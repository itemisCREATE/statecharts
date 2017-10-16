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

import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.sct.generator.core.language.CharSequenceList
import org.yakindu.sct.generator.core.language.IDeclarable
import org.yakindu.sct.generator.core.language.IFunction
import org.yakindu.sct.generator.core.language.IModule

/**
 * @author rbeckmann
 *
 */
class Function extends org.yakindu.sct.generator.c.language.Function implements IFunction, IDeclarable {
	@Accessors protected IModule parent
	@Accessors protected boolean pure = false // Pure virtual functions
	@Accessors protected boolean constFunction = false
	
	override getName() {
		if(parent === null) name
		else parent.getName + "::" + name
	}
	
	override prefix() {
		if(parent === null) super.prefix
		else new CharSequenceList(#[typeQualifier, type, getName()])
	}
	
	override getModifiers() {
		if(modifiers.contains(Modifier.CONST)) {
			modifiers.remove(Modifier.CONST)
			constFunction = true
		}
		modifiers
	}
	
	override postfix() {
		var postfix = if(isConstFunction) " const" else ""
		if(pure) postfix += " = 0"
		postfix
	}
	
	def boolean isConstFunction() {
		if(modifiers.contains(Modifier.CONST)) {
			modifiers.remove(Modifier.CONST)
			constFunction = true
		}
		constFunction
	}
	
	override declare() {
		'''«new CharSequenceList(#[modifiers.toString, typeQualifier, type, name])»(«parameters»)«postfix»;'''
	}
	
	override toString() {
		if (pure) "" else super.toString
	}
}