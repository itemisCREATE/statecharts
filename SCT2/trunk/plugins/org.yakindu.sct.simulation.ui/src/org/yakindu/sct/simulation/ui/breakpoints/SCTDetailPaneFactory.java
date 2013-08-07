package org.yakindu.sct.simulation.ui.breakpoints;

import static org.yakindu.sct.simulation.ui.breakpoints.SCTBreakpointDetailPane.SCT_BREAKPOINT_PANE;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.debug.ui.IDetailPane;
import org.eclipse.debug.ui.IDetailPaneFactory;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.yakindu.sct.simulation.core.breakpoints.SCTBreakpoint;

public class SCTDetailPaneFactory implements IDetailPaneFactory {

	public Set<String> getDetailPaneTypes(IStructuredSelection selection) {
		Set<String> possibleIDs = new HashSet<String>(1);
		Object object = unwrap(selection);
		if (object instanceof SCTBreakpoint)
			possibleIDs.add(SCT_BREAKPOINT_PANE);
		return possibleIDs;
	}

	public String getDefaultDetailPane(IStructuredSelection selection) {
		return null;
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
		return null;
	}

	public Object unwrap(ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		return structuredSelection.getFirstElement();
	}

}
