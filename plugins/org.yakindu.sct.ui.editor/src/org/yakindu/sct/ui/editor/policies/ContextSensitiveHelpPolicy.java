/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.policies;

import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;

/**
 * Adds context-sensitive help to the host <code>EditPart</code>. 
 * 
 * @see org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds
 * 
 * @author martin esser
 * 
 */
public class ContextSensitiveHelpPolicy extends SelectionEditPolicy {

	// Duplicate of the internal constant used to register the help view as a UI
	// extension.
	// @see org.eclipse.help.ui.internalDefaulHelptUI#HELP_VIEW_ID
	private final static String HELP_VIEW_ID = "org.eclipse.help.ui.HelpView";
	
	private String helpContextId;

	public ContextSensitiveHelpPolicy(String helpContextId) {
		this.helpContextId = helpContextId;
	}

	@Override
	protected void showSelection() {
		if (isDynamicHelpViewShowing()) {
				displayViewerHelpContext(helpContextId);
		}
	}

	@Override
	protected void hideSelection() {
		if (isDynamicHelpViewShowing()) {
			displayViewerHelpContext(IYakinduSctHelpContextIds.SC_EDITOR_GRAPHICAL_VIEWER);
		}
	}

	private void displayViewerHelpContext(String helpContextId) {
		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(getHost().getViewer().getControl(), helpContextId);
		PlatformUI.getWorkbench().getHelpSystem().displayDynamicHelp();
	}
	
	public static boolean isDynamicHelpViewShowing() {
		boolean open = false;
		IWorkbenchWindow activeWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (activeWindow != null) {
			IWorkbenchPage activePage = activeWindow.getActivePage();
			if (activePage != null) {
				IViewPart view = activePage.findView(HELP_VIEW_ID);
				if (view != null) {
					open = true;
				}
			}
		}
		return open;
	}

}
