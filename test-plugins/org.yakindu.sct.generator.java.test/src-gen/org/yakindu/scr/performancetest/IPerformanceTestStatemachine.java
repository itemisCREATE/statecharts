package org.yakindu.scr.performancetest;
import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface IPerformanceTestStatemachine
		extends
			ITimerCallback,
			IStatemachine {

	public interface SCInterface {
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

	public SCInterface getSCInterface();

}
