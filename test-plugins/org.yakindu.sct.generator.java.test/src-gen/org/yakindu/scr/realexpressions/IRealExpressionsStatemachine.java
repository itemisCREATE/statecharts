package org.yakindu.scr.realexpressions;
import org.yakindu.scr.IStatemachine;

public interface IRealExpressionsStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE1();
		public double getMyReal1();
		public void setMyReal1(double value);
		public double getMyReal2();
		public void setMyReal2(double value);
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
		public boolean getPlus();
		public void setPlus(boolean value);
		public boolean getMinus();
		public void setMinus(boolean value);
		public boolean getMultiply();
		public void setMultiply(boolean value);
		public boolean getDivision();
		public void setDivision(boolean value);
		public boolean getModulo();
		public void setModulo(boolean value);
		public double getNegat();
		public void setNegat(double value);
		public boolean getComplement();
		public void setComplement(boolean value);
		public double getMultiAssign();
		public void setMultiAssign(double value);
		public double getDivAssign();
		public void setDivAssign(double value);
		public double getPlusAssign();
		public void setPlusAssign(double value);
		public double getMinusAssign();
		public void setMinusAssign(double value);
		public boolean getModuloAssign();
		public void setModuloAssign(boolean value);

	}

	public SCInterface getSCInterface();

}
