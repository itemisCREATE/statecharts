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

import org.yakindu.sct.generator.core.language.ICodeBlock

/**
 * @author rbeckmann
 *
 */
abstract class CodeBlock extends org.yakindu.sct.generator.core.language.CodeBlock implements ICodeBlock {
	protected static final CharSequence BLOCKOPEN = "\n{"
	
	protected static final CharSequence BLOCKCLOSE = '''
	}
	'''
	
	override getBlockClose() {
		return BLOCKCLOSE
	}
	
	override getBlockOpen() {
		return BLOCKOPEN
	}
	
	override toString() {
		'''
		«blockOpen»
			«IF getContent !== null»«getContent»«ENDIF»
		«blockClose»
		'''
	}
}