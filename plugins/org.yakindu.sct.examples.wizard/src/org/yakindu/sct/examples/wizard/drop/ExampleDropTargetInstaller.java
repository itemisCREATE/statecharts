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

import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetListener;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.dnd.URLTransfer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

/**
 * Copied from
 * {@link org.eclipse.epp.internal.mpc.ui.wizards.MarketplaceDropAdapter}.
 * 
 */
public class ExampleDropTargetInstaller implements IDropTargetInstaller {

	private final DropTargetAdapter dropListener = getDropTargetListener();

	private Transfer[] transferAgents;

	public void installDropTarget(final Shell shell) {
		hookUrlTransfer(shell, dropListener);
	}
	
	protected DropTargetAdapter getDropTargetListener() {
		return new ExampleDropTargetListener();
	}

	protected DropTarget hookUrlTransfer(final Shell shell, DropTargetAdapter dropListener) {
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

	protected void registerDropListener(DropTarget target, DropTargetListener dropListener) {
		target.removeDropListener(dropListener);
		target.addDropListener(dropListener);
	}

	protected void hookRecursive(Control child, DropTargetListener dropListener) {
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

	protected void registerWithExistingTarget(DropTarget target) {
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

	protected DropTarget findDropTarget(Control control) {
		Object object = control.getData(DND.DROP_TARGET_KEY);
		if (object instanceof DropTarget) {
			return (DropTarget) object;
		}
		return null;
	}
}
