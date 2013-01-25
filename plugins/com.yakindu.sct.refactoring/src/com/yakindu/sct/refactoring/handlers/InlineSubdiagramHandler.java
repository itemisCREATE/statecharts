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
package com.yakindu.sct.refactoring.handlers;

import org.eclipse.gmf.runtime.notation.View;

import com.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import com.yakindu.sct.refactoring.refactor.InlineSubdiagramRefactoring;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class InlineSubdiagramHandler extends AbstractViewRefactoringHandler {

	@Override
	public AbstractRefactoring<View> createRefactoring() {
		return new InlineSubdiagramRefactoring();
	}

}
