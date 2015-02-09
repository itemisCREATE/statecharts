package org.yakindu.scr.statechartlocalreactions;
import org.yakindu.scr.IStatemachine;

public interface IStatechartLocalReactionsStatemachine extends IStatemachine {

	public interface SCInterface {
		public long getMyInt();
		public void setMyInt(long value);

	}

	public SCInterface getSCInterface();

}
