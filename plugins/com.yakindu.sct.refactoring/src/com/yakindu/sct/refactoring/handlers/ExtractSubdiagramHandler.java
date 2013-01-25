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
import org.eclipse.jface.viewers.ISelection;

import com.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import com.yakindu.sct.refactoring.refactor.ExtractSubdiagramRefactoring;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExtractSubdiagramHandler extends AbstractViewRefactoringHandler {

	@Override
	public AbstractRefactoring<View> createRefactoring() {
		return new ExtractSubdiagramRefactoring();
	}

	@Override
	public void setContext(AbstractRefactoring<View> refactoring,
			ISelection selection) {
		
		
	}

}
