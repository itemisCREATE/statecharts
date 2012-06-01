package org.yakindu.sct.generator.java.runtime.cyclebased.test_localactions;

import org.yakindu.sct.generator.java.runtime.cyclebased.IStatemachine;
import org.yakindu.sct.generator.java.runtime.cyclebased.ITimedStatemachine;

public interface ITest_localactionsStatemachine
		extends
			ITimedStatemachine,
			IStatemachine {

	public interface DefaultInterface {

		public void raiseEvent1();

		public void raiseEvent2();

		public void raiseEvent3();

		public void raiseEvent4();

		public int getI();
		public void setI(int value);
		public int getJ();
		public void setJ(int value);
		public int getC();
		public void setC(int value);

	}

	public DefaultInterface getDefaultInterface();

}
