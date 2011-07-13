package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class DefaultTimingService implements TimingService {

	private final AbstractStatechart statechart;

	public DefaultTimingService(AbstractStatechart statechart) {
		this.statechart = statechart;
	}

	private Set<TimeEvent> canceledRequestedEvents = new HashSet<TimeEvent>();

	public void requestTimeEvent(final TimeEvent timeEvent) {

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

	public void cancelTimeEvent(final TimeEvent timeEvent) {

		canceledRequestedEvents.add(timeEvent);

	}

}
