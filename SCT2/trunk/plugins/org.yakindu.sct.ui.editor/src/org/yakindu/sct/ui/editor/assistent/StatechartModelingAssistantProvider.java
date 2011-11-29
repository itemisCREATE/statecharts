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
package org.yakindu.sct.ui.editor.assistent;

import static org.yakindu.sct.ui.editor.editor.StatechartElementTypes.CHOICE;
import static org.yakindu.sct.ui.editor.editor.StatechartElementTypes.ENTRY;
import static org.yakindu.sct.ui.editor.editor.StatechartElementTypes.FINALSTATE;
import static org.yakindu.sct.ui.editor.editor.StatechartElementTypes.REGION;
import static org.yakindu.sct.ui.editor.editor.StatechartElementTypes.STATE;
import static org.yakindu.sct.ui.editor.editor.StatechartElementTypes.TRANSITION;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.modelingassistant.ModelingAssistantProvider;
import org.yakindu.sct.ui.editor.editor.StatechartElementTypes;
import org.yakindu.sct.ui.editor.editparts.RegionCompartmentEditPart;
import org.yakindu.sct.ui.editor.editparts.RegionEditPart;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;
import org.yakindu.sct.ui.editor.editparts.StateFigureCompartmentEditPart;

import com.google.common.collect.Lists;

/**
 * 
 * @author andreas muelder - Initial contribution and API
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
			return Lists.newArrayList(ENTRY, STATE, FINALSTATE, ENTRY, CHOICE);

		if (editPart instanceof StateEditPart
				|| editPart instanceof StateFigureCompartmentEditPart)
			return Lists.newArrayList(REGION);

		return Lists.newArrayList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IElementType> getTypesForTarget(IAdaptable source,
			IElementType relationshipType) {
		if (StatechartElementTypes.TRANSITION.equals(relationshipType))
			return Lists.newArrayList(STATE, FINALSTATE, CHOICE);
		return Collections.EMPTY_LIST;
	}

	@Override
	public List<?> getRelTypesOnSource(IAdaptable source) {
		return Lists.newArrayList(TRANSITION);
	}

	@Override
	public List<?> getRelTypesOnTarget(IAdaptable target) {
		return Lists.newArrayList(TRANSITION);
	}

	@Override
	public List<?> getRelTypesOnSourceAndTarget(IAdaptable source,
			IAdaptable target) {
		return Lists.newArrayList(TRANSITION);
	}
}
