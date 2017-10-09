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
package org.yakindu.sct.generator.core.language

import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author rbeckmann
 *
 */
class Parameter extends CodePart implements IParameter {
	@Accessors protected IType type;
	@Accessors protected ITypeQualifier typeQualifier;
	@Accessors protected CharSequence name;
	
	new(ITypedElement other) {
		this.type = other.type
		this.typeQualifier = other.typeQualifier
		this.name = other.name
	}
	
	new(IType type, CharSequence name) {
		this.type = type
		this.name = name
	}
	
	new() {
		
	}
	
	override toString() {
		new CharSequenceList(#[typeQualifier, type, name]).toString
	}
}
