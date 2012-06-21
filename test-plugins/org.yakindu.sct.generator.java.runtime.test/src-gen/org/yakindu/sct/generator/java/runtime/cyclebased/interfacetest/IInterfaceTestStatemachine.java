package org.yakindu.sct.generator.java.runtime.cyclebased.interfacetest;

import java.util.List;
import org.yakindu.sct.generator.java.runtime.cyclebased.IStatemachine;

public interface IInterfaceTestStatemachine extends IStatemachine {

	public interface SCIDefault {

		public void raiseEvent1();
		public boolean isRaisedEvent2();

		public int getEvent2Value();

		public boolean getVar1();
		public void setVar1(boolean value);
		public double getVar2();
		public void setVar2(double value);
		public int getVar3();
		public void setVar3(int value);

		public List<SCIDefaultListener> getListeners();
	}

	public interface SCIDefaultListener {
		public void onEvent2Raised(int value);
	}

	public interface SCIOther {

		public void raiseEvent3();
		public boolean isRaisedEvent4();

		public int getV1();
		public void setV1(int value);

		public List<SCIOtherListener> getListeners();
	}

	public interface SCIOtherListener {

		public void onEvent4Raised();
	}

	public interface SCIThird {

		public void raiseEvent5();
		public boolean isRaisedEvent6();

		public boolean getEvent6Value();

		public double getV1();
		public void setV1(double value);

		public List<SCIThirdListener> getListeners();
	}

	public interface SCIThirdListener {
		public void onEvent6Raised(boolean value);
	}

	public SCIDefault getSCIDefault();

	public SCIOther getSCIOther();

	public SCIThird getSCIThird();

}
