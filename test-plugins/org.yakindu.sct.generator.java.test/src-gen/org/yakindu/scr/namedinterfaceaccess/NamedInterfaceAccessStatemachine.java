package org.yakindu.scr.namedinterfaceaccess;

public class NamedInterfaceAccessStatemachine
		implements
			INamedInterfaceAccessStatemachine {

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

		private int numberPressedValue;

		public void raiseNumberPressed(int value) {
			numberPressed = true;
			numberPressedValue = value;
		}

		private int getNumberPressedValue() {
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

	private int number1;
	private int number2;
	private int number3;

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

		sCISafe.raiseClose();

		nextStateIndex = 0;
		stateVector[0] = State.region_1_Idle;

		nextStateIndex = 1;
		stateVector[1] = State._region1_Closed;
	}

	public void exit() {
		switch (stateVector[0]) {
			case region_1_Idle :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case region_1_Number1Pressed :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case region_1_Number2Pressed :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case region_1_Number3Pressed :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case _region1_Closed :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case _region1_Open :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {
		sCISafe.clearEvents();
		sCIUser.clearEvents();

	}

	protected void clearOutEvents() {
		sCISafe.clearOutEvents();
	}

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

	/* Entry action for statechart 'NamedInterfaceAccess'. */
	private void entryAction() {
	}

	/* Exit action for state 'NamedInterfaceAccess'. */
	private void exitAction() {
	}

	/* The reactions of state Idle. */
	private void reactRegion_1_Idle() {
		if (sCIUser.numberPressed && sCIUser.numberPressedValue == number1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.region_1_Number1Pressed;
		}
	}

	/* The reactions of state Number1Pressed. */
	private void reactRegion_1_Number1Pressed() {
		if (sCIUser.numberPressed && sCIUser.numberPressedValue == number2) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.region_1_Number2Pressed;
		} else {
			if (sCIUser.numberPressed) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCISafe.raiseClose();

				nextStateIndex = 0;
				stateVector[0] = State.region_1_Idle;
			}
		}
	}

	/* The reactions of state Number2Pressed. */
	private void reactRegion_1_Number2Pressed() {
		if (sCIUser.numberPressed && sCIUser.numberPressedValue == number3) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCISafe.raiseOpen();

			nextStateIndex = 0;
			stateVector[0] = State.region_1_Number3Pressed;
		} else {
			if (sCIUser.numberPressed) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				sCISafe.raiseClose();

				nextStateIndex = 0;
				stateVector[0] = State.region_1_Idle;
			}
		}
	}

	/* The reactions of state Number3Pressed. */
	private void reactRegion_1_Number3Pressed() {
		if (sCIUser.numberPressed) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCISafe.raiseClose();

			nextStateIndex = 0;
			stateVector[0] = State.region_1_Idle;
		}
	}

	/* The reactions of state Closed. */
	private void reactRegion1_Closed() {
		if (sCISafe.open) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State._region1_Open;
		}
	}

	/* The reactions of state Open. */
	private void reactRegion1_Open() {
		if (sCISafe.close) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State._region1_Closed;
		}
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
