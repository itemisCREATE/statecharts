/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.interfacetest;

import org.yakindu.sct.runtime.java.INotificationSender;
import org.yakindu.sct.runtime.java.IGenericAccessInterface;
import org.yakindu.sct.runtime.java.ValuedEvent;

public interface DefaultInterface
		extends
			INotificationSender,
			IGenericAccessInterface {

	public enum Events {
		Event1, Event2,
	}

	public enum Variables {
		var1, var2, var3,
	}

	public void raiseEvent1();
	public boolean isRaisedEvent2();

	public ValuedEvent<Events, Integer> getEventEvent2();

	public boolean getVarVar1();
	public void setVarVar1(boolean value);
	public double getVarVar2();
	public void setVarVar2(double value);
	public int getVarVar3();
	public void setVarVar3(int value);
}
