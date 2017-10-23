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
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.classes.StatechartClass
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.StatechartScope

class StatemachineHeader extends org.yakindu.sct.generator.c.StatemachineHeader {

	@Inject protected extension CppNaming
	@Inject protected extension Navigation
	@Inject protected extension GenmodelEntriesExtension

	protected GeneratorEntry entry
	
	@Accessors protected StatechartClass statechartClass

	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) {
		this.entry = entry
		'''
			«entry.licenseText»
			
			#ifndef «module().define»_H_
			#define «module().define»_H_
			
			«FOR include : statechartClass.requiredHeaders»
			«include»
			«ENDFOR»
			
			/*! \file Header of the state machine '«name»'.
			*/
			
			«preStatechartDeclarations»
			
			/*! Define indices of states in the StateConfVector */
			«FOR state : states»
				#define «state.stateVectorDefine» «state.stateVector.offset»
			«ENDFOR»
			
			«generateClass(artifactConfigs)»
			
			«IF !entry.useStaticOPC»
				«scopes.filter(typeof(StatechartScope)).map[createInlineOCB_Destructor].filterNullOrEmptyAndJoin»
			«ENDIF»
			
			«postStatechartDeclarations»
			
			#endif /* «module().define»_H_ */
		'''
	}
	
	def protected generateClass(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
			statechartClass?.declare
	}

	def protected CharSequence createInlineOCB_Destructor(StatechartScope it) {
		if (hasOperations) {
			return '''inline «flow.module»::«interfaceOCBName»::~«interfaceOCBName»() {}'''
		}
		return ''''''
	}
}
