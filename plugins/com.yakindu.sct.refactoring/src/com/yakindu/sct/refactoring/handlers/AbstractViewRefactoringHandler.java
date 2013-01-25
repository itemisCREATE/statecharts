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
import org.yakindu.sct.ui.editor.editparts.StateEditPart;

import com.google.common.collect.Lists;
import com.yakindu.sct.refactoring.refactor.AbstractRefactoring;
/**
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public abstract class AbstractViewRefactoringHandler extends
		AbstractRefactoringHandler<View> {

	@Override
	public void setContext(AbstractRefactoring<View> refactoring,
			ISelection selection) {
		StateEditPart firstElement = (StateEditPart) getFirstElement(selection);
		refactoring.setContextObjects(Lists.newArrayList(firstElement
				.getNotationView()));
	}

}