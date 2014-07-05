package org.yakindu.scr.staticchoice;
import org.yakindu.scr.IStatemachine;

public interface IStaticChoiceStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseReset();
		public long getNumber();
		public void setNumber(long value);

	}

	public SCInterface getSCInterface();

}
