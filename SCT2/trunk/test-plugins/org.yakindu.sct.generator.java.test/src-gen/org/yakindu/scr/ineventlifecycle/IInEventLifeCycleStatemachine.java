package org.yakindu.scr.ineventlifecycle;
import org.yakindu.scr.IStatemachine;

public interface IInEventLifeCycleStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE();
		public int getI();
		public void setI(int value);

	}

	public SCInterface getSCInterface();

}
