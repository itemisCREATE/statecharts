package org.yakindu.scr.eventdriventriggeredbyevent;

import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface IEventDrivenTriggeredByEventStatemachine extends ITimerCallback,IStatemachine {
	public interface SCInterface {
		public void raiseE();
		
		public long getX();
		
		public void setX(long value);
		
	}
	
	public SCInterface getSCInterface();
	
}
