package org.yakindu.scr.valuedevents;
import org.yakindu.scr.IStatemachine;

public interface IValuedEventsStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseIntegerEvent(long value);
		public long getMyVar();
		public void setMyVar(long value);

	}

	public SCInterface getSCInterface();

}
