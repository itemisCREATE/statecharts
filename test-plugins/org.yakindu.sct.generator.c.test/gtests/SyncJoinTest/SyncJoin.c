
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "SyncJoin.h"
/*! \file Implementation of the state machine 'SyncJoin'
*/

/* prototypes of all internal functions */
static sc_boolean syncJoin_check_main_region_A_tr0_tr0(const SyncJoin* handle);
static sc_boolean syncJoin_check_main_region_B_r1_C1_tr0_tr0(const SyncJoin* handle);
static sc_boolean syncJoin_check_main_region_B_r1_C2_tr0_tr0(const SyncJoin* handle);
static sc_boolean syncJoin_check_main_region_B_r2_D1_tr0_tr0(const SyncJoin* handle);
static sc_boolean syncJoin_check_main_region_B_r2_D2_tr0_tr0(const SyncJoin* handle);
static void syncJoin_effect_main_region_A_tr0(SyncJoin* handle);
static void syncJoin_effect_main_region_B_r1_C1_tr0(SyncJoin* handle);
static void syncJoin_effect_main_region_B_r1_C2_tr0(SyncJoin* handle);
static void syncJoin_effect_main_region_B_r2_D1_tr0(SyncJoin* handle);
static void syncJoin_effect_main_region_B_r2_D2_tr0(SyncJoin* handle);
static void syncJoin_enact_main_region_A(SyncJoin* handle);
static void syncJoin_enseq_main_region_A_default(SyncJoin* handle);
static void syncJoin_enseq_main_region_B_default(SyncJoin* handle);
static void syncJoin_enseq_main_region_B_r1_C1_default(SyncJoin* handle);
static void syncJoin_enseq_main_region_B_r1_C2_default(SyncJoin* handle);
static void syncJoin_enseq_main_region_B_r2_D1_default(SyncJoin* handle);
static void syncJoin_enseq_main_region_B_r2_D2_default(SyncJoin* handle);
static void syncJoin_enseq_main_region_default(SyncJoin* handle);
static void syncJoin_enseq_main_region_B_r1_default(SyncJoin* handle);
static void syncJoin_enseq_main_region_B_r2_default(SyncJoin* handle);
static void syncJoin_exseq_main_region_A(SyncJoin* handle);
static void syncJoin_exseq_main_region_B(SyncJoin* handle);
static void syncJoin_exseq_main_region_B_r1_C1(SyncJoin* handle);
static void syncJoin_exseq_main_region_B_r1_C2(SyncJoin* handle);
static void syncJoin_exseq_main_region_B_r2_D1(SyncJoin* handle);
static void syncJoin_exseq_main_region_B_r2_D2(SyncJoin* handle);
static void syncJoin_exseq_main_region(SyncJoin* handle);
static void syncJoin_exseq_main_region_B_r1(SyncJoin* handle);
static void syncJoin_exseq_main_region_B_r2(SyncJoin* handle);
static void syncJoin_react_main_region_A(SyncJoin* handle);
static void syncJoin_react_main_region_B_r1_C1(SyncJoin* handle);
static void syncJoin_react_main_region_B_r1_C2(SyncJoin* handle);
static void syncJoin_react_main_region_B_r2_D1(SyncJoin* handle);
static void syncJoin_react_main_region_B_r2_D2(SyncJoin* handle);
static void syncJoin_react_main_region__entry_Default(SyncJoin* handle);
static void syncJoin_react_main_region_B_r1__entry_Default(SyncJoin* handle);
static void syncJoin_react_main_region_B_r2__entry_Default(SyncJoin* handle);
static void syncJoin_react_main_region__sync0(SyncJoin* handle);
static void syncJoin_clearInEvents(SyncJoin* handle);
static void syncJoin_clearOutEvents(SyncJoin* handle);


