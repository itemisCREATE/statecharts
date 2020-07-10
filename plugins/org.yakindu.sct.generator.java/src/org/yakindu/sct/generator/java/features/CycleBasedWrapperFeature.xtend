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
package org.yakindu.sct.generator.java.features

import com.google.inject.Inject
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.InterfaceScope

class CycleBasedWrapperFeature {

	@Inject extension Naming

	def getFeatureCycleWrapper(GeneratorEntry it) {
		getFeatureConfiguration(IJavaFeatureConstants::FEATURE_SYCHRONIZED_WRAPPER);
	}

	def hasFeatureCycleWrapper(GeneratorEntry it) {
		featureCycleWrapper !== null
	}

	def getNamePrefix(GeneratorEntry it) {
		if (featureCycleWrapper !== null &&
			featureCycleWrapper.getParameterValue(IJavaFeatureConstants::VALUE_NAME_PREFIX) !== null)
			featureCycleWrapper.getParameterValue(IJavaFeatureConstants::VALUE_NAME_PREFIX).stringValue
		else
			IJavaFeatureConstants::SYCHRONIZED_WRAPPER_NAME_PREFIX_DEFAULT
	}

	def getNameSuffix(GeneratorEntry it) {
		if (featureCycleWrapper !== null &&
			featureCycleWrapper.getParameterValue(IJavaFeatureConstants::VALUE_NAME_PREFIX) !== null)
			featureCycleWrapper.getParameterValue(IJavaFeatureConstants::VALUE_NAME_SUFFIX).stringValue
		else
			IJavaFeatureConstants::SYCHRONIZED_WRAPPER_NAME_SUFFIX_DEFAULT
	}

	def cycleWrapperClassName(ExecutionFlow it, GeneratorEntry entry) {
		entry.namePrefix + statemachineClassName + entry.nameSuffix
	}
	
	def wrapperInterfaceName(InterfaceScope it, GeneratorEntry entry) {
		entry.namePrefix + interfaceName + entry.nameSuffix
	}
}