package org.yakindu.scr.syncfork;

import org.yakindu.scr.IStatemachine;

public interface ISyncForkStatemachine extends IStatemachine {

	public interface SCIDefault {

		public void raiseE();

		public void raiseF();

	}

	public SCIDefault getSCIDefault();

}
