package org.yakindu.scr.ineventlifecycle;
import org.yakindu.scr.IStatemachine;

public interface IInEventLifeCycleStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseE();
		public long getI();
		public void setI(long value);

	}

	public SCInterface getSCInterface();

}
