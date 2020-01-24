/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 *
 */
package org.yakindu.sct.generator.c;

/**
 * @author rbeckmann
 * @author axel terfloth
 *
 */
public abstract class CGeneratorConstants {
	
	/*
	 * TYPES
	 */
	public static final String BOOL_TYPE = "sc_boolean";
	public static final String STRING_TYPE = "sc_string";
	public static final String INT_TYPE = "sc_integer";
	public static final String UINT_TYPE = "sc_uinteger";
	public static final String SHORT_TYPE = "sc_short";
	public static final String USHORT_TYPE = "sc_ushort";
	public static final String REAL_TYPE = "sc_real";
	public static final String EVENT_TYPE = "sc_eventid";
	public static final String INTPTR_TYPE = "sc_intptr_t";
	

	public static final String TYPES_MODULE = "sc_types";
	public static final String TRACING_MODULE = "sc_tracing";

	/*
	 * FUNCTIONS
	 */
	public static final String CLEAR_IN_EVENTS = "clearInEvents";
	public static final String CLEAR_OUT_EVENTS = "clearOutEvents";
	public static final String RAISE_TIME_EVENT = "raiseTimeEvent";
	public static final String IS_STATE_ACTIVE = "isStateActive";
	public static final String IS_ACTIVE = "isActive";
	public static final String IS_FINAL = "isFinal";
	public static final String INIT = "init";
	public static final String ENTER = "enter";
	public static final String EXIT = "exit";
	public static final String RUN_CYCLE = "runCycle";
	public static final String SET_TIMER = "setTimer";
	public static final String UNSET_TIMER = "unsetTimer";
	public static final String STATE_ENTERED = "stateEntered";
	public static final String STATE_EXITED = "stateExited";

	/*
	 * VARIABLES
	 */
	public static final String STATEVECTOR = "stateConfVector";
	public static final String STATEVECTOR_POS = "stateConfVectorPosition";
	public static final String STATEVECTOR_CHANGED = "stateConfVectorChanged";
	public static final String HISTORYVECTOR = "historyVector";
	public static final String HANDLE = "handle";

	/*
	 * MISC
	 */
	public static final int EVENT_QUEUE_BUFFER_SIZE = 20;
}
