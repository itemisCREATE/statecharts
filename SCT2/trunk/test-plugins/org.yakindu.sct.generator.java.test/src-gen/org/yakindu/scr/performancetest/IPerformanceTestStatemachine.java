package org.yakindu.scr.performancetest;
import org.yakindu.scr.IStatemachine;

public interface IPerformanceTestStatemachine extends IStatemachine {

	public interface SCIDefault {
		public void raiseE1();
		public void raiseE2();
		public void raiseE3();
		public int getX();
		public void setX(int value);
		public int getA();
		public void setA(int value);
		public int getC();
		public void setC(int value);

	}

	public SCIDefault getSCIDefault();

}
