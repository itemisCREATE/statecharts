package org.yakindu.scr.statechartlocalreactions;
import org.yakindu.scr.IStatemachine;

public interface IStatechartLocalReactionsStatemachine extends IStatemachine {

	public interface SCInterface {
		public int getMyInt();
		public void setMyInt(int value);

	}

	public SCInterface getSCInterface();

}
