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
package org.yakindu.sct.statechart.diagram.assistent;

import static org.yakindu.sct.statechart.diagram.editor.StatechartElementTypes.CHOICE;
import static org.yakindu.sct.statechart.diagram.editor.StatechartElementTypes.DEEPHISTORY;
import static org.yakindu.sct.statechart.diagram.editor.StatechartElementTypes.FINALSTATE;
import static org.yakindu.sct.statechart.diagram.editor.StatechartElementTypes.INITIALSTATE;
import static org.yakindu.sct.statechart.diagram.editor.StatechartElementTypes.JUNCTION;
import static org.yakindu.sct.statechart.diagram.editor.StatechartElementTypes.REGION;
import static org.yakindu.sct.statechart.diagram.editor.StatechartElementTypes.SHALLOWHISTORY;
import static org.yakindu.sct.statechart.diagram.editor.StatechartElementTypes.STATE;

import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.yakindu.sct.statechart.diagram.editparts.RegionCompartmentEditPart;
import org.yakindu.sct.statechart.diagram.editparts.RegionEditPart;
import org.yakindu.sct.statechart.diagram.editparts.StateCompartmentEditPart;
import org.yakindu.sct.statechart.diagram.editparts.StateEditPart;

import com.google.common.collect.Lists;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class StatechartModelingAssistantProvider extends
		ModelingAssistantProvider {

	@Override
	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		IGraphicalEditPart editPart = (IGraphicalEditPart) host
				.getAdapter(IGraphicalEditPart.class);

		if (editPart instanceof RegionEditPart
				|| editPart instanceof RegionCompartmentEditPart)
			return Lists.newArrayList(INITIALSTATE, STATE, FINALSTATE,
					DEEPHISTORY, SHALLOWHISTORY, JUNCTION, CHOICE);

		if (editPart instanceof StateEditPart
				|| editPart instanceof StateCompartmentEditPart)
			return Lists.newArrayList(REGION);

		return Lists.newArrayList();
	}
	
	
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		return Lists.newArrayList(STATE, FINALSTATE, JUNCTION, CHOICE);
	}

	
}
