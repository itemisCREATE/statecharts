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
package org.yakindu.sct.simulation.ui.view.actions;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.yakindu.sct.simulation.ui.DeclarationImages;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class CollapseAllAction extends Action {

	private TreeViewer fViewer;

	public CollapseAllAction(TreeViewer viewer) {
		super("Collapse all");
		fViewer = viewer;
		setToolTipText("Collapse all");
		setImageDescriptor(DeclarationImages.COLLAPSE_ALL.imageDescriptor());
	}

	public void run() {
		if (fViewer != null) {
			fViewer.collapseAll();
		}
	}
}
