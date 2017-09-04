package org.yakindu.base.expressions.interpreter;

import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext;

import com.google.inject.ImplementedBy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@ImplementedBy(ExpressionsInterpreter.class)
public interface IStatementInterpreter {
	
	public Object evaluateStatement(Expression statement, ExecutionContext context);

}
