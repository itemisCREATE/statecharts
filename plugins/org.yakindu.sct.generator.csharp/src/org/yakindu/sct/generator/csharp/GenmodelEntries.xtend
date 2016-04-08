/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.csharp

import com.google.inject.Inject
import org.yakindu.sct.generator.core.features.ICoreFeatureConstants
import org.yakindu.sct.generator.csharp.features.ICSharpFeatureConstants
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.FeatureParameterValue
import org.yakindu.sct.model.sgen.GeneratorEntry

class GenmodelEntries {

	@Inject extension Naming

	def private getLicenseFeature(GeneratorEntry it) {
		getFeatureConfiguration(ICoreFeatureConstants::LICENSE_HEADER)
	}

	def private getNamingFeature(GeneratorEntry it) {
		getFeatureConfiguration(ICSharpFeatureConstants::NAMING_FEATURE)
	}

	def private getGeneralFeatures(GeneratorEntry it) {
		getFeatureConfiguration(ICSharpFeatureConstants::GENERAL_FEATURES)
	}
	
	def private FeatureParameterValue getNamespaceNameParameter(GeneratorEntry it) {
		namingFeature?.getParameterValue(ICSharpFeatureConstants::NAMESPACE_NAME)
	}
	
	def private FeatureParameterValue getImplementationSuffixParameter(GeneratorEntry it) {
		namingFeature?.getParameterValue(ICSharpFeatureConstants::IMPLEMENTATION_SUFFIX)
	}

	def private FeatureParameterValue getLicenseTextParameter(GeneratorEntry it) {
		licenseFeature?.getParameterValue(ICoreFeatureConstants::LICENSE_TEXT)
	}

	def private FeatureParameterValue getTimerServiceParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(ICSharpFeatureConstants::TIMER_SERVICE)
	}

	def private FeatureParameterValue getRuntimeServiceParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(ICSharpFeatureConstants::RUNTIME_SERVICE)
	}

	def private FeatureParameterValue getInterfaceObserverSupportParameter(GeneratorEntry it) {
		generalFeatures?.getParameterValue(ICSharpFeatureConstants::INTERFACE_OBSERVER_SUPPORT)
	}

	def private FeatureParameterValue getUseCSharpIntForInteger(GeneratorEntry it) {
		generalFeatures?.getParameterValue(ICSharpFeatureConstants::USE_CSHARP_INT_FOR_INTEGER)
	}

	def getLicenseText(GeneratorEntry it) {
		if (licenseTextParameter != null) {
			return "/**" + licenseTextParameter.stringValue + "*/"
		}
		return null
	}

	def getNamespaceName(GeneratorEntry it) {
		if (namespaceNameParameter != null) {
			return namespaceNameParameter.stringValue
		}
		return "Yakindu.SCR"
	}

	def getImplementationSuffix(GeneratorEntry it, ExecutionFlow flow) {
		if (implementationSuffixParameter != null) {
			return flow.statemachineName + implementationSuffixParameter.stringValue
		}
		return flow.statemachineName
	}

	def getImplementationPackageName(ExecutionFlow it, GeneratorEntry entry) {
		entry.namespaceName + "." + entry.getImplementationSuffix(it).toLowerCase();
	}

	def getBasePackagePath(GeneratorEntry it) {
		return namespaceName.replace('.', '/')
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

	def useCSharpInt(GeneratorEntry it) {
		if (useCSharpIntForInteger != null) {
			return useCSharpIntForInteger.booleanValue
		}
		return false
	}
}
