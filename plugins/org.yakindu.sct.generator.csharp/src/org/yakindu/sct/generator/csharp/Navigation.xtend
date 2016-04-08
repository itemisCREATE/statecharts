/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Commiters of Yakindu - Initial contribution and API
 */
package org.yakindu.sct.generator.csharp

import java.util.ArrayList
import java.util.List
import org.yakindu.base.types.Event
import org.yakindu.base.types.Property
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.VariableDefinition

class Navigation extends SExecExtensions {
	
	
	def List<EventDefinition> getOutgoingEvents(ExecutionFlow flow) {
		val events = new ArrayList<EventDefinition>()
		for (scope: flow.scopes) {
			events.addAll(scope.outgoingEvents)
		}
		return events
	}
	
	def boolean hasOutgoingEvents(ExecutionFlow it) {
		return !outgoingEvents.empty
	}
	
	def getInternalScopeEvents(ExecutionFlow flow) {
		val events = new ArrayList<EventDefinition>
		flow.internalScopes.forEach[events.addAll(eventDefinitions)]
		return events
	}
	
	def getInternalScopeVariables(ExecutionFlow flow) {
		val variables = new ArrayList<VariableDefinition>
		flow.internalScopes.forEach[variables.addAll(variableDefinitions)]
		return variables
	}
	
	
	def getDefaultScope(ExecutionFlow it) {
		interfaceScopes.filter[name == null || name.empty].head
	}
	
	def Iterable<InternalScope> getInternalScopes(ExecutionFlow it) {
		return scopes.filter(typeof(InternalScope))
	}
	
	def boolean hasEvents(Scope it) {
		return !eventDefinitions.empty
	}
	
	def getEventDefinitions(Scope scope) {
		scope.declarations.filter(typeof(EventDefinition))
	}
	
	def getOperations(Scope it) {
		declarations.filter(typeof(OperationDefinition));
	}
	
	def hasOperations(Scope it) {
		!operations.isEmpty;
	}
	
	
	def dispatch scope(Property it) {
		if (eContainer instanceof InterfaceScope)
			eContainer as InterfaceScope
		else
			null
	}
	
	def dispatch scope(Event it) {
		if (eContainer instanceof InterfaceScope)
			eContainer as InterfaceScope
		else
			null
	}
	
	def dispatch scope(OperationDefinition it) {
		if (eContainer instanceof InterfaceScope)
			eContainer as InterfaceScope
		else
			null
	}
	
	
}