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
package org.yakindu.sct.statechart.diagram.providers;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.core.providers.AbstractViewProvider;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.DiagramViewFactory;
import org.eclipse.gmf.runtime.diagram.ui.view.factories.optimal.ShapeViewFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.statechart.diagram.editor.StatechartDiagramEditor;
import org.yakindu.sct.statechart.diagram.factories.RegionViewFactory;
import org.yakindu.sct.statechart.diagram.factories.StateViewFactory;

/**
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public class StatechartDiagramViewProvider extends AbstractViewProvider implements ProviderConstants {

	private final Map<String, Class<?>> factories;

	public StatechartDiagramViewProvider() {
		factories = new HashMap<String, Class<?>>();
		init();
	}

	private void init() {
		factories.put(StatechartDiagramEditor.ID, DiagramViewFactory.class);
		factories.put(REGION, RegionViewFactory.class);
		factories.put(REGION_COMPARTMENT, ShapeViewFactory.class);
		factories.put(STATE, StateViewFactory.class);
		factories.put(STATE_COMPARTMENT, ShapeViewFactory.class);
		factories.put(TRANSITION, TransitionViewFactory.class);
		factories.put(CHOICE, ShapeViewFactory.class);
		factories.put(INITIALSTATE, ShapeViewFactory.class);
		factories.put(FINALSTATE, ShapeViewFactory.class);
		factories.put(JUNCTION, ShapeViewFactory.class);
		factories.put(SHALLOWHISTORY, ShapeViewFactory.class);
		factories.put(DEEPHISTORY, ShapeViewFactory.class);
	}

	private Class<?> getClass(String semanticHint) {
		Class<?> factory = factories.get(semanticHint);
		if (factory == null) {
			System.err.println("No Factory found for semanticHint " + semanticHint);
			throw new ProviderException("No Factory found for semanticHint " + semanticHint);
		}
		return factory;
	}

	@Override
	protected Class<?> getDiagramViewClass(IAdaptable semanticAdapter, String diagramKind) {
		return getClass(diagramKind);
	}

	@Override
	protected Class<?> getEdgeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		System.out.println("Edge contaqiner is " + containerView);
		return getClass(semanticHint);
	}

	@Override
	protected Class<?> getNodeViewClass(IAdaptable semanticAdapter, View containerView, String semanticHint) {
		return getClass(semanticHint);
	}
}
