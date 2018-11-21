/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.c.extensions

import org.yakindu.sct.generator.c.features.ICFeatureConstants
import org.yakindu.sct.model.sgen.FeatureParameterValue
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.*

class GenmodelEntries {
	
	def private getLicenseFeature(GeneratorEntry it) {
		getFeatureConfiguration(LICENSE_HEADER)
	}
	
	def private FeatureParameterValue getLicenseTextParameter(GeneratorEntry it) {
		licenseFeature?.getParameterValue(LICENSE_TEXT)
	}
	
	def getLicenseText(GeneratorEntry it) {
		if (licenseTextParameter !== null) {
			return "/* " + licenseTextParameter.stringValue.trim + " */"
		}
		return null
	}
	
	def private getIdentifierSettingsFeature(GeneratorEntry it) {
		getFeatureConfiguration(ICFeatureConstants::FEATURE_NAMING)
	}
	
	def private FeatureParameterValue getMaxIdentifierLengthParameter(GeneratorEntry it) {
		identifierSettingsFeature?.getParameterValue(ICFeatureConstants::PARAMETER_NAMING_MAX_IDENTIFIER_LENGTH)
	}
	
	def getIdentifierLength(GeneratorEntry it) {
		if (maxIdentifierLengthParameter !== null) {
			try {
				return Integer.valueOf(maxIdentifierLengthParameter.stringValue)
			}
			catch (NumberFormatException e) {
				return 0
			}
		}
		return 0
	}
	
	def private FeatureParameterValue getSeparatorParameter(GeneratorEntry it) {
		identifierSettingsFeature?.getParameterValue(ICFeatureConstants::PARAMETER_NAMING_SEPARATOR)
	}
	
	def getSeparator(GeneratorEntry it) {
		return separatorParameter?.stringValue
	}
	
	def private FeatureParameterValue getStatemachinePrefixParameter(GeneratorEntry it) {
		identifierSettingsFeature?.getParameterValue(ICFeatureConstants::PARAMETER_NAMING_STATEMACHINE_PREFIX)
	}
	
	def getStatemachinePrefix(GeneratorEntry it) {
		return statemachinePrefixParameter?.stringValue
	}
	
	def private FeatureParameterValue getModuleNameParameter(GeneratorEntry it) {
		identifierSettingsFeature?.getParameterValue(ICFeatureConstants::PARAMETER_NAMING_MODULE_NAME)
	}
	
	def getModuleName(GeneratorEntry it) {
		return moduleNameParameter?.stringValue
	}
	
	
	def private getTracingFeature(GeneratorEntry it) {
		getFeatureConfiguration(ICFeatureConstants::FEATURE_TRACING)
	}
	
	def getTracingEnterState(GeneratorEntry it){
		val enterStateParameter = tracingFeature?.getParameterValue(ICFeatureConstants::PARAMETER_TRACING_ENTER_STATE)
		if (enterStateParameter !== null) {
			return enterStateParameter.booleanValue
		}
		return false
	}
	
	def getTracingExitState(GeneratorEntry it){
		val exitStateParameter = tracingFeature?.getParameterValue(ICFeatureConstants::PARAMETER_TRACING_EXIT_STATE)
		if (exitStateParameter !== null) {
			return exitStateParameter.booleanValue
		}
		return false
	}
	
	def tracingUsed(GeneratorEntry it) {
		return (tracingEnterState || tracingExitState)
	}
}
