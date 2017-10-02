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
import org.yakindu.sct.generator.common.CharSequenceList
import org.yakindu.sct.generator.common.IFunction
import org.yakindu.sct.generator.common.IModifier
import org.yakindu.sct.generator.common.IType

/**
 * @author rbeckmann
 *
 */
class Function extends CodeBlock implements IFunction {
	@Accessors protected CharSequence name;
	@Accessors protected List<CharSequence> parameters;
	@Accessors protected List<IModifier> modifiers;
	@Accessors protected IType type;
	@Accessors protected CharSequence documentation;
	
	new() {
		this.parameters = new CharSequenceList(", ")
		this.modifiers = new CharSequenceList(" ")
	}
	
	override getBlockOpen() {
		val prefix = new CharSequenceList(#[modifiers.toString, type, name])
		'''«prefix»(«parameters») «super.blockOpen»'''
	}
	
	def declare() {
		'''«prefix»(«parameters»);'''
	}
	
	def prefix() {
		new CharSequenceList(#[modifiers.toString, type, name])
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