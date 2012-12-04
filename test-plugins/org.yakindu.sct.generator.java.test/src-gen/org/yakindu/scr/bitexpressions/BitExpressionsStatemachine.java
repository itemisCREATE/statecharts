package org.yakindu.scr.bitexpressions;

public class BitExpressionsStatemachine implements IBitExpressionsStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		private int myBit1;

		public int getMyBit1() {
			return myBit1;
		}

		public void setMyBit1(int value) {
			this.myBit1 = value;
		}

		private int myBit2;

		public int getMyBit2() {
			return myBit2;
		}

		public void setMyBit2(int value) {
			this.myBit2 = value;
		}

		private int leftBitshift;

		public int getLeftBitshift() {
			return leftBitshift;
		}

		public void setLeftBitshift(int value) {
			this.leftBitshift = value;
		}

		private int rightBitshift;

		public int getRightBitshift() {
			return rightBitshift;
		}

		public void setRightBitshift(int value) {
			this.rightBitshift = value;
		}

		private int complementBitshift;

		public int getComplementBitshift() {
			return complementBitshift;
		}

		public void setComplementBitshift(int value) {
			this.complementBitshift = value;
		}

		private int bitwiseAnd;

		public int getBitwiseAnd() {
			return bitwiseAnd;
		}

		public void setBitwiseAnd(int value) {
			this.bitwiseAnd = value;
		}

		private int bitwiseOr;

		public int getBitwiseOr() {
			return bitwiseOr;
		}

		public void setBitwiseOr(int value) {
			this.bitwiseOr = value;
		}

		private int bitwiseXor;

		public int getBitwiseXor() {
			return bitwiseXor;
		}

		public void setBitwiseXor(int value) {
			this.bitwiseXor = value;
		}

		public void clearEvents() {
			e1 = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		main_region_StateA, main_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public BitExpressionsStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIDefault.myBit1 = 0;

		sCIDefault.myBit2 = 0;

		sCIDefault.leftBitshift = 0;

		sCIDefault.rightBitshift = 0;

		sCIDefault.complementBitshift = 0;

		sCIDefault.bitwiseAnd = 0;

		sCIDefault.bitwiseOr = 0;

		sCIDefault.bitwiseXor = 0;
	}

	public void enter() {
		entryAction();

		sCIDefault.myBit1 = 5;

		sCIDefault.myBit2 = 7;

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
		sCIDefault.clearEvents();

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

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseE1() {
		sCIDefault.raiseE1();
	}

	public int getMyBit1() {
		return sCIDefault.getMyBit1();
	}

	public void setMyBit1(int value) {
		sCIDefault.setMyBit1(value);
	}
	public int getMyBit2() {
		return sCIDefault.getMyBit2();
	}

	public void setMyBit2(int value) {
		sCIDefault.setMyBit2(value);
	}
	public int getLeftBitshift() {
		return sCIDefault.getLeftBitshift();
	}

	public void setLeftBitshift(int value) {
		sCIDefault.setLeftBitshift(value);
	}
	public int getRightBitshift() {
		return sCIDefault.getRightBitshift();
	}

	public void setRightBitshift(int value) {
		sCIDefault.setRightBitshift(value);
	}
	public int getComplementBitshift() {
		return sCIDefault.getComplementBitshift();
	}

	public void setComplementBitshift(int value) {
		sCIDefault.setComplementBitshift(value);
	}
	public int getBitwiseAnd() {
		return sCIDefault.getBitwiseAnd();
	}

	public void setBitwiseAnd(int value) {
		sCIDefault.setBitwiseAnd(value);
	}
	public int getBitwiseOr() {
		return sCIDefault.getBitwiseOr();
	}

	public void setBitwiseOr(int value) {
		sCIDefault.setBitwiseOr(value);
	}
	public int getBitwiseXor() {
		return sCIDefault.getBitwiseXor();
	}

	public void setBitwiseXor(int value) {
		sCIDefault.setBitwiseXor(value);
	}

	/* Entry action for statechart 'BitExpressions'. */
	private void entryAction() {
	}

	/* Exit action for state 'BitExpressions'. */
	private void exitAction() {
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (sCIDefault.e1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIDefault.leftBitshift = sCIDefault.myBit1 << 1;

			sCIDefault.rightBitshift = sCIDefault.myBit1 >> 1;

			sCIDefault.complementBitshift = ~sCIDefault.myBit1;

			sCIDefault.bitwiseAnd = sCIDefault.myBit1 & sCIDefault.myBit2;

			sCIDefault.bitwiseOr = sCIDefault.myBit1 | sCIDefault.myBit2;

			sCIDefault.bitwiseXor = sCIDefault.myBit1 ^ sCIDefault.myBit2;

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
