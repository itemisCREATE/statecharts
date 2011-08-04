package org.yakindu.sct.ui.editor.policies;

import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;

/**
 * 
 * @author martin esser
 * 
 */
public class ContextSensitiveHelpPolicy extends SelectionEditPolicy {

	private String helpContextId;

	
	public ContextSensitiveHelpPolicy(String helpContextId) {
		this.helpContextId = helpContextId;
	}

	@Override
	protected void showSelection() {
		if (StatechartDiagramEditor.isDynamicHelpViewShowing()) {
			displayViewerHelpContext(helpContextId);
			// Simple, but unreliable alternative
			// PlatformUI.getWorkbench().getHelpSystem().displayHelp(helpContextId);
		}
	}

	@Override
	protected void hideSelection() {
		if (StatechartDiagramEditor.isDynamicHelpViewShowing()) {
			displayViewerHelpContext(IYakinduSctHelpContextIds.SC_EDITOR_GRAPHICAL_VIEWER);
			// Simple, but unreliable alternative
			// PlatformUI.getWorkbench().getHelpSystem().displayHelp(IYakinduSctHelpContextIds.SC_EDITOR_GRAPHICAL_VIEWER);
		}
	}

	private void displayViewerHelpContext(String helpContextId) {
		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(getHost().getViewer().getControl(), helpContextId);
		PlatformUI.getWorkbench().getHelpSystem().displayDynamicHelp();
	}

}
