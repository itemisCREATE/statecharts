/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.types.generator.c

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.MultiplicativeOperator
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.types.Expression
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sexec.Execution
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.types.generator.c.typesystem.CTypeSystemAccess

class CExpressionsChecker {

	@Inject protected extension ITypeSystem
	@Inject protected extension ITypeSystemInferrer
	@Inject protected extension CTypeSystemAccess

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
		leftOperand.infer.type.isString || rightOperand.infer.type.isString
	}

	def isConstString(VariableDefinition it) {
		const && isStringType
	}

	def protected isStringType(VariableDefinition it) {
		isString(typeSpecifier.type)
	}

	def boolean haveCommonTypeReal(Expression expression) {
		val inferResult = infer(expression)
		if (inferResult === null) {
			return true
		};
		!getCommonType(
			infer(expression).getType,
			getType(ITypeSystem.INTEGER)
		).isInteger
	}

	def dispatch CharSequence castToReciever(ElementReferenceExpression it) {
		if (reference instanceof VariableDefinition) {
			val originalType = infer(reference)
			return '''(«getTargetLanguageName(originalType.type)»)'''
		}
	}

	def dispatch CharSequence castToReciever(FeatureCall it) {
		if (feature instanceof VariableDefinition) {
			val originalType = infer(feature)
			return '''(«getTargetLanguageName(originalType.type)»)'''
		}
	}

	def dispatch CharSequence castToReciever(EObject obj) {
		val eContainer = obj.eContainer
		if (eContainer instanceof Execution) {
			val statement = eContainer.statement
			if (statement instanceof AssignmentExpression) {
				castToReciever(statement.varRef)
			}
		}
	}

	def dispatch CharSequence castToReciever(AssignmentExpression it) {
		varRef.castToReciever
	}
	
	def boolean modOnNumericalMulitplyDivide(Iterable<Expression> expressions) {
		expressions.filter(NumericalMultiplyDivideExpression).findFirst[operator.equals(AssignmentOperator.MOD_ASSIGN) && haveCommonTypeReal] !== null
	}
	
	def boolean modOnAssignment(Iterable<Expression> expressions) {
		expressions.filter(AssignmentExpression).findFirst[operator.equals(AssignmentOperator.MOD_ASSIGN) && haveCommonTypeReal] !== null
	}
}
