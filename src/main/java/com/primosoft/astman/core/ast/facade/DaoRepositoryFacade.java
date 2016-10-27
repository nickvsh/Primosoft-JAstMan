/*
 * Copyright (c) 2016.
 * © PrimoCollect IT team.
 */

package com.primosoft.astman.core.ast.facade;

import com.primosoft.astman.core.db.dao.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Created on 15.08.16.
 *
 * @author atelizhenko
 */
public final class DaoRepositoryFacade {
	private final ApplicationContext context;

	DaoRepositoryFacade(AbstractApplicationContext context) {
		this.context = context;
	}

	public ICallBackDao getCallBackDao() {
		return (ICallBackDao) context.getBean("callBackDao");
	}

	public ICallBackStatusDao getCallBackStatusDao() {
		return (ICallBackStatusDao) context.getBean("callBackStatusDao");
	}

	public ICallDao getCallDao() {
		return (ICallDao) context.getBean("callDao");
	}

	public ICallRecordDao getCallRecordDao() {
		return (ICallRecordDao) context.getBean("callRecordDao");
	}

	public ICallRouteDao getCallRouteDao() {
		return (ICallRouteDao) context.getBean("callRouteDao");
	}

	public ICbCallDao getCbCallDao() {
		return (ICbCallDao) context.getBean("cbCallDao");
	}

	public IExtNumberDao getExtNumberDao() {
		return (IExtNumberDao) context.getBean("extNumberDao");
	}

	public IGroupDao getGroupDao() {
		return (IGroupDao) context.getBean("groupDao");
	}

	public IOperatorDao getOperatorDao() {
		return (IOperatorDao) context.getBean("operatorDao");
	}

	public IOperatorStatusDao getOperatorStatusDao() {
		return (IOperatorStatusDao) context.getBean("operatorStatusDao");
	}

	public IRelOpGrDao getRelOpGrDao() {
		return (IRelOpGrDao) context.getBean("relOpGrDao");
	}

	public IRelWauWagDao getRelWauWagDao() {
		return (IRelWauWagDao) context.getBean("relWauWagDao");
	}

	public IRouteContentDao getRouteContentDao() {
		return (IRouteContentDao) context.getBean("routeContentDao");
	}

	public IRouteDao getRouteDao() {
		return (IRouteDao) context.getBean("routeDao");
	}

	public ISipUserDao getSipUserDao() {
		return (ISipUserDao) context.getBean("sipUserDao");
	}

	public IWorkAppGroupDao getWorkAppGroupDao() {
		return (IWorkAppGroupDao) context.getBean("workAppGroupDao");
	}

	public IWorkAppUserDao getWorkAppUserDao() {
		return (IWorkAppUserDao) context.getBean("workAppUserDao");
	}
}
