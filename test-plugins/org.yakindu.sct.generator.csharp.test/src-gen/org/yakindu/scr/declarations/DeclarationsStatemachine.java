package org.yakindu.scr.declarations;

public class DeclarationsStatemachine implements IDeclarationsStatemachine {
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

	private final class SCInterfaceImpl implements SCInterface {

		private boolean evA;

		public void raiseEvA() {
			evA = true;
		}

		private boolean evB;

		public boolean isRaisedEvB() {
			return evB;
		}

		private void raiseEvB() {
			evB = true;
		}

		private boolean evC;

		private boolean evCValue;

		public void raiseEvC(boolean value) {
			evC = true;
			evCValue = value;
		}

		private boolean getEvCValue() {
			if (!evC)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvC is not raised!");
			return evCValue;
		}

		private boolean evD;

		private long evDValue;

		public boolean isRaisedEvD() {
			return evD;
		}

		private void raiseEvD(long value) {
			evD = true;
			evDValue = value;
		}

		public long getEvDValue() {
			if (!evD)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvD is not raised!");
			return evDValue;
		}

		private boolean evE;

		private double evEValue;

		public void raiseEvE(double value) {
			evE = true;
			evEValue = value;
		}

		private double getEvEValue() {
			if (!evE)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvE is not raised!");
			return evEValue;
		}

		private boolean evF;

		private String evFValue;

		public boolean isRaisedEvF() {
			return evF;
		}

		private void raiseEvF(String value) {
			evF = true;
			evFValue = value;
		}

		public String getEvFValue() {
			if (!evF)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvF is not raised!");
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

		public void clearEvents() {
			evA = false;
			evC = false;
			evE = false;
		}

		public void clearOutEvents() {
			evB = false;
			evD = false;
			evF = false;
		}
	}

	private SCInterfaceImpl sCInterface;
	private final class SCIIfAImpl implements SCIIfA {

		private boolean evA;

		public void raiseEvA() {
			evA = true;
		}

		private boolean evB;

		public boolean isRaisedEvB() {
			return evB;
		}

		private void raiseEvB() {
			evB = true;
		}

		private boolean evC;

		private boolean evCValue;

		public void raiseEvC(boolean value) {
			evC = true;
			evCValue = value;
		}

		private boolean getEvCValue() {
			if (!evC)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvC is not raised!");
			return evCValue;
		}

		private boolean evD;

		private long evDValue;

		public boolean isRaisedEvD() {
			return evD;
		}

		private void raiseEvD(long value) {
			evD = true;
			evDValue = value;
		}

		public long getEvDValue() {
			if (!evD)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvD is not raised!");
			return evDValue;
		}

		private boolean evE;

		private double evEValue;

		public void raiseEvE(double value) {
			evE = true;
			evEValue = value;
		}

		private double getEvEValue() {
			if (!evE)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvE is not raised!");
			return evEValue;
		}

		private boolean evF;

		private String evFValue;

		public boolean isRaisedEvF() {
			return evF;
		}

		private void raiseEvF(String value) {
			evF = true;
			evFValue = value;
		}

		public String getEvFValue() {
			if (!evF)
				throw new IllegalStateException(
						"Illegal event value acces. Event EvF is not raised!");
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

		public void clearEvents() {
			evA = false;
			evC = false;
			evE = false;
		}

		public void clearOutEvents() {
			evB = false;
			evD = false;
			evF = false;
		}
	}

	private SCIIfAImpl sCIIfA;

	public enum State {
		main_region_A, $NullState$
	};

	private boolean varInA;
	private long varInB;
	private double varInC;
	private String varInD;
	private long varInE;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public DeclarationsStatemachine() {

		sCInterface = new SCInterfaceImpl();
		sCIIfA = new SCIIfAImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

		sCInterface.varA = false;

		sCInterface.varB = 1;

		sCInterface.varC = 1.0;

		sCInterface.varD = "myString";

		sCInterface.varE = 16;

		sCIIfA.varA = false;

		sCIIfA.varB = 1;

		sCIIfA.varC = 1.0;

		sCIIfA.varD = "myString";

		sCIIfA.varE = 16;

		varInA = false;

		varInB = 1;

		varInC = 1.0;

		varInD = "myString";

		varInE = 16;
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
	@Override
	public boolean isActive() {

		return stateVector[0] != State.$NullState$;
	}

	/** 
	 * Always returns 'false' since this state machine can never become final.
	 *
	 * @see IStatemachine#isFinal() 
	 */
	@Override
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
			throw new IllegalStateException(
					"Illegal event value acces. Event EvInC is not raised!");
		return evInCValue;
	}
	private void raiseEvInD(long value) {
		evInDValue = value;
		evInD = true;
	}

	private long getEvInDValue() {
		if (!evInD)
			throw new IllegalStateException(
					"Illegal event value acces. Event EvInD is not raised!");
		return evInDValue;
	}
	private void raiseEvInE(double value) {
		evInEValue = value;
		evInE = true;
	}

	private double getEvInEValue() {
		if (!evInE)
			throw new IllegalStateException(
					"Illegal event value acces. Event EvInE is not raised!");
		return evInEValue;
	}
	private void raiseEvInF(String value) {
		evInFValue = value;
		evInF = true;
	}

	private String getEvInFValue() {
		if (!evInF)
			throw new IllegalStateException(
					"Illegal event value acces. Event EvInF is not raised!");
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

	/* Entry action for statechart 'Declarations'. */
	private void entryAction() {
	}

	/* Exit action for state 'Declarations'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state A */
	private void enterSequence_main_region_A_default() {
		nextStateIndex = 0;
		stateVector[0] = State.main_region_A;
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

	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
			case main_region_A :
				exitSequence_main_region_A();
				break;

			default :
				break;
		}
	}

	/* The reactions of state A. */
	private void react_main_region_A() {
	}

	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_A_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case main_region_A :
					react_main_region_A();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
