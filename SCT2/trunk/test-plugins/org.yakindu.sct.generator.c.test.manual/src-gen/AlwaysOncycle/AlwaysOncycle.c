#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "AlwaysOncycle.h"
#include "AlwaysOncycleRequired.h"

/*! \file Implementation of the state machine 'AlwaysOncycle'
*/

// prototypes of all internal functions

static void alwaysOncycle_entryaction(AlwaysOncycle* handle);
static void alwaysOncycle_exitaction(AlwaysOncycle* handle);
static void alwaysOncycle_react_main_region_StateA(AlwaysOncycle* handle);
static void alwaysOncycle_react_main_region_StateB(AlwaysOncycle* handle);
static void clearInEvents(AlwaysOncycle* handle);
static void clearOutEvents(AlwaysOncycle* handle);


void alwaysOncycle_init(AlwaysOncycle* handle)
{
	int i;

	for (i = 0; i < ALWAYSONCYCLE_MAX_ORTHOGONAL_STATES; ++i)
		handle->stateConfVector[i] = AlwaysOncycle_last_state;
	
	
	handle->stateConfVectorPosition = 0;

	// TODO: initialize all events ...
	// TODO: initialize all variables ... (set default values - here or inenter sequence ?!?)

}

void alwaysOncycle_enter(AlwaysOncycle* handle)
{
	/* Default enter sequence for statechart AlwaysOncycle */
	alwaysOncycle_entryaction(handle);
	/* Default enter sequence for region main region */
	/* Default react sequence for initial entry  */
	/* Default enter sequence for state StateA */
	/* Entry action for state 'StateA'. */
	handle->iface.value = 0;
	handle->stateConfVector[0] = AlwaysOncycle_main_region_StateA;
	handle->stateConfVectorPosition = 0;
}

void alwaysOncycle_exit(AlwaysOncycle* handle)
{
	/* Default exit sequence for statechart AlwaysOncycle */
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of main region) at position 0... */
	switch(handle->stateConfVector[ 0 ]) {
		case AlwaysOncycle_main_region_StateA : {
			/* Default exit sequence for state StateA */
			handle->stateConfVector[0] = AlwaysOncycle_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'StateA'. */
			handle->iface.value = 0;
			break;
		}
		case AlwaysOncycle_main_region_StateB : {
			/* Default exit sequence for state StateB */
			handle->stateConfVector[0] = AlwaysOncycle_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		default: break;
	}
	alwaysOncycle_exitaction(handle);
}

static void clearInEvents(AlwaysOncycle* handle) {
}

static void clearOutEvents(AlwaysOncycle* handle) {
}

void alwaysOncycle_runCycle(AlwaysOncycle* handle) {
	
	clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < ALWAYSONCYCLE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++) {
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition]) {
		case AlwaysOncycle_main_region_StateA : {
			alwaysOncycle_react_main_region_StateA(handle);
			break;
		}
		case AlwaysOncycle_main_region_StateB : {
			alwaysOncycle_react_main_region_StateB(handle);
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents(handle);
}


sc_boolean alwaysOncycle_isActive(AlwaysOncycle* handle, AlwaysOncycleStates state) {
	switch (state) {
		case AlwaysOncycle_main_region_StateA : 
			return (sc_boolean) (handle->stateConfVector[0] == AlwaysOncycle_main_region_StateA
			);
		case AlwaysOncycle_main_region_StateB : 
			return (sc_boolean) (handle->stateConfVector[0] == AlwaysOncycle_main_region_StateB
			);
		default: return bool_false;
	}
}



sc_integer alwaysOncycleIface_get_value(AlwaysOncycle* handle) {
	return handle->iface.value;
}
void alwaysOncycleIface_set_value(AlwaysOncycle* handle, sc_integer value) {
	handle->iface.value = value;
}
		
// implementations of all internal functions

/* Entry action for statechart 'AlwaysOncycle'. */
static void alwaysOncycle_entryaction(AlwaysOncycle* handle) {
	/* Entry action for statechart 'AlwaysOncycle'. */
}

/* Exit action for state 'AlwaysOncycle'. */
static void alwaysOncycle_exitaction(AlwaysOncycle* handle) {
	/* Exit action for state 'AlwaysOncycle'. */
}

/* The reactions of state StateA. */
static void alwaysOncycle_react_main_region_StateA(AlwaysOncycle* handle) {
	/* The reactions of state StateA. */
	if (handle->iface.value == 5) { 
		/* Default exit sequence for state StateA */
		handle->stateConfVector[0] = AlwaysOncycle_last_state;
		handle->stateConfVectorPosition = 0;
		/* Exit action for state 'StateA'. */
		handle->iface.value = 0;
		/* Default enter sequence for state StateB */
		handle->stateConfVector[0] = AlwaysOncycle_main_region_StateB;
		handle->stateConfVectorPosition = 0;
	}  else {
		handle->iface.value += 1;
	}
}

/* The reactions of state StateB. */
static void alwaysOncycle_react_main_region_StateB(AlwaysOncycle* handle) {
	/* The reactions of state StateB. */
	if (handle->iface.value == 5) { 
		/* Default exit sequence for state StateB */
		handle->stateConfVector[0] = AlwaysOncycle_last_state;
		handle->stateConfVectorPosition = 0;
		/* Default enter sequence for state StateA */
		/* Entry action for state 'StateA'. */
		handle->iface.value = 0;
		handle->stateConfVector[0] = AlwaysOncycle_main_region_StateA;
		handle->stateConfVectorPosition = 0;
	}  else {
		handle->iface.value += 1;
	}
}


