package org.yakindu.scr.priorityvalues;
import org.yakindu.scr.IStatemachine;

public interface IPriorityValuesStatemachine extends IStatemachine {

	public interface SCIDefault {
		public void raiseEvent1();
		public void raiseEvent2();

	}

	public SCIDefault getSCIDefault();

}
