package org.yakindu.scr.eventdriventriggeredbytimeevent;

import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface IEventDrivenTriggeredByTimeEventStatemachine extends ITimerCallback,IStatemachine {
	public interface SCInterface {
	
		public long getX();
		
		public void setX(long value);
		
		public long getTransition_count();
		
		public void setTransition_count(long value);
		
	}
	
	public SCInterface getSCInterface();
	
}
