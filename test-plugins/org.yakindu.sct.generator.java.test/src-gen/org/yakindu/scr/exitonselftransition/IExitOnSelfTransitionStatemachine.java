package org.yakindu.scr.exitonselftransition;
import org.yakindu.scr.IStatemachine;

public interface IExitOnSelfTransitionStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE();
		public void raiseF();
		public int getEntryCount();
		public void setEntryCount(int value);
		public int getExitCount();
		public void setExitCount(int value);

	}

	public SCInterface getSCInterface();

}
