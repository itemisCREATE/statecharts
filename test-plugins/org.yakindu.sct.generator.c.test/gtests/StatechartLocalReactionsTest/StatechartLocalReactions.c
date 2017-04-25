
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "StatechartLocalReactions.h"
/*! \file Implementation of the state machine 'StatechartLocalReactions'
*/

/* prototypes of all internal functions */
static sc_boolean statechartLocalReactions_check__lr0(const StatechartLocalReactions* handle);
static sc_boolean statechartLocalReactions_check__lr1(const StatechartLocalReactions* handle);
static sc_boolean statechartLocalReactions_check_main_region_S1_tr0_tr0(const StatechartLocalReactions* handle);
static sc_boolean statechartLocalReactions_check_main_region_S2_tr0_tr0(const StatechartLocalReactions* handle);
static void statechartLocalReactions_effect__lr0(StatechartLocalReactions* handle);
static void statechartLocalReactions_effect__lr1(StatechartLocalReactions* handle);
static void statechartLocalReactions_effect_main_region_S1_tr0(StatechartLocalReactions* handle);
static void statechartLocalReactions_effect_main_region_S2_tr0(StatechartLocalReactions* handle);
static void statechartLocalReactions_enseq_main_region_S1_default(StatechartLocalReactions* handle);
static void statechartLocalReactions_enseq_main_region_S2_default(StatechartLocalReactions* handle);
static void statechartLocalReactions_enseq_region2_a_default(StatechartLocalReactions* handle);
static void statechartLocalReactions_enseq_main_region_default(StatechartLocalReactions* handle);
static void statechartLocalReactions_enseq_region2_default(StatechartLocalReactions* handle);
static void statechartLocalReactions_exseq_main_region_S1(StatechartLocalReactions* handle);
static void statechartLocalReactions_exseq_main_region_S2(StatechartLocalReactions* handle);
static void statechartLocalReactions_exseq_region2_a(StatechartLocalReactions* handle);
static void statechartLocalReactions_exseq_main_region(StatechartLocalReactions* handle);
static void statechartLocalReactions_exseq_region2(StatechartLocalReactions* handle);
static void statechartLocalReactions_react_main_region_S1(StatechartLocalReactions* handle);
static void statechartLocalReactions_react_main_region_S2(StatechartLocalReactions* handle);
static void statechartLocalReactions_react_region2_a(StatechartLocalReactions* handle);
static void statechartLocalReactions_react_main_region__entry_Default(StatechartLocalReactions* handle);
static void statechartLocalReactions_react_region2__entry_Default(StatechartLocalReactions* handle);
static void statechartLocalReactions_clearInEvents(StatechartLocalReactions* handle);
static void statechartLocalReactions_clearOutEvents(StatechartLocalReactions* handle);


void statechartLocalReactions_init(StatechartLocalReactions* handle)
{
	sc_integer i;

	for (i = 0; i < STATECHARTLOCALREACTIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = StatechartLocalReactions_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	statechartLocalReactions_clearInEvents(handle);
	statechartLocalReactions_clearOutEvents(handle);

	/* Default init sequence for statechart StatechartLocalReactions */
	handle->iface.myInt = 0;

}

void statechartLocalReactions_enter(StatechartLocalReactions* handle)
{
	/* Default enter sequence for statechart StatechartLocalReactions */
	statechartLocalReactions_enseq_main_region_default(handle);
	statechartLocalReactions_enseq_region2_default(handle);
}

void statechartLocalReactions_exit(StatechartLocalReactions* handle)
{
	/* Default exit sequence for statechart StatechartLocalReactions */
	statechartLocalReactions_exseq_main_region(handle);
	statechartLocalReactions_exseq_region2(handle);
}

sc_boolean statechartLocalReactions_isActive(const StatechartLocalReactions* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != StatechartLocalReactions_last_state || handle->stateConfVector[1] != StatechartLocalReactions_last_state)
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
sc_boolean statechartLocalReactions_isFinal(const StatechartLocalReactions* handle)
{
   return bool_false;
}

static void statechartLocalReactions_clearInEvents(StatechartLocalReactions* handle)
{
}

static void statechartLocalReactions_clearOutEvents(StatechartLocalReactions* handle)
{
}

void statechartLocalReactions_runCycle(StatechartLocalReactions* handle)
{
	
	statechartLocalReactions_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < STATECHARTLOCALREACTIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case StatechartLocalReactions_main_region_S1 :
		{
			statechartLocalReactions_react_main_region_S1(handle);
			break;
		}
		case StatechartLocalReactions_main_region_S2 :
		{
			statechartLocalReactions_react_main_region_S2(handle);
			break;
		}
		case StatechartLocalReactions_region2_a :
		{
			statechartLocalReactions_react_region2_a(handle);
			break;
		}
		default:
			break;
		}
	}
	
	statechartLocalReactions_clearInEvents(handle);
}


