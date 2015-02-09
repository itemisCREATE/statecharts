package org.yakindu.scr.stextkeywordsinstatesandregions;

public class STextKeywordsInStatesAndRegionsStatemachine
		implements
			ISTextKeywordsInStatesAndRegionsStatemachine {

	static {
	}

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

		enterSequence_default_default();

		enterSequence_operation_default();

		enterSequence_namespace_default();

		enterSequence_local_default();

		enterSequence_interface_default();

		enterSequence_internal_default();

		enterSequence_event_default();

		enterSequence_in_default();

		enterSequence_out_default();

		enterSequence_var_default();

		enterSequence_readonly_default();

		enterSequence_external_default();

		enterSequence_else_default();

		enterSequence_entry_default();

		enterSequence_exit_default();

		enterSequence_always_default();

		enterSequence_oncycle_default();

		enterSequence_raise_default();

		enterSequence_valueof_default();

		enterSequence_active_default();
	}

	public void exit() {
		exitSequence_default();

		exitSequence_operation();

		exitSequence_namespace();

		exitSequence_local();

		exitSequence_interface();

		exitSequence_internal();

		exitSequence_event();

		exitSequence_in();

		exitSequence_out();

		exitSequence_var();

		exitSequence_readonly();

		exitSequence_external();

		exitSequence_else();

		exitSequence_entry();

		exitSequence_exit();

		exitSequence_always();

		exitSequence_oncycle();

		exitSequence_raise();

		exitSequence_valueof();

		exitSequence_active();

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

	private boolean check_operation_interface_tr0() {
		return (sCInterface.e1) && isStateActive(State.default_namespace);
	}

	private boolean check_namespace_event_tr0() {
		return (sCInterface.e2) && isStateActive(State.operation_internal);
	}

	private boolean check_local_in_tr0() {
		return (sCInterface.e1) && isStateActive(State.namespace_local);
	}

	private boolean check_interface_var_tr0() {
		return (sCInterface.e2) && isStateActive(State.local_out);
	}

	private boolean check_internal_external_tr0() {
		return (sCInterface.e1) && isStateActive(State.interface_readonly);
	}

	private boolean check_event_default_tr0() {
		return (sCInterface.e2) && isStateActive(State.internal_operation);
	}

	private boolean check_in_entry_tr0() {
		return (sCInterface.e1) && isStateActive(State.event_else);
	}

	private boolean check_out_always_tr0() {
		return (sCInterface.e2) && isStateActive(State.in_exit);
	}

	private boolean check_var_raise_tr0() {
		return (sCInterface.e1) && isStateActive(State.out_oncycle);
	}

	private boolean check_readonly_active_tr0() {
		return (sCInterface.e2) && isStateActive(State.var_valueof);
	}

	private boolean check_external_interface_tr0() {
		return (sCInterface.e1) && isStateActive(State.readonly_namespace);
	}

	private boolean check_else_event_tr0() {
		return (sCInterface.e2) && isStateActive(State.external_internal);
	}

	private boolean check_entry_in_tr0() {
		return (sCInterface.e1) && isStateActive(State.else_local);
	}

	private boolean check_exit_var_tr0() {
		return (sCInterface.e2) && isStateActive(State.entry_out);
	}

	private boolean check_always_external_tr0() {
		return (sCInterface.e1) && isStateActive(State.exit_readonly);
	}

	private boolean check_oncycle_default_tr0() {
		return (sCInterface.e2) && isStateActive(State.always_operation);
	}

	private boolean check_raise_entry_tr0() {
		return (sCInterface.e1) && isStateActive(State.oncycle_else);
	}

	private boolean check_valueof_always_tr0() {
		return (sCInterface.e2) && isStateActive(State.raise_exit);
	}

	private boolean check_active_raise_tr0() {
		return (sCInterface.e1) && isStateActive(State.valueof_oncycle);
	}

	private void effect_operation_interface_tr0() {
		exitSequence_operation_interface();

		enterSequence_operation_internal_default();
	}

	private void effect_namespace_event_tr0() {
		exitSequence_namespace_event();

		enterSequence_namespace_local_default();
	}

	private void effect_local_in_tr0() {
		exitSequence_local_in();

		enterSequence_local_out_default();
	}

	private void effect_interface_var_tr0() {
		exitSequence_interface_var();

		enterSequence_interface_readonly_default();
	}

	private void effect_internal_external_tr0() {
		exitSequence_internal_external();

		enterSequence_internal_operation_default();
	}

	private void effect_event_default_tr0() {
		exitSequence_event_default();

		enterSequence_event_else_default();
	}

	private void effect_in_entry_tr0() {
		exitSequence_in_entry();

		enterSequence_in_exit_default();
	}

	private void effect_out_always_tr0() {
		exitSequence_out_always();

		enterSequence_out_oncycle_default();
	}

	private void effect_var_raise_tr0() {
		exitSequence_var_raise();

		enterSequence_var_valueof_default();
	}

	private void effect_readonly_active_tr0() {
		exitSequence_readonly_active();

		enterSequence_readonly_namespace_default();
	}

	private void effect_external_interface_tr0() {
		exitSequence_external_interface();

		enterSequence_external_internal_default();
	}

	private void effect_else_event_tr0() {
		exitSequence_else_event();

		enterSequence_else_local_default();
	}

	private void effect_entry_in_tr0() {
		exitSequence_entry_in();

		enterSequence_entry_out_default();
	}

	private void effect_exit_var_tr0() {
		exitSequence_exit_var();

		enterSequence_exit_readonly_default();
	}

	private void effect_always_external_tr0() {
		exitSequence_always_external();

		enterSequence_always_operation_default();
	}

	private void effect_oncycle_default_tr0() {
		exitSequence_oncycle_default();

		enterSequence_oncycle_else_default();
	}

	private void effect_raise_entry_tr0() {
		exitSequence_raise_entry();

		enterSequence_raise_exit_default();
	}

	private void effect_valueof_always_tr0() {
		exitSequence_valueof_always();

		enterSequence_valueof_oncycle_default();
	}

	private void effect_active_raise_tr0() {
		exitSequence_active_raise();

		enterSequence_active_valueof_default();
	}

	/* Entry action for statechart 'STextKeywordsInStatesAndRegions'. */
	private void entryAction() {
	}

	/* Exit action for state 'STextKeywordsInStatesAndRegions'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state namespace */
	private void enterSequence_default_namespace_default() {
		nextStateIndex = 0;
		stateVector[0] = State.default_namespace;
	}

	/* 'default' enter sequence for state interface */
	private void enterSequence_operation_interface_default() {
		nextStateIndex = 1;
		stateVector[1] = State.operation_interface;
	}

	/* 'default' enter sequence for state internal */
	private void enterSequence_operation_internal_default() {
		nextStateIndex = 1;
		stateVector[1] = State.operation_internal;
	}

	/* 'default' enter sequence for state event */
	private void enterSequence_namespace_event_default() {
		nextStateIndex = 2;
		stateVector[2] = State.namespace_event;
	}

	/* 'default' enter sequence for state local */
	private void enterSequence_namespace_local_default() {
		nextStateIndex = 2;
		stateVector[2] = State.namespace_local;
	}

	/* 'default' enter sequence for state in */
	private void enterSequence_local_in_default() {
		nextStateIndex = 3;
		stateVector[3] = State.local_in;
	}

	/* 'default' enter sequence for state out */
	private void enterSequence_local_out_default() {
		nextStateIndex = 3;
		stateVector[3] = State.local_out;
	}

	/* 'default' enter sequence for state var */
	private void enterSequence_interface_var_default() {
		nextStateIndex = 4;
		stateVector[4] = State.interface_var;
	}

	/* 'default' enter sequence for state readonly */
	private void enterSequence_interface_readonly_default() {
		nextStateIndex = 4;
		stateVector[4] = State.interface_readonly;
	}

	/* 'default' enter sequence for state external */
	private void enterSequence_internal_external_default() {
		nextStateIndex = 5;
		stateVector[5] = State.internal_external;
	}

	/* 'default' enter sequence for state operation */
	private void enterSequence_internal_operation_default() {
		nextStateIndex = 5;
		stateVector[5] = State.internal_operation;
	}

	/* 'default' enter sequence for state default */
	private void enterSequence_event_default_default() {
		nextStateIndex = 6;
		stateVector[6] = State.event_default;
	}

	/* 'default' enter sequence for state else */
	private void enterSequence_event_else_default() {
		nextStateIndex = 6;
		stateVector[6] = State.event_else;
	}

	/* 'default' enter sequence for state entry */
	private void enterSequence_in_entry_default() {
		nextStateIndex = 7;
		stateVector[7] = State.in_entry;
	}

	/* 'default' enter sequence for state exit */
	private void enterSequence_in_exit_default() {
		nextStateIndex = 7;
		stateVector[7] = State.in_exit;
	}

	/* 'default' enter sequence for state always */
	private void enterSequence_out_always_default() {
		nextStateIndex = 8;
		stateVector[8] = State.out_always;
	}

	/* 'default' enter sequence for state oncycle */
	private void enterSequence_out_oncycle_default() {
		nextStateIndex = 8;
		stateVector[8] = State.out_oncycle;
	}

	/* 'default' enter sequence for state raise */
	private void enterSequence_var_raise_default() {
		nextStateIndex = 9;
		stateVector[9] = State.var_raise;
	}

	/* 'default' enter sequence for state valueof */
	private void enterSequence_var_valueof_default() {
		nextStateIndex = 9;
		stateVector[9] = State.var_valueof;
	}

	/* 'default' enter sequence for state active */
	private void enterSequence_readonly_active_default() {
		nextStateIndex = 10;
		stateVector[10] = State.readonly_active;
	}

	/* 'default' enter sequence for state namespace */
	private void enterSequence_readonly_namespace_default() {
		nextStateIndex = 10;
		stateVector[10] = State.readonly_namespace;
	}

	/* 'default' enter sequence for state interface */
	private void enterSequence_external_interface_default() {
		nextStateIndex = 11;
		stateVector[11] = State.external_interface;
	}

	/* 'default' enter sequence for state internal */
	private void enterSequence_external_internal_default() {
		nextStateIndex = 11;
		stateVector[11] = State.external_internal;
	}

	/* 'default' enter sequence for state event */
	private void enterSequence_else_event_default() {
		nextStateIndex = 12;
		stateVector[12] = State.else_event;
	}

	/* 'default' enter sequence for state local */
	private void enterSequence_else_local_default() {
		nextStateIndex = 12;
		stateVector[12] = State.else_local;
	}

	/* 'default' enter sequence for state in */
	private void enterSequence_entry_in_default() {
		nextStateIndex = 13;
		stateVector[13] = State.entry_in;
	}

	/* 'default' enter sequence for state out */
	private void enterSequence_entry_out_default() {
		nextStateIndex = 13;
		stateVector[13] = State.entry_out;
	}

	/* 'default' enter sequence for state var */
	private void enterSequence_exit_var_default() {
		nextStateIndex = 14;
		stateVector[14] = State.exit_var;
	}

	/* 'default' enter sequence for state readonly */
	private void enterSequence_exit_readonly_default() {
		nextStateIndex = 14;
		stateVector[14] = State.exit_readonly;
	}

	/* 'default' enter sequence for state external */
	private void enterSequence_always_external_default() {
		nextStateIndex = 15;
		stateVector[15] = State.always_external;
	}

	/* 'default' enter sequence for state operation */
	private void enterSequence_always_operation_default() {
		nextStateIndex = 15;
		stateVector[15] = State.always_operation;
	}

	/* 'default' enter sequence for state default */
	private void enterSequence_oncycle_default_default() {
		nextStateIndex = 16;
		stateVector[16] = State.oncycle_default;
	}

	/* 'default' enter sequence for state else */
	private void enterSequence_oncycle_else_default() {
		nextStateIndex = 16;
		stateVector[16] = State.oncycle_else;
	}

	/* 'default' enter sequence for state entry */
	private void enterSequence_raise_entry_default() {
		nextStateIndex = 17;
		stateVector[17] = State.raise_entry;
	}

	/* 'default' enter sequence for state exit */
	private void enterSequence_raise_exit_default() {
		nextStateIndex = 17;
		stateVector[17] = State.raise_exit;
	}

	/* 'default' enter sequence for state always */
	private void enterSequence_valueof_always_default() {
		nextStateIndex = 18;
		stateVector[18] = State.valueof_always;
	}

	/* 'default' enter sequence for state oncycle */
	private void enterSequence_valueof_oncycle_default() {
		nextStateIndex = 18;
		stateVector[18] = State.valueof_oncycle;
	}

	/* 'default' enter sequence for state raise */
	private void enterSequence_active_raise_default() {
		nextStateIndex = 19;
		stateVector[19] = State.active_raise;
	}

	/* 'default' enter sequence for state valueof */
	private void enterSequence_active_valueof_default() {
		nextStateIndex = 19;
		stateVector[19] = State.active_valueof;
	}

	/* 'default' enter sequence for region default */
	private void enterSequence_default_default() {
		react_default__entry_Default();
	}

	/* 'default' enter sequence for region operation */
	private void enterSequence_operation_default() {
		react_operation__entry_Default();
	}

	/* 'default' enter sequence for region namespace */
	private void enterSequence_namespace_default() {
		react_namespace__entry_Default();
	}

	/* 'default' enter sequence for region local */
	private void enterSequence_local_default() {
		react_local__entry_Default();
	}

	/* 'default' enter sequence for region interface */
	private void enterSequence_interface_default() {
		react_interface__entry_Default();
	}

	/* 'default' enter sequence for region internal */
	private void enterSequence_internal_default() {
		react_internal__entry_Default();
	}

	/* 'default' enter sequence for region event */
	private void enterSequence_event_default() {
		react_event__entry_Default();
	}

	/* 'default' enter sequence for region in */
	private void enterSequence_in_default() {
		react_in__entry_Default();
	}

	/* 'default' enter sequence for region out */
	private void enterSequence_out_default() {
		react_out__entry_Default();
	}

	/* 'default' enter sequence for region var */
	private void enterSequence_var_default() {
		react_var__entry_Default();
	}

	/* 'default' enter sequence for region readonly */
	private void enterSequence_readonly_default() {
		react_readonly__entry_Default();
	}

	/* 'default' enter sequence for region external */
	private void enterSequence_external_default() {
		react_external__entry_Default();
	}

	/* 'default' enter sequence for region else */
	private void enterSequence_else_default() {
		react_else__entry_Default();
	}

	/* 'default' enter sequence for region entry */
	private void enterSequence_entry_default() {
		react_entry__entry_Default();
	}

	/* 'default' enter sequence for region exit */
	private void enterSequence_exit_default() {
		react_exit__entry_Default();
	}

	/* 'default' enter sequence for region always */
	private void enterSequence_always_default() {
		react_always__entry_Default();
	}

	/* 'default' enter sequence for region oncycle */
	private void enterSequence_oncycle_default() {
		react_oncycle__entry_Default();
	}

	/* 'default' enter sequence for region raise */
	private void enterSequence_raise_default() {
		react_raise__entry_Default();
	}

	/* 'default' enter sequence for region valueof */
	private void enterSequence_valueof_default() {
		react_valueof__entry_Default();
	}

	/* 'default' enter sequence for region active */
	private void enterSequence_active_default() {
		react_active__entry_Default();
	}

	/* Default exit sequence for state namespace */
	private void exitSequence_default_namespace() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state interface */
	private void exitSequence_operation_interface() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state internal */
	private void exitSequence_operation_internal() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state event */
	private void exitSequence_namespace_event() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for state local */
	private void exitSequence_namespace_local() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for state in */
	private void exitSequence_local_in() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}

	/* Default exit sequence for state out */
	private void exitSequence_local_out() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}

	/* Default exit sequence for state var */
	private void exitSequence_interface_var() {
		nextStateIndex = 4;
		stateVector[4] = State.$NullState$;
	}

	/* Default exit sequence for state readonly */
	private void exitSequence_interface_readonly() {
		nextStateIndex = 4;
		stateVector[4] = State.$NullState$;
	}

	/* Default exit sequence for state external */
	private void exitSequence_internal_external() {
		nextStateIndex = 5;
		stateVector[5] = State.$NullState$;
	}

	/* Default exit sequence for state operation */
	private void exitSequence_internal_operation() {
		nextStateIndex = 5;
		stateVector[5] = State.$NullState$;
	}

	/* Default exit sequence for state default */
	private void exitSequence_event_default() {
		nextStateIndex = 6;
		stateVector[6] = State.$NullState$;
	}

	/* Default exit sequence for state else */
	private void exitSequence_event_else() {
		nextStateIndex = 6;
		stateVector[6] = State.$NullState$;
	}

	/* Default exit sequence for state entry */
	private void exitSequence_in_entry() {
		nextStateIndex = 7;
		stateVector[7] = State.$NullState$;
	}

	/* Default exit sequence for state exit */
	private void exitSequence_in_exit() {
		nextStateIndex = 7;
		stateVector[7] = State.$NullState$;
	}

	/* Default exit sequence for state always */
	private void exitSequence_out_always() {
		nextStateIndex = 8;
		stateVector[8] = State.$NullState$;
	}

	/* Default exit sequence for state oncycle */
	private void exitSequence_out_oncycle() {
		nextStateIndex = 8;
		stateVector[8] = State.$NullState$;
	}

	/* Default exit sequence for state raise */
	private void exitSequence_var_raise() {
		nextStateIndex = 9;
		stateVector[9] = State.$NullState$;
	}

	/* Default exit sequence for state valueof */
	private void exitSequence_var_valueof() {
		nextStateIndex = 9;
		stateVector[9] = State.$NullState$;
	}

	/* Default exit sequence for state active */
	private void exitSequence_readonly_active() {
		nextStateIndex = 10;
		stateVector[10] = State.$NullState$;
	}

	/* Default exit sequence for state namespace */
	private void exitSequence_readonly_namespace() {
		nextStateIndex = 10;
		stateVector[10] = State.$NullState$;
	}

	/* Default exit sequence for state interface */
	private void exitSequence_external_interface() {
		nextStateIndex = 11;
		stateVector[11] = State.$NullState$;
	}

	/* Default exit sequence for state internal */
	private void exitSequence_external_internal() {
		nextStateIndex = 11;
		stateVector[11] = State.$NullState$;
	}

	/* Default exit sequence for state event */
	private void exitSequence_else_event() {
		nextStateIndex = 12;
		stateVector[12] = State.$NullState$;
	}

	/* Default exit sequence for state local */
	private void exitSequence_else_local() {
		nextStateIndex = 12;
		stateVector[12] = State.$NullState$;
	}

	/* Default exit sequence for state in */
	private void exitSequence_entry_in() {
		nextStateIndex = 13;
		stateVector[13] = State.$NullState$;
	}

	/* Default exit sequence for state out */
	private void exitSequence_entry_out() {
		nextStateIndex = 13;
		stateVector[13] = State.$NullState$;
	}

	/* Default exit sequence for state var */
	private void exitSequence_exit_var() {
		nextStateIndex = 14;
		stateVector[14] = State.$NullState$;
	}

	/* Default exit sequence for state readonly */
	private void exitSequence_exit_readonly() {
		nextStateIndex = 14;
		stateVector[14] = State.$NullState$;
	}

	/* Default exit sequence for state external */
	private void exitSequence_always_external() {
		nextStateIndex = 15;
		stateVector[15] = State.$NullState$;
	}

	/* Default exit sequence for state operation */
	private void exitSequence_always_operation() {
		nextStateIndex = 15;
		stateVector[15] = State.$NullState$;
	}

	/* Default exit sequence for state default */
	private void exitSequence_oncycle_default() {
		nextStateIndex = 16;
		stateVector[16] = State.$NullState$;
	}

	/* Default exit sequence for state else */
	private void exitSequence_oncycle_else() {
		nextStateIndex = 16;
		stateVector[16] = State.$NullState$;
	}

	/* Default exit sequence for state entry */
	private void exitSequence_raise_entry() {
		nextStateIndex = 17;
		stateVector[17] = State.$NullState$;
	}

	/* Default exit sequence for state exit */
	private void exitSequence_raise_exit() {
		nextStateIndex = 17;
		stateVector[17] = State.$NullState$;
	}

	/* Default exit sequence for state always */
	private void exitSequence_valueof_always() {
		nextStateIndex = 18;
		stateVector[18] = State.$NullState$;
	}

	/* Default exit sequence for state oncycle */
	private void exitSequence_valueof_oncycle() {
		nextStateIndex = 18;
		stateVector[18] = State.$NullState$;
	}

	/* Default exit sequence for state raise */
	private void exitSequence_active_raise() {
		nextStateIndex = 19;
		stateVector[19] = State.$NullState$;
	}

	/* Default exit sequence for state valueof */
	private void exitSequence_active_valueof() {
		nextStateIndex = 19;
		stateVector[19] = State.$NullState$;
	}

	/* Default exit sequence for region default */
	private void exitSequence_default() {
		switch (stateVector[0]) {
			case default_namespace :
				exitSequence_default_namespace();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region operation */
	private void exitSequence_operation() {
		switch (stateVector[1]) {
			case operation_interface :
				exitSequence_operation_interface();
				break;

			case operation_internal :
				exitSequence_operation_internal();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region namespace */
	private void exitSequence_namespace() {
		switch (stateVector[2]) {
			case namespace_event :
				exitSequence_namespace_event();
				break;

			case namespace_local :
				exitSequence_namespace_local();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region local */
	private void exitSequence_local() {
		switch (stateVector[3]) {
			case local_in :
				exitSequence_local_in();
				break;

			case local_out :
				exitSequence_local_out();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region interface */
	private void exitSequence_interface() {
		switch (stateVector[4]) {
			case interface_var :
				exitSequence_interface_var();
				break;

			case interface_readonly :
				exitSequence_interface_readonly();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region internal */
	private void exitSequence_internal() {
		switch (stateVector[5]) {
			case internal_external :
				exitSequence_internal_external();
				break;

			case internal_operation :
				exitSequence_internal_operation();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region event */
	private void exitSequence_event() {
		switch (stateVector[6]) {
			case event_default :
				exitSequence_event_default();
				break;

			case event_else :
				exitSequence_event_else();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region in */
	private void exitSequence_in() {
		switch (stateVector[7]) {
			case in_entry :
				exitSequence_in_entry();
				break;

			case in_exit :
				exitSequence_in_exit();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region out */
	private void exitSequence_out() {
		switch (stateVector[8]) {
			case out_always :
				exitSequence_out_always();
				break;

			case out_oncycle :
				exitSequence_out_oncycle();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region var */
	private void exitSequence_var() {
		switch (stateVector[9]) {
			case var_raise :
				exitSequence_var_raise();
				break;

			case var_valueof :
				exitSequence_var_valueof();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region readonly */
	private void exitSequence_readonly() {
		switch (stateVector[10]) {
			case readonly_active :
				exitSequence_readonly_active();
				break;

			case readonly_namespace :
				exitSequence_readonly_namespace();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region external */
	private void exitSequence_external() {
		switch (stateVector[11]) {
			case external_interface :
				exitSequence_external_interface();
				break;

			case external_internal :
				exitSequence_external_internal();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region else */
	private void exitSequence_else() {
		switch (stateVector[12]) {
			case else_event :
				exitSequence_else_event();
				break;

			case else_local :
				exitSequence_else_local();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region entry */
	private void exitSequence_entry() {
		switch (stateVector[13]) {
			case entry_in :
				exitSequence_entry_in();
				break;

			case entry_out :
				exitSequence_entry_out();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region exit */
	private void exitSequence_exit() {
		switch (stateVector[14]) {
			case exit_var :
				exitSequence_exit_var();
				break;

			case exit_readonly :
				exitSequence_exit_readonly();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region always */
	private void exitSequence_always() {
		switch (stateVector[15]) {
			case always_external :
				exitSequence_always_external();
				break;

			case always_operation :
				exitSequence_always_operation();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region oncycle */
	private void exitSequence_oncycle() {
		switch (stateVector[16]) {
			case oncycle_default :
				exitSequence_oncycle_default();
				break;

			case oncycle_else :
				exitSequence_oncycle_else();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region raise */
	private void exitSequence_raise() {
		switch (stateVector[17]) {
			case raise_entry :
				exitSequence_raise_entry();
				break;

			case raise_exit :
				exitSequence_raise_exit();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region valueof */
	private void exitSequence_valueof() {
		switch (stateVector[18]) {
			case valueof_always :
				exitSequence_valueof_always();
				break;

			case valueof_oncycle :
				exitSequence_valueof_oncycle();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region active */
	private void exitSequence_active() {
		switch (stateVector[19]) {
			case active_raise :
				exitSequence_active_raise();
				break;

			case active_valueof :
				exitSequence_active_valueof();
				break;

			default :
				break;
		}
	}

	/* The reactions of state namespace. */
	private void react_default_namespace() {
	}

	/* The reactions of state interface. */
	private void react_operation_interface() {
		if (check_operation_interface_tr0()) {
			effect_operation_interface_tr0();
		}
	}

	/* The reactions of state internal. */
	private void react_operation_internal() {
	}

	/* The reactions of state event. */
	private void react_namespace_event() {
		if (check_namespace_event_tr0()) {
			effect_namespace_event_tr0();
		}
	}

	/* The reactions of state local. */
	private void react_namespace_local() {
	}

	/* The reactions of state in. */
	private void react_local_in() {
		if (check_local_in_tr0()) {
			effect_local_in_tr0();
		}
	}

	/* The reactions of state out. */
	private void react_local_out() {
	}

	/* The reactions of state var. */
	private void react_interface_var() {
		if (check_interface_var_tr0()) {
			effect_interface_var_tr0();
		}
	}

	/* The reactions of state readonly. */
	private void react_interface_readonly() {
	}

	/* The reactions of state external. */
	private void react_internal_external() {
		if (check_internal_external_tr0()) {
			effect_internal_external_tr0();
		}
	}

	/* The reactions of state operation. */
	private void react_internal_operation() {
	}

	/* The reactions of state default. */
	private void react_event_default() {
		if (check_event_default_tr0()) {
			effect_event_default_tr0();
		}
	}

	/* The reactions of state else. */
	private void react_event_else() {
	}

	/* The reactions of state entry. */
	private void react_in_entry() {
		if (check_in_entry_tr0()) {
			effect_in_entry_tr0();
		}
	}

	/* The reactions of state exit. */
	private void react_in_exit() {
	}

	/* The reactions of state always. */
	private void react_out_always() {
		if (check_out_always_tr0()) {
			effect_out_always_tr0();
		}
	}

	/* The reactions of state oncycle. */
	private void react_out_oncycle() {
	}

	/* The reactions of state raise. */
	private void react_var_raise() {
		if (check_var_raise_tr0()) {
			effect_var_raise_tr0();
		}
	}

	/* The reactions of state valueof. */
	private void react_var_valueof() {
	}

	/* The reactions of state active. */
	private void react_readonly_active() {
		if (check_readonly_active_tr0()) {
			effect_readonly_active_tr0();
		}
	}

	/* The reactions of state namespace. */
	private void react_readonly_namespace() {
	}

	/* The reactions of state interface. */
	private void react_external_interface() {
		if (check_external_interface_tr0()) {
			effect_external_interface_tr0();
		}
	}

	/* The reactions of state internal. */
	private void react_external_internal() {
	}

	/* The reactions of state event. */
	private void react_else_event() {
		if (check_else_event_tr0()) {
			effect_else_event_tr0();
		}
	}

	/* The reactions of state local. */
	private void react_else_local() {
	}

	/* The reactions of state in. */
	private void react_entry_in() {
		if (check_entry_in_tr0()) {
			effect_entry_in_tr0();
		}
	}

	/* The reactions of state out. */
	private void react_entry_out() {
	}

	/* The reactions of state var. */
	private void react_exit_var() {
		if (check_exit_var_tr0()) {
			effect_exit_var_tr0();
		}
	}

	/* The reactions of state readonly. */
	private void react_exit_readonly() {
	}

	/* The reactions of state external. */
	private void react_always_external() {
		if (check_always_external_tr0()) {
			effect_always_external_tr0();
		}
	}

	/* The reactions of state operation. */
	private void react_always_operation() {
	}

	/* The reactions of state default. */
	private void react_oncycle_default() {
		if (check_oncycle_default_tr0()) {
			effect_oncycle_default_tr0();
		}
	}

	/* The reactions of state else. */
	private void react_oncycle_else() {
	}

	/* The reactions of state entry. */
	private void react_raise_entry() {
		if (check_raise_entry_tr0()) {
			effect_raise_entry_tr0();
		}
	}

	/* The reactions of state exit. */
	private void react_raise_exit() {
	}

	/* The reactions of state always. */
	private void react_valueof_always() {
		if (check_valueof_always_tr0()) {
			effect_valueof_always_tr0();
		}
	}

	/* The reactions of state oncycle. */
	private void react_valueof_oncycle() {
	}

	/* The reactions of state raise. */
	private void react_active_raise() {
		if (check_active_raise_tr0()) {
			effect_active_raise_tr0();
		}
	}

	/* The reactions of state valueof. */
	private void react_active_valueof() {
	}

	/* Default react sequence for initial entry  */
	private void react_default__entry_Default() {
		enterSequence_default_namespace_default();
	}

	/* Default react sequence for initial entry  */
	private void react_operation__entry_Default() {
		enterSequence_operation_interface_default();
	}

	/* Default react sequence for initial entry  */
	private void react_namespace__entry_Default() {
		enterSequence_namespace_event_default();
	}

	/* Default react sequence for initial entry  */
	private void react_local__entry_Default() {
		enterSequence_local_in_default();
	}

	/* Default react sequence for initial entry  */
	private void react_interface__entry_Default() {
		enterSequence_interface_var_default();
	}

	/* Default react sequence for initial entry  */
	private void react_internal__entry_Default() {
		enterSequence_internal_external_default();
	}

	/* Default react sequence for initial entry  */
	private void react_event__entry_Default() {
		enterSequence_event_default_default();
	}

	/* Default react sequence for initial entry  */
	private void react_in__entry_Default() {
		enterSequence_in_entry_default();
	}

	/* Default react sequence for initial entry  */
	private void react_out__entry_Default() {
		enterSequence_out_always_default();
	}

	/* Default react sequence for initial entry  */
	private void react_var__entry_Default() {
		enterSequence_var_raise_default();
	}

	/* Default react sequence for initial entry  */
	private void react_readonly__entry_Default() {
		enterSequence_readonly_active_default();
	}

	/* Default react sequence for initial entry  */
	private void react_external__entry_Default() {
		enterSequence_external_interface_default();
	}

	/* Default react sequence for initial entry  */
	private void react_else__entry_Default() {
		enterSequence_else_event_default();
	}

	/* Default react sequence for initial entry  */
	private void react_entry__entry_Default() {
		enterSequence_entry_in_default();
	}

	/* Default react sequence for initial entry  */
	private void react_exit__entry_Default() {
		enterSequence_exit_var_default();
	}

	/* Default react sequence for initial entry  */
	private void react_always__entry_Default() {
		enterSequence_always_external_default();
	}

	/* Default react sequence for initial entry  */
	private void react_oncycle__entry_Default() {
		enterSequence_oncycle_default_default();
	}

	/* Default react sequence for initial entry  */
	private void react_raise__entry_Default() {
		enterSequence_raise_entry_default();
	}

	/* Default react sequence for initial entry  */
	private void react_valueof__entry_Default() {
		enterSequence_valueof_always_default();
	}

	/* Default react sequence for initial entry  */
	private void react_active__entry_Default() {
		enterSequence_active_raise_default();
	}

	public void runCycle() {

		clearOutEvents();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {

			switch (stateVector[nextStateIndex]) {
				case default_namespace :
					react_default_namespace();
					break;
				case operation_interface :
					react_operation_interface();
					break;
				case operation_internal :
					react_operation_internal();
					break;
				case namespace_event :
					react_namespace_event();
					break;
				case namespace_local :
					react_namespace_local();
					break;
				case local_in :
					react_local_in();
					break;
				case local_out :
					react_local_out();
					break;
				case interface_var :
					react_interface_var();
					break;
				case interface_readonly :
					react_interface_readonly();
					break;
				case internal_external :
					react_internal_external();
					break;
				case internal_operation :
					react_internal_operation();
					break;
				case event_default :
					react_event_default();
					break;
				case event_else :
					react_event_else();
					break;
				case in_entry :
					react_in_entry();
					break;
				case in_exit :
					react_in_exit();
					break;
				case out_always :
					react_out_always();
					break;
				case out_oncycle :
					react_out_oncycle();
					break;
				case var_raise :
					react_var_raise();
					break;
				case var_valueof :
					react_var_valueof();
					break;
				case readonly_active :
					react_readonly_active();
					break;
				case readonly_namespace :
					react_readonly_namespace();
					break;
				case external_interface :
					react_external_interface();
					break;
				case external_internal :
					react_external_internal();
					break;
				case else_event :
					react_else_event();
					break;
				case else_local :
					react_else_local();
					break;
				case entry_in :
					react_entry_in();
					break;
				case entry_out :
					react_entry_out();
					break;
				case exit_var :
					react_exit_var();
					break;
				case exit_readonly :
					react_exit_readonly();
					break;
				case always_external :
					react_always_external();
					break;
				case always_operation :
					react_always_operation();
					break;
				case oncycle_default :
					react_oncycle_default();
					break;
				case oncycle_else :
					react_oncycle_else();
					break;
				case raise_entry :
					react_raise_entry();
					break;
				case raise_exit :
					react_raise_exit();
					break;
				case valueof_always :
					react_valueof_always();
					break;
				case valueof_oncycle :
					react_valueof_oncycle();
					break;
				case active_raise :
					react_active_raise();
					break;
				case active_valueof :
					react_active_valueof();
					break;
				default :
					// $NullState$
			}
		}

		clearEvents();
	}
}
