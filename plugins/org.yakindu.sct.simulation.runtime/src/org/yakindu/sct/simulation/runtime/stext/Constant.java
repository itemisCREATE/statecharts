/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.stext;

import org.yakindu.sct.simulation.runtime.ExecutionScope;

/**
 * 
 * @author terfloth@itemis.de
 *
 */
public class Constant implements RTExpression {
	
	protected Object value;
	
	public Constant(Object value) {
		super();
		this.value = value;
	}

	public Object getValue() {
		return value;
	}

	public Object execute(ExecutionScope scope) {
		return value;
	}
	
	
}
