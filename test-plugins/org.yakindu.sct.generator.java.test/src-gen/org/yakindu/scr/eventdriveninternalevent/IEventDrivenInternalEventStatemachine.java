package org.yakindu.scr.eventdriveninternalevent;

import org.yakindu.scr.IStatemachine;

public interface IEventDrivenInternalEventStatemachine extends IStatemachine {
	public interface SCInterface {
	
		public void raiseStart();
		
		public void raiseReset();
		
		public boolean isRaisedE();
		
		public long getEValue();
		
		public long getX();
		
		public void setX(long value);
		
		public long getI1_sequence();
		
		public void setI1_sequence(long value);
		
		public long getI2_sequence();
		
		public void setI2_sequence(long value);
		
	}
	
	public SCInterface getSCInterface();
	
}
