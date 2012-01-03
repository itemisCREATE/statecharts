/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.trafficlightwaiting;

public class InterfaceTrafficLightImpl implements InterfaceTrafficLight {

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
