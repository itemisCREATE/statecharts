package org.yakindu.scr.readonlyvariable;
import org.yakindu.scr.IStatemachine;

public interface IReadOnlyVariableStatemachine extends IStatemachine {
	public interface SCInterface {
		public long getMyInt();
		public String getMyString();
		public boolean getMyBool();
		public double getMyReal();

	}

	public SCInterface getSCInterface();

	public interface SCIA {
		public long getMyInt();
		public String getMyString();
		public boolean getMyBool();
		public double getMyReal();

	}

	public SCIA getSCIA();

}
