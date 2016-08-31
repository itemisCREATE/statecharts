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

import org.eclipse.jface.util.Util;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.swt.dnd.URLTransfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.examples.wizard.ExampleWizard;

/**
 * Mostly copied from
 * {@link org.eclipse.epp.internal.mpc.ui.wizards.MarketplaceDropAdapter}.
 * 
 * @author Thomas Kutz - Adjusted {@link #proceedInstallation(String)} method to
 *         open example wizard with preselected example based on dropped URL.
 * 
 */
public class ExampleDropTargetListener extends DropTargetAdapter {

	private static final int[] PREFERRED_DROP_OPERATIONS = {DND.DROP_DEFAULT, DND.DROP_COPY, DND.DROP_MOVE,
			DND.DROP_LINK};

	@Override
	public void dragEnter(DropTargetEvent e) {
		updateDragDetails(e);
	}

	@Override
	public void dragOver(DropTargetEvent e) {
		updateDragDetails(e);
	}

	@Override
	public void dragLeave(DropTargetEvent e) {
		if (e.detail == DND.DROP_NONE) {
			setDropOperation(e);
		}
	}

	@Override
	public void dropAccept(DropTargetEvent e) {
		updateDragDetails(e);
	}

	@Override
	public void dragOperationChanged(DropTargetEvent e) {
		updateDragDetails(e);
	}

	private void setDropOperation(DropTargetEvent e) {
		int allowedOperations = e.operations;
		for (int op : PREFERRED_DROP_OPERATIONS) {
			if ((allowedOperations & op) != 0) {
				e.detail = op;
				return;
			}
		}
		e.detail = allowedOperations;
	}

	private void updateDragDetails(DropTargetEvent e) {
		if (dropTargetIsValid(e, false)) {
			setDropOperation(e);
		}
	}

	private boolean dropTargetIsValid(DropTargetEvent e, boolean isDrop) {
		if (URLTransfer.getInstance().isSupportedType(e.currentDataType)) {
			// on Windows, we get the URL already during drag operations...
			// FIXME find a way to check the URL early on other platforms,
			// too...
			if (isDrop || Util.isWindows()) {
				if (e.data == null && !extractEventData(e)) {
					// ... but if we don't, it's no problem, unless this is
					// already
					// the final drop event
					return !isDrop;
				}
				final String url = getUrl(e.data);
				if (!ExampleURLHandler.isValidExample(url)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

	private boolean extractEventData(DropTargetEvent e) {
		TransferData transferData = e.currentDataType;
		if (transferData != null) {
			Object data = URLTransfer.getInstance().nativeToJava(transferData);
			if (data != null && getUrl(data) != null) {
				e.data = data;
				return true;
			}
		}
		return false;
	}

	@Override
	public void drop(DropTargetEvent event) {
		if (!URLTransfer.getInstance().isSupportedType(event.currentDataType)) {
			return;
		}
		final String url = getUrl(event.data);

		if (ExampleURLHandler.isValidExample(url)) {
			DropTarget source = (DropTarget) event.getSource();
			Display display = source.getDisplay();
			display.asyncExec(new Runnable() {
				public void run() {
					proceedInstallation(url);
				}
			});
		}
	}

	protected void proceedInstallation(String url) {
		String exampleId = ExampleURLHandler.extractExampleId(url);
		System.out.println("Installing Example: " + exampleId);
		
		createWizardDialog(exampleId);
	}

	private void createWizardDialog(String exampleId) {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		ExampleWizard exampleWizard = new ExampleWizard(exampleId);
		WizardDialog dialog = new WizardDialog(shell, exampleWizard);
		dialog.create();
		dialog.open();
	}

	private String getUrl(Object eventData) {
		if (eventData == null) {
			return null;
		}
		if (eventData == null || !(eventData instanceof String)) {
			return null;
		}
		// Depending on the form the link and browser/os,
		// we get the url twice in the data separated by new lines
		String[] dataLines = ((String) eventData).split(System.getProperty("line.separator")); //$NON-NLS-1$
		String url = dataLines[0];
		return url;
	}
}