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
		public long getX();
		public void setX(long value);
		public long getA();
		public void setA(long value);
		public long getC();
		public void setC(long value);

	}

	public SCInterface getSCInterface();

}
