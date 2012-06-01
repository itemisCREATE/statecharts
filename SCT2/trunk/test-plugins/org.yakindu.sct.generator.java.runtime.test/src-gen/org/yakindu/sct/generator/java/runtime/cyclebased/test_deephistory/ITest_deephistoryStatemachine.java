package org.yakindu.sct.generator.java.runtime.cyclebased.test_deephistory;

import org.yakindu.sct.generator.java.runtime.cyclebased.IStatemachine;

public interface ITest_deephistoryStatemachine extends IStatemachine {

	public interface DefaultInterface {

		public void raiseEvent1();

		public void raiseEvent2();

		public void raiseEvent3();

		public void raiseEvent4();

		public void raiseEvent5();

		public void raiseEvent6();

		public void raiseEvent7();

		public void raiseEvent8();

		public void raiseEvent9();

	}

	public DefaultInterface getDefaultInterface();

}
