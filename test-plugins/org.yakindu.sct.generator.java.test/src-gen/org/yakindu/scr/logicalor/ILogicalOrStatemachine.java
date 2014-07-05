package org.yakindu.scr.logicalor;
import org.yakindu.scr.IStatemachine;

public interface ILogicalOrStatemachine extends IStatemachine {

	public interface SCInterface {
		public long getX();
		public void setX(long value);
		public boolean getB();
		public void setB(boolean value);

	}

	public SCInterface getSCInterface();

}
