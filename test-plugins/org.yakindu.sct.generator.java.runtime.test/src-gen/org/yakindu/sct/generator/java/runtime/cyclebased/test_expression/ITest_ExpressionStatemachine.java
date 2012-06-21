package org.yakindu.sct.generator.java.runtime.cyclebased.test_expression;

import java.util.List;
import org.yakindu.sct.generator.java.runtime.cyclebased.IStatemachine;

public interface ITest_ExpressionStatemachine extends IStatemachine {

	public interface SCIDefault {
		public void raiseEvent1(int value);
		public boolean isRaisedEvent2();

		public double getEvent2Value();

		public void raiseEvent3();

		public int getVar1();
		public void setVar1(int value);
		public int getVar2();
		public void setVar2(int value);
		public double getVar3();
		public void setVar3(double value);
		public double getVar4();
		public void setVar4(double value);
		public boolean getVar5();
		public void setVar5(boolean value);
		public String getVar6();
		public void setVar6(String value);

		public List<SCIDefaultListener> getListeners();
	}

	public interface SCIDefaultListener {
		public void onEvent2Raised(double value);
	}

	public interface SCIOther {

		public boolean getVar1();
		public void setVar1(boolean value);
		public double getVar2();
		public void setVar2(double value);
		public int getVar3();
		public void setVar3(int value);

	}

	public SCIDefault getSCIDefault();

	public SCIOther getSCIOther();

}
