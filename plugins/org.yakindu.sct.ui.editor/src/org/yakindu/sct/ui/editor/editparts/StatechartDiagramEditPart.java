/**
 * Copyright (c) 2010-2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IDiagramPreferenceSupport;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.editor.themes.IStatechartsTheme;
import org.yakindu.sct.ui.editor.editor.themes.ThemeProvider;
import org.yakindu.sct.ui.editor.policies.CompositeElementCanonicalEditPolicy;

/**
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public class StatechartDiagramEditPart extends DiagramEditPart implements IDiagramPreferenceSupport {

	private PreferencesHint preferenceHint;

	public StatechartDiagramEditPart(View diagramView) {
		super(diagramView);
	}

	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new CompositeElementCanonicalEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy());
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
		installEditPolicy(EditPolicyRoles.SNAP_FEEDBACK_ROLE, new SimpleSnapFeedbackPolicy());
	}

	@Override
	public void setPreferencesHint(PreferencesHint preferenceHint) {
		this.preferenceHint = preferenceHint;
	}

	@Override
	public PreferencesHint getPreferencesHint() {
		return preferenceHint;
	}

	@Override
	public PreferencesHint getDiagramPreferencesHint() {
		return DiagramActivator.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	public IFigure getFigure() {
		IStatechartsTheme theme = ThemeProvider.getInstance().getTheme();
		IFigure figure = super.getFigure();
		figure.setBackgroundColor(theme.getCanvasBgColor());
		figure.setOpaque(true);
		return figure;
	}

}
