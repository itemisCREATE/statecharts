package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.Set;


public interface ITrigger {

	boolean isEnabled(Set<RTEvent> events);

	RTTimeEvent getTimeTrigger();

}
