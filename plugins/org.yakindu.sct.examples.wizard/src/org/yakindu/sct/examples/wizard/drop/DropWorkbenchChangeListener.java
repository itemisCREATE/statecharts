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

import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IPartService;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IPerspectiveListener;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * Copied from
 * {@link org.eclipse.epp.internal.mpc.ui.wizards.MarketplaceDropAdapter}.
 * 
 */
public class DropWorkbenchChangeListener
		implements
			IPartListener2,
			IPageListener,
			IPerspectiveListener,
			IWindowListener {

	private IDropTargetInstaller dropTargetInstaller = getDropTargetInstaller();
	
	protected IDropTargetInstaller getDropTargetInstaller() {
		return new ExampleDropTargetInstaller();
	}
	
	@Override
	public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
		pageChanged(page);
	}

	@Override
	public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, String changeId) {
	}

	@Override
	public void pageActivated(IWorkbenchPage page) {
		pageChanged(page);
	}

	@Override
	public void pageClosed(IWorkbenchPage page) {
	}

	@Override
	public void pageOpened(IWorkbenchPage page) {
		pageChanged(page);
	}

	protected void pageChanged(IWorkbenchPage page) {
		if (page == null) {
			return;
		}
		IWorkbenchWindow workbenchWindow = page.getWorkbenchWindow();
		windowChanged(workbenchWindow);
	}

	@Override
	public void windowActivated(IWorkbenchWindow window) {
		windowChanged(window);
	}

	protected void windowChanged(IWorkbenchWindow window) {
		if (window == null) {
			return;
		}
		Shell shell = window.getShell();
		runUpdate(shell);
	}

	@Override
	public void windowDeactivated(IWorkbenchWindow window) {
	}

	@Override
	public void windowClosed(IWorkbenchWindow window) {
	}

	@Override
	public void windowOpened(IWorkbenchWindow window) {
		hookWindow(window);
	}

	protected void hookWindow(IWorkbenchWindow window) {
		if (window == null) {
			return;
		}
		window.addPageListener(this);
		window.addPerspectiveListener(this);
		IPartService partService = (IPartService) window.getService(IPartService.class);
		partService.addPartListener(this);
		windowChanged(window);
	}

	@Override
	public void partOpened(IWorkbenchPartReference partRef) {
		partUpdate(partRef);
	}

	@Override
	public void partActivated(IWorkbenchPartReference partRef) {
		partUpdate(partRef);
	}

	@Override
	public void partBroughtToTop(IWorkbenchPartReference partRef) {
		partUpdate(partRef);
	}

	@Override
	public void partVisible(IWorkbenchPartReference partRef) {
	}

	@Override
	public void partClosed(IWorkbenchPartReference partRef) {
		partUpdate(partRef);
	}

	@Override
	public void partDeactivated(IWorkbenchPartReference partRef) {
		partUpdate(partRef);
	}

	@Override
	public void partHidden(IWorkbenchPartReference partRef) {
		partUpdate(partRef);
	}

	@Override
	public void partInputChanged(IWorkbenchPartReference partRef) {
	}

	protected void partUpdate(IWorkbenchPartReference partRef) {
		if (partRef == null) {
			return;
		}
		IWorkbenchPage page = partRef.getPage();
		pageChanged(page);
	}

	protected void runUpdate(final Shell shell) {
		if (shell == null || shell.isDisposed()) {
			return;
		}
		Display display = shell.getDisplay();
		if (display == null || display.isDisposed()) {
			return;
		}
		try {
			display.asyncExec(new Runnable() {

				public void run() {
					if (!shell.isDisposed()) {
						dropTargetInstaller.installDropTarget(shell);
					}
				}
			});
		} catch (SWTException ex) {
			if (ex.code == SWT.ERROR_DEVICE_DISPOSED) {
				// ignore
				return;
			}
			ex.printStackTrace();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
		}
	}

}
