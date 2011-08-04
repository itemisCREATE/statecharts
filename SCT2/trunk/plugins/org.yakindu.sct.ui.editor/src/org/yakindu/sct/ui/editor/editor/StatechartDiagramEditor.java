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
package org.yakindu.sct.ui.editor.editor;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IGotoMarker;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;
import org.yakindu.sct.ui.editor.validation.ValidationAction;

/**
 * 
 * @author andreas muelder
 * @author martin esser
 */
public class StatechartDiagramEditor extends DiagramDocumentEditor implements
		IGotoMarker {

	public static final String ID = "org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor";

	// Duplicate of the internal constant used to register the help view as a UI
	// extension.
	// @see org.eclipse.help.ui.internalDefaulHelptUI#HELP_VIEW_ID
	private final static String HELP_VIEW_ID = "org.eclipse.help.ui.HelpView";

	// Declared static to prevent problems in case of an access attempt on
	// startup
	private static boolean dynamicHelpViewShowing = false;

	private IPartListener2 dynamicHelpViewListener;

	public StatechartDiagramEditor() {
		super(true);
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);

		getEditingDomain().addResourceSetListener(
				new ResourceSetListenerImpl() {
					@Override
					public void resourceSetChanged(ResourceSetChangeEvent event) {
						Display.getDefault().asyncExec(new Runnable() {
							public void run() {
								if (getDiagram() != null) {
									ValidationAction.validate(
											getDiagramEditPart(), getDiagram());
								}
							}
						});

					}
				});

		// Create the help view listener and register it with the workbench
		Display.getCurrent().asyncExec(new Runnable() {
			public void run() {
				createDynamicHelpViewListener();
				PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getPartService()
						.addPartListener(dynamicHelpViewListener);
				// Listener may have missed view opening
				dynamicHelpViewShowing = askWorkbenchIfDynamicHelpViewShowing();
			}
		});

	}

	public void gotoMarker(IMarker marker) {
		MarkerNavigationService.getInstance().gotoMarker(this, marker);
	}

	@Override
	protected PreferencesHint getPreferencesHint() {
		return DiagramActivator.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	protected void createGraphicalViewer(Composite parent) {
		super.createGraphicalViewer(parent);
		// Tag the viewer with the desired help context id
		PlatformUI
				.getWorkbench()
				.getHelpSystem()
				.setHelp(getGraphicalViewer().getControl(),
						IYakinduSctHelpContextIds.SC_EDITOR_GRAPHICAL_VIEWER); // /CHANGE
																				// ID!!!
	}

	@Override
	public void dispose() {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService()
				.removePartListener(dynamicHelpViewListener);
		super.dispose();
	}

	private void createDynamicHelpViewListener() {
		dynamicHelpViewListener = new IPartListener2() {

			public void partOpened(IWorkbenchPartReference partRef) {
				partVisible(partRef);
			}

			// Will be notified reliably when Dynamic Help View is opened in ANY
			// perspective
			public void partVisible(IWorkbenchPartReference partRef) {
				if (HELP_VIEW_ID.equals(partRef.getId())) {
					dynamicHelpViewShowing = true;
				}

			}

			public void partClosed(IWorkbenchPartReference partRef) {
				partHidden(partRef);
			}

			// Will be notified reliably when Dynamic Help View is closed in ANY
			// perspective
			public void partHidden(IWorkbenchPartReference partRef) {
				if (HELP_VIEW_ID.equals(partRef.getId())) {
					dynamicHelpViewShowing = false;
					PlatformUI
							.getWorkbench()
							.getHelpSystem()
							.setHelp(
									getGraphicalViewer().getControl(),
									IYakinduSctHelpContextIds.SC_EDITOR_GRAPHICAL_VIEWER);
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
	}

	public static boolean askWorkbenchIfDynamicHelpViewShowing() {
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

	@Override
	public String getContributorId() {
		return ID;
	}

	public static void setDynamicHelpViewShowing(boolean dynamicHelpViewShowing) {
		StatechartDiagramEditor.dynamicHelpViewShowing = dynamicHelpViewShowing;
	}

	public static boolean isDynamicHelpViewShowing() {
		return StatechartDiagramEditor.dynamicHelpViewShowing;
	}

}
