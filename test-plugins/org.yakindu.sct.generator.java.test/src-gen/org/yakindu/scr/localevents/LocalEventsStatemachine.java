package org.yakindu.scr.localevents;
import java.util.LinkedList;
import java.util.Queue;

public class LocalEventsStatemachine implements ILocalEventsStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
		private boolean bUTTON_ON;
		
		public void raiseBUTTON_ON() {
			bUTTON_ON = true;
			runCycle();
		}
		
		protected void clearEvents() {
			bUTTON_ON = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		localEvents_r1_A,
		localEvents_r1_C,
		localEvents_r2_idle,
		localEvents_r2_B,
		localEvents_r2_D,
		$NullState$
	};
	
	private final State[] stateVector = new State[2];
	
	private int nextStateIndex;
	
	
	private Queue<Runnable> internalEventQueue = new LinkedList<Runnable>();
	
	private boolean sTART_B;
	
	private boolean sTART_C;
	
	public LocalEventsStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
		enterSequence_localEvents_r1_default();
		enterSequence_localEvents_r2_default();
	}
	
	public void exit() {
		exitSequence_localEvents_r1();
		exitSequence_localEvents_r2();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$||stateVector[1] != State.$NullState$;
	}
	
	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return false;
	}
	/**
	* This method resets the incoming events (time events included).
	*/
	protected void clearEvents() {
		sCInterface.clearEvents();
		sTART_B = false;
		sTART_C = false;
	}
	
	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
	}
	
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case localEvents_r1_A:
			return stateVector[0] == State.localEvents_r1_A;
		case localEvents_r1_C:
			return stateVector[0] == State.localEvents_r1_C;
		case localEvents_r2_idle:
			return stateVector[1] == State.localEvents_r2_idle;
		case localEvents_r2_B:
			return stateVector[1] == State.localEvents_r2_B;
		case localEvents_r2_D:
			return stateVector[1] == State.localEvents_r2_D;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	private void raiseSTART_B() {
	
		internalEventQueue.add( new Runnable() {
			@Override public void run() {
				sTART_B = true;					
				runCycle();
			}
		});
	}
	
	
	private void raiseSTART_C() {
	
		internalEventQueue.add( new Runnable() {
			@Override public void run() {
				sTART_C = true;					
				runCycle();
			}
		});
	}
	
	
	public void raiseBUTTON_ON() {
		sCInterface.raiseBUTTON_ON();
	}
	
	private boolean check_localEvents_r1_A_lr0_lr0() {
		return sCInterface.bUTTON_ON;
	}
	
	private boolean check_localEvents_r1_A_tr0_tr0() {
		return sTART_C;
	}
	
	private boolean check_localEvents_r2_idle_tr0_tr0() {
		return sTART_B;
	}
	
	private boolean check_localEvents_r2_B_tr0_tr0() {
		return sTART_C;
	}
	
	private void effect_localEvents_r1_A_lr0_lr0() {
		raiseSTART_B();
	}
	
	private void effect_localEvents_r1_A_tr0() {
		exitSequence_localEvents_r1_A();
		enterSequence_localEvents_r1_C_default();
	}
	
	private void effect_localEvents_r2_idle_tr0() {
		exitSequence_localEvents_r2_idle();
		enterSequence_localEvents_r2_B_default();
	}
	
	private void effect_localEvents_r2_B_tr0() {
		exitSequence_localEvents_r2_B();
		enterSequence_localEvents_r2_D_default();
	}
	
	/* Entry action for state 'B'. */
	private void entryAction_localEvents_r2_B() {
		raiseSTART_C();
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_localEvents_r1_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.localEvents_r1_A;
	}
	
	/* 'default' enter sequence for state C */
	private void enterSequence_localEvents_r1_C_default() {
		nextStateIndex = 0;
		stateVector[0] = State.localEvents_r1_C;
	}
	
	/* 'default' enter sequence for state idle */
	private void enterSequence_localEvents_r2_idle_default() {
		nextStateIndex = 1;
		stateVector[1] = State.localEvents_r2_idle;
	}
	
	/* 'default' enter sequence for state B */
	private void enterSequence_localEvents_r2_B_default() {
		entryAction_localEvents_r2_B();
		nextStateIndex = 1;
		stateVector[1] = State.localEvents_r2_B;
	}
	
	/* 'default' enter sequence for state D */
	private void enterSequence_localEvents_r2_D_default() {
		nextStateIndex = 1;
		stateVector[1] = State.localEvents_r2_D;
	}
	
	/* 'default' enter sequence for region r1 */
	private void enterSequence_localEvents_r1_default() {
		react_localEvents_r1__entry_Default();
	}
	
	/* 'default' enter sequence for region r2 */
	private void enterSequence_localEvents_r2_default() {
		react_localEvents_r2__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_localEvents_r1_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state C */
	private void exitSequence_localEvents_r1_C() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state idle */
	private void exitSequence_localEvents_r2_idle() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state B */
	private void exitSequence_localEvents_r2_B() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state D */
	private void exitSequence_localEvents_r2_D() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for region r1 */
	private void exitSequence_localEvents_r1() {
		switch (stateVector[0]) {
		case localEvents_r1_A:
			exitSequence_localEvents_r1_A();
			break;
		case localEvents_r1_C:
			exitSequence_localEvents_r1_C();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r2 */
	private void exitSequence_localEvents_r2() {
		switch (stateVector[1]) {
		case localEvents_r2_idle:
			exitSequence_localEvents_r2_idle();
			break;
		case localEvents_r2_B:
			exitSequence_localEvents_r2_B();
			break;
		case localEvents_r2_D:
			exitSequence_localEvents_r2_D();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state A. */
	private void react_localEvents_r1_A() {
		if (check_localEvents_r1_A_tr0_tr0()) {
			effect_localEvents_r1_A_tr0();
		} else {
			if (check_localEvents_r1_A_lr0_lr0()) {
				effect_localEvents_r1_A_lr0_lr0();
			}
		}
	}
	
	/* The reactions of state C. */
	private void react_localEvents_r1_C() {
	}
	
	/* The reactions of state idle. */
	private void react_localEvents_r2_idle() {
		if (check_localEvents_r2_idle_tr0_tr0()) {
			effect_localEvents_r2_idle_tr0();
		}
	}
	
	/* The reactions of state B. */
	private void react_localEvents_r2_B() {
		if (check_localEvents_r2_B_tr0_tr0()) {
			effect_localEvents_r2_B_tr0();
		}
	}
	
	/* The reactions of state D. */
	private void react_localEvents_r2_D() {
	}
	
	/* Default react sequence for initial entry  */
	private void react_localEvents_r1__entry_Default() {
		enterSequence_localEvents_r1_A_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_localEvents_r2__entry_Default() {
		enterSequence_localEvents_r2_idle_default();
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
	
		clearOutEvents();
		singleCycle();
		clearEvents();
		
		// process queued events
		while (internalEventQueue.size() > 0) {
			internalEventQueue.poll().run();
			singleCycle();
			clearEvents();
		}
	}
	
	protected void singleCycle() {
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case localEvents_r1_A:
				react_localEvents_r1_A();
				break;
			case localEvents_r1_C:
				react_localEvents_r1_C();
				break;
			case localEvents_r2_idle:
				react_localEvents_r2_idle();
				break;
			case localEvents_r2_B:
				react_localEvents_r2_B();
				break;
			case localEvents_r2_D:
				react_localEvents_r2_D();
				break;
			default:
				// $NullState$
			}
		}
	}
}
