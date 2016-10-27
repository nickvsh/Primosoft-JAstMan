/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.facade;

import com.primosoft.astman.core.ast.listener.AsteriskEventListener;
import com.primosoft.astman.core.db.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created on 16.08.16.
 *
 * @author atelizhenko
 */
public final class ServiceFacade {
	private final ApplicationContext context;

	ServiceFacade(AbstractApplicationContext context) {
		this.context = context;
	}

	public ICallBackService getCallBackService() {
		return (ICallBackService) context.getBean("callBackService");
	}

	public ICallBackStatusService getCallBackStatusService() {
		return (ICallBackStatusService) context.getBean("callBackStatusService");
	}

	public ICallRecordService getCallRecordService() {
		return (ICallRecordService) context.getBean("callRecordService");
	}

	public ICallRouteService getCallRouteService() {
		return (ICallRouteService) context.getBean("callRouteService");
	}

	public ICallService getCallService() {
		return (ICallService) context.getBean("callService");
	}

	public ICbCallService getCbCallService() {
		return (ICbCallService) context.getBean("cbCallService");
	}

	public IExtNumberService getExtNumberService() {
		return (IExtNumberService) context.getBean("extNumberService");
	}

	public IGroupService getGroupService() {
		return (IGroupService) context.getBean("groupService");
	}

	public IOperatorService getOperatorService() {
		return (IOperatorService) context.getBean("operatorService");
	}

	public IOperatorStatusService getOperatorStatusService() {
		return (IOperatorStatusService) context.getBean("operatorStatusService");
	}

	public IRelOpGrService getRelOpGrService() {
		return (IRelOpGrService) context.getBean("relOprGrService");
	}

	public IRelWauWagService getRelWauWagService() {
		return (IRelWauWagService) context.getBean("relWauWagService");
	}

	public IRouteContentService getRouteContentService() {
		return (IRouteContentService) context.getBean("routeContentService");
	}

	public IRouteService getRouteService() {
		return (IRouteService) context.getBean("routeService");
	}

	public ISipUserService getSipUserService() {
		return (ISipUserService) context.getBean("sipUserService");
	}

	public IWorkAppGroupService getWorkAppGroupService() {
		return (IWorkAppGroupService) context.getBean("workAppGroupService");
	}

	public IWorkAppUserService getWorkAppUserService() {
		return (IWorkAppUserService) context.getBean("workAppUserService");
	}

	public AsteriskEventListener getAsteriskEventListener() {
		return (AsteriskEventListener) context.getBean("asteriskEventListenerService");
	}
}
