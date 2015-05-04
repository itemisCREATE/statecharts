package org.yakindu.sct.generator.java

import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.generator.java.features.IJavaFeatureConstants
import org.yakindu.sct.model.sexec.ExecutionFlow
import com.google.inject.Inject

class RunnableFeature {
	
	@Inject extension Naming
	
	
	def getFeatureRunnable(GeneratorEntry it) {
		getFeatureConfiguration(IJavaFeatureConstants::RUNNABLE_WRAPPER);
	}
	
	def hasFeatureRunnable(GeneratorEntry it) {
		featureRunnable != null
	}
	
	def getNamePrefix(GeneratorEntry it) {
		if (featureRunnable != null) featureRunnable.getParameterValue(IJavaFeatureConstants::NAME_PREFIX).stringValue
		else ""	
	}
	
	def getNameSuffix(GeneratorEntry it) {
		if (featureRunnable != null) featureRunnable.getParameterValue(IJavaFeatureConstants::NAME_SUFFIX).stringValue
		else ""	
	}
	
	
	def runnableWrapperClassName(ExecutionFlow it, GeneratorEntry entry) {
		 entry.namePrefix + statemachineName + entry.nameSuffix 
	}
	
}