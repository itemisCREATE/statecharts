package org.yakindu.scr.childfirstorthogonalreactions;

public class ChildFirstOrthogonalReactionsStatemachine implements IChildFirstOrthogonalReactionsStatemachine {

	protected class SCInterfaceImpl implements SCInterface {
	
		private SCInterfaceOperationCallback operationCallback;
		
		public void setSCInterfaceOperationCallback(
				SCInterfaceOperationCallback operationCallback) {
			this.operationCallback = operationCallback;
		}
		private long a_local;
		
		public long getA_local() {
			return a_local;
		}
		
		public void setA_local(long value) {
			this.a_local = value;
		}
		
		private long c_local;
		
		public long getC_local() {
			return c_local;
		}
		
		public void setC_local(long value) {
			this.c_local = value;
		}
		
		private long aa_local;
		
		public long getAa_local() {
			return aa_local;
		}
		
		public void setAa_local(long value) {
			this.aa_local = value;
		}
		
		private long ac_local;
		
		public long getAc_local() {
			return ac_local;
		}
		
		public void setAc_local(long value) {
			this.ac_local = value;
		}
		
		private long aaa_local;
		
		public long getAaa_local() {
			return aaa_local;
		}
		
		public void setAaa_local(long value) {
			this.aaa_local = value;
		}
		
		private long aac_local;
		
		public long getAac_local() {
			return aac_local;
		}
		
		public void setAac_local(long value) {
			this.aac_local = value;
		}
		
		private long a_check;
		
		public long getA_check() {
			return a_check;
		}
		
		public void setA_check(long value) {
			this.a_check = value;
		}
		
		private long aa_check;
		
		public long getAa_check() {
			return aa_check;
		}
		
		public void setAa_check(long value) {
			this.aa_check = value;
		}
		
		private long aaa_check;
		
		public long getAaa_check() {
			return aaa_check;
		}
		
		public void setAaa_check(long value) {
			this.aaa_check = value;
		}
		
		private long aac_check;
		
		public long getAac_check() {
			return aac_check;
		}
		
		public void setAac_check(long value) {
			this.aac_check = value;
		}
		
		private long ac_check;
		
		public long getAc_check() {
			return ac_check;
		}
		
		public void setAc_check(long value) {
			this.ac_check = value;
		}
		
		private long c_check;
		
		public long getC_check() {
			return c_check;
		}
		
		public void setC_check(long value) {
			this.c_check = value;
		}
		
		private long sm_local;
		
		public long getSm_local() {
			return sm_local;
		}
		
		public void setSm_local(long value) {
			this.sm_local = value;
		}
		
		private long cnt;
		
		public long getCnt() {
			return cnt;
		}
		
		public void setCnt(long value) {
			this.cnt = value;
		}
		
	}
	
	protected SCInterfaceImpl sCInterface;
	
	private boolean initialized = false;
	
	public enum State {
		childFirstOrthogonalReactions_r_A,
		childFirstOrthogonalReactions_r_A_r_AA,
		childFirstOrthogonalReactions_r_A_r_AA_r_AAA,
		childFirstOrthogonalReactions_r_A_r_AA__region1_AAC,
		childFirstOrthogonalReactions_r_A_r2_AC,
		childFirstOrthogonalReactions_r_B,
		childFirstOrthogonalReactions_r2_C,
		childFirstOrthogonalReactions_r2_D,
		$NullState$
	};
	
	private final State[] stateVector = new State[4];
	
	private int nextStateIndex;
	
	public ChildFirstOrthogonalReactionsStatemachine() {
		sCInterface = new SCInterfaceImpl();
	}
	
