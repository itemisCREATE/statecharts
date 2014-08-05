package org.yakindu.scr.stateisactive;
import org.yakindu.scr.IStatemachine;

public interface IStateIsActiveStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseEvent1();

	}

	public SCInterface getSCInterface();

}
