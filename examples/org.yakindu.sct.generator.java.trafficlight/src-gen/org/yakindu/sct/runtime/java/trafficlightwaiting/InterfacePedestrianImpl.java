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

public class InterfacePedestrianImpl implements InterfacePedestrian {

	private boolean varRequest;

	public boolean getVarRequest() {
		return varRequest;
	}

	public void setVarRequest(boolean value) {
		varRequest = value;
	}
	private boolean varRed;

	public boolean getVarRed() {
		return varRed;
	}

	public void setVarRed(boolean value) {
		varRed = value;
	}
	private boolean varGreen;

	public boolean getVarGreen() {
		return varGreen;
	}

	public void setVarGreen(boolean value) {
		varGreen = value;
	}
}
