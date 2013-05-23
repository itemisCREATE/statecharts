/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.test.models;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractTestModelsUtil {

	public static final String VALIDATION_TESTMODEL_DIR = "org.yakindu.sct.test.models/testmodels/validation/";

	@Inject
	private IModelSequencer sequencer;

	public abstract String getModelDirectory();

	public Statechart loadStatechartFromResource(String fileName) {
		URI uri = URI.createPlatformPluginURI(getModelDirectory() + fileName,
				true);
		return loadStatechart(uri);
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

	/**
	 * Helper method - loads a testmodel from the given {@link URI}
	 * 
	 * @param uri
	 *            the {@link URI} of the model file
	 * @return the {@link Statechart}
	 */
	public static final Statechart loadStatechart(URI uri) {
		ResourceSet resSet = new ResourceSetImpl();
		Resource resource = resSet.getResource(uri, true);
		Statechart statechart = (Statechart) EcoreUtil.getObjectByType(
				resource.getContents(), SGraphPackage.Literals.STATECHART);
		return statechart;
	}

	/**
	 * Helper method - loads a testmodel from the given filename.
	 * 
	 * @param filename
	 *            the filename of the model file
	 * @return the {@link Statechart}
	 */
	public static final Statechart loadStatechart(String filename) {
		return AbstractTestModelsUtil.loadStatechart(URI
				.createPlatformPluginURI(filename, true));
	}
}
