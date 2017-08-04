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
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.IGenArtifactConfigurations.GenArtifactConfiguration
import org.yakindu.sct.generator.core.IExecutionFlowGenerator
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Statechart

import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*
import static org.yakindu.sct.model.stext.lib.StatechartAnnotations.*

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
	@Inject extension ICoreLibraryHelper

	@Inject
	IGenArtifactConfigurations locations

	override generate(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		initGenerationArtifacts(flow, entry, locations)
		generateArtifacts(flow, entry, fsa, locations);
	}

	def generateArtifacts(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa,
		IGenArtifactConfigurations locations) {
		for (GenArtifactConfiguration a : locations.configurations) {
			fsa.generateFile(a.getName, a.getOutputName, a.getContentTemplate.content(flow, entry, locations))
		}
	}

	def initGenerationArtifacts(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		locations.configure(flow.typesModule.h, entry.libraryOutput, typesContent)
		locations.configure(statemachineInterface.h, entry.libraryOutput, statemachineInterfaceContent)

		if (flow.timed) {
			locations.configure(timedStatemachineInterface.h, entry.libraryOutput, timedStatemachineInterfaceContent)
			locations.configure(timerInterface.h, entry.libraryOutput, timerInterfaceContent)
		}

		locations.configure(flow.module.h, entry.headerOutput, statemachineHeaderContent)
		locations.configure(flow.module.cpp, entry.sourceOutput, statemachineSourceContent)
	}

	def isEventDriven(ExecutionFlow it) {
		val statechart = sourceElement as Statechart

		val eventDrivenAnnotation = statechart.getAnnotationOfType(EVENT_DRIVEN_ANNOTATION)
		return eventDrivenAnnotation !== null
	}

	def protected getHeaderOutput(GeneratorEntry entry) {
		if (entry.apiTargetFolderValue !== null) {
			API_TARGET_FOLDER_OUTPUT
		} else {
			TARGET_FOLDER_OUTPUT
		}
	}

	def protected getLibraryOutput(GeneratorEntry entry) {
		if (entry.libraryTargetFolderValue !== null) {
			LIBRARY_TARGET_FOLDER_OUTPUT
		} else {
			entry.headerOutput
		}
	}

	def protected getSourceOutput(GeneratorEntry entry) {
		TARGET_FOLDER_OUTPUT
	}

}
