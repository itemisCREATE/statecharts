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
import java.util.List
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.sct.model.stext.lib.StatechartAnnotations

class ConstructorProvider implements ISourceFragment {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension CLiterals
	@Inject protected extension StatechartAnnotations
	
	@Inject protected GeneratorEntry entry
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		'''
		«constructorDefinition»
		
		«destructorDefinition»
		'''
	}
	
	def constructorDefinition(ExecutionFlow it){
	'''
		«module»::«module»() «initialisationList.generate»
		{
			«constructorBody(it)»
		}
	'''
	}
	
	def protected initialisationList(ExecutionFlow it) {
		val List<Pair<String, String>> toInit = newArrayList
		if(timed) toInit.add(timerInstance, NULL_LITERAL)
		if(entry.tracingUsed) toInit.add(tracingInstance, "0")
		toInit.add(STATEVECTOR_POS, "0")
		if(statechart.isSuperStep) toInit.add(STATEVECTOR_CHANGED, "false")
		interfaces.forEach[
			toInit.add(instance, "")
			if(hasOperations && !entry.useStaticOPC) {
				toInit.add(OCB_Instance, NULL_LITERAL)
			}
		]
		toInit
	}
	
	def protected initialisationListCopy(ExecutionFlow it) {
		val List<Pair<String, String>> toInit = newArrayList
		if(timed) toInit.add(timerInstance, '''rhs.«timerInstance»''')
		toInit.add(STATEVECTOR_POS, '''rhs.«STATEVECTOR_POS»''')
		if(statechart.isSuperStep) toInit.add(STATEVECTOR_CHANGED, '''rhs.«STATEVECTOR_CHANGED»''')
		interfaces.forEach[
			toInit.add(instance, '''rhs.«instance»''')
			if(hasOperations && !entry.useStaticOPC) {
				toInit.add(OCB_Instance, '''rhs.«OCB_Instance»''')
			}
		]
		toInit
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
	
	def protected generate(List<Pair<String,String>> values) {
		values.join(" :\n", ",\n", "", ['''«it.key»(«it.value»)'''])
	}
	
	def protected Pair<String, String> pair(String a, String b) {
		return new Pair<String, String>(a, b)
	}
	
	def protected void add(List<Pair<String, String>> l, String a, String b) {
		l.add(pair(a, b))
	}
	
}