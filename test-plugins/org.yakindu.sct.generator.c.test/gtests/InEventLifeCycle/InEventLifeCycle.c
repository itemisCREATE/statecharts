
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "InEventLifeCycle.h"
/*! \file Implementation of the state machine 'InEventLifeCycle'
*/

/* prototypes of all internal functions */
static sc_boolean inEventLifeCycle_check_main_region_A_lr0_lr0(const InEventLifeCycle* handle);
static void inEventLifeCycle_effect_main_region_A_lr0_lr0(InEventLifeCycle* handle);
static void inEventLifeCycle_enseq_main_region_A_default(InEventLifeCycle* handle);
static void inEventLifeCycle_enseq_main_region_default(InEventLifeCycle* handle);
static void inEventLifeCycle_exseq_main_region_A(InEventLifeCycle* handle);
static void inEventLifeCycle_exseq_main_region(InEventLifeCycle* handle);
static void inEventLifeCycle_react_main_region_A(InEventLifeCycle* handle);
static void inEventLifeCycle_react_main_region__entry_Default(InEventLifeCycle* handle);
static void inEventLifeCycle_clearInEvents(InEventLifeCycle* handle);
static void inEventLifeCycle_clearOutEvents(InEventLifeCycle* handle);


void inEventLifeCycle_init(InEventLifeCycle* handle)
{
	sc_integer i;

	for (i = 0; i < INEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = InEventLifeCycle_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	inEventLifeCycle_clearInEvents(handle);
	inEventLifeCycle_clearOutEvents(handle);

	/* Default init sequence for statechart InEventLifeCycle */
	handle->iface.i = 0;

}

void inEventLifeCycle_enter(InEventLifeCycle* handle)
{
	/* Default enter sequence for statechart InEventLifeCycle */
	inEventLifeCycle_enseq_main_region_default(handle);
}

void inEventLifeCycle_exit(InEventLifeCycle* handle)
{
	/* Default exit sequence for statechart InEventLifeCycle */
	inEventLifeCycle_exseq_main_region(handle);
}

sc_boolean inEventLifeCycle_isActive(const InEventLifeCycle* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < INEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != InEventLifeCycle_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean inEventLifeCycle_isFinal(const InEventLifeCycle* handle)
{
   return bool_false;
}

static void inEventLifeCycle_clearInEvents(InEventLifeCycle* handle)
{
	handle->iface.e_raised = bool_false;
}

static void inEventLifeCycle_clearOutEvents(InEventLifeCycle* handle)
{
}

void inEventLifeCycle_runCycle(InEventLifeCycle* handle)
{
	
	inEventLifeCycle_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < INEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case InEventLifeCycle_main_region_A :
		{
			inEventLifeCycle_react_main_region_A(handle);
			break;
		}
		default:
			break;
		}
	}
	
	inEventLifeCycle_clearInEvents(handle);
}


sc_boolean inEventLifeCycle_isStateActive(const InEventLifeCycle* handle, InEventLifeCycleStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case InEventLifeCycle_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_INEVENTLIFECYCLE_MAIN_REGION_A] == InEventLifeCycle_main_region_A
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void inEventLifeCycleIface_raise_e(InEventLifeCycle* handle)
{
	handle->iface.e_raised = bool_true;
}


sc_integer inEventLifeCycleIface_get_i(const InEventLifeCycle* handle)
{
	return handle->iface.i;
}
void inEventLifeCycleIface_set_i(InEventLifeCycle* handle, sc_integer value)
{
	handle->iface.i = value;
}

/* implementations of all internal functions */

static sc_boolean inEventLifeCycle_check_main_region_A_lr0_lr0(const InEventLifeCycle* handle)
{
	return handle->iface.e_raised;
}

static void inEventLifeCycle_effect_main_region_A_lr0_lr0(InEventLifeCycle* handle)
{
	handle->iface.i += 1;
}

/* 'default' enter sequence for state A */
static void inEventLifeCycle_enseq_main_region_A_default(InEventLifeCycle* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = InEventLifeCycle_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void inEventLifeCycle_enseq_main_region_default(InEventLifeCycle* handle)
{
	/* 'default' enter sequence for region main region */
	inEventLifeCycle_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void inEventLifeCycle_exseq_main_region_A(InEventLifeCycle* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = InEventLifeCycle_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void inEventLifeCycle_exseq_main_region(InEventLifeCycle* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of InEventLifeCycle.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case InEventLifeCycle_main_region_A :
		{
			inEventLifeCycle_exseq_main_region_A(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void inEventLifeCycle_react_main_region_A(InEventLifeCycle* handle)
{
	/* The reactions of state A. */
	if (inEventLifeCycle_check_main_region_A_lr0_lr0(handle) == bool_true)
	{ 
		inEventLifeCycle_effect_main_region_A_lr0_lr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void inEventLifeCycle_react_main_region__entry_Default(InEventLifeCycle* handle)
{
	/* Default react sequence for initial entry  */
	inEventLifeCycle_enseq_main_region_A_default(handle);
}


