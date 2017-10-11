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

import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.sct.generator.core.language.CharSequenceList
import org.yakindu.sct.generator.core.language.IType

/**
 * @author rbeckmann
 *
 */
class ArrayVariable extends Variable {
	@Accessors protected CharSequence initialSize
	
	new() {
		super()
	}
	
	new(IType type, CharSequence name) {
		super(type, name)
	}
	
	new(CharSequence type, CharSequence name) {
		super(type, name)
	}
	
	new(CharSequence type, CharSequence name, CharSequence initialSize) {
		super(type, name)
		this.initialSize = initialSize
	}
	
	override declare() {
		'''
		«documentation»
		«new CharSequenceList(#[modifiers.toString, typeQualifier, type, arrayName, declareInitialValue]) + ";"»
		'''
	}
	
	def CharSequence arrayName() {
		if(initialSize === null || initialSize == "") {
			'''«name»[]'''
		} else {
			'''«name»[«initialSize»]'''
		}
	}
	
	def index(CharSequence index) {
		'''«toString»[«index»]'''
	}
}