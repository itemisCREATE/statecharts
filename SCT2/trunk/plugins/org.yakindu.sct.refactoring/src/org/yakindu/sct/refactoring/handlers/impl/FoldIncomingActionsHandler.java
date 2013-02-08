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
package org.yakindu.sct.refactoring.handlers.impl;

import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.refactoring.handlers.AbstractStateRefactoringHandler;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.refactoring.refactor.impl.FoldIncomingActionsRefactoring;

/**
 * Handler for {@link FoldIncomingActionsRefactoring}.
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class FoldIncomingActionsHandler extends
		AbstractStateRefactoringHandler {

	@Override
	public AbstractRefactoring<State> createRefactoring() {
		return new FoldIncomingActionsRefactoring();
	}
}
