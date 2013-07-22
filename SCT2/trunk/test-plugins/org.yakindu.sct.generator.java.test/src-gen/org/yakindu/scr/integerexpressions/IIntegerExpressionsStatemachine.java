package org.yakindu.scr.integerexpressions;
import org.yakindu.scr.IStatemachine;

public interface IIntegerExpressionsStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE1();
		public int getMyInt1();
		public void setMyInt1(int value);
		public int getMyInt2();
		public void setMyInt2(int value);
		public boolean getLess();
		public void setLess(boolean value);
		public boolean getGreater();
		public void setGreater(boolean value);
		public boolean getEqualOrLess();
		public void setEqualOrLess(boolean value);
		public boolean getEqualOrGreater();
		public void setEqualOrGreater(boolean value);
		public boolean getEqual();
		public void setEqual(boolean value);
		public boolean getNotEqual();
		public void setNotEqual(boolean value);
		public int getPlus();
		public void setPlus(int value);
		public int getMinus();
		public void setMinus(int value);
		public int getMultiply();
		public void setMultiply(int value);
		public int getDivision();
		public void setDivision(int value);
		public int getModulo();
		public void setModulo(int value);
		public int getNegat();
		public void setNegat(int value);
		public boolean getComplement();
		public void setComplement(boolean value);
		public int getMultiAssign();
		public void setMultiAssign(int value);
		public int getDivAssign();
		public void setDivAssign(int value);
		public int getPlusAssign();
		public void setPlusAssign(int value);
		public int getMinusAssign();
		public void setMinusAssign(int value);
		public int getModuloAssign();
		public void setModuloAssign(int value);

	}

	public SCInterface getSCInterface();

}
