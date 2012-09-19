package org.yakindu.scr.parenthesis;

import org.yakindu.scr.IStatemachine;

public interface IParenthesisStatemachine extends IStatemachine {

	public interface SCIDefault {

		public int getErg();
		public void setErg(int value);

	}

	public SCIDefault getSCIDefault();

}
