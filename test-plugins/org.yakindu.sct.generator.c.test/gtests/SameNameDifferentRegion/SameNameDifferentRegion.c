
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "SameNameDifferentRegion.h"
/*! \file Implementation of the state machine 'SameNameDifferentRegion'
*/

/* prototypes of all internal functions */
static sc_boolean sameNameDifferentRegion_check_main_region_StateA_tr0_tr0(const SameNameDifferentRegion* handle);
static sc_boolean sameNameDifferentRegion_check_main_region_StateB_r1_StateA_tr0_tr0(const SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_effect_main_region_StateA_tr0(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_effect_main_region_StateB_r1_StateA_tr0(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_enseq_main_region_StateA_default(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_enseq_main_region_StateB_default(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_enseq_main_region_StateB_r1_StateA_default(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_enseq_main_region_StateB_r1_StateB_default(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_enseq_main_region_default(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_enseq_main_region_StateB_r1_default(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_exseq_main_region_StateA(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_exseq_main_region_StateB_r1_StateA(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_exseq_main_region_StateB_r1_StateB(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_exseq_main_region(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_exseq_main_region_StateB_r1(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_react_main_region_StateA(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_react_main_region_StateB_r1_StateA(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_react_main_region_StateB_r1_StateB(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_react_main_region__entry_Default(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_react_main_region_StateB_r1__entry_Default(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_clearInEvents(SameNameDifferentRegion* handle);
static void sameNameDifferentRegion_clearOutEvents(SameNameDifferentRegion* handle);


void sameNameDifferentRegion_init(SameNameDifferentRegion* handle)
{
	sc_integer i;

	for (i = 0; i < SAMENAMEDIFFERENTREGION_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = SameNameDifferentRegion_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	sameNameDifferentRegion_clearInEvents(handle);
	sameNameDifferentRegion_clearOutEvents(handle);


}

void sameNameDifferentRegion_enter(SameNameDifferentRegion* handle)
{
	/* Default enter sequence for statechart SameNameDifferentRegion */
	sameNameDifferentRegion_enseq_main_region_default(handle);
}

void sameNameDifferentRegion_exit(SameNameDifferentRegion* handle)
{
	/* Default exit sequence for statechart SameNameDifferentRegion */
	sameNameDifferentRegion_exseq_main_region(handle);
}

sc_boolean sameNameDifferentRegion_isActive(const SameNameDifferentRegion* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < SAMENAMEDIFFERENTREGION_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != SameNameDifferentRegion_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean sameNameDifferentRegion_isFinal(const SameNameDifferentRegion* handle)
{
   return bool_false;
}

static void sameNameDifferentRegion_clearInEvents(SameNameDifferentRegion* handle)
{
	handle->iface.e1_raised = bool_false;
}

static void sameNameDifferentRegion_clearOutEvents(SameNameDifferentRegion* handle)
{
}

void sameNameDifferentRegion_runCycle(SameNameDifferentRegion* handle)
{
	
	sameNameDifferentRegion_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < SAMENAMEDIFFERENTREGION_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case SameNameDifferentRegion_main_region_StateA :
		{
			sameNameDifferentRegion_react_main_region_StateA(handle);
			break;
		}
		case SameNameDifferentRegion_main_region_StateB_r1_StateA :
		{
			sameNameDifferentRegion_react_main_region_StateB_r1_StateA(handle);
			break;
		}
		case SameNameDifferentRegion_main_region_StateB_r1_StateB :
		{
			sameNameDifferentRegion_react_main_region_StateB_r1_StateB(handle);
			break;
		}
		default:
			break;
		}
	}
	
	sameNameDifferentRegion_clearInEvents(handle);
}


sc_boolean sameNameDifferentRegion_isStateActive(const SameNameDifferentRegion* handle, SameNameDifferentRegionStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case SameNameDifferentRegion_main_region_StateA :
			result = (sc_boolean) (handle->stateConfVector[SCVI_SAMENAMEDIFFERENTREGION_MAIN_REGION_STATEA] == SameNameDifferentRegion_main_region_StateA
			);
			break;
		case SameNameDifferentRegion_main_region_StateB :
			result = (sc_boolean) (handle->stateConfVector[SCVI_SAMENAMEDIFFERENTREGION_MAIN_REGION_STATEB] >= SameNameDifferentRegion_main_region_StateB
				&& handle->stateConfVector[SCVI_SAMENAMEDIFFERENTREGION_MAIN_REGION_STATEB] <= SameNameDifferentRegion_main_region_StateB_r1_StateB);
			break;
		case SameNameDifferentRegion_main_region_StateB_r1_StateA :
			result = (sc_boolean) (handle->stateConfVector[SCVI_SAMENAMEDIFFERENTREGION_MAIN_REGION_STATEB_R1_STATEA] == SameNameDifferentRegion_main_region_StateB_r1_StateA
			);
			break;
		case SameNameDifferentRegion_main_region_StateB_r1_StateB :
			result = (sc_boolean) (handle->stateConfVector[SCVI_SAMENAMEDIFFERENTREGION_MAIN_REGION_STATEB_R1_STATEB] == SameNameDifferentRegion_main_region_StateB_r1_StateB
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void sameNameDifferentRegionIface_raise_e1(SameNameDifferentRegion* handle)
{
	handle->iface.e1_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean sameNameDifferentRegion_check_main_region_StateA_tr0_tr0(const SameNameDifferentRegion* handle)
{
	return handle->iface.e1_raised;
}

static sc_boolean sameNameDifferentRegion_check_main_region_StateB_r1_StateA_tr0_tr0(const SameNameDifferentRegion* handle)
{
	return handle->iface.e1_raised;
}

static void sameNameDifferentRegion_effect_main_region_StateA_tr0(SameNameDifferentRegion* handle)
{
	sameNameDifferentRegion_exseq_main_region_StateA(handle);
	sameNameDifferentRegion_enseq_main_region_StateB_default(handle);
}

static void sameNameDifferentRegion_effect_main_region_StateB_r1_StateA_tr0(SameNameDifferentRegion* handle)
{
	sameNameDifferentRegion_exseq_main_region_StateB_r1_StateA(handle);
	sameNameDifferentRegion_enseq_main_region_StateB_r1_StateB_default(handle);
}

/* 'default' enter sequence for state StateA */
static void sameNameDifferentRegion_enseq_main_region_StateA_default(SameNameDifferentRegion* handle)
{
	/* 'default' enter sequence for state StateA */
	handle->stateConfVector[0] = SameNameDifferentRegion_main_region_StateA;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
static void sameNameDifferentRegion_enseq_main_region_StateB_default(SameNameDifferentRegion* handle)
{
	/* 'default' enter sequence for state StateB */
	sameNameDifferentRegion_enseq_main_region_StateB_r1_default(handle);
}

/* 'default' enter sequence for state StateA */
static void sameNameDifferentRegion_enseq_main_region_StateB_r1_StateA_default(SameNameDifferentRegion* handle)
{
	/* 'default' enter sequence for state StateA */
	handle->stateConfVector[0] = SameNameDifferentRegion_main_region_StateB_r1_StateA;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
static void sameNameDifferentRegion_enseq_main_region_StateB_r1_StateB_default(SameNameDifferentRegion* handle)
{
	/* 'default' enter sequence for state StateB */
	handle->stateConfVector[0] = SameNameDifferentRegion_main_region_StateB_r1_StateB;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void sameNameDifferentRegion_enseq_main_region_default(SameNameDifferentRegion* handle)
{
	/* 'default' enter sequence for region main region */
	sameNameDifferentRegion_react_main_region__entry_Default(handle);
}

/* 'default' enter sequence for region r1 */
static void sameNameDifferentRegion_enseq_main_region_StateB_r1_default(SameNameDifferentRegion* handle)
{
	/* 'default' enter sequence for region r1 */
	sameNameDifferentRegion_react_main_region_StateB_r1__entry_Default(handle);
}

/* Default exit sequence for state StateA */
static void sameNameDifferentRegion_exseq_main_region_StateA(SameNameDifferentRegion* handle)
{
	/* Default exit sequence for state StateA */
	handle->stateConfVector[0] = SameNameDifferentRegion_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateA */
static void sameNameDifferentRegion_exseq_main_region_StateB_r1_StateA(SameNameDifferentRegion* handle)
{
	/* Default exit sequence for state StateA */
	handle->stateConfVector[0] = SameNameDifferentRegion_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateB */
static void sameNameDifferentRegion_exseq_main_region_StateB_r1_StateB(SameNameDifferentRegion* handle)
{
	/* Default exit sequence for state StateB */
	handle->stateConfVector[0] = SameNameDifferentRegion_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void sameNameDifferentRegion_exseq_main_region(SameNameDifferentRegion* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of SameNameDifferentRegion.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case SameNameDifferentRegion_main_region_StateA :
		{
			sameNameDifferentRegion_exseq_main_region_StateA(handle);
			break;
		}
		case SameNameDifferentRegion_main_region_StateB_r1_StateA :
		{
			sameNameDifferentRegion_exseq_main_region_StateB_r1_StateA(handle);
			break;
		}
		case SameNameDifferentRegion_main_region_StateB_r1_StateB :
		{
			sameNameDifferentRegion_exseq_main_region_StateB_r1_StateB(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r1 */
static void sameNameDifferentRegion_exseq_main_region_StateB_r1(SameNameDifferentRegion* handle)
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of SameNameDifferentRegion.main_region.StateB.r1) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case SameNameDifferentRegion_main_region_StateB_r1_StateA :
		{
			sameNameDifferentRegion_exseq_main_region_StateB_r1_StateA(handle);
			break;
		}
		case SameNameDifferentRegion_main_region_StateB_r1_StateB :
		{
			sameNameDifferentRegion_exseq_main_region_StateB_r1_StateB(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state StateA. */
static void sameNameDifferentRegion_react_main_region_StateA(SameNameDifferentRegion* handle)
{
	/* The reactions of state StateA. */
	if (sameNameDifferentRegion_check_main_region_StateA_tr0_tr0(handle) == bool_true)
	{ 
		sameNameDifferentRegion_effect_main_region_StateA_tr0(handle);
	} 
}

/* The reactions of state StateA. */
static void sameNameDifferentRegion_react_main_region_StateB_r1_StateA(SameNameDifferentRegion* handle)
{
	/* The reactions of state StateA. */
	if (sameNameDifferentRegion_check_main_region_StateB_r1_StateA_tr0_tr0(handle) == bool_true)
	{ 
		sameNameDifferentRegion_effect_main_region_StateB_r1_StateA_tr0(handle);
	} 
}

/* The reactions of state StateB. */
static void sameNameDifferentRegion_react_main_region_StateB_r1_StateB(SameNameDifferentRegion* handle)
{
	/* The reactions of state StateB. */
}

/* Default react sequence for initial entry  */
static void sameNameDifferentRegion_react_main_region__entry_Default(SameNameDifferentRegion* handle)
{
	/* Default react sequence for initial entry  */
	sameNameDifferentRegion_enseq_main_region_StateA_default(handle);
}

/* Default react sequence for initial entry  */
static void sameNameDifferentRegion_react_main_region_StateB_r1__entry_Default(SameNameDifferentRegion* handle)
{
	/* Default react sequence for initial entry  */
	sameNameDifferentRegion_enseq_main_region_StateB_r1_StateA_default(handle);
}


