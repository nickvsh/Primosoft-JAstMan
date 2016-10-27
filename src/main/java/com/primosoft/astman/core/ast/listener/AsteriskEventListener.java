/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.listener;


import org.asteriskjava.live.*;
import org.asteriskjava.manager.ManagerConnectionState;
import org.asteriskjava.manager.SendActionCallback;
import org.asteriskjava.manager.TimeoutException;
import org.asteriskjava.manager.action.ManagerAction;
import org.asteriskjava.manager.action.OriginateAction;
import org.asteriskjava.manager.response.ManagerResponse;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

/**
 * Created on 21.06.16.
 * Asterisk events listener interface.
 *
 * @author atelizhenko
 */
public interface AsteriskEventListener {
	/**
	 * Shutdown all connections
	 */
	void shutdown();

	/**
	 * Start listening events by asterisk credentials
	 */
	void startListening();

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
	void sendAction(ManagerAction action, SendActionCallback callback) throws IOException, IllegalArgumentException,
			IllegalStateException;

	;

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
	AsteriskChannel originate(OriginateAction originateAction) throws ManagerCommunicationException, NoSuchChannelException;

	/**
	 * Asynchronously generates an outgoing channel.
	 *
	 * @param originateAction the action that contains parameters for the originate
	 * @param cb              callback to inform about the result
	 * @throws ManagerCommunicationException if the originate action cannot be
	 *                                       sent to Asterisk
	 */
	void originateAsync(OriginateAction originateAction, OriginateCallback cb) throws ManagerCommunicationException;

	/**
	 * Returns the active channels of the Asterisk server.
	 *
	 * @return a Collection of active channels.
	 * @throws ManagerCommunicationException if there is a problem communication
	 *                                       with Asterisk
	 */
	Collection<AsteriskChannel> getChannels() throws ManagerCommunicationException;

	/**
	 * Returns a channel by its name.
	 *
	 * @param name name of the channel to return
	 * @return the channel with the given name or <code>null</code> if there
	 * is no such channel.
	 * @throws ManagerCommunicationException if there is a problem communication
	 *                                       with Asterisk
	 */
	AsteriskChannel getChannelByName(String name) throws ManagerCommunicationException;

	/**
	 * Returns a channel by its unique id.
	 *
	 * @param id the unique id of the channel to return
	 * @return the channel with the given unique id or <code>null</code> if
	 * there is no such channel.
	 * @throws ManagerCommunicationException if there is a problem communication
	 *                                       with Asterisk
	 */
	AsteriskChannel getChannelById(String id) throws ManagerCommunicationException;

	/**
	 * Return the agents, registered at Asterisk server. (Consider remarks for
	 * {@link AsteriskAgent})
	 *
	 * @return a Collection of agents
	 * @throws ManagerCommunicationException if there is a problem communication
	 *                                       with Asterisk
	 */
	Collection<AsteriskAgent> getAgents() throws ManagerCommunicationException;

	/**
	 * Returns the value of the given global variable.
	 *
	 * @param variable the name of the global variable to return.
	 * @return the value of the global variable or <code>null</code> if it is
	 * not set.
	 * @throws ManagerCommunicationException if the get variable action cannot
	 *                                       be sent to Asterisk.
	 */
	String getGlobalVariable(String variable) throws ManagerCommunicationException;

	/**
	 * Executes a command line interface (CLI) command.
	 *
	 * @param command the command to execute, for example "sip show peers".
	 * @return a List containing strings representing the lines returned by the
	 * CLI command.
	 * @throws ManagerCommunicationException if the command can't be executed.
	 * @see org.asteriskjava.manager.action.CommandAction
	 */
	List<String> executeCliCommand(String command) throws ManagerCommunicationException;

	/**
	 * Returns the lifecycle status of this connection.
	 *
	 * @return the lifecycle status of this connection.
	 */
	ManagerConnectionState getState();

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
	ManagerResponse sendAction(ManagerAction action, long timeout) throws IOException, TimeoutException,
			IllegalArgumentException, IllegalStateException;
}
