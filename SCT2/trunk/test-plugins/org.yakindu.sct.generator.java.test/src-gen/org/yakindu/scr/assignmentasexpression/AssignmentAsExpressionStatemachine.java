package org.yakindu.scr.assignmentasexpression;

public class AssignmentAsExpressionStatemachine
		implements
			IAssignmentAsExpressionStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private int a;

		public int getA() {
			return a;
		}

		public void setA(int value) {
			this.a = value;
		}

		private int b;

		public int getB() {
			return b;
		}

		public void setB(int value) {
			this.b = value;
		}

		private int c;

		public int getC() {
			return c;
		}

		public void setC(int value) {
			this.c = value;
		}

		private int d;

		public int getD() {
			return d;
		}

		public void setD(int value) {
			this.d = value;
		}

		private int e;

		public int getE() {
			return e;
		}

		public void setE(int value) {
			this.e = value;
		}

		private int f;

		public int getF() {
			return f;
		}

		public void setF(int value) {
			this.f = value;
		}

		private int g;

		public int getG() {
			return g;
		}

		public void setG(int value) {
			this.g = value;
		}

		private int h;

		public int getH() {
			return h;
		}

		public void setH(int value) {
			this.h = value;
		}

		private int i;

		public int getI() {
			return i;
		}

		public void setI(int value) {
			this.i = value;
		}

		private int i1;

		public int getI1() {
			return i1;
		}

		public void setI1(int value) {
			this.i1 = value;
		}

		private int j;

		public int getJ() {
			return j;
		}

		public void setJ(int value) {
			this.j = value;
		}

		private int j1;

		public int getJ1() {
			return j1;
		}

		public void setJ1(int value) {
			this.j1 = value;
		}

		private int k;

		public int getK() {
			return k;
		}

		public void setK(int value) {
			this.k = value;
		}

		private int k1;

		public int getK1() {
			return k1;
		}

		public void setK1(int value) {
			this.k1 = value;
		}

		private int l;

		public int getL() {
			return l;
		}

		public void setL(int value) {
			this.l = value;
		}

		private int m;

		public int getM() {
			return m;
		}

		public void setM(int value) {
			this.m = value;
		}

		private int n;

		public int getN() {
			return n;
		}

		public void setN(int value) {
			this.n = value;
		}

		private int p;

		public int getP() {
			return p;
		}

		public void setP(int value) {
			this.p = value;
		}

		private int r;

		public int getR() {
			return r;
		}

		public void setR(int value) {
			this.r = value;
		}

		private int t;

		public int getT() {
			return t;
		}

		public void setT(int value) {
			this.t = value;
		}

		private int u;

		public int getU() {
			return u;
		}

		public void setU(int value) {
			this.u = value;
		}

		private int v;

		public int getV() {
			return v;
		}

		public void setV(int value) {
			this.v = value;
		}

		private int w;

		public int getW() {
			return w;
		}

		public void setW(int value) {
			this.w = value;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		main_region_Add, main_region_Subtract, main_region_Multiply, main_region_Divide, main_region_Modulo, main_region_Shift, main_region_boolean_And, main_region_boolean_Or, main_region_boolean_Xor, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public AssignmentAsExpressionStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCIDefault.a = 0;

		sCIDefault.b = 0;

		sCIDefault.c = 0;

		sCIDefault.d = 0;

		sCIDefault.e = 1;

		sCIDefault.f = 1;

		sCIDefault.g = 4;

		sCIDefault.h = 32;

		sCIDefault.i = 7;

		sCIDefault.i1 = 7;

		sCIDefault.j = 8;

		sCIDefault.j1 = 2;

		sCIDefault.k = 8;

		sCIDefault.k1 = 4;

		sCIDefault.l = 3;

		sCIDefault.m = 7;

		sCIDefault.n = 5;

		sCIDefault.p = 0;

		sCIDefault.r = 7;

		sCIDefault.t = 10;

		sCIDefault.u = 6;

		sCIDefault.v = 13;

		sCIDefault.w = 7;
	}

	public void enter() {
		entryAction();

		sCIDefault.a = (sCIDefault.b = 5) + 4;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Add;
	}

	public void exit() {
		switch (stateVector[0]) {
			case main_region_Add :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Multiply :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Divide :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Modulo :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_Shift :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_boolean_And :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_boolean_Or :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case main_region_boolean_Xor :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
	}

	protected void clearEvents() {

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_Add :
				return stateVector[0] == State.main_region_Add;
			case main_region_Subtract :
				return stateVector[0] == State.main_region_Subtract;
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
			default :
				return false;
		}
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public int getA() {
		return sCIDefault.getA();
	}

	public void setA(int value) {
		sCIDefault.setA(value);
	}
	public int getB() {
		return sCIDefault.getB();
	}

	public void setB(int value) {
		sCIDefault.setB(value);
	}
	public int getC() {
		return sCIDefault.getC();
	}

	public void setC(int value) {
		sCIDefault.setC(value);
	}
	public int getD() {
		return sCIDefault.getD();
	}

	public void setD(int value) {
		sCIDefault.setD(value);
	}
	public int getE() {
		return sCIDefault.getE();
	}

	public void setE(int value) {
		sCIDefault.setE(value);
	}
	public int getF() {
		return sCIDefault.getF();
	}

	public void setF(int value) {
		sCIDefault.setF(value);
	}
	public int getG() {
		return sCIDefault.getG();
	}

	public void setG(int value) {
		sCIDefault.setG(value);
	}
	public int getH() {
		return sCIDefault.getH();
	}

	public void setH(int value) {
		sCIDefault.setH(value);
	}
	public int getI() {
		return sCIDefault.getI();
	}

	public void setI(int value) {
		sCIDefault.setI(value);
	}
	public int getI1() {
		return sCIDefault.getI1();
	}

	public void setI1(int value) {
		sCIDefault.setI1(value);
	}
	public int getJ() {
		return sCIDefault.getJ();
	}

	public void setJ(int value) {
		sCIDefault.setJ(value);
	}
	public int getJ1() {
		return sCIDefault.getJ1();
	}

	public void setJ1(int value) {
		sCIDefault.setJ1(value);
	}
	public int getK() {
		return sCIDefault.getK();
	}

	public void setK(int value) {
		sCIDefault.setK(value);
	}
	public int getK1() {
		return sCIDefault.getK1();
	}

	public void setK1(int value) {
		sCIDefault.setK1(value);
	}
	public int getL() {
		return sCIDefault.getL();
	}

	public void setL(int value) {
		sCIDefault.setL(value);
	}
	public int getM() {
		return sCIDefault.getM();
	}

	public void setM(int value) {
		sCIDefault.setM(value);
	}
	public int getN() {
		return sCIDefault.getN();
	}

	public void setN(int value) {
		sCIDefault.setN(value);
	}
	public int getP() {
		return sCIDefault.getP();
	}

	public void setP(int value) {
		sCIDefault.setP(value);
	}
	public int getR() {
		return sCIDefault.getR();
	}

	public void setR(int value) {
		sCIDefault.setR(value);
	}
	public int getT() {
		return sCIDefault.getT();
	}

	public void setT(int value) {
		sCIDefault.setT(value);
	}
	public int getU() {
		return sCIDefault.getU();
	}

	public void setU(int value) {
		sCIDefault.setU(value);
	}
	public int getV() {
		return sCIDefault.getV();
	}

	public void setV(int value) {
		sCIDefault.setV(value);
	}
	public int getW() {
		return sCIDefault.getW();
	}

	public void setW(int value) {
		sCIDefault.setW(value);
	}

	/* Entry action for statechart 'AssignmentAsExpression'. */
	private void entryAction() {
	}

	/* Exit action for state 'AssignmentAsExpression'. */
	private void exitAction() {
	}

	/* The reactions of state Add. */
	private void reactMain_region_Add() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCIDefault.d -= (sCIDefault.c -= 5) - 1;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Subtract;
	}

	/* The reactions of state Subtract. */
	private void reactMain_region_Subtract() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCIDefault.e *= (sCIDefault.f *= 5) * 3;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Multiply;
	}

	/* The reactions of state Multiply. */
	private void reactMain_region_Multiply() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCIDefault.g /= (sCIDefault.h /= 2) / 4;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Divide;
	}

	/* The reactions of state Divide. */
	private void reactMain_region_Divide() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCIDefault.i %= (sCIDefault.i1 %= 4) % 4;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Modulo;
	}

	/* The reactions of state Modulo. */
	private void reactMain_region_Modulo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCIDefault.j <<= (sCIDefault.j1 >>= 1);

		sCIDefault.k >>= (sCIDefault.k1 >>= 2);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Shift;
	}

	/* The reactions of state Shift. */
	private void reactMain_region_Shift() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCIDefault.l &= (sCIDefault.n &= sCIDefault.m);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_boolean_And;
	}

	/* The reactions of state boolean And. */
	private void reactMain_region_boolean_And() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCIDefault.p |= (sCIDefault.r |= sCIDefault.t);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_boolean_Or;
	}

	/* The reactions of state boolean Or. */
	private void reactMain_region_boolean_Or() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCIDefault.u ^= (sCIDefault.v ^= sCIDefault.w);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_boolean_Xor;
	}

	/* The reactions of state boolean Xor. */
	private void reactMain_region_boolean_Xor() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Add :
					reactMain_region_Add();
					break;
				case main_region_Subtract :
					reactMain_region_Subtract();
					break;
				case main_region_Multiply :
					reactMain_region_Multiply();
					break;
				case main_region_Divide :
					reactMain_region_Divide();
					break;
				case main_region_Modulo :
					reactMain_region_Modulo();
					break;
				case main_region_Shift :
					reactMain_region_Shift();
					break;
				case main_region_boolean_And :
					reactMain_region_boolean_And();
					break;
				case main_region_boolean_Or :
					reactMain_region_boolean_Or();
					break;
				case main_region_boolean_Xor :
					reactMain_region_boolean_Xor();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
