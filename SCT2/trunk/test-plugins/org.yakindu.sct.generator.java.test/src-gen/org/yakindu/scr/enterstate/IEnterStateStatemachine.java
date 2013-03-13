package org.yakindu.scr.enterstate;
import org.yakindu.scr.IStatemachine;

public interface IEnterStateStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE();
		public void raiseF();
		public void raiseG();

	}

	public SCInterface getSCInterface();

}
