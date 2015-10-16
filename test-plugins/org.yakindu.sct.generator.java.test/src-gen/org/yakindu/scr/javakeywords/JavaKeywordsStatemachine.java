package org.yakindu.scr.javakeywords;

public class JavaKeywordsStatemachine implements IJavaKeywordsStatemachine {

	protected class SCInterfaceImpl implements SCInterface {

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

		protected void clearEvents() {
			while_ID = false;
			ev = false;
		}

	}

	protected SCInterfaceImpl sCInterface;

	private boolean initialized = false;

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
		this.initialized = true;
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		for (int i = 0; i < 2; i++) {
			historyVector[i] = State.$NullState$;
		}
		clearEvents();
		clearOutEvents();

		sCInterface.setAbstract(false);

		sCInterface.setAssert(false);

		sCInterface.setBoolean(false);

		sCInterface.setBreak(false);

		sCInterface.setByte(false);

		sCInterface.setCase(false);

		sCInterface.setCatch(false);

		sCInterface.setChar(false);

		sCInterface.setClass_ID(false);

		sCInterface.setContinue(false);

		sCInterface.setDo(false);

		sCInterface.setDouble(false);

		sCInterface.setEnum(false);

		sCInterface.setExtends(false);

		sCInterface.setFinal(false);

		sCInterface.setFinally(false);

		sCInterface.setFloat(false);

		sCInterface.setFor(false);

		sCInterface.setGoto(false);

		sCInterface.setIf(false);

		sCInterface.setImplements(false);

		sCInterface.setInstanceof(false);

		sCInterface.setInt(false);

		sCInterface.setLong(false);

		sCInterface.setNative(false);

		sCInterface.setNew(false);

		sCInterface.setPackage(false);

		sCInterface.setPrivate(false);

		sCInterface.setProtected(false);

		sCInterface.setPublic(false);

		sCInterface.setReturn(false);

		sCInterface.setShort(false);

		sCInterface.setStatic(false);

		sCInterface.setStrictfp(false);

		sCInterface.setSuper(false);

		sCInterface.setSwitch(false);

		sCInterface.setSynchronized(false);

		sCInterface.setThis(false);

		sCInterface.setThrow(false);

		sCInterface.setThrows(false);

		sCInterface.setTransient(false);

		sCInterface.setTry(false);

		sCInterface.setVoid(false);

