package org.yakindu.sct.simulation.ui.model.presenter;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.model.sexec.TraceBeginRunCycle;
import org.yakindu.sct.model.sexec.TraceEndRunCycle;
import org.yakindu.sct.model.sexec.TraceNodeExecuted;
import org.yakindu.sct.model.sexec.TraceStateEntered;
import org.yakindu.sct.model.sexec.TraceStateExited;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.simulation.core.runtime.IExecutionContext;

import de.itemis.gmf.runtime.commons.highlighting.HighlightingParameters;
import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport;
import de.itemis.gmf.runtime.commons.highlighting.IHighlightingSupport.Action;

/**
 * This dynamic notation handler highlight the current states, the previous active states and the execution paths 
 * that are the transitions and pseudo states that were taken in the last run to completion step (runCycle).
 * 
 * @author terfloth
 */
public class ExecutionPathDynamicNotationHandler extends
		DefaultDynamicNotationHandler {

	
	/** stores the highlighting actions for the last execution cycle */
	protected List<Action> cycleUpdates = new ArrayList<Action>();
	
	protected List<RegularState> active = new ArrayList<RegularState>();
	protected List<RegularState> previousActive = new ArrayList<RegularState>();
	protected List<EObject> executionPathElements = new ArrayList<EObject>();
	
	
	
	public void restoreNotationState(IExecutionContext context) {
		List<Action> actionList = new ArrayList<Action>();
		
		for (RegularState state : context.getAllActiveStates()) {
			active.add(state);
			actionList.add( new IHighlightingSupport.Highlight(state, HighlightingParameters.DEFAULT) );
		}
		
		getHighlightingSupport().executeBatch(actionList);
		
	}


	public void visualizeStep(final TraceBeginRunCycle trace) {
		
		cycleUpdates.clear();

		for ( EObject obj : previousActive ) { cycleUpdates.add( new IHighlightingSupport.Highlight(obj, null)); }
		previousActive.clear();
		
		for ( EObject obj : executionPathElements ) { cycleUpdates.add( new IHighlightingSupport.Highlight(obj, null)); }
		executionPathElements.clear();
				
	}

	
	public void visualizeStep(final TraceEndRunCycle trace) {
		
		List<Action> actions = new ArrayList<Action>(cycleUpdates);
		getHighlightingSupport().executeBatch(actions);
		
	}

	
	public void visualizeStep(final TraceStateEntered trace) {
		
		active.add((RegularState) trace.getState().getSourceElement());
		cycleUpdates.add(new IHighlightingSupport.Highlight(trace.getState().getSourceElement(), HighlightingParameters.DEFAULT) );
		
	}

	public void visualizeStep(final TraceStateExited trace) {

		RegularState state = (RegularState) trace.getState().getSourceElement();

		active.remove(state);
		previousActive.add(state);
		cycleUpdates.add(new IHighlightingSupport.Highlight(trace.getState().getSourceElement(), TRANSITION_PARAMS) );

	}

	public void visualizeStep(final ReactionFired trace) {
		
		executionPathElements.add(trace.getReaction().getSourceElement());
		cycleUpdates.add(new IHighlightingSupport.Highlight(trace.getReaction().getSourceElement(), TRANSITION_PARAMS) );

	}

	public void visualizeStep(final TraceNodeExecuted trace) {
		
		executionPathElements.add(trace.getNode().getSourceElement());
		cycleUpdates.add(new IHighlightingSupport.Highlight(trace.getNode().getSourceElement(), TRANSITION_PARAMS) );

	}


}
