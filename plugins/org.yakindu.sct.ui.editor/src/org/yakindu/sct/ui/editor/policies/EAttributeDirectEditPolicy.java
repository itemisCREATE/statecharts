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
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.yakindu.base.xtext.utils.gmf.directedit.IEAttributeProvider;
import org.yakindu.base.xtext.utils.gmf.directedit.IXtextAwareEditPart;

/**
 * 
 * @author muelder
 * 
 */
public class EAttributeDirectEditPolicy extends DirectEditPolicy {

	private IEAttributeProvider provider;

	public EAttributeDirectEditPolicy(IEAttributeProvider provider) {
		this.provider = provider;
	}

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		SetRequest setRequest = new SetRequest(getHost().resolveSemanticElement(), provider.getAttribute(), request
				.getCellEditor().getValue());
		SetValueCommand setCommand = new SetValueCommand(setRequest);
		return new ICommandProxy(setCommand);
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		((IXtextAwareEditPart) getHost()).setLabelText(value);
	}

}
