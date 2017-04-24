
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "SyncFork.h"
/*! \file Implementation of the state machine 'SyncFork'
*/

/* prototypes of all internal functions */
static sc_boolean syncFork_check_main_region_A_tr0_tr0(const SyncFork* handle);
static sc_boolean syncFork_check_main_region_A_tr1_tr1(const SyncFork* handle);
static sc_boolean syncFork_check_main_region_B_tr0_tr0(const SyncFork* handle);
static sc_boolean syncFork_check_main_region_B_r1_C1_tr0_tr0(const SyncFork* handle);
static sc_boolean syncFork_check_main_region_B_r2_D1_tr0_tr0(const SyncFork* handle);
static void syncFork_effect_main_region_A_tr0(SyncFork* handle);
static void syncFork_effect_main_region_A_tr1(SyncFork* handle);
static void syncFork_effect_main_region_B_tr0(SyncFork* handle);
static void syncFork_effect_main_region_B_r1_C1_tr0(SyncFork* handle);
static void syncFork_effect_main_region_B_r2_D1_tr0(SyncFork* handle);
static void syncFork_enseq_main_region_A_default(SyncFork* handle);
static void syncFork_enseq_main_region_B_default(SyncFork* handle);
static void syncFork_enseq_main_region_B_r1_C1_default(SyncFork* handle);
static void syncFork_enseq_main_region_B_r1_C2_default(SyncFork* handle);
static void syncFork_enseq_main_region_B_r2_D1_default(SyncFork* handle);
static void syncFork_enseq_main_region_B_r2_D2_default(SyncFork* handle);
static void syncFork_enseq_main_region_default(SyncFork* handle);
static void syncFork_enseq_main_region_B_r1_default(SyncFork* handle);
static void syncFork_enseq_main_region_B_r2_default(SyncFork* handle);
static void syncFork_exseq_main_region_A(SyncFork* handle);
static void syncFork_exseq_main_region_B(SyncFork* handle);
static void syncFork_exseq_main_region_B_r1_C1(SyncFork* handle);
static void syncFork_exseq_main_region_B_r1_C2(SyncFork* handle);
static void syncFork_exseq_main_region_B_r2_D1(SyncFork* handle);
static void syncFork_exseq_main_region_B_r2_D2(SyncFork* handle);
static void syncFork_exseq_main_region(SyncFork* handle);
static void syncFork_exseq_main_region_B_r1(SyncFork* handle);
static void syncFork_exseq_main_region_B_r2(SyncFork* handle);
static void syncFork_react_main_region_A(SyncFork* handle);
static void syncFork_react_main_region_B_r1_C1(SyncFork* handle);
static void syncFork_react_main_region_B_r1_C2(SyncFork* handle);
static void syncFork_react_main_region_B_r2_D1(SyncFork* handle);
static void syncFork_react_main_region_B_r2_D2(SyncFork* handle);
static void syncFork_react_main_region__entry_Default(SyncFork* handle);
static void syncFork_react_main_region_B_r1__entry_Default(SyncFork* handle);
static void syncFork_react_main_region_B_r2__entry_Default(SyncFork* handle);
static void syncFork_react_main_region__sync0(SyncFork* handle);
static void syncFork_clearInEvents(SyncFork* handle);
static void syncFork_clearOutEvents(SyncFork* handle);


