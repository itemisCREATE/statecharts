package org.yakindu.scr.integerexpressions;

public class IntegerExpressionsStatemachine
		implements
			IIntegerExpressionsStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

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

		private int multiAssign = 2;

		public int getMultiAssign() {
			return multiAssign;
		}

		public void setMultiAssign(int value) {
			this.multiAssign = value;
		}

		private int divAssign = 20;

		public int getDivAssign() {
			return divAssign;
		}

		public void setDivAssign(int value) {
			this.divAssign = value;
		}

		private int plusAssign = 2;

		public int getPlusAssign() {
			return plusAssign;
		}

		public void setPlusAssign(int value) {
			this.plusAssign = value;
		}

		private int minusAssign = 2;

		public int getMinusAssign() {
			return minusAssign;
		}

		public void setMinusAssign(int value) {
			this.minusAssign = value;
		}

		private int moduloAssign = 20;

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

	private SCIDefaultImpl sCIDefault;

	public enum State {
		Main_region_StateA, Main_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public IntegerExpressionsStatemachine() {

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
		for (int i = 0; i < stateVector.length; i++) {
			if (stateVector[i] == state) {
				return true;
			}
		}
		return false;
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseE1() {
		sCIDefault.raiseE1();
	}

	public int getMyInt1() {
		return sCIDefault.getMyInt1();
	}

	public void setMyInt1(int value) {
		sCIDefault.setMyInt1(value);
	}
	public int getMyInt2() {
		return sCIDefault.getMyInt2();
	}

	public void setMyInt2(int value) {
		sCIDefault.setMyInt2(value);
	}
	public boolean getLess() {
		return sCIDefault.getLess();
	}

	public void setLess(boolean value) {
		sCIDefault.setLess(value);
	}
	public boolean getGreater() {
		return sCIDefault.getGreater();
	}

	public void setGreater(boolean value) {
		sCIDefault.setGreater(value);
	}
	public boolean getEqualOrLess() {
		return sCIDefault.getEqualOrLess();
	}

	public void setEqualOrLess(boolean value) {
		sCIDefault.setEqualOrLess(value);
	}
	public boolean getEqualOrGreater() {
		return sCIDefault.getEqualOrGreater();
	}

	public void setEqualOrGreater(boolean value) {
		sCIDefault.setEqualOrGreater(value);
	}
	public boolean getEqual() {
		return sCIDefault.getEqual();
	}

	public void setEqual(boolean value) {
		sCIDefault.setEqual(value);
	}
	public boolean getNotEqual() {
		return sCIDefault.getNotEqual();
	}

	public void setNotEqual(boolean value) {
		sCIDefault.setNotEqual(value);
	}
	public int getPlus() {
		return sCIDefault.getPlus();
	}

	public void setPlus(int value) {
		sCIDefault.setPlus(value);
	}
	public int getMinus() {
		return sCIDefault.getMinus();
	}

	public void setMinus(int value) {
		sCIDefault.setMinus(value);
	}
	public int getMultiply() {
		return sCIDefault.getMultiply();
	}

	public void setMultiply(int value) {
		sCIDefault.setMultiply(value);
	}
	public int getDivision() {
		return sCIDefault.getDivision();
	}

	public void setDivision(int value) {
		sCIDefault.setDivision(value);
	}
	public int getModulo() {
		return sCIDefault.getModulo();
	}

	public void setModulo(int value) {
		sCIDefault.setModulo(value);
	}
	public int getNegat() {
		return sCIDefault.getNegat();
	}

	public void setNegat(int value) {
		sCIDefault.setNegat(value);
	}
	public boolean getComplement() {
		return sCIDefault.getComplement();
	}

	public void setComplement(boolean value) {
		sCIDefault.setComplement(value);
	}
	public int getMultiAssign() {
		return sCIDefault.getMultiAssign();
	}

	public void setMultiAssign(int value) {
		sCIDefault.setMultiAssign(value);
	}
	public int getDivAssign() {
		return sCIDefault.getDivAssign();
	}

	public void setDivAssign(int value) {
		sCIDefault.setDivAssign(value);
	}
	public int getPlusAssign() {
		return sCIDefault.getPlusAssign();
	}

	public void setPlusAssign(int value) {
		sCIDefault.setPlusAssign(value);
	}
	public int getMinusAssign() {
		return sCIDefault.getMinusAssign();
	}

	public void setMinusAssign(int value) {
		sCIDefault.setMinusAssign(value);
	}
	public int getModuloAssign() {
		return sCIDefault.getModuloAssign();
	}

	public void setModuloAssign(int value) {
		sCIDefault.setModuloAssign(value);
	}

	public void enter() {
		sCIDefault.setMultiAssign(2);
		sCIDefault.setDivAssign(20);
		sCIDefault.setPlusAssign(2);
		sCIDefault.setMinusAssign(2);
		sCIDefault.setModuloAssign(20);
		entryActionIntegerExpressions();
		sCIDefault.setMyInt1(10);
		sCIDefault.setMyInt2(5);

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

		exitActionIntegerExpressions();
	}

	private void entryActionIntegerExpressions() {

	}

	private void exitActionIntegerExpressions() {

	}

	private void reactMain_region_StateA() {
		if (sCIDefault.e1) {
			stateVector[0] = State.$NullState$;

			sCIDefault
					.setLess((sCIDefault.getMyInt1() < sCIDefault.getMyInt2()));
			sCIDefault.setGreater((sCIDefault.getMyInt1() > sCIDefault
					.getMyInt2()));
			sCIDefault.setEqualOrLess((sCIDefault.getMyInt1() <= sCIDefault
					.getMyInt2()));
			sCIDefault.setEqualOrGreater((sCIDefault.getMyInt1() >= sCIDefault
					.getMyInt2()));
			sCIDefault.setEqual((sCIDefault.getMyInt1() == sCIDefault
					.getMyInt2()));
			sCIDefault.setNotEqual((sCIDefault.getMyInt1() != sCIDefault
					.getMyInt2()));
			sCIDefault
					.setPlus((sCIDefault.getMyInt1() + sCIDefault.getMyInt2()));
			sCIDefault.setMinus((sCIDefault.getMyInt1() - sCIDefault
					.getMyInt2()));
			sCIDefault.setMultiply((sCIDefault.getMyInt1() * sCIDefault
					.getMyInt2()));
			sCIDefault.setDivision((sCIDefault.getMyInt1() / sCIDefault
					.getMyInt2()));
			sCIDefault.setModulo((sCIDefault.getMyInt1() % sCIDefault
					.getMyInt2()));
			sCIDefault.setNegat(-(sCIDefault.getMyInt1()));
			sCIDefault.setMultiAssign(sCIDefault.getMultiAssign()
					* (sCIDefault.getMyInt1()));
			sCIDefault.setDivAssign(sCIDefault.getDivAssign()
					/ (sCIDefault.getMyInt1()));
			sCIDefault.setPlusAssign(sCIDefault.getPlusAssign()
					+ (sCIDefault.getMyInt1()));
			sCIDefault.setMinusAssign(sCIDefault.getMinusAssign()
					- (sCIDefault.getMyInt1()));
			sCIDefault.setModuloAssign(sCIDefault.getModuloAssign()
					% (sCIDefault.getMyInt1()));

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
