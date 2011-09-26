/******************************************************************************
 * Copyright (c) 2004, 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    IBM Corporation - initial API and implementation 
 ****************************************************************************/

package org.yakindu.sct.ui.editor.clipboardsupport;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.clipboard.core.ObjectInfo;
import org.eclipse.gmf.runtime.emf.clipboard.core.OverridePasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PostPasteChildOperation;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This is a copy of
 * {@link org.eclipse.gmf.runtime.notation.providers.internal.copypaste.PositionalGeneralViewPasteOperation}
 * . It calls a static method of the {@link NotationClipboardOperationHelper}
 * 
 */
@SuppressWarnings("all")
public class PositionalGeneralViewPasteOperation extends
		OverridePasteChildOperation {

	private boolean shouldPasteAlwaysCopyObject;

	/**
	 * @param overriddenChildPasteOperation
	 */
	public PositionalGeneralViewPasteOperation(
			PasteChildOperation overriddenChildPasteOperation,
			boolean shouldPasteAlwaysCopyObject) {
		super(overriddenChildPasteOperation);
		this.shouldPasteAlwaysCopyObject = shouldPasteAlwaysCopyObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gmf.runtime.emf.clipboard.core.PasteChildOperation#paste()
	 */
	public void paste() throws Exception {
		// delay unsetting of connector refs
	}

	protected boolean shouldPasteAlwaysCopyObject(
			ObjectInfo alwaysCopyObjectInfo) {
		return shouldPasteAlwaysCopyObject;
	}

	public PasteChildOperation getPostPasteOperation() {

		return new PostPasteChildOperation(this, EMPTY_ARRAY) {

			public void paste() throws Exception {
				// unset connectors before pasting so that it won't affect
				// real connectors especially if they happen to belong to the
				// same
				// target diagram
				Node view = (Node) getEObject();
				view.eUnset(NotationPackage.eINSTANCE.getView_SourceEdges());
				view.eUnset(NotationPackage.eINSTANCE.getView_TargetEdges());

				// now paste view
				EObject pastedElement = doPasteInto(getParentEObject());
				// did we succeed?
				if (pastedElement != null) {
					setPastedElement(pastedElement);
					addPastedElement(pastedElement);
				} else {
					addPasteFailuresObject(getEObject());
				}
			}

			protected boolean shouldPasteAlwaysCopyObject(
					ObjectInfo alwaysCopyObjectInfo) {
				return PositionalGeneralViewPasteOperation.this
						.shouldPasteAlwaysCopyObject(alwaysCopyObjectInfo);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.gmf.runtime.emf.core.internal.copypaste.
			 * PasteChildOperation
			 * #makeAuxiliaryChildPasteProcess(org.eclipse.gmf
			 * .runtime.emf.core.internal.copypaste.ObjectInfo)
			 */
			@SuppressWarnings("restriction")
			protected PasteChildOperation makeAuxiliaryChildPasteProcess(
					ObjectInfo auxiliaryChildEObjectInfo) {
				EObject semanticPasteTarget = NotationClipboardOperationHelper
						.getSemanticPasteTarget((View) getPastedElement());
				if (semanticPasteTarget == null) {
					return null;
				}
				return new PasteChildOperation(getParentPasteProcess().clone(
						semanticPasteTarget), auxiliaryChildEObjectInfo);
			}

			public PasteChildOperation getPostPasteOperation() {
				List operations = getAlwaysCopyObjectPasteOperations();
				return new PostPasteChildOperation(this, operations);
			}
		};
	}

}