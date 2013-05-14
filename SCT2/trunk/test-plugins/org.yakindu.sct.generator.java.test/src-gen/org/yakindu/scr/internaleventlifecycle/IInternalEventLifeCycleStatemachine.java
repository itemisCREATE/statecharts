package org.yakindu.scr.internaleventlifecycle;
import org.yakindu.scr.IStatemachine;

public interface IInternalEventLifeCycleStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE();
		public void raiseF();

	}

	public SCInterface getSCInterface();

}
