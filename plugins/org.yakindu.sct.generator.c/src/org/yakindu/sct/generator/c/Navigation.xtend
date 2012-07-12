package org.yakindu.sct.generator.c

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.InterfaceScope
import java.util.Collection
import org.yakindu.sct.model.sexec.StateVector
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.stext.stext.EventDefinition

class Navigation {
	
	def ExecutionFlow flow(Scope scope) {
		if (scope.eContainer instanceof ExecutionFlow) scope.eContainer as ExecutionFlow
		else null
	}
	
	def ExecutionFlow flow(Declaration it) {
		scope?.flow
	}
	
	def Scope scope(Declaration it) {
		if (eContainer instanceof Scope) eContainer as Scope
		else null
	}
	
	
	def empty (StateVector sv) {
		sv == null || sv.size == 0
	}
	
	def isTimed (ExecutionFlow it) {
		scopes.filter( s | s.declarations.filter( typeof(TimeEvent) ).size > 0).size > 0
	}
	
	def hasValue (EventDefinition it) {
		type != null && type.name != 'void'
	}
	
}