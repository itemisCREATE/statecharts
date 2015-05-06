package org.yakindu.scr.deepentry;
import org.yakindu.scr.IStatemachine;

public interface IDeepEntryStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseE();
		public void raiseF();
		public long getX();
		public void setX(long value);
		public long getY();
		public void setY(long value);
		public long getZ();
		public void setZ(long value);

	}

	public SCInterface getSCInterface();

}
