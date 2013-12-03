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
package org.yakindu.sct.refactoring.handlers;

import java.util.Collections;

import org.eclipse.jface.viewers.ISelection;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;

import com.google.common.collect.Lists;

/**
 * Base class for all refactoring handlers working on a single {@link State}.
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public abstract class AbstractStateRefactoringHandler extends
		AbstractRefactoringHandler<State> {

	@Override
	public void setContext(AbstractRefactoring<State> refactoring,
			ISelection selection) {
		StateEditPart element = (StateEditPart) getFirstElement(selection);
		if (element == null) {
			refactoring.setContextObjects(Collections.<State>emptyList());
		} else {
			State state = element.resolveSemanticElement();
			refactoring.setContextObjects(Lists.newArrayList(state));
		}
	}
}
