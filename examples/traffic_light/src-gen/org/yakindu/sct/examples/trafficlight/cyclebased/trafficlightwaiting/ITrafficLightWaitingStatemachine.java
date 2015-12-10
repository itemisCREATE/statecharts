/**
Copyright (c) 2012 committers of YAKINDU and others.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    committers of YAKINDU - initial API and implementation
�*/
package org.yakindu.sct.examples.trafficlight.cyclebased.trafficlightwaiting;
import org.yakindu.sct.examples.trafficlight.cyclebased.IStatemachine;
import org.yakindu.sct.examples.trafficlight.cyclebased.ITimerCallback;

public interface ITrafficLightWaitingStatemachine
		extends
			ITimerCallback,
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

	public interface SCInterface {
		public void raisePedestrianRequest();
		public void raiseOnOff();

	}

	public SCInterface getSCInterface();

}
