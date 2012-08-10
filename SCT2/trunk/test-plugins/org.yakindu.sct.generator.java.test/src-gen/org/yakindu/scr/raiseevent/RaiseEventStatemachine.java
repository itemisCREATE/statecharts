package org.yakindu.scr.raiseevent;

public class RaiseEventStatemachine implements IRaiseEventStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean e1;

		public boolean isRaisedE1() {
			return e1;
		}

		private void raiseE1() {
			e1 = true;
		}

		private boolean e2;

		public void raiseE2() {
			e2 = true;
		}

		public void clearEvents() {
			e2 = false;
		}

		public void clearOutEvents() {
			e1 = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		Main_region_StateA, Main_region_StateB, Second_region_SateA, Second_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[2];

	private int nextStateIndex;

	public RaiseEventStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 2; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();
	}

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
		sCIDefault.clearOutEvents();
	}

	public boolean isStateActive(State state) {
		switch (state) {

			case Main_region_StateA :
				return stateVector[0] == State.Main_region_StateA;

			case Main_region_StateB :
				return stateVector[0] == State.Main_region_StateB;

			case Second_region_SateA :
				return stateVector[1] == State.Second_region_SateA;

			case Second_region_StateB :
				return stateVector[1] == State.Second_region_StateB;

			default :
				return false;
		}
		/*
		for (int i=0;i<stateVector.length;i++){
			if (stateVector[i]==state) {
				return true;
			}
		}
		return false;
		 */
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public boolean isRaisedE1() {
		return sCIDefault.isRaisedE1();
	}

	public void raiseE2() {
		sCIDefault.raiseE2();
	}

	public void enter() {
		entryActionRaiseEvent();
		nextStateIndex = 0;
		stateVector[0] = State.Main_region_StateA;

		nextStateIndex = 1;
		stateVector[1] = State.Second_region_SateA;

	}

	public void exit() {
		//Handle exit of all possible states (of main region) at position 0...
		switch (stateVector[0]) {

			case Main_region_StateA :
				stateVector[0] = State.$NullState$;

				break;

			case Main_region_StateB :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		//Handle exit of all possible states (of second region) at position 1...
		switch (stateVector[1]) {

			case Second_region_SateA :
				stateVector[1] = State.$NullState$;

				break;

			case Second_region_StateB :
				stateVector[1] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionRaiseEvent();
	}

	private void entryActionRaiseEvent() {

	}

	private void exitActionRaiseEvent() {

	}

	private void reactMain_region_StateA() {
		if (sCIDefault.e2) {
			stateVector[0] = State.$NullState$;

			sCIDefault.raiseE1();

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_StateB;

		}

	}
	private void reactMain_region_StateB() {

	}
	private void reactSecond_region_SateA() {
		if (sCIDefault.e1) {
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.Second_region_StateB;

		}
	}
	private void reactSecond_region_StateB() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case Main_region_StateA :
					reactMain_region_StateA();
					break;
				case Main_region_StateB :
					reactMain_region_StateB();
					break;
				case Second_region_SateA :
					reactSecond_region_SateA();
					break;
				case Second_region_StateB :
					reactSecond_region_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
