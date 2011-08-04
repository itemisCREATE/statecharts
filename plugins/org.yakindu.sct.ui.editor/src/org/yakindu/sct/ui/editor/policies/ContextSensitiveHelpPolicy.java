package org.yakindu.sct.ui.editor.policies;

import java.util.Arrays;

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
	// private String editPartViewerInitialHelpContextId;
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
				// editPartViewerInitialHelpContextId =
				// getEditPartViewerInitialHelpContextId();
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

	/*
	 * Called to save the original help context id set on the statechart
	 * editor's <code>EditPartViewer</code> so that it can be restored when
	 * switching back and forth between individual <code>EditPart</code>s and
	 * their associated contexts. Assumes that the concrete implementation of
	 * <code>IWorkbenchHelpSystem</code> used in this scenario relies on the
	 * <code>Widget</code> class's data field to store the help context id.
	 * 
	 * @see org.eclipse.ui.internal.help.WorkbenchHelpSystem#HELP_KEY
	 * 
	 * @see org.eclipse.swt.widgets.Widget#setData(Object)
	 * 
	 * @see #helpViewListener
	 */
	protected String getEditPartViewerInitialHelpContextId() {
		String dummyHelpContextId = "dummy_context_id";
		String editPartViewerInitialHelpContextId = null;

		Object[] widgetData = (Object[]) getHost().getViewer().getControl()
				.getData();
		if (!(widgetData == null)) {
			// Save the original widget data
			Object[] savedWidgetData = Arrays.copyOf(widgetData,
					widgetData.length);
			PlatformUI
					.getWorkbench()
					.getHelpSystem()
					.setHelp(getHost().getViewer().getControl(),
							dummyHelpContextId);
			Object[] changedWidgetData = (Object[]) getHost().getViewer()
					.getControl().getData();

			// Determine help key by searching the widget data for the dummy
			// context id just inserted
			String helpKey = null;
			boolean found = false;
			int i = 0;
			while (i < changedWidgetData.length && !found) {
				found = dummyHelpContextId.equals(changedWidgetData[i]);
				if (found) {
					helpKey = (String) changedWidgetData[i - 1];
				}
				i++;
			}

			// Determine the initial help context id registered for the
			// editPartViewer
			found = false;
			i = 0;
			while (i < savedWidgetData.length - 1 && !found) {
				found = helpKey.equals(savedWidgetData[i]);
				if (found) {
					editPartViewerInitialHelpContextId = (String) savedWidgetData[i + 1];
				}
				i++;
			}

			// Restore the original help context id for the widget
			PlatformUI.getWorkbench().getHelpSystem()
					.setHelp(getHost().getViewer().getControl(), helpContextId);
		}
		return editPartViewerInitialHelpContextId;
	}
}
