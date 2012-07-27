#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "DeepHistory.h"
#include "DeepHistoryRequired.h"

/*! \file Implementation of the state machine 'DeepHistory'
*/

// prototypes of all internal functions

static void deepHistory_entryaction(DeepHistory* handle);
static void deepHistory_exitaction(DeepHistory* handle);
static void deepHistory_deepentersequence_mainRegion_State2_region0(DeepHistory* handle);
static void deepHistory_deepentersequence_mainRegion_State2_region0_State4_region0(DeepHistory* handle);
static void deepHistory_deepentersequence_mainRegion_State2_region0_State4_region0_State7_region0(DeepHistory* handle);
static void deepHistory_react_mainRegion_State1(DeepHistory* handle);
static void deepHistory_react_mainRegion_State2_region0_a(DeepHistory* handle);
static void deepHistory_react_mainRegion_State2_region0_State4_region0_State6(DeepHistory* handle);
static void deepHistory_react_mainRegion_State2_region0_State4_region0_State7_region0_State8(DeepHistory* handle);
static void deepHistory_react_mainRegion_State2_region0_State4_region0_State7_region0_State9(DeepHistory* handle);
static void deepHistory_react_mainRegion_State2_region0_State5(DeepHistory* handle);
static void clearInEvents(DeepHistory* handle);
static void clearOutEvents(DeepHistory* handle);


void deepHistory_init(DeepHistory* handle)
{
	int i;

	for (i = 0; i < DEEPHISTORY_MAX_ORTHOGONAL_STATES; ++i)
		handle->stateConfVector[i] = DeepHistory_last_state;
	
	for (i = 0; i < DEEPHISTORY_MAX_HISTORY_STATES; ++i)
		handle->historyVector[i] = DeepHistory_last_state;
	
	handle->stateConfVectorPosition = 0;

	// TODO: initialize all events ...
	// TODO: initialize all variables ... (set default values - here or inenter sequence ?!?)

}

void deepHistory_enter(DeepHistory* handle)
{
	/* Default enter sequence for statechart DeepHistory */
	deepHistory_entryaction(handle);
	/* Default enter sequence for region mainRegion */
	/* Default react sequence for initial entry  */
	/* Default enter sequence for state State1 */
	handle->stateConfVector[0] = DeepHistory_mainRegion_State1;
	handle->stateConfVectorPosition = 0;
}

void deepHistory_exit(DeepHistory* handle)
{
	/* Default exit sequence for statechart DeepHistory */
	/* Default exit sequence for region mainRegion */
	/* Handle exit of all possible states (of mainRegion) at position 0... */
	switch(handle->stateConfVector[ 0 ]) {
		case DeepHistory_mainRegion_State1 : {
			/* Default exit sequence for state State1 */
			handle->stateConfVector[0] = DeepHistory_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case DeepHistory_mainRegion_State2__region0_a : {
			handle->historyVector[0] = handle->stateConfVector[0];
			/* Default exit sequence for state a */
			handle->stateConfVector[0] = DeepHistory_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State6 : {
			handle->historyVector[1] = handle->stateConfVector[0];
			handle->historyVector[0] = handle->stateConfVector[0];
			/* Default exit sequence for state State6 */
			handle->stateConfVector[0] = DeepHistory_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
			handle->historyVector[2] = handle->stateConfVector[0];
			handle->historyVector[1] = handle->stateConfVector[0];
			handle->historyVector[0] = handle->stateConfVector[0];
			/* Default exit sequence for state State8 */
			handle->stateConfVector[0] = DeepHistory_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
			handle->historyVector[2] = handle->stateConfVector[0];
			handle->historyVector[1] = handle->stateConfVector[0];
			handle->historyVector[0] = handle->stateConfVector[0];
			/* Default exit sequence for state State9 */
			handle->stateConfVector[0] = DeepHistory_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State5 : {
			handle->historyVector[0] = handle->stateConfVector[0];
			/* Default exit sequence for state State5 */
			handle->stateConfVector[0] = DeepHistory_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		default: break;
	}
	deepHistory_exitaction(handle);
}

static void clearInEvents(DeepHistory* handle) {
	handle->iface.event1_raised = bool_false;
	handle->iface.event2_raised = bool_false;
	handle->iface.event3_raised = bool_false;
	handle->iface.event4_raised = bool_false;
	handle->iface.event5_raised = bool_false;
	handle->iface.event6_raised = bool_false;
	handle->iface.event7_raised = bool_false;
	handle->iface.event8_raised = bool_false;
	handle->iface.event9_raised = bool_false;
}

static void clearOutEvents(DeepHistory* handle) {
}

void deepHistory_runCycle(DeepHistory* handle) {
	
	clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < DEEPHISTORY_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++) {
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition]) {
		case DeepHistory_mainRegion_State1 : {
			deepHistory_react_mainRegion_State1(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_a : {
			deepHistory_react_mainRegion_State2_region0_a(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State6 : {
			deepHistory_react_mainRegion_State2_region0_State4_region0_State6(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
			deepHistory_react_mainRegion_State2_region0_State4_region0_State7_region0_State8(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
			deepHistory_react_mainRegion_State2_region0_State4_region0_State7_region0_State9(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State5 : {
			deepHistory_react_mainRegion_State2_region0_State5(handle);
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents(handle);
}


sc_boolean deepHistory_isActive(DeepHistory* handle, DeepHistoryStates state) {
	switch (state) {
		case DeepHistory_mainRegion_State1 : 
			return (sc_boolean) (handle->stateConfVector[0] == DeepHistory_mainRegion_State1
			);
		case DeepHistory_mainRegion_State2 : 
			return (sc_boolean) (handle->stateConfVector[0] >= DeepHistory_mainRegion_State2
				&& handle->stateConfVector[0] <= DeepHistory_mainRegion_State2__region0_State5);
		case DeepHistory_mainRegion_State2__region0_a : 
			return (sc_boolean) (handle->stateConfVector[0] == DeepHistory_mainRegion_State2__region0_a
			);
		case DeepHistory_mainRegion_State2__region0_State4 : 
			return (sc_boolean) (handle->stateConfVector[0] >= DeepHistory_mainRegion_State2__region0_State4
				&& handle->stateConfVector[0] <= DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9);
		case DeepHistory_mainRegion_State2__region0_State4__region0_State6 : 
			return (sc_boolean) (handle->stateConfVector[0] == DeepHistory_mainRegion_State2__region0_State4__region0_State6
			);
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7 : 
			return (sc_boolean) (handle->stateConfVector[0] >= DeepHistory_mainRegion_State2__region0_State4__region0_State7
				&& handle->stateConfVector[0] <= DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9);
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : 
			return (sc_boolean) (handle->stateConfVector[0] == DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8
			);
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : 
			return (sc_boolean) (handle->stateConfVector[0] == DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9
			);
		case DeepHistory_mainRegion_State2__region0_State5 : 
			return (sc_boolean) (handle->stateConfVector[0] == DeepHistory_mainRegion_State2__region0_State5
			);
		default: return bool_false;
	}
}

void deepHistoryIface_raise_event1(DeepHistory* handle) {
	handle->iface.event1_raised = bool_true;
}
void deepHistoryIface_raise_event2(DeepHistory* handle) {
	handle->iface.event2_raised = bool_true;
}
void deepHistoryIface_raise_event3(DeepHistory* handle) {
	handle->iface.event3_raised = bool_true;
}
void deepHistoryIface_raise_event4(DeepHistory* handle) {
	handle->iface.event4_raised = bool_true;
}
void deepHistoryIface_raise_event5(DeepHistory* handle) {
	handle->iface.event5_raised = bool_true;
}
void deepHistoryIface_raise_event6(DeepHistory* handle) {
	handle->iface.event6_raised = bool_true;
}
void deepHistoryIface_raise_event7(DeepHistory* handle) {
	handle->iface.event7_raised = bool_true;
}
void deepHistoryIface_raise_event8(DeepHistory* handle) {
	handle->iface.event8_raised = bool_true;
}
void deepHistoryIface_raise_event9(DeepHistory* handle) {
	handle->iface.event9_raised = bool_true;
}


		
// implementations of all internal functions

/* Entry action for statechart 'DeepHistory'. */
static void deepHistory_entryaction(DeepHistory* handle) {
	/* Entry action for statechart 'DeepHistory'. */
}

/* Exit action for state 'DeepHistory'. */
static void deepHistory_exitaction(DeepHistory* handle) {
	/* Exit action for state 'DeepHistory'. */
}

/* deep enterSequence with history in child null */
static void deepHistory_deepentersequence_mainRegion_State2_region0(DeepHistory* handle) {
	/* deep enterSequence with history in child null */
	/* Handle deep history entry of null */
	switch(handle->historyVector[ 0 ]) {
		case DeepHistory_mainRegion_State2__region0_a : {
			/* enterSequence with history in child a for leaf a */
			/* Default enter sequence for state a */
			handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_a;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State6 : {
			/* enterSequence with history in child State4 for leaf State6 */
			deepHistory_deepentersequence_mainRegion_State2_region0_State4_region0(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
			/* enterSequence with history in child State4 for leaf State8 */
			deepHistory_deepentersequence_mainRegion_State2_region0_State4_region0(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
			/* enterSequence with history in child State4 for leaf State9 */
			deepHistory_deepentersequence_mainRegion_State2_region0_State4_region0(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State5 : {
			/* enterSequence with history in child State5 for leaf State5 */
			/* Default enter sequence for state State5 */
			handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State5;
			handle->stateConfVectorPosition = 0;
			break;
		}
		default: break;
	}
}

/* deep enterSequence with history in child null */
static void deepHistory_deepentersequence_mainRegion_State2_region0_State4_region0(DeepHistory* handle) {
	/* deep enterSequence with history in child null */
	/* Handle deep history entry of null */
	switch(handle->historyVector[ 1 ]) {
		case DeepHistory_mainRegion_State2__region0_State4__region0_State6 : {
			/* enterSequence with history in child State6 for leaf State6 */
			/* Default enter sequence for state State6 */
			handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State4__region0_State6;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
			/* enterSequence with history in child State7 for leaf State8 */
			deepHistory_deepentersequence_mainRegion_State2_region0_State4_region0_State7_region0(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
			/* enterSequence with history in child State7 for leaf State9 */
			deepHistory_deepentersequence_mainRegion_State2_region0_State4_region0_State7_region0(handle);
			break;
		}
		default: break;
	}
}

/* deep enterSequence with history in child null */
static void deepHistory_deepentersequence_mainRegion_State2_region0_State4_region0_State7_region0(DeepHistory* handle) {
	/* deep enterSequence with history in child null */
	/* Handle deep history entry of null */
	switch(handle->historyVector[ 2 ]) {
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
			/* enterSequence with history in child State8 for leaf State8 */
			/* Default enter sequence for state State8 */
			handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
			/* enterSequence with history in child State9 for leaf State9 */
			/* Default enter sequence for state State9 */
			handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9;
			handle->stateConfVectorPosition = 0;
			break;
		}
		default: break;
	}
}

/* The reactions of state State1. */
static void deepHistory_react_mainRegion_State1(DeepHistory* handle) {
	/* The reactions of state State1. */
	if (handle->iface.event1_raised) { 
		/* Default exit sequence for state State1 */
		handle->stateConfVector[0] = DeepHistory_last_state;
		handle->stateConfVectorPosition = 0;
		/* Default enter sequence for state State2 */
		/* Default enter sequence for region null */
		/* Default react sequence for deep history entry  */
		/* Enter the region with deep history */
		if (handle->historyVector[0] != DeepHistory_last_state) {
			deepHistory_deepentersequence_mainRegion_State2_region0(handle);
		} else {
			/* Default enter sequence for state a */
			handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_a;
			handle->stateConfVectorPosition = 0;
		}
	} 
}

/* The reactions of state a. */
static void deepHistory_react_mainRegion_State2_region0_a(DeepHistory* handle) {
	/* The reactions of state a. */
	if (handle->iface.event2_raised) { 
		/* Default exit sequence for state State2 */
		/* Default exit sequence for region null */
		handle->historyVector[0] = handle->stateConfVector[0];
		/* Handle exit of all possible states (of region0) at position 0... */
		switch(handle->stateConfVector[ 0 ]) {
			case DeepHistory_mainRegion_State2__region0_a : {
				/* Default exit sequence for state a */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State6 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State6 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
				handle->historyVector[2] = handle->stateConfVector[0];
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State8 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
				handle->historyVector[2] = handle->stateConfVector[0];
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State9 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State5 : {
				/* Default exit sequence for state State5 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			default: break;
		}
		/* Default enter sequence for state State1 */
		handle->stateConfVector[0] = DeepHistory_mainRegion_State1;
		handle->stateConfVectorPosition = 0;
	}  else {
		if (bool_true) { 
			/* Default exit sequence for state a */
			handle->stateConfVector[0] = DeepHistory_last_state;
			handle->stateConfVectorPosition = 0;
			/* Default enter sequence for state State4 */
			/* Default enter sequence for region null */
			/* Default react sequence for initial entry  */
			/* Default enter sequence for state State6 */
			handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State4__region0_State6;
			handle->stateConfVectorPosition = 0;
		} 
	}
}

/* The reactions of state State6. */
static void deepHistory_react_mainRegion_State2_region0_State4_region0_State6(DeepHistory* handle) {
	/* The reactions of state State6. */
	if (handle->iface.event2_raised) { 
		/* Default exit sequence for state State2 */
		/* Default exit sequence for region null */
		handle->historyVector[0] = handle->stateConfVector[0];
		/* Handle exit of all possible states (of region0) at position 0... */
		switch(handle->stateConfVector[ 0 ]) {
			case DeepHistory_mainRegion_State2__region0_a : {
				/* Default exit sequence for state a */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State6 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State6 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
				handle->historyVector[2] = handle->stateConfVector[0];
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State8 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
				handle->historyVector[2] = handle->stateConfVector[0];
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State9 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State5 : {
				/* Default exit sequence for state State5 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			default: break;
		}
		/* Default enter sequence for state State1 */
		handle->stateConfVector[0] = DeepHistory_mainRegion_State1;
		handle->stateConfVectorPosition = 0;
	}  else {
		if (handle->iface.event4_raised) { 
			/* Default exit sequence for state State4 */
			/* Default exit sequence for region null */
			handle->historyVector[1] = handle->stateConfVector[0];
			/* Handle exit of all possible states (of region0) at position 0... */
			switch(handle->stateConfVector[ 0 ]) {
				case DeepHistory_mainRegion_State2__region0_State4__region0_State6 : {
					/* Default exit sequence for state State6 */
					handle->stateConfVector[0] = DeepHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
					handle->historyVector[2] = handle->stateConfVector[0];
					/* Default exit sequence for state State8 */
					handle->stateConfVector[0] = DeepHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
					handle->historyVector[2] = handle->stateConfVector[0];
					/* Default exit sequence for state State9 */
					handle->stateConfVector[0] = DeepHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				default: break;
			}
			/* Default enter sequence for state State5 */
			handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State5;
			handle->stateConfVectorPosition = 0;
		}  else {
			if (handle->iface.event5_raised) { 
				/* Default exit sequence for state State6 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				/* Default enter sequence for state State7 */
				/* Default enter sequence for region null */
				/* Default react sequence for initial entry  */
				/* Default enter sequence for state State8 */
				handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8;
				handle->stateConfVectorPosition = 0;
			} 
		}
	}
}

/* The reactions of state State8. */
static void deepHistory_react_mainRegion_State2_region0_State4_region0_State7_region0_State8(DeepHistory* handle) {
	/* The reactions of state State8. */
	if (handle->iface.event2_raised) { 
		/* Default exit sequence for state State2 */
		/* Default exit sequence for region null */
		handle->historyVector[0] = handle->stateConfVector[0];
		/* Handle exit of all possible states (of region0) at position 0... */
		switch(handle->stateConfVector[ 0 ]) {
			case DeepHistory_mainRegion_State2__region0_a : {
				/* Default exit sequence for state a */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State6 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State6 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
				handle->historyVector[2] = handle->stateConfVector[0];
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State8 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
				handle->historyVector[2] = handle->stateConfVector[0];
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State9 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State5 : {
				/* Default exit sequence for state State5 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			default: break;
		}
		/* Default enter sequence for state State1 */
		handle->stateConfVector[0] = DeepHistory_mainRegion_State1;
		handle->stateConfVectorPosition = 0;
	}  else {
		if (handle->iface.event4_raised) { 
			/* Default exit sequence for state State4 */
			/* Default exit sequence for region null */
			handle->historyVector[1] = handle->stateConfVector[0];
			/* Handle exit of all possible states (of region0) at position 0... */
			switch(handle->stateConfVector[ 0 ]) {
				case DeepHistory_mainRegion_State2__region0_State4__region0_State6 : {
					/* Default exit sequence for state State6 */
					handle->stateConfVector[0] = DeepHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
					handle->historyVector[2] = handle->stateConfVector[0];
					/* Default exit sequence for state State8 */
					handle->stateConfVector[0] = DeepHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
					handle->historyVector[2] = handle->stateConfVector[0];
					/* Default exit sequence for state State9 */
					handle->stateConfVector[0] = DeepHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				default: break;
			}
			/* Default enter sequence for state State5 */
			handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State5;
			handle->stateConfVectorPosition = 0;
		}  else {
			if (handle->iface.event6_raised) { 
				/* Default exit sequence for state State7 */
				/* Default exit sequence for region null */
				handle->historyVector[2] = handle->stateConfVector[0];
				/* Handle exit of all possible states (of region0) at position 0... */
				switch(handle->stateConfVector[ 0 ]) {
					case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
						/* Default exit sequence for state State8 */
						handle->stateConfVector[0] = DeepHistory_last_state;
						handle->stateConfVectorPosition = 0;
						break;
					}
					case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
						/* Default exit sequence for state State9 */
						handle->stateConfVector[0] = DeepHistory_last_state;
						handle->stateConfVectorPosition = 0;
						break;
					}
					default: break;
				}
				/* Default enter sequence for state State6 */
				handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State4__region0_State6;
				handle->stateConfVectorPosition = 0;
			}  else {
				if (handle->iface.event7_raised) { 
					/* Default exit sequence for state State8 */
					handle->stateConfVector[0] = DeepHistory_last_state;
					handle->stateConfVectorPosition = 0;
					/* Default enter sequence for state State9 */
					handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9;
					handle->stateConfVectorPosition = 0;
				} 
			}
		}
	}
}

/* The reactions of state State9. */
static void deepHistory_react_mainRegion_State2_region0_State4_region0_State7_region0_State9(DeepHistory* handle) {
	/* The reactions of state State9. */
	if (handle->iface.event2_raised) { 
		/* Default exit sequence for state State2 */
		/* Default exit sequence for region null */
		handle->historyVector[0] = handle->stateConfVector[0];
		/* Handle exit of all possible states (of region0) at position 0... */
		switch(handle->stateConfVector[ 0 ]) {
			case DeepHistory_mainRegion_State2__region0_a : {
				/* Default exit sequence for state a */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State6 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State6 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
				handle->historyVector[2] = handle->stateConfVector[0];
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State8 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
				handle->historyVector[2] = handle->stateConfVector[0];
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State9 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State5 : {
				/* Default exit sequence for state State5 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			default: break;
		}
		/* Default enter sequence for state State1 */
		handle->stateConfVector[0] = DeepHistory_mainRegion_State1;
		handle->stateConfVectorPosition = 0;
	}  else {
		if (handle->iface.event4_raised) { 
			/* Default exit sequence for state State4 */
			/* Default exit sequence for region null */
			handle->historyVector[1] = handle->stateConfVector[0];
			/* Handle exit of all possible states (of region0) at position 0... */
			switch(handle->stateConfVector[ 0 ]) {
				case DeepHistory_mainRegion_State2__region0_State4__region0_State6 : {
					/* Default exit sequence for state State6 */
					handle->stateConfVector[0] = DeepHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
					handle->historyVector[2] = handle->stateConfVector[0];
					/* Default exit sequence for state State8 */
					handle->stateConfVector[0] = DeepHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
					handle->historyVector[2] = handle->stateConfVector[0];
					/* Default exit sequence for state State9 */
					handle->stateConfVector[0] = DeepHistory_last_state;
					handle->stateConfVectorPosition = 0;
					break;
				}
				default: break;
			}
			/* Default enter sequence for state State5 */
			handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State5;
			handle->stateConfVectorPosition = 0;
		}  else {
			if (handle->iface.event6_raised) { 
				/* Default exit sequence for state State7 */
				/* Default exit sequence for region null */
				handle->historyVector[2] = handle->stateConfVector[0];
				/* Handle exit of all possible states (of region0) at position 0... */
				switch(handle->stateConfVector[ 0 ]) {
					case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
						/* Default exit sequence for state State8 */
						handle->stateConfVector[0] = DeepHistory_last_state;
						handle->stateConfVectorPosition = 0;
						break;
					}
					case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
						/* Default exit sequence for state State9 */
						handle->stateConfVector[0] = DeepHistory_last_state;
						handle->stateConfVectorPosition = 0;
						break;
					}
					default: break;
				}
				/* Default enter sequence for state State6 */
				handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State4__region0_State6;
				handle->stateConfVectorPosition = 0;
			}  else {
				if (handle->iface.event8_raised) { 
					/* Default exit sequence for state State9 */
					handle->stateConfVector[0] = DeepHistory_last_state;
					handle->stateConfVectorPosition = 0;
					/* Default enter sequence for state State8 */
					handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8;
					handle->stateConfVectorPosition = 0;
				} 
			}
		}
	}
}

/* The reactions of state State5. */
static void deepHistory_react_mainRegion_State2_region0_State5(DeepHistory* handle) {
	/* The reactions of state State5. */
	if (handle->iface.event2_raised) { 
		/* Default exit sequence for state State2 */
		/* Default exit sequence for region null */
		handle->historyVector[0] = handle->stateConfVector[0];
		/* Handle exit of all possible states (of region0) at position 0... */
		switch(handle->stateConfVector[ 0 ]) {
			case DeepHistory_mainRegion_State2__region0_a : {
				/* Default exit sequence for state a */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State6 : {
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State6 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 : {
				handle->historyVector[2] = handle->stateConfVector[0];
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State8 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 : {
				handle->historyVector[2] = handle->stateConfVector[0];
				handle->historyVector[1] = handle->stateConfVector[0];
				/* Default exit sequence for state State9 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case DeepHistory_mainRegion_State2__region0_State5 : {
				/* Default exit sequence for state State5 */
				handle->stateConfVector[0] = DeepHistory_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			default: break;
		}
		/* Default enter sequence for state State1 */
		handle->stateConfVector[0] = DeepHistory_mainRegion_State1;
		handle->stateConfVectorPosition = 0;
	}  else {
	}
}


