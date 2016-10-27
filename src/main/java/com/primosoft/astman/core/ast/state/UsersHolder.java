/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.state;

import com.primosoft.astman.core.db.entity.ats.SipUser;
import com.primosoft.astman.core.db.service.IOperatorService;
import com.primosoft.astman.core.db.service.ISipUserService;
import com.primosoft.astman.core.log.Logger;
import com.primosoft.astman.core.util.ChannelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
public class UsersHolder {
	private final Set<SipUser> sipUserSet;
	private final Map<String, SipUser> sipUserMap;
	private final ISipUserService sipUserService;
	private final Logger logger;
	private final Lock readLock;
	private final Lock writeLock;
	private final IOperatorService operatorService;
	private LocalDateTime lastSyncDateTime;

	@Autowired
	public UsersHolder(ISipUserService sipUserService, @Qualifier("infoLogger") Logger logger, IOperatorService operatorService) {
		this.sipUserSet = new CopyOnWriteArraySet<>();
		this.sipUserMap = new ConcurrentHashMap<>();
		this.lastSyncDateTime = LocalDateTime.now();
		this.sipUserService = sipUserService;
		this.logger = logger;

		final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
		this.readLock = readWriteLock.readLock();
		this.writeLock = readWriteLock.writeLock();
		this.operatorService = operatorService;
	}

	public void addUser(String channelName) {
		SipUser sipUser = null;
		readLock.lock();
		try {
			sipUser = sipUserMap.get(channelName);
		} finally {
			readLock.unlock();
		}

		if (sipUser == null) {
			final SipUser newSipUser = sipUserService.findByUserName(ChannelUtil.getChannelBean(channelName).getDn());
			addUser(newSipUser);
		}
	}

	public void addUser(SipUser sipUser) {
		writeLock.lock();
		try {
			final boolean addedUserChecker = sipUserSet.add(sipUser);
			if (addedUserChecker) {
				sipUserMap.put(sipUser.getUsername(), sipUser);
				logger.debug("Added user: " + sipUser.getId());
			}
		} finally {
			writeLock.unlock();
		}
	}

	public void addUser(String dn, int state) {
		writeLock.lock();
		try {
			SipUser sipUser = sipUserMap.get(dn);
			if (sipUser == null) {
				sipUser = sipUserService.findByUserName(dn);
				sipUserMap.put(sipUser.getUsername(), sipUser);
				logger.debug("Added user " + dn + " to local memory user's set");
			}
			logger.debug("Refreshing new state " + state + " for user " + dn);
			operatorService.refreshOperatorStatus(state, dn);
		} finally {
			writeLock.unlock();
		}
	}

	public void removeUser(String dn, int state) {
		writeLock.lock();
		try {
			SipUser sipUser = sipUserMap.get(dn);
			if (sipUser != null) {
				sipUserMap.remove(dn);
				logger.debug("Removed user " + dn + " from local memory user's set");
			}
			logger.debug("Refreshing new state " + state + " for user " + dn);
			operatorService.refreshOperatorStatus(state, dn);
		} finally {
			writeLock.unlock();
		}
	}

	public void removeUser(SipUser sipUser) {
		sipUserSet.removeIf(user -> Objects.equals(user, sipUser));
	}

	public final Set<SipUser> getSipUserSet() {
		readLock.lock();
		try {
			return sipUserSet;
		} finally {
			readLock.unlock();
		}
	}

	public final void synchronizeUsers() {
		writeLock.lock();
		try {
			logger.trace("Making synchronization for users holder");

			logger.trace("Clearing sip users set, was contained " + sipUserSet.size());
			sipUserSet.clear();
			logger.trace("Clearing sip users map, was contained " + sipUserMap.size());
			sipUserMap.clear();

			final List<SipUser> allSipUsers = sipUserService.getAllActiveSipUsers();
			logger.debug("Got new sip users list " + allSipUsers);

			sipUserSet.addAll(allSipUsers);
			sipUserMap.putAll(allSipUsers.stream().collect(Collectors.toMap(SipUser::getUsername, Function.identity())));
			logger.debug("Translated sip users list to map " + sipUserMap);
		} finally {
			writeLock.unlock();
		}
	}

	public void citlFSC(String channelName) {
		logger.debug("Invoked citlFSC " + channelName);
		final SipUser sipUser = sipUserMap.get(channelName);
		if (sipUser != null) {
			sipUserService.invokeFinishCitlSc(sipUser);
		}
	}

	public void citlHMC(String channelName) {
		logger.debug("Invoked citlHMC " + channelName);
		final SipUser sipUser = sipUserMap.get(channelName);
		if (sipUser != null) {
			sipUserService.invokeHangupCitlMc(sipUser);
		}
	}

	public void citlBSC(String channelName) {
		logger.debug("Invoked citlBSC " + channelName);
		final SipUser sipUser = sipUserMap.get(channelName);
		if (sipUser != null) {
			sipUserService.invokeBeginCitlSc(sipUser);
		}
	}
}
