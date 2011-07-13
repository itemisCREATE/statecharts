package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class RTDefaultTimingService implements RTTimingService {

	private final AbstractStatechart statechart;

	public RTDefaultTimingService(AbstractStatechart statechart) {
		this.statechart = statechart;
	}

	private Set<RTTimeEvent> canceledRequestedEvents = new HashSet<RTTimeEvent>();

	public void requestTimeEvent(final RTTimeEvent timeEvent) {

		canceledRequestedEvents.remove(timeEvent);

		// run a timer (there is an own thread for this);
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				if (canceledRequestedEvents.contains(timeEvent)) {
					canceledRequestedEvents.remove(timeEvent);
				} else {
					statechart.setEvent(timeEvent);
				}
			}

		}, timeEvent.getDuration());

	}

	public void cancelTimeEvent(final RTTimeEvent timeEvent) {

		canceledRequestedEvents.add(timeEvent);

	}

}
