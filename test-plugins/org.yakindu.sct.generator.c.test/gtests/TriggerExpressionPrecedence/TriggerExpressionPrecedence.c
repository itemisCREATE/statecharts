
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "TriggerExpressionPrecedence.h"
/*! \file Implementation of the state machine 'TriggerExpressionPrecedence'
*/

/* prototypes of all internal functions */
static sc_boolean triggerExpressionPrecedence_check_TriggerExpressionPrecedence_main_region_A_tr0_tr0(const TriggerExpressionPrecedence* handle);
static sc_boolean triggerExpressionPrecedence_check_TriggerExpressionPrecedence_main_region_A_tr1_tr1(const TriggerExpressionPrecedence* handle);
static void triggerExpressionPrecedence_effect_TriggerExpressionPrecedence_main_region_A_tr0(TriggerExpressionPrecedence* handle);
static void triggerExpressionPrecedence_effect_TriggerExpressionPrecedence_main_region_A_tr1(TriggerExpressionPrecedence* handle);
static void triggerExpressionPrecedence_enseq_TriggerExpressionPrecedence_main_region_A_default(TriggerExpressionPrecedence* handle);
static void triggerExpressionPrecedence_enseq_TriggerExpressionPrecedence_main_region_default(TriggerExpressionPrecedence* handle);
static void triggerExpressionPrecedence_exseq_TriggerExpressionPrecedence_main_region_A(TriggerExpressionPrecedence* handle);
static void triggerExpressionPrecedence_exseq_TriggerExpressionPrecedence_main_region(TriggerExpressionPrecedence* handle);
static void triggerExpressionPrecedence_react_TriggerExpressionPrecedence_main_region_A(TriggerExpressionPrecedence* handle);
static void triggerExpressionPrecedence_react_TriggerExpressionPrecedence_main_region__entry_Default(TriggerExpressionPrecedence* handle);
static void triggerExpressionPrecedence_clearInEvents(TriggerExpressionPrecedence* handle);
static void triggerExpressionPrecedence_clearOutEvents(TriggerExpressionPrecedence* handle);


void triggerExpressionPrecedence_init(TriggerExpressionPrecedence* handle)
{
	sc_integer i;

	for (i = 0; i < TRIGGEREXPRESSIONPRECEDENCE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = TriggerExpressionPrecedence_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	triggerExpressionPrecedence_clearInEvents(handle);
	triggerExpressionPrecedence_clearOutEvents(handle);

	/* Default init sequence for statechart TriggerExpressionPrecedence */
	handle->iface.c1 = bool_false;
	handle->iface.c2 = bool_false;
	handle->iface.e1_transition = bool_false;
	handle->iface.e2_transition = bool_false;

}

void triggerExpressionPrecedence_enter(TriggerExpressionPrecedence* handle)
{
	/* Default enter sequence for statechart TriggerExpressionPrecedence */
	triggerExpressionPrecedence_enseq_TriggerExpressionPrecedence_main_region_default(handle);
}

void triggerExpressionPrecedence_exit(TriggerExpressionPrecedence* handle)
{
	/* Default exit sequence for statechart TriggerExpressionPrecedence */
	triggerExpressionPrecedence_exseq_TriggerExpressionPrecedence_main_region(handle);
}

sc_boolean triggerExpressionPrecedence_isActive(const TriggerExpressionPrecedence* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < TRIGGEREXPRESSIONPRECEDENCE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != TriggerExpressionPrecedence_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean triggerExpressionPrecedence_isFinal(const TriggerExpressionPrecedence* handle)
{
   return bool_false;
}

static void triggerExpressionPrecedence_clearInEvents(TriggerExpressionPrecedence* handle)
{
	handle->iface.e1_raised = bool_false;
	handle->iface.e2_raised = bool_false;
}

static void triggerExpressionPrecedence_clearOutEvents(TriggerExpressionPrecedence* handle)
{
}

void triggerExpressionPrecedence_runCycle(TriggerExpressionPrecedence* handle)
{
	
	triggerExpressionPrecedence_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < TRIGGEREXPRESSIONPRECEDENCE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case TriggerExpressionPrecedence_TriggerExpressionPrecedence_main_region_A :
		{
			triggerExpressionPrecedence_react_TriggerExpressionPrecedence_main_region_A(handle);
			break;
		}
		default:
			break;
		}
	}
	
	triggerExpressionPrecedence_clearInEvents(handle);
}


sc_boolean triggerExpressionPrecedence_isStateActive(const TriggerExpressionPrecedence* handle, TriggerExpressionPrecedenceStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case TriggerExpressionPrecedence_TriggerExpressionPrecedence_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_TRIGGEREXPRESSIONPRECEDENCE_TRIGGEREXPRESSIONPRECEDENCE_MAIN_REGION_A] == TriggerExpressionPrecedence_TriggerExpressionPrecedence_main_region_A
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void triggerExpressionPrecedenceIface_raise_e1(TriggerExpressionPrecedence* handle)
{
	handle->iface.e1_raised = bool_true;
}
void triggerExpressionPrecedenceIface_raise_e2(TriggerExpressionPrecedence* handle)
{
	handle->iface.e2_raised = bool_true;
}


