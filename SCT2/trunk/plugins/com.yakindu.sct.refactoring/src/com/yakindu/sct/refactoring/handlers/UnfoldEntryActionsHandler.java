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

import org.yakindu.sct.model.sgraph.State;

import com.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import com.yakindu.sct.refactoring.refactor.UnfoldEntryActionsRefactoring;
/**
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class UnfoldEntryActionsHandler extends AbstractStateRefactoringHandler {

	@Override
	public AbstractRefactoring<State> createRefactoring() {
		return new UnfoldEntryActionsRefactoring();
	}

}
