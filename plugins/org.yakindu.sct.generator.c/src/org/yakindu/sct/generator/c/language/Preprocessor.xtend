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
import org.yakindu.sct.generator.common.CodePart

/**
 * @author rbeckmann
 * 
 */
class Preprocessor {
	static abstract class Header extends CodePart {
		@Accessors protected CharSequence name
		new(CharSequence name) {
			this.name = name
		}
		
		override toString() {
			switch (this) {
				SystemHeader: '''#include <«name»>'''
				LocalHeader: '''#include "«name»"'''
			}
		}
	}

	static class SystemHeader extends Header {
		new(CharSequence name) {
			super(name)
		}
	}

	static class LocalHeader extends Header {
		new(CharSequence name) {
			super(name)
		}
	}
}
