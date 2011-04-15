package org.yakindu.sct.statechart.diagram.validation.provider.impl;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.model.sct.statechart.Entry;
import org.yakindu.model.sct.statechart.FinalState;
import org.yakindu.model.sct.statechart.Region;
import org.yakindu.model.sct.statechart.State;
import org.yakindu.model.sct.statechart.Vertex;
import org.yakindu.sct.statechart.diagram.extensions.IValidationProvider;
import org.yakindu.sct.statechart.diagram.validation.provider.AbstractJavaValidationProvider;

/**
 * Implementation of {@link IValidationProvider} that contains common
 * {@link ValidationRule}s for Statechart.
 * 
 * @author muelder
 * 
 */
public class StatechartDefaultValidationProvider extends
		AbstractJavaValidationProvider {

	@ValidationRule
	public IStatus validateExactlyOneInitialState(Region region) {
		//FIXME: Check for Initial kind only
		List<Entry> initialStates = EcoreUtil2.typeSelect(region.getVertices(), Entry.class);
		if (initialStates.size() != 1) {
			return createErrorStatus("A region must contain exactly one initial state!");
		}
		return createOKStatus();
	}

	@ValidationRule
	public IStatus validateIncomingTransition(Vertex vertex) {
		if (vertex.getIncomingTransitions().size() == 0
				&& !(vertex instanceof Entry)) {
			return createErrorStatus("A state must have at least one incoming transition!");
		}
		return createOKStatus();
	}

	@ValidationRule
	public IStatus validateOutgoingTransitions(State vertex) {
		if (!(vertex instanceof FinalState)) {
			if (vertex.getOutgoingTransitions().size() == 0) {
				return createWarningStatus("A state should have at least one outgoing transition.");
			}
		}
		return createOKStatus();
	}

	@ValidationRule
	public IStatus validateNameIsNotEmpty(State state) {
		if ( !(state instanceof FinalState) && (state.getName() == null || "".equals(state.getName())))
			return createErrorStatus("A state must have a name!");
		return createOKStatus();
	}

}
