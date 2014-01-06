package org.yakindu.scr.integerexpressions;
import org.yakindu.scr.IStatemachine;

public interface IIntegerExpressionsStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE1();
		public long getMyInt1();
		public void setMyInt1(long value);
		public long getMyInt2();
		public void setMyInt2(long value);
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
		public long getPlus();
		public void setPlus(long value);
		public long getMinus();
		public void setMinus(long value);
		public long getMultiply();
		public void setMultiply(long value);
		public long getDivision();
		public void setDivision(long value);
		public long getModulo();
		public void setModulo(long value);
		public long getNegat();
		public void setNegat(long value);
		public boolean getComplement();
		public void setComplement(boolean value);
		public long getMultiAssign();
		public void setMultiAssign(long value);
		public long getDivAssign();
		public void setDivAssign(long value);
		public long getPlusAssign();
		public void setPlusAssign(long value);
		public long getMinusAssign();
		public void setMinusAssign(long value);
		public long getModuloAssign();
		public void setModuloAssign(long value);

	}

	public SCInterface getSCInterface();

}
