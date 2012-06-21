package org.yakindu.scr.alwaysoncycle;

import org.yakindu.scr.IStatemachine;

public interface IAlwaysOncycleStatemachine extends IStatemachine {

	public interface SCIDefault {

		public int getValue();
		public void setValue(int value);

	}

	public SCIDefault getSCIDefault();

}
