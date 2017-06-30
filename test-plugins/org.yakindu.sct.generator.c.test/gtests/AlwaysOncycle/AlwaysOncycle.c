
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "AlwaysOncycle.h"
/*! \file Implementation of the state machine 'AlwaysOncycle'
*/

/* prototypes of all internal functions */
static sc_boolean alwaysOncycle_check_main_region_StateA_tr0_tr0(const AlwaysOncycle* handle);
static sc_boolean alwaysOncycle_check_main_region_StateA_lr1_lr1(const AlwaysOncycle* handle);
static sc_boolean alwaysOncycle_check_main_region_StateB_tr0_tr0(const AlwaysOncycle* handle);
static sc_boolean alwaysOncycle_check_main_region_StateB_lr0_lr0(const AlwaysOncycle* handle);
static void alwaysOncycle_effect_main_region_StateA_tr0(AlwaysOncycle* handle);
static void alwaysOncycle_effect_main_region_StateA_lr1_lr1(AlwaysOncycle* handle);
static void alwaysOncycle_effect_main_region_StateB_tr0(AlwaysOncycle* handle);
static void alwaysOncycle_effect_main_region_StateB_lr0_lr0(AlwaysOncycle* handle);
static void alwaysOncycle_enact_main_region_StateA(AlwaysOncycle* handle);
static void alwaysOncycle_exact_main_region_StateA(AlwaysOncycle* handle);
static void alwaysOncycle_enseq_main_region_StateA_default(AlwaysOncycle* handle);
static void alwaysOncycle_enseq_main_region_StateB_default(AlwaysOncycle* handle);
static void alwaysOncycle_enseq_main_region_default(AlwaysOncycle* handle);
static void alwaysOncycle_exseq_main_region_StateA(AlwaysOncycle* handle);
static void alwaysOncycle_exseq_main_region_StateB(AlwaysOncycle* handle);
static void alwaysOncycle_exseq_main_region(AlwaysOncycle* handle);
static void alwaysOncycle_react_main_region_StateA(AlwaysOncycle* handle);
static void alwaysOncycle_react_main_region_StateB(AlwaysOncycle* handle);
static void alwaysOncycle_react_main_region__entry_Default(AlwaysOncycle* handle);
static void alwaysOncycle_clearInEvents(AlwaysOncycle* handle);
static void alwaysOncycle_clearOutEvents(AlwaysOncycle* handle);


void alwaysOncycle_init(AlwaysOncycle* handle)
{
	sc_integer i;

	for (i = 0; i < ALWAYSONCYCLE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = AlwaysOncycle_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	alwaysOncycle_clearInEvents(handle);
	alwaysOncycle_clearOutEvents(handle);

	/* Default init sequence for statechart AlwaysOncycle */
	handle->iface.value = 0;
	handle->iface.v2 = bool_false;

}

void alwaysOncycle_enter(AlwaysOncycle* handle)
{
	/* Default enter sequence for statechart AlwaysOncycle */
	alwaysOncycle_enseq_main_region_default(handle);
}

void alwaysOncycle_exit(AlwaysOncycle* handle)
{
	/* Default exit sequence for statechart AlwaysOncycle */
	alwaysOncycle_exseq_main_region(handle);
}

sc_boolean alwaysOncycle_isActive(const AlwaysOncycle* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < ALWAYSONCYCLE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != AlwaysOncycle_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean alwaysOncycle_isFinal(const AlwaysOncycle* handle)
{
   return bool_false;
}

static void alwaysOncycle_clearInEvents(AlwaysOncycle* handle)
{
}

static void alwaysOncycle_clearOutEvents(AlwaysOncycle* handle)
{
}

void alwaysOncycle_runCycle(AlwaysOncycle* handle)
{
	
	alwaysOncycle_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < ALWAYSONCYCLE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case AlwaysOncycle_main_region_StateA :
		{
			alwaysOncycle_react_main_region_StateA(handle);
			break;
		}
		case AlwaysOncycle_main_region_StateB :
		{
			alwaysOncycle_react_main_region_StateB(handle);
			break;
		}
		default:
			break;
		}
	}
	
	alwaysOncycle_clearInEvents(handle);
}


sc_boolean alwaysOncycle_isStateActive(const AlwaysOncycle* handle, AlwaysOncycleStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case AlwaysOncycle_main_region_StateA :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ALWAYSONCYCLE_MAIN_REGION_STATEA] == AlwaysOncycle_main_region_StateA
			);
			break;
		case AlwaysOncycle_main_region_StateB :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ALWAYSONCYCLE_MAIN_REGION_STATEB] == AlwaysOncycle_main_region_StateB
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}



sc_integer alwaysOncycleIface_get_value(const AlwaysOncycle* handle)
{
	return handle->iface.value;
}
void alwaysOncycleIface_set_value(AlwaysOncycle* handle, sc_integer value)
{
	handle->iface.value = value;
}
sc_boolean alwaysOncycleIface_get_v2(const AlwaysOncycle* handle)
{
	return handle->iface.v2;
}
void alwaysOncycleIface_set_v2(AlwaysOncycle* handle, sc_boolean value)
{
	handle->iface.v2 = value;
}

