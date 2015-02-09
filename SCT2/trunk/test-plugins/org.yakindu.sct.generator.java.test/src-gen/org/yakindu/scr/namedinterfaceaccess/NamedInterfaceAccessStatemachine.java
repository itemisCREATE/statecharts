package org.yakindu.scr.namedinterfaceaccess;

public class NamedInterfaceAccessStatemachine
		implements
			INamedInterfaceAccessStatemachine {

	static {
	}

	private final class SCISafeImpl implements SCISafe {

		private boolean open;

		public boolean isRaisedOpen() {
			return open;
		}

		private void raiseOpen() {
			open = true;
		}

		private boolean close;

		public boolean isRaisedClose() {
			return close;
		}

		private void raiseClose() {
			close = true;
		}

		public void clearEvents() {
		}

		public void clearOutEvents() {
			open = false;
			close = false;
		}
	}

	private SCISafeImpl sCISafe;
	private final class SCIUserImpl implements SCIUser {

		private boolean numberPressed;

		private long numberPressedValue;

		public void raiseNumberPressed(long value) {
			numberPressed = true;
			numberPressedValue = value;
		}

		private long getNumberPressedValue() {
			if (!numberPressed)
				throw new IllegalStateException(
						"Illegal event value acces. Event NumberPressed is not raised!");
			return numberPressedValue;
		}

		private boolean reset;

		public void raiseReset() {
			reset = true;
		}

		public void clearEvents() {
			numberPressed = false;
			reset = false;
		}

	}

	private SCIUserImpl sCIUser;

	public enum State {
		region_1_Idle, region_1_Number1Pressed, region_1_Number2Pressed, region_1_Number3Pressed, _region1_Closed, _region1_Open, $NullState$
	};

	private long number1;
	private long number2;
	private long number3;

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public NamedInterfaceAccessStatemachine() {

		sCISafe = new SCISafeImpl();
		sCIUser = new SCIUserImpl();
	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		number1 = 3;

		number2 = 7;

		number3 = 5;
	}

	public void enter() {
		entryAction();

		enterSequenceRegion_1();

		enterSequenceRegion1();
	}

	public void exit() {
		exitSequenceRegion_1();

		exitSequenceRegion1();

		exitAction();
	}

	/**
	 * This method resets the incoming events (time events included).
	 */
	protected void clearEvents() {
		sCISafe.clearEvents();
		sCIUser.clearEvents();

	}

	/**
	 * This method resets the outgoing events.
	 */
	protected void clearOutEvents() {
		sCISafe.clearOutEvents();
	}

	/**
	 * Returns true if the given state is currently active otherwise false.
	 */
	public boolean isStateActive(State state) {
		switch (state) {
			case region_1_Idle :
				return stateVector[0] == State.region_1_Idle;
			case region_1_Number1Pressed :
				return stateVector[0] == State.region_1_Number1Pressed;
			case region_1_Number2Pressed :
				return stateVector[0] == State.region_1_Number2Pressed;
			case region_1_Number3Pressed :
				return stateVector[0] == State.region_1_Number3Pressed;
			case _region1_Closed :
				return stateVector[1] == State._region1_Closed;
			case _region1_Open :
				return stateVector[1] == State._region1_Open;
			default :
				return false;
		}
	}

	public SCISafe getSCISafe() {
		return sCISafe;
	}
	public SCIUser getSCIUser() {
		return sCIUser;
	}

	private boolean checkRegion_1_IdleTr0() {
		return (sCIUser.numberPressed) && sCIUser.numberPressedValue == number1;
	}

	private boolean checkRegion_1_Number1PressedTr0() {
		return (sCIUser.numberPressed) && sCIUser.numberPressedValue == number2;
	}

	private boolean checkRegion_1_Number1PressedTr1() {
		return sCIUser.numberPressed;
	}

	private boolean checkRegion_1_Number2PressedTr0() {
		return (sCIUser.numberPressed) && sCIUser.numberPressedValue == number3;
	}

	private boolean checkRegion_1_Number2PressedTr1() {
		return sCIUser.numberPressed;
	}

	private boolean checkRegion_1_Number3PressedTr0() {
		return sCIUser.numberPressed;
	}

	private boolean checkRegion1_ClosedTr0() {
		return sCISafe.open;
	}

	private boolean checkRegion1_OpenTr0() {
		return sCISafe.close;
	}

	private void effectRegion_1_IdleTr0() {
		exitSequenceRegion_1_Idle();

		enterSequenceRegion_1_Number1Pressed();
	}

	private void effectRegion_1_Number1PressedTr0() {
		exitSequenceRegion_1_Number1Pressed();

		enterSequenceRegion_1_Number2Pressed();
	}

	private void effectRegion_1_Number1PressedTr1() {
		exitSequenceRegion_1_Number1Pressed();

		enterSequenceRegion_1_Idle();
	}

	private void effectRegion_1_Number2PressedTr0() {
		exitSequenceRegion_1_Number2Pressed();

		enterSequenceRegion_1_Number3Pressed();
	}

	private void effectRegion_1_Number2PressedTr1() {
		exitSequenceRegion_1_Number2Pressed();

		enterSequenceRegion_1_Idle();
	}

	private void effectRegion_1_Number3PressedTr0() {
		exitSequenceRegion_1_Number3Pressed();

		enterSequenceRegion_1_Idle();
	}

	private void effectRegion1_ClosedTr0() {
		exitSequenceRegion1_Closed();

		enterSequenceRegion1_Open();
	}

	private void effectRegion1_OpenTr0() {
		exitSequenceRegion1_Open();

		enterSequenceRegion1_Closed();
	}

	/* Entry action for statechart 'NamedInterfaceAccess'. */
	private void entryAction() {
	}

	/* Entry action for state 'Idle'. */
	private void entryActionRegion_1_Idle() {
		sCISafe.raiseClose();
	}

	/* Entry action for state 'Number3Pressed'. */
	private void entryActionRegion_1_Number3Pressed() {
		sCISafe.raiseOpen();
	}

	/* Exit action for state 'NamedInterfaceAccess'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state Idle */
	private void enterSequenceRegion_1_Idle() {
		entryActionRegion_1_Idle();

		nextStateIndex = 0;
		stateVector[0] = State.region_1_Idle;
	}

	/* 'default' enter sequence for state Number1Pressed */
	private void enterSequenceRegion_1_Number1Pressed() {
		nextStateIndex = 0;
		stateVector[0] = State.region_1_Number1Pressed;
	}

	/* 'default' enter sequence for state Number2Pressed */
	private void enterSequenceRegion_1_Number2Pressed() {
		nextStateIndex = 0;
		stateVector[0] = State.region_1_Number2Pressed;
	}

	/* 'default' enter sequence for state Number3Pressed */
	private void enterSequenceRegion_1_Number3Pressed() {
		entryActionRegion_1_Number3Pressed();

		nextStateIndex = 0;
		stateVector[0] = State.region_1_Number3Pressed;
	}

	/* 'default' enter sequence for state Closed */
	private void enterSequenceRegion1_Closed() {
		nextStateIndex = 1;
		stateVector[1] = State._region1_Closed;
	}

	/* 'default' enter sequence for state Open */
	private void enterSequenceRegion1_Open() {
		nextStateIndex = 1;
		stateVector[1] = State._region1_Open;
	}

	/* 'default' enter sequence for region region 1 */
	private void enterSequenceRegion_1() {
		reactNamedInterfaceAccess_region_1__entry_Default();
	}

	/* 'default' enter sequence for region null */
	private void enterSequenceRegion1() {
		reactNamedInterfaceAccess__region1__entry_Default();
	}

	/* Default exit sequence for state Idle */
	private void exitSequenceRegion_1_Idle() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Number1Pressed */
	private void exitSequenceRegion_1_Number1Pressed() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Number2Pressed */
	private void exitSequenceRegion_1_Number2Pressed() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Number3Pressed */
	private void exitSequenceRegion_1_Number3Pressed() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Closed */
	private void exitSequenceRegion1_Closed() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state Open */
	private void exitSequenceRegion1_Open() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for region region 1 */
	private void exitSequenceRegion_1() {
		switch (stateVector[0]) {
			case region_1_Idle :
				exitSequenceRegion_1_Idle();
				break;

			case region_1_Number1Pressed :
				exitSequenceRegion_1_Number1Pressed();
				break;

			case region_1_Number2Pressed :
				exitSequenceRegion_1_Number2Pressed();
				break;

			case region_1_Number3Pressed :
				exitSequenceRegion_1_Number3Pressed();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region null */
	private void exitSequenceRegion1() {
		switch (stateVector[1]) {
			case _region1_Closed :
				exitSequenceRegion1_Closed();
				break;

			case _region1_Open :
				exitSequenceRegion1_Open();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Idle. */
	private void reactRegion_1_Idle() {
		if (checkRegion_1_IdleTr0()) {
			effectRegion_1_IdleTr0();
		}
	}

	/* The reactions of state Number1Pressed. */
	private void reactRegion_1_Number1Pressed() {
		if (checkRegion_1_Number1PressedTr0()) {
			effectRegion_1_Number1PressedTr0();
		} else {
			if (checkRegion_1_Number1PressedTr1()) {
				effectRegion_1_Number1PressedTr1();
			}
		}
	}

	/* The reactions of state Number2Pressed. */
	private void reactRegion_1_Number2Pressed() {
		if (checkRegion_1_Number2PressedTr0()) {
			effectRegion_1_Number2PressedTr0();
		} else {
			if (checkRegion_1_Number2PressedTr1()) {
				effectRegion_1_Number2PressedTr1();
			}
		}
	}

	/* The reactions of state Number3Pressed. */
	private void reactRegion_1_Number3Pressed() {
		if (checkRegion_1_Number3PressedTr0()) {
			effectRegion_1_Number3PressedTr0();
		}
	}

	/* The reactions of state Closed. */
	private void reactRegion1_Closed() {
		if (checkRegion1_ClosedTr0()) {
			effectRegion1_ClosedTr0();
		}
	}

	/* The reactions of state Open. */
	private void reactRegion1_Open() {
		if (checkRegion1_OpenTr0()) {
			effectRegion1_OpenTr0();
		}
	}

	/* Default react sequence for initial entry  */
	private void reactNamedInterfaceAccess_region_1__entry_Default() {
		enterSequenceRegion_1_Idle();
	}

	/* Default react sequence for initial entry  */
	private void reactNamedInterfaceAccess__region1__entry_Default() {
		enterSequenceRegion1_Closed();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case region_1_Idle :
					reactRegion_1_Idle();
					break;
				case region_1_Number1Pressed :
					reactRegion_1_Number1Pressed();
					break;
				case region_1_Number2Pressed :
					reactRegion_1_Number2Pressed();
					break;
				case region_1_Number3Pressed :
					reactRegion_1_Number3Pressed();
					break;
				case _region1_Closed :
					reactRegion1_Closed();
					break;
				case _region1_Open :
					reactRegion1_Open();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
