package org.yakindu.scr.valuedevents;
import org.yakindu.scr.IStatemachine;

public interface IValuedEventsStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseIntegerEvent(int value);
		public int getMyVar();
		public void setMyVar(int value);

	}

	public SCInterface getSCInterface();

}
