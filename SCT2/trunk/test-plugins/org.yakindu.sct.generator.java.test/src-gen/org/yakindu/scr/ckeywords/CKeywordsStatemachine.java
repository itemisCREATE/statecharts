package org.yakindu.scr.ckeywords;

public class CKeywordsStatemachine implements ICKeywordsStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

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

		public void clearEvents() {
			auto = false;
			break_ID = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		auto_char, auto_const, auto_const_switch_case, auto_const_switch_case_enum_asm, $NullState$
	};

	private State[] historyVector = new State[2];
	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public CKeywordsStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		for (int i = 0; i < 2; i++) {
			historyVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();

		sCInterface.case_ID = false;

		sCInterface.do_ID = 0;

		sCInterface.continue_ID = false;

		sCInterface.double_ID = false;

		sCInterface.enum_ID = false;

		sCInterface.extern = false;

		sCInterface.float_ID = false;

		sCInterface.for_ID = false;

		sCInterface.goto_ID = false;

		sCInterface.if_ID = false;

		sCInterface.int_ID = false;

		sCInterface.long_ID = false;

		sCInterface.register = false;

		sCInterface.return_ID = false;

		sCInterface.short_ID = false;

		sCInterface.signed = false;

		sCInterface.sizeof = false;

		sCInterface.static_ID = false;

		sCInterface.struct = false;

		sCInterface.switch_ID = false;

		sCInterface.typedef = false;

		sCInterface.union = false;

		sCInterface.unsigned = false;

		sCInterface.void_ID = false;

		sCInterface.volatile_ID = false;

		sCInterface.while_ID = false;
	}

	public void enter() {
		entryAction();

		sCInterface.case_ID = true;

		sCInterface.do_ID = 0;

		sCInterface.continue_ID = true;

		sCInterface.double_ID = true;

		sCInterface.enum_ID = true;

		sCInterface.extern = true;

		sCInterface.float_ID = true;

		sCInterface.for_ID = true;

		sCInterface.goto_ID = true;

		sCInterface.if_ID = true;

		sCInterface.int_ID = true;

		sCInterface.long_ID = true;

		sCInterface.register = true;

		sCInterface.return_ID = true;

		sCInterface.short_ID = true;

		sCInterface.signed = true;

		sCInterface.sizeof = true;

		sCInterface.static_ID = true;

		sCInterface.struct = true;

		sCInterface.switch_ID = true;

		sCInterface.typedef = true;

		sCInterface.union = true;

		sCInterface.unsigned = true;

		sCInterface.void_ID = true;

		sCInterface.volatile_ID = true;

		sCInterface.while_ID = true;

		nextStateIndex = 0;
		stateVector[0] = State.auto_char;
	}

	public void exit() {
		switch (stateVector[0]) {
			case auto_char :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case auto_const_switch_case_enum_asm :
				historyVector[1] = stateVector[0];

				historyVector[0] = stateVector[0];

				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		exitAction();
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
			case auto_const :
				return stateVector[0].ordinal() >= State.auto_const.ordinal()
						&& stateVector[0].ordinal() <= State.auto_const_switch_case_enum_asm
								.ordinal();
			case auto_const_switch_case :
				return stateVector[0].ordinal() >= State.auto_const_switch_case
						.ordinal()
						&& stateVector[0].ordinal() <= State.auto_const_switch_case_enum_asm
								.ordinal();
			case auto_const_switch_case_enum_asm :
				return stateVector[0] == State.auto_const_switch_case_enum_asm;
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

	/* Entry action for statechart 'CKeywords'. */
	private void entryAction() {
	}

	/* Exit action for state 'CKeywords'. */
	private void exitAction() {
	}

	/* shallow enterSequence with history in child switch */
	private void shallowEnterSequenceAuto_const_switch() {
		switch (historyVector[0]) {
			case auto_const_switch_case_enum_asm :
				/* Enter the region with deep history */
				if (historyVector[1] != State.$NullState$) {
					deepEnterSequenceAuto_const_switch_case_enum();
				} else {
					sCInterface.case_ID = false;

					sCInterface.do_ID = 0;

					sCInterface.continue_ID = false;

					sCInterface.double_ID = false;

					sCInterface.enum_ID = false;

					sCInterface.extern = false;

					sCInterface.float_ID = false;

					sCInterface.for_ID = false;

					sCInterface.goto_ID = false;

					sCInterface.if_ID = false;

					sCInterface.int_ID = false;

					sCInterface.long_ID = false;

					sCInterface.register = false;

					sCInterface.return_ID = false;

					sCInterface.short_ID = false;

					sCInterface.signed = false;

					sCInterface.sizeof = false;

					sCInterface.static_ID = false;

					sCInterface.struct = false;

					sCInterface.switch_ID = false;

					sCInterface.typedef = false;

					sCInterface.union = false;

					sCInterface.unsigned = false;

					sCInterface.void_ID = false;

					sCInterface.volatile_ID = false;

					sCInterface.while_ID = false;

					nextStateIndex = 0;
					stateVector[0] = State.auto_const_switch_case_enum_asm;
				}
				break;

			default :
				break;
		}
	}

	/* deep enterSequence with history in child enum */
	private void deepEnterSequenceAuto_const_switch_case_enum() {
		switch (historyVector[1]) {
			case auto_const_switch_case_enum_asm :
				sCInterface.case_ID = false;

				sCInterface.do_ID = 0;

				sCInterface.continue_ID = false;

				sCInterface.double_ID = false;

				sCInterface.enum_ID = false;

				sCInterface.extern = false;

				sCInterface.float_ID = false;

				sCInterface.for_ID = false;

				sCInterface.goto_ID = false;

				sCInterface.if_ID = false;

				sCInterface.int_ID = false;

				sCInterface.long_ID = false;

				sCInterface.register = false;

				sCInterface.return_ID = false;

				sCInterface.short_ID = false;

				sCInterface.signed = false;

				sCInterface.sizeof = false;

				sCInterface.static_ID = false;

				sCInterface.struct = false;

				sCInterface.switch_ID = false;

				sCInterface.typedef = false;

				sCInterface.union = false;

				sCInterface.unsigned = false;

				sCInterface.void_ID = false;

				sCInterface.volatile_ID = false;

				sCInterface.while_ID = false;

				nextStateIndex = 0;
				stateVector[0] = State.auto_const_switch_case_enum_asm;
				break;

			default :
				break;
		}
	}

	/* The reactions of state char. */
	private void reactAuto_char() {
		if (sCInterface.auto && sCInterface.case_ID) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.do_ID += 1;

			/* Enter the region with shallow history */
			if (historyVector[0] != State.$NullState$) {
				shallowEnterSequenceAuto_const_switch();
			} else {
				/* Enter the region with deep history */
				if (historyVector[1] != State.$NullState$) {
					deepEnterSequenceAuto_const_switch_case_enum();
				} else {
					sCInterface.case_ID = false;

					sCInterface.do_ID = 0;

					sCInterface.continue_ID = false;

					sCInterface.double_ID = false;

					sCInterface.enum_ID = false;

					sCInterface.extern = false;

					sCInterface.float_ID = false;

					sCInterface.for_ID = false;

					sCInterface.goto_ID = false;

					sCInterface.if_ID = false;

					sCInterface.int_ID = false;

					sCInterface.long_ID = false;

					sCInterface.register = false;

					sCInterface.return_ID = false;

					sCInterface.short_ID = false;

					sCInterface.signed = false;

					sCInterface.sizeof = false;

					sCInterface.static_ID = false;

					sCInterface.struct = false;

					sCInterface.switch_ID = false;

					sCInterface.typedef = false;

					sCInterface.union = false;

					sCInterface.unsigned = false;

					sCInterface.void_ID = false;

					sCInterface.volatile_ID = false;

					sCInterface.while_ID = false;

					nextStateIndex = 0;
					stateVector[0] = State.auto_const_switch_case_enum_asm;
				}
			}
		}
	}

	/* The reactions of state asm. */
	private void reactAuto_const_switch_case_enum_asm() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case auto_char :
					reactAuto_char();
					break;
				case auto_const_switch_case_enum_asm :
					reactAuto_const_switch_case_enum_asm();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
