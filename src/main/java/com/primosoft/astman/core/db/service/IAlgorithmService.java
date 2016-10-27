package com.primosoft.astman.core.db.service;

import com.primosoft.astman.core.db.entity.ats.Operator;
import com.primosoft.astman.core.db.entity.dlr.DlrCalls;

import java.math.BigInteger;
import java.util.List;

/**
 * Created on 21.09.16.
 *
 * @author atelizhenko
 */
public interface IAlgorithmService {
	List<Operator> getAllOfGroupList(String groupName);

	List<Operator> getLoginedOfGroupList(String groupName);

	List<Operator> getFreeOfGroupList(String groupName);

	List<Operator> getDontSpeakOfGroupList(String groupName);

	List<Operator> getOldestFreeOfGroupList(String groupName);

	DlrCalls getDefaultNextCall(BigInteger campaignId);

	DlrCalls getNextByTopCall(BigInteger campaignId);
}
