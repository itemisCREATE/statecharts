
#include "STextKeywordsInStatesAndRegions.h"
#include <string.h>

/*! \file Implementation of the state machine 'STextKeywordsInStatesAndRegions'
*/

STextKeywordsInStatesAndRegions::STextKeywordsInStatesAndRegions()
{
	
	
	stateConfVectorPosition = 0;
	
}

STextKeywordsInStatesAndRegions::~STextKeywordsInStatesAndRegions()
{
}


void STextKeywordsInStatesAndRegions::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = STextKeywordsInStatesAndRegions_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void STextKeywordsInStatesAndRegions::enter()
{
	/* Default enter sequence for statechart STextKeywordsInStatesAndRegions */
	enseq_default_default();
	enseq_operation_default();
	enseq_namespace_default();
	enseq_local_default();
	enseq_interface_default();
	enseq_internal_default();
	enseq_event_default();
	enseq_in_default();
	enseq_out_default();
	enseq_var_default();
	enseq_readonly_default();
	enseq_external_default();
	enseq_else_default();
	enseq_entry_default();
	enseq_exit_default();
	enseq_always_default();
	enseq_oncycle_default();
	enseq_raise_default();
	enseq_valueof_default();
	enseq_active_default();
}

void STextKeywordsInStatesAndRegions::exit()
{
	/* Default exit sequence for statechart STextKeywordsInStatesAndRegions */
	exseq_default();
	exseq_operation();
	exseq_namespace();
	exseq_local();
	exseq_interface();
	exseq_internal();
	exseq_event();
	exseq_in();
	exseq_out();
	exseq_var();
	exseq_readonly();
	exseq_external();
	exseq_else();
	exseq_entry();
	exseq_exit();
	exseq_always();
	exseq_oncycle();
	exseq_raise();
	exseq_valueof();
	exseq_active();
}

