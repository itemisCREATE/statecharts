
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "FinalState.h"
/*! \file Implementation of the state machine 'FinalState'
*/

/* prototypes of all internal functions */
static sc_boolean finalState_check_main_region_myState_tr0_tr0(const FinalState* handle);
static void finalState_effect_main_region_myState_tr0(FinalState* handle);
static void finalState_enseq_main_region_myState_default(FinalState* handle);
static void finalState_enseq_main_region__final__default(FinalState* handle);
static void finalState_enseq_main_region_default(FinalState* handle);
static void finalState_exseq_main_region_myState(FinalState* handle);
static void finalState_exseq_main_region__final_(FinalState* handle);
static void finalState_exseq_main_region(FinalState* handle);
static void finalState_react_main_region_myState(FinalState* handle);
static void finalState_react_main_region__final_(FinalState* handle);
static void finalState_react_main_region__entry_Default(FinalState* handle);
static void finalState_clearInEvents(FinalState* handle);
static void finalState_clearOutEvents(FinalState* handle);


void finalState_init(FinalState* handle)
{
	sc_integer i;

	for (i = 0; i < FINALSTATE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = FinalState_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	finalState_clearInEvents(handle);
	finalState_clearOutEvents(handle);


}

void finalState_enter(FinalState* handle)
{
	/* Default enter sequence for statechart FinalState */
	finalState_enseq_main_region_default(handle);
}

void finalState_exit(FinalState* handle)
{
	/* Default exit sequence for statechart FinalState */
	finalState_exseq_main_region(handle);
}

sc_boolean finalState_isActive(const FinalState* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < FINALSTATE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != FinalState_last_state;
	}
	
	return result;
}

sc_boolean finalState_isFinal(const FinalState* handle)
{
	return (handle->stateConfVector[0] == FinalState_main_region__final_);

}

static void finalState_clearInEvents(FinalState* handle)
{
}

static void finalState_clearOutEvents(FinalState* handle)
{
}

void finalState_runCycle(FinalState* handle)
{
	
	finalState_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < FINALSTATE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case FinalState_main_region_myState :
		{
			finalState_react_main_region_myState(handle);
			break;
		}
		case FinalState_main_region__final_ :
		{
			finalState_react_main_region__final_(handle);
			break;
		}
		default:
			break;
		}
	}
	
	finalState_clearInEvents(handle);
}


sc_boolean finalState_isStateActive(const FinalState* handle, FinalStateStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case FinalState_main_region_myState :
			result = (sc_boolean) (handle->stateConfVector[SCVI_FINALSTATE_MAIN_REGION_MYSTATE] == FinalState_main_region_myState
			);
			break;
		case FinalState_main_region__final_ :
			result = (sc_boolean) (handle->stateConfVector[SCVI_FINALSTATE_MAIN_REGION__FINAL_] == FinalState_main_region__final_
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}


/* implementations of all internal functions */

static sc_boolean finalState_check_main_region_myState_tr0_tr0(const FinalState* handle)
{
	return bool_true;
}

static void finalState_effect_main_region_myState_tr0(FinalState* handle)
{
	finalState_exseq_main_region_myState(handle);
	finalState_enseq_main_region__final__default(handle);
}

/* 'default' enter sequence for state myState */
static void finalState_enseq_main_region_myState_default(FinalState* handle)
{
	/* 'default' enter sequence for state myState */
	handle->stateConfVector[0] = FinalState_main_region_myState;
	handle->stateConfVectorPosition = 0;
}

/* Default enter sequence for state null */
static void finalState_enseq_main_region__final__default(FinalState* handle)
{
	/* Default enter sequence for state null */
	handle->stateConfVector[0] = FinalState_main_region__final_;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void finalState_enseq_main_region_default(FinalState* handle)
{
	/* 'default' enter sequence for region main region */
	finalState_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state myState */
static void finalState_exseq_main_region_myState(FinalState* handle)
{
	/* Default exit sequence for state myState */
	handle->stateConfVector[0] = FinalState_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for final state. */
static void finalState_exseq_main_region__final_(FinalState* handle)
{
	/* Default exit sequence for final state. */
	handle->stateConfVector[0] = FinalState_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void finalState_exseq_main_region(FinalState* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of FinalState.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case FinalState_main_region_myState :
		{
			finalState_exseq_main_region_myState(handle);
			break;
		}
		case FinalState_main_region__final_ :
		{
			finalState_exseq_main_region__final_(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state myState. */
static void finalState_react_main_region_myState(FinalState* handle)
{
	/* The reactions of state myState. */
	finalState_effect_main_region_myState_tr0(handle);
}

/* The reactions of state null. */
static void finalState_react_main_region__final_(FinalState* handle)
{
	/* The reactions of state null. */
}

/* Default react sequence for initial entry  */
static void finalState_react_main_region__entry_Default(FinalState* handle)
{
	/* Default react sequence for initial entry  */
	finalState_enseq_main_region_myState_default(handle);
}


