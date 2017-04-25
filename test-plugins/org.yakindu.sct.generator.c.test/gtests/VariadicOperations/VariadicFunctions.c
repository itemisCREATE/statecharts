
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "VariadicFunctions.h"
#include "VariadicFunctionsRequired.h"
/*! \file Implementation of the state machine 'VariadicFunctions'
*/

/* prototypes of all internal functions */
static sc_boolean variadicFunctions_check_main_region_StateA_tr0_tr0(const VariadicFunctions* handle);
static void variadicFunctions_effect_main_region_StateA_tr0(VariadicFunctions* handle);
static void variadicFunctions_enact_main_region_StateA(VariadicFunctions* handle);
static void variadicFunctions_enact_main_region_StateB(VariadicFunctions* handle);
static void variadicFunctions_enseq_main_region_StateA_default(VariadicFunctions* handle);
static void variadicFunctions_enseq_main_region_StateB_default(VariadicFunctions* handle);
static void variadicFunctions_enseq_main_region_default(VariadicFunctions* handle);
static void variadicFunctions_exseq_main_region_StateA(VariadicFunctions* handle);
static void variadicFunctions_exseq_main_region_StateB(VariadicFunctions* handle);
static void variadicFunctions_exseq_main_region(VariadicFunctions* handle);
static void variadicFunctions_react_main_region_StateA(VariadicFunctions* handle);
static void variadicFunctions_react_main_region_StateB(VariadicFunctions* handle);
static void variadicFunctions_react_main_region__entry_Default(VariadicFunctions* handle);
static void variadicFunctions_clearInEvents(VariadicFunctions* handle);
static void variadicFunctions_clearOutEvents(VariadicFunctions* handle);


void variadicFunctions_init(VariadicFunctions* handle)
{
	sc_integer i;

	for (i = 0; i < VARIADICFUNCTIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = VariadicFunctions_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	variadicFunctions_clearInEvents(handle);
	variadicFunctions_clearOutEvents(handle);


}

void variadicFunctions_enter(VariadicFunctions* handle)
{
	/* Default enter sequence for statechart VariadicFunctions */
	variadicFunctions_enseq_main_region_default(handle);
}

void variadicFunctions_exit(VariadicFunctions* handle)
{
	/* Default exit sequence for statechart VariadicFunctions */
	variadicFunctions_exseq_main_region(handle);
}

sc_boolean variadicFunctions_isActive(const VariadicFunctions* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != VariadicFunctions_last_state)
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
sc_boolean variadicFunctions_isFinal(const VariadicFunctions* handle)
{
   return bool_false;
}

static void variadicFunctions_clearInEvents(VariadicFunctions* handle)
{
}

static void variadicFunctions_clearOutEvents(VariadicFunctions* handle)
{
}

void variadicFunctions_runCycle(VariadicFunctions* handle)
{
	
	variadicFunctions_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < VARIADICFUNCTIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case VariadicFunctions_main_region_StateA :
		{
			variadicFunctions_react_main_region_StateA(handle);
			break;
		}
		case VariadicFunctions_main_region_StateB :
		{
			variadicFunctions_react_main_region_StateB(handle);
			break;
		}
		default:
			break;
		}
	}
	
	variadicFunctions_clearInEvents(handle);
}


sc_boolean variadicFunctions_isStateActive(const VariadicFunctions* handle, VariadicFunctionsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case VariadicFunctions_main_region_StateA :
			result = (sc_boolean) (handle->stateConfVector[0] == VariadicFunctions_main_region_StateA
			);
			break;
		case VariadicFunctions_main_region_StateB :
			result = (sc_boolean) (handle->stateConfVector[0] == VariadicFunctions_main_region_StateB
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}






/* implementations of all internal functions */

static sc_boolean variadicFunctions_check_main_region_StateA_tr0_tr0(const VariadicFunctions* handle)
{
	return bool_true;
}

static void variadicFunctions_effect_main_region_StateA_tr0(VariadicFunctions* handle)
{
	variadicFunctions_exseq_main_region_StateA(handle);
	variadicFunctionsInternal_myInternalVarOperation(handle, 0.0, 0.2);
	variadicFunctions_enseq_main_region_StateB_default(handle);
}

/* Entry action for state 'StateA'. */
static void variadicFunctions_enact_main_region_StateA(VariadicFunctions* handle)
{
	/* Entry action for state 'StateA'. */
	variadicFunctionsIface_myVarOperation(handle);
	variadicFunctionsIface_myVarOperation(handle, "one");
	variadicFunctionsIface_myVarOperation(handle, "one", "two", "three");
}

/* Entry action for state 'StateB'. */
static void variadicFunctions_enact_main_region_StateB(VariadicFunctions* handle)
{
	/* Entry action for state 'StateB'. */
	variadicFunctionsIfaceIF2_myVarOperation2(handle, 1);
	variadicFunctionsIfaceIF2_myVarOperation2(handle, 1, 2);
	variadicFunctionsIfaceIF2_myVarOperation2(handle, 1, 2, 3, 4);
}

/* 'default' enter sequence for state StateA */
static void variadicFunctions_enseq_main_region_StateA_default(VariadicFunctions* handle)
{
	/* 'default' enter sequence for state StateA */
	variadicFunctions_enact_main_region_StateA(handle);
	handle->stateConfVector[0] = VariadicFunctions_main_region_StateA;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
static void variadicFunctions_enseq_main_region_StateB_default(VariadicFunctions* handle)
{
	/* 'default' enter sequence for state StateB */
	variadicFunctions_enact_main_region_StateB(handle);
	handle->stateConfVector[0] = VariadicFunctions_main_region_StateB;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void variadicFunctions_enseq_main_region_default(VariadicFunctions* handle)
{
	/* 'default' enter sequence for region main region */
	variadicFunctions_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state StateA */
static void variadicFunctions_exseq_main_region_StateA(VariadicFunctions* handle)
{
	/* Default exit sequence for state StateA */
	handle->stateConfVector[0] = VariadicFunctions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateB */
static void variadicFunctions_exseq_main_region_StateB(VariadicFunctions* handle)
{
	/* Default exit sequence for state StateB */
	handle->stateConfVector[0] = VariadicFunctions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void variadicFunctions_exseq_main_region(VariadicFunctions* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of VariadicFunctions.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case VariadicFunctions_main_region_StateA :
		{
			variadicFunctions_exseq_main_region_StateA(handle);
			break;
		}
		case VariadicFunctions_main_region_StateB :
		{
			variadicFunctions_exseq_main_region_StateB(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state StateA. */
static void variadicFunctions_react_main_region_StateA(VariadicFunctions* handle)
{
	/* The reactions of state StateA. */
	variadicFunctions_effect_main_region_StateA_tr0(handle);
}

/* The reactions of state StateB. */
static void variadicFunctions_react_main_region_StateB(VariadicFunctions* handle)
{
	/* The reactions of state StateB. */
}

/* Default react sequence for initial entry  */
static void variadicFunctions_react_main_region__entry_Default(VariadicFunctions* handle)
{
	/* Default react sequence for initial entry  */
	variadicFunctions_enseq_main_region_StateA_default(handle);
}


