package org.yakindu.scr.outeventlifecycle;
import org.yakindu.scr.IStatemachine;

public interface IOutEventLifeCycleStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE();
		public boolean isRaisedF();
		public boolean getF_available_in_cycle();
		public void setF_available_in_cycle(boolean value);
		public boolean getF_available_in_next_cycle();
		public void setF_available_in_next_cycle(boolean value);

	}

	public SCInterface getSCInterface();

}
