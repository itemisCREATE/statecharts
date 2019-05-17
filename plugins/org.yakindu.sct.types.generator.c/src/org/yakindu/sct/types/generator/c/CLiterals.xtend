/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.types.generator.c

/**
 * This extension class defines fixed literal names for different data types for C languages. These literals can be overwritten platform specifically by derived generators.
 * 
 * @author axel terfloth
 */
class CLiterals {

	public static final String NULL_LITERAL_NAME = "sc_null";
	public static final String TRUE_LITERAL_NAME = "bool_true";
	public static final String FALSE_LITERAL_NAME = "bool_false";

	def NULL_LITERAL() { NULL_LITERAL_NAME }

	def TRUE_LITERAL() { TRUE_LITERAL_NAME }

	def FALSE_LITERAL() { FALSE_LITERAL_NAME }

}
