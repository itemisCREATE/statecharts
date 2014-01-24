/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.c

import org.yakindu.sct.generator.core.features.ICoreFeatureConstants
import org.yakindu.sct.model.sgen.FeatureParameterValue
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.c.features.CFeatureConstants

class GenmodelEntries {
	
	def private getLicenseFeature(GeneratorEntry it) {
		getFeatureConfiguration(ICoreFeatureConstants::LICENSE_HEADER)
	}
	
	def private FeatureParameterValue getLicenseTextParameter(GeneratorEntry it) {
		licenseFeature?.getParameterValue(ICoreFeatureConstants::LICENSE_TEXT)
	}
	
	def getLicenseText(GeneratorEntry it) {
		if (licenseTextParameter != null) {
			return "/*"+licenseTextParameter.stringValue+"*/"
		}
		return null
	}
	
	def private getIdentifierSettingsFeature(GeneratorEntry it) {
		getFeatureConfiguration(CFeatureConstants::FEATURE_IDENTIFIER_SETTINGS)
	}
	
	def private FeatureParameterValue getMaxIdentifierLengthParameter(GeneratorEntry it) {
		identifierSettingsFeature?.getParameterValue(CFeatureConstants::PARAMETER_MAX_IDENTIFIER_LENGTH)
	}
	
	def getIdentifierLength(GeneratorEntry it) {
		if (maxIdentifierLengthParameter != null) {
			return Integer.valueOf(maxIdentifierLengthParameter.stringValue)
		}
		return null
	}
	
	def private FeatureParameterValue getSeparatorParameter(GeneratorEntry it) {
		identifierSettingsFeature?.getParameterValue(CFeatureConstants::PARAMETER_SEPARATOR)
	}
	
	def getSeparator(GeneratorEntry it) {
		return separatorParameter?.stringValue
	}
	
	def private FeatureParameterValue getStatemachinePrefixParameter(GeneratorEntry it) {
		identifierSettingsFeature?.getParameterValue(CFeatureConstants::PARAMETER_STATEMACHINE_PREFIX)
	}
	
	def getStatemachinePrefix(GeneratorEntry it) {
		return statemachinePrefixParameter?.stringValue
	}
	
	def private FeatureParameterValue getModuleNameParameter(GeneratorEntry it) {
		identifierSettingsFeature?.getParameterValue(CFeatureConstants::PARAMETER_MODULE_NAME)
	}
	
	def getModuleName(GeneratorEntry it) {
		return moduleNameParameter?.stringValue
	}
}