package org.yakindu.sct.simulation.core.sexec.interpreter;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;
import org.yakindu.sct.simulation.core.sruntime.ExecutionEvent;
import org.yakindu.sct.simulation.core.sruntime.ExecutionSlot;

public interface IExecutionSlotResolver {

	
	ExecutionSlot resolveVariable(ExecutionContext context, EObject expression);
	
	ExecutionEvent resolveEvent(ExecutionContext context, Expression expression);
}
