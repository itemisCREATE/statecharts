package org.yakindu.scr.dynamicchoice;
import org.yakindu.scr.IStatemachine;

public interface IDynamicChoiceStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseReset();
		public long getNumber();
		public void setNumber(long value);

	}

	public SCInterface getSCInterface();

}
