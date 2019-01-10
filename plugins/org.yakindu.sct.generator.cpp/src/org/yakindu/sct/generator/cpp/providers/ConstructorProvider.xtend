/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.providers

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.generator.cpp.files.StatemachineImplementation
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.sct.generator.c.types.CLiterals

@GeneratorContribution(StatemachineImplementation.SOURCE_TARGET)
class ConstructorProvider implements ISourceFragment {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension CLiterals
	
	@Inject protected GeneratorEntry entry
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		'''
		«constructorDefinition»
		
		«destructorDefinition»
		'''
	}
	
	override orderPriority(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		-1
	}
	
	def constructorDefinition(ExecutionFlow it){
	'''
		«module»::«module»():
			«initialisationList»
		{
			«constructorBody(it)»
		}
	'''
	}
	
	def protected initialisationList(ExecutionFlow it) {
		'''
			«IF timed»«timerInstance»(«NULL_LITERAL»),«ENDIF»
			«STATEVECTOR_POS»(0)«FOR s : getInterfaces»,
			«s.instance»()«IF s.hasOperations && !entry.useStaticOPC»,
			«s.OCB_Instance»(«NULL_LITERAL»)«ENDIF»«ENDFOR»«IF entry.tracingUsed»,
			«tracingInstance»(0)«ENDIF»
		'''
	}
	
	def protected initialisationListCopy(ExecutionFlow it) {
		'''
			«IF timed»«timerInstance»(rhs.«timerInstance»),«ENDIF»
			«STATEVECTOR_POS»(rhs.«STATEVECTOR_POS»)«FOR s : getInterfaces»,
			«s.instance»(rhs.«s.instance»)«IF s.hasOperations && !entry.useStaticOPC»,
			«s.OCB_Instance»(rhs.«s.OCB_Instance»)«ENDIF»«ENDFOR»
		'''	
	}
	
	protected def CharSequence constructorBody(ExecutionFlow it)
		'''
		«IF hasHistory»
			for («USHORT_TYPE» i = 0; i < «historyStatesConst»; ++i)
				«HISTORYVECTOR»[i] = «null_state»;
				
		«ENDIF»
		'''
	
	
	def destructorDefinition(ExecutionFlow it) '''
		«module»::~«module»()
		{
		}
	'''
	
}