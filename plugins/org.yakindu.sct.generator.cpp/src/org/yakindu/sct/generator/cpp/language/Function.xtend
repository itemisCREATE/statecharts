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
	
	override getName() {
		if(parent === null) name
		else parent.getName + "::" + name
	}
	
	override prefix() {
		if(parent === null) super.prefix
		else new CharSequenceList(#[type, getName()])
	}
	
	override getModifiers() {
		modifiers.filter[parent == null || it == Modifier.VIRTUAL].toList
	}
	
	override postfix() {
		var postfix = if(modifiers.contains(Modifier.CONST)) " const" else ""
		if(pure) postfix += " = 0"
		postfix
	}
	
	override toString() {
		if (pure) "" else super.toString
	}
}