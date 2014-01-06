package org.yakindu.scr.guard;
import org.yakindu.scr.IStatemachine;

public interface IGuardStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseEvent1();
		public void raiseEvent2();
		public void raiseReturn();
		public long getMyVar();
		public void setMyVar(long value);

	}

	public SCInterface getSCInterface();

}
