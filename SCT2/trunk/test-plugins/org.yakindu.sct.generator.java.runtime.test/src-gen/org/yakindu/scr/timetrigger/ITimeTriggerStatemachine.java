package org.yakindu.scr.timetrigger;

import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimedStatemachine;

public interface ITimeTriggerStatemachine
		extends
			ITimedStatemachine,
			IStatemachine {

	public interface SCIDefault {

		public int getValue();
		public void setValue(int value);

	}

	public SCIDefault getSCIDefault();

}
