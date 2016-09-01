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
import org.eclipse.draw2d.Label;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.RootEditPart;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IDiagramPreferenceSupport;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.render.editparts.RenderedDiagramRootEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.base.base.DomainElement;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.model.sgraph.validation.DomainValidator;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.policies.CompositeElementCanonicalEditPolicy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartDiagramEditPart extends DiagramEditPart implements IDiagramPreferenceSupport {

	private static final Font INVALID_DOMAIN_FONT = new Font(null, new FontData("Verdana", 10, SWT.NORMAL));

	private PreferencesHint preferenceHint;

	public StatechartDiagramEditPart(View diagramView) {
		super(diagramView);
	}

	@Override
	public void activate() {
		super.activate();
		validateDomain();
	}

	private void validateDomain() {
		final DomainElement domainElement = EcoreUtil2.getContainerOfType(resolveSemanticElement(),
				DomainElement.class);
		if (domainElement != null && !DomainRegistry.domainExists(domainElement.getDomainID())) {
			showInvalidDomainMessage(domainElement.getDomainID());
			disableEditMode();
		}
	}

	private void showInvalidDomainMessage(String id) {
		RootEditPart rootEditPart = getRoot();
		if (rootEditPart instanceof RenderedDiagramRootEditPart) {
			IFigure layer = ((RenderedDiagramRootEditPart) rootEditPart)
					.getLayer(SCTRenderedDiagramRootEditPart.WATERMARK_LAYER);
			Label figure = new Label(String.format(DomainValidator.MSG_DOMAIN_UNAVAILABLE, id));
			figure.setIcon(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_ERROR_TSK));
			figure.setForegroundColor(org.eclipse.draw2d.ColorConstants.red);
			figure.setFont(INVALID_DOMAIN_FONT);
			figure.setSize(figure.getPreferredSize());
			layer.add(figure);
		}
	}

	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new CompositeElementCanonicalEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy());
		removeEditPolicy(EditPolicyRoles.POPUPBAR_ROLE);
	}

	public void setPreferencesHint(PreferencesHint preferenceHint) {
		this.preferenceHint = preferenceHint;
	}

	public PreferencesHint getPreferencesHint() {
		return preferenceHint;
	}

	@Override
	public PreferencesHint getDiagramPreferencesHint() {
		return DiagramActivator.DIAGRAM_PREFERENCES_HINT;
	}

}
