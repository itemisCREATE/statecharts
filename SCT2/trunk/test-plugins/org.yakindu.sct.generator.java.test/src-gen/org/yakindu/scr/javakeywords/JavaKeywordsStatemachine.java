package org.yakindu.scr.javakeywords;

public class JavaKeywordsStatemachine implements IJavaKeywordsStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean while_ID;

		public void raiseWhile() {
			while_ID = true;
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
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		goto_abstract, goto_boolean, goto_void, goto_void_volatile_transient, goto_void_volatile_transient_throw_false, $NullState$
	};

	private State[] historyVector = new State[2];
	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public JavaKeywordsStatemachine() {

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

		sCIDefault.abstract_ID = false;

		sCIDefault.assert_ID = false;

		sCIDefault.boolean_ID = false;

		sCIDefault.break_ID = false;

		sCIDefault.byte_ID = false;

		sCIDefault.case_ID = false;

		sCIDefault.catch_ID = false;

		sCIDefault.char_ID = false;

		sCIDefault.class_ID = false;

		sCIDefault.const_ID = false;

		sCIDefault.continue_ID = false;

		sCIDefault.do_ID = false;

		sCIDefault.double_ID = false;

		sCIDefault.enum_ID = false;

		sCIDefault.extends_ID = false;

		sCIDefault.final_ID = false;

		sCIDefault.finally_ID = false;

		sCIDefault.float_ID = false;

		sCIDefault.for_ID = false;

		sCIDefault.goto_ID = false;

		sCIDefault.if_ID = false;

		sCIDefault.implements_ID = false;

		sCIDefault.import_ID = false;

		sCIDefault.instanceof_ID = false;

		sCIDefault.int_ID = false;

		sCIDefault.long_ID = false;

		sCIDefault.native_ID = false;

		sCIDefault.new_ID = false;

		sCIDefault.null_ID = false;

		sCIDefault.package_ID = false;

		sCIDefault.private_ID = false;

		sCIDefault.protected_ID = false;

		sCIDefault.public_ID = false;

		sCIDefault.return_ID = false;

		sCIDefault.short_ID = false;

		sCIDefault.static_ID = false;

		sCIDefault.strictfp_ID = false;

		sCIDefault.super_ID = false;

		sCIDefault.switch_ID = false;

		sCIDefault.synchronized_ID = false;

		sCIDefault.this_ID = false;

		sCIDefault.throw_ID = false;

		sCIDefault.throws_ID = false;

		sCIDefault.transient_ID = false;

		sCIDefault.try_ID = false;

		sCIDefault.void_ID = false;

		sCIDefault.volatile_ID = false;
	}

	public void enter() {
		entryAction();

		sCIDefault.abstract_ID = true;

		sCIDefault.assert_ID = true;

		sCIDefault.boolean_ID = true;

		sCIDefault.break_ID = true;

		sCIDefault.byte_ID = true;

		sCIDefault.case_ID = true;

		sCIDefault.catch_ID = true;

		sCIDefault.char_ID = true;

		sCIDefault.class_ID = true;

		sCIDefault.const_ID = true;

		sCIDefault.continue_ID = true;

		sCIDefault.do_ID = true;

		sCIDefault.double_ID = true;

		sCIDefault.enum_ID = true;

		sCIDefault.extends_ID = true;

		sCIDefault.final_ID = true;

		sCIDefault.finally_ID = true;

		sCIDefault.float_ID = true;

		sCIDefault.for_ID = true;

		sCIDefault.goto_ID = true;

		sCIDefault.if_ID = true;

		sCIDefault.implements_ID = true;

		sCIDefault.import_ID = true;

		sCIDefault.instanceof_ID = true;

		sCIDefault.int_ID = true;

		sCIDefault.long_ID = true;

		sCIDefault.native_ID = true;

		sCIDefault.new_ID = true;

		sCIDefault.null_ID = true;

		sCIDefault.package_ID = true;

		sCIDefault.private_ID = true;

		sCIDefault.protected_ID = true;

		sCIDefault.public_ID = true;

		sCIDefault.return_ID = true;

		sCIDefault.short_ID = true;

		sCIDefault.static_ID = true;

		sCIDefault.strictfp_ID = true;

		sCIDefault.super_ID = true;

		sCIDefault.switch_ID = true;

		sCIDefault.synchronized_ID = true;

		sCIDefault.this_ID = true;

		sCIDefault.throw_ID = true;

		sCIDefault.throws_ID = true;

		sCIDefault.transient_ID = true;

		sCIDefault.try_ID = true;

		sCIDefault.void_ID = true;

		sCIDefault.volatile_ID = true;

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
			case goto_abstract :
				return stateVector[0] == State.goto_abstract;
			case goto_boolean :
				return stateVector[0] == State.goto_boolean;
			case goto_void :
				return stateVector[0].ordinal() >= State.goto_void.ordinal()
						&& stateVector[0].ordinal() <= State.goto_void_volatile_transient_throw_false
								.ordinal();
			case goto_void_volatile_transient :
				return stateVector[0].ordinal() >= State.goto_void_volatile_transient
						.ordinal()
						&& stateVector[0].ordinal() <= State.goto_void_volatile_transient_throw_false
								.ordinal();
			case goto_void_volatile_transient_throw_false :
				return stateVector[0] == State.goto_void_volatile_transient_throw_false;
			default :
				return false;
		}
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseWhile() {
		sCIDefault.raiseWhile();
	}

	public boolean getAbstract() {
		return sCIDefault.getAbstract();
	}

	public void setAbstract(boolean value) {
		sCIDefault.setAbstract(value);
	}
	public boolean getAssert() {
		return sCIDefault.getAssert();
	}

	public void setAssert(boolean value) {
		sCIDefault.setAssert(value);
	}
	public boolean getBoolean() {
		return sCIDefault.getBoolean();
	}

	public void setBoolean(boolean value) {
		sCIDefault.setBoolean(value);
	}
	public boolean getBreak() {
		return sCIDefault.getBreak();
	}

	public void setBreak(boolean value) {
		sCIDefault.setBreak(value);
	}
	public boolean getByte() {
		return sCIDefault.getByte();
	}

	public void setByte(boolean value) {
		sCIDefault.setByte(value);
	}
	public boolean getCase() {
		return sCIDefault.getCase();
	}

	public void setCase(boolean value) {
		sCIDefault.setCase(value);
	}
	public boolean getCatch() {
		return sCIDefault.getCatch();
	}

	public void setCatch(boolean value) {
		sCIDefault.setCatch(value);
	}
	public boolean getChar() {
		return sCIDefault.getChar();
	}

	public void setChar(boolean value) {
		sCIDefault.setChar(value);
	}
	public boolean getClass_ID() {
		return sCIDefault.getClass_ID();
	}

	public void setClass_ID(boolean value) {
		sCIDefault.setClass_ID(value);
	}
	public boolean getConst() {
		return sCIDefault.getConst();
	}

	public void setConst(boolean value) {
		sCIDefault.setConst(value);
	}
	public boolean getContinue() {
		return sCIDefault.getContinue();
	}

	public void setContinue(boolean value) {
		sCIDefault.setContinue(value);
	}
	public boolean getDo() {
		return sCIDefault.getDo();
	}

	public void setDo(boolean value) {
		sCIDefault.setDo(value);
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
	public boolean getExtends() {
		return sCIDefault.getExtends();
	}

	public void setExtends(boolean value) {
		sCIDefault.setExtends(value);
	}
	public boolean getFinal() {
		return sCIDefault.getFinal();
	}

	public void setFinal(boolean value) {
		sCIDefault.setFinal(value);
	}
	public boolean getFinally() {
		return sCIDefault.getFinally();
	}

	public void setFinally(boolean value) {
		sCIDefault.setFinally(value);
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
	public boolean getImplements() {
		return sCIDefault.getImplements();
	}

	public void setImplements(boolean value) {
		sCIDefault.setImplements(value);
	}
	public boolean getImport() {
		return sCIDefault.getImport();
	}

	public void setImport(boolean value) {
		sCIDefault.setImport(value);
	}
	public boolean getInstanceof() {
		return sCIDefault.getInstanceof();
	}

	public void setInstanceof(boolean value) {
		sCIDefault.setInstanceof(value);
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
	public boolean getNative() {
		return sCIDefault.getNative();
	}

	public void setNative(boolean value) {
		sCIDefault.setNative(value);
	}
	public boolean getNew() {
		return sCIDefault.getNew();
	}

	public void setNew(boolean value) {
		sCIDefault.setNew(value);
	}
	public boolean getNull() {
		return sCIDefault.getNull();
	}

	public void setNull(boolean value) {
		sCIDefault.setNull(value);
	}
	public boolean getPackage() {
		return sCIDefault.getPackage();
	}

	public void setPackage(boolean value) {
		sCIDefault.setPackage(value);
	}
	public boolean getPrivate() {
		return sCIDefault.getPrivate();
	}

	public void setPrivate(boolean value) {
		sCIDefault.setPrivate(value);
	}
	public boolean getProtected() {
		return sCIDefault.getProtected();
	}

	public void setProtected(boolean value) {
		sCIDefault.setProtected(value);
	}
	public boolean getPublic() {
		return sCIDefault.getPublic();
	}

	public void setPublic(boolean value) {
		sCIDefault.setPublic(value);
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
	public boolean getStatic() {
		return sCIDefault.getStatic();
	}

	public void setStatic(boolean value) {
		sCIDefault.setStatic(value);
	}
	public boolean getStrictfp() {
		return sCIDefault.getStrictfp();
	}

	public void setStrictfp(boolean value) {
		sCIDefault.setStrictfp(value);
	}
	public boolean getSuper() {
		return sCIDefault.getSuper();
	}

	public void setSuper(boolean value) {
		sCIDefault.setSuper(value);
	}
	public boolean getSwitch() {
		return sCIDefault.getSwitch();
	}

	public void setSwitch(boolean value) {
		sCIDefault.setSwitch(value);
	}
	public boolean getSynchronized() {
		return sCIDefault.getSynchronized();
	}

	public void setSynchronized(boolean value) {
		sCIDefault.setSynchronized(value);
	}
	public boolean getThis() {
		return sCIDefault.getThis();
	}

	public void setThis(boolean value) {
		sCIDefault.setThis(value);
	}
	public boolean getThrow() {
		return sCIDefault.getThrow();
	}

	public void setThrow(boolean value) {
		sCIDefault.setThrow(value);
	}
	public boolean getThrows() {
		return sCIDefault.getThrows();
	}

	public void setThrows(boolean value) {
		sCIDefault.setThrows(value);
	}
	public boolean getTransient() {
		return sCIDefault.getTransient();
	}

	public void setTransient(boolean value) {
		sCIDefault.setTransient(value);
	}
	public boolean getTry() {
		return sCIDefault.getTry();
	}

	public void setTry(boolean value) {
		sCIDefault.setTry(value);
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
		if (sCIDefault.while_ID && sCIDefault.null_ID) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

			sCIDefault.native_ID = false;

			sCIDefault.abstract_ID = false;

			sCIDefault.assert_ID = false;

			sCIDefault.boolean_ID = false;

			sCIDefault.break_ID = false;

			sCIDefault.byte_ID = false;

			sCIDefault.case_ID = false;

			sCIDefault.catch_ID = false;

			sCIDefault.char_ID = false;

			sCIDefault.class_ID = false;

			sCIDefault.const_ID = false;

			sCIDefault.continue_ID = false;

			sCIDefault.do_ID = false;

			sCIDefault.double_ID = false;

			sCIDefault.enum_ID = false;

			sCIDefault.extends_ID = false;

			sCIDefault.final_ID = false;

			sCIDefault.finally_ID = false;

			sCIDefault.float_ID = false;

			sCIDefault.for_ID = false;

			sCIDefault.goto_ID = false;

			sCIDefault.if_ID = false;

			sCIDefault.implements_ID = false;

			sCIDefault.import_ID = false;

			sCIDefault.instanceof_ID = false;

			sCIDefault.int_ID = false;

			sCIDefault.long_ID = false;

			sCIDefault.new_ID = false;

			sCIDefault.null_ID = false;

			sCIDefault.package_ID = false;

			sCIDefault.private_ID = false;

			sCIDefault.protected_ID = false;

			sCIDefault.public_ID = false;

			sCIDefault.return_ID = false;

			sCIDefault.short_ID = false;

			sCIDefault.static_ID = false;

			sCIDefault.strictfp_ID = false;

			sCIDefault.super_ID = false;

			sCIDefault.switch_ID = false;

			sCIDefault.synchronized_ID = false;

			sCIDefault.this_ID = false;

			sCIDefault.throw_ID = false;

			sCIDefault.throws_ID = false;

			sCIDefault.transient_ID = false;

			sCIDefault.try_ID = false;

			sCIDefault.void_ID = false;

			sCIDefault.volatile_ID = false;

			nextStateIndex = 0;
			stateVector[0] = State.goto_boolean;
		}
	}

	/* The reactions of state boolean. */
	private void reactGoto_boolean() {
		if (sCIDefault.while_ID) {
			nextStateIndex = 0;
			stateVector[0] = State.$NullState$;

		}
	}

	/* The reactions of state false. */
	private void reactGoto_void_volatile_transient_throw_false() {
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
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
