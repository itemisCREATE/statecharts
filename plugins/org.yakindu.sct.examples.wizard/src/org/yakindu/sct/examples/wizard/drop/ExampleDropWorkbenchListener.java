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
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.URLTransfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
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
public class ExampleDropWorkbenchListener implements IPartListener2, IPageListener, IPerspectiveListener, IWindowListener {

	public void perspectiveActivated(IWorkbenchPage page, IPerspectiveDescriptor perspective) {
		pageChanged(page);
	}

	public void perspectiveChanged(IWorkbenchPage page, IPerspectiveDescriptor perspective, String changeId) {
	}

	public void pageActivated(IWorkbenchPage page) {
		pageChanged(page);
	}

	public void pageClosed(IWorkbenchPage page) {
	}

	public void pageOpened(IWorkbenchPage page) {
		pageChanged(page);
	}

	private void pageChanged(IWorkbenchPage page) {
		if (page == null) {
			return;
		}
		IWorkbenchWindow workbenchWindow = page.getWorkbenchWindow();
		windowChanged(workbenchWindow);
	}

	public void windowActivated(IWorkbenchWindow window) {
		windowChanged(window);
	}

	private void windowChanged(IWorkbenchWindow window) {
		if (window == null) {
			return;
		}
		Shell shell = window.getShell();
		runUpdate(shell);
	}

	public void windowDeactivated(IWorkbenchWindow window) {
	}

	public void windowClosed(IWorkbenchWindow window) {
	}

	public void windowOpened(IWorkbenchWindow window) {
		hookWindow(window);
	}

	public void hookWindow(IWorkbenchWindow window) {
		if (window == null) {
			return;
		}
		window.addPageListener(this);
		window.addPerspectiveListener(this);
		IPartService partService = window.getService(IPartService.class);
		partService.addPartListener(this);
		windowChanged(window);
	}

	public void partOpened(IWorkbenchPartReference partRef) {
		partUpdate(partRef);
	}

	public void partActivated(IWorkbenchPartReference partRef) {
		partUpdate(partRef);
	}

	public void partBroughtToTop(IWorkbenchPartReference partRef) {
		partUpdate(partRef);
	}

	public void partVisible(IWorkbenchPartReference partRef) {
	}

	public void partClosed(IWorkbenchPartReference partRef) {
		partUpdate(partRef);
	}

	public void partDeactivated(IWorkbenchPartReference partRef) {
		partUpdate(partRef);
	}

	public void partHidden(IWorkbenchPartReference partRef) {
		partUpdate(partRef);
	}

	public void partInputChanged(IWorkbenchPartReference partRef) {
	}

	private void partUpdate(IWorkbenchPartReference partRef) {
		if (partRef == null) {
			return;
		}
		IWorkbenchPage page = partRef.getPage();
		pageChanged(page);
	}

	private void runUpdate(final Shell shell) {
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
						installDropTarget(shell);
					}
				}
			});
		} catch (SWTException ex) {
			if (ex.code == SWT.ERROR_DEVICE_DISPOSED) {
				// ignore
				return;
			}
			// TODO report
		} catch (RuntimeException ex) {
			// TODO report
		}
	}

	private static final int DROP_OPERATIONS = DND.DROP_MOVE | DND.DROP_COPY | DND.DROP_LINK | DND.DROP_DEFAULT;

	private final DropTargetAdapter dropListener = new ExampleDropTargetListener();

	private Transfer[] transferAgents;

	public void installDropTarget(final Shell shell) {
		hookUrlTransfer(shell, dropListener);
	}

	private DropTarget hookUrlTransfer(final Shell shell, DropTargetAdapter dropListener) {
		DropTarget target = findDropTarget(shell);
		if (target != null) {
			// target exists, get it and check proper registration
			registerWithExistingTarget(target);
		} else {
			target = new DropTarget(shell, DROP_OPERATIONS);
			if (transferAgents == null) {
				transferAgents = new Transfer[]{URLTransfer.getInstance()};
			}
			target.setTransfer(transferAgents);
		}
		registerDropListener(target, dropListener);

		Control[] children = shell.getChildren();
		for (Control child : children) {
			hookRecursive(child, dropListener);
		}
		return target;
	}

	private void registerDropListener(DropTarget target, DropTargetListener dropListener) {
		target.removeDropListener(dropListener);
		target.addDropListener(dropListener);
	}

	private void hookRecursive(Control child, DropTargetListener dropListener) {
		DropTarget childTarget = findDropTarget(child);
		if (childTarget != null) {
			registerWithExistingTarget(childTarget);
			registerDropListener(childTarget, dropListener);
		}
		if (child instanceof Composite) {
			Composite composite = (Composite) child;
			Control[] children = composite.getChildren();
			for (Control control : children) {
				hookRecursive(control, dropListener);
			}
		}
	}

	private void registerWithExistingTarget(DropTarget target) {
		Transfer[] transfers = target.getTransfer();
		boolean exists = false;
		if (transfers != null) {
			for (Transfer transfer : transfers) {
				if (transfer instanceof URLTransfer) {
					exists = true;
					break;
				}
			}
			if (!exists) {
				Transfer[] newTransfers = new Transfer[transfers.length + 1];
				System.arraycopy(transfers, 0, newTransfers, 0, transfers.length);
				newTransfers[transfers.length] = URLTransfer.getInstance();
				target.setTransfer(newTransfers);
			}
		}
	}

	private DropTarget findDropTarget(Control control) {
		Object object = control.getData(DND.DROP_TARGET_KEY);
		if (object instanceof DropTarget) {
			return (DropTarget) object;
		}
		return null;
	}
}
