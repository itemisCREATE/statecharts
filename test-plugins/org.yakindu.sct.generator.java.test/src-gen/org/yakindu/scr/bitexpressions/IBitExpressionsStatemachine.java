package org.yakindu.scr.bitexpressions;
import org.yakindu.scr.IStatemachine;

public interface IBitExpressionsStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE1();
		public long getMyBit1();
		public void setMyBit1(long value);
		public long getMyBit2();
		public void setMyBit2(long value);
		public long getLeftBitshift();
		public void setLeftBitshift(long value);
		public long getRightBitshift();
		public void setRightBitshift(long value);
		public long getComplementBitshift();
		public void setComplementBitshift(long value);
		public long getBitwiseAnd();
		public void setBitwiseAnd(long value);
		public long getBitwiseOr();
		public void setBitwiseOr(long value);
		public long getBitwiseXor();
		public void setBitwiseXor(long value);

	}

	public SCInterface getSCInterface();

}
