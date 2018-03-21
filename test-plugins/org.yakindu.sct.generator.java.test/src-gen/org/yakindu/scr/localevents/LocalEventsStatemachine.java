package org.yakindu.scr.localevents;
import java.util.LinkedList;
import java.util.Queue;

public class LocalEventsStatemachine implements ILocalEventsStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
		private boolean e;
		
		public void raiseE() {
			e = true;
			runCycle();
		}
		
		private long cycleCountSm;
		
		public long getCycleCountSm() {
			return cycleCountSm;
		}
		
		public void setCycleCountSm(long value) {
			this.cycleCountSm = value;
		}
		
		private long cycleCount1;
		
		public long getCycleCount1() {
			return cycleCount1;
		}
		
		public void setCycleCount1(long value) {
			this.cycleCount1 = value;
		}
		
		private long cycleCount2;
		
		public long getCycleCount2() {
			return cycleCount2;
		}
		
		public void setCycleCount2(long value) {
			this.cycleCount2 = value;
		}
		
		private long checksum;
		
		public long getChecksum() {
			return checksum;
		}
		
		public void setChecksum(long value) {
			this.checksum = value;
		}
		
		protected void clearEvents() {
			e = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		localEvents_r1_Comp1,
		localEvents_r1_Comp1_r_A1,
		localEvents_r1_Comp1_r_C1,
		localEvents_r1_Comp1_r_D1,
		localEvents_r2_Comp2,
		localEvents_r2_Comp2_r_A2,
		localEvents_r2_Comp2_r_B2,
		localEvents_r2_Comp2_r_C2,
		localEvents_r2_Comp2_r_D2,
		$NullState$
	};
	
	private final State[] stateVector = new State[2];
	
	private int nextStateIndex;
	
	private Queue<Runnable> internalEventQueue = new LinkedList<Runnable>();
	
	private boolean activate_b;
	
	private boolean activate_c;
	
	private boolean activate_d;
	private long activate_dValue;
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
		sCInterface.setCycleCountSm(0);
		
		sCInterface.setCycleCount1(0);
		
		sCInterface.setCycleCount2(0);
		
		sCInterface.setChecksum(0);
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
		activate_b = false;
		activate_c = false;
		activate_d = false;
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
		case localEvents_r1_Comp1:
			return stateVector[0].ordinal() >= State.
					localEvents_r1_Comp1.ordinal()&& stateVector[0].ordinal() <= State.localEvents_r1_Comp1_r_D1.ordinal();
		case localEvents_r1_Comp1_r_A1:
			return stateVector[0] == State.localEvents_r1_Comp1_r_A1;
		case localEvents_r1_Comp1_r_C1:
			return stateVector[0] == State.localEvents_r1_Comp1_r_C1;
		case localEvents_r1_Comp1_r_D1:
			return stateVector[0] == State.localEvents_r1_Comp1_r_D1;
		case localEvents_r2_Comp2:
			return stateVector[1].ordinal() >= State.
					localEvents_r2_Comp2.ordinal()&& stateVector[1].ordinal() <= State.localEvents_r2_Comp2_r_D2.ordinal();
		case localEvents_r2_Comp2_r_A2:
			return stateVector[1] == State.localEvents_r2_Comp2_r_A2;
		case localEvents_r2_Comp2_r_B2:
			return stateVector[1] == State.localEvents_r2_Comp2_r_B2;
		case localEvents_r2_Comp2_r_C2:
			return stateVector[1] == State.localEvents_r2_Comp2_r_C2;
		case localEvents_r2_Comp2_r_D2:
			return stateVector[1] == State.localEvents_r2_Comp2_r_D2;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	private void raiseActivate_b() {
	
		internalEventQueue.add( new Runnable() {
			@Override public void run() {
				activate_b = true;					
				runCycle();
			}
		});
	}
	
	
	private void raiseActivate_c() {
	
		internalEventQueue.add( new Runnable() {
			@Override public void run() {
				activate_c = true;					
				runCycle();
			}
		});
	}
	
	
	private void raiseActivate_d(final long value) {
	
		internalEventQueue.add( new Runnable() {
			@Override public void run() {
				activate_dValue = value;
				activate_d = true;					
				runCycle();
			}
		});
	}
	
	private long getActivate_dValue() {
		if (! activate_d ) 
			throw new IllegalStateException("Illegal event value access. Event Activate_d is not raised!");
		return activate_dValue;
	}
	
	public void raiseE() {
		sCInterface.raiseE();
	}
	
	public long getCycleCountSm() {
		return sCInterface.getCycleCountSm();
	}
	
	public void setCycleCountSm(long value) {
		sCInterface.setCycleCountSm(value);
	}
	
	public long getCycleCount1() {
		return sCInterface.getCycleCount1();
	}
	
	public void setCycleCount1(long value) {
		sCInterface.setCycleCount1(value);
	}
	
	public long getCycleCount2() {
		return sCInterface.getCycleCount2();
	}
	
	public void setCycleCount2(long value) {
		sCInterface.setCycleCount2(value);
	}
	
	public long getChecksum() {
		return sCInterface.getChecksum();
	}
	
	public void setChecksum(long value) {
		sCInterface.setChecksum(value);
	}
	
	private boolean check__lr0() {
		return activate_c;
	}
	
	private boolean check__lr1() {
		return activate_d;
	}
	
	private boolean check__lr2() {
		return true;
	}
	
	private boolean check_localEvents_r1_Comp1_lr0_lr0() {
		return true;
	}
	
	private boolean check_localEvents_r1_Comp1_r_A1_lr0_lr0() {
		return sCInterface.e;
	}
	
	private boolean check_localEvents_r1_Comp1_r_A1_tr0_tr0() {
		return activate_c;
	}
	
	private boolean check_localEvents_r1_Comp1_r_C1_tr0_tr0() {
		return (activate_d) && (getActivate_dValue()==1);
	}
	
	private boolean check_localEvents_r2_Comp2_lr0_lr0() {
		return true;
	}
	
	private boolean check_localEvents_r2_Comp2_r_A2_tr0_tr0() {
		return activate_b;
	}
	
	private boolean check_localEvents_r2_Comp2_r_B2_tr0_tr0() {
		return activate_c;
	}
	
	private boolean check_localEvents_r2_Comp2_r_C2_tr0_tr0() {
		return (activate_d) && (getActivate_dValue()==2);
	}
	
	private void effect__lr0() {
		raiseActivate_d(1);
	}
	
	private void effect__lr1() {
		sCInterface.setChecksum(sCInterface.getChecksum() + (getActivate_dValue()));
	}
	
	private void effect__lr2() {
		sCInterface.setCycleCountSm(sCInterface.getCycleCountSm() + 1);
	}
	
	private void effect_localEvents_r1_Comp1_lr0_lr0() {
		sCInterface.setCycleCount1(sCInterface.getCycleCount1() + 1);
	}
	
	private void effect_localEvents_r1_Comp1_r_A1_lr0_lr0() {
		raiseActivate_b();
	}
	
	private void effect_localEvents_r1_Comp1_r_A1_tr0() {
		exitSequence_localEvents_r1_Comp1_r_A1();
		enterSequence_localEvents_r1_Comp1_r_C1_default();
	}
	
	private void effect_localEvents_r1_Comp1_r_C1_tr0() {
		exitSequence_localEvents_r1_Comp1_r_C1();
		raiseActivate_d(2);
		
		enterSequence_localEvents_r1_Comp1_r_D1_default();
	}
	
	private void effect_localEvents_r2_Comp2_lr0_lr0() {
		sCInterface.setCycleCount2(sCInterface.getCycleCount2() + 1);
	}
	
	private void effect_localEvents_r2_Comp2_r_A2_tr0() {
		exitSequence_localEvents_r2_Comp2_r_A2();
		enterSequence_localEvents_r2_Comp2_r_B2_default();
	}
	
	private void effect_localEvents_r2_Comp2_r_B2_tr0() {
		exitSequence_localEvents_r2_Comp2_r_B2();
		enterSequence_localEvents_r2_Comp2_r_C2_default();
	}
	
	private void effect_localEvents_r2_Comp2_r_C2_tr0() {
		exitSequence_localEvents_r2_Comp2_r_C2();
		enterSequence_localEvents_r2_Comp2_r_D2_default();
	}
	
	/* Entry action for state 'B2'. */
	private void entryAction_localEvents_r2_Comp2_r_B2() {
		raiseActivate_c();
	}
	
	/* 'default' enter sequence for state A1 */
	private void enterSequence_localEvents_r1_Comp1_r_A1_default() {
		nextStateIndex = 0;
		stateVector[0] = State.localEvents_r1_Comp1_r_A1;
	}
	
	/* 'default' enter sequence for state C1 */
	private void enterSequence_localEvents_r1_Comp1_r_C1_default() {
		nextStateIndex = 0;
		stateVector[0] = State.localEvents_r1_Comp1_r_C1;
	}
	
	/* 'default' enter sequence for state D1 */
	private void enterSequence_localEvents_r1_Comp1_r_D1_default() {
		nextStateIndex = 0;
		stateVector[0] = State.localEvents_r1_Comp1_r_D1;
	}
	
	/* 'default' enter sequence for state A2 */
	private void enterSequence_localEvents_r2_Comp2_r_A2_default() {
		nextStateIndex = 1;
		stateVector[1] = State.localEvents_r2_Comp2_r_A2;
	}
	
	/* 'default' enter sequence for state B2 */
	private void enterSequence_localEvents_r2_Comp2_r_B2_default() {
		entryAction_localEvents_r2_Comp2_r_B2();
		nextStateIndex = 1;
		stateVector[1] = State.localEvents_r2_Comp2_r_B2;
	}
	
	/* 'default' enter sequence for state C2 */
	private void enterSequence_localEvents_r2_Comp2_r_C2_default() {
		nextStateIndex = 1;
		stateVector[1] = State.localEvents_r2_Comp2_r_C2;
	}
	
	/* 'default' enter sequence for state D2 */
	private void enterSequence_localEvents_r2_Comp2_r_D2_default() {
		nextStateIndex = 1;
		stateVector[1] = State.localEvents_r2_Comp2_r_D2;
	}
	
	/* 'default' enter sequence for region r1 */
	private void enterSequence_localEvents_r1_default() {
		react_localEvents_r1__entry_Default();
	}
	
	/* 'default' enter sequence for region r2 */
	private void enterSequence_localEvents_r2_default() {
		react_localEvents_r2__entry_Default();
	}
	
	/* Default exit sequence for state A1 */
	private void exitSequence_localEvents_r1_Comp1_r_A1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state C1 */
	private void exitSequence_localEvents_r1_Comp1_r_C1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state D1 */
	private void exitSequence_localEvents_r1_Comp1_r_D1() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state A2 */
	private void exitSequence_localEvents_r2_Comp2_r_A2() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state B2 */
	private void exitSequence_localEvents_r2_Comp2_r_B2() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state C2 */
	private void exitSequence_localEvents_r2_Comp2_r_C2() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state D2 */
	private void exitSequence_localEvents_r2_Comp2_r_D2() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for region r1 */
	private void exitSequence_localEvents_r1() {
		switch (stateVector[0]) {
		case localEvents_r1_Comp1_r_A1:
			exitSequence_localEvents_r1_Comp1_r_A1();
			break;
		case localEvents_r1_Comp1_r_C1:
			exitSequence_localEvents_r1_Comp1_r_C1();
			break;
		case localEvents_r1_Comp1_r_D1:
			exitSequence_localEvents_r1_Comp1_r_D1();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r */
	private void exitSequence_localEvents_r1_Comp1_r() {
		switch (stateVector[0]) {
		case localEvents_r1_Comp1_r_A1:
			exitSequence_localEvents_r1_Comp1_r_A1();
			break;
		case localEvents_r1_Comp1_r_C1:
			exitSequence_localEvents_r1_Comp1_r_C1();
			break;
		case localEvents_r1_Comp1_r_D1:
			exitSequence_localEvents_r1_Comp1_r_D1();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r2 */
	private void exitSequence_localEvents_r2() {
		switch (stateVector[1]) {
		case localEvents_r2_Comp2_r_A2:
			exitSequence_localEvents_r2_Comp2_r_A2();
			break;
		case localEvents_r2_Comp2_r_B2:
			exitSequence_localEvents_r2_Comp2_r_B2();
			break;
		case localEvents_r2_Comp2_r_C2:
			exitSequence_localEvents_r2_Comp2_r_C2();
			break;
		case localEvents_r2_Comp2_r_D2:
			exitSequence_localEvents_r2_Comp2_r_D2();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r */
	private void exitSequence_localEvents_r2_Comp2_r() {
		switch (stateVector[1]) {
		case localEvents_r2_Comp2_r_A2:
			exitSequence_localEvents_r2_Comp2_r_A2();
			break;
		case localEvents_r2_Comp2_r_B2:
			exitSequence_localEvents_r2_Comp2_r_B2();
			break;
		case localEvents_r2_Comp2_r_C2:
			exitSequence_localEvents_r2_Comp2_r_C2();
			break;
		case localEvents_r2_Comp2_r_D2:
			exitSequence_localEvents_r2_Comp2_r_D2();
			break;
		default:
			break;
		}
	}
	
	/* The reactions of state A1. */
	private void react_localEvents_r1_Comp1_r_A1() {
		if (check__lr0()) {
			effect__lr0();
		}
		if (check__lr1()) {
			effect__lr1();
		}
		effect__lr2();
		effect_localEvents_r1_Comp1_lr0_lr0();
		if (check_localEvents_r1_Comp1_r_A1_tr0_tr0()) {
			effect_localEvents_r1_Comp1_r_A1_tr0();
		} else {
			if (check_localEvents_r1_Comp1_r_A1_lr0_lr0()) {
				effect_localEvents_r1_Comp1_r_A1_lr0_lr0();
			}
		}
	}
	
	/* The reactions of state C1. */
	private void react_localEvents_r1_Comp1_r_C1() {
		if (check__lr0()) {
			effect__lr0();
		}
		if (check__lr1()) {
			effect__lr1();
		}
		effect__lr2();
		effect_localEvents_r1_Comp1_lr0_lr0();
		if (check_localEvents_r1_Comp1_r_C1_tr0_tr0()) {
			effect_localEvents_r1_Comp1_r_C1_tr0();
		}
	}
	
	/* The reactions of state D1. */
	private void react_localEvents_r1_Comp1_r_D1() {
		if (check__lr0()) {
			effect__lr0();
		}
		if (check__lr1()) {
			effect__lr1();
		}
		effect__lr2();
		effect_localEvents_r1_Comp1_lr0_lr0();
	}
	
	/* The reactions of state A2. */
	private void react_localEvents_r2_Comp2_r_A2() {
		effect_localEvents_r2_Comp2_lr0_lr0();
		if (check_localEvents_r2_Comp2_r_A2_tr0_tr0()) {
			effect_localEvents_r2_Comp2_r_A2_tr0();
		}
	}
	
	/* The reactions of state B2. */
	private void react_localEvents_r2_Comp2_r_B2() {
		effect_localEvents_r2_Comp2_lr0_lr0();
		if (check_localEvents_r2_Comp2_r_B2_tr0_tr0()) {
			effect_localEvents_r2_Comp2_r_B2_tr0();
		}
	}
	
	/* The reactions of state C2. */
	private void react_localEvents_r2_Comp2_r_C2() {
		effect_localEvents_r2_Comp2_lr0_lr0();
		if (check_localEvents_r2_Comp2_r_C2_tr0_tr0()) {
			effect_localEvents_r2_Comp2_r_C2_tr0();
		}
	}
	
	/* The reactions of state D2. */
	private void react_localEvents_r2_Comp2_r_D2() {
		effect_localEvents_r2_Comp2_lr0_lr0();
	}
	
	/* Default react sequence for initial entry  */
	private void react_localEvents_r1__entry_Default() {
		enterSequence_localEvents_r1_Comp1_r_A1_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_localEvents_r2__entry_Default() {
		enterSequence_localEvents_r2_Comp2_r_A2_default();
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
			case localEvents_r1_Comp1_r_A1:
				react_localEvents_r1_Comp1_r_A1();
				break;
			case localEvents_r1_Comp1_r_C1:
				react_localEvents_r1_Comp1_r_C1();
				break;
			case localEvents_r1_Comp1_r_D1:
				react_localEvents_r1_Comp1_r_D1();
				break;
			case localEvents_r2_Comp2_r_A2:
				react_localEvents_r2_Comp2_r_A2();
				break;
			case localEvents_r2_Comp2_r_B2:
				react_localEvents_r2_Comp2_r_B2();
				break;
			case localEvents_r2_Comp2_r_C2:
				react_localEvents_r2_Comp2_r_C2();
				break;
			case localEvents_r2_Comp2_r_D2:
				react_localEvents_r2_Comp2_r_D2();
				break;
			default:
				// $NullState$
			}
		}
	}
}
