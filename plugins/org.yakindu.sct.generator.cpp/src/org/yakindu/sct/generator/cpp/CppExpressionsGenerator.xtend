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
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.c.CExpressionsGenerator
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.LogicalNotExpression

class CppExpressionsGenerator extends CExpressionsGenerator {

	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject protected extension ITypeSystem
	@Inject protected extension INamingService

	override dispatch CharSequence code(ElementReferenceExpression it,
		OperationDefinition target) '''«target.access»(«FOR arg : expressions SEPARATOR ', '»«arg.
		code»«ENDFOR»)'''

	override dispatch CharSequence code(EventRaisingExpression it) '''
	«IF value !== null»
		«event.definition.event.valueAccess» = «value.code»;
	«ENDIF»
	«event.definition.event.access» = true'''

	override dispatch CharSequence code(
		ActiveStateReferenceExpression it) '''«flow.stateActiveFctID»(«value.shortName»)'''

	/* Feature Call */
	override dispatch CharSequence code(FeatureCall it,
		OperationDefinition target) '''«target.access»(«FOR arg : expressions SEPARATOR ', '»«arg.code»«ENDFOR»)'''

	/* Literals */
	override dispatch CharSequence code(BoolLiteral it) '''«IF value»true«ELSE»false«ENDIF»'''
	
	override dispatch CharSequence code(StringLiteral it) '''(sc_string) «super._code(it)»'''
	
	/** Don't use bool_true for C++ code */
	override dispatch CharSequence sc_boolean_code(Expression it) {code}
	
	/** Don't use bool_false for C++ code */
	override dispatch CharSequence sc_boolean_code(LogicalNotExpression it) {code}
	
	

}
