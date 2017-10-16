/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp.language

import org.yakindu.sct.generator.c.language.CustomType
import org.yakindu.sct.generator.c.language.TypeQualifier
import org.yakindu.sct.generator.core.language.IFunction
import org.yakindu.sct.generator.core.language.IModifierOwner
import org.yakindu.sct.generator.core.language.IType
import org.yakindu.sct.generator.core.language.ITypeQualifierOwner

/**
 * @author rbeckmann
 *
 */
class CodePartExtensions {
	def setConst(ITypeQualifierOwner it) {
		it.typeQualifier = TypeQualifier.CONST
	}
	
	def setStatic(IModifierOwner it) {
		if(!modifiers.contains(Modifier.STATIC)) modifiers += Modifier.STATIC
	}
	
	def setVirtual(IModifierOwner it) {
		if(!modifiers.contains(Modifier.VIRTUAL)) modifiers += Modifier.VIRTUAL
	}
	
	def setFunctionConst(IFunction it) {
		if(it instanceof Function) constFunction = true
	}
	
	def pointer(IType type) {
		new CustomType(type.name + "*")
	}
	
	def pointer(CharSequence type) {
		new CustomType(type + "*")
	}
	
	def reference(IType type) {
		new CustomType(type.name + "&")
	}
	
	def setPure(Function it) {
		setVirtual
		pure = true
	}
}