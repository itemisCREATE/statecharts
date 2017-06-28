
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "StaticChoice.h"
/*! \file Implementation of the state machine 'StaticChoice'
*/

/* prototypes of all internal functions */
static sc_boolean staticChoice_check_main_region_Start_tr0_tr0(const StaticChoice* handle);
static sc_boolean staticChoice_check_main_region__choice_0_tr1_tr1(const StaticChoice* handle);
static sc_boolean staticChoice_check_main_region__choice_0_tr0(const StaticChoice* handle);
static void staticChoice_effect_main_region_Start_tr0(StaticChoice* handle);
static void staticChoice_effect_main_region__choice_0_tr1(StaticChoice* handle);
static void staticChoice_effect_main_region__choice_0_tr0(StaticChoice* handle);
static void staticChoice_enact_main_region_Start(StaticChoice* handle);
static void staticChoice_enseq_main_region_Start_default(StaticChoice* handle);
static void staticChoice_enseq_main_region_B_default(StaticChoice* handle);
static void staticChoice_enseq_main_region_A_default(StaticChoice* handle);
static void staticChoice_enseq_main_region_default(StaticChoice* handle);
static void staticChoice_exseq_main_region_Start(StaticChoice* handle);
static void staticChoice_exseq_main_region_B(StaticChoice* handle);
static void staticChoice_exseq_main_region_A(StaticChoice* handle);
static void staticChoice_exseq_main_region(StaticChoice* handle);
static void staticChoice_react_main_region_Start(StaticChoice* handle);
static void staticChoice_react_main_region_B(StaticChoice* handle);
static void staticChoice_react_main_region_A(StaticChoice* handle);
static void staticChoice_react_main_region__choice_0(StaticChoice* handle);
static void staticChoice_react_main_region__entry_Default(StaticChoice* handle);
static void staticChoice_clearInEvents(StaticChoice* handle);
static void staticChoice_clearOutEvents(StaticChoice* handle);


void staticChoice_init(StaticChoice* handle)
{
	sc_integer i;

	for (i = 0; i < STATICCHOICE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = StaticChoice_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	staticChoice_clearInEvents(handle);
	staticChoice_clearOutEvents(handle);

	/* Default init sequence for statechart StaticChoice */
	handle->iface.number = 0;

}

void staticChoice_enter(StaticChoice* handle)
{
	/* Default enter sequence for statechart StaticChoice */
	staticChoice_enseq_main_region_default(handle);
}

void staticChoice_exit(StaticChoice* handle)
{
	/* Default exit sequence for statechart StaticChoice */
	staticChoice_exseq_main_region(handle);
}

sc_boolean staticChoice_isActive(const StaticChoice* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < STATICCHOICE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != StaticChoice_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean staticChoice_isFinal(const StaticChoice* handle)
{
   return bool_false;
}

static void staticChoice_clearInEvents(StaticChoice* handle)
{
	handle->iface.reset_raised = bool_false;
}

static void staticChoice_clearOutEvents(StaticChoice* handle)
{
}

void staticChoice_runCycle(StaticChoice* handle)
{
	
	staticChoice_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < STATICCHOICE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case StaticChoice_main_region_Start :
		{
			staticChoice_react_main_region_Start(handle);
			break;
		}
		case StaticChoice_main_region_B :
		{
			staticChoice_react_main_region_B(handle);
			break;
		}
		case StaticChoice_main_region_A :
		{
			staticChoice_react_main_region_A(handle);
			break;
		}
		default:
			break;
		}
	}
	
	staticChoice_clearInEvents(handle);
}


sc_boolean staticChoice_isStateActive(const StaticChoice* handle, StaticChoiceStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case StaticChoice_main_region_Start :
			result = (sc_boolean) (handle->stateConfVector[SCVI_STATICCHOICE_MAIN_REGION_START] == StaticChoice_main_region_Start
			);
			break;
		case StaticChoice_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_STATICCHOICE_MAIN_REGION_B] == StaticChoice_main_region_B
			);
			break;
		case StaticChoice_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_STATICCHOICE_MAIN_REGION_A] == StaticChoice_main_region_A
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void staticChoiceIface_raise_reset(StaticChoice* handle)
{
	handle->iface.reset_raised = bool_true;
}


