package org.yakindu.scr.logicalor;
import org.yakindu.scr.IStatemachine;

public interface ILogicalOrStatemachine extends IStatemachine {

	public interface SCInterface {
		public int getX();
		public void setX(int value);
		public boolean getB();
		public void setB(boolean value);

	}

	public SCInterface getSCInterface();

}
