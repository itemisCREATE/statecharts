/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.ui.editor.clipboardsupport;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.clipboard.core.OverridePasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteTarget;

public class DiagramPasteOperation extends OverridePasteChildOperation {
	
	public DiagramPasteOperation(PasteChildOperation overriddenChildPasteOperation) {
		super(overriddenChildPasteOperation);
	}

	/**
	 * We want sub diagrams to be directly pasted into resources
	 */
	@Override
	public PasteTarget getParentTarget() {
		PasteTarget parentTarget = super.getParentTarget();
		if (parentTarget.getObject() instanceof EObject) {
			EObject eObject = (EObject) parentTarget.getObject();
			return new PasteTarget(eObject.eResource());
		}
		return parentTarget;
	}

	@Override
	public void paste() throws Exception {
		doPasteInto(getParentTarget());
	}
	
}
