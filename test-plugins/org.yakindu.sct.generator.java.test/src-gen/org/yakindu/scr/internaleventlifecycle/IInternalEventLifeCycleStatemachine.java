package org.yakindu.scr.internaleventlifecycle;
import org.yakindu.scr.IStatemachine;

public interface IInternalEventLifeCycleStatemachine extends IStatemachine {

	public interface SCIDefault {
		public void raiseE();
		public void raiseF();

	}

	public SCIDefault getSCIDefault();

}
