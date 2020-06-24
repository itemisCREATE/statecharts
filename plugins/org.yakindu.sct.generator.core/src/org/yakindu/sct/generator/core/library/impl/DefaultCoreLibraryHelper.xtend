/** 
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.core.library.impl

import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.DEBUG_FEATURE
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.DEBUG_FEATURE_DUMP_SEXEC
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_API_TARGET_FOLDER
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_LIBRARY_TARGET_FOLDER
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_TARGET_FOLDER
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_TARGET_PROJECT
import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.OUTLET_FEATURE_SKIP_LIBRARY_FILES
import org.eclipse.core.runtime.Path
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.model.sgen.FeatureParameterValue
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.core.library.ICoreLibraryConstants

/** 
 * @author Johannes Dicks - Initial contribution and API
 */
class DefaultCoreLibraryHelper implements ICoreLibraryHelper {
	override FeatureParameterValue getTargetFolderValue(GeneratorEntry entry) {
		return entry.getFeatureParameterValue(OUTLET_FEATURE, OUTLET_FEATURE_TARGET_FOLDER)
	}

	override FeatureParameterValue getLibraryTargetFolderValue(GeneratorEntry entry) {
		return entry.getFeatureParameterValue(OUTLET_FEATURE, OUTLET_FEATURE_LIBRARY_TARGET_FOLDER)
	}

	override FeatureParameterValue getApiTargetFolderValue(GeneratorEntry entry) {
		return entry.getFeatureParameterValue(OUTLET_FEATURE, OUTLET_FEATURE_API_TARGET_FOLDER)
	}

	override FeatureParameterValue getTargetProjectValue(GeneratorEntry entry) {
		return entry.getFeatureParameterValue(OUTLET_FEATURE, OUTLET_FEATURE_TARGET_PROJECT)
	}

	override String getRelativeTargetFolder(GeneratorEntry entry) {
		var String projectFolderName = getTargetProjectValue(entry).getStringValue()
		var String targetFolderValue = getTargetFolderValue(entry).getStringValue()
		return projectFolderName + Path.SEPARATOR + targetFolderValue
	}

	override String getRelativeLibraryFolder(GeneratorEntry entry) {
		var String projectFolderName = getTargetProjectValue(entry).getStringValue()
		var String libraryFolderName = getLibraryTargetFolderValue(entry).getStringValue()
		return projectFolderName + Path.SEPARATOR + libraryFolderName
	}

	override String getRelativeApiFolder(GeneratorEntry entry) {
		var String projectFolderName = getTargetProjectValue(entry).getStringValue()
		var String apiFolderName = getApiTargetFolderValue(entry).getStringValue()
		return projectFolderName + Path.SEPARATOR + apiFolderName
	}

	override boolean serializeExecutionFlow(GeneratorEntry entry) {
		var FeatureParameterValue dumpSexec = entry.getFeatureParameterValue(DEBUG_FEATURE, DEBUG_FEATURE_DUMP_SEXEC)
		if (dumpSexec === null) {
			return false
		}
		return dumpSexec.getBooleanValue()
	}

	override boolean getSkipLibraryFiles(GeneratorEntry entry) {
		var FeatureParameterValue skipLibraryFiles = entry.getFeatureParameterValue(OUTLET_FEATURE,
			OUTLET_FEATURE_SKIP_LIBRARY_FILES)
		return if(skipLibraryFiles === null) false else skipLibraryFiles.getBooleanValue()
	}
	
	def private getOutEventAPIFeature(GeneratorEntry it) {
		getFeatureConfiguration(ICoreLibraryConstants::FEATURE_OUT_EVENT_API)
	}
	
		
	override getOutEventObservablesUsed(GeneratorEntry it) {
		val parameter = getOutEventAPIFeature?.getParameterValue(ICoreLibraryConstants::PARAMETER_OUT_EVENT_OBSERVABLES)
		if(parameter !== null) {
			return parameter.booleanValue
		}
		true
	}
	
	override getOutEventGettersUsed(GeneratorEntry it) {
		val parameter = getOutEventAPIFeature?.getParameterValue(ICoreLibraryConstants::PARAMETER_OUT_EVENT_GETTERS)
		if(parameter !== null) {
			return parameter.booleanValue
		}
		false
	}


	def private getEventProcessingFeature(GeneratorEntry it) {
		getFeatureConfiguration(ICoreLibraryConstants::FEATURE_EVENT_PROCESSING)
	}
	
	override applyInEventBuffer(GeneratorEntry it) {
		val parameter = eventProcessingFeature?.getParameterValue(ICoreLibraryConstants::PARAMETER_IN_EVENT_BUFFER)
		if(parameter !== null) {
			return parameter.booleanValue
		}
		true
	}
	
	override applyInEventQueue(GeneratorEntry it) {
		val parameter = eventProcessingFeature?.getParameterValue(ICoreLibraryConstants::PARAMETER_IN_EVENT_QUEUE)
		if(parameter !== null) {
			return parameter.booleanValue
		}
		false
	}
	
	override applyInternalEventBuffer(GeneratorEntry it) {
		val parameter = eventProcessingFeature?.getParameterValue(ICoreLibraryConstants::PARAMETER_INTERNAL_EVENT_BUFFER)
		if(parameter !== null) {
			return parameter.booleanValue
		}
		true
	}
	
}
