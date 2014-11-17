package org.yakindu.scr.stextkeywordsinstatesandregions;

public class STextKeywordsInStatesAndRegionsStatemachine
		implements
			ISTextKeywordsInStatesAndRegionsStatemachine {

	private final class SCInterfaceImpl implements SCInterface {

		private boolean e1;

		public void raiseE1() {
			e1 = true;
		}

		private boolean e2;

		public void raiseE2() {
			e2 = true;
		}

		public void clearEvents() {
			e1 = false;
			e2 = false;
		}

	}

	private SCInterfaceImpl sCInterface;

	public enum State {
		default_namespace, operation_interface, operation_internal, namespace_event, namespace_local, local_in, local_out, interface_var, interface_readonly, internal_external, internal_operation, event_default, event_else, in_entry, in_exit, out_always, out_oncycle, var_raise, var_valueof, readonly_active, readonly_namespace, external_interface, external_internal, else_event, else_local, entry_in, entry_out, exit_var, exit_readonly, always_external, always_operation, oncycle_default, oncycle_else, raise_entry, raise_exit, valueof_always, valueof_oncycle, active_raise, active_valueof, $NullState$
	};

	private final State[] stateVector = new State[20];

	private int nextStateIndex;

	public STextKeywordsInStatesAndRegionsStatemachine() {

		sCInterface = new SCInterfaceImpl();
	}

	public void init() {
		for (int i = 0; i < 20; i++) {
			stateVector[i] = State.$NullState$;
		}

		clearEvents();
		clearOutEvents();

	}

	public void enter() {
		entryAction();

		nextStateIndex = 0;
		stateVector[0] = State.default_namespace;

		nextStateIndex = 1;
		stateVector[1] = State.operation_interface;

		nextStateIndex = 2;
		stateVector[2] = State.namespace_event;

		nextStateIndex = 3;
		stateVector[3] = State.local_in;

		nextStateIndex = 4;
		stateVector[4] = State.interface_var;

		nextStateIndex = 5;
		stateVector[5] = State.internal_external;

		nextStateIndex = 6;
		stateVector[6] = State.event_default;

		nextStateIndex = 7;
		stateVector[7] = State.in_entry;

		nextStateIndex = 8;
		stateVector[8] = State.out_always;

		nextStateIndex = 9;
		stateVector[9] = State.var_raise;

		nextStateIndex = 10;
		stateVector[10] = State.readonly_active;

		nextStateIndex = 11;
		stateVector[11] = State.external_interface;

		nextStateIndex = 12;
		stateVector[12] = State.else_event;

		nextStateIndex = 13;
		stateVector[13] = State.entry_in;

		nextStateIndex = 14;
		stateVector[14] = State.exit_var;

		nextStateIndex = 15;
		stateVector[15] = State.always_external;

		nextStateIndex = 16;
		stateVector[16] = State.oncycle_default;

		nextStateIndex = 17;
		stateVector[17] = State.raise_entry;

		nextStateIndex = 18;
		stateVector[18] = State.valueof_always;

		nextStateIndex = 19;
		stateVector[19] = State.active_raise;
	}

	public void exit() {
		switch (stateVector[0]) {
			case default_namespace :
				nextStateIndex = 0;
				stateVector[0] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[1]) {
			case operation_interface :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			case operation_internal :
				nextStateIndex = 1;
				stateVector[1] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[2]) {
			case namespace_event :
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			case namespace_local :
				nextStateIndex = 2;
				stateVector[2] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[3]) {
			case local_in :
				nextStateIndex = 3;
				stateVector[3] = State.$NullState$;
				break;

			case local_out :
				nextStateIndex = 3;
				stateVector[3] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[4]) {
			case interface_var :
				nextStateIndex = 4;
				stateVector[4] = State.$NullState$;
				break;

			case interface_readonly :
				nextStateIndex = 4;
				stateVector[4] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[5]) {
			case internal_external :
				nextStateIndex = 5;
				stateVector[5] = State.$NullState$;
				break;

			case internal_operation :
				nextStateIndex = 5;
				stateVector[5] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[6]) {
			case event_default :
				nextStateIndex = 6;
				stateVector[6] = State.$NullState$;
				break;

			case event_else :
				nextStateIndex = 6;
				stateVector[6] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[7]) {
			case in_entry :
				nextStateIndex = 7;
				stateVector[7] = State.$NullState$;
				break;

			case in_exit :
				nextStateIndex = 7;
				stateVector[7] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[8]) {
			case out_always :
				nextStateIndex = 8;
				stateVector[8] = State.$NullState$;
				break;

			case out_oncycle :
				nextStateIndex = 8;
				stateVector[8] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[9]) {
			case var_raise :
				nextStateIndex = 9;
				stateVector[9] = State.$NullState$;
				break;

			case var_valueof :
				nextStateIndex = 9;
				stateVector[9] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[10]) {
			case readonly_active :
				nextStateIndex = 10;
				stateVector[10] = State.$NullState$;
				break;

			case readonly_namespace :
				nextStateIndex = 10;
				stateVector[10] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[11]) {
			case external_interface :
				nextStateIndex = 11;
				stateVector[11] = State.$NullState$;
				break;

			case external_internal :
				nextStateIndex = 11;
				stateVector[11] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[12]) {
			case else_event :
				nextStateIndex = 12;
				stateVector[12] = State.$NullState$;
				break;

			case else_local :
				nextStateIndex = 12;
				stateVector[12] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[13]) {
			case entry_in :
				nextStateIndex = 13;
				stateVector[13] = State.$NullState$;
				break;

			case entry_out :
				nextStateIndex = 13;
				stateVector[13] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[14]) {
			case exit_var :
				nextStateIndex = 14;
				stateVector[14] = State.$NullState$;
				break;

			case exit_readonly :
				nextStateIndex = 14;
				stateVector[14] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[15]) {
			case always_external :
				nextStateIndex = 15;
				stateVector[15] = State.$NullState$;
				break;

			case always_operation :
				nextStateIndex = 15;
				stateVector[15] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[16]) {
			case oncycle_default :
				nextStateIndex = 16;
				stateVector[16] = State.$NullState$;
				break;

			case oncycle_else :
				nextStateIndex = 16;
				stateVector[16] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[17]) {
			case raise_entry :
				nextStateIndex = 17;
				stateVector[17] = State.$NullState$;
				break;

			case raise_exit :
				nextStateIndex = 17;
				stateVector[17] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[18]) {
			case valueof_always :
				nextStateIndex = 18;
				stateVector[18] = State.$NullState$;
				break;

			case valueof_oncycle :
				nextStateIndex = 18;
				stateVector[18] = State.$NullState$;
				break;

			default :
				break;
		}

		switch (stateVector[19]) {
			case active_raise :
				nextStateIndex = 19;
				stateVector[19] = State.$NullState$;
				break;

			case active_valueof :
				nextStateIndex = 19;
				stateVector[19] = State.$NullState$;
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
			case default_namespace :
				return stateVector[0] == State.default_namespace;
			case operation_interface :
				return stateVector[1] == State.operation_interface;
			case operation_internal :
				return stateVector[1] == State.operation_internal;
			case namespace_event :
				return stateVector[2] == State.namespace_event;
			case namespace_local :
				return stateVector[2] == State.namespace_local;
			case local_in :
				return stateVector[3] == State.local_in;
			case local_out :
				return stateVector[3] == State.local_out;
			case interface_var :
				return stateVector[4] == State.interface_var;
			case interface_readonly :
				return stateVector[4] == State.interface_readonly;
			case internal_external :
				return stateVector[5] == State.internal_external;
			case internal_operation :
				return stateVector[5] == State.internal_operation;
			case event_default :
				return stateVector[6] == State.event_default;
			case event_else :
				return stateVector[6] == State.event_else;
			case in_entry :
				return stateVector[7] == State.in_entry;
			case in_exit :
				return stateVector[7] == State.in_exit;
			case out_always :
				return stateVector[8] == State.out_always;
			case out_oncycle :
				return stateVector[8] == State.out_oncycle;
			case var_raise :
				return stateVector[9] == State.var_raise;
			case var_valueof :
				return stateVector[9] == State.var_valueof;
			case readonly_active :
				return stateVector[10] == State.readonly_active;
			case readonly_namespace :
				return stateVector[10] == State.readonly_namespace;
			case external_interface :
				return stateVector[11] == State.external_interface;
			case external_internal :
				return stateVector[11] == State.external_internal;
			case else_event :
				return stateVector[12] == State.else_event;
			case else_local :
				return stateVector[12] == State.else_local;
			case entry_in :
				return stateVector[13] == State.entry_in;
			case entry_out :
				return stateVector[13] == State.entry_out;
			case exit_var :
				return stateVector[14] == State.exit_var;
			case exit_readonly :
				return stateVector[14] == State.exit_readonly;
			case always_external :
				return stateVector[15] == State.always_external;
			case always_operation :
				return stateVector[15] == State.always_operation;
			case oncycle_default :
				return stateVector[16] == State.oncycle_default;
			case oncycle_else :
				return stateVector[16] == State.oncycle_else;
			case raise_entry :
				return stateVector[17] == State.raise_entry;
			case raise_exit :
				return stateVector[17] == State.raise_exit;
			case valueof_always :
				return stateVector[18] == State.valueof_always;
			case valueof_oncycle :
				return stateVector[18] == State.valueof_oncycle;
			case active_raise :
				return stateVector[19] == State.active_raise;
			case active_valueof :
				return stateVector[19] == State.active_valueof;
			default :
				return false;
		}
	}

	public SCInterface getSCInterface() {
		return sCInterface;
	}

	public void raiseE1() {
		sCInterface.raiseE1();
	}
	public void raiseE2() {
		sCInterface.raiseE2();
	}

	/* Entry action for statechart 'STextKeywordsInStatesAndRegions'. */
	private void entryAction() {
	}

	/* Exit action for state 'STextKeywordsInStatesAndRegions'. */
	private void exitAction() {
	}

	/* The reactions of state namespace. */
	private void reactDefault_namespace() {
	}

	/* The reactions of state interface. */
	private void reactOperation_interface() {
		if ((sCInterface.e1) && isStateActive(State.default_namespace)) {
			nextStateIndex = 1;
			stateVector[1] = State.$NullState$;

			nextStateIndex = 1;
			stateVector[1] = State.operation_internal;
		}
	}

	/* The reactions of state internal. */
	private void reactOperation_internal() {
	}

	/* The reactions of state event. */
	private void reactNamespace_event() {
		if ((sCInterface.e2) && isStateActive(State.operation_internal)) {
			nextStateIndex = 2;
			stateVector[2] = State.$NullState$;

			nextStateIndex = 2;
			stateVector[2] = State.namespace_local;
		}
	}

	/* The reactions of state local. */
	private void reactNamespace_local() {
	}

	/* The reactions of state in. */
	private void reactLocal_in() {
		if ((sCInterface.e1) && isStateActive(State.namespace_local)) {
			nextStateIndex = 3;
			stateVector[3] = State.$NullState$;

			nextStateIndex = 3;
			stateVector[3] = State.local_out;
		}
	}

	/* The reactions of state out. */
	private void reactLocal_out() {
	}

	/* The reactions of state var. */
	private void reactInterface_var() {
		if ((sCInterface.e2) && isStateActive(State.local_out)) {
			nextStateIndex = 4;
			stateVector[4] = State.$NullState$;

			nextStateIndex = 4;
			stateVector[4] = State.interface_readonly;
		}
	}

	/* The reactions of state readonly. */
	private void reactInterface_readonly() {
	}

	/* The reactions of state external. */
	private void reactInternal_external() {
		if ((sCInterface.e1) && isStateActive(State.interface_readonly)) {
			nextStateIndex = 5;
			stateVector[5] = State.$NullState$;

			nextStateIndex = 5;
			stateVector[5] = State.internal_operation;
		}
	}

	/* The reactions of state operation. */
	private void reactInternal_operation() {
	}

	/* The reactions of state default. */
	private void reactEvent_default() {
		if ((sCInterface.e2) && isStateActive(State.internal_operation)) {
			nextStateIndex = 6;
			stateVector[6] = State.$NullState$;

			nextStateIndex = 6;
			stateVector[6] = State.event_else;
		}
	}

	/* The reactions of state else. */
	private void reactEvent_else() {
	}

	/* The reactions of state entry. */
	private void reactIn_entry() {
		if ((sCInterface.e1) && isStateActive(State.event_else)) {
			nextStateIndex = 7;
			stateVector[7] = State.$NullState$;

			nextStateIndex = 7;
			stateVector[7] = State.in_exit;
		}
	}

	/* The reactions of state exit. */
	private void reactIn_exit() {
	}

	/* The reactions of state always. */
	private void reactOut_always() {
		if ((sCInterface.e2) && isStateActive(State.in_exit)) {
			nextStateIndex = 8;
			stateVector[8] = State.$NullState$;

			nextStateIndex = 8;
			stateVector[8] = State.out_oncycle;
		}
	}

	/* The reactions of state oncycle. */
	private void reactOut_oncycle() {
	}

	/* The reactions of state raise. */
	private void reactVar_raise() {
		if ((sCInterface.e1) && isStateActive(State.out_oncycle)) {
			nextStateIndex = 9;
			stateVector[9] = State.$NullState$;

			nextStateIndex = 9;
			stateVector[9] = State.var_valueof;
		}
	}

	/* The reactions of state valueof. */
	private void reactVar_valueof() {
	}

	/* The reactions of state active. */
	private void reactReadonly_active() {
		if ((sCInterface.e2) && isStateActive(State.var_valueof)) {
			nextStateIndex = 10;
			stateVector[10] = State.$NullState$;

			nextStateIndex = 10;
			stateVector[10] = State.readonly_namespace;
		}
	}

	/* The reactions of state namespace. */
	private void reactReadonly_namespace() {
	}

	/* The reactions of state interface. */
	private void reactExternal_interface() {
		if ((sCInterface.e1) && isStateActive(State.readonly_namespace)) {
			nextStateIndex = 11;
			stateVector[11] = State.$NullState$;

			nextStateIndex = 11;
			stateVector[11] = State.external_internal;
		}
	}

	/* The reactions of state internal. */
	private void reactExternal_internal() {
	}

	/* The reactions of state event. */
	private void reactElse_event() {
		if ((sCInterface.e2) && isStateActive(State.external_internal)) {
			nextStateIndex = 12;
			stateVector[12] = State.$NullState$;

			nextStateIndex = 12;
			stateVector[12] = State.else_local;
		}
	}

	/* The reactions of state local. */
	private void reactElse_local() {
	}

	/* The reactions of state in. */
	private void reactEntry_in() {
		if ((sCInterface.e1) && isStateActive(State.else_local)) {
			nextStateIndex = 13;
			stateVector[13] = State.$NullState$;

			nextStateIndex = 13;
			stateVector[13] = State.entry_out;
		}
	}

	/* The reactions of state out. */
	private void reactEntry_out() {
	}

	/* The reactions of state var. */
	private void reactExit_var() {
		if ((sCInterface.e2) && isStateActive(State.entry_out)) {
			nextStateIndex = 14;
			stateVector[14] = State.$NullState$;

			nextStateIndex = 14;
			stateVector[14] = State.exit_readonly;
		}
	}

	/* The reactions of state readonly. */
	private void reactExit_readonly() {
	}

	/* The reactions of state external. */
	private void reactAlways_external() {
		if ((sCInterface.e1) && isStateActive(State.exit_readonly)) {
			nextStateIndex = 15;
			stateVector[15] = State.$NullState$;

			nextStateIndex = 15;
			stateVector[15] = State.always_operation;
		}
	}

	/* The reactions of state operation. */
	private void reactAlways_operation() {
	}

	/* The reactions of state default. */
	private void reactOncycle_default() {
		if ((sCInterface.e2) && isStateActive(State.always_operation)) {
			nextStateIndex = 16;
			stateVector[16] = State.$NullState$;

			nextStateIndex = 16;
			stateVector[16] = State.oncycle_else;
		}
	}

	/* The reactions of state else. */
	private void reactOncycle_else() {
	}

	/* The reactions of state entry. */
	private void reactRaise_entry() {
		if ((sCInterface.e1) && isStateActive(State.oncycle_else)) {
			nextStateIndex = 17;
			stateVector[17] = State.$NullState$;

			nextStateIndex = 17;
			stateVector[17] = State.raise_exit;
		}
	}

	/* The reactions of state exit. */
	private void reactRaise_exit() {
	}

	/* The reactions of state always. */
	private void reactValueof_always() {
		if ((sCInterface.e2) && isStateActive(State.raise_exit)) {
			nextStateIndex = 18;
			stateVector[18] = State.$NullState$;

			nextStateIndex = 18;
			stateVector[18] = State.valueof_oncycle;
		}
	}

	/* The reactions of state oncycle. */
	private void reactValueof_oncycle() {
	}

	/* The reactions of state raise. */
	private void reactActive_raise() {
		if ((sCInterface.e1) && isStateActive(State.valueof_oncycle)) {
			nextStateIndex = 19;
			stateVector[19] = State.$NullState$;

			nextStateIndex = 19;
			stateVector[19] = State.active_valueof;
		}
	}

	/* The reactions of state valueof. */
	private void reactActive_valueof() {
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case default_namespace :
					reactDefault_namespace();
					break;
				case operation_interface :
					reactOperation_interface();
					break;
				case operation_internal :
					reactOperation_internal();
					break;
				case namespace_event :
					reactNamespace_event();
					break;
				case namespace_local :
					reactNamespace_local();
					break;
				case local_in :
					reactLocal_in();
					break;
				case local_out :
					reactLocal_out();
					break;
				case interface_var :
					reactInterface_var();
					break;
				case interface_readonly :
					reactInterface_readonly();
					break;
				case internal_external :
					reactInternal_external();
					break;
				case internal_operation :
					reactInternal_operation();
					break;
				case event_default :
					reactEvent_default();
					break;
				case event_else :
					reactEvent_else();
					break;
				case in_entry :
					reactIn_entry();
					break;
				case in_exit :
					reactIn_exit();
					break;
				case out_always :
					reactOut_always();
					break;
				case out_oncycle :
					reactOut_oncycle();
					break;
				case var_raise :
					reactVar_raise();
					break;
				case var_valueof :
					reactVar_valueof();
					break;
				case readonly_active :
					reactReadonly_active();
					break;
				case readonly_namespace :
					reactReadonly_namespace();
					break;
				case external_interface :
					reactExternal_interface();
					break;
				case external_internal :
					reactExternal_internal();
					break;
				case else_event :
					reactElse_event();
					break;
				case else_local :
					reactElse_local();
					break;
				case entry_in :
					reactEntry_in();
					break;
				case entry_out :
					reactEntry_out();
					break;
				case exit_var :
					reactExit_var();
					break;
				case exit_readonly :
					reactExit_readonly();
					break;
				case always_external :
					reactAlways_external();
					break;
				case always_operation :
					reactAlways_operation();
					break;
				case oncycle_default :
					reactOncycle_default();
					break;
				case oncycle_else :
					reactOncycle_else();
					break;
				case raise_entry :
					reactRaise_entry();
					break;
				case raise_exit :
					reactRaise_exit();
					break;
				case valueof_always :
					reactValueof_always();
					break;
				case valueof_oncycle :
					reactValueof_oncycle();
					break;
				case active_raise :
					reactActive_raise();
					break;
				case active_valueof :
					reactActive_valueof();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
