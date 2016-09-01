/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.examples.wizard.drop;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.progress.UIJob;

/**
 * 
 * Copied from {@link org.eclipse.epp.internal.mpc.ui.wizards.MarketplaceDropAdapter}.
 *
 */
public class ExampleDropSupportRegistrar implements IStartup {

	private final DropWorkbenchChangeListener workbenchListener = new DropWorkbenchChangeListener();

	@Override
	public void earlyStartup() {
		registerExampleDropAdapter();
	}
	
	private void registerExampleDropAdapter() {
		UIJob registerJob = new UIJob(Display.getDefault(), "Registering example drop adapter.") {
			{
				setPriority(Job.SHORT);
				setSystem(true);
			}

			@Override
			public IStatus runInUIThread(IProgressMonitor monitor) {
				IWorkbench workbench = PlatformUI.getWorkbench();
				workbench.addWindowListener(workbenchListener);
				IWorkbenchWindow[] workbenchWindows = workbench
						.getWorkbenchWindows();
				for (IWorkbenchWindow window : workbenchWindows) {
					workbenchListener.hookWindow(window);
				}
				return Status.OK_STATUS;
			}

		};
		registerJob.schedule();
	}

}
