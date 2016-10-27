/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.state;

import com.primosoft.astman.core.ast.listener.AsteriskEventListener;
import com.primosoft.astman.core.log.Logger;
import org.asteriskjava.live.AsteriskChannel;
import org.asteriskjava.live.ChannelState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created on 23.08.16.
 *
 * @author atelizhenko
 */
public class ChannelHolder {
//	private final Map<String, AsteriskChannel> channels;
	private final Set<BridgedChannel> bridgedChannels;
	private final Map manUids;
	private final Map uids;
	private final Map deadChannels;
	private final float afterKillLiveTime;
	private final float osfLiveTime;
	private final Set<ChannelState> channelStatuses;
	private final Logger logger;
	private AsteriskEventListener asteriskEventListener;
	private LocalDateTime lastDelDeadChannelsDateTime;
	private LocalDateTime lastSyncDateTime;

	@Autowired
	public ChannelHolder(@Qualifier("infoLogger") Logger logger) {
//		this.channels = new ConcurrentHashMap<>();
		this.bridgedChannels = new CopyOnWriteArraySet<>();
		this.manUids = new ConcurrentHashMap();
		this.uids = new ConcurrentHashMap();
		this.deadChannels = new ConcurrentHashMap();
		this.lastDelDeadChannelsDateTime = LocalDateTime.now();
		this.afterKillLiveTime = 0.1F;
		this.osfLiveTime = 0.3F;
		this.channelStatuses = new CopyOnWriteArraySet<>();
		this.lastSyncDateTime = LocalDateTime.now();
		this.logger = logger;
	}

	public void setAsteriskEventListener(AsteriskEventListener asteriskEventListener) {
		this.asteriskEventListener = asteriskEventListener;
	}

	public Set<BridgedChannel> getBridgedChannels() {
		return bridgedChannels;
	}

//	public void addChannel(AsteriskChannel channel) {
//		channels.put(channel.getName(), channel);
//		logger.info("Added new channel: " + channel.getName());
//	}

	public void addBridgedChannel(BridgedChannel bridgedChannel) {
		final boolean addBridgedChannelChecker = bridgedChannels.add(bridgedChannel);
		if (addBridgedChannelChecker)
			logger.info("Added new bridged channel: " + bridgedChannel);
	}

	public Map getManUids() {
		return manUids;
	}

	public Map getUids() {
		return uids;
	}

	public Map getDeadChannels() {
		return deadChannels;
	}

	public float getAfterKillLiveTime() {
		return afterKillLiveTime;
	}

	public float getOsfLiveTime() {
		return osfLiveTime;
	}

	public Set<ChannelState> getChannelStatuses() {
		return channelStatuses;
	}

	public LocalDateTime getLastDelDeadChannelsDateTime() {
		return lastDelDeadChannelsDateTime;
	}

	public LocalDateTime getLastSyncDateTime() {
		return lastSyncDateTime;
	}

//	public final void synchronizeChannels() {
//		if (asteriskEventListener != null) {
//			logger.info("Making synchronization for channels holder");
//			channels.clear();
//			final Collection<AsteriskChannel> channelsList = asteriskEventListener.getChannels();
//			this.channels.putAll(channelsList
//					.stream()
//					.collect(Collectors.toMap(AsteriskChannel::getName, Function.identity()))
//			);
//		}
//	}
}
