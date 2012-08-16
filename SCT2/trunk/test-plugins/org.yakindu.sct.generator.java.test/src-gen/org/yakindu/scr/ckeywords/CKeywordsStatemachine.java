package org.yakindu.scr.ckeywords;

public class CKeywordsStatemachine implements ICKeywordsStatemachine {

	private final class SCIDefaultImpl implements SCIDefault {

		private boolean auto;

		public void raiseAuto() {
			auto = true;
		}

		private boolean eventBreak;

		public void raiseBreak() {
			eventBreak = true;
		}

		private boolean varCase;

		public boolean getVarCase() {
			return varCase;
		}

		public void setVarCase(boolean value) {
			this.varCase = value;
		}

		private int varDo;

		public int getVarDo() {
			return varDo;
		}

		public void setVarDo(int value) {
			this.varDo = value;
		}

		private boolean varContinue;

		public boolean getVarContinue() {
			return varContinue;
		}

		public void setVarContinue(boolean value) {
			this.varContinue = value;
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

		private boolean extern;

		public boolean getExtern() {
			return extern;
		}

		public void setExtern(boolean value) {
			this.extern = value;
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

		private boolean register;

		public boolean getRegister() {
			return register;
		}

		public void setRegister(boolean value) {
			this.register = value;
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

		private boolean varStatic;

		public boolean getVarStatic() {
			return varStatic;
		}

		public void setVarStatic(boolean value) {
			this.varStatic = value;
		}

		private boolean struct;

		public boolean getStruct() {
			return struct;
		}

		public void setStruct(boolean value) {
			this.struct = value;
		}

		private boolean varSwitch;

		public boolean getVarSwitch() {
			return varSwitch;
		}

		public void setVarSwitch(boolean value) {
			this.varSwitch = value;
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

		private boolean varWhile;

		public boolean getVarWhile() {
			return varWhile;
		}

		public void setVarWhile(boolean value) {
			this.varWhile = value;
		}

		public void clearEvents() {
			auto = false;
			eventBreak = false;
		}

	}

	private SCIDefaultImpl sCIDefault;

	public enum State {
		Auto_char, Auto_const, Auto_const_switch_case, Auto_const_switch_case_enum_asm, $NullState$
	};

	private State[] historyVector = new State[6];

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	public CKeywordsStatemachine() {

		sCIDefault = new SCIDefaultImpl();

	}

	public void init() {
		for (int i = 0; i < 1; i++) {
			stateVector[i] = State.$NullState$;
		}

		for (int i = 0; i < 6; i++) {
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

			case Auto_char :
				return stateVector[0] == State.Auto_char;

			case Auto_const :
				return stateVector[0].ordinal() >= State.Auto_const.ordinal()
						&& stateVector[0].ordinal() <= State.Auto_const_switch_case_enum_asm
								.ordinal();

			case Auto_const_switch_case :
				return stateVector[0].ordinal() >= State.Auto_const_switch_case
						.ordinal()
						&& stateVector[0].ordinal() <= State.Auto_const_switch_case_enum_asm
								.ordinal();

			case Auto_const_switch_case_enum_asm :
				return stateVector[0] == State.Auto_const_switch_case_enum_asm;

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

	public void raiseAuto() {
		sCIDefault.raiseAuto();
	}

	public void raiseBreak() {
		sCIDefault.raiseBreak();
	}

	public boolean getVarCase() {
		return sCIDefault.getVarCase();
	}

	public void setVarCase(boolean value) {
		sCIDefault.setVarCase(value);
	}
	public int getVarDo() {
		return sCIDefault.getVarDo();
	}

	public void setVarDo(int value) {
		sCIDefault.setVarDo(value);
	}
	public boolean getVarContinue() {
		return sCIDefault.getVarContinue();
	}

	public void setVarContinue(boolean value) {
		sCIDefault.setVarContinue(value);
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
	public boolean getExtern() {
		return sCIDefault.getExtern();
	}

	public void setExtern(boolean value) {
		sCIDefault.setExtern(value);
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
	public boolean getRegister() {
		return sCIDefault.getRegister();
	}

	public void setRegister(boolean value) {
		sCIDefault.setRegister(value);
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
	public boolean getVarStatic() {
		return sCIDefault.getVarStatic();
	}

	public void setVarStatic(boolean value) {
		sCIDefault.setVarStatic(value);
	}
	public boolean getStruct() {
		return sCIDefault.getStruct();
	}

	public void setStruct(boolean value) {
		sCIDefault.setStruct(value);
	}
	public boolean getVarSwitch() {
		return sCIDefault.getVarSwitch();
	}

	public void setVarSwitch(boolean value) {
		sCIDefault.setVarSwitch(value);
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
	public boolean getVarWhile() {
		return sCIDefault.getVarWhile();
	}

	public void setVarWhile(boolean value) {
		sCIDefault.setVarWhile(value);
	}

	public void enter() {
		entryActionCKeywords();
		sCIDefault.varCase = true;

		sCIDefault.varDo = 0;

		sCIDefault.varContinue = true;

		sCIDefault.varDouble = true;

		sCIDefault.varEnum = true;

		sCIDefault.extern = true;

		sCIDefault.varFloat = true;

		sCIDefault.varFor = true;

		sCIDefault.varGoto = true;

		sCIDefault.varIf = true;

		sCIDefault.varInt = true;

		sCIDefault.varLong = true;

		sCIDefault.register = true;

		sCIDefault.varReturn = true;

		sCIDefault.varShort = true;

		sCIDefault.signed = true;

		sCIDefault.sizeof = true;

		sCIDefault.varStatic = true;

		sCIDefault.struct = true;

		sCIDefault.varSwitch = true;

		sCIDefault.typedef = true;

		sCIDefault.union = true;

		sCIDefault.unsigned = true;

		sCIDefault.varVoid = true;

		sCIDefault.varVolatile = true;

		sCIDefault.varWhile = true;

		nextStateIndex = 0;
		stateVector[0] = State.Auto_char;

	}

	public void exit() {
		//Handle exit of all possible states (of auto) at position 0...
		switch (stateVector[0]) {

			case Auto_char :
				stateVector[0] = State.$NullState$;

				break;

			default :
				break;
		}

		exitActionCKeywords();
	}

	private void entryActionCKeywords() {

	}

	private void exitActionCKeywords() {

	}

	private void deepEnterSequenceAuto_const_switch_caseEnum() {
		//Handle deep history entry of enum
		switch (historyVector[1]) {

			case Auto_const_switch_case_enum_asm :
				sCIDefault.varCase = false;

				sCIDefault.varDo = 0;

				sCIDefault.varContinue = false;

				sCIDefault.varDouble = false;

				sCIDefault.varEnum = false;

				sCIDefault.extern = false;

				sCIDefault.varFloat = false;

				sCIDefault.varFor = false;

				sCIDefault.varGoto = false;

				sCIDefault.varIf = false;

				sCIDefault.varInt = false;

				sCIDefault.varLong = false;

				sCIDefault.register = false;

				sCIDefault.varReturn = false;

				sCIDefault.varShort = false;

				sCIDefault.signed = false;

				sCIDefault.sizeof = false;

				sCIDefault.varStatic = false;

				sCIDefault.struct = false;

				sCIDefault.varSwitch = false;

				sCIDefault.typedef = false;

				sCIDefault.union = false;

				sCIDefault.unsigned = false;

				sCIDefault.varVoid = false;

				sCIDefault.varVolatile = false;

				sCIDefault.varWhile = false;

				nextStateIndex = 0;
				stateVector[0] = State.Auto_const_switch_case_enum_asm;

				break;

			default :
				break;
		}
	}

	private void shallowEnterSequenceAuto_constSwitch() {
		//Handle shallow history entry of switch
		switch (historyVector[0]) {

			case Auto_const_switch_case_enum_asm :

				break;

			default :
				break;
		}
	}

	private void reactAuto_char() {
		if ((sCIDefault.auto && sCIDefault.varCase)) {
			stateVector[0] = State.$NullState$;

			sCIDefault.varDo += 1;

		}

	}
	private void reactAuto_const() {
	}
	private void reactAuto_const_switch_case() {
	}
	private void reactAuto_const_switch_case_enum_asm() {

	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case Auto_char :
					reactAuto_char();
					break;
				case Auto_const :
					reactAuto_const();
					break;
				case Auto_const_switch_case :
					reactAuto_const_switch_case();
					break;
				case Auto_const_switch_case_enum_asm :
					reactAuto_const_switch_case_enum_asm();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
