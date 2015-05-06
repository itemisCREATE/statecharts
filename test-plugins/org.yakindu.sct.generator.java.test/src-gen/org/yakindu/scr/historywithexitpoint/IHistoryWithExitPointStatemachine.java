package org.yakindu.scr.historywithexitpoint;
import org.yakindu.scr.IStatemachine;

public interface IHistoryWithExitPointStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raisePush();
		public void raiseBack();
		public void raiseNext();

	}

	public SCInterface getSCInterface();

}
