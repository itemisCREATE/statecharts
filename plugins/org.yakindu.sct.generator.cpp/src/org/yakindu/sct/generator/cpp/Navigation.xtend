/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.generator.cpp

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.ImportScope
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope

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
	
	def getInterfaces(ExecutionFlow it) {
		scopes.filter(typeof(StatechartScope)).filter[!(it instanceof ImportScope)]
	}
}