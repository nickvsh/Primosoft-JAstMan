/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.state;

import org.asteriskjava.live.AsteriskChannel;

import java.util.Objects;

/**
 * Created on 29.08.16.
 *
 * @author atelizhenko
 */
public final class BridgedChannel {
	private final AsteriskChannel channel1;
	private final AsteriskChannel channel2;

	public BridgedChannel(AsteriskChannel channel1, AsteriskChannel channel2) {
		this.channel1 = channel1;
		this.channel2 = channel2;
	}

	public final AsteriskChannel getChannel1() {
		return channel1;
	}

	public final AsteriskChannel getChannel2() {
		return channel2;
	}

	@Override
	public int hashCode() {
		return Objects.hash(channel1, channel2);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BridgedChannel)) return false;
		BridgedChannel that = (BridgedChannel) o;
		return Objects.equals(channel1, that.channel1) &&
				Objects.equals(channel2, that.channel2);
	}

	@Override
	public String toString() {
		return "BridgedChannel{" +
				"channel1=" + channel1.getName() +
				", channel2=" + channel2.getName() +
				'}';
	}
}
