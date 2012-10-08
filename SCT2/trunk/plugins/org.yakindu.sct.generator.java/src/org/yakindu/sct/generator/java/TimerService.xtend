/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.java

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject

class TimerService {
	
	@Inject
	extension Naming 
	
	@Inject
	extension GenmodelEntries
	
	def generateTimerService(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		fsa.generateFile(entry.basePackagePath + '/' + timerServiceClass.java, content(entry))
	}
	
	def private content(GeneratorEntry entry) '''
		«entry.licenseText»
		package «entry.getBasePackageName()»;
		
		import java.util.HashMap;
		import java.util.Map;
		import java.util.Timer;
		import java.util.TimerTask;
		
		/**
		 * Default timer service implementation.
		 * 
		 */
		public class TimerService implements ITimerService {
		
			private final Timer timer = new Timer();
		
			private final Map<TimeEvent, TimerTask> timerTaskMap = new HashMap<TimeEvent, TimerTask>();
		
			public void setTimer(final TimeEvent event, long time,
					long cycleStartTime) {
				// Reset existing TimerTask for event. This step isn't necessary if
				// timer tasks are properly reset by sexec model.
				if (timerTaskMap.containsKey(event)) {
					resetTimer(event);
				}
		
				// Create a new TimerTask for given event.
				timerTaskMap.put(event, new TimerTask() {
					@Override
					public void run() {
						event.getStatemachine().onTimeEventRaised(event);
					}
				});
		
				// start scheduling the timer
				if (event.isPeriodic()) {
					timer.scheduleAtFixedRate(timerTaskMap.get(event),
							time - (System.currentTimeMillis() - cycleStartTime), time);
				} else {
					timer.schedule(timerTaskMap.get(event),
							time - (System.currentTimeMillis() - cycleStartTime));
				}
			}
		
			public void resetTimer(TimeEvent event) {
				if (timerTaskMap.containsKey(event) && timerTaskMap.get(event) != null) {
					timerTaskMap.get(event).cancel();
					timer.purge();
				}
				timerTaskMap.remove(event);
			}
		
			/**
			 * Cancels all running TimersTasks
			 */
			public void cancel() {
				timer.cancel();
				timer.purge();
			}
		}
	'''
}