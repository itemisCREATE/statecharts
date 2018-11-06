/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.editor.figures.RegionFigure;
import org.yakindu.sct.ui.editor.editparts.tracker.NonRevealingDragEditPartsTrackerEx;
import org.yakindu.sct.ui.editor.policies.PreferredSizeHandlerEditPolicy;
import org.yakindu.sct.ui.editor.preferences.StatechartColorConstants;
import org.yakindu.sct.ui.editor.preferences.StatechartPreferenceConstants;

/**
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public class RegionEditPart extends ShapeNodeEditPart implements IPropertyChangeListener {

	public RegionEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new NodeFigure();
		figure.setLayoutManager(new StackLayout());
		figure.setMinimumSize(new Dimension(0, 0));
		figure.add(new RegionFigure(getMapMode()));
		return figure;
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new ConstrainedToolbarLayoutEditPolicy() {
			@Override
			protected Command getAutoSizeCommand(Request request) {
				return UnexecutableCommand.INSTANCE;
			}
		});
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new PreferredSizeHandlerEditPolicy());
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		if (RequestConstants.REQ_PASTE.equals(request.getType().toString())) {
			for (Object object : getChildren()) {
				if (object instanceof RegionCompartmentEditPart) {
					return (EditPart) object;
				}
			}
		}
		return super.getTargetEditPart(request);
	}

	@Override
	protected void refreshBackgroundColor() {
		IPreferenceStore store = DiagramActivator.getDefault().getPreferenceStore();
		RGB color = PreferenceConverter.getColor(store, StatechartPreferenceConstants.PREF_REGION_BACKGROUND);
		setBackgroundColor(DiagramColorRegistry.getInstance().getColor(color));
	}
	
	@Override
	protected void setBackgroundColor(Color c) {
		super.setBackgroundColor(c);
		Figure figure = getPrimaryShape();
		figure.setBackgroundColor(c);
	}

	@Override
	protected void refreshForegroundColor() {
		IPreferenceStore store = DiagramActivator.getDefault().getPreferenceStore();
		RGB color = PreferenceConverter.getColor(store, StatechartPreferenceConstants.PREF_REGION_LINE);
		setForegroundColor(DiagramColorRegistry.getInstance().getColor(color));
	}

	@Override
	protected void setForegroundColor(Color color) {
		super.setForegroundColor(color);
		Figure figure = getPrimaryShape();
		figure.setForegroundColor(color);
	}

	@Override
	public IFigure getContentPane() {
		return getPrimaryShape().getCompartmentPane();
	}

	private RegionFigure getPrimaryShape() {
		return (RegionFigure) getFigure().getChildren().get(0);
	}

	@Override
	public DragTracker getDragTracker(Request request) {
		return new NonRevealingDragEditPartsTrackerEx(this);
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof RegionCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentPane();
			pane.setLayoutManager(new StackLayout());
			IFigure figure2 = ((RegionCompartmentEditPart) childEditPart).getFigure();
			pane.add(figure2);
		} else if (childEditPart instanceof RegionNameEditPart) {
			((RegionNameEditPart) childEditPart).setLabel(getPrimaryShape().getNameLabel());
		} else
			super.addChildVisual(childEditPart, index);
	}

	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (childEditPart instanceof RegionCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentPane();
			IFigure figure = ((RegionCompartmentEditPart) childEditPart).getFigure();
			pane.remove(figure);
		} else
			super.removeChildVisual(childEditPart);
	}

	/**
	 * Returns the default background color for states
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
			return FigureUtilities.RGBToInteger(StatechartColorConstants.REGION_LINE_COLOR.getRGB());
		} else if (feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			return FigureUtilities.RGBToInteger(StatechartColorConstants.REGION_BG_COLOR.getRGB());
		}
		return super.getPreferredValue(feature);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		if (StatechartPreferenceConstants.PREF_REGION_BACKGROUND.equals(event.getProperty())) {
			refreshVisuals();
		} else if (StatechartPreferenceConstants.PREF_REGION_LINE.equals(event.getProperty())) {
			refreshVisuals();
		}
	}
	
	@Override
	public void activate() {
		DiagramActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
		super.activate();
	}

	@Override
	public void deactivate() {
		DiagramActivator.getDefault().getPreferenceStore().removePropertyChangeListener(this);
		super.deactivate();
	}
}
