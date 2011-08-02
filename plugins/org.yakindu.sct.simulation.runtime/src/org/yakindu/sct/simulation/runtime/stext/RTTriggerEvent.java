package org.yakindu.sct.simulation.runtime.stext;

import org.yakindu.sct.simulation.runtime.ExecutionScope;

public class RTTriggerEvent {

	public static class SignalEvent extends RTTriggerEvent {
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
	
	public static class TimeEvent extends RTTriggerEvent implements RTExpression {
		protected RTExpression durationExp;

		
		public TimeEvent(RTExpression timeValueExp) {
			super();
			this.durationExp = timeValueExp;
		}

		public RTExpression getDurationExp() {
			return durationExp;
		}

		public void setDurationExp(RTExpression timeValueExp) {
			this.durationExp = timeValueExp;
		}

		public Object execute(ExecutionScope scope) {
			return durationExp.execute(scope);
		}
		
		
	}

}
