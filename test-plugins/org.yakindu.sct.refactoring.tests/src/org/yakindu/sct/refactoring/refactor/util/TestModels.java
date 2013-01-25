/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.refactor.util;

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

@Deprecated
// Use sct.examples TestModels
public class TestModels {

	public static final String INITIAL_STATECHART = "before.sct";
	public static final String EXPECTED_STATECHART = "after.sct";

	public static final String FOLD_INCOMING_ACTIONS = "fold_inc_action/";
	public static final String FOLD_OUTGOING_ACTIONS = "fold_out_action/";
	public static final String UNFOLD_ENTRY_ACTIONS = "unfold_entry_action/";
	public static final String UNFOLD_EXIT_ACTIONS = "unfold_exit_action/";
	public static final String GROUPING_STATES = "grouping_states/";
	public static final String RENAMING = "renaming/";
	public static final String CREATE_SUBMACHINE = "create_submachine/";

	public static final String TESTMODEL_DIR = "com.yakindu.sct.refactoring.tests/testmodels/";

	@Inject
	private ModelSequencer sequencer;

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
