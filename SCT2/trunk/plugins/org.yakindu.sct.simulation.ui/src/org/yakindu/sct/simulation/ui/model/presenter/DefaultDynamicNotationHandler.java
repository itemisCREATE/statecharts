/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.ui.model.presenter;

import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.STATE_FOREGROUND_HIGHLIGHTING_COLOR;
import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.STATE_BACKGROUND_HIGHLIGHTING_COLOR;
import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.TRANSITION_HIGHLIGHTING_COLOR;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.model.sexec.TraceBeginRunCycle;
import org.yakindu.sct.model.sexec.TraceEndRunCycle;
import org.yakindu.sct.model.sexec.TraceNodeExecuted;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;
import org.yakindu.sct.simulation.ui.SimulationActivator;

import de.itemis.gmf.runtime.commons.highlighting.HighlightingParameters;
import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport;
import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport.Action;

/**
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - Additions
 * 
 */
public class DefaultDynamicNotationHandler extends
		AbstractDynamicNotationHandler {

	protected static HighlightingParameters TRANSITION_PARAMS = new HighlightingParameters(
			0, ColorConstants.darkGreen, ColorConstants.gray, false);

	protected static HighlightingParameters STATE_PARAMS = HighlightingParameters.DEFAULT;


	public DefaultDynamicNotationHandler() {
		updatePreferences();
	}

	public void restoreNotationState(IExecutionContext context) {
		for (Vertex vertex : context.getAllActiveStates()) {
			getHighlightingSupport().fadeIn(vertex,
					HighlightingParameters.DEFAULT);
		}

	}


	public void visualizeStep(final TraceBeginRunCycle trace) {
	}

	
	public void visualizeStep(final TraceEndRunCycle trace) {
	}

	
	public void visualizeStep(final TraceStateEntered trace) {
		getHighlightingSupport().fadeIn(
				((TraceStateEntered) trace).getState().getSourceElement(),
				HighlightingParameters.DEFAULT);
	}

	public void visualizeStep(final TraceStateExited trace) {
		getHighlightingSupport().fadeOut(
				((TraceStateExited) trace).getState().getSourceElement(),
				HighlightingParameters.DEFAULT);
	}

	public void visualizeStep(final ReactionFired trace) {
		getHighlightingSupport().flash(
				trace.getReaction().getSourceElement(),
				HighlightingParameters.DEFAULT);
	}

	public void visualizeStep(final TraceNodeExecuted trace) {
		getHighlightingSupport().flash(
				trace.getNode().getSourceElement(),
				HighlightingParameters.DEFAULT);
	}

	/** 
	 * this dispatch method invokes the appropriate handler methods for the different trace step types. 
	 */
	public void visualizeStep(final Trace trace) {
		if (trace instanceof TraceBeginRunCycle)
			visualizeStep((TraceBeginRunCycle) trace);
		if (trace instanceof TraceStateEntered)
			visualizeStep((TraceStateEntered) trace);
		if (trace instanceof TraceStateExited)
			visualizeStep((TraceStateExited) trace);
		if (trace instanceof ReactionFired)
			visualizeStep((ReactionFired) trace);
		if (trace instanceof TraceNodeExecuted)
			visualizeStep((TraceNodeExecuted) trace);
		if (trace instanceof TraceEndRunCycle)
			visualizeStep((TraceEndRunCycle) trace);
	}

	
	protected void updatePreferences() {
		IPreferenceStore store = SimulationActivator.getDefault()
				.getPreferenceStore();
		// read out the new colors
		RGB foregroundColor = PreferenceConverter.getColor(store,
				STATE_FOREGROUND_HIGHLIGHTING_COLOR);
		RGB backgroundColor = PreferenceConverter.getColor(store,
				STATE_BACKGROUND_HIGHLIGHTING_COLOR);
		RGB transitionColor = PreferenceConverter.getColor(store,
				TRANSITION_HIGHLIGHTING_COLOR);
		// Set the new colors
		STATE_PARAMS.foregroundFadingColor = new Color(Display.getDefault(),
				foregroundColor);
		STATE_PARAMS.backgroundFadingColor = new Color(Display.getDefault(),
				backgroundColor);
		TRANSITION_PARAMS.foregroundFadingColor = new Color(
				Display.getDefault(), transitionColor);
	}
}
