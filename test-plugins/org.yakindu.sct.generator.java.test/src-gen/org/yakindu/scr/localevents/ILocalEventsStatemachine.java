package org.yakindu.scr.localevents;

import java.util.LinkedList;
import java.util.Queue;
import org.yakindu.scr.IStatemachine;

public interface ILocalEventsStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseE();
		
		public long getCycleCountSm();
		
		public void setCycleCountSm(long value);
		
		public long getCycleCount1();
		
		public void setCycleCount1(long value);
		
		public long getCycleCount2();
		
		public void setCycleCount2(long value);
		
		public long getChecksum();
		
		public void setChecksum(long value);
		
	}
	
	public SCInterface getSCInterface();
	
}
