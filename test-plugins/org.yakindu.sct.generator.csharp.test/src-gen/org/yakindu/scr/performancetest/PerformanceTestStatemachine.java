package org.yakindu.scr.performancetest;
import org.yakindu.scr.ITimer;

public class PerformanceTestStatemachine
		implements
			IPerformanceTestStatemachine {
	private final boolean[] timeEvents = new boolean[2];

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		private boolean e2;

		public void raiseE2() {
			e2 = true;
		}

		private boolean e3;

		public void raiseE3() {
			e3 = true;
		}

		private long x;
		public long getX() {
			return x;
		}

		public void setX(long value) {
			this.x = value;
		}

		private long a;
		public long getA() {
			return a;
		}

		public void setA(long value) {
			this.a = value;
		}

		private long c;
		public long getC() {
			return c;
		}

		public void setC(long value) {
			this.c = value;
		}

		public void clearEvents() {
			e1 = false;
			e2 = false;
			e3 = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		mr_A, mr_B, mr_B_r1_X, mr_B_r1_Y, mr_B_r1_Z, mr_B_r1_V, mr_B_r1_W, mr_B_r1_S, mr_B_r1_T, mr_B_r1_U, mr_B_r2_S, mr_B_r2_T, mr_B_r2_U, mr_B_r2_V, mr_B_r2_W, $NullState$
	};

	private State[] historyVector = new State[1];
	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	private ITimer timer;

	public PerformanceTestStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		for (int i = 0; i < 1; i++) {
			historyVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();

		sCInterface.x = 0;

		sCInterface.a = 0;

		sCInterface.c = 0;
	}

	public void enter() {
		if (timer == null) {
			throw new IllegalStateException("timer not set.");
		}

		timer.setTimer(this, 0, 2000, true);

		timer.setTimer(this, 1, 6200, true);

		entryAction();

		enterSequence_mr_default();
	}

	public void exit() {
		exitSequence_mr();

		exitAction();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	@Override
	public boolean isActive() {

		return stateVector[0] != State.$NullState$
				|| stateVector[1] != State.$NullState$;
	}

	/** 
	 * Always returns 'false' since this state machine can never become final.
	 *
	 * @see IStatemachine#isFinal() 
	 */
	@Override
	public boolean isFinal() {
		return false;
	}

	/**
	 * This method resets the incoming events (time events included).
	 */
	protected void clearEvents() {
		sCInterface.clearEvents();

		for (int i = 0; i < timeEvents.length; i++) {
			timeEvents[i] = false;
		}
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
			case mr_A :
				return stateVector[0] == State.mr_A;
			case mr_B :
				return stateVector[0].ordinal() >= State.mr_B.ordinal()
						&& stateVector[0].ordinal() <= State.mr_B_r2_W
								.ordinal();
			case mr_B_r1_X :
				return stateVector[0] == State.mr_B_r1_X;
			case mr_B_r1_Y :
				return stateVector[0] == State.mr_B_r1_Y;
			case mr_B_r1_Z :
				return stateVector[0] == State.mr_B_r1_Z;
			case mr_B_r1_V :
				return stateVector[0] == State.mr_B_r1_V;
			case mr_B_r1_W :
				return stateVector[0] == State.mr_B_r1_W;
			case mr_B_r1_S :
				return stateVector[0] == State.mr_B_r1_S;
			case mr_B_r1_T :
				return stateVector[0] == State.mr_B_r1_T;
			case mr_B_r1_U :
				return stateVector[0] == State.mr_B_r1_U;
			case mr_B_r2_S :
				return stateVector[1] == State.mr_B_r2_S;
			case mr_B_r2_T :
				return stateVector[1] == State.mr_B_r2_T;
			case mr_B_r2_U :
				return stateVector[1] == State.mr_B_r2_U;
			case mr_B_r2_V :
				return stateVector[1] == State.mr_B_r2_V;
			case mr_B_r2_W :
				return stateVector[1] == State.mr_B_r2_W;
			default :
				return false;
		}
	}

	/**
	 * Set the {@link ITimer} for the state machine. It must be set
	 * externally on a timed state machine before a run cycle can be correct
	 * executed.
	 * 
	 * @param timer
	 */
	public void setTimer(ITimer timer) {
		this.timer = timer;
	}

	/**
	 * Returns the currently used timer.
	 * 
	 * @return {@link ITimer}
	 */
	public ITimer getTimer() {
		return timer;
	}

	public void timeElapsed(int eventID) {
		timeEvents[eventID] = true;
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseE1() {
		sCInterface.raiseE1();
	}
	public void raiseE2() {
		sCInterface.raiseE2();
	}
	public void raiseE3() {
		sCInterface.raiseE3();
	}

	public long getX() {
		return sCInterface.getX();
	}

	public void setX(long value) {
		sCInterface.setX(value);
	}
	public long getA() {
		return sCInterface.getA();
	}

	public void setA(long value) {
		sCInterface.setA(value);
	}
	public long getC() {
		return sCInterface.getC();
	}

	public void setC(long value) {
		sCInterface.setC(value);
	}

	private boolean check__lr0() {
		return true;
	}

	private boolean check__lr1() {
		return timeEvents[0];
	}

	private boolean check__lr2() {
		return timeEvents[1];
	}

	private boolean check_mr_A_tr0_tr0() {
		return sCInterface.e1;
	}

	private boolean check_mr_B_r1_X_tr0_tr0() {
		return sCInterface.e2;
	}

	private boolean check_mr_B_r1_Y_tr0_tr0() {
		return sCInterface.e2;
	}

	private boolean check_mr_B_r1_Z_tr0_tr0() {
		return sCInterface.e2;
	}

	private boolean check_mr_B_r1_V_tr0_tr0() {
		return sCInterface.e2;
	}

	private boolean check_mr_B_r1_W_tr0_tr0() {
		return sCInterface.e2;
	}

	private boolean check_mr_B_r1_S_tr0_tr0() {
		return sCInterface.e2;
	}

	private boolean check_mr_B_r1_S_tr1_tr1() {
		return true && isStateActive(State.mr_B_r2_W) && sCInterface.e3;
	}

	private boolean check_mr_B_r1_T_tr0_tr0() {
		return sCInterface.e2;
	}

	private boolean check_mr_B_r1_U_tr0_tr0() {
		return sCInterface.e2;
	}

	private boolean check_mr_B_r2_S_tr0_tr0() {
		return sCInterface.e3;
	}

	private boolean check_mr_B_r2_T_tr0_tr0() {
		return sCInterface.e3;
	}

	private boolean check_mr_B_r2_U_tr0_tr0() {
		return sCInterface.e3;
	}

	private boolean check_mr_B_r2_U_tr1_tr1() {
		return sCInterface.e2;
	}

	private boolean check_mr_B_r2_V_tr0_tr0() {
		return sCInterface.e3;
	}

	private boolean check_mr_B_r2_V_tr1_tr1() {
		return sCInterface.e2;
	}

	private boolean check_mr_B_r2_W_tr0_tr0() {
		return sCInterface.e3 && isStateActive(State.mr_B_r1_S) && true;
	}

	private boolean check_mr_B_r1__choice_0_tr0_tr0() {
		return true;
	}

	private boolean check_mr_B_r1__choice_1_tr0_tr0() {
		return sCInterface.x == 4;
	}

	private boolean check_mr_B_r1__choice_1_tr1_tr1() {
		return sCInterface.x == 5;
	}

	private boolean check_mr_B_r1__choice_1_tr2_tr2() {
		return sCInterface.x == 6;
	}

	private boolean check_mr_B_r1__choice_1_tr3_tr3() {
		return sCInterface.x == 7;
	}

	private boolean check_mr_B_r1__choice_1_tr4_tr4() {
		return sCInterface.x == 8;
	}

	private boolean check_mr_B_r1__choice_1_tr5_tr5() {
		return sCInterface.x == 3;
	}

	private boolean check_mr_B_r1__choice_1_tr6_tr6() {
		return sCInterface.x == 2;
	}

	private boolean check_mr_B_r1__choice_1_tr7_tr7() {
		return true;
	}

	private void effect__lr0() {
		sCInterface.c += 1;
	}

	private void effect__lr1() {
		sCInterface.raiseE2();

		sCInterface.raiseE1();
	}

	private void effect__lr2() {
		sCInterface.raiseE3();
	}

	private void effect_mr_A_tr0() {
		exitSequence_mr_A();

		enterSequence_mr_B_default();
	}

	private void effect_mr_B_r1_X_tr0() {
		exitSequence_mr_B_r1_X();

		react_mr_B_r1__choice_0();
	}

	private void effect_mr_B_r1_Y_tr0() {
		exitSequence_mr_B_r1_Y();

		react_mr_B_r1__choice_0();
	}

	private void effect_mr_B_r1_Z_tr0() {
		exitSequence_mr_B_r1_Z();

		react_mr_B_r1__choice_0();
	}

	private void effect_mr_B_r1_V_tr0() {
		exitSequence_mr_B_r1_V();

		react_mr_B_r1__choice_0();
	}

	private void effect_mr_B_r1_W_tr0() {
		exitSequence_mr_B_r1_W();

		react_mr_B_r1__choice_0();
	}

	private void effect_mr_B_r1_S_tr0() {
		exitSequence_mr_B_r1_S();

		react_mr_B_r1__choice_0();
	}

	private void effect_mr_B_r1_S_tr1() {
		exitSequence_mr_B();

		react_mr__sync0();
	}

	private void effect_mr_B_r1_T_tr0() {
		exitSequence_mr_B_r1_T();

		react_mr_B_r1__choice_0();
	}

	private void effect_mr_B_r1_U_tr0() {
		exitSequence_mr_B_r1_U();

		react_mr_B_r1__choice_0();
	}

	private void effect_mr_B_r2_S_tr0() {
		exitSequence_mr_B_r2_S();

		enterSequence_mr_B_r2_T_default();
	}

	private void effect_mr_B_r2_T_tr0() {
		exitSequence_mr_B_r2_T();

		enterSequence_mr_B_r2_U_default();
	}

	private void effect_mr_B_r2_U_tr0() {
		exitSequence_mr_B_r2_U();

		enterSequence_mr_B_r2_V_default();
	}

	private void effect_mr_B_r2_U_tr1() {
		exitSequence_mr_B_r2_U();

		enterSequence_mr_B_r2_W_default();
	}

	private void effect_mr_B_r2_V_tr0() {
		exitSequence_mr_B_r2_V();

		enterSequence_mr_B_r2_W_default();
	}

	private void effect_mr_B_r2_V_tr1() {
		exitSequence_mr_B_r2_V();

		enterSequence_mr_B_r2_S_default();
	}

	private void effect_mr_B_r2_W_tr0() {
		exitSequence_mr_B();

		react_mr__sync0();
	}

	private void effect_mr_B_r1__choice_0_tr0() {
		sCInterface.x += 1;

		react_mr_B_r1__choice_1();
	}

	private void effect_mr_B_r1__choice_1_tr0() {
		enterSequence_mr_B_r1_V_default();
	}

	private void effect_mr_B_r1__choice_1_tr1() {
		enterSequence_mr_B_r1_W_default();
	}

	private void effect_mr_B_r1__choice_1_tr2() {
		enterSequence_mr_B_r1_X_default();
	}

	private void effect_mr_B_r1__choice_1_tr3() {
		enterSequence_mr_B_r1_Y_default();
	}

	private void effect_mr_B_r1__choice_1_tr4() {
		sCInterface.x = 0;

		enterSequence_mr_B_r1_Z_default();
	}

	private void effect_mr_B_r1__choice_1_tr5() {
		enterSequence_mr_B_r1_U_default();
	}

	private void effect_mr_B_r1__choice_1_tr6() {
		enterSequence_mr_B_r1_T_default();
	}

	private void effect_mr_B_r1__choice_1_tr7() {
		enterSequence_mr_B_r1_S_default();
	}

	/* Entry action for statechart 'PerformanceTest'. */
	private void entryAction() {

		timer.setTimer(this, 0, 2000, true);

		timer.setTimer(this, 1, 6200, true);
	}

	/* Entry action for state 'A'. */
	private void entryAction_mr_A() {
		sCInterface.a += 1;
	}

	/* Exit action for state 'PerformanceTest'. */
	private void exitAction() {
		timer.unsetTimer(this, 0);

		timer.unsetTimer(this, 1);
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_mr_A_default() {
		entryAction_mr_A();

		nextStateIndex = 0;
		stateVector[0] = State.mr_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequence_mr_B_default() {
		enterSequence_mr_B_r1_default();

		enterSequence_mr_B_r2_default();
	}

	/* 'default' enter sequence for state X */
	private void enterSequence_mr_B_r1_X_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_X;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state Y */
	private void enterSequence_mr_B_r1_Y_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_Y;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state Z */
	private void enterSequence_mr_B_r1_Z_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_Z;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state V */
	private void enterSequence_mr_B_r1_V_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_V;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state W */
	private void enterSequence_mr_B_r1_W_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_W;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state S */
	private void enterSequence_mr_B_r1_S_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_S;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state T */
	private void enterSequence_mr_B_r1_T_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_T;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state U */
	private void enterSequence_mr_B_r1_U_default() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_U;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state S */
	private void enterSequence_mr_B_r2_S_default() {
		nextStateIndex = 1;
		stateVector[1] = State.mr_B_r2_S;
	}

	/* 'default' enter sequence for state T */
	private void enterSequence_mr_B_r2_T_default() {
		nextStateIndex = 1;
		stateVector[1] = State.mr_B_r2_T;
	}

	/* 'default' enter sequence for state U */
	private void enterSequence_mr_B_r2_U_default() {
		nextStateIndex = 1;
		stateVector[1] = State.mr_B_r2_U;
	}

	/* 'default' enter sequence for state V */
	private void enterSequence_mr_B_r2_V_default() {
		nextStateIndex = 1;
		stateVector[1] = State.mr_B_r2_V;
	}

	/* 'default' enter sequence for state W */
	private void enterSequence_mr_B_r2_W_default() {
		nextStateIndex = 1;
		stateVector[1] = State.mr_B_r2_W;
	}

	/* 'default' enter sequence for region mr */
	private void enterSequence_mr_default() {
		react_mr__entry_Default();
	}

	/* 'default' enter sequence for region r1 */
	private void enterSequence_mr_B_r1_default() {
		react_mr_B_r1__entry_Default();
	}

	/* shallow enterSequence with history in child r1 */
	private void shallowEnterSequence_mr_B_r1() {
		switch (historyVector[0]) {
			case mr_B_r1_X :
				enterSequence_mr_B_r1_X_default();
				break;

			case mr_B_r1_Y :
				enterSequence_mr_B_r1_Y_default();
				break;

			case mr_B_r1_Z :
				enterSequence_mr_B_r1_Z_default();
				break;

			case mr_B_r1_V :
				enterSequence_mr_B_r1_V_default();
				break;

			case mr_B_r1_W :
				enterSequence_mr_B_r1_W_default();
				break;

			case mr_B_r1_S :
				enterSequence_mr_B_r1_S_default();
				break;

			case mr_B_r1_T :
				enterSequence_mr_B_r1_T_default();
				break;

			case mr_B_r1_U :
				enterSequence_mr_B_r1_U_default();
				break;

			default :
				break;
		}
	}

	/* 'default' enter sequence for region r2 */
	private void enterSequence_mr_B_r2_default() {
		react_mr_B_r2__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequence_mr_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequence_mr_B() {
		exitSequence_mr_B_r1();

		exitSequence_mr_B_r2();
	}

	/* Default exit sequence for state X */
	private void exitSequence_mr_B_r1_X() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Y */
	private void exitSequence_mr_B_r1_Y() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Z */
	private void exitSequence_mr_B_r1_Z() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state V */
	private void exitSequence_mr_B_r1_V() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state W */
	private void exitSequence_mr_B_r1_W() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state S */
	private void exitSequence_mr_B_r1_S() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state T */
	private void exitSequence_mr_B_r1_T() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state U */
	private void exitSequence_mr_B_r1_U() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state S */
	private void exitSequence_mr_B_r2_S() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state T */
	private void exitSequence_mr_B_r2_T() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state U */
	private void exitSequence_mr_B_r2_U() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state V */
	private void exitSequence_mr_B_r2_V() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state W */
	private void exitSequence_mr_B_r2_W() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region mr */
	private void exitSequence_mr() {
		switch (stateVector[0]) {
			case mr_A :
				exitSequence_mr_A();
				break;

			case mr_B_r1_X :
				exitSequence_mr_B_r1_X();
				break;

			case mr_B_r1_Y :
				exitSequence_mr_B_r1_Y();
				break;

			case mr_B_r1_Z :
				exitSequence_mr_B_r1_Z();
				break;

			case mr_B_r1_V :
				exitSequence_mr_B_r1_V();
				break;

			case mr_B_r1_W :
				exitSequence_mr_B_r1_W();
				break;

			case mr_B_r1_S :
				exitSequence_mr_B_r1_S();
				break;

			case mr_B_r1_T :
				exitSequence_mr_B_r1_T();
				break;

			case mr_B_r1_U :
				exitSequence_mr_B_r1_U();
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case mr_B_r2_S :
				exitSequence_mr_B_r2_S();
				break;

			case mr_B_r2_T :
				exitSequence_mr_B_r2_T();
				break;

			case mr_B_r2_U :
				exitSequence_mr_B_r2_U();
				break;

			case mr_B_r2_V :
				exitSequence_mr_B_r2_V();
				break;

			case mr_B_r2_W :
				exitSequence_mr_B_r2_W();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r1 */
	private void exitSequence_mr_B_r1() {
		switch (stateVector[0]) {
			case mr_B_r1_X :
				exitSequence_mr_B_r1_X();
				break;

			case mr_B_r1_Y :
				exitSequence_mr_B_r1_Y();
				break;

			case mr_B_r1_Z :
				exitSequence_mr_B_r1_Z();
				break;

			case mr_B_r1_V :
				exitSequence_mr_B_r1_V();
				break;

			case mr_B_r1_W :
				exitSequence_mr_B_r1_W();
				break;

			case mr_B_r1_S :
				exitSequence_mr_B_r1_S();
				break;

			case mr_B_r1_T :
				exitSequence_mr_B_r1_T();
				break;

			case mr_B_r1_U :
				exitSequence_mr_B_r1_U();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r2 */
	private void exitSequence_mr_B_r2() {
		switch (stateVector[1]) {
			case mr_B_r2_S :
				exitSequence_mr_B_r2_S();
				break;

			case mr_B_r2_T :
				exitSequence_mr_B_r2_T();
				break;

			case mr_B_r2_U :
				exitSequence_mr_B_r2_U();
				break;

			case mr_B_r2_V :
				exitSequence_mr_B_r2_V();
				break;

			case mr_B_r2_W :
				exitSequence_mr_B_r2_W();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void react_mr_A() {
		effect__lr0();

		if (check__lr1()) {
			effect__lr1();
		}

		if (check__lr2()) {
			effect__lr2();
		}

		if (check_mr_A_tr0_tr0()) {
			effect_mr_A_tr0();
		}
	}

	/* The reactions of state X. */
	private void react_mr_B_r1_X() {
		effect__lr0();

		if (check__lr1()) {
			effect__lr1();
		}

		if (check__lr2()) {
			effect__lr2();
		}

		if (check_mr_B_r1_X_tr0_tr0()) {
			effect_mr_B_r1_X_tr0();
		}
	}

	/* The reactions of state Y. */
	private void react_mr_B_r1_Y() {
		effect__lr0();

		if (check__lr1()) {
			effect__lr1();
		}

		if (check__lr2()) {
			effect__lr2();
		}

		if (check_mr_B_r1_Y_tr0_tr0()) {
			effect_mr_B_r1_Y_tr0();
		}
	}

	/* The reactions of state Z. */
	private void react_mr_B_r1_Z() {
		effect__lr0();

		if (check__lr1()) {
			effect__lr1();
		}

		if (check__lr2()) {
			effect__lr2();
		}

		if (check_mr_B_r1_Z_tr0_tr0()) {
			effect_mr_B_r1_Z_tr0();
		}
	}

	/* The reactions of state V. */
	private void react_mr_B_r1_V() {
		effect__lr0();

		if (check__lr1()) {
			effect__lr1();
		}

		if (check__lr2()) {
			effect__lr2();
		}

		if (check_mr_B_r1_V_tr0_tr0()) {
			effect_mr_B_r1_V_tr0();
		}
	}

	/* The reactions of state W. */
	private void react_mr_B_r1_W() {
		effect__lr0();

		if (check__lr1()) {
			effect__lr1();
		}

		if (check__lr2()) {
			effect__lr2();
		}

		if (check_mr_B_r1_W_tr0_tr0()) {
			effect_mr_B_r1_W_tr0();
		}
	}

	/* The reactions of state S. */
	private void react_mr_B_r1_S() {
		effect__lr0();

		if (check__lr1()) {
			effect__lr1();
		}

		if (check__lr2()) {
			effect__lr2();
		}

		if (check_mr_B_r1_S_tr0_tr0()) {
			effect_mr_B_r1_S_tr0();
		} else {
			if (check_mr_B_r1_S_tr1_tr1()) {
				effect_mr_B_r1_S_tr1();
			}
		}
	}

	/* The reactions of state T. */
	private void react_mr_B_r1_T() {
		effect__lr0();

		if (check__lr1()) {
			effect__lr1();
		}

		if (check__lr2()) {
			effect__lr2();
		}

		if (check_mr_B_r1_T_tr0_tr0()) {
			effect_mr_B_r1_T_tr0();
		}
	}

	/* The reactions of state U. */
	private void react_mr_B_r1_U() {
		effect__lr0();

		if (check__lr1()) {
			effect__lr1();
		}

		if (check__lr2()) {
			effect__lr2();
		}

		if (check_mr_B_r1_U_tr0_tr0()) {
			effect_mr_B_r1_U_tr0();
		}
	}

	/* The reactions of state S. */
	private void react_mr_B_r2_S() {
		if (check_mr_B_r2_S_tr0_tr0()) {
			effect_mr_B_r2_S_tr0();
		}
	}

	/* The reactions of state T. */
	private void react_mr_B_r2_T() {
		if (check_mr_B_r2_T_tr0_tr0()) {
			effect_mr_B_r2_T_tr0();
		}
	}

	/* The reactions of state U. */
	private void react_mr_B_r2_U() {
		if (check_mr_B_r2_U_tr0_tr0()) {
			effect_mr_B_r2_U_tr0();
		} else {
			if (check_mr_B_r2_U_tr1_tr1()) {
				effect_mr_B_r2_U_tr1();
			}
		}
	}

	/* The reactions of state V. */
	private void react_mr_B_r2_V() {
		if (check_mr_B_r2_V_tr0_tr0()) {
			effect_mr_B_r2_V_tr0();
		} else {
			if (check_mr_B_r2_V_tr1_tr1()) {
				effect_mr_B_r2_V_tr1();
			}
		}
	}

	/* The reactions of state W. */
	private void react_mr_B_r2_W() {
		if (check_mr_B_r2_W_tr0_tr0()) {
			effect_mr_B_r2_W_tr0();
		}
	}

	/* The reactions of state null. */
	private void react_mr_B_r1__choice_0() {
		effect_mr_B_r1__choice_0_tr0();
	}

	/* The reactions of state null. */
	private void react_mr_B_r1__choice_1() {
		if (check_mr_B_r1__choice_1_tr0_tr0()) {
			effect_mr_B_r1__choice_1_tr0();
		} else {
			if (check_mr_B_r1__choice_1_tr1_tr1()) {
				effect_mr_B_r1__choice_1_tr1();
			} else {
				if (check_mr_B_r1__choice_1_tr2_tr2()) {
					effect_mr_B_r1__choice_1_tr2();
				} else {
					if (check_mr_B_r1__choice_1_tr3_tr3()) {
						effect_mr_B_r1__choice_1_tr3();
					} else {
						if (check_mr_B_r1__choice_1_tr4_tr4()) {
							effect_mr_B_r1__choice_1_tr4();
						} else {
							if (check_mr_B_r1__choice_1_tr5_tr5()) {
								effect_mr_B_r1__choice_1_tr5();
							} else {
								if (check_mr_B_r1__choice_1_tr6_tr6()) {
									effect_mr_B_r1__choice_1_tr6();
								} else {
									effect_mr_B_r1__choice_1_tr7();
								}
							}
						}
					}
				}
			}
		}
	}

	/* Default react sequence for initial entry  */
	private void react_mr__entry_Default() {
		enterSequence_mr_A_default();
	}

	/* Default react sequence for shallow history entry  */
	private void react_mr_B_r1__entry_Default() {
		/* Enter the region with shallow history */
		if (historyVector[0] != State.$NullState$) {
			shallowEnterSequence_mr_B_r1();
		} else {
			enterSequence_mr_B_r1_S_default();
		}
	}

	/* Default react sequence for initial entry  */
	private void react_mr_B_r2__entry_Default() {
		enterSequence_mr_B_r2_S_default();
	}

	/* The reactions of state null. */
	private void react_mr__sync0() {
		enterSequence_mr_A_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case mr_A :
					react_mr_A();
					break;
				case mr_B_r1_X :
					react_mr_B_r1_X();
					break;
				case mr_B_r1_Y :
					react_mr_B_r1_Y();
					break;
				case mr_B_r1_Z :
					react_mr_B_r1_Z();
					break;
				case mr_B_r1_V :
					react_mr_B_r1_V();
					break;
				case mr_B_r1_W :
					react_mr_B_r1_W();
					break;
				case mr_B_r1_S :
					react_mr_B_r1_S();
					break;
				case mr_B_r1_T :
					react_mr_B_r1_T();
					break;
				case mr_B_r1_U :
					react_mr_B_r1_U();
					break;
				case mr_B_r2_S :
					react_mr_B_r2_S();
					break;
				case mr_B_r2_T :
					react_mr_B_r2_T();
					break;
				case mr_B_r2_U :
					react_mr_B_r2_U();
					break;
				case mr_B_r2_V :
					react_mr_B_r2_V();
					break;
				case mr_B_r2_W :
					react_mr_B_r2_W();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
