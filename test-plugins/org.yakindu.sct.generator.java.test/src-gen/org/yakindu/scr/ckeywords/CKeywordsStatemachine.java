package org.yakindu.scr.ckeywords;

public class CKeywordsStatemachine implements ICKeywordsStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

		private boolean auto;

		public void raiseAuto() {
			auto = true;
		}

		private boolean break_ID;

		public void raiseBreak() {
			break_ID = true;
		}

		private boolean case_ID;

		public boolean getCase() {
			return case_ID;
		}

		public void setCase(boolean value) {
			this.case_ID = value;
		}

		private long do_ID;

		public long getDo() {
			return do_ID;
		}

		public void setDo(long value) {
			this.do_ID = value;
		}

		private boolean continue_ID;

		public boolean getContinue() {
			return continue_ID;
		}

		public void setContinue(boolean value) {
			this.continue_ID = value;
		}

		private boolean double_ID;

		public boolean getDouble() {
			return double_ID;
		}

		public void setDouble(boolean value) {
			this.double_ID = value;
		}

		private boolean enum_ID;

		public boolean getEnum() {
			return enum_ID;
		}

		public void setEnum(boolean value) {
			this.enum_ID = value;
		}

		private boolean extern;

		public boolean getExtern() {
			return extern;
		}

		public void setExtern(boolean value) {
			this.extern = value;
		}

		private boolean float_ID;

		public boolean getFloat() {
			return float_ID;
		}

		public void setFloat(boolean value) {
			this.float_ID = value;
		}

		private boolean for_ID;

		public boolean getFor() {
			return for_ID;
		}

		public void setFor(boolean value) {
			this.for_ID = value;
		}

		private boolean goto_ID;

		public boolean getGoto() {
			return goto_ID;
		}

		public void setGoto(boolean value) {
			this.goto_ID = value;
		}

		private boolean if_ID;

		public boolean getIf() {
			return if_ID;
		}

		public void setIf(boolean value) {
			this.if_ID = value;
		}

		private boolean int_ID;

		public boolean getInt() {
			return int_ID;
		}

		public void setInt(boolean value) {
			this.int_ID = value;
		}

		private boolean long_ID;

		public boolean getLong() {
			return long_ID;
		}

		public void setLong(boolean value) {
			this.long_ID = value;
		}

		private boolean register;

		public boolean getRegister() {
			return register;
		}

		public void setRegister(boolean value) {
			this.register = value;
		}

		private boolean return_ID;

		public boolean getReturn() {
			return return_ID;
		}

		public void setReturn(boolean value) {
			this.return_ID = value;
		}

		private boolean short_ID;

		public boolean getShort() {
			return short_ID;
		}

		public void setShort(boolean value) {
			this.short_ID = value;
		}

		private boolean signed;

		public boolean getSigned() {
			return signed;
		}

		public void setSigned(boolean value) {
			this.signed = value;
		}

		private boolean sizeof;

		public boolean getSizeof() {
			return sizeof;
		}

		public void setSizeof(boolean value) {
			this.sizeof = value;
		}

		private boolean static_ID;

		public boolean getStatic() {
			return static_ID;
		}

		public void setStatic(boolean value) {
			this.static_ID = value;
		}

		private boolean struct;

		public boolean getStruct() {
			return struct;
		}

		public void setStruct(boolean value) {
			this.struct = value;
		}

		private boolean switch_ID;

		public boolean getSwitch() {
			return switch_ID;
		}

		public void setSwitch(boolean value) {
			this.switch_ID = value;
		}

		private boolean typedef;

		public boolean getTypedef() {
			return typedef;
		}

		public void setTypedef(boolean value) {
			this.typedef = value;
		}

		private boolean union;

		public boolean getUnion() {
			return union;
		}

		public void setUnion(boolean value) {
			this.union = value;
		}

		private boolean unsigned;

		public boolean getUnsigned() {
			return unsigned;
		}

		public void setUnsigned(boolean value) {
			this.unsigned = value;
		}

		private boolean void_ID;

		public boolean getVoid() {
			return void_ID;
		}

		public void setVoid(boolean value) {
			this.void_ID = value;
		}

		private boolean volatile_ID;

		public boolean getVolatile() {
			return volatile_ID;
		}

		public void setVolatile(boolean value) {
			this.volatile_ID = value;
		}

		private boolean while_ID;

		public boolean getWhile() {
			return while_ID;
		}

		public void setWhile(boolean value) {
			this.while_ID = value;
		}

		protected void clearEvents() {
			auto = false;
			break_ID = false;
		}

	}

	protected SCInterfaceImpl sCInterface;

	private boolean initialized = false;

	public enum State {
		auto_char, auto_loop, auto_loop_switch_case, auto_loop_switch_case_enum_asm, $NullState$
	};

	private State[] historyVector = new State[2];
	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public CKeywordsStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		for (int i = 0; i < 2; i++) {
			historyVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();

		sCInterface.setCase(false);

		sCInterface.setDo(0);

		sCInterface.setContinue(false);

		sCInterface.setDouble(false);

		sCInterface.setEnum(false);

		sCInterface.setExtern(false);

		sCInterface.setFloat(false);

		sCInterface.setFor(false);

		sCInterface.setGoto(false);

		sCInterface.setIf(false);

		sCInterface.setInt(false);

		sCInterface.setLong(false);

		sCInterface.setRegister(false);

		sCInterface.setReturn(false);

		sCInterface.setShort(false);

		sCInterface.setSigned(false);

		sCInterface.setSizeof(false);

		sCInterface.setStatic(false);

		sCInterface.setStruct(false);

		sCInterface.setSwitch(false);

		sCInterface.setTypedef(false);

		sCInterface.setUnion(false);

		sCInterface.setUnsigned(false);

		sCInterface.setVoid(false);

		sCInterface.setVolatile(false);

		sCInterface.setWhile(false);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		entryAction();

		enterSequence_auto_default();
	}

	public void exit() {
		initialized = false;
		exitSequence_auto();

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
			case auto_char :
				return stateVector[0] == State.auto_char;
			case auto_loop :
				return stateVector[0].ordinal() >= State.auto_loop.ordinal()
						&& stateVector[0].ordinal() <= State.auto_loop_switch_case_enum_asm.ordinal();
			case auto_loop_switch_case :
				return stateVector[0].ordinal() >= State.auto_loop_switch_case.ordinal()
						&& stateVector[0].ordinal() <= State.auto_loop_switch_case_enum_asm.ordinal();
			case auto_loop_switch_case_enum_asm :
				return stateVector[0] == State.auto_loop_switch_case_enum_asm;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseAuto() {
		sCInterface.raiseAuto();
	}
	public void raiseBreak() {
		sCInterface.raiseBreak();
	}

	public boolean getCase() {
		return sCInterface.getCase();
	}

	public void setCase(boolean value) {
		sCInterface.setCase(value);
	}
	public long getDo() {
		return sCInterface.getDo();
	}

	public void setDo(long value) {
		sCInterface.setDo(value);
	}
	public boolean getContinue() {
		return sCInterface.getContinue();
	}

	public void setContinue(boolean value) {
		sCInterface.setContinue(value);
	}
	public boolean getDouble() {
		return sCInterface.getDouble();
	}

	public void setDouble(boolean value) {
		sCInterface.setDouble(value);
	}
	public boolean getEnum() {
		return sCInterface.getEnum();
	}

	public void setEnum(boolean value) {
		sCInterface.setEnum(value);
	}
	public boolean getExtern() {
		return sCInterface.getExtern();
	}

	public void setExtern(boolean value) {
		sCInterface.setExtern(value);
	}
	public boolean getFloat() {
		return sCInterface.getFloat();
	}

	public void setFloat(boolean value) {
		sCInterface.setFloat(value);
	}
	public boolean getFor() {
		return sCInterface.getFor();
	}

	public void setFor(boolean value) {
		sCInterface.setFor(value);
	}
	public boolean getGoto() {
		return sCInterface.getGoto();
	}

	public void setGoto(boolean value) {
		sCInterface.setGoto(value);
	}
	public boolean getIf() {
		return sCInterface.getIf();
	}

	public void setIf(boolean value) {
		sCInterface.setIf(value);
	}
	public boolean getInt() {
		return sCInterface.getInt();
	}

	public void setInt(boolean value) {
		sCInterface.setInt(value);
	}
	public boolean getLong() {
		return sCInterface.getLong();
	}

	public void setLong(boolean value) {
		sCInterface.setLong(value);
	}
	public boolean getRegister() {
		return sCInterface.getRegister();
	}

	public void setRegister(boolean value) {
		sCInterface.setRegister(value);
	}
	public boolean getReturn() {
		return sCInterface.getReturn();
	}

	public void setReturn(boolean value) {
		sCInterface.setReturn(value);
	}
	public boolean getShort() {
		return sCInterface.getShort();
	}

	public void setShort(boolean value) {
		sCInterface.setShort(value);
	}
	public boolean getSigned() {
		return sCInterface.getSigned();
	}

	public void setSigned(boolean value) {
		sCInterface.setSigned(value);
	}
	public boolean getSizeof() {
		return sCInterface.getSizeof();
	}

	public void setSizeof(boolean value) {
		sCInterface.setSizeof(value);
	}
	public boolean getStatic() {
		return sCInterface.getStatic();
	}

	public void setStatic(boolean value) {
		sCInterface.setStatic(value);
	}
	public boolean getStruct() {
		return sCInterface.getStruct();
	}

	public void setStruct(boolean value) {
		sCInterface.setStruct(value);
	}
	public boolean getSwitch() {
		return sCInterface.getSwitch();
	}

	public void setSwitch(boolean value) {
		sCInterface.setSwitch(value);
	}
	public boolean getTypedef() {
		return sCInterface.getTypedef();
	}

	public void setTypedef(boolean value) {
		sCInterface.setTypedef(value);
	}
	public boolean getUnion() {
		return sCInterface.getUnion();
	}

	public void setUnion(boolean value) {
		sCInterface.setUnion(value);
	}
	public boolean getUnsigned() {
		return sCInterface.getUnsigned();
	}

	public void setUnsigned(boolean value) {
		sCInterface.setUnsigned(value);
	}
	public boolean getVoid() {
		return sCInterface.getVoid();
	}

	public void setVoid(boolean value) {
		sCInterface.setVoid(value);
	}
	public boolean getVolatile() {
		return sCInterface.getVolatile();
	}

	public void setVolatile(boolean value) {
		sCInterface.setVolatile(value);
	}
	public boolean getWhile() {
		return sCInterface.getWhile();
	}

	public void setWhile(boolean value) {
		sCInterface.setWhile(value);
	}

	private boolean check_auto_char_tr0_tr0() {
		return (sCInterface.auto) && sCInterface.getCase();
	}

	private void effect_auto_char_tr0() {
		exitSequence_auto_char();

		sCInterface.setDo(sCInterface.getDo() + 1);

		enterSequence_auto_loop_default();
	}

	/* Entry action for statechart 'CKeywords'. */
	private void entryAction() {
	}

	/* Entry action for state 'char'. */
	private void entryAction_auto_char() {
		sCInterface.setCase(true);

		sCInterface.setDo(0);

		sCInterface.setContinue(true);

		sCInterface.setDouble(true);

		sCInterface.setEnum(true);

		sCInterface.setExtern(true);

		sCInterface.setFloat(true);

		sCInterface.setFor(true);

		sCInterface.setGoto(true);

		sCInterface.setIf(true);

		sCInterface.setInt(true);

		sCInterface.setLong(true);

		sCInterface.setRegister(true);

		sCInterface.setReturn(true);

		sCInterface.setShort(true);

		sCInterface.setSigned(true);

		sCInterface.setSizeof(true);

		sCInterface.setStatic(true);

		sCInterface.setStruct(true);

		sCInterface.setSwitch(true);

		sCInterface.setTypedef(true);

		sCInterface.setUnion(true);

		sCInterface.setUnsigned(true);

		sCInterface.setVoid(true);

		sCInterface.setVolatile(true);

		sCInterface.setWhile(true);
	}

	/* Entry action for state 'asm'. */
	private void entryAction_auto_loop_switch_case_enum_asm() {
		sCInterface.setCase(false);

		sCInterface.setDo(0);

		sCInterface.setContinue(false);

		sCInterface.setDouble(false);

		sCInterface.setEnum(false);

		sCInterface.setExtern(false);

		sCInterface.setFloat(false);

		sCInterface.setFor(false);

		sCInterface.setGoto(false);

		sCInterface.setIf(false);

		sCInterface.setInt(false);

		sCInterface.setLong(false);

		sCInterface.setRegister(false);

		sCInterface.setReturn(false);

		sCInterface.setShort(false);

		sCInterface.setSigned(false);

		sCInterface.setSizeof(false);

		sCInterface.setStatic(false);

		sCInterface.setStruct(false);

		sCInterface.setSwitch(false);

		sCInterface.setTypedef(false);

		sCInterface.setUnion(false);

		sCInterface.setUnsigned(false);

		sCInterface.setVoid(false);

		sCInterface.setVolatile(false);

		sCInterface.setWhile(false);
	}

	/* Exit action for state 'CKeywords'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state char */
	private void enterSequence_auto_char_default() {
		entryAction_auto_char();

		nextStateIndex = 0;
		stateVector[0] = State.auto_char;
	}

	/* 'default' enter sequence for state loop */
	private void enterSequence_auto_loop_default() {
		enterSequence_auto_loop_switch_default();
	}

	/* 'default' enter sequence for state case */
	private void enterSequence_auto_loop_switch_case_default() {
		enterSequence_auto_loop_switch_case_enum_default();

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state asm */
	private void enterSequence_auto_loop_switch_case_enum_asm_default() {
		entryAction_auto_loop_switch_case_enum_asm();

		nextStateIndex = 0;
		stateVector[0] = State.auto_loop_switch_case_enum_asm;

		historyVector[1] = stateVector[0];
	}

	/* 'default' enter sequence for region auto */
	private void enterSequence_auto_default() {
		react_auto__entry_Default();
	}

	/* 'default' enter sequence for region switch */
	private void enterSequence_auto_loop_switch_default() {
		react_auto_loop_switch__entry_Default();
	}

	/* shallow enterSequence with history in child switch */
	private void shallowEnterSequence_auto_loop_switch() {
		switch (historyVector[0]) {
			case auto_loop_switch_case_enum_asm :
				enterSequence_auto_loop_switch_case_default();
				break;

			default :
				break;
		}
	}

	/* 'default' enter sequence for region enum */
	private void enterSequence_auto_loop_switch_case_enum_default() {
		react_auto_loop_switch_case_enum__entry_Default();
	}

	/* deep enterSequence with history in child enum */
	private void deepEnterSequence_auto_loop_switch_case_enum() {
		switch (historyVector[1]) {
			case auto_loop_switch_case_enum_asm :
				enterSequence_auto_loop_switch_case_enum_asm_default();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for state char */
	private void exitSequence_auto_char() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state asm */
	private void exitSequence_auto_loop_switch_case_enum_asm() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region auto */
	private void exitSequence_auto() {
		switch (stateVector[0]) {
			case auto_char :
				exitSequence_auto_char();
				break;

			case auto_loop_switch_case_enum_asm :
				exitSequence_auto_loop_switch_case_enum_asm();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region switch */
	private void exitSequence_auto_loop_switch() {
		switch (stateVector[0]) {
			case auto_loop_switch_case_enum_asm :
				exitSequence_auto_loop_switch_case_enum_asm();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region enum */
	private void exitSequence_auto_loop_switch_case_enum() {
		switch (stateVector[0]) {
			case auto_loop_switch_case_enum_asm :
				exitSequence_auto_loop_switch_case_enum_asm();
				break;

			default :
				break;
		}
	}

	/* The reactions of state char. */
	private void react_auto_char() {
		if (check_auto_char_tr0_tr0()) {
			effect_auto_char_tr0();
		}
	}

	/* The reactions of state asm. */
	private void react_auto_loop_switch_case_enum_asm() {
	}

	/* Default react sequence for initial entry  */
	private void react_auto__entry_Default() {
		enterSequence_auto_char_default();
	}

	/* Default react sequence for shallow history entry  */
	private void react_auto_loop_switch__entry_Default() {
		/* Enter the region with shallow history */
		if (historyVector[0] != State.$NullState$) {
			shallowEnterSequence_auto_loop_switch();
		} else {
			enterSequence_auto_loop_switch_case_default();
		}
	}

	/* Default react sequence for deep history entry  */
	private void react_auto_loop_switch_case_enum__entry_Default() {
		/* Enter the region with deep history */
		if (historyVector[1] != State.$NullState$) {
			deepEnterSequence_auto_loop_switch_case_enum();
		} else {
			enterSequence_auto_loop_switch_case_enum_asm_default();
		}
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case auto_char :
					react_auto_char();
					break;
				case auto_loop_switch_case_enum_asm :
					react_auto_loop_switch_case_enum_asm();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
