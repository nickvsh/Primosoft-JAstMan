/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;

import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.fastagi.AgiServer;
import org.asteriskjava.live.*;
import org.asteriskjava.manager.*;
import org.asteriskjava.manager.action.ManagerAction;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.event.ManagerEvent;
import org.asteriskjava.manager.response.ManagerResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created on 21.06.16.
 * Asterisk live events listener.
 *
 * @author atelizhenko
 */
@Service(value = "asteriskEventListenerService")
class EventsListener implements ManagerEventListener, AsteriskEventListener {
	private final Logger logger;
	private final AsteriskServer asteriskServer;
	private final AgiServer agiServer;
	private final AsteriskManagerEventPublisher asteriskManagerEventPublisher;
	private final ManagerEventListenerProxy eventListener;
	private PingThread pingThread;

	/**
	 * Default constructor
	 */
	@Autowired
	EventsListener(@Qualifier("asteriskLogger") Logger logger, AsteriskServer asteriskServer, AgiServer agiServer,
				   AsteriskManagerEventPublisher asteriskManagerEventPublisher) {
		this.logger = logger;
		this.asteriskServer = asteriskServer;
		this.agiServer = agiServer;
		this.asteriskManagerEventPublisher = asteriskManagerEventPublisher;
		this.eventListener = new ManagerEventListenerProxy(this);
	}

	/**
	 * Shutdown all connections
	 */
	@Override
	public void shutdown() {
		logger.trace("Removing event listener from asterisk server");
		asteriskServer.getManagerConnection().removeEventListener(eventListener);
		logger.trace("Shutting down asterisk ping thread");
		pingThread.removeConnection(getManagerConnection());
		pingThread.die();
		logger.trace("Shutting down asterisk server");
		asteriskServer.shutdown();
		logger.trace("Shutting down agi server");
		agiServer.shutdown();
	}

