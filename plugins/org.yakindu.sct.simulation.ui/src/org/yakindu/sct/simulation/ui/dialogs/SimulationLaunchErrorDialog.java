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
import org.eclipse.debug.core.model.IDebugTarget;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SimulationLaunchErrorDialog extends ErrorDialog {

	protected List<IDebugTarget> targets;

	private static final int RELAUNCH_ID = 42;

	public SimulationLaunchErrorDialog(Shell parentShell, String dialogTitle, String message, IStatus status,
			List<IDebugTarget> target) {
		super(parentShell, dialogTitle, message, status, IStatus.WARNING | IStatus.ERROR | IStatus.INFO);
		this.targets = target;
	}

	protected void createButtonsForButtonBar(Composite parent) {
		super.createButtonsForButtonBar(parent);
		getButton(IDialogConstants.OK_ID).setText("Terminate");
		createButton(parent, RELAUNCH_ID, "Relaunch", false);
	}

	@Override
	protected void createDetailsButton(Composite parent) {
		// No Detail section required
	}

	protected Button createButton(Composite parent, int id, String label, boolean defaultButton) {
		Button button = super.createButton(parent, id, label, defaultButton);
		return button;
	}

	protected void buttonPressed(final int id) {
		try {
			if (id == IDialogConstants.OK_ID) {
				for (IDebugTarget target : targets) {
					target.getLaunch().terminate();
				}
			} else if (id == RELAUNCH_ID) {
				for (IDebugTarget target : targets) {
					target.getLaunch().terminate();
					ILaunchConfiguration launchConfiguration = target.getLaunch().getLaunchConfiguration();
					DebugUITools.launch(launchConfiguration, target.getLaunch().getLaunchMode());
				}
			}
		} catch (DebugException e) {
			e.printStackTrace();
		}
		okPressed();
	}
}