void syncFork_init(SyncFork* handle)
{
	sc_integer i;

	for (i = 0; i < SYNCFORK_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = SyncFork_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	syncFork_clearInEvents(handle);
	syncFork_clearOutEvents(handle);


}

void syncFork_enter(SyncFork* handle)
{
	/* Default enter sequence for statechart SyncFork */
	syncFork_enseq_main_region_default(handle);
}

void syncFork_exit(SyncFork* handle)
{
	/* Default exit sequence for statechart SyncFork */
	syncFork_exseq_main_region(handle);
}

sc_boolean syncFork_isActive(const SyncFork* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != SyncFork_last_state || handle->stateConfVector[1] != SyncFork_last_state)
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
sc_boolean syncFork_isFinal(const SyncFork* handle)
{
   return bool_false;
}

static void syncFork_clearInEvents(SyncFork* handle)
{
	handle->iface.e_raised = bool_false;
	handle->iface.f_raised = bool_false;
}

static void syncFork_clearOutEvents(SyncFork* handle)
{
}

void syncFork_runCycle(SyncFork* handle)
{
	
	syncFork_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < SYNCFORK_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case SyncFork_main_region_A :
		{
			syncFork_react_main_region_A(handle);
			break;
		}
		case SyncFork_main_region_B_r1_C1 :
		{
			syncFork_react_main_region_B_r1_C1(handle);
			break;
		}
		case SyncFork_main_region_B_r1_C2 :
		{
			syncFork_react_main_region_B_r1_C2(handle);
			break;
		}
		case SyncFork_main_region_B_r2_D1 :
		{
			syncFork_react_main_region_B_r2_D1(handle);
			break;
		}
		case SyncFork_main_region_B_r2_D2 :
		{
			syncFork_react_main_region_B_r2_D2(handle);
			break;
		}
		default:
			break;
		}
	}
	
	syncFork_clearInEvents(handle);
}


