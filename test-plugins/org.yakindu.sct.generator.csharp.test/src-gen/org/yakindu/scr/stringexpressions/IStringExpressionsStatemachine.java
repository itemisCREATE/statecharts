package org.yakindu.scr.stringexpressions;
import org.yakindu.scr.IStatemachine;

public interface IStringExpressionsStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseE();
		public String getStringA();
		public void setStringA(String value);
		public String getStringA2();
		public void setStringA2(String value);
		public String getStringB();
		public void setStringB(String value);
		public String getQuotedStringX();
		public void setQuotedStringX(String value);
		public String getQuotedStringY();
		public void setQuotedStringY(String value);
		public boolean getStringVarEqual();
		public void setStringVarEqual(boolean value);
		public boolean getStringVarNotEqual();
		public void setStringVarNotEqual(boolean value);
		public boolean getGuardStringNotEqual();
		public void setGuardStringNotEqual(boolean value);
		public boolean getGuardStringEqual();
		public void setGuardStringEqual(boolean value);

	}

	public SCInterface getSCInterface();

}
