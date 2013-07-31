package org.yakindu.scr.javakeywords;

public class JavaKeywordsStatemachine implements IJavaKeywordsStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean while_ID;

		public void raiseWhile() {
			while_ID = true;
		}

		private boolean ev;

		public void raiseEv() {
			ev = true;
		}

		private boolean abstract_ID;

		public boolean getAbstract() {
			return abstract_ID;
		}

		public void setAbstract(boolean value) {
			this.abstract_ID = value;
		}

		private boolean assert_ID;

		public boolean getAssert() {
			return assert_ID;
		}

		public void setAssert(boolean value) {
			this.assert_ID = value;
		}

		private boolean boolean_ID;

		public boolean getBoolean() {
			return boolean_ID;
		}

		public void setBoolean(boolean value) {
			this.boolean_ID = value;
		}

		private boolean break_ID;

		public boolean getBreak() {
			return break_ID;
		}

		public void setBreak(boolean value) {
			this.break_ID = value;
		}

		private boolean byte_ID;

		public boolean getByte() {
			return byte_ID;
		}

		public void setByte(boolean value) {
			this.byte_ID = value;
		}

		private boolean case_ID;

		public boolean getCase() {
			return case_ID;
		}

		public void setCase(boolean value) {
			this.case_ID = value;
		}

		private boolean catch_ID;

		public boolean getCatch() {
			return catch_ID;
		}

		public void setCatch(boolean value) {
			this.catch_ID = value;
		}

		private boolean char_ID;

		public boolean getChar() {
			return char_ID;
		}

		public void setChar(boolean value) {
			this.char_ID = value;
		}

		private boolean class_ID;

		public boolean getClass_ID() {
			return class_ID;
		}

		public void setClass_ID(boolean value) {
			this.class_ID = value;
		}

		private boolean const_ID;

		public boolean getConst() {
			return const_ID;
		}

		public void setConst(boolean value) {
			this.const_ID = value;
		}

		private boolean continue_ID;

		public boolean getContinue() {
			return continue_ID;
		}

		public void setContinue(boolean value) {
			this.continue_ID = value;
		}

		private boolean do_ID;

		public boolean getDo() {
			return do_ID;
		}

		public void setDo(boolean value) {
			this.do_ID = value;
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

		private boolean extends_ID;

		public boolean getExtends() {
			return extends_ID;
		}

		public void setExtends(boolean value) {
			this.extends_ID = value;
		}

		private boolean final_ID;

		public boolean getFinal() {
			return final_ID;
		}

		public void setFinal(boolean value) {
			this.final_ID = value;
		}

		private boolean finally_ID;

		public boolean getFinally() {
			return finally_ID;
		}

		public void setFinally(boolean value) {
			this.finally_ID = value;
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

		private boolean implements_ID;

		public boolean getImplements() {
			return implements_ID;
		}

		public void setImplements(boolean value) {
			this.implements_ID = value;
		}

		private boolean import_ID;

		public boolean getImport() {
			return import_ID;
		}

		public void setImport(boolean value) {
			this.import_ID = value;
		}

		private boolean instanceof_ID;

		public boolean getInstanceof() {
			return instanceof_ID;
		}

		public void setInstanceof(boolean value) {
			this.instanceof_ID = value;
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

		private boolean native_ID;

		public boolean getNative() {
			return native_ID;
		}

		public void setNative(boolean value) {
			this.native_ID = value;
		}

		private boolean new_ID;

		public boolean getNew() {
			return new_ID;
		}

		public void setNew(boolean value) {
			this.new_ID = value;
		}

		private boolean null_ID;

		public boolean getNull() {
			return null_ID;
		}

		public void setNull(boolean value) {
			this.null_ID = value;
		}

		private boolean package_ID;

		public boolean getPackage() {
			return package_ID;
		}

		public void setPackage(boolean value) {
			this.package_ID = value;
		}

		private boolean private_ID;

		public boolean getPrivate() {
			return private_ID;
		}

		public void setPrivate(boolean value) {
			this.private_ID = value;
		}

		private boolean protected_ID;

		public boolean getProtected() {
			return protected_ID;
		}

		public void setProtected(boolean value) {
			this.protected_ID = value;
		}

		private boolean public_ID;

		public boolean getPublic() {
			return public_ID;
		}

		public void setPublic(boolean value) {
			this.public_ID = value;
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

		private boolean static_ID;

		public boolean getStatic() {
			return static_ID;
		}

		public void setStatic(boolean value) {
			this.static_ID = value;
		}

		private boolean strictfp_ID;

		public boolean getStrictfp() {
			return strictfp_ID;
		}

		public void setStrictfp(boolean value) {
			this.strictfp_ID = value;
		}

		private boolean super_ID;

		public boolean getSuper() {
			return super_ID;
		}

		public void setSuper(boolean value) {
			this.super_ID = value;
		}

		private boolean switch_ID;

		public boolean getSwitch() {
			return switch_ID;
		}

		public void setSwitch(boolean value) {
			this.switch_ID = value;
		}

		private boolean synchronized_ID;

		public boolean getSynchronized() {
			return synchronized_ID;
		}

		public void setSynchronized(boolean value) {
			this.synchronized_ID = value;
		}

		private boolean this_ID;

		public boolean getThis() {
			return this_ID;
		}

		public void setThis(boolean value) {
			this.this_ID = value;
		}

		private boolean throw_ID;

		public boolean getThrow() {
			return throw_ID;
		}

		public void setThrow(boolean value) {
			this.throw_ID = value;
		}

		private boolean throws_ID;

		public boolean getThrows() {
			return throws_ID;
		}

		public void setThrows(boolean value) {
			this.throws_ID = value;
		}

		private boolean transient_ID;

		public boolean getTransient() {
			return transient_ID;
		}

		public void setTransient(boolean value) {
			this.transient_ID = value;
		}

		private boolean try_ID;

		public boolean getTry() {
			return try_ID;
		}

		public void setTry(boolean value) {
			this.try_ID = value;
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

		public void clearEvents() {
			while_ID = false;
			ev = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		goto_abstract, goto_boolean, goto_void, goto_void_volatile_transient, goto_void_volatile_transient_throw_false, goto_void_volatile_state, $NullState$
	};

	private State[] historyVector = new State[2];
	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public JavaKeywordsStatemachine() {

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

		sCInterface.abstract_ID = false;

		sCInterface.assert_ID = false;

		sCInterface.boolean_ID = false;

		sCInterface.break_ID = false;

		sCInterface.byte_ID = false;

		sCInterface.case_ID = false;

		sCInterface.catch_ID = false;

		sCInterface.char_ID = false;

		sCInterface.class_ID = false;

		sCInterface.const_ID = false;

		sCInterface.continue_ID = false;

		sCInterface.do_ID = false;

		sCInterface.double_ID = false;

		sCInterface.enum_ID = false;

		sCInterface.extends_ID = false;

		sCInterface.final_ID = false;

		sCInterface.finally_ID = false;

		sCInterface.float_ID = false;

		sCInterface.for_ID = false;

		sCInterface.goto_ID = false;

		sCInterface.if_ID = false;

		sCInterface.implements_ID = false;

		sCInterface.import_ID = false;

		sCInterface.instanceof_ID = false;

		sCInterface.int_ID = false;

		sCInterface.long_ID = false;

		sCInterface.native_ID = false;

		sCInterface.new_ID = false;

		sCInterface.null_ID = false;

		sCInterface.package_ID = false;

		sCInterface.private_ID = false;

		sCInterface.protected_ID = false;

		sCInterface.public_ID = false;

		sCInterface.return_ID = false;

		sCInterface.short_ID = false;

		sCInterface.static_ID = false;

		sCInterface.strictfp_ID = false;

		sCInterface.super_ID = false;

		sCInterface.switch_ID = false;

		sCInterface.synchronized_ID = false;

		sCInterface.this_ID = false;

		sCInterface.throw_ID = false;

		sCInterface.throws_ID = false;

		sCInterface.transient_ID = false;

		sCInterface.try_ID = false;

		sCInterface.void_ID = false;

		sCInterface.volatile_ID = false;
	}

	public void enter() {
		entryAction();

		sCInterface.abstract_ID = true;

		sCInterface.assert_ID = true;

		sCInterface.boolean_ID = true;

		sCInterface.break_ID = true;

		sCInterface.byte_ID = true;

		sCInterface.case_ID = true;

		sCInterface.catch_ID = true;

		sCInterface.char_ID = true;

		sCInterface.class_ID = true;

		sCInterface.const_ID = true;

		sCInterface.continue_ID = true;

		sCInterface.do_ID = true;

		sCInterface.double_ID = true;

		sCInterface.enum_ID = true;

		sCInterface.extends_ID = true;

		sCInterface.final_ID = true;

		sCInterface.finally_ID = true;

		sCInterface.float_ID = true;

		sCInterface.for_ID = true;

		sCInterface.goto_ID = true;

		sCInterface.if_ID = true;

		sCInterface.implements_ID = true;

		sCInterface.import_ID = true;

		sCInterface.instanceof_ID = true;

		sCInterface.int_ID = true;

		sCInterface.long_ID = true;

		sCInterface.native_ID = true;

		sCInterface.new_ID = true;

		sCInterface.null_ID = true;

		sCInterface.package_ID = true;

		sCInterface.private_ID = true;

		sCInterface.protected_ID = true;

		sCInterface.public_ID = true;

		sCInterface.return_ID = true;

		sCInterface.short_ID = true;

		sCInterface.static_ID = true;

		sCInterface.strictfp_ID = true;

		sCInterface.super_ID = true;

		sCInterface.switch_ID = true;

		sCInterface.synchronized_ID = true;

		sCInterface.this_ID = true;

		sCInterface.throw_ID = true;

		sCInterface.throws_ID = true;

		sCInterface.transient_ID = true;

		sCInterface.try_ID = true;

		sCInterface.void_ID = true;

		sCInterface.volatile_ID = true;

		nextStateIndex = 0;
		stateVector[0] = State.goto_abstract;
	}

	public void exit() {
		switch (stateVector[0]) {
			case goto_abstract :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case goto_boolean :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case goto_void_volatile_transient_throw_false :
				historyVector[1] = stateVector[0];

				historyVector[0] = stateVector[0];

				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			case goto_void_volatile_state :
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
		sCInterface.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {
			case goto_abstract :
				return stateVector[0] == State.goto_abstract;
			case goto_boolean :
				return stateVector[0] == State.goto_boolean;
			case goto_void :
				return stateVector[0].ordinal() >= State.goto_void.ordinal()
						&& stateVector[0].ordinal() <= State.goto_void_volatile_state
								.ordinal();
			case goto_void_volatile_transient :
				return stateVector[0].ordinal() >= State.goto_void_volatile_transient
						.ordinal()
						&& stateVector[0].ordinal() <= State.goto_void_volatile_transient_throw_false
								.ordinal();
			case goto_void_volatile_transient_throw_false :
				return stateVector[0] == State.goto_void_volatile_transient_throw_false;
			case goto_void_volatile_state :
				return stateVector[0] == State.goto_void_volatile_state;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseWhile() {
		sCInterface.raiseWhile();
	}
	public void raiseEv() {
		sCInterface.raiseEv();
	}

	public boolean getAbstract() {
		return sCInterface.getAbstract();
	}

	public void setAbstract(boolean value) {
		sCInterface.setAbstract(value);
	}
	public boolean getAssert() {
		return sCInterface.getAssert();
	}

	public void setAssert(boolean value) {
		sCInterface.setAssert(value);
	}
	public boolean getBoolean() {
		return sCInterface.getBoolean();
	}

	public void setBoolean(boolean value) {
		sCInterface.setBoolean(value);
	}
	public boolean getBreak() {
		return sCInterface.getBreak();
	}

	public void setBreak(boolean value) {
		sCInterface.setBreak(value);
	}
	public boolean getByte() {
		return sCInterface.getByte();
	}

	public void setByte(boolean value) {
		sCInterface.setByte(value);
	}
	public boolean getCase() {
		return sCInterface.getCase();
	}

	public void setCase(boolean value) {
		sCInterface.setCase(value);
	}
	public boolean getCatch() {
		return sCInterface.getCatch();
	}

	public void setCatch(boolean value) {
		sCInterface.setCatch(value);
	}
	public boolean getChar() {
		return sCInterface.getChar();
	}

	public void setChar(boolean value) {
		sCInterface.setChar(value);
	}
	public boolean getClass_ID() {
		return sCInterface.getClass_ID();
	}

	public void setClass_ID(boolean value) {
		sCInterface.setClass_ID(value);
	}
	public boolean getConst() {
		return sCInterface.getConst();
	}

	public void setConst(boolean value) {
		sCInterface.setConst(value);
	}
	public boolean getContinue() {
		return sCInterface.getContinue();
	}

	public void setContinue(boolean value) {
		sCInterface.setContinue(value);
	}
	public boolean getDo() {
		return sCInterface.getDo();
	}

	public void setDo(boolean value) {
		sCInterface.setDo(value);
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
	public boolean getExtends() {
		return sCInterface.getExtends();
	}

	public void setExtends(boolean value) {
		sCInterface.setExtends(value);
	}
	public boolean getFinal() {
		return sCInterface.getFinal();
	}

	public void setFinal(boolean value) {
		sCInterface.setFinal(value);
	}
	public boolean getFinally() {
		return sCInterface.getFinally();
	}

	public void setFinally(boolean value) {
		sCInterface.setFinally(value);
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
	public boolean getImplements() {
		return sCInterface.getImplements();
	}

	public void setImplements(boolean value) {
		sCInterface.setImplements(value);
	}
	public boolean getImport() {
		return sCInterface.getImport();
	}

	public void setImport(boolean value) {
		sCInterface.setImport(value);
	}
	public boolean getInstanceof() {
		return sCInterface.getInstanceof();
	}

	public void setInstanceof(boolean value) {
		sCInterface.setInstanceof(value);
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
	public boolean getNative() {
		return sCInterface.getNative();
	}

	public void setNative(boolean value) {
		sCInterface.setNative(value);
	}
	public boolean getNew() {
		return sCInterface.getNew();
	}

	public void setNew(boolean value) {
		sCInterface.setNew(value);
	}
	public boolean getNull() {
		return sCInterface.getNull();
	}

	public void setNull(boolean value) {
		sCInterface.setNull(value);
	}
	public boolean getPackage() {
		return sCInterface.getPackage();
	}

	public void setPackage(boolean value) {
		sCInterface.setPackage(value);
	}
	public boolean getPrivate() {
		return sCInterface.getPrivate();
	}

	public void setPrivate(boolean value) {
		sCInterface.setPrivate(value);
	}
	public boolean getProtected() {
		return sCInterface.getProtected();
	}

	public void setProtected(boolean value) {
		sCInterface.setProtected(value);
	}
	public boolean getPublic() {
		return sCInterface.getPublic();
	}

	public void setPublic(boolean value) {
		sCInterface.setPublic(value);
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
	public boolean getStatic() {
		return sCInterface.getStatic();
	}

	public void setStatic(boolean value) {
		sCInterface.setStatic(value);
	}
	public boolean getStrictfp() {
		return sCInterface.getStrictfp();
	}

	public void setStrictfp(boolean value) {
		sCInterface.setStrictfp(value);
	}
	public boolean getSuper() {
		return sCInterface.getSuper();
	}

	public void setSuper(boolean value) {
		sCInterface.setSuper(value);
	}
	public boolean getSwitch() {
		return sCInterface.getSwitch();
	}

	public void setSwitch(boolean value) {
		sCInterface.setSwitch(value);
	}
	public boolean getSynchronized() {
		return sCInterface.getSynchronized();
	}

	public void setSynchronized(boolean value) {
		sCInterface.setSynchronized(value);
	}
	public boolean getThis() {
		return sCInterface.getThis();
	}

	public void setThis(boolean value) {
		sCInterface.setThis(value);
	}
	public boolean getThrow() {
		return sCInterface.getThrow();
	}

	public void setThrow(boolean value) {
		sCInterface.setThrow(value);
	}
	public boolean getThrows() {
		return sCInterface.getThrows();
	}

	public void setThrows(boolean value) {
		sCInterface.setThrows(value);
	}
	public boolean getTransient() {
		return sCInterface.getTransient();
	}

	public void setTransient(boolean value) {
		sCInterface.setTransient(value);
	}
	public boolean getTry() {
		return sCInterface.getTry();
	}

	public void setTry(boolean value) {
		sCInterface.setTry(value);
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

	/* Entry action for statechart 'JavaKeywords'. */
	private void entryAction() {
	}

	/* Exit action for state 'JavaKeywords'. */
	private void exitAction() {
	}

	/* shallow enterSequence with history in child volatile */
	private void shallowEnterSequenceGoto_void_volatile() {
		switch (historyVector[0]) {
			case goto_void_volatile_transient_throw_false :
				nextStateIndex = 0;
				stateVector[0] = State.goto_void_volatile_transient_throw_false;
				break;

			case goto_void_volatile_state :
				nextStateIndex = 0;
				stateVector[0] = State.goto_void_volatile_state;
				break;

			default :
				break;
		}
	}

	/* deep enterSequence with history in child throw */
	private void deepEnterSequenceGoto_void_volatile_transient_throw() {
		switch (historyVector[1]) {
			case goto_void_volatile_transient_throw_false :
				nextStateIndex = 0;
				stateVector[0] = State.goto_void_volatile_transient_throw_false;
				break;

			default :
				break;
		}
	}

	/* The reactions of state abstract. */
	private void reactGoto_abstract() {
		if (sCInterface.while_ID && sCInterface.null_ID) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCInterface.native_ID = false;

			sCInterface.abstract_ID = false;

			sCInterface.assert_ID = false;

			sCInterface.boolean_ID = false;

			sCInterface.break_ID = false;

			sCInterface.byte_ID = false;

			sCInterface.case_ID = false;

			sCInterface.catch_ID = false;

			sCInterface.char_ID = false;

			sCInterface.class_ID = false;

			sCInterface.const_ID = false;

			sCInterface.continue_ID = false;

			sCInterface.do_ID = false;

			sCInterface.double_ID = false;

			sCInterface.enum_ID = false;

			sCInterface.extends_ID = false;

			sCInterface.final_ID = false;

			sCInterface.finally_ID = false;

			sCInterface.float_ID = false;

			sCInterface.for_ID = false;

			sCInterface.goto_ID = false;

			sCInterface.if_ID = false;

			sCInterface.implements_ID = false;

			sCInterface.import_ID = false;

			sCInterface.instanceof_ID = false;

			sCInterface.int_ID = false;

			sCInterface.long_ID = false;

			sCInterface.new_ID = false;

			sCInterface.null_ID = false;

			sCInterface.package_ID = false;

			sCInterface.private_ID = false;

			sCInterface.protected_ID = false;

			sCInterface.public_ID = false;

			sCInterface.return_ID = false;

			sCInterface.short_ID = false;

			sCInterface.static_ID = false;

			sCInterface.strictfp_ID = false;

			sCInterface.super_ID = false;

			sCInterface.switch_ID = false;

			sCInterface.synchronized_ID = false;

			sCInterface.this_ID = false;

			sCInterface.throw_ID = false;

			sCInterface.throws_ID = false;

			sCInterface.transient_ID = false;

			sCInterface.try_ID = false;

			sCInterface.void_ID = false;

			sCInterface.volatile_ID = false;

			nextStateIndex = 0;
			stateVector[0] = State.goto_boolean;
		}
	}

	/* The reactions of state boolean. */
	private void reactGoto_boolean() {
		if (sCInterface.while_ID) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			nextStateIndex = 0;
			stateVector[0] = State.goto_void_volatile_transient_throw_false;
		} else {
			if (sCInterface.ev) {
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;

				/* Enter the region with shallow history */
				if (historyVector[0] != State.$NullState$) {
					shallowEnterSequenceGoto_void_volatile();
				} else {
					nextStateIndex = 0;
					stateVector[0] = State.goto_void_volatile_state;
				}
			}
		}
	}

	/* The reactions of state false. */
	private void reactGoto_void_volatile_transient_throw_false() {
	}

	/* The reactions of state state. */
	private void reactGoto_void_volatile_state() {
		if (sCInterface.ev) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			/* Enter the region with deep history */
			if (historyVector[1] != State.$NullState$) {
				deepEnterSequenceGoto_void_volatile_transient_throw();
			} else {
				nextStateIndex = 0;
				stateVector[0] = State.goto_void_volatile_transient_throw_false;
			}
		}
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case goto_abstract :
					reactGoto_abstract();
					break;
				case goto_boolean :
					reactGoto_boolean();
					break;
				case goto_void_volatile_transient_throw_false :
					reactGoto_void_volatile_transient_throw_false();
					break;
				case goto_void_volatile_state :
					reactGoto_void_volatile_state();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
