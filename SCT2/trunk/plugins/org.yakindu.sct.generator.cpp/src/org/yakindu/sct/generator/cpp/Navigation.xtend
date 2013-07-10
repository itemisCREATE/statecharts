package org.yakindu.sct.generator.cpp

import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.OperationDefinition

class Navigation extends org.yakindu.sct.generator.c.Navigation {
	
	def operations(Scope it) {
		declarations.filter(typeof(OperationDefinition));
	}
	
	def hasOperations(Scope it) {
		!operations.isEmpty;
	}
}