/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_parallelregions;

import org.yakindu.sct.runtime.java.INotificationSender;

public interface DefaultInterface extends INotificationSender {

	public enum Events {
		Event1, Event2, Event3, Event4, Event5, Event6, Event7, Event8, Event9, Event10, Event11, Event12, Event13, Event14,
	}

	public enum Variables {
		reg3, hierarchy,
	}

	public void raiseEvent1();

	public void raiseEvent2();

	public void raiseEvent3();

	public void raiseEvent4();

	public void raiseEvent5();

	public void raiseEvent6();

	public void raiseEvent7();

	public void raiseEvent8();

	public void raiseEvent9();

	public void raiseEvent10();

	public void raiseEvent11();

	public void raiseEvent12();

	public void raiseEvent13();

	public void raiseEvent14();

	public int getVarReg3();
	public void setVarReg3(int value);
	public int getVarHierarchy();
	public void setVarHierarchy(int value);
}
