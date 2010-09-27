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
package org.yakindu.sct.statechart.diagram.policies;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.yakindu.sct.statechart.diagram.editor.StatechartElementTypes;

import com.google.common.collect.ImmutableList;

/**
 * Disallows custom size for the given model elements on creation.
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class CompartmentCreationEditPolicy extends CreationEditPolicy {

	private static final ImmutableList<IElementType> fixedSizeElements = ImmutableList.of(
			StatechartElementTypes.CHOICE, StatechartElementTypes.JUNCTION, StatechartElementTypes.INITIALSTATE,
			StatechartElementTypes.FINALSTATE, StatechartElementTypes.DEEPHISTORY,
			StatechartElementTypes.SHALLOWHISTORY);

	@Override
	protected Command getCreateElementAndViewCommand(CreateViewAndElementRequest request) {
		String semanticHint = request.getViewAndElementDescriptor().getSemanticHint();
		IElementType elementType = StatechartElementTypes.fromSemanticId(semanticHint);
		if (fixedSizeElements.contains(elementType))
			request.setSize(new Dimension(-1, -1));
		return super.getCreateElementAndViewCommand(request);
	}
}
