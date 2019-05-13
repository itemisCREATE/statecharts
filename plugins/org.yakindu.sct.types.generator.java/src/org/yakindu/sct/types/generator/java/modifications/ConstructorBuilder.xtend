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
package org.yakindu.sct.types.generator.java.modifications

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.TypeBuilder
import org.yakindu.sct.model.sexec.transformation.ExpressionBuilder

@Singleton
class ConstructorBuilder {

	@Inject protected extension ExpressionBuilder
	@Inject protected extension TypeBuilder
	@Inject protected extension ExpressionExtensions

	static val CTOR_NAME = "__init__" 

	def create ctor : _op defaultConstructor(ComplexType ct) {
		ctor.name = CTOR_NAME
		ctor._type(ct)
		ctor.static = true
		
		ct.features += ctor
	}
	
	def dispatch isConstructor(Void it) { false }
	def dispatch isConstructor(EObject it) { false }
	def dispatch isConstructor(Operation it) {
		name == CTOR_NAME && static
	}
	
	def isConstructorCall(Expression e) {
		e.featureOrReference.isConstructor
	}
}
