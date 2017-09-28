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
package org.yakindu.sct.generator.c.language;

import org.yakindu.sct.generator.common.IModifier;

/**
 * @author rbeckmann
 *
 */
public enum Modifier implements IModifier {
	STATIC ("static"),
	EXTERN ("extern")
	;
	
	protected final String s;
	Modifier(String s) {
		this.s = s;
	}
	
	public String toString() {
		return s;
	}

}
