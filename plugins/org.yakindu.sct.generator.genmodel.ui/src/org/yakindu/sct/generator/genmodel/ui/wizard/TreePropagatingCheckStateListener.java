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
import org.eclipse.jface.viewers.ICheckStateListener;

/**
 * Will propagate the check/uncheck event to subtrees of expandable elements
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class TreePropagatingCheckStateListener implements
		ICheckStateListener {

	private final CheckboxTreeViewer treeViewer;

	public TreePropagatingCheckStateListener(CheckboxTreeViewer treeViewer) {
		super();
		this.treeViewer = treeViewer;
	}

	public void checkStateChanged(CheckStateChangedEvent event) {
		Object element = event.getElement();
		if (treeViewer.isExpandable(element)) {
			treeViewer.setSubtreeChecked(element, event.getChecked());
		}
	}

}
