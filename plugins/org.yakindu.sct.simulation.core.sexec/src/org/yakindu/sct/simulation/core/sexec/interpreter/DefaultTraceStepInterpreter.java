package org.yakindu.sct.simulation.core.sexec.interpreter;

import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.Trace;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;

public class DefaultTraceStepInterpreter implements ITraceStepInterpreter {

	@Override
	public void evaluate(Trace trace, ExecutionContext context) {
		if (trace instanceof ReactionFired) {
			context.getExecutedElements().add(((ReactionFired) trace).getReaction().getSourceElement());
		}
	}
}
