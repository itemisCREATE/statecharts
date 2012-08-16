package org.yakindu.scr.ckeywords;

import org.yakindu.scr.IStatemachine;

public interface ICKeywordsStatemachine extends IStatemachine {

	public interface SCIDefault {

		public void raiseAuto();

		public void raiseBreak();

		public boolean getVarCase();
		public void setVarCase(boolean value);
		public int getVarDo();
		public void setVarDo(int value);
		public boolean getVarContinue();
		public void setVarContinue(boolean value);
		public boolean getVarDouble();
		public void setVarDouble(boolean value);
		public boolean getVarEnum();
		public void setVarEnum(boolean value);
		public boolean getExtern();
		public void setExtern(boolean value);
		public boolean getVarFloat();
		public void setVarFloat(boolean value);
		public boolean getVarFor();
		public void setVarFor(boolean value);
		public boolean getVarGoto();
		public void setVarGoto(boolean value);
		public boolean getVarIf();
		public void setVarIf(boolean value);
		public boolean getVarInt();
		public void setVarInt(boolean value);
		public boolean getVarLong();
		public void setVarLong(boolean value);
		public boolean getRegister();
		public void setRegister(boolean value);
		public boolean getVarReturn();
		public void setVarReturn(boolean value);
		public boolean getVarShort();
		public void setVarShort(boolean value);
		public boolean getSigned();
		public void setSigned(boolean value);
		public boolean getSizeof();
		public void setSizeof(boolean value);
		public boolean getVarStatic();
		public void setVarStatic(boolean value);
		public boolean getStruct();
		public void setStruct(boolean value);
		public boolean getVarSwitch();
		public void setVarSwitch(boolean value);
		public boolean getTypedef();
		public void setTypedef(boolean value);
		public boolean getUnion();
		public void setUnion(boolean value);
		public boolean getUnsigned();
		public void setUnsigned(boolean value);
		public boolean getVarVoid();
		public void setVarVoid(boolean value);
		public boolean getVarVolatile();
		public void setVarVolatile(boolean value);
		public boolean getVarWhile();
		public void setVarWhile(boolean value);

	}

	public SCIDefault getSCIDefault();

}
