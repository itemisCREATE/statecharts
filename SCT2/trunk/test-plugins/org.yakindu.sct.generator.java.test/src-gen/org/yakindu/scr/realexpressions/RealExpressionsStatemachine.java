package org.yakindu.scr.realexpressions;

public class RealExpressionsStatemachine
		implements
			IRealExpressionsStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

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

		private double multiAssign;

		public double getMultiAssign() {
			return multiAssign;
		}

		public void setMultiAssign(double value) {
			this.multiAssign = value;
		}

		private double divAssign;

		public double getDivAssign() {
			return divAssign;
		}

		public void setDivAssign(double value) {
			this.divAssign = value;
		}

		private double plusAssign;

		public double getPlusAssign() {
			return plusAssign;
		}

		public void setPlusAssign(double value) {
			this.plusAssign = value;
		}

		private double minusAssign;

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

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_StateA, main_region_StateB, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public RealExpressionsStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.myReal1 = 0.0;

		sCInterface.myReal2 = 0.0;

		sCInterface.less = false;

		sCInterface.greater = false;

		sCInterface.equalOrLess = false;

		sCInterface.equalOrGreater = false;

		sCInterface.equal = false;

		sCInterface.notEqual = false;

		sCInterface.plus = false;

		sCInterface.minus = false;

		sCInterface.multiply = false;

		sCInterface.division = false;

		sCInterface.modulo = false;

		sCInterface.negat = 0.0;

		sCInterface.complement = false;

		sCInterface.multiAssign = 2.2;

		sCInterface.divAssign = 22.79;

		sCInterface.plusAssign = 2.2;

		sCInterface.minusAssign = 8.6;

		sCInterface.moduloAssign = false;
	}

	public void enter() {
		entryAction();

		sCInterface.myReal1 = 5.3;

		sCInterface.myReal2 = 10.6;

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

	public double getMyReal1() {
		return sCInterface.getMyReal1();
	}

	public void setMyReal1(double value) {
		sCInterface.setMyReal1(value);
	}
	public double getMyReal2() {
		return sCInterface.getMyReal2();
	}

	public void setMyReal2(double value) {
		sCInterface.setMyReal2(value);
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
	public boolean getPlus() {
		return sCInterface.getPlus();
	}

	public void setPlus(boolean value) {
		sCInterface.setPlus(value);
	}
	public boolean getMinus() {
		return sCInterface.getMinus();
	}

	public void setMinus(boolean value) {
		sCInterface.setMinus(value);
	}
	public boolean getMultiply() {
		return sCInterface.getMultiply();
	}

	public void setMultiply(boolean value) {
		sCInterface.setMultiply(value);
	}
	public boolean getDivision() {
		return sCInterface.getDivision();
	}

	public void setDivision(boolean value) {
		sCInterface.setDivision(value);
	}
	public boolean getModulo() {
		return sCInterface.getModulo();
	}

	public void setModulo(boolean value) {
		sCInterface.setModulo(value);
	}
	public double getNegat() {
		return sCInterface.getNegat();
	}

	public void setNegat(double value) {
		sCInterface.setNegat(value);
	}
	public boolean getComplement() {
		return sCInterface.getComplement();
	}

	public void setComplement(boolean value) {
		sCInterface.setComplement(value);
	}
	public double getMultiAssign() {
		return sCInterface.getMultiAssign();
	}

	public void setMultiAssign(double value) {
		sCInterface.setMultiAssign(value);
	}
	public double getDivAssign() {
		return sCInterface.getDivAssign();
	}

	public void setDivAssign(double value) {
		sCInterface.setDivAssign(value);
	}
	public double getPlusAssign() {
		return sCInterface.getPlusAssign();
	}

	public void setPlusAssign(double value) {
		sCInterface.setPlusAssign(value);
	}
	public double getMinusAssign() {
		return sCInterface.getMinusAssign();
	}

	public void setMinusAssign(double value) {
		sCInterface.setMinusAssign(value);
	}
	public boolean getModuloAssign() {
		return sCInterface.getModuloAssign();
	}

	public void setModuloAssign(boolean value) {
		sCInterface.setModuloAssign(value);
	}

	/* Entry action for statechart 'RealExpressions'. */
	private void entryAction() {
	}

	/* Exit action for state 'RealExpressions'. */
	private void exitAction() {
	}

	/* The reactions of state StateA. */
	private void reactMain_region_StateA() {
		if (sCInterface.e1) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.less = sCInterface.myReal1 < sCInterface.myReal2;

			sCInterface.greater = sCInterface.myReal1 > sCInterface.myReal2;

			sCInterface.equalOrLess = sCInterface.myReal1 <= sCInterface.myReal2;

			sCInterface.equalOrGreater = sCInterface.myReal1 >= sCInterface.myReal2;

			sCInterface.equal = sCInterface.myReal1 == sCInterface.myReal2;

			sCInterface.notEqual = sCInterface.myReal1 != sCInterface.myReal2;

			sCInterface.plus = (15.89 <= (sCInterface.myReal1 + sCInterface.myReal2) && (sCInterface.myReal1 + sCInterface.myReal2) <= 16.91);

			sCInterface.minus = (5.29 <= (sCInterface.myReal2 - sCInterface.myReal1) && (sCInterface.myReal1 - sCInterface.myReal2) <= 5.31);

			sCInterface.multiply = (56.17 <= (sCInterface.myReal1 * sCInterface.myReal2) && (sCInterface.myReal1 * sCInterface.myReal2) <= 56.19);

			sCInterface.division = (1.9 <= (sCInterface.myReal2 / sCInterface.myReal1) && (sCInterface.myReal1 / sCInterface.myReal2) <= 2.1);

			sCInterface.modulo = (-0.1 <= (sCInterface.myReal2 % sCInterface.myReal1) && (sCInterface.myReal1 % sCInterface.myReal2) <= 0.1);

			sCInterface.negat = -sCInterface.myReal1;

			sCInterface.multiAssign *= sCInterface.myReal1;

			sCInterface.divAssign /= sCInterface.myReal1;

			sCInterface.plusAssign += sCInterface.myReal1;

			sCInterface.minusAssign -= sCInterface.myReal1;

			sCInterface.moduloAssign = (-0.1 <= (sCInterface.myReal1 %= sCInterface.myReal1));

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
