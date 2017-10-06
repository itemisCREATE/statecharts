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
import org.yakindu.sct.generator.core.language.CodePart
import org.yakindu.sct.generator.core.language.IModule

/**
 * @author rbeckmann
 *
 */
class Namespace extends CodePart implements IModule {
	@Accessors protected CharSequence name;
	@Accessors protected IModule parent;
	
	override setParent(IModule parent) {
		if(parent instanceof Namespace) {
			this.parent = parent
		}
	}
}