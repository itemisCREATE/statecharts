
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "TransitionWithoutCondition.h"
/*! \file Implementation of the state machine 'TransitionWithoutCondition'
*/

/* prototypes of all internal functions */
static sc_boolean transitionWithoutCondition_check_main_region_A_tr0_tr0(const TransitionWithoutCondition* handle);
static void transitionWithoutCondition_effect_main_region_A_tr0(TransitionWithoutCondition* handle);
static void transitionWithoutCondition_enseq_main_region_A_default(TransitionWithoutCondition* handle);
static void transitionWithoutCondition_enseq_main_region_B_default(TransitionWithoutCondition* handle);
static void transitionWithoutCondition_enseq_main_region_default(TransitionWithoutCondition* handle);
static void transitionWithoutCondition_exseq_main_region_A(TransitionWithoutCondition* handle);
static void transitionWithoutCondition_exseq_main_region_B(TransitionWithoutCondition* handle);
static void transitionWithoutCondition_exseq_main_region(TransitionWithoutCondition* handle);
static void transitionWithoutCondition_react_main_region_A(TransitionWithoutCondition* handle);
static void transitionWithoutCondition_react_main_region_B(TransitionWithoutCondition* handle);
static void transitionWithoutCondition_react_main_region__entry_Default(TransitionWithoutCondition* handle);
static void transitionWithoutCondition_clearInEvents(TransitionWithoutCondition* handle);
static void transitionWithoutCondition_clearOutEvents(TransitionWithoutCondition* handle);


void transitionWithoutCondition_init(TransitionWithoutCondition* handle)
{
	sc_integer i;

	for (i = 0; i < TRANSITIONWITHOUTCONDITION_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = TransitionWithoutCondition_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	transitionWithoutCondition_clearInEvents(handle);
	transitionWithoutCondition_clearOutEvents(handle);


}

void transitionWithoutCondition_enter(TransitionWithoutCondition* handle)
{
	/* Default enter sequence for statechart TransitionWithoutCondition */
	transitionWithoutCondition_enseq_main_region_default(handle);
}

void transitionWithoutCondition_exit(TransitionWithoutCondition* handle)
{
	/* Default exit sequence for statechart TransitionWithoutCondition */
	transitionWithoutCondition_exseq_main_region(handle);
}

sc_boolean transitionWithoutCondition_isActive(const TransitionWithoutCondition* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != TransitionWithoutCondition_last_state)
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
sc_boolean transitionWithoutCondition_isFinal(const TransitionWithoutCondition* handle)
{
   return bool_false;
}

static void transitionWithoutCondition_clearInEvents(TransitionWithoutCondition* handle)
{
}

static void transitionWithoutCondition_clearOutEvents(TransitionWithoutCondition* handle)
{
}

void transitionWithoutCondition_runCycle(TransitionWithoutCondition* handle)
{
	
	transitionWithoutCondition_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < TRANSITIONWITHOUTCONDITION_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case TransitionWithoutCondition_main_region_A :
		{
			transitionWithoutCondition_react_main_region_A(handle);
			break;
		}
		case TransitionWithoutCondition_main_region_B :
		{
			transitionWithoutCondition_react_main_region_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	transitionWithoutCondition_clearInEvents(handle);
}


sc_boolean transitionWithoutCondition_isStateActive(const TransitionWithoutCondition* handle, TransitionWithoutConditionStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case TransitionWithoutCondition_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == TransitionWithoutCondition_main_region_A
			);
			break;
		case TransitionWithoutCondition_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[0] == TransitionWithoutCondition_main_region_B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}


/* implementations of all internal functions */

static sc_boolean transitionWithoutCondition_check_main_region_A_tr0_tr0(const TransitionWithoutCondition* handle)
{
	return bool_true;
}

static void transitionWithoutCondition_effect_main_region_A_tr0(TransitionWithoutCondition* handle)
{
	transitionWithoutCondition_exseq_main_region_A(handle);
	transitionWithoutCondition_enseq_main_region_B_default(handle);
}

/* 'default' enter sequence for state A */
static void transitionWithoutCondition_enseq_main_region_A_default(TransitionWithoutCondition* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = TransitionWithoutCondition_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void transitionWithoutCondition_enseq_main_region_B_default(TransitionWithoutCondition* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = TransitionWithoutCondition_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void transitionWithoutCondition_enseq_main_region_default(TransitionWithoutCondition* handle)
{
	/* 'default' enter sequence for region main region */
	transitionWithoutCondition_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void transitionWithoutCondition_exseq_main_region_A(TransitionWithoutCondition* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = TransitionWithoutCondition_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void transitionWithoutCondition_exseq_main_region_B(TransitionWithoutCondition* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = TransitionWithoutCondition_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void transitionWithoutCondition_exseq_main_region(TransitionWithoutCondition* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of TransitionWithoutCondition.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case TransitionWithoutCondition_main_region_A :
		{
			transitionWithoutCondition_exseq_main_region_A(handle);
			break;
		}
		case TransitionWithoutCondition_main_region_B :
		{
			transitionWithoutCondition_exseq_main_region_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void transitionWithoutCondition_react_main_region_A(TransitionWithoutCondition* handle)
{
	/* The reactions of state A. */
	transitionWithoutCondition_effect_main_region_A_tr0(handle);
}

/* The reactions of state B. */
static void transitionWithoutCondition_react_main_region_B(TransitionWithoutCondition* handle)
{
	/* The reactions of state B. */
}

/* Default react sequence for initial entry  */
static void transitionWithoutCondition_react_main_region__entry_Default(TransitionWithoutCondition* handle)
{
	/* Default react sequence for initial entry  */
	transitionWithoutCondition_enseq_main_region_A_default(handle);
}


