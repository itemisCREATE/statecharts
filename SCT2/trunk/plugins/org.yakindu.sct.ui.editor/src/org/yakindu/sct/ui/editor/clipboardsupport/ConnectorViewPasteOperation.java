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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardSupportUtil;
import org.eclipse.gmf.runtime.emf.clipboard.core.ObjectInfo;
import org.eclipse.gmf.runtime.emf.clipboard.core.OverridePasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PostPasteChildOperation;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This is a copy of
 * {@link org.eclipse.gmf.runtime.notation.providers.internal.copypaste.ConnectorViewPasteOperation}
 * . It calls a static method of the {@link NotationClipboardOperationHelper}
 * 
 */
@SuppressWarnings("all")
public class ConnectorViewPasteOperation
	extends OverridePasteChildOperation {

	private boolean pasteSemanticElement;

	private Edge connectorView;

	private View sourceView;

	private View targetView;

	/**
	 * @param overriddenChildPasteOperation
	 */
	public ConnectorViewPasteOperation(
		PasteChildOperation overriddenChildPasteOperation) {
		super(overriddenChildPasteOperation);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.clipboard.core.PasteChildOperation#paste()
	 */
	public void paste() throws Exception {
		//basically delay...
		connectorView = (Edge) getEObject();
		sourceView = connectorView.getSource();
		targetView = connectorView.getTarget();
		EObject element = connectorView.getElement();
		if (element != null) {
			if (element.eIsProxy()) {
				element = ClipboardSupportUtil.resolve(element,
					getParentPasteProcess().getLoadedIDToEObjectMapCopy());
			}
			if (element.eIsProxy() == false) {
				pasteSemanticElement = true;
			}
		}
	}

	protected boolean shouldPasteAlwaysCopyObject(
		ObjectInfo alwaysCopyObjectInfo) {
		return false;
	}

	protected PasteChildOperation makeAuxiliaryChildPasteProcess(
		ObjectInfo auxiliaryChildEObjectInfo) {
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.clipboard.core.PasteChildOperation#getPostPasteOperation()
	 */
	public PasteChildOperation getPostPasteOperation() {
		return new PostPasteChildOperation(this, EMPTY_ARRAY) {

			public void paste() throws Exception {
				//delay
			}

			public PasteChildOperation getPostPasteOperation() {
				return new PostPasteChildOperation(this, EMPTY_ARRAY) {

					public void paste() throws Exception {
						//delay
					}

					public PasteChildOperation getPostPasteOperation() {
						return new ConnectorViewPostPasteChildOperation(
							ConnectorViewPasteOperation.this,
							ConnectorViewPasteOperation.this.pasteSemanticElement);
					}
				};
			}
		};
	}

	protected ObjectInfo getChildObjectInfo() {
		return super.getChildObjectInfo();
	}

	protected List getAlwaysCopyObjectPasteOperations() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * @return Returns the sourceView.
	 */
	protected View getSourceView() {
		return sourceView;
	}

	/**
	 * @return Returns the targetView.
	 */
	protected View getTargetView() {
		return targetView;
	}

	/**
	 * @return Returns the connectorView.
	 */
	protected Edge getConnectorView() {
		return connectorView;
	}
}