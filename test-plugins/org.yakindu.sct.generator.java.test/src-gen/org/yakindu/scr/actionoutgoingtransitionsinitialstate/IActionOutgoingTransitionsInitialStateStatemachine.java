package org.yakindu.scr.actionoutgoingtransitionsinitialstate;
import org.yakindu.scr.IStatemachine;

public interface IActionOutgoingTransitionsInitialStateStatemachine extends IStatemachine {

	public interface SCInterface {
		public long getInternalB();
		public void setInternalB(long value);
		public long getC();
		public void setC(long value);
		public long getD();
		public void setD(long value);

	}

	public SCInterface getSCInterface();

}
