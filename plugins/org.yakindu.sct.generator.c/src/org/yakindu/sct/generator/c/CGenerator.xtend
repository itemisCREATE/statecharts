/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c

import com.google.inject.Inject
import com.google.inject.name.Named
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.core.library.IOutletFeatureHelper
import org.yakindu.sct.generator.c.GenArtifactConfigurations.GenArtifactConfiguration

/**
 * This is the C code generators main class. 
 * 
 * @author Axel Terfloth
 */
class CGenerator implements IExecutionFlowGenerator {
	 
	@Inject extension Types types
	@Inject extension StatemachineHeader statemachineHeader
	@Inject extension StatemachineSource statemachineSource
	@Inject extension StatemachineRequiredHeader statemachineRequiredHeader
	@Inject extension Navigation
	@Inject extension GenmodelEntries
	@Inject extension Naming
	
	@Inject IOutletFeatureHelper outletFeatureHelper

	@Inject @Named(IGenArtifactConfigurations.DEFAULT)
	IGenArtifactConfigurations defaultConfigs
	
	/**
	 * @Deprecated use {@link #generate(ExecutionFlow, GeneratorEntry, IFileSystemAccess, ArtifactLocationProvider)} instead
	 */
	@Deprecated
	override generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		generate(flow, entry, fsa, defaultConfigs)
	}
	
	def generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa, IGenArtifactConfigurations locations) {
		initGenerationArtifacts(flow, entry, locations)
		generateArtifacts(flow, entry, fsa, locations);
	}
	
	def generateArtifacts(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa, IGenArtifactConfigurations locations) {
		for (GenArtifactConfiguration a : locations.configurations) {
			fsa.generateFile(a.getName, a.getOutputName, a.getContentTemplate.content(flow, entry, locations))
		}
	}
	
	def protected initGenerationArtifacts(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		if (outletFeatureHelper.getLibraryTargetFolderValue(entry) != null) {
			locations.configure(flow.typesModule.h, IExecutionFlowGenerator.LIBRARY_TARGET_FOLDER_OUTPUT, types)
		} else {
			locations.configure(flow.typesModule.h, IExecutionFlowGenerator.TARGET_FOLDER_OUTPUT, types)
		}
		locations.configure(flow.module.h, IExecutionFlowGenerator.TARGET_FOLDER_OUTPUT, statemachineHeader)
		locations.configure(flow.module.c, IExecutionFlowGenerator.TARGET_FOLDER_OUTPUT, statemachineSource)
		if (flow.timed || !flow.operations.empty || entry.tracingEnterState || entry.tracingExitState) {
			locations.configure(flow.module.client.h, IExecutionFlowGenerator.TARGET_FOLDER_OUTPUT, statemachineRequiredHeader)
		}
	}
	
}