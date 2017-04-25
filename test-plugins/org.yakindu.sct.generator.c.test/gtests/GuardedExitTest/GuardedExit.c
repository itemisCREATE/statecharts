
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "GuardedExit.h"
/*! \file Implementation of the state machine 'GuardedExit'
*/

/* prototypes of all internal functions */
static sc_boolean guardedExit_check_main_region_A_tr0_tr0(const GuardedExit* handle);
static sc_boolean guardedExit_check_main_region_B_tr0_tr0(const GuardedExit* handle);
static void guardedExit_effect_main_region_A_tr0(GuardedExit* handle);
static void guardedExit_effect_main_region_B_tr0(GuardedExit* handle);
static void guardedExit_exact_main_region_A(GuardedExit* handle);
static void guardedExit_enseq_main_region_A_default(GuardedExit* handle);
static void guardedExit_enseq_main_region_B_default(GuardedExit* handle);
static void guardedExit_enseq_main_region_default(GuardedExit* handle);
static void guardedExit_exseq_main_region_A(GuardedExit* handle);
static void guardedExit_exseq_main_region_B(GuardedExit* handle);
static void guardedExit_exseq_main_region(GuardedExit* handle);
static void guardedExit_react_main_region_A(GuardedExit* handle);
static void guardedExit_react_main_region_B(GuardedExit* handle);
static void guardedExit_react_main_region__entry_Default(GuardedExit* handle);
static void guardedExit_clearInEvents(GuardedExit* handle);
static void guardedExit_clearOutEvents(GuardedExit* handle);


void guardedExit_init(GuardedExit* handle)
{
	sc_integer i;

	for (i = 0; i < GUARDEDEXIT_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = GuardedExit_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	guardedExit_clearInEvents(handle);
	guardedExit_clearOutEvents(handle);

	/* Default init sequence for statechart GuardedExit */
	handle->iface.guard = bool_false;
	handle->iface.done = bool_false;

}

void guardedExit_enter(GuardedExit* handle)
{
	/* Default enter sequence for statechart GuardedExit */
	guardedExit_enseq_main_region_default(handle);
}

void guardedExit_exit(GuardedExit* handle)
{
	/* Default exit sequence for statechart GuardedExit */
	guardedExit_exseq_main_region(handle);
}

sc_boolean guardedExit_isActive(const GuardedExit* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != GuardedExit_last_state)
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
sc_boolean guardedExit_isFinal(const GuardedExit* handle)
{
   return bool_false;
}

static void guardedExit_clearInEvents(GuardedExit* handle)
{
	handle->iface.e_raised = bool_false;
}

static void guardedExit_clearOutEvents(GuardedExit* handle)
{
}

void guardedExit_runCycle(GuardedExit* handle)
{
	
	guardedExit_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < GUARDEDEXIT_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case GuardedExit_main_region_A :
		{
			guardedExit_react_main_region_A(handle);
			break;
		}
		case GuardedExit_main_region_B :
		{
			guardedExit_react_main_region_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	guardedExit_clearInEvents(handle);
}


sc_boolean guardedExit_isStateActive(const GuardedExit* handle, GuardedExitStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case GuardedExit_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == GuardedExit_main_region_A
			);
			break;
		case GuardedExit_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[0] == GuardedExit_main_region_B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void guardedExitIface_raise_e(GuardedExit* handle)
{
	handle->iface.e_raised = bool_true;
}


sc_boolean guardedExitIface_get_guard(const GuardedExit* handle)
{
	return handle->iface.guard;
}
void guardedExitIface_set_guard(GuardedExit* handle, sc_boolean value)
{
	handle->iface.guard = value;
}
sc_boolean guardedExitIface_get_done(const GuardedExit* handle)
{
	return handle->iface.done;
}
void guardedExitIface_set_done(GuardedExit* handle, sc_boolean value)
{
	handle->iface.done = value;
}

/* implementations of all internal functions */

static sc_boolean guardedExit_check_main_region_A_tr0_tr0(const GuardedExit* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean guardedExit_check_main_region_B_tr0_tr0(const GuardedExit* handle)
{
	return handle->iface.e_raised;
}

static void guardedExit_effect_main_region_A_tr0(GuardedExit* handle)
{
	guardedExit_exseq_main_region_A(handle);
	guardedExit_enseq_main_region_B_default(handle);
}

static void guardedExit_effect_main_region_B_tr0(GuardedExit* handle)
{
	guardedExit_exseq_main_region_B(handle);
	guardedExit_enseq_main_region_A_default(handle);
}

/* Exit action for state 'A'. */
static void guardedExit_exact_main_region_A(GuardedExit* handle)
{
	/* Exit action for state 'A'. */
	if (handle->iface.guard == bool_true)
	{ 
		handle->iface.done = bool_true;
	} 
}

/* 'default' enter sequence for state A */
static void guardedExit_enseq_main_region_A_default(GuardedExit* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = GuardedExit_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void guardedExit_enseq_main_region_B_default(GuardedExit* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = GuardedExit_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void guardedExit_enseq_main_region_default(GuardedExit* handle)
{
	/* 'default' enter sequence for region main region */
	guardedExit_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void guardedExit_exseq_main_region_A(GuardedExit* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = GuardedExit_last_state;
	handle->stateConfVectorPosition = 0;
	guardedExit_exact_main_region_A(handle);
}

/* Default exit sequence for state B */
static void guardedExit_exseq_main_region_B(GuardedExit* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = GuardedExit_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void guardedExit_exseq_main_region(GuardedExit* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of GuardedExit.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case GuardedExit_main_region_A :
		{
			guardedExit_exseq_main_region_A(handle);
			break;
		}
		case GuardedExit_main_region_B :
		{
			guardedExit_exseq_main_region_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void guardedExit_react_main_region_A(GuardedExit* handle)
{
	/* The reactions of state A. */
	if (guardedExit_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		guardedExit_effect_main_region_A_tr0(handle);
	} 
}

/* The reactions of state B. */
static void guardedExit_react_main_region_B(GuardedExit* handle)
{
	/* The reactions of state B. */
	if (guardedExit_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		guardedExit_effect_main_region_B_tr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void guardedExit_react_main_region__entry_Default(GuardedExit* handle)
{
	/* Default react sequence for initial entry  */
	guardedExit_enseq_main_region_A_default(handle);
}


