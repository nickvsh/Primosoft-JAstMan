package com.primosoft.astman.core.db.service.impl;

import com.primosoft.astman.core.db.dao.IDlrCallsDao;
import com.primosoft.astman.core.db.dao.IOperatorDao;
import com.primosoft.astman.core.db.entity.ats.Operator;
import com.primosoft.astman.core.db.entity.dlr.DlrCalls;
import com.primosoft.astman.core.db.service.IAlgorithmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

/**
 * Created on 21.09.16.
 *
 * @author atelizhenko
 */
@Service(value = "algorithmService")
public class AlgorithmServiceImpl implements IAlgorithmService {
	private final IOperatorDao operatorDao;
	private final IDlrCallsDao dlrCallsDao;

	@Autowired
	public AlgorithmServiceImpl(IOperatorDao operatorDao, IDlrCallsDao dlrCallsDao) {
		this.operatorDao = operatorDao;
		this.dlrCallsDao = dlrCallsDao;
	}

	@Override
	public List<Operator> getAllOfGroupList(String groupName) {
		return Collections.unmodifiableList(operatorDao.getAllOfGroupList(groupName));
	}

	@Override
	public List<Operator> getLoginedOfGroupList(String groupName) {
		return Collections.unmodifiableList(operatorDao.getLoginedOfGroupList(groupName));
	}

	@Override
	public List<Operator> getFreeOfGroupList(String groupName) {
		return Collections.unmodifiableList(operatorDao.getFreeOfGroupList(groupName));
	}

	@Override
	public List<Operator> getDontSpeakOfGroupList(String groupName) {
		return Collections.unmodifiableList(operatorDao.getDontSpeakOfGroupList(groupName));
	}

	@Override
	public List<Operator> getOldestFreeOfGroupList(String groupName) {
		return Collections.unmodifiableList(operatorDao.getOldestFreeOfGroupList(groupName));
	}

	@Override
	public DlrCalls getDefaultNextCall(BigInteger campaignId) {
		final BigInteger nextLineal = dlrCallsDao.getNextLineal(campaignId);
		return dlrCallsDao.getById(nextLineal);
	}

	@Override
	public DlrCalls getNextByTopCall(BigInteger campaignId) {
		final BigInteger nextLineal = dlrCallsDao.getNextTop(campaignId);
		return dlrCallsDao.getById(nextLineal);
	}
}
