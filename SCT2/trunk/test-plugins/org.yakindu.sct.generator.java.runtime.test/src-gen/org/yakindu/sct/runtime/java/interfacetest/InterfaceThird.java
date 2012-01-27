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

public interface InterfaceThird
		extends
			INotificationSender,
			IGenericAccessInterface {

	public enum Events {
		Event5, Event6,
	}

	public enum Variables {
		v1,
	}

	public void raiseEvent5();
	public boolean isRaisedEvent6();

	public ValuedEvent<Events, Boolean> getEventEvent6();

	public double getVarV1();
	public void setVarV1(double value);
}
