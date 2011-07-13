/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.stext;

import org.yakindu.sct.simulation.runtime.ExecutionScope;

public class Trigger {
	
	public static class SignalEvent extends Trigger {
		protected String signal;

		public SignalEvent(String signal) {
			super();
			this.signal = signal;
		}

		public String getSignal() {
			return signal;
		}

		public void setSignal(String signal) {
			this.signal = signal;
		}
		
	}
	
	public static class TimeEvent extends Trigger implements Expression {
		protected Expression durationExp;

		
		public TimeEvent(Expression timeValueExp) {
			super();
			this.durationExp = timeValueExp;
		}

		public Expression getDurationExp() {
			return durationExp;
		}

		public void setDurationExp(Expression timeValueExp) {
			this.durationExp = timeValueExp;
		}

		public Object execute(ExecutionScope scope) {
			return durationExp.execute(scope);
		}
		
		
	}
}
