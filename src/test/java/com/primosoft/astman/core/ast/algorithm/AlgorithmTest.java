package com.primosoft.astman.core.ast.algorithm;

import com.primosoft.astman.core.db.entity.ats.Operator;
import com.primosoft.astman.core.db.entity.dlr.DlrCalls;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created on 21.09.16.
 *
 * @author atelizhenko
 */
@ActiveProfiles("test")
@ContextConfiguration("classpath:config/spring-all.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AlgorithmTest {
	@Autowired
	private OperatorAlgorithmContext operatorAlgorithmContext;
	@Autowired
	private CallAlgorithmContext callAlgorithmContext;

	@Test
	public void testAlgorithms() {
		final String groupName = "test";
		final String workGroupName = "ALL";
		final String operatorAlgorithmErrorMessage = "Operators not found in this group ";

		//allOperatorsOfGroupAlgorithm
		final OperatorAlgorithm allOperatorsOfGroupAlgorithm =
				operatorAlgorithmContext.getOperatorAlgorithm(EOperatorAlgorithm.ALL_OF_GROUP);
		final List<Operator> allOperatorsOfGroupList = allOperatorsOfGroupAlgorithm.invokeAlgorithm(groupName);
		assertNotEquals(operatorAlgorithmErrorMessage + groupName, allOperatorsOfGroupList, Collections.emptyList());

		//dontSpeakOperatorsAlgorithm
		final OperatorAlgorithm dontSpeakOperatorsAlgorithm =
				operatorAlgorithmContext.getOperatorAlgorithm(EOperatorAlgorithm.DONT_SPEAK_OF_GROUP);
		final List<Operator> dontSpeakOperatorsOfGroupList = dontSpeakOperatorsAlgorithm.invokeAlgorithm(workGroupName);
		assertNotEquals(operatorAlgorithmErrorMessage + workGroupName, dontSpeakOperatorsOfGroupList, Collections.emptyList());

		//freeOperatorsOfGroupAlgorithm
		final OperatorAlgorithm freeOperatorsOfGroupAlgorithm =
				operatorAlgorithmContext.getOperatorAlgorithm(EOperatorAlgorithm.FREE_OF_GROUP);
		final List<Operator> freeOfGroupOperatorsList = freeOperatorsOfGroupAlgorithm.invokeAlgorithm(workGroupName);
		assertNotEquals(operatorAlgorithmErrorMessage + workGroupName, freeOfGroupOperatorsList, Collections.emptyList());

		//loginedOperatorsOfGroupAlgorithm
		final OperatorAlgorithm loginedOperatorsOfGroupAlgorithm =
				operatorAlgorithmContext.getOperatorAlgorithm(EOperatorAlgorithm.LOGINED_OF_GROUP);
		final List<Operator> loginedOfGroupOperatorsList = loginedOperatorsOfGroupAlgorithm.invokeAlgorithm(workGroupName);
		assertNotEquals(operatorAlgorithmErrorMessage + workGroupName, loginedOfGroupOperatorsList, Collections.emptyList());

		//oldestFreeOperatorsOfGroupAlgorithm
		final OperatorAlgorithm oldestFreeOperatorsOfGroupAlgorithm =
				operatorAlgorithmContext.getOperatorAlgorithm(EOperatorAlgorithm.OLDEST_FREE_OF_GROUP);
		final List<Operator> oldestFreeOfGroupOperatorsList = oldestFreeOperatorsOfGroupAlgorithm.invokeAlgorithm(workGroupName);
		assertNotEquals(operatorAlgorithmErrorMessage + workGroupName, oldestFreeOfGroupOperatorsList, Collections.emptyList());

		final BigInteger campaignId = BigInteger.valueOf(372971);
		final String callAlgorithmErrorMessage = "Call not found with id ";

		//defaultNextLinearCallAlgorithm
		final CallAlgorithm defaultNextLinearCallAlgorithm =
				callAlgorithmContext.getCallAlgorithm(ECallAlgorithm.NEXT_LINEAL_CALL);
		final DlrCalls nextLinearDlrCall = defaultNextLinearCallAlgorithm.invokeAlgorithm(campaignId);
		assertNotNull(callAlgorithmErrorMessage + campaignId, nextLinearDlrCall);

		//nextTopCallAlgorithm
		final CallAlgorithm nextTopCallAlgorithm =
				callAlgorithmContext.getCallAlgorithm(ECallAlgorithm.NEXT_TOP_CALL);
		final DlrCalls nextTopDlrCall = nextTopCallAlgorithm.invokeAlgorithm(campaignId);
		assertNotNull(callAlgorithmErrorMessage + campaignId, nextTopDlrCall);
	}
}
