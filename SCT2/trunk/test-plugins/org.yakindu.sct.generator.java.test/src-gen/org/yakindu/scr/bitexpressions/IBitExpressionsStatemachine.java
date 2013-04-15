package org.yakindu.scr.bitexpressions;
import org.yakindu.scr.IStatemachine;

public interface IBitExpressionsStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE1();
		public int getMyBit1();
		public void setMyBit1(int value);
		public int getMyBit2();
		public void setMyBit2(int value);
		public int getLeftBitshift();
		public void setLeftBitshift(int value);
		public int getRightBitshift();
		public void setRightBitshift(int value);
		public int getComplementBitshift();
		public void setComplementBitshift(int value);
		public int getBitwiseAnd();
		public void setBitwiseAnd(int value);
		public int getBitwiseOr();
		public void setBitwiseOr(int value);
		public int getBitwiseXor();
		public void setBitwiseXor(int value);

	}

	public SCInterface getSCInterface();

}
