package org.yakindu.scr.bitexpressions;

public class BitExpressionsStatemachine implements IBitExpressionsStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

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

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_StateA, main_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public BitExpressionsStatemachine() {

		sCInterface = new SCInterfaceImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.myBit1 = 0;

		sCInterface.myBit2 = 0;

		sCInterface.leftBitshift = 0;

		sCInterface.rightBitshift = 0;

		sCInterface.complementBitshift = 0;

		sCInterface.bitwiseAnd = 0;

		sCInterface.bitwiseOr = 0;

		sCInterface.bitwiseXor = 0;
	}

	public void enter() {
		entryAction();

		sCInterface.myBit1 = 5;

		sCInterface.myBit2 = 7;

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

	public int getMyBit1() {
		return sCInterface.getMyBit1();
	}

	public void setMyBit1(int value) {
		sCInterface.setMyBit1(value);
	}
	public int getMyBit2() {
		return sCInterface.getMyBit2();
	}

	public void setMyBit2(int value) {
		sCInterface.setMyBit2(value);
	}
	public int getLeftBitshift() {
		return sCInterface.getLeftBitshift();
	}

	public void setLeftBitshift(int value) {
		sCInterface.setLeftBitshift(value);
	}
	public int getRightBitshift() {
		return sCInterface.getRightBitshift();
	}

	public void setRightBitshift(int value) {
		sCInterface.setRightBitshift(value);
	}
	public int getComplementBitshift() {
		return sCInterface.getComplementBitshift();
	}

	public void setComplementBitshift(int value) {
		sCInterface.setComplementBitshift(value);
	}
	public int getBitwiseAnd() {
		return sCInterface.getBitwiseAnd();
	}

	public void setBitwiseAnd(int value) {
		sCInterface.setBitwiseAnd(value);
	}
	public int getBitwiseOr() {
		return sCInterface.getBitwiseOr();
	}

	public void setBitwiseOr(int value) {
		sCInterface.setBitwiseOr(value);
	}
	public int getBitwiseXor() {
		return sCInterface.getBitwiseXor();
	}

	public void setBitwiseXor(int value) {
		sCInterface.setBitwiseXor(value);
	}

	/* Entry action for statechart 'BitExpressions'. */
	private void entryAction() {
	}

	/* Exit action for state 'BitExpressions'. */
	private void exitAction() {
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (sCInterface.e1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.leftBitshift = sCInterface.myBit1 << 1;

			sCInterface.rightBitshift = sCInterface.myBit1 >> 1;

			sCInterface.complementBitshift = ~sCInterface.myBit1;

			sCInterface.bitwiseAnd = sCInterface.myBit1 & sCInterface.myBit2;

			sCInterface.bitwiseOr = sCInterface.myBit1 | sCInterface.myBit2;

			sCInterface.bitwiseXor = sCInterface.myBit1 ^ sCInterface.myBit2;

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