void syncJoin_init(SyncJoin* handle)
{
	sc_integer i;

	for (i = 0; i < SYNCJOIN_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = SyncJoin_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	syncJoin_clearInEvents(handle);
	syncJoin_clearOutEvents(handle);

	/* Default init sequence for statechart SyncJoin */
	handle->iface.x = 0;

}

void syncJoin_enter(SyncJoin* handle)
{
	/* Default enter sequence for statechart SyncJoin */
	syncJoin_enseq_main_region_default(handle);
}

void syncJoin_exit(SyncJoin* handle)
{
	/* Default exit sequence for statechart SyncJoin */
	syncJoin_exseq_main_region(handle);
}

sc_boolean syncJoin_isActive(const SyncJoin* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != SyncJoin_last_state || handle->stateConfVector[1] != SyncJoin_last_state)
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
sc_boolean syncJoin_isFinal(const SyncJoin* handle)
{
   return bool_false;
}

static void syncJoin_clearInEvents(SyncJoin* handle)
{
	handle->iface.e_raised = bool_false;
	handle->iface.f_raised = bool_false;
	handle->iface.jc_raised = bool_false;
	handle->iface.jd_raised = bool_false;
}

static void syncJoin_clearOutEvents(SyncJoin* handle)
{
}

void syncJoin_runCycle(SyncJoin* handle)
{
	
	syncJoin_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < SYNCJOIN_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case SyncJoin_main_region_A :
		{
			syncJoin_react_main_region_A(handle);
			break;
		}
		case SyncJoin_main_region_B_r1_C1 :
		{
			syncJoin_react_main_region_B_r1_C1(handle);
			break;
		}
		case SyncJoin_main_region_B_r1_C2 :
		{
			syncJoin_react_main_region_B_r1_C2(handle);
			break;
		}
		case SyncJoin_main_region_B_r2_D1 :
		{
			syncJoin_react_main_region_B_r2_D1(handle);
			break;
		}
		case SyncJoin_main_region_B_r2_D2 :
		{
			syncJoin_react_main_region_B_r2_D2(handle);
			break;
		}
		default:
			break;
		}
	}
	
	syncJoin_clearInEvents(handle);
}


