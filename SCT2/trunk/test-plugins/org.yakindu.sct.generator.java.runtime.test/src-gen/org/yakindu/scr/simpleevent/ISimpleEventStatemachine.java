package org.yakindu.scr.simpleevent;

import org.yakindu.scr.IStatemachine;

public interface ISimpleEventStatemachine extends IStatemachine {

	public interface SCIDefault {

		public void raiseEvent1();

	}

	public SCIDefault getSCIDefault();

}
