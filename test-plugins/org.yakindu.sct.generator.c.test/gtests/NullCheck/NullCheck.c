
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "NullCheck.h"
/*! \file Implementation of the state machine 'NullCheck'
*/

/* prototypes of all internal functions */
static sc_boolean nullCheck_check_main_region_A_tr0_tr0(const NullCheck* handle);
static void nullCheck_effect_main_region_A_tr0(NullCheck* handle);
static void nullCheck_enseq_main_region_A_default(NullCheck* handle);
static void nullCheck_enseq_main_region_B_default(NullCheck* handle);
static void nullCheck_enseq_main_region_default(NullCheck* handle);
static void nullCheck_exseq_main_region_A(NullCheck* handle);
static void nullCheck_exseq_main_region_B(NullCheck* handle);
static void nullCheck_exseq_main_region(NullCheck* handle);
static void nullCheck_react_main_region_A(NullCheck* handle);
static void nullCheck_react_main_region_B(NullCheck* handle);
static void nullCheck_react_main_region__entry_Default(NullCheck* handle);
static void nullCheck_clearInEvents(NullCheck* handle);
static void nullCheck_clearOutEvents(NullCheck* handle);


void nullCheck_init(NullCheck* handle)
{
	sc_integer i;

	for (i = 0; i < NULLCHECK_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = NullCheck_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	nullCheck_clearInEvents(handle);
	nullCheck_clearOutEvents(handle);


}

void nullCheck_enter(NullCheck* handle)
{
	/* Default enter sequence for statechart NullCheck */
	nullCheck_enseq_main_region_default(handle);
}

void nullCheck_exit(NullCheck* handle)
{
	/* Default exit sequence for statechart NullCheck */
	nullCheck_exseq_main_region(handle);
}

sc_boolean nullCheck_isActive(const NullCheck* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < NULLCHECK_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != NullCheck_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean nullCheck_isFinal(const NullCheck* handle)
{
   return bool_false;
}

static void nullCheck_clearInEvents(NullCheck* handle)
{
}

static void nullCheck_clearOutEvents(NullCheck* handle)
{
}

void nullCheck_runCycle(NullCheck* handle)
{
	
	nullCheck_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < NULLCHECK_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case NullCheck_main_region_A :
		{
			nullCheck_react_main_region_A(handle);
			break;
		}
		case NullCheck_main_region_B :
		{
			nullCheck_react_main_region_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	nullCheck_clearInEvents(handle);
}


sc_boolean nullCheck_isStateActive(const NullCheck* handle, NullCheckStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case NullCheck_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_NULLCHECK_MAIN_REGION_A] == NullCheck_main_region_A
			);
			break;
		case NullCheck_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_NULLCHECK_MAIN_REGION_B] == NullCheck_main_region_B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}


/* implementations of all internal functions */

static sc_boolean nullCheck_check_main_region_A_tr0_tr0(const NullCheck* handle)
{
	return (null == null) ? bool_true : bool_false;
}

static void nullCheck_effect_main_region_A_tr0(NullCheck* handle)
{
	nullCheck_exseq_main_region_A(handle);
	nullCheck_enseq_main_region_B_default(handle);
}

/* 'default' enter sequence for state A */
static void nullCheck_enseq_main_region_A_default(NullCheck* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = NullCheck_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void nullCheck_enseq_main_region_B_default(NullCheck* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = NullCheck_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void nullCheck_enseq_main_region_default(NullCheck* handle)
{
	/* 'default' enter sequence for region main region */
	nullCheck_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void nullCheck_exseq_main_region_A(NullCheck* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = NullCheck_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void nullCheck_exseq_main_region_B(NullCheck* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = NullCheck_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void nullCheck_exseq_main_region(NullCheck* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of NullCheck.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case NullCheck_main_region_A :
		{
			nullCheck_exseq_main_region_A(handle);
			break;
		}
		case NullCheck_main_region_B :
		{
			nullCheck_exseq_main_region_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void nullCheck_react_main_region_A(NullCheck* handle)
{
	/* The reactions of state A. */
	if (nullCheck_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		nullCheck_effect_main_region_A_tr0(handle);
	} 
}

/* The reactions of state B. */
static void nullCheck_react_main_region_B(NullCheck* handle)
{
	/* The reactions of state B. */
}

/* Default react sequence for initial entry  */
static void nullCheck_react_main_region__entry_Default(NullCheck* handle)
{
	/* Default react sequence for initial entry  */
	nullCheck_enseq_main_region_A_default(handle);
}


