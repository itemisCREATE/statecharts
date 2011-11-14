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

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;

/**
 * Will expand/collapse all expandable elements on double click and
 * check/uncheck all others.
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class TreeExpandingDoubleClickListener implements IDoubleClickListener {
	private final CheckboxTreeViewer treeViewer;

	public TreeExpandingDoubleClickListener(CheckboxTreeViewer treeViewer) {
		super();
		this.treeViewer = treeViewer;
	}

	public void doubleClick(DoubleClickEvent event) {
		IStructuredSelection selection = (IStructuredSelection) event
				.getSelection();
		Object firstElement = selection.getFirstElement();
		if (treeViewer.isExpandable(firstElement)) {
			boolean expanded = treeViewer.getExpandedState(firstElement);
			treeViewer.setExpandedState(firstElement, !expanded);
		} else {
			treeViewer.setChecked(firstElement,
					!treeViewer.getChecked(firstElement));
		}
	}
}
