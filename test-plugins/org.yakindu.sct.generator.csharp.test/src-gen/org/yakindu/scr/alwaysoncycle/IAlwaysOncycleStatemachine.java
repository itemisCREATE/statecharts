package org.yakindu.scr.alwaysoncycle;
import org.yakindu.scr.IStatemachine;

public interface IAlwaysOncycleStatemachine extends IStatemachine {
	public interface SCInterface {
		public long getValue();
		public void setValue(long value);
		public boolean getV2();
		public void setV2(boolean value);

	}

	public SCInterface getSCInterface();

}
