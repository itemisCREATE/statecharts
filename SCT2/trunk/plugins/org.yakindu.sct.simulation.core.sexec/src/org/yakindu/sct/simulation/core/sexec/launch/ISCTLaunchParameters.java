/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sexec.launch;

/**
 * Attribute constants for the YAKINDU Statechart launch configuration.
 * 
 * @author andreas muelder
 * 
 */
public interface ISCTLaunchParameters {

	String FILE_NAME = "filename";
	String DEFAULT_FILE_NAME = "";

	String CYCLE_PERIOD = "cyclePeriod";
	int DEFAULT_CYCLE_PERIOD = 200;

	String IS_CYCLE_BASED = "cycleBased";
	boolean DEFAULT_IS_CYCLE_BASED = true;

	String IS_EVENT_DRIVEN = "eventDriven";
	boolean DEFAULT_IS_EVENT_DRIVEN = false;
	
	String OPERATION_CLASS = "operationClass";
	String DEFAULT_OPERATION_CLASS = "";
	
	String EXECUTION_CONTEXT = "executionContext";

}