sc_boolean statechartLocalReactions_isStateActive(const StatechartLocalReactions* handle, StatechartLocalReactionsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case StatechartLocalReactions_main_region_S1 :
			result = (sc_boolean) (handle->stateConfVector[0] == StatechartLocalReactions_main_region_S1
			);
			break;
		case StatechartLocalReactions_main_region_S2 :
			result = (sc_boolean) (handle->stateConfVector[0] == StatechartLocalReactions_main_region_S2
			);
			break;
		case StatechartLocalReactions_region2_a :
			result = (sc_boolean) (handle->stateConfVector[1] == StatechartLocalReactions_region2_a
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}



sc_integer statechartLocalReactionsIface_get_myInt(const StatechartLocalReactions* handle)
{
	return handle->iface.myInt;
}
void statechartLocalReactionsIface_set_myInt(StatechartLocalReactions* handle, sc_integer value)
{
	handle->iface.myInt = value;
}

/* implementations of all internal functions */

static sc_boolean statechartLocalReactions_check__lr0(const StatechartLocalReactions* handle)
{
	return bool_true;
}

static sc_boolean statechartLocalReactions_check__lr1(const StatechartLocalReactions* handle)
{
	return (handle->iface.myInt == 100) ? bool_true : bool_false;
}

static sc_boolean statechartLocalReactions_check_main_region_S1_tr0_tr0(const StatechartLocalReactions* handle)
{
	return bool_true;
}

static sc_boolean statechartLocalReactions_check_main_region_S2_tr0_tr0(const StatechartLocalReactions* handle)
{
	return bool_true;
}

static void statechartLocalReactions_effect__lr0(StatechartLocalReactions* handle)
{
	handle->iface.myInt += 1;
}

static void statechartLocalReactions_effect__lr1(StatechartLocalReactions* handle)
{
	handle->iface.myInt = 0;
}

static void statechartLocalReactions_effect_main_region_S1_tr0(StatechartLocalReactions* handle)
{
	statechartLocalReactions_exseq_main_region_S1(handle);
	statechartLocalReactions_enseq_main_region_S2_default(handle);
}

static void statechartLocalReactions_effect_main_region_S2_tr0(StatechartLocalReactions* handle)
{
	statechartLocalReactions_exseq_main_region_S2(handle);
	statechartLocalReactions_enseq_main_region_S1_default(handle);
}

/* 'default' enter sequence for state S1 */
static void statechartLocalReactions_enseq_main_region_S1_default(StatechartLocalReactions* handle)
{
	/* 'default' enter sequence for state S1 */
	handle->stateConfVector[0] = StatechartLocalReactions_main_region_S1;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state S2 */
static void statechartLocalReactions_enseq_main_region_S2_default(StatechartLocalReactions* handle)
{
	/* 'default' enter sequence for state S2 */
	handle->stateConfVector[0] = StatechartLocalReactions_main_region_S2;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state a */
static void statechartLocalReactions_enseq_region2_a_default(StatechartLocalReactions* handle)
{
	/* 'default' enter sequence for state a */
	handle->stateConfVector[1] = StatechartLocalReactions_region2_a;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region main region */
static void statechartLocalReactions_enseq_main_region_default(StatechartLocalReactions* handle)
{
	/* 'default' enter sequence for region main region */
	statechartLocalReactions_react_main_region__entry_Default(handle);
}

/* 'default' enter sequence for region region2 */
static void statechartLocalReactions_enseq_region2_default(StatechartLocalReactions* handle)
{
	/* 'default' enter sequence for region region2 */
	statechartLocalReactions_react_region2__entry_Default(handle);
}

/* Default exit sequence for state S1 */
static void statechartLocalReactions_exseq_main_region_S1(StatechartLocalReactions* handle)
{
	/* Default exit sequence for state S1 */
	handle->stateConfVector[0] = StatechartLocalReactions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state S2 */
static void statechartLocalReactions_exseq_main_region_S2(StatechartLocalReactions* handle)
{
	/* Default exit sequence for state S2 */
	handle->stateConfVector[0] = StatechartLocalReactions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state a */
static void statechartLocalReactions_exseq_region2_a(StatechartLocalReactions* handle)
{
	/* Default exit sequence for state a */
	handle->stateConfVector[1] = StatechartLocalReactions_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for region main region */
static void statechartLocalReactions_exseq_main_region(StatechartLocalReactions* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of StatechartLocalReactions.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case StatechartLocalReactions_main_region_S1 :
		{
			statechartLocalReactions_exseq_main_region_S1(handle);
			break;
		}
		case StatechartLocalReactions_main_region_S2 :
		{
			statechartLocalReactions_exseq_main_region_S2(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region region2 */
static void statechartLocalReactions_exseq_region2(StatechartLocalReactions* handle)
{
	/* Default exit sequence for region region2 */
	/* Handle exit of all possible states (of StatechartLocalReactions.region2) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case StatechartLocalReactions_region2_a :
		{
			statechartLocalReactions_exseq_region2_a(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state S1. */
static void statechartLocalReactions_react_main_region_S1(StatechartLocalReactions* handle)
{
	/* The reactions of state S1. */
	statechartLocalReactions_effect__lr0(handle);
	if (statechartLocalReactions_check__lr1(handle) == bool_true)
	{ 
		statechartLocalReactions_effect__lr1(handle);
	} 
	statechartLocalReactions_effect_main_region_S1_tr0(handle);
}

/* The reactions of state S2. */
static void statechartLocalReactions_react_main_region_S2(StatechartLocalReactions* handle)
{
	/* The reactions of state S2. */
	statechartLocalReactions_effect__lr0(handle);
	if (statechartLocalReactions_check__lr1(handle) == bool_true)
	{ 
		statechartLocalReactions_effect__lr1(handle);
	} 
	statechartLocalReactions_effect_main_region_S2_tr0(handle);
}

/* The reactions of state a. */
static void statechartLocalReactions_react_region2_a(StatechartLocalReactions* handle)
{
}

/* Default react sequence for initial entry  */
static void statechartLocalReactions_react_main_region__entry_Default(StatechartLocalReactions* handle)
{
	/* Default react sequence for initial entry  */
	statechartLocalReactions_enseq_main_region_S1_default(handle);
}

/* Default react sequence for initial entry  */
static void statechartLocalReactions_react_region2__entry_Default(StatechartLocalReactions* handle)
{
	/* Default react sequence for initial entry  */
	statechartLocalReactions_enseq_region2_a_default(handle);
}


