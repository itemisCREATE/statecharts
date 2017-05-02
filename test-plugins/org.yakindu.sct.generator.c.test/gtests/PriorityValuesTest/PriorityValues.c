
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "PriorityValues.h"
/*! \file Implementation of the state machine 'PriorityValues'
*/

/* prototypes of all internal functions */
static sc_boolean priorityValues_check_someRegion_A_tr0_tr0(const PriorityValues* handle);
static sc_boolean priorityValues_check_main_region_A_tr0_tr0(const PriorityValues* handle);
static sc_boolean priorityValues_check_main_region_A_tr1_tr1(const PriorityValues* handle);
static sc_boolean priorityValues_check_main_region_A_tr2_tr2(const PriorityValues* handle);
static sc_boolean priorityValues_check_main_region_A_tr3_tr3(const PriorityValues* handle);
static void priorityValues_effect_someRegion_A_tr0(PriorityValues* handle);
static void priorityValues_effect_main_region_A_tr0(PriorityValues* handle);
static void priorityValues_effect_main_region_A_tr1(PriorityValues* handle);
static void priorityValues_effect_main_region_A_tr2(PriorityValues* handle);
static void priorityValues_effect_main_region_A_tr3(PriorityValues* handle);
static void priorityValues_enseq_someRegion_A_default(PriorityValues* handle);
static void priorityValues_enseq_someRegion_B_default(PriorityValues* handle);
static void priorityValues_enseq_main_region_A_default(PriorityValues* handle);
static void priorityValues_enseq_main_region_B_default(PriorityValues* handle);
static void priorityValues_enseq_main_region_C_default(PriorityValues* handle);
static void priorityValues_enseq_main_region_D_default(PriorityValues* handle);
static void priorityValues_enseq_main_region_E_default(PriorityValues* handle);
static void priorityValues_enseq_someRegion_default(PriorityValues* handle);
static void priorityValues_enseq_main_region_default(PriorityValues* handle);
static void priorityValues_exseq_someRegion_A(PriorityValues* handle);
static void priorityValues_exseq_someRegion_B(PriorityValues* handle);
static void priorityValues_exseq_main_region_A(PriorityValues* handle);
static void priorityValues_exseq_main_region_B(PriorityValues* handle);
static void priorityValues_exseq_main_region_C(PriorityValues* handle);
static void priorityValues_exseq_main_region_D(PriorityValues* handle);
static void priorityValues_exseq_main_region_E(PriorityValues* handle);
static void priorityValues_exseq_someRegion(PriorityValues* handle);
static void priorityValues_exseq_main_region(PriorityValues* handle);
static void priorityValues_react_someRegion_A(PriorityValues* handle);
static void priorityValues_react_someRegion_B(PriorityValues* handle);
static void priorityValues_react_main_region_A(PriorityValues* handle);
static void priorityValues_react_main_region_B(PriorityValues* handle);
static void priorityValues_react_main_region_C(PriorityValues* handle);
static void priorityValues_react_main_region_D(PriorityValues* handle);
static void priorityValues_react_main_region_E(PriorityValues* handle);
static void priorityValues_react_someRegion__entry_Default(PriorityValues* handle);
static void priorityValues_react_main_region__entry_Default(PriorityValues* handle);
static void priorityValues_clearInEvents(PriorityValues* handle);
static void priorityValues_clearOutEvents(PriorityValues* handle);


void priorityValues_init(PriorityValues* handle)
{
	sc_integer i;

	for (i = 0; i < PRIORITYVALUES_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = PriorityValues_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	priorityValues_clearInEvents(handle);
	priorityValues_clearOutEvents(handle);


}

void priorityValues_enter(PriorityValues* handle)
{
	/* Default enter sequence for statechart PriorityValues */
	priorityValues_enseq_someRegion_default(handle);
	priorityValues_enseq_main_region_default(handle);
}

void priorityValues_exit(PriorityValues* handle)
{
	/* Default exit sequence for statechart PriorityValues */
	priorityValues_exseq_someRegion(handle);
	priorityValues_exseq_main_region(handle);
}

sc_boolean priorityValues_isActive(const PriorityValues* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != PriorityValues_last_state || handle->stateConfVector[1] != PriorityValues_last_state)
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
sc_boolean priorityValues_isFinal(const PriorityValues* handle)
{
   return bool_false;
}

static void priorityValues_clearInEvents(PriorityValues* handle)
{
	handle->iface.event1_raised = bool_false;
	handle->iface.event2_raised = bool_false;
}

static void priorityValues_clearOutEvents(PriorityValues* handle)
{
}

void priorityValues_runCycle(PriorityValues* handle)
{
	
	priorityValues_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < PRIORITYVALUES_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case PriorityValues_someRegion_A :
		{
			priorityValues_react_someRegion_A(handle);
			break;
		}
		case PriorityValues_someRegion_B :
		{
			priorityValues_react_someRegion_B(handle);
			break;
		}
		case PriorityValues_main_region_A :
		{
			priorityValues_react_main_region_A(handle);
			break;
		}
		case PriorityValues_main_region_B :
		{
			priorityValues_react_main_region_B(handle);
			break;
		}
		case PriorityValues_main_region_C :
		{
			priorityValues_react_main_region_C(handle);
			break;
		}
		case PriorityValues_main_region_D :
		{
			priorityValues_react_main_region_D(handle);
			break;
		}
		case PriorityValues_main_region_E :
		{
			priorityValues_react_main_region_E(handle);
			break;
		}
		default:
			break;
		}
	}
	
	priorityValues_clearInEvents(handle);
}


