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
import org.yakindu.sct.generator.common.ILoop

/**
 * @author rbeckmann
 *
 */
class ForLoop extends CodeBlock implements ILoop {
	@Accessors protected CharSequence initializer;
	@Accessors protected CharSequence endCondition;
	@Accessors protected CharSequence iteration;
	
	override getBlockOpen() {
		'''for(«loopHead») «super.blockOpen»'''
	}
	
	def CharSequence loopHead() {
		var head = '''«initializer»; «endCondition»; «iteration»'''
		if (head.length > 80) {
			head = '''
			«initializer»;
			«endCondition»;
			«iteration»'''
		}
		return head
	}
}