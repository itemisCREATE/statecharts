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
package org.yakindu.sct.model.sexec.interpreter.stext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.yakindu.sct.model.sexec.interpreter.IStatementInterpreter;
import org.yakindu.sct.model.stext.stext.OperationDefinition;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - added caching of function lookups
 * 
 */
public abstract class AbstractStatementInterpreter extends CoreFunction
		implements IStatementInterpreter {

	protected static Map<String, String> assignFunctionMap = new HashMap<String, String>();

	protected List<Object> operationCallback;

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

	public void setOperationCallbacks(List<Object> callbacks) {
		this.operationCallback = callbacks;
	}

	public Object executeOperationCallback(OperationDefinition definition,
			Object... parameter) {
		PolymorphicDispatcher<Object> dispatcher = new PolymorphicDispatcher<Object>(
				definition.getName(), definition.getParameters().size(),
				definition.getParameters().size(), operationCallback);
		try {
			return dispatcher.invoke(parameter);
		} catch (WrappedException e) {
			throw e;
		} catch (Exception ex) {
			throw new WrappedException("Error during invocation of operation '"
					+ definition.getName() + "' with params "
					+ definition.getParameters() + " '", ex);
		}
	}

}
