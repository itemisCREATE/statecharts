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
		val flow = type.executionFlow
		// TODO: Reuse Statechart2Type names here..
		switch(op.name) {
			case "init": return flow.initFctID
			case "exit": return flow.exitFctID
 			case "enter": return flow.enterFctID
 			case "isActive": return flow.isActiveFctID
 			case "isFinal": return flow.isFinalFctID
			case "runCycle": return flow.runCycleFctID
			default: return '''Cannot find state machine method '«op.name»' for type '«type»'.'''
		}
	}
	
	def dispatch CharSequence getFunctionId(Operation op, TypedDeclaration decl) {
		val type = decl.type
			if(type instanceof ComplexType) {
				return op.getFunctionId(type)
			}
		return '''Cannot find state machine method '«op.name»' for Declaration '«decl»'.'''
	}
	
	def dispatch CharSequence getFunctionId(Operation op, EObject decl) {
		return '''Cannot find state machine method '«op.name»' for EObject '«decl»'.'''
	}
	
}