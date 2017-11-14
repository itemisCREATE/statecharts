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
import org.yakindu.sct.generator.c.language.CustomType
import org.yakindu.sct.generator.core.language.CharSequenceList
import org.yakindu.sct.generator.core.language.CodePart
import org.yakindu.sct.generator.core.language.IDeclarable
import org.yakindu.sct.generator.core.language.IModifier
import org.yakindu.sct.generator.core.language.IModule
import org.yakindu.sct.generator.core.language.IType
import org.yakindu.sct.generator.core.language.ITypeQualifier
import org.yakindu.sct.generator.core.language.IVariable

/**
 * @author rbeckmann
 *
 */
class Variable extends CodePart implements IVariable, IDeclarable {
	@Accessors protected CharSequence name
	@Accessors protected IType type
	@Accessors protected ITypeQualifier typeQualifier
	@Accessors protected IModule parent
	@Accessors protected List<IModifier> modifiers = new CharSequenceList()
	@Accessors protected CharSequence initialValue
	@Accessors protected CharSequence documentation
	
	new() {
		
	}
	
	new(IType type, CharSequence name) {
		this.type = type;
		this.name = name;
	}
	
	new(CharSequence type, CharSequence name) {
		this(new CustomType(type), name)
	}
	
	override toString() {
		name.toString
	}
	
	override declare() {
		'''
		«documentation»
		«new CharSequenceList(#[modifiers.toString, typeQualifier, type, name, declareInitialValue]) + ";"»
		'''
	}
	
	def CharSequence declareInitialValue() {
		if(initialValue === null || initialValue == "") {
			""
		} else {
			" = " + initialValue
		}
	}
}