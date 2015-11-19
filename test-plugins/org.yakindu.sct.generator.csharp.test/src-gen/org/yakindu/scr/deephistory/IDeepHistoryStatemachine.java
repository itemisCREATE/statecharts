package org.yakindu.scr.deephistory;
import org.yakindu.scr.IStatemachine;

public interface IDeepHistoryStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseEvent1();
		public void raiseEvent2();
		public void raiseEvent3();
		public void raiseEvent4();
		public void raiseEvent5();
		public void raiseEvent6();
		public void raiseEvent7();
		public void raiseEvent8();
		public void raiseEvent9();

	}

	public SCInterface getSCInterface();

}
