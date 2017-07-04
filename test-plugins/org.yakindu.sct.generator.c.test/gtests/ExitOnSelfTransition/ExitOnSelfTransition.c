
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "ExitOnSelfTransition.h"
/*! \file Implementation of the state machine 'ExitOnSelfTransition'
*/

/* prototypes of all internal functions */
static sc_boolean exitOnSelfTransition_check_main_region_A_tr0_tr0(const ExitOnSelfTransition* handle);
static sc_boolean exitOnSelfTransition_check_main_region_A_tr1_tr1(const ExitOnSelfTransition* handle);
static sc_boolean exitOnSelfTransition_check_main_region_B_tr0_tr0(const ExitOnSelfTransition* handle);
static void exitOnSelfTransition_effect_main_region_A_tr0(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_effect_main_region_A_tr1(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_effect_main_region_B_tr0(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_enact_main_region_A(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_exact_main_region_A(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_enseq_main_region_A_default(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_enseq_main_region_B_default(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_enseq_main_region_default(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_exseq_main_region_A(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_exseq_main_region_B(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_exseq_main_region(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_react_main_region_A(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_react_main_region_B(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_react_main_region__entry_Default(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_clearInEvents(ExitOnSelfTransition* handle);
static void exitOnSelfTransition_clearOutEvents(ExitOnSelfTransition* handle);


void exitOnSelfTransition_init(ExitOnSelfTransition* handle)
{
	sc_integer i;

	for (i = 0; i < EXITONSELFTRANSITION_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = ExitOnSelfTransition_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	exitOnSelfTransition_clearInEvents(handle);
	exitOnSelfTransition_clearOutEvents(handle);

	/* Default init sequence for statechart ExitOnSelfTransition */
	handle->iface.entryCount = 0;
	handle->iface.exitCount = 0;

}

void exitOnSelfTransition_enter(ExitOnSelfTransition* handle)
{
	/* Default enter sequence for statechart ExitOnSelfTransition */
	exitOnSelfTransition_enseq_main_region_default(handle);
}

void exitOnSelfTransition_exit(ExitOnSelfTransition* handle)
{
	/* Default exit sequence for statechart ExitOnSelfTransition */
	exitOnSelfTransition_exseq_main_region(handle);
}

sc_boolean exitOnSelfTransition_isActive(const ExitOnSelfTransition* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < EXITONSELFTRANSITION_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != ExitOnSelfTransition_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean exitOnSelfTransition_isFinal(const ExitOnSelfTransition* handle)
{
   return bool_false;
}

static void exitOnSelfTransition_clearInEvents(ExitOnSelfTransition* handle)
{
	handle->iface.e_raised = bool_false;
	handle->iface.f_raised = bool_false;
}

static void exitOnSelfTransition_clearOutEvents(ExitOnSelfTransition* handle)
{
}

void exitOnSelfTransition_runCycle(ExitOnSelfTransition* handle)
{
	
	exitOnSelfTransition_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < EXITONSELFTRANSITION_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case ExitOnSelfTransition_main_region_A :
		{
			exitOnSelfTransition_react_main_region_A(handle);
			break;
		}
		case ExitOnSelfTransition_main_region_B :
		{
			exitOnSelfTransition_react_main_region_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	exitOnSelfTransition_clearInEvents(handle);
}


sc_boolean exitOnSelfTransition_isStateActive(const ExitOnSelfTransition* handle, ExitOnSelfTransitionStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case ExitOnSelfTransition_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_EXITONSELFTRANSITION_MAIN_REGION_A] == ExitOnSelfTransition_main_region_A
			);
			break;
		case ExitOnSelfTransition_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_EXITONSELFTRANSITION_MAIN_REGION_B] == ExitOnSelfTransition_main_region_B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void exitOnSelfTransitionIface_raise_e(ExitOnSelfTransition* handle)
{
	handle->iface.e_raised = bool_true;
}
void exitOnSelfTransitionIface_raise_f(ExitOnSelfTransition* handle)
{
	handle->iface.f_raised = bool_true;
}


sc_integer exitOnSelfTransitionIface_get_entryCount(const ExitOnSelfTransition* handle)
{
	return handle->iface.entryCount;
}
void exitOnSelfTransitionIface_set_entryCount(ExitOnSelfTransition* handle, sc_integer value)
{
	handle->iface.entryCount = value;
}
sc_integer exitOnSelfTransitionIface_get_exitCount(const ExitOnSelfTransition* handle)
{
	return handle->iface.exitCount;
}
void exitOnSelfTransitionIface_set_exitCount(ExitOnSelfTransition* handle, sc_integer value)
{
	handle->iface.exitCount = value;
}

/* implementations of all internal functions */

static sc_boolean exitOnSelfTransition_check_main_region_A_tr0_tr0(const ExitOnSelfTransition* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean exitOnSelfTransition_check_main_region_A_tr1_tr1(const ExitOnSelfTransition* handle)
{
	return handle->iface.f_raised;
}

static sc_boolean exitOnSelfTransition_check_main_region_B_tr0_tr0(const ExitOnSelfTransition* handle)
{
	return handle->iface.f_raised;
}

static void exitOnSelfTransition_effect_main_region_A_tr0(ExitOnSelfTransition* handle)
{
	exitOnSelfTransition_exseq_main_region_A(handle);
	exitOnSelfTransition_enseq_main_region_A_default(handle);
}

static void exitOnSelfTransition_effect_main_region_A_tr1(ExitOnSelfTransition* handle)
{
	exitOnSelfTransition_exseq_main_region_A(handle);
	exitOnSelfTransition_enseq_main_region_B_default(handle);
}

static void exitOnSelfTransition_effect_main_region_B_tr0(ExitOnSelfTransition* handle)
{
	exitOnSelfTransition_exseq_main_region_B(handle);
	exitOnSelfTransition_enseq_main_region_A_default(handle);
}

/* Entry action for state 'A'. */
static void exitOnSelfTransition_enact_main_region_A(ExitOnSelfTransition* handle)
{
	/* Entry action for state 'A'. */
	handle->iface.entryCount += 1;
}

/* Exit action for state 'A'. */
static void exitOnSelfTransition_exact_main_region_A(ExitOnSelfTransition* handle)
{
	/* Exit action for state 'A'. */
	handle->iface.exitCount += 1;
}

/* 'default' enter sequence for state A */
static void exitOnSelfTransition_enseq_main_region_A_default(ExitOnSelfTransition* handle)
{
	/* 'default' enter sequence for state A */
	exitOnSelfTransition_enact_main_region_A(handle);
	handle->stateConfVector[0] = ExitOnSelfTransition_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void exitOnSelfTransition_enseq_main_region_B_default(ExitOnSelfTransition* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = ExitOnSelfTransition_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void exitOnSelfTransition_enseq_main_region_default(ExitOnSelfTransition* handle)
{
	/* 'default' enter sequence for region main region */
	exitOnSelfTransition_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void exitOnSelfTransition_exseq_main_region_A(ExitOnSelfTransition* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = ExitOnSelfTransition_last_state;
	handle->stateConfVectorPosition = 0;
	exitOnSelfTransition_exact_main_region_A(handle);
}

/* Default exit sequence for state B */
static void exitOnSelfTransition_exseq_main_region_B(ExitOnSelfTransition* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = ExitOnSelfTransition_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void exitOnSelfTransition_exseq_main_region(ExitOnSelfTransition* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of ExitOnSelfTransition.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ExitOnSelfTransition_main_region_A :
		{
			exitOnSelfTransition_exseq_main_region_A(handle);
			break;
		}
		case ExitOnSelfTransition_main_region_B :
		{
			exitOnSelfTransition_exseq_main_region_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void exitOnSelfTransition_react_main_region_A(ExitOnSelfTransition* handle)
{
	/* The reactions of state A. */
	if (exitOnSelfTransition_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		exitOnSelfTransition_effect_main_region_A_tr0(handle);
	}  else
	{
		if (exitOnSelfTransition_check_main_region_A_tr1_tr1(handle) == bool_true)
		{ 
			exitOnSelfTransition_effect_main_region_A_tr1(handle);
		} 
	}
}

/* The reactions of state B. */
static void exitOnSelfTransition_react_main_region_B(ExitOnSelfTransition* handle)
{
	/* The reactions of state B. */
	if (exitOnSelfTransition_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		exitOnSelfTransition_effect_main_region_B_tr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void exitOnSelfTransition_react_main_region__entry_Default(ExitOnSelfTransition* handle)
{
	/* Default react sequence for initial entry  */
	exitOnSelfTransition_enseq_main_region_A_default(handle);
}