	/**
	 * Start listening events by asterisk credentials
	 */
	@Override
	public void startListening() {
		try {
			logger.trace("Adding event listener to handle asterisk events");
			asteriskServer.getManagerConnection().addEventListener(eventListener);
			logger.trace("Initializing asterisk server connections");
			asteriskServer.initialize();
			logger.trace(asteriskServer.getVersion());

			logger.trace("Starting up agi server");
			agiServer.startup();

			logger.trace("Initiating asterisk ping thread");
			pingThread = new PingThread(getManagerConnection());
			pingThread.start();
		} catch (IOException | ManagerCommunicationException e) {
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * Sends a ManagerAction to the Asterisk server and registers a callback
	 * handler to be called when the corresponding {@link ManagerResponse} is
	 * received. Be very careful that your callbackHandler terminates very
	 * quickly and does not do any fancy processing because it is called from
	 * the reader thread which is blocked for the time it takes to execute your
	 * callbackHandler.
	 *
	 * @param action   the action to send to the Asterisk server
	 * @param callback the callback handler to call when the response is
	 *                 received or <code>null</code> if you are not interested in
	 *                 the response
	 * @throws IOException              if the network connection is disrupted.
	 * @throws IllegalArgumentException if the action is <code>null</code>.
	 * @throws IllegalStateException    if you are not connected to the Asterisk
	 *                                  server.
	 */
	@Override
	public void sendAction(ManagerAction action, SendActionCallback callback) throws IOException, IllegalArgumentException,
			IllegalStateException {
		try {
			logger.debug("Sends a ManagerAction to the Asterisk server and registers a callback " + action);
			asteriskServer.getManagerConnection().sendAction(action, callback);
		} catch (IOException | IllegalArgumentException | IllegalStateException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	/**
	 * Generates an outgoing channel.
	 *
	 * @param originateAction the action that contains parameters for the originate
	 * @return the generated channel
	 * @throws NoSuchChannelException        if the channel is not available on the
	 *                                       Asterisk server, for example because you used "SIP/1310" and 1310
	 *                                       is not a valid SIP user, the SIP channel module hasn't been
	 *                                       loaded or the SIP or IAX peer is not registered currently.
	 * @throws ManagerCommunicationException if the originate action cannot be
	 *                                       sent to Asterisk
	 */
	@Override
	public AsteriskChannel originate(OriginateAction originateAction) throws ManagerCommunicationException, NoSuchChannelException {
		return asteriskServer.originate(originateAction);
	}

	/**
	 * Asynchronously generates an outgoing channel.
	 *
	 * @param originateAction the action that contains parameters for the originate
	 * @param cb              callback to inform about the result
	 * @throws ManagerCommunicationException if the originate action cannot be
	 *                                       sent to Asterisk
	 */
	@Override
	public void originateAsync(OriginateAction originateAction, OriginateCallback cb) throws ManagerCommunicationException {
		asteriskServer.originateAsync(originateAction, cb);
	}

	/**
	 * Returns the active channels of the Asterisk server.
	 *
	 * @return a Collection of active channels.
	 * @throws ManagerCommunicationException if there is a problem communication
	 *                                       with Asterisk
	 */
	@Override
	public Collection<AsteriskChannel> getChannels() throws ManagerCommunicationException {
		return asteriskServer.getChannels();
	}

	/**
	 * Returns a channel by its name.
	 *
	 * @param name name of the channel to return
	 * @return the channel with the given name or <code>null</code> if there
	 * is no such channel.
	 * @throws ManagerCommunicationException if there is a problem communication
	 *                                       with Asterisk
	 */
	@Override
	public AsteriskChannel getChannelByName(String name) throws ManagerCommunicationException {
		return asteriskServer.getChannelByName(name);
	}

	/**
	 * Returns a channel by its unique id.
	 *
	 * @param id the unique id of the channel to return
	 * @return the channel with the given unique id or <code>null</code> if
	 * there is no such channel.
	 * @throws ManagerCommunicationException if there is a problem communication
	 *                                       with Asterisk
	 */
	@Override
	public AsteriskChannel getChannelById(String id) throws ManagerCommunicationException {
		return asteriskServer.getChannelById(id);
	}

	/**
	 * Return the agents, registered at Asterisk server. (Consider remarks for
	 * {@link AsteriskAgent})
	 *
	 * @return a Collection of agents
	 * @throws ManagerCommunicationException if there is a problem communication
	 *                                       with Asterisk
	 */
	@Override
	public Collection<AsteriskAgent> getAgents() throws ManagerCommunicationException {
		return asteriskServer.getAgents();
	}

	/**
	 * Returns the value of the given global variable.
	 *
	 * @param variable the name of the global variable to return.
	 * @return the value of the global variable or <code>null</code> if it is
	 * not set.
	 * @throws ManagerCommunicationException if the get variable action cannot
	 *                                       be sent to Asterisk.
	 */
	@Override
	public String getGlobalVariable(String variable) throws ManagerCommunicationException {
		return asteriskServer.getGlobalVariable(variable);
	}

	/**
	 * Executes a command line interface (CLI) command.
	 *
	 * @param command the command to execute, for example "sip show peers".
	 * @return a List containing strings representing the lines returned by the
	 * CLI command.
	 * @throws ManagerCommunicationException if the command can't be executed.
	 * @see org.asteriskjava.manager.action.CommandAction
	 */
	@Override
	public List<String> executeCliCommand(String command) throws ManagerCommunicationException {
		return asteriskServer.executeCliCommand(command);
	}

	/**
	 * Returns the lifecycle status of this connection.
	 *
	 * @return the lifecycle status of this connection.
	 */
	@Override
	public ManagerConnectionState getState() {
		return getManagerConnection().getState();
	}

	/**
	 * Sends a ManagerAction to the Asterisk server and waits for the
	 * corresponding {@link ManagerResponse}.
	 *
	 * @param action  the action to send to the Asterisk server
	 * @param timeout milliseconds to wait for the response before throwing a
	 *                TimeoutException
	 * @return the corresponding response received from the Asterisk server
	 * @throws IOException              if the network connection is disrupted.
	 * @throws TimeoutException         if no response is received within the given
	 *                                  timeout period.
	 * @throws IllegalArgumentException if the action is <code>null</code>.
	 * @throws IllegalStateException    if you are not connected to an Asterisk
	 *                                  server.
	 * @see #sendAction(ManagerAction, SendActionCallback)
	 * @see #sendAction(ManagerAction, SendActionCallback)
	 */
	@Override
	public ManagerResponse sendAction(ManagerAction action, long timeout) throws IOException, TimeoutException,
			IllegalArgumentException, IllegalStateException {
		try {
			logger.debug("Sends a ManagerAction to the Asterisk server and waits for the corresponding "
					+ timeout + " - " + action);
			return getManagerConnection().sendAction(action, timeout);
		} catch (IOException | TimeoutException |
				IllegalArgumentException | IllegalStateException e) {
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	private ManagerConnection getManagerConnection() {
		return asteriskServer.getManagerConnection();
	}

	/**
	 * This method is called when an event is received.
	 *
	 * @param event the event that has been received
	 */
	@Override
	public void onManagerEvent(ManagerEvent event) {
		logger.trace("Handled event " + event);

		asteriskManagerEventPublisher.publishManagerEvent(event);
	}
}
