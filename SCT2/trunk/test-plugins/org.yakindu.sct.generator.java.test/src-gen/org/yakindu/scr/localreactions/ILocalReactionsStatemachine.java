package org.yakindu.scr.localreactions;
import org.yakindu.scr.IStatemachine;

public interface ILocalReactionsStatemachine extends IStatemachine {

	public interface SCInterface {
		public long getX();
		public void setX(long value);

	}

	public SCInterface getSCInterface();

}
