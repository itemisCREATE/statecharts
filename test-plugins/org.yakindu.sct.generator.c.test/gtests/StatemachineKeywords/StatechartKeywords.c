
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "StatechartKeywords.h"
#include "StatechartKeywordsRequired.h"
/*! \file Implementation of the state machine 'StatechartKeywords'
*/

/* prototypes of all internal functions */
static sc_boolean statechartKeywords_check__lr0(const StatechartKeywords* handle);
static void statechartKeywords_effect__lr0(StatechartKeywords* handle);
static void statechartKeywords_enact(StatechartKeywords* handle);
static void statechartKeywords_exact(StatechartKeywords* handle);
static void statechartKeywords_enseq_main_region_Timer_default(StatechartKeywords* handle);
static void statechartKeywords_enseq_main_region_default(StatechartKeywords* handle);
static void statechartKeywords_exseq_main_region_Timer(StatechartKeywords* handle);
static void statechartKeywords_exseq_main_region(StatechartKeywords* handle);
static void statechartKeywords_react_main_region_Timer(StatechartKeywords* handle);
static void statechartKeywords_react_main_region__entry_Default(StatechartKeywords* handle);
static void statechartKeywords_clearInEvents(StatechartKeywords* handle);
static void statechartKeywords_clearOutEvents(StatechartKeywords* handle);


void statechartKeywords_init(StatechartKeywords* handle)
{
	sc_integer i;

	for (i = 0; i < STATECHARTKEYWORDS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = StatechartKeywords_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	statechartKeywords_clearInEvents(handle);
	statechartKeywords_clearOutEvents(handle);

	/* Default init sequence for statechart StatechartKeywords */
	handle->ifaceIf.timer = 0;
	handle->ifaceIf.isActive = 0;
	handle->ifaceIf.init = 0;
	handle->ifaceIf.enter = 0;
	handle->ifaceIf.runCycle = 0;
	handle->internal.timer = 0;
	handle->internal.isActive = 0;
	handle->internal.init = 0;
	handle->internal.enter = 0;
	handle->internal.runCycle = 0;
	handle->internal.sCIIf = 0;

}

void statechartKeywords_enter(StatechartKeywords* handle)
{
	/* Default enter sequence for statechart StatechartKeywords */
	statechartKeywords_enact(handle);
	statechartKeywords_enseq_main_region_default(handle);
}

void statechartKeywords_exit(StatechartKeywords* handle)
{
	/* Default exit sequence for statechart StatechartKeywords */
	statechartKeywords_exseq_main_region(handle);
	statechartKeywords_exact(handle);
}

sc_boolean statechartKeywords_isActive(const StatechartKeywords* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != StatechartKeywords_last_state)
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
sc_boolean statechartKeywords_isFinal(const StatechartKeywords* handle)
{
   return bool_false;
}

static void statechartKeywords_clearInEvents(StatechartKeywords* handle)
{
	handle->internal.operationCallback_raised = bool_false;
	handle->internal.listeners_raised = bool_false;
	handle->timeEvents.statechartKeywords_tev0_raised = bool_false;
}

static void statechartKeywords_clearOutEvents(StatechartKeywords* handle)
{
	handle->ifaceIf.operationCallback_raised = bool_false;
	handle->ifaceIf.listeners_raised = bool_false;
}

void statechartKeywords_runCycle(StatechartKeywords* handle)
{
	
	statechartKeywords_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < STATECHARTKEYWORDS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case StatechartKeywords_main_region_Timer :
		{
			statechartKeywords_react_main_region_Timer(handle);
			break;
		}
		default:
			break;
		}
	}
	
	statechartKeywords_clearInEvents(handle);
}

void statechartKeywords_raiseTimeEvent(const StatechartKeywords* handle, sc_eventid evid)
{
	if ( ((sc_intptr_t)evid) >= ((sc_intptr_t)&(handle->timeEvents))
		&&  ((sc_intptr_t)evid) < ((sc_intptr_t)&(handle->timeEvents)) + sizeof(StatechartKeywordsTimeEvents))
		{
		*(sc_boolean*)evid = bool_true;
	}		
}

