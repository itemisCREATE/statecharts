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
package org.yakindu.sct.ui.editor.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.yakindu.sct.model.sgraph.SGraphPackage;

/**
 * The {@link TransitionExpressionComponentEditPolicy} deletes the specification
 * expression when the label is deleted.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class TransitionExpressionComponentEditPolicy extends
		ComponentEditPolicy {

	@Override
	protected boolean shouldDeleteSemantic() {
		return true;
	}

	@Override
	protected Command createDeleteSemanticCommand(GroupRequest deleteRequest) {
		SetRequest request = new SetRequest(getHost().resolveSemanticElement(),
				SGraphPackage.Literals.SPECIFICATION_ELEMENT__SPECIFICATION,
				null);
		SetValueCommand result = new SetValueCommand(request);
		return new ICommandProxy(result);
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

}
