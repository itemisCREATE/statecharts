/**
 *   Copyright (c) 2013-2017 committers of YAKINDU and others.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *  
 *   Contributors:
 *   	Markus Mühlbrandt - Initial contribution and API
 */
 
package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import java.util.List
import org.yakindu.base.types.Event
import org.yakindu.base.types.Parameter
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.generator.cpp.features.GenmodelEntriesExtension
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.sexec.transformation.SgraphExtensions
import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*
import static org.yakindu.sct.generator.c.CGeneratorConstants.*

/**
 * @author Markus Mühlbrands - Initial contribution and API
 * @author Axel Terfloth - updates
 */
class CppNaming extends Naming {

	@Inject protected extension SExecExtensions
	@Inject protected extension SgraphExtensions
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject protected extension INamingService
	@Inject protected extension GenmodelEntriesExtension
	@Inject GeneratorEntry entry

	def cpp(String it) { it + ".cpp" }

	def abstractModule(ExecutionFlow it) {
		module() + 'Interface'
	}

	def statemachineInterface() {
		SM_INTERFACE
	}
	
	def statesCountConst() {
		STATES_COUNT
	}

	def orthogonalStatesConst() {
		MAX_ORTHOGONAL_STATES
	}

	def historyStatesConst() {
		MAX_HISTORY_STATES
	}

	def timedStatemachineInterface() {
		SM_TIMED_INTERFACE
	}

	def timerInterface() {
		TIMER_INTERFACE
	}

	def timerInstance() {
		TIMER
	}

	def timeEventsCountConst() {
		TIME_EVENTS_COUNT
	}

	def timeEventsCountparallelConst() {
		PARALLEL_TIME_EVENTS_COUNT
	}

	def timeEventsInstance() {
		TIME_EVENTS
	}
	
	override enterStateTracingFctID(ExecutionFlow it) {
		STATE_ENTERED
	}
	
	override exitStateTracingFctID(ExecutionFlow it) {
		STATE_EXITED
	}
	
	override dispatch scopeTypeDeclMember(VariableDefinition it) '''
		«IF type.name != 'void'»«IF const»static const «ENDIF»«typeSpecifier.targetLanguageName» «name.asEscapedIdentifier»;«ENDIF»
	'''

	def protected signature(OperationDefinition it) '''
	«typeSpecifier.targetLanguageName» «name.asEscapedIdentifier»(«FOR parameter : parameters SEPARATOR ', '»«IF parameter.isVarArgs»...«ELSE»«parameter.typeSpecifier.
		targetLanguageName» «parameter.identifier»«ENDIF»«ENDFOR»)'''

	def protected OCB_InterfaceSetterDeclaration(StatechartScope scope, boolean fqn) '''
	void «IF fqn»«scope.flow.module»::«ENDIF»set«scope.interfaceOCBName»(«scope.interfaceOCBName»* operationCallback)'''

	def protected identifier(Parameter parameter) {
		if (parameter.name.isKeyword) {
			return parameter.name + "Arg"
		} else {
			parameter.name
		}
	}

	override dispatch instance(InternalScope it) {
		'iface' + interfaceName.asIdentifier.toFirstUpper
	}

	def OCB_Instance(Scope it) {
		it.instance + "_OCB"
	}
	
	def tracingInstance(ExecutionFlow it) {
		"iface_TR"
	}

	def dispatch String getInterfaceName(Scope it) '''
		no interfaceName for «it»
	'''

	def dispatch String getInterfaceName(InterfaceScope it) {
		if (name !== null) {
			return "SCI_" + name.toFirstUpper()
		} else {
			return "DefaultSCI";
		}
	}

	def dispatch String getInterfaceName(InternalScope it) {
		"InternalSCI"
	}

	def dispatch String getSimpleName(InterfaceScope it) {
		if (name !== null) {
			return name
		} else {
			return "default";
		}
	}

	def dispatch String getSimpleName(InternalScope it) {
		"internal"
	}

	def String getInterfaceOCBName(StatechartScope it) {
		interfaceName + "_OCB"
	}

	override asFunction(OperationDefinition it) {
		name.asEscapedIdentifier
	}
	
	override enterFctID(ExecutionFlow it) {
		ENTER
	}
	
	override exitFctID(ExecutionFlow it) {
		EXIT
	}
	
	override initFctID(ExecutionFlow it) {
		INIT
	}
	
	override runCycleFctID(ExecutionFlow it) {
		RUN_CYCLE
	}
	
	override isActiveFctID(ExecutionFlow it) {
		IS_ACTIVE
	}
	
	override asRaiser(EventDefinition it) {
		'raise_' + name.asIdentifier.toFirstLower
	}

	override asRaised(EventDefinition it) {
		'isRaised_' + name.asIdentifier.toFirstLower
	}

	override asGetter(EventDefinition it) {
		'get_' + name.asIdentifier.toFirstLower + '_value'
	}

	override asGetter(VariableDefinition it) {
		'get_' + name.asIdentifier.toFirstLower
	}

	override asSetter(VariableDefinition it) {
		'set_' + name.asIdentifier.toFirstLower
	}

	override raiseTimeEventFctID(ExecutionFlow it) {
		RAISE_TIME_EVENT
	}

	override isStateActiveFctID(ExecutionFlow it) {
		IS_STATE_ACTIVE
	}
	
	override isFinalFctID(ExecutionFlow it) {
		IS_FINAL
	}

	override dispatch access(OperationDefinition it) {
		if (entry.useStaticOPC) {
			return '''«(scope as StatechartScope).interfaceOCBName»::«asFunction»'''
		}
		return '''«scope.OCB_Instance»->«asFunction»'''
	}

	override dispatch access(TimeEvent it) '''«timeEventsInstance»[«indexOf»]'''

	override dispatch access(VariableDefinition it) {
		if (const) {
			return '''«flow.module»::«scope.interfaceName»::«name.asEscapedIdentifier»'''
		} else {
			return '''«scope.instance».«name.asEscapedIdentifier»'''
		}
	}

	override dispatch access(Event it) '''«scope.instance».«name.asIdentifier.raised»'''

	override valueAccess(Event it) '''«scope.instance».«name.asIdentifier.value»'''

	def dispatch localAccess(VariableDefinition it) '''«name.asEscapedIdentifier»'''

	def dispatch localAccess(Event it) '''«name.asIdentifier.raised»'''

	def localValueAccess(Event it) '''«name.asIdentifier.value»'''

	override valueParams(EventDefinition it) {
		if (hasValue)
			typeSpecifier.targetLanguageName + ' value'
		else
			''
	}
	
	def tracingModule(ExecutionFlow it) {
		module + '_TR'
	}
	
	def List<String> statechartNamespace(ExecutionFlow it) {
		val sct = statechart
		if(sct === null) {
			return emptyList
		}
		var ns = sct.namespace
		if(ns === null || ns == "") {
			return emptyList
		}
		return newArrayList(ns.replace(".", "::").replace("/", "::").split("::").filter[!nullOrEmpty])
	}
}
