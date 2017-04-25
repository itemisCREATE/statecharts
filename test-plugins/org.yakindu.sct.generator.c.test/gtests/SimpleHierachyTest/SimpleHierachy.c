
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "SimpleHierachy.h"
/*! \file Implementation of the state machine 'SimpleHierachy'
*/

/* prototypes of all internal functions */
static sc_boolean simpleHierachy_check_main_region_A_tr0_tr0(const SimpleHierachy* handle);
static void simpleHierachy_effect_main_region_A_tr0(SimpleHierachy* handle);
static void simpleHierachy_enseq_main_region_A_default(SimpleHierachy* handle);
static void simpleHierachy_enseq_main_region_B_default(SimpleHierachy* handle);
static void simpleHierachy_enseq_main_region_B_subregion1_B1_default(SimpleHierachy* handle);
static void simpleHierachy_enseq_main_region_default(SimpleHierachy* handle);
static void simpleHierachy_enseq_main_region_B_subregion1_default(SimpleHierachy* handle);
static void simpleHierachy_exseq_main_region_A(SimpleHierachy* handle);
static void simpleHierachy_exseq_main_region_B_subregion1_B1(SimpleHierachy* handle);
static void simpleHierachy_exseq_main_region(SimpleHierachy* handle);
static void simpleHierachy_exseq_main_region_B_subregion1(SimpleHierachy* handle);
static void simpleHierachy_react_main_region_A(SimpleHierachy* handle);
static void simpleHierachy_react_main_region_B_subregion1_B1(SimpleHierachy* handle);
static void simpleHierachy_react_main_region__entry_Default(SimpleHierachy* handle);
static void simpleHierachy_react_main_region_B_subregion1__entry_Default(SimpleHierachy* handle);
static void simpleHierachy_clearInEvents(SimpleHierachy* handle);
static void simpleHierachy_clearOutEvents(SimpleHierachy* handle);


void simpleHierachy_init(SimpleHierachy* handle)
{
	sc_integer i;

	for (i = 0; i < SIMPLEHIERACHY_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = SimpleHierachy_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	simpleHierachy_clearInEvents(handle);
	simpleHierachy_clearOutEvents(handle);


}

void simpleHierachy_enter(SimpleHierachy* handle)
{
	/* Default enter sequence for statechart SimpleHierachy */
	simpleHierachy_enseq_main_region_default(handle);
}

void simpleHierachy_exit(SimpleHierachy* handle)
{
	/* Default exit sequence for statechart SimpleHierachy */
	simpleHierachy_exseq_main_region(handle);
}

sc_boolean simpleHierachy_isActive(const SimpleHierachy* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != SimpleHierachy_last_state)
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
sc_boolean simpleHierachy_isFinal(const SimpleHierachy* handle)
{
   return bool_false;
}

static void simpleHierachy_clearInEvents(SimpleHierachy* handle)
{
	handle->iface.Event1_raised = bool_false;
}

static void simpleHierachy_clearOutEvents(SimpleHierachy* handle)
{
}

void simpleHierachy_runCycle(SimpleHierachy* handle)
{
	
	simpleHierachy_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < SIMPLEHIERACHY_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case SimpleHierachy_main_region_A :
		{
			simpleHierachy_react_main_region_A(handle);
			break;
		}
		case SimpleHierachy_main_region_B_subregion1_B1 :
		{
			simpleHierachy_react_main_region_B_subregion1_B1(handle);
			break;
		}
		default:
			break;
		}
	}
	
	simpleHierachy_clearInEvents(handle);
}


