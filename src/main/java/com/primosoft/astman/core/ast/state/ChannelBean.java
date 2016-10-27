/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.state;

import java.util.Objects;
import java.util.Optional;

/**
 * Created on 02.09.16.
 *
 * @author atelizhenko
 */
public final class ChannelBean {
	private String peer;
	private String dn;

	public ChannelBean() {
	}

	public ChannelBean(String peer, String dn) {
		this.peer = peer;
		this.dn = dn;
	}

	public final String getPeer() {
		return Optional.ofNullable(peer).orElse("");
	}

	public final void setPeer(String peer) {
		this.peer = peer;
	}

	public final String getDn() {
		return Optional.ofNullable(dn).orElse("");
	}

	public final void setDn(String dn) {
		this.dn = dn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(peer, dn);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof ChannelBean)) return false;
		ChannelBean that = (ChannelBean) o;
		return Objects.equals(peer, that.peer) &&
				Objects.equals(dn, that.dn);
	}

	@Override
	public String toString() {
		return "ChannelBean{" +
				"peer='" + peer + '\'' +
				", dn='" + dn + '\'' +
				'}';
	}
}
