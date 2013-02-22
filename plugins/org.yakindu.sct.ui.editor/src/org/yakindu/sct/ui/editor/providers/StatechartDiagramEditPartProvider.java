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
package org.yakindu.sct.ui.editor.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.editparts.BorderItemEditPart;
import org.yakindu.sct.ui.editor.editparts.ChoiceEditPart;
import org.yakindu.sct.ui.editor.editparts.EntryEditPart;
import org.yakindu.sct.ui.editor.editparts.ExitEditPart;
import org.yakindu.sct.ui.editor.editparts.FinalStateEditPart;
import org.yakindu.sct.ui.editor.editparts.NamedElementLabelEditPart;
import org.yakindu.sct.ui.editor.editparts.RegionCompartmentEditPart;
import org.yakindu.sct.ui.editor.editparts.RegionEditPart;
import org.yakindu.sct.ui.editor.editparts.RegionNameEditPart;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;
import org.yakindu.sct.ui.editor.editparts.StateFigureCompartmentEditPart;
import org.yakindu.sct.ui.editor.editparts.StateNameEditPart;
import org.yakindu.sct.ui.editor.editparts.StateTextCompartmentEditPart;
import org.yakindu.sct.ui.editor.editparts.StateTextCompartmentExpressionEditPart;
import org.yakindu.sct.ui.editor.editparts.StatechartDiagramEditPart;
import org.yakindu.sct.ui.editor.editparts.StatechartNameEditPart;
import org.yakindu.sct.ui.editor.editparts.StatechartTextEditPart;
import org.yakindu.sct.ui.editor.editparts.StatechartTextExpressionEditPart;
import org.yakindu.sct.ui.editor.editparts.SynchronizationEditPart;
import org.yakindu.sct.ui.editor.editparts.TransitionEditPart;
import org.yakindu.sct.ui.editor.editparts.TransitionExpressionEditPart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartDiagramEditPartProvider extends AbstractEditPartProvider
		implements SemanticHints {

	public static final Map<String, Class<? extends IGraphicalEditPart>> editParts;
	static {
		editParts = new HashMap<String, Class<? extends IGraphicalEditPart>>();
		init();
	}

	private static void init() {
		editParts.put(StatechartDiagramEditor.ID,
				StatechartDiagramEditPart.class);
		editParts.put(STATECHART_TEXT, StatechartTextEditPart.class);
		editParts.put(STATECHART_NAME, StatechartNameEditPart.class);
		editParts.put(STATECHART_TEXT_EXPRESSION,
				StatechartTextExpressionEditPart.class);
		editParts.put(CHOICE, ChoiceEditPart.class);
		editParts.put(FINALSTATE, FinalStateEditPart.class);
		editParts.put(ENTRY, EntryEditPart.class);
		editParts.put(BORDER_ITEM_LABEL, NamedElementLabelEditPart.class);
		editParts.put(BORDER_ITEM_LABEL_CONTAINER, BorderItemEditPart.class);
		editParts.put(SHALLOWHISTORY, EntryEditPart.class);
		editParts.put(DEEPHISTORY, EntryEditPart.class);
		
		editParts.put(REGION_COMPARTMENT, RegionCompartmentEditPart.class);
		editParts.put(REGION, RegionEditPart.class);
		editParts.put(REGION_NAME, RegionNameEditPart.class);
		
		editParts.put(STATE_NAME, StateNameEditPart.class);
		editParts.put(STATE_TEXT_COMPARTMENT,
				StateTextCompartmentEditPart.class);
		editParts.put(SUBMACHINE_STATE, StateEditPart.class);
		editParts.put(SUBMACHINE_STATE_NAME, StateNameEditPart.class);
		editParts.put(STATE_TEXT_COMPARTMENT_EXPRESSION,
				StateTextCompartmentExpressionEditPart.class);
		editParts.put(STATE, StateEditPart.class);
		editParts.put(STATE_FIGURE_COMPARTMENT,
				StateFigureCompartmentEditPart.class);
		editParts.put(TRANSITION, TransitionEditPart.class);
		editParts
				.put(TRANSITION_EXPRESSION, TransitionExpressionEditPart.class);
		editParts.put(EXIT, ExitEditPart.class);
		editParts.put(SYNCHRONIZATION, SynchronizationEditPart.class);

	}

	protected Class<? extends IGraphicalEditPart> getClass(String semanticHint) {
		return editParts.get(semanticHint);
	}

	@Override
	protected Class<? extends IGraphicalEditPart> getNodeEditPartClass(View view) {
		return getClass(view.getType());
	}

	@Override
	protected Class<? extends IGraphicalEditPart> getDiagramEditPartClass(
			View view) {
		return getClass(view.getType());
	}

	@Override
	protected Class<? extends IGraphicalEditPart> getEdgeEditPartClass(View view) {
		return getClass(view.getType());
	}

}
