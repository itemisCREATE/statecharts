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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.CompartmentViewFactory;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.ShapeViewFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.factories.BorderItemContainerViewFactory;
import org.yakindu.sct.ui.editor.factories.BorderItemLabelViewFactory;
import org.yakindu.sct.ui.editor.factories.EntryViewFactory;
import org.yakindu.sct.ui.editor.factories.RegionViewFactory;
import org.yakindu.sct.ui.editor.factories.StateTextCompartmentViewFactory;
import org.yakindu.sct.ui.editor.factories.StateViewFactory;
import org.yakindu.sct.ui.editor.factories.StatechartDiagramViewFactory;
import org.yakindu.sct.ui.editor.factories.StatechartTextFactory;
import org.yakindu.sct.ui.editor.factories.TransitionViewFactory;
import org.yakindu.sct.ui.editor.utils.SemanticHintUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartDiagramViewProvider extends AbstractViewProvider implements SemanticHints {

	private static final Map<String, Class<?>> factories;
	static {
		factories = new HashMap<String, Class<?>>();
		init();
	}

	private static void init() {
		factories.put(StatechartDiagramEditor.ID, StatechartDiagramViewFactory.class);
		factories.put(STATECHART_TEXT, StatechartTextFactory.class);
		factories.put(STATECHART_NAME, ShapeViewFactory.class);
		factories.put(STATECHART_TEXT_EXPRESSION, ShapeViewFactory.class);
		factories.put(REGION, RegionViewFactory.class);
		factories.put(REGION_COMPARTMENT, ShapeViewFactory.class);

		factories.put(STATE, StateViewFactory.class);
		factories.put(STATE_TEXT_COMPARTMENT, StateTextCompartmentViewFactory.class);
		factories.put(STATE_FIGURE_COMPARTMENT, CompartmentViewFactory.class);
		factories.put(SUBMACHINE_STATE, StateViewFactory.class);

		factories.put(STATE_TEXT_COMPARTMENT_EXPRESSION, ShapeViewFactory.class);
		factories.put(TRANSITION, TransitionViewFactory.class);
		factories.put(CHOICE, ShapeViewFactory.class);
		factories.put(ENTRY, EntryViewFactory.class);
		factories.put(EXIT, BorderItemContainerViewFactory.class);
		factories.put(BORDER_ITEM_LABEL_CONTAINER, BorderItemLabelViewFactory.class);
		factories.put(SHALLOWHISTORY, EntryViewFactory.class);
		factories.put(DEEPHISTORY, EntryViewFactory.class);
		factories.put(FINALSTATE, ShapeViewFactory.class);
		factories.put(JUNCTION, ShapeViewFactory.class);
		factories.put(SYNCHRONIZATION, ShapeViewFactory.class);
	}

	private Class<?> getClass(String semanticHint) {
		return factories.get(semanticHint);
	}

	@Override
	protected Class<?> getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		return getClass(diagramKind);
	}

	@Override
	protected Class<?> getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		if (semanticHint == null || "".equals(semanticHint)) {
			semanticHint = SemanticHintUtil.getSemanticHint((EObject) semanticAdapter.getAdapter(EObject.class));
		}
		return getClass(semanticHint);
	}

	@Override
	protected Class<?> getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		if (semanticHint == null || "".equals(semanticHint)) {
			semanticHint = SemanticHintUtil.getSemanticHint((EObject) semanticAdapter.getAdapter(EObject.class));
		}
		return getClass(semanticHint);
	}
}
