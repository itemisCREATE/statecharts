
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "ShallowHistory.h"
/*! \file Implementation of the state machine 'ShallowHistory'
*/

/* prototypes of all internal functions */
static sc_boolean shallowHistory_check_mainRegion_State1_tr0_tr0(const ShallowHistory* handle);
static sc_boolean shallowHistory_check_mainRegion_State2_tr0_tr0(const ShallowHistory* handle);
static sc_boolean shallowHistory_check_mainRegion_State2__region0_State3_tr0_tr0(const ShallowHistory* handle);
static sc_boolean shallowHistory_check_mainRegion_State2__region0_State4_tr0_tr0(const ShallowHistory* handle);
static sc_boolean shallowHistory_check_mainRegion_State2__region0_State4__region0_State6_tr0_tr0(const ShallowHistory* handle);
static sc_boolean shallowHistory_check_mainRegion_State2__region0_State4__region0_State7_tr0_tr0(const ShallowHistory* handle);
static sc_boolean shallowHistory_check_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0_tr0(const ShallowHistory* handle);
static sc_boolean shallowHistory_check_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0_tr0(const ShallowHistory* handle);
static void shallowHistory_effect_mainRegion_State1_tr0(ShallowHistory* handle);
static void shallowHistory_effect_mainRegion_State2_tr0(ShallowHistory* handle);
static void shallowHistory_effect_mainRegion_State2__region0_State3_tr0(ShallowHistory* handle);
static void shallowHistory_effect_mainRegion_State2__region0_State4_tr0(ShallowHistory* handle);
static void shallowHistory_effect_mainRegion_State2__region0_State4__region0_State6_tr0(ShallowHistory* handle);
static void shallowHistory_effect_mainRegion_State2__region0_State4__region0_State7_tr0(ShallowHistory* handle);
static void shallowHistory_effect_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0(ShallowHistory* handle);
static void shallowHistory_effect_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0(ShallowHistory* handle);
static void shallowHistory_enseq_mainRegion_State1_default(ShallowHistory* handle);
static void shallowHistory_enseq_mainRegion_State2_default(ShallowHistory* handle);
static void shallowHistory_enseq_mainRegion_State2__region0_State3_default(ShallowHistory* handle);
static void shallowHistory_enseq_mainRegion_State2__region0_State4_default(ShallowHistory* handle);
static void shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State6_default(ShallowHistory* handle);
static void shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7_default(ShallowHistory* handle);
static void shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default(ShallowHistory* handle);
static void shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default(ShallowHistory* handle);
static void shallowHistory_enseq_mainRegion_State2__region0_State5_default(ShallowHistory* handle);
static void shallowHistory_enseq_mainRegion_default(ShallowHistory* handle);
static void shallowHistory_enseq_mainRegion_State2__region0_default(ShallowHistory* handle);
static void shallowHistory_shenseq_mainRegion_State2__region0(ShallowHistory* handle);
static void shallowHistory_enseq_mainRegion_State2__region0_State4__region0_default(ShallowHistory* handle);
static void shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_default(ShallowHistory* handle);
static void shallowHistory_shenseq_mainRegion_State2__region0_State4__region0_State7__region0(ShallowHistory* handle);
static void shallowHistory_exseq_mainRegion_State1(ShallowHistory* handle);
static void shallowHistory_exseq_mainRegion_State2(ShallowHistory* handle);
static void shallowHistory_exseq_mainRegion_State2__region0_State3(ShallowHistory* handle);
static void shallowHistory_exseq_mainRegion_State2__region0_State4(ShallowHistory* handle);
static void shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State6(ShallowHistory* handle);
static void shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7(ShallowHistory* handle);
static void shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(ShallowHistory* handle);
static void shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(ShallowHistory* handle);
static void shallowHistory_exseq_mainRegion_State2__region0_State5(ShallowHistory* handle);
static void shallowHistory_exseq_mainRegion(ShallowHistory* handle);
static void shallowHistory_exseq_mainRegion_State2__region0(ShallowHistory* handle);
static void shallowHistory_exseq_mainRegion_State2__region0_State4__region0(ShallowHistory* handle);
static void shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State1(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State2__region0_State3(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State2__region0_State4__region0_State6(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State2__region0_State4__region0_State7__region0_State8(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State2__region0_State4__region0_State7__region0_State9(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State2__region0_State5(ShallowHistory* handle);
static void shallowHistory_react_mainRegion__entry_Default(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State2__region0__entry_Default(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State2__region0_State4__region0__entry_Default(ShallowHistory* handle);
static void shallowHistory_react_mainRegion_State2__region0_State4__region0_State7__region0__entry_Default(ShallowHistory* handle);
static void shallowHistory_clearInEvents(ShallowHistory* handle);
static void shallowHistory_clearOutEvents(ShallowHistory* handle);


void shallowHistory_init(ShallowHistory* handle)
{
	sc_integer i;

	for (i = 0; i < SHALLOWHISTORY_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = ShallowHistory_last_state;
	}
	
	for (i = 0; i < SHALLOWHISTORY_MAX_HISTORY_STATES; ++i)
	{
		handle->historyVector[i] = ShallowHistory_last_state;
	}
	
	handle->stateConfVectorPosition = 0;

	shallowHistory_clearInEvents(handle);
	shallowHistory_clearOutEvents(handle);


}

void shallowHistory_enter(ShallowHistory* handle)
{
	/* Default enter sequence for statechart ShallowHistory */
	shallowHistory_enseq_mainRegion_default(handle);
}

void shallowHistory_exit(ShallowHistory* handle)
{
	/* Default exit sequence for statechart ShallowHistory */
	shallowHistory_exseq_mainRegion(handle);
}

sc_boolean shallowHistory_isActive(const ShallowHistory* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != ShallowHistory_last_state)
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
sc_boolean shallowHistory_isFinal(const ShallowHistory* handle)
{
   return bool_false;
}

static void shallowHistory_clearInEvents(ShallowHistory* handle)
{
	handle->iface.event1_raised = bool_false;
	handle->iface.event2_raised = bool_false;
	handle->iface.event3_raised = bool_false;
	handle->iface.event4_raised = bool_false;
	handle->iface.event5_raised = bool_false;
	handle->iface.event6_raised = bool_false;
	handle->iface.event7_raised = bool_false;
	handle->iface.event8_raised = bool_false;
}

static void shallowHistory_clearOutEvents(ShallowHistory* handle)
{
}

void shallowHistory_runCycle(ShallowHistory* handle)
{
	
	shallowHistory_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < SHALLOWHISTORY_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case ShallowHistory_mainRegion_State1 :
		{
			shallowHistory_react_mainRegion_State1(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State3 :
		{
			shallowHistory_react_mainRegion_State2__region0_State3(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 :
		{
			shallowHistory_react_mainRegion_State2__region0_State4__region0_State6(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			shallowHistory_react_mainRegion_State2__region0_State4__region0_State7__region0_State8(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			shallowHistory_react_mainRegion_State2__region0_State4__region0_State7__region0_State9(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State5 :
		{
			shallowHistory_react_mainRegion_State2__region0_State5(handle);
			break;
		}
		default:
			break;
		}
	}
	
	shallowHistory_clearInEvents(handle);
}


sc_boolean shallowHistory_isStateActive(const ShallowHistory* handle, ShallowHistoryStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case ShallowHistory_mainRegion_State1 :
			result = (sc_boolean) (handle->stateConfVector[0] == ShallowHistory_mainRegion_State1
			);
			break;
		case ShallowHistory_mainRegion_State2 :
			result = (sc_boolean) (handle->stateConfVector[0] >= ShallowHistory_mainRegion_State2
				&& handle->stateConfVector[0] <= ShallowHistory_mainRegion_State2__region0_State5);
			break;
		case ShallowHistory_mainRegion_State2__region0_State3 :
			result = (sc_boolean) (handle->stateConfVector[0] == ShallowHistory_mainRegion_State2__region0_State3
			);
			break;
		case ShallowHistory_mainRegion_State2__region0_State4 :
			result = (sc_boolean) (handle->stateConfVector[0] >= ShallowHistory_mainRegion_State2__region0_State4
				&& handle->stateConfVector[0] <= ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9);
			break;
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 :
			result = (sc_boolean) (handle->stateConfVector[0] == ShallowHistory_mainRegion_State2__region0_State4__region0_State6
			);
			break;
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7 :
			result = (sc_boolean) (handle->stateConfVector[0] >= ShallowHistory_mainRegion_State2__region0_State4__region0_State7
				&& handle->stateConfVector[0] <= ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9);
			break;
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
			result = (sc_boolean) (handle->stateConfVector[0] == ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8
			);
			break;
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
			result = (sc_boolean) (handle->stateConfVector[0] == ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9
			);
			break;
		case ShallowHistory_mainRegion_State2__region0_State5 :
			result = (sc_boolean) (handle->stateConfVector[0] == ShallowHistory_mainRegion_State2__region0_State5
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void shallowHistoryIface_raise_event1(ShallowHistory* handle)
{
	handle->iface.event1_raised = bool_true;
}
void shallowHistoryIface_raise_event2(ShallowHistory* handle)
{
	handle->iface.event2_raised = bool_true;
}
void shallowHistoryIface_raise_event3(ShallowHistory* handle)
{
	handle->iface.event3_raised = bool_true;
}
void shallowHistoryIface_raise_event4(ShallowHistory* handle)
{
	handle->iface.event4_raised = bool_true;
}
void shallowHistoryIface_raise_event5(ShallowHistory* handle)
{
	handle->iface.event5_raised = bool_true;
}
void shallowHistoryIface_raise_event6(ShallowHistory* handle)
{
	handle->iface.event6_raised = bool_true;
}
void shallowHistoryIface_raise_event7(ShallowHistory* handle)
{
	handle->iface.event7_raised = bool_true;
}
void shallowHistoryIface_raise_event8(ShallowHistory* handle)
{
	handle->iface.event8_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean shallowHistory_check_mainRegion_State1_tr0_tr0(const ShallowHistory* handle)
{
	return handle->iface.event1_raised;
}

static sc_boolean shallowHistory_check_mainRegion_State2_tr0_tr0(const ShallowHistory* handle)
{
	return handle->iface.event2_raised;
}

static sc_boolean shallowHistory_check_mainRegion_State2__region0_State3_tr0_tr0(const ShallowHistory* handle)
{
	return handle->iface.event3_raised;
}

static sc_boolean shallowHistory_check_mainRegion_State2__region0_State4_tr0_tr0(const ShallowHistory* handle)
{
	return handle->iface.event4_raised;
}

static sc_boolean shallowHistory_check_mainRegion_State2__region0_State4__region0_State6_tr0_tr0(const ShallowHistory* handle)
{
	return handle->iface.event5_raised;
}

static sc_boolean shallowHistory_check_mainRegion_State2__region0_State4__region0_State7_tr0_tr0(const ShallowHistory* handle)
{
	return handle->iface.event6_raised;
}

static sc_boolean shallowHistory_check_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0_tr0(const ShallowHistory* handle)
{
	return handle->iface.event7_raised;
}

static sc_boolean shallowHistory_check_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0_tr0(const ShallowHistory* handle)
{
	return handle->iface.event8_raised;
}

static void shallowHistory_effect_mainRegion_State1_tr0(ShallowHistory* handle)
{
	shallowHistory_exseq_mainRegion_State1(handle);
	shallowHistory_enseq_mainRegion_State2_default(handle);
}

static void shallowHistory_effect_mainRegion_State2_tr0(ShallowHistory* handle)
{
	shallowHistory_exseq_mainRegion_State2(handle);
	shallowHistory_enseq_mainRegion_State1_default(handle);
}

static void shallowHistory_effect_mainRegion_State2__region0_State3_tr0(ShallowHistory* handle)
{
	shallowHistory_exseq_mainRegion_State2__region0_State3(handle);
	shallowHistory_enseq_mainRegion_State2__region0_State4_default(handle);
}

static void shallowHistory_effect_mainRegion_State2__region0_State4_tr0(ShallowHistory* handle)
{
	shallowHistory_exseq_mainRegion_State2__region0_State4(handle);
	shallowHistory_enseq_mainRegion_State2__region0_State5_default(handle);
}

static void shallowHistory_effect_mainRegion_State2__region0_State4__region0_State6_tr0(ShallowHistory* handle)
{
	shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State6(handle);
	shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7_default(handle);
}

static void shallowHistory_effect_mainRegion_State2__region0_State4__region0_State7_tr0(ShallowHistory* handle)
{
	shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7(handle);
	shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State6_default(handle);
}

static void shallowHistory_effect_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0(ShallowHistory* handle)
{
	shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(handle);
	shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default(handle);
}

static void shallowHistory_effect_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0(ShallowHistory* handle)
{
	shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(handle);
	shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default(handle);
}

/* 'default' enter sequence for state State1 */
static void shallowHistory_enseq_mainRegion_State1_default(ShallowHistory* handle)
{
	/* 'default' enter sequence for state State1 */
	handle->stateConfVector[0] = ShallowHistory_mainRegion_State1;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state State2 */
static void shallowHistory_enseq_mainRegion_State2_default(ShallowHistory* handle)
{
	/* 'default' enter sequence for state State2 */
	shallowHistory_enseq_mainRegion_State2__region0_default(handle);
}

/* 'default' enter sequence for state State3 */
static void shallowHistory_enseq_mainRegion_State2__region0_State3_default(ShallowHistory* handle)
{
	/* 'default' enter sequence for state State3 */
	handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State3;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state State4 */
static void shallowHistory_enseq_mainRegion_State2__region0_State4_default(ShallowHistory* handle)
{
	/* 'default' enter sequence for state State4 */
	shallowHistory_enseq_mainRegion_State2__region0_State4__region0_default(handle);
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state State6 */
static void shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State6_default(ShallowHistory* handle)
{
	/* 'default' enter sequence for state State6 */
	handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State6;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state State7 */
static void shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7_default(ShallowHistory* handle)
{
	/* 'default' enter sequence for state State7 */
	shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_default(handle);
}

/* 'default' enter sequence for state State8 */
static void shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default(ShallowHistory* handle)
{
	/* 'default' enter sequence for state State8 */
	handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[1] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state State9 */
static void shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default(ShallowHistory* handle)
{
	/* 'default' enter sequence for state State9 */
	handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[1] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state State5 */
static void shallowHistory_enseq_mainRegion_State2__region0_State5_default(ShallowHistory* handle)
{
	/* 'default' enter sequence for state State5 */
	handle->stateConfVector[0] = ShallowHistory_mainRegion_State2__region0_State5;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for region mainRegion */
static void shallowHistory_enseq_mainRegion_default(ShallowHistory* handle)
{
	/* 'default' enter sequence for region mainRegion */
	shallowHistory_react_mainRegion__entry_Default(handle);
}

/* 'default' enter sequence for region null */
static void shallowHistory_enseq_mainRegion_State2__region0_default(ShallowHistory* handle)
{
	/* 'default' enter sequence for region null */
	shallowHistory_react_mainRegion_State2__region0__entry_Default(handle);
}

/* shallow enterSequence with history in child null */
static void shallowHistory_shenseq_mainRegion_State2__region0(ShallowHistory* handle)
{
	/* shallow enterSequence with history in child null */
	/* Handle shallow history entry of null */
	switch(handle->historyVector[ 0 ])
	{
		case ShallowHistory_mainRegion_State2__region0_State3 :
		{
			shallowHistory_enseq_mainRegion_State2__region0_State3_default(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 :
		{
			shallowHistory_enseq_mainRegion_State2__region0_State4_default(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			shallowHistory_enseq_mainRegion_State2__region0_State4_default(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			shallowHistory_enseq_mainRegion_State2__region0_State4_default(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State5 :
		{
			shallowHistory_enseq_mainRegion_State2__region0_State5_default(handle);
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region null */
static void shallowHistory_enseq_mainRegion_State2__region0_State4__region0_default(ShallowHistory* handle)
{
	/* 'default' enter sequence for region null */
	shallowHistory_react_mainRegion_State2__region0_State4__region0__entry_Default(handle);
}

/* 'default' enter sequence for region null */
static void shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_default(ShallowHistory* handle)
{
	/* 'default' enter sequence for region null */
	shallowHistory_react_mainRegion_State2__region0_State4__region0_State7__region0__entry_Default(handle);
}

/* shallow enterSequence with history in child null */
static void shallowHistory_shenseq_mainRegion_State2__region0_State4__region0_State7__region0(ShallowHistory* handle)
{
	/* shallow enterSequence with history in child null */
	/* Handle shallow history entry of null */
	switch(handle->historyVector[ 1 ])
	{
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for state State1 */
static void shallowHistory_exseq_mainRegion_State1(ShallowHistory* handle)
{
	/* Default exit sequence for state State1 */
	handle->stateConfVector[0] = ShallowHistory_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state State2 */
static void shallowHistory_exseq_mainRegion_State2(ShallowHistory* handle)
{
	/* Default exit sequence for state State2 */
	shallowHistory_exseq_mainRegion_State2__region0(handle);
}

/* Default exit sequence for state State3 */
static void shallowHistory_exseq_mainRegion_State2__region0_State3(ShallowHistory* handle)
{
	/* Default exit sequence for state State3 */
	handle->stateConfVector[0] = ShallowHistory_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state State4 */
static void shallowHistory_exseq_mainRegion_State2__region0_State4(ShallowHistory* handle)
{
	/* Default exit sequence for state State4 */
	shallowHistory_exseq_mainRegion_State2__region0_State4__region0(handle);
}

/* Default exit sequence for state State6 */
static void shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State6(ShallowHistory* handle)
{
	/* Default exit sequence for state State6 */
	handle->stateConfVector[0] = ShallowHistory_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state State7 */
static void shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7(ShallowHistory* handle)
{
	/* Default exit sequence for state State7 */
	shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0(handle);
}

/* Default exit sequence for state State8 */
static void shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(ShallowHistory* handle)
{
	/* Default exit sequence for state State8 */
	handle->stateConfVector[0] = ShallowHistory_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state State9 */
static void shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(ShallowHistory* handle)
{
	/* Default exit sequence for state State9 */
	handle->stateConfVector[0] = ShallowHistory_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state State5 */
static void shallowHistory_exseq_mainRegion_State2__region0_State5(ShallowHistory* handle)
{
	/* Default exit sequence for state State5 */
	handle->stateConfVector[0] = ShallowHistory_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region mainRegion */
static void shallowHistory_exseq_mainRegion(ShallowHistory* handle)
{
	/* Default exit sequence for region mainRegion */
	/* Handle exit of all possible states (of ShallowHistory.mainRegion) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ShallowHistory_mainRegion_State1 :
		{
			shallowHistory_exseq_mainRegion_State1(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State3 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State3(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State6(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State5 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State5(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
static void shallowHistory_exseq_mainRegion_State2__region0(ShallowHistory* handle)
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of ShallowHistory.mainRegion.State2._region0) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ShallowHistory_mainRegion_State2__region0_State3 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State3(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State6(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State5 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State5(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
static void shallowHistory_exseq_mainRegion_State2__region0_State4__region0(ShallowHistory* handle)
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of ShallowHistory.mainRegion.State2._region0.State4._region0) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State6 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State6(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
static void shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0(ShallowHistory* handle)
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of ShallowHistory.mainRegion.State2._region0.State4._region0.State7._region0) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8(handle);
			break;
		}
		case ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			shallowHistory_exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state State1. */
static void shallowHistory_react_mainRegion_State1(ShallowHistory* handle)
{
	/* The reactions of state State1. */
	if (shallowHistory_check_mainRegion_State1_tr0_tr0(handle) == bool_true)
	{ 
		shallowHistory_effect_mainRegion_State1_tr0(handle);
	} 
}

/* The reactions of state State3. */
static void shallowHistory_react_mainRegion_State2__region0_State3(ShallowHistory* handle)
{
	/* The reactions of state State3. */
	if (shallowHistory_check_mainRegion_State2_tr0_tr0(handle) == bool_true)
	{ 
		shallowHistory_effect_mainRegion_State2_tr0(handle);
	}  else
	{
		if (shallowHistory_check_mainRegion_State2__region0_State3_tr0_tr0(handle) == bool_true)
		{ 
			shallowHistory_effect_mainRegion_State2__region0_State3_tr0(handle);
		} 
	}
}

/* The reactions of state State6. */
static void shallowHistory_react_mainRegion_State2__region0_State4__region0_State6(ShallowHistory* handle)
{
	/* The reactions of state State6. */
	if (shallowHistory_check_mainRegion_State2_tr0_tr0(handle) == bool_true)
	{ 
		shallowHistory_effect_mainRegion_State2_tr0(handle);
	}  else
	{
		if (shallowHistory_check_mainRegion_State2__region0_State4_tr0_tr0(handle) == bool_true)
		{ 
			shallowHistory_effect_mainRegion_State2__region0_State4_tr0(handle);
		}  else
		{
			if (shallowHistory_check_mainRegion_State2__region0_State4__region0_State6_tr0_tr0(handle) == bool_true)
			{ 
				shallowHistory_effect_mainRegion_State2__region0_State4__region0_State6_tr0(handle);
			} 
		}
	}
}

/* The reactions of state State8. */
static void shallowHistory_react_mainRegion_State2__region0_State4__region0_State7__region0_State8(ShallowHistory* handle)
{
	/* The reactions of state State8. */
	if (shallowHistory_check_mainRegion_State2_tr0_tr0(handle) == bool_true)
	{ 
		shallowHistory_effect_mainRegion_State2_tr0(handle);
	}  else
	{
		if (shallowHistory_check_mainRegion_State2__region0_State4_tr0_tr0(handle) == bool_true)
		{ 
			shallowHistory_effect_mainRegion_State2__region0_State4_tr0(handle);
		}  else
		{
			if (shallowHistory_check_mainRegion_State2__region0_State4__region0_State7_tr0_tr0(handle) == bool_true)
			{ 
				shallowHistory_effect_mainRegion_State2__region0_State4__region0_State7_tr0(handle);
			}  else
			{
				if (shallowHistory_check_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0_tr0(handle) == bool_true)
				{ 
					shallowHistory_effect_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0(handle);
				} 
			}
		}
	}
}

/* The reactions of state State9. */
static void shallowHistory_react_mainRegion_State2__region0_State4__region0_State7__region0_State9(ShallowHistory* handle)
{
	/* The reactions of state State9. */
	if (shallowHistory_check_mainRegion_State2_tr0_tr0(handle) == bool_true)
	{ 
		shallowHistory_effect_mainRegion_State2_tr0(handle);
	}  else
	{
		if (shallowHistory_check_mainRegion_State2__region0_State4_tr0_tr0(handle) == bool_true)
		{ 
			shallowHistory_effect_mainRegion_State2__region0_State4_tr0(handle);
		}  else
		{
			if (shallowHistory_check_mainRegion_State2__region0_State4__region0_State7_tr0_tr0(handle) == bool_true)
			{ 
				shallowHistory_effect_mainRegion_State2__region0_State4__region0_State7_tr0(handle);
			}  else
			{
				if (shallowHistory_check_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0_tr0(handle) == bool_true)
				{ 
					shallowHistory_effect_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0(handle);
				} 
			}
		}
	}
}

/* The reactions of state State5. */
static void shallowHistory_react_mainRegion_State2__region0_State5(ShallowHistory* handle)
{
	/* The reactions of state State5. */
	if (shallowHistory_check_mainRegion_State2_tr0_tr0(handle) == bool_true)
	{ 
		shallowHistory_effect_mainRegion_State2_tr0(handle);
	}  else
	{
	}
}

/* Default react sequence for initial entry  */
static void shallowHistory_react_mainRegion__entry_Default(ShallowHistory* handle)
{
	/* Default react sequence for initial entry  */
	shallowHistory_enseq_mainRegion_State1_default(handle);
}

/* Default react sequence for shallow history entry  */
static void shallowHistory_react_mainRegion_State2__region0__entry_Default(ShallowHistory* handle)
{
	/* Default react sequence for shallow history entry  */
	/* Enter the region with shallow history */
	if (handle->historyVector[0] != ShallowHistory_last_state)
	{
		shallowHistory_shenseq_mainRegion_State2__region0(handle);
	} else
	{
		shallowHistory_enseq_mainRegion_State2__region0_State3_default(handle);
	} 
}

/* Default react sequence for initial entry  */
static void shallowHistory_react_mainRegion_State2__region0_State4__region0__entry_Default(ShallowHistory* handle)
{
	/* Default react sequence for initial entry  */
	shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State6_default(handle);
}

/* Default react sequence for shallow history entry  */
static void shallowHistory_react_mainRegion_State2__region0_State4__region0_State7__region0__entry_Default(ShallowHistory* handle)
{
	/* Default react sequence for shallow history entry  */
	/* Enter the region with shallow history */
	if (handle->historyVector[1] != ShallowHistory_last_state)
	{
		shallowHistory_shenseq_mainRegion_State2__region0_State4__region0_State7__region0(handle);
	} else
	{
		shallowHistory_enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default(handle);
	} 
}


