/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.policies;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewType;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewRequest.ViewDescriptor;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StateCompartmentCreationEditPolicy extends CompartmentCreationEditPolicy {

	@Override
	protected Command getCreateCommand(CreateViewRequest request) {
		StateEditPart parent = (StateEditPart) getHost().getParent();
		BooleanValueStyle isInline = GMFNotationUtil.getBooleanValueStyle(parent.getNotationView(),
				DiagramPartitioningUtil.INLINE_STYLE);
		if (isInline != null && !isInline.isBooleanValue())
			return UnexecutableCommand.INSTANCE;

		List<? extends ViewDescriptor> viewDescriptors = request.getViewDescriptors();
		for (ViewDescriptor viewDescriptor : viewDescriptors) {
			String semanticHint = viewDescriptor.getSemanticHint();
			if (ViewType.NOTE.equals(semanticHint) || ViewType.NOTEATTACHMENT.equals(semanticHint)
					|| ViewType.TEXT.equals(semanticHint)) {
				return UnexecutableCommand.INSTANCE;
			}
		}
		return super.getCreateCommand(request);
	}
}
