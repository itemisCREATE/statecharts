package org.yakindu.sct.ui.editor.policies;

import org.eclipse.gef.editpolicies.SelectionEditPolicy;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;

/**
 * 
 * @author martin esser
 * 
 */
public class ContextSensitiveHelpPolicy extends SelectionEditPolicy {

	protected IPartListener2 helpViewListener = new IPartListener2() {

		public void partOpened(IWorkbenchPartReference partRef) {
			partVisible(partRef);
		}

		public void partVisible(IWorkbenchPartReference partRef) {
			if (HELP_VIEW_ID.equals(partRef.getId())) {
				dynamicHelpViewShowing = true;
			}

		}

		public void partClosed(IWorkbenchPartReference partRef) {
			partHidden(partRef);
		}

		public void partHidden(IWorkbenchPartReference partRef) {
			if (HELP_VIEW_ID.equals(partRef.getId())) {
				dynamicHelpViewShowing = false;
				PlatformUI
						.getWorkbench()
						.getHelpSystem()
						.setHelp(
								getHost().getViewer().getControl(),
								IYakinduSctHelpContextIds.SC_EDITOR_EDITPART_VIEWER);
			}
		}

		public void partActivated(IWorkbenchPartReference partRef) {
			// do nothing
		}

		public void partBroughtToTop(IWorkbenchPartReference partRef) {
			// do nothing
		}

		public void partDeactivated(IWorkbenchPartReference partRef) {
			// do nothing
		}

		public void partInputChanged(IWorkbenchPartReference partRef) {
			// do nothing
		}

	};

	// Copied from extension point
	private final static String HELP_VIEW_ID = "org.eclipse.help.ui.HelpView";

	private String helpContextId;
	private static boolean dynamicHelpViewShowing = false;

	public ContextSensitiveHelpPolicy(String helpContextId) {
		this.helpContextId = helpContextId;
	}

	@Override
	public void activate() {
		super.activate();
		// Workbench might be in the process of starting up
		Runnable runnable = new Runnable() {
			public void run() {
				PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getPartService().addPartListener(helpViewListener);
				// Listener may have missed view opening
				dynamicHelpViewShowing = isDynamicHelpViewShowing();
			}
		};
		Display.getCurrent().asyncExec(runnable);
	}

	@Override
	public void deactivate() {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService()
				.removePartListener(helpViewListener);
		super.deactivate();
	}

	@Override
	protected void showSelection() {
		if (dynamicHelpViewShowing) {
			displayViewerHelpContext(helpContextId);
			// Simple, but unreliable alternative
			// PlatformUI.getWorkbench().getHelpSystem().displayHelp(helpContextId);
		}
	}

	@Override
	protected void hideSelection() {
		if (dynamicHelpViewShowing) {
			displayViewerHelpContext(IYakinduSctHelpContextIds.SC_EDITOR_EDITPART_VIEWER);
			// Simple, but unreliable alternative
			// PlatformUI.getWorkbench().getHelpSystem().displayHelp(IYakinduSctHelpContextIds.SC_EDITOR_EDITPART_VIEWER);
		}
	}

	private static boolean isDynamicHelpViewShowing() {
		boolean open = false;
		IWorkbenchWindow activeWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		if (activeWindow != null) {
			IWorkbenchPage activePage = activeWindow.getActivePage();
			if (activePage != null) {
				IViewPart view = activePage.findView(HELP_VIEW_ID);
				if (view != null) {
					open = true;
				}
			}
		}
		return open;
	}

	private void displayViewerHelpContext(String helpContextId) {
		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(getHost().getViewer().getControl(), helpContextId);
		PlatformUI.getWorkbench().getHelpSystem().displayDynamicHelp();
	}

}
