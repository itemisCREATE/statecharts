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

import org.yakindu.sct.model.sgen.FeatureParameterValue
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.core.library.ICoreLibraryConstants.*
import static org.yakindu.sct.generator.java.features.IJavaFeatureConstants.*
import org.yakindu.sct.model.sgraph.Statechart
import com.google.inject.Inject

class GenmodelEntries {

	@Inject extension Naming

	def private getLicenseFeature(GeneratorEntry it) {
		getFeatureConfiguration(LICENSE_HEADER)
	}

	def private getNamingFeature(GeneratorEntry it) {
		getFeatureConfiguration(NAMING_FEATURE)
	}

	def private getGeneralFeatures(GeneratorEntry it) {
		getFeatureConfiguration(GENERAL_FEATURES)
	}

	def private getOutletFeatures(GeneratorEntry it) {
		getFeatureConfiguration(OUTLET_FEATURE)
	}

	def private FeatureParameterValue getOutletFeatureTargetProject(GeneratorEntry it) {
		outletFeatures.getParameterValue(OUTLET_FEATURE_TARGET_PROJECT)
	}

	def private FeatureParameterValue getBasePackageParameter(GeneratorEntry it) {
		namingFeature?.getParameterValue(BASE_PACKAGE)
	}
	
	def private FeatureParameterValue getApiPackageParameter(GeneratorEntry it) {
		namingFeature?.getParameterValue(API_PACKAGE)
	}
	
	def private FeatureParameterValue getLibraryPackageParameter(GeneratorEntry it) {
		namingFeature?.getParameterValue(LIBRARY_PACKAGE)
	}

	def private FeatureParameterValue getTypeNameParameter(GeneratorEntry it) {
		namingFeature?.getParameterValue(TYPE_NAME)
	}

	def private FeatureParameterValue getLicenseTextParameter(GeneratorEntry it) {
		licenseFeature?.getParameterValue(LICENSE_TEXT)
	}

	def private FeatureParameterValue getTimerServiceParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(TIMER_SERVICE)
	}

	def private FeatureParameterValue getRuntimeServiceParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(RUNTIME_SERVICE)
	}

	def private FeatureParameterValue getInterfaceObserverSupportParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(INTERFACE_OBSERVER_SUPPORT)
	}

	def private FeatureParameterValue getUseJavaIntForInteger(GeneratorEntry it) {
		generalFeatures?.getParameterValue(USE_JAVA_INT_FOR_INTEGER)
	}
	
	def private FeatureParameterValue getInEventQueueParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(IN_EVENT_QUEUE)
	}
	
	def private FeatureParameterValue getSynchronizedParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(SYNCHRONIZED)
	}
	
	def private FeatureParameterValue getRunnableParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(RUNNABLE)
	}

	def getLicenseText(GeneratorEntry it) {
		if (licenseTextParameter !== null)
			"/** " + licenseTextParameter.stringValue.trim + " */"
		else
			LICENSE_STANDARD_TEXT
	}

	def getBasePackage(GeneratorEntry it) {
		(basePackageParameter?.stringValue ?: BASE_PACKAGE_DEFAULT).dot(statechart.namespace)
	}

	def getApiPackage(GeneratorEntry it) {
		if (apiPackageParameter !== null)
			apiPackageParameter?.stringValue.dot(statechart.namespace)
		else
			basePackage
	}
	
	def getLibraryPackage(GeneratorEntry it) {
		libraryPackageParameter?.stringValue ?: LIBRARY_PACKAGE_DEFAULT
	}

	def toPath(String packageName) {
		packageName.replace('.', '/')
	}
	
	def getTypeName(GeneratorEntry it) {
		typeNameParameter?.stringValue
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
		getFeatureConfiguration(FEATURE_TRACING)
	}
	
	def getTracingEnterState(GeneratorEntry it){
		val enterStateParameter = tracingFeature?.getParameterValue(PARAMETER_TRACING_ENTER_STATE)
		if (enterStateParameter !== null) {
			return enterStateParameter.booleanValue
		}
		return false
	}
	
	def getTracingExitState(GeneratorEntry it){
		val exitStateParameter = tracingFeature?.getParameterValue(PARAMETER_TRACING_EXIT_STATE)
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
	
	def getStatechart(GeneratorEntry it) {
		elementRef as Statechart
	}
}
