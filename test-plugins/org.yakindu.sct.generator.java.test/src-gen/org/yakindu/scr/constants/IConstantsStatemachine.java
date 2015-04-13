package org.yakindu.scr.constants;
import org.yakindu.scr.IStatemachine;

public interface IConstantsStatemachine extends IStatemachine {

	public static final long internalConstant = 5;
	public interface SCInterface {
		public static final long x = 10;
		public static final long y = SCInterface.x * 2;
		public void raiseE();
		public long getX();
		public long getY();
		public long getResult();
		public void setResult(long value);

	}

	public SCInterface getSCInterface();

	public interface SCINamed {
		public static final String y = "Hello World";
		public static final long two = 2;
		public String getY();
		public long getTwo();

	}

	public SCINamed getSCINamed();

}
