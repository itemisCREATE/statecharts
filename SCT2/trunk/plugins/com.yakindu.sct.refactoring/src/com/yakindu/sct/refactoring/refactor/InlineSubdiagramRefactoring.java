/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package com.yakindu.sct.refactoring.refactor;


/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class InlineSubdiagramRefactoring extends SubdiagramRefactoring {

	@Override
	public boolean isExecutable() {
		return super.isExecutable() && !getInlineStyle().isBooleanValue();
	}

	@Override
	protected void internalExecute() {
		System.out.println("Inline");
		getInlineStyle().setBooleanValue(true);
	}

}
