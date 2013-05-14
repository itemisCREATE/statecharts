package org.yakindu.scr.featurecalls;
import org.yakindu.scr.IStatemachine;

public interface IFeatureCallsStatemachine extends IStatemachine {

	public interface SCIMyInterface {
		public void raiseEvent1();
		public int getMyInt();
		public void setMyInt(int value);

	}

	public SCIMyInterface getSCIMyInterface();

}
