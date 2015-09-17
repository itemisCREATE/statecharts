package org.yakindu.scr.realexpressions;

public class RealExpressionsStatemachine implements IRealExpressionsStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

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

		protected double assignMyReal1(double value) {
			return this.myReal1 = value;
		}

		private double myReal2;

		public double getMyReal2() {
			return myReal2;
		}

		public void setMyReal2(double value) {
			this.myReal2 = value;
		}

		private double myFloat;

		public double getMyFloat() {
			return myFloat;
		}

		public void setMyFloat(double value) {
			this.myFloat = value;
		}

		private double myDouble;

		public double getMyDouble() {
			return myDouble;
		}

		public void setMyDouble(double value) {
			this.myDouble = value;
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

		protected void clearEvents() {
			e1 = false;
		}

	}

	protected SCInterfaceImpl sCInterface;

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

		sCInterface.setMyReal1(0.0);

		sCInterface.setMyReal2(0.0);

		sCInterface.setMyFloat(1.0);

		sCInterface.setMyDouble(2.0);

		sCInterface.setLess(false);

		sCInterface.setGreater(false);

		sCInterface.setEqualOrLess(false);

		sCInterface.setEqualOrGreater(false);

		sCInterface.setEqual(false);

		sCInterface.setNotEqual(false);

		sCInterface.setPlus(false);

		sCInterface.setMinus(false);

		sCInterface.setMultiply(false);

		sCInterface.setDivision(false);

		sCInterface.setModulo(false);

		sCInterface.setNegat(0.0);

		sCInterface.setComplement(false);

		sCInterface.setMultiAssign(2.2);

		sCInterface.setDivAssign(22.79);

		sCInterface.setPlusAssign(2.2);

		sCInterface.setMinusAssign(8.6);

		sCInterface.setModuloAssign(false);
	}

	public void enter() {
		entryAction();

		enterSequence_main_region_default();
	}

	public void exit() {
		exitSequence_main_region();

		exitAction();
	}

	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {

		return stateVector[0] != State.$NullState$;
	}

	/** 
	* Always returns 'false' since this state machine can never become final.
	*
	 * @see IStatemachine#isFinal() 
	 */
	public boolean isFinal() {
		return false;
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
	public double getMyFloat() {
		return sCInterface.getMyFloat();
	}

	public void setMyFloat(double value) {
		sCInterface.setMyFloat(value);
	}
	public double getMyDouble() {
		return sCInterface.getMyDouble();
	}

	public void setMyDouble(double value) {
		sCInterface.setMyDouble(value);
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

	private boolean check_main_region_StateA_tr0_tr0() {
		return sCInterface.e1;
	}

	private void effect_main_region_StateA_tr0() {
		exitSequence_main_region_StateA();

		enterSequence_main_region_StateB_default();
	}

	/* Entry action for statechart 'RealExpressions'. */
	private void entryAction() {
	}

	/* Entry action for state 'StateA'. */
	private void entryAction_main_region_StateA() {
		sCInterface.setMyReal1(5.3);

		sCInterface.setMyReal2(10.6);

		sCInterface.setMyFloat(3.3);

		sCInterface.setMyDouble(4.4);
	}

	/* Entry action for state 'StateB'. */
	private void entryAction_main_region_StateB() {
		sCInterface.setLess(sCInterface.myReal1 < sCInterface.myReal2);

		sCInterface.setGreater(sCInterface.myReal1 > sCInterface.myReal2);

		sCInterface.setEqualOrLess(sCInterface.myReal1 <= sCInterface.myReal2);

		sCInterface.setEqualOrGreater(sCInterface.myReal1 >= sCInterface.myReal2);

		sCInterface.setEqual(sCInterface.myReal1 == sCInterface.myReal2);

		sCInterface.setNotEqual(sCInterface.myReal1 != sCInterface.myReal2);

		sCInterface.setPlus((15.89 <= (sCInterface.myReal1 + sCInterface.myReal2)
				&& (sCInterface.myReal1 + sCInterface.myReal2) <= 16.91));

		sCInterface.setMinus((5.29 <= (sCInterface.myReal2 - sCInterface.myReal1)
				&& (sCInterface.myReal1 - sCInterface.myReal2) <= 5.31));

		sCInterface.setMultiply((56.17 <= (sCInterface.myReal1 * sCInterface.myReal2)
				&& (sCInterface.myReal1 * sCInterface.myReal2) <= 56.19));

		sCInterface.setDivision((1.9 <= (sCInterface.myReal2 / sCInterface.myReal1)
				&& (sCInterface.myReal1 / sCInterface.myReal2) <= 2.1));

		sCInterface.setModulo((-0.1 <= (sCInterface.myReal2 % sCInterface.myReal1)
				&& (sCInterface.myReal1 % sCInterface.myReal2) <= 0.1));

		sCInterface.setNegat(-sCInterface.myReal1);

		sCInterface.setMultiAssign(sCInterface.getMultiAssign() * sCInterface.myReal1);

		sCInterface.setDivAssign(sCInterface.getDivAssign() / sCInterface.myReal1);

		sCInterface.setPlusAssign(sCInterface.getPlusAssign() + sCInterface.myReal1);

		sCInterface.setMinusAssign(sCInterface.getMinusAssign() - sCInterface.myReal1);

		sCInterface
				.setModuloAssign((-0.1 <= (sCInterface.assignMyReal1(sCInterface.getMyReal1() % sCInterface.myReal1))));
	}

	/* Exit action for state 'RealExpressions'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_StateA_default() {
		entryAction_main_region_StateA();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateA;
	}

	/* 'default' enter sequence for state StateB */
	private void enterSequence_main_region_StateB_default() {
		entryAction_main_region_StateB();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_StateB;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state StateB */
	private void exitSequence_main_region_StateB() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_StateA :
				exitSequence_main_region_StateA();
				break;

			case main_region_StateB :
				exitSequence_main_region_StateB();
				break;

			default :
				break;
		}
	}

	/* The reactions of state StateA. */
	private void react_main_region_StateA() {
		if (check_main_region_StateA_tr0_tr0()) {
			effect_main_region_StateA_tr0();
		}
	}

	/* The reactions of state StateB. */
	private void react_main_region_StateB() {
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_StateA_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_StateA :
					react_main_region_StateA();
					break;
				case main_region_StateB :
					react_main_region_StateB();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
