package org.yakindu.base.expressions.interpreter.base;

import org.eclipse.xtext.xbase.lib.Functions.Function0;

public interface IInterpreter {
	
	Object evaluate(Object input);

	public static interface Control {	
		void suspend();
		void resume();	
	}
	
	public static interface Resolver {
		Object resolve(Object owner, Object symbol);
	}
	
	public static interface Context extends Resolver {

		void pushValue(Object value);
		Object popValue();
		
		void _execute(String description, Runnable r); 
		void _return(String description, Function0<?> f);
		void _requestExecution(Object program, Execution requester);
		
		void setValue(Object slot, Object value);
		void raise(Object slot, Object value);
		Object getValue(Object slot);
		
		
		void enterCall(String opName);
		void exitCall(Object returnValue);

		/** defines variable in current scope */
		Object defineVariable(String name, Object value);
	}
	
	public static interface Execution {
		
		void setExecutionContext(IInterpreter.Context context);
		void provideExecution(Object program);

	}
	
}
