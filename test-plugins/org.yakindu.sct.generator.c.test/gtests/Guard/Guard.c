
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "Guard.h"
/*! \file Implementation of the state machine 'Guard'
*/

/* prototypes of all internal functions */
static sc_boolean guard_check_main_region_A_tr0_tr0(const Guard* handle);
static sc_boolean guard_check_main_region_A_tr1_tr1(const Guard* handle);
static sc_boolean guard_check_main_region_B_tr0_tr0(const Guard* handle);
static void guard_effect_main_region_A_tr0(Guard* handle);
static void guard_effect_main_region_A_tr1(Guard* handle);
static void guard_effect_main_region_B_tr0(Guard* handle);
static void guard_enact_main_region_B(Guard* handle);
static void guard_enseq_main_region_A_default(Guard* handle);
static void guard_enseq_main_region_B_default(Guard* handle);
static void guard_enseq_main_region_default(Guard* handle);
static void guard_exseq_main_region_A(Guard* handle);
static void guard_exseq_main_region_B(Guard* handle);
static void guard_exseq_main_region(Guard* handle);
static void guard_react_main_region_A(Guard* handle);
static void guard_react_main_region_B(Guard* handle);
static void guard_react_main_region__entry_Default(Guard* handle);
static void guard_clearInEvents(Guard* handle);
static void guard_clearOutEvents(Guard* handle);


void guard_init(Guard* handle)
{
	sc_integer i;

	for (i = 0; i < GUARD_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = Guard_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	guard_clearInEvents(handle);
	guard_clearOutEvents(handle);

	/* Default init sequence for statechart Guard */
	handle->iface.MyVar = 0;

}

void guard_enter(Guard* handle)
{
	/* Default enter sequence for statechart Guard */
	guard_enseq_main_region_default(handle);
}

void guard_exit(Guard* handle)
{
	/* Default exit sequence for statechart Guard */
	guard_exseq_main_region(handle);
}

sc_boolean guard_isActive(const Guard* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < GUARD_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != Guard_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean guard_isFinal(const Guard* handle)
{
   return bool_false;
}

static void guard_clearInEvents(Guard* handle)
{
	handle->iface.Event1_raised = bool_false;
	handle->iface.Event2_raised = bool_false;
	handle->iface.Return_raised = bool_false;
}

static void guard_clearOutEvents(Guard* handle)
{
}

void guard_runCycle(Guard* handle)
{
	
	guard_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < GUARD_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case Guard_main_region_A :
		{
			guard_react_main_region_A(handle);
			break;
		}
		case Guard_main_region_B :
		{
			guard_react_main_region_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	guard_clearInEvents(handle);
}


sc_boolean guard_isStateActive(const Guard* handle, GuardStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case Guard_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_GUARD_MAIN_REGION_A] == Guard_main_region_A
			);
			break;
		case Guard_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_GUARD_MAIN_REGION_B] == Guard_main_region_B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void guardIface_raise_event1(Guard* handle)
{
	handle->iface.Event1_raised = bool_true;
}
void guardIface_raise_event2(Guard* handle)
{
	handle->iface.Event2_raised = bool_true;
}
void guardIface_raise_return(Guard* handle)
{
	handle->iface.Return_raised = bool_true;
}


sc_integer guardIface_get_myVar(const Guard* handle)
{
	return handle->iface.MyVar;
}
void guardIface_set_myVar(Guard* handle, sc_integer value)
{
	handle->iface.MyVar = value;
}

/* implementations of all internal functions */

static sc_boolean guard_check_main_region_A_tr0_tr0(const Guard* handle)
{
	return ((handle->iface.Event1_raised) && (handle->iface.MyVar == 10)) ? bool_true : bool_false;
}

static sc_boolean guard_check_main_region_A_tr1_tr1(const Guard* handle)
{
	return handle->iface.Event2_raised;
}

static sc_boolean guard_check_main_region_B_tr0_tr0(const Guard* handle)
{
	return handle->iface.Return_raised;
}

static void guard_effect_main_region_A_tr0(Guard* handle)
{
	guard_exseq_main_region_A(handle);
	guard_enseq_main_region_B_default(handle);
}

static void guard_effect_main_region_A_tr1(Guard* handle)
{
	guard_exseq_main_region_A(handle);
	guard_enseq_main_region_B_default(handle);
}

static void guard_effect_main_region_B_tr0(Guard* handle)
{
	guard_exseq_main_region_B(handle);
	guard_enseq_main_region_A_default(handle);
}

/* Entry action for state 'B'. */
static void guard_enact_main_region_B(Guard* handle)
{
	/* Entry action for state 'B'. */
	handle->iface.MyVar = 10;
}

/* 'default' enter sequence for state A */
static void guard_enseq_main_region_A_default(Guard* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = Guard_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void guard_enseq_main_region_B_default(Guard* handle)
{
	/* 'default' enter sequence for state B */
	guard_enact_main_region_B(handle);
	handle->stateConfVector[0] = Guard_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void guard_enseq_main_region_default(Guard* handle)
{
	/* 'default' enter sequence for region main region */
	guard_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void guard_exseq_main_region_A(Guard* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = Guard_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void guard_exseq_main_region_B(Guard* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = Guard_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void guard_exseq_main_region(Guard* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of Guard.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case Guard_main_region_A :
		{
			guard_exseq_main_region_A(handle);
			break;
		}
		case Guard_main_region_B :
		{
			guard_exseq_main_region_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void guard_react_main_region_A(Guard* handle)
{
	/* The reactions of state A. */
	if (guard_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		guard_effect_main_region_A_tr0(handle);
	}  else
	{
		if (guard_check_main_region_A_tr1_tr1(handle) == bool_true)
		{ 
			guard_effect_main_region_A_tr1(handle);
		} 
	}
}

/* The reactions of state B. */
static void guard_react_main_region_B(Guard* handle)
{
	/* The reactions of state B. */
	if (guard_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		guard_effect_main_region_B_tr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void guard_react_main_region__entry_Default(Guard* handle)
{
	/* Default react sequence for initial entry  */
	guard_enseq_main_region_A_default(handle);
}


