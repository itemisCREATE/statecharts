/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.sexec.interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - added caching of function lookups
 * 
 */
public abstract class AbstractStatementInterpreter extends CoreFunction
		implements IStatementInterpreter {

	protected static Map<String, String> assignFunctionMap = new HashMap<String, String>();

	static {
		assignFunctionMap.put("multAssign", "*");
		assignFunctionMap.put("divAssign", "/");
		assignFunctionMap.put("modAssign", "%");
		assignFunctionMap.put("addAssign", "+");
		assignFunctionMap.put("subAssign", "-");
		assignFunctionMap.put("leftShiftAssign", "<<");
		assignFunctionMap.put("rightShiftAssign", ">>");
		assignFunctionMap.put("andAssign", "&");
		assignFunctionMap.put("xorAssign", "^");
		assignFunctionMap.put("orAssign", "|");
	}

	protected Map<Signature, Function> functionMap = new HashMap<Signature, Function>();

	public Object evaluate(String name, Object... params) {
		Function lookup = lookup(name, params);
		return lookup.execute(params);

	}

	public Function lookup(String name, Object... params) {

		Signature sig = new Signature(name, toParamTypes(params));
		Function f = functionMap.get(sig);
		if (f == null) {
			f = super.lookup(getClass(), name, sig.getParamTypes());
			functionMap.put(sig, f);
		}
		return f;
	}

}
