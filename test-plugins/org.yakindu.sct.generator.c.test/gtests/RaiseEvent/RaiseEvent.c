
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "RaiseEvent.h"
/*! \file Implementation of the state machine 'RaiseEvent'
*/

/* prototypes of all internal functions */
static sc_boolean raiseEvent_check_main_region_StateA_tr0_tr0(const RaiseEvent* handle);
static sc_boolean raiseEvent_check_second_region_SateA_tr0_tr0(const RaiseEvent* handle);
static void raiseEvent_effect_main_region_StateA_tr0(RaiseEvent* handle);
static void raiseEvent_effect_second_region_SateA_tr0(RaiseEvent* handle);
static void raiseEvent_enact_main_region_StateB(RaiseEvent* handle);
static void raiseEvent_enseq_main_region_StateA_default(RaiseEvent* handle);
static void raiseEvent_enseq_main_region_StateB_default(RaiseEvent* handle);
static void raiseEvent_enseq_second_region_SateA_default(RaiseEvent* handle);
static void raiseEvent_enseq_second_region_StateB_default(RaiseEvent* handle);
static void raiseEvent_enseq_main_region_default(RaiseEvent* handle);
static void raiseEvent_enseq_second_region_default(RaiseEvent* handle);
static void raiseEvent_exseq_main_region_StateA(RaiseEvent* handle);
static void raiseEvent_exseq_main_region_StateB(RaiseEvent* handle);
static void raiseEvent_exseq_second_region_SateA(RaiseEvent* handle);
static void raiseEvent_exseq_second_region_StateB(RaiseEvent* handle);
static void raiseEvent_exseq_main_region(RaiseEvent* handle);
static void raiseEvent_exseq_second_region(RaiseEvent* handle);
static void raiseEvent_react_main_region_StateA(RaiseEvent* handle);
static void raiseEvent_react_main_region_StateB(RaiseEvent* handle);
static void raiseEvent_react_second_region_SateA(RaiseEvent* handle);
static void raiseEvent_react_second_region_StateB(RaiseEvent* handle);
static void raiseEvent_react_main_region__entry_Default(RaiseEvent* handle);
static void raiseEvent_react_second_region__entry_Default(RaiseEvent* handle);
static void raiseEvent_clearInEvents(RaiseEvent* handle);
static void raiseEvent_clearOutEvents(RaiseEvent* handle);


void raiseEvent_init(RaiseEvent* handle)
{
	sc_integer i;

	for (i = 0; i < RAISEEVENT_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = RaiseEvent_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	raiseEvent_clearInEvents(handle);
	raiseEvent_clearOutEvents(handle);


}

void raiseEvent_enter(RaiseEvent* handle)
{
	/* Default enter sequence for statechart RaiseEvent */
	raiseEvent_enseq_main_region_default(handle);
	raiseEvent_enseq_second_region_default(handle);
}

void raiseEvent_exit(RaiseEvent* handle)
{
	/* Default exit sequence for statechart RaiseEvent */
	raiseEvent_exseq_main_region(handle);
	raiseEvent_exseq_second_region(handle);
}

sc_boolean raiseEvent_isActive(const RaiseEvent* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < RAISEEVENT_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != RaiseEvent_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean raiseEvent_isFinal(const RaiseEvent* handle)
{
   return bool_false;
}

static void raiseEvent_clearInEvents(RaiseEvent* handle)
{
	handle->iface.e2_raised = bool_false;
}

static void raiseEvent_clearOutEvents(RaiseEvent* handle)
{
	handle->iface.e1_raised = bool_false;
}

void raiseEvent_runCycle(RaiseEvent* handle)
{
	
	raiseEvent_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < RAISEEVENT_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case RaiseEvent_main_region_StateA :
		{
			raiseEvent_react_main_region_StateA(handle);
			break;
		}
		case RaiseEvent_main_region_StateB :
		{
			raiseEvent_react_main_region_StateB(handle);
			break;
		}
		case RaiseEvent_second_region_SateA :
		{
			raiseEvent_react_second_region_SateA(handle);
			break;
		}
		case RaiseEvent_second_region_StateB :
		{
			raiseEvent_react_second_region_StateB(handle);
			break;
		}
		default:
			break;
		}
	}
	
	raiseEvent_clearInEvents(handle);
}


sc_boolean raiseEvent_isStateActive(const RaiseEvent* handle, RaiseEventStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case RaiseEvent_main_region_StateA :
			result = (sc_boolean) (handle->stateConfVector[SCVI_RAISEEVENT_MAIN_REGION_STATEA] == RaiseEvent_main_region_StateA
			);
			break;
		case RaiseEvent_main_region_StateB :
			result = (sc_boolean) (handle->stateConfVector[SCVI_RAISEEVENT_MAIN_REGION_STATEB] == RaiseEvent_main_region_StateB
			);
			break;
		case RaiseEvent_second_region_SateA :
			result = (sc_boolean) (handle->stateConfVector[SCVI_RAISEEVENT_SECOND_REGION_SATEA] == RaiseEvent_second_region_SateA
			);
			break;
		case RaiseEvent_second_region_StateB :
			result = (sc_boolean) (handle->stateConfVector[SCVI_RAISEEVENT_SECOND_REGION_STATEB] == RaiseEvent_second_region_StateB
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void raiseEventIface_raise_e2(RaiseEvent* handle)
{
	handle->iface.e2_raised = bool_true;
}

sc_boolean raiseEventIface_israised_e1(const RaiseEvent* handle)
{
	return handle->iface.e1_raised;
}


/* implementations of all internal functions */

static sc_boolean raiseEvent_check_main_region_StateA_tr0_tr0(const RaiseEvent* handle)
{
	return handle->iface.e2_raised;
}

static sc_boolean raiseEvent_check_second_region_SateA_tr0_tr0(const RaiseEvent* handle)
{
	return handle->iface.e1_raised;
}

static void raiseEvent_effect_main_region_StateA_tr0(RaiseEvent* handle)
{
	raiseEvent_exseq_main_region_StateA(handle);
	raiseEvent_enseq_main_region_StateB_default(handle);
}

static void raiseEvent_effect_second_region_SateA_tr0(RaiseEvent* handle)
{
	raiseEvent_exseq_second_region_SateA(handle);
	raiseEvent_enseq_second_region_StateB_default(handle);
}

/* Entry action for state 'StateB'. */
static void raiseEvent_enact_main_region_StateB(RaiseEvent* handle)
{
	/* Entry action for state 'StateB'. */
	handle->iface.e1_raised = bool_true;
}

/* 'default' enter sequence for state StateA */
static void raiseEvent_enseq_main_region_StateA_default(RaiseEvent* handle)
{
	/* 'default' enter sequence for state StateA */
	handle->stateConfVector[0] = RaiseEvent_main_region_StateA;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
static void raiseEvent_enseq_main_region_StateB_default(RaiseEvent* handle)
{
	/* 'default' enter sequence for state StateB */
	raiseEvent_enact_main_region_StateB(handle);
	handle->stateConfVector[0] = RaiseEvent_main_region_StateB;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state SateA */
static void raiseEvent_enseq_second_region_SateA_default(RaiseEvent* handle)
{
	/* 'default' enter sequence for state SateA */
	handle->stateConfVector[1] = RaiseEvent_second_region_SateA;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state StateB */
static void raiseEvent_enseq_second_region_StateB_default(RaiseEvent* handle)
{
	/* 'default' enter sequence for state StateB */
	handle->stateConfVector[1] = RaiseEvent_second_region_StateB;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region main region */
static void raiseEvent_enseq_main_region_default(RaiseEvent* handle)
{
	/* 'default' enter sequence for region main region */
	raiseEvent_react_main_region__entry_Default(handle);
}

/* 'default' enter sequence for region second region */
static void raiseEvent_enseq_second_region_default(RaiseEvent* handle)
{
	/* 'default' enter sequence for region second region */
	raiseEvent_react_second_region__entry_Default(handle);
}

/* Default exit sequence for state StateA */
static void raiseEvent_exseq_main_region_StateA(RaiseEvent* handle)
{
	/* Default exit sequence for state StateA */
	handle->stateConfVector[0] = RaiseEvent_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateB */
static void raiseEvent_exseq_main_region_StateB(RaiseEvent* handle)
{
	/* Default exit sequence for state StateB */
	handle->stateConfVector[0] = RaiseEvent_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state SateA */
static void raiseEvent_exseq_second_region_SateA(RaiseEvent* handle)
{
	/* Default exit sequence for state SateA */
	handle->stateConfVector[1] = RaiseEvent_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state StateB */
static void raiseEvent_exseq_second_region_StateB(RaiseEvent* handle)
{
	/* Default exit sequence for state StateB */
	handle->stateConfVector[1] = RaiseEvent_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for region main region */
static void raiseEvent_exseq_main_region(RaiseEvent* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of RaiseEvent.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case RaiseEvent_main_region_StateA :
		{
			raiseEvent_exseq_main_region_StateA(handle);
			break;
		}
		case RaiseEvent_main_region_StateB :
		{
			raiseEvent_exseq_main_region_StateB(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region second region */
static void raiseEvent_exseq_second_region(RaiseEvent* handle)
{
	/* Default exit sequence for region second region */
	/* Handle exit of all possible states (of RaiseEvent.second_region) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case RaiseEvent_second_region_SateA :
		{
			raiseEvent_exseq_second_region_SateA(handle);
			break;
		}
		case RaiseEvent_second_region_StateB :
		{
			raiseEvent_exseq_second_region_StateB(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state StateA. */
static void raiseEvent_react_main_region_StateA(RaiseEvent* handle)
{
	/* The reactions of state StateA. */
	if (raiseEvent_check_main_region_StateA_tr0_tr0(handle) == bool_true)
	{ 
		raiseEvent_effect_main_region_StateA_tr0(handle);
	} 
}

/* The reactions of state StateB. */
static void raiseEvent_react_main_region_StateB(RaiseEvent* handle)
{
	/* The reactions of state StateB. */
}

/* The reactions of state SateA. */
static void raiseEvent_react_second_region_SateA(RaiseEvent* handle)
{
	/* The reactions of state SateA. */
	if (raiseEvent_check_second_region_SateA_tr0_tr0(handle) == bool_true)
	{ 
		raiseEvent_effect_second_region_SateA_tr0(handle);
	} 
}

/* The reactions of state StateB. */
static void raiseEvent_react_second_region_StateB(RaiseEvent* handle)
{
}

/* Default react sequence for initial entry  */
static void raiseEvent_react_main_region__entry_Default(RaiseEvent* handle)
{
	/* Default react sequence for initial entry  */
	raiseEvent_enseq_main_region_StateA_default(handle);
}

/* Default react sequence for initial entry  */
static void raiseEvent_react_second_region__entry_Default(RaiseEvent* handle)
{
	/* Default react sequence for initial entry  */
	raiseEvent_enseq_second_region_SateA_default(handle);
}


