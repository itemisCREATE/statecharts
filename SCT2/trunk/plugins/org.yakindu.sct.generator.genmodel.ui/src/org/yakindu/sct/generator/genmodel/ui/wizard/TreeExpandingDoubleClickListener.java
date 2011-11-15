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
package org.yakindu.sct.generator.genmodel.ui.wizard;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;

/**
 * Will expand/collapse all expandable elements on double click and
 * check/uncheck all others.
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class TreeExpandingDoubleClickListener implements IDoubleClickListener {
	private final CheckboxTreeViewer treeViewer;

	private final ICheckStateListener checkStateListener;

	/**
	 * @param treeViewer
	 *            the {@link TreeViewer}
	 * @param checkStateListener
	 *            the {@link ICheckStateListener} to notify if double clicking
	 *            changes a checked state
	 */
	public TreeExpandingDoubleClickListener(CheckboxTreeViewer treeViewer,
			ICheckStateListener checkStateListener) {
		super();
		this.treeViewer = treeViewer;
		this.checkStateListener = checkStateListener;
	}

	/**
	 * @param treeViewer
	 *            the {@link TreeViewer}
	 */
	public TreeExpandingDoubleClickListener(CheckboxTreeViewer treeViewer) {
		this(treeViewer, null);
	}

	public void doubleClick(DoubleClickEvent event) {
		IStructuredSelection selection = (IStructuredSelection) event
				.getSelection();
		Object firstElement = selection.getFirstElement();
		if (treeViewer.isExpandable(firstElement)) {
			boolean expanded = treeViewer.getExpandedState(firstElement);
			treeViewer.setExpandedState(firstElement, !expanded);
		} else {
			// FIXME :: does not trigger validation
			boolean newState = !treeViewer.getChecked(firstElement);
			treeViewer.setChecked(firstElement, newState);
			if (checkStateListener != null) {
				checkStateListener
						.checkStateChanged(new CheckStateChangedEvent(
								treeViewer, firstElement, newState));
			}
		}
	}
}
