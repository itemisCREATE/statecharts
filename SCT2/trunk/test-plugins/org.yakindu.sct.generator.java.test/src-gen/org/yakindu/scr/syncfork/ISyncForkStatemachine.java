package org.yakindu.scr.syncfork;
import org.yakindu.scr.IStatemachine;

public interface ISyncForkStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE();
		public void raiseF();

	}

	public SCInterface getSCInterface();

}