	public void init() {
		this.initialized = true;
		if (this.sCInterface.operationCallback == null) {
			throw new IllegalStateException("Operation callback for interface sCInterface must be set.");
		}
		
		for (int i = 0; i < 4; i++) {
			stateVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();
		sCInterface.setA_local(0);
		
		sCInterface.setC_local(0);
		
		sCInterface.setAa_local(0);
		
		sCInterface.setAc_local(0);
		
		sCInterface.setAaa_local(0);
		
		sCInterface.setAac_local(0);
		
		sCInterface.setA_check(0);
		
		sCInterface.setAa_check(0);
		
		sCInterface.setAaa_check(0);
		
		sCInterface.setAac_check(0);
		
		sCInterface.setAc_check(0);
		
		sCInterface.setC_check(0);
		
		sCInterface.setSm_local(0);
		
		sCInterface.setCnt(0);
	}
	
	public void enter() {
		if (!initialized) {
			throw new IllegalStateException(
					"The state machine needs to be initialized first by calling the init() function.");
		}
		enterSequence_ChildFirstOrthogonalReactions_r_default();
		enterSequence_ChildFirstOrthogonalReactions_r2_default();
	}
	
	public void exit() {
		exitSequence_ChildFirstOrthogonalReactions_r();
		exitSequence_ChildFirstOrthogonalReactions_r2();
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NullState$||stateVector[1] != State.$NullState$||stateVector[2] != State.$NullState$||stateVector[3] != State.$NullState$;
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
		case childFirstOrthogonalReactions_r_A:
			return stateVector[0].ordinal() >= State.
					childFirstOrthogonalReactions_r_A.ordinal()&& stateVector[0].ordinal() <= State.childFirstOrthogonalReactions_r_A_r2_AC.ordinal();
		case childFirstOrthogonalReactions_r_A_r_AA:
			return stateVector[0].ordinal() >= State.
					childFirstOrthogonalReactions_r_A_r_AA.ordinal()&& stateVector[0].ordinal() <= State.childFirstOrthogonalReactions_r_A_r_AA__region1_AAC.ordinal();
		case childFirstOrthogonalReactions_r_A_r_AA_r_AAA:
			return stateVector[0] == State.childFirstOrthogonalReactions_r_A_r_AA_r_AAA;
		case childFirstOrthogonalReactions_r_A_r_AA__region1_AAC:
			return stateVector[1] == State.childFirstOrthogonalReactions_r_A_r_AA__region1_AAC;
		case childFirstOrthogonalReactions_r_A_r2_AC:
			return stateVector[2] == State.childFirstOrthogonalReactions_r_A_r2_AC;
		case childFirstOrthogonalReactions_r_B:
			return stateVector[0] == State.childFirstOrthogonalReactions_r_B;
		case childFirstOrthogonalReactions_r2_C:
			return stateVector[3] == State.childFirstOrthogonalReactions_r2_C;
		case childFirstOrthogonalReactions_r2_D:
			return stateVector[3] == State.childFirstOrthogonalReactions_r2_D;
		default:
			return false;
		}
	}
	
	public SCInterface getSCInterface() {
		return sCInterface;
	}
	
	public long getA_local() {
		return sCInterface.getA_local();
	}
	
	public void setA_local(long value) {
		sCInterface.setA_local(value);
	}
	
	public long getC_local() {
		return sCInterface.getC_local();
	}
	
	public void setC_local(long value) {
		sCInterface.setC_local(value);
	}
	
	public long getAa_local() {
		return sCInterface.getAa_local();
	}
	
	public void setAa_local(long value) {
		sCInterface.setAa_local(value);
	}
	
	public long getAc_local() {
		return sCInterface.getAc_local();
	}
	
	public void setAc_local(long value) {
		sCInterface.setAc_local(value);
	}
	
	public long getAaa_local() {
		return sCInterface.getAaa_local();
	}
	
	public void setAaa_local(long value) {
		sCInterface.setAaa_local(value);
	}
	
	public long getAac_local() {
		return sCInterface.getAac_local();
	}
	
	public void setAac_local(long value) {
		sCInterface.setAac_local(value);
	}
	
	public long getA_check() {
		return sCInterface.getA_check();
	}
	
	public void setA_check(long value) {
		sCInterface.setA_check(value);
	}
	
	public long getAa_check() {
		return sCInterface.getAa_check();
	}
	
	public void setAa_check(long value) {
		sCInterface.setAa_check(value);
	}
	
	public long getAaa_check() {
		return sCInterface.getAaa_check();
	}
	
	public void setAaa_check(long value) {
		sCInterface.setAaa_check(value);
	}
	
	public long getAac_check() {
		return sCInterface.getAac_check();
	}
	
	public void setAac_check(long value) {
		sCInterface.setAac_check(value);
	}
	
	public long getAc_check() {
		return sCInterface.getAc_check();
	}
	
	public void setAc_check(long value) {
		sCInterface.setAc_check(value);
	}
	
	public long getC_check() {
		return sCInterface.getC_check();
	}
	
	public void setC_check(long value) {
		sCInterface.setC_check(value);
	}
	
	public long getSm_local() {
		return sCInterface.getSm_local();
	}
	
