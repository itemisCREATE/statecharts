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

import org.yakindu.sct.runtime.java.NotificationSender;
import org.yakindu.sct.runtime.java.VariableNotification;

public class InterfaceOtherImpl extends NotificationSender
		implements
			InterfaceOther {

	private boolean varVar1;
	public boolean getVarVar1() {
		return varVar1;
	}

	public void setVarVar1(boolean value) {
		boolean oldValue = getVarVar1();
		varVar1 = value;
		notifyListeners(new VariableNotification<Boolean>(Variables.var1,
				getVarVar1(), oldValue));
	}
	private double varVar2;
	public double getVarVar2() {
		return varVar2;
	}

	public void setVarVar2(double value) {
		double oldValue = getVarVar2();
		varVar2 = value;
		notifyListeners(new VariableNotification<Double>(Variables.var2,
				getVarVar2(), oldValue));
	}
	private int varVar3;
	public int getVarVar3() {
		return varVar3;
	}

	public void setVarVar3(int value) {
		int oldValue = getVarVar3();
		varVar3 = value;
		notifyListeners(new VariableNotification<Integer>(Variables.var3,
				getVarVar3(), oldValue));
	}

}
