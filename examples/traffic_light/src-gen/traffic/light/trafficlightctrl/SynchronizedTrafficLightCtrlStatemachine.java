/** Copyright (c) 2012-2015 committers of YAKINDU and others.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    committers of YAKINDU - initial API and implementation
� */
package traffic.light.trafficlightctrl;
import traffic.light.ITimer;
import traffic.light.ITimerCallback;
import traffic.light.trafficlightctrl.TrafficLightCtrlStatemachine.State;

/**
 * Runnable wrapper of TrafficLightCtrlStatemachine. This wrapper provides a thread-safe
 * instance of the state machine.
 * 
 * Please report bugs and issues...
 */

public class SynchronizedTrafficLightCtrlStatemachine implements ITrafficLightCtrlStatemachine {
	
	/**
	 * The core state machine is simply wrapped and the event processing will be
	 * delegated to that state machine instance. This instance will be created
	 * implicitly.
	 */
	protected TrafficLightCtrlStatemachine statemachine = new TrafficLightCtrlStatemachine();
	
	/**
	 * Interface object for SCITrafficLight
	 */		
	protected class SynchronizedSCITrafficLight implements SCITrafficLight {
		
		public boolean getRed() {
			synchronized(statemachine) {
				return statemachine.getSCITrafficLight().getRed();
			}
		}
		
		public void setRed(final boolean value) {
			synchronized(statemachine) {
				statemachine.getSCITrafficLight().setRed(value);
			}
		}
		
		public boolean getYellow() {
			synchronized(statemachine) {
				return statemachine.getSCITrafficLight().getYellow();
			}
		}
		
		public void setYellow(final boolean value) {
			synchronized(statemachine) {
				statemachine.getSCITrafficLight().setYellow(value);
			}
		}
		
		public boolean getGreen() {
			synchronized(statemachine) {
				return statemachine.getSCITrafficLight().getGreen();
			}
		}
		
		public void setGreen(final boolean value) {
			synchronized(statemachine) {
				statemachine.getSCITrafficLight().setGreen(value);
			}
		}
		
	};
	
	protected SCITrafficLight sCITrafficLight;
	
	/**
	 * Interface object for SCIPedestrian
	 */		
	protected class SynchronizedSCIPedestrian implements SCIPedestrian {
		
		public boolean getRequest() {
			synchronized(statemachine) {
				return statemachine.getSCIPedestrian().getRequest();
			}
		}
		
		public void setRequest(final boolean value) {
			synchronized(statemachine) {
				statemachine.getSCIPedestrian().setRequest(value);
			}
		}
		
		public boolean getRed() {
			synchronized(statemachine) {
				return statemachine.getSCIPedestrian().getRed();
			}
		}
		
		public void setRed(final boolean value) {
			synchronized(statemachine) {
				statemachine.getSCIPedestrian().setRed(value);
			}
		}
		
		public boolean getGreen() {
			synchronized(statemachine) {
				return statemachine.getSCIPedestrian().getGreen();
			}
		}
		
		public void setGreen(final boolean value) {
			synchronized(statemachine) {
				statemachine.getSCIPedestrian().setGreen(value);
			}
		}
		
	};
	
	protected SCIPedestrian sCIPedestrian;
	
	/**
	 * Interface object for SCInterface
	 */		
	protected class SynchronizedSCInterface implements SCInterface {
		
		public void setSCInterfaceOperationCallback(SCInterfaceOperationCallback operationCallback) {
			synchronized(statemachine) {
				statemachine.getSCInterface().setSCInterfaceOperationCallback(operationCallback);
			}
		}
		
		public void raisePedestrianRequest() {
			
			synchronized (statemachine) {
				statemachine.getSCInterface().raisePedestrianRequest();
				statemachine.runCycle();
			}
		}
		
		public void raiseOnOff() {
			
			synchronized (statemachine) {
				statemachine.getSCInterface().raiseOnOff();
				statemachine.runCycle();
			}
		}
		
	};
	
	protected SCInterface sCInterface;
	
	public SynchronizedTrafficLightCtrlStatemachine() {
		sCITrafficLight = new SynchronizedSCITrafficLight();
		sCIPedestrian = new SynchronizedSCIPedestrian();
		sCInterface = new SynchronizedSCInterface();
	}
	
	public synchronized SCITrafficLight getSCITrafficLight() {
		return sCITrafficLight;
	}
	public synchronized SCIPedestrian getSCIPedestrian() {
		return sCIPedestrian;
	}
	public synchronized SCInterface getSCInterface() {
		return sCInterface;
	}
	/*================ TIME EVENT HANDLING ================
	
	/** An external timer instance is required. */
	protected ITimer externalTimer;
	
	/** Internally we use a timer proxy that queues time events together with other input events. */
	protected ITimer timerProxy = new ITimer() {
		/** Simply delegate to external timer with a modified callback. */
		@Override
		public void setTimer(ITimerCallback callback, int eventID, long time,
				boolean isPeriodic) {
			externalTimer.setTimer(SynchronizedTrafficLightCtrlStatemachine.this, eventID, time, isPeriodic);
		}
		
		@Override
		public void unsetTimer(ITimerCallback callback, int eventID) {
			externalTimer.unsetTimer(SynchronizedTrafficLightCtrlStatemachine.this, eventID);
		}
	};
	
	/**
	 * Set the {@link ITimer} for the state machine. It must be set externally
	 * on a timed state machine before a run cycle can be correct executed.
	 * 
	 * @param timer
	 */
	public void setTimer(ITimer timer) {
		synchronized(statemachine) {
			this.externalTimer = timer;
			/* the wrapped state machine uses timer proxy as timer */
			statemachine.setTimer(timerProxy);
		}
	}
	
	/**
	* Returns the currently used timer.
	* 
	* @return {@link ITimer}
	*/
	public ITimer getTimer() {
		return externalTimer;
	}
	
	public void timeElapsed(int eventID) {
		synchronized (statemachine) {
			statemachine.timeElapsed(eventID);
		}
	}
	
	/**
	 * init() will be delegated thread-safely to the wrapped state machine.
	 */
	public void init() {
		synchronized(statemachine) {
			statemachine.init();
		}
	}
	
	/**
	 * enter() will be delegated thread-safely to the wrapped state machine.
	 */
	public void enter() {
		synchronized(statemachine) {
			statemachine.enter();
		}
	}
	
	/**
	 * exit() will be delegated thread-safely to the wrapped state machine.
	 */
	public void exit() {
		synchronized(statemachine) {
			statemachine.exit();
		}
	}
	
	/**
	 * isActive() will be delegated thread-safely to the wrapped state machine.
	 */
	public boolean isActive() {
		synchronized(statemachine) {
			return statemachine.isActive();
		}
	}
	
	/**
	 * isFinal() will be delegated thread-safely to the wrapped state machine.
	 */
	public boolean isFinal() {
		synchronized(statemachine) {
			return statemachine.isFinal();
		}
	}
	
	/**
	 * isStateActive() will be delegated thread-safely to the wrapped state machine.
	 */
	public boolean isStateActive(State state) {
		synchronized(statemachine) {
			return statemachine.isStateActive(state);
		}
	}
	
	/**
	 * runCycle() will be delegated thread-safely to the wrapped state machine.
	 */ 
	@Override
	public void runCycle() {
		synchronized (statemachine) {
			statemachine.runCycle();
		}
	}
}