sc_boolean STextKeywordsInStatesAndRegions::isActive() const
{
	return stateConfVector[0] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[1] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[2] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[3] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[4] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[5] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[6] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[7] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[8] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[9] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[10] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[11] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[12] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[13] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[14] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[15] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[16] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[17] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[18] != STextKeywordsInStatesAndRegions_last_state||stateConfVector[19] != STextKeywordsInStatesAndRegions_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean STextKeywordsInStatesAndRegions::isFinal() const
{
   return false;}

void STextKeywordsInStatesAndRegions::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case default_namespace :
		{
			react_default_namespace();
			break;
		}
		case operation_interface :
		{
			react_operation_interface();
			break;
		}
		case operation_internal :
		{
			react_operation_internal();
			break;
		}
		case namespace_event :
		{
			react_namespace_event();
			break;
		}
		case namespace_local :
		{
			react_namespace_local();
			break;
		}
		case local_in :
		{
			react_local_in();
			break;
		}
		case local_out :
		{
			react_local_out();
			break;
		}
		case interface_var :
		{
			react_interface_var();
			break;
		}
		case interface_readonly :
		{
			react_interface_readonly();
			break;
		}
		case internal_external :
		{
			react_internal_external();
			break;
		}
		case internal_operation :
		{
			react_internal_operation();
			break;
		}
		case event_default :
		{
			react_event_default();
			break;
		}
		case event_else :
		{
			react_event_else();
			break;
		}
		case in_entry :
		{
			react_in_entry();
			break;
		}
		case in_exit :
		{
			react_in_exit();
			break;
		}
		case out_always :
		{
			react_out_always();
			break;
		}
		case out_oncycle :
		{
			react_out_oncycle();
			break;
		}
		case var_raise :
		{
			react_var_raise();
			break;
		}
		case var_valueof :
		{
			react_var_valueof();
			break;
		}
		case readonly_active :
		{
			react_readonly_active();
			break;
		}
		case readonly_namespace :
		{
			react_readonly_namespace();
			break;
		}
		case external_interface :
		{
			react_external_interface();
			break;
		}
		case external_internal :
		{
			react_external_internal();
			break;
		}
		case else_event :
		{
			react_else_event();
			break;
		}
		case else_local :
		{
			react_else_local();
			break;
		}
		case entry_in :
		{
			react_entry_in();
			break;
		}
		case entry_out :
		{
			react_entry_out();
			break;
		}
		case exit_var :
		{
			react_exit_var();
			break;
		}
		case exit_readonly :
		{
			react_exit_readonly();
			break;
		}
		case always_external :
		{
			react_always_external();
			break;
		}
		case always_operation :
		{
			react_always_operation();
			break;
		}
		case oncycle_default :
		{
			react_oncycle_default();
			break;
		}
		case oncycle_else :
		{
			react_oncycle_else();
			break;
		}
		case raise_entry :
		{
			react_raise_entry();
			break;
		}
		case raise_exit :
		{
			react_raise_exit();
			break;
		}
		case valueof_always :
		{
			react_valueof_always();
			break;
		}
		case valueof_oncycle :
		{
			react_valueof_oncycle();
			break;
		}
		case active_raise :
		{
			react_active_raise();
			break;
		}
		case active_valueof :
		{
			react_active_valueof();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void STextKeywordsInStatesAndRegions::clearInEvents()
{
	iface.e1_raised = false;
	iface.e2_raised = false;
}

void STextKeywordsInStatesAndRegions::clearOutEvents()
{
}


sc_boolean STextKeywordsInStatesAndRegions::isStateActive(STextKeywordsInStatesAndRegionsStates state) const
{
	switch (state)
	{
		case default_namespace : 
			return (sc_boolean) (stateConfVector[0] == default_namespace
			);
		case operation_interface : 
			return (sc_boolean) (stateConfVector[1] == operation_interface
			);
		case operation_internal : 
			return (sc_boolean) (stateConfVector[1] == operation_internal
			);
		case namespace_event : 
			return (sc_boolean) (stateConfVector[2] == namespace_event
			);
		case namespace_local : 
			return (sc_boolean) (stateConfVector[2] == namespace_local
			);
		case local_in : 
			return (sc_boolean) (stateConfVector[3] == local_in
			);
		case local_out : 
			return (sc_boolean) (stateConfVector[3] == local_out
			);
		case interface_var : 
			return (sc_boolean) (stateConfVector[4] == interface_var
			);
		case interface_readonly : 
			return (sc_boolean) (stateConfVector[4] == interface_readonly
			);
		case internal_external : 
			return (sc_boolean) (stateConfVector[5] == internal_external
			);
		case internal_operation : 
			return (sc_boolean) (stateConfVector[5] == internal_operation
			);
		case event_default : 
			return (sc_boolean) (stateConfVector[6] == event_default
			);
		case event_else : 
			return (sc_boolean) (stateConfVector[6] == event_else
			);
		case in_entry : 
			return (sc_boolean) (stateConfVector[7] == in_entry
			);
		case in_exit : 
			return (sc_boolean) (stateConfVector[7] == in_exit
			);
		case out_always : 
			return (sc_boolean) (stateConfVector[8] == out_always
			);
		case out_oncycle : 
			return (sc_boolean) (stateConfVector[8] == out_oncycle
			);
		case var_raise : 
			return (sc_boolean) (stateConfVector[9] == var_raise
			);
		case var_valueof : 
			return (sc_boolean) (stateConfVector[9] == var_valueof
			);
		case readonly_active : 
			return (sc_boolean) (stateConfVector[10] == readonly_active
			);
		case readonly_namespace : 
			return (sc_boolean) (stateConfVector[10] == readonly_namespace
			);
		case external_interface : 
			return (sc_boolean) (stateConfVector[11] == external_interface
			);
		case external_internal : 
			return (sc_boolean) (stateConfVector[11] == external_internal
			);
		case else_event : 
			return (sc_boolean) (stateConfVector[12] == else_event
			);
		case else_local : 
			return (sc_boolean) (stateConfVector[12] == else_local
			);
		case entry_in : 
			return (sc_boolean) (stateConfVector[13] == entry_in
			);
		case entry_out : 
			return (sc_boolean) (stateConfVector[13] == entry_out
			);
		case exit_var : 
			return (sc_boolean) (stateConfVector[14] == exit_var
			);
		case exit_readonly : 
			return (sc_boolean) (stateConfVector[14] == exit_readonly
			);
		case always_external : 
			return (sc_boolean) (stateConfVector[15] == always_external
			);
		case always_operation : 
			return (sc_boolean) (stateConfVector[15] == always_operation
			);
		case oncycle_default : 
			return (sc_boolean) (stateConfVector[16] == oncycle_default
			);
		case oncycle_else : 
			return (sc_boolean) (stateConfVector[16] == oncycle_else
			);
		case raise_entry : 
			return (sc_boolean) (stateConfVector[17] == raise_entry
			);
		case raise_exit : 
			return (sc_boolean) (stateConfVector[17] == raise_exit
			);
		case valueof_always : 
			return (sc_boolean) (stateConfVector[18] == valueof_always
			);
		case valueof_oncycle : 
			return (sc_boolean) (stateConfVector[18] == valueof_oncycle
			);
		case active_raise : 
			return (sc_boolean) (stateConfVector[19] == active_raise
			);
		case active_valueof : 
			return (sc_boolean) (stateConfVector[19] == active_valueof
			);
		default: return false;
	}
}

STextKeywordsInStatesAndRegions::DefaultSCI* STextKeywordsInStatesAndRegions::getDefaultSCI()
{
	return &iface;
}

void STextKeywordsInStatesAndRegions::DefaultSCI::raise_e1()
{
	e1_raised = true;
}

void STextKeywordsInStatesAndRegions::raise_e1()
{
	iface.raise_e1();
}

void STextKeywordsInStatesAndRegions::DefaultSCI::raise_e2()
{
	e2_raised = true;
}

void STextKeywordsInStatesAndRegions::raise_e2()
{
	iface.raise_e2();
}



// implementations of all internal functions

sc_boolean STextKeywordsInStatesAndRegions::check_operation_interface_tr0_tr0()
{
	return (iface.e1_raised) && (isStateActive(default_namespace));
}

sc_boolean STextKeywordsInStatesAndRegions::check_namespace_event_tr0_tr0()
{
	return (iface.e2_raised) && (isStateActive(operation_internal));
}

sc_boolean STextKeywordsInStatesAndRegions::check_local_in_tr0_tr0()
{
	return (iface.e1_raised) && (isStateActive(namespace_local));
}

sc_boolean STextKeywordsInStatesAndRegions::check_interface_var_tr0_tr0()
{
	return (iface.e2_raised) && (isStateActive(local_out));
}

sc_boolean STextKeywordsInStatesAndRegions::check_internal_external_tr0_tr0()
{
	return (iface.e1_raised) && (isStateActive(interface_readonly));
}

sc_boolean STextKeywordsInStatesAndRegions::check_event_default_tr0_tr0()
{
	return (iface.e2_raised) && (isStateActive(internal_operation));
}

sc_boolean STextKeywordsInStatesAndRegions::check_in_entry_tr0_tr0()
{
	return (iface.e1_raised) && (isStateActive(event_else));
}

sc_boolean STextKeywordsInStatesAndRegions::check_out_always_tr0_tr0()
{
	return (iface.e2_raised) && (isStateActive(in_exit));
}

sc_boolean STextKeywordsInStatesAndRegions::check_var_raise_tr0_tr0()
{
	return (iface.e1_raised) && (isStateActive(out_oncycle));
}

sc_boolean STextKeywordsInStatesAndRegions::check_readonly_active_tr0_tr0()
{
	return (iface.e2_raised) && (isStateActive(var_valueof));
}

sc_boolean STextKeywordsInStatesAndRegions::check_external_interface_tr0_tr0()
{
	return (iface.e1_raised) && (isStateActive(readonly_namespace));
}

sc_boolean STextKeywordsInStatesAndRegions::check_else_event_tr0_tr0()
{
	return (iface.e2_raised) && (isStateActive(external_internal));
}

sc_boolean STextKeywordsInStatesAndRegions::check_entry_in_tr0_tr0()
{
	return (iface.e1_raised) && (isStateActive(else_local));
}

sc_boolean STextKeywordsInStatesAndRegions::check_exit_var_tr0_tr0()
{
	return (iface.e2_raised) && (isStateActive(entry_out));
}

sc_boolean STextKeywordsInStatesAndRegions::check_always_external_tr0_tr0()
{
	return (iface.e1_raised) && (isStateActive(exit_readonly));
}

sc_boolean STextKeywordsInStatesAndRegions::check_oncycle_default_tr0_tr0()
{
	return (iface.e2_raised) && (isStateActive(always_operation));
}

sc_boolean STextKeywordsInStatesAndRegions::check_raise_entry_tr0_tr0()
{
	return (iface.e1_raised) && (isStateActive(oncycle_else));
}

sc_boolean STextKeywordsInStatesAndRegions::check_valueof_always_tr0_tr0()
{
	return (iface.e2_raised) && (isStateActive(raise_exit));
}

sc_boolean STextKeywordsInStatesAndRegions::check_active_raise_tr0_tr0()
{
	return (iface.e1_raised) && (isStateActive(valueof_oncycle));
}

void STextKeywordsInStatesAndRegions::effect_operation_interface_tr0()
{
	exseq_operation_interface();
	enseq_operation_internal_default();
}

void STextKeywordsInStatesAndRegions::effect_namespace_event_tr0()
{
	exseq_namespace_event();
	enseq_namespace_local_default();
}

void STextKeywordsInStatesAndRegions::effect_local_in_tr0()
{
	exseq_local_in();
	enseq_local_out_default();
}

void STextKeywordsInStatesAndRegions::effect_interface_var_tr0()
{
	exseq_interface_var();
	enseq_interface_readonly_default();
}

void STextKeywordsInStatesAndRegions::effect_internal_external_tr0()
{
	exseq_internal_external();
	enseq_internal_operation_default();
}

void STextKeywordsInStatesAndRegions::effect_event_default_tr0()
{
	exseq_event_default();
	enseq_event_else_default();
}

void STextKeywordsInStatesAndRegions::effect_in_entry_tr0()
{
	exseq_in_entry();
	enseq_in_exit_default();
}

void STextKeywordsInStatesAndRegions::effect_out_always_tr0()
{
	exseq_out_always();
	enseq_out_oncycle_default();
}

void STextKeywordsInStatesAndRegions::effect_var_raise_tr0()
{
	exseq_var_raise();
	enseq_var_valueof_default();
}

void STextKeywordsInStatesAndRegions::effect_readonly_active_tr0()
{
	exseq_readonly_active();
	enseq_readonly_namespace_default();
}

void STextKeywordsInStatesAndRegions::effect_external_interface_tr0()
{
	exseq_external_interface();
	enseq_external_internal_default();
}

void STextKeywordsInStatesAndRegions::effect_else_event_tr0()
{
	exseq_else_event();
	enseq_else_local_default();
}

void STextKeywordsInStatesAndRegions::effect_entry_in_tr0()
{
	exseq_entry_in();
	enseq_entry_out_default();
}

void STextKeywordsInStatesAndRegions::effect_exit_var_tr0()
{
	exseq_exit_var();
	enseq_exit_readonly_default();
}

void STextKeywordsInStatesAndRegions::effect_always_external_tr0()
{
	exseq_always_external();
	enseq_always_operation_default();
}

void STextKeywordsInStatesAndRegions::effect_oncycle_default_tr0()
{
	exseq_oncycle_default();
	enseq_oncycle_else_default();
}

void STextKeywordsInStatesAndRegions::effect_raise_entry_tr0()
{
	exseq_raise_entry();
	enseq_raise_exit_default();
}

void STextKeywordsInStatesAndRegions::effect_valueof_always_tr0()
{
	exseq_valueof_always();
	enseq_valueof_oncycle_default();
}

void STextKeywordsInStatesAndRegions::effect_active_raise_tr0()
{
	exseq_active_raise();
	enseq_active_valueof_default();
}

/* 'default' enter sequence for state namespace */
void STextKeywordsInStatesAndRegions::enseq_default_namespace_default()
{
	/* 'default' enter sequence for state namespace */
	stateConfVector[0] = default_namespace;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state interface */
void STextKeywordsInStatesAndRegions::enseq_operation_interface_default()
{
	/* 'default' enter sequence for state interface */
	stateConfVector[1] = operation_interface;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state internal */
void STextKeywordsInStatesAndRegions::enseq_operation_internal_default()
{
	/* 'default' enter sequence for state internal */
	stateConfVector[1] = operation_internal;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state event */
void STextKeywordsInStatesAndRegions::enseq_namespace_event_default()
{
	/* 'default' enter sequence for state event */
	stateConfVector[2] = namespace_event;
	stateConfVectorPosition = 2;
}

/* 'default' enter sequence for state local */
void STextKeywordsInStatesAndRegions::enseq_namespace_local_default()
{
	/* 'default' enter sequence for state local */
	stateConfVector[2] = namespace_local;
	stateConfVectorPosition = 2;
}

/* 'default' enter sequence for state in */
void STextKeywordsInStatesAndRegions::enseq_local_in_default()
{
	/* 'default' enter sequence for state in */
	stateConfVector[3] = local_in;
	stateConfVectorPosition = 3;
}

/* 'default' enter sequence for state out */
void STextKeywordsInStatesAndRegions::enseq_local_out_default()
{
	/* 'default' enter sequence for state out */
	stateConfVector[3] = local_out;
	stateConfVectorPosition = 3;
}

/* 'default' enter sequence for state var */
void STextKeywordsInStatesAndRegions::enseq_interface_var_default()
{
	/* 'default' enter sequence for state var */
	stateConfVector[4] = interface_var;
	stateConfVectorPosition = 4;
}

/* 'default' enter sequence for state readonly */
void STextKeywordsInStatesAndRegions::enseq_interface_readonly_default()
{
	/* 'default' enter sequence for state readonly */
	stateConfVector[4] = interface_readonly;
	stateConfVectorPosition = 4;
}

/* 'default' enter sequence for state external */
void STextKeywordsInStatesAndRegions::enseq_internal_external_default()
{
	/* 'default' enter sequence for state external */
	stateConfVector[5] = internal_external;
	stateConfVectorPosition = 5;
}

/* 'default' enter sequence for state operation */
void STextKeywordsInStatesAndRegions::enseq_internal_operation_default()
{
	/* 'default' enter sequence for state operation */
	stateConfVector[5] = internal_operation;
	stateConfVectorPosition = 5;
}

/* 'default' enter sequence for state default */
void STextKeywordsInStatesAndRegions::enseq_event_default_default()
{
	/* 'default' enter sequence for state default */
	stateConfVector[6] = event_default;
	stateConfVectorPosition = 6;
}

/* 'default' enter sequence for state else */
void STextKeywordsInStatesAndRegions::enseq_event_else_default()
{
	/* 'default' enter sequence for state else */
	stateConfVector[6] = event_else;
	stateConfVectorPosition = 6;
}

/* 'default' enter sequence for state entry */
void STextKeywordsInStatesAndRegions::enseq_in_entry_default()
{
	/* 'default' enter sequence for state entry */
	stateConfVector[7] = in_entry;
	stateConfVectorPosition = 7;
}

/* 'default' enter sequence for state exit */
void STextKeywordsInStatesAndRegions::enseq_in_exit_default()
{
	/* 'default' enter sequence for state exit */
	stateConfVector[7] = in_exit;
	stateConfVectorPosition = 7;
}

/* 'default' enter sequence for state always */
void STextKeywordsInStatesAndRegions::enseq_out_always_default()
{
	/* 'default' enter sequence for state always */
	stateConfVector[8] = out_always;
	stateConfVectorPosition = 8;
}

/* 'default' enter sequence for state oncycle */
void STextKeywordsInStatesAndRegions::enseq_out_oncycle_default()
{
	/* 'default' enter sequence for state oncycle */
	stateConfVector[8] = out_oncycle;
	stateConfVectorPosition = 8;
}

/* 'default' enter sequence for state raise */
void STextKeywordsInStatesAndRegions::enseq_var_raise_default()
{
	/* 'default' enter sequence for state raise */
	stateConfVector[9] = var_raise;
	stateConfVectorPosition = 9;
}

/* 'default' enter sequence for state valueof */
void STextKeywordsInStatesAndRegions::enseq_var_valueof_default()
{
	/* 'default' enter sequence for state valueof */
	stateConfVector[9] = var_valueof;
	stateConfVectorPosition = 9;
}

/* 'default' enter sequence for state active */
void STextKeywordsInStatesAndRegions::enseq_readonly_active_default()
{
	/* 'default' enter sequence for state active */
	stateConfVector[10] = readonly_active;
	stateConfVectorPosition = 10;
}

/* 'default' enter sequence for state namespace */
void STextKeywordsInStatesAndRegions::enseq_readonly_namespace_default()
{
	/* 'default' enter sequence for state namespace */
	stateConfVector[10] = readonly_namespace;
	stateConfVectorPosition = 10;
}

/* 'default' enter sequence for state interface */
void STextKeywordsInStatesAndRegions::enseq_external_interface_default()
{
	/* 'default' enter sequence for state interface */
	stateConfVector[11] = external_interface;
	stateConfVectorPosition = 11;
}

/* 'default' enter sequence for state internal */
void STextKeywordsInStatesAndRegions::enseq_external_internal_default()
{
	/* 'default' enter sequence for state internal */
	stateConfVector[11] = external_internal;
	stateConfVectorPosition = 11;
}

/* 'default' enter sequence for state event */
void STextKeywordsInStatesAndRegions::enseq_else_event_default()
{
	/* 'default' enter sequence for state event */
	stateConfVector[12] = else_event;
	stateConfVectorPosition = 12;
}

/* 'default' enter sequence for state local */
void STextKeywordsInStatesAndRegions::enseq_else_local_default()
{
	/* 'default' enter sequence for state local */
	stateConfVector[12] = else_local;
	stateConfVectorPosition = 12;
}

/* 'default' enter sequence for state in */
void STextKeywordsInStatesAndRegions::enseq_entry_in_default()
{
	/* 'default' enter sequence for state in */
	stateConfVector[13] = entry_in;
	stateConfVectorPosition = 13;
}

/* 'default' enter sequence for state out */
void STextKeywordsInStatesAndRegions::enseq_entry_out_default()
{
	/* 'default' enter sequence for state out */
	stateConfVector[13] = entry_out;
	stateConfVectorPosition = 13;
}

/* 'default' enter sequence for state var */
void STextKeywordsInStatesAndRegions::enseq_exit_var_default()
{
	/* 'default' enter sequence for state var */
	stateConfVector[14] = exit_var;
	stateConfVectorPosition = 14;
}

/* 'default' enter sequence for state readonly */
void STextKeywordsInStatesAndRegions::enseq_exit_readonly_default()
{
	/* 'default' enter sequence for state readonly */
	stateConfVector[14] = exit_readonly;
	stateConfVectorPosition = 14;
}

/* 'default' enter sequence for state external */
void STextKeywordsInStatesAndRegions::enseq_always_external_default()
{
	/* 'default' enter sequence for state external */
	stateConfVector[15] = always_external;
	stateConfVectorPosition = 15;
}

/* 'default' enter sequence for state operation */
void STextKeywordsInStatesAndRegions::enseq_always_operation_default()
{
	/* 'default' enter sequence for state operation */
	stateConfVector[15] = always_operation;
	stateConfVectorPosition = 15;
}

/* 'default' enter sequence for state default */
void STextKeywordsInStatesAndRegions::enseq_oncycle_default_default()
{
	/* 'default' enter sequence for state default */
	stateConfVector[16] = oncycle_default;
	stateConfVectorPosition = 16;
}

/* 'default' enter sequence for state else */
void STextKeywordsInStatesAndRegions::enseq_oncycle_else_default()
{
	/* 'default' enter sequence for state else */
	stateConfVector[16] = oncycle_else;
	stateConfVectorPosition = 16;
}

/* 'default' enter sequence for state entry */
void STextKeywordsInStatesAndRegions::enseq_raise_entry_default()
{
	/* 'default' enter sequence for state entry */
	stateConfVector[17] = raise_entry;
	stateConfVectorPosition = 17;
}

/* 'default' enter sequence for state exit */
void STextKeywordsInStatesAndRegions::enseq_raise_exit_default()
{
	/* 'default' enter sequence for state exit */
	stateConfVector[17] = raise_exit;
	stateConfVectorPosition = 17;
}

/* 'default' enter sequence for state always */
void STextKeywordsInStatesAndRegions::enseq_valueof_always_default()
{
	/* 'default' enter sequence for state always */
	stateConfVector[18] = valueof_always;
	stateConfVectorPosition = 18;
}

/* 'default' enter sequence for state oncycle */
void STextKeywordsInStatesAndRegions::enseq_valueof_oncycle_default()
{
	/* 'default' enter sequence for state oncycle */
	stateConfVector[18] = valueof_oncycle;
	stateConfVectorPosition = 18;
}

/* 'default' enter sequence for state raise */
void STextKeywordsInStatesAndRegions::enseq_active_raise_default()
{
	/* 'default' enter sequence for state raise */
	stateConfVector[19] = active_raise;
	stateConfVectorPosition = 19;
}

/* 'default' enter sequence for state valueof */
void STextKeywordsInStatesAndRegions::enseq_active_valueof_default()
{
	/* 'default' enter sequence for state valueof */
	stateConfVector[19] = active_valueof;
	stateConfVectorPosition = 19;
}

/* 'default' enter sequence for region default */
void STextKeywordsInStatesAndRegions::enseq_default_default()
{
	/* 'default' enter sequence for region default */
	react_default__entry_Default();
}

/* 'default' enter sequence for region operation */
void STextKeywordsInStatesAndRegions::enseq_operation_default()
{
	/* 'default' enter sequence for region operation */
	react_operation__entry_Default();
}

/* 'default' enter sequence for region namespace */
void STextKeywordsInStatesAndRegions::enseq_namespace_default()
{
	/* 'default' enter sequence for region namespace */
	react_namespace__entry_Default();
}

/* 'default' enter sequence for region local */
void STextKeywordsInStatesAndRegions::enseq_local_default()
{
	/* 'default' enter sequence for region local */
	react_local__entry_Default();
}

/* 'default' enter sequence for region interface */
void STextKeywordsInStatesAndRegions::enseq_interface_default()
{
	/* 'default' enter sequence for region interface */
	react_interface__entry_Default();
}

/* 'default' enter sequence for region internal */
void STextKeywordsInStatesAndRegions::enseq_internal_default()
{
	/* 'default' enter sequence for region internal */
	react_internal__entry_Default();
}

/* 'default' enter sequence for region event */
void STextKeywordsInStatesAndRegions::enseq_event_default()
{
	/* 'default' enter sequence for region event */
	react_event__entry_Default();
}

/* 'default' enter sequence for region in */
void STextKeywordsInStatesAndRegions::enseq_in_default()
{
	/* 'default' enter sequence for region in */
	react_in__entry_Default();
}

/* 'default' enter sequence for region out */
void STextKeywordsInStatesAndRegions::enseq_out_default()
{
	/* 'default' enter sequence for region out */
	react_out__entry_Default();
}

/* 'default' enter sequence for region var */
void STextKeywordsInStatesAndRegions::enseq_var_default()
{
	/* 'default' enter sequence for region var */
	react_var__entry_Default();
}

/* 'default' enter sequence for region readonly */
void STextKeywordsInStatesAndRegions::enseq_readonly_default()
{
	/* 'default' enter sequence for region readonly */
	react_readonly__entry_Default();
}

/* 'default' enter sequence for region external */
void STextKeywordsInStatesAndRegions::enseq_external_default()
{
	/* 'default' enter sequence for region external */
	react_external__entry_Default();
}

/* 'default' enter sequence for region else */
void STextKeywordsInStatesAndRegions::enseq_else_default()
{
	/* 'default' enter sequence for region else */
	react_else__entry_Default();
}

/* 'default' enter sequence for region entry */
void STextKeywordsInStatesAndRegions::enseq_entry_default()
{
	/* 'default' enter sequence for region entry */
	react_entry__entry_Default();
}

/* 'default' enter sequence for region exit */
void STextKeywordsInStatesAndRegions::enseq_exit_default()
{
	/* 'default' enter sequence for region exit */
	react_exit__entry_Default();
}

/* 'default' enter sequence for region always */
void STextKeywordsInStatesAndRegions::enseq_always_default()
{
	/* 'default' enter sequence for region always */
	react_always__entry_Default();
}

/* 'default' enter sequence for region oncycle */
void STextKeywordsInStatesAndRegions::enseq_oncycle_default()
{
	/* 'default' enter sequence for region oncycle */
	react_oncycle__entry_Default();
}

/* 'default' enter sequence for region raise */
void STextKeywordsInStatesAndRegions::enseq_raise_default()
{
	/* 'default' enter sequence for region raise */
	react_raise__entry_Default();
}

/* 'default' enter sequence for region valueof */
void STextKeywordsInStatesAndRegions::enseq_valueof_default()
{
	/* 'default' enter sequence for region valueof */
	react_valueof__entry_Default();
}

/* 'default' enter sequence for region active */
void STextKeywordsInStatesAndRegions::enseq_active_default()
{
	/* 'default' enter sequence for region active */
	react_active__entry_Default();
}

/* Default exit sequence for state namespace */
void STextKeywordsInStatesAndRegions::exseq_default_namespace()
{
	/* Default exit sequence for state namespace */
	stateConfVector[0] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state interface */
void STextKeywordsInStatesAndRegions::exseq_operation_interface()
{
	/* Default exit sequence for state interface */
	stateConfVector[1] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state internal */
void STextKeywordsInStatesAndRegions::exseq_operation_internal()
{
	/* Default exit sequence for state internal */
	stateConfVector[1] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state event */
void STextKeywordsInStatesAndRegions::exseq_namespace_event()
{
	/* Default exit sequence for state event */
	stateConfVector[2] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 2;
}

/* Default exit sequence for state local */
void STextKeywordsInStatesAndRegions::exseq_namespace_local()
{
	/* Default exit sequence for state local */
	stateConfVector[2] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 2;
}

/* Default exit sequence for state in */
void STextKeywordsInStatesAndRegions::exseq_local_in()
{
	/* Default exit sequence for state in */
	stateConfVector[3] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 3;
}

/* Default exit sequence for state out */
void STextKeywordsInStatesAndRegions::exseq_local_out()
{
	/* Default exit sequence for state out */
	stateConfVector[3] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 3;
}

/* Default exit sequence for state var */
void STextKeywordsInStatesAndRegions::exseq_interface_var()
{
	/* Default exit sequence for state var */
	stateConfVector[4] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 4;
}

/* Default exit sequence for state readonly */
void STextKeywordsInStatesAndRegions::exseq_interface_readonly()
{
	/* Default exit sequence for state readonly */
	stateConfVector[4] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 4;
}

/* Default exit sequence for state external */
void STextKeywordsInStatesAndRegions::exseq_internal_external()
{
	/* Default exit sequence for state external */
	stateConfVector[5] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 5;
}

/* Default exit sequence for state operation */
void STextKeywordsInStatesAndRegions::exseq_internal_operation()
{
	/* Default exit sequence for state operation */
	stateConfVector[5] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 5;
}

/* Default exit sequence for state default */
void STextKeywordsInStatesAndRegions::exseq_event_default()
{
	/* Default exit sequence for state default */
	stateConfVector[6] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 6;
}

/* Default exit sequence for state else */
void STextKeywordsInStatesAndRegions::exseq_event_else()
{
	/* Default exit sequence for state else */
	stateConfVector[6] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 6;
}

/* Default exit sequence for state entry */
void STextKeywordsInStatesAndRegions::exseq_in_entry()
{
	/* Default exit sequence for state entry */
	stateConfVector[7] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 7;
}

/* Default exit sequence for state exit */
void STextKeywordsInStatesAndRegions::exseq_in_exit()
{
	/* Default exit sequence for state exit */
	stateConfVector[7] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 7;
}

/* Default exit sequence for state always */
void STextKeywordsInStatesAndRegions::exseq_out_always()
{
	/* Default exit sequence for state always */
	stateConfVector[8] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 8;
}

/* Default exit sequence for state oncycle */
void STextKeywordsInStatesAndRegions::exseq_out_oncycle()
{
	/* Default exit sequence for state oncycle */
	stateConfVector[8] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 8;
}

/* Default exit sequence for state raise */
void STextKeywordsInStatesAndRegions::exseq_var_raise()
{
	/* Default exit sequence for state raise */
	stateConfVector[9] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 9;
}

/* Default exit sequence for state valueof */
void STextKeywordsInStatesAndRegions::exseq_var_valueof()
{
	/* Default exit sequence for state valueof */
	stateConfVector[9] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 9;
}

/* Default exit sequence for state active */
void STextKeywordsInStatesAndRegions::exseq_readonly_active()
{
	/* Default exit sequence for state active */
	stateConfVector[10] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 10;
}

/* Default exit sequence for state namespace */
void STextKeywordsInStatesAndRegions::exseq_readonly_namespace()
{
	/* Default exit sequence for state namespace */
	stateConfVector[10] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 10;
}

/* Default exit sequence for state interface */
void STextKeywordsInStatesAndRegions::exseq_external_interface()
{
	/* Default exit sequence for state interface */
	stateConfVector[11] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 11;
}

/* Default exit sequence for state internal */
void STextKeywordsInStatesAndRegions::exseq_external_internal()
{
	/* Default exit sequence for state internal */
	stateConfVector[11] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 11;
}

/* Default exit sequence for state event */
void STextKeywordsInStatesAndRegions::exseq_else_event()
{
	/* Default exit sequence for state event */
	stateConfVector[12] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 12;
}

/* Default exit sequence for state local */
void STextKeywordsInStatesAndRegions::exseq_else_local()
{
	/* Default exit sequence for state local */
	stateConfVector[12] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 12;
}

/* Default exit sequence for state in */
void STextKeywordsInStatesAndRegions::exseq_entry_in()
{
	/* Default exit sequence for state in */
	stateConfVector[13] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 13;
}

/* Default exit sequence for state out */
void STextKeywordsInStatesAndRegions::exseq_entry_out()
{
	/* Default exit sequence for state out */
	stateConfVector[13] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 13;
}

/* Default exit sequence for state var */
void STextKeywordsInStatesAndRegions::exseq_exit_var()
{
	/* Default exit sequence for state var */
	stateConfVector[14] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 14;
}

/* Default exit sequence for state readonly */
void STextKeywordsInStatesAndRegions::exseq_exit_readonly()
{
	/* Default exit sequence for state readonly */
	stateConfVector[14] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 14;
}

/* Default exit sequence for state external */
void STextKeywordsInStatesAndRegions::exseq_always_external()
{
	/* Default exit sequence for state external */
	stateConfVector[15] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 15;
}

/* Default exit sequence for state operation */
void STextKeywordsInStatesAndRegions::exseq_always_operation()
{
	/* Default exit sequence for state operation */
	stateConfVector[15] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 15;
}

/* Default exit sequence for state default */
void STextKeywordsInStatesAndRegions::exseq_oncycle_default()
{
	/* Default exit sequence for state default */
	stateConfVector[16] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 16;
}

/* Default exit sequence for state else */
void STextKeywordsInStatesAndRegions::exseq_oncycle_else()
{
	/* Default exit sequence for state else */
	stateConfVector[16] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 16;
}

/* Default exit sequence for state entry */
void STextKeywordsInStatesAndRegions::exseq_raise_entry()
{
	/* Default exit sequence for state entry */
	stateConfVector[17] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 17;
}

/* Default exit sequence for state exit */
void STextKeywordsInStatesAndRegions::exseq_raise_exit()
{
	/* Default exit sequence for state exit */
	stateConfVector[17] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 17;
}

/* Default exit sequence for state always */
void STextKeywordsInStatesAndRegions::exseq_valueof_always()
{
	/* Default exit sequence for state always */
	stateConfVector[18] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 18;
}

/* Default exit sequence for state oncycle */
void STextKeywordsInStatesAndRegions::exseq_valueof_oncycle()
{
	/* Default exit sequence for state oncycle */
	stateConfVector[18] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 18;
}

/* Default exit sequence for state raise */
void STextKeywordsInStatesAndRegions::exseq_active_raise()
{
	/* Default exit sequence for state raise */
	stateConfVector[19] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 19;
}

/* Default exit sequence for state valueof */
void STextKeywordsInStatesAndRegions::exseq_active_valueof()
{
	/* Default exit sequence for state valueof */
	stateConfVector[19] = STextKeywordsInStatesAndRegions_last_state;
	stateConfVectorPosition = 19;
}

/* Default exit sequence for region default */
void STextKeywordsInStatesAndRegions::exseq_default()
{
	/* Default exit sequence for region default */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.default) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case default_namespace :
		{
			exseq_default_namespace();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region operation */
void STextKeywordsInStatesAndRegions::exseq_operation()
{
	/* Default exit sequence for region operation */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.operation) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case operation_interface :
		{
			exseq_operation_interface();
			break;
		}
		case operation_internal :
		{
			exseq_operation_internal();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region namespace */
void STextKeywordsInStatesAndRegions::exseq_namespace()
{
	/* Default exit sequence for region namespace */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.namespace) at position 2... */
	switch(stateConfVector[ 2 ])
	{
		case namespace_event :
		{
			exseq_namespace_event();
			break;
		}
		case namespace_local :
		{
			exseq_namespace_local();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region local */
void STextKeywordsInStatesAndRegions::exseq_local()
{
	/* Default exit sequence for region local */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.local) at position 3... */
	switch(stateConfVector[ 3 ])
	{
		case local_in :
		{
			exseq_local_in();
			break;
		}
		case local_out :
		{
			exseq_local_out();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region interface */
void STextKeywordsInStatesAndRegions::exseq_interface()
{
	/* Default exit sequence for region interface */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.interface) at position 4... */
	switch(stateConfVector[ 4 ])
	{
		case interface_var :
		{
			exseq_interface_var();
			break;
		}
		case interface_readonly :
		{
			exseq_interface_readonly();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region internal */
void STextKeywordsInStatesAndRegions::exseq_internal()
{
	/* Default exit sequence for region internal */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.internal) at position 5... */
	switch(stateConfVector[ 5 ])
	{
		case internal_external :
		{
			exseq_internal_external();
			break;
		}
		case internal_operation :
		{
			exseq_internal_operation();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region event */
void STextKeywordsInStatesAndRegions::exseq_event()
{
	/* Default exit sequence for region event */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.event) at position 6... */
	switch(stateConfVector[ 6 ])
	{
		case event_default :
		{
			exseq_event_default();
			break;
		}
		case event_else :
		{
			exseq_event_else();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region in */
void STextKeywordsInStatesAndRegions::exseq_in()
{
	/* Default exit sequence for region in */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.in) at position 7... */
	switch(stateConfVector[ 7 ])
	{
		case in_entry :
		{
			exseq_in_entry();
			break;
		}
		case in_exit :
		{
			exseq_in_exit();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region out */
void STextKeywordsInStatesAndRegions::exseq_out()
{
	/* Default exit sequence for region out */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.out) at position 8... */
	switch(stateConfVector[ 8 ])
	{
		case out_always :
		{
			exseq_out_always();
			break;
		}
		case out_oncycle :
		{
			exseq_out_oncycle();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region var */
void STextKeywordsInStatesAndRegions::exseq_var()
{
	/* Default exit sequence for region var */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.var) at position 9... */
	switch(stateConfVector[ 9 ])
	{
		case var_raise :
		{
			exseq_var_raise();
			break;
		}
		case var_valueof :
		{
			exseq_var_valueof();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region readonly */
void STextKeywordsInStatesAndRegions::exseq_readonly()
{
	/* Default exit sequence for region readonly */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.readonly) at position 10... */
	switch(stateConfVector[ 10 ])
	{
		case readonly_active :
		{
			exseq_readonly_active();
			break;
		}
		case readonly_namespace :
		{
			exseq_readonly_namespace();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region external */
void STextKeywordsInStatesAndRegions::exseq_external()
{
	/* Default exit sequence for region external */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.external) at position 11... */
	switch(stateConfVector[ 11 ])
	{
		case external_interface :
		{
			exseq_external_interface();
			break;
		}
		case external_internal :
		{
			exseq_external_internal();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region else */
void STextKeywordsInStatesAndRegions::exseq_else()
{
	/* Default exit sequence for region else */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.else) at position 12... */
	switch(stateConfVector[ 12 ])
	{
		case else_event :
		{
			exseq_else_event();
			break;
		}
		case else_local :
		{
			exseq_else_local();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region entry */
void STextKeywordsInStatesAndRegions::exseq_entry()
{
	/* Default exit sequence for region entry */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.entry) at position 13... */
	switch(stateConfVector[ 13 ])
	{
		case entry_in :
		{
			exseq_entry_in();
			break;
		}
		case entry_out :
		{
			exseq_entry_out();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region exit */
void STextKeywordsInStatesAndRegions::exseq_exit()
{
	/* Default exit sequence for region exit */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.exit) at position 14... */
	switch(stateConfVector[ 14 ])
	{
		case exit_var :
		{
			exseq_exit_var();
			break;
		}
		case exit_readonly :
		{
			exseq_exit_readonly();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region always */
void STextKeywordsInStatesAndRegions::exseq_always()
{
	/* Default exit sequence for region always */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.always) at position 15... */
	switch(stateConfVector[ 15 ])
	{
		case always_external :
		{
			exseq_always_external();
			break;
		}
		case always_operation :
		{
			exseq_always_operation();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region oncycle */
void STextKeywordsInStatesAndRegions::exseq_oncycle()
{
	/* Default exit sequence for region oncycle */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.oncycle) at position 16... */
	switch(stateConfVector[ 16 ])
	{
		case oncycle_default :
		{
			exseq_oncycle_default();
			break;
		}
		case oncycle_else :
		{
			exseq_oncycle_else();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region raise */
void STextKeywordsInStatesAndRegions::exseq_raise()
{
	/* Default exit sequence for region raise */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.raise) at position 17... */
	switch(stateConfVector[ 17 ])
	{
		case raise_entry :
		{
			exseq_raise_entry();
			break;
		}
		case raise_exit :
		{
			exseq_raise_exit();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region valueof */
void STextKeywordsInStatesAndRegions::exseq_valueof()
{
	/* Default exit sequence for region valueof */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.valueof) at position 18... */
	switch(stateConfVector[ 18 ])
	{
		case valueof_always :
		{
			exseq_valueof_always();
			break;
		}
		case valueof_oncycle :
		{
			exseq_valueof_oncycle();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region active */
void STextKeywordsInStatesAndRegions::exseq_active()
{
	/* Default exit sequence for region active */
	/* Handle exit of all possible states (of STextKeywordsInStatesAndRegions.active) at position 19... */
	switch(stateConfVector[ 19 ])
	{
		case active_raise :
		{
			exseq_active_raise();
			break;
		}
		case active_valueof :
		{
			exseq_active_valueof();
			break;
		}
		default: break;
	}
}

/* The reactions of state namespace. */
void STextKeywordsInStatesAndRegions::react_default_namespace()
{
	/* The reactions of state namespace. */
}

/* The reactions of state interface. */
void STextKeywordsInStatesAndRegions::react_operation_interface()
{
	/* The reactions of state interface. */
	if (check_operation_interface_tr0_tr0())
	{ 
		effect_operation_interface_tr0();
	} 
}

/* The reactions of state internal. */
void STextKeywordsInStatesAndRegions::react_operation_internal()
{
}

/* The reactions of state event. */
void STextKeywordsInStatesAndRegions::react_namespace_event()
{
	/* The reactions of state event. */
	if (check_namespace_event_tr0_tr0())
	{ 
		effect_namespace_event_tr0();
	} 
}

/* The reactions of state local. */
void STextKeywordsInStatesAndRegions::react_namespace_local()
{
}

/* The reactions of state in. */
void STextKeywordsInStatesAndRegions::react_local_in()
{
	/* The reactions of state in. */
	if (check_local_in_tr0_tr0())
	{ 
		effect_local_in_tr0();
	} 
}

/* The reactions of state out. */
void STextKeywordsInStatesAndRegions::react_local_out()
{
}

/* The reactions of state var. */
void STextKeywordsInStatesAndRegions::react_interface_var()
{
	/* The reactions of state var. */
	if (check_interface_var_tr0_tr0())
	{ 
		effect_interface_var_tr0();
	} 
}

/* The reactions of state readonly. */
void STextKeywordsInStatesAndRegions::react_interface_readonly()
{
}

/* The reactions of state external. */
void STextKeywordsInStatesAndRegions::react_internal_external()
{
	/* The reactions of state external. */
	if (check_internal_external_tr0_tr0())
	{ 
		effect_internal_external_tr0();
	} 
}

/* The reactions of state operation. */
void STextKeywordsInStatesAndRegions::react_internal_operation()
{
}

/* The reactions of state default. */
void STextKeywordsInStatesAndRegions::react_event_default()
{
	/* The reactions of state default. */
	if (check_event_default_tr0_tr0())
	{ 
		effect_event_default_tr0();
	} 
}

/* The reactions of state else. */
void STextKeywordsInStatesAndRegions::react_event_else()
{
}

/* The reactions of state entry. */
void STextKeywordsInStatesAndRegions::react_in_entry()
{
	/* The reactions of state entry. */
	if (check_in_entry_tr0_tr0())
	{ 
		effect_in_entry_tr0();
	} 
}

/* The reactions of state exit. */
void STextKeywordsInStatesAndRegions::react_in_exit()
{
}

/* The reactions of state always. */
void STextKeywordsInStatesAndRegions::react_out_always()
{
	/* The reactions of state always. */
	if (check_out_always_tr0_tr0())
	{ 
		effect_out_always_tr0();
	} 
}

/* The reactions of state oncycle. */
void STextKeywordsInStatesAndRegions::react_out_oncycle()
{
}

/* The reactions of state raise. */
void STextKeywordsInStatesAndRegions::react_var_raise()
{
	/* The reactions of state raise. */
	if (check_var_raise_tr0_tr0())
	{ 
		effect_var_raise_tr0();
	} 
}

/* The reactions of state valueof. */
void STextKeywordsInStatesAndRegions::react_var_valueof()
{
}

/* The reactions of state active. */
void STextKeywordsInStatesAndRegions::react_readonly_active()
{
	/* The reactions of state active. */
	if (check_readonly_active_tr0_tr0())
	{ 
		effect_readonly_active_tr0();
	} 
}

/* The reactions of state namespace. */
void STextKeywordsInStatesAndRegions::react_readonly_namespace()
{
}

/* The reactions of state interface. */
void STextKeywordsInStatesAndRegions::react_external_interface()
{
	/* The reactions of state interface. */
	if (check_external_interface_tr0_tr0())
	{ 
		effect_external_interface_tr0();
	} 
}

/* The reactions of state internal. */
void STextKeywordsInStatesAndRegions::react_external_internal()
{
}

/* The reactions of state event. */
void STextKeywordsInStatesAndRegions::react_else_event()
{
	/* The reactions of state event. */
	if (check_else_event_tr0_tr0())
	{ 
		effect_else_event_tr0();
	} 
}

/* The reactions of state local. */
void STextKeywordsInStatesAndRegions::react_else_local()
{
}

/* The reactions of state in. */
void STextKeywordsInStatesAndRegions::react_entry_in()
{
	/* The reactions of state in. */
	if (check_entry_in_tr0_tr0())
	{ 
		effect_entry_in_tr0();
	} 
}

/* The reactions of state out. */
void STextKeywordsInStatesAndRegions::react_entry_out()
{
}

/* The reactions of state var. */
void STextKeywordsInStatesAndRegions::react_exit_var()
{
	/* The reactions of state var. */
	if (check_exit_var_tr0_tr0())
	{ 
		effect_exit_var_tr0();
	} 
}

/* The reactions of state readonly. */
void STextKeywordsInStatesAndRegions::react_exit_readonly()
{
}

/* The reactions of state external. */
void STextKeywordsInStatesAndRegions::react_always_external()
{
	/* The reactions of state external. */
	if (check_always_external_tr0_tr0())
	{ 
		effect_always_external_tr0();
	} 
}

/* The reactions of state operation. */
void STextKeywordsInStatesAndRegions::react_always_operation()
{
}

/* The reactions of state default. */
void STextKeywordsInStatesAndRegions::react_oncycle_default()
{
	/* The reactions of state default. */
	if (check_oncycle_default_tr0_tr0())
	{ 
		effect_oncycle_default_tr0();
	} 
}

/* The reactions of state else. */
void STextKeywordsInStatesAndRegions::react_oncycle_else()
{
}

/* The reactions of state entry. */
void STextKeywordsInStatesAndRegions::react_raise_entry()
{
	/* The reactions of state entry. */
	if (check_raise_entry_tr0_tr0())
	{ 
		effect_raise_entry_tr0();
	} 
}

/* The reactions of state exit. */
void STextKeywordsInStatesAndRegions::react_raise_exit()
{
}

/* The reactions of state always. */
void STextKeywordsInStatesAndRegions::react_valueof_always()
{
	/* The reactions of state always. */
	if (check_valueof_always_tr0_tr0())
	{ 
		effect_valueof_always_tr0();
	} 
}

/* The reactions of state oncycle. */
void STextKeywordsInStatesAndRegions::react_valueof_oncycle()
{
}

/* The reactions of state raise. */
void STextKeywordsInStatesAndRegions::react_active_raise()
{
	/* The reactions of state raise. */
	if (check_active_raise_tr0_tr0())
	{ 
		effect_active_raise_tr0();
	} 
}

/* The reactions of state valueof. */
void STextKeywordsInStatesAndRegions::react_active_valueof()
{
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_default__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_default_namespace_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_operation__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_operation_interface_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_namespace__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_namespace_event_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_local__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_local_in_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_interface__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_interface_var_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_internal__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_internal_external_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_event__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_event_default_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_in__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_in_entry_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_out__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_out_always_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_var__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_var_raise_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_readonly__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_readonly_active_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_external__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_external_interface_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_else__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_else_event_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_entry__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_entry_in_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_exit__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_exit_var_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_always__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_always_external_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_oncycle__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_oncycle_default_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_raise__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_raise_entry_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_valueof__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_valueof_always_default();
}

/* Default react sequence for initial entry  */
void STextKeywordsInStatesAndRegions::react_active__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_active_raise_default();
}


