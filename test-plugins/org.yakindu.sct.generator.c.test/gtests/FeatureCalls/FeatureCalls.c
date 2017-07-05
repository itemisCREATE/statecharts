
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "FeatureCalls.h"
/*! \file Implementation of the state machine 'FeatureCalls'
*/

/* prototypes of all internal functions */
static sc_boolean featureCalls_check_main_region_A_tr0_tr0(const FeatureCalls* handle);
static sc_boolean featureCalls_check_main_region_B_tr0_tr0(const FeatureCalls* handle);
static void featureCalls_effect_main_region_A_tr0(FeatureCalls* handle);
static void featureCalls_effect_main_region_B_tr0(FeatureCalls* handle);
static void featureCalls_enact_main_region_B(FeatureCalls* handle);
static void featureCalls_enseq_main_region_A_default(FeatureCalls* handle);
static void featureCalls_enseq_main_region_B_default(FeatureCalls* handle);
static void featureCalls_enseq_main_region_default(FeatureCalls* handle);
static void featureCalls_exseq_main_region_A(FeatureCalls* handle);
static void featureCalls_exseq_main_region_B(FeatureCalls* handle);
static void featureCalls_exseq_main_region(FeatureCalls* handle);
static void featureCalls_react_main_region_A(FeatureCalls* handle);
static void featureCalls_react_main_region_B(FeatureCalls* handle);
static void featureCalls_react_main_region__entry_Default(FeatureCalls* handle);
static void featureCalls_clearInEvents(FeatureCalls* handle);
static void featureCalls_clearOutEvents(FeatureCalls* handle);


void featureCalls_init(FeatureCalls* handle)
{
	sc_integer i;

	for (i = 0; i < FEATURECALLS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = FeatureCalls_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	featureCalls_clearInEvents(handle);
	featureCalls_clearOutEvents(handle);

	/* Default init sequence for statechart FeatureCalls */
	handle->ifaceMyInterface.myInt = 0;

}

void featureCalls_enter(FeatureCalls* handle)
{
	/* Default enter sequence for statechart FeatureCalls */
	featureCalls_enseq_main_region_default(handle);
}

void featureCalls_exit(FeatureCalls* handle)
{
	/* Default exit sequence for statechart FeatureCalls */
	featureCalls_exseq_main_region(handle);
}

sc_boolean featureCalls_isActive(const FeatureCalls* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < FEATURECALLS_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != FeatureCalls_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean featureCalls_isFinal(const FeatureCalls* handle)
{
   return bool_false;
}

static void featureCalls_clearInEvents(FeatureCalls* handle)
{
	handle->ifaceMyInterface.Event1_raised = bool_false;
}

static void featureCalls_clearOutEvents(FeatureCalls* handle)
{
}

void featureCalls_runCycle(FeatureCalls* handle)
{
	
	featureCalls_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < FEATURECALLS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case FeatureCalls_main_region_A :
		{
			featureCalls_react_main_region_A(handle);
			break;
		}
		case FeatureCalls_main_region_B :
		{
			featureCalls_react_main_region_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	featureCalls_clearInEvents(handle);
}


sc_boolean featureCalls_isStateActive(const FeatureCalls* handle, FeatureCallsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case FeatureCalls_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_FEATURECALLS_MAIN_REGION_A] == FeatureCalls_main_region_A
			);
			break;
		case FeatureCalls_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_FEATURECALLS_MAIN_REGION_B] == FeatureCalls_main_region_B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void featureCallsIfaceMyInterface_raise_event1(FeatureCalls* handle)
{
	handle->ifaceMyInterface.Event1_raised = bool_true;
}


sc_integer featureCallsIfaceMyInterface_get_myInt(const FeatureCalls* handle)
{
	return handle->ifaceMyInterface.myInt;
}
void featureCallsIfaceMyInterface_set_myInt(FeatureCalls* handle, sc_integer value)
{
	handle->ifaceMyInterface.myInt = value;
}

/* implementations of all internal functions */

static sc_boolean featureCalls_check_main_region_A_tr0_tr0(const FeatureCalls* handle)
{
	return handle->ifaceMyInterface.Event1_raised;
}

static sc_boolean featureCalls_check_main_region_B_tr0_tr0(const FeatureCalls* handle)
{
	return handle->ifaceMyInterface.Event1_raised;
}

static void featureCalls_effect_main_region_A_tr0(FeatureCalls* handle)
{
	featureCalls_exseq_main_region_A(handle);
	featureCalls_enseq_main_region_B_default(handle);
}

static void featureCalls_effect_main_region_B_tr0(FeatureCalls* handle)
{
	featureCalls_exseq_main_region_B(handle);
	featureCalls_enseq_main_region_A_default(handle);
}

/* Entry action for state 'B'. */
static void featureCalls_enact_main_region_B(FeatureCalls* handle)
{
	/* Entry action for state 'B'. */
	handle->ifaceMyInterface.myInt = 42;
	handle->ifaceMyInterface.Event1_raised = bool_true;
}

/* 'default' enter sequence for state A */
static void featureCalls_enseq_main_region_A_default(FeatureCalls* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = FeatureCalls_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void featureCalls_enseq_main_region_B_default(FeatureCalls* handle)
{
	/* 'default' enter sequence for state B */
	featureCalls_enact_main_region_B(handle);
	handle->stateConfVector[0] = FeatureCalls_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void featureCalls_enseq_main_region_default(FeatureCalls* handle)
{
	/* 'default' enter sequence for region main region */
	featureCalls_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void featureCalls_exseq_main_region_A(FeatureCalls* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = FeatureCalls_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void featureCalls_exseq_main_region_B(FeatureCalls* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = FeatureCalls_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void featureCalls_exseq_main_region(FeatureCalls* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of FeatureCalls.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case FeatureCalls_main_region_A :
		{
			featureCalls_exseq_main_region_A(handle);
			break;
		}
		case FeatureCalls_main_region_B :
		{
			featureCalls_exseq_main_region_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void featureCalls_react_main_region_A(FeatureCalls* handle)
{
	/* The reactions of state A. */
	if (featureCalls_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		featureCalls_effect_main_region_A_tr0(handle);
	} 
}

/* The reactions of state B. */
static void featureCalls_react_main_region_B(FeatureCalls* handle)
{
	/* The reactions of state B. */
	if (featureCalls_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		featureCalls_effect_main_region_B_tr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void featureCalls_react_main_region__entry_Default(FeatureCalls* handle)
{
	/* Default react sequence for initial entry  */
	featureCalls_enseq_main_region_A_default(handle);
}


