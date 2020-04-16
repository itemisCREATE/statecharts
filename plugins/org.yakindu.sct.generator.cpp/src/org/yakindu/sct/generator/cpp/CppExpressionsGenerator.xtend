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

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.types.Expression
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.c.CExpressionsGenerator
import org.yakindu.sct.model.sexec.Method
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition

class CppExpressionsGenerator extends CExpressionsGenerator {

	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension ITypeSystem
	@Inject protected extension INamingService
	
	@Inject protected extension EventRaisingCode

	override dispatch CharSequence code(ElementReferenceExpression it,
		OperationDefinition target) '''«target.access»(«FOR arg : expressions SEPARATOR ', '»«arg.
		code»«ENDFOR»)'''

	override dispatch CharSequence code(EventRaisingExpression it) {
		raiseEvent(it, value?.code)
	}

	override dispatch CharSequence code(
		ActiveStateReferenceExpression it) '''«flow.stateActiveFctID»(«value.shortName»)'''
		
	override dispatch CharSequence code(ElementReferenceExpression it, Method target){
		'''«target.access»(«FOR arg : expressions SEPARATOR ', '»«arg.code»«ENDFOR»)'''
	}
	
	/* Feature Call */
	override dispatch CharSequence code(FeatureCall it,
		OperationDefinition target) '''«target.access»(«FOR arg : expressions SEPARATOR ', '»«arg.code»«ENDFOR»)'''

	/* Literals */
	override dispatch CharSequence code(BoolLiteral it) '''«IF value»true«ELSE»false«ENDIF»'''
	
	/** Don't use bool_true for C++ code */
	override dispatch CharSequence sc_boolean_code(Expression it) {code}
	
	/** Don't use bool_false for C++ code */
	override dispatch CharSequence sc_boolean_code(LogicalNotExpression it) {code}
}
