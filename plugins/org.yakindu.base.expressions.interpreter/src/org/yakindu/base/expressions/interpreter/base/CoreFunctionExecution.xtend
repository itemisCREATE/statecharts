/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
 
package org.yakindu.base.expressions.interpreter.base

import org.yakindu.base.expressions.interpreter.CoreFunction
import java.util.Map
import org.yakindu.base.expressions.interpreter.Signature
import org.yakindu.base.expressions.interpreter.Function
import java.util.HashMap
import java.util.Arrays

/**
 * This extension of CoreFunctions implements function caching.
 * 
 * TODO: Move to CoreFunction or Function
 * 
 * @author axel terfloth
 */
class CoreFunctionExecution extends CoreFunction {

	protected Map<Signature, Function> functionMap = new HashMap<Signature, Function>();
	
		
	protected def  Object evaluate(String name, Object... params) {
		val Function lookup = lookup(name, params);
		if (lookup === null)
			throw new RuntimeException(
					"No function definition found for '" + name + "' with parameters: " + Arrays.toString(params));

		return lookup.execute(params);
	}


	protected def Function lookup(String name, Object... params) {
		val Signature sig = new Signature(name, toParamTypes(params));
		var Function f = functionMap.get(sig);
		if (f === null) {
			f = super.lookup(getClass(), name, sig.getParamTypes());
			functionMap.put(sig, f);
		}
		return f;
	}
	
}