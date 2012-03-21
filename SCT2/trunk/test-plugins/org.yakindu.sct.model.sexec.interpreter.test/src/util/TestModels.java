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

import com.google.inject.Inject;

/**
 * Provides access to the testmodels.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TestModels {

	private static final String TESTMODEL_DIR = "org.yakindu.sct.model.sexec.interpreter.test/testmodels/";

	private static final String SIMPLE = "Simple.sct";
	private static final String SIMPLE_HIERACHY = "SimpleHierachy.sct";

	@Inject
	private ModelSequencer sequencer;

	/**
	 * <img src="../../images/Simple.png" /> <br />
	 * Creates a simple {@link Statechart} with two States and one Transition
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createSimpleModel() throws IOException {
		return loadFromResource(SIMPLE);
	}
	
	/**
	 * <img src="../../images/SimpleHierachy.png" /> <br />
	 * Creates a simple {@link Statechart} with two States and one Transition
	 * @return the {@link ExecutionFlow}
	 * @throws IOException
	 */
	public ExecutionFlow createSimpleHierachyModel() throws IOException {
		return loadFromResource(SIMPLE_HIERACHY);
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
		Assert.isNotNull(fileName);
		URI uri = URI.createPlatformPluginURI(TESTMODEL_DIR + fileName, true);
		ResourceSetImpl impl = new ResourceSetImpl();
		Resource resource = impl.getResource(uri, true);
		Statechart statechart = (Statechart) EcoreUtil.getObjectByType(
				resource.getContents(), SGraphPackage.Literals.STATECHART);
		Assert.isNotNull(statechart);
		return sequencer.transform(statechart);
	}
}
