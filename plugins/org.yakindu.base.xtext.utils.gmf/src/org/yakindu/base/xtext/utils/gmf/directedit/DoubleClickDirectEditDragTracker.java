/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.base.xtext.utils.gmf.directedit;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.gef.ui.internal.tools.DelegatingDragEditPartsTracker;

/**
 * Delegates the double click event to a callback, used for creating direct edit
 * requests on double click
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class DoubleClickDirectEditDragTracker extends
		DelegatingDragEditPartsTracker {

	public interface IDoubleClickCallback {
		public void handleDoubleClick(int btn);
	}

	private IDoubleClickCallback callback;

	public DoubleClickDirectEditDragTracker(EditPart delegatingEditPart,
			EditPart delegateEditPart, IDoubleClickCallback callback) {
		super(delegatingEditPart, delegateEditPart);
		this.callback = callback;
	}

	@Override
	protected boolean handleDoubleClick(int button) {
		callback.handleDoubleClick(button);
		return true;
	}

}
