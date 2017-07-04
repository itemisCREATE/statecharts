
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "StatechartActive.h"
/*! \file Implementation of the state machine 'StatechartActive'
*/

/* prototypes of all internal functions */
static void statechartActive_enseq_r_A_default(StatechartActive* handle);
static void statechartActive_enseq_r_default(StatechartActive* handle);
static void statechartActive_exseq_r_A(StatechartActive* handle);
static void statechartActive_exseq_r(StatechartActive* handle);
static void statechartActive_react_r_A(StatechartActive* handle);
static void statechartActive_react_r__entry_Default(StatechartActive* handle);
static void statechartActive_clearInEvents(StatechartActive* handle);
static void statechartActive_clearOutEvents(StatechartActive* handle);


void statechartActive_init(StatechartActive* handle)
{
	sc_integer i;

	for (i = 0; i < STATECHARTACTIVE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = StatechartActive_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	statechartActive_clearInEvents(handle);
	statechartActive_clearOutEvents(handle);


}

void statechartActive_enter(StatechartActive* handle)
{
	/* Default enter sequence for statechart StatechartActive */
	statechartActive_enseq_r_default(handle);
}

void statechartActive_exit(StatechartActive* handle)
{
	/* Default exit sequence for statechart StatechartActive */
	statechartActive_exseq_r(handle);
}

sc_boolean statechartActive_isActive(const StatechartActive* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < STATECHARTACTIVE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != StatechartActive_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean statechartActive_isFinal(const StatechartActive* handle)
{
   return bool_false;
}

static void statechartActive_clearInEvents(StatechartActive* handle)
{
}

static void statechartActive_clearOutEvents(StatechartActive* handle)
{
}

void statechartActive_runCycle(StatechartActive* handle)
{
	
	statechartActive_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < STATECHARTACTIVE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case StatechartActive_r_A :
		{
			statechartActive_react_r_A(handle);
			break;
		}
		default:
			break;
		}
	}
	
	statechartActive_clearInEvents(handle);
}


sc_boolean statechartActive_isStateActive(const StatechartActive* handle, StatechartActiveStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case StatechartActive_r_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_STATECHARTACTIVE_R_A] == StatechartActive_r_A
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}


/* implementations of all internal functions */

/* 'default' enter sequence for state A */
static void statechartActive_enseq_r_A_default(StatechartActive* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = StatechartActive_r_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region r */
static void statechartActive_enseq_r_default(StatechartActive* handle)
{
	/* 'default' enter sequence for region r */
	statechartActive_react_r__entry_Default(handle);
}

/* Default exit sequence for state A */
static void statechartActive_exseq_r_A(StatechartActive* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = StatechartActive_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region r */
static void statechartActive_exseq_r(StatechartActive* handle)
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of StatechartActive.r) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case StatechartActive_r_A :
		{
			statechartActive_exseq_r_A(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void statechartActive_react_r_A(StatechartActive* handle)
{
	/* The reactions of state A. */
}

/* Default react sequence for initial entry  */
static void statechartActive_react_r__entry_Default(StatechartActive* handle)
{
	/* Default react sequence for initial entry  */
	statechartActive_enseq_r_A_default(handle);
}


