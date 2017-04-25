
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "StateIsActive.h"
/*! \file Implementation of the state machine 'StateIsActive'
*/

/* prototypes of all internal functions */
static sc_boolean stateIsActive_check_R1_R1A_tr0_tr0(const StateIsActive* handle);
static sc_boolean stateIsActive_check_R2_R2A_tr0_tr0(const StateIsActive* handle);
static void stateIsActive_effect_R1_R1A_tr0(StateIsActive* handle);
static void stateIsActive_effect_R2_R2A_tr0(StateIsActive* handle);
static void stateIsActive_enseq_R1_R1A_default(StateIsActive* handle);
static void stateIsActive_enseq_R1_R1B_default(StateIsActive* handle);
static void stateIsActive_enseq_R2_R2A_default(StateIsActive* handle);
static void stateIsActive_enseq_R2_R2B_default(StateIsActive* handle);
static void stateIsActive_enseq_R1_default(StateIsActive* handle);
static void stateIsActive_enseq_R2_default(StateIsActive* handle);
static void stateIsActive_exseq_R1_R1A(StateIsActive* handle);
static void stateIsActive_exseq_R1_R1B(StateIsActive* handle);
static void stateIsActive_exseq_R2_R2A(StateIsActive* handle);
static void stateIsActive_exseq_R2_R2B(StateIsActive* handle);
static void stateIsActive_exseq_R1(StateIsActive* handle);
static void stateIsActive_exseq_R2(StateIsActive* handle);
static void stateIsActive_react_R1_R1A(StateIsActive* handle);
static void stateIsActive_react_R1_R1B(StateIsActive* handle);
static void stateIsActive_react_R2_R2A(StateIsActive* handle);
static void stateIsActive_react_R2_R2B(StateIsActive* handle);
static void stateIsActive_react_R1__entry_Default(StateIsActive* handle);
static void stateIsActive_react_R2__entry_Default(StateIsActive* handle);
static void stateIsActive_clearInEvents(StateIsActive* handle);
static void stateIsActive_clearOutEvents(StateIsActive* handle);


