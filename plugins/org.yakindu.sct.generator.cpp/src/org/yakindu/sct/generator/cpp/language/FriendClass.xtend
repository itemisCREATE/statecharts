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

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.sct.generator.core.language.CodePart
import org.yakindu.sct.generator.core.language.IDeclarable
import org.yakindu.sct.generator.core.language.IModifier
import org.yakindu.sct.generator.core.language.IModule
import org.yakindu.sct.generator.core.language.IModuleMember
import org.yakindu.sct.generator.core.language.INameOwner

/**
 * @author rbeckmann
 *
 */
class FriendClass extends CodePart implements INameOwner, IModuleMember, IDeclarable {
	@Accessors protected CharSequence name
	@Accessors protected IModule parent
	@Accessors(PRIVATE_GETTER, PRIVATE_SETTER) protected List<IModifier> modifiers
	
	new(CharSequence name) {
		this.name = name
	}
	
	override declare() {
		'''friend class «name»;'''
	}
}