
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "HistoryWithExitPoint.h"
/*! \file Implementation of the state machine 'HistoryWithExitPoint'
*/

/* prototypes of all internal functions */
static sc_boolean historyWithExitPoint_check_mr_A_r_X1_tr0_tr0(const HistoryWithExitPoint* handle);
static sc_boolean historyWithExitPoint_check_mr_A_r_X1_tr1_tr1(const HistoryWithExitPoint* handle);
static sc_boolean historyWithExitPoint_check_mr_A_r_X2_tr0_tr0(const HistoryWithExitPoint* handle);
static sc_boolean historyWithExitPoint_check_mr_A_r_X2_tr1_tr1(const HistoryWithExitPoint* handle);
static sc_boolean historyWithExitPoint_check_mr_B_tr0_tr0(const HistoryWithExitPoint* handle);
static void historyWithExitPoint_effect_mr_A_tr0(HistoryWithExitPoint* handle);
static void historyWithExitPoint_effect_mr_A_r_X1_tr0(HistoryWithExitPoint* handle);
static void historyWithExitPoint_effect_mr_A_r_X1_tr1(HistoryWithExitPoint* handle);
static void historyWithExitPoint_effect_mr_A_r_X2_tr0(HistoryWithExitPoint* handle);
static void historyWithExitPoint_effect_mr_A_r_X2_tr1(HistoryWithExitPoint* handle);
static void historyWithExitPoint_effect_mr_B_tr0(HistoryWithExitPoint* handle);
static void historyWithExitPoint_enseq_mr_A_default(HistoryWithExitPoint* handle);
static void historyWithExitPoint_enseq_mr_A_r_X1_default(HistoryWithExitPoint* handle);
static void historyWithExitPoint_enseq_mr_A_r_X2_default(HistoryWithExitPoint* handle);
static void historyWithExitPoint_enseq_mr_B_default(HistoryWithExitPoint* handle);
static void historyWithExitPoint_enseq_mr_default(HistoryWithExitPoint* handle);
static void historyWithExitPoint_enseq_mr_A_r_default(HistoryWithExitPoint* handle);
static void historyWithExitPoint_shenseq_mr_A_r(HistoryWithExitPoint* handle);
static void historyWithExitPoint_exseq_mr_A(HistoryWithExitPoint* handle);
static void historyWithExitPoint_exseq_mr_A_r_X1(HistoryWithExitPoint* handle);
static void historyWithExitPoint_exseq_mr_A_r_X2(HistoryWithExitPoint* handle);
static void historyWithExitPoint_exseq_mr_B(HistoryWithExitPoint* handle);
static void historyWithExitPoint_exseq_mr(HistoryWithExitPoint* handle);
static void historyWithExitPoint_exseq_mr_A_r(HistoryWithExitPoint* handle);
static void historyWithExitPoint_react_mr_A_r_X1(HistoryWithExitPoint* handle);
static void historyWithExitPoint_react_mr_A_r_X2(HistoryWithExitPoint* handle);
static void historyWithExitPoint_react_mr_B(HistoryWithExitPoint* handle);
static void historyWithExitPoint_react_mr__entry_Default(HistoryWithExitPoint* handle);
static void historyWithExitPoint_react_mr_A_r__entry_Default(HistoryWithExitPoint* handle);
static void historyWithExitPoint_react_mr_A_r_exit_to_B(HistoryWithExitPoint* handle);
static void historyWithExitPoint_clearInEvents(HistoryWithExitPoint* handle);
static void historyWithExitPoint_clearOutEvents(HistoryWithExitPoint* handle);


void historyWithExitPoint_init(HistoryWithExitPoint* handle)
{
	sc_integer i;

	for (i = 0; i < HISTORYWITHEXITPOINT_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = HistoryWithExitPoint_last_state;
	}
	
	for (i = 0; i < HISTORYWITHEXITPOINT_MAX_HISTORY_STATES; ++i)
	{
		handle->historyVector[i] = HistoryWithExitPoint_last_state;
	}
	
	handle->stateConfVectorPosition = 0;

	historyWithExitPoint_clearInEvents(handle);
	historyWithExitPoint_clearOutEvents(handle);


}

