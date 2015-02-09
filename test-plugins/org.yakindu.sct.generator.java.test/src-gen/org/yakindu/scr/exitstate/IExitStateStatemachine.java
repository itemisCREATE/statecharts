package org.yakindu.scr.exitstate;
import org.yakindu.scr.IStatemachine;

public interface IExitStateStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE();
		public void raiseF();
		public void raiseG();

	}

	public SCInterface getSCInterface();

}
