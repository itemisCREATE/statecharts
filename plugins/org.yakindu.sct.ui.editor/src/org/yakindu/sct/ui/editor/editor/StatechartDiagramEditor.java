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
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.ViewportAwareConnectionLayerClippingStrategy;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.ui.ide.IGotoMarker;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.breadcrumb.BreadcrumbDiagramEditor;
import org.yakindu.sct.ui.editor.utils.IYakinduSctHelpContextIds;
import org.yakindu.sct.ui.editor.validation.ValidationAction;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author martin esser
 */
public class StatechartDiagramEditor extends BreadcrumbDiagramEditor implements
		IGotoMarker {

	public static final String ID = "org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor";

	// Listenes the ResourceSet for semantic changes
	private ResourceSetListener validationListener = new ResourceSetListenerImpl() {
		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			validate();
		}
	};

	public StatechartDiagramEditor() {
		super(true);
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);
		getEditingDomain().addResourceSetListener(validationListener);
	}

	@Override
	protected void sanityCheckState(IEditorInput input) {
		super.sanityCheckState(input);
		validate();
	}

	protected void validate() {
		if (getDiagram() != null) {
			ValidationAction.validate(getDiagramEditPart(), getDiagram());
		}
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
		IWorkbenchHelpSystem helpSystem = PlatformUI.getWorkbench()
				.getHelpSystem();
		helpSystem.setHelp(getGraphicalViewer().getControl(),
				IYakinduSctHelpContextIds.SC_EDITOR_GRAPHICAL_VIEWER);
	}

	@Override
	public String getContributorId() {
		return ID;
	}

	@Override
	protected void configureGraphicalViewer() {
		super.configureGraphicalViewer();
		RootEditPart rootEditPart = getDiagramGraphicalViewer()
				.getRootEditPart();
		// set clipping strategy for connection layer
		if (rootEditPart instanceof LayerManager) {
			ConnectionLayer connectionLayer = (ConnectionLayer) ((LayerManager) rootEditPart)
					.getLayer(LayerConstants.CONNECTION_LAYER);
			connectionLayer
					.setClippingStrategy(new ViewportAwareConnectionLayerClippingStrategy(
							connectionLayer));
		}
	}

	@Override
	public void dispose() {
		getEditingDomain().removeResourceSetListener(validationListener);
		super.dispose();
	}
}
