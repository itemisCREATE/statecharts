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

import java.util.ArrayList
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.Declaration
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.OperationDefinition

class Navigation extends SExecExtensions {
	
	
	
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
	
	
	def hasValue (EventDefinition it) {
		type != null && type.name != 'void'
	}
	
	def operations(ExecutionFlow it) {
		scopes.fold(new ArrayList<OperationDefinition>(), [ l, s | l.addAll(s.declarations.filter( typeof(OperationDefinition))) return l ])
	}
	
	def Scope getTimeEventScope(ExecutionFlow it) {
		return 	scopes.filter[declarations.filter( typeof(TimeEvent) ).size > 0].head
	}
	
	def boolean hasLocalScope(ExecutionFlow it) {
		return internalScope != null;
	}
	
		
}