/** 
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java.util

class StringHelper {
	
	def dot(String a, String b) {
		if (a.nullOrEmpty) return b ?: ""
		if (b.nullOrEmpty) return a ?: ""
		a + "." + b
	}
	
	def isLowercase(String s) {
		!s.nullOrEmpty && Character.isLowerCase(s.charAt(0));
	}

}