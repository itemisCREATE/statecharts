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
package org.yakindu.sct.generator.common

import java.util.ArrayList
import java.util.Collection
import org.eclipse.xtend.lib.annotations.Accessors

/**
 * @author rbeckmann
 *
 */
class CharSequenceList<T extends CharSequence> extends ArrayList<CharSequence> implements CharSequence {
	@Accessors protected CharSequence separator
	
	new(CharSequence separator) {
		this.separator = separator
	}
	
	new() {
		super()
	}
	
	new(Collection<CharSequence> elements) {
		super(elements)
	}
	
	/* (non-Javadoc)
	 * @see CharSequence#charAt(int)
	 */
	override char charAt(int index) {
		return toString().charAt(index);
	}

	/* (non-Javadoc)
	 * @see CharSequence#length()
	 */
	override int length() {
		return toString().length();
	}

	/* (non-Javadoc)
	 * @see CharSequence#subSequence(int, int)
	 */
	override CharSequence subSequence(int start, int end) {
		return toString().subSequence(start, end);
	}
	
	override toString() {
		return this.join(separator)
	}
}