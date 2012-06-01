package org.yakindu.sct.examples.trafficlight.cyclebased.trafficlightwaiting;

import org.yakindu.sct.examples.trafficlight.cyclebased.IStatemachine;
import org.yakindu.sct.examples.trafficlight.cyclebased.ITimedStatemachine;

public interface ITrafficlightwaitingStatemachine
		extends
			ITimedStatemachine,
			IStatemachine {

	public interface InterfaceTrafficLight {

		public boolean getRed();
		public void setRed(boolean value);
		public boolean getYellow();
		public void setYellow(boolean value);
		public boolean getGreen();
		public void setGreen(boolean value);

	}

	public interface InterfacePedestrian {

		public boolean getRequest();
		public void setRequest(boolean value);
		public boolean getRed();
		public void setRed(boolean value);
		public boolean getGreen();
		public void setGreen(boolean value);

	}

	public interface DefaultInterface {

		public void raisePedestrianRequest();

		public void raiseOnOff();

	}

	public InterfaceTrafficLight getInterfaceTrafficLight();

	public InterfacePedestrian getInterfacePedestrian();

	public DefaultInterface getDefaultInterface();

}
