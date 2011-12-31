package org.yakindu.sct.simulation.ui.model.presenter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.model.sexec.TraceNodeExecuted;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;

import de.itemis.gmf.runtime.commons.highlighting.HighlightingParameters;

/**
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - Additions
 * 
 */
public class DefaultDynamicNotationHandler extends AbstractDynamicNotationHandler {

	private static final HighlightingParameters TRANSITION_PARAMS = new HighlightingParameters(
			0, ColorConstants.darkGreen, ColorConstants.gray, false);

	private List<EObject> lastTransitionPath = new ArrayList<EObject>();

	public void restoreNotationState(IExecutionContext context) {
		for (Vertex vertex : context.getAllActiveStates()) {
			getHighlightingSupport().fadeIn(vertex,
					HighlightingParameters.DEFAULT);
		}
		for (EObject obj : lastTransitionPath) {
			getHighlightingSupport().fadeIn(obj, TRANSITION_PARAMS);
		}

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
		
		for (EObject obj : lastTransitionPath) {
			getHighlightingSupport().fadeOut(obj, TRANSITION_PARAMS);
		}
		lastTransitionPath.clear();
	}

	public void visualizeStep(final ReactionFired trace) {
		EObject transition = trace.getReaction().getSourceElement();
//		if (lastTransitionPath != null) {
//			getHighlightingSupport().fadeOut(lastTransitionPath,
//					TRANSITION_PARAMS);
//		}
		getHighlightingSupport().fadeIn(transition, TRANSITION_PARAMS);
		lastTransitionPath.add(transition);
	}

	public void visualizeStep(final TraceNodeExecuted trace) {
		EObject node = trace.getNode().getSourceElement();
//		getHighlightingSupport().flash(node, HighlightingParameters.DEFAULT);
		getHighlightingSupport().fadeIn(node, TRANSITION_PARAMS);
		lastTransitionPath.add(node);
	}

	// dispatch
	public void visualizeStep(final Trace trace) {
		if (trace instanceof TraceStateEntered)
			visualizeStep((TraceStateEntered) trace);
		if (trace instanceof TraceStateExited)
			visualizeStep((TraceStateExited) trace);
		if (trace instanceof ReactionFired)
			visualizeStep((ReactionFired) trace);
		if (trace instanceof TraceNodeExecuted)
			visualizeStep((TraceNodeExecuted) trace);
	}
}
