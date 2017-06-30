
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "EntryChoice.h"
/*! \file Implementation of the state machine 'EntryChoice'
*/

/* prototypes of all internal functions */
static sc_boolean entryChoice_check_main_region__choice_0_tr0_tr0(const EntryChoice* handle);
static void entryChoice_effect_main_region__choice_0_tr0(EntryChoice* handle);
static void entryChoice_enseq_main_region_A_default(EntryChoice* handle);
static void entryChoice_enseq_main_region_default(EntryChoice* handle);
static void entryChoice_exseq_main_region_A(EntryChoice* handle);
static void entryChoice_exseq_main_region(EntryChoice* handle);
static void entryChoice_react_main_region_A(EntryChoice* handle);
static void entryChoice_react_main_region__choice_0(EntryChoice* handle);
static void entryChoice_react_main_region__entry_Default(EntryChoice* handle);
static void entryChoice_clearInEvents(EntryChoice* handle);
static void entryChoice_clearOutEvents(EntryChoice* handle);


void entryChoice_init(EntryChoice* handle)
{
	sc_integer i;

	for (i = 0; i < ENTRYCHOICE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = EntryChoice_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	entryChoice_clearInEvents(handle);
	entryChoice_clearOutEvents(handle);


}

void entryChoice_enter(EntryChoice* handle)
{
	/* Default enter sequence for statechart EntryChoice */
	entryChoice_enseq_main_region_default(handle);
}

void entryChoice_exit(EntryChoice* handle)
{
	/* Default exit sequence for statechart EntryChoice */
	entryChoice_exseq_main_region(handle);
}

sc_boolean entryChoice_isActive(const EntryChoice* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < ENTRYCHOICE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != EntryChoice_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean entryChoice_isFinal(const EntryChoice* handle)
{
   return bool_false;
}

static void entryChoice_clearInEvents(EntryChoice* handle)
{
}

static void entryChoice_clearOutEvents(EntryChoice* handle)
{
}

void entryChoice_runCycle(EntryChoice* handle)
{
	
	entryChoice_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < ENTRYCHOICE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case EntryChoice_main_region_A :
		{
			entryChoice_react_main_region_A(handle);
			break;
		}
		default:
			break;
		}
	}
	
	entryChoice_clearInEvents(handle);
}


sc_boolean entryChoice_isStateActive(const EntryChoice* handle, EntryChoiceStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case EntryChoice_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ENTRYCHOICE_MAIN_REGION_A] == EntryChoice_main_region_A
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}


/* implementations of all internal functions */

static sc_boolean entryChoice_check_main_region__choice_0_tr0_tr0(const EntryChoice* handle)
{
	return bool_true;
}

static void entryChoice_effect_main_region__choice_0_tr0(EntryChoice* handle)
{
	entryChoice_enseq_main_region_A_default(handle);
}

/* 'default' enter sequence for state A */
static void entryChoice_enseq_main_region_A_default(EntryChoice* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = EntryChoice_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void entryChoice_enseq_main_region_default(EntryChoice* handle)
{
	/* 'default' enter sequence for region main region */
	entryChoice_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void entryChoice_exseq_main_region_A(EntryChoice* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = EntryChoice_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void entryChoice_exseq_main_region(EntryChoice* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of EntryChoice.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case EntryChoice_main_region_A :
		{
			entryChoice_exseq_main_region_A(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void entryChoice_react_main_region_A(EntryChoice* handle)
{
	/* The reactions of state A. */
}

/* The reactions of state null. */
static void entryChoice_react_main_region__choice_0(EntryChoice* handle)
{
	/* The reactions of state null. */
	entryChoice_effect_main_region__choice_0_tr0(handle);
}

/* Default react sequence for initial entry  */
static void entryChoice_react_main_region__entry_Default(EntryChoice* handle)
{
	/* Default react sequence for initial entry  */
	entryChoice_react_main_region__choice_0(handle);
}