	public void setSm_local(long value) {
		sCInterface.setSm_local(value);
	}
	
	public long getCnt() {
		return sCInterface.getCnt();
	}
	
	public void setCnt(long value) {
		sCInterface.setCnt(value);
	}
	
	/* 'default' enter sequence for state A */
	private void enterSequence_ChildFirstOrthogonalReactions_r_A_default() {
		enterSequence_ChildFirstOrthogonalReactions_r_A_r_default();
		enterSequence_ChildFirstOrthogonalReactions_r_A_r2_default();
	}
	
	/* 'default' enter sequence for state AA */
	private void enterSequence_ChildFirstOrthogonalReactions_r_A_r_AA_default() {
		enterSequence_ChildFirstOrthogonalReactions_r_A_r_AA_r_default();
		enterSequence_ChildFirstOrthogonalReactions_r_A_r_AA__region1_default();
	}
	
	/* 'default' enter sequence for state AAA */
	private void enterSequence_ChildFirstOrthogonalReactions_r_A_r_AA_r_AAA_default() {
		nextStateIndex = 0;
		stateVector[0] = State.childFirstOrthogonalReactions_r_A_r_AA_r_AAA;
	}
	
	/* 'default' enter sequence for state AAC */
	private void enterSequence_ChildFirstOrthogonalReactions_r_A_r_AA__region1_AAC_default() {
		nextStateIndex = 1;
		stateVector[1] = State.childFirstOrthogonalReactions_r_A_r_AA__region1_AAC;
	}
	
	/* 'default' enter sequence for state AC */
	private void enterSequence_ChildFirstOrthogonalReactions_r_A_r2_AC_default() {
		nextStateIndex = 2;
		stateVector[2] = State.childFirstOrthogonalReactions_r_A_r2_AC;
	}
	
	/* 'default' enter sequence for state B */
	private void enterSequence_ChildFirstOrthogonalReactions_r_B_default() {
		nextStateIndex = 0;
		stateVector[0] = State.childFirstOrthogonalReactions_r_B;
	}
	
	/* 'default' enter sequence for state C */
	private void enterSequence_ChildFirstOrthogonalReactions_r2_C_default() {
		nextStateIndex = 3;
		stateVector[3] = State.childFirstOrthogonalReactions_r2_C;
	}
	
	/* 'default' enter sequence for state D */
	private void enterSequence_ChildFirstOrthogonalReactions_r2_D_default() {
		nextStateIndex = 3;
		stateVector[3] = State.childFirstOrthogonalReactions_r2_D;
	}
	
	/* 'default' enter sequence for region r */
	private void enterSequence_ChildFirstOrthogonalReactions_r_default() {
		react_ChildFirstOrthogonalReactions_r__entry_Default();
	}
	
	/* 'default' enter sequence for region r */
	private void enterSequence_ChildFirstOrthogonalReactions_r_A_r_default() {
		react_ChildFirstOrthogonalReactions_r_A_r__entry_Default();
	}
	
	/* 'default' enter sequence for region r */
	private void enterSequence_ChildFirstOrthogonalReactions_r_A_r_AA_r_default() {
		react_ChildFirstOrthogonalReactions_r_A_r_AA_r__entry_Default();
	}
	
	/* 'default' enter sequence for region  */
	private void enterSequence_ChildFirstOrthogonalReactions_r_A_r_AA__region1_default() {
		react_ChildFirstOrthogonalReactions_r_A_r_AA__region1__entry_Default();
	}
	
	/* 'default' enter sequence for region r2 */
	private void enterSequence_ChildFirstOrthogonalReactions_r_A_r2_default() {
		react_ChildFirstOrthogonalReactions_r_A_r2__entry_Default();
	}
	
	/* 'default' enter sequence for region r2 */
	private void enterSequence_ChildFirstOrthogonalReactions_r2_default() {
		react_ChildFirstOrthogonalReactions_r2__entry_Default();
	}
	
	/* Default exit sequence for state A */
	private void exitSequence_ChildFirstOrthogonalReactions_r_A() {
		exitSequence_ChildFirstOrthogonalReactions_r_A_r();
		exitSequence_ChildFirstOrthogonalReactions_r_A_r2();
	}
	