sc_boolean syncJoin_isStateActive(const SyncJoin* handle, SyncJoinStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case SyncJoin_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == SyncJoin_main_region_A
			);
			break;
		case SyncJoin_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[0] >= SyncJoin_main_region_B
				&& handle->stateConfVector[0] <= SyncJoin_main_region_B_r2_D2);
			break;
		case SyncJoin_main_region_B_r1_C1 :
			result = (sc_boolean) (handle->stateConfVector[0] == SyncJoin_main_region_B_r1_C1
			);
			break;
		case SyncJoin_main_region_B_r1_C2 :
			result = (sc_boolean) (handle->stateConfVector[0] == SyncJoin_main_region_B_r1_C2
			);
			break;
		case SyncJoin_main_region_B_r2_D1 :
			result = (sc_boolean) (handle->stateConfVector[1] == SyncJoin_main_region_B_r2_D1
			);
			break;
		case SyncJoin_main_region_B_r2_D2 :
			result = (sc_boolean) (handle->stateConfVector[1] == SyncJoin_main_region_B_r2_D2
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void syncJoinIface_raise_e(SyncJoin* handle)
{
	handle->iface.e_raised = bool_true;
}
void syncJoinIface_raise_f(SyncJoin* handle)
{
	handle->iface.f_raised = bool_true;
}
void syncJoinIface_raise_jc(SyncJoin* handle)
{
	handle->iface.jc_raised = bool_true;
}
void syncJoinIface_raise_jd(SyncJoin* handle)
{
	handle->iface.jd_raised = bool_true;
}


sc_integer syncJoinIface_get_x(const SyncJoin* handle)
{
	return handle->iface.x;
}
void syncJoinIface_set_x(SyncJoin* handle, sc_integer value)
{
	handle->iface.x = value;
}

/* implementations of all internal functions */

static sc_boolean syncJoin_check_main_region_A_tr0_tr0(const SyncJoin* handle)
{
	return (handle->iface.e_raised || handle->iface.f_raised) ? bool_true : bool_false;
}

static sc_boolean syncJoin_check_main_region_B_r1_C1_tr0_tr0(const SyncJoin* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean syncJoin_check_main_region_B_r1_C2_tr0_tr0(const SyncJoin* handle)
{
	return (handle->iface.jc_raised && syncJoin_isStateActive(handle, SyncJoin_main_region_B_r2_D2) && handle->iface.jd_raised) ? bool_true : bool_false;
}

static sc_boolean syncJoin_check_main_region_B_r2_D1_tr0_tr0(const SyncJoin* handle)
{
	return handle->iface.f_raised;
}

static sc_boolean syncJoin_check_main_region_B_r2_D2_tr0_tr0(const SyncJoin* handle)
{
	return (handle->iface.jd_raised && syncJoin_isStateActive(handle, SyncJoin_main_region_B_r1_C2) && handle->iface.jc_raised) ? bool_true : bool_false;
}

static void syncJoin_effect_main_region_A_tr0(SyncJoin* handle)
{
	syncJoin_exseq_main_region_A(handle);
	syncJoin_enseq_main_region_B_default(handle);
}

static void syncJoin_effect_main_region_B_r1_C1_tr0(SyncJoin* handle)
{
	syncJoin_exseq_main_region_B_r1_C1(handle);
	syncJoin_enseq_main_region_B_r1_C2_default(handle);
}

static void syncJoin_effect_main_region_B_r1_C2_tr0(SyncJoin* handle)
{
	syncJoin_exseq_main_region_B(handle);
	syncJoin_react_main_region__sync0(handle);
}

static void syncJoin_effect_main_region_B_r2_D1_tr0(SyncJoin* handle)
{
	syncJoin_exseq_main_region_B_r2_D1(handle);
	syncJoin_enseq_main_region_B_r2_D2_default(handle);
}

static void syncJoin_effect_main_region_B_r2_D2_tr0(SyncJoin* handle)
{
	syncJoin_exseq_main_region_B(handle);
	syncJoin_react_main_region__sync0(handle);
}

/* Entry action for state 'A'. */
static void syncJoin_enact_main_region_A(SyncJoin* handle)
{
	/* Entry action for state 'A'. */
	handle->iface.x += 1;
}

/* 'default' enter sequence for state A */
static void syncJoin_enseq_main_region_A_default(SyncJoin* handle)
{
	/* 'default' enter sequence for state A */
	syncJoin_enact_main_region_A(handle);
	handle->stateConfVector[0] = SyncJoin_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void syncJoin_enseq_main_region_B_default(SyncJoin* handle)
{
	/* 'default' enter sequence for state B */
	syncJoin_enseq_main_region_B_r1_default(handle);
	syncJoin_enseq_main_region_B_r2_default(handle);
}

/* 'default' enter sequence for state C1 */
static void syncJoin_enseq_main_region_B_r1_C1_default(SyncJoin* handle)
{
	/* 'default' enter sequence for state C1 */
	handle->stateConfVector[0] = SyncJoin_main_region_B_r1_C1;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C2 */
static void syncJoin_enseq_main_region_B_r1_C2_default(SyncJoin* handle)
{
	/* 'default' enter sequence for state C2 */
	handle->stateConfVector[0] = SyncJoin_main_region_B_r1_C2;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state D1 */
static void syncJoin_enseq_main_region_B_r2_D1_default(SyncJoin* handle)
{
	/* 'default' enter sequence for state D1 */
	handle->stateConfVector[1] = SyncJoin_main_region_B_r2_D1;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state D2 */
static void syncJoin_enseq_main_region_B_r2_D2_default(SyncJoin* handle)
{
	/* 'default' enter sequence for state D2 */
	handle->stateConfVector[1] = SyncJoin_main_region_B_r2_D2;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region main region */
static void syncJoin_enseq_main_region_default(SyncJoin* handle)
{
	/* 'default' enter sequence for region main region */
	syncJoin_react_main_region__entry_Default(handle);
}

/* 'default' enter sequence for region r1 */
static void syncJoin_enseq_main_region_B_r1_default(SyncJoin* handle)
{
	/* 'default' enter sequence for region r1 */
	syncJoin_react_main_region_B_r1__entry_Default(handle);
}

/* 'default' enter sequence for region r2 */
static void syncJoin_enseq_main_region_B_r2_default(SyncJoin* handle)
{
	/* 'default' enter sequence for region r2 */
	syncJoin_react_main_region_B_r2__entry_Default(handle);
}

/* Default exit sequence for state A */
static void syncJoin_exseq_main_region_A(SyncJoin* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = SyncJoin_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void syncJoin_exseq_main_region_B(SyncJoin* handle)
{
	/* Default exit sequence for state B */
	syncJoin_exseq_main_region_B_r1(handle);
	syncJoin_exseq_main_region_B_r2(handle);
}

/* Default exit sequence for state C1 */
static void syncJoin_exseq_main_region_B_r1_C1(SyncJoin* handle)
{
	/* Default exit sequence for state C1 */
	handle->stateConfVector[0] = SyncJoin_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state C2 */
static void syncJoin_exseq_main_region_B_r1_C2(SyncJoin* handle)
{
	/* Default exit sequence for state C2 */
	handle->stateConfVector[0] = SyncJoin_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state D1 */
static void syncJoin_exseq_main_region_B_r2_D1(SyncJoin* handle)
{
	/* Default exit sequence for state D1 */
	handle->stateConfVector[1] = SyncJoin_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state D2 */
static void syncJoin_exseq_main_region_B_r2_D2(SyncJoin* handle)
{
	/* Default exit sequence for state D2 */
	handle->stateConfVector[1] = SyncJoin_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for region main region */
static void syncJoin_exseq_main_region(SyncJoin* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of SyncJoin.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case SyncJoin_main_region_A :
		{
			syncJoin_exseq_main_region_A(handle);
			break;
		}
		case SyncJoin_main_region_B_r1_C1 :
		{
			syncJoin_exseq_main_region_B_r1_C1(handle);
			break;
		}
		case SyncJoin_main_region_B_r1_C2 :
		{
			syncJoin_exseq_main_region_B_r1_C2(handle);
			break;
		}
		default: break;
	}
	/* Handle exit of all possible states (of SyncJoin.main_region) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case SyncJoin_main_region_B_r2_D1 :
		{
			syncJoin_exseq_main_region_B_r2_D1(handle);
			break;
		}
		case SyncJoin_main_region_B_r2_D2 :
		{
			syncJoin_exseq_main_region_B_r2_D2(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r1 */
static void syncJoin_exseq_main_region_B_r1(SyncJoin* handle)
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of SyncJoin.main_region.B.r1) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case SyncJoin_main_region_B_r1_C1 :
		{
			syncJoin_exseq_main_region_B_r1_C1(handle);
			break;
		}
		case SyncJoin_main_region_B_r1_C2 :
		{
			syncJoin_exseq_main_region_B_r1_C2(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r2 */
static void syncJoin_exseq_main_region_B_r2(SyncJoin* handle)
{
	/* Default exit sequence for region r2 */
	/* Handle exit of all possible states (of SyncJoin.main_region.B.r2) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case SyncJoin_main_region_B_r2_D1 :
		{
			syncJoin_exseq_main_region_B_r2_D1(handle);
			break;
		}
		case SyncJoin_main_region_B_r2_D2 :
		{
			syncJoin_exseq_main_region_B_r2_D2(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void syncJoin_react_main_region_A(SyncJoin* handle)
{
	/* The reactions of state A. */
	if (syncJoin_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		syncJoin_effect_main_region_A_tr0(handle);
	} 
}

/* The reactions of state C1. */
static void syncJoin_react_main_region_B_r1_C1(SyncJoin* handle)
{
	/* The reactions of state C1. */
	if (syncJoin_check_main_region_B_r1_C1_tr0_tr0(handle) == bool_true)
	{ 
		syncJoin_effect_main_region_B_r1_C1_tr0(handle);
	} 
}

/* The reactions of state C2. */
static void syncJoin_react_main_region_B_r1_C2(SyncJoin* handle)
{
	/* The reactions of state C2. */
	if (syncJoin_check_main_region_B_r1_C2_tr0_tr0(handle) == bool_true)
	{ 
		syncJoin_effect_main_region_B_r1_C2_tr0(handle);
	} 
}

/* The reactions of state D1. */
static void syncJoin_react_main_region_B_r2_D1(SyncJoin* handle)
{
	/* The reactions of state D1. */
	if (syncJoin_check_main_region_B_r2_D1_tr0_tr0(handle) == bool_true)
	{ 
		syncJoin_effect_main_region_B_r2_D1_tr0(handle);
	} 
}

/* The reactions of state D2. */
static void syncJoin_react_main_region_B_r2_D2(SyncJoin* handle)
{
	/* The reactions of state D2. */
	if (syncJoin_check_main_region_B_r2_D2_tr0_tr0(handle) == bool_true)
	{ 
		syncJoin_effect_main_region_B_r2_D2_tr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void syncJoin_react_main_region__entry_Default(SyncJoin* handle)
{
	/* Default react sequence for initial entry  */
	syncJoin_enseq_main_region_B_default(handle);
}

/* Default react sequence for initial entry  */
static void syncJoin_react_main_region_B_r1__entry_Default(SyncJoin* handle)
{
	/* Default react sequence for initial entry  */
	syncJoin_enseq_main_region_B_r1_C1_default(handle);
}

/* Default react sequence for initial entry  */
static void syncJoin_react_main_region_B_r2__entry_Default(SyncJoin* handle)
{
	/* Default react sequence for initial entry  */
	syncJoin_enseq_main_region_B_r2_D1_default(handle);
}

/* The reactions of state null. */
static void syncJoin_react_main_region__sync0(SyncJoin* handle)
{
	/* The reactions of state null. */
	syncJoin_enseq_main_region_A_default(handle);
}


