/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.runtime.stext;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.yakindu.sct.simulation.runtime.sgraph.ITrigger;
import org.yakindu.sct.simulation.runtime.sgraph.RTEvent;
import org.yakindu.sct.simulation.runtime.sgraph.RTGuard;
import org.yakindu.sct.simulation.runtime.sgraph.RTSignalEvent;
import org.yakindu.sct.simulation.runtime.sgraph.RTTimeEvent;

/**
 * 
 * @author terfloth
 */
public class RTTrigger  implements ITrigger{
	
	private RTGuard guard;
	private Set<RTSignalEvent> signalTriggers = new HashSet<RTSignalEvent>();
	private RTTimeEvent timeTrigger;


	public RTTrigger(RTTimeEvent timeTrigger, Set<RTSignalEvent> signalTriggers, RTGuard guard) {

		this.timeTrigger = timeTrigger;
		if (signalTriggers != null) {
			this.signalTriggers.addAll(signalTriggers);
		}
		this.guard = guard;
	}

	
	
	public boolean isEnabled(Set<RTEvent> events) {

		if ( hasTriggerEvents() ) {
			return matchesTriggerEvents(events) && matchesGuard();
		}
		
		return matchesGuard();
	}
	
	
			

	private boolean matchesTriggerEvents(Set<RTEvent> events) {
		return !Collections.disjoint(this.signalTriggers, events) || (timeTrigger != null && events.contains(timeTrigger));
			
	}		
			
	private boolean matchesGuard() {
		if (guard == null) {
			return true;
		} else {
			return guard.evaluate();
		}
	}


	private boolean hasTriggerEvents() {
		return !signalTriggers.isEmpty() || timeTrigger!=null;
	}



	
	
	public RTGuard getGuard() {
		return guard;
	}


	public RTTimeEvent getTimeTrigger() {
		return timeTrigger;
	}

	protected boolean isTimeTriggered() {
		return timeTrigger != null;
	}
	
	public Set<RTSignalEvent> getSignalTriggers() {
		return signalTriggers;
	}


	
}
