package org.yakindu.scr.childfirsttransitiontaking;


public class ChildFirstTransitionTakingStatemachine implements IChildFirstTransitionTakingStatemachine {
	protected class SCInterfaceImpl implements SCInterface {
	
		private boolean e;
		
		public void raiseE() {
			e = true;
			runCycle();
		}
		
		private boolean go;
		
		public void raiseGo() {
			go = true;
			runCycle();
		}
		
		private long cLocalReaction;
		
		public long getCLocalReaction() {
			return cLocalReaction;
		}
		
		public void setCLocalReaction(long value) {
			this.cLocalReaction = value;
		}
		
		private long caLocalReaction;
		
		public long getCaLocalReaction() {
			return caLocalReaction;
		}
		
		public void setCaLocalReaction(long value) {
			this.caLocalReaction = value;
		}
		
		protected void clearEvents() {
			e = false;
			go = false;
		}
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		childFirstTransitionTaking_r1_A,
		childFirstTransitionTaking_r1_A_r1_AA,
		childFirstTransitionTaking_r1_A_r1_AB,
		childFirstTransitionTaking_r1_A_r1_AB_r1_ABA,
		childFirstTransitionTaking_r1_A_r1_AB_r2_ABB,
		childFirstTransitionTaking_r1_B,
		childFirstTransitionTaking_r2_C,
		childFirstTransitionTaking_r2_C_r_CA,
		childFirstTransitionTaking_r2_C_r_CA_r_CAA,
		childFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA,
		childFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB,
		childFirstTransitionTaking_r2_C_r_CA_r_CAB,
		childFirstTransitionTaking_r2_C_r_CB,
		childFirstTransitionTaking_r2_C_r_CB_r1_CBA,
		childFirstTransitionTaking_r2_C_r_CB_r2_CBB,
		childFirstTransitionTaking_r2_C_r_CB_r3_CBC,
		$NullState$
	};
	
	private final State[] stateVector = new State[5];
	
	private int nextStateIndex;
	
	public ChildFirstTransitionTakingStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 5; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCInterface.setCLocalReaction(0);
		
