/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_localactions;

public class DefaultInterfaceEventBasedImpl extends DefaultInterfaceImpl {

	public DefaultInterfaceEventBasedImpl(
			Test_LocalActionsCycleBasedStatemachine statemachine) {
		super(statemachine);
	}

	public void raiseEvent1() {
		super.raiseEvent1();
		statemachine.runCycle();
	}
	public void raiseEvent2() {
		super.raiseEvent2();
		statemachine.runCycle();
	}
	public void raiseEvent3() {
		super.raiseEvent3();
		statemachine.runCycle();
	}
	public void raiseEvent4() {
		super.raiseEvent4();
		statemachine.runCycle();
	}

	public boolean raiseEvent(String name) {
		boolean raised = super.raiseEvent(name);
		if (raised) {
			statemachine.runCycle();
		}
		return raised;
	}

	public boolean raiseEvent(String name, Object value) {
		boolean raised = super.raiseEvent(name, value);
		if (raised) {
			statemachine.runCycle();
		}
		return raised;
	}
}
