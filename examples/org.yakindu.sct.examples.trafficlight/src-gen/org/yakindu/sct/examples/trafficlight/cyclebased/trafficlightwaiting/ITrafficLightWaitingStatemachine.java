package org.yakindu.sct.examples.trafficlight.cyclebased.trafficlightwaiting;
import org.yakindu.sct.examples.trafficlight.cyclebased.IStatemachine;
import org.yakindu.sct.examples.trafficlight.cyclebased.ITimedStatemachine;

public interface ITrafficLightWaitingStatemachine
		extends
			ITimedStatemachine,
			IStatemachine {

	public interface SCITrafficLight {
		public boolean getRed();
		public void setRed(boolean value);
		public boolean getYellow();
		public void setYellow(boolean value);
		public boolean getGreen();
		public void setGreen(boolean value);

	}

	public SCITrafficLight getSCITrafficLight();

	public interface SCIPedestrian {
		public boolean getRequest();
		public void setRequest(boolean value);
		public boolean getRed();
		public void setRed(boolean value);
		public boolean getGreen();
		public void setGreen(boolean value);

	}

	public SCIPedestrian getSCIPedestrian();

	public interface SCIDefault {
		public void raisePedestrianRequest();
		public void raiseOnOff();

	}

	public SCIDefault getSCIDefault();

}