sc_boolean simpleHierachy_isStateActive(const SimpleHierachy* handle, SimpleHierachyStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case SimpleHierachy_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == SimpleHierachy_main_region_A
			);
			break;
		case SimpleHierachy_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[0] >= SimpleHierachy_main_region_B
				&& handle->stateConfVector[0] <= SimpleHierachy_main_region_B_subregion1_B1);
			break;
		case SimpleHierachy_main_region_B_subregion1_B1 :
			result = (sc_boolean) (handle->stateConfVector[0] == SimpleHierachy_main_region_B_subregion1_B1
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void simpleHierachyIface_raise_event1(SimpleHierachy* handle)
{
	handle->iface.Event1_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean simpleHierachy_check_main_region_A_tr0_tr0(const SimpleHierachy* handle)
{
	return handle->iface.Event1_raised;
}

static void simpleHierachy_effect_main_region_A_tr0(SimpleHierachy* handle)
{
	simpleHierachy_exseq_main_region_A(handle);
	simpleHierachy_enseq_main_region_B_default(handle);
}

/* 'default' enter sequence for state A */
static void simpleHierachy_enseq_main_region_A_default(SimpleHierachy* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = SimpleHierachy_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void simpleHierachy_enseq_main_region_B_default(SimpleHierachy* handle)
{
	/* 'default' enter sequence for state B */
	simpleHierachy_enseq_main_region_B_subregion1_default(handle);
}

/* 'default' enter sequence for state B1 */
static void simpleHierachy_enseq_main_region_B_subregion1_B1_default(SimpleHierachy* handle)
{
	/* 'default' enter sequence for state B1 */
	handle->stateConfVector[0] = SimpleHierachy_main_region_B_subregion1_B1;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void simpleHierachy_enseq_main_region_default(SimpleHierachy* handle)
{
	/* 'default' enter sequence for region main region */
	simpleHierachy_react_main_region__entry_Default(handle);
}

/* 'default' enter sequence for region subregion1 */
static void simpleHierachy_enseq_main_region_B_subregion1_default(SimpleHierachy* handle)
{
	/* 'default' enter sequence for region subregion1 */
	simpleHierachy_react_main_region_B_subregion1__entry_Default(handle);
}

/* Default exit sequence for state A */
static void simpleHierachy_exseq_main_region_A(SimpleHierachy* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = SimpleHierachy_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B1 */
static void simpleHierachy_exseq_main_region_B_subregion1_B1(SimpleHierachy* handle)
{
	/* Default exit sequence for state B1 */
	handle->stateConfVector[0] = SimpleHierachy_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void simpleHierachy_exseq_main_region(SimpleHierachy* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of SimpleHierachy.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case SimpleHierachy_main_region_A :
		{
			simpleHierachy_exseq_main_region_A(handle);
			break;
		}
		case SimpleHierachy_main_region_B_subregion1_B1 :
		{
			simpleHierachy_exseq_main_region_B_subregion1_B1(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region subregion1 */
static void simpleHierachy_exseq_main_region_B_subregion1(SimpleHierachy* handle)
{
	/* Default exit sequence for region subregion1 */
	/* Handle exit of all possible states (of SimpleHierachy.main_region.B.subregion1) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case SimpleHierachy_main_region_B_subregion1_B1 :
		{
			simpleHierachy_exseq_main_region_B_subregion1_B1(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void simpleHierachy_react_main_region_A(SimpleHierachy* handle)
{
	/* The reactions of state A. */
	if (simpleHierachy_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		simpleHierachy_effect_main_region_A_tr0(handle);
	} 
}

/* The reactions of state B1. */
static void simpleHierachy_react_main_region_B_subregion1_B1(SimpleHierachy* handle)
{
	/* The reactions of state B1. */
}

/* Default react sequence for initial entry  */
static void simpleHierachy_react_main_region__entry_Default(SimpleHierachy* handle)
{
	/* Default react sequence for initial entry  */
	simpleHierachy_enseq_main_region_A_default(handle);
}

/* Default react sequence for initial entry  */
static void simpleHierachy_react_main_region_B_subregion1__entry_Default(SimpleHierachy* handle)
{
	/* Default react sequence for initial entry  */
	simpleHierachy_enseq_main_region_B_subregion1_B1_default(handle);
}


