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
package org.yakindu.sct.ui.editor.policies;

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.yakindu.sct.ui.editor.editparts.StatechartTextEditPart;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

import com.google.common.collect.ImmutableList;

/**
 * Disallows custom size for the given model elements on creation.
 * 
 * @author muelder
 * 
 */
public class CompartmentCreationEditPolicy extends CreationEditPolicy {

	private static final ImmutableList<String> fixedSizeElements = ImmutableList
			.of(SemanticHints.CHOICE, SemanticHints.JUNCTION,
					SemanticHints.ENTRY, SemanticHints.FINALSTATE,
					SemanticHints.DEEPHISTORY, SemanticHints.SHALLOWHISTORY,
					SemanticHints.EXIT, SemanticHints.SYNCHRONIZATION);

	@Override
	protected Command getCreateElementAndViewCommand(
			CreateViewAndElementRequest request) {
		String semanticHint = request.getViewAndElementDescriptor()
				.getSemanticHint();
		if (fixedSizeElements.contains(semanticHint))
			request.setSize(new Dimension(-1, -1));
		return super.getCreateElementAndViewCommand(request);
	}
	
	@Override
	protected Command getReparentCommand(ChangeBoundsRequest request) {
		if (!isValidSelection(request.getEditParts())) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getReparentCommand(request);
	}
	
	private boolean isValidSelection(List<?> editParts) {
		for (Object editPart:editParts) {
			if (editPart instanceof StatechartTextEditPart) {
				return false;
			}
		}
		return true;
	}
}