sc_boolean syncFork_isStateActive(const SyncFork* handle, SyncForkStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case SyncFork_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == SyncFork_main_region_A
			);
			break;
		case SyncFork_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[0] >= SyncFork_main_region_B
				&& handle->stateConfVector[0] <= SyncFork_main_region_B_r2_D2);
			break;
		case SyncFork_main_region_B_r1_C1 :
			result = (sc_boolean) (handle->stateConfVector[0] == SyncFork_main_region_B_r1_C1
			);
			break;
		case SyncFork_main_region_B_r1_C2 :
			result = (sc_boolean) (handle->stateConfVector[0] == SyncFork_main_region_B_r1_C2
			);
			break;
		case SyncFork_main_region_B_r2_D1 :
			result = (sc_boolean) (handle->stateConfVector[1] == SyncFork_main_region_B_r2_D1
			);
			break;
		case SyncFork_main_region_B_r2_D2 :
			result = (sc_boolean) (handle->stateConfVector[1] == SyncFork_main_region_B_r2_D2
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void syncForkIface_raise_e(SyncFork* handle)
{
	handle->iface.e_raised = bool_true;
}
void syncForkIface_raise_f(SyncFork* handle)
{
	handle->iface.f_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean syncFork_check_main_region_A_tr0_tr0(const SyncFork* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean syncFork_check_main_region_A_tr1_tr1(const SyncFork* handle)
{
	return handle->iface.f_raised;
}

static sc_boolean syncFork_check_main_region_B_tr0_tr0(const SyncFork* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean syncFork_check_main_region_B_r1_C1_tr0_tr0(const SyncFork* handle)
{
	return handle->iface.f_raised;
}

static sc_boolean syncFork_check_main_region_B_r2_D1_tr0_tr0(const SyncFork* handle)
{
	return handle->iface.f_raised;
}

static void syncFork_effect_main_region_A_tr0(SyncFork* handle)
{
	syncFork_exseq_main_region_A(handle);
	syncFork_react_main_region__sync0(handle);
}

static void syncFork_effect_main_region_A_tr1(SyncFork* handle)
{
	syncFork_exseq_main_region_A(handle);
	syncFork_enseq_main_region_B_default(handle);
}

static void syncFork_effect_main_region_B_tr0(SyncFork* handle)
{
	syncFork_exseq_main_region_B(handle);
	syncFork_enseq_main_region_A_default(handle);
}

static void syncFork_effect_main_region_B_r1_C1_tr0(SyncFork* handle)
{
	syncFork_exseq_main_region_B_r1_C1(handle);
	syncFork_enseq_main_region_B_r1_C2_default(handle);
}

static void syncFork_effect_main_region_B_r2_D1_tr0(SyncFork* handle)
{
	syncFork_exseq_main_region_B_r2_D1(handle);
	syncFork_enseq_main_region_B_r2_D2_default(handle);
}

/* 'default' enter sequence for state A */
static void syncFork_enseq_main_region_A_default(SyncFork* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = SyncFork_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void syncFork_enseq_main_region_B_default(SyncFork* handle)
{
	/* 'default' enter sequence for state B */
	syncFork_enseq_main_region_B_r1_default(handle);
	syncFork_enseq_main_region_B_r2_default(handle);
}

/* 'default' enter sequence for state C1 */
static void syncFork_enseq_main_region_B_r1_C1_default(SyncFork* handle)
{
	/* 'default' enter sequence for state C1 */
	handle->stateConfVector[0] = SyncFork_main_region_B_r1_C1;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C2 */
static void syncFork_enseq_main_region_B_r1_C2_default(SyncFork* handle)
{
	/* 'default' enter sequence for state C2 */
	handle->stateConfVector[0] = SyncFork_main_region_B_r1_C2;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state D1 */
static void syncFork_enseq_main_region_B_r2_D1_default(SyncFork* handle)
{
	/* 'default' enter sequence for state D1 */
	handle->stateConfVector[1] = SyncFork_main_region_B_r2_D1;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state D2 */
static void syncFork_enseq_main_region_B_r2_D2_default(SyncFork* handle)
{
	/* 'default' enter sequence for state D2 */
	handle->stateConfVector[1] = SyncFork_main_region_B_r2_D2;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region main region */
static void syncFork_enseq_main_region_default(SyncFork* handle)
{
	/* 'default' enter sequence for region main region */
	syncFork_react_main_region__entry_Default(handle);
}

/* 'default' enter sequence for region r1 */
static void syncFork_enseq_main_region_B_r1_default(SyncFork* handle)
{
	/* 'default' enter sequence for region r1 */
	syncFork_react_main_region_B_r1__entry_Default(handle);
}

/* 'default' enter sequence for region r2 */
static void syncFork_enseq_main_region_B_r2_default(SyncFork* handle)
{
	/* 'default' enter sequence for region r2 */
	syncFork_react_main_region_B_r2__entry_Default(handle);
}

/* Default exit sequence for state A */
static void syncFork_exseq_main_region_A(SyncFork* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = SyncFork_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void syncFork_exseq_main_region_B(SyncFork* handle)
{
	/* Default exit sequence for state B */
	syncFork_exseq_main_region_B_r1(handle);
	syncFork_exseq_main_region_B_r2(handle);
}

/* Default exit sequence for state C1 */
static void syncFork_exseq_main_region_B_r1_C1(SyncFork* handle)
{
	/* Default exit sequence for state C1 */
	handle->stateConfVector[0] = SyncFork_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state C2 */
static void syncFork_exseq_main_region_B_r1_C2(SyncFork* handle)
{
	/* Default exit sequence for state C2 */
	handle->stateConfVector[0] = SyncFork_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state D1 */
static void syncFork_exseq_main_region_B_r2_D1(SyncFork* handle)
{
	/* Default exit sequence for state D1 */
	handle->stateConfVector[1] = SyncFork_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state D2 */
static void syncFork_exseq_main_region_B_r2_D2(SyncFork* handle)
{
	/* Default exit sequence for state D2 */
	handle->stateConfVector[1] = SyncFork_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for region main region */
static void syncFork_exseq_main_region(SyncFork* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of SyncFork.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case SyncFork_main_region_A :
		{
			syncFork_exseq_main_region_A(handle);
			break;
		}
		case SyncFork_main_region_B_r1_C1 :
		{
			syncFork_exseq_main_region_B_r1_C1(handle);
			break;
		}
		case SyncFork_main_region_B_r1_C2 :
		{
			syncFork_exseq_main_region_B_r1_C2(handle);
			break;
		}
		default: break;
	}
	/* Handle exit of all possible states (of SyncFork.main_region) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case SyncFork_main_region_B_r2_D1 :
		{
			syncFork_exseq_main_region_B_r2_D1(handle);
			break;
		}
		case SyncFork_main_region_B_r2_D2 :
		{
			syncFork_exseq_main_region_B_r2_D2(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r1 */
static void syncFork_exseq_main_region_B_r1(SyncFork* handle)
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of SyncFork.main_region.B.r1) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case SyncFork_main_region_B_r1_C1 :
		{
			syncFork_exseq_main_region_B_r1_C1(handle);
			break;
		}
		case SyncFork_main_region_B_r1_C2 :
		{
			syncFork_exseq_main_region_B_r1_C2(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r2 */
static void syncFork_exseq_main_region_B_r2(SyncFork* handle)
{
	/* Default exit sequence for region r2 */
	/* Handle exit of all possible states (of SyncFork.main_region.B.r2) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case SyncFork_main_region_B_r2_D1 :
		{
			syncFork_exseq_main_region_B_r2_D1(handle);
			break;
		}
		case SyncFork_main_region_B_r2_D2 :
		{
			syncFork_exseq_main_region_B_r2_D2(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void syncFork_react_main_region_A(SyncFork* handle)
{
	/* The reactions of state A. */
	if (syncFork_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		syncFork_effect_main_region_A_tr0(handle);
	}  else
	{
		if (syncFork_check_main_region_A_tr1_tr1(handle) == bool_true)
		{ 
			syncFork_effect_main_region_A_tr1(handle);
		} 
	}
}

/* The reactions of state C1. */
static void syncFork_react_main_region_B_r1_C1(SyncFork* handle)
{
	/* The reactions of state C1. */
	if (syncFork_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		syncFork_effect_main_region_B_tr0(handle);
	}  else
	{
		if (syncFork_check_main_region_B_r1_C1_tr0_tr0(handle) == bool_true)
		{ 
			syncFork_effect_main_region_B_r1_C1_tr0(handle);
		} 
	}
}

/* The reactions of state C2. */
static void syncFork_react_main_region_B_r1_C2(SyncFork* handle)
{
	/* The reactions of state C2. */
	if (syncFork_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		syncFork_effect_main_region_B_tr0(handle);
	}  else
	{
	}
}

/* The reactions of state D1. */
static void syncFork_react_main_region_B_r2_D1(SyncFork* handle)
{
	/* The reactions of state D1. */
	if (syncFork_check_main_region_B_r2_D1_tr0_tr0(handle) == bool_true)
	{ 
		syncFork_effect_main_region_B_r2_D1_tr0(handle);
	} 
}

/* The reactions of state D2. */
static void syncFork_react_main_region_B_r2_D2(SyncFork* handle)
{
}

/* Default react sequence for initial entry  */
static void syncFork_react_main_region__entry_Default(SyncFork* handle)
{
	/* Default react sequence for initial entry  */
	syncFork_enseq_main_region_A_default(handle);
}

/* Default react sequence for initial entry  */
static void syncFork_react_main_region_B_r1__entry_Default(SyncFork* handle)
{
	/* Default react sequence for initial entry  */
	syncFork_enseq_main_region_B_r1_C1_default(handle);
}

/* Default react sequence for initial entry  */
static void syncFork_react_main_region_B_r2__entry_Default(SyncFork* handle)
{
	/* Default react sequence for initial entry  */
	syncFork_enseq_main_region_B_r2_D1_default(handle);
}

/* The reactions of state null. */
static void syncFork_react_main_region__sync0(SyncFork* handle)
{
	/* The reactions of state null. */
	syncFork_enseq_main_region_B_r1_C2_default(handle);
	syncFork_enseq_main_region_B_r2_D2_default(handle);
}


