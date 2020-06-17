/** Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.scr.eventdriven;

import java.util.LinkedList;
import java.util.Queue;
import org.yakindu.scr.IStatemachine;
import org.yakindu.sct.rx.Observable;

public interface IEventDrivenStatemachine extends IStatemachine {
	
	public interface SCInterface {
	
		public void raiseInEvent();
		
		public void raiseInEventBool(boolean value);
		
		public boolean isRaisedOutEvent();
		
		public Observable<Void> getOutEvent();
		
		public boolean isRaisedRunning();
		
		public Observable<Void> getRunning();
		
		public boolean isRaisedOe1();
		
		public Observable<Void> getOe1();
		
		public boolean isRaisedOe2();
		
		public Observable<Void> getOe2();
		
		public boolean isRaisedOe3();
		
		public Observable<Void> getOe3();
		
	}
	
	public SCInterface getSCInterface();
	
	
	public interface SCINamedI {
	
		public void raiseNamedInEvent();
		
	}
	
	public SCINamedI getSCINamedI();
	
}
