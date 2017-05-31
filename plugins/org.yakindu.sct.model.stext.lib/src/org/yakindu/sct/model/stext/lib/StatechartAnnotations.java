/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.lib;

import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StatechartAnnotations {

	public static final String CYCLE_BASED_ANNOTATION = "CycleBased";
	public static final String EVENT_DRIVEN_ANNOTATION = "EventDriven";

	public boolean isCycleBased(Statechart statechart) {
		return statechart.getAnnotationOfType(EVENT_DRIVEN_ANNOTATION) == null;
	}

	public boolean isEventDriven(Statechart statechart) {
		return statechart.getAnnotationOfType(EVENT_DRIVEN_ANNOTATION) != null;
	}
}
