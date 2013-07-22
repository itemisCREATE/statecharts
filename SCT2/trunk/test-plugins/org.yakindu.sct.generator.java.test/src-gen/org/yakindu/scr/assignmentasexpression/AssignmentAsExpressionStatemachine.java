package org.yakindu.scr.assignmentasexpression;

public class AssignmentAsExpressionStatemachine
		implements
			IAssignmentAsExpressionStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

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

	private SCInterfaceImpl sCInterface;

	public enum State {
		main_region_Add, main_region_Multiply, main_region_Divide, main_region_Modulo, main_region_Shift, main_region_boolean_And, main_region_boolean_Or, main_region_boolean_Xor, main_region_Subtract, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public AssignmentAsExpressionStatemachine() {

		sCInterface = new SCInterfaceImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.a = 0;

		sCInterface.b = 0;

		sCInterface.c = 0;

		sCInterface.d = 0;

		sCInterface.e = 1;

		sCInterface.f = 1;

		sCInterface.g = 4;

		sCInterface.h = 32;

		sCInterface.i = 7;

		sCInterface.i1 = 7;

		sCInterface.j = 8;

		sCInterface.j1 = 2;

		sCInterface.k = 8;

		sCInterface.k1 = 4;

		sCInterface.l = 3;

		sCInterface.m = 7;

		sCInterface.n = 5;

		sCInterface.p = 0;

		sCInterface.r = 7;

		sCInterface.t = 10;

		sCInterface.u = 6;

		sCInterface.v = 13;

		sCInterface.w = 7;
	}

	public void enter() {
		entryAction();

		sCInterface.a = (sCInterface.b = 5) + 4;

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

			case main_region_Subtract :
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

	public int getA() {
		return sCInterface.getA();
	}

	public void setA(int value) {
		sCInterface.setA(value);
	}
	public int getB() {
		return sCInterface.getB();
	}

	public void setB(int value) {
		sCInterface.setB(value);
	}
	public int getC() {
		return sCInterface.getC();
	}

	public void setC(int value) {
		sCInterface.setC(value);
	}
	public int getD() {
		return sCInterface.getD();
	}

	public void setD(int value) {
		sCInterface.setD(value);
	}
	public int getE() {
		return sCInterface.getE();
	}

	public void setE(int value) {
		sCInterface.setE(value);
	}
	public int getF() {
		return sCInterface.getF();
	}

	public void setF(int value) {
		sCInterface.setF(value);
	}
	public int getG() {
		return sCInterface.getG();
	}

	public void setG(int value) {
		sCInterface.setG(value);
	}
	public int getH() {
		return sCInterface.getH();
	}

	public void setH(int value) {
		sCInterface.setH(value);
	}
	public int getI() {
		return sCInterface.getI();
	}

	public void setI(int value) {
		sCInterface.setI(value);
	}
	public int getI1() {
		return sCInterface.getI1();
	}

	public void setI1(int value) {
		sCInterface.setI1(value);
	}
	public int getJ() {
		return sCInterface.getJ();
	}

	public void setJ(int value) {
		sCInterface.setJ(value);
	}
	public int getJ1() {
		return sCInterface.getJ1();
	}

	public void setJ1(int value) {
		sCInterface.setJ1(value);
	}
	public int getK() {
		return sCInterface.getK();
	}

	public void setK(int value) {
		sCInterface.setK(value);
	}
	public int getK1() {
		return sCInterface.getK1();
	}

	public void setK1(int value) {
		sCInterface.setK1(value);
	}
	public int getL() {
		return sCInterface.getL();
	}

	public void setL(int value) {
		sCInterface.setL(value);
	}
	public int getM() {
		return sCInterface.getM();
	}

	public void setM(int value) {
		sCInterface.setM(value);
	}
	public int getN() {
		return sCInterface.getN();
	}

	public void setN(int value) {
		sCInterface.setN(value);
	}
	public int getP() {
		return sCInterface.getP();
	}

	public void setP(int value) {
		sCInterface.setP(value);
	}
	public int getR() {
		return sCInterface.getR();
	}

	public void setR(int value) {
		sCInterface.setR(value);
	}
	public int getT() {
		return sCInterface.getT();
	}

	public void setT(int value) {
		sCInterface.setT(value);
	}
	public int getU() {
		return sCInterface.getU();
	}

	public void setU(int value) {
		sCInterface.setU(value);
	}
	public int getV() {
		return sCInterface.getV();
	}

	public void setV(int value) {
		sCInterface.setV(value);
	}
	public int getW() {
		return sCInterface.getW();
	}

	public void setW(int value) {
		sCInterface.setW(value);
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

		sCInterface.d -= (sCInterface.c -= 5) - 1;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Subtract;
	}

	/* The reactions of state Multiply. */
	private void reactMain_region_Multiply() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.g /= (sCInterface.h /= 2) / 4;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Divide;
	}

	/* The reactions of state Divide. */
	private void reactMain_region_Divide() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.i %= (sCInterface.i1 %= 4) % 4;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Modulo;
	}

	/* The reactions of state Modulo. */
	private void reactMain_region_Modulo() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.j <<= (sCInterface.j1 >>= 1);

		sCInterface.k >>= (sCInterface.k1 >>= 2);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Shift;
	}

	/* The reactions of state Shift. */
	private void reactMain_region_Shift() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.l &= (sCInterface.n &= sCInterface.m);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_boolean_And;
	}

	/* The reactions of state boolean And. */
	private void reactMain_region_boolean_And() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.p |= (sCInterface.r |= sCInterface.t);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_boolean_Or;
	}

	/* The reactions of state boolean Or. */
	private void reactMain_region_boolean_Or() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.u ^= (sCInterface.v ^= sCInterface.w);

		nextStateIndex = 0;
		stateVector[0] = State.main_region_boolean_Xor;
	}

	/* The reactions of state boolean Xor. */
	private void reactMain_region_boolean_Xor() {
	}

	/* The reactions of state Subtract. */
	private void reactMain_region_Subtract() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;

		sCInterface.e *= (sCInterface.f *= 5) * 3;

		nextStateIndex = 0;
		stateVector[0] = State.main_region_Multiply;
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_Add :
					reactMain_region_Add();
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
				case main_region_Subtract :
					reactMain_region_Subtract();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
