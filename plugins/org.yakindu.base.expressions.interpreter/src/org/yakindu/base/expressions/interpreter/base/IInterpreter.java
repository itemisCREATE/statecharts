/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */

package org.yakindu.base.expressions.interpreter.base;

import org.eclipse.xtext.xbase.lib.Functions.Function0;

/**
 * Defines all core interfaces of the interpreter infrastructure. 
 * The interfaces do not assume specific data types but just define core protocols 
 * between the participating instances.
 * 
 * IInterpreter is the public interface which is intended to be used by clients.
 * 
 * @author axel aterfloth
 */
public interface IInterpreter {
	
	/** 
	 * Evaluates a program and returns a result object.
	 *  
	 * @param input the program input of a type that the interpreter implementation can consume.
	 * @return result of the evaluation. The possible types depends on the interpreter implementation.
	 */
	Object evaluate(Object input);

	
	/**
	 * 
	 * @param type
	 * @return
	 */
	Object newInstance(Object type);


	/**
	 * Invokes an operation by the operation name 
	 * @param receiver
	 * @param operation
	 * @param args
	 * @return
	 */
	public Object invokeOperation(Object receiver, String operation, Object... args);


	/**
	 * Raises an event with an optional payload
	 * @param e
	 * @param value
	 */
	public void  raiseEvent(Object e, Object value);

	
	/**
	 * An interpreter implementation which is allows to suspend and resume the execution 
	 * should implement this interface.
	 *
	 */
	public static interface Control {	
		void suspend();
		void resume();
	}
	
	/**
	 * Resolving runtime elements.
	 */
	public static interface Resolver {
		Object resolve(Object owner, Object symbol);
	}
	
	/**
	 * This interface defines a methods which can be used by the execution instances 
	 * which are involved interpreting.
	 */
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
		
		void _schedule(String jobId, long duration, boolean periodic, Runnable action);
		void _unschedule(String jobId);
	}
	
	/**
	 * Interface for instances which contribute executions of elements to the interpreter.
	 */
	public static interface Execution {
		
		void setExecutionContext(IInterpreter.Context context);
		void provideExecution(Object program);

	}
	
	/**
	 * Representation of a runtime instance of some type which contributes executions.
	 */
	public static interface Instance extends IInterpreter.Execution, IInterpreter.Resolver {
		
		void raise(Object slot, Object value);
	}
	
}
