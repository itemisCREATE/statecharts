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
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.ExecutionSlot;
import org.yakindu.sct.simulation.core.sruntime.ReferenceSlot;
import org.yakindu.sct.simulation.ui.SimulationImages;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExpandAllAction extends Action {

	private TreeViewer fViewer;

	public ExpandAllAction(TreeViewer viewer) {
		super("Expand all");
		fViewer = viewer;
		setToolTipText("Expand all");
		setImageDescriptor(SimulationImages.EXPAND_ALL.imageDescriptor());
	}

	public void run() {
		if (fViewer != null) {
			// do not expand ReferenceSlot which may cause circular expansions resulting in stack overflows
			if (fViewer.getInput() instanceof ExecutionContext) {
				ExecutionContext executionContext = (ExecutionContext) fViewer.getInput();
				for (ExecutionSlot slot : executionContext.getAllSlots()) {
					if (!(slot instanceof ReferenceSlot)) {
						fViewer.expandToLevel(slot, 1);
					}
				}
			}
			else {
				fViewer.expandAll();
			}
		}
	}
}
