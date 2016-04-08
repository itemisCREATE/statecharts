package org.yakindu.scr.conditionalexpressions;
import org.yakindu.scr.IStatemachine;

public interface IConditionalExpressionsStatemachine extends IStatemachine {
	public interface SCInterface {
		public void raiseE();
		public long getCondition();
		public void setCondition(long value);
		public boolean getBoolVar();
		public void setBoolVar(boolean value);

	}

	public SCInterface getSCInterface();

}
