package org.yakindu.scr.performancetest;
import org.yakindu.scr.ITimer;

public class PerformanceTestStatemachine
		implements
			IPerformanceTestStatemachine {

	static {
	}

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

		enterSequenceMr();
	}

	public void exit() {
		exitSequenceMr();

		exitAction();
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

	private boolean checkLr0() {
		return true;
	}

	private boolean checkLr1() {
		return timeEvents[0];
	}

	private boolean checkLr2() {
		return timeEvents[1];
	}

	private boolean checkMr_ATr0() {
		return sCInterface.e1;
	}

	private boolean checkMr_B_r1_XTr0() {
		return sCInterface.e2;
	}

	private boolean checkMr_B_r1_YTr0() {
		return sCInterface.e2;
	}

	private boolean checkMr_B_r1_ZTr0() {
		return sCInterface.e2;
	}

	private boolean checkMr_B_r1_VTr0() {
		return sCInterface.e2;
	}

	private boolean checkMr_B_r1_WTr0() {
		return sCInterface.e2;
	}

	private boolean checkMr_B_r1_STr0() {
		return sCInterface.e2;
	}

	private boolean checkMr_B_r1_STr1() {
		return true && isStateActive(State.mr_B_r2_W) && sCInterface.e3;
	}

	private boolean checkMr_B_r1_TTr0() {
		return sCInterface.e2;
	}

	private boolean checkMr_B_r1_UTr0() {
		return sCInterface.e2;
	}

	private boolean checkMr_B_r2_STr0() {
		return sCInterface.e3;
	}

	private boolean checkMr_B_r2_TTr0() {
		return sCInterface.e3;
	}

	private boolean checkMr_B_r2_UTr0() {
		return sCInterface.e3;
	}

	private boolean checkMr_B_r2_UTr1() {
		return sCInterface.e2;
	}

	private boolean checkMr_B_r2_VTr0() {
		return sCInterface.e3;
	}

	private boolean checkMr_B_r2_VTr1() {
		return sCInterface.e2;
	}

	private boolean checkMr_B_r2_WTr0() {
		return sCInterface.e3 && isStateActive(State.mr_B_r1_S) && true;
	}

	private boolean checkPerformanceTest_mr_B_r1__choice_0Tr0() {
		return true;
	}

	private boolean checkPerformanceTest_mr_B_r1__choice_1Tr0() {
		return sCInterface.x == 4;
	}

	private boolean checkPerformanceTest_mr_B_r1__choice_1Tr1() {
		return sCInterface.x == 5;
	}

	private boolean checkPerformanceTest_mr_B_r1__choice_1Tr2() {
		return sCInterface.x == 6;
	}

	private boolean checkPerformanceTest_mr_B_r1__choice_1Tr3() {
		return sCInterface.x == 7;
	}

	private boolean checkPerformanceTest_mr_B_r1__choice_1Tr4() {
		return sCInterface.x == 8;
	}

	private boolean checkPerformanceTest_mr_B_r1__choice_1Tr5() {
		return sCInterface.x == 3;
	}

	private boolean checkPerformanceTest_mr_B_r1__choice_1Tr6() {
		return sCInterface.x == 2;
	}

	private boolean checkPerformanceTest_mr_B_r1__choice_1Tr7() {
		return true;
	}

	private void effectLr0() {
		sCInterface.c += 1;
	}

	private void effectLr1() {
		sCInterface.raiseE2();

		sCInterface.raiseE1();
	}

	private void effectLr2() {
		sCInterface.raiseE3();
	}

	private void effectMr_ATr0() {
		exitSequenceMr_A();

		enterSequenceMr_B();
	}

	private void effectMr_B_r1_XTr0() {
		exitSequenceMr_B_r1_X();

		reactPerformanceTest_mr_B_r1__choice_0();
	}

	private void effectMr_B_r1_YTr0() {
		exitSequenceMr_B_r1_Y();

		reactPerformanceTest_mr_B_r1__choice_0();
	}

	private void effectMr_B_r1_ZTr0() {
		exitSequenceMr_B_r1_Z();

		reactPerformanceTest_mr_B_r1__choice_0();
	}

	private void effectMr_B_r1_VTr0() {
		exitSequenceMr_B_r1_V();

		reactPerformanceTest_mr_B_r1__choice_0();
	}

	private void effectMr_B_r1_WTr0() {
		exitSequenceMr_B_r1_W();

		reactPerformanceTest_mr_B_r1__choice_0();
	}

	private void effectMr_B_r1_STr0() {
		exitSequenceMr_B_r1_S();

		reactPerformanceTest_mr_B_r1__choice_0();
	}

	private void effectMr_B_r1_STr1() {
		exitSequenceMr_B();

		reactPerformanceTest_mr__sync0();
	}

	private void effectMr_B_r1_TTr0() {
		exitSequenceMr_B_r1_T();

		reactPerformanceTest_mr_B_r1__choice_0();
	}

	private void effectMr_B_r1_UTr0() {
		exitSequenceMr_B_r1_U();

		reactPerformanceTest_mr_B_r1__choice_0();
	}

	private void effectMr_B_r2_STr0() {
		exitSequenceMr_B_r2_S();

		enterSequenceMr_B_r2_T();
	}

	private void effectMr_B_r2_TTr0() {
		exitSequenceMr_B_r2_T();

		enterSequenceMr_B_r2_U();
	}

	private void effectMr_B_r2_UTr0() {
		exitSequenceMr_B_r2_U();

		enterSequenceMr_B_r2_V();
	}

	private void effectMr_B_r2_UTr1() {
		exitSequenceMr_B_r2_U();

		enterSequenceMr_B_r2_W();
	}

	private void effectMr_B_r2_VTr0() {
		exitSequenceMr_B_r2_V();

		enterSequenceMr_B_r2_W();
	}

	private void effectMr_B_r2_VTr1() {
		exitSequenceMr_B_r2_V();

		enterSequenceMr_B_r2_S();
	}

	private void effectMr_B_r2_WTr0() {
		exitSequenceMr_B();

		reactPerformanceTest_mr__sync0();
	}

	private void effectPerformanceTest_mr_B_r1__choice_0Tr0() {
		sCInterface.x += 1;

		reactPerformanceTest_mr_B_r1__choice_1();
	}

	private void effectPerformanceTest_mr_B_r1__choice_1Tr0() {
		enterSequenceMr_B_r1_V();
	}

	private void effectPerformanceTest_mr_B_r1__choice_1Tr1() {
		enterSequenceMr_B_r1_W();
	}

	private void effectPerformanceTest_mr_B_r1__choice_1Tr2() {
		enterSequenceMr_B_r1_X();
	}

	private void effectPerformanceTest_mr_B_r1__choice_1Tr3() {
		enterSequenceMr_B_r1_Y();
	}

	private void effectPerformanceTest_mr_B_r1__choice_1Tr4() {
		sCInterface.x = 0;

		enterSequenceMr_B_r1_Z();
	}

	private void effectPerformanceTest_mr_B_r1__choice_1Tr5() {
		enterSequenceMr_B_r1_U();
	}

	private void effectPerformanceTest_mr_B_r1__choice_1Tr6() {
		enterSequenceMr_B_r1_T();
	}

	private void effectPerformanceTest_mr_B_r1__choice_1Tr7() {
		enterSequenceMr_B_r1_S();
	}

	/* Entry action for statechart 'PerformanceTest'. */
	private void entryAction() {

		timer.setTimer(this, 0, 2000, true);

		timer.setTimer(this, 1, 6200, true);
	}

	/* Entry action for state 'A'. */
	private void entryActionMr_A() {
		sCInterface.a += 1;
	}

	/* Exit action for state 'PerformanceTest'. */
	private void exitAction() {
		timer.unsetTimer(this, 0);

		timer.unsetTimer(this, 1);
	}

	/* 'default' enter sequence for state A */
	private void enterSequenceMr_A() {
		entryActionMr_A();

		nextStateIndex = 0;
		stateVector[0] = State.mr_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequenceMr_B() {
		enterSequenceMr_B_r1();

		enterSequenceMr_B_r2();
	}

	/* 'default' enter sequence for state X */
	private void enterSequenceMr_B_r1_X() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_X;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state Y */
	private void enterSequenceMr_B_r1_Y() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_Y;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state Z */
	private void enterSequenceMr_B_r1_Z() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_Z;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state V */
	private void enterSequenceMr_B_r1_V() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_V;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state W */
	private void enterSequenceMr_B_r1_W() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_W;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state S */
	private void enterSequenceMr_B_r1_S() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_S;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state T */
	private void enterSequenceMr_B_r1_T() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_T;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state U */
	private void enterSequenceMr_B_r1_U() {
		nextStateIndex = 0;
		stateVector[0] = State.mr_B_r1_U;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state S */
	private void enterSequenceMr_B_r2_S() {
		nextStateIndex = 1;
		stateVector[1] = State.mr_B_r2_S;
	}

	/* 'default' enter sequence for state T */
	private void enterSequenceMr_B_r2_T() {
		nextStateIndex = 1;
		stateVector[1] = State.mr_B_r2_T;
	}

	/* 'default' enter sequence for state U */
	private void enterSequenceMr_B_r2_U() {
		nextStateIndex = 1;
		stateVector[1] = State.mr_B_r2_U;
	}

	/* 'default' enter sequence for state V */
	private void enterSequenceMr_B_r2_V() {
		nextStateIndex = 1;
		stateVector[1] = State.mr_B_r2_V;
	}

	/* 'default' enter sequence for state W */
	private void enterSequenceMr_B_r2_W() {
		nextStateIndex = 1;
		stateVector[1] = State.mr_B_r2_W;
	}

	/* 'default' enter sequence for region mr */
	private void enterSequenceMr() {
		reactPerformanceTest_mr__entry_Default();
	}

	/* 'default' enter sequence for region r1 */
	private void enterSequenceMr_B_r1() {
		reactPerformanceTest_mr_B_r1__entry_Default();
	}

	/* shallow enterSequence with history in child r1 */
	private void shallowEnterSequenceMr_B_r1() {
		switch (historyVector[0]) {
			case mr_B_r1_X :
				enterSequenceMr_B_r1_X();
				break;

			case mr_B_r1_Y :
				enterSequenceMr_B_r1_Y();
				break;

			case mr_B_r1_Z :
				enterSequenceMr_B_r1_Z();
				break;

			case mr_B_r1_V :
				enterSequenceMr_B_r1_V();
				break;

			case mr_B_r1_W :
				enterSequenceMr_B_r1_W();
				break;

			case mr_B_r1_S :
				enterSequenceMr_B_r1_S();
				break;

			case mr_B_r1_T :
				enterSequenceMr_B_r1_T();
				break;

			case mr_B_r1_U :
				enterSequenceMr_B_r1_U();
				break;

			default :
				break;
		}
	}

	/* 'default' enter sequence for region r2 */
	private void enterSequenceMr_B_r2() {
		reactPerformanceTest_mr_B_r2__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequenceMr_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequenceMr_B() {
		exitSequenceMr_B_r1();

		exitSequenceMr_B_r2();
	}

	/* Default exit sequence for state X */
	private void exitSequenceMr_B_r1_X() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Y */
	private void exitSequenceMr_B_r1_Y() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Z */
	private void exitSequenceMr_B_r1_Z() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state V */
	private void exitSequenceMr_B_r1_V() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state W */
	private void exitSequenceMr_B_r1_W() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state S */
	private void exitSequenceMr_B_r1_S() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state T */
	private void exitSequenceMr_B_r1_T() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state U */
	private void exitSequenceMr_B_r1_U() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state S */
	private void exitSequenceMr_B_r2_S() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state T */
	private void exitSequenceMr_B_r2_T() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state U */
	private void exitSequenceMr_B_r2_U() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state V */
	private void exitSequenceMr_B_r2_V() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state W */
	private void exitSequenceMr_B_r2_W() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region mr */
	private void exitSequenceMr() {
		switch (stateVector[0]) {
			case mr_A :
				exitSequenceMr_A();
				break;

			case mr_B_r1_X :
				exitSequenceMr_B_r1_X();
				break;

			case mr_B_r1_Y :
				exitSequenceMr_B_r1_Y();
				break;

			case mr_B_r1_Z :
				exitSequenceMr_B_r1_Z();
				break;

			case mr_B_r1_V :
				exitSequenceMr_B_r1_V();
				break;

			case mr_B_r1_W :
				exitSequenceMr_B_r1_W();
				break;

			case mr_B_r1_S :
				exitSequenceMr_B_r1_S();
				break;

			case mr_B_r1_T :
				exitSequenceMr_B_r1_T();
				break;

			case mr_B_r1_U :
				exitSequenceMr_B_r1_U();
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case mr_B_r2_S :
				exitSequenceMr_B_r2_S();
				break;

			case mr_B_r2_T :
				exitSequenceMr_B_r2_T();
				break;

			case mr_B_r2_U :
				exitSequenceMr_B_r2_U();
				break;

			case mr_B_r2_V :
				exitSequenceMr_B_r2_V();
				break;

			case mr_B_r2_W :
				exitSequenceMr_B_r2_W();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r1 */
	private void exitSequenceMr_B_r1() {
		switch (stateVector[0]) {
			case mr_B_r1_X :
				exitSequenceMr_B_r1_X();
				break;

			case mr_B_r1_Y :
				exitSequenceMr_B_r1_Y();
				break;

			case mr_B_r1_Z :
				exitSequenceMr_B_r1_Z();
				break;

			case mr_B_r1_V :
				exitSequenceMr_B_r1_V();
				break;

			case mr_B_r1_W :
				exitSequenceMr_B_r1_W();
				break;

			case mr_B_r1_S :
				exitSequenceMr_B_r1_S();
				break;

			case mr_B_r1_T :
				exitSequenceMr_B_r1_T();
				break;

			case mr_B_r1_U :
				exitSequenceMr_B_r1_U();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region r2 */
	private void exitSequenceMr_B_r2() {
		switch (stateVector[1]) {
			case mr_B_r2_S :
				exitSequenceMr_B_r2_S();
				break;

			case mr_B_r2_T :
				exitSequenceMr_B_r2_T();
				break;

			case mr_B_r2_U :
				exitSequenceMr_B_r2_U();
				break;

			case mr_B_r2_V :
				exitSequenceMr_B_r2_V();
				break;

			case mr_B_r2_W :
				exitSequenceMr_B_r2_W();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void reactMr_A() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (checkMr_ATr0()) {
			effectMr_ATr0();
		}
	}

	/* The reactions of state X. */
	private void reactMr_B_r1_X() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (checkMr_B_r1_XTr0()) {
			effectMr_B_r1_XTr0();
		}
	}

	/* The reactions of state Y. */
	private void reactMr_B_r1_Y() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (checkMr_B_r1_YTr0()) {
			effectMr_B_r1_YTr0();
		}
	}

	/* The reactions of state Z. */
	private void reactMr_B_r1_Z() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (checkMr_B_r1_ZTr0()) {
			effectMr_B_r1_ZTr0();
		}
	}

	/* The reactions of state V. */
	private void reactMr_B_r1_V() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (checkMr_B_r1_VTr0()) {
			effectMr_B_r1_VTr0();
		}
	}

	/* The reactions of state W. */
	private void reactMr_B_r1_W() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (checkMr_B_r1_WTr0()) {
			effectMr_B_r1_WTr0();
		}
	}

	/* The reactions of state S. */
	private void reactMr_B_r1_S() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (checkMr_B_r1_STr0()) {
			effectMr_B_r1_STr0();
		} else {
			if (checkMr_B_r1_STr1()) {
				effectMr_B_r1_STr1();
			}
		}
	}

	/* The reactions of state T. */
	private void reactMr_B_r1_T() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (checkMr_B_r1_TTr0()) {
			effectMr_B_r1_TTr0();
		}
	}

	/* The reactions of state U. */
	private void reactMr_B_r1_U() {
		effectLr0();

		if (checkLr1()) {
			effectLr1();
		}

		if (checkLr2()) {
			effectLr2();
		}

		if (checkMr_B_r1_UTr0()) {
			effectMr_B_r1_UTr0();
		}
	}

	/* The reactions of state S. */
	private void reactMr_B_r2_S() {
		if (checkMr_B_r2_STr0()) {
			effectMr_B_r2_STr0();
		}
	}

	/* The reactions of state T. */
	private void reactMr_B_r2_T() {
		if (checkMr_B_r2_TTr0()) {
			effectMr_B_r2_TTr0();
		}
	}

	/* The reactions of state U. */
	private void reactMr_B_r2_U() {
		if (checkMr_B_r2_UTr0()) {
			effectMr_B_r2_UTr0();
		} else {
			if (checkMr_B_r2_UTr1()) {
				effectMr_B_r2_UTr1();
			}
		}
	}

	/* The reactions of state V. */
	private void reactMr_B_r2_V() {
		if (checkMr_B_r2_VTr0()) {
			effectMr_B_r2_VTr0();
		} else {
			if (checkMr_B_r2_VTr1()) {
				effectMr_B_r2_VTr1();
			}
		}
	}

	/* The reactions of state W. */
	private void reactMr_B_r2_W() {
		if (checkMr_B_r2_WTr0()) {
			effectMr_B_r2_WTr0();
		}
	}

	/* The reactions of state null. */
	private void reactPerformanceTest_mr_B_r1__choice_0() {
		effectPerformanceTest_mr_B_r1__choice_0Tr0();
	}

	/* The reactions of state null. */
	private void reactPerformanceTest_mr_B_r1__choice_1() {
		if (checkPerformanceTest_mr_B_r1__choice_1Tr0()) {
			effectPerformanceTest_mr_B_r1__choice_1Tr0();
		} else {
			if (checkPerformanceTest_mr_B_r1__choice_1Tr1()) {
				effectPerformanceTest_mr_B_r1__choice_1Tr1();
			} else {
				if (checkPerformanceTest_mr_B_r1__choice_1Tr2()) {
					effectPerformanceTest_mr_B_r1__choice_1Tr2();
				} else {
					if (checkPerformanceTest_mr_B_r1__choice_1Tr3()) {
						effectPerformanceTest_mr_B_r1__choice_1Tr3();
					} else {
						if (checkPerformanceTest_mr_B_r1__choice_1Tr4()) {
							effectPerformanceTest_mr_B_r1__choice_1Tr4();
						} else {
							if (checkPerformanceTest_mr_B_r1__choice_1Tr5()) {
								effectPerformanceTest_mr_B_r1__choice_1Tr5();
							} else {
								if (checkPerformanceTest_mr_B_r1__choice_1Tr6()) {
									effectPerformanceTest_mr_B_r1__choice_1Tr6();
								} else {
									effectPerformanceTest_mr_B_r1__choice_1Tr7();
								}
							}
						}
					}
				}
			}
		}
	}

	/* Default react sequence for initial entry  */
	private void reactPerformanceTest_mr__entry_Default() {
		enterSequenceMr_A();
	}

	/* Default react sequence for shallow history entry  */
	private void reactPerformanceTest_mr_B_r1__entry_Default() {
		/* Enter the region with shallow history */
		if (historyVector[0] != State.$NullState$) {
			shallowEnterSequenceMr_B_r1();
		} else {
			enterSequenceMr_B_r1_S();
		}
	}

	/* Default react sequence for initial entry  */
	private void reactPerformanceTest_mr_B_r2__entry_Default() {
		enterSequenceMr_B_r2_S();
	}

	/* The reactions of state null. */
	private void reactPerformanceTest_mr__sync0() {
		enterSequenceMr_A();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case mr_A :
					reactMr_A();
					break;
				case mr_B_r1_X :
					reactMr_B_r1_X();
					break;
				case mr_B_r1_Y :
					reactMr_B_r1_Y();
					break;
				case mr_B_r1_Z :
					reactMr_B_r1_Z();
					break;
				case mr_B_r1_V :
					reactMr_B_r1_V();
					break;
				case mr_B_r1_W :
					reactMr_B_r1_W();
					break;
				case mr_B_r1_S :
					reactMr_B_r1_S();
					break;
				case mr_B_r1_T :
					reactMr_B_r1_T();
					break;
				case mr_B_r1_U :
					reactMr_B_r1_U();
					break;
				case mr_B_r2_S :
					reactMr_B_r2_S();
					break;
				case mr_B_r2_T :
					reactMr_B_r2_T();
					break;
				case mr_B_r2_U :
					reactMr_B_r2_U();
					break;
				case mr_B_r2_V :
					reactMr_B_r2_V();
					break;
				case mr_B_r2_W :
					reactMr_B_r2_W();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
