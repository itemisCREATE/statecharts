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

		enterSequenceDefault();

		enterSequenceOperation();

		enterSequenceNamespace();

		enterSequenceLocal();

		enterSequenceInterface();

		enterSequenceInternal();

		enterSequenceEvent();

		enterSequenceIn();

		enterSequenceOut();

		enterSequenceVar();

		enterSequenceReadonly();

		enterSequenceExternal();

		enterSequenceElse();

		enterSequenceEntry();

		enterSequenceExit();

		enterSequenceAlways();

		enterSequenceOncycle();

		enterSequenceRaise();

		enterSequenceValueof();

		enterSequenceActive();
	}

	public void exit() {
		exitSequenceDefault();

		exitSequenceOperation();

		exitSequenceNamespace();

		exitSequenceLocal();

		exitSequenceInterface();

		exitSequenceInternal();

		exitSequenceEvent();

		exitSequenceIn();

		exitSequenceOut();

		exitSequenceVar();

		exitSequenceReadonly();

		exitSequenceExternal();

		exitSequenceElse();

		exitSequenceEntry();

		exitSequenceExit();

		exitSequenceAlways();

		exitSequenceOncycle();

		exitSequenceRaise();

		exitSequenceValueof();

		exitSequenceActive();

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

	private boolean checkOperation_interfaceTr0() {
		return (sCInterface.e1) && isStateActive(State.default_namespace);
	}

	private boolean checkNamespace_eventTr0() {
		return (sCInterface.e2) && isStateActive(State.operation_internal);
	}

	private boolean checkLocal_inTr0() {
		return (sCInterface.e1) && isStateActive(State.namespace_local);
	}

	private boolean checkInterface_varTr0() {
		return (sCInterface.e2) && isStateActive(State.local_out);
	}

	private boolean checkInternal_externalTr0() {
		return (sCInterface.e1) && isStateActive(State.interface_readonly);
	}

	private boolean checkEvent_defaultTr0() {
		return (sCInterface.e2) && isStateActive(State.internal_operation);
	}

	private boolean checkIn_entryTr0() {
		return (sCInterface.e1) && isStateActive(State.event_else);
	}

	private boolean checkOut_alwaysTr0() {
		return (sCInterface.e2) && isStateActive(State.in_exit);
	}

	private boolean checkVar_raiseTr0() {
		return (sCInterface.e1) && isStateActive(State.out_oncycle);
	}

	private boolean checkReadonly_activeTr0() {
		return (sCInterface.e2) && isStateActive(State.var_valueof);
	}

	private boolean checkExternal_interfaceTr0() {
		return (sCInterface.e1) && isStateActive(State.readonly_namespace);
	}

	private boolean checkElse_eventTr0() {
		return (sCInterface.e2) && isStateActive(State.external_internal);
	}

	private boolean checkEntry_inTr0() {
		return (sCInterface.e1) && isStateActive(State.else_local);
	}

	private boolean checkExit_varTr0() {
		return (sCInterface.e2) && isStateActive(State.entry_out);
	}

	private boolean checkAlways_externalTr0() {
		return (sCInterface.e1) && isStateActive(State.exit_readonly);
	}

	private boolean checkOncycle_defaultTr0() {
		return (sCInterface.e2) && isStateActive(State.always_operation);
	}

	private boolean checkRaise_entryTr0() {
		return (sCInterface.e1) && isStateActive(State.oncycle_else);
	}

	private boolean checkValueof_alwaysTr0() {
		return (sCInterface.e2) && isStateActive(State.raise_exit);
	}

	private boolean checkActive_raiseTr0() {
		return (sCInterface.e1) && isStateActive(State.valueof_oncycle);
	}

	private void effectOperation_interfaceTr0() {
		exitSequenceOperation_interface();

		enterSequenceOperation_internal();
	}

	private void effectNamespace_eventTr0() {
		exitSequenceNamespace_event();

		enterSequenceNamespace_local();
	}

	private void effectLocal_inTr0() {
		exitSequenceLocal_in();

		enterSequenceLocal_out();
	}

	private void effectInterface_varTr0() {
		exitSequenceInterface_var();

		enterSequenceInterface_readonly();
	}

	private void effectInternal_externalTr0() {
		exitSequenceInternal_external();

		enterSequenceInternal_operation();
	}

	private void effectEvent_defaultTr0() {
		exitSequenceEvent_default();

		enterSequenceEvent_else();
	}

	private void effectIn_entryTr0() {
		exitSequenceIn_entry();

		enterSequenceIn_exit();
	}

	private void effectOut_alwaysTr0() {
		exitSequenceOut_always();

		enterSequenceOut_oncycle();
	}

	private void effectVar_raiseTr0() {
		exitSequenceVar_raise();

		enterSequenceVar_valueof();
	}

	private void effectReadonly_activeTr0() {
		exitSequenceReadonly_active();

		enterSequenceReadonly_namespace();
	}

	private void effectExternal_interfaceTr0() {
		exitSequenceExternal_interface();

		enterSequenceExternal_internal();
	}

	private void effectElse_eventTr0() {
		exitSequenceElse_event();

		enterSequenceElse_local();
	}

	private void effectEntry_inTr0() {
		exitSequenceEntry_in();

		enterSequenceEntry_out();
	}

	private void effectExit_varTr0() {
		exitSequenceExit_var();

		enterSequenceExit_readonly();
	}

	private void effectAlways_externalTr0() {
		exitSequenceAlways_external();

		enterSequenceAlways_operation();
	}

	private void effectOncycle_defaultTr0() {
		exitSequenceOncycle_default();

		enterSequenceOncycle_else();
	}

	private void effectRaise_entryTr0() {
		exitSequenceRaise_entry();

		enterSequenceRaise_exit();
	}

	private void effectValueof_alwaysTr0() {
		exitSequenceValueof_always();

		enterSequenceValueof_oncycle();
	}

	private void effectActive_raiseTr0() {
		exitSequenceActive_raise();

		enterSequenceActive_valueof();
	}

	/* Entry action for statechart 'STextKeywordsInStatesAndRegions'. */
	private void entryAction() {
	}

	/* Exit action for state 'STextKeywordsInStatesAndRegions'. */
	private void exitAction() {
	}

	/* 'default' enter sequence for state namespace */
	private void enterSequenceDefault_namespace() {
		nextStateIndex = 0;
		stateVector[0] = State.default_namespace;
	}

	/* 'default' enter sequence for state interface */
	private void enterSequenceOperation_interface() {
		nextStateIndex = 1;
		stateVector[1] = State.operation_interface;
	}

	/* 'default' enter sequence for state internal */
	private void enterSequenceOperation_internal() {
		nextStateIndex = 1;
		stateVector[1] = State.operation_internal;
	}

	/* 'default' enter sequence for state event */
	private void enterSequenceNamespace_event() {
		nextStateIndex = 2;
		stateVector[2] = State.namespace_event;
	}

	/* 'default' enter sequence for state local */
	private void enterSequenceNamespace_local() {
		nextStateIndex = 2;
		stateVector[2] = State.namespace_local;
	}

	/* 'default' enter sequence for state in */
	private void enterSequenceLocal_in() {
		nextStateIndex = 3;
		stateVector[3] = State.local_in;
	}

	/* 'default' enter sequence for state out */
	private void enterSequenceLocal_out() {
		nextStateIndex = 3;
		stateVector[3] = State.local_out;
	}

	/* 'default' enter sequence for state var */
	private void enterSequenceInterface_var() {
		nextStateIndex = 4;
		stateVector[4] = State.interface_var;
	}

	/* 'default' enter sequence for state readonly */
	private void enterSequenceInterface_readonly() {
		nextStateIndex = 4;
		stateVector[4] = State.interface_readonly;
	}

	/* 'default' enter sequence for state external */
	private void enterSequenceInternal_external() {
		nextStateIndex = 5;
		stateVector[5] = State.internal_external;
	}

	/* 'default' enter sequence for state operation */
	private void enterSequenceInternal_operation() {
		nextStateIndex = 5;
		stateVector[5] = State.internal_operation;
	}

	/* 'default' enter sequence for state default */
	private void enterSequenceEvent_default() {
		nextStateIndex = 6;
		stateVector[6] = State.event_default;
	}

	/* 'default' enter sequence for state else */
	private void enterSequenceEvent_else() {
		nextStateIndex = 6;
		stateVector[6] = State.event_else;
	}

	/* 'default' enter sequence for state entry */
	private void enterSequenceIn_entry() {
		nextStateIndex = 7;
		stateVector[7] = State.in_entry;
	}

	/* 'default' enter sequence for state exit */
	private void enterSequenceIn_exit() {
		nextStateIndex = 7;
		stateVector[7] = State.in_exit;
	}

	/* 'default' enter sequence for state always */
	private void enterSequenceOut_always() {
		nextStateIndex = 8;
		stateVector[8] = State.out_always;
	}

	/* 'default' enter sequence for state oncycle */
	private void enterSequenceOut_oncycle() {
		nextStateIndex = 8;
		stateVector[8] = State.out_oncycle;
	}

	/* 'default' enter sequence for state raise */
	private void enterSequenceVar_raise() {
		nextStateIndex = 9;
		stateVector[9] = State.var_raise;
	}

	/* 'default' enter sequence for state valueof */
	private void enterSequenceVar_valueof() {
		nextStateIndex = 9;
		stateVector[9] = State.var_valueof;
	}

	/* 'default' enter sequence for state active */
	private void enterSequenceReadonly_active() {
		nextStateIndex = 10;
		stateVector[10] = State.readonly_active;
	}

	/* 'default' enter sequence for state namespace */
	private void enterSequenceReadonly_namespace() {
		nextStateIndex = 10;
		stateVector[10] = State.readonly_namespace;
	}

	/* 'default' enter sequence for state interface */
	private void enterSequenceExternal_interface() {
		nextStateIndex = 11;
		stateVector[11] = State.external_interface;
	}

	/* 'default' enter sequence for state internal */
	private void enterSequenceExternal_internal() {
		nextStateIndex = 11;
		stateVector[11] = State.external_internal;
	}

	/* 'default' enter sequence for state event */
	private void enterSequenceElse_event() {
		nextStateIndex = 12;
		stateVector[12] = State.else_event;
	}

	/* 'default' enter sequence for state local */
	private void enterSequenceElse_local() {
		nextStateIndex = 12;
		stateVector[12] = State.else_local;
	}

	/* 'default' enter sequence for state in */
	private void enterSequenceEntry_in() {
		nextStateIndex = 13;
		stateVector[13] = State.entry_in;
	}

	/* 'default' enter sequence for state out */
	private void enterSequenceEntry_out() {
		nextStateIndex = 13;
		stateVector[13] = State.entry_out;
	}

	/* 'default' enter sequence for state var */
	private void enterSequenceExit_var() {
		nextStateIndex = 14;
		stateVector[14] = State.exit_var;
	}

	/* 'default' enter sequence for state readonly */
	private void enterSequenceExit_readonly() {
		nextStateIndex = 14;
		stateVector[14] = State.exit_readonly;
	}

	/* 'default' enter sequence for state external */
	private void enterSequenceAlways_external() {
		nextStateIndex = 15;
		stateVector[15] = State.always_external;
	}

	/* 'default' enter sequence for state operation */
	private void enterSequenceAlways_operation() {
		nextStateIndex = 15;
		stateVector[15] = State.always_operation;
	}

	/* 'default' enter sequence for state default */
	private void enterSequenceOncycle_default() {
		nextStateIndex = 16;
		stateVector[16] = State.oncycle_default;
	}

	/* 'default' enter sequence for state else */
	private void enterSequenceOncycle_else() {
		nextStateIndex = 16;
		stateVector[16] = State.oncycle_else;
	}

	/* 'default' enter sequence for state entry */
	private void enterSequenceRaise_entry() {
		nextStateIndex = 17;
		stateVector[17] = State.raise_entry;
	}

	/* 'default' enter sequence for state exit */
	private void enterSequenceRaise_exit() {
		nextStateIndex = 17;
		stateVector[17] = State.raise_exit;
	}

	/* 'default' enter sequence for state always */
	private void enterSequenceValueof_always() {
		nextStateIndex = 18;
		stateVector[18] = State.valueof_always;
	}

	/* 'default' enter sequence for state oncycle */
	private void enterSequenceValueof_oncycle() {
		nextStateIndex = 18;
		stateVector[18] = State.valueof_oncycle;
	}

	/* 'default' enter sequence for state raise */
	private void enterSequenceActive_raise() {
		nextStateIndex = 19;
		stateVector[19] = State.active_raise;
	}

	/* 'default' enter sequence for state valueof */
	private void enterSequenceActive_valueof() {
		nextStateIndex = 19;
		stateVector[19] = State.active_valueof;
	}

	/* 'default' enter sequence for region default */
	private void enterSequenceDefault() {
		reactSTextKeywordsInStatesAndRegions_default__entry_Default();
	}

	/* 'default' enter sequence for region operation */
	private void enterSequenceOperation() {
		reactSTextKeywordsInStatesAndRegions_operation__entry_Default();
	}

	/* 'default' enter sequence for region namespace */
	private void enterSequenceNamespace() {
		reactSTextKeywordsInStatesAndRegions_namespace__entry_Default();
	}

	/* 'default' enter sequence for region local */
	private void enterSequenceLocal() {
		reactSTextKeywordsInStatesAndRegions_local__entry_Default();
	}

	/* 'default' enter sequence for region interface */
	private void enterSequenceInterface() {
		reactSTextKeywordsInStatesAndRegions_interface__entry_Default();
	}

	/* 'default' enter sequence for region internal */
	private void enterSequenceInternal() {
		reactSTextKeywordsInStatesAndRegions_internal__entry_Default();
	}

	/* 'default' enter sequence for region event */
	private void enterSequenceEvent() {
		reactSTextKeywordsInStatesAndRegions_event__entry_Default();
	}

	/* 'default' enter sequence for region in */
	private void enterSequenceIn() {
		reactSTextKeywordsInStatesAndRegions_in__entry_Default();
	}

	/* 'default' enter sequence for region out */
	private void enterSequenceOut() {
		reactSTextKeywordsInStatesAndRegions_out__entry_Default();
	}

	/* 'default' enter sequence for region var */
	private void enterSequenceVar() {
		reactSTextKeywordsInStatesAndRegions_var__entry_Default();
	}

	/* 'default' enter sequence for region readonly */
	private void enterSequenceReadonly() {
		reactSTextKeywordsInStatesAndRegions_readonly__entry_Default();
	}

	/* 'default' enter sequence for region external */
	private void enterSequenceExternal() {
		reactSTextKeywordsInStatesAndRegions_external__entry_Default();
	}

	/* 'default' enter sequence for region else */
	private void enterSequenceElse() {
		reactSTextKeywordsInStatesAndRegions_else__entry_Default();
	}

	/* 'default' enter sequence for region entry */
	private void enterSequenceEntry() {
		reactSTextKeywordsInStatesAndRegions_entry__entry_Default();
	}

	/* 'default' enter sequence for region exit */
	private void enterSequenceExit() {
		reactSTextKeywordsInStatesAndRegions_exit__entry_Default();
	}

	/* 'default' enter sequence for region always */
	private void enterSequenceAlways() {
		reactSTextKeywordsInStatesAndRegions_always__entry_Default();
	}

	/* 'default' enter sequence for region oncycle */
	private void enterSequenceOncycle() {
		reactSTextKeywordsInStatesAndRegions_oncycle__entry_Default();
	}

	/* 'default' enter sequence for region raise */
	private void enterSequenceRaise() {
		reactSTextKeywordsInStatesAndRegions_raise__entry_Default();
	}

	/* 'default' enter sequence for region valueof */
	private void enterSequenceValueof() {
		reactSTextKeywordsInStatesAndRegions_valueof__entry_Default();
	}

	/* 'default' enter sequence for region active */
	private void enterSequenceActive() {
		reactSTextKeywordsInStatesAndRegions_active__entry_Default();
	}

	/* Default exit sequence for state namespace */
	private void exitSequenceDefault_namespace() {
		nextStateIndex = 0;
		stateVector[0] = State.$NullState$;
	}

	/* Default exit sequence for state interface */
	private void exitSequenceOperation_interface() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state internal */
	private void exitSequenceOperation_internal() {
		nextStateIndex = 1;
		stateVector[1] = State.$NullState$;
	}

	/* Default exit sequence for state event */
	private void exitSequenceNamespace_event() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for state local */
	private void exitSequenceNamespace_local() {
		nextStateIndex = 2;
		stateVector[2] = State.$NullState$;
	}

	/* Default exit sequence for state in */
	private void exitSequenceLocal_in() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}

	/* Default exit sequence for state out */
	private void exitSequenceLocal_out() {
		nextStateIndex = 3;
		stateVector[3] = State.$NullState$;
	}

	/* Default exit sequence for state var */
	private void exitSequenceInterface_var() {
		nextStateIndex = 4;
		stateVector[4] = State.$NullState$;
	}

	/* Default exit sequence for state readonly */
	private void exitSequenceInterface_readonly() {
		nextStateIndex = 4;
		stateVector[4] = State.$NullState$;
	}

	/* Default exit sequence for state external */
	private void exitSequenceInternal_external() {
		nextStateIndex = 5;
		stateVector[5] = State.$NullState$;
	}

	/* Default exit sequence for state operation */
	private void exitSequenceInternal_operation() {
		nextStateIndex = 5;
		stateVector[5] = State.$NullState$;
	}

	/* Default exit sequence for state default */
	private void exitSequenceEvent_default() {
		nextStateIndex = 6;
		stateVector[6] = State.$NullState$;
	}

	/* Default exit sequence for state else */
	private void exitSequenceEvent_else() {
		nextStateIndex = 6;
		stateVector[6] = State.$NullState$;
	}

	/* Default exit sequence for state entry */
	private void exitSequenceIn_entry() {
		nextStateIndex = 7;
		stateVector[7] = State.$NullState$;
	}

	/* Default exit sequence for state exit */
	private void exitSequenceIn_exit() {
		nextStateIndex = 7;
		stateVector[7] = State.$NullState$;
	}

	/* Default exit sequence for state always */
	private void exitSequenceOut_always() {
		nextStateIndex = 8;
		stateVector[8] = State.$NullState$;
	}

	/* Default exit sequence for state oncycle */
	private void exitSequenceOut_oncycle() {
		nextStateIndex = 8;
		stateVector[8] = State.$NullState$;
	}

	/* Default exit sequence for state raise */
	private void exitSequenceVar_raise() {
		nextStateIndex = 9;
		stateVector[9] = State.$NullState$;
	}

	/* Default exit sequence for state valueof */
	private void exitSequenceVar_valueof() {
		nextStateIndex = 9;
		stateVector[9] = State.$NullState$;
	}

	/* Default exit sequence for state active */
	private void exitSequenceReadonly_active() {
		nextStateIndex = 10;
		stateVector[10] = State.$NullState$;
	}

	/* Default exit sequence for state namespace */
	private void exitSequenceReadonly_namespace() {
		nextStateIndex = 10;
		stateVector[10] = State.$NullState$;
	}

	/* Default exit sequence for state interface */
	private void exitSequenceExternal_interface() {
		nextStateIndex = 11;
		stateVector[11] = State.$NullState$;
	}

	/* Default exit sequence for state internal */
	private void exitSequenceExternal_internal() {
		nextStateIndex = 11;
		stateVector[11] = State.$NullState$;
	}

	/* Default exit sequence for state event */
	private void exitSequenceElse_event() {
		nextStateIndex = 12;
		stateVector[12] = State.$NullState$;
	}

	/* Default exit sequence for state local */
	private void exitSequenceElse_local() {
		nextStateIndex = 12;
		stateVector[12] = State.$NullState$;
	}

	/* Default exit sequence for state in */
	private void exitSequenceEntry_in() {
		nextStateIndex = 13;
		stateVector[13] = State.$NullState$;
	}

	/* Default exit sequence for state out */
	private void exitSequenceEntry_out() {
		nextStateIndex = 13;
		stateVector[13] = State.$NullState$;
	}

	/* Default exit sequence for state var */
	private void exitSequenceExit_var() {
		nextStateIndex = 14;
		stateVector[14] = State.$NullState$;
	}

	/* Default exit sequence for state readonly */
	private void exitSequenceExit_readonly() {
		nextStateIndex = 14;
		stateVector[14] = State.$NullState$;
	}

	/* Default exit sequence for state external */
	private void exitSequenceAlways_external() {
		nextStateIndex = 15;
		stateVector[15] = State.$NullState$;
	}

	/* Default exit sequence for state operation */
	private void exitSequenceAlways_operation() {
		nextStateIndex = 15;
		stateVector[15] = State.$NullState$;
	}

	/* Default exit sequence for state default */
	private void exitSequenceOncycle_default() {
		nextStateIndex = 16;
		stateVector[16] = State.$NullState$;
	}

	/* Default exit sequence for state else */
	private void exitSequenceOncycle_else() {
		nextStateIndex = 16;
		stateVector[16] = State.$NullState$;
	}

	/* Default exit sequence for state entry */
	private void exitSequenceRaise_entry() {
		nextStateIndex = 17;
		stateVector[17] = State.$NullState$;
	}

	/* Default exit sequence for state exit */
	private void exitSequenceRaise_exit() {
		nextStateIndex = 17;
		stateVector[17] = State.$NullState$;
	}

	/* Default exit sequence for state always */
	private void exitSequenceValueof_always() {
		nextStateIndex = 18;
		stateVector[18] = State.$NullState$;
	}

	/* Default exit sequence for state oncycle */
	private void exitSequenceValueof_oncycle() {
		nextStateIndex = 18;
		stateVector[18] = State.$NullState$;
	}

	/* Default exit sequence for state raise */
	private void exitSequenceActive_raise() {
		nextStateIndex = 19;
		stateVector[19] = State.$NullState$;
	}

	/* Default exit sequence for state valueof */
	private void exitSequenceActive_valueof() {
		nextStateIndex = 19;
		stateVector[19] = State.$NullState$;
	}

	/* Default exit sequence for region default */
	private void exitSequenceDefault() {
		switch (stateVector[0]) {
			case default_namespace :
				exitSequenceDefault_namespace();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region operation */
	private void exitSequenceOperation() {
		switch (stateVector[1]) {
			case operation_interface :
				exitSequenceOperation_interface();
				break;

			case operation_internal :
				exitSequenceOperation_internal();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region namespace */
	private void exitSequenceNamespace() {
		switch (stateVector[2]) {
			case namespace_event :
				exitSequenceNamespace_event();
				break;

			case namespace_local :
				exitSequenceNamespace_local();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region local */
	private void exitSequenceLocal() {
		switch (stateVector[3]) {
			case local_in :
				exitSequenceLocal_in();
				break;

			case local_out :
				exitSequenceLocal_out();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region interface */
	private void exitSequenceInterface() {
		switch (stateVector[4]) {
			case interface_var :
				exitSequenceInterface_var();
				break;

			case interface_readonly :
				exitSequenceInterface_readonly();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region internal */
	private void exitSequenceInternal() {
		switch (stateVector[5]) {
			case internal_external :
				exitSequenceInternal_external();
				break;

			case internal_operation :
				exitSequenceInternal_operation();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region event */
	private void exitSequenceEvent() {
		switch (stateVector[6]) {
			case event_default :
				exitSequenceEvent_default();
				break;

			case event_else :
				exitSequenceEvent_else();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region in */
	private void exitSequenceIn() {
		switch (stateVector[7]) {
			case in_entry :
				exitSequenceIn_entry();
				break;

			case in_exit :
				exitSequenceIn_exit();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region out */
	private void exitSequenceOut() {
		switch (stateVector[8]) {
			case out_always :
				exitSequenceOut_always();
				break;

			case out_oncycle :
				exitSequenceOut_oncycle();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region var */
	private void exitSequenceVar() {
		switch (stateVector[9]) {
			case var_raise :
				exitSequenceVar_raise();
				break;

			case var_valueof :
				exitSequenceVar_valueof();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region readonly */
	private void exitSequenceReadonly() {
		switch (stateVector[10]) {
			case readonly_active :
				exitSequenceReadonly_active();
				break;

			case readonly_namespace :
				exitSequenceReadonly_namespace();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region external */
	private void exitSequenceExternal() {
		switch (stateVector[11]) {
			case external_interface :
				exitSequenceExternal_interface();
				break;

			case external_internal :
				exitSequenceExternal_internal();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region else */
	private void exitSequenceElse() {
		switch (stateVector[12]) {
			case else_event :
				exitSequenceElse_event();
				break;

			case else_local :
				exitSequenceElse_local();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region entry */
	private void exitSequenceEntry() {
		switch (stateVector[13]) {
			case entry_in :
				exitSequenceEntry_in();
				break;

			case entry_out :
				exitSequenceEntry_out();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region exit */
	private void exitSequenceExit() {
		switch (stateVector[14]) {
			case exit_var :
				exitSequenceExit_var();
				break;

			case exit_readonly :
				exitSequenceExit_readonly();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region always */
	private void exitSequenceAlways() {
		switch (stateVector[15]) {
			case always_external :
				exitSequenceAlways_external();
				break;

			case always_operation :
				exitSequenceAlways_operation();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region oncycle */
	private void exitSequenceOncycle() {
		switch (stateVector[16]) {
			case oncycle_default :
				exitSequenceOncycle_default();
				break;

			case oncycle_else :
				exitSequenceOncycle_else();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region raise */
	private void exitSequenceRaise() {
		switch (stateVector[17]) {
			case raise_entry :
				exitSequenceRaise_entry();
				break;

			case raise_exit :
				exitSequenceRaise_exit();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region valueof */
	private void exitSequenceValueof() {
		switch (stateVector[18]) {
			case valueof_always :
				exitSequenceValueof_always();
				break;

			case valueof_oncycle :
				exitSequenceValueof_oncycle();
				break;

			default :
				break;
		}
	}

	/* Default exit sequence for region active */
	private void exitSequenceActive() {
		switch (stateVector[19]) {
			case active_raise :
				exitSequenceActive_raise();
				break;

			case active_valueof :
				exitSequenceActive_valueof();
				break;

			default :
				break;
		}
	}

	/* The reactions of state namespace. */
	private void reactDefault_namespace() {
	}

	/* The reactions of state interface. */
	private void reactOperation_interface() {
		if (checkOperation_interfaceTr0()) {
			effectOperation_interfaceTr0();
		}
	}

	/* The reactions of state internal. */
	private void reactOperation_internal() {
	}

	/* The reactions of state event. */
	private void reactNamespace_event() {
		if (checkNamespace_eventTr0()) {
			effectNamespace_eventTr0();
		}
	}

	/* The reactions of state local. */
	private void reactNamespace_local() {
	}

	/* The reactions of state in. */
	private void reactLocal_in() {
		if (checkLocal_inTr0()) {
			effectLocal_inTr0();
		}
	}

	/* The reactions of state out. */
	private void reactLocal_out() {
	}

	/* The reactions of state var. */
	private void reactInterface_var() {
		if (checkInterface_varTr0()) {
			effectInterface_varTr0();
		}
	}

	/* The reactions of state readonly. */
	private void reactInterface_readonly() {
	}

	/* The reactions of state external. */
	private void reactInternal_external() {
		if (checkInternal_externalTr0()) {
			effectInternal_externalTr0();
		}
	}

	/* The reactions of state operation. */
	private void reactInternal_operation() {
	}

	/* The reactions of state default. */
	private void reactEvent_default() {
		if (checkEvent_defaultTr0()) {
			effectEvent_defaultTr0();
		}
	}

	/* The reactions of state else. */
	private void reactEvent_else() {
	}

	/* The reactions of state entry. */
	private void reactIn_entry() {
		if (checkIn_entryTr0()) {
			effectIn_entryTr0();
		}
	}

	/* The reactions of state exit. */
	private void reactIn_exit() {
	}

	/* The reactions of state always. */
	private void reactOut_always() {
		if (checkOut_alwaysTr0()) {
			effectOut_alwaysTr0();
		}
	}

	/* The reactions of state oncycle. */
	private void reactOut_oncycle() {
	}

	/* The reactions of state raise. */
	private void reactVar_raise() {
		if (checkVar_raiseTr0()) {
			effectVar_raiseTr0();
		}
	}

	/* The reactions of state valueof. */
	private void reactVar_valueof() {
	}

	/* The reactions of state active. */
	private void reactReadonly_active() {
		if (checkReadonly_activeTr0()) {
			effectReadonly_activeTr0();
		}
	}

	/* The reactions of state namespace. */
	private void reactReadonly_namespace() {
	}

	/* The reactions of state interface. */
	private void reactExternal_interface() {
		if (checkExternal_interfaceTr0()) {
			effectExternal_interfaceTr0();
		}
	}

	/* The reactions of state internal. */
	private void reactExternal_internal() {
	}

	/* The reactions of state event. */
	private void reactElse_event() {
		if (checkElse_eventTr0()) {
			effectElse_eventTr0();
		}
	}

	/* The reactions of state local. */
	private void reactElse_local() {
	}

	/* The reactions of state in. */
	private void reactEntry_in() {
		if (checkEntry_inTr0()) {
			effectEntry_inTr0();
		}
	}

	/* The reactions of state out. */
	private void reactEntry_out() {
	}

	/* The reactions of state var. */
	private void reactExit_var() {
		if (checkExit_varTr0()) {
			effectExit_varTr0();
		}
	}

	/* The reactions of state readonly. */
	private void reactExit_readonly() {
	}

	/* The reactions of state external. */
	private void reactAlways_external() {
		if (checkAlways_externalTr0()) {
			effectAlways_externalTr0();
		}
	}

	/* The reactions of state operation. */
	private void reactAlways_operation() {
	}

	/* The reactions of state default. */
	private void reactOncycle_default() {
		if (checkOncycle_defaultTr0()) {
			effectOncycle_defaultTr0();
		}
	}

	/* The reactions of state else. */
	private void reactOncycle_else() {
	}

	/* The reactions of state entry. */
	private void reactRaise_entry() {
		if (checkRaise_entryTr0()) {
			effectRaise_entryTr0();
		}
	}

	/* The reactions of state exit. */
	private void reactRaise_exit() {
	}

	/* The reactions of state always. */
	private void reactValueof_always() {
		if (checkValueof_alwaysTr0()) {
			effectValueof_alwaysTr0();
		}
	}

	/* The reactions of state oncycle. */
	private void reactValueof_oncycle() {
	}

	/* The reactions of state raise. */
	private void reactActive_raise() {
		if (checkActive_raiseTr0()) {
			effectActive_raiseTr0();
		}
	}

	/* The reactions of state valueof. */
	private void reactActive_valueof() {
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_default__entry_Default() {
		enterSequenceDefault_namespace();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_operation__entry_Default() {
		enterSequenceOperation_interface();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_namespace__entry_Default() {
		enterSequenceNamespace_event();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_local__entry_Default() {
		enterSequenceLocal_in();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_interface__entry_Default() {
		enterSequenceInterface_var();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_internal__entry_Default() {
		enterSequenceInternal_external();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_event__entry_Default() {
		enterSequenceEvent_default();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_in__entry_Default() {
		enterSequenceIn_entry();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_out__entry_Default() {
		enterSequenceOut_always();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_var__entry_Default() {
		enterSequenceVar_raise();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_readonly__entry_Default() {
		enterSequenceReadonly_active();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_external__entry_Default() {
		enterSequenceExternal_interface();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_else__entry_Default() {
		enterSequenceElse_event();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_entry__entry_Default() {
		enterSequenceEntry_in();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_exit__entry_Default() {
		enterSequenceExit_var();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_always__entry_Default() {
		enterSequenceAlways_external();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_oncycle__entry_Default() {
		enterSequenceOncycle_default();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_raise__entry_Default() {
		enterSequenceRaise_entry();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_valueof__entry_Default() {
		enterSequenceValueof_always();
	}

	/* Default react sequence for initial entry  */
	private void reactSTextKeywordsInStatesAndRegions_active__entry_Default() {
		enterSequenceActive_raise();
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
