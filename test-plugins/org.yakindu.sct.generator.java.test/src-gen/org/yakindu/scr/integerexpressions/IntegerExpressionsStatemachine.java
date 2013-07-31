package org.yakindu.scr.integerexpressions;

public class IntegerExpressionsStatemachine
		implements
			IIntegerExpressionsStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		private int myInt1;

		public int getMyInt1() {
			return myInt1;
		}

		public void setMyInt1(int value) {
			this.myInt1 = value;
		}

		private int myInt2;

		public int getMyInt2() {
			return myInt2;
		}

		public void setMyInt2(int value) {
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

		private int plus;

		public int getPlus() {
			return plus;
		}

		public void setPlus(int value) {
			this.plus = value;
		}

		private int minus;

		public int getMinus() {
			return minus;
		}

		public void setMinus(int value) {
			this.minus = value;
		}

		private int multiply;

		public int getMultiply() {
			return multiply;
		}

		public void setMultiply(int value) {
			this.multiply = value;
		}

		private int division;

		public int getDivision() {
			return division;
		}

		public void setDivision(int value) {
			this.division = value;
		}

		private int modulo;

		public int getModulo() {
			return modulo;
		}

		public void setModulo(int value) {
			this.modulo = value;
		}

		private int negat;

		public int getNegat() {
			return negat;
		}

		public void setNegat(int value) {
			this.negat = value;
		}

		private boolean complement;

		public boolean getComplement() {
			return complement;
		}

		public void setComplement(boolean value) {
			this.complement = value;
		}

		private int multiAssign;

		public int getMultiAssign() {
			return multiAssign;
		}

		public void setMultiAssign(int value) {
			this.multiAssign = value;
		}

		private int divAssign;

		public int getDivAssign() {
			return divAssign;
		}

		public void setDivAssign(int value) {
			this.divAssign = value;
		}

		private int plusAssign;

		public int getPlusAssign() {
			return plusAssign;
		}

		public void setPlusAssign(int value) {
			this.plusAssign = value;
		}

		private int minusAssign;

		public int getMinusAssign() {
			return minusAssign;
		}

		public void setMinusAssign(int value) {
			this.minusAssign = value;
		}

		private int moduloAssign;

		public int getModuloAssign() {
			return moduloAssign;
		}

		public void setModuloAssign(int value) {
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

		sCInterface.myInt1 = 10;

		sCInterface.myInt2 = 5;

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

	public int getMyInt1() {
		return sCInterface.getMyInt1();
	}

	public void setMyInt1(int value) {
		sCInterface.setMyInt1(value);
	}
	public int getMyInt2() {
		return sCInterface.getMyInt2();
	}

	public void setMyInt2(int value) {
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
	public int getPlus() {
		return sCInterface.getPlus();
	}

	public void setPlus(int value) {
		sCInterface.setPlus(value);
	}
	public int getMinus() {
		return sCInterface.getMinus();
	}

	public void setMinus(int value) {
		sCInterface.setMinus(value);
	}
	public int getMultiply() {
		return sCInterface.getMultiply();
	}

	public void setMultiply(int value) {
		sCInterface.setMultiply(value);
	}
	public int getDivision() {
		return sCInterface.getDivision();
	}

	public void setDivision(int value) {
		sCInterface.setDivision(value);
	}
	public int getModulo() {
		return sCInterface.getModulo();
	}

	public void setModulo(int value) {
		sCInterface.setModulo(value);
	}
	public int getNegat() {
		return sCInterface.getNegat();
	}

	public void setNegat(int value) {
		sCInterface.setNegat(value);
	}
	public boolean getComplement() {
		return sCInterface.getComplement();
	}

	public void setComplement(boolean value) {
		sCInterface.setComplement(value);
	}
	public int getMultiAssign() {
		return sCInterface.getMultiAssign();
	}

	public void setMultiAssign(int value) {
		sCInterface.setMultiAssign(value);
	}
	public int getDivAssign() {
		return sCInterface.getDivAssign();
	}

	public void setDivAssign(int value) {
		sCInterface.setDivAssign(value);
	}
	public int getPlusAssign() {
		return sCInterface.getPlusAssign();
	}

	public void setPlusAssign(int value) {
		sCInterface.setPlusAssign(value);
	}
	public int getMinusAssign() {
		return sCInterface.getMinusAssign();
	}

	public void setMinusAssign(int value) {
		sCInterface.setMinusAssign(value);
	}
	public int getModuloAssign() {
		return sCInterface.getModuloAssign();
	}

	public void setModuloAssign(int value) {
		sCInterface.setModuloAssign(value);
	}

	/* Entry action for statechart 'IntegerExpressions'. */
	private void entryAction() {
	}

	/* Exit action for state 'IntegerExpressions'. */
	private void exitAction() {
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (sCInterface.e1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

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
