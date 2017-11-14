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

/**
 * @author rbeckmann
 *
 */
class Parameter extends org.yakindu.sct.generator.core.language.Parameter {
	new(CharSequence type, CharSequence name) {
		super(new CustomType(type), name)
	}
}