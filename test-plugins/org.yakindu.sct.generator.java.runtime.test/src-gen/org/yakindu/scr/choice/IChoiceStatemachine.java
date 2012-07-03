package org.yakindu.scr.choice;

import org.yakindu.scr.IStatemachine;

public interface IChoiceStatemachine extends IStatemachine {

	public interface SCIDefault {

		public void raisePressKey();

		public int getValue();
		public void setValue(int value);

	}

	public SCIDefault getSCIDefault();

}
