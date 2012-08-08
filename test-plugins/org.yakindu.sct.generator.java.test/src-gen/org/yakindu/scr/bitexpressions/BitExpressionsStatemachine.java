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
		Main_region_StateA, Main_region_StateB, $NullState$
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
	}

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {

			case Main_region_StateA :
				return stateVector[0] == State.Main_region_StateA;

			case Main_region_StateB :
				return stateVector[0] == State.Main_region_StateB;

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

	public void enter() {
		entryActionBitExpressions();
		sCIDefault.myBit1 = 5;

		sCIDefault.myBit2 = 7;

		nextStateIndex = 0;
		stateVector[0] = State.Main_region_StateA;

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

		exitActionBitExpressions();
	}

	private void entryActionBitExpressions() {

	}

	private void exitActionBitExpressions() {

	}

	private void reactMain_region_StateA() {
		if (sCIDefault.e1) {
			stateVector[0] = State.$NullState$;

			sCIDefault.leftBitshift = (sCIDefault.myBit1 << 1);

			sCIDefault.rightBitshift = (sCIDefault.myBit1 >> 1);

			sCIDefault.complementBitshift = ~(sCIDefault.myBit1);

			sCIDefault.bitwiseAnd = (sCIDefault.myBit1 & sCIDefault.myBit2);

			sCIDefault.bitwiseOr = (sCIDefault.myBit1 | sCIDefault.myBit2);

			sCIDefault.bitwiseXor = (sCIDefault.myBit1 ^ sCIDefault.myBit2);

			nextStateIndex = 0;
			stateVector[0] = State.Main_region_StateB;

		}

	}
	private void reactMain_region_StateB() {

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
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
