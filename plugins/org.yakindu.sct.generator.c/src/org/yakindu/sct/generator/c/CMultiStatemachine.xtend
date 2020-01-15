/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.TypedDeclaration
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.model.sgraph.util.StatechartUtil

class CMultiStatemachine {
	@Inject extension Naming
	@Inject extension StatechartUtil

	def dispatch CharSequence getFunctionId(Operation op, ComplexType type) {
		return getFunctionId(op.name, type)
	}

	def dispatch CharSequence getFunctionId(String op, ComplexType type) {
		val sct = type.getOriginStatechart
		switch (op) {
			case "init": return sct.initFctID
			case "exit": return sct.exitFctID
			case "enter": return sct.enterFctID
			case "isActive": return sct.isActiveFctID
			case "isFinal": return sct.isFinalFctID
			case "runCycle": return sct.runCycleFctID
			case "isStateActive": return sct.isStateActiveFctID
			default: return '''Cannot find state machine method '«op»' for type '«type»'.'''
		}
	}

	def dispatch CharSequence getFunctionId(Operation op, TypedDeclaration decl) {
		val type = decl.type
		if (type instanceof ComplexType) {
			return op.getFunctionId(type)
		}
		return '''Cannot find state machine method '«op.name»' for Declaration '«decl»'.'''
	}

	def dispatch CharSequence getFunctionId(Operation op, EObject decl) {
		return '''Cannot find state machine method '«op.name»' for EObject '«decl»'.'''
	}

}
