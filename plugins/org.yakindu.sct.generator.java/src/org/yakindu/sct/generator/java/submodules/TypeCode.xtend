/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java.submodules

import com.google.inject.Inject
import org.yakindu.base.types.ComplexType
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Event
import org.yakindu.base.types.Property
import org.yakindu.base.types.annotations.VisibilityAnnotations
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess

/**
 * 
 * @author Thomas Kutz
 */
class TypeCode {
	
	@Inject extension VisibilityAnnotations
	@Inject extension ICodegenTypeSystemAccess
	@Inject extension EventCode
	@Inject extension VariableCode
	
	def dispatch CharSequence toCode(ComplexType it) '''
		«classModifier»class «targetLanguageName» {
			«features.map[toCode].join»
		}
	'''

	def dispatch CharSequence toCode(Event event) '''
		«event.fieldDeclaration»
	'''
	
	def dispatch CharSequence toCode(Property prop) '''
		«prop.fieldDeclaration»
	'''

	def dispatch CharSequence toCode(Declaration it) ''''''

	def classModifier(ComplexType it) {
		if (isPublic)
			'''public static '''
		else
			'''private static '''
	}
}