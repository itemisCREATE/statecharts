/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package util;

import java.io.IOException;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;

import com.google.inject.Inject;

/**
 * Provides access to the testmodels.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TestModels {

	public static final String ALWAYS_ONCYCLE = "AlwaysOncycle.sct";
	public static final String BIT_EXPRESSIONS = "BitExpressions.sct";
	public static final String BOOLEAN_EXPRESSIONS = "BooleanExpressions.sct";
	public static final String C_KEYWORDS_M = "CKeywords.sct";
	public static final String DECLARATIONS = "Declarations.sct";
	public static final String CHOICE = "Choice.sct";
	public static final String DEEP_HISTORY = "DeepHistory.sct";
	public static final String FEATURE_CALLS = "FeatureCalls.sct";
	public static final String GUARD = "Guard.sct";
	public static final String INTEGER_EXPRESSIONS = "IntegerExpressions.sct";
	public static final String JAVA_KEYWORDS_M = "JavaKeywords.sct";
	public static final String PARENTHESIS = "Parenthesis.sct";
	public static final String PRIORITY_VALUES = "PriorityValues.sct";
	public static final String RAISE_EVENTS = "RaiseEvent.sct";
	public static final String REAL_EXPRESSIONS = "RealExpressions.sct";
	public static final String SAME_NAME_DIFFERENT_REGION = "SameNameDifferentRegion.sct";
	public static final String SHALLOW_HISTORY = "ShallowHistory.sct";
	public static final String SIMPLE_EVENT = "SimpleEvent.sct";
	public static final String SIMPLE_HIERACHY = "SimpleHierachy.sct";
	public static final String STATE_ACTIVE = "StateIsActive.sct";
	public static final String STATECHART_LOCAL_REACTIONS = "StatechartLocalReactions.sct";
	public static final String STRING_EXPRESSIONS = "StringExpressions.sct";
	public static final String SYNC_FORK = "SyncFork.sct";
	public static final String SYNC_JOIN = "SyncJoin.sct";
	private static final String TESTMODEL_DIR = "org.yakindu.sct.test.models/testmodels/";
	public static final String TIME_TRIGGER = "TimeTrigger.sct";
	public static final String VALUED_EVENTS = "ValuedEvents.sct";
	public static final String OPERATIONS = "Operations.sct";

	@Inject
	private ModelSequencer sequencer;

	/**
	 * <img src="../../images/AlwaysOncycle.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createAlwaysOncycleModel() throws IOException {
		return loadExecutionFlowFromResource(ALWAYS_ONCYCLE);
	}

	/**
	 * <img src="../../images/SimpleEvent.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createBitExpressionsModel() throws IOException {
		return loadExecutionFlowFromResource(BIT_EXPRESSIONS);
	}

	/**
	 * <img src="../../images/BooleanExpressions.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */

	public ExecutionFlow createBooleanExpressionsModel() throws IOException {
		return loadExecutionFlowFromResource(BOOLEAN_EXPRESSIONS);
	}

	/**
	 * <img src="../../images/Choice.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createChoiceJunctionModel() throws IOException {
		return loadExecutionFlowFromResource(CHOICE);
	}

	/**
	 * <img src="../../images/CKeywords.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createCKeywordModel() throws IOException {
		return loadExecutionFlowFromResource(C_KEYWORDS_M);
	}

	/**
	 * <img src="../../images/Declarations.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createDeclarationsModel() throws IOException {
		return loadExecutionFlowFromResource(DECLARATIONS);
	}

	/**
	 * <img src="../../images/DeepHistory.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createDeepHistoryModel() throws IOException {
		return loadExecutionFlowFromResource(DEEP_HISTORY);
	}

	/**
	 * <img src="../../images/FeatureCalls.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createFeatureCallModel() throws IOException {
		return loadExecutionFlowFromResource(FEATURE_CALLS);
	}

	/**
	 * <img src="../../images/Guard.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createGuardModel() throws IOException {
		return loadExecutionFlowFromResource(GUARD);
	}

	/**
	 * <img src="../../images/IntegerExpressions.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createIntegerExpressionsModel() throws IOException {
		return loadExecutionFlowFromResource(INTEGER_EXPRESSIONS);
	}

	/**
	 * <img src="../../images/JavaKeywords.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createJavaKeywordsModel() throws IOException {
		return loadExecutionFlowFromResource(JAVA_KEYWORDS_M);
	}

	/**
	 * <img src="../../images/Parenthesis.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createParenthesisModel() throws IOException {
		return loadExecutionFlowFromResource(PARENTHESIS);
	}

	/**
	 * <img src="../../images/PriorityValues.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createPriorityValueModel() throws IOException {
		return loadExecutionFlowFromResource(PRIORITY_VALUES);
	}

	/**
	 * <img src="../../images/RaisEvent.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createRaisEventModel() throws IOException {
		return loadExecutionFlowFromResource(RAISE_EVENTS);
	}

	/**
	 * <img src="../../images/RealExpressions.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createRealExpressionsModel() throws IOException {
		return loadExecutionFlowFromResource(REAL_EXPRESSIONS);
	}

	/**
	 * <img src="../../images/SameNameDifferentRegion.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createSameNameDifferentRegionModel()
			throws IOException {
		return loadExecutionFlowFromResource(SAME_NAME_DIFFERENT_REGION);
	}

	/**
	 * <img src="../../images/ShallowHistory.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createShallowHistoryModel() throws IOException {
		return loadExecutionFlowFromResource(SHALLOW_HISTORY);
	}

	/**
	 * <img src="../../images/BitExpressions.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createSimpleEventModel() throws IOException {
		return loadExecutionFlowFromResource(SIMPLE_EVENT);
	}

	/**
	 * <img src="../../images/SimpleHierachy.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createSimpleHierachyModel() throws IOException {
		return loadExecutionFlowFromResource(SIMPLE_HIERACHY);
	}

	/**
	 * <img src="../../images/StatechartLocalReactions.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createStatechartLocalReactionsModel()
			throws IOException {
		return loadExecutionFlowFromResource(STATECHART_LOCAL_REACTIONS);
	}

	/**
	 * <img src="../../images/StateIsActive.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createStateIsActiveModel() throws IOException {
		return loadExecutionFlowFromResource(STATE_ACTIVE);
	}

	/**
	 * <img src="../../images/StringExpressions.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createStringExpressionsModel() throws IOException {
		return loadExecutionFlowFromResource(STRING_EXPRESSIONS);
	}

	/**
	 * <img src="../../images/SyncFork.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createSyncForkModel() throws IOException {
		return loadExecutionFlowFromResource(SYNC_FORK);
	}

	/**
	 * <img src="../../images/SyncJoin.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createSyncJoinModel() throws IOException {
		return loadExecutionFlowFromResource(SYNC_JOIN);
	}

	/**
	 * <img src="../../images/TimeTrigger.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createTimeTriggerModel() throws IOException {
		return loadExecutionFlowFromResource(TIME_TRIGGER);
	}

	/**
	 * <img src="../../images/ValuedEvents.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createValuedEventsModel() throws IOException {
		return loadExecutionFlowFromResource(VALUED_EVENTS);
	}

	/**
	 * <img src="../../images/Operations.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createOperationsModel() throws IOException {
		return loadExecutionFlowFromResource(OPERATIONS);
	}

	/**
	 * Helper method - loads a testmodel from the Testmodel directory
	 * 
	 * @param fileName
	 *            the filename of the testmodel
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow loadExecutionFlowFromResource(String fileName)
			throws IOException {
		Statechart statechart = loadStatechartFromResource(fileName);
		final ExecutionFlow flow = sequencer.transform(statechart);
		return flow;
	}

	public Statechart loadStatechartFromResource(String fileName) {
		URI uri = URI.createPlatformPluginURI(TESTMODEL_DIR + fileName, true);
		ResourceSetImpl impl = new ResourceSetImpl();
		Resource resource = impl.getResource(uri, true);
		Assert.isTrue(resource instanceof AbstractSCTResource);
		Statechart statechart = (Statechart) EcoreUtil.getObjectByType(
				resource.getContents(), SGraphPackage.Literals.STATECHART);
		return statechart;
	}
}
