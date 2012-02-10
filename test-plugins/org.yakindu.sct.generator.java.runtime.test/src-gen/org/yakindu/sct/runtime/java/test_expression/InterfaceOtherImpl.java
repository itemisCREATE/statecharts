/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_expression;

import java.util.HashMap;
import java.util.Map;
import org.yakindu.sct.runtime.java.NotificationSender;
import org.yakindu.sct.runtime.java.VariableNotification;
import org.yakindu.sct.runtime.java.ValuedEvent;

public class InterfaceOtherImpl extends NotificationSender
		implements
			IInterfaceOtherImpl {
	protected Map<String, Object> variableMap;

	public InterfaceOtherImpl() {
		variableMap = new HashMap<String, Object>();
		variableMap.put("var1", new Boolean(false));
		variableMap.put("var2", new Double(0D));
		variableMap.put("var3", new Integer(0));

	}

	public boolean getVarVar1() {
		return (Boolean) variableMap.get("var1");
	}

	public void setVarVar1(boolean value) {
		boolean oldValue = getVarVar1();
		variableMap.put("var1", new Boolean(value));
		notifyListeners(new VariableNotification<Boolean>(Variables.var1,
				getVarVar1(), oldValue));
	}
	public double getVarVar2() {
		return (Double) variableMap.get("var2");
	}

	public void setVarVar2(double value) {
		double oldValue = getVarVar2();
		variableMap.put("var2", new Double(value));
		notifyListeners(new VariableNotification<Double>(Variables.var2,
				getVarVar2(), oldValue));
	}
	public int getVarVar3() {
		return (Integer) variableMap.get("var3");
	}

	public void setVarVar3(int value) {
		int oldValue = getVarVar3();
		variableMap.put("var3", new Integer(value));
		notifyListeners(new VariableNotification<Integer>(Variables.var3,
				getVarVar3(), oldValue));
	}

	public boolean raiseEvent(String name) {
		return false;
	}

	public boolean raiseEvent(String name, Object value) {
		return false;
	}

	public boolean setVariable(String name, Object value) {
		if (variableMap.get(name) != null
				&& variableMap.get(name).getClass() == value.getClass()) {
			Object oldValue = variableMap.get(name);
			variableMap.put(name, value);
			notifyListeners(new VariableNotification<Object>(
					Variables.valueOf(name), variableMap.get(name), oldValue));
			return true;
		}
		return false;
	}

	public Object getVariable(String name) {
		return variableMap.get(name);
	}
}
