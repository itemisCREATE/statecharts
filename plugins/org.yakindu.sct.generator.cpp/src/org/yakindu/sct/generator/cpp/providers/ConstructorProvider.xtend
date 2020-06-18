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
import org.yakindu.sct.model.sexec.extensions.ShadowEventExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.lib.StatechartAnnotations
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.base.types.TypedDeclaration
import org.yakindu.base.types.typesystem.ITypeValueProvider
import org.eclipse.emf.ecore.EObject
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Event
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.TypeAlias

class ConstructorProvider implements ISourceFragment {
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension CLiterals
	@Inject protected extension StatechartAnnotations
	@Inject protected extension INamingService	
	@Inject protected extension ShadowEventExtensions
	@Inject protected GeneratorEntry entry
	@Inject protected extension ITypeValueProvider
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		'''
		«constructorDefinition»
		
		«destructorDefinition»
		
		«FOR iface : interfaces»
			«it.ifaceConstructorDefintion(iface)»
			
		«ENDFOR»
		'''
	}
	
	def ifaceConstructorDefintion(ExecutionFlow it, StatechartScope iface) {
		'''
		«module»::«iface.interfaceName»::«iface.interfaceName»(«module»* «parent»)«initialisationList(iface).generate»
		{
			«constructorBody(iface)»
		}
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
			toInit.add(instance, NULL_LITERAL)
			if(hasOperations && !entry.useStaticOPC) {
				toInit.add(OCB_Instance, NULL_LITERAL)
			}
		]
		toInit
	}
	
	def protected initialisationList(ExecutionFlow flow, StatechartScope it) {
		val List<Pair<String, String>> toInit = newArrayList
		
		for(d : declarations.filter(TypedDeclaration).filter[it instanceof VariableDefinition || it instanceof Event]) {
			var add = true
			if(d instanceof VariableDefinition) {
				if(d.const){
					add = false
				}
			} if(add) {
				if(d instanceof Event) {
					println(d.name)
				}
				toInit.add(d.localAccess.toString, d.type?.defaultValue?.toString?:d.NULL_LITERAL)
				
				if(d.hasValue) {
					if(d.type instanceof ComplexType) {
						
					} else {
						toInit.add(d.localValueAccess.toString, d.type.defaultValue?.toString?:d.eventDefaultValue)
					}
				}
			}
		}
		toInit.add('''«parent»''','''«parent»''')
		shadowEvents.forEach[toInit.add('''«observer»''', "this")]
		return toInit
	}
	
	def String eventDefaultValue(TypedDeclaration it) {
		val type = type
		switch type {
			EnumerationType case type:
				return '''«(type as EnumerationType).enumerator.head.stateEnumAccess»'''
			TypeAlias case type: {
				val typeAlias = type.typeSpecifier.type
				switch typeAlias {
					EnumerationType case typeAlias: return '''«typeAlias.enumerator.head.access»'''
					ComplexType case typeAlias: return ""
					default: return NULL_LITERAL
				}
			}
			ComplexType case type:
				return ""
			default:
				return NULL_LITERAL
		}
	}
	
	
	def private dispatch NULL_LITERAL(EventDefinition it) {
		return "false"
	}
	
	def private dispatch NULL_LITERAL(EObject it) {
		NULL_LITERAL
	}
	
	def private dispatch NULL_LITERAL(TypedDeclaration it) {
		val type = type
		switch type{
			EnumerationType case type: 
				return '''«type.enumerator.head.stateEnumAccess»'''
			TypeAlias case type: {
				val typeAlias = type.typeSpecifier.type
				switch typeAlias {
					EnumerationType case typeAlias: return '''«typeAlias.enumerator.head.enumeratorAccess»'''
					ComplexType case typeAlias: return ""
					default: return NULL_LITERAL
				}
			}
			ComplexType case type:
				return ""
			default: 
				return NULL_LITERAL
		}
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
		«FOR iface : interfaces»
			this->«iface.instance».«parent» = this;
		«ENDFOR»
		'''
	
	protected def CharSequence constructorBody(ExecutionFlow it, StatechartScope iface) 
	'''
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