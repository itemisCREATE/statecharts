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
import org.yakindu.sct.generator.core.multism.MultiStatemachineHelper

class CMultiStatemachine {
	@Inject protected extension MultiStatemachineHelper
	@Inject extension Naming

	def dispatch CharSequence getFunctionId(Operation op, ComplexType type) {
		return getFunctionId(op.name, type)
	}

	def dispatch CharSequence getFunctionId(String op, ComplexType type) {
		val flow = type.executionFlow
		switch (op) {
			case "init": return flow.initFctID
			case "exit": return flow.exitFctID
			case "enter": return flow.enterFctID
			case "isActive": return flow.isActiveFctID
			case "isFinal": return flow.isFinalFctID
			case "runCycle": return flow.runCycleFctID
			case "isStateActive": return flow.isStateActiveFctID
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
