package org.yakindu.scr.valuedevents;
import org.yakindu.scr.IStatemachine;

public interface IValuedEventsStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseIntegerEvent(long value);
		public void raiseBooleanEvent(boolean value);
		public void raiseRealEvent(double value);
		public void raiseStringEvent(String value);
		public long getMyInt();
		public void setMyInt(long value);
		public boolean getMyBool();
		public void setMyBool(boolean value);
		public double getMyReal();
		public void setMyReal(double value);
		public String getMyString();
		public void setMyString(String value);

	}

	public SCInterface getSCInterface();

}
