package org.yakindu.scr.parenthesis;
import org.yakindu.scr.IStatemachine;

public interface IParenthesisStatemachine extends IStatemachine {

	public interface SCInterface {
		public int getErg();
		public void setErg(int value);

	}

	public SCInterface getSCInterface();

}