sc_boolean priorityValues_isStateActive(const PriorityValues* handle, PriorityValuesStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case PriorityValues_someRegion_A :
			result = (sc_boolean) (handle->stateConfVector[0] == PriorityValues_someRegion_A
			);
			break;
		case PriorityValues_someRegion_B :
			result = (sc_boolean) (handle->stateConfVector[0] == PriorityValues_someRegion_B
			);
			break;
		case PriorityValues_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[1] == PriorityValues_main_region_A
			);
			break;
		case PriorityValues_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[1] == PriorityValues_main_region_B
			);
			break;
		case PriorityValues_main_region_C :
			result = (sc_boolean) (handle->stateConfVector[1] == PriorityValues_main_region_C
			);
			break;
		case PriorityValues_main_region_D :
			result = (sc_boolean) (handle->stateConfVector[1] == PriorityValues_main_region_D
			);
			break;
		case PriorityValues_main_region_E :
			result = (sc_boolean) (handle->stateConfVector[1] == PriorityValues_main_region_E
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void priorityValuesIface_raise_event1(PriorityValues* handle)
{
	handle->iface.event1_raised = bool_true;
}
void priorityValuesIface_raise_event2(PriorityValues* handle)
{
	handle->iface.event2_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean priorityValues_check_someRegion_A_tr0_tr0(const PriorityValues* handle)
{
	return handle->iface.event2_raised;
}

static sc_boolean priorityValues_check_main_region_A_tr0_tr0(const PriorityValues* handle)
{
	return handle->iface.event1_raised;
}

static sc_boolean priorityValues_check_main_region_A_tr1_tr1(const PriorityValues* handle)
{
	return handle->iface.event1_raised;
}

static sc_boolean priorityValues_check_main_region_A_tr2_tr2(const PriorityValues* handle)
{
	return handle->iface.event1_raised;
}

static sc_boolean priorityValues_check_main_region_A_tr3_tr3(const PriorityValues* handle)
{
	return ((handle->iface.event2_raised) && (!priorityValues_isStateActive(handle, PriorityValues_someRegion_B))) ? bool_true : bool_false;
}

static void priorityValues_effect_someRegion_A_tr0(PriorityValues* handle)
{
	priorityValues_exseq_someRegion_A(handle);
	priorityValues_enseq_someRegion_B_default(handle);
}

static void priorityValues_effect_main_region_A_tr0(PriorityValues* handle)
{
	priorityValues_exseq_main_region_A(handle);
	priorityValues_enseq_main_region_C_default(handle);
}

static void priorityValues_effect_main_region_A_tr1(PriorityValues* handle)
{
	priorityValues_exseq_main_region_A(handle);
	priorityValues_enseq_main_region_B_default(handle);
}

static void priorityValues_effect_main_region_A_tr2(PriorityValues* handle)
{
	priorityValues_exseq_main_region_A(handle);
	priorityValues_enseq_main_region_D_default(handle);
}

static void priorityValues_effect_main_region_A_tr3(PriorityValues* handle)
{
	priorityValues_exseq_main_region_A(handle);
	priorityValues_enseq_main_region_E_default(handle);
}

/* 'default' enter sequence for state A */
static void priorityValues_enseq_someRegion_A_default(PriorityValues* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = PriorityValues_someRegion_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void priorityValues_enseq_someRegion_B_default(PriorityValues* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = PriorityValues_someRegion_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state A */
static void priorityValues_enseq_main_region_A_default(PriorityValues* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[1] = PriorityValues_main_region_A;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state B */
static void priorityValues_enseq_main_region_B_default(PriorityValues* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[1] = PriorityValues_main_region_B;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state C */
static void priorityValues_enseq_main_region_C_default(PriorityValues* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[1] = PriorityValues_main_region_C;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state D */
static void priorityValues_enseq_main_region_D_default(PriorityValues* handle)
{
	/* 'default' enter sequence for state D */
	handle->stateConfVector[1] = PriorityValues_main_region_D;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state E */
static void priorityValues_enseq_main_region_E_default(PriorityValues* handle)
{
	/* 'default' enter sequence for state E */
	handle->stateConfVector[1] = PriorityValues_main_region_E;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region someRegion */
static void priorityValues_enseq_someRegion_default(PriorityValues* handle)
{
	/* 'default' enter sequence for region someRegion */
	priorityValues_react_someRegion__entry_Default(handle);
}

/* 'default' enter sequence for region main region */
static void priorityValues_enseq_main_region_default(PriorityValues* handle)
{
	/* 'default' enter sequence for region main region */
	priorityValues_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void priorityValues_exseq_someRegion_A(PriorityValues* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = PriorityValues_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void priorityValues_exseq_someRegion_B(PriorityValues* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = PriorityValues_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state A */
static void priorityValues_exseq_main_region_A(PriorityValues* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[1] = PriorityValues_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state B */
static void priorityValues_exseq_main_region_B(PriorityValues* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[1] = PriorityValues_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state C */
static void priorityValues_exseq_main_region_C(PriorityValues* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[1] = PriorityValues_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state D */
static void priorityValues_exseq_main_region_D(PriorityValues* handle)
{
	/* Default exit sequence for state D */
	handle->stateConfVector[1] = PriorityValues_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state E */
static void priorityValues_exseq_main_region_E(PriorityValues* handle)
{
	/* Default exit sequence for state E */
	handle->stateConfVector[1] = PriorityValues_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for region someRegion */
static void priorityValues_exseq_someRegion(PriorityValues* handle)
{
	/* Default exit sequence for region someRegion */
	/* Handle exit of all possible states (of PriorityValues.someRegion) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case PriorityValues_someRegion_A :
		{
			priorityValues_exseq_someRegion_A(handle);
			break;
		}
		case PriorityValues_someRegion_B :
		{
			priorityValues_exseq_someRegion_B(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region main region */
static void priorityValues_exseq_main_region(PriorityValues* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of PriorityValues.main_region) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case PriorityValues_main_region_A :
		{
			priorityValues_exseq_main_region_A(handle);
			break;
		}
		case PriorityValues_main_region_B :
		{
			priorityValues_exseq_main_region_B(handle);
			break;
		}
		case PriorityValues_main_region_C :
		{
			priorityValues_exseq_main_region_C(handle);
			break;
		}
		case PriorityValues_main_region_D :
		{
			priorityValues_exseq_main_region_D(handle);
			break;
		}
		case PriorityValues_main_region_E :
		{
			priorityValues_exseq_main_region_E(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void priorityValues_react_someRegion_A(PriorityValues* handle)
{
	/* The reactions of state A. */
	if (priorityValues_check_someRegion_A_tr0_tr0(handle) == bool_true)
	{ 
		priorityValues_effect_someRegion_A_tr0(handle);
	} 
}

/* The reactions of state B. */
static void priorityValues_react_someRegion_B(PriorityValues* handle)
{
	/* The reactions of state B. */
}

/* The reactions of state A. */
static void priorityValues_react_main_region_A(PriorityValues* handle)
{
	/* The reactions of state A. */
	if (priorityValues_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		priorityValues_effect_main_region_A_tr0(handle);
	}  else
	{
		if (priorityValues_check_main_region_A_tr1_tr1(handle) == bool_true)
		{ 
			priorityValues_effect_main_region_A_tr1(handle);
		}  else
		{
			if (priorityValues_check_main_region_A_tr2_tr2(handle) == bool_true)
			{ 
				priorityValues_effect_main_region_A_tr2(handle);
			}  else
			{
				if (priorityValues_check_main_region_A_tr3_tr3(handle) == bool_true)
				{ 
					priorityValues_effect_main_region_A_tr3(handle);
				} 
			}
		}
	}
}

/* The reactions of state B. */
static void priorityValues_react_main_region_B(PriorityValues* handle)
{
}

/* The reactions of state C. */
static void priorityValues_react_main_region_C(PriorityValues* handle)
{
}

/* The reactions of state D. */
static void priorityValues_react_main_region_D(PriorityValues* handle)
{
}

/* The reactions of state E. */
static void priorityValues_react_main_region_E(PriorityValues* handle)
{
}

/* Default react sequence for initial entry  */
static void priorityValues_react_someRegion__entry_Default(PriorityValues* handle)
{
	/* Default react sequence for initial entry  */
	priorityValues_enseq_someRegion_A_default(handle);
}

/* Default react sequence for initial entry  */
static void priorityValues_react_main_region__entry_Default(PriorityValues* handle)
{
	/* Default react sequence for initial entry  */
	priorityValues_enseq_main_region_A_default(handle);
}


