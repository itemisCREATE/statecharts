package org.yakindu.scr.booleanexpressions;
import org.yakindu.scr.IStatemachine;

public interface IBooleanExpressionsStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseE1();
		public boolean getMyBool1();
		public void setMyBool1(boolean value);
		public boolean getMyBool2();
		public void setMyBool2(boolean value);
		public boolean getAnd();
		public void setAnd(boolean value);
		public boolean getOr();
		public void setOr(boolean value);
		public boolean getNot();
		public void setNot(boolean value);
		public boolean getEqual();
		public void setEqual(boolean value);
		public boolean getNotequal();
		public void setNotequal(boolean value);

	}

	public SCInterface getSCInterface();

}
