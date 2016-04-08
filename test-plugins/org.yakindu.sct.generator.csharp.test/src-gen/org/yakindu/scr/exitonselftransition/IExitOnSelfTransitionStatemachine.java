package org.yakindu.scr.exitonselftransition;
import org.yakindu.scr.IStatemachine;

public interface IExitOnSelfTransitionStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseE();
		public void raiseF();
		public long getEntryCount();
		public void setEntryCount(long value);
		public long getExitCount();
		public void setExitCount(long value);

	}

	public SCInterface getSCInterface();

}
