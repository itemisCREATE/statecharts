package org.yakindu.scr.entryexitselftransition;
import org.yakindu.scr.IStatemachine;

public interface IEntryExitSelfTransitionStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE();
		public void raiseE1();
		public long getX();
		public void setX(long value);

	}

	public SCInterface getSCInterface();

}
