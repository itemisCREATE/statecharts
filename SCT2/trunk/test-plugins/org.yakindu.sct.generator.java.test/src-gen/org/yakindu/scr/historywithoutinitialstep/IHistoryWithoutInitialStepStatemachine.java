package org.yakindu.scr.historywithoutinitialstep;
import org.yakindu.scr.IStatemachine;

public interface IHistoryWithoutInitialStepStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseToA();
		public void raiseToB();
		public void raiseToHistory();
		public void raiseNext();

	}

	public SCInterface getSCInterface();

}
