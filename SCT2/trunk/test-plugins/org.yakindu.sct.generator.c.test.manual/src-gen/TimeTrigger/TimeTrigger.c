#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "TimeTrigger.h"
#include "TimeTriggerRequired.h"

/*! \file Implementation of the state machine 'TimeTrigger'
*/

// prototypes of all internal functions

static void timeTrigger_entryaction(TimeTrigger* handle);
static void timeTrigger_exitaction(TimeTrigger* handle);
static void timeTrigger_react_mainRegion_StateA(TimeTrigger* handle);
static void timeTrigger_react_mainRegion_StateB(TimeTrigger* handle);
static void clearInEvents(TimeTrigger* handle);
static void clearOutEvents(TimeTrigger* handle);


void timeTrigger_init(TimeTrigger* handle)
{
	int i;

	for (i = 0; i < TIMETRIGGER_MAX_ORTHOGONAL_STATES; ++i)
		handle->stateConfVector[i] = TimeTrigger_last_state;
	
	
	handle->stateConfVectorPosition = 0;

	// TODO: initialize all events ...
	// TODO: initialize all variables ... (set default values - here or inenter sequence ?!?)

}

void timeTrigger_enter(TimeTrigger* handle)
{
	/* Default enter sequence for statechart TimeTrigger */
	timeTrigger_entryaction(handle);
	/* Default enter sequence for region mainRegion */
	/* Default react sequence for initial entry  */
	/* Default enter sequence for state StateA */
	/* Entry action for state 'StateA'. */
	timeTrigger_setTimer( (sc_eventid) &(handle->timeEvents.StateA_time_event_0_raised) , 100, bool_false);
	handle->iface.value = 0;
	handle->stateConfVector[0] = TimeTrigger_mainRegion_StateA;
	handle->stateConfVectorPosition = 0;
}

void timeTrigger_exit(TimeTrigger* handle)
{
	/* Default exit sequence for statechart TimeTrigger */
	/* Default exit sequence for region mainRegion */
	/* Handle exit of all possible states (of mainRegion) at position 0... */
	switch(handle->stateConfVector[ 0 ]) {
		case TimeTrigger_mainRegion_StateA : {
			/* Default exit sequence for state StateA */
			handle->stateConfVector[0] = TimeTrigger_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'StateA'. */
			timeTrigger_unsetTimer( (sc_eventid) &(handle->timeEvents.StateA_time_event_0_raised) );		
			break;
		}
		case TimeTrigger_mainRegion_StateB : {
			/* Default exit sequence for state StateB */
			handle->stateConfVector[0] = TimeTrigger_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'StateB'. */
			timeTrigger_unsetTimer( (sc_eventid) &(handle->timeEvents.StateB_time_event_0_raised) );		
			break;
		}
		default: break;
	}
	timeTrigger_exitaction(handle);
}

static void clearInEvents(TimeTrigger* handle) {
}

static void clearOutEvents(TimeTrigger* handle) {
}

void timeTrigger_runCycle(TimeTrigger* handle) {
	
	clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < TIMETRIGGER_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++) {
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition]) {
		case TimeTrigger_mainRegion_StateA : {
			timeTrigger_react_mainRegion_StateA(handle);
			break;
		}
		case TimeTrigger_mainRegion_StateB : {
			timeTrigger_react_mainRegion_StateB(handle);
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents(handle);
}

void timeTrigger_raiseTimeEvent(TimeTrigger* handle, sc_eventid evid) {
	if ( ((intptr_t)evid) >= ((intptr_t)&(handle->timeEvents))
		&&  ((intptr_t)evid) < ((intptr_t)&(handle->timeEvents)) + sizeof(TimeTriggerTimeEvents)) {
		*(sc_boolean*)evid = bool_true;
	}		
}

sc_boolean timeTrigger_isActive(TimeTrigger* handle, TimeTriggerStates state) {
	switch (state) {
		case TimeTrigger_mainRegion_StateA : 
			return (sc_boolean) (handle->stateConfVector[0] == TimeTrigger_mainRegion_StateA
			);
		case TimeTrigger_mainRegion_StateB : 
			return (sc_boolean) (handle->stateConfVector[0] == TimeTrigger_mainRegion_StateB
			);
		default: return bool_false;
	}
}



sc_integer timeTriggerIface_get_value(TimeTrigger* handle) {
	return handle->iface.value;
}
void timeTriggerIface_set_value(TimeTrigger* handle, sc_integer value) {
	handle->iface.value = value;
}
		
// implementations of all internal functions

/* Entry action for statechart 'TimeTrigger'. */
static void timeTrigger_entryaction(TimeTrigger* handle) {
	/* Entry action for statechart 'TimeTrigger'. */
}

/* Exit action for state 'TimeTrigger'. */
static void timeTrigger_exitaction(TimeTrigger* handle) {
	/* Exit action for state 'TimeTrigger'. */
}

/* The reactions of state StateA. */
static void timeTrigger_react_mainRegion_StateA(TimeTrigger* handle) {
	/* The reactions of state StateA. */
	if (handle->timeEvents.StateA_time_event_0_raised) { 
		/* Default exit sequence for state StateA */
		handle->stateConfVector[0] = TimeTrigger_last_state;
		handle->stateConfVectorPosition = 0;
		/* Exit action for state 'StateA'. */
		timeTrigger_unsetTimer( (sc_eventid) &(handle->timeEvents.StateA_time_event_0_raised) );		
		/* Default enter sequence for state StateB */
		/* Entry action for state 'StateB'. */
		timeTrigger_setTimer( (sc_eventid) &(handle->timeEvents.StateB_time_event_0_raised) , 20, bool_true);
		handle->stateConfVector[0] = TimeTrigger_mainRegion_StateB;
		handle->stateConfVectorPosition = 0;
	} 
}

/* The reactions of state StateB. */
static void timeTrigger_react_mainRegion_StateB(TimeTrigger* handle) {
	/* The reactions of state StateB. */
	if (handle->iface.value == 10) { 
		/* Default exit sequence for state StateB */
		handle->stateConfVector[0] = TimeTrigger_last_state;
		handle->stateConfVectorPosition = 0;
		/* Exit action for state 'StateB'. */
		timeTrigger_unsetTimer( (sc_eventid) &(handle->timeEvents.StateB_time_event_0_raised) );		
		/* Default enter sequence for state StateA */
		/* Entry action for state 'StateA'. */
		timeTrigger_setTimer( (sc_eventid) &(handle->timeEvents.StateA_time_event_0_raised) , 100, bool_false);
		handle->iface.value = 0;
		handle->stateConfVector[0] = TimeTrigger_mainRegion_StateA;
		handle->stateConfVectorPosition = 0;
	}  else {
		if (handle->timeEvents.StateB_time_event_0_raised) { 
			handle->iface.value += 1;
		} 
	}
}


