
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "DynamicChoice.h"
/*! \file Implementation of the state machine 'DynamicChoice'
*/

/* prototypes of all internal functions */
static sc_boolean dynamicChoice_check_main_region_Start_tr0_tr0(const DynamicChoice* handle);
static sc_boolean dynamicChoice_check_main_region__choice_0_tr0_tr0(const DynamicChoice* handle);
static sc_boolean dynamicChoice_check_main_region__choice_0_tr1(const DynamicChoice* handle);
static void dynamicChoice_effect_main_region_Start_tr0(DynamicChoice* handle);
static void dynamicChoice_effect_main_region__choice_0_tr0(DynamicChoice* handle);
static void dynamicChoice_effect_main_region__choice_0_tr1(DynamicChoice* handle);
static void dynamicChoice_enact_main_region_Start(DynamicChoice* handle);
static void dynamicChoice_enseq_main_region_Start_default(DynamicChoice* handle);
static void dynamicChoice_enseq_main_region_A_default(DynamicChoice* handle);
static void dynamicChoice_enseq_main_region_B_default(DynamicChoice* handle);
static void dynamicChoice_enseq_main_region_default(DynamicChoice* handle);
static void dynamicChoice_exseq_main_region_Start(DynamicChoice* handle);
static void dynamicChoice_exseq_main_region_A(DynamicChoice* handle);
static void dynamicChoice_exseq_main_region_B(DynamicChoice* handle);
static void dynamicChoice_exseq_main_region(DynamicChoice* handle);
static void dynamicChoice_react_main_region_Start(DynamicChoice* handle);
static void dynamicChoice_react_main_region_A(DynamicChoice* handle);
static void dynamicChoice_react_main_region_B(DynamicChoice* handle);
static void dynamicChoice_react_main_region__choice_0(DynamicChoice* handle);
static void dynamicChoice_react_main_region__entry_Default(DynamicChoice* handle);
static void dynamicChoice_clearInEvents(DynamicChoice* handle);
static void dynamicChoice_clearOutEvents(DynamicChoice* handle);


