package org.yakindu.scr.booleanexpressions;

public class BooleanExpressionsStatemachine
		implements
			IBooleanExpressionsStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		private boolean myBool1;

		public boolean getMyBool1() {
			return myBool1;
		}

		public void setMyBool1(boolean value) {
			this.myBool1 = value;
		}

		private boolean myBool2;

		public boolean getMyBool2() {
			return myBool2;
		}

		public void setMyBool2(boolean value) {
			this.myBool2 = value;
		}

		private boolean and;

		public boolean getAnd() {
			return and;
		}

		public void setAnd(boolean value) {
			this.and = value;
		}

		private boolean or;

		public boolean getOr() {
			return or;
		}

		public void setOr(boolean value) {
			this.or = value;
		}

		private boolean not;

		public boolean getNot() {
			return not;
		}

		public void setNot(boolean value) {
			this.not = value;
		}

		private boolean equal;

		public boolean getEqual() {
			return equal;
		}

		public void setEqual(boolean value) {
			this.equal = value;
		}

		private boolean notequal;

		public boolean getNotequal() {
			return notequal;
		}

		public void setNotequal(boolean value) {
			this.notequal = value;
		}

		public void clearEvents() {
			e1 = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_StateA, main_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public BooleanExpressionsStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.myBool1 = false;

		sCInterface.myBool2 = false;

		sCInterface.and = false;

		sCInterface.or = false;

		sCInterface.not = false;

		sCInterface.equal = false;

		sCInterface.notequal = false;
	}

	public void enter() {
		entryAction();

		sCInterface.myBool1 = true;

		sCInterface.myBool2 = false;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_StateA :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_StateB :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {
		sCInterface.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_StateA :
				return stateVector[0] == State.main_region_StateA;
			case main_region_StateB :
				return stateVector[0] == State.main_region_StateB;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseE1() {
		sCInterface.raiseE1();
	}

	public boolean getMyBool1() {
		return sCInterface.getMyBool1();
	}

	public void setMyBool1(boolean value) {
		sCInterface.setMyBool1(value);
	}
	public boolean getMyBool2() {
		return sCInterface.getMyBool2();
	}

	public void setMyBool2(boolean value) {
		sCInterface.setMyBool2(value);
	}
	public boolean getAnd() {
		return sCInterface.getAnd();
	}

	public void setAnd(boolean value) {
		sCInterface.setAnd(value);
	}
	public boolean getOr() {
		return sCInterface.getOr();
	}

	public void setOr(boolean value) {
		sCInterface.setOr(value);
	}
	public boolean getNot() {
		return sCInterface.getNot();
	}

	public void setNot(boolean value) {
		sCInterface.setNot(value);
	}
	public boolean getEqual() {
		return sCInterface.getEqual();
	}

	public void setEqual(boolean value) {
		sCInterface.setEqual(value);
	}
	public boolean getNotequal() {
		return sCInterface.getNotequal();
	}

	public void setNotequal(boolean value) {
		sCInterface.setNotequal(value);
	}

	/* Entry action for statechart 'BooleanExpressions'. */
	private void entryAction() {
	}

	/* Exit action for state 'BooleanExpressions'. */
	private void exitAction() {
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (sCInterface.e1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.and = sCInterface.myBool1 && sCInterface.myBool2;

			sCInterface.or = sCInterface.myBool1 || sCInterface.myBool2;

			sCInterface.not = !sCInterface.myBool1;

			sCInterface.equal = sCInterface.myBool1 == sCInterface.myBool2;

			sCInterface.notequal = (sCInterface.myBool1 != sCInterface.myBool2);

			nextStateIndex = 0;
			stateVector[0] = State.main_region_StateB;
		}
	}

	/* The reactions of state StateB. */
	private void reactMain_region_StateB() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_StateA :
					reactMain_region_StateA();
					break;
				case main_region_StateB :
					reactMain_region_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
