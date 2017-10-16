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
package org.yakindu.sct.generator.c.language

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.sct.generator.core.language.CharSequenceList
import org.yakindu.sct.generator.core.language.IDeclarable
import org.yakindu.sct.generator.core.language.IFunction
import org.yakindu.sct.generator.core.language.IModifier
import org.yakindu.sct.generator.core.language.IModule
import org.yakindu.sct.generator.core.language.IType
import org.yakindu.sct.generator.core.language.ITypeQualifier

/**
 * @author rbeckmann
 *
 */
class Function extends CodeBlock implements IFunction, IDeclarable {
	@Accessors protected CharSequence name;
	@Accessors protected List<CharSequence> parameters;
	@Accessors protected List<IModifier> modifiers;
	@Accessors protected IType type;
	@Accessors protected CharSequence documentation;
	@Accessors protected ITypeQualifier typeQualifier
	@Accessors protected IModule parent
	
	new() {
		this.parameters = new CharSequenceList(", ")
		this.modifiers = new CharSequenceList(" ")
	}
	
	override getBlockOpen() {
		'''«prefix»(«parameters»)«postfix» «super.blockOpen»'''
	}
	
	override declare() {
		'''«prefix»(«parameters»);'''
	}
	
	def CharSequence prefix() {
		new CharSequenceList(#[modifiers.toString, typeQualifier, type, name])
	}

	def postfix() {
		""
	}
	
	override toString() {
		if(documentation !== null) {
			'''
			«documentation»
			«super.toString»
			'''
		} else {
			super.toString
		}
	}
}