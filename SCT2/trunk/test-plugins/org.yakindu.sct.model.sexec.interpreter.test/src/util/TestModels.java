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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Assert;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.transformation.ModelSequencer;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;

import de.itemis.xtext.utils.gmf.resource.InjectMembersResource;

/**
 * Provides access to the testmodels.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TestModels {

	private static final String TESTMODEL_DIR = "org.yakindu.sct.model.sexec.interpreter.test/testmodels/";

	private static final String GUARD = "Guard.sct";
	private static final String SIMPLE_HIERACHY = "SimpleHierachy.sct";
	private static final String DEEP_HISTORY = "DeepHistory.sct";
	private static final String STATE_ACTIVE = "StateIsActive.sct";
	private static final String VALUED_EVENTS = "ValuedEvents.sct";
	private static final String FEATURE_CALLS = "FeatureCalls.sct";

	@Inject
	private ModelSequencer sequencer;

	/**
	 * <img src="../../images/Guard.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createGuardModel() throws IOException {
		return loadFromResource(GUARD);
	}

	/**
	 * <img src="../../images/SimpleHierachy.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createSimpleHierachyModel() throws IOException {
		return loadFromResource(SIMPLE_HIERACHY);
	}

	/**
	 * <img src="../../images/DeepHistory.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createDeepHistoryModel() throws IOException {
		return loadFromResource(DEEP_HISTORY);
	}

	/**
	 * <img src="../../images/StateIsActive.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createStateIsActiveModel() throws IOException {
		return loadFromResource(STATE_ACTIVE);
	}

	/**
	 * <img src="../../images/ValuedEvents.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createValuedEventsModel() throws IOException {
		return loadFromResource(VALUED_EVENTS);
	}
	/**
	 * <img src="../../images/FeatureCalls.png" /> <br />
	 * 
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createFeatureCallModel() throws IOException {
		return loadFromResource(FEATURE_CALLS);
	}

	/**
	 * Helper method - loads a testmodel from the Testmodel directory
	 * 
	 * @param fileName
	 *            the filename of the testmodel
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	private ExecutionFlow loadFromResource(String fileName) throws IOException {
		Assert.assertNotNull(fileName);
		URI uri = URI.createPlatformPluginURI(TESTMODEL_DIR + fileName, true);
		ResourceSetImpl impl = new ResourceSetImpl();
		Resource resource = impl.getResource(uri, true);
		Assert.assertTrue(
				"Statechart resources have to be InjectMemberResourece but was '"
						+ resource.getClass().getCanonicalName() + "'",
				resource instanceof InjectMembersResource);
		Statechart statechart = (Statechart) EcoreUtil.getObjectByType(
				resource.getContents(), SGraphPackage.Literals.STATECHART);
		Assert.assertNotNull(statechart);
		final ExecutionFlow flow = sequencer.transform(statechart);
		Assert.assertNotNull(flow);
		return flow;
	}
}
