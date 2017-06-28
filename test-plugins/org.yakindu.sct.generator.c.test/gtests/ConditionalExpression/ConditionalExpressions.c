
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "ConditionalExpressions.h"
/*! \file Implementation of the state machine 'ConditionalExpressions'
*/

/* prototypes of all internal functions */
static sc_boolean conditionalExpressions_check_main_region_A_tr0_tr0(const ConditionalExpressions* handle);
static void conditionalExpressions_effect_main_region_A_tr0(ConditionalExpressions* handle);
static void conditionalExpressions_enact_main_region_A(ConditionalExpressions* handle);
static void conditionalExpressions_enact_main_region_B(ConditionalExpressions* handle);
static void conditionalExpressions_enseq_main_region_A_default(ConditionalExpressions* handle);
static void conditionalExpressions_enseq_main_region_B_default(ConditionalExpressions* handle);
static void conditionalExpressions_enseq_main_region_default(ConditionalExpressions* handle);
static void conditionalExpressions_exseq_main_region_A(ConditionalExpressions* handle);
static void conditionalExpressions_exseq_main_region_B(ConditionalExpressions* handle);
static void conditionalExpressions_exseq_main_region(ConditionalExpressions* handle);
static void conditionalExpressions_react_main_region_A(ConditionalExpressions* handle);
static void conditionalExpressions_react_main_region_B(ConditionalExpressions* handle);
static void conditionalExpressions_react_main_region__entry_Default(ConditionalExpressions* handle);
static void conditionalExpressions_clearInEvents(ConditionalExpressions* handle);
static void conditionalExpressions_clearOutEvents(ConditionalExpressions* handle);


void conditionalExpressions_init(ConditionalExpressions* handle)
{
	sc_integer i;

	for (i = 0; i < CONDITIONALEXPRESSIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = ConditionalExpressions_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	conditionalExpressions_clearInEvents(handle);
	conditionalExpressions_clearOutEvents(handle);

	/* Default init sequence for statechart ConditionalExpressions */
	handle->iface.condition = handle->iface.boolVar ? 3 : 2;
	handle->iface.boolVar = bool_true;

}

void conditionalExpressions_enter(ConditionalExpressions* handle)
{
	/* Default enter sequence for statechart ConditionalExpressions */
	conditionalExpressions_enseq_main_region_default(handle);
}

void conditionalExpressions_exit(ConditionalExpressions* handle)
{
	/* Default exit sequence for statechart ConditionalExpressions */
	conditionalExpressions_exseq_main_region(handle);
}

sc_boolean conditionalExpressions_isActive(const ConditionalExpressions* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < CONDITIONALEXPRESSIONS_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != ConditionalExpressions_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean conditionalExpressions_isFinal(const ConditionalExpressions* handle)
{
   return bool_false;
}

static void conditionalExpressions_clearInEvents(ConditionalExpressions* handle)
{
	handle->iface.e_raised = bool_false;
}

static void conditionalExpressions_clearOutEvents(ConditionalExpressions* handle)
{
}

void conditionalExpressions_runCycle(ConditionalExpressions* handle)
{
	
	conditionalExpressions_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < CONDITIONALEXPRESSIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case ConditionalExpressions_main_region_A :
		{
			conditionalExpressions_react_main_region_A(handle);
			break;
		}
		case ConditionalExpressions_main_region_B :
		{
			conditionalExpressions_react_main_region_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	conditionalExpressions_clearInEvents(handle);
}


sc_boolean conditionalExpressions_isStateActive(const ConditionalExpressions* handle, ConditionalExpressionsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case ConditionalExpressions_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_CONDITIONALEXPRESSIONS_MAIN_REGION_A] == ConditionalExpressions_main_region_A
			);
			break;
		case ConditionalExpressions_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_CONDITIONALEXPRESSIONS_MAIN_REGION_B] == ConditionalExpressions_main_region_B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void conditionalExpressionsIface_raise_e(ConditionalExpressions* handle)
{
	handle->iface.e_raised = bool_true;
}


sc_integer conditionalExpressionsIface_get_condition(const ConditionalExpressions* handle)
{
	return handle->iface.condition;
}
void conditionalExpressionsIface_set_condition(ConditionalExpressions* handle, sc_integer value)
{
	handle->iface.condition = value;
}
sc_boolean conditionalExpressionsIface_get_boolVar(const ConditionalExpressions* handle)
{
	return handle->iface.boolVar;
}
void conditionalExpressionsIface_set_boolVar(ConditionalExpressions* handle, sc_boolean value)
{
	handle->iface.boolVar = value;
}

/* implementations of all internal functions */

static sc_boolean conditionalExpressions_check_main_region_A_tr0_tr0(const ConditionalExpressions* handle)
{
	return ((handle->iface.e_raised) && (1 == (handle->iface.boolVar ? 1 : 0))) ? bool_true : bool_false;
}

static void conditionalExpressions_effect_main_region_A_tr0(ConditionalExpressions* handle)
{
	conditionalExpressions_exseq_main_region_A(handle);
	conditionalExpressions_enseq_main_region_B_default(handle);
}

/* Entry action for state 'A'. */
static void conditionalExpressions_enact_main_region_A(ConditionalExpressions* handle)
{
	/* Entry action for state 'A'. */
	handle->iface.condition = handle->iface.boolVar ? 1 : 0;
}

/* Entry action for state 'B'. */
static void conditionalExpressions_enact_main_region_B(ConditionalExpressions* handle)
{
	/* Entry action for state 'B'. */
	handle->iface.condition = ((handle->iface.condition == 2) ? 1 : 2);
}

/* 'default' enter sequence for state A */
static void conditionalExpressions_enseq_main_region_A_default(ConditionalExpressions* handle)
{
	/* 'default' enter sequence for state A */
	conditionalExpressions_enact_main_region_A(handle);
	handle->stateConfVector[0] = ConditionalExpressions_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void conditionalExpressions_enseq_main_region_B_default(ConditionalExpressions* handle)
{
	/* 'default' enter sequence for state B */
	conditionalExpressions_enact_main_region_B(handle);
	handle->stateConfVector[0] = ConditionalExpressions_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void conditionalExpressions_enseq_main_region_default(ConditionalExpressions* handle)
{
	/* 'default' enter sequence for region main region */
	conditionalExpressions_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void conditionalExpressions_exseq_main_region_A(ConditionalExpressions* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = ConditionalExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void conditionalExpressions_exseq_main_region_B(ConditionalExpressions* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = ConditionalExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void conditionalExpressions_exseq_main_region(ConditionalExpressions* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of ConditionalExpressions.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ConditionalExpressions_main_region_A :
		{
			conditionalExpressions_exseq_main_region_A(handle);
			break;
		}
		case ConditionalExpressions_main_region_B :
		{
			conditionalExpressions_exseq_main_region_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void conditionalExpressions_react_main_region_A(ConditionalExpressions* handle)
{
	/* The reactions of state A. */
	if (conditionalExpressions_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		conditionalExpressions_effect_main_region_A_tr0(handle);
	} 
}

/* The reactions of state B. */
static void conditionalExpressions_react_main_region_B(ConditionalExpressions* handle)
{
	/* The reactions of state B. */
}

/* Default react sequence for initial entry  */
static void conditionalExpressions_react_main_region__entry_Default(ConditionalExpressions* handle)
{
	/* Default react sequence for initial entry  */
	conditionalExpressions_enseq_main_region_A_default(handle);
}


