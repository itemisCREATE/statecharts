package org.yakindu.scr.constants;
import org.yakindu.scr.IStatemachine;

public interface IConstantsStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE();
		public long getX();
		public long getY();
		public long getResult();
		public void setResult(long value);

	}

	public SCInterface getSCInterface();

	public interface SCINamed {
		public String getY();
		public long getTwo();

	}

	public SCINamed getSCINamed();

}