void stateIsActive_init(StateIsActive* handle)
{
	sc_integer i;

	for (i = 0; i < STATEISACTIVE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = StateIsActive_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	stateIsActive_clearInEvents(handle);
	stateIsActive_clearOutEvents(handle);


}

void stateIsActive_enter(StateIsActive* handle)
{
	/* Default enter sequence for statechart StateIsActive */
	stateIsActive_enseq_R1_default(handle);
	stateIsActive_enseq_R2_default(handle);
}

void stateIsActive_exit(StateIsActive* handle)
{
	/* Default exit sequence for statechart StateIsActive */
	stateIsActive_exseq_R1(handle);
	stateIsActive_exseq_R2(handle);
}

sc_boolean stateIsActive_isActive(const StateIsActive* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != StateIsActive_last_state || handle->stateConfVector[1] != StateIsActive_last_state)
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
sc_boolean stateIsActive_isFinal(const StateIsActive* handle)
{
   return bool_false;
}

static void stateIsActive_clearInEvents(StateIsActive* handle)
{
	handle->iface.Event1_raised = bool_false;
}

static void stateIsActive_clearOutEvents(StateIsActive* handle)
{
}

void stateIsActive_runCycle(StateIsActive* handle)
{
	
	stateIsActive_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < STATEISACTIVE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case StateIsActive_R1_R1A :
		{
			stateIsActive_react_R1_R1A(handle);
			break;
		}
		case StateIsActive_R1_R1B :
		{
			stateIsActive_react_R1_R1B(handle);
			break;
		}
		case StateIsActive_R2_R2A :
		{
			stateIsActive_react_R2_R2A(handle);
			break;
		}
		case StateIsActive_R2_R2B :
		{
			stateIsActive_react_R2_R2B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	stateIsActive_clearInEvents(handle);
}


sc_boolean stateIsActive_isStateActive(const StateIsActive* handle, StateIsActiveStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case StateIsActive_R1_R1A :
			result = (sc_boolean) (handle->stateConfVector[0] == StateIsActive_R1_R1A
			);
			break;
		case StateIsActive_R1_R1B :
			result = (sc_boolean) (handle->stateConfVector[0] == StateIsActive_R1_R1B
			);
			break;
		case StateIsActive_R2_R2A :
			result = (sc_boolean) (handle->stateConfVector[1] == StateIsActive_R2_R2A
			);
			break;
		case StateIsActive_R2_R2B :
			result = (sc_boolean) (handle->stateConfVector[1] == StateIsActive_R2_R2B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void stateIsActiveIface_raise_event1(StateIsActive* handle)
{
	handle->iface.Event1_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean stateIsActive_check_R1_R1A_tr0_tr0(const StateIsActive* handle)
{
	return stateIsActive_isStateActive(handle, StateIsActive_R2_R2B);
}

static sc_boolean stateIsActive_check_R2_R2A_tr0_tr0(const StateIsActive* handle)
{
	return handle->iface.Event1_raised;
}

static void stateIsActive_effect_R1_R1A_tr0(StateIsActive* handle)
{
	stateIsActive_exseq_R1_R1A(handle);
	stateIsActive_enseq_R1_R1B_default(handle);
}

static void stateIsActive_effect_R2_R2A_tr0(StateIsActive* handle)
{
	stateIsActive_exseq_R2_R2A(handle);
	stateIsActive_enseq_R2_R2B_default(handle);
}

/* 'default' enter sequence for state R1A */
static void stateIsActive_enseq_R1_R1A_default(StateIsActive* handle)
{
	/* 'default' enter sequence for state R1A */
	handle->stateConfVector[0] = StateIsActive_R1_R1A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state R1B */
static void stateIsActive_enseq_R1_R1B_default(StateIsActive* handle)
{
	/* 'default' enter sequence for state R1B */
	handle->stateConfVector[0] = StateIsActive_R1_R1B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state R2A */
static void stateIsActive_enseq_R2_R2A_default(StateIsActive* handle)
{
	/* 'default' enter sequence for state R2A */
	handle->stateConfVector[1] = StateIsActive_R2_R2A;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state R2B */
static void stateIsActive_enseq_R2_R2B_default(StateIsActive* handle)
{
	/* 'default' enter sequence for state R2B */
	handle->stateConfVector[1] = StateIsActive_R2_R2B;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region R1 */
static void stateIsActive_enseq_R1_default(StateIsActive* handle)
{
	/* 'default' enter sequence for region R1 */
	stateIsActive_react_R1__entry_Default(handle);
}

/* 'default' enter sequence for region R2 */
static void stateIsActive_enseq_R2_default(StateIsActive* handle)
{
	/* 'default' enter sequence for region R2 */
	stateIsActive_react_R2__entry_Default(handle);
}

/* Default exit sequence for state R1A */
static void stateIsActive_exseq_R1_R1A(StateIsActive* handle)
{
	/* Default exit sequence for state R1A */
	handle->stateConfVector[0] = StateIsActive_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state R1B */
static void stateIsActive_exseq_R1_R1B(StateIsActive* handle)
{
	/* Default exit sequence for state R1B */
	handle->stateConfVector[0] = StateIsActive_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state R2A */
static void stateIsActive_exseq_R2_R2A(StateIsActive* handle)
{
	/* Default exit sequence for state R2A */
	handle->stateConfVector[1] = StateIsActive_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state R2B */
static void stateIsActive_exseq_R2_R2B(StateIsActive* handle)
{
	/* Default exit sequence for state R2B */
	handle->stateConfVector[1] = StateIsActive_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for region R1 */
static void stateIsActive_exseq_R1(StateIsActive* handle)
{
	/* Default exit sequence for region R1 */
	/* Handle exit of all possible states (of StateIsActive.R1) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case StateIsActive_R1_R1A :
		{
			stateIsActive_exseq_R1_R1A(handle);
			break;
		}
		case StateIsActive_R1_R1B :
		{
			stateIsActive_exseq_R1_R1B(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region R2 */
static void stateIsActive_exseq_R2(StateIsActive* handle)
{
	/* Default exit sequence for region R2 */
	/* Handle exit of all possible states (of StateIsActive.R2) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case StateIsActive_R2_R2A :
		{
			stateIsActive_exseq_R2_R2A(handle);
			break;
		}
		case StateIsActive_R2_R2B :
		{
			stateIsActive_exseq_R2_R2B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state R1A. */
static void stateIsActive_react_R1_R1A(StateIsActive* handle)
{
	/* The reactions of state R1A. */
	if (stateIsActive_check_R1_R1A_tr0_tr0(handle) == bool_true)
	{ 
		stateIsActive_effect_R1_R1A_tr0(handle);
	} 
}

/* The reactions of state R1B. */
static void stateIsActive_react_R1_R1B(StateIsActive* handle)
{
	/* The reactions of state R1B. */
}

/* The reactions of state R2A. */
static void stateIsActive_react_R2_R2A(StateIsActive* handle)
{
	/* The reactions of state R2A. */
	if (stateIsActive_check_R2_R2A_tr0_tr0(handle) == bool_true)
	{ 
		stateIsActive_effect_R2_R2A_tr0(handle);
	} 
}

/* The reactions of state R2B. */
static void stateIsActive_react_R2_R2B(StateIsActive* handle)
{
}

/* Default react sequence for initial entry  */
static void stateIsActive_react_R1__entry_Default(StateIsActive* handle)
{
	/* Default react sequence for initial entry  */
	stateIsActive_enseq_R1_R1A_default(handle);
}

/* Default react sequence for initial entry  */
static void stateIsActive_react_R2__entry_Default(StateIsActive* handle)
{
	/* Default react sequence for initial entry  */
	stateIsActive_enseq_R2_R2A_default(handle);
}


