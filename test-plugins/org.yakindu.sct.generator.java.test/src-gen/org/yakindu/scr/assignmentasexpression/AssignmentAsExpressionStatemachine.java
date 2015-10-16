package org.yakindu.scr.assignmentasexpression;

public class AssignmentAsExpressionStatemachine implements IAssignmentAsExpressionStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

		private long a;

		public long getA() {
			return a;
		}

		public void setA(long value) {
			this.a = value;
		}

		private long b;

		public long getB() {
			return b;
		}

		public void setB(long value) {
			this.b = value;
		}

		protected long assignB(long value) {
			return this.b = value;
		}

		private long c;

		public long getC() {
			return c;
		}

		public void setC(long value) {
			this.c = value;
		}

		protected long assignC(long value) {
			return this.c = value;
		}

		private long d;

		public long getD() {
			return d;
		}

		public void setD(long value) {
			this.d = value;
		}

		private long e;

		public long getE() {
			return e;
		}

		public void setE(long value) {
			this.e = value;
		}

		private long f;

		public long getF() {
			return f;
		}

		public void setF(long value) {
			this.f = value;
		}

		protected long assignF(long value) {
			return this.f = value;
		}

		private long g;

		public long getG() {
			return g;
		}

		public void setG(long value) {
			this.g = value;
		}

		private long h;

		public long getH() {
			return h;
		}

		public void setH(long value) {
			this.h = value;
		}

		protected long assignH(long value) {
			return this.h = value;
		}

		private long i;

		public long getI() {
			return i;
		}

		public void setI(long value) {
			this.i = value;
		}

		private long i1;

		public long getI1() {
			return i1;
		}

		public void setI1(long value) {
			this.i1 = value;
		}

		protected long assignI1(long value) {
			return this.i1 = value;
		}

		private long j;

		public long getJ() {
			return j;
		}

		public void setJ(long value) {
			this.j = value;
		}

		private long j1;

		public long getJ1() {
			return j1;
		}

		public void setJ1(long value) {
			this.j1 = value;
		}

		protected long assignJ1(long value) {
			return this.j1 = value;
		}

		private long k;

		public long getK() {
			return k;
		}

		public void setK(long value) {
			this.k = value;
		}

		private long k1;

		public long getK1() {
			return k1;
		}

		public void setK1(long value) {
			this.k1 = value;
		}

		protected long assignK1(long value) {
			return this.k1 = value;
		}

		private long l;

		public long getL() {
			return l;
		}

		public void setL(long value) {
			this.l = value;
		}

		private long m;

		public long getM() {
			return m;
		}

		public void setM(long value) {
			this.m = value;
		}

		private long n;

		public long getN() {
			return n;
		}

		public void setN(long value) {
			this.n = value;
		}

		protected long assignN(long value) {
			return this.n = value;
		}

		private long p;

		public long getP() {
			return p;
		}

		public void setP(long value) {
			this.p = value;
		}

		private long r;

		public long getR() {
			return r;
		}

		public void setR(long value) {
			this.r = value;
		}

		protected long assignR(long value) {
			return this.r = value;
		}

		private long t;

		public long getT() {
			return t;
		}

		public void setT(long value) {
			this.t = value;
		}

		private long u;

		public long getU() {
			return u;
		}

		public void setU(long value) {
			this.u = value;
		}

		private long v;

		public long getV() {
			return v;
		}

		public void setV(long value) {
			this.v = value;
		}

		protected long assignV(long value) {
			return this.v = value;
		}

		private long w;

		public long getW() {
			return w;
		}

		public void setW(long value) {
			this.w = value;
		}

	}

	protected SCInterfaceImpl sCInterface;

	private boolean initialized = false;

	public enum State {
		main_region_Add, main_region_Multiply, main_region_Divide, main_region_Modulo, main_region_Shift, main_region_boolean_And, main_region_boolean_Or, main_region_boolean_Xor, main_region_Subtract, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public AssignmentAsExpressionStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.setA(0);

		sCInterface.setB(0);

		sCInterface.setC(0);

		sCInterface.setD(0);

		sCInterface.setE(1);

		sCInterface.setF(1);

		sCInterface.setG(4);

		sCInterface.setH(32);

		sCInterface.setI(7);

		sCInterface.setI1(7);

		sCInterface.setJ(8);

		sCInterface.setJ1(2);

		sCInterface.setK(8);

		sCInterface.setK1(4);

		sCInterface.setL(3);

		sCInterface.setM(7);

		sCInterface.setN(5);

		sCInterface.setP(0);

		sCInterface.setR(7);

		sCInterface.setT(10);

		sCInterface.setU(6);

		sCInterface.setV(13);

		sCInterface.setW(7);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		entryAction();

		enterSequence_main_region_default();
	}

	public void exit() {
		initialized = false;
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
			case main_region_Add :
				return stateVector[0] == State.main_region_Add;
			case main_region_Multiply :
				return stateVector[0] == State.main_region_Multiply;
			case main_region_Divide :
				return stateVector[0] == State.main_region_Divide;
			case main_region_Modulo :
				return stateVector[0] == State.main_region_Modulo;
			case main_region_Shift :
				return stateVector[0] == State.main_region_Shift;
			case main_region_boolean_And :
				return stateVector[0] == State.main_region_boolean_And;
			case main_region_boolean_Or :
				return stateVector[0] == State.main_region_boolean_Or;
			case main_region_boolean_Xor :
				return stateVector[0] == State.main_region_boolean_Xor;
			case main_region_Subtract :
				return stateVector[0] == State.main_region_Subtract;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public long getA() {
		return sCInterface.getA();
	}

	public void setA(long value) {
		sCInterface.setA(value);
	}
	public long getB() {
		return sCInterface.getB();
	}

	public void setB(long value) {
		sCInterface.setB(value);
	}
	public long getC() {
		return sCInterface.getC();
	}

	public void setC(long value) {
		sCInterface.setC(value);
	}
	public long getD() {
		return sCInterface.getD();
	}

	public void setD(long value) {
		sCInterface.setD(value);
	}
	public long getE() {
		return sCInterface.getE();
	}

	public void setE(long value) {
		sCInterface.setE(value);
	}
	public long getF() {
		return sCInterface.getF();
	}

	public void setF(long value) {
		sCInterface.setF(value);
	}
	public long getG() {
		return sCInterface.getG();
	}

	public void setG(long value) {
		sCInterface.setG(value);
	}
	public long getH() {
		return sCInterface.getH();
	}

	public void setH(long value) {
		sCInterface.setH(value);
	}
	public long getI() {
		return sCInterface.getI();
	}

	public void setI(long value) {
		sCInterface.setI(value);
	}
	public long getI1() {
		return sCInterface.getI1();
	}

	public void setI1(long value) {
		sCInterface.setI1(value);
	}
	public long getJ() {
		return sCInterface.getJ();
	}

	public void setJ(long value) {
		sCInterface.setJ(value);
	}
	public long getJ1() {
		return sCInterface.getJ1();
	}

	public void setJ1(long value) {
		sCInterface.setJ1(value);
	}
	public long getK() {
		return sCInterface.getK();
	}

	public void setK(long value) {
		sCInterface.setK(value);
	}
	public long getK1() {
		return sCInterface.getK1();
	}

	public void setK1(long value) {
		sCInterface.setK1(value);
	}
	public long getL() {
		return sCInterface.getL();
	}

	public void setL(long value) {
		sCInterface.setL(value);
	}
	public long getM() {
		return sCInterface.getM();
	}

	public void setM(long value) {
		sCInterface.setM(value);
	}
	public long getN() {
		return sCInterface.getN();
	}

	public void setN(long value) {
		sCInterface.setN(value);
	}
	public long getP() {
		return sCInterface.getP();
	}

	public void setP(long value) {
		sCInterface.setP(value);
	}
	public long getR() {
		return sCInterface.getR();
	}

	public void setR(long value) {
		sCInterface.setR(value);
	}
	public long getT() {
		return sCInterface.getT();
	}

	public void setT(long value) {
		sCInterface.setT(value);
	}
	public long getU() {
		return sCInterface.getU();
	}

	public void setU(long value) {
		sCInterface.setU(value);
	}
	public long getV() {
		return sCInterface.getV();
	}

	public void setV(long value) {
		sCInterface.setV(value);
	}
	public long getW() {
		return sCInterface.getW();
	}

	public void setW(long value) {
		sCInterface.setW(value);
	}

	private boolean check_main_region_Add_tr0_tr0() {
		return true;
	}

	private boolean check_main_region_Multiply_tr0_tr0() {
		return true;
	}

	private boolean check_main_region_Divide_tr0_tr0() {
		return true;
	}

	private boolean check_main_region_Modulo_tr0_tr0() {
		return true;
	}

	private boolean check_main_region_Shift_tr0_tr0() {
		return true;
	}

	private boolean check_main_region_boolean_And_tr0_tr0() {
		return true;
	}

	private boolean check_main_region_boolean_Or_tr0_tr0() {
		return true;
	}

	private boolean check_main_region_Subtract_tr0_tr0() {
		return true;
	}

	private void effect_main_region_Add_tr0() {
		exitSequence_main_region_Add();

		enterSequence_main_region_Subtract_default();
	}

	private void effect_main_region_Multiply_tr0() {
		exitSequence_main_region_Multiply();

		enterSequence_main_region_Divide_default();
	}

	private void effect_main_region_Divide_tr0() {
		exitSequence_main_region_Divide();

		enterSequence_main_region_Modulo_default();
	}

	private void effect_main_region_Modulo_tr0() {
		exitSequence_main_region_Modulo();

		enterSequence_main_region_Shift_default();
	}

	private void effect_main_region_Shift_tr0() {
		exitSequence_main_region_Shift();

		enterSequence_main_region_boolean_And_default();
	}

	private void effect_main_region_boolean_And_tr0() {
		exitSequence_main_region_boolean_And();

		enterSequence_main_region_boolean_Or_default();
	}

	private void effect_main_region_boolean_Or_tr0() {
		exitSequence_main_region_boolean_Or();

		enterSequence_main_region_boolean_Xor_default();
	}

	private void effect_main_region_Subtract_tr0() {
		exitSequence_main_region_Subtract();

		enterSequence_main_region_Multiply_default();
	}

	/* Entry action for statechart 'AssignmentAsExpression'. */
	private void entryAction() {
	}

	/* Entry action for state 'Add'. */
	private void entryAction_main_region_Add() {
		sCInterface.setA((sCInterface.assignB(5)) + 4);
	}

	/* Entry action for state 'Multiply'. */
	private void entryAction_main_region_Multiply() {
		sCInterface.setE(sCInterface.getE() * ((sCInterface.assignF(sCInterface.getF() * 5)) * 3));
	}

	/* Entry action for state 'Divide'. */
	private void entryAction_main_region_Divide() {
		sCInterface.setG(sCInterface.getG() / ((sCInterface.assignH(sCInterface.getH() / 2)) / 4));
	}

	/* Entry action for state 'Modulo'. */
	private void entryAction_main_region_Modulo() {
		sCInterface.setI(sCInterface.getI() % ((sCInterface.assignI1(sCInterface.getI1() % 4)) % 4));
	}

	/* Entry action for state 'Shift'. */
	private void entryAction_main_region_Shift() {
		sCInterface.setJ(sCInterface.getJ() << ((sCInterface.assignJ1(sCInterface.getJ1() >> 1))));

		sCInterface.setK(sCInterface.getK() >> ((sCInterface.assignK1(sCInterface.getK1() >> 2))));
	}

	/* Entry action for state 'boolean And'. */
	private void entryAction_main_region_boolean_And() {
		sCInterface.setL(sCInterface.getL() & ((sCInterface.assignN(sCInterface.getN() & sCInterface.m))));
	}

	/* Entry action for state 'boolean Or'. */
	private void entryAction_main_region_boolean_Or() {
		sCInterface.setP(sCInterface.getP() | ((sCInterface.assignR(sCInterface.getR() | sCInterface.t))));
	}

	/* Entry action for state 'boolean Xor'. */
	private void entryAction_main_region_boolean_Xor() {
		sCInterface.setU(sCInterface.getU() ^ ((sCInterface.assignV(sCInterface.getV() ^ sCInterface.w))));
	}

	/* Entry action for state 'Subtract'. */
	private void entryAction_main_region_Subtract() {
		sCInterface.setD(sCInterface.getD() - ((sCInterface.assignC(sCInterface.getC() - 5)) - 1));
	}

	/* Exit action for state 'AssignmentAsExpression'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state Add */
	private void enterSequence_main_region_Add_default() {
		entryAction_main_region_Add();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Add;
	}

	/* 'default' enter sequence for state Multiply */
	private void enterSequence_main_region_Multiply_default() {
		entryAction_main_region_Multiply();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Multiply;
	}

	/* 'default' enter sequence for state Divide */
	private void enterSequence_main_region_Divide_default() {
		entryAction_main_region_Divide();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Divide;
	}

	/* 'default' enter sequence for state Modulo */
	private void enterSequence_main_region_Modulo_default() {
		entryAction_main_region_Modulo();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Modulo;
	}

	/* 'default' enter sequence for state Shift */
	private void enterSequence_main_region_Shift_default() {
		entryAction_main_region_Shift();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Shift;
	}

	/* 'default' enter sequence for state boolean And */
	private void enterSequence_main_region_boolean_And_default() {
		entryAction_main_region_boolean_And();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_boolean_And;
	}

	/* 'default' enter sequence for state boolean Or */
	private void enterSequence_main_region_boolean_Or_default() {
		entryAction_main_region_boolean_Or();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_boolean_Or;
	}

	/* 'default' enter sequence for state boolean Xor */
	private void enterSequence_main_region_boolean_Xor_default() {
		entryAction_main_region_boolean_Xor();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_boolean_Xor;
	}

	/* 'default' enter sequence for state Subtract */
	private void enterSequence_main_region_Subtract_default() {
		entryAction_main_region_Subtract();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Subtract;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* Default exit sequence for state Add */
	private void exitSequence_main_region_Add() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Multiply */
	private void exitSequence_main_region_Multiply() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Divide */
	private void exitSequence_main_region_Divide() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Modulo */
	private void exitSequence_main_region_Modulo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Shift */
	private void exitSequence_main_region_Shift() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state boolean And */
	private void exitSequence_main_region_boolean_And() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state boolean Or */
	private void exitSequence_main_region_boolean_Or() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state boolean Xor */
	private void exitSequence_main_region_boolean_Xor() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state Subtract */
	private void exitSequence_main_region_Subtract() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_Add :
				exitSequence_main_region_Add();
				break;

			case main_region_Multiply :
				exitSequence_main_region_Multiply();
				break;

			case main_region_Divide :
				exitSequence_main_region_Divide();
				break;

			case main_region_Modulo :
				exitSequence_main_region_Modulo();
				break;

			case main_region_Shift :
				exitSequence_main_region_Shift();
				break;

			case main_region_boolean_And :
				exitSequence_main_region_boolean_And();
				break;

			case main_region_boolean_Or :
				exitSequence_main_region_boolean_Or();
				break;

			case main_region_boolean_Xor :
				exitSequence_main_region_boolean_Xor();
				break;

			case main_region_Subtract :
				exitSequence_main_region_Subtract();
				break;

			default :
				break;
		}
	}

	/* The reactions of state Add. */
	private void react_main_region_Add() {
		effect_main_region_Add_tr0();
	}

	/* The reactions of state Multiply. */
	private void react_main_region_Multiply() {
		effect_main_region_Multiply_tr0();
	}

	/* The reactions of state Divide. */
	private void react_main_region_Divide() {
		effect_main_region_Divide_tr0();
	}

	/* The reactions of state Modulo. */
	private void react_main_region_Modulo() {
		effect_main_region_Modulo_tr0();
	}

	/* The reactions of state Shift. */
	private void react_main_region_Shift() {
		effect_main_region_Shift_tr0();
	}

	/* The reactions of state boolean And. */
	private void react_main_region_boolean_And() {
		effect_main_region_boolean_And_tr0();
	}

	/* The reactions of state boolean Or. */
	private void react_main_region_boolean_Or() {
		effect_main_region_boolean_Or_tr0();
	}

	/* The reactions of state boolean Xor. */
	private void react_main_region_boolean_Xor() {
	}

	/* The reactions of state Subtract. */
	private void react_main_region_Subtract() {
		effect_main_region_Subtract_tr0();
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_Add_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Add :
					react_main_region_Add();
					break;
				case main_region_Multiply :
					react_main_region_Multiply();
					break;
				case main_region_Divide :
					react_main_region_Divide();
					break;
				case main_region_Modulo :
					react_main_region_Modulo();
					break;
				case main_region_Shift :
					react_main_region_Shift();
					break;
				case main_region_boolean_And :
					react_main_region_boolean_And();
					break;
				case main_region_boolean_Or :
					react_main_region_boolean_Or();
					break;
				case main_region_boolean_Xor :
					react_main_region_boolean_Xor();
					break;
				case main_region_Subtract :
					react_main_region_Subtract();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
