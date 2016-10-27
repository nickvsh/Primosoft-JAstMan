/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.db.entity.ats.pk;

import com.primosoft.astman.core.db.entity.EmbeddedModel;
import com.primosoft.astman.core.db.entity.ats.CallRoute;
import com.primosoft.astman.core.db.entity.ats.Route;
import com.primosoft.astman.core.db.entity.ats.RouteContent;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * Created on 07.06.16.
 * Embeddable class for two PK for {@link RouteContent}
 *
 * @author atelizhenko
 */
@Embeddable
public class RouteContentPK implements EmbeddedModel {
	private static final long serialVersionUID = -3588082592648970499L;

	private Route route;
	private CallRoute callRoute;

	/**
	 * Gets route.
	 *
	 * @return the route
	 */
	@ManyToOne
	@JoinColumn(name = "o_route_id", referencedColumnName = "id")
	public Route getRoute() {
		return route;
	}

	/**
	 * Sets route.
	 *
	 * @param route the route
	 */
	public void setRoute(Route route) {
		this.route = route;
	}

	/**
	 * Gets call route.
	 *
	 * @return the call route
	 */
	@ManyToOne
	@JoinColumn(name = "callroute_id", referencedColumnName = "id")
	public CallRoute getCallRoute() {
		return callRoute;
	}

	/**
	 * Sets call route.
	 *
	 * @param callRoute the call route
	 */
	public void setCallRoute(CallRoute callRoute) {
		this.callRoute = callRoute;
	}

	@Override
	public int hashCode() {
		return Objects.hash(route, callRoute);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RouteContentPK)) return false;
		RouteContentPK that = (RouteContentPK) o;
		return Objects.equals(route, that.route) &&
				Objects.equals(callRoute, that.callRoute);
	}

	@Override
	public String toString() {
		return "RouteContentPK{" +
				"route=" + route +
				", callRoute=" + callRoute +
				'}';
	}
}