		sCInterface.setVolatile(false);
	}

	public void enter() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		entryAction();

		enterSequence_goto_default();
	}

	public void exit() {
		initialized = false;
		exitSequence_goto();

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
			case goto_abstract :
				return stateVector[0] == State.goto_abstract;
			case goto_boolean :
				return stateVector[0] == State.goto_boolean;
			case goto_void :
				return stateVector[0].ordinal() >= State.goto_void.ordinal()
						&& stateVector[0].ordinal() <= State.goto_void_volatile_state.ordinal();
			case goto_void_volatile_transient :
				return stateVector[0].ordinal() >= State.goto_void_volatile_transient.ordinal()
						&& stateVector[0].ordinal() <= State.goto_void_volatile_transient_throw_false.ordinal();
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

	private boolean check_goto_abstract_tr0_tr0() {
		return (sCInterface.while_ID) && true;
	}

	private boolean check_goto_boolean_tr0_tr0() {
		return sCInterface.while_ID;
	}

	private boolean check_goto_boolean_tr1_tr1() {
		return sCInterface.ev;
	}

	private boolean check_goto_void_volatile_state_tr0_tr0() {
		return sCInterface.ev;
	}

	private void effect_goto_abstract_tr0() {
		exitSequence_goto_abstract();

		sCInterface.setNative(false);

		enterSequence_goto_boolean_default();
	}

	private void effect_goto_boolean_tr0() {
		exitSequence_goto_boolean();

		enterSequence_goto_void_default();
	}

	private void effect_goto_boolean_tr1() {
		exitSequence_goto_boolean();

		enterSequence_goto_void_try();
	}

	private void effect_goto_void_volatile_state_tr0() {
		exitSequence_goto_void_volatile_state();

		enterSequence_goto_void_volatile_transient_this();
	}

	/* Entry action for statechart 'JavaKeywords'. */
	private void entryAction() {
	}

	/* Entry action for state 'abstract'. */
	private void entryAction_goto_abstract() {
		sCInterface.setAbstract(true);

		sCInterface.setAssert(true);

		sCInterface.setBoolean(true);

		sCInterface.setBreak(true);

		sCInterface.setByte(true);

		sCInterface.setCase(true);

		sCInterface.setCatch(true);

		sCInterface.setChar(true);

		sCInterface.setClass_ID(true);

		sCInterface.setContinue(true);

		sCInterface.setDo(true);

		sCInterface.setDouble(true);

		sCInterface.setEnum(true);

		sCInterface.setExtends(true);

		sCInterface.setFinal(true);

		sCInterface.setFinally(true);

		sCInterface.setFloat(true);

		sCInterface.setFor(true);

		sCInterface.setGoto(true);

		sCInterface.setIf(true);

		sCInterface.setImplements(true);

		sCInterface.setInstanceof(true);

		sCInterface.setInt(true);

		sCInterface.setLong(true);

		sCInterface.setNative(true);

		sCInterface.setNew(true);

		sCInterface.setPackage(true);

		sCInterface.setPrivate(true);

		sCInterface.setProtected(true);

		sCInterface.setPublic(true);

		sCInterface.setReturn(true);

		sCInterface.setShort(true);

		sCInterface.setStatic(true);

		sCInterface.setStrictfp(true);

		sCInterface.setSuper(true);

		sCInterface.setSwitch(true);

		sCInterface.setSynchronized(true);

		sCInterface.setThis(true);

		sCInterface.setThrow(true);

		sCInterface.setThrows(true);

		sCInterface.setTransient(true);

		sCInterface.setTry(true);

		sCInterface.setVoid(true);

		sCInterface.setVolatile(true);
	}

	/* Entry action for state 'boolean'. */
	private void entryAction_goto_boolean() {
		sCInterface.setAbstract(false);

		sCInterface.setAssert(false);

		sCInterface.setBoolean(false);

		sCInterface.setBreak(false);

		sCInterface.setByte(false);

		sCInterface.setCase(false);

		sCInterface.setCatch(false);

		sCInterface.setChar(false);

		sCInterface.setClass_ID(false);

		sCInterface.setContinue(false);

		sCInterface.setDo(false);

		sCInterface.setDouble(false);

		sCInterface.setEnum(false);

		sCInterface.setExtends(false);

		sCInterface.setFinal(false);

		sCInterface.setFinally(false);

		sCInterface.setFloat(false);

		sCInterface.setFor(false);

		sCInterface.setGoto(false);

		sCInterface.setIf(false);

		sCInterface.setImplements(false);

		sCInterface.setInstanceof(false);

		sCInterface.setInt(false);

		sCInterface.setLong(false);

		sCInterface.setNew(false);

		sCInterface.setPackage(false);

		sCInterface.setPrivate(false);

		sCInterface.setProtected(false);

		sCInterface.setPublic(false);

		sCInterface.setReturn(false);

		sCInterface.setShort(false);

		sCInterface.setStatic(false);

		sCInterface.setStrictfp(false);

		sCInterface.setSuper(false);

		sCInterface.setSwitch(false);

		sCInterface.setSynchronized(false);

		sCInterface.setThis(false);

		sCInterface.setThrow(false);

		sCInterface.setThrows(false);

		sCInterface.setTransient(false);

		sCInterface.setTry(false);

		sCInterface.setVoid(false);

		sCInterface.setVolatile(false);
	}

	/* Exit action for state 'JavaKeywords'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state abstract */
	private void enterSequence_goto_abstract_default() {
		entryAction_goto_abstract();

		nextStateIndex = 0;
		stateVector[0] = State.goto_abstract;
	}

	/* 'default' enter sequence for state boolean */
	private void enterSequence_goto_boolean_default() {
		entryAction_goto_boolean();

		nextStateIndex = 0;
		stateVector[0] = State.goto_boolean;
	}

	/* 'default' enter sequence for state void */
	private void enterSequence_goto_void_default() {
		enterSequence_goto_void_volatile_default();
	}

	/* 'try' enter sequence for state void */
	private void enterSequence_goto_void_try() {
		enterSequence_goto_void_volatile_try();
	}

	/* 'default' enter sequence for state transient */
	private void enterSequence_goto_void_volatile_transient_default() {
		enterSequence_goto_void_volatile_transient_throw_default();

		historyVector[0] = stateVector[0];
	}

	/* 'this' enter sequence for state transient */
	private void enterSequence_goto_void_volatile_transient_this() {
		enterSequence_goto_void_volatile_transient_throw_this();

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for state false */
	private void enterSequence_goto_void_volatile_transient_throw_false_default() {
		nextStateIndex = 0;
		stateVector[0] = State.goto_void_volatile_transient_throw_false;

		historyVector[1] = stateVector[0];
	}

	/* 'default' enter sequence for state state */
	private void enterSequence_goto_void_volatile_state_default() {
		nextStateIndex = 0;
		stateVector[0] = State.goto_void_volatile_state;

		historyVector[0] = stateVector[0];
	}

	/* 'default' enter sequence for region goto */
	private void enterSequence_goto_default() {
		react_goto__entry_Default();
	}

	/* 'try' enter sequence for region volatile */
	private void enterSequence_goto_void_volatile_try() {
		react_goto_void_volatile_try();
	}

	/* 'default' enter sequence for region volatile */
	private void enterSequence_goto_void_volatile_default() {
		react_goto_void_volatile__entry_Default();
	}

	/* shallow enterSequence with history in child volatile */
	private void shallowEnterSequence_goto_void_volatile() {
		switch (historyVector[0]) {
			case goto_void_volatile_transient_throw_false :
				enterSequence_goto_void_volatile_transient_default();
				break;

			case goto_void_volatile_state :
				enterSequence_goto_void_volatile_state_default();
				break;

			default :
				break;
		}
	}

	/* 'this' enter sequence for region throw */
	private void enterSequence_goto_void_volatile_transient_throw_this() {
		react_goto_void_volatile_transient_throw_this();
	}

	/* 'default' enter sequence for region throw */
	private void enterSequence_goto_void_volatile_transient_throw_default() {
		react_goto_void_volatile_transient_throw__entry_Default();
	}

	/* deep enterSequence with history in child throw */
	private void deepEnterSequence_goto_void_volatile_transient_throw() {
		switch (historyVector[1]) {
			case goto_void_volatile_transient_throw_false :
				enterSequence_goto_void_volatile_transient_throw_false_default();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for state abstract */
	private void exitSequence_goto_abstract() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state boolean */
	private void exitSequence_goto_boolean() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state false */
	private void exitSequence_goto_void_volatile_transient_throw_false() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state state */
	private void exitSequence_goto_void_volatile_state() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for region goto */
	private void exitSequence_goto() {
		switch (stateVector[0]) {
			case goto_abstract :
				exitSequence_goto_abstract();
				break;

			case goto_boolean :
				exitSequence_goto_boolean();
				break;

			case goto_void_volatile_transient_throw_false :
				exitSequence_goto_void_volatile_transient_throw_false();
				break;

			case goto_void_volatile_state :
				exitSequence_goto_void_volatile_state();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region volatile */
	private void exitSequence_goto_void_volatile() {
		switch (stateVector[0]) {
			case goto_void_volatile_transient_throw_false :
				exitSequence_goto_void_volatile_transient_throw_false();
				break;

			case goto_void_volatile_state :
				exitSequence_goto_void_volatile_state();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region throw */
	private void exitSequence_goto_void_volatile_transient_throw() {
		switch (stateVector[0]) {
			case goto_void_volatile_transient_throw_false :
				exitSequence_goto_void_volatile_transient_throw_false();
				break;

			default :
				break;
		}
	}

	/* The reactions of state abstract. */
	private void react_goto_abstract() {
		if (check_goto_abstract_tr0_tr0()) {
			effect_goto_abstract_tr0();
		}
	}

	/* The reactions of state boolean. */
	private void react_goto_boolean() {
		if (check_goto_boolean_tr0_tr0()) {
			effect_goto_boolean_tr0();
		} else {
			if (check_goto_boolean_tr1_tr1()) {
				effect_goto_boolean_tr1();
			}
		}
	}

	/* The reactions of state false. */
	private void react_goto_void_volatile_transient_throw_false() {
	}

	/* The reactions of state state. */
	private void react_goto_void_volatile_state() {
		if (check_goto_void_volatile_state_tr0_tr0()) {
			effect_goto_void_volatile_state_tr0();
		}
	}

	/* Default react sequence for initial entry  */
	private void react_goto__entry_Default() {
		enterSequence_goto_abstract_default();
	}

	/* Default react sequence for shallow history entry try */
	private void react_goto_void_volatile_try() {
		/* Enter the region with shallow history */
		if (historyVector[0] != State.$NullState$) {
			shallowEnterSequence_goto_void_volatile();
		} else {
			enterSequence_goto_void_volatile_state_default();
		}
	}

	/* Default react sequence for deep history entry this */
	private void react_goto_void_volatile_transient_throw_this() {
		/* Enter the region with deep history */
		if (historyVector[1] != State.$NullState$) {
			deepEnterSequence_goto_void_volatile_transient_throw();
		} else {
			enterSequence_goto_void_volatile_transient_throw_false_default();
		}
	}

	/* Default react sequence for initial entry  */
	private void react_goto_void_volatile_transient_throw__entry_Default() {
		enterSequence_goto_void_volatile_transient_throw_false_default();
	}

	/* Default react sequence for initial entry  */
	private void react_goto_void_volatile__entry_Default() {
		enterSequence_goto_void_volatile_transient_default();
	}

	public void runCycle() {
		if (!initialized)
			throw new IllegalStateException(
					"The statemachine needs to be initialized first by calling the init() function.");

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case goto_abstract :
					react_goto_abstract();
					break;
				case goto_boolean :
					react_goto_boolean();
					break;
				case goto_void_volatile_transient_throw_false :
					react_goto_void_volatile_transient_throw_false();
					break;
				case goto_void_volatile_state :
					react_goto_void_volatile_state();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