sc_boolean triggerExpressionPrecedenceIface_get_c1(const TriggerExpressionPrecedence* handle)
{
	return handle->iface.c1;
}
void triggerExpressionPrecedenceIface_set_c1(TriggerExpressionPrecedence* handle, sc_boolean value)
{
	handle->iface.c1 = value;
}
sc_boolean triggerExpressionPrecedenceIface_get_c2(const TriggerExpressionPrecedence* handle)
{
	return handle->iface.c2;
}
void triggerExpressionPrecedenceIface_set_c2(TriggerExpressionPrecedence* handle, sc_boolean value)
{
	handle->iface.c2 = value;
}
sc_boolean triggerExpressionPrecedenceIface_get_e1_transition(const TriggerExpressionPrecedence* handle)
{
	return handle->iface.e1_transition;
}
void triggerExpressionPrecedenceIface_set_e1_transition(TriggerExpressionPrecedence* handle, sc_boolean value)
{
	handle->iface.e1_transition = value;
}
sc_boolean triggerExpressionPrecedenceIface_get_e2_transition(const TriggerExpressionPrecedence* handle)
{
	return handle->iface.e2_transition;
}
void triggerExpressionPrecedenceIface_set_e2_transition(TriggerExpressionPrecedence* handle, sc_boolean value)
{
	handle->iface.e2_transition = value;
}

/* implementations of all internal functions */

static sc_boolean triggerExpressionPrecedence_check_TriggerExpressionPrecedence_main_region_A_tr0_tr0(const TriggerExpressionPrecedence* handle)
{
	return ((handle->iface.e1_raised) && (handle->iface.c1 || handle->iface.c2)) ? bool_true : bool_false;
}

static sc_boolean triggerExpressionPrecedence_check_TriggerExpressionPrecedence_main_region_A_tr1_tr1(const TriggerExpressionPrecedence* handle)
{
	return handle->iface.e2_raised;
}

static void triggerExpressionPrecedence_effect_TriggerExpressionPrecedence_main_region_A_tr0(TriggerExpressionPrecedence* handle)
{
	triggerExpressionPrecedence_exseq_TriggerExpressionPrecedence_main_region_A(handle);
	handle->iface.e1_transition = bool_true;
	triggerExpressionPrecedence_enseq_TriggerExpressionPrecedence_main_region_A_default(handle);
}

static void triggerExpressionPrecedence_effect_TriggerExpressionPrecedence_main_region_A_tr1(TriggerExpressionPrecedence* handle)
{
	triggerExpressionPrecedence_exseq_TriggerExpressionPrecedence_main_region_A(handle);
	handle->iface.e2_transition = bool_true;
	triggerExpressionPrecedence_enseq_TriggerExpressionPrecedence_main_region_A_default(handle);
}

/* 'default' enter sequence for state A */
static void triggerExpressionPrecedence_enseq_TriggerExpressionPrecedence_main_region_A_default(TriggerExpressionPrecedence* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = TriggerExpressionPrecedence_TriggerExpressionPrecedence_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void triggerExpressionPrecedence_enseq_TriggerExpressionPrecedence_main_region_default(TriggerExpressionPrecedence* handle)
{
	/* 'default' enter sequence for region main region */
	triggerExpressionPrecedence_react_TriggerExpressionPrecedence_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void triggerExpressionPrecedence_exseq_TriggerExpressionPrecedence_main_region_A(TriggerExpressionPrecedence* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = TriggerExpressionPrecedence_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void triggerExpressionPrecedence_exseq_TriggerExpressionPrecedence_main_region(TriggerExpressionPrecedence* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of expressions.TriggerExpressionPrecedence.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case TriggerExpressionPrecedence_TriggerExpressionPrecedence_main_region_A :
		{
			triggerExpressionPrecedence_exseq_TriggerExpressionPrecedence_main_region_A(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void triggerExpressionPrecedence_react_TriggerExpressionPrecedence_main_region_A(TriggerExpressionPrecedence* handle)
{
	/* The reactions of state A. */
	if (triggerExpressionPrecedence_check_TriggerExpressionPrecedence_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		triggerExpressionPrecedence_effect_TriggerExpressionPrecedence_main_region_A_tr0(handle);
	}  else
	{
		if (triggerExpressionPrecedence_check_TriggerExpressionPrecedence_main_region_A_tr1_tr1(handle) == bool_true)
		{ 
			triggerExpressionPrecedence_effect_TriggerExpressionPrecedence_main_region_A_tr1(handle);
		} 
	}
}

/* Default react sequence for initial entry  */
static void triggerExpressionPrecedence_react_TriggerExpressionPrecedence_main_region__entry_Default(TriggerExpressionPrecedence* handle)
{
	/* Default react sequence for initial entry  */
	triggerExpressionPrecedence_enseq_TriggerExpressionPrecedence_main_region_A_default(handle);
}


