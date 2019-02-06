package org.yakindu.scr.ieq.eventdrivenoutevents;

import java.util.LinkedList;
import java.util.Queue;
import org.yakindu.scr.ieq.IStatemachine;

public interface IEventDrivenOutEventsStatemachine extends IStatemachine {
	public interface SCInterface {
	
		public void raiseE1();
		
		public boolean isRaisedE2();
		
	}
	
	public SCInterface getSCInterface();
	
}