void dynamicChoice_init(DynamicChoice* handle)
{
	sc_integer i;

	for (i = 0; i < DYNAMICCHOICE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = DynamicChoice_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	dynamicChoice_clearInEvents(handle);
	dynamicChoice_clearOutEvents(handle);

	/* Default init sequence for statechart DynamicChoice */
	handle->iface.number = 0;

}

void dynamicChoice_enter(DynamicChoice* handle)
{
	/* Default enter sequence for statechart DynamicChoice */
	dynamicChoice_enseq_main_region_default(handle);
}

void dynamicChoice_exit(DynamicChoice* handle)
{
	/* Default exit sequence for statechart DynamicChoice */
	dynamicChoice_exseq_main_region(handle);
}

sc_boolean dynamicChoice_isActive(const DynamicChoice* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < DYNAMICCHOICE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != DynamicChoice_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean dynamicChoice_isFinal(const DynamicChoice* handle)
{
   return bool_false;
}

static void dynamicChoice_clearInEvents(DynamicChoice* handle)
{
	handle->iface.reset_raised = bool_false;
}

static void dynamicChoice_clearOutEvents(DynamicChoice* handle)
{
}

void dynamicChoice_runCycle(DynamicChoice* handle)
{
	
	dynamicChoice_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < DYNAMICCHOICE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case DynamicChoice_main_region_Start :
		{
			dynamicChoice_react_main_region_Start(handle);
			break;
		}
		case DynamicChoice_main_region_A :
		{
			dynamicChoice_react_main_region_A(handle);
			break;
		}
		case DynamicChoice_main_region_B :
		{
			dynamicChoice_react_main_region_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	dynamicChoice_clearInEvents(handle);
}


sc_boolean dynamicChoice_isStateActive(const DynamicChoice* handle, DynamicChoiceStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case DynamicChoice_main_region_Start :
			result = (sc_boolean) (handle->stateConfVector[SCVI_DYNAMICCHOICE_MAIN_REGION_START] == DynamicChoice_main_region_Start
			);
			break;
		case DynamicChoice_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_DYNAMICCHOICE_MAIN_REGION_A] == DynamicChoice_main_region_A
			);
			break;
		case DynamicChoice_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_DYNAMICCHOICE_MAIN_REGION_B] == DynamicChoice_main_region_B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void dynamicChoiceIface_raise_reset(DynamicChoice* handle)
{
	handle->iface.reset_raised = bool_true;
}


sc_integer dynamicChoiceIface_get_number(const DynamicChoice* handle)
{
	return handle->iface.number;
}
void dynamicChoiceIface_set_number(DynamicChoice* handle, sc_integer value)
{
	handle->iface.number = value;
}

/* implementations of all internal functions */

static sc_boolean dynamicChoice_check_main_region_Start_tr0_tr0(const DynamicChoice* handle)
{
	return bool_true;
}

static sc_boolean dynamicChoice_check_main_region__choice_0_tr0_tr0(const DynamicChoice* handle)
{
	return (handle->iface.number == 2) ? bool_true : bool_false;
}

static sc_boolean dynamicChoice_check_main_region__choice_0_tr1(const DynamicChoice* handle)
{
	return bool_true;
}

static void dynamicChoice_effect_main_region_Start_tr0(DynamicChoice* handle)
{
	dynamicChoice_exseq_main_region_Start(handle);
	handle->iface.number += 1;
	dynamicChoice_react_main_region__choice_0(handle);
}

static void dynamicChoice_effect_main_region__choice_0_tr0(DynamicChoice* handle)
{
	dynamicChoice_enseq_main_region_A_default(handle);
}

static void dynamicChoice_effect_main_region__choice_0_tr1(DynamicChoice* handle)
{
	dynamicChoice_enseq_main_region_B_default(handle);
}

/* Entry action for state 'Start'. */
static void dynamicChoice_enact_main_region_Start(DynamicChoice* handle)
{
	/* Entry action for state 'Start'. */
	handle->iface.number = 1;
}

/* 'default' enter sequence for state Start */
static void dynamicChoice_enseq_main_region_Start_default(DynamicChoice* handle)
{
	/* 'default' enter sequence for state Start */
	dynamicChoice_enact_main_region_Start(handle);
	handle->stateConfVector[0] = DynamicChoice_main_region_Start;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state A */
static void dynamicChoice_enseq_main_region_A_default(DynamicChoice* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = DynamicChoice_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void dynamicChoice_enseq_main_region_B_default(DynamicChoice* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = DynamicChoice_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void dynamicChoice_enseq_main_region_default(DynamicChoice* handle)
{
	/* 'default' enter sequence for region main region */
	dynamicChoice_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state Start */
static void dynamicChoice_exseq_main_region_Start(DynamicChoice* handle)
{
	/* Default exit sequence for state Start */
	handle->stateConfVector[0] = DynamicChoice_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state A */
static void dynamicChoice_exseq_main_region_A(DynamicChoice* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = DynamicChoice_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void dynamicChoice_exseq_main_region_B(DynamicChoice* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = DynamicChoice_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void dynamicChoice_exseq_main_region(DynamicChoice* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of DynamicChoice.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case DynamicChoice_main_region_Start :
		{
			dynamicChoice_exseq_main_region_Start(handle);
			break;
		}
		case DynamicChoice_main_region_A :
		{
			dynamicChoice_exseq_main_region_A(handle);
			break;
		}
		case DynamicChoice_main_region_B :
		{
			dynamicChoice_exseq_main_region_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state Start. */
static void dynamicChoice_react_main_region_Start(DynamicChoice* handle)
{
	/* The reactions of state Start. */
	dynamicChoice_effect_main_region_Start_tr0(handle);
}

/* The reactions of state A. */
static void dynamicChoice_react_main_region_A(DynamicChoice* handle)
{
	/* The reactions of state A. */
}

/* The reactions of state B. */
static void dynamicChoice_react_main_region_B(DynamicChoice* handle)
{
	/* The reactions of state B. */
}

/* The reactions of state null. */
static void dynamicChoice_react_main_region__choice_0(DynamicChoice* handle)
{
	/* The reactions of state null. */
	if (dynamicChoice_check_main_region__choice_0_tr0_tr0(handle) == bool_true)
	{ 
		dynamicChoice_effect_main_region__choice_0_tr0(handle);
	}  else
	{
		dynamicChoice_effect_main_region__choice_0_tr1(handle);
	}
}

/* Default react sequence for initial entry  */
static void dynamicChoice_react_main_region__entry_Default(DynamicChoice* handle)
{
	/* Default react sequence for initial entry  */
	dynamicChoice_enseq_main_region_Start_default(handle);
}


