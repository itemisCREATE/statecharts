/**
 *   Copyright (c) 2012 committers of YAKINDU and others.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   Contributors:
 *   	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import org.yakindu.sct.generator.java.features.IJavaFeatureConstants
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.FeatureParameterValue
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.*

class GenmodelEntries {

	@Inject extension Naming

	def private getLicenseFeature(GeneratorEntry it) {
		getFeatureConfiguration(LICENSE_HEADER)
	}

	def private getNamingFeature(GeneratorEntry it) {
		getFeatureConfiguration(IJavaFeatureConstants::NAMING_FEATURE)
	}

	def private getGeneralFeatures(GeneratorEntry it) {
		getFeatureConfiguration(IJavaFeatureConstants::GENERAL_FEATURES)
	}

	def private getOutletFeatures(GeneratorEntry it) {
		getFeatureConfiguration(OUTLET_FEATURE)
	}

	def private FeatureParameterValue getOutletFeatureTargetProject(GeneratorEntry it) {
		outletFeatures.getParameterValue(OUTLET_FEATURE_TARGET_PROJECT)
	}

	def private FeatureParameterValue getBasePackageParameter(GeneratorEntry it) {
		namingFeature?.getParameterValue(IJavaFeatureConstants::BASE_PACKAGE)
	}

	def private FeatureParameterValue getImplementationSuffixParameter(GeneratorEntry it) {
		namingFeature?.getParameterValue(IJavaFeatureConstants::IMPLEMENTATION_SUFFIX)
	}

	def private FeatureParameterValue getLicenseTextParameter(GeneratorEntry it) {
		licenseFeature?.getParameterValue(LICENSE_TEXT)
	}

	def private FeatureParameterValue getTimerServiceParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(IJavaFeatureConstants::TIMER_SERVICE)
	}

	def private FeatureParameterValue getRuntimeServiceParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(IJavaFeatureConstants::RUNTIME_SERVICE)
	}

	def private FeatureParameterValue getInterfaceObserverSupportParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(IJavaFeatureConstants::INTERFACE_OBSERVER_SUPPORT)
	}

	def private FeatureParameterValue getUseJavaIntForInteger(GeneratorEntry it) {
		generalFeatures?.getParameterValue(IJavaFeatureConstants::USE_JAVA_INT_FOR_INTEGER)
	}
	
	def private FeatureParameterValue getInEventQueueParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(IJavaFeatureConstants::IN_EVENT_QUEUE)
	}
	
	def private FeatureParameterValue getSynchronizedParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(IJavaFeatureConstants::SYNCHRONIZED)
	}
	
	def private FeatureParameterValue getRunnableParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(IJavaFeatureConstants::RUNNABLE)
	}

	def getLicenseText(GeneratorEntry it) {
		if (licenseTextParameter !== null) {
			return "/** " + licenseTextParameter.stringValue.trim + " */"
		}
		LICENSE_STANDARD_TEXT
	}

	def getBasePackageName(GeneratorEntry it) {
		if (basePackageParameter !== null)
			return basePackageParameter.stringValue.toLowerCase
		if (outletFeatureTargetProject !== null)
			return outletFeatureTargetProject.stringValue.toLowerCase
	}

	def getImplementationSuffix(GeneratorEntry it, ExecutionFlow flow) {
		if (implementationSuffixParameter !== null) {
			return flow.statemachineName + implementationSuffixParameter.stringValue
		}
		return flow.statemachineName
	}
	
	def getImplementationSuffix(GeneratorEntry it) {
		if (implementationSuffixParameter !== null) {
			return implementationSuffixParameter.stringValue
		}
		return null
	}

	def getImplementationPackageName(ExecutionFlow it, GeneratorEntry entry) {
		entry.basePackageName + "." + entry.getImplementationSuffix(it).toLowerCase();
	}

	def getBasePackagePath(GeneratorEntry it) {
		return basePackageName.replace('.', '/')
	}

	def getImplementationPackagePath(ExecutionFlow it, GeneratorEntry entry) {
		getImplementationPackageName(entry).replace('.', '/')

	// entry.basePackagePath+"/"+entry.getImplementationSuffix(it).toLowerCase
	}

	def createTimerService(GeneratorEntry it) {
		if (timerServiceParameter !== null) {
			return timerServiceParameter.booleanValue
		}
		return false
	}

	def createRuntimeService(GeneratorEntry it) {
		if (runtimeServiceParameter !== null) {
			return runtimeServiceParameter.booleanValue
		}
		return false
	}

	def createInterfaceObserver(GeneratorEntry it) {
		if (interfaceObserverSupportParameter !== null) {
			return interfaceObserverSupportParameter.booleanValue
		}
		return false
	}

	def useJavaInt(GeneratorEntry it) {
		if (useJavaIntForInteger !== null) {
			return useJavaIntForInteger.booleanValue
		}
		return false
	}
	
	def private getTracingFeature(GeneratorEntry it) {
		getFeatureConfiguration(IJavaFeatureConstants::FEATURE_TRACING)
	}
	
	def getTracingEnterState(GeneratorEntry it){
		val enterStateParameter = tracingFeature?.getParameterValue(IJavaFeatureConstants::PARAMETER_TRACING_ENTER_STATE)
		if (enterStateParameter !== null) {
			return enterStateParameter.booleanValue
		}
		return false
	}
	
	def getTracingExitState(GeneratorEntry it){
		val exitStateParameter = tracingFeature?.getParameterValue(IJavaFeatureConstants::PARAMETER_TRACING_EXIT_STATE)
		if (exitStateParameter !== null) {
			return exitStateParameter.booleanValue
		}
		return false
	}
	
	def tracingUsed(GeneratorEntry it) {
		return (tracingEnterState || tracingExitState)
	}
	
	def inEventQueue(GeneratorEntry it) {
		if(inEventQueueParameter !== null) {
			inEventQueueParameter.booleanValue
		} else {
			false
		}
	}
	
	def isSynchronized(GeneratorEntry it) {
		if(synchronizedParameter !== null) {
			synchronizedParameter.booleanValue
		} else {
			false
		}
	}
	
	def isRunnable(GeneratorEntry it) {
		if(runnableParameter !== null) {
			runnableParameter.booleanValue
		} else {
			false
		}
	}
}
