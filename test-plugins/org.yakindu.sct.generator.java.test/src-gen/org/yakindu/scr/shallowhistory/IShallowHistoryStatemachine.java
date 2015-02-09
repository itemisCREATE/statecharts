package org.yakindu.scr.shallowhistory;
import org.yakindu.scr.IStatemachine;

public interface IShallowHistoryStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseEvent1();
		public void raiseEvent2();
		public void raiseEvent3();
		public void raiseEvent4();
		public void raiseEvent5();
		public void raiseEvent6();
		public void raiseEvent7();
		public void raiseEvent8();

	}

	public SCInterface getSCInterface();

}
