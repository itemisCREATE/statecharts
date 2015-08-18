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
package org.yakindu.sct.refactoring.proposals;

import java.util.Collections;

import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.base.xtext.utils.gmf.proposals.ISemanticModification;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.refactoring.refactor.IRefactoring;

/**
 * Adapts the {@link ISemanticModification} interface to the
 * {@link IRefactoring} interface
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SemanticModificationAdapter implements ISemanticModification {

	private AbstractRefactoring<View> refactoring;

	public SemanticModificationAdapter(AbstractRefactoring<View> refactoring) {
		this.refactoring = refactoring;

	}

	public boolean IsModificationFor(View object) {
		refactoring.setContextObjects(Collections.singletonList(object));
		return refactoring.isExecutable();
	}

	public void modify(View view) {
		refactoring.execute();
	}

}
