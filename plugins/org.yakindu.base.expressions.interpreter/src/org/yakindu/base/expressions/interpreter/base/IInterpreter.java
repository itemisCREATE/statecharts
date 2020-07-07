package org.yakindu.base.expressions.interpreter.base;

import org.eclipse.xtext.xbase.lib.Functions.Function0;

public interface IInterpreter {
	
	Object evaluate(Object input);

	public static interface Control {	
		void suspend();
		void resume();	
	}
	
	public static interface Context {

		void pushValue(Object value);
		Object popValue();
		
		void _execute(Function0<?> f);
		void _return(Function0<?> f);
		
		Object resolve(Object owner, Object symbol);
	}
	
	public static interface Execution {
		
		void setExecutionContext(IInterpreter.Context context);
		void provideExecution(Object program);

	}
	
}
