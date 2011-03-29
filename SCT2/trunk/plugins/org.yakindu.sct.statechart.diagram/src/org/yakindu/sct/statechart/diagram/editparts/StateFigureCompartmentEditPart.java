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
package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.policies.CompartmentCreationEditPolicy;
import org.yakindu.sct.statechart.diagram.policies.StateCompartmentCanonicalEditPolicy;

/**
 * 
 * @author muelder
 *
 */
public class StateFigureCompartmentEditPart extends ShapeCompartmentEditPart {

	public StateFigureCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CompartmentCreationEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new StateCompartmentCanonicalEditPolicy());
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

}
