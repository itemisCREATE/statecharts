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

import org.yakindu.sct.runtime.java.INotificationSender;
import org.yakindu.sct.runtime.java.IGenericAccessInterface;
import org.yakindu.sct.runtime.java.ValuedEvent;

public interface DefaultInterface
		extends
			INotificationSender,
			IGenericAccessInterface {

	public enum Events {
		Event1, Event2, Event3,
	}

	public enum Variables {
		var1, var2, var3, var4, var5,
	}

	public void raiseEvent1(int value);
	public boolean isRaisedEvent2();

	public ValuedEvent<Events, Double> getEventEvent2();

	public void raiseEvent3();

	public int getVarVar1();
	public void setVarVar1(int value);
	public int getVarVar2();
	public void setVarVar2(int value);
	public double getVarVar3();
	public void setVarVar3(double value);
	public double getVarVar4();
	public void setVarVar4(double value);
	public boolean getVarVar5();
	public void setVarVar5(boolean value);
}
