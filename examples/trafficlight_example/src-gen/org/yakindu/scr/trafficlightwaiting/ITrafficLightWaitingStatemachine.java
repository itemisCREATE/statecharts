package org.yakindu.scr.trafficlightwaiting;
import org.yakindu.scr.IStatemachine;
import org.yakindu.scr.ITimerCallback;

public interface ITrafficLightWaitingStatemachine extends ITimerCallback, IStatemachine {
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

	public interface SCInterface {
		public void raisePedestrianRequest();
		public void raiseOnOff();

	}

	public SCInterface getSCInterface();

}