	/* Default exit sequence for state AAA */
	private void exitSequence_ChildFirstOrthogonalReactions_r_A_r_AA_r_AAA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state AAC */
	private void exitSequence_ChildFirstOrthogonalReactions_r_A_r_AA__region1_AAC() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}
	
	/* Default exit sequence for state AC */
	private void exitSequence_ChildFirstOrthogonalReactions_r_A_r2_AC() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}
	
	/* Default exit sequence for state B */
	private void exitSequence_ChildFirstOrthogonalReactions_r_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}
	
	/* Default exit sequence for state C */
	private void exitSequence_ChildFirstOrthogonalReactions_r2_C() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}
	
	/* Default exit sequence for state D */
	private void exitSequence_ChildFirstOrthogonalReactions_r2_D() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}
	
	/* Default exit sequence for region r */
	private void exitSequence_ChildFirstOrthogonalReactions_r() {
		switch (stateVector[0]) {
		case childFirstOrthogonalReactions_r_A_r_AA_r_AAA:
			exitSequence_ChildFirstOrthogonalReactions_r_A_r_AA_r_AAA();
			break;
		case childFirstOrthogonalReactions_r_B:
			exitSequence_ChildFirstOrthogonalReactions_r_B();
			break;
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case childFirstOrthogonalReactions_r_A_r_AA__region1_AAC:
			exitSequence_ChildFirstOrthogonalReactions_r_A_r_AA__region1_AAC();
			break;
		default:
			break;
		}
		
		switch (stateVector[2]) {
		case childFirstOrthogonalReactions_r_A_r2_AC:
			exitSequence_ChildFirstOrthogonalReactions_r_A_r2_AC();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r */
	private void exitSequence_ChildFirstOrthogonalReactions_r_A_r() {
		switch (stateVector[0]) {
		case childFirstOrthogonalReactions_r_A_r_AA_r_AAA:
			exitSequence_ChildFirstOrthogonalReactions_r_A_r_AA_r_AAA();
			break;
		default:
			break;
		}
		
		switch (stateVector[1]) {
		case childFirstOrthogonalReactions_r_A_r_AA__region1_AAC:
			exitSequence_ChildFirstOrthogonalReactions_r_A_r_AA__region1_AAC();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r */
	private void exitSequence_ChildFirstOrthogonalReactions_r_A_r_AA_r() {
		switch (stateVector[0]) {
		case childFirstOrthogonalReactions_r_A_r_AA_r_AAA:
			exitSequence_ChildFirstOrthogonalReactions_r_A_r_AA_r_AAA();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region  */
	private void exitSequence_ChildFirstOrthogonalReactions_r_A_r_AA__region1() {
		switch (stateVector[1]) {
		case childFirstOrthogonalReactions_r_A_r_AA__region1_AAC:
			exitSequence_ChildFirstOrthogonalReactions_r_A_r_AA__region1_AAC();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r2 */
	private void exitSequence_ChildFirstOrthogonalReactions_r_A_r2() {
		switch (stateVector[2]) {
		case childFirstOrthogonalReactions_r_A_r2_AC:
			exitSequence_ChildFirstOrthogonalReactions_r_A_r2_AC();
			break;
		default:
			break;
		}
	}
	
	/* Default exit sequence for region r2 */
	private void exitSequence_ChildFirstOrthogonalReactions_r2() {
		switch (stateVector[3]) {
		case childFirstOrthogonalReactions_r2_C:
			exitSequence_ChildFirstOrthogonalReactions_r2_C();
			break;
		case childFirstOrthogonalReactions_r2_D:
			exitSequence_ChildFirstOrthogonalReactions_r2_D();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstOrthogonalReactions_r__entry_Default() {
		enterSequence_ChildFirstOrthogonalReactions_r_A_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstOrthogonalReactions_r_A_r__entry_Default() {
		enterSequence_ChildFirstOrthogonalReactions_r_A_r_AA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstOrthogonalReactions_r_A_r_AA_r__entry_Default() {
		enterSequence_ChildFirstOrthogonalReactions_r_A_r_AA_r_AAA_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstOrthogonalReactions_r_A_r_AA__region1__entry_Default() {
		enterSequence_ChildFirstOrthogonalReactions_r_A_r_AA__region1_AAC_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstOrthogonalReactions_r_A_r2__entry_Default() {
		enterSequence_ChildFirstOrthogonalReactions_r_A_r2_AC_default();
	}
	
	/* Default react sequence for initial entry  */
	private void react_ChildFirstOrthogonalReactions_r2__entry_Default() {
		enterSequence_ChildFirstOrthogonalReactions_r2_C_default();
	}
	
	private boolean react(boolean try_transition) {
		sCInterface.setSm_local(sCInterface.operationCallback.next());
		
		return false;
	}
	
	private boolean childFirstOrthogonalReactions_r_A_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.operationCallback.check("A")) {
				exitSequence_ChildFirstOrthogonalReactions_r_A();
				enterSequence_ChildFirstOrthogonalReactions_r_B_default();
			} else {
				did_transition = false;;
			}
		}
		if (did_transition==false) {
			sCInterface.setA_local(sCInterface.operationCallback.next());
		}
		return did_transition;
	}
	
	private boolean childFirstOrthogonalReactions_r_A_r_AA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.operationCallback.check("AA")) {
				exitSequence_ChildFirstOrthogonalReactions_r_A();
				enterSequence_ChildFirstOrthogonalReactions_r_B_default();
			} else {
				did_transition = false;;
			}
		}
		if (did_transition==false) {
			sCInterface.setAa_local(sCInterface.operationCallback.next());
		}
		return did_transition;
	}
	
	private boolean childFirstOrthogonalReactions_r_A_r_AA_r_AAA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.operationCallback.check("AAA")) {
				exitSequence_ChildFirstOrthogonalReactions_r_A();
				enterSequence_ChildFirstOrthogonalReactions_r_B_default();
			} else {
				did_transition = false;;
			}
		}
		if (did_transition==false) {
			sCInterface.setAaa_local(sCInterface.operationCallback.next());
		}
		return did_transition;
	}
	
	private boolean childFirstOrthogonalReactions_r_A_r_AA__region1_AAC_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.operationCallback.check("AAC")) {
				exitSequence_ChildFirstOrthogonalReactions_r_A();
				enterSequence_ChildFirstOrthogonalReactions_r_B_default();
			} else {
				did_transition = false;;
			}
		}
		if (did_transition==false) {
			sCInterface.setAac_local(sCInterface.operationCallback.next());
			
			did_transition = childFirstOrthogonalReactions_r_A_r_AA_react(try_transition);;
		}
		return did_transition;
	}
	
	private boolean childFirstOrthogonalReactions_r_A_r2_AC_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.operationCallback.check("AC")) {
				exitSequence_ChildFirstOrthogonalReactions_r_A();
				enterSequence_ChildFirstOrthogonalReactions_r_B_default();
			} else {
				did_transition = false;;
			}
		}
		if (did_transition==false) {
			sCInterface.setAc_local(sCInterface.operationCallback.next());
			
			did_transition = childFirstOrthogonalReactions_r_A_react(try_transition);;
		}
		return did_transition;
	}
	
	private boolean childFirstOrthogonalReactions_r_B_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;;
		}
		if (did_transition==false) {
		}
		return did_transition;
	}
	
	private boolean childFirstOrthogonalReactions_r2_C_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (sCInterface.operationCallback.check("C")) {
				exitSequence_ChildFirstOrthogonalReactions_r2_C();
				enterSequence_ChildFirstOrthogonalReactions_r2_D_default();
				react(false);
			} else {
				did_transition = false;;
			}
		}
		if (did_transition==false) {
			sCInterface.setC_local(sCInterface.operationCallback.next());
			
			did_transition = react(try_transition);;
		}
		return did_transition;
	}
	
	private boolean childFirstOrthogonalReactions_r2_D_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			did_transition = false;;
		}
		if (did_transition==false) {
			did_transition = react(try_transition);;
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
			case childFirstOrthogonalReactions_r_A_r_AA_r_AAA:
				childFirstOrthogonalReactions_r_A_r_AA_r_AAA_react(true);
				break;
			case childFirstOrthogonalReactions_r_A_r_AA__region1_AAC:
				childFirstOrthogonalReactions_r_A_r_AA__region1_AAC_react(true);
				break;
			case childFirstOrthogonalReactions_r_A_r2_AC:
				childFirstOrthogonalReactions_r_A_r2_AC_react(true);
				break;
			case childFirstOrthogonalReactions_r_B:
				childFirstOrthogonalReactions_r_B_react(true);
				break;
			case childFirstOrthogonalReactions_r2_C:
				childFirstOrthogonalReactions_r2_C_react(true);
				break;
			case childFirstOrthogonalReactions_r2_D:
				childFirstOrthogonalReactions_r2_D_react(true);
				break;
			default:
				// $NullState$
			}
		}
		clearEvents();
	}
}
