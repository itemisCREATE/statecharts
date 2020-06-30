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
import org.yakindu.sct.model.stext.stext.StatechartScope
import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.base.types.typesystem.ITypeValueProvider
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Event
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.TypeAlias
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Type
import org.yakindu.sct.model.sgraph.util.StatechartUtil

class ConstructorProvider implements ISourceFragment {

	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension GenmodelEntriesExtension
	@Inject protected extension CLiterals
	@Inject protected extension INamingService
	@Inject protected extension ShadowEventExtensions
	@Inject protected GeneratorEntry entry
	@Inject protected extension ITypeValueProvider
	@Inject protected extension StatechartUtil

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

	def constructorDefinition(ExecutionFlow it) {
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
		interfaces.forEach [
			toInit.add(instance, NULL_LITERAL)
			if (hasOperations && !entry.useStaticOPC) {
				toInit.add(OCB_Instance, NULL_LITERAL)
			}
		]
		properties.forEach[p | toInit.add(p.name.asEscapedIdentifier, p.type.initialValue)]
		toInit
	}

	def protected initialisationList(ExecutionFlow flow, StatechartScope it) {
		val List<Pair<String, String>> toInit = newArrayList
		declarations.forEach[d|toInit.add(d)]
		toInit.add('''«parent»''', '''«parent»''')
		shadowEvents.forEach[toInit.add('''«observer»''', "this")]
		return toInit
	}

	def dispatch add(List<Pair<String, String>> toInit, Declaration it) {}

	def dispatch add(List<Pair<String, String>> toInit, VariableDefinition it) {
		if (!isConst) {
			toInit.add(localAccess.toString, type.initialValue)
		}
	}

	def dispatch add(List<Pair<String, String>> toInit, Event it) {
		toInit.add(localAccess.toString, "false")
		if (hasValue) {
			toInit.add(localValueAccess.toString, type.initialValue)
		}
	}

	def dispatch initialValue(Type it) {
		defaultValue?.toString ?: NULL_LITERAL
	}

	def dispatch initialValue(EnumerationType it) {
		if (multiSM) {
			return enumerator.head.stateEnumAccess
		}
		enumerator.head.enumeratorAccess.toString
	}

	def dispatch initialValue(ComplexType it) {
		""
	}

	def dispatch String initialValue(TypeAlias it) {
		type.initialValue
	}

	def protected initialisationListCopy(ExecutionFlow it) {
		val List<Pair<String, String>> toInit = newArrayList
		if(timed) toInit.add(timerInstance, '''rhs.«timerInstance»''')
		toInit.add(STATEVECTOR_POS, '''rhs.«STATEVECTOR_POS»''')
		interfaces.forEach [
			toInit.add(instance, '''rhs.«instance»''')
			if (hasOperations && !entry.useStaticOPC) {
				toInit.add(OCB_Instance, '''rhs.«OCB_Instance»''')
			}
		]
		toInit
	}

	protected def CharSequence constructorBody(ExecutionFlow it) '''
		«IF hasHistory»
			for («USHORT_TYPE» i = 0; i < «historyStatesConst»; ++i)
				«HISTORYVECTOR»[i] = «null_state»;
		«ENDIF»
		«FOR iface : interfaces»
			this->«iface.instance».«parent» = this;
		«ENDFOR»
	'''

	protected def CharSequence constructorBody(ExecutionFlow it, StatechartScope iface) '''
	'''

	def destructorDefinition(ExecutionFlow it) '''
		«module»::~«module»()
		{
		}
	'''

	def protected generate(List<Pair<String, String>> values) {
		values.join(" :\n", ",\n", "", ['''«it.key»(«it.value»)'''])
	}

	def protected Pair<String, String> pair(String a, String b) {
		return new Pair<String, String>(a, b)
	}

	def protected void add(List<Pair<String, String>> l, String a, String b) {
		l.add(pair(a, b))
	}
}
