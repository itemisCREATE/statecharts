/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.generator.cpp.features

import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.cpp.features.CPPFeatureConstants.Visibility
import org.yakindu.sct.model.sgen.GeneratorEntry

class GenmodelEntriesExtension extends GenmodelEntries {

	def private getGeneratorOptionsFeature(GeneratorEntry it) {
		getFeatureConfiguration(CPPFeatureConstants::FEATURE_GENERATOR_OPTIONS)
	}
	
	def private getAPIFeature(GeneratorEntry it){
		getFeatureConfiguration(CPPFeatureConstants::FEATURE_API)
	}

	def private getVisibilityParameter(GeneratorEntry it) {
		generatorOptionsFeature?.getParameterValue(CPPFeatureConstants.PARAMETER_INNER_FUNCTION_VISIBILITY)
	}
	
	def private getCheckUnimplementedParamter(GeneratorEntry it) {
		APIFeature?.getParameterValue(CPPFeatureConstants.PARAMETER_API_CHECK_UNIMPLEMENTED_OCBS)
	}

	def getInnerClassVisibility(GeneratorEntry it) {
		if (visibilityParameter !== null) {
			return visibilityParameter.stringValue
		}
		return Visibility.PRIVATE.toString.toLowerCase
	}

	def private getStaticOPCParameter(GeneratorEntry it) {
		generatorOptionsFeature?.getParameterValue(CPPFeatureConstants.PARAMETER_STATIC_OPC)
	}

	def useStaticOPC(GeneratorEntry it) {
		if (staticOPCParameter !== null) {
			return staticOPCParameter.booleanValue
		}
		return false
	}
	
	def getCheckUnimplementedOCBs(GeneratorEntry it) {
		if (checkUnimplementedParamter !== null){
			return checkUnimplementedParamter.booleanValue
		}
	}
	
	def private getInEventQueueParameter(GeneratorEntry it) {
		generatorOptionsFeature?.getParameterValue(CPPFeatureConstants.PARAMETER_IN_EVENT_QUEUE)
	}
	
	def inEventQueue(GeneratorEntry it) {
		inEventQueueParameter?.booleanValue
	}
}
