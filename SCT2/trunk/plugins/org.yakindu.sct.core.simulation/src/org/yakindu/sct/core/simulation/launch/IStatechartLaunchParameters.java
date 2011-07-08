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
package org.yakindu.sct.core.simulation.launch;

/**
 * Attribute constants for the YAKINDU Statechart launch configuration.
 * 
 * @author andreas muelder
 * 
 */
public interface IStatechartLaunchParameters {

	// Attribute keys
	String FILE_NAME = "filename";
	String YACOP_ENABLED = "yacopEnabled";
	String YACOP_PORT = "yacopPort";

	// Attribute default values
	String DEFAULT_FILE_NAME = "";
	boolean DEFAULT_YACOP_ENABLED = false;
	String DEFAULT_YACOP_PORT = "1234";

}
