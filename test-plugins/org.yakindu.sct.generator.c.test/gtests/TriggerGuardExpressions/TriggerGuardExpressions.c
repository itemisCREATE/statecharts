
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "TriggerGuardExpressions.h"
/*! \file Implementation of the state machine 'TriggerGuardExpressions'
*/

/* prototypes of all internal functions */
static sc_boolean triggerGuardExpressions_check_main_region_A_tr0_tr0(const TriggerGuardExpressions* handle);
static sc_boolean triggerGuardExpressions_check_main_region_B_tr0_tr0(const TriggerGuardExpressions* handle);
static void triggerGuardExpressions_effect_main_region_A_tr0(TriggerGuardExpressions* handle);
static void triggerGuardExpressions_effect_main_region_B_tr0(TriggerGuardExpressions* handle);
static void triggerGuardExpressions_enseq_main_region_A_default(TriggerGuardExpressions* handle);
static void triggerGuardExpressions_enseq_main_region_B_default(TriggerGuardExpressions* handle);
static void triggerGuardExpressions_enseq_main_region_default(TriggerGuardExpressions* handle);
static void triggerGuardExpressions_exseq_main_region_A(TriggerGuardExpressions* handle);
static void triggerGuardExpressions_exseq_main_region_B(TriggerGuardExpressions* handle);
static void triggerGuardExpressions_exseq_main_region(TriggerGuardExpressions* handle);
static void triggerGuardExpressions_react_main_region_A(TriggerGuardExpressions* handle);
static void triggerGuardExpressions_react_main_region_B(TriggerGuardExpressions* handle);
static void triggerGuardExpressions_react_main_region__entry_Default(TriggerGuardExpressions* handle);
static void triggerGuardExpressions_clearInEvents(TriggerGuardExpressions* handle);
static void triggerGuardExpressions_clearOutEvents(TriggerGuardExpressions* handle);


void triggerGuardExpressions_init(TriggerGuardExpressions* handle)
{
	sc_integer i;

	for (i = 0; i < TRIGGERGUARDEXPRESSIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = TriggerGuardExpressions_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	triggerGuardExpressions_clearInEvents(handle);
	triggerGuardExpressions_clearOutEvents(handle);

	/* Default init sequence for statechart TriggerGuardExpressions */
	handle->iface.b = bool_false;

}

void triggerGuardExpressions_enter(TriggerGuardExpressions* handle)
{
	/* Default enter sequence for statechart TriggerGuardExpressions */
	triggerGuardExpressions_enseq_main_region_default(handle);
}

void triggerGuardExpressions_exit(TriggerGuardExpressions* handle)
{
	/* Default exit sequence for statechart TriggerGuardExpressions */
	triggerGuardExpressions_exseq_main_region(handle);
}

sc_boolean triggerGuardExpressions_isActive(const TriggerGuardExpressions* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < TRIGGERGUARDEXPRESSIONS_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != TriggerGuardExpressions_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean triggerGuardExpressions_isFinal(const TriggerGuardExpressions* handle)
{
   return bool_false;
}

static void triggerGuardExpressions_clearInEvents(TriggerGuardExpressions* handle)
{
	handle->iface.e1_raised = bool_false;
	handle->iface.e2_raised = bool_false;
}

static void triggerGuardExpressions_clearOutEvents(TriggerGuardExpressions* handle)
{
}

void triggerGuardExpressions_runCycle(TriggerGuardExpressions* handle)
{
	
	triggerGuardExpressions_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < TRIGGERGUARDEXPRESSIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case TriggerGuardExpressions_main_region_A :
		{
			triggerGuardExpressions_react_main_region_A(handle);
			break;
		}
		case TriggerGuardExpressions_main_region_B :
		{
			triggerGuardExpressions_react_main_region_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	triggerGuardExpressions_clearInEvents(handle);
}


sc_boolean triggerGuardExpressions_isStateActive(const TriggerGuardExpressions* handle, TriggerGuardExpressionsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case TriggerGuardExpressions_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_TRIGGERGUARDEXPRESSIONS_MAIN_REGION_A] == TriggerGuardExpressions_main_region_A
			);
			break;
		case TriggerGuardExpressions_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_TRIGGERGUARDEXPRESSIONS_MAIN_REGION_B] == TriggerGuardExpressions_main_region_B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void triggerGuardExpressionsIface_raise_e1(TriggerGuardExpressions* handle)
{
	handle->iface.e1_raised = bool_true;
}
void triggerGuardExpressionsIface_raise_e2(TriggerGuardExpressions* handle)
{
	handle->iface.e2_raised = bool_true;
}


sc_boolean triggerGuardExpressionsIface_get_b(const TriggerGuardExpressions* handle)
{
	return handle->iface.b;
}
void triggerGuardExpressionsIface_set_b(TriggerGuardExpressions* handle, sc_boolean value)
{
	handle->iface.b = value;
}

/* implementations of all internal functions */

static sc_boolean triggerGuardExpressions_check_main_region_A_tr0_tr0(const TriggerGuardExpressions* handle)
{
	return ((handle->iface.e1_raised || handle->iface.e2_raised) && (handle->iface.b)) ? bool_true : bool_false;
}

static sc_boolean triggerGuardExpressions_check_main_region_B_tr0_tr0(const TriggerGuardExpressions* handle)
{
	return bool_true;
}

static void triggerGuardExpressions_effect_main_region_A_tr0(TriggerGuardExpressions* handle)
{
	triggerGuardExpressions_exseq_main_region_A(handle);
	triggerGuardExpressions_enseq_main_region_B_default(handle);
}

static void triggerGuardExpressions_effect_main_region_B_tr0(TriggerGuardExpressions* handle)
{
	triggerGuardExpressions_exseq_main_region_B(handle);
	triggerGuardExpressions_enseq_main_region_A_default(handle);
}

/* 'default' enter sequence for state A */
static void triggerGuardExpressions_enseq_main_region_A_default(TriggerGuardExpressions* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = TriggerGuardExpressions_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void triggerGuardExpressions_enseq_main_region_B_default(TriggerGuardExpressions* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = TriggerGuardExpressions_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void triggerGuardExpressions_enseq_main_region_default(TriggerGuardExpressions* handle)
{
	/* 'default' enter sequence for region main region */
	triggerGuardExpressions_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void triggerGuardExpressions_exseq_main_region_A(TriggerGuardExpressions* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = TriggerGuardExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void triggerGuardExpressions_exseq_main_region_B(TriggerGuardExpressions* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = TriggerGuardExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void triggerGuardExpressions_exseq_main_region(TriggerGuardExpressions* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of TriggerGuardExpressions.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case TriggerGuardExpressions_main_region_A :
		{
			triggerGuardExpressions_exseq_main_region_A(handle);
			break;
		}
		case TriggerGuardExpressions_main_region_B :
		{
			triggerGuardExpressions_exseq_main_region_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void triggerGuardExpressions_react_main_region_A(TriggerGuardExpressions* handle)
{
	/* The reactions of state A. */
	if (triggerGuardExpressions_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		triggerGuardExpressions_effect_main_region_A_tr0(handle);
	} 
}

/* The reactions of state B. */
static void triggerGuardExpressions_react_main_region_B(TriggerGuardExpressions* handle)
{
	/* The reactions of state B. */
	triggerGuardExpressions_effect_main_region_B_tr0(handle);
}

/* Default react sequence for initial entry  */
static void triggerGuardExpressions_react_main_region__entry_Default(TriggerGuardExpressions* handle)
{
	/* Default react sequence for initial entry  */
	triggerGuardExpressions_enseq_main_region_A_default(handle);
}


