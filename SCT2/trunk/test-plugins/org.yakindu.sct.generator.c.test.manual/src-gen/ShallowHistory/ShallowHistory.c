#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "ShallowHistory.h"
#include "ShallowHistoryRequired.h"

/*! \file Implementation of the state machine 'ShallowHistory'
*/

// prototypes of all internal functions

static void shallowHistory_entryaction(ShallowHistory* handle);
static void shallowHistory_exitaction(ShallowHistory* handle);
static void shallowHistory_shallowentersequence_mainRegion_State2_region0(ShallowHistory* handle);
static void shallowHistory_shallowentersequence_mainRegion_State2_region0_State4_region0_State7_region0(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State1(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State2_region0_State3(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State2_region0_State4_region0_State6(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State2_region0_State4_region0_State7_region0_State8(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State2_region0_State4_region0_State7_region0_State9(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State2_region0_State5(ShallowHistory* handle);
static void clearInEvents(ShallowHistory* handle);
static void clearOutEvents(ShallowHistory* handle);


void shallowHistory_init(ShallowHistory* handle)
{
	int i;

	for (i = 0; i < SHALLOWHISTORY_MAX_ORTHOGONAL_STATES; ++i)
		handle->stateConfVector[i] = ShallowHistory_last_state;
	
	for (i = 0; i < SHALLOWHISTORY_MAX_HISTORY_STATES; ++i)
		handle->historyVector[i] = ShallowHistory_last_state;
	
	handle->stateConfVectorPosition = 0;

	// TODO: initialize all events ...
	// TODO: initialize all variables ... (set default values - here or inenter sequence ?!?)

}

void shallowHistory_enter(ShallowHistory* handle)
{
	/* Default enter sequence for statechart ShallowHistory */
	shallowHistory_entryaction(handle);
	/* Default enter sequence for region mainRegion */
	/* Default react sequence for initial entry  */
	/* Default enter sequence for state State1 */
	handle->stateConfVector[0] = ShallowHistory_mainRegion_State1;
	handle->stateConfVectorPosition = 0;
}

void shallowHistory_exit(ShallowHistory* handle)
{
	/* Default exit sequence for statechart ShallowHistory */
	/* Default exit sequence for region mainRegion */
	/* Handle exit of all possible states (of mainRegion) at position 0... */
	switch(handle->stateConfVector[ 0 ]) {
		case ShallowHistory_mainRegion_State1 : {
			/* Default exit sequence for state State1 */
			handle->stateConfVector[0] = ShallowHistory_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State3 : {
			handle->historyVector[0] = handle->stateConfVector[0];
			/* Default exit sequence for state State3 */
			handle->stateConfVector[0] = ShallowHistory_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 : {
			handle->historyVector[0] = handle->stateConfVector[0];
			/* Default exit sequence for state State6 */
			handle->stateConfVector[0] = ShallowHistory_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
			handle->historyVector[1] = handle->stateConfVector[0];
			handle->historyVector[0] = handle->stateConfVector[0];
			/* Default exit sequence for state State8 */
			handle->stateConfVector[0] = ShallowHistory_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
			handle->historyVector[1] = handle->stateConfVector[0];
			handle->historyVector[0] = handle->stateConfVector[0];
			/* Default exit sequence for state State9 */
			handle->stateConfVector[0] = ShallowHistory_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State5 : {
			handle->historyVector[0] = handle->stateConfVector[0];
			/* Default exit sequence for state State5 */
			handle->stateConfVector[0] = ShallowHistory_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		default: break;
	}
	shallowHistory_exitaction(handle);
}

static void clearInEvents(ShallowHistory* handle) {
	handle->iface.event1_raised = bool_false;
	handle->iface.event2_raised = bool_false;
	handle->iface.event3_raised = bool_false;
	handle->iface.event4_raised = bool_false;
	handle->iface.event5_raised = bool_false;
	handle->iface.event6_raised = bool_false;
	handle->iface.event7_raised = bool_false;
	handle->iface.event8_raised = bool_false;
}

static void clearOutEvents(ShallowHistory* handle) {
}

void shallowHistory_runCycle(ShallowHistory* handle) {
	
	clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < SHALLOWHISTORY_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++) {
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition]) {
		case ShallowHistory_mainRegion_State1 : {
			shallowHistory_react_mainRegion_State1(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State3 : {
			shallowHistory_react_mainRegion_State2_region0_State3(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 : {
			shallowHistory_react_mainRegion_State2_region0_State4_region0_State6(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
			shallowHistory_react_mainRegion_State2_region0_State4_region0_State7_region0_State8(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
			shallowHistory_react_mainRegion_State2_region0_State4_region0_State7_region0_State9(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State5 : {
			shallowHistory_react_mainRegion_State2_region0_State5(handle);
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents(handle);
}


sc_boolean shallowHistory_isActive(ShallowHistory* handle, ShallowHistoryStates state) {
	switch (state) {
		case ShallowHistory_mainRegion_State1 : 
			return (sc_boolean) (handle->stateConfVector[0] == ShallowHistory_mainRegion_State1
			);
		case ShallowHistory_mainRegion_State2 : 
			return (sc_boolean) (handle->stateConfVector[0] >= ShallowHistory_mainRegion_State2
				&& handle->stateConfVector[0] <= ShallowHistory_mainRegion_State2__region0_State5);
		case ShallowHistory_mainRegion_State2__region0_State3 : 
			return (sc_boolean) (handle->stateConfVector[0] == ShallowHistory_mainRegion_State2__region0_State3
			);
		case ShallowHistory_mainRegion_State2__region0_State4 : 
			return (sc_boolean) (handle->stateConfVector[0] >= ShallowHistory_mainRegion_State2__region0_State4
				&& handle->stateConfVector[0] <= ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9);
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 : 
			return (sc_boolean) (handle->stateConfVector[0] == ShallowHistory_mainRegion_State2__region0_State4__region0_State6
			);
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7 : 
			return (sc_boolean) (handle->stateConfVector[0] >= ShallowHistory_mainRegion_State2__region0_State4__region0_State7
				&& handle->stateConfVector[0] <= ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9);
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : 
			return (sc_boolean) (handle->stateConfVector[0] == ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8
			);
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : 
			return (sc_boolean) (handle->stateConfVector[0] == ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9
			);
		case ShallowHistory_mainRegion_State2__region0_State5 : 
			return (sc_boolean) (handle->stateConfVector[0] == ShallowHistory_mainRegion_State2__region0_State5
			);
		default: return bool_false;
	}
}

void shallowHistoryIface_raise_event1(ShallowHistory* handle) {
	handle->iface.event1_raised = bool_true;
}
void shallowHistoryIface_raise_event2(ShallowHistory* handle) {
	handle->iface.event2_raised = bool_true;
}
void shallowHistoryIface_raise_event3(ShallowHistory* handle) {
	handle->iface.event3_raised = bool_true;
}
void shallowHistoryIface_raise_event4(ShallowHistory* handle) {
	handle->iface.event4_raised = bool_true;
}
void shallowHistoryIface_raise_event5(ShallowHistory* handle) {
	handle->iface.event5_raised = bool_true;
}
void shallowHistoryIface_raise_event6(ShallowHistory* handle) {
	handle->iface.event6_raised = bool_true;
}
void shallowHistoryIface_raise_event7(ShallowHistory* handle) {
	handle->iface.event7_raised = bool_true;
}
void shallowHistoryIface_raise_event8(ShallowHistory* handle) {
	handle->iface.event8_raised = bool_true;
}


		
// implementations of all internal functions

/* Entry action for statechart 'ShallowHistory'. */
static void shallowHistory_entryaction(ShallowHistory* handle) {
	/* Entry action for statechart 'ShallowHistory'. */
}

/* Exit action for state 'ShallowHistory'. */
static void shallowHistory_exitaction(ShallowHistory* handle) {
	/* Exit action for state 'ShallowHistory'. */
}

/* shallow enterSequence with history in child null */
static void shallowHistory_shallowentersequence_mainRegion_State2_region0(ShallowHistory* handle) {
	/* shallow enterSequence with history in child null */
	/* Handle shallow history entry of null */
	switch(handle->historyVector[ 0 ]) {
		case ShallowHistory_mainRegion_State2__region0_State3 : {
			/* Default enter sequence for state State3 */
			handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State3;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 : {
			/* Default enter sequence for state State4 */
			/* Default enter sequence for region null */
			/* Default react sequence for initial entry  */
			/* Default enter sequence for state State6 */
			handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State6;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
			/* Default enter sequence for state State4 */
			/* Default enter sequence for region null */
			/* Default react sequence for initial entry  */
			/* Default enter sequence for state State6 */
			handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State6;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
			/* Default enter sequence for state State4 */
			/* Default enter sequence for region null */
			/* Default react sequence for initial entry  */
			/* Default enter sequence for state State6 */
			handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State6;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State5 : {
			/* Default enter sequence for state State5 */
			handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State5;
			handle->stateConfVectorPosition = 0;
			break;
		}
		default: break;
	}
}

/* shallow enterSequence with history in child null */
static void shallowHistory_shallowentersequence_mainRegion_State2_region0_State4_region0_State7_region0(ShallowHistory* handle) {
	/* shallow enterSequence with history in child null */
	/* Handle shallow history entry of null */
	switch(handle->historyVector[ 1 ]) {
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
			/* Default enter sequence for state State8 */
			handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
			/* Default enter sequence for state State9 */
			handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9;
			handle->stateConfVectorPosition = 0;
			break;
		}
		default: break;
	}
}

/* The reactions of state State1. */
static void shallowHistory_react_mainRegion_State1(ShallowHistory* handle) {
	/* The reactions of state State1. */
	if (handle->iface.event1_raised) { 
		/* Default exit sequence for state State1 */
		handle->stateConfVector[0] = ShallowHistory_last_state;
		handle->stateConfVectorPosition = 0;
		/* Default enter sequence for state State2 */
		/* Default enter sequence for region null */
		/* Default react sequence for shallow history entry  */
		/* Enter the region with shallow history */
		if (handle->historyVector[0] != ShallowHistory_last_state) {
			shallowHistory_shallowentersequence_mainRegion_State2_region0(handle);
		} else {
			/* Default enter sequence for state State3 */
			handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State3;
			handle->stateConfVectorPosition = 0;
		}
	} 
}

/* The reactions of state State3. */
static void shallowHistory_react_mainRegion_State2_region0_State3(ShallowHistory* handle) {
	/* The reactions of state State3. */
	if (handle->iface.event2_raised) { 
		/* Default exit sequence for state State2 */
		/* Default exit sequence for region null */
		handle->historyVector[0] = handle->stateConfVector[0];
		/* Handle exit of all possible states (of region0) at position 0... */
		switch(handle->stateConfVector[ 0 ]) {
			case ShallowHistory_mainRegion_State2__region0_State3 : {
				/* Default exit sequence for state State3 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 : {
				/* Default exit sequence for state State6 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State8 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State9 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State5 : {
				/* Default exit sequence for state State5 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			default: break;
		}
		/* Default enter sequence for state State1 */
		handle->stateConfVector[0] = ShallowHistory_mainRegion_State1;
		handle->stateConfVectorPosition = 0;
	}  else {
		if (handle->iface.event3_raised) { 
			/* Default exit sequence for state State3 */
			handle->stateConfVector[0] = ShallowHistory_last_state;
			handle->stateConfVectorPosition = 0;
			/* Default enter sequence for state State4 */
			/* Default enter sequence for region null */
			/* Default react sequence for initial entry  */
			/* Default enter sequence for state State6 */
			handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State6;
			handle->stateConfVectorPosition = 0;
		} 
	}
}

/* The reactions of state State6. */
static void shallowHistory_react_mainRegion_State2_region0_State4_region0_State6(ShallowHistory* handle) {
	/* The reactions of state State6. */
	if (handle->iface.event2_raised) { 
		/* Default exit sequence for state State2 */
		/* Default exit sequence for region null */
		handle->historyVector[0] = handle->stateConfVector[0];
		/* Handle exit of all possible states (of region0) at position 0... */
		switch(handle->stateConfVector[ 0 ]) {
			case ShallowHistory_mainRegion_State2__region0_State3 : {
				/* Default exit sequence for state State3 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 : {
				/* Default exit sequence for state State6 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State8 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State9 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State5 : {
				/* Default exit sequence for state State5 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			default: break;
		}
		/* Default enter sequence for state State1 */
		handle->stateConfVector[0] = ShallowHistory_mainRegion_State1;
		handle->stateConfVectorPosition = 0;
	}  else {
		if (handle->iface.event4_raised) { 
			/* Default exit sequence for state State4 */
			/* Default exit sequence for region null */
			/* Handle exit of all possible states (of region0) at position 0... */
			switch(handle->stateConfVector[ 0 ]) {
				case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 : {
					/* Default exit sequence for state State6 */
					handle->stateConfVector[0] = ShallowHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
					handle->historyVector[1] = handle->stateConfVector[0];
					/* Default exit sequence for state State8 */
					handle->stateConfVector[0] = ShallowHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
					handle->historyVector[1] = handle->stateConfVector[0];
					/* Default exit sequence for state State9 */
					handle->stateConfVector[0] = ShallowHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				default: break;
			}
			/* Default enter sequence for state State5 */
			handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State5;
			handle->stateConfVectorPosition = 0;
		}  else {
			if (handle->iface.event5_raised) { 
				/* Default exit sequence for state State6 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				/* Default enter sequence for state State7 */
				/* Default enter sequence for region null */
				/* Default react sequence for shallow history entry  */
				/* Enter the region with shallow history */
				if (handle->historyVector[1] != ShallowHistory_last_state) {
					shallowHistory_shallowentersequence_mainRegion_State2_region0_State4_region0_State7_region0(handle);
				} else {
					/* Default enter sequence for state State8 */
					handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8;
					handle->stateConfVectorPosition = 0;
				}
			} 
		}
	}
}

/* The reactions of state State8. */
static void shallowHistory_react_mainRegion_State2_region0_State4_region0_State7_region0_State8(ShallowHistory* handle) {
	/* The reactions of state State8. */
	if (handle->iface.event2_raised) { 
		/* Default exit sequence for state State2 */
		/* Default exit sequence for region null */
		handle->historyVector[0] = handle->stateConfVector[0];
		/* Handle exit of all possible states (of region0) at position 0... */
		switch(handle->stateConfVector[ 0 ]) {
			case ShallowHistory_mainRegion_State2__region0_State3 : {
				/* Default exit sequence for state State3 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 : {
				/* Default exit sequence for state State6 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State8 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State9 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State5 : {
				/* Default exit sequence for state State5 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			default: break;
		}
		/* Default enter sequence for state State1 */
		handle->stateConfVector[0] = ShallowHistory_mainRegion_State1;
		handle->stateConfVectorPosition = 0;
	}  else {
		if (handle->iface.event4_raised) { 
			/* Default exit sequence for state State4 */
			/* Default exit sequence for region null */
			/* Handle exit of all possible states (of region0) at position 0... */
			switch(handle->stateConfVector[ 0 ]) {
				case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 : {
					/* Default exit sequence for state State6 */
					handle->stateConfVector[0] = ShallowHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
					handle->historyVector[1] = handle->stateConfVector[0];
					/* Default exit sequence for state State8 */
					handle->stateConfVector[0] = ShallowHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
					handle->historyVector[1] = handle->stateConfVector[0];
					/* Default exit sequence for state State9 */
					handle->stateConfVector[0] = ShallowHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				default: break;
			}
			/* Default enter sequence for state State5 */
			handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State5;
			handle->stateConfVectorPosition = 0;
		}  else {
			if (handle->iface.event6_raised) { 
				/* Default exit sequence for state State7 */
				/* Default exit sequence for region null */
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Handle exit of all possible states (of region0) at position 0... */
				switch(handle->stateConfVector[ 0 ]) {
					case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
						/* Default exit sequence for state State8 */
						handle->stateConfVector[0] = ShallowHistory_last_state;
						handle->stateConfVectorPosition = 0;
						break;
					}
					case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
						/* Default exit sequence for state State9 */
						handle->stateConfVector[0] = ShallowHistory_last_state;
						handle->stateConfVectorPosition = 0;
						break;
					}
					default: break;
				}
				/* Default enter sequence for state State6 */
				handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State6;
				handle->stateConfVectorPosition = 0;
			}  else {
				if (handle->iface.event7_raised) { 
					/* Default exit sequence for state State8 */
					handle->stateConfVector[0] = ShallowHistory_last_state;
					handle->stateConfVectorPosition = 0;
					/* Default enter sequence for state State9 */
					handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9;
					handle->stateConfVectorPosition = 0;
				} 
			}
		}
	}
}

/* The reactions of state State9. */
static void shallowHistory_react_mainRegion_State2_region0_State4_region0_State7_region0_State9(ShallowHistory* handle) {
	/* The reactions of state State9. */
	if (handle->iface.event2_raised) { 
		/* Default exit sequence for state State2 */
		/* Default exit sequence for region null */
		handle->historyVector[0] = handle->stateConfVector[0];
		/* Handle exit of all possible states (of region0) at position 0... */
		switch(handle->stateConfVector[ 0 ]) {
			case ShallowHistory_mainRegion_State2__region0_State3 : {
				/* Default exit sequence for state State3 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 : {
				/* Default exit sequence for state State6 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State8 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State9 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State5 : {
				/* Default exit sequence for state State5 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			default: break;
		}
		/* Default enter sequence for state State1 */
		handle->stateConfVector[0] = ShallowHistory_mainRegion_State1;
		handle->stateConfVectorPosition = 0;
	}  else {
		if (handle->iface.event4_raised) { 
			/* Default exit sequence for state State4 */
			/* Default exit sequence for region null */
			/* Handle exit of all possible states (of region0) at position 0... */
			switch(handle->stateConfVector[ 0 ]) {
				case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 : {
					/* Default exit sequence for state State6 */
					handle->stateConfVector[0] = ShallowHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
					handle->historyVector[1] = handle->stateConfVector[0];
					/* Default exit sequence for state State8 */
					handle->stateConfVector[0] = ShallowHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
					handle->historyVector[1] = handle->stateConfVector[0];
					/* Default exit sequence for state State9 */
					handle->stateConfVector[0] = ShallowHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				default: break;
			}
			/* Default enter sequence for state State5 */
			handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State5;
			handle->stateConfVectorPosition = 0;
		}  else {
			if (handle->iface.event6_raised) { 
				/* Default exit sequence for state State7 */
				/* Default exit sequence for region null */
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Handle exit of all possible states (of region0) at position 0... */
				switch(handle->stateConfVector[ 0 ]) {
					case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
						/* Default exit sequence for state State8 */
						handle->stateConfVector[0] = ShallowHistory_last_state;
						handle->stateConfVectorPosition = 0;
						break;
					}
					case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
						/* Default exit sequence for state State9 */
						handle->stateConfVector[0] = ShallowHistory_last_state;
						handle->stateConfVectorPosition = 0;
						break;
					}
					default: break;
				}
				/* Default enter sequence for state State6 */
				handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State6;
				handle->stateConfVectorPosition = 0;
			}  else {
				if (handle->iface.event8_raised) { 
					/* Default exit sequence for state State9 */
					handle->stateConfVector[0] = ShallowHistory_last_state;
					handle->stateConfVectorPosition = 0;
					/* Default enter sequence for state State8 */
					handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8;
					handle->stateConfVectorPosition = 0;
				} 
			}
		}
	}
}

/* The reactions of state State5. */
static void shallowHistory_react_mainRegion_State2_region0_State5(ShallowHistory* handle) {
	/* The reactions of state State5. */
	if (handle->iface.event2_raised) { 
		/* Default exit sequence for state State2 */
		/* Default exit sequence for region null */
		handle->historyVector[0] = handle->stateConfVector[0];
		/* Handle exit of all possible states (of region0) at position 0... */
		switch(handle->stateConfVector[ 0 ]) {
			case ShallowHistory_mainRegion_State2__region0_State3 : {
				/* Default exit sequence for state State3 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 : {
				/* Default exit sequence for state State6 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State8 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State9 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case ShallowHistory_mainRegion_State2__region0_State5 : {
				/* Default exit sequence for state State5 */
				handle->stateConfVector[0] = ShallowHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			default: break;
		}
		/* Default enter sequence for state State1 */
		handle->stateConfVector[0] = ShallowHistory_mainRegion_State1;
		handle->stateConfVectorPosition = 0;
	}  else {
	}
}


