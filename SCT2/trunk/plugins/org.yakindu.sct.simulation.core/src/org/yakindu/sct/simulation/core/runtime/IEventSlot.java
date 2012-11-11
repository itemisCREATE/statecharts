/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.simulation.core.runtime;

/**
 * Defines the interface of an event slot.
 * EventSlot are extensions of Slot that adds notion of raising and unraising (resetting) events.
 *  
 * @author axel terfloth
 */
public interface IEventSlot extends ISlot {
	
	
	public static class SlotEventRaised implements ISlotChangedEvent {}
	public static class SlotEventUnraised implements ISlotChangedEvent {}

	public static final SlotEventRaised SLOT_EVENT_RAISED = new SlotEventRaised();
	public static final SlotEventUnraised SLOT_EVENT_UNRAISED = new SlotEventUnraised();

	
	void raise(Object value);
	void unraise();
	boolean isRaised();

}
