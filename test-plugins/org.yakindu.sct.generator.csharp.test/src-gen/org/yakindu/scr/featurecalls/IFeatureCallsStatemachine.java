package org.yakindu.scr.featurecalls;
import org.yakindu.scr.IStatemachine;

public interface IFeatureCallsStatemachine extends IStatemachine {
	public interface SCIMyInterface {
		public void raiseEvent1();
		public long getMyInt();
		public void setMyInt(long value);

	}

	public SCIMyInterface getSCIMyInterface();

}
