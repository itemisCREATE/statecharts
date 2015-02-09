package org.yakindu.scr.triggerguardexpressions;
import org.yakindu.scr.IStatemachine;

public interface ITriggerGuardExpressionsStatemachine extends IStatemachine {

	public interface SCInterface {
		public void raiseE1();
		public void raiseE2();
		public boolean getB();
		public void setB(boolean value);

	}

	public SCInterface getSCInterface();

}
