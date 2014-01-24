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
package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.sgraph.Event
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.sgen.GeneratorEntry

class Naming {
	
	@Inject extension Navigation
	
	@Inject extension ICodegenTypeSystemAccess
	
	@Inject private StextNameProvider provider
	
	@Inject extension INamingService
	
	@Inject GeneratorEntry entry
	
	@Inject extension GenmodelEntries
	
	def getFullyQualifiedName(State state) {
		provider.getFullyQualifiedName(state).toString.asEscapedIdentifier
	}
	
	def module(ExecutionFlow it) {
		if (entry.moduleName.nullOrEmpty) {
			return name.asIdentifier.toFirstUpper	
		}
		return entry.moduleName.toFirstUpper
	}
	
//	def module(InterfaceScope it) {
//		flow.type + (if (name.nullOrEmpty) 'Default' else name).asIdentifier.toFirstUpper	
//	}
	
	def client(String it) {
		it + "Required"	
	}
	
	def timerModule(ExecutionFlow it) {
		'sc_timer'	
	}
	
	def typesModule(ExecutionFlow it) {
		'sc_types'	
	}
	
	def timerType(ExecutionFlow it) {
		'SCTimer'
	}
	
	def statesEnumType(ExecutionFlow it) {
		flow.type + 'States'	
	}
	
	def dispatch type(InterfaceScope it) {
		flow.type + 'Iface' + (if (name.nullOrEmpty) '' else name).asIdentifier.toFirstUpper	
	}
	
	def dispatch type(InternalScope it) {
		flow.type + 'Internal'	
	}
	
	def dispatch type(Scope it) {
		flow.type + 'TimeEvents'	
	}
	
	def dispatch type(ExecutionFlow it) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			return name.asIdentifier.toFirstUpper	
		}
		return entry.statemachinePrefix.toFirstUpper
	}
	
	def dispatch instance(InterfaceScope it) {
		'iface' + (if (name.nullOrEmpty) '' else name).asIdentifier.toFirstUpper	
	}
	
	def dispatch instance(Scope it) {
		'timeEvents'
	}
	
	def dispatch instance(InternalScope it) {
		'internal'
	}
	
	def functionPrefix(Scope it) {
		if (!entry.statemachinePrefix.nullOrEmpty) {
			return entry.statemachinePrefix
		}
		return type.toFirstLower	
	}
	
	def functionPrefix(ExecutionFlow it) {
		if (!entry.statemachinePrefix.nullOrEmpty) {
			return entry.statemachinePrefix + separator
		}
		type.toFirstLower + separator
	}
	
	def separator() {
		var sep = entry.separator
		if (sep.nullOrEmpty) {
			sep = "_"
		}
		return sep
	}
	
	def clearInEventsFctID(ExecutionFlow it) {
		functionPrefix + "clearInEvents"
	}
	
	def clearOutEventsFctID(ExecutionFlow it) {
		functionPrefix + "clearOutEvents"
	}
	
	def dispatch last_state(ExecutionFlow it) {
		type + lastStateID
	}
	
	def dispatch last_state(Step it) {
		execution_flow.module + lastStateID
	}
	
	def lastStateID() {
		separator + "last" + separator + "state"
	} 
	
	def ExecutionFlow execution_flow(EObject element) {
		var ret = element;
		
		while (ret != null) {
			if (ret instanceof ExecutionFlow) {
				return ret as ExecutionFlow
			}
			else {
				ret = ret.eContainer;
			}	
		}
		return null;
	}

	def raiseTimeEventFctID(ExecutionFlow it) {
		functionPrefix + "raiseTimeEvent"
	}

	def isActiveFctID(ExecutionFlow it) {
		functionPrefix + "isActive"
	}

	def asRaiser(EventDefinition it) {
		scope.functionPrefix + separator + 'raise' + separator + name.asIdentifier.toFirstLower	
	}
	
	def asRaised(EventDefinition it) {
		scope.functionPrefix + separator + 'israised' + separator + name.asIdentifier.toFirstLower	
	}
	
	def asGetter(EventDefinition it) {
		scope.functionPrefix + separator + 'get' + separator + name.asIdentifier.toFirstLower + separator + 'value'
	}
	
	def asGetter(VariableDefinition it) {
		scope.functionPrefix + separator + 'get' + separator + name.asIdentifier.toFirstLower	
	}
	
	def asSetter(VariableDefinition it) {
		scope.functionPrefix + separator + 'set' + separator + name.asIdentifier.toFirstLower	
	}
	
	def asFunction(OperationDefinition it) {
		scope.functionPrefix + separator + name.asIdentifier.toFirstLower	
	}
	
	def raised(CharSequence it) { it + separator + 'raised' }
	
	def value(CharSequence it)  { it + separator + 'value' }
	
	def h(String it) { it + ".h" }
	
	def c(String it) { it + ".c" }
	
	def define(String it) { it.replaceAll('\\.', '_').toUpperCase }
		
	def dispatch scopeDescription(Scope it) '''scope'''
	
	def dispatch scopeDescription(InterfaceScope it) '''«IF name==null || name.empty»default interface scope«ELSE»interface scope '«name»'«ENDIF»'''
	
	def dispatch scopeDescription(InternalScope it) '''internal scope'''
	
	def scHandleDecl(EObject it) { flow.type + '* ' + scHandle }
	
	def scHandle() { 'handle' }
	
	def valueParams(EventDefinition it) {
		if (hasValue) ', ' + type.targetLanguageName + ' value' 
		else ''
	}
	
	def dispatch access (VariableDefinition it) 
		'''«scHandle»->«scope.instance».«name.asEscapedIdentifier»'''

	def dispatch access (OperationDefinition it) 
		'''«asFunction»'''
	
	def dispatch access (Event it) 
		'''«scHandle»->«scope.instance».«name.asIdentifier.raised»'''
				
	def dispatch access (EObject it) 
		'''#error cannot access elements of type «getClass().name»'''
	
	def valueAccess(Event it) 
		'''«scHandle»->«scope.instance».«name.asIdentifier.value»'''
}