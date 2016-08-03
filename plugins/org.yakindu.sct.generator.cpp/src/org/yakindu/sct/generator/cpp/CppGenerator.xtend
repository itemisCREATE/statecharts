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
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import com.google.inject.name.Named
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.c.GenArtifactConfigurations.GenArtifactConfiguration
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator
import org.yakindu.sct.generator.core.library.IOutletFeatureHelper
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

/**
 * This is the CPP code generators main class. 
 * 
 * @author Markus Mühlbrandt
 */
class CppGenerator implements IExecutionFlowGenerator {
	 
	@Inject extension Types typesContent
	@Inject extension TimedStatemachineInterface timedStatemachineInterfaceContent
	@Inject extension TimerInterface timerInterfaceContent
	@Inject extension StatemachineInterface statemachineInterfaceContent
	@Inject extension StatemachineHeader statemachineHeaderContent
	@Inject extension StatemachineImplementation statemachineSourceContent
	@Inject extension Navigation
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
	
	def initGenerationArtifacts(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		if (outletFeatureHelper.getLibraryTargetFolderValue(entry) != null) {
			locations.configure(flow.typesModule.h, IExecutionFlowGenerator.LIBRARY_TARGET_FOLDER_OUTPUT, typesContent)
		} else {
			locations.configure(flow.typesModule.h, IExecutionFlowGenerator.TARGET_FOLDER_OUTPUT, typesContent)
		}
		
		locations.configure(statemachineInterface.h, IExecutionFlowGenerator.TARGET_FOLDER_OUTPUT, statemachineInterfaceContent)
		
		if (flow.timed) {
			if (outletFeatureHelper.getLibraryTargetFolderValue(entry) != null) {
				locations.configure(timedStatemachineInterface.h, IExecutionFlowGenerator.LIBRARY_TARGET_FOLDER_OUTPUT, timedStatemachineInterfaceContent)
				locations.configure(timerInterface.h, IExecutionFlowGenerator.LIBRARY_TARGET_FOLDER_OUTPUT, timerInterfaceContent)
			} else {
				locations.configure(timedStatemachineInterface.h, IExecutionFlowGenerator.TARGET_FOLDER_OUTPUT, timedStatemachineInterfaceContent)
				locations.configure(timerInterface.h, IExecutionFlowGenerator.TARGET_FOLDER_OUTPUT, timerInterfaceContent)
			}
		}
		
		locations.configure(flow.module.h, IExecutionFlowGenerator.TARGET_FOLDER_OUTPUT, statemachineHeaderContent)
		locations.configure(flow.module.cpp, IExecutionFlowGenerator.TARGET_FOLDER_OUTPUT, statemachineSourceContent)
	}
	
}