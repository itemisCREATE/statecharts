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
import java.util.ArrayList
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.eclipse.emf.ecore.EObject

class Navigation {
	
	def dispatch ExecutionFlow flow(Scope scope) {
		if (scope.eContainer instanceof ExecutionFlow) scope.eContainer as ExecutionFlow
		else null
	}
	
	def dispatch ExecutionFlow flow(Declaration it) {
		scope?.flow
	}
	
	def dispatch ExecutionFlow flow(EObject it) {
		eContainer.flow
	}
	
	def dispatch ExecutionFlow flow(ExecutionFlow it) {
		it
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
	
	def operations(ExecutionFlow it) {
		scopes.fold(new ArrayList<OperationDefinition>(), [ l, s | l.addAll(s.declarations.filter( typeof(OperationDefinition))) return l ])
	}
	

}