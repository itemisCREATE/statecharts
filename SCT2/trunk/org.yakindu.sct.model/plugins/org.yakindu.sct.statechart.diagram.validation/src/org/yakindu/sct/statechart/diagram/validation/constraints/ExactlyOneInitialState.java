package org.yakindu.sct.statechart.diagram.validation.constraints;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.xtext.EcoreUtil2;
import org.yakindu.sct.model.statechart.statechart.InitialState;
import org.yakindu.sct.model.statechart.statechart.Region;

public class ExactlyOneInitialState extends AbstractModelConstraint {
	@Override
	public IStatus validate(IValidationContext ctx) {
		System.out.println("ExactlyOneInitialState");
		Region region = (Region) ctx.getTarget();
		List<InitialState> initialStates = EcoreUtil2.getAllContentsOfType(region, InitialState.class);
		if (initialStates.size() != 1) {
			System.out.println("Creating ERROR");
			return ctx.createFailureStatus(region, initialStates.size());
		}
		return ctx.createSuccessStatus();
	}
}
