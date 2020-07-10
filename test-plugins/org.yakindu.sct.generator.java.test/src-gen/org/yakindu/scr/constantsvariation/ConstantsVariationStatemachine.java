/** Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.scr.constantsvariation;


public class ConstantsVariationStatemachine implements IConstantsVariationStatemachine {
	protected class InterfaceImpl implements Interface {
	
		public boolean getB2() {
			return b2;
		}
		
		public String getStr2() {
			return str2;
		}
		
		public double getR2() {
			return r2;
		}
		
		public long getI2() {
			return i2;
		}
		
	}
	
	protected class InterfaceNamedImpl implements InterfaceNamed {
	
		public boolean getB() {
			return b;
		}
		
		public String getStr() {
			return str;
		}
		
		public double getR() {
			return r;
		}
		
		public long getI() {
			return i;
		}
		
	}
	
	protected InterfaceImpl defaultInterface;
	
	protected InterfaceNamedImpl interfaceNamed;
	
	private boolean initialized = false;
	
	public enum State {
		MAIN_REGION_STATEA,
		MAIN_REGION__FINAL_,
		$NULLSTATE$
	};
	
	private final State[] stateVector = new State[1];
	
	private int nextStateIndex;
	
	protected boolean getB() {
		return b;
	}
	
	
	protected String getStr() {
		return str;
	}
	
	
	protected double getR() {
		return r;
	}
	
	
	protected long getI() {
		return i;
	}
	
	
	private boolean isExecuting;
	
	protected boolean getIsExecuting() {
		return isExecuting;
	}
	
	protected void setIsExecuting(boolean value) {
		this.isExecuting = value;
	}
	public ConstantsVariationStatemachine() {
		defaultInterface = new InterfaceImpl();
		interfaceNamed = new InterfaceNamedImpl();
	}
	
	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NULLSTATE$;
		}
		
		
		
		isExecuting = false;
	}
	
	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
			        "The state machine needs to be initialized first by calling the init() function.");
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		enterSequence_main_region_default();
		isExecuting = false;
	}
	
	public void exit() {
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		exitSequence_main_region();
		isExecuting = false;
	}
	
	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
			        "The state machine needs to be initialized first by calling the init() function.");
		
		if (getIsExecuting()) {
			return;
		}
		isExecuting = true;
		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			switch (stateVector[nextStateIndex]) {
			case MAIN_REGION_STATEA:
				main_region_StateA_react(true);
				break;
			case MAIN_REGION__FINAL_:
				main_region__final__react(true);
				break;
			default:
				// $NULLSTATE$
			}
		}
		
		isExecuting = false;
	}
	
	/**
	 * @see IStatemachine#isActive()
	 */
	public boolean isActive() {
		return stateVector[0] != State.$NULLSTATE$;
	}
	
	/** 
	* @see IStatemachine#isFinal()
	*/
	public boolean isFinal() {
		return (stateVector[0] == State.MAIN_REGION__FINAL_);
	}
	/**
	* Returns true if the given state is currently active otherwise false.
	*/
	public boolean isStateActive(State state) {
	
		switch (state) {
		case MAIN_REGION_STATEA:
			return stateVector[0] == State.MAIN_REGION_STATEA;
		case MAIN_REGION__FINAL_:
			return stateVector[0] == State.MAIN_REGION__FINAL_;
		default:
			return false;
		}
	}
	
	public Interface getInterface() {
		return defaultInterface;
	}
	
	public InterfaceNamed getInterfaceNamed() {
		return interfaceNamed;
	}
	
	public boolean getB2() {
		return defaultInterface.getB2();
	}
	
	public String getStr2() {
		return defaultInterface.getStr2();
	}
	
	public double getR2() {
		return defaultInterface.getR2();
	}
	
	public long getI2() {
		return defaultInterface.getI2();
	}
	
	/* 'default' enter sequence for state StateA */
	private void enterSequence_main_region_StateA_default() {
		nextStateIndex = 0;
		stateVector[0] = State.MAIN_REGION_STATEA;
	}
	
	/* Default enter sequence for state null */
	private void enterSequence_main_region__final__default() {
		nextStateIndex = 0;
		stateVector[0] = State.MAIN_REGION__FINAL_;
	}
	
	/* 'default' enter sequence for region main region */
	private void enterSequence_main_region_default() {
		react_main_region__entry_Default();
	}
	
	/* Default exit sequence for state StateA */
	private void exitSequence_main_region_StateA() {
		nextStateIndex = 0;
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for final state. */
	private void exitSequence_main_region__final_() {
		nextStateIndex = 0;
		stateVector[0] = State.$NULLSTATE$;
	}
	
	/* Default exit sequence for region main region */
	private void exitSequence_main_region() {
		switch (stateVector[0]) {
		case MAIN_REGION_STATEA:
			exitSequence_main_region_StateA();
			break;
		case MAIN_REGION__FINAL_:
			exitSequence_main_region__final_();
			break;
		default:
			break;
		}
	}
	
	/* Default react sequence for initial entry  */
	private void react_main_region__entry_Default() {
		enterSequence_main_region_StateA_default();
	}
	
	private boolean react() {
		return false;
	}
	
	private boolean main_region_StateA_react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				if ((((((((((((getB()==true && (getStr()== null?"String" ==null :getStr().equals("String"))) && getR()==5) && getI()==5) && defaultInterface.getB2()==true) && (defaultInterface.getStr2()== null?"String" ==null :defaultInterface.getStr2().equals("String"))) && defaultInterface.getR2()==5) && defaultInterface.getI2()==5) && interfaceNamed.getB()==true) && (interfaceNamed.getStr()== null?"String" ==null :interfaceNamed.getStr().equals("String"))) && interfaceNamed.getR()==5) && interfaceNamed.getI()==5)) {
					exitSequence_main_region_StateA();
					enterSequence_main_region__final__default();
				} else {
					did_transition = false;
				}
			}
		}
		return did_transition;
	}
	
	private boolean main_region__final__react(boolean try_transition) {
		boolean did_transition = try_transition;
		
		if (try_transition) {
			if (react()==false) {
				did_transition = false;
			}
		}
		return did_transition;
	}
	
}
