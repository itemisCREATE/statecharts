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
package org.yakindu.sct.simulation.ui.dialogs;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.yakindu.sct.simulation.core.debugmodel.SCTDebugTarget;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class HotModelReplaceErrorDialog extends ErrorDialog {

	protected List<SCTDebugTarget> targets;

	private static final int RELAUNCH_ID = 42;

	public HotModelReplaceErrorDialog(Shell parentShell, String dialogTitle,
			String message, IStatus status, List<SCTDebugTarget> target) {
		super(parentShell, dialogTitle, message, status, IStatus.WARNING
				| IStatus.ERROR | IStatus.INFO);
		this.targets = target;
	}

	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		getButton(IDialogConstants.OK_ID).setText("Terminate");
		createButton(parent, RELAUNCH_ID, "Relaunch", false);
	}

	protected Button createButton(Composite parent, int id, String label,
			boolean defaultButton) {
		Button button = super.createButton(parent, id, label, defaultButton);
		return button;
	}

	protected void buttonPressed(final int id) {
		try {
			if (id == IDialogConstants.OK_ID) {
				for (SCTDebugTarget target : targets) {
					target.getLaunch().terminate();
				}
			} else if (id == RELAUNCH_ID) {
				for (SCTDebugTarget target : targets) {
					target.getLaunch().terminate();
					ILaunchConfiguration launchConfiguration = target
							.getLaunch().getLaunchConfiguration();
					DebugUITools.launch(launchConfiguration, target.getLaunch()
							.getLaunchMode());
				}
			}
		} catch (DebugException e) {
			e.printStackTrace();
		}
		okPressed();
	}
}
