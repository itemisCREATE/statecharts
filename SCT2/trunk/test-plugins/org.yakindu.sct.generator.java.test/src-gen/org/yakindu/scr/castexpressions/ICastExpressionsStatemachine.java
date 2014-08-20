package org.yakindu.scr.castexpressions;
import org.yakindu.scr.IStatemachine;

public interface ICastExpressionsStatemachine extends IStatemachine {

	public interface SCInterface {
		public double getRealValue();
		public void setRealValue(double value);
		public long getIntValue();
		public void setIntValue(long value);

	}

	public SCInterface getSCInterface();

}
