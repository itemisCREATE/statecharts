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
import org.yakindu.sct.generator.core.language.CodePart
import org.yakindu.sct.generator.core.language.IDeclarable
import org.yakindu.sct.generator.core.language.IType

/**
 * @author rbeckmann
 *
 */
class Typedef extends CodePart implements IType, IDeclarable {
	@Accessors protected CharSequence name
	@Accessors protected IType type
	
	override toString() {
		name.toString
	}
	
	override declare() {
		'''typedef «type» «name»;'''
	}
	
	
}