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
package org.yakindu.sct.ui.editor.definitionsection;

import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.ui.IWorkbenchPartSite;
import org.yakindu.base.xtext.utils.jface.viewers.StyledTextXtextAdapter;

/**
 * Extends {@link StyledTextXtextAdapter.ChangeSelectionProviderOnFocusGain} to
 * be able to release selection of previous selection provider. This in needed
 * to be able to perform keyboard shortcuts on the text in the statechart
 * definition section without interacting with the elements of the diagram.
 * 
 * @author robert rudi - Initial contribution and API
 */
public class ReleaseSelectionOnFocusGain extends StyledTextXtextAdapter.ChangeSelectionProviderOnFocusGain {

	public ReleaseSelectionOnFocusGain(IWorkbenchPartSite site, ISelectionProvider selectionProviderOnFocusGain) {
		super(site, selectionProviderOnFocusGain);
	}

	public void focusGained(FocusEvent e) {
		releaseSelection();
		super.focusGained(e);
	}

	protected void releaseSelection() {
		if (site != null && this.selectionProviderOnFocusGain != null
				&& !site.getSelectionProvider().equals(selectionProviderOnFocusGain))
			site.getSelectionProvider().setSelection(StructuredSelection.EMPTY);
	}
}