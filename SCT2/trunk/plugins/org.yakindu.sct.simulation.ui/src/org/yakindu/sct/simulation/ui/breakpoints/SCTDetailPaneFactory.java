/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.breakpoints;

import static org.yakindu.sct.simulation.ui.breakpoints.SCTBreakpointDetailPane.SCT_BREAKPOINT_PANE;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.debug.ui.IDetailPane;
import org.eclipse.debug.ui.IDetailPaneFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.yakindu.sct.simulation.core.breakpoints.SCTBreakpoint;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTDetailPaneFactory implements IDetailPaneFactory {

	public Set<String> getDetailPaneTypes(IStructuredSelection selection) {
		Set<String> possibleIDs = new HashSet<String>(1);
		Object object = unwrap(selection);
		if (object instanceof SCTBreakpoint)
			possibleIDs.add(SCT_BREAKPOINT_PANE);
		return possibleIDs;
	}

	public String getDefaultDetailPane(IStructuredSelection selection) {
		return SCT_BREAKPOINT_PANE;
	}

	public IDetailPane createDetailPane(String paneID) {
		if (SCT_BREAKPOINT_PANE.equals(paneID)) {
			return new SCTBreakpointDetailPane();
		}
		return null;
	}

	public String getDetailPaneName(String paneID) {
		return SCT_BREAKPOINT_PANE;
	}

	public String getDetailPaneDescription(String paneID) {
		return "SCT Breakpoints";
	}

	public Object unwrap(ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		return structuredSelection.getFirstElement();
	}

}
