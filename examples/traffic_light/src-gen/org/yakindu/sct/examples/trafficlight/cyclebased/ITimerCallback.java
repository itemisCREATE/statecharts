/**
Copyright (c) 2012 committers of YAKINDU and others.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    committers of YAKINDU - initial API and implementation
�*/
package org.yakindu.sct.examples.trafficlight.cyclebased;

/**
* Interface for state machines which use timed event triggers.
*/
public interface ITimerCallback {
	
	/**
	* Callback method if a time event occurred.
	* 
	* @param eventID
	* 			:The id of the occurred event.
	*/
	public void timeElapsed(int eventID);
}
