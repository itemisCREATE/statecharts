/** Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.scr.ieq.eventdriven;

import java.util.LinkedList;
import java.util.Queue;
import org.yakindu.sct.IStatemachine;
import org.yakindu.sct.ITimerCallback;

public interface IEventDrivenTriggeredByEventStatemachine extends ITimerCallback,IStatemachine {
	
	public interface Interface {
	
		public void raiseE();
		
		public long getX();
		
		public void setX(long value);
		
	}
	
	public Interface getInterface();
	
}