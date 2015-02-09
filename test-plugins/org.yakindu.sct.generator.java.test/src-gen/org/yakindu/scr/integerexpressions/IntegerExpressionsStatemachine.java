package org.yakindu.scr.integerexpressions;

public class IntegerExpressionsStatemachine
		implements
			IIntegerExpressionsStatemachine {

	static {
	}

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		private long myInt1;
		public long getMyInt1() {
			return myInt1;
		}

		public void setMyInt1(long value) {
			this.myInt1 = value;
		}

		private long myInt2;
		public long getMyInt2() {
			return myInt2;
		}

		public void setMyInt2(long value) {
			this.myInt2 = value;
		}

		private boolean less;
		public boolean getLess() {
			return less;
		}

		public void setLess(boolean value) {
			this.less = value;
		}

		private boolean greater;
		public boolean getGreater() {
			return greater;
		}

		public void setGreater(boolean value) {
			this.greater = value;
		}

		private boolean equalOrLess;
		public boolean getEqualOrLess() {
			return equalOrLess;
		}

		public void setEqualOrLess(boolean value) {
			this.equalOrLess = value;
		}

		private boolean equalOrGreater;
		public boolean getEqualOrGreater() {
			return equalOrGreater;
		}

		public void setEqualOrGreater(boolean value) {
			this.equalOrGreater = value;
		}

		private boolean equal;
		public boolean getEqual() {
			return equal;
		}

		public void setEqual(boolean value) {
			this.equal = value;
		}

		private boolean notEqual;
		public boolean getNotEqual() {
			return notEqual;
		}

		public void setNotEqual(boolean value) {
			this.notEqual = value;
		}

		private long plus;
		public long getPlus() {
			return plus;
		}

		public void setPlus(long value) {
			this.plus = value;
		}

		private long minus;
		public long getMinus() {
			return minus;
		}

		public void setMinus(long value) {
			this.minus = value;
		}

		private long multiply;
		public long getMultiply() {
			return multiply;
		}

		public void setMultiply(long value) {
			this.multiply = value;
		}

		private long division;
		public long getDivision() {
			return division;
		}

		public void setDivision(long value) {
			this.division = value;
		}

		private long modulo;
		public long getModulo() {
			return modulo;
		}

		public void setModulo(long value) {
			this.modulo = value;
		}

		private long negat;
		public long getNegat() {
			return negat;
		}

		public void setNegat(long value) {
			this.negat = value;
		}

		private boolean complement;
		public boolean getComplement() {
			return complement;
		}

		public void setComplement(boolean value) {
			this.complement = value;
		}

		private long multiAssign;
		public long getMultiAssign() {
			return multiAssign;
		}

		public void setMultiAssign(long value) {
			this.multiAssign = value;
		}

		private long divAssign;
		public long getDivAssign() {
			return divAssign;
		}

		public void setDivAssign(long value) {
			this.divAssign = value;
		}

		private long plusAssign;
		public long getPlusAssign() {
			return plusAssign;
		}

		public void setPlusAssign(long value) {
			this.plusAssign = value;
		}

		private long minusAssign;
		public long getMinusAssign() {
			return minusAssign;
		}

		public void setMinusAssign(long value) {
			this.minusAssign = value;
		}

		private long moduloAssign;
		public long getModuloAssign() {
			return moduloAssign;
		}

		public void setModuloAssign(long value) {
			this.moduloAssign = value;
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

	public IntegerExpressionsStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.myInt1 = 0;

		sCInterface.myInt2 = 0;

		sCInterface.less = false;

		sCInterface.greater = false;

		sCInterface.equalOrLess = false;

		sCInterface.equalOrGreater = false;

		sCInterface.equal = false;

		sCInterface.notEqual = false;

		sCInterface.plus = 0;

		sCInterface.minus = 0;

		sCInterface.multiply = 0;

		sCInterface.division = 0;

		sCInterface.modulo = 0;

		sCInterface.negat = 0;

		sCInterface.complement = false;

		sCInterface.multiAssign = 2;

		sCInterface.divAssign = 20;

		sCInterface.plusAssign = 2;

		sCInterface.minusAssign = 2;

		sCInterface.moduloAssign = 20;
	}

	public void enter() {
		entryAction();

		enterSequenceMain_region();
	}

	public void exit() {
		exitSequenceMain_region();

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

	public long getMyInt1() {
		return sCInterface.getMyInt1();
	}

	public void setMyInt1(long value) {
		sCInterface.setMyInt1(value);
	}
	public long getMyInt2() {
		return sCInterface.getMyInt2();
	}

	public void setMyInt2(long value) {
		sCInterface.setMyInt2(value);
	}
	public boolean getLess() {
		return sCInterface.getLess();
	}

	public void setLess(boolean value) {
		sCInterface.setLess(value);
	}
	public boolean getGreater() {
		return sCInterface.getGreater();
	}

	public void setGreater(boolean value) {
		sCInterface.setGreater(value);
	}
	public boolean getEqualOrLess() {
		return sCInterface.getEqualOrLess();
	}

	public void setEqualOrLess(boolean value) {
		sCInterface.setEqualOrLess(value);
	}
	public boolean getEqualOrGreater() {
		return sCInterface.getEqualOrGreater();
	}

	public void setEqualOrGreater(boolean value) {
		sCInterface.setEqualOrGreater(value);
	}
	public boolean getEqual() {
		return sCInterface.getEqual();
	}

	public void setEqual(boolean value) {
		sCInterface.setEqual(value);
	}
	public boolean getNotEqual() {
		return sCInterface.getNotEqual();
	}

	public void setNotEqual(boolean value) {
		sCInterface.setNotEqual(value);
	}
	public long getPlus() {
		return sCInterface.getPlus();
	}

	public void setPlus(long value) {
		sCInterface.setPlus(value);
	}
	public long getMinus() {
		return sCInterface.getMinus();
	}

	public void setMinus(long value) {
		sCInterface.setMinus(value);
	}
	public long getMultiply() {
		return sCInterface.getMultiply();
	}

	public void setMultiply(long value) {
		sCInterface.setMultiply(value);
	}
	public long getDivision() {
		return sCInterface.getDivision();
	}

	public void setDivision(long value) {
		sCInterface.setDivision(value);
	}
	public long getModulo() {
		return sCInterface.getModulo();
	}

	public void setModulo(long value) {
		sCInterface.setModulo(value);
	}
	public long getNegat() {
		return sCInterface.getNegat();
	}

	public void setNegat(long value) {
		sCInterface.setNegat(value);
	}
	public boolean getComplement() {
		return sCInterface.getComplement();
	}

	public void setComplement(boolean value) {
		sCInterface.setComplement(value);
	}
	public long getMultiAssign() {
		return sCInterface.getMultiAssign();
	}

	public void setMultiAssign(long value) {
		sCInterface.setMultiAssign(value);
	}
	public long getDivAssign() {
		return sCInterface.getDivAssign();
	}

	public void setDivAssign(long value) {
		sCInterface.setDivAssign(value);
	}
	public long getPlusAssign() {
		return sCInterface.getPlusAssign();
	}

	public void setPlusAssign(long value) {
		sCInterface.setPlusAssign(value);
	}
	public long getMinusAssign() {
		return sCInterface.getMinusAssign();
	}

	public void setMinusAssign(long value) {
		sCInterface.setMinusAssign(value);
	}
	public long getModuloAssign() {
		return sCInterface.getModuloAssign();
	}

	public void setModuloAssign(long value) {
		sCInterface.setModuloAssign(value);
	}

	private boolean checkMain_region_StateATr0() {
		return sCInterface.e1;
	}

	private void effectMain_region_StateATr0() {
		exitSequenceMain_region_StateA();

		enterSequenceMain_region_StateB();
	}

	/* Entry action for statechart 'IntegerExpressions'. */
	private void entryAction() {
	}

	/* Entry action for state 'StateA'. */
	private void entryActionMain_region_StateA() {
		sCInterface.myInt1 = 10;

		sCInterface.myInt2 = 5;
	}

	/* Entry action for state 'StateB'. */
	private void entryActionMain_region_StateB() {
		sCInterface.less = (sCInterface.myInt1 < sCInterface.myInt2);

		sCInterface.greater = (sCInterface.myInt1 > sCInterface.myInt2);

		sCInterface.equalOrLess = (sCInterface.myInt1 <= sCInterface.myInt2);

		sCInterface.equalOrGreater = (sCInterface.myInt1 >= sCInterface.myInt2);

		sCInterface.equal = (sCInterface.myInt1 == sCInterface.myInt2);

		sCInterface.notEqual = (sCInterface.myInt1 != sCInterface.myInt2);

		sCInterface.plus = sCInterface.myInt1 + sCInterface.myInt2;

		sCInterface.minus = sCInterface.myInt1 - sCInterface.myInt2;

		sCInterface.multiply = sCInterface.myInt1 * sCInterface.myInt2;

		sCInterface.division = sCInterface.myInt1 / sCInterface.myInt2;

		sCInterface.modulo = sCInterface.myInt1 % sCInterface.myInt2;

		sCInterface.negat = -sCInterface.myInt1;

		sCInterface.multiAssign *= sCInterface.myInt1;

		sCInterface.divAssign /= sCInterface.myInt1;

		sCInterface.plusAssign += sCInterface.myInt1;

		sCInterface.minusAssign -= sCInterface.myInt1;

		sCInterface.moduloAssign %= sCInterface.myInt1;
	}

	/* Exit action for state 'IntegerExpressions'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state StateA */
	private void enterSequenceMain_region_StateA() {
		entryActionMain_region_StateA();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}

	/* 'default' enter sequence for state StateB */
	private void enterSequenceMain_region_StateB() {
		entryActionMain_region_StateB();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateB;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequenceMain_region() {
		reactIntegerExpressions_main_region__entry_Default();
	}

	/* Default exit sequence for state StateA */
	private void exitSequenceMain_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state StateB */
	private void exitSequenceMain_region_StateB() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequenceMain_region() {
		switch (stateVector[0]) {
			case main_region_StateA :
				exitSequenceMain_region_StateA();
				break;

			case main_region_StateB :
				exitSequenceMain_region_StateB();
				break;

			default :
				break;
		}
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (checkMain_region_StateATr0()) {
			effectMain_region_StateATr0();
		}
	}

	/* The reactions of state StateB. */
	private void reactMain_region_StateB() {
	}

	/* Default react sequence for initial entry  */
	private void reactIntegerExpressions_main_region__entry_Default() {
		enterSequenceMain_region_StateA();
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
