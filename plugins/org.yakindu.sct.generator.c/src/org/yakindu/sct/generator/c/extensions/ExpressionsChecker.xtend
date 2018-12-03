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
package org.yakindu.sct.generator.c.extensions

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.MultiplicativeOperator
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.c.CExpressionsGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.VariableDefinition

class ExpressionsChecker {

	@Inject protected extension CExpressionsGenerator
	
	@Inject protected extension ITypeSystem
	@Inject protected extension ITypeSystemInferrer

	def modOnReal(ExecutionFlow it) {
		!eAllContents.filter(NumericalMultiplyDivideExpression).filter[operator == MultiplicativeOperator.MOD].filter [
			it.haveCommonTypeReal
		].isEmpty || !eAllContents.filter(AssignmentExpression).filter[operator == AssignmentOperator.MOD_ASSIGN].filter [
			it.haveCommonTypeReal
		].isEmpty
	}
	
	def hasStringComparison(ExecutionFlow it) {
		!eAllContents.filter(LogicalRelationExpression).filter[comparesString].isEmpty
	}
	
	def protected comparesString(LogicalRelationExpression it) {
		isSame(infer(it.leftOperand).type, getType(ITypeSystem.STRING)) || 
			isSame(infer(it.rightOperand).type, getType(ITypeSystem.STRING))
	}
	
	def isConstString(VariableDefinition it) {
		const && isStringType
	}
	
	def protected isStringType(VariableDefinition it) {
		isSame(typeSpecifier.type ,getType(ITypeSystem.STRING))
	}
}