sc_boolean statechartKeywords_isStateActive(const StatechartKeywords* handle, StatechartKeywordsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case StatechartKeywords_main_region_Timer :
			result = (sc_boolean) (handle->stateConfVector[0] == StatechartKeywords_main_region_Timer
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}


sc_boolean statechartKeywordsIfaceIf_israised_operationCallback(const StatechartKeywords* handle)
{
	return handle->ifaceIf.operationCallback_raised;
}
sc_boolean statechartKeywordsIfaceIf_israised_listeners(const StatechartKeywords* handle)
{
	return handle->ifaceIf.listeners_raised;
}

sc_integer statechartKeywordsIfaceIf_get_timer(const StatechartKeywords* handle)
{
	return handle->ifaceIf.timer;
}
void statechartKeywordsIfaceIf_set_timer(StatechartKeywords* handle, sc_integer value)
{
	handle->ifaceIf.timer = value;
}
sc_integer statechartKeywordsIfaceIf_get_isActive(const StatechartKeywords* handle)
{
	return handle->ifaceIf.isActive;
}
void statechartKeywordsIfaceIf_set_isActive(StatechartKeywords* handle, sc_integer value)
{
	handle->ifaceIf.isActive = value;
}
sc_integer statechartKeywordsIfaceIf_get_init(const StatechartKeywords* handle)
{
	return handle->ifaceIf.init;
}
void statechartKeywordsIfaceIf_set_init(StatechartKeywords* handle, sc_integer value)
{
	handle->ifaceIf.init = value;
}
sc_integer statechartKeywordsIfaceIf_get_enter(const StatechartKeywords* handle)
{
	return handle->ifaceIf.enter;
}
void statechartKeywordsIfaceIf_set_enter(StatechartKeywords* handle, sc_integer value)
{
	handle->ifaceIf.enter = value;
}
sc_integer statechartKeywordsIfaceIf_get_runCycle(const StatechartKeywords* handle)
{
	return handle->ifaceIf.runCycle;
}
void statechartKeywordsIfaceIf_set_runCycle(StatechartKeywords* handle, sc_integer value)
{
	handle->ifaceIf.runCycle = value;
}

/* implementations of all internal functions */

static sc_boolean statechartKeywords_check__lr0(const StatechartKeywords* handle)
{
	return handle->timeEvents.statechartKeywords_tev0_raised;
}

static void statechartKeywords_effect__lr0(StatechartKeywords* handle)
{
	handle->internal.timer += 1;
}

/* Entry action for statechart 'StatechartKeywords'. */
static void statechartKeywords_enact(StatechartKeywords* handle)
{
	/* Entry action for statechart 'StatechartKeywords'. */
	statechartKeywords_setTimer(handle, (sc_eventid) &(handle->timeEvents.statechartKeywords_tev0_raised) , 1 * 1000, bool_true);
}

/* Exit action for state 'StatechartKeywords'. */
static void statechartKeywords_exact(StatechartKeywords* handle)
{
	/* Exit action for state 'StatechartKeywords'. */
	statechartKeywords_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.statechartKeywords_tev0_raised) );		
}

/* 'default' enter sequence for state Timer */
static void statechartKeywords_enseq_main_region_Timer_default(StatechartKeywords* handle)
{
	/* 'default' enter sequence for state Timer */
	handle->stateConfVector[0] = StatechartKeywords_main_region_Timer;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void statechartKeywords_enseq_main_region_default(StatechartKeywords* handle)
{
	/* 'default' enter sequence for region main region */
	statechartKeywords_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state Timer */
static void statechartKeywords_exseq_main_region_Timer(StatechartKeywords* handle)
{
	/* Default exit sequence for state Timer */
	handle->stateConfVector[0] = StatechartKeywords_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void statechartKeywords_exseq_main_region(StatechartKeywords* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of StatechartKeywords.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case StatechartKeywords_main_region_Timer :
		{
			statechartKeywords_exseq_main_region_Timer(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state Timer. */
static void statechartKeywords_react_main_region_Timer(StatechartKeywords* handle)
{
	/* The reactions of state Timer. */
	if (statechartKeywords_check__lr0(handle) == bool_true)
	{ 
		statechartKeywords_effect__lr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void statechartKeywords_react_main_region__entry_Default(StatechartKeywords* handle)
{
	/* Default react sequence for initial entry  */
	statechartKeywords_enseq_main_region_Timer_default(handle);
}


