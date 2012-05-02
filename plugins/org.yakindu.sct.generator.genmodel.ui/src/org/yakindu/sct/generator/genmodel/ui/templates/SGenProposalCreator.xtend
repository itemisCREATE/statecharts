/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.templates

import org.eclipse.emf.ecore.EObject
import org.yakindu.sct.generator.core.features.IDefaultFeatureValueProvider
import org.yakindu.sct.model.sgen.FeatureConfiguration
import org.yakindu.sct.model.sgen.FeatureParameter
import org.yakindu.sct.model.sgen.FeatureType
import org.yakindu.sct.model.sgen.ParameterTypes

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
class SGenProposalCreator {

	 def createProposal(FeatureType featureType, IDefaultFeatureValueProvider defaultProvider,
		EObject context){
			 var defaultConfiguration  = defaultProvider.createDefaultFeatureConfiguration(featureType,context)
			'''
			feature «featureType.name» {
				«FOR param :featureType.parameters»
				«param.name» = «defaultConfiguration.value(param)»
				«ENDFOR»
			}
			'''.toString
		}
		
	def value(FeatureConfiguration value, FeatureParameter param){
		 var defaultValue = value.getParameterValue(param.name)
		 if(defaultValue != null) {
		 	if(param.parameterType.equals(ParameterTypes::STRING))
		 		return ''' "«defaultValue.expression»" '''.toString
		 	else
		 		return defaultValue.expression
		 }
		 switch param.parameterType {
		 	case ParameterTypes::STRING:
		 		return "\"\""
		 	case ParameterTypes::BOOLEAN:
		 		return "false"
		 	case ParameterTypes::FLOAT:
		 		return "0.0"	
		 	case ParameterTypes::INTEGER:
		 		return "0"
		 }
		 null
		 
	}
	
		

}