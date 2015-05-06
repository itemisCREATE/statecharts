package org.yakindu.scr.choice;
import org.yakindu.scr.IStatemachine;

public interface IChoiceStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseE();
		public void raiseF();
		public void raiseG();
		public void raiseH();
		public boolean getC();
		public void setC(boolean value);

	}

	public SCInterface getSCInterface();

}
