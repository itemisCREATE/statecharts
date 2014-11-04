/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import org.yakindu.sct.generator.core.features.ICoreFeatureConstants
import org.yakindu.sct.generator.java.features.IJavaFeatureConstants
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.FeatureParameterValue
import org.yakindu.sct.model.sgen.GeneratorEntry

class GenmodelEntries {

	@Inject extension Naming

	def private getLicenseFeature(GeneratorEntry it) {
		getFeatureConfiguration(ICoreFeatureConstants::LICENSE_HEADER)
	}

	def private getNamingFeature(GeneratorEntry it) {
		getFeatureConfiguration(IJavaFeatureConstants::NAMING_FEATURE)
	}

	def private getGeneralFeatures(GeneratorEntry it) {
		getFeatureConfiguration(IJavaFeatureConstants::GENERAL_FEATURES)
	}

	def private FeatureParameterValue getBasePackageParameter(GeneratorEntry it) {
		namingFeature?.getParameterValue(IJavaFeatureConstants::BASE_PACKAGE)
	}
	
	def private FeatureParameterValue getImplementationSuffixParameter(GeneratorEntry it) {
		namingFeature?.getParameterValue(IJavaFeatureConstants::IMPLEMENTATION_SUFFIX)
	}

	def private FeatureParameterValue getLicenseTextParameter(GeneratorEntry it) {
		licenseFeature?.getParameterValue(ICoreFeatureConstants::LICENSE_TEXT)
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

	def getLicenseText(GeneratorEntry it) {
		if (licenseTextParameter != null) {
			return "/**" + licenseTextParameter.stringValue + "*/"
		}
		return null
	}

	def getBasePackageName(GeneratorEntry it) {
		if (basePackageParameter != null) {
			return basePackageParameter.stringValue
		}
		return "org.yakindu.scr"
	}

	def getImplementationSuffix(GeneratorEntry it, ExecutionFlow flow) {
		if (implementationSuffixParameter != null) {
			return flow.statemachineName + implementationSuffixParameter.stringValue
		}
		return flow.statemachineName
	}

	def getImplementationPackageName(ExecutionFlow it, GeneratorEntry entry) {
		entry.basePackageName + "." + entry.getImplementationSuffix(it).toLowerCase();
	}

	def getBasePackagePath(GeneratorEntry it) {
		return basePackageName.replace('.', '/')
	}

	def getImplementationPackagePath(ExecutionFlow it, GeneratorEntry entry) {
		getImplementationPackageName(entry).replace('.', '/')

	//entry.basePackagePath+"/"+entry.getImplementationSuffix(it).toLowerCase
	}

	def createTimerService(GeneratorEntry it) {
		if (timerServiceParameter != null) {
			return timerServiceParameter.booleanValue
		}
		return false
	}

	def createRuntimeService(GeneratorEntry it) {
		if (runtimeServiceParameter != null) {
			return runtimeServiceParameter.booleanValue
		}
		return false
	}

	def createInterfaceObserver(GeneratorEntry it) {
		if (interfaceObserverSupportParameter != null) {
			return interfaceObserverSupportParameter.booleanValue
		}
		return false
	}

	def useJavaInt(GeneratorEntry it) {
		if (useJavaIntForInteger != null) {
			return useJavaIntForInteger.booleanValue
		}
		return false
	}
}
