/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.naming;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class IdentifierConverter {

	private static final String ESCAPE_TOKEN = "_";

	/**
	 * Converts the specified string into a valid identifier. All illegal
	 * characters are escaped.
	 */
	public String toIdentifier(String string) {
		StringBuilder result = new StringBuilder();
		int index = 0;
		char c = string.charAt(index);
		if (Character.isJavaIdentifierStart(c)) {
			result.append(c);
			index++;
		} else if (Character.isJavaIdentifierPart(c)) {
			result.append(ESCAPE_TOKEN);
		}
		while (index < string.length()) {
			c = string.charAt(index++);
			result.append(Character.isJavaIdentifierPart(c) ? c : ESCAPE_TOKEN);
		}
		return result.toString();
	}
}
