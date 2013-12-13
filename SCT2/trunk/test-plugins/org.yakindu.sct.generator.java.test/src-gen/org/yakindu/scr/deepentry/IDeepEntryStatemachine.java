package org.yakindu.scr.deepentry;
import org.yakindu.scr.IStatemachine;

public interface IDeepEntryStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE();
		public void raiseF();
		public int getX();
		public void setX(int value);
		public int getY();
		public void setY(int value);
		public int getZ();
		public void setZ(int value);

	}

	public SCInterface getSCInterface();

}
