package org.yakindu.scr.ckeywords;
import org.yakindu.scr.IStatemachine;

public interface ICKeywordsStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseAuto();
		public void raiseBreak();
		public boolean getCase();
		public void setCase(boolean value);
		public int getDo();
		public void setDo(int value);
		public boolean getContinue();
		public void setContinue(boolean value);
		public boolean getDouble();
		public void setDouble(boolean value);
		public boolean getEnum();
		public void setEnum(boolean value);
		public boolean getExtern();
		public void setExtern(boolean value);
		public boolean getFloat();
		public void setFloat(boolean value);
		public boolean getFor();
		public void setFor(boolean value);
		public boolean getGoto();
		public void setGoto(boolean value);
		public boolean getIf();
		public void setIf(boolean value);
		public boolean getInt();
		public void setInt(boolean value);
		public boolean getLong();
		public void setLong(boolean value);
		public boolean getRegister();
		public void setRegister(boolean value);
		public boolean getReturn();
		public void setReturn(boolean value);
		public boolean getShort();
		public void setShort(boolean value);
		public boolean getSigned();
		public void setSigned(boolean value);
		public boolean getSizeof();
		public void setSizeof(boolean value);
		public boolean getStatic();
		public void setStatic(boolean value);
		public boolean getStruct();
		public void setStruct(boolean value);
		public boolean getSwitch();
		public void setSwitch(boolean value);
		public boolean getTypedef();
		public void setTypedef(boolean value);
		public boolean getUnion();
		public void setUnion(boolean value);
		public boolean getUnsigned();
		public void setUnsigned(boolean value);
		public boolean getVoid();
		public void setVoid(boolean value);
		public boolean getVolatile();
		public void setVolatile(boolean value);
		public boolean getWhile();
		public void setWhile(boolean value);

	}

	public SCInterface getSCInterface();

}
