package org.yakindu.scr.simpleevent;
import org.yakindu.scr.IStatemachine;

public interface ISimpleEventStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseEvent1();

	}

	public SCInterface getSCInterface();

}
