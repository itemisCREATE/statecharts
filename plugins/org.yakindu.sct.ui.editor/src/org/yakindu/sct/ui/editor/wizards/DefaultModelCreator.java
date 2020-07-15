/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.ui.editor.wizards;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.lib.StatechartAnnotations;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public class DefaultModelCreator implements IModelCreator {

	/* @formatter:off */
	protected static final String INITIAL_SPECIFICATION = ""
			+ "// Use the event driven execution model.\n"
			+ "// Switch to cycle based behavior\n" + "// by specifying '@CycleBased(200)'\n"
			+ "// instead.\n"
			+ "@" + StatechartAnnotations.EVENT_DRIVEN_ANNOTATION + "\n"
			+ "\n"
			+ "// Use @" + StatechartAnnotations.SUPERSTEP_ANNOTATION + "(yes) to enable\n" 
			+ "// super step semantics.\n"
			+ "@" + StatechartAnnotations.SUPERSTEP_ANNOTATION + "(no)\n"
			+ "\n"
			+ "interface:\n"
			+ "\t// Define events\n"
			+ "\t// and variables here. \n"
			+ "\t// Use CTRL + Space for content assist.";
	/* @formatter:on */
	protected static final String INITIAL_REGION_NAME = "main region";
	protected static final int INITIAL_REGION_WIDTH = 400;
	protected static final int INITIAL_REGION_HEIGHT = 400;

	protected static final int INITIAL_TEXT_COMPARTMENT_X = 10;
	protected static final int INITIAL_TEXT_COMPARTMENT_Y = 10;
	protected static final int INITIAL_TEXT_COMPARTMENT_HEIGHT = 400;
	protected static final int INITIAL_TEXT_COMPARTMENT_WIDTH = 200;

	protected static final int SPACING = 10;

	/**
	 * Creates a Statechart with an initial Region and an initial State
	 *
	 * @return instanceof {@link Statechart}
	 */
	@Override
	public void createStatechartModel(Resource resource) {
		createStatechartModel(resource, DiagramActivator.DIAGRAM_PREFERENCES_HINT);
	}

	/**
	 * Creates a Statechart with an initial Region and an initial State
	 *
	 * @return instanceof {@link Statechart}
	 */
	@Override
	public void createStatechartModel(Resource resource, PreferencesHint preferencesHint) {
		// Create a statechart
		Statechart statechart = SGraphFactory.eINSTANCE.createStatechart();
		String lastSegment = resource.getURI().lastSegment();
		String statechartName = lastSegment.substring(0, lastSegment.indexOf('.'));
		statechart.setName(statechartName);
		statechart.setSpecification(getInitialSpecification());

		Diagram diagram = ViewService.createDiagram(statechart, StatechartDiagramEditor.ID, preferencesHint);
		diagram.setElement(statechart);
		resource.getContents().add(statechart);
		resource.getContents().add(diagram);
		// Create an initial region
		Region region = SGraphFactory.eINSTANCE.createRegion();
		region.setName(getInitialRegionName());
		statechart.getRegions().add(region);
		Node regionView = ViewService.createNode(diagram, region, SemanticHints.REGION, preferencesHint);
		setRegionViewLayoutConstraint(regionView);
		// // Create an initial state
		Entry initialState = SGraphFactory.eINSTANCE.createEntry();
		initialState.setKind(EntryKind.INITIAL);
		region.getVertices().add(initialState);
		Node initialStateView = ViewService.createNode(getRegionCompartmentView(regionView), initialState,
				SemanticHints.ENTRY, preferencesHint);
		setInitialStateViewLayoutConstraint(initialStateView);
		// Create the first state
		State state = SGraphFactory.eINSTANCE.createState();
		state.setName("StateA");
		region.getVertices().add(state);
		Node stateNode = ViewService.createNode(getRegionCompartmentView(regionView), state, SemanticHints.STATE,
				preferencesHint);
		setStateViewLayoutConstraint(stateNode);
		// Create the transition from Initial State to State
		Transition transition = SGraphFactory.eINSTANCE.createTransition();
		transition.setSource(initialState);
		transition.setTarget(state);
		initialState.getOutgoingTransitions().add(transition);
		ViewService.createEdge(initialStateView, stateNode, transition, SemanticHints.TRANSITION, preferencesHint);
		// Create the textcompartment for events / variables
		Node textCompartment = ViewService.createNode(diagram, statechart, SemanticHints.STATECHART_TEXT,
				preferencesHint);
		setTextCompartmentLayoutConstraint(textCompartment);
	}

	protected String getInitialRegionName() {
		return INITIAL_REGION_NAME;
	}

	protected String getInitialSpecification() {
		return INITIAL_SPECIFICATION;
	}

	protected View getRegionCompartmentView(View regionView) {
		return (View) regionView.getChildren().get(1);
	}

	protected void setTextCompartmentLayoutConstraint(Node textCompartment) {
		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setX(INITIAL_TEXT_COMPARTMENT_X);
		bounds.setY(INITIAL_TEXT_COMPARTMENT_Y);
		bounds.setHeight(INITIAL_TEXT_COMPARTMENT_HEIGHT);
		bounds.setWidth(INITIAL_TEXT_COMPARTMENT_WIDTH);
		textCompartment.setLayoutConstraint(bounds);
	}

	protected void setRegionViewLayoutConstraint(Node regionView) {
		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setX(INITIAL_TEXT_COMPARTMENT_WIDTH + INITIAL_TEXT_COMPARTMENT_X + SPACING);
		bounds.setY(INITIAL_TEXT_COMPARTMENT_Y);
		bounds.setHeight(INITIAL_REGION_HEIGHT);
		bounds.setWidth(INITIAL_REGION_WIDTH);
		regionView.setLayoutConstraint(bounds);
	}

	protected void setStateViewLayoutConstraint(Node stateNode) {
		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setX(40);
		bounds.setY(80);
		stateNode.setLayoutConstraint(bounds);
	}

	protected void setInitialStateViewLayoutConstraint(Node initialStateView) {
		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setX(70);
		bounds.setY(20);
		initialStateView.setLayoutConstraint(bounds);
	}
}
