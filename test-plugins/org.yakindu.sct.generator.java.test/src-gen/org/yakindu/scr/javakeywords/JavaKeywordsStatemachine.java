package org.yakindu.scr.javakeywords;

public class JavaKeywordsStatemachine implements IJavaKeywordsStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean eventWhile;

		public void raiseWhile() {
			eventWhile = true;
		}

		private boolean varAbstract;

		public boolean getVarAbstract() {
			return varAbstract;
		}

		public void setVarAbstract(boolean value) {
			this.varAbstract = value;
		}

		private boolean varAssert;

		public boolean getVarAssert() {
			return varAssert;
		}

		public void setVarAssert(boolean value) {
			this.varAssert = value;
		}

		private boolean varBoolean;

		public boolean getVarBoolean() {
			return varBoolean;
		}

		public void setVarBoolean(boolean value) {
			this.varBoolean = value;
		}

		private boolean varBreak;

		public boolean getVarBreak() {
			return varBreak;
		}

		public void setVarBreak(boolean value) {
			this.varBreak = value;
		}

		private boolean varByte;

		public boolean getVarByte() {
			return varByte;
		}

		public void setVarByte(boolean value) {
			this.varByte = value;
		}

		private boolean varCase;

		public boolean getVarCase() {
			return varCase;
		}

		public void setVarCase(boolean value) {
			this.varCase = value;
		}

		private boolean varCatch;

		public boolean getVarCatch() {
			return varCatch;
		}

		public void setVarCatch(boolean value) {
			this.varCatch = value;
		}

		private boolean varChar;

		public boolean getVarChar() {
			return varChar;
		}

		public void setVarChar(boolean value) {
			this.varChar = value;
		}

		private boolean varClass;

		public boolean getVarClass() {
			return varClass;
		}

		public void setVarClass(boolean value) {
			this.varClass = value;
		}

		private boolean varConst;

		public boolean getVarConst() {
			return varConst;
		}

		public void setVarConst(boolean value) {
			this.varConst = value;
		}

		private boolean varContinue;

		public boolean getVarContinue() {
			return varContinue;
		}

		public void setVarContinue(boolean value) {
			this.varContinue = value;
		}

		private boolean varDo;

		public boolean getVarDo() {
			return varDo;
		}

		public void setVarDo(boolean value) {
			this.varDo = value;
		}

		private boolean varDouble;

		public boolean getVarDouble() {
			return varDouble;
		}

		public void setVarDouble(boolean value) {
			this.varDouble = value;
		}

		private boolean varEnum;

		public boolean getVarEnum() {
			return varEnum;
		}

		public void setVarEnum(boolean value) {
			this.varEnum = value;
		}

		private boolean varExtends;

		public boolean getVarExtends() {
			return varExtends;
		}

		public void setVarExtends(boolean value) {
			this.varExtends = value;
		}

		private boolean varFinal;

		public boolean getVarFinal() {
			return varFinal;
		}

		public void setVarFinal(boolean value) {
			this.varFinal = value;
		}

		private boolean varFinally;

		public boolean getVarFinally() {
			return varFinally;
		}

		public void setVarFinally(boolean value) {
			this.varFinally = value;
		}

		private boolean varFloat;

		public boolean getVarFloat() {
			return varFloat;
		}

		public void setVarFloat(boolean value) {
			this.varFloat = value;
		}

		private boolean varFor;

		public boolean getVarFor() {
			return varFor;
		}

		public void setVarFor(boolean value) {
			this.varFor = value;
		}

		private boolean varGoto;

		public boolean getVarGoto() {
			return varGoto;
		}

		public void setVarGoto(boolean value) {
			this.varGoto = value;
		}

		private boolean varIf;

		public boolean getVarIf() {
			return varIf;
		}

		public void setVarIf(boolean value) {
			this.varIf = value;
		}

		private boolean varImplements;

		public boolean getVarImplements() {
			return varImplements;
		}

		public void setVarImplements(boolean value) {
			this.varImplements = value;
		}

		private boolean varImport;

		public boolean getVarImport() {
			return varImport;
		}

		public void setVarImport(boolean value) {
			this.varImport = value;
		}

		private boolean varInstanceof;

		public boolean getVarInstanceof() {
			return varInstanceof;
		}

		public void setVarInstanceof(boolean value) {
			this.varInstanceof = value;
		}

		private boolean varInt;

		public boolean getVarInt() {
			return varInt;
		}

		public void setVarInt(boolean value) {
			this.varInt = value;
		}

		private boolean varLong;

		public boolean getVarLong() {
			return varLong;
		}

		public void setVarLong(boolean value) {
			this.varLong = value;
		}

		private boolean varNative;

		public boolean getVarNative() {
			return varNative;
		}

		public void setVarNative(boolean value) {
			this.varNative = value;
		}

		private boolean varNew;

		public boolean getVarNew() {
			return varNew;
		}

		public void setVarNew(boolean value) {
			this.varNew = value;
		}

		private boolean varNull;

		public boolean getVarNull() {
			return varNull;
		}

		public void setVarNull(boolean value) {
			this.varNull = value;
		}

		private boolean varPackage;

		public boolean getVarPackage() {
			return varPackage;
		}

		public void setVarPackage(boolean value) {
			this.varPackage = value;
		}

		private boolean varPrivate;

		public boolean getVarPrivate() {
			return varPrivate;
		}

		public void setVarPrivate(boolean value) {
			this.varPrivate = value;
		}

		private boolean varProtected;

		public boolean getVarProtected() {
			return varProtected;
		}

		public void setVarProtected(boolean value) {
			this.varProtected = value;
		}

		private boolean varPublic;

		public boolean getVarPublic() {
			return varPublic;
		}

		public void setVarPublic(boolean value) {
			this.varPublic = value;
		}

		private boolean varReturn;

		public boolean getVarReturn() {
			return varReturn;
		}

		public void setVarReturn(boolean value) {
			this.varReturn = value;
		}

		private boolean varShort;

		public boolean getVarShort() {
			return varShort;
		}

		public void setVarShort(boolean value) {
			this.varShort = value;
		}

		private boolean varStatic;

		public boolean getVarStatic() {
			return varStatic;
		}

		public void setVarStatic(boolean value) {
			this.varStatic = value;
		}

		private boolean varStrictfp;

		public boolean getVarStrictfp() {
			return varStrictfp;
		}

		public void setVarStrictfp(boolean value) {
			this.varStrictfp = value;
		}

		private boolean varSuper;

		public boolean getVarSuper() {
			return varSuper;
		}

		public void setVarSuper(boolean value) {
			this.varSuper = value;
		}

		private boolean varSwitch;

		public boolean getVarSwitch() {
			return varSwitch;
		}

		public void setVarSwitch(boolean value) {
			this.varSwitch = value;
		}

		private boolean varSynchronized;

		public boolean getVarSynchronized() {
			return varSynchronized;
		}

		public void setVarSynchronized(boolean value) {
			this.varSynchronized = value;
		}

		private boolean varThis;

		public boolean getVarThis() {
			return varThis;
		}

		public void setVarThis(boolean value) {
			this.varThis = value;
		}

		private boolean varThrow;

		public boolean getVarThrow() {
			return varThrow;
		}

		public void setVarThrow(boolean value) {
			this.varThrow = value;
		}

		private boolean varThrows;

		public boolean getVarThrows() {
			return varThrows;
		}

		public void setVarThrows(boolean value) {
			this.varThrows = value;
		}

		private boolean varTransient;

		public boolean getVarTransient() {
			return varTransient;
		}

		public void setVarTransient(boolean value) {
			this.varTransient = value;
		}

		private boolean varTry;

		public boolean getVarTry() {
			return varTry;
		}

		public void setVarTry(boolean value) {
			this.varTry = value;
		}

		private boolean varVoid;

		public boolean getVarVoid() {
			return varVoid;
		}

		public void setVarVoid(boolean value) {
			this.varVoid = value;
		}

		private boolean varVolatile;

		public boolean getVarVolatile() {
			return varVolatile;
		}

		public void setVarVolatile(boolean value) {
			this.varVolatile = value;
		}

		public void clearEvents() {
			eventWhile = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		Goto_abstract, Goto_boolean, Goto_void, Goto_void_volatile_transient, Goto_void_volatile_transient_throw_false, $NullState$
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
	}

	protected void clearEvents() {
		sCIDefault.clearEvents();

	}

	protected void clearOutEvents() {
	}

	public boolean isStateActive(State state) {
		switch (state) {

			case Goto_abstract :
				return stateVector[0] == State.Goto_abstract;

			case Goto_boolean :
				return stateVector[0] == State.Goto_boolean;

			case Goto_void :
				return stateVector[0].ordinal() >= State.Goto_void.ordinal()
						&& stateVector[0].ordinal() <= State.Goto_void_volatile_transient_throw_false
								.ordinal();

			case Goto_void_volatile_transient :
				return stateVector[0].ordinal() >= State.Goto_void_volatile_transient
						.ordinal()
						&& stateVector[0].ordinal() <= State.Goto_void_volatile_transient_throw_false
								.ordinal();

			case Goto_void_volatile_transient_throw_false :
				return stateVector[0] == State.Goto_void_volatile_transient_throw_false;

			default :
				return false;
		}
		/*
		for (int i=0;i<stateVector.length;i++){
			if (stateVector[i]==state) {
				return true;
			}
		}
		return false;
		 */
	}

	public SCIDefault getSCIDefault() {
		return sCIDefault;
	}

	public void raiseWhile() {
		sCIDefault.raiseWhile();
	}

	public boolean getVarAbstract() {
		return sCIDefault.getVarAbstract();
	}

	public void setVarAbstract(boolean value) {
		sCIDefault.setVarAbstract(value);
	}
	public boolean getVarAssert() {
		return sCIDefault.getVarAssert();
	}

	public void setVarAssert(boolean value) {
		sCIDefault.setVarAssert(value);
	}
	public boolean getVarBoolean() {
		return sCIDefault.getVarBoolean();
	}

	public void setVarBoolean(boolean value) {
		sCIDefault.setVarBoolean(value);
	}
	public boolean getVarBreak() {
		return sCIDefault.getVarBreak();
	}

	public void setVarBreak(boolean value) {
		sCIDefault.setVarBreak(value);
	}
	public boolean getVarByte() {
		return sCIDefault.getVarByte();
	}

	public void setVarByte(boolean value) {
		sCIDefault.setVarByte(value);
	}
	public boolean getVarCase() {
		return sCIDefault.getVarCase();
	}

	public void setVarCase(boolean value) {
		sCIDefault.setVarCase(value);
	}
	public boolean getVarCatch() {
		return sCIDefault.getVarCatch();
	}

	public void setVarCatch(boolean value) {
		sCIDefault.setVarCatch(value);
	}
	public boolean getVarChar() {
		return sCIDefault.getVarChar();
	}

	public void setVarChar(boolean value) {
		sCIDefault.setVarChar(value);
	}
	public boolean getVarClass() {
		return sCIDefault.getVarClass();
	}

	public void setVarClass(boolean value) {
		sCIDefault.setVarClass(value);
	}
	public boolean getVarConst() {
		return sCIDefault.getVarConst();
	}

	public void setVarConst(boolean value) {
		sCIDefault.setVarConst(value);
	}
	public boolean getVarContinue() {
		return sCIDefault.getVarContinue();
	}

	public void setVarContinue(boolean value) {
		sCIDefault.setVarContinue(value);
	}
	public boolean getVarDo() {
		return sCIDefault.getVarDo();
	}

	public void setVarDo(boolean value) {
		sCIDefault.setVarDo(value);
	}
	public boolean getVarDouble() {
		return sCIDefault.getVarDouble();
	}

	public void setVarDouble(boolean value) {
		sCIDefault.setVarDouble(value);
	}
	public boolean getVarEnum() {
		return sCIDefault.getVarEnum();
	}

	public void setVarEnum(boolean value) {
		sCIDefault.setVarEnum(value);
	}
	public boolean getVarExtends() {
		return sCIDefault.getVarExtends();
	}

	public void setVarExtends(boolean value) {
		sCIDefault.setVarExtends(value);
	}
	public boolean getVarFinal() {
		return sCIDefault.getVarFinal();
	}

	public void setVarFinal(boolean value) {
		sCIDefault.setVarFinal(value);
	}
	public boolean getVarFinally() {
		return sCIDefault.getVarFinally();
	}

	public void setVarFinally(boolean value) {
		sCIDefault.setVarFinally(value);
	}
	public boolean getVarFloat() {
		return sCIDefault.getVarFloat();
	}

	public void setVarFloat(boolean value) {
		sCIDefault.setVarFloat(value);
	}
	public boolean getVarFor() {
		return sCIDefault.getVarFor();
	}

	public void setVarFor(boolean value) {
		sCIDefault.setVarFor(value);
	}
	public boolean getVarGoto() {
		return sCIDefault.getVarGoto();
	}

	public void setVarGoto(boolean value) {
		sCIDefault.setVarGoto(value);
	}
	public boolean getVarIf() {
		return sCIDefault.getVarIf();
	}

	public void setVarIf(boolean value) {
		sCIDefault.setVarIf(value);
	}
	public boolean getVarImplements() {
		return sCIDefault.getVarImplements();
	}

	public void setVarImplements(boolean value) {
		sCIDefault.setVarImplements(value);
	}
	public boolean getVarImport() {
		return sCIDefault.getVarImport();
	}

	public void setVarImport(boolean value) {
		sCIDefault.setVarImport(value);
	}
	public boolean getVarInstanceof() {
		return sCIDefault.getVarInstanceof();
	}

	public void setVarInstanceof(boolean value) {
		sCIDefault.setVarInstanceof(value);
	}
	public boolean getVarInt() {
		return sCIDefault.getVarInt();
	}

	public void setVarInt(boolean value) {
		sCIDefault.setVarInt(value);
	}
	public boolean getVarLong() {
		return sCIDefault.getVarLong();
	}

	public void setVarLong(boolean value) {
		sCIDefault.setVarLong(value);
	}
	public boolean getVarNative() {
		return sCIDefault.getVarNative();
	}

	public void setVarNative(boolean value) {
		sCIDefault.setVarNative(value);
	}
	public boolean getVarNew() {
		return sCIDefault.getVarNew();
	}

	public void setVarNew(boolean value) {
		sCIDefault.setVarNew(value);
	}
	public boolean getVarNull() {
		return sCIDefault.getVarNull();
	}

	public void setVarNull(boolean value) {
		sCIDefault.setVarNull(value);
	}
	public boolean getVarPackage() {
		return sCIDefault.getVarPackage();
	}

	public void setVarPackage(boolean value) {
		sCIDefault.setVarPackage(value);
	}
	public boolean getVarPrivate() {
		return sCIDefault.getVarPrivate();
	}

	public void setVarPrivate(boolean value) {
		sCIDefault.setVarPrivate(value);
	}
	public boolean getVarProtected() {
		return sCIDefault.getVarProtected();
	}

	public void setVarProtected(boolean value) {
		sCIDefault.setVarProtected(value);
	}
	public boolean getVarPublic() {
		return sCIDefault.getVarPublic();
	}

	public void setVarPublic(boolean value) {
		sCIDefault.setVarPublic(value);
	}
	public boolean getVarReturn() {
		return sCIDefault.getVarReturn();
	}

	public void setVarReturn(boolean value) {
		sCIDefault.setVarReturn(value);
	}
	public boolean getVarShort() {
		return sCIDefault.getVarShort();
	}

	public void setVarShort(boolean value) {
		sCIDefault.setVarShort(value);
	}
	public boolean getVarStatic() {
		return sCIDefault.getVarStatic();
	}

	public void setVarStatic(boolean value) {
		sCIDefault.setVarStatic(value);
	}
	public boolean getVarStrictfp() {
		return sCIDefault.getVarStrictfp();
	}

	public void setVarStrictfp(boolean value) {
		sCIDefault.setVarStrictfp(value);
	}
	public boolean getVarSuper() {
		return sCIDefault.getVarSuper();
	}

	public void setVarSuper(boolean value) {
		sCIDefault.setVarSuper(value);
	}
	public boolean getVarSwitch() {
		return sCIDefault.getVarSwitch();
	}

	public void setVarSwitch(boolean value) {
		sCIDefault.setVarSwitch(value);
	}
	public boolean getVarSynchronized() {
		return sCIDefault.getVarSynchronized();
	}

	public void setVarSynchronized(boolean value) {
		sCIDefault.setVarSynchronized(value);
	}
	public boolean getVarThis() {
		return sCIDefault.getVarThis();
	}

	public void setVarThis(boolean value) {
		sCIDefault.setVarThis(value);
	}
	public boolean getVarThrow() {
		return sCIDefault.getVarThrow();
	}

	public void setVarThrow(boolean value) {
		sCIDefault.setVarThrow(value);
	}
	public boolean getVarThrows() {
		return sCIDefault.getVarThrows();
	}

	public void setVarThrows(boolean value) {
		sCIDefault.setVarThrows(value);
	}
	public boolean getVarTransient() {
		return sCIDefault.getVarTransient();
	}

	public void setVarTransient(boolean value) {
		sCIDefault.setVarTransient(value);
	}
	public boolean getVarTry() {
		return sCIDefault.getVarTry();
	}

	public void setVarTry(boolean value) {
		sCIDefault.setVarTry(value);
	}
	public boolean getVarVoid() {
		return sCIDefault.getVarVoid();
	}

	public void setVarVoid(boolean value) {
		sCIDefault.setVarVoid(value);
	}
	public boolean getVarVolatile() {
		return sCIDefault.getVarVolatile();
	}

	public void setVarVolatile(boolean value) {
		sCIDefault.setVarVolatile(value);
	}

	public void enter() {
		entryActionJavaKeywords();
		sCIDefault.varAbstract = true;

		sCIDefault.varAssert = true;

		sCIDefault.varBoolean = true;

		sCIDefault.varBreak = true;

		sCIDefault.varByte = true;

		sCIDefault.varCase = true;

		sCIDefault.varCatch = true;

		sCIDefault.varChar = true;

		sCIDefault.varClass = true;

		sCIDefault.varConst = true;

		sCIDefault.varContinue = true;

		sCIDefault.varDo = true;

		sCIDefault.varDouble = true;

		sCIDefault.varEnum = true;

		sCIDefault.varExtends = true;

		sCIDefault.varFinal = true;

		sCIDefault.varFinally = true;

		sCIDefault.varFloat = true;

		sCIDefault.varFor = true;

		sCIDefault.varGoto = true;

		sCIDefault.varIf = true;

		sCIDefault.varImplements = true;

		sCIDefault.varImport = true;

		sCIDefault.varInstanceof = true;

		sCIDefault.varInt = true;

		sCIDefault.varLong = true;

		sCIDefault.varNative = true;

		sCIDefault.varNew = true;

		sCIDefault.varNull = true;

		sCIDefault.varPackage = true;

		sCIDefault.varPrivate = true;

		sCIDefault.varProtected = true;

		sCIDefault.varPublic = true;

		sCIDefault.varReturn = true;

		sCIDefault.varShort = true;

		sCIDefault.varStatic = true;

		sCIDefault.varStrictfp = true;

		sCIDefault.varSuper = true;

		sCIDefault.varSwitch = true;

		sCIDefault.varSynchronized = true;

		sCIDefault.varThis = true;

		sCIDefault.varThrow = true;

		sCIDefault.varThrows = true;

		sCIDefault.varTransient = true;

		sCIDefault.varTry = true;

		sCIDefault.varVoid = true;

		sCIDefault.varVolatile = true;

		nextStateIndex = 0;
		stateVector[0] = State.Goto_abstract;

	}

	public void exit() {
		//Handle exit of all possible states (of goto) at position 0...
		switch (stateVector[0]) {

			case Goto_abstract :
				stateVector[0] = State.$NullState$;

				break;

			case Goto_boolean :
				stateVector[0] = State.$NullState$;

				break;

			case Goto_void_volatile_transient_throw_false :

				historyVector[1] = stateVector[0];

				historyVector[0] = stateVector[0];
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionJavaKeywords();
	}

	private void entryActionJavaKeywords() {

	}

	private void exitActionJavaKeywords() {

	}

	private void deepEnterSequenceGoto_void_volatile_transientThrow() {
		//Handle deep history entry of throw
		switch (historyVector[1]) {

			case Goto_void_volatile_transient_throw_false :
				nextStateIndex = 0;
				stateVector[0] = State.Goto_void_volatile_transient_throw_false;

				break;

			default :
				break;
		}
	}

	private void shallowEnterSequenceGoto_voidVolatile() {
		//Handle shallow history entry of volatile
		switch (historyVector[0]) {

			case Goto_void_volatile_transient_throw_false :

				break;

			default :
				break;
		}
	}

	private void reactGoto_abstract() {
		if ((sCIDefault.eventWhile && sCIDefault.varNull)) {
			stateVector[0] = State.$NullState$;

			sCIDefault.varNative = false;

			sCIDefault.varAbstract = false;

			sCIDefault.varAssert = false;

			sCIDefault.varBoolean = false;

			sCIDefault.varBreak = false;

			sCIDefault.varByte = false;

			sCIDefault.varCase = false;

			sCIDefault.varCatch = false;

			sCIDefault.varChar = false;

			sCIDefault.varClass = false;

			sCIDefault.varConst = false;

			sCIDefault.varContinue = false;

			sCIDefault.varDo = false;

			sCIDefault.varDouble = false;

			sCIDefault.varEnum = false;

			sCIDefault.varExtends = false;

			sCIDefault.varFinal = false;

			sCIDefault.varFinally = false;

			sCIDefault.varFloat = false;

			sCIDefault.varFor = false;

			sCIDefault.varGoto = false;

			sCIDefault.varIf = false;

			sCIDefault.varImplements = false;

			sCIDefault.varImport = false;

			sCIDefault.varInstanceof = false;

			sCIDefault.varInt = false;

			sCIDefault.varLong = false;

			sCIDefault.varNew = false;

			sCIDefault.varNull = false;

			sCIDefault.varPackage = false;

			sCIDefault.varPrivate = false;

			sCIDefault.varProtected = false;

			sCIDefault.varPublic = false;

			sCIDefault.varReturn = false;

			sCIDefault.varShort = false;

			sCIDefault.varStatic = false;

			sCIDefault.varStrictfp = false;

			sCIDefault.varSuper = false;

			sCIDefault.varSwitch = false;

			sCIDefault.varSynchronized = false;

			sCIDefault.varThis = false;

			sCIDefault.varThrow = false;

			sCIDefault.varThrows = false;

			sCIDefault.varTransient = false;

			sCIDefault.varTry = false;

			sCIDefault.varVoid = false;

			sCIDefault.varVolatile = false;

			nextStateIndex = 0;
			stateVector[0] = State.Goto_boolean;

		}

	}
	private void reactGoto_boolean() {
		if (sCIDefault.eventWhile) {
			stateVector[0] = State.$NullState$;

		}

	}
	private void reactGoto_void() {
	}
	private void reactGoto_void_volatile_transient() {
	}
	private void reactGoto_void_volatile_transient_throw_false() {

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case Goto_abstract :
					reactGoto_abstract();
					break;
				case Goto_boolean :
					reactGoto_boolean();
					break;
				case Goto_void :
					reactGoto_void();
					break;
				case Goto_void_volatile_transient :
					reactGoto_void_volatile_transient();
					break;
				case Goto_void_volatile_transient_throw_false :
					reactGoto_void_volatile_transient_throw_false();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
