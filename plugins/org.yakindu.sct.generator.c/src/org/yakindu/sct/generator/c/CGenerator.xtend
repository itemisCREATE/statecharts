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
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.c.IGenArtifactConfigurations.GenArtifactConfiguration
import org.yakindu.sct.generator.c.eventdriven.StatechartEventsHeader
import org.yakindu.sct.generator.c.eventdriven.StatechartEventsSource
import org.yakindu.sct.generator.core.IExecutionFlowGenerator
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Statechart

import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*
import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.EVENT_DRIVEN_ANNOTATION

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
	@Inject extension StatechartEventsHeader statechartEventsHeader
	@Inject extension StatechartEventsSource statechartEventsSource
	@Inject extension Navigation
	@Inject extension GenmodelEntries
	@Inject extension Naming
	@Inject extension ICoreLibraryHelper

	@Inject
	IGenArtifactConfigurations configs
	
	override generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		initGenerationArtifacts(flow, entry, configs)
		generateArtifacts(flow, entry, fsa, configs)
	}
	
	def generateArtifacts(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa, IGenArtifactConfigurations locations) {
		for (GenArtifactConfiguration a : locations.configurations) {
			fsa.generateFile(a.getName, a.getOutputName, a.getContentTemplate.content(flow, entry, locations))
		}
	}
	
	def protected initGenerationArtifacts(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		locations.configure(flow.typesModule.h, entry.libraryOutput, types)
		locations.configure(flow.module.h, entry.headerOutput, statemachineHeader)
		locations.configure(flow.module.c, entry.sourceOutput, statemachineSource)
		if (flow.timed || !flow.operations.empty || entry.tracingEnterState || entry.tracingExitState) {
			locations.configure(flow.module.client.h, entry.headerOutput, statemachineRequiredHeader)
		}
		
		if((sourceElement as Statechart).getAnnotationOfType(EVENT_DRIVEN_ANNOTATION) !== null) {
			locations.configure(flow.eventsModule.h, entry.headerOutput, statechartEventsHeader)
			locations.configure(flow.eventsModule.c, entry.sourceOutput, statechartEventsSource)
		}
	}
	
	def protected getHeaderOutput(GeneratorEntry entry) {
		if (entry.apiTargetFolderValue != null) {
			API_TARGET_FOLDER_OUTPUT
		} else {
			TARGET_FOLDER_OUTPUT
		}
	}

	def protected getLibraryOutput(GeneratorEntry entry) {
		if (entry.libraryTargetFolderValue != null) {
			LIBRARY_TARGET_FOLDER_OUTPUT
		} else {
			entry.headerOutput
		}
	}
	
	def protected getSourceOutput(GeneratorEntry entry) {
		TARGET_FOLDER_OUTPUT
	}
	
}