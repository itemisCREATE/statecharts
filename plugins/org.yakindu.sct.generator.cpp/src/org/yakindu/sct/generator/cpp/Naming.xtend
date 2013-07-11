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

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

class Naming extends org.yakindu.sct.generator.c.Naming {
	
	def hpp(String it) { it + ".hpp" }
	def cpp(String it) { it + ".cpp" }
	
	def abstractModule(ExecutionFlow it) {
		'I'+module()
	}
	
	def iStatemachine() {
		'IStatemachine'
	}
	
	def iTimedStatemachine() {
		'ITimedStatemachine'
	}
	
	def iTimerService() {
		'ITimerService'
	}
	
	def timeEvent() {
		'TimeEvent'
	}
	
	def String getInterfaceName(InterfaceScope it) {  
		if (name != null) {
			return "SCI" + name.toFirstUpper()
		}
		else {
			return "SCInterface";
		}
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
}