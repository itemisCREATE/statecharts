package org.yakindu.sct.generator.java.runtime.cyclebased.test_parallelregions;

import org.yakindu.sct.generator.java.runtime.cyclebased.IStatemachine;

public interface ITest_ParallelRegionsStatemachine extends IStatemachine {

	public interface SCIDefault {

		public void raiseEvent1();

		public void raiseEvent2();

		public void raiseEvent3();

		public void raiseEvent4();

		public void raiseEvent5();

		public void raiseEvent6();

		public void raiseEvent7();

		public void raiseEvent8();

		public void raiseEvent9();

		public void raiseEvent10();

		public void raiseEvent11();

		public void raiseEvent12();

		public void raiseEvent13();

		public void raiseEvent14();

		public int getReg3();
		public void setReg3(int value);
		public int getHierarchy();
		public void setHierarchy(int value);

	}

	public SCIDefault getSCIDefault();

}
