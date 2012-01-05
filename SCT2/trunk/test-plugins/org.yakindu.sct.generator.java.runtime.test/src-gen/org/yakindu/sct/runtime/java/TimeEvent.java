/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java;

public class TimeEvent<EnumType extends Enum<EnumType>>
		extends
			ValuedEvent<EnumType, Boolean> {

	private long time = -1;

	private ITimedStatemachine statemachine;

	public TimeEvent(EnumType id, int offset, boolean periodic) {
		super(id, offset, periodic);
	}

	public void setTime(long time) {
		this.time = time;
	}

	public long getTime() {
		return time;
	}

	public ITimedStatemachine getStatemachine() {
		return statemachine;
	}

	public void setStatemachine(ITimedStatemachine statemachine) {
		this.statemachine = statemachine;
	}
}