/* implementations of all internal functions */

static sc_boolean alwaysOncycle_check_main_region_StateA_tr0_tr0(const AlwaysOncycle* handle)
{
	return (handle->iface.value == 5) ? bool_true : bool_false;
}

static sc_boolean alwaysOncycle_check_main_region_StateA_lr1_lr1(const AlwaysOncycle* handle)
{
	return bool_true;
}

static sc_boolean alwaysOncycle_check_main_region_StateB_tr0_tr0(const AlwaysOncycle* handle)
{
	return (handle->iface.value == 5) ? bool_true : bool_false;
}

static sc_boolean alwaysOncycle_check_main_region_StateB_lr0_lr0(const AlwaysOncycle* handle)
{
	return bool_true;
}

static void alwaysOncycle_effect_main_region_StateA_tr0(AlwaysOncycle* handle)
{
	alwaysOncycle_exseq_main_region_StateA(handle);
	alwaysOncycle_enseq_main_region_StateB_default(handle);
}

static void alwaysOncycle_effect_main_region_StateA_lr1_lr1(AlwaysOncycle* handle)
{
	handle->iface.value += 1;
}

static void alwaysOncycle_effect_main_region_StateB_tr0(AlwaysOncycle* handle)
{
	alwaysOncycle_exseq_main_region_StateB(handle);
	alwaysOncycle_enseq_main_region_StateA_default(handle);
}

static void alwaysOncycle_effect_main_region_StateB_lr0_lr0(AlwaysOncycle* handle)
{
	handle->iface.value += 1;
}

/* Entry action for state 'StateA'. */
static void alwaysOncycle_enact_main_region_StateA(AlwaysOncycle* handle)
{
	/* Entry action for state 'StateA'. */
	handle->iface.value = 0;
}

/* Exit action for state 'StateA'. */
static void alwaysOncycle_exact_main_region_StateA(AlwaysOncycle* handle)
{
	/* Exit action for state 'StateA'. */
	handle->iface.value = 0;
}

/* 'default' enter sequence for state StateA */
static void alwaysOncycle_enseq_main_region_StateA_default(AlwaysOncycle* handle)
{
	/* 'default' enter sequence for state StateA */
	alwaysOncycle_enact_main_region_StateA(handle);
	handle->stateConfVector[0] = AlwaysOncycle_main_region_StateA;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
static void alwaysOncycle_enseq_main_region_StateB_default(AlwaysOncycle* handle)
{
	/* 'default' enter sequence for state StateB */
	handle->stateConfVector[0] = AlwaysOncycle_main_region_StateB;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void alwaysOncycle_enseq_main_region_default(AlwaysOncycle* handle)
{
	/* 'default' enter sequence for region main region */
	alwaysOncycle_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state StateA */
static void alwaysOncycle_exseq_main_region_StateA(AlwaysOncycle* handle)
{
	/* Default exit sequence for state StateA */
	handle->stateConfVector[0] = AlwaysOncycle_last_state;
	handle->stateConfVectorPosition = 0;
	alwaysOncycle_exact_main_region_StateA(handle);
}

/* Default exit sequence for state StateB */
static void alwaysOncycle_exseq_main_region_StateB(AlwaysOncycle* handle)
{
	/* Default exit sequence for state StateB */
	handle->stateConfVector[0] = AlwaysOncycle_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void alwaysOncycle_exseq_main_region(AlwaysOncycle* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of AlwaysOncycle.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case AlwaysOncycle_main_region_StateA :
		{
			alwaysOncycle_exseq_main_region_StateA(handle);
			break;
		}
		case AlwaysOncycle_main_region_StateB :
		{
			alwaysOncycle_exseq_main_region_StateB(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state StateA. */
static void alwaysOncycle_react_main_region_StateA(AlwaysOncycle* handle)
{
	/* The reactions of state StateA. */
	if (alwaysOncycle_check_main_region_StateA_tr0_tr0(handle) == bool_true)
	{ 
		alwaysOncycle_effect_main_region_StateA_tr0(handle);
	}  else
	{
		alwaysOncycle_effect_main_region_StateA_lr1_lr1(handle);
	}
}

/* The reactions of state StateB. */
static void alwaysOncycle_react_main_region_StateB(AlwaysOncycle* handle)
{
	/* The reactions of state StateB. */
	if (alwaysOncycle_check_main_region_StateB_tr0_tr0(handle) == bool_true)
	{ 
		alwaysOncycle_effect_main_region_StateB_tr0(handle);
	}  else
	{
		alwaysOncycle_effect_main_region_StateB_lr0_lr0(handle);
	}
}

/* Default react sequence for initial entry  */
static void alwaysOncycle_react_main_region__entry_Default(AlwaysOncycle* handle)
{
	/* Default react sequence for initial entry  */
	alwaysOncycle_enseq_main_region_StateA_default(handle);
}


