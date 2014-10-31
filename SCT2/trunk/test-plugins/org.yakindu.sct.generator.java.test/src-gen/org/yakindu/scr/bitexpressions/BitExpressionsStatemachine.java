package org.yakindu.scr.bitexpressions;

public class BitExpressionsStatemachine implements IBitExpressionsStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		private long myBit1;

		public long getMyBit1() {
			return myBit1;
		}

		public void setMyBit1(long value) {
			this.myBit1 = value;
		}

		private long myBit2;

		public long getMyBit2() {
			return myBit2;
		}

		public void setMyBit2(long value) {
			this.myBit2 = value;
		}

		private long leftBitshift;

		public long getLeftBitshift() {
			return leftBitshift;
		}

		public void setLeftBitshift(long value) {
			this.leftBitshift = value;
		}

		private long rightBitshift;

		public long getRightBitshift() {
			return rightBitshift;
		}

		public void setRightBitshift(long value) {
			this.rightBitshift = value;
		}

		private long complementBitshift;

		public long getComplementBitshift() {
			return complementBitshift;
		}

		public void setComplementBitshift(long value) {
			this.complementBitshift = value;
		}

		private long bitwiseAnd;

		public long getBitwiseAnd() {
			return bitwiseAnd;
		}

		public void setBitwiseAnd(long value) {
			this.bitwiseAnd = value;
		}

		private long bitwiseOr;

		public long getBitwiseOr() {
			return bitwiseOr;
		}

		public void setBitwiseOr(long value) {
			this.bitwiseOr = value;
		}

		private long bitwiseXor;

		public long getBitwiseXor() {
			return bitwiseXor;
		}

		public void setBitwiseXor(long value) {
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

	/**
	 * This method resets the incoming events (time events included).
	 */
	protected void clearEvents() {
		sCInterface.clearEvents();

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

	public long getMyBit1() {
		return sCInterface.getMyBit1();
	}

	public void setMyBit1(long value) {
		sCInterface.setMyBit1(value);
	}
	public long getMyBit2() {
		return sCInterface.getMyBit2();
	}

	public void setMyBit2(long value) {
		sCInterface.setMyBit2(value);
	}
	public long getLeftBitshift() {
		return sCInterface.getLeftBitshift();
	}

	public void setLeftBitshift(long value) {
		sCInterface.setLeftBitshift(value);
	}
	public long getRightBitshift() {
		return sCInterface.getRightBitshift();
	}

	public void setRightBitshift(long value) {
		sCInterface.setRightBitshift(value);
	}
	public long getComplementBitshift() {
		return sCInterface.getComplementBitshift();
	}

	public void setComplementBitshift(long value) {
		sCInterface.setComplementBitshift(value);
	}
	public long getBitwiseAnd() {
		return sCInterface.getBitwiseAnd();
	}

	public void setBitwiseAnd(long value) {
		sCInterface.setBitwiseAnd(value);
	}
	public long getBitwiseOr() {
		return sCInterface.getBitwiseOr();
	}

	public void setBitwiseOr(long value) {
		sCInterface.setBitwiseOr(value);
	}
	public long getBitwiseXor() {
		return sCInterface.getBitwiseXor();
	}

	public void setBitwiseXor(long value) {
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
