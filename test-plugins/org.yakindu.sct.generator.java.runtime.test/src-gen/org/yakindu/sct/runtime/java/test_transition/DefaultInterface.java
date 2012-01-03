/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_transition;

import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.INotificationSender;

public interface DefaultInterface extends INotificationSender {

	public enum Events {
		Event5, Event6, Event7,
	}

	public void raiseEvent5(boolean value);

	public void raiseEvent6();
	public boolean isRaisedEvent7();

	public Event<Events> getEventEvent7();

	public int getVarI();
	public void setVarI(int value);
	public double getVarJ();
	public void setVarJ(double value);
}
