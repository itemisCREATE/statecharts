package org.yakindu.scr.parenthesis;
import org.yakindu.scr.IStatemachine;

public interface IParenthesisStatemachine extends IStatemachine {
	public interface SCInterface {
		public long getErg();
		public void setErg(long value);

	}

	public SCInterface getSCInterface();

}
