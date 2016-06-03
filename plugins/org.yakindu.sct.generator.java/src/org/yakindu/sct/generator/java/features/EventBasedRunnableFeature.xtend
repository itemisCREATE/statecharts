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

import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.java.features.IJavaFeatureConstants
import org.yakindu.sct.model.sexec.ExecutionFlow
import com.google.inject.Inject
import org.yakindu.sct.generator.java.Naming

class EventBasedRunnableFeature {

	@Inject extension Naming

	def getFeatureEventRunnable(GeneratorEntry it) {
		getFeatureConfiguration(IJavaFeatureConstants::FEATURE_RUNNABLE_WRAPPER);
	}

	def hasFeatureEventRunnable(GeneratorEntry it) {
		featureEventRunnable != null
	}

	def getNamePrefix(GeneratorEntry it) {
		if (featureEventRunnable != null &&
			featureEventRunnable.getParameterValue(IJavaFeatureConstants::VALUE_NAME_PREFIX) != null)
			featureEventRunnable.getParameterValue(IJavaFeatureConstants::VALUE_NAME_PREFIX).stringValue
		else
			IJavaFeatureConstants::RUNNABLE_WRAPPER_NAME_PREFIX_DEFAULT
	}

	def getNameSuffix(GeneratorEntry it) {
		if (featureEventRunnable != null &&
			featureEventRunnable.getParameterValue(IJavaFeatureConstants::VALUE_NAME_SUFFIX) != null)
			featureEventRunnable.getParameterValue(IJavaFeatureConstants::VALUE_NAME_SUFFIX).stringValue
		else
			IJavaFeatureConstants::RUNNABLE_WRAPPER_NAME_SUFFIX_DEFAULT
	}

	def eventBasedWrapperClassName(ExecutionFlow it, GeneratorEntry entry) {
		entry.namePrefix + statemachineClassName + entry.nameSuffix
	}
}