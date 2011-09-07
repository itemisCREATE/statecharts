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

/**
 * The semantic hints for the factories.
 * 
 * @author muelder
 * 
 */
public interface SemanticHints {

	String STATECHART_TEXT = "StatechartText";
	String STATECHART_NAME = "StatechartName";
	String STATECHART_TEXT_EXPRESSION = "StatechartTextExpression";

	String REGION = "Region";
	String REGION_NAME = "RegionName";
	String REGION_COMPARTMENT = "RegionCompartment";

	String TRANSITION = "Transition";
	String TRANSITION_EXPRESSION = "TransitionExpression";

	String STATE_NAME = "StateName";
	String STATE_TEXT_COMPARTMENT = "StateTextCompartment";
	String STATE_TEXT_COMPARTMENT_EXPRESSION = "StateTextCompartmentExpression";
	String STATE_FIGURE_COMPARTMENT = "StateFigureCompartment";

	String STATE = "State";
	String SUBMACHINE_STATE = "SubmachineState";
	String SUBMACHINE_STATE_NAME = "SubmachineStateName";

	String CHOICE = "Choice";

	String DEEPHISTORY = "DeepHistory";

	String SHALLOWHISTORY = "ShallowHistory";

	String ENTRY = "Entry";

	String FINALSTATE = "FinalState";
	String EXIT = "Exit";

	String BORDER_ITEM_LABEL_CONTAINER = "BorderItemLabelContainer";
	String BORDER_ITEM_LABEL = "BorderItemLabel";

	String JOIN = "Join";

	String JUNCTION = "Junction";

	String SYNCHRONIZATION = "Synchronization";

}