sc_integer staticChoiceIface_get_number(const StaticChoice* handle)
{
	return handle->iface.number;
}
void staticChoiceIface_set_number(StaticChoice* handle, sc_integer value)
{
	handle->iface.number = value;
}

/* implementations of all internal functions */

static sc_boolean staticChoice_check_main_region_Start_tr0_tr0(const StaticChoice* handle)
{
	return bool_true;
}

static sc_boolean staticChoice_check_main_region__choice_0_tr1_tr1(const StaticChoice* handle)
{
	return (handle->iface.number == 2) ? bool_true : bool_false;
}

static sc_boolean staticChoice_check_main_region__choice_0_tr0(const StaticChoice* handle)
{
	return bool_true;
}

static void staticChoice_effect_main_region_Start_tr0(StaticChoice* handle)
{
	staticChoice_exseq_main_region_Start(handle);
	handle->iface.number += 1;
	staticChoice_react_main_region__choice_0(handle);
}

static void staticChoice_effect_main_region__choice_0_tr1(StaticChoice* handle)
{
	staticChoice_enseq_main_region_A_default(handle);
}

static void staticChoice_effect_main_region__choice_0_tr0(StaticChoice* handle)
{
	staticChoice_enseq_main_region_B_default(handle);
}

/* Entry action for state 'Start'. */
static void staticChoice_enact_main_region_Start(StaticChoice* handle)
{
	/* Entry action for state 'Start'. */
	handle->iface.number = 1;
}

/* 'default' enter sequence for state Start */
static void staticChoice_enseq_main_region_Start_default(StaticChoice* handle)
{
	/* 'default' enter sequence for state Start */
	staticChoice_enact_main_region_Start(handle);
	handle->stateConfVector[0] = StaticChoice_main_region_Start;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void staticChoice_enseq_main_region_B_default(StaticChoice* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = StaticChoice_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state A */
static void staticChoice_enseq_main_region_A_default(StaticChoice* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = StaticChoice_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void staticChoice_enseq_main_region_default(StaticChoice* handle)
{
	/* 'default' enter sequence for region main region */
	staticChoice_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state Start */
static void staticChoice_exseq_main_region_Start(StaticChoice* handle)
{
	/* Default exit sequence for state Start */
	handle->stateConfVector[0] = StaticChoice_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void staticChoice_exseq_main_region_B(StaticChoice* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = StaticChoice_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state A */
static void staticChoice_exseq_main_region_A(StaticChoice* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = StaticChoice_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void staticChoice_exseq_main_region(StaticChoice* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of StaticChoice.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case StaticChoice_main_region_Start :
		{
			staticChoice_exseq_main_region_Start(handle);
			break;
		}
		case StaticChoice_main_region_B :
		{
			staticChoice_exseq_main_region_B(handle);
			break;
		}
		case StaticChoice_main_region_A :
		{
			staticChoice_exseq_main_region_A(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state Start. */
static void staticChoice_react_main_region_Start(StaticChoice* handle)
{
	/* The reactions of state Start. */
	staticChoice_effect_main_region_Start_tr0(handle);
}

/* The reactions of state B. */
static void staticChoice_react_main_region_B(StaticChoice* handle)
{
	/* The reactions of state B. */
}

/* The reactions of state A. */
static void staticChoice_react_main_region_A(StaticChoice* handle)
{
	/* The reactions of state A. */
}

/* The reactions of state null. */
static void staticChoice_react_main_region__choice_0(StaticChoice* handle)
{
	/* The reactions of state null. */
	if (staticChoice_check_main_region__choice_0_tr1_tr1(handle) == bool_true)
	{ 
		staticChoice_effect_main_region__choice_0_tr1(handle);
	}  else
	{
		staticChoice_effect_main_region__choice_0_tr0(handle);
	}
}

/* Default react sequence for initial entry  */
static void staticChoice_react_main_region__entry_Default(StaticChoice* handle)
{
	/* Default react sequence for initial entry  */
	staticChoice_enseq_main_region_Start_default(handle);
}


