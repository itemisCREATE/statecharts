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
import org.yakindu.sct.runtime.java.ValuedEvent;

public interface IInterfaceAImpl extends InterfaceA {

	public ValuedEvent<Events, Integer> getEventEvent1();

	public Event<Events> getEventEvent2();

	public Event<Events> getEventEvent3();

	public Event<Events> getEventEvent4();

	public void raiseEvent5();

}
