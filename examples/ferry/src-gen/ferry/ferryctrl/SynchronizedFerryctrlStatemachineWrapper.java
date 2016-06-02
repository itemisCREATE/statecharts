/** Copyright (c) 2012-2015 committers of YAKINDU and others.
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html

Contributors:
    committers of YAKINDU - initial API and implementation
� */
package ferry.ferryctrl;
import ferry.ITimer;
import ferry.ITimerCallback;
import ferry.ferryctrl.FerryctrlStatemachine.State;

/**
 * Runnable wrapper of FerryctrlStatemachine. This wrapper provides a thread-safe
 * instance of the state machine.
 * 
 * Please report bugs and issues...
 */

public class SynchronizedFerryctrlStatemachineWrapper implements IFerryctrlStatemachine {
	
	/**
	 * The core state machine is simply wrapped and the event processing will be
	 * delegated to that state machine instance. This instance will be created
	 * implicitly.
	 */
	protected FerryctrlStatemachine statemachine = new FerryctrlStatemachine();
	
	/**
	 * Interface object for SCIFerry
	 */		
	protected class SynchronizedSCIFerryWrapper implements SCIFerry {
		
		public void raiseLeftBumper() {
			
			synchronized (statemachine) {
				statemachine.getSCIFerry().raiseLeftBumper();
				statemachine.runCycle();
			}
		}
		
		public void raiseRightBumper() {
			
			synchronized (statemachine) {
				statemachine.getSCIFerry().raiseRightBumper();
				statemachine.runCycle();
			}
		}
		
		public boolean getMoving() {
			synchronized(statemachine) {
				return statemachine.getSCIFerry().getMoving();
			}
		}
		
		public void setMoving(final boolean value) {
			synchronized(statemachine) {
				statemachine.getSCIFerry().setMoving(value);
			}
		}
		
		public boolean getIsLeft() {
			synchronized(statemachine) {
				return statemachine.getSCIFerry().getIsLeft();
			}
		}
		
		public void setIsLeft(final boolean value) {
			synchronized(statemachine) {
				statemachine.getSCIFerry().setIsLeft(value);
			}
		}
		
		public boolean getIsRight() {
			synchronized(statemachine) {
				return statemachine.getSCIFerry().getIsRight();
			}
		}
		
		public void setIsRight(final boolean value) {
			synchronized(statemachine) {
				statemachine.getSCIFerry().setIsRight(value);
			}
		}
		
		public boolean getFull() {
			synchronized(statemachine) {
				return statemachine.getSCIFerry().getFull();
			}
		}
		
		public void setFull(final boolean value) {
			synchronized(statemachine) {
				statemachine.getSCIFerry().setFull(value);
			}
		}
		
	};
	
	protected SCIFerry sCIFerry;
	
	/**
	 * Interface object for SCICorn
	 */		
	protected class SynchronizedSCICornWrapper implements SCICorn {
		
		public void raiseLoadleft() {
			
			synchronized (statemachine) {
				statemachine.getSCICorn().raiseLoadleft();
				statemachine.runCycle();
			}
		}
		
		public void raiseLoadright() {
			
			synchronized (statemachine) {
				statemachine.getSCICorn().raiseLoadright();
				statemachine.runCycle();
			}
		}
		
	};
	
	protected SCICorn sCICorn;
	
	/**
	 * Interface object for SCIGoose
	 */		
	protected class SynchronizedSCIGooseWrapper implements SCIGoose {
		
		public void raiseLoadleft() {
			
			synchronized (statemachine) {
				statemachine.getSCIGoose().raiseLoadleft();
				statemachine.runCycle();
			}
		}
		
		public void raiseLoadright() {
			
			synchronized (statemachine) {
				statemachine.getSCIGoose().raiseLoadright();
				statemachine.runCycle();
			}
		}
		
	};
	
	protected SCIGoose sCIGoose;
	
	/**
	 * Interface object for SCIWolf
	 */		
	protected class SynchronizedSCIWolfWrapper implements SCIWolf {
		
		public void raiseLoadleft() {
			
			synchronized (statemachine) {
				statemachine.getSCIWolf().raiseLoadleft();
				statemachine.runCycle();
			}
		}
		
		public void raiseLoadright() {
			
			synchronized (statemachine) {
				statemachine.getSCIWolf().raiseLoadright();
				statemachine.runCycle();
			}
		}
		
	};
	
	protected SCIWolf sCIWolf;
	
	/**
	 * Interface object for SCInterface
	 */		
	protected class SynchronizedSCInterfaceWrapper implements SCInterface {
		
		public void setSCInterfaceOperationCallback(SCInterfaceOperationCallback operationCallback) {
			synchronized(statemachine) {
				statemachine.getSCInterface().setSCInterfaceOperationCallback(operationCallback);
			}
		}
		
		public void raiseLeftShoreButton() {
			
			synchronized (statemachine) {
				statemachine.getSCInterface().raiseLeftShoreButton();
				statemachine.runCycle();
			}
		}
		
		public void raiseLeftFerryButton() {
			
			synchronized (statemachine) {
				statemachine.getSCInterface().raiseLeftFerryButton();
				statemachine.runCycle();
			}
		}
		
		public void raiseRightFerryButton() {
			
			synchronized (statemachine) {
				statemachine.getSCInterface().raiseRightFerryButton();
				statemachine.runCycle();
			}
		}
		
		public void raiseRightShoreButton() {
			
			synchronized (statemachine) {
				statemachine.getSCInterface().raiseRightShoreButton();
				statemachine.runCycle();
			}
		}
		
	};
	
	protected SCInterface sCInterface;
	
	public SynchronizedFerryctrlStatemachineWrapper() {
		sCIFerry = new SynchronizedSCIFerryWrapper();
		sCICorn = new SynchronizedSCICornWrapper();
		sCIGoose = new SynchronizedSCIGooseWrapper();
		sCIWolf = new SynchronizedSCIWolfWrapper();
		sCInterface = new SynchronizedSCInterfaceWrapper();
	}
	
	public synchronized SCIFerry getSCIFerry() {
		return sCIFerry;
	}
	public synchronized SCICorn getSCICorn() {
		return sCICorn;
	}
	public synchronized SCIGoose getSCIGoose() {
		return sCIGoose;
	}
	public synchronized SCIWolf getSCIWolf() {
		return sCIWolf;
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
			externalTimer.setTimer(SynchronizedFerryctrlStatemachineWrapper.this, eventID, time, isPeriodic);
		}
		
		@Override
		public void unsetTimer(ITimerCallback callback, int eventID) {
			externalTimer.unsetTimer(SynchronizedFerryctrlStatemachineWrapper.this, eventID);
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
