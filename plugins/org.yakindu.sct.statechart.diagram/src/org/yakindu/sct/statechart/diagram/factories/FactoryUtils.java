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
package org.yakindu.sct.statechart.diagram.factories;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.DecorationNode;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.model.sct.statechart.InitialState;
import org.yakindu.model.sct.statechart.Region;
import org.yakindu.model.sct.statechart.Statechart;
import org.yakindu.model.sct.statechart.StatechartFactory;
import org.yakindu.sct.statechart.diagram.DiagramActivator;
import org.yakindu.sct.statechart.diagram.editor.StatechartDiagramEditor;
import org.yakindu.sct.statechart.diagram.providers.SemanticHints;

/**
 * Convenience methods for semantic and notation model element creation.
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public final class FactoryUtils {

	private static final int INITIAL_REGION_WIDTH = 800;
	private static final int INITIAL_REGION_HEIGHT = 600;
	private static final String INITIAL_REGION_NAME = "main region";
	private static final int INITIAL_TEXT_COMPARTMENT_HEIGHT = 600;
	private static final int INITIAL_TEXT_COMPARTMENT_WIDTH = 200;
	
	private static final int SPACING = 50;

	private FactoryUtils() {
	}

	/**
	 * Creates a Label view
	 * 
	 * @param owner
	 * @param hint
	 * @return
	 */
	public static Node createLabel(View owner, String hint) {
		DecorationNode nameLabel = NotationFactory.eINSTANCE
				.createDecorationNode();
		nameLabel.setType(hint);
		ViewUtil.insertChildView(owner, nameLabel, ViewUtil.APPEND, true);
		nameLabel.setLayoutConstraint(NotationFactory.eINSTANCE
				.createLocation());
		return nameLabel;
	}

	/**
	 * Creates a Statechart with an initial Region and an initial State
	 * 
	 * @return instanceof {@link Statechart}
	 */
	public static void createStatechartModel(Resource resource) {
		// Create a statechart
		Statechart statechart = StatechartFactory.eINSTANCE.createStatechart();
		Diagram diagram = ViewService.createDiagram(statechart,
				StatechartDiagramEditor.ID,
				DiagramActivator.DIAGRAM_PREFERENCES_HINT);
		diagram.setElement(statechart);
		// Add to resource
		resource.getContents().add(statechart);
		resource.getContents().add(diagram);
		// Create an initial region
		Region region = StatechartFactory.eINSTANCE.createRegion();
		region.setName(INITIAL_REGION_NAME);
		statechart.getRegions().add(region);
		Node regionView = ViewService.createNode(diagram, region,
				SemanticHints.REGION,
				DiagramActivator.DIAGRAM_PREFERENCES_HINT);
		setRegionViewLayoutConstraint(regionView);
		// // Create an initial state
		InitialState initialState = StatechartFactory.eINSTANCE
				.createInitialState();
		region.getVertices().add(initialState);
		Node initialStateView = ViewService.createNode(
				getRegionCompartmentView(regionView),
				SemanticHints.INITIALSTATE,
				DiagramActivator.DIAGRAM_PREFERENCES_HINT);
		setInitialStateViewLayoutConstraint(initialStateView);
		//Create the textcompartment for events / variables
		Node textCompartment = ViewService.createNode(diagram,statechart,
				SemanticHints.STATECHART_TEXT,
				DiagramActivator.DIAGRAM_PREFERENCES_HINT);
		setTextCompartmentLayoutConstraint(textCompartment);
		
	}


	private static void setInitialStateViewLayoutConstraint(
			Node initialStateView) {
		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setX(40);
		bounds.setY(40);
		initialStateView.setLayoutConstraint(bounds);
	}

	private static View getRegionCompartmentView(View regionView) {
		return (View) regionView.getChildren().get(1);
	}
	
	private static void setTextCompartmentLayoutConstraint(Node textCompartment) {
		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setHeight(INITIAL_TEXT_COMPARTMENT_HEIGHT);
		bounds.setWidth(INITIAL_TEXT_COMPARTMENT_WIDTH);
		textCompartment.setLayoutConstraint(bounds);
	}

	private static void setRegionViewLayoutConstraint(Node regionView) {
		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setX(INITIAL_TEXT_COMPARTMENT_WIDTH + SPACING);
		bounds.setHeight(INITIAL_REGION_HEIGHT);
		bounds.setWidth(INITIAL_REGION_WIDTH);
		regionView.setLayoutConstraint(bounds);
	}

}
