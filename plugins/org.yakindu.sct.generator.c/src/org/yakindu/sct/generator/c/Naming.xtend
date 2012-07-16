package org.yakindu.sct.generator.c

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.InterfaceScope
import com.google.inject.Inject
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.OperationDefinition

class Naming {

	@Inject extension Navigation
	
	def module(ExecutionFlow it) {
		name.asIdentifier.toFirstUpper	
	}
	
	def client(String it) {
		it + "Required"	
	}
	
	def timerModule(ExecutionFlow it) {
		'sc_timer'	
	}
	
	def typesModule(ExecutionFlow it) {
		'sc_types'	
	}
	
	def dispatch type(ExecutionFlow it) {
		name.asIdentifier.toFirstUpper	
	}
	
	def timerType(ExecutionFlow it) {
		'SCTimer'
	}
	
	def statesEnumType(ExecutionFlow it) {
		module + 'States'	
	}
	
	def module(InterfaceScope it) {
		flow.module + (if (name == null || name.empty) 'Default' else name).asIdentifier.toFirstUpper	
	}
	
	def dispatch type(InterfaceScope it) {
		flow.module + 'Iface' + (if (name == null || name.empty) '' else name).asIdentifier.toFirstUpper	
	}
	
	def dispatch instance(InterfaceScope it) {
		'iface' + (if (name == null || name.empty) '' else name).asIdentifier.toFirstUpper	
	}
	
	def dispatch instance(Scope it) {
		'timeEvents'
	}
	
	def dispatch type(InternalScope it) {
		flow.module + 'Internal'	
	}
	
	def dispatch type(Scope it) {
		flow.module + 'TimeEvents'	
	}
	
	def dispatch instance(InternalScope it) {
		'internal'
	}
	
	def functionPrefix(Scope it) {
		type.toFirstLower	
	}


	def asRaiser(EventDefinition it) {
		scope.functionPrefix + '_raise_' + name.asIdentifier.toFirstLower	
	}
	
	def asRaised(EventDefinition it) {
		scope.functionPrefix + '_israised_' + name.asIdentifier.toFirstLower	
	}
	
	def asGetter(EventDefinition it) {
		scope.functionPrefix + '_get_' + name.asIdentifier.toFirstLower	+ '_value'
	}
	
	def asGetter(VariableDefinition it) {
		scope.functionPrefix + '_get_' + name.asIdentifier.toFirstLower	
	}
	
	def asSetter(VariableDefinition it) {
		scope.functionPrefix + '_set_' + name.asIdentifier.toFirstLower	
	}

	def asFunction(OperationDefinition it) {
		scope.functionPrefix + '_' + name.asIdentifier.toFirstLower	
	}
	
	
	def h(String it) { it + ".h" }
	def c(String it) { it + ".c" }
	
	def define(String it) { it.replaceAll('\\.', '_').toUpperCase }
	
	
	def asIdentifier(String it) {
		replaceAll('[^a-z&&[^A-Z&&[^0-9]]]', '_')
	}
	
	
	def dispatch scopeDescription(Scope it) '''scope'''
	
	def dispatch scopeDescription(InterfaceScope it) '''«IF name==null || name.empty»default interface scope«ELSE»interface scope '«name»'«ENDIF»'''
	def dispatch scopeDescription(InternalScope it) '''internal scope'''
}