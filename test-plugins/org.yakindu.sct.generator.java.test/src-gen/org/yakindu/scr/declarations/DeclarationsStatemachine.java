package org.yakindu.scr.declarations;

public class DeclarationsStatemachine implements IDeclarationsStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

		private boolean evA;

		public void raiseEvA() {
			evA = true;
		}

		private boolean evB;

		public boolean isRaisedEvB() {
			return evB;
		}

		protected void raiseEvB() {
			evB = true;
		}

		private boolean evC;

		private boolean evCValue;

		public void raiseEvC(boolean value) {
			evC = true;
			evCValue = value;
		}

		protected boolean getEvCValue() {
			if (!evC)
				throw new IllegalStateException("Illegal event value acces. Event EvC is not raised!");
			return evCValue;
		}

		private boolean evD;

		private long evDValue;

		public boolean isRaisedEvD() {
			return evD;
		}

		protected void raiseEvD(long value) {
			evD = true;
			evDValue = value;
		}

		public long getEvDValue() {
			if (!evD)
				throw new IllegalStateException("Illegal event value acces. Event EvD is not raised!");
			return evDValue;
		}

		private boolean evE;

		private double evEValue;

		public void raiseEvE(double value) {
			evE = true;
			evEValue = value;
		}

		protected double getEvEValue() {
			if (!evE)
				throw new IllegalStateException("Illegal event value acces. Event EvE is not raised!");
			return evEValue;
		}

		private boolean evF;

		private String evFValue;

		public boolean isRaisedEvF() {
			return evF;
		}

		protected void raiseEvF(String value) {
			evF = true;
			evFValue = value;
		}

		public String getEvFValue() {
			if (!evF)
				throw new IllegalStateException("Illegal event value acces. Event EvF is not raised!");
			return evFValue;
		}

		private boolean varA;

		public boolean getVarA() {
			return varA;
		}

		public void setVarA(boolean value) {
			this.varA = value;
		}

		private long varB;

		public long getVarB() {
			return varB;
		}

		public void setVarB(long value) {
			this.varB = value;
		}

		private double varC;

		public double getVarC() {
			return varC;
		}

		public void setVarC(double value) {
			this.varC = value;
		}

		private String varD;

		public String getVarD() {
			return varD;
		}

		public void setVarD(String value) {
			this.varD = value;
		}

		private long varE;

		public long getVarE() {
			return varE;
		}

		public void setVarE(long value) {
			this.varE = value;
		}

		protected void clearEvents() {
			evA = false;
			evC = false;
			evE = false;
		}

		protected void clearOutEvents() {
			evB = false;
			evD = false;
			evF = false;
		}
	}

	protected SCInterfaceImpl sCInterface;

	protected class SCIIfAImpl implements SCIIfA {

		private boolean evA;

		public void raiseEvA() {
			evA = true;
		}

		private boolean evB;

		public boolean isRaisedEvB() {
			return evB;
		}

		protected void raiseEvB() {
			evB = true;
		}

		private boolean evC;

		private boolean evCValue;

		public void raiseEvC(boolean value) {
			evC = true;
			evCValue = value;
		}

		protected boolean getEvCValue() {
			if (!evC)
				throw new IllegalStateException("Illegal event value acces. Event EvC is not raised!");
			return evCValue;
		}

		private boolean evD;

		private long evDValue;

		public boolean isRaisedEvD() {
			return evD;
		}

		protected void raiseEvD(long value) {
			evD = true;
			evDValue = value;
		}

		public long getEvDValue() {
			if (!evD)
				throw new IllegalStateException("Illegal event value acces. Event EvD is not raised!");
			return evDValue;
		}

		private boolean evE;

		private double evEValue;

		public void raiseEvE(double value) {
			evE = true;
			evEValue = value;
		}

		protected double getEvEValue() {
			if (!evE)
				throw new IllegalStateException("Illegal event value acces. Event EvE is not raised!");
			return evEValue;
		}

		private boolean evF;

		private String evFValue;

		public boolean isRaisedEvF() {
			return evF;
		}

		protected void raiseEvF(String value) {
			evF = true;
			evFValue = value;
		}

		public String getEvFValue() {
			if (!evF)
				throw new IllegalStateException("Illegal event value acces. Event EvF is not raised!");
			return evFValue;
		}

		private boolean varA;

		public boolean getVarA() {
			return varA;
		}

		public void setVarA(boolean value) {
			this.varA = value;
		}

		private long varB;

		public long getVarB() {
			return varB;
		}

		public void setVarB(long value) {
			this.varB = value;
		}

		private double varC;

		public double getVarC() {
			return varC;
		}

		public void setVarC(double value) {
			this.varC = value;
		}

		private String varD;

		public String getVarD() {
			return varD;
		}

		public void setVarD(String value) {
			this.varD = value;
		}

		private long varE;

		public long getVarE() {
			return varE;
		}

		public void setVarE(long value) {
			this.varE = value;
		}

		protected void clearEvents() {
			evA = false;
			evC = false;
			evE = false;
		}

		protected void clearOutEvents() {
			evB = false;
			evD = false;
			evF = false;
		}
	}

	protected SCIIfAImpl sCIIfA;

	private boolean initialized = false;

	public enum State {
		main_region_A, main_region_B, $NullState$
	};

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private boolean evInA;

	private boolean evInB;

	private boolean evInC;

	private boolean evInCValue;

	private boolean evInD;

	private long evInDValue;

	private boolean evInE;

	private double evInEValue;

	private boolean evInF;

	private String evInFValue;

	private boolean varInA;

	protected void setVarInA(boolean value) {
		varInA = value;
	}

	protected boolean getVarInA() {
		return varInA;
	}

	private long varInB;

	protected void setVarInB(long value) {
		varInB = value;
	}

	protected long getVarInB() {
		return varInB;
	}

	private double varInC;

	protected void setVarInC(double value) {
		varInC = value;
	}

	protected double getVarInC() {
		return varInC;
	}

	private String varInD;

	protected void setVarInD(String value) {
		varInD = value;
	}

	protected String getVarInD() {
		return varInD;
	}

	private long varInE;

	protected void setVarInE(long value) {
		varInE = value;
	}

	protected long getVarInE() {
		return varInE;
	}

	public DeclarationsStatemachine() {

		sCInterface = new SCInterfaceImpl();
		sCIIfA = new SCIIfAImpl();
	}

	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.setVarA(false);

		sCInterface.setVarB(1);

		sCInterface.setVarC(1.0);

		sCInterface.setVarD("myString");

		sCInterface.setVarE(16);

		sCIIfA.setVarA(false);

		sCIIfA.setVarB(1);

		sCIIfA.setVarC(1.0);

		sCIIfA.setVarD("myString");

		sCIIfA.setVarE(16);

		setVarInA(false);

		setVarInB(1);

		setVarInC(1.0);

		setVarInD("myString");

		setVarInE(16);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

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
		sCIIfA.clearEvents();
		evInA = false;
		evInB = false;
		evInC = false;
		evInD = false;
		evInE = false;
		evInF = false;

	}

	/**
	* This method resets the outgoing events.
	*/
	protected void clearOutEvents() {
		sCInterface.clearOutEvents();
		sCIIfA.clearOutEvents();
	}

	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
		switch (state) {
			case main_region_A :
				return stateVector[0] == State.main_region_A;
			case main_region_B :
				return stateVector[0] == State.main_region_B;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}
	public SCIIfA getSCIIfA() {
		return sCIIfA;
	}

	private void raiseEvInA() {
		evInA = true;
	}

	private void raiseEvInB() {
		evInB = true;
	}

	private void raiseEvInC(boolean value) {
		evInCValue = value;
		evInC = true;
	}

	private boolean getEvInCValue() {
		if (!evInC)
			throw new IllegalStateException("Illegal event value acces. Event EvInC is not raised!");
		return evInCValue;
	}
	private void raiseEvInD(long value) {
		evInDValue = value;
		evInD = true;
	}

	private long getEvInDValue() {
		if (!evInD)
			throw new IllegalStateException("Illegal event value acces. Event EvInD is not raised!");
		return evInDValue;
	}
	private void raiseEvInE(double value) {
		evInEValue = value;
		evInE = true;
	}

	private double getEvInEValue() {
		if (!evInE)
			throw new IllegalStateException("Illegal event value acces. Event EvInE is not raised!");
		return evInEValue;
	}
	private void raiseEvInF(String value) {
		evInFValue = value;
		evInF = true;
	}

	private String getEvInFValue() {
		if (!evInF)
			throw new IllegalStateException("Illegal event value acces. Event EvInF is not raised!");
		return evInFValue;
	}

	public void raiseEvA() {
		sCInterface.raiseEvA();
	}
	public boolean isRaisedEvB() {
		return sCInterface.isRaisedEvB();
	}
	public void raiseEvC(boolean value) {
		sCInterface.raiseEvC(value);
	}
	public boolean isRaisedEvD() {
		return sCInterface.isRaisedEvD();
	}
	public long getEvDValue() {
		return sCInterface.getEvDValue();
	}
	public void raiseEvE(double value) {
		sCInterface.raiseEvE(value);
	}
	public boolean isRaisedEvF() {
		return sCInterface.isRaisedEvF();
	}
	public String getEvFValue() {
		return sCInterface.getEvFValue();
	}

	public boolean getVarA() {
		return sCInterface.getVarA();
	}

	public void setVarA(boolean value) {
		sCInterface.setVarA(value);
	}
	public long getVarB() {
		return sCInterface.getVarB();
	}

	public void setVarB(long value) {
		sCInterface.setVarB(value);
	}
	public double getVarC() {
		return sCInterface.getVarC();
	}

	public void setVarC(double value) {
		sCInterface.setVarC(value);
	}
	public String getVarD() {
		return sCInterface.getVarD();
	}

	public void setVarD(String value) {
		sCInterface.setVarD(value);
	}
	public long getVarE() {
		return sCInterface.getVarE();
	}

	public void setVarE(long value) {
		sCInterface.setVarE(value);
	}

	private boolean check_main_region_A_tr0_tr0() {
		return evInA;
	}

	private boolean check_main_region_A_tr1_tr1() {
		return evInC;
	}

	private boolean check_main_region_B_tr0_tr0() {
		return evInB;
	}

	private boolean check_main_region_B_tr1_tr1() {
		return evInD;
	}

	private boolean check_main_region_B_tr2_tr2() {
		return evInE;
	}

	private boolean check_main_region_B_tr3_tr3() {
		return evInF;
	}

	private void effect_main_region_A_tr0() {
		exitSequence_main_region_A();

		enterSequence_main_region_B_default();
	}

	private void effect_main_region_A_tr1() {
		exitSequence_main_region_A();

		enterSequence_main_region_A_default();
	}

	private void effect_main_region_B_tr0() {
		exitSequence_main_region_B();

		enterSequence_main_region_A_default();
	}

	private void effect_main_region_B_tr1() {
		exitSequence_main_region_B();

		enterSequence_main_region_B_default();
	}

	private void effect_main_region_B_tr2() {
		exitSequence_main_region_B();

		enterSequence_main_region_B_default();
	}

	private void effect_main_region_B_tr3() {
		exitSequence_main_region_B();

		enterSequence_main_region_A_default();
	}

	/* Entry action for statechart 'Declarations'. */
	private void entryAction() {
	}

	/* Entry action for state 'A'. */
	private void entryAction_main_region_A() {
		setVarInA(false);

		setVarInB(1);

		setVarInC(1.1);

		setVarInD("blub");

		setVarInE(1);
	}

	/* Exit action for state 'Declarations'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		entryAction_main_region_A();

		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
	}

	/* 'default' enter sequence for state B */
	private void enterSequence_main_region_B_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_B;
	}

	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}

	/* Default exit sequence for state A */
	private void exitSequence_main_region_A() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state B */
	private void exitSequence_main_region_B() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequence_main_region_A();
				break;

			case main_region_B :
				exitSequence_main_region_B();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void react_main_region_A() {
		if (check_main_region_A_tr0_tr0()) {
			effect_main_region_A_tr0();
		} else {
			if (check_main_region_A_tr1_tr1()) {
				effect_main_region_A_tr1();
			}
		}
	}

	/* The reactions of state B. */
	private void react_main_region_B() {
		if (check_main_region_B_tr0_tr0()) {
			effect_main_region_B_tr0();
		} else {
			if (check_main_region_B_tr1_tr1()) {
				effect_main_region_B_tr1();
			} else {
				if (check_main_region_B_tr2_tr2()) {
					effect_main_region_B_tr2();
				} else {
					if (check_main_region_B_tr3_tr3()) {
						effect_main_region_B_tr3();
					}
				}
			}
		}
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					react_main_region_A();
					break;
				case main_region_B :
					react_main_region_B();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
