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
package org.yakindu.sct.ui.editor.wizards;

import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jface.dialogs.MessageDialogWithToggle;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveRegistry;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.osgi.service.prefs.BackingStoreException;
import org.yakindu.sct.ui.UIPluginActivator;
import org.yakindu.sct.ui.perspectives.IYakinduSctPerspectives;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class PerspectiveUtil {

	public static final String AUTO_SWITCH_PERSPECTIVE = "AutoSwitchPerspective";

	public static void switchToModelingPerspective(IWorkbenchWindow window) {
		IPreferenceStore prefs = UIPluginActivator.getDefault()
				.getPreferenceStore();
		boolean hide = prefs.getBoolean(AUTO_SWITCH_PERSPECTIVE);
		IWorkbenchPage page = window.getActivePage();
		if (!hide) {
			IWorkbench workbench = window.getWorkbench();
			IPerspectiveRegistry registry = workbench.getPerspectiveRegistry();
			IPerspectiveDescriptor descriptor = registry
					.findPerspectiveWithId(IYakinduSctPerspectives.ID_PERSPECTIVE_SCT_MODELING);
			if ((page != null) && (page.getPerspective() != descriptor)) {
				MessageDialogWithToggle dialog = MessageDialogWithToggle
						.openYesNoQuestion(
								window.getShell(),
								"Confirm Perspective Switch",
								"This kind of editor is associated with the YAKINDU Modeling perspective. Do you want to switch to this perspective now?",
								"Do not offer to switch perspective in the future",
								hide, prefs, AUTO_SWITCH_PERSPECTIVE);
				if (dialog.getReturnCode() == 2)
					page.setPerspective(descriptor);
				hide = dialog.getToggleState();
				prefs.setValue(AUTO_SWITCH_PERSPECTIVE, hide);
				try {
					InstanceScope.INSTANCE.getNode(UIPluginActivator.PLUGIN_ID)
							.flush();
				} catch (BackingStoreException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
