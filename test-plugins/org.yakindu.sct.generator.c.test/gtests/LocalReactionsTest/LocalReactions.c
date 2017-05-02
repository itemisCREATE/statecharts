
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "LocalReactions.h"
/*! \file Implementation of the state machine 'LocalReactions'
*/

/* prototypes of all internal functions */
static sc_boolean localReactions_check_main_region_A_lr0_lr0(const LocalReactions* handle);
static void localReactions_effect_main_region_A_lr0_lr0(LocalReactions* handle);
static void localReactions_enseq_main_region_A_default(LocalReactions* handle);
static void localReactions_enseq_main_region_default(LocalReactions* handle);
static void localReactions_exseq_main_region_A(LocalReactions* handle);
static void localReactions_exseq_main_region(LocalReactions* handle);
static void localReactions_react_main_region_A(LocalReactions* handle);
static void localReactions_react_main_region__entry_Default(LocalReactions* handle);
static void localReactions_clearInEvents(LocalReactions* handle);
static void localReactions_clearOutEvents(LocalReactions* handle);


void localReactions_init(LocalReactions* handle)
{
	sc_integer i;

	for (i = 0; i < LOCALREACTIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = LocalReactions_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	localReactions_clearInEvents(handle);
	localReactions_clearOutEvents(handle);

	/* Default init sequence for statechart LocalReactions */
	handle->iface.x = 0;

}

void localReactions_enter(LocalReactions* handle)
{
	/* Default enter sequence for statechart LocalReactions */
	localReactions_enseq_main_region_default(handle);
}

void localReactions_exit(LocalReactions* handle)
{
	/* Default exit sequence for statechart LocalReactions */
	localReactions_exseq_main_region(handle);
}

sc_boolean localReactions_isActive(const LocalReactions* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != LocalReactions_last_state)
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
sc_boolean localReactions_isFinal(const LocalReactions* handle)
{
   return bool_false;
}

static void localReactions_clearInEvents(LocalReactions* handle)
{
}

static void localReactions_clearOutEvents(LocalReactions* handle)
{
}

void localReactions_runCycle(LocalReactions* handle)
{
	
	localReactions_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < LOCALREACTIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case LocalReactions_main_region_A :
		{
			localReactions_react_main_region_A(handle);
			break;
		}
		default:
			break;
		}
	}
	
	localReactions_clearInEvents(handle);
}


sc_boolean localReactions_isStateActive(const LocalReactions* handle, LocalReactionsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case LocalReactions_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == LocalReactions_main_region_A
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}



sc_integer localReactionsIface_get_x(const LocalReactions* handle)
{
	return handle->iface.x;
}
void localReactionsIface_set_x(LocalReactions* handle, sc_integer value)
{
	handle->iface.x = value;
}

/* implementations of all internal functions */

static sc_boolean localReactions_check_main_region_A_lr0_lr0(const LocalReactions* handle)
{
	return (handle->iface.x == 0) ? bool_true : bool_false;
}

static void localReactions_effect_main_region_A_lr0_lr0(LocalReactions* handle)
{
	handle->iface.x += 1;
}

/* 'default' enter sequence for state A */
static void localReactions_enseq_main_region_A_default(LocalReactions* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = LocalReactions_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void localReactions_enseq_main_region_default(LocalReactions* handle)
{
	/* 'default' enter sequence for region main region */
	localReactions_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void localReactions_exseq_main_region_A(LocalReactions* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = LocalReactions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void localReactions_exseq_main_region(LocalReactions* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of LocalReactions.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case LocalReactions_main_region_A :
		{
			localReactions_exseq_main_region_A(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void localReactions_react_main_region_A(LocalReactions* handle)
{
	/* The reactions of state A. */
	if (localReactions_check_main_region_A_lr0_lr0(handle) == bool_true)
	{ 
		localReactions_effect_main_region_A_lr0_lr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void localReactions_react_main_region__entry_Default(LocalReactions* handle)
{
	/* Default react sequence for initial entry  */
	localReactions_enseq_main_region_A_default(handle);
}


