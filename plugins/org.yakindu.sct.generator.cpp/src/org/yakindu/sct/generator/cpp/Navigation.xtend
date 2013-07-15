package org.yakindu.sct.generator.cpp

import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.model.sexec.TimeEvent

class Navigation extends org.yakindu.sct.generator.c.Navigation {
	
	def getStatechartScopes(ExecutionFlow it) {
		scopes.filter(typeof(StatechartScope))
	}
	
	def operations(Scope it) {
		declarations.filter(typeof(OperationDefinition));
	}
	
	def hasOperations(Scope it) {
		!operations.isEmpty;
	}
	
	def indexOf(TimeEvent it) {
		scope.declarations.filter(typeof(TimeEvent)).toList.indexOf(it);
	}
}