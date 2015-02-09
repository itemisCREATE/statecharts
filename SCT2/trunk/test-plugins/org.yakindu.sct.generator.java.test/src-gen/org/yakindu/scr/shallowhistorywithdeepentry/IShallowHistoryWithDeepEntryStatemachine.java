package org.yakindu.scr.shallowhistorywithdeepentry;
import org.yakindu.scr.IStatemachine;

public interface IShallowHistoryWithDeepEntryStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseToZ();
		public void raiseToY();
		public void raiseToC();
		public void raiseToA();

	}

	public SCInterface getSCInterface();

}