void historyWithExitPoint_enter(HistoryWithExitPoint* handle)
{
	/* Default enter sequence for statechart HistoryWithExitPoint */
	historyWithExitPoint_enseq_mr_default(handle);
}

void historyWithExitPoint_exit(HistoryWithExitPoint* handle)
{
	/* Default exit sequence for statechart HistoryWithExitPoint */
	historyWithExitPoint_exseq_mr(handle);
}

sc_boolean historyWithExitPoint_isActive(const HistoryWithExitPoint* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != HistoryWithExitPoint_last_state)
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
sc_boolean historyWithExitPoint_isFinal(const HistoryWithExitPoint* handle)
{
   return bool_false;
}

static void historyWithExitPoint_clearInEvents(HistoryWithExitPoint* handle)
{
	handle->iface.push_raised = bool_false;
	handle->iface.back_raised = bool_false;
	handle->iface.next_raised = bool_false;
}

static void historyWithExitPoint_clearOutEvents(HistoryWithExitPoint* handle)
{
}

void historyWithExitPoint_runCycle(HistoryWithExitPoint* handle)
{
	
	historyWithExitPoint_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < HISTORYWITHEXITPOINT_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case HistoryWithExitPoint_mr_A_r_X1 :
		{
			historyWithExitPoint_react_mr_A_r_X1(handle);
			break;
		}
		case HistoryWithExitPoint_mr_A_r_X2 :
		{
			historyWithExitPoint_react_mr_A_r_X2(handle);
			break;
		}
		case HistoryWithExitPoint_mr_B :
		{
			historyWithExitPoint_react_mr_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	historyWithExitPoint_clearInEvents(handle);
}


sc_boolean historyWithExitPoint_isStateActive(const HistoryWithExitPoint* handle, HistoryWithExitPointStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case HistoryWithExitPoint_mr_A :
			result = (sc_boolean) (handle->stateConfVector[0] >= HistoryWithExitPoint_mr_A
				&& handle->stateConfVector[0] <= HistoryWithExitPoint_mr_A_r_X2);
			break;
		case HistoryWithExitPoint_mr_A_r_X1 :
			result = (sc_boolean) (handle->stateConfVector[0] == HistoryWithExitPoint_mr_A_r_X1
			);
			break;
		case HistoryWithExitPoint_mr_A_r_X2 :
			result = (sc_boolean) (handle->stateConfVector[0] == HistoryWithExitPoint_mr_A_r_X2
			);
			break;
		case HistoryWithExitPoint_mr_B :
			result = (sc_boolean) (handle->stateConfVector[0] == HistoryWithExitPoint_mr_B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void historyWithExitPointIface_raise_push(HistoryWithExitPoint* handle)
{
	handle->iface.push_raised = bool_true;
}
void historyWithExitPointIface_raise_back(HistoryWithExitPoint* handle)
{
	handle->iface.back_raised = bool_true;
}
void historyWithExitPointIface_raise_next(HistoryWithExitPoint* handle)
{
	handle->iface.next_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean historyWithExitPoint_check_mr_A_r_X1_tr0_tr0(const HistoryWithExitPoint* handle)
{
	return handle->iface.next_raised;
}

static sc_boolean historyWithExitPoint_check_mr_A_r_X1_tr1_tr1(const HistoryWithExitPoint* handle)
{
	return handle->iface.push_raised;
}

static sc_boolean historyWithExitPoint_check_mr_A_r_X2_tr0_tr0(const HistoryWithExitPoint* handle)
{
	return handle->iface.next_raised;
}

static sc_boolean historyWithExitPoint_check_mr_A_r_X2_tr1_tr1(const HistoryWithExitPoint* handle)
{
	return handle->iface.push_raised;
}

static sc_boolean historyWithExitPoint_check_mr_B_tr0_tr0(const HistoryWithExitPoint* handle)
{
	return handle->iface.back_raised;
}

static void historyWithExitPoint_effect_mr_A_tr0(HistoryWithExitPoint* handle)
{
	historyWithExitPoint_exseq_mr_A(handle);
	historyWithExitPoint_enseq_mr_B_default(handle);
}

static void historyWithExitPoint_effect_mr_A_r_X1_tr0(HistoryWithExitPoint* handle)
{
	historyWithExitPoint_exseq_mr_A_r_X1(handle);
	historyWithExitPoint_enseq_mr_A_r_X2_default(handle);
}

static void historyWithExitPoint_effect_mr_A_r_X1_tr1(HistoryWithExitPoint* handle)
{
	historyWithExitPoint_exseq_mr_A_r_X1(handle);
	historyWithExitPoint_react_mr_A_r_exit_to_B(handle);
}

static void historyWithExitPoint_effect_mr_A_r_X2_tr0(HistoryWithExitPoint* handle)
{
	historyWithExitPoint_exseq_mr_A_r_X2(handle);
	historyWithExitPoint_enseq_mr_A_r_X1_default(handle);
}

static void historyWithExitPoint_effect_mr_A_r_X2_tr1(HistoryWithExitPoint* handle)
{
	historyWithExitPoint_exseq_mr_A_r_X2(handle);
	historyWithExitPoint_react_mr_A_r_exit_to_B(handle);
}

static void historyWithExitPoint_effect_mr_B_tr0(HistoryWithExitPoint* handle)
{
	historyWithExitPoint_exseq_mr_B(handle);
	historyWithExitPoint_enseq_mr_A_default(handle);
}

/* 'default' enter sequence for state A */
static void historyWithExitPoint_enseq_mr_A_default(HistoryWithExitPoint* handle)
{
	/* 'default' enter sequence for state A */
	historyWithExitPoint_enseq_mr_A_r_default(handle);
}

/* 'default' enter sequence for state X1 */
static void historyWithExitPoint_enseq_mr_A_r_X1_default(HistoryWithExitPoint* handle)
{
	/* 'default' enter sequence for state X1 */
	handle->stateConfVector[0] = HistoryWithExitPoint_mr_A_r_X1;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state X2 */
static void historyWithExitPoint_enseq_mr_A_r_X2_default(HistoryWithExitPoint* handle)
{
	/* 'default' enter sequence for state X2 */
	handle->stateConfVector[0] = HistoryWithExitPoint_mr_A_r_X2;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state B */
static void historyWithExitPoint_enseq_mr_B_default(HistoryWithExitPoint* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = HistoryWithExitPoint_mr_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region mr */
static void historyWithExitPoint_enseq_mr_default(HistoryWithExitPoint* handle)
{
	/* 'default' enter sequence for region mr */
	historyWithExitPoint_react_mr__entry_Default(handle);
}

/* 'default' enter sequence for region r */
static void historyWithExitPoint_enseq_mr_A_r_default(HistoryWithExitPoint* handle)
{
	/* 'default' enter sequence for region r */
	historyWithExitPoint_react_mr_A_r__entry_Default(handle);
}

/* shallow enterSequence with history in child r */
static void historyWithExitPoint_shenseq_mr_A_r(HistoryWithExitPoint* handle)
{
	/* shallow enterSequence with history in child r */
	/* Handle shallow history entry of r */
	switch(handle->historyVector[ 0 ])
	{
		case HistoryWithExitPoint_mr_A_r_X1 :
		{
			historyWithExitPoint_enseq_mr_A_r_X1_default(handle);
			break;
		}
		case HistoryWithExitPoint_mr_A_r_X2 :
		{
			historyWithExitPoint_enseq_mr_A_r_X2_default(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for state A */
static void historyWithExitPoint_exseq_mr_A(HistoryWithExitPoint* handle)
{
	/* Default exit sequence for state A */
	historyWithExitPoint_exseq_mr_A_r(handle);
}

/* Default exit sequence for state X1 */
static void historyWithExitPoint_exseq_mr_A_r_X1(HistoryWithExitPoint* handle)
{
	/* Default exit sequence for state X1 */
	handle->stateConfVector[0] = HistoryWithExitPoint_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state X2 */
static void historyWithExitPoint_exseq_mr_A_r_X2(HistoryWithExitPoint* handle)
{
	/* Default exit sequence for state X2 */
	handle->stateConfVector[0] = HistoryWithExitPoint_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void historyWithExitPoint_exseq_mr_B(HistoryWithExitPoint* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = HistoryWithExitPoint_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region mr */
static void historyWithExitPoint_exseq_mr(HistoryWithExitPoint* handle)
{
	/* Default exit sequence for region mr */
	/* Handle exit of all possible states (of HistoryWithExitPoint.mr) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case HistoryWithExitPoint_mr_A_r_X1 :
		{
			historyWithExitPoint_exseq_mr_A_r_X1(handle);
			break;
		}
		case HistoryWithExitPoint_mr_A_r_X2 :
		{
			historyWithExitPoint_exseq_mr_A_r_X2(handle);
			break;
		}
		case HistoryWithExitPoint_mr_B :
		{
			historyWithExitPoint_exseq_mr_B(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
static void historyWithExitPoint_exseq_mr_A_r(HistoryWithExitPoint* handle)
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of HistoryWithExitPoint.mr.A.r) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case HistoryWithExitPoint_mr_A_r_X1 :
		{
			historyWithExitPoint_exseq_mr_A_r_X1(handle);
			break;
		}
		case HistoryWithExitPoint_mr_A_r_X2 :
		{
			historyWithExitPoint_exseq_mr_A_r_X2(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state X1. */
static void historyWithExitPoint_react_mr_A_r_X1(HistoryWithExitPoint* handle)
{
	/* The reactions of state X1. */
	if (historyWithExitPoint_check_mr_A_r_X1_tr0_tr0(handle) == bool_true)
	{ 
		historyWithExitPoint_effect_mr_A_r_X1_tr0(handle);
	}  else
	{
		if (historyWithExitPoint_check_mr_A_r_X1_tr1_tr1(handle) == bool_true)
		{ 
			historyWithExitPoint_effect_mr_A_r_X1_tr1(handle);
		} 
	}
}

/* The reactions of state X2. */
static void historyWithExitPoint_react_mr_A_r_X2(HistoryWithExitPoint* handle)
{
	/* The reactions of state X2. */
	if (historyWithExitPoint_check_mr_A_r_X2_tr0_tr0(handle) == bool_true)
	{ 
		historyWithExitPoint_effect_mr_A_r_X2_tr0(handle);
	}  else
	{
		if (historyWithExitPoint_check_mr_A_r_X2_tr1_tr1(handle) == bool_true)
		{ 
			historyWithExitPoint_effect_mr_A_r_X2_tr1(handle);
		} 
	}
}

/* The reactions of state B. */
static void historyWithExitPoint_react_mr_B(HistoryWithExitPoint* handle)
{
	/* The reactions of state B. */
	if (historyWithExitPoint_check_mr_B_tr0_tr0(handle) == bool_true)
	{ 
		historyWithExitPoint_effect_mr_B_tr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void historyWithExitPoint_react_mr__entry_Default(HistoryWithExitPoint* handle)
{
	/* Default react sequence for initial entry  */
	historyWithExitPoint_enseq_mr_A_default(handle);
}

/* Default react sequence for shallow history entry  */
static void historyWithExitPoint_react_mr_A_r__entry_Default(HistoryWithExitPoint* handle)
{
	/* Default react sequence for shallow history entry  */
	/* Enter the region with shallow history */
	if (handle->historyVector[0] != HistoryWithExitPoint_last_state)
	{
		historyWithExitPoint_shenseq_mr_A_r(handle);
	} else
	{
		historyWithExitPoint_enseq_mr_A_r_X1_default(handle);
	} 
}

/* The reactions of exit exit_to_B. */
static void historyWithExitPoint_react_mr_A_r_exit_to_B(HistoryWithExitPoint* handle)
{
	/* The reactions of exit exit_to_B. */
	historyWithExitPoint_effect_mr_A_tr0(handle);
}


