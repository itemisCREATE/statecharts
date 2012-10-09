package org.yakindu.scr.realexpressions;

public class RealExpressionsStatemachine
		implements
			IRealExpressionsStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		private double myReal1;

		public double getMyReal1() {
			return myReal1;
		}

		public void setMyReal1(double value) {
			this.myReal1 = value;
		}

		private double myReal2;

		public double getMyReal2() {
			return myReal2;
		}

		public void setMyReal2(double value) {
			this.myReal2 = value;
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

		private boolean plus;

		public boolean getPlus() {
			return plus;
		}

		public void setPlus(boolean value) {
			this.plus = value;
		}

		private boolean minus;

		public boolean getMinus() {
			return minus;
		}

		public void setMinus(boolean value) {
			this.minus = value;
		}

		private boolean multiply;

		public boolean getMultiply() {
			return multiply;
		}

		public void setMultiply(boolean value) {
			this.multiply = value;
		}

		private boolean division;

		public boolean getDivision() {
			return division;
		}

		public void setDivision(boolean value) {
			this.division = value;
		}

		private boolean modulo;

		public boolean getModulo() {
			return modulo;
		}

		public void setModulo(boolean value) {
			this.modulo = value;
		}

		private double negat;

		public double getNegat() {
			return negat;
		}

		public void setNegat(double value) {
			this.negat = value;
		}

		private boolean complement;

		public boolean getComplement() {
			return complement;
		}

		public void setComplement(boolean value) {
			this.complement = value;
		}

		private double multiAssign = 2.2;

		public double getMultiAssign() {
			return multiAssign;
		}

		public void setMultiAssign(double value) {
			this.multiAssign = value;
		}

		private double divAssign = 22.79;

		public double getDivAssign() {
			return divAssign;
		}

		public void setDivAssign(double value) {
			this.divAssign = value;
		}

		private double plusAssign = 2.2;

		public double getPlusAssign() {
			return plusAssign;
		}

		public void setPlusAssign(double value) {
			this.plusAssign = value;
		}

		private double minusAssign = 8.6;

		public double getMinusAssign() {
			return minusAssign;
		}

		public void setMinusAssign(double value) {
			this.minusAssign = value;
		}

		private boolean moduloAssign;

		public boolean getModuloAssign() {
			return moduloAssign;
		}

		public void setModuloAssign(boolean value) {
			this.moduloAssign = value;
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

	public RealExpressionsStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();
	}

	public void enter() {
		sCIDefault.multiAssign = 2.2;

		sCIDefault.divAssign = 22.79;

		sCIDefault.plusAssign = 2.2;

		sCIDefault.minusAssign = 8.6;

		entryAction();

		sCIDefault.myReal1 = 5.3;

		sCIDefault.myReal2 = 10.6;

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

	public double getMyReal1() {
		return sCIDefault.getMyReal1();
	}

	public void setMyReal1(double value) {
		sCIDefault.setMyReal1(value);
	}
	public double getMyReal2() {
		return sCIDefault.getMyReal2();
	}

	public void setMyReal2(double value) {
		sCIDefault.setMyReal2(value);
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
	public boolean getPlus() {
		return sCIDefault.getPlus();
	}

	public void setPlus(boolean value) {
		sCIDefault.setPlus(value);
	}
	public boolean getMinus() {
		return sCIDefault.getMinus();
	}

	public void setMinus(boolean value) {
		sCIDefault.setMinus(value);
	}
	public boolean getMultiply() {
		return sCIDefault.getMultiply();
	}

	public void setMultiply(boolean value) {
		sCIDefault.setMultiply(value);
	}
	public boolean getDivision() {
		return sCIDefault.getDivision();
	}

	public void setDivision(boolean value) {
		sCIDefault.setDivision(value);
	}
	public boolean getModulo() {
		return sCIDefault.getModulo();
	}

	public void setModulo(boolean value) {
		sCIDefault.setModulo(value);
	}
	public double getNegat() {
		return sCIDefault.getNegat();
	}

	public void setNegat(double value) {
		sCIDefault.setNegat(value);
	}
	public boolean getComplement() {
		return sCIDefault.getComplement();
	}

	public void setComplement(boolean value) {
		sCIDefault.setComplement(value);
	}
	public double getMultiAssign() {
		return sCIDefault.getMultiAssign();
	}

	public void setMultiAssign(double value) {
		sCIDefault.setMultiAssign(value);
	}
	public double getDivAssign() {
		return sCIDefault.getDivAssign();
	}

	public void setDivAssign(double value) {
		sCIDefault.setDivAssign(value);
	}
	public double getPlusAssign() {
		return sCIDefault.getPlusAssign();
	}

	public void setPlusAssign(double value) {
		sCIDefault.setPlusAssign(value);
	}
	public double getMinusAssign() {
		return sCIDefault.getMinusAssign();
	}

	public void setMinusAssign(double value) {
		sCIDefault.setMinusAssign(value);
	}
	public boolean getModuloAssign() {
		return sCIDefault.getModuloAssign();
	}

	public void setModuloAssign(boolean value) {
		sCIDefault.setModuloAssign(value);
	}

	/* Entry action for statechart 'RealExpressions'. */
	private void entryAction() {
	}

	/* Exit action for state 'RealExpressions'. */
	private void exitAction() {
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (sCIDefault.e1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIDefault.less = sCIDefault.myReal1 < sCIDefault.myReal2;

			sCIDefault.greater = sCIDefault.myReal1 > sCIDefault.myReal2;

			sCIDefault.equalOrLess = sCIDefault.myReal1 <= sCIDefault.myReal2;

			sCIDefault.equalOrGreater = sCIDefault.myReal1 >= sCIDefault.myReal2;

			sCIDefault.equal = sCIDefault.myReal1 == sCIDefault.myReal2;

			sCIDefault.notEqual = sCIDefault.myReal1 != sCIDefault.myReal2;

			sCIDefault.plus = (15.89 <= (sCIDefault.myReal1 + sCIDefault.myReal2) && (sCIDefault.myReal1 + sCIDefault.myReal2) <= 16.91);

			sCIDefault.minus = (5.29 <= (sCIDefault.myReal2 - sCIDefault.myReal1) && (sCIDefault.myReal1 - sCIDefault.myReal2) <= 5.31);

			sCIDefault.multiply = (56.17 <= (sCIDefault.myReal1 * sCIDefault.myReal2) && (sCIDefault.myReal1 * sCIDefault.myReal2) <= 56.19);

			sCIDefault.division = (1.9 <= (sCIDefault.myReal2 / sCIDefault.myReal1) && (sCIDefault.myReal1 / sCIDefault.myReal2) <= 2.1);

			sCIDefault.modulo = (-0.1 <= (sCIDefault.myReal2 % sCIDefault.myReal1) && (sCIDefault.myReal1 % sCIDefault.myReal2) <= 0.1);

			sCIDefault.negat = -sCIDefault.myReal1;

			sCIDefault.multiAssign *= sCIDefault.myReal1;

			sCIDefault.divAssign /= sCIDefault.myReal1;

			sCIDefault.plusAssign += sCIDefault.myReal1;

			sCIDefault.minusAssign -= sCIDefault.myReal1;

			sCIDefault.moduloAssign = (-0.1 <= (sCIDefault.myReal1 %= sCIDefault.myReal1));

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
