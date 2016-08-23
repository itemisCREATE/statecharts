/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.core.execution;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.yakindu.sct.generator.core.IExecutionFlowGenerator;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.transformation.FlowOptimizer;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SExecGenModelExecutor extends AbstractGenModelExecutor implements IGenModelExecutor {

	private static final String SEXEC_FILE_EXTENSION = "sexec";

	@Inject
	private IExecutionFlowGenerator generator;
	@Inject
	private IModelSequencer sequencer;
	@Inject
	private FlowOptimizerFactory optimizerFactory;
	@Inject
	protected ICoreLibraryHelper helper;

	@Override
	protected void execute(ISCTFileSystemAccess access, GeneratorEntry generatorEntry) {
		ExecutionFlow flow = createExecutionFlow(generatorEntry);
		generator.generate(flow, generatorEntry, access);
		if (helper.serializeExecutionFlow(generatorEntry)) {
			serializeExecutionFlow(generatorEntry, flow);
		}
	}

	protected ExecutionFlow createExecutionFlow(GeneratorEntry entry) {
		ExecutionFlow flow = sequencer.transform((Statechart) entry.getElementRef());
		Assert.isNotNull(flow, "Error creation ExecutionFlow");
		FlowOptimizer optimizer = optimizerFactory.create(entry);
		return optimizer.transform(flow);
	}

	protected void serializeExecutionFlow(GeneratorEntry entry, ExecutionFlow flow) {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
		URI fileURI = entry.getElementRef().eResource().getURI().trimFileExtension()
				.appendFileExtension(SEXEC_FILE_EXTENSION);
		Resource resource = resourceSet.createResource(fileURI);
		resource.getContents().add(flow);
		try {
			resource.save(Collections.EMPTY_MAP);
		} catch (IOException e) {
		}
	}

}
