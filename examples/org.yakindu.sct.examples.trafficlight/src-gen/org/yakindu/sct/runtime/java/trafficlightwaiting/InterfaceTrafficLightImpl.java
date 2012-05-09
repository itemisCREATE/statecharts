package org.yakindu.sct.runtime.java.trafficlightwaiting;

public class InterfaceTrafficLightImpl implements IInterfaceTrafficLightImpl {

	public InterfaceTrafficLightImpl() {
	}

	private boolean varRed;
	public boolean getVarRed() {
		return varRed;
	}

	public void setVarRed(boolean value) {
		varRed = value;
	}
	private boolean varYellow;
	public boolean getVarYellow() {
		return varYellow;
	}

	public void setVarYellow(boolean value) {
		varYellow = value;
	}
	private boolean varGreen;
	public boolean getVarGreen() {
		return varGreen;
	}

	public void setVarGreen(boolean value) {
		varGreen = value;
	}

}
