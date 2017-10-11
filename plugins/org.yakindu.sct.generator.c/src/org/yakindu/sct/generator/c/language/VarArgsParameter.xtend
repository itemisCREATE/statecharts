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
import org.yakindu.sct.generator.core.language.IParameter
import org.yakindu.sct.generator.core.language.IType
import org.yakindu.sct.generator.core.language.ITypeQualifier

/**
 * @author rbeckmann
 *
 */
class VarArgsParameter extends CodePart implements IParameter {
	@Accessors protected IType type
	@Accessors protected ITypeQualifier typeQualifier
	@Accessors protected CharSequence name
	
	new() {
		
	}
	
	override toString() {
		"..."
	}
}