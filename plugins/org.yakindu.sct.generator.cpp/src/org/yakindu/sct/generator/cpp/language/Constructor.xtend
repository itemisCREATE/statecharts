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
import org.yakindu.sct.generator.core.language.CharSequenceList
import org.yakindu.sct.generator.core.language.IFunction

/**
 * @author rbeckmann
 * 
 */
class Constructor extends Function implements IFunction {
	@Accessors protected List<CharSequence> initializerList;

	new() {
		this.initializerList = new CharSequenceList(",\n");
	}

	override postfix() {
		if(!initializerList.nullOrEmpty) {
			'''
			 : 
			 	«initializerList»'''
		}
	}
	
	override declare() {
		'''«name»(«parameters»);'''
	}

	override prefix() {
		getName()
	}
}
