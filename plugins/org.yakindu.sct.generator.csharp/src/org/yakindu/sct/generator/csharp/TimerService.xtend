/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.csharp

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
		fsa.generateFile(entry.basePackagePath + '/' + timerServiceClass.csharp, content(entry))
	}
	
	def private content(GeneratorEntry entry) '''
		«entry.licenseText»
		
		using System;
		using System.Collections.Generic;
		using System.Timers;
		using «entry.getNamespaceName()»;
		
		/**
		 * Default timer service implementation.
		 * 
		 */
		namespace «entry.getNamespaceName()»
		{
			public class TimerService : ITimer {
			
				private readonly List<TimeEventTask> timerTaskList = new List<TimeEventTask>();
				
				/**
				 * Timer task that reflects a time event. It's internally used by
				 * {@link TimerService}.
				 * 
				 */
				private class TimeEventTask : Timer {
				
					private ITimerCallback callback;
				
					int eventID;
				
					/**
					 * Constructor for a time event.
					 * 
					 * @param callback
					 *            : Set to {@code true} if event should be repeated
					 *            periodically.
					 * 
					 * @param eventID
					 *            : Index position within the state machine's timeEvent
					 *            array.
					 */
					public TimeEventTask(ITimerCallback callback, int eventID) {
						// Add to base classes Elapsed event
						this.Elapsed += (sender, e) => {
						    	callback.timeElapsed(eventID);
							};  
						this.callback = callback;
						this.eventID = eventID;
					}
				
					public void Run() {
						callback.timeElapsed(eventID);
					}
				
					public override bool Equals(Object obj) {
						if (obj is TimeEventTask) {
							return ((TimeEventTask) obj).callback.Equals(callback)
									&& ((TimeEventTask) obj).eventID == eventID;
						}
						return base.Equals(obj);
					}
					
					public void Cancel() {
						this.Stop();
					}
				}
				
				public void setTimer(ITimerCallback callback, int eventID,
						long time, bool isPeriodic) {
				
					// Create a new TimerTask for given event and store it.
					TimeEventTask timerTask = new TimeEventTask(callback, eventID);
					timerTaskList.Add(timerTask);
				
					// start scheduling the timer
					if (isPeriodic) {
						timerTask.Interval = time;
						timerTask.AutoReset = true;
					} else {
						timerTask.Interval = time;
						timerTask.AutoReset = false;
					}
					
					timerTask.Start();
				}
				
				public void unsetTimer(ITimerCallback callback, int eventID) {
					int index = timerTaskList.FindIndex( x => x.Equals(new TimeEventTask(callback, eventID)) );
					if (index != -1) {
						timerTaskList[index].Cancel();
						timerTaskList.RemoveAt(index);
					}
				}
				
				/**
				 * Cancel timer service. Use this to end possible timing threads and free
				 * memory resources.
				 */
				public void cancel() {
					foreach( TimeEventTask tet in timerTaskList )
					{
						tet.Cancel();
					}
				}
			}
		}

	'''
}