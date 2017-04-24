
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "EntryExitSelfTransition.h"
/*! \file Implementation of the state machine 'EntryExitSelfTransition'
*/

/* prototypes of all internal functions */
static sc_boolean entryExitSelfTransition_check_main_region_A_tr0_tr0(const EntryExitSelfTransition* handle);
static sc_boolean entryExitSelfTransition_check_main_region_A__region0_B_tr0_tr0(const EntryExitSelfTransition* handle);
static sc_boolean entryExitSelfTransition_check_main_region_A__region0_C_tr0_tr0(const EntryExitSelfTransition* handle);
static void entryExitSelfTransition_effect_main_region_A_tr0(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_effect_main_region_A__region0_B_tr0(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_effect_main_region_A__region0_C_tr0(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_enact_main_region_A(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_exact_main_region_A(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_enseq_main_region_A_default(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_enseq_main_region_A__region0_B_default(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_enseq_main_region_A__region0_C_default(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_enseq_main_region_default(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_enseq_main_region_A__region0_default(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_exseq_main_region_A(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_exseq_main_region_A__region0_B(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_exseq_main_region_A__region0_C(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_exseq_main_region(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_exseq_main_region_A__region0(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_react_main_region_A__region0_B(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_react_main_region_A__region0_C(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_react_main_region__entry_Default(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_react_main_region_A__region0__entry_Default(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_clearInEvents(EntryExitSelfTransition* handle);
static void entryExitSelfTransition_clearOutEvents(EntryExitSelfTransition* handle);


void entryExitSelfTransition_init(EntryExitSelfTransition* handle)
{
	sc_integer i;

	for (i = 0; i < ENTRYEXITSELFTRANSITION_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = EntryExitSelfTransition_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	entryExitSelfTransition_clearInEvents(handle);
	entryExitSelfTransition_clearOutEvents(handle);

	/* Default init sequence for statechart EntryExitSelfTransition */
	handle->iface.exits = 0;
	handle->iface.entries = 0;

}

void entryExitSelfTransition_enter(EntryExitSelfTransition* handle)
{
	/* Default enter sequence for statechart EntryExitSelfTransition */
	entryExitSelfTransition_enseq_main_region_default(handle);
}

void entryExitSelfTransition_exit(EntryExitSelfTransition* handle)
{
	/* Default exit sequence for statechart EntryExitSelfTransition */
	entryExitSelfTransition_exseq_main_region(handle);
}

sc_boolean entryExitSelfTransition_isActive(const EntryExitSelfTransition* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != EntryExitSelfTransition_last_state)
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
sc_boolean entryExitSelfTransition_isFinal(const EntryExitSelfTransition* handle)
{
   return bool_false;
}

static void entryExitSelfTransition_clearInEvents(EntryExitSelfTransition* handle)
{
	handle->iface.e_raised = bool_false;
	handle->iface.e1_raised = bool_false;
}

static void entryExitSelfTransition_clearOutEvents(EntryExitSelfTransition* handle)
{
}

void entryExitSelfTransition_runCycle(EntryExitSelfTransition* handle)
{
	
	entryExitSelfTransition_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < ENTRYEXITSELFTRANSITION_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case EntryExitSelfTransition_main_region_A__region0_B :
		{
			entryExitSelfTransition_react_main_region_A__region0_B(handle);
			break;
		}
		case EntryExitSelfTransition_main_region_A__region0_C :
		{
			entryExitSelfTransition_react_main_region_A__region0_C(handle);
			break;
		}
		default:
			break;
		}
	}
	
	entryExitSelfTransition_clearInEvents(handle);
}


sc_boolean entryExitSelfTransition_isStateActive(const EntryExitSelfTransition* handle, EntryExitSelfTransitionStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case EntryExitSelfTransition_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] >= EntryExitSelfTransition_main_region_A
				&& handle->stateConfVector[0] <= EntryExitSelfTransition_main_region_A__region0_C);
			break;
		case EntryExitSelfTransition_main_region_A__region0_B :
			result = (sc_boolean) (handle->stateConfVector[0] == EntryExitSelfTransition_main_region_A__region0_B
			);
			break;
		case EntryExitSelfTransition_main_region_A__region0_C :
			result = (sc_boolean) (handle->stateConfVector[0] == EntryExitSelfTransition_main_region_A__region0_C
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void entryExitSelfTransitionIface_raise_e(EntryExitSelfTransition* handle)
{
	handle->iface.e_raised = bool_true;
}
void entryExitSelfTransitionIface_raise_e1(EntryExitSelfTransition* handle)
{
	handle->iface.e1_raised = bool_true;
}


sc_integer entryExitSelfTransitionIface_get_exits(const EntryExitSelfTransition* handle)
{
	return handle->iface.exits;
}
void entryExitSelfTransitionIface_set_exits(EntryExitSelfTransition* handle, sc_integer value)
{
	handle->iface.exits = value;
}
sc_integer entryExitSelfTransitionIface_get_entries(const EntryExitSelfTransition* handle)
{
	return handle->iface.entries;
}
void entryExitSelfTransitionIface_set_entries(EntryExitSelfTransition* handle, sc_integer value)
{
	handle->iface.entries = value;
}

/* implementations of all internal functions */

static sc_boolean entryExitSelfTransition_check_main_region_A_tr0_tr0(const EntryExitSelfTransition* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean entryExitSelfTransition_check_main_region_A__region0_B_tr0_tr0(const EntryExitSelfTransition* handle)
{
	return handle->iface.e1_raised;
}

static sc_boolean entryExitSelfTransition_check_main_region_A__region0_C_tr0_tr0(const EntryExitSelfTransition* handle)
{
	return handle->iface.e1_raised;
}

static void entryExitSelfTransition_effect_main_region_A_tr0(EntryExitSelfTransition* handle)
{
	entryExitSelfTransition_exseq_main_region_A(handle);
	entryExitSelfTransition_enact_main_region_A(handle);
	entryExitSelfTransition_enseq_main_region_A__region0_C_default(handle);
}

static void entryExitSelfTransition_effect_main_region_A__region0_B_tr0(EntryExitSelfTransition* handle)
{
	entryExitSelfTransition_exseq_main_region_A__region0_B(handle);
	entryExitSelfTransition_enseq_main_region_A__region0_C_default(handle);
}

static void entryExitSelfTransition_effect_main_region_A__region0_C_tr0(EntryExitSelfTransition* handle)
{
	entryExitSelfTransition_exseq_main_region_A(handle);
	entryExitSelfTransition_enseq_main_region_A_default(handle);
}

/* Entry action for state 'A'. */
static void entryExitSelfTransition_enact_main_region_A(EntryExitSelfTransition* handle)
{
	/* Entry action for state 'A'. */
	handle->iface.entries += 1;
}

/* Exit action for state 'A'. */
static void entryExitSelfTransition_exact_main_region_A(EntryExitSelfTransition* handle)
{
	/* Exit action for state 'A'. */
	handle->iface.exits += 1;
}

/* 'default' enter sequence for state A */
static void entryExitSelfTransition_enseq_main_region_A_default(EntryExitSelfTransition* handle)
{
	/* 'default' enter sequence for state A */
	entryExitSelfTransition_enact_main_region_A(handle);
	entryExitSelfTransition_enseq_main_region_A__region0_default(handle);
}

/* 'default' enter sequence for state B */
static void entryExitSelfTransition_enseq_main_region_A__region0_B_default(EntryExitSelfTransition* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = EntryExitSelfTransition_main_region_A__region0_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
static void entryExitSelfTransition_enseq_main_region_A__region0_C_default(EntryExitSelfTransition* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[0] = EntryExitSelfTransition_main_region_A__region0_C;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void entryExitSelfTransition_enseq_main_region_default(EntryExitSelfTransition* handle)
{
	/* 'default' enter sequence for region main region */
	entryExitSelfTransition_react_main_region__entry_Default(handle);
}

/* 'default' enter sequence for region  */
static void entryExitSelfTransition_enseq_main_region_A__region0_default(EntryExitSelfTransition* handle)
{
	/* 'default' enter sequence for region  */
	entryExitSelfTransition_react_main_region_A__region0__entry_Default(handle);
}

/* Default exit sequence for state A */
static void entryExitSelfTransition_exseq_main_region_A(EntryExitSelfTransition* handle)
{
	/* Default exit sequence for state A */
	entryExitSelfTransition_exseq_main_region_A__region0(handle);
	entryExitSelfTransition_exact_main_region_A(handle);
}

/* Default exit sequence for state B */
static void entryExitSelfTransition_exseq_main_region_A__region0_B(EntryExitSelfTransition* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = EntryExitSelfTransition_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
static void entryExitSelfTransition_exseq_main_region_A__region0_C(EntryExitSelfTransition* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[0] = EntryExitSelfTransition_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void entryExitSelfTransition_exseq_main_region(EntryExitSelfTransition* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of EntryExitSelfTransition.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case EntryExitSelfTransition_main_region_A__region0_B :
		{
			entryExitSelfTransition_exseq_main_region_A__region0_B(handle);
			entryExitSelfTransition_exact_main_region_A(handle);
			break;
		}
		case EntryExitSelfTransition_main_region_A__region0_C :
		{
			entryExitSelfTransition_exseq_main_region_A__region0_C(handle);
			entryExitSelfTransition_exact_main_region_A(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region  */
static void entryExitSelfTransition_exseq_main_region_A__region0(EntryExitSelfTransition* handle)
{
	/* Default exit sequence for region  */
	/* Handle exit of all possible states (of EntryExitSelfTransition.main_region.A._region0) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case EntryExitSelfTransition_main_region_A__region0_B :
		{
			entryExitSelfTransition_exseq_main_region_A__region0_B(handle);
			break;
		}
		case EntryExitSelfTransition_main_region_A__region0_C :
		{
			entryExitSelfTransition_exseq_main_region_A__region0_C(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state B. */
static void entryExitSelfTransition_react_main_region_A__region0_B(EntryExitSelfTransition* handle)
{
	/* The reactions of state B. */
	if (entryExitSelfTransition_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		entryExitSelfTransition_effect_main_region_A_tr0(handle);
	}  else
	{
		if (entryExitSelfTransition_check_main_region_A__region0_B_tr0_tr0(handle) == bool_true)
		{ 
			entryExitSelfTransition_effect_main_region_A__region0_B_tr0(handle);
		} 
	}
}

/* The reactions of state C. */
static void entryExitSelfTransition_react_main_region_A__region0_C(EntryExitSelfTransition* handle)
{
	/* The reactions of state C. */
	if (entryExitSelfTransition_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		entryExitSelfTransition_effect_main_region_A_tr0(handle);
	}  else
	{
		if (entryExitSelfTransition_check_main_region_A__region0_C_tr0_tr0(handle) == bool_true)
		{ 
			entryExitSelfTransition_effect_main_region_A__region0_C_tr0(handle);
		} 
	}
}

/* Default react sequence for initial entry  */
static void entryExitSelfTransition_react_main_region__entry_Default(EntryExitSelfTransition* handle)
{
	/* Default react sequence for initial entry  */
	entryExitSelfTransition_enseq_main_region_A_default(handle);
}

/* Default react sequence for initial entry  */
static void entryExitSelfTransition_react_main_region_A__region0__entry_Default(EntryExitSelfTransition* handle)
{
	/* Default react sequence for initial entry  */
	entryExitSelfTransition_enseq_main_region_A__region0_B_default(handle);
}


