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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Viewport;
import org.eclipse.draw2d.ViewportAwareConnectionLayerClippingStrategy;
import org.eclipse.draw2d.ViewportUtilities;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.LayerConstants;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gmf.runtime.common.ui.services.marker.MarkerNavigationService;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.help.IWorkbenchHelpSystem;
import org.eclipse.ui.ide.IGotoMarker;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.utils.HelpContextIds;
import org.yakindu.sct.ui.editor.validation.ValidationAction;

import de.itemis.xtext.utils.gmf.resource.DirtyStateListener;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author martin esser
 */
public class StatechartDiagramEditor extends DiagramDocumentEditor implements
		IGotoMarker {

	public static final String ID = "org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor";

	private ResourceSetListener validationListener = new ResourceSetListenerImpl() {
		@Override
		public void resourceSetChanged(ResourceSetChangeEvent event) {
			validate();
		}
	};

	private DirtyStateListener domainAdapter;

	public StatechartDiagramEditor() {
		super(true);
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		super.init(site, input);
		getEditingDomain().addResourceSetListener(validationListener);
		checkXtextNature();
	}

	private void checkXtextNature() {
		IFileEditorInput editorInput = (IFileEditorInput) getEditorInput();
		IProject project = editorInput.getFile().getProject();
		if (project != null && !XtextProjectHelper.hasNature(project)
				&& project.isAccessible() && !project.isHidden()) {
			addNature(project);
		}
	}

	public void addNature(IProject project) {
		try {
			IProjectDescription description = project.getDescription();
			String[] natures = description.getNatureIds();
			String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = XtextProjectHelper.NATURE_ID;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected TransactionalEditingDomain createEditingDomain() {
		TransactionalEditingDomain domain = super.createEditingDomain();
		domainAdapter = new DirtyStateListener();
		domain.addResourceSetListener(domainAdapter);
		return domain;
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
				HelpContextIds.SC_EDITOR_GRAPHICAL_VIEWER);
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
//			connectionLayer
//					.setClippingStrategy(new ViewportAwareConnectionLayerClippingStrategy(
//							connectionLayer));

			connectionLayer
				.setClippingStrategy(new ViewportAwareConnectionLayerClippingStrategy(
						connectionLayer){
				
				private final Insets PRIVATE_INSETS = new Insets(0, 0, 1, 1);
				
				/**
				 * Computes clipping rectangle(s) for a given connection. Will consider all
				 * enclosing viewports, excluding the root viewport.
				 */
				protected Rectangle[] getEdgeClippingRectangle(Connection connection) {
					// start with clipping the connection at its original bounds
					Rectangle clipRect = getAbsoluteBoundsAsCopy(connection);

					// in case we cannot infer source and target of the connection (e.g.
					// if XYAnchors are used), returning the bounds is all we can do
					ConnectionAnchor sourceAnchor = connection.getSourceAnchor();
					ConnectionAnchor targetAnchor = connection.getTargetAnchor();
					if (sourceAnchor == null || sourceAnchor.getOwner() == null
							|| targetAnchor == null || targetAnchor.getOwner() == null) {
						return new Rectangle[] { clipRect };
					}

					// source and target figure are known, see if there is common
					// viewport
					// the connection has to be clipped at.
					IFigure sourceFigure = sourceAnchor.getOwner();
					IFigure targetFigure = targetAnchor.getOwner();
					Viewport nearestEnclosingCommonViewport = ViewportUtilities
							.getNearestCommonViewport(sourceFigure, targetFigure);
					if (nearestEnclosingCommonViewport == null) {
						return new Rectangle[] { clipRect };
					}

					// if the nearest common viewport is not the root viewport, we may
					// start with clipping the connection at this viewport.
					if (nearestEnclosingCommonViewport != getRootViewport()) {
						clipRect.intersect(getNodeClippingRectangle(nearestEnclosingCommonViewport));
					}

					// if the nearest common viewport of source and target is not
					// simultaneously
					// the nearest enclosing viewport of source and target respectively, the
					// connection has to be further clipped (the connection may even not be
					// visible at all)
					Viewport nearestEnclosingSourceViewport = ViewportUtilities
							.getNearestEnclosingViewport(sourceFigure);
					Viewport nearestEnclosingTargetViewport = ViewportUtilities
							.getNearestEnclosingViewport(targetFigure);
					if (nearestEnclosingSourceViewport != nearestEnclosingTargetViewport) {
						// compute if source and target anchor are visible
						// within the nearest common enclosing viewport (which may
						// itself be nested in other viewports).
						Rectangle sourceClipRect = getAbsoluteBoundsAsCopy(connection);
						if (nearestEnclosingSourceViewport != nearestEnclosingCommonViewport) {
							clipAtViewports(sourceClipRect,
									ViewportUtilities.getViewportsPath(
											nearestEnclosingSourceViewport,
											nearestEnclosingCommonViewport, false));
						}
						Rectangle targetClipRect = getAbsoluteBoundsAsCopy(connection);
						if (nearestEnclosingTargetViewport != nearestEnclosingCommonViewport) {
							clipAtViewports(targetClipRect,
									ViewportUtilities.getViewportsPath(
											nearestEnclosingTargetViewport,
											nearestEnclosingCommonViewport, false));
						}
						PointList absolutePointsAsCopy = getAbsolutePointsAsCopy(connection);
						boolean sourceAnchorVisible = sourceClipRect.getExpanded(
								PRIVATE_INSETS).contains(
								absolutePointsAsCopy.getFirstPoint());
						boolean targetAnchorVisible = targetClipRect.getExpanded(
								PRIVATE_INSETS).contains(
								absolutePointsAsCopy.getLastPoint());

						if (!sourceAnchorVisible || !targetAnchorVisible) {
							// one (or both) of source or target anchor is invisible
							// within the nearest common viewport, so up to now
							// we regard the edge as invisible.
							return new Rectangle[] {};
							// TODO: We could come up with a more decent strategy here,
							// which also computes clipping fragments in those cases
							// where source/target are not visible but the edge
							// intersects with the enclosing source/target viewport's
							// parents bounds.

						} else {
							// both ends are visible, so just return what we have
							// computed before
							// (clipping at nearest enclosing viewport)
							return new Rectangle[] { clipRect };
						}
					} else {
						// source and target share the same enclosing viewport, so just
						// return what we have computed before (clipping at nearest
						// enclosing viewport)
						return new Rectangle[] { clipRect };
					}
				}
				
										
			});

		}
	}

	@Override
	public void dispose() {
		getEditingDomain().removeResourceSetListener(validationListener);
		getEditingDomain().removeResourceSetListener(domainAdapter);
		domainAdapter.dispose();
		super.dispose();
	}
}
