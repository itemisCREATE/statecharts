/**
 * Copyright (c) 2013-2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.proposals;

import java.util.Collections;

import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.refactoring.refactor.IRefactoring;
import org.yakindu.sct.ui.editor.modifications.ISemanticModification;

/**
 * Adapts the {@link ISemanticModification} interface to the
 * {@link IRefactoring} interface
 * 
 * @author andreas muelder - Initial contribution and API
 * @author terfloth
 * 
 */
public class RefactoringBasedModification implements ISemanticModification {

	private View targetView;
	private AbstractRefactoring<View> refactoring;

	
	@Override
	public void setTargetView(View view) {
		targetView = view;
	}

	@Override
	public View getTargetView() {
		return targetView;
	}


	public RefactoringBasedModification(View view, AbstractRefactoring<View> refactoring) {
		this.targetView = view;
		this.refactoring = refactoring;
	}

	
	public boolean isApplicable() {
		if ( targetView == null ) return false;
		refactoring.setContextObjects(Collections.singletonList(targetView));
		return refactoring.isExecutable();
	}

	public void modify() {
		refactoring.execute();
	}

}
