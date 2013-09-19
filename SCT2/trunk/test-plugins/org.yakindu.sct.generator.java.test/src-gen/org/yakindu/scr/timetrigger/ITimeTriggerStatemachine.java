package org.yakindu.scr.timetrigger;
import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface ITimeTriggerStatemachine extends ITimerCallback, IStatemachine {

	public interface SCInterface {
		public void raiseX3();
		public boolean isRaisedX4();
		public int getY0();
		public void setY0(int value);
		public String getY1();
		public void setY1(String value);
		public boolean getY2();
		public void setY2(boolean value);

	}

	public SCInterface getSCInterface();

	public interface SCIB {
		public void raiseX5();
		public boolean isRaisedX6();

	}

	public SCIB getSCIB();

}
