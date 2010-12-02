package org.yakindu.sct.statechart.diagram.validation.provider.impl;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.sct.model.statechart.statechart.FinalState;
import org.yakindu.sct.model.statechart.statechart.InitialState;
import org.yakindu.sct.model.statechart.statechart.NamedElement;
import org.yakindu.sct.model.statechart.statechart.Region;
import org.yakindu.sct.model.statechart.statechart.Vertex;
import org.yakindu.sct.statechart.diagram.validation.IValidationProvider;
import org.yakindu.sct.statechart.diagram.validation.provider.AbstractJavaValidationProvider;
import org.yakindu.sct.statechart.diagram.validation.provider.AbstractJavaValidationProvider.ValidationRule;

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
		List<InitialState> initialStates = EcoreUtil2.getAllContentsOfType(
				region, InitialState.class);
		if (initialStates.size() != 1) {
			return createErrorStatus("A region must contain exactly one initial state!");
		}
		return createOKStatus();
	}

	@ValidationRule
	public IStatus validateIncomingTransitions(Vertex vertex) {
		if (vertex.getIncomingTransitions().size() == 0
				&& !(vertex instanceof InitialState)) {
			return createErrorStatus("A state must have at least one incoming transition!");
		}
		return createOKStatus();
	}

	@ValidationRule
	public IStatus validateOutgoingTransitions(Vertex vertex) {
		if (!(vertex instanceof FinalState)) {
			if (vertex.getOutgoingTransitions().size() == 0 && !(vertex instanceof FinalState)) {
				return createErrorStatus("A state must have at least one outgoing transition!");
			}
		}
		return createOKStatus();
	}
	@ValidationRule
	public IStatus validateNameIsNotEmpty(NamedElement namedElement){
		if(namedElement.getName() == null || namedElement.getName().isEmpty())
			return createErrorStatus("name must not be empty!");
		return createOKStatus();
	}

}
