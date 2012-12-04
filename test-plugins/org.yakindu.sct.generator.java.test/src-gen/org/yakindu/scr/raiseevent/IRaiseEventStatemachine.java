package org.yakindu.scr.raiseevent;
import org.yakindu.scr.IStatemachine;

public interface IRaiseEventStatemachine extends IStatemachine {

	public interface SCIDefault {
		public boolean isRaisedE1();
		public void raiseE2();

	}

	public SCIDefault getSCIDefault();

}
