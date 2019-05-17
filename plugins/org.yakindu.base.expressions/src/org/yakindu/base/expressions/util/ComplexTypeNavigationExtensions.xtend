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
package org.yakindu.base.expressions.util

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property

@Singleton
class ComplexTypeNavigationExtensions {
	@Inject protected extension ExpressionPredicates	
		
	def allComplexTypes(ComplexType ct) {
		ct.eAllContents.filter(ComplexType).toList
	}
	
	def complexTypes(ComplexType ct) {
		ct.features.filter(ComplexType).toList
	}
	
	def publicProperties(ComplexType ct) {
		ct.features.filter(Property).filter[isPublic]
	}
	
	def properties(ComplexType ct) {
		ct.features.filter(Property)
	}
	
	def operations(ComplexType ct) {
		ct.features.filter(Operation)
	}
	
}
