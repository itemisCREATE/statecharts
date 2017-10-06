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
import org.yakindu.sct.generator.core.language.IFunction
import org.yakindu.sct.generator.core.language.IDeclarable

/**
 * @author rbeckmann
 *
 */
class Function extends org.yakindu.sct.generator.c.language.Function implements IFunction, IDeclarable {
	@Accessors protected CppClass parent
	
	override getName() {
		if(parent === null) name
		else parent.getName + "::" + name
	}
	
	override prefix() {
		if(parent === null) super.prefix
		else new CharSequenceList(#[type, getName()])
	}
}