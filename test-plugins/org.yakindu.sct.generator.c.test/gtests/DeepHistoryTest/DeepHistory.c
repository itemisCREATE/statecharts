
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "DeepHistory.h"
/*! \file Implementation of the state machine 'DeepHistory'
*/

/* prototypes of all internal functions */
static sc_boolean deepHistory_check_mainRegion_State1_tr0_tr0(const DeepHistory* handle);
static sc_boolean deepHistory_check_mainRegion_State2_tr0_tr0(const DeepHistory* handle);
static sc_boolean deepHistory_check_mainRegion_State2__region0_a_tr0_tr0(const DeepHistory* handle);
static sc_boolean deepHistory_check_mainRegion_State2__region0_State4_tr0_tr0(const DeepHistory* handle);
static sc_boolean deepHistory_check_mainRegion_State2__region0_State4__region0_State6_tr0_tr0(const DeepHistory* handle);
static sc_boolean deepHistory_check_mainRegion_State2__region0_State4__region0_State7_tr0_tr0(const DeepHistory* handle);
static sc_boolean deepHistory_check_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0_tr0(const DeepHistory* handle);
static sc_boolean deepHistory_check_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0_tr0(const DeepHistory* handle);
static void deepHistory_effect_mainRegion_State1_tr0(DeepHistory* handle);
static void deepHistory_effect_mainRegion_State2_tr0(DeepHistory* handle);
static void deepHistory_effect_mainRegion_State2__region0_a_tr0(DeepHistory* handle);
static void deepHistory_effect_mainRegion_State2__region0_State4_tr0(DeepHistory* handle);
static void deepHistory_effect_mainRegion_State2__region0_State4__region0_State6_tr0(DeepHistory* handle);
static void deepHistory_effect_mainRegion_State2__region0_State4__region0_State7_tr0(DeepHistory* handle);
static void deepHistory_effect_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0(DeepHistory* handle);
static void deepHistory_effect_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0(DeepHistory* handle);
static void deepHistory_enseq_mainRegion_State1_default(DeepHistory* handle);
static void deepHistory_enseq_mainRegion_State2_default(DeepHistory* handle);
static void deepHistory_enseq_mainRegion_State2__region0_a_default(DeepHistory* handle);
static void deepHistory_enseq_mainRegion_State2__region0_State4_default(DeepHistory* handle);
static void deepHistory_enseq_mainRegion_State2__region0_State4__region0_State6_default(DeepHistory* handle);
static void deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7_default(DeepHistory* handle);
static void deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default(DeepHistory* handle);
static void deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default(DeepHistory* handle);
static void deepHistory_enseq_mainRegion_State2__region0_State5_default(DeepHistory* handle);
static void deepHistory_enseq_mainRegion_default(DeepHistory* handle);
static void deepHistory_enseq_mainRegion_State2__region0_default(DeepHistory* handle);
static void deepHistory_dhenseq_mainRegion_State2__region0(DeepHistory* handle);
static void deepHistory_enseq_mainRegion_State2__region0_State4__region0_default(DeepHistory* handle);
static void deepHistory_dhenseq_mainRegion_State2__region0_State4__region0(DeepHistory* handle);
static void deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_default(DeepHistory* handle);
static void deepHistory_dhenseq_mainRegion_State2__region0_State4__region0_State7__region0(DeepHistory* handle);
static void deepHistory_exseq_mainRegion_State1(DeepHistory* handle);
static void deepHistory_exseq_mainRegion_State2(DeepHistory* handle);
static void deepHistory_exseq_mainRegion_State2__region0_a(DeepHistory* handle);
static void deepHistory_exseq_mainRegion_State2__region0_State4(DeepHistory* handle);
static void deepHistory_exseq_mainRegion_State2__region0_State4__region0_State6(DeepHistory* handle);
static void deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7(DeepHistory* handle);
static void deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(DeepHistory* handle);
static void deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(DeepHistory* handle);
static void deepHistory_exseq_mainRegion_State2__region0_State5(DeepHistory* handle);
static void deepHistory_exseq_mainRegion(DeepHistory* handle);
static void deepHistory_exseq_mainRegion_State2__region0(DeepHistory* handle);
static void deepHistory_exseq_mainRegion_State2__region0_State4__region0(DeepHistory* handle);
static void deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0(DeepHistory* handle);
static void deepHistory_react_mainRegion_State1(DeepHistory* handle);
static void deepHistory_react_mainRegion_State2__region0_a(DeepHistory* handle);
static void deepHistory_react_mainRegion_State2__region0_State4__region0_State6(DeepHistory* handle);
static void deepHistory_react_mainRegion_State2__region0_State4__region0_State7__region0_State8(DeepHistory* handle);
static void deepHistory_react_mainRegion_State2__region0_State4__region0_State7__region0_State9(DeepHistory* handle);
static void deepHistory_react_mainRegion_State2__region0_State5(DeepHistory* handle);
static void deepHistory_react_mainRegion__entry_Default(DeepHistory* handle);
static void deepHistory_react_mainRegion_State2__region0_State4__region0__entry_Default(DeepHistory* handle);
static void deepHistory_react_mainRegion_State2__region0_State4__region0_State7__region0__entry_Default(DeepHistory* handle);
static void deepHistory_react_mainRegion_State2__region0__entry_Default(DeepHistory* handle);
static void deepHistory_clearInEvents(DeepHistory* handle);
static void deepHistory_clearOutEvents(DeepHistory* handle);


void deepHistory_init(DeepHistory* handle)
{
	sc_integer i;

	for (i = 0; i < DEEPHISTORY_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = DeepHistory_last_state;
	}
	
	for (i = 0; i < DEEPHISTORY_MAX_HISTORY_STATES; ++i)
	{
		handle->historyVector[i] = DeepHistory_last_state;
	}
	
	handle->stateConfVectorPosition = 0;

	deepHistory_clearInEvents(handle);
	deepHistory_clearOutEvents(handle);


}

void deepHistory_enter(DeepHistory* handle)
{
	/* Default enter sequence for statechart DeepHistory */
	deepHistory_enseq_mainRegion_default(handle);
}

void deepHistory_exit(DeepHistory* handle)
{
	/* Default exit sequence for statechart DeepHistory */
	deepHistory_exseq_mainRegion(handle);
}

sc_boolean deepHistory_isActive(const DeepHistory* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != DeepHistory_last_state)
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
sc_boolean deepHistory_isFinal(const DeepHistory* handle)
{
   return bool_false;
}

static void deepHistory_clearInEvents(DeepHistory* handle)
{
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

static void deepHistory_clearOutEvents(DeepHistory* handle)
{
}

void deepHistory_runCycle(DeepHistory* handle)
{
	
	deepHistory_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < DEEPHISTORY_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case DeepHistory_mainRegion_State1 :
		{
			deepHistory_react_mainRegion_State1(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_a :
		{
			deepHistory_react_mainRegion_State2__region0_a(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State6 :
		{
			deepHistory_react_mainRegion_State2__region0_State4__region0_State6(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			deepHistory_react_mainRegion_State2__region0_State4__region0_State7__region0_State8(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			deepHistory_react_mainRegion_State2__region0_State4__region0_State7__region0_State9(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State5 :
		{
			deepHistory_react_mainRegion_State2__region0_State5(handle);
			break;
		}
		default:
			break;
		}
	}
	
	deepHistory_clearInEvents(handle);
}


sc_boolean deepHistory_isStateActive(const DeepHistory* handle, DeepHistoryStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case DeepHistory_mainRegion_State1 :
			result = (sc_boolean) (handle->stateConfVector[0] == DeepHistory_mainRegion_State1
			);
			break;
		case DeepHistory_mainRegion_State2 :
			result = (sc_boolean) (handle->stateConfVector[0] >= DeepHistory_mainRegion_State2
				&& handle->stateConfVector[0] <= DeepHistory_mainRegion_State2__region0_State5);
			break;
		case DeepHistory_mainRegion_State2__region0_a :
			result = (sc_boolean) (handle->stateConfVector[0] == DeepHistory_mainRegion_State2__region0_a
			);
			break;
		case DeepHistory_mainRegion_State2__region0_State4 :
			result = (sc_boolean) (handle->stateConfVector[0] >= DeepHistory_mainRegion_State2__region0_State4
				&& handle->stateConfVector[0] <= DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9);
			break;
		case DeepHistory_mainRegion_State2__region0_State4__region0_State6 :
			result = (sc_boolean) (handle->stateConfVector[0] == DeepHistory_mainRegion_State2__region0_State4__region0_State6
			);
			break;
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7 :
			result = (sc_boolean) (handle->stateConfVector[0] >= DeepHistory_mainRegion_State2__region0_State4__region0_State7
				&& handle->stateConfVector[0] <= DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9);
			break;
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
			result = (sc_boolean) (handle->stateConfVector[0] == DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8
			);
			break;
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
			result = (sc_boolean) (handle->stateConfVector[0] == DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9
			);
			break;
		case DeepHistory_mainRegion_State2__region0_State5 :
			result = (sc_boolean) (handle->stateConfVector[0] == DeepHistory_mainRegion_State2__region0_State5
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void deepHistoryIface_raise_event1(DeepHistory* handle)
{
	handle->iface.event1_raised = bool_true;
}
void deepHistoryIface_raise_event2(DeepHistory* handle)
{
	handle->iface.event2_raised = bool_true;
}
void deepHistoryIface_raise_event3(DeepHistory* handle)
{
	handle->iface.event3_raised = bool_true;
}
void deepHistoryIface_raise_event4(DeepHistory* handle)
{
	handle->iface.event4_raised = bool_true;
}
void deepHistoryIface_raise_event5(DeepHistory* handle)
{
	handle->iface.event5_raised = bool_true;
}
void deepHistoryIface_raise_event6(DeepHistory* handle)
{
	handle->iface.event6_raised = bool_true;
}
void deepHistoryIface_raise_event7(DeepHistory* handle)
{
	handle->iface.event7_raised = bool_true;
}
void deepHistoryIface_raise_event8(DeepHistory* handle)
{
	handle->iface.event8_raised = bool_true;
}
void deepHistoryIface_raise_event9(DeepHistory* handle)
{
	handle->iface.event9_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean deepHistory_check_mainRegion_State1_tr0_tr0(const DeepHistory* handle)
{
	return handle->iface.event1_raised;
}

static sc_boolean deepHistory_check_mainRegion_State2_tr0_tr0(const DeepHistory* handle)
{
	return handle->iface.event2_raised;
}

static sc_boolean deepHistory_check_mainRegion_State2__region0_a_tr0_tr0(const DeepHistory* handle)
{
	return handle->iface.event3_raised;
}

static sc_boolean deepHistory_check_mainRegion_State2__region0_State4_tr0_tr0(const DeepHistory* handle)
{
	return handle->iface.event4_raised;
}

static sc_boolean deepHistory_check_mainRegion_State2__region0_State4__region0_State6_tr0_tr0(const DeepHistory* handle)
{
	return handle->iface.event5_raised;
}

static sc_boolean deepHistory_check_mainRegion_State2__region0_State4__region0_State7_tr0_tr0(const DeepHistory* handle)
{
	return handle->iface.event6_raised;
}

static sc_boolean deepHistory_check_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0_tr0(const DeepHistory* handle)
{
	return handle->iface.event7_raised;
}

static sc_boolean deepHistory_check_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0_tr0(const DeepHistory* handle)
{
	return handle->iface.event8_raised;
}

static void deepHistory_effect_mainRegion_State1_tr0(DeepHistory* handle)
{
	deepHistory_exseq_mainRegion_State1(handle);
	deepHistory_enseq_mainRegion_State2_default(handle);
}

static void deepHistory_effect_mainRegion_State2_tr0(DeepHistory* handle)
{
	deepHistory_exseq_mainRegion_State2(handle);
	deepHistory_enseq_mainRegion_State1_default(handle);
}

static void deepHistory_effect_mainRegion_State2__region0_a_tr0(DeepHistory* handle)
{
	deepHistory_exseq_mainRegion_State2__region0_a(handle);
	deepHistory_enseq_mainRegion_State2__region0_State4_default(handle);
}

static void deepHistory_effect_mainRegion_State2__region0_State4_tr0(DeepHistory* handle)
{
	deepHistory_exseq_mainRegion_State2__region0_State4(handle);
	deepHistory_enseq_mainRegion_State2__region0_State5_default(handle);
}

static void deepHistory_effect_mainRegion_State2__region0_State4__region0_State6_tr0(DeepHistory* handle)
{
	deepHistory_exseq_mainRegion_State2__region0_State4__region0_State6(handle);
	deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7_default(handle);
}

static void deepHistory_effect_mainRegion_State2__region0_State4__region0_State7_tr0(DeepHistory* handle)
{
	deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7(handle);
	deepHistory_enseq_mainRegion_State2__region0_State4__region0_State6_default(handle);
}

static void deepHistory_effect_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0(DeepHistory* handle)
{
	deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(handle);
	deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default(handle);
}

static void deepHistory_effect_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0(DeepHistory* handle)
{
	deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(handle);
	deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default(handle);
}

/* 'default' enter sequence for state State1 */
static void deepHistory_enseq_mainRegion_State1_default(DeepHistory* handle)
{
	/* 'default' enter sequence for state State1 */
	handle->stateConfVector[0] = DeepHistory_mainRegion_State1;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state State2 */
static void deepHistory_enseq_mainRegion_State2_default(DeepHistory* handle)
{
	/* 'default' enter sequence for state State2 */
	deepHistory_enseq_mainRegion_State2__region0_default(handle);
}

/* 'default' enter sequence for state a */
static void deepHistory_enseq_mainRegion_State2__region0_a_default(DeepHistory* handle)
{
	/* 'default' enter sequence for state a */
	handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_a;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state State4 */
static void deepHistory_enseq_mainRegion_State2__region0_State4_default(DeepHistory* handle)
{
	/* 'default' enter sequence for state State4 */
	deepHistory_enseq_mainRegion_State2__region0_State4__region0_default(handle);
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state State6 */
static void deepHistory_enseq_mainRegion_State2__region0_State4__region0_State6_default(DeepHistory* handle)
{
	/* 'default' enter sequence for state State6 */
	handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State4__region0_State6;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[1] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state State7 */
static void deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7_default(DeepHistory* handle)
{
	/* 'default' enter sequence for state State7 */
	deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_default(handle);
	handle->historyVector[1] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state State8 */
static void deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default(DeepHistory* handle)
{
	/* 'default' enter sequence for state State8 */
	handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[2] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state State9 */
static void deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default(DeepHistory* handle)
{
	/* 'default' enter sequence for state State9 */
	handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[2] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state State5 */
static void deepHistory_enseq_mainRegion_State2__region0_State5_default(DeepHistory* handle)
{
	/* 'default' enter sequence for state State5 */
	handle->stateConfVector[0] = DeepHistory_mainRegion_State2__region0_State5;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for region mainRegion */
static void deepHistory_enseq_mainRegion_default(DeepHistory* handle)
{
	/* 'default' enter sequence for region mainRegion */
	deepHistory_react_mainRegion__entry_Default(handle);
}

/* 'default' enter sequence for region null */
static void deepHistory_enseq_mainRegion_State2__region0_default(DeepHistory* handle)
{
	/* 'default' enter sequence for region null */
	deepHistory_react_mainRegion_State2__region0__entry_Default(handle);
}

/* deep enterSequence with history in child null */
static void deepHistory_dhenseq_mainRegion_State2__region0(DeepHistory* handle)
{
	/* deep enterSequence with history in child null */
	/* Handle deep history entry of null */
	switch(handle->historyVector[ 0 ])
	{
		case DeepHistory_mainRegion_State2__region0_a :
		{
			/* enterSequence with history in child a for leaf a */
			deepHistory_enseq_mainRegion_State2__region0_a_default(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State6 :
		{
			/* enterSequence with history in child State4 for leaf State6 */
			deepHistory_dhenseq_mainRegion_State2__region0_State4__region0(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			/* enterSequence with history in child State4 for leaf State8 */
			deepHistory_dhenseq_mainRegion_State2__region0_State4__region0(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			/* enterSequence with history in child State4 for leaf State9 */
			deepHistory_dhenseq_mainRegion_State2__region0_State4__region0(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State5 :
		{
			/* enterSequence with history in child State5 for leaf State5 */
			deepHistory_enseq_mainRegion_State2__region0_State5_default(handle);
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region null */
static void deepHistory_enseq_mainRegion_State2__region0_State4__region0_default(DeepHistory* handle)
{
	/* 'default' enter sequence for region null */
	deepHistory_react_mainRegion_State2__region0_State4__region0__entry_Default(handle);
}

/* deep enterSequence with history in child null */
static void deepHistory_dhenseq_mainRegion_State2__region0_State4__region0(DeepHistory* handle)
{
	/* deep enterSequence with history in child null */
	/* Handle deep history entry of null */
	switch(handle->historyVector[ 1 ])
	{
		case DeepHistory_mainRegion_State2__region0_State4__region0_State6 :
		{
			/* enterSequence with history in child State6 for leaf State6 */
			deepHistory_enseq_mainRegion_State2__region0_State4__region0_State6_default(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			/* enterSequence with history in child State7 for leaf State8 */
			deepHistory_dhenseq_mainRegion_State2__region0_State4__region0_State7__region0(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			/* enterSequence with history in child State7 for leaf State9 */
			deepHistory_dhenseq_mainRegion_State2__region0_State4__region0_State7__region0(handle);
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region null */
static void deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_default(DeepHistory* handle)
{
	/* 'default' enter sequence for region null */
	deepHistory_react_mainRegion_State2__region0_State4__region0_State7__region0__entry_Default(handle);
}

/* deep enterSequence with history in child null */
static void deepHistory_dhenseq_mainRegion_State2__region0_State4__region0_State7__region0(DeepHistory* handle)
{
	/* deep enterSequence with history in child null */
	/* Handle deep history entry of null */
	switch(handle->historyVector[ 2 ])
	{
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			/* enterSequence with history in child State8 for leaf State8 */
			deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			/* enterSequence with history in child State9 for leaf State9 */
			deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for state State1 */
static void deepHistory_exseq_mainRegion_State1(DeepHistory* handle)
{
	/* Default exit sequence for state State1 */
	handle->stateConfVector[0] = DeepHistory_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state State2 */
static void deepHistory_exseq_mainRegion_State2(DeepHistory* handle)
{
	/* Default exit sequence for state State2 */
	deepHistory_exseq_mainRegion_State2__region0(handle);
}

/* Default exit sequence for state a */
static void deepHistory_exseq_mainRegion_State2__region0_a(DeepHistory* handle)
{
	/* Default exit sequence for state a */
	handle->stateConfVector[0] = DeepHistory_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state State4 */
static void deepHistory_exseq_mainRegion_State2__region0_State4(DeepHistory* handle)
{
	/* Default exit sequence for state State4 */
	deepHistory_exseq_mainRegion_State2__region0_State4__region0(handle);
}

/* Default exit sequence for state State6 */
static void deepHistory_exseq_mainRegion_State2__region0_State4__region0_State6(DeepHistory* handle)
{
	/* Default exit sequence for state State6 */
	handle->stateConfVector[0] = DeepHistory_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state State7 */
static void deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7(DeepHistory* handle)
{
	/* Default exit sequence for state State7 */
	deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0(handle);
}

/* Default exit sequence for state State8 */
static void deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(DeepHistory* handle)
{
	/* Default exit sequence for state State8 */
	handle->stateConfVector[0] = DeepHistory_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state State9 */
static void deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(DeepHistory* handle)
{
	/* Default exit sequence for state State9 */
	handle->stateConfVector[0] = DeepHistory_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state State5 */
static void deepHistory_exseq_mainRegion_State2__region0_State5(DeepHistory* handle)
{
	/* Default exit sequence for state State5 */
	handle->stateConfVector[0] = DeepHistory_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region mainRegion */
static void deepHistory_exseq_mainRegion(DeepHistory* handle)
{
	/* Default exit sequence for region mainRegion */
	/* Handle exit of all possible states (of DeepHistory.mainRegion) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case DeepHistory_mainRegion_State1 :
		{
			deepHistory_exseq_mainRegion_State1(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_a :
		{
			deepHistory_exseq_mainRegion_State2__region0_a(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State6 :
		{
			deepHistory_exseq_mainRegion_State2__region0_State4__region0_State6(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State5 :
		{
			deepHistory_exseq_mainRegion_State2__region0_State5(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
static void deepHistory_exseq_mainRegion_State2__region0(DeepHistory* handle)
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of DeepHistory.mainRegion.State2._region0) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case DeepHistory_mainRegion_State2__region0_a :
		{
			deepHistory_exseq_mainRegion_State2__region0_a(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State6 :
		{
			deepHistory_exseq_mainRegion_State2__region0_State4__region0_State6(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State5 :
		{
			deepHistory_exseq_mainRegion_State2__region0_State5(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
static void deepHistory_exseq_mainRegion_State2__region0_State4__region0(DeepHistory* handle)
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of DeepHistory.mainRegion.State2._region0.State4._region0) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case DeepHistory_mainRegion_State2__region0_State4__region0_State6 :
		{
			deepHistory_exseq_mainRegion_State2__region0_State4__region0_State6(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
static void deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0(DeepHistory* handle)
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of DeepHistory.mainRegion.State2._region0.State4._region0.State7._region0) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(handle);
			break;
		}
		case DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			deepHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state State1. */
static void deepHistory_react_mainRegion_State1(DeepHistory* handle)
{
	/* The reactions of state State1. */
	if (deepHistory_check_mainRegion_State1_tr0_tr0(handle) == bool_true)
	{ 
		deepHistory_effect_mainRegion_State1_tr0(handle);
	} 
}

/* The reactions of state a. */
static void deepHistory_react_mainRegion_State2__region0_a(DeepHistory* handle)
{
	/* The reactions of state a. */
	if (deepHistory_check_mainRegion_State2_tr0_tr0(handle) == bool_true)
	{ 
		deepHistory_effect_mainRegion_State2_tr0(handle);
	}  else
	{
		if (deepHistory_check_mainRegion_State2__region0_a_tr0_tr0(handle) == bool_true)
		{ 
			deepHistory_effect_mainRegion_State2__region0_a_tr0(handle);
		} 
	}
}

/* The reactions of state State6. */
static void deepHistory_react_mainRegion_State2__region0_State4__region0_State6(DeepHistory* handle)
{
	/* The reactions of state State6. */
	if (deepHistory_check_mainRegion_State2_tr0_tr0(handle) == bool_true)
	{ 
		deepHistory_effect_mainRegion_State2_tr0(handle);
	}  else
	{
		if (deepHistory_check_mainRegion_State2__region0_State4_tr0_tr0(handle) == bool_true)
		{ 
			deepHistory_effect_mainRegion_State2__region0_State4_tr0(handle);
		}  else
		{
			if (deepHistory_check_mainRegion_State2__region0_State4__region0_State6_tr0_tr0(handle) == bool_true)
			{ 
				deepHistory_effect_mainRegion_State2__region0_State4__region0_State6_tr0(handle);
			} 
		}
	}
}

/* The reactions of state State8. */
static void deepHistory_react_mainRegion_State2__region0_State4__region0_State7__region0_State8(DeepHistory* handle)
{
	/* The reactions of state State8. */
	if (deepHistory_check_mainRegion_State2_tr0_tr0(handle) == bool_true)
	{ 
		deepHistory_effect_mainRegion_State2_tr0(handle);
	}  else
	{
		if (deepHistory_check_mainRegion_State2__region0_State4_tr0_tr0(handle) == bool_true)
		{ 
			deepHistory_effect_mainRegion_State2__region0_State4_tr0(handle);
		}  else
		{
			if (deepHistory_check_mainRegion_State2__region0_State4__region0_State7_tr0_tr0(handle) == bool_true)
			{ 
				deepHistory_effect_mainRegion_State2__region0_State4__region0_State7_tr0(handle);
			}  else
			{
				if (deepHistory_check_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0_tr0(handle) == bool_true)
				{ 
					deepHistory_effect_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0(handle);
				} 
			}
		}
	}
}

/* The reactions of state State9. */
static void deepHistory_react_mainRegion_State2__region0_State4__region0_State7__region0_State9(DeepHistory* handle)
{
	/* The reactions of state State9. */
	if (deepHistory_check_mainRegion_State2_tr0_tr0(handle) == bool_true)
	{ 
		deepHistory_effect_mainRegion_State2_tr0(handle);
	}  else
	{
		if (deepHistory_check_mainRegion_State2__region0_State4_tr0_tr0(handle) == bool_true)
		{ 
			deepHistory_effect_mainRegion_State2__region0_State4_tr0(handle);
		}  else
		{
			if (deepHistory_check_mainRegion_State2__region0_State4__region0_State7_tr0_tr0(handle) == bool_true)
			{ 
				deepHistory_effect_mainRegion_State2__region0_State4__region0_State7_tr0(handle);
			}  else
			{
				if (deepHistory_check_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0_tr0(handle) == bool_true)
				{ 
					deepHistory_effect_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0(handle);
				} 
			}
		}
	}
}

/* The reactions of state State5. */
static void deepHistory_react_mainRegion_State2__region0_State5(DeepHistory* handle)
{
	/* The reactions of state State5. */
	if (deepHistory_check_mainRegion_State2_tr0_tr0(handle) == bool_true)
	{ 
		deepHistory_effect_mainRegion_State2_tr0(handle);
	}  else
	{
	}
}

/* Default react sequence for initial entry  */
static void deepHistory_react_mainRegion__entry_Default(DeepHistory* handle)
{
	/* Default react sequence for initial entry  */
	deepHistory_enseq_mainRegion_State1_default(handle);
}

/* Default react sequence for initial entry  */
static void deepHistory_react_mainRegion_State2__region0_State4__region0__entry_Default(DeepHistory* handle)
{
	/* Default react sequence for initial entry  */
	deepHistory_enseq_mainRegion_State2__region0_State4__region0_State6_default(handle);
}

/* Default react sequence for initial entry  */
static void deepHistory_react_mainRegion_State2__region0_State4__region0_State7__region0__entry_Default(DeepHistory* handle)
{
	/* Default react sequence for initial entry  */
	deepHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default(handle);
}

/* Default react sequence for deep history entry  */
static void deepHistory_react_mainRegion_State2__region0__entry_Default(DeepHistory* handle)
{
	/* Default react sequence for deep history entry  */
	/* Enter the region with deep history */
	if (handle->historyVector[0] != DeepHistory_last_state)
	{
		deepHistory_dhenseq_mainRegion_State2__region0(handle);
	} else
	{
		deepHistory_enseq_mainRegion_State2__region0_a_default(handle);
	} 
}


