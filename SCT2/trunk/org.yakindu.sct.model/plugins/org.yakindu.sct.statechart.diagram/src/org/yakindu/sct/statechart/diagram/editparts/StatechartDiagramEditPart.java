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

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateConnectionViewAndElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.policies.StatechartCanonicalEditPolicy;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class StatechartDiagramEditPart extends DiagramEditPart {

	public StatechartDiagramEditPart(View diagramView) {
		super(diagramView);
	}

	@Override
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new StatechartCanonicalEditPolicy());
		super.createDefaultEditPolicies();
	}
	
	@Override
	public Command getCommand(Request _request) {
		if(_request instanceof CreateConnectionViewAndElementRequest)
			return null;
		System.out.println(_request);
		return super.getCommand(_request);
	}
	
}
