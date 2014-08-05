package org.yakindu.scr.priorityvalues;
import org.yakindu.scr.IStatemachine;

public interface IPriorityValuesStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseEvent1();
		public void raiseEvent2();

	}

	public SCInterface getSCInterface();

}
