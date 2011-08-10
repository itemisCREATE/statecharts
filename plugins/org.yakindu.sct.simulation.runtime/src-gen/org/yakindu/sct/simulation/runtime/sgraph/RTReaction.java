package org.yakindu.sct.simulation.runtime.sgraph;


public class RTReaction {

	protected ITrigger trigger;
	protected RTAction action;

	public RTReaction(ITrigger trigger, RTAction action) {
		this.trigger = trigger;
		this.action = action;
	}

	public RTAction getAction() {
		return action;
	}

	public ITrigger getTrigger() {
		return trigger;
	}

}
