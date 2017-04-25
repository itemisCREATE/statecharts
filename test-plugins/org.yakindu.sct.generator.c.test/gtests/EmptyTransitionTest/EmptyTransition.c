
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "EmptyTransition.h"
/*! \file Implementation of the state machine 'EmptyTransition'
*/

/* prototypes of all internal functions */
static void emptyTransition_enseq_main_region_A_default(EmptyTransition* handle);
static void emptyTransition_enseq_main_region_B_default(EmptyTransition* handle);
static void emptyTransition_enseq_main_region_default(EmptyTransition* handle);
static void emptyTransition_exseq_main_region_A(EmptyTransition* handle);
static void emptyTransition_exseq_main_region_B(EmptyTransition* handle);
static void emptyTransition_exseq_main_region(EmptyTransition* handle);
static void emptyTransition_react_main_region_A(EmptyTransition* handle);
static void emptyTransition_react_main_region_B(EmptyTransition* handle);
static void emptyTransition_react_main_region__entry_Default(EmptyTransition* handle);
static void emptyTransition_clearInEvents(EmptyTransition* handle);
static void emptyTransition_clearOutEvents(EmptyTransition* handle);


void emptyTransition_init(EmptyTransition* handle)
{
	sc_integer i;

	for (i = 0; i < EMPTYTRANSITION_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = EmptyTransition_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	emptyTransition_clearInEvents(handle);
	emptyTransition_clearOutEvents(handle);


}

void emptyTransition_enter(EmptyTransition* handle)
{
	/* Default enter sequence for statechart EmptyTransition */
	emptyTransition_enseq_main_region_default(handle);
}

void emptyTransition_exit(EmptyTransition* handle)
{
	/* Default exit sequence for statechart EmptyTransition */
	emptyTransition_exseq_main_region(handle);
}

sc_boolean emptyTransition_isActive(const EmptyTransition* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != EmptyTransition_last_state)
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
sc_boolean emptyTransition_isFinal(const EmptyTransition* handle)
{
   return bool_false;
}

static void emptyTransition_clearInEvents(EmptyTransition* handle)
{
}

static void emptyTransition_clearOutEvents(EmptyTransition* handle)
{
}

void emptyTransition_runCycle(EmptyTransition* handle)
{
	
	emptyTransition_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < EMPTYTRANSITION_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case EmptyTransition_main_region_A :
		{
			emptyTransition_react_main_region_A(handle);
			break;
		}
		case EmptyTransition_main_region_B :
		{
			emptyTransition_react_main_region_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	emptyTransition_clearInEvents(handle);
}


sc_boolean emptyTransition_isStateActive(const EmptyTransition* handle, EmptyTransitionStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case EmptyTransition_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == EmptyTransition_main_region_A
			);
			break;
		case EmptyTransition_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[0] == EmptyTransition_main_region_B
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
static void emptyTransition_enseq_main_region_A_default(EmptyTransition* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = EmptyTransition_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void emptyTransition_enseq_main_region_B_default(EmptyTransition* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = EmptyTransition_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void emptyTransition_enseq_main_region_default(EmptyTransition* handle)
{
	/* 'default' enter sequence for region main region */
	emptyTransition_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void emptyTransition_exseq_main_region_A(EmptyTransition* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = EmptyTransition_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void emptyTransition_exseq_main_region_B(EmptyTransition* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = EmptyTransition_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void emptyTransition_exseq_main_region(EmptyTransition* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of EmptyTransition.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case EmptyTransition_main_region_A :
		{
			emptyTransition_exseq_main_region_A(handle);
			break;
		}
		case EmptyTransition_main_region_B :
		{
			emptyTransition_exseq_main_region_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void emptyTransition_react_main_region_A(EmptyTransition* handle)
{
	/* The reactions of state A. */
}

/* The reactions of state B. */
static void emptyTransition_react_main_region_B(EmptyTransition* handle)
{
	/* The reactions of state B. */
}

/* Default react sequence for initial entry  */
static void emptyTransition_react_main_region__entry_Default(EmptyTransition* handle)
{
	/* Default react sequence for initial entry  */
	emptyTransition_enseq_main_region_A_default(handle);
}