		sCInterface.setCaLocalReaction(0);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
		enterSequence_ChildFirstTransitionTaking_r1_default();
		enterSequence_ChildFirstTransitionTaking_r2_default();
	}
	
	public void exit() {
		exitSequence_ChildFirstTransitionTaking_r1();
		exitSequence_ChildFirstTransitionTaking_r2();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$||stateVector[1] != State.$NullState$||stateVector[2] != State.$NullState$||stateVector[3] != State.$NullState$||stateVector[4] != State.$NullState$;
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
		case childFirstTransitionTaking_r1_A:
			return stateVector[0].ordinal() >= State.
					childFirstTransitionTaking_r1_A.ordinal()&& stateVector[0].ordinal() <= State.childFirstTransitionTaking_r1_A_r1_AB_r2_ABB.ordinal();
		case childFirstTransitionTaking_r1_A_r1_AA:
			return stateVector[0] == State.childFirstTransitionTaking_r1_A_r1_AA;
		case childFirstTransitionTaking_r1_A_r1_AB:
			return stateVector[0].ordinal() >= State.
					childFirstTransitionTaking_r1_A_r1_AB.ordinal()&& stateVector[0].ordinal() <= State.childFirstTransitionTaking_r1_A_r1_AB_r2_ABB.ordinal();
		case childFirstTransitionTaking_r1_A_r1_AB_r1_ABA:
			return stateVector[0] == State.childFirstTransitionTaking_r1_A_r1_AB_r1_ABA;
		case childFirstTransitionTaking_r1_A_r1_AB_r2_ABB:
			return stateVector[1] == State.childFirstTransitionTaking_r1_A_r1_AB_r2_ABB;
		case childFirstTransitionTaking_r1_B:
			return stateVector[0] == State.childFirstTransitionTaking_r1_B;
		case childFirstTransitionTaking_r2_C:
			return stateVector[2].ordinal() >= State.
					childFirstTransitionTaking_r2_C.ordinal()&& stateVector[2].ordinal() <= State.childFirstTransitionTaking_r2_C_r_CB_r3_CBC.ordinal();
		case childFirstTransitionTaking_r2_C_r_CA:
			return stateVector[2].ordinal() >= State.
					childFirstTransitionTaking_r2_C_r_CA.ordinal()&& stateVector[2].ordinal() <= State.childFirstTransitionTaking_r2_C_r_CA_r_CAB.ordinal();
		case childFirstTransitionTaking_r2_C_r_CA_r_CAA:
			return stateVector[2].ordinal() >= State.
					childFirstTransitionTaking_r2_C_r_CA_r_CAA.ordinal()&& stateVector[2].ordinal() <= State.childFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB.ordinal();
		case childFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA:
			return stateVector[2] == State.childFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA;
		case childFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB:
			return stateVector[3] == State.childFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB;
		case childFirstTransitionTaking_r2_C_r_CA_r_CAB:
			return stateVector[2] == State.childFirstTransitionTaking_r2_C_r_CA_r_CAB;
		case childFirstTransitionTaking_r2_C_r_CB:
			return stateVector[2].ordinal() >= State.
					childFirstTransitionTaking_r2_C_r_CB.ordinal()&& stateVector[2].ordinal() <= State.childFirstTransitionTaking_r2_C_r_CB_r3_CBC.ordinal();
		case childFirstTransitionTaking_r2_C_r_CB_r1_CBA:
			return stateVector[2] == State.childFirstTransitionTaking_r2_C_r_CB_r1_CBA;
		case childFirstTransitionTaking_r2_C_r_CB_r2_CBB:
			return stateVector[3] == State.childFirstTransitionTaking_r2_C_r_CB_r2_CBB;
		case childFirstTransitionTaking_r2_C_r_CB_r3_CBC:
			return stateVector[4] == State.childFirstTransitionTaking_r2_C_r_CB_r3_CBC;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public void raiseE() {
		sCInterface.raiseE();
	}
	
	public void raiseGo() {
		sCInterface.raiseGo();
	}
	
	public long getCLocalReaction() {
		return sCInterface.getCLocalReaction();
	}
	
	public void setCLocalReaction(long value) {
		sCInterface.setCLocalReaction(value);
	}
	
	public long getCaLocalReaction() {
		return sCInterface.getCaLocalReaction();
	}
	
	public void setCaLocalReaction(long value) {
		sCInterface.setCaLocalReaction(value);
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_ChildFirstTransitionTaking_r1_A_default() {
		enterSequence_ChildFirstTransitionTaking_r1_A_r1_default();
	}
	
	/* 'default' enter sequence for state AA */
	private void enterSequence_ChildFirstTransitionTaking_r1_A_r1_AA_default() {
		nextStateIndex = 0;
		stateVector[0] = State.childFirstTransitionTaking_r1_A_r1_AA;
	}
	
	/* 'default' enter sequence for state AB */
	private void enterSequence_ChildFirstTransitionTaking_r1_A_r1_AB_default() {
		enterSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r1_default();
		enterSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r2_default();
	}
	
	/* 'default' enter sequence for state ABA */
	private void enterSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r1_ABA_default() {
		nextStateIndex = 0;
		stateVector[0] = State.childFirstTransitionTaking_r1_A_r1_AB_r1_ABA;
	}
	
	/* 'default' enter sequence for state ABB */
	private void enterSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r2_ABB_default() {
		nextStateIndex = 1;
		stateVector[1] = State.childFirstTransitionTaking_r1_A_r1_AB_r2_ABB;
	}
	
	/* 'default' enter sequence for state B */
	private void enterSequence_ChildFirstTransitionTaking_r1_B_default() {
		nextStateIndex = 0;
		stateVector[0] = State.childFirstTransitionTaking_r1_B;
	}
	
	/* 'default' enter sequence for state C */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_default() {
		enterSequence_ChildFirstTransitionTaking_r2_C_r_default();
	}
	
	/* 'default' enter sequence for state CA */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_default() {
		enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_default();
	}
	
	/* 'default' enter sequence for state CAA */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_default() {
		enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_default();
		enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_default();
	}
	
	/* 'default' enter sequence for state CAAA */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA_default() {
		nextStateIndex = 2;
		stateVector[2] = State.childFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA;
	}
	
	/* 'default' enter sequence for state CAAB */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB_default() {
		nextStateIndex = 3;
		stateVector[3] = State.childFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB;
	}
	
	/* 'default' enter sequence for state CAB */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAB_default() {
		nextStateIndex = 2;
		stateVector[2] = State.childFirstTransitionTaking_r2_C_r_CA_r_CAB;
	}
	
	/* 'default' enter sequence for state CB */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_default() {
		enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_r1_default();
		enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_r2_default();
		enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_r3_default();
	}
	
	/* 'default' enter sequence for state CBA */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_r1_CBA_default() {
		nextStateIndex = 2;
		stateVector[2] = State.childFirstTransitionTaking_r2_C_r_CB_r1_CBA;
	}
	
	/* 'default' enter sequence for state CBB */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_r2_CBB_default() {
		nextStateIndex = 3;
		stateVector[3] = State.childFirstTransitionTaking_r2_C_r_CB_r2_CBB;
	}
	
	/* 'default' enter sequence for state CBC */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_r3_CBC_default() {
		nextStateIndex = 4;
		stateVector[4] = State.childFirstTransitionTaking_r2_C_r_CB_r3_CBC;
	}
	
	/* 'default' enter sequence for region r1 */
	private void enterSequence_ChildFirstTransitionTaking_r1_default() {
		react_ChildFirstTransitionTaking_r1__entry_Default();
	}
	
	/* 'default' enter sequence for region r1 */
	private void enterSequence_ChildFirstTransitionTaking_r1_A_r1_default() {
		react_ChildFirstTransitionTaking_r1_A_r1__entry_Default();
	}
	
	/* 'default' enter sequence for region r1 */
	private void enterSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r1_default() {
		react_ChildFirstTransitionTaking_r1_A_r1_AB_r1__entry_Default();
	}
	
	/* 'default' enter sequence for region r2 */
	private void enterSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r2_default() {
		react_ChildFirstTransitionTaking_r1_A_r1_AB_r2__entry_Default();
	}
	
	/* 'default' enter sequence for region r2 */
	private void enterSequence_ChildFirstTransitionTaking_r2_default() {
		react_ChildFirstTransitionTaking_r2__entry_Default();
	}
	
	/* 'default' enter sequence for region r */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_default() {
		react_ChildFirstTransitionTaking_r2_C_r__entry_Default();
	}
	
	/* 'default' enter sequence for region r */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_default() {
		react_ChildFirstTransitionTaking_r2_C_r_CA_r__entry_Default();
	}
	
	/* 'default' enter sequence for region r1 */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_default() {
		react_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r1__entry_Default();
	}
	
	/* 'default' enter sequence for region r2 */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_default() {
		react_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r2__entry_Default();
	}
	
	/* 'default' enter sequence for region r1 */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_r1_default() {
		react_ChildFirstTransitionTaking_r2_C_r_CB_r1__entry_Default();
	}
	
	/* 'default' enter sequence for region r2 */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_r2_default() {
		react_ChildFirstTransitionTaking_r2_C_r_CB_r2__entry_Default();
	}
	
	/* 'default' enter sequence for region r3 */
	private void enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_r3_default() {
		react_ChildFirstTransitionTaking_r2_C_r_CB_r3__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_ChildFirstTransitionTaking_r1_A() {
		exitSequence_ChildFirstTransitionTaking_r1_A_r1();
	}
	
	/* Default exit sequence for state AA */
	private void exitSequence_ChildFirstTransitionTaking_r1_A_r1_AA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state AB */
	private void exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB() {
		exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r1();
		exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r2();
	}
	
	/* Default exit sequence for state ABA */
	private void exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r1_ABA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state ABB */
	private void exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r2_ABB() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state B */
	private void exitSequence_ChildFirstTransitionTaking_r1_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state CA */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CA() {
		exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r();
	}
	
	/* Default exit sequence for state CAA */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA() {
		exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r1();
		exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r2();
	}
	
	/* Default exit sequence for state CAAA */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}
	
	/* Default exit sequence for state CAAB */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}
	
	/* Default exit sequence for state CAB */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAB() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}
	
	/* Default exit sequence for state CB */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CB() {
		exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r1();
		exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r2();
		exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r3();
	}
	
	/* Default exit sequence for state CBA */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r1_CBA() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}
	
	/* Default exit sequence for state CBB */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r2_CBB() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}
	
	/* Default exit sequence for state CBC */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r3_CBC() {
		nextStateIndex = 4;
		stateVector[4] = State.$NullState$;
	}
	
	/* Default exit sequence for region r1 */
	private void exitSequence_ChildFirstTransitionTaking_r1() {
		switch (stateVector[0]) {
		case childFirstTransitionTaking_r1_A_r1_AA:
			exitSequence_ChildFirstTransitionTaking_r1_A_r1_AA();
			break;
		case childFirstTransitionTaking_r1_A_r1_AB_r1_ABA:
			exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r1_ABA();
			break;
		case childFirstTransitionTaking_r1_B:
			exitSequence_ChildFirstTransitionTaking_r1_B();
			break;
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case childFirstTransitionTaking_r1_A_r1_AB_r2_ABB:
			exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r2_ABB();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r1 */
	private void exitSequence_ChildFirstTransitionTaking_r1_A_r1() {
		switch (stateVector[0]) {
		case childFirstTransitionTaking_r1_A_r1_AA:
			exitSequence_ChildFirstTransitionTaking_r1_A_r1_AA();
			break;
		case childFirstTransitionTaking_r1_A_r1_AB_r1_ABA:
			exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r1_ABA();
			break;
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case childFirstTransitionTaking_r1_A_r1_AB_r2_ABB:
			exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r2_ABB();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r1 */
	private void exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r1() {
		switch (stateVector[0]) {
		case childFirstTransitionTaking_r1_A_r1_AB_r1_ABA:
			exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r1_ABA();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r2 */
	private void exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r2() {
		switch (stateVector[1]) {
		case childFirstTransitionTaking_r1_A_r1_AB_r2_ABB:
			exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r2_ABB();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r2 */
	private void exitSequence_ChildFirstTransitionTaking_r2() {
		switch (stateVector[2]) {
		case childFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA();
			break;
		case childFirstTransitionTaking_r2_C_r_CA_r_CAB:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAB();
			break;
		case childFirstTransitionTaking_r2_C_r_CB_r1_CBA:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r1_CBA();
			break;
		default:
			break;
		}
		
		switch (stateVector[3]) {
		case childFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB();
			break;
		case childFirstTransitionTaking_r2_C_r_CB_r2_CBB:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r2_CBB();
			break;
		default:
			break;
		}
		
		switch (stateVector[4]) {
		case childFirstTransitionTaking_r2_C_r_CB_r3_CBC:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r3_CBC();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r() {
		switch (stateVector[2]) {
		case childFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA();
			break;
		case childFirstTransitionTaking_r2_C_r_CA_r_CAB:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAB();
			break;
		case childFirstTransitionTaking_r2_C_r_CB_r1_CBA:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r1_CBA();
			break;
		default:
			break;
		}
		
		switch (stateVector[3]) {
		case childFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB();
			break;
		case childFirstTransitionTaking_r2_C_r_CB_r2_CBB:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r2_CBB();
			break;
		default:
			break;
		}
		
		switch (stateVector[4]) {
		case childFirstTransitionTaking_r2_C_r_CB_r3_CBC:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r3_CBC();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r() {
		switch (stateVector[2]) {
		case childFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA();
			break;
		case childFirstTransitionTaking_r2_C_r_CA_r_CAB:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAB();
			break;
		default:
			break;
		}
		
		switch (stateVector[3]) {
		case childFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r1 */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r1() {
		switch (stateVector[2]) {
		case childFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r2 */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r2() {
		switch (stateVector[3]) {
		case childFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r1 */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r1() {
		switch (stateVector[2]) {
		case childFirstTransitionTaking_r2_C_r_CB_r1_CBA:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r1_CBA();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r2 */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r2() {
		switch (stateVector[3]) {
		case childFirstTransitionTaking_r2_C_r_CB_r2_CBB:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r2_CBB();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r3 */
	private void exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r3() {
		switch (stateVector[4]) {
		case childFirstTransitionTaking_r2_C_r_CB_r3_CBC:
			exitSequence_ChildFirstTransitionTaking_r2_C_r_CB_r3_CBC();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstTransitionTaking_r1__entry_Default() {
		enterSequence_ChildFirstTransitionTaking_r1_A_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstTransitionTaking_r1_A_r1__entry_Default() {
		enterSequence_ChildFirstTransitionTaking_r1_A_r1_AA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstTransitionTaking_r1_A_r1_AB_r1__entry_Default() {
		enterSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r1_ABA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstTransitionTaking_r1_A_r1_AB_r2__entry_Default() {
		enterSequence_ChildFirstTransitionTaking_r1_A_r1_AB_r2_ABB_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstTransitionTaking_r2__entry_Default() {
		enterSequence_ChildFirstTransitionTaking_r2_C_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstTransitionTaking_r2_C_r__entry_Default() {
		enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstTransitionTaking_r2_C_r_CA_r__entry_Default() {
		enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r1__entry_Default() {
		enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r2__entry_Default() {
		enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstTransitionTaking_r2_C_r_CB_r1__entry_Default() {
		enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_r1_CBA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstTransitionTaking_r2_C_r_CB_r2__entry_Default() {
		enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_r2_CBB_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstTransitionTaking_r2_C_r_CB_r3__entry_Default() {
		enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_r3_CBC_default();
	}
	
	private boolean react(boolean try_transition) {
		return false;
	}
	
	private boolean childFirstTransitionTaking_r1_A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.e) {
				exitSequence_ChildFirstTransitionTaking_r1_A();
				enterSequence_ChildFirstTransitionTaking_r1_B_default();
			} else {
				did_transition = false;
			}
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r1_A_r1_AA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.go) {
				exitSequence_ChildFirstTransitionTaking_r1_A_r1_AA();
				enterSequence_ChildFirstTransitionTaking_r1_A_r1_AB_default();
				childFirstTransitionTaking_r1_A_react(false);
			} else {
				did_transition = false;
			}
		}
		if (did_transition==false) {
			did_transition = childFirstTransitionTaking_r1_A_react(try_transition);
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r1_A_r1_AB_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
			did_transition = childFirstTransitionTaking_r1_A_react(try_transition);
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r1_A_r1_AB_r1_ABA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.go) {
				exitSequence_ChildFirstTransitionTaking_r1_A_r1_AB();
				enterSequence_ChildFirstTransitionTaking_r1_A_r1_AA_default();
				childFirstTransitionTaking_r1_A_react(false);
			} else {
				did_transition = false;
			}
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r1_A_r1_AB_r2_ABB_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
			did_transition = childFirstTransitionTaking_r1_A_r1_AB_react(try_transition);
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r1_B_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.e) {
				exitSequence_ChildFirstTransitionTaking_r1_B();
				enterSequence_ChildFirstTransitionTaking_r1_A_default();
			} else {
				did_transition = false;
			}
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r2_C_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
			sCInterface.setCLocalReaction(sCInterface.getCLocalReaction() + 1);
			
			did_transition = react(try_transition);
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r2_C_r_CA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.e) {
				exitSequence_ChildFirstTransitionTaking_r2_C_r_CA();
				enterSequence_ChildFirstTransitionTaking_r2_C_r_CB_default();
				childFirstTransitionTaking_r2_C_react(false);
			} else {
				did_transition = false;
			}
		}
		if (did_transition==false) {
			sCInterface.setCaLocalReaction(sCInterface.getCaLocalReaction() + 1);
			
			did_transition = childFirstTransitionTaking_r2_C_react(try_transition);
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r2_C_r_CA_r_CAA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.go) {
				exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA();
				enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAB_default();
				childFirstTransitionTaking_r2_C_r_CA_react(false);
			} else {
				did_transition = false;
			}
		}
		if (did_transition==false) {
			did_transition = childFirstTransitionTaking_r2_C_r_CA_react(try_transition);
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
			did_transition = childFirstTransitionTaking_r2_C_r_CA_r_CAA_react(try_transition);
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r2_C_r_CA_r_CAB_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.go) {
				exitSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAB();
				enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_r_CAA_default();
				childFirstTransitionTaking_r2_C_r_CA_react(false);
			} else {
				did_transition = false;
			}
		}
		if (did_transition==false) {
			did_transition = childFirstTransitionTaking_r2_C_r_CA_react(try_transition);
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r2_C_r_CB_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.e) {
				exitSequence_ChildFirstTransitionTaking_r2_C_r_CB();
				enterSequence_ChildFirstTransitionTaking_r2_C_r_CA_default();
				childFirstTransitionTaking_r2_C_react(false);
			} else {
				did_transition = false;
			}
		}
		if (did_transition==false) {
			did_transition = childFirstTransitionTaking_r2_C_react(try_transition);
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r2_C_r_CB_r1_CBA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r2_C_r_CB_r2_CBB_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	private boolean childFirstTransitionTaking_r2_C_r_CB_r3_CBC_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;
		}
		if (did_transition==false) {
			did_transition = childFirstTransitionTaking_r2_C_r_CB_react(try_transition);
		}
		return did_transition;
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		clearOutEvents();
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case childFirstTransitionTaking_r1_A_r1_AA:
				childFirstTransitionTaking_r1_A_r1_AA_react(true);
				break;
			case childFirstTransitionTaking_r1_A_r1_AB_r1_ABA:
				childFirstTransitionTaking_r1_A_r1_AB_r1_ABA_react(true);
				break;
			case childFirstTransitionTaking_r1_A_r1_AB_r2_ABB:
				childFirstTransitionTaking_r1_A_r1_AB_r2_ABB_react(true);
				break;
			case childFirstTransitionTaking_r1_B:
				childFirstTransitionTaking_r1_B_react(true);
				break;
			case childFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA:
				childFirstTransitionTaking_r2_C_r_CA_r_CAA_r1_CAAA_react(true);
				break;
			case childFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB:
				childFirstTransitionTaking_r2_C_r_CA_r_CAA_r2_CAAB_react(true);
				break;
			case childFirstTransitionTaking_r2_C_r_CA_r_CAB:
				childFirstTransitionTaking_r2_C_r_CA_r_CAB_react(true);
				break;
			case childFirstTransitionTaking_r2_C_r_CB_r1_CBA:
				childFirstTransitionTaking_r2_C_r_CB_r1_CBA_react(true);
				break;
			case childFirstTransitionTaking_r2_C_r_CB_r2_CBB:
				childFirstTransitionTaking_r2_C_r_CB_r2_CBB_react(true);
				break;
			case childFirstTransitionTaking_r2_C_r_CB_r3_CBC:
				childFirstTransitionTaking_r2_C_r_CB_r3_CBC_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
