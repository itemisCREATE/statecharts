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
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class BaseTestModels {

	@Inject
	private ModelSequencer sequencer;

	public abstract String getModelDirectory();

	public Statechart loadStatechartFromResource(String fileName) {
		URI uri = URI.createPlatformPluginURI(getModelDirectory() + fileName,
				true);
		ResourceSetImpl impl = new ResourceSetImpl();
		Resource resource = impl.getResource(uri, true);
		Assert.isTrue(resource instanceof AbstractSCTResource);
		Statechart statechart = (Statechart) EcoreUtil.getObjectByType(
				resource.getContents(), SGraphPackage.Literals.STATECHART);
		return statechart;
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
}
