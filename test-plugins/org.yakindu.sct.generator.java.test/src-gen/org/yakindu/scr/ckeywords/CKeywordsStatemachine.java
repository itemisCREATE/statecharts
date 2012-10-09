package org.yakindu.scr.ckeywords;

public class CKeywordsStatemachine implements ICKeywordsStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

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

		private int do_ID;

		public int getDo() {
			return do_ID;
		}

		public void setDo(int value) {
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

	private SCIDefaultImpl sCIDefault;

	public enum State {
		auto_char, auto_const, auto_const_switch_case, auto_const_switch_case_enum_asm, $NullState$
	};

	private State[] historyVector = new State[2];
	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public CKeywordsStatemachine() {

		sCIDefault = new SCIDefaultImpl();

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
	}

	public void enter() {
		entryAction();

		sCIDefault.case_ID = true;

		sCIDefault.do_ID = 0;

		sCIDefault.continue_ID = true;

		sCIDefault.double_ID = true;

		sCIDefault.enum_ID = true;

		sCIDefault.extern = true;

		sCIDefault.float_ID = true;

		sCIDefault.for_ID = true;

		sCIDefault.goto_ID = true;

		sCIDefault.if_ID = true;

		sCIDefault.int_ID = true;

		sCIDefault.long_ID = true;

		sCIDefault.register = true;

		sCIDefault.return_ID = true;

		sCIDefault.short_ID = true;

		sCIDefault.signed = true;

		sCIDefault.sizeof = true;

		sCIDefault.static_ID = true;

		sCIDefault.struct = true;

		sCIDefault.switch_ID = true;

		sCIDefault.typedef = true;

		sCIDefault.union = true;

		sCIDefault.unsigned = true;

		sCIDefault.void_ID = true;

		sCIDefault.volatile_ID = true;

		sCIDefault.while_ID = true;

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

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
	}

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

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseAuto() {
		sCIDefault.raiseAuto();
	}
	public void raiseBreak() {
		sCIDefault.raiseBreak();
	}

	public boolean getCase() {
		return sCIDefault.getCase();
	}

	public void setCase(boolean value) {
		sCIDefault.setCase(value);
	}
	public int getDo() {
		return sCIDefault.getDo();
	}

	public void setDo(int value) {
		sCIDefault.setDo(value);
	}
	public boolean getContinue() {
		return sCIDefault.getContinue();
	}

	public void setContinue(boolean value) {
		sCIDefault.setContinue(value);
	}
	public boolean getDouble() {
		return sCIDefault.getDouble();
	}

	public void setDouble(boolean value) {
		sCIDefault.setDouble(value);
	}
	public boolean getEnum() {
		return sCIDefault.getEnum();
	}

	public void setEnum(boolean value) {
		sCIDefault.setEnum(value);
	}
	public boolean getExtern() {
		return sCIDefault.getExtern();
	}

	public void setExtern(boolean value) {
		sCIDefault.setExtern(value);
	}
	public boolean getFloat() {
		return sCIDefault.getFloat();
	}

	public void setFloat(boolean value) {
		sCIDefault.setFloat(value);
	}
	public boolean getFor() {
		return sCIDefault.getFor();
	}

	public void setFor(boolean value) {
		sCIDefault.setFor(value);
	}
	public boolean getGoto() {
		return sCIDefault.getGoto();
	}

	public void setGoto(boolean value) {
		sCIDefault.setGoto(value);
	}
	public boolean getIf() {
		return sCIDefault.getIf();
	}

	public void setIf(boolean value) {
		sCIDefault.setIf(value);
	}
	public boolean getInt() {
		return sCIDefault.getInt();
	}

	public void setInt(boolean value) {
		sCIDefault.setInt(value);
	}
	public boolean getLong() {
		return sCIDefault.getLong();
	}

	public void setLong(boolean value) {
		sCIDefault.setLong(value);
	}
	public boolean getRegister() {
		return sCIDefault.getRegister();
	}

	public void setRegister(boolean value) {
		sCIDefault.setRegister(value);
	}
	public boolean getReturn() {
		return sCIDefault.getReturn();
	}

	public void setReturn(boolean value) {
		sCIDefault.setReturn(value);
	}
	public boolean getShort() {
		return sCIDefault.getShort();
	}

	public void setShort(boolean value) {
		sCIDefault.setShort(value);
	}
	public boolean getSigned() {
		return sCIDefault.getSigned();
	}

	public void setSigned(boolean value) {
		sCIDefault.setSigned(value);
	}
	public boolean getSizeof() {
		return sCIDefault.getSizeof();
	}

	public void setSizeof(boolean value) {
		sCIDefault.setSizeof(value);
	}
	public boolean getStatic() {
		return sCIDefault.getStatic();
	}

	public void setStatic(boolean value) {
		sCIDefault.setStatic(value);
	}
	public boolean getStruct() {
		return sCIDefault.getStruct();
	}

	public void setStruct(boolean value) {
		sCIDefault.setStruct(value);
	}
	public boolean getSwitch() {
		return sCIDefault.getSwitch();
	}

	public void setSwitch(boolean value) {
		sCIDefault.setSwitch(value);
	}
	public boolean getTypedef() {
		return sCIDefault.getTypedef();
	}

	public void setTypedef(boolean value) {
		sCIDefault.setTypedef(value);
	}
	public boolean getUnion() {
		return sCIDefault.getUnion();
	}

	public void setUnion(boolean value) {
		sCIDefault.setUnion(value);
	}
	public boolean getUnsigned() {
		return sCIDefault.getUnsigned();
	}

	public void setUnsigned(boolean value) {
		sCIDefault.setUnsigned(value);
	}
	public boolean getVoid() {
		return sCIDefault.getVoid();
	}

	public void setVoid(boolean value) {
		sCIDefault.setVoid(value);
	}
	public boolean getVolatile() {
		return sCIDefault.getVolatile();
	}

	public void setVolatile(boolean value) {
		sCIDefault.setVolatile(value);
	}
	public boolean getWhile() {
		return sCIDefault.getWhile();
	}

	public void setWhile(boolean value) {
		sCIDefault.setWhile(value);
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
					sCIDefault.case_ID = false;

					sCIDefault.do_ID = 0;

					sCIDefault.continue_ID = false;

					sCIDefault.double_ID = false;

					sCIDefault.enum_ID = false;

					sCIDefault.extern = false;

					sCIDefault.float_ID = false;

					sCIDefault.for_ID = false;

					sCIDefault.goto_ID = false;

					sCIDefault.if_ID = false;

					sCIDefault.int_ID = false;

					sCIDefault.long_ID = false;

					sCIDefault.register = false;

					sCIDefault.return_ID = false;

					sCIDefault.short_ID = false;

					sCIDefault.signed = false;

					sCIDefault.sizeof = false;

					sCIDefault.static_ID = false;

					sCIDefault.struct = false;

					sCIDefault.switch_ID = false;

					sCIDefault.typedef = false;

					sCIDefault.union = false;

					sCIDefault.unsigned = false;

					sCIDefault.void_ID = false;

					sCIDefault.volatile_ID = false;

					sCIDefault.while_ID = false;

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
				sCIDefault.case_ID = false;

				sCIDefault.do_ID = 0;

				sCIDefault.continue_ID = false;

				sCIDefault.double_ID = false;

				sCIDefault.enum_ID = false;

				sCIDefault.extern = false;

				sCIDefault.float_ID = false;

				sCIDefault.for_ID = false;

				sCIDefault.goto_ID = false;

				sCIDefault.if_ID = false;

				sCIDefault.int_ID = false;

				sCIDefault.long_ID = false;

				sCIDefault.register = false;

				sCIDefault.return_ID = false;

				sCIDefault.short_ID = false;

				sCIDefault.signed = false;

				sCIDefault.sizeof = false;

				sCIDefault.static_ID = false;

				sCIDefault.struct = false;

				sCIDefault.switch_ID = false;

				sCIDefault.typedef = false;

				sCIDefault.union = false;

				sCIDefault.unsigned = false;

				sCIDefault.void_ID = false;

				sCIDefault.volatile_ID = false;

				sCIDefault.while_ID = false;

				nextStateIndex = 0;
				stateVector[0] = State.auto_const_switch_case_enum_asm;
				break;

			default :
				break;
		}
	}

	/* The reactions of state char. */
	private void reactAuto_char() {
		if (sCIDefault.auto && sCIDefault.case_ID) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIDefault.do_ID += 1;

			/* Enter the region with shallow history */
			if (historyVector[0] != State.$NullState$) {
				shallowEnterSequenceAuto_const_switch();
			} else {
				/* Enter the region with deep history */
				if (historyVector[1] != State.$NullState$) {
					deepEnterSequenceAuto_const_switch_case_enum();
				} else {
					sCIDefault.case_ID = false;

					sCIDefault.do_ID = 0;

					sCIDefault.continue_ID = false;

					sCIDefault.double_ID = false;

					sCIDefault.enum_ID = false;

					sCIDefault.extern = false;

					sCIDefault.float_ID = false;

					sCIDefault.for_ID = false;

					sCIDefault.goto_ID = false;

					sCIDefault.if_ID = false;

					sCIDefault.int_ID = false;

					sCIDefault.long_ID = false;

					sCIDefault.register = false;

					sCIDefault.return_ID = false;

					sCIDefault.short_ID = false;

					sCIDefault.signed = false;

					sCIDefault.sizeof = false;

					sCIDefault.static_ID = false;

					sCIDefault.struct = false;

					sCIDefault.switch_ID = false;

					sCIDefault.typedef = false;

					sCIDefault.union = false;

					sCIDefault.unsigned = false;

					sCIDefault.void_ID = false;

					sCIDefault.volatile_ID = false;

					sCIDefault.while_ID = false;

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
