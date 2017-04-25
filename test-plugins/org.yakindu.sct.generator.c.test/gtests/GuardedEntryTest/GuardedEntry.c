
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "GuardedEntry.h"
/*! \file Implementation of the state machine 'GuardedEntry'
*/

/* prototypes of all internal functions */
static sc_boolean guardedEntry_check_main_region_A_tr0_tr0(const GuardedEntry* handle);
static sc_boolean guardedEntry_check_main_region_B_tr0_tr0(const GuardedEntry* handle);
static void guardedEntry_effect_main_region_A_tr0(GuardedEntry* handle);
static void guardedEntry_effect_main_region_B_tr0(GuardedEntry* handle);
static void guardedEntry_enact_main_region_A(GuardedEntry* handle);
static void guardedEntry_enseq_main_region_A_default(GuardedEntry* handle);
static void guardedEntry_enseq_main_region_B_default(GuardedEntry* handle);
static void guardedEntry_enseq_main_region_default(GuardedEntry* handle);
static void guardedEntry_exseq_main_region_A(GuardedEntry* handle);
static void guardedEntry_exseq_main_region_B(GuardedEntry* handle);
static void guardedEntry_exseq_main_region(GuardedEntry* handle);
static void guardedEntry_react_main_region_A(GuardedEntry* handle);
static void guardedEntry_react_main_region_B(GuardedEntry* handle);
static void guardedEntry_react_main_region__entry_Default(GuardedEntry* handle);
static void guardedEntry_clearInEvents(GuardedEntry* handle);
static void guardedEntry_clearOutEvents(GuardedEntry* handle);


void guardedEntry_init(GuardedEntry* handle)
{
	sc_integer i;

	for (i = 0; i < GUARDEDENTRY_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = GuardedEntry_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	guardedEntry_clearInEvents(handle);
	guardedEntry_clearOutEvents(handle);

	/* Default init sequence for statechart GuardedEntry */
	handle->iface.guard = bool_false;
	handle->iface.done = bool_false;

}

void guardedEntry_enter(GuardedEntry* handle)
{
	/* Default enter sequence for statechart GuardedEntry */
	guardedEntry_enseq_main_region_default(handle);
}

void guardedEntry_exit(GuardedEntry* handle)
{
	/* Default exit sequence for statechart GuardedEntry */
	guardedEntry_exseq_main_region(handle);
}

sc_boolean guardedEntry_isActive(const GuardedEntry* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != GuardedEntry_last_state)
	{
		result =  bool_true;
	}
	else
	{
		result = bool_false;
	}
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean guardedEntry_isFinal(const GuardedEntry* handle)
{
   return bool_false;
}

static void guardedEntry_clearInEvents(GuardedEntry* handle)
{
	handle->iface.e_raised = bool_false;
}

static void guardedEntry_clearOutEvents(GuardedEntry* handle)
{
}

void guardedEntry_runCycle(GuardedEntry* handle)
{
	
	guardedEntry_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < GUARDEDENTRY_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case GuardedEntry_main_region_A :
		{
			guardedEntry_react_main_region_A(handle);
			break;
		}
		case GuardedEntry_main_region_B :
		{
			guardedEntry_react_main_region_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	guardedEntry_clearInEvents(handle);
}


sc_boolean guardedEntry_isStateActive(const GuardedEntry* handle, GuardedEntryStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case GuardedEntry_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == GuardedEntry_main_region_A
			);
			break;
		case GuardedEntry_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[0] == GuardedEntry_main_region_B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void guardedEntryIface_raise_e(GuardedEntry* handle)
{
	handle->iface.e_raised = bool_true;
}


sc_boolean guardedEntryIface_get_guard(const GuardedEntry* handle)
{
	return handle->iface.guard;
}
void guardedEntryIface_set_guard(GuardedEntry* handle, sc_boolean value)
{
	handle->iface.guard = value;
}
sc_boolean guardedEntryIface_get_done(const GuardedEntry* handle)
{
	return handle->iface.done;
}
void guardedEntryIface_set_done(GuardedEntry* handle, sc_boolean value)
{
	handle->iface.done = value;
}

/* implementations of all internal functions */

static sc_boolean guardedEntry_check_main_region_A_tr0_tr0(const GuardedEntry* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean guardedEntry_check_main_region_B_tr0_tr0(const GuardedEntry* handle)
{
	return handle->iface.e_raised;
}

static void guardedEntry_effect_main_region_A_tr0(GuardedEntry* handle)
{
	guardedEntry_exseq_main_region_A(handle);
	guardedEntry_enseq_main_region_B_default(handle);
}

static void guardedEntry_effect_main_region_B_tr0(GuardedEntry* handle)
{
	guardedEntry_exseq_main_region_B(handle);
	guardedEntry_enseq_main_region_A_default(handle);
}

/* Entry action for state 'A'. */
static void guardedEntry_enact_main_region_A(GuardedEntry* handle)
{
	/* Entry action for state 'A'. */
	if (handle->iface.guard == bool_true)
	{ 
		handle->iface.done = bool_true;
	} 
}

/* 'default' enter sequence for state A */
static void guardedEntry_enseq_main_region_A_default(GuardedEntry* handle)
{
	/* 'default' enter sequence for state A */
	guardedEntry_enact_main_region_A(handle);
	handle->stateConfVector[0] = GuardedEntry_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void guardedEntry_enseq_main_region_B_default(GuardedEntry* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = GuardedEntry_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void guardedEntry_enseq_main_region_default(GuardedEntry* handle)
{
	/* 'default' enter sequence for region main region */
	guardedEntry_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void guardedEntry_exseq_main_region_A(GuardedEntry* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = GuardedEntry_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void guardedEntry_exseq_main_region_B(GuardedEntry* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = GuardedEntry_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void guardedEntry_exseq_main_region(GuardedEntry* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of GuardedEntry.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case GuardedEntry_main_region_A :
		{
			guardedEntry_exseq_main_region_A(handle);
			break;
		}
		case GuardedEntry_main_region_B :
		{
			guardedEntry_exseq_main_region_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void guardedEntry_react_main_region_A(GuardedEntry* handle)
{
	/* The reactions of state A. */
	if (guardedEntry_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		guardedEntry_effect_main_region_A_tr0(handle);
	} 
}

/* The reactions of state B. */
static void guardedEntry_react_main_region_B(GuardedEntry* handle)
{
	/* The reactions of state B. */
	if (guardedEntry_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		guardedEntry_effect_main_region_B_tr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void guardedEntry_react_main_region__entry_Default(GuardedEntry* handle)
{
	/* Default react sequence for initial entry  */
	guardedEntry_enseq_main_region_A_default(handle);
}


