/**
  Copyright (c) 2013 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Mühlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.cpp

import java.util.List
import org.eclipse.emf.ecore.EObject
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.sgraph.Event
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.TimeEvent

class Naming extends org.yakindu.sct.generator.c.Naming {
	
	@Inject extension Navigation;
	
	def hpp(String it) { it + ".hpp" }
	def cpp(String it) { it + ".cpp" }
	
	def abstractModule(ExecutionFlow it) {
		module() + 'Interface'	
	}
	
	def statemachineInterface() {
		'StatemachineInterface'
	}
	
	def orthogonalStatesConst() {
		'maxOrthogonalStates'
	}
	
	def historyStatesConst() {
		'maxHistoryStates'
	}
	
	def timedStatemachineInterface() {
		'TimedStatemachineInterface'
	}
	
	def timerServiceInterface() {
		'TimerServiceInterface'
	}
	
	def timerServiceInstance() {
		'timerService'
	}
	
	def timeEventsInstance() {
		'timeEvents'
	}
	
	override dispatch instance(InternalScope it) {
		'iface' + interfaceName.asIdentifier.toFirstUpper	
	}
	
	def dispatch String getInterfaceName(InterfaceScope it) {  
		if (name != null) {
			return "SCI" + name.toFirstUpper()
		}
		else {
			return "SCInterface";
		}
	}
	
	def dispatch String getInterfaceName(InternalScope it) {  
		"InternalSCIScope"
	}
	
	def String getInterfaceOperationCallbackName(InterfaceScope it) {
		interfaceName + "OperationCallback"
	}
	
	def String getInternalOperationCallbackName() {
		"InternalOperationCallback"
	}
	
	override asFunction(OperationDefinition it) {
		name.asIdentifier.toFirstLower	
	}
	
	override asRaiser(EventDefinition it) {
		'raise_' + name.asIdentifier.toFirstLower	
	}
	
	override asRaised(EventDefinition it) {
		'isRaised_' + name.asIdentifier.toFirstLower	
	}
	
	override asGetter(EventDefinition it) {
		'get_' + name.asIdentifier.toFirstLower	+ '_value'
	}
	
	override asGetter(VariableDefinition it) {
		'get_' + name.asIdentifier.toFirstLower	
	}
	
	override asSetter(VariableDefinition it) {
		'set_' + name.asIdentifier.toFirstLower	
	}
	
	override functionName(EObject it, List<String> segments) {
		segments.fold("", [s, seg | s + if (seg.empty) "" else "_" + seg]).asIdentifier
	}
	
	override nameOfRaiseTimeEventFunction(ExecutionFlow it) {
		"raiseTimeEvent"
	}
	
	override nameOfIsActiveFunction(ExecutionFlow it) {
		"isActive"
	}
	

	override dispatch access (OperationDefinition it) 
		'''«asFunction»'''
		
	def dispatch access(TimeEvent it)
		'''«timeEventsInstance»[«indexOf»]'''
		
	override dispatch access (VariableDefinition it) 
		'''«scope.instance»->«name.asEscapedIdentifier»'''
	
	override dispatch access (Event it) 
		'''«scope.instance»->«name.asIdentifier.raised»'''
	
	override valueAccess(Event it) 
		'''«scope.instance»->«name.asIdentifier.value»'''
		
	def dispatch localAccess (VariableDefinition it) 
		'''«name.asEscapedIdentifier»'''
	
	def dispatch localAccess (Event it) 
		'''«name.asIdentifier.raised»'''
	
	def localValueAccess(Event it) 
		'''«name.asIdentifier.value»'''
}