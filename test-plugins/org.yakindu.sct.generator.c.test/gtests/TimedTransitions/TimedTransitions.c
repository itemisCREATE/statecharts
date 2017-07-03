
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "TimedTransitions.h"
#include "TimedTransitionsRequired.h"
/*! \file Implementation of the state machine 'TimedTransitions'
*/

/* prototypes of all internal functions */
static sc_boolean timedTransitions_check__lr0(const TimedTransitions* handle);
static sc_boolean timedTransitions_check__lr1(const TimedTransitions* handle);
static sc_boolean timedTransitions_check_main_region_Start_tr0_tr0(const TimedTransitions* handle);
static void timedTransitions_effect__lr0(TimedTransitions* handle);
static void timedTransitions_effect__lr1(TimedTransitions* handle);
static void timedTransitions_effect_main_region_Start_tr0(TimedTransitions* handle);
static void timedTransitions_enact(TimedTransitions* handle);
static void timedTransitions_enact_main_region_Start(TimedTransitions* handle);
static void timedTransitions_exact(TimedTransitions* handle);
static void timedTransitions_exact_main_region_Start(TimedTransitions* handle);
static void timedTransitions_enseq_main_region_Start_default(TimedTransitions* handle);
static void timedTransitions_enseq_main_region_End_default(TimedTransitions* handle);
static void timedTransitions_enseq_main_region_default(TimedTransitions* handle);
static void timedTransitions_exseq_main_region_Start(TimedTransitions* handle);
static void timedTransitions_exseq_main_region_End(TimedTransitions* handle);
static void timedTransitions_exseq_main_region(TimedTransitions* handle);
static void timedTransitions_react_main_region_Start(TimedTransitions* handle);
static void timedTransitions_react_main_region_End(TimedTransitions* handle);
static void timedTransitions_react_main_region__entry_Default(TimedTransitions* handle);
static void timedTransitions_clearInEvents(TimedTransitions* handle);
static void timedTransitions_clearOutEvents(TimedTransitions* handle);


void timedTransitions_init(TimedTransitions* handle)
{
	sc_integer i;

	for (i = 0; i < TIMEDTRANSITIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = TimedTransitions_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	timedTransitions_clearInEvents(handle);
	timedTransitions_clearOutEvents(handle);

	/* Default init sequence for statechart TimedTransitions */
	handle->internal.x = 0;
	handle->internal.y = 0;

}

void timedTransitions_enter(TimedTransitions* handle)
{
	/* Default enter sequence for statechart TimedTransitions */
	timedTransitions_enact(handle);
	timedTransitions_enseq_main_region_default(handle);
}

void timedTransitions_exit(TimedTransitions* handle)
{
	/* Default exit sequence for statechart TimedTransitions */
	timedTransitions_exseq_main_region(handle);
	timedTransitions_exact(handle);
}

sc_boolean timedTransitions_isActive(const TimedTransitions* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < TIMEDTRANSITIONS_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != TimedTransitions_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean timedTransitions_isFinal(const TimedTransitions* handle)
{
   return bool_false;
}

static void timedTransitions_clearInEvents(TimedTransitions* handle)
{
	handle->timeEvents.timedTransitions_main_region_Start_tev0_raised = bool_false;
	handle->timeEvents.timedTransitions_tev0_raised = bool_false;
}

static void timedTransitions_clearOutEvents(TimedTransitions* handle)
{
}

void timedTransitions_runCycle(TimedTransitions* handle)
{
	
	timedTransitions_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < TIMEDTRANSITIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case TimedTransitions_main_region_Start :
		{
			timedTransitions_react_main_region_Start(handle);
			break;
		}
		case TimedTransitions_main_region_End :
		{
			timedTransitions_react_main_region_End(handle);
			break;
		}
		default:
			break;
		}
	}
	
	timedTransitions_clearInEvents(handle);
}

void timedTransitions_raiseTimeEvent(const TimedTransitions* handle, sc_eventid evid)
{
	if ( ((sc_intptr_t)evid) >= ((sc_intptr_t)&(handle->timeEvents))
		&&  ((sc_intptr_t)evid) < ((sc_intptr_t)&(handle->timeEvents)) + sizeof(TimedTransitionsTimeEvents))
		{
		*(sc_boolean*)evid = bool_true;
	}		
}

sc_boolean timedTransitions_isStateActive(const TimedTransitions* handle, TimedTransitionsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case TimedTransitions_main_region_Start :
			result = (sc_boolean) (handle->stateConfVector[SCVI_TIMEDTRANSITIONS_MAIN_REGION_START] == TimedTransitions_main_region_Start
			);
			break;
		case TimedTransitions_main_region_End :
			result = (sc_boolean) (handle->stateConfVector[SCVI_TIMEDTRANSITIONS_MAIN_REGION_END] == TimedTransitions_main_region_End
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}


/* implementations of all internal functions */

static sc_boolean timedTransitions_check__lr0(const TimedTransitions* handle)
{
	return handle->timeEvents.timedTransitions_tev0_raised;
}

static sc_boolean timedTransitions_check__lr1(const TimedTransitions* handle)
{
	return bool_true;
}

static sc_boolean timedTransitions_check_main_region_Start_tr0_tr0(const TimedTransitions* handle)
{
	return handle->timeEvents.timedTransitions_main_region_Start_tev0_raised;
}

static void timedTransitions_effect__lr0(TimedTransitions* handle)
{
	handle->internal.x += 1;
}

static void timedTransitions_effect__lr1(TimedTransitions* handle)
{
	handle->internal.y += 1;
}

static void timedTransitions_effect_main_region_Start_tr0(TimedTransitions* handle)
{
	timedTransitions_exseq_main_region_Start(handle);
	timedTransitions_enseq_main_region_End_default(handle);
}

/* Entry action for statechart 'TimedTransitions'. */
static void timedTransitions_enact(TimedTransitions* handle)
{
	/* Entry action for statechart 'TimedTransitions'. */
	timedTransitions_setTimer(handle, (sc_eventid) &(handle->timeEvents.timedTransitions_tev0_raised) , 1 * 1000, bool_true);
}

/* Entry action for state 'Start'. */
static void timedTransitions_enact_main_region_Start(TimedTransitions* handle)
{
	/* Entry action for state 'Start'. */
	timedTransitions_setTimer(handle, (sc_eventid) &(handle->timeEvents.timedTransitions_main_region_Start_tev0_raised) , 2 * 1000, bool_false);
}

/* Exit action for state 'TimedTransitions'. */
static void timedTransitions_exact(TimedTransitions* handle)
{
	/* Exit action for state 'TimedTransitions'. */
	timedTransitions_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.timedTransitions_tev0_raised) );		
}

/* Exit action for state 'Start'. */
static void timedTransitions_exact_main_region_Start(TimedTransitions* handle)
{
	/* Exit action for state 'Start'. */
	timedTransitions_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.timedTransitions_main_region_Start_tev0_raised) );		
}

/* 'default' enter sequence for state Start */
static void timedTransitions_enseq_main_region_Start_default(TimedTransitions* handle)
{
	/* 'default' enter sequence for state Start */
	timedTransitions_enact_main_region_Start(handle);
	handle->stateConfVector[0] = TimedTransitions_main_region_Start;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state End */
static void timedTransitions_enseq_main_region_End_default(TimedTransitions* handle)
{
	/* 'default' enter sequence for state End */
	handle->stateConfVector[0] = TimedTransitions_main_region_End;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void timedTransitions_enseq_main_region_default(TimedTransitions* handle)
{
	/* 'default' enter sequence for region main region */
	timedTransitions_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state Start */
static void timedTransitions_exseq_main_region_Start(TimedTransitions* handle)
{
	/* Default exit sequence for state Start */
	handle->stateConfVector[0] = TimedTransitions_last_state;
	handle->stateConfVectorPosition = 0;
	timedTransitions_exact_main_region_Start(handle);
}

/* Default exit sequence for state End */
static void timedTransitions_exseq_main_region_End(TimedTransitions* handle)
{
	/* Default exit sequence for state End */
	handle->stateConfVector[0] = TimedTransitions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void timedTransitions_exseq_main_region(TimedTransitions* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of TimedTransitions.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case TimedTransitions_main_region_Start :
		{
			timedTransitions_exseq_main_region_Start(handle);
			break;
		}
		case TimedTransitions_main_region_End :
		{
			timedTransitions_exseq_main_region_End(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state Start. */
static void timedTransitions_react_main_region_Start(TimedTransitions* handle)
{
	/* The reactions of state Start. */
	if (timedTransitions_check__lr0(handle) == bool_true)
	{ 
		timedTransitions_effect__lr0(handle);
	} 
	timedTransitions_effect__lr1(handle);
	if (timedTransitions_check_main_region_Start_tr0_tr0(handle) == bool_true)
	{ 
		timedTransitions_effect_main_region_Start_tr0(handle);
	} 
}

/* The reactions of state End. */
static void timedTransitions_react_main_region_End(TimedTransitions* handle)
{
	/* The reactions of state End. */
	if (timedTransitions_check__lr0(handle) == bool_true)
	{ 
		timedTransitions_effect__lr0(handle);
	} 
	timedTransitions_effect__lr1(handle);
}

/* Default react sequence for initial entry  */
static void timedTransitions_react_main_region__entry_Default(TimedTransitions* handle)
{
	/* Default react sequence for initial entry  */
	timedTransitions_enseq_main_region_Start_default(handle);
}


