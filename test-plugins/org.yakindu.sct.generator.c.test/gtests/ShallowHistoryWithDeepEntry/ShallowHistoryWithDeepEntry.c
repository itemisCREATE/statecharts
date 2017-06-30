
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "ShallowHistoryWithDeepEntry.h"
/*! \file Implementation of the state machine 'ShallowHistoryWithDeepEntry'
*/

/* prototypes of all internal functions */
static sc_boolean shallowHistoryWithDeepEntry_check_main_region_Y_tr0_tr0(const ShallowHistoryWithDeepEntry* handle);
static sc_boolean shallowHistoryWithDeepEntry_check_main_region_Y_tr1_tr1(const ShallowHistoryWithDeepEntry* handle);
static sc_boolean shallowHistoryWithDeepEntry_check_main_region_Z_tr0_tr0(const ShallowHistoryWithDeepEntry* handle);
static sc_boolean shallowHistoryWithDeepEntry_check_main_region_Z__region0_A_tr0_tr0(const ShallowHistoryWithDeepEntry* handle);
static sc_boolean shallowHistoryWithDeepEntry_check_main_region_Z__region0_B__region0_C_tr0_tr0(const ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_effect_main_region_Y_tr0(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_effect_main_region_Y_tr1(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_effect_main_region_Z_tr0(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_effect_main_region_Z__region0_A_tr0(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_effect_main_region_Z__region0_B__region0_C_tr0(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_enseq_main_region_Y_default(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_enseq_main_region_Z_default(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_A_default(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_B_default(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_B__region0_C_default(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_enseq_main_region_default(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_default(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_shenseq_main_region_Z__region0(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_B__region0_default(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_exseq_main_region_Y(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_exseq_main_region_Z(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_A(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_B(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_B__region0_C(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_exseq_main_region(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_exseq_main_region_Z__region0(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_B__region0(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_react_main_region_Y(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_react_main_region_Z__region0_A(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_react_main_region_Z__region0_B__region0_C(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_react_main_region__entry_Default(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_react_main_region_Z__region0__entry_Default(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_react_main_region_Z__region0_B__region0__entry_Default(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_clearInEvents(ShallowHistoryWithDeepEntry* handle);
static void shallowHistoryWithDeepEntry_clearOutEvents(ShallowHistoryWithDeepEntry* handle);


void shallowHistoryWithDeepEntry_init(ShallowHistoryWithDeepEntry* handle)
{
	sc_integer i;

	for (i = 0; i < SHALLOWHISTORYWITHDEEPENTRY_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = ShallowHistoryWithDeepEntry_last_state;
	}
	
	for (i = 0; i < SHALLOWHISTORYWITHDEEPENTRY_MAX_HISTORY_STATES; ++i)
	{
		handle->historyVector[i] = ShallowHistoryWithDeepEntry_last_state;
	}
	
	handle->stateConfVectorPosition = 0;

	shallowHistoryWithDeepEntry_clearInEvents(handle);
	shallowHistoryWithDeepEntry_clearOutEvents(handle);


}

void shallowHistoryWithDeepEntry_enter(ShallowHistoryWithDeepEntry* handle)
{
	/* Default enter sequence for statechart ShallowHistoryWithDeepEntry */
	shallowHistoryWithDeepEntry_enseq_main_region_default(handle);
}

void shallowHistoryWithDeepEntry_exit(ShallowHistoryWithDeepEntry* handle)
{
	/* Default exit sequence for statechart ShallowHistoryWithDeepEntry */
	shallowHistoryWithDeepEntry_exseq_main_region(handle);
}

sc_boolean shallowHistoryWithDeepEntry_isActive(const ShallowHistoryWithDeepEntry* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < SHALLOWHISTORYWITHDEEPENTRY_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != ShallowHistoryWithDeepEntry_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean shallowHistoryWithDeepEntry_isFinal(const ShallowHistoryWithDeepEntry* handle)
{
   return bool_false;
}

static void shallowHistoryWithDeepEntry_clearInEvents(ShallowHistoryWithDeepEntry* handle)
{
	handle->iface.toZ_raised = bool_false;
	handle->iface.toY_raised = bool_false;
	handle->iface.toC_raised = bool_false;
	handle->iface.toA_raised = bool_false;
}

static void shallowHistoryWithDeepEntry_clearOutEvents(ShallowHistoryWithDeepEntry* handle)
{
}

void shallowHistoryWithDeepEntry_runCycle(ShallowHistoryWithDeepEntry* handle)
{
	
	shallowHistoryWithDeepEntry_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < SHALLOWHISTORYWITHDEEPENTRY_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case ShallowHistoryWithDeepEntry_main_region_Y :
		{
			shallowHistoryWithDeepEntry_react_main_region_Y(handle);
			break;
		}
		case ShallowHistoryWithDeepEntry_main_region_Z__region0_A :
		{
			shallowHistoryWithDeepEntry_react_main_region_Z__region0_A(handle);
			break;
		}
		case ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C :
		{
			shallowHistoryWithDeepEntry_react_main_region_Z__region0_B__region0_C(handle);
			break;
		}
		default:
			break;
		}
	}
	
	shallowHistoryWithDeepEntry_clearInEvents(handle);
}


sc_boolean shallowHistoryWithDeepEntry_isStateActive(const ShallowHistoryWithDeepEntry* handle, ShallowHistoryWithDeepEntryStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case ShallowHistoryWithDeepEntry_main_region_Y :
			result = (sc_boolean) (handle->stateConfVector[SCVI_SHALLOWHISTORYWITHDEEPENTRY_MAIN_REGION_Y] == ShallowHistoryWithDeepEntry_main_region_Y
			);
			break;
		case ShallowHistoryWithDeepEntry_main_region_Z :
			result = (sc_boolean) (handle->stateConfVector[SCVI_SHALLOWHISTORYWITHDEEPENTRY_MAIN_REGION_Z] >= ShallowHistoryWithDeepEntry_main_region_Z
				&& handle->stateConfVector[SCVI_SHALLOWHISTORYWITHDEEPENTRY_MAIN_REGION_Z] <= ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C);
			break;
		case ShallowHistoryWithDeepEntry_main_region_Z__region0_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_SHALLOWHISTORYWITHDEEPENTRY_MAIN_REGION_Z__REGION0_A] == ShallowHistoryWithDeepEntry_main_region_Z__region0_A
			);
			break;
		case ShallowHistoryWithDeepEntry_main_region_Z__region0_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_SHALLOWHISTORYWITHDEEPENTRY_MAIN_REGION_Z__REGION0_B] >= ShallowHistoryWithDeepEntry_main_region_Z__region0_B
				&& handle->stateConfVector[SCVI_SHALLOWHISTORYWITHDEEPENTRY_MAIN_REGION_Z__REGION0_B] <= ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C);
			break;
		case ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C :
			result = (sc_boolean) (handle->stateConfVector[SCVI_SHALLOWHISTORYWITHDEEPENTRY_MAIN_REGION_Z__REGION0_B__REGION0_C] == ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void shallowHistoryWithDeepEntryIface_raise_toZ(ShallowHistoryWithDeepEntry* handle)
{
	handle->iface.toZ_raised = bool_true;
}
void shallowHistoryWithDeepEntryIface_raise_toY(ShallowHistoryWithDeepEntry* handle)
{
	handle->iface.toY_raised = bool_true;
}
void shallowHistoryWithDeepEntryIface_raise_toC(ShallowHistoryWithDeepEntry* handle)
{
	handle->iface.toC_raised = bool_true;
}
void shallowHistoryWithDeepEntryIface_raise_toA(ShallowHistoryWithDeepEntry* handle)
{
	handle->iface.toA_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean shallowHistoryWithDeepEntry_check_main_region_Y_tr0_tr0(const ShallowHistoryWithDeepEntry* handle)
{
	return handle->iface.toZ_raised;
}

static sc_boolean shallowHistoryWithDeepEntry_check_main_region_Y_tr1_tr1(const ShallowHistoryWithDeepEntry* handle)
{
	return handle->iface.toC_raised;
}

static sc_boolean shallowHistoryWithDeepEntry_check_main_region_Z_tr0_tr0(const ShallowHistoryWithDeepEntry* handle)
{
	return handle->iface.toY_raised;
}

static sc_boolean shallowHistoryWithDeepEntry_check_main_region_Z__region0_A_tr0_tr0(const ShallowHistoryWithDeepEntry* handle)
{
	return handle->iface.toC_raised;
}

static sc_boolean shallowHistoryWithDeepEntry_check_main_region_Z__region0_B__region0_C_tr0_tr0(const ShallowHistoryWithDeepEntry* handle)
{
	return handle->iface.toA_raised;
}

static void shallowHistoryWithDeepEntry_effect_main_region_Y_tr0(ShallowHistoryWithDeepEntry* handle)
{
	shallowHistoryWithDeepEntry_exseq_main_region_Y(handle);
	shallowHistoryWithDeepEntry_enseq_main_region_Z_default(handle);
}

static void shallowHistoryWithDeepEntry_effect_main_region_Y_tr1(ShallowHistoryWithDeepEntry* handle)
{
	shallowHistoryWithDeepEntry_exseq_main_region_Y(handle);
	shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_B__region0_C_default(handle);
	handle->historyVector[0] = handle->stateConfVector[0];
}

static void shallowHistoryWithDeepEntry_effect_main_region_Z_tr0(ShallowHistoryWithDeepEntry* handle)
{
	shallowHistoryWithDeepEntry_exseq_main_region_Z(handle);
	shallowHistoryWithDeepEntry_enseq_main_region_Y_default(handle);
}

static void shallowHistoryWithDeepEntry_effect_main_region_Z__region0_A_tr0(ShallowHistoryWithDeepEntry* handle)
{
	shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_A(handle);
	shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_B__region0_C_default(handle);
	handle->historyVector[0] = handle->stateConfVector[0];
}

static void shallowHistoryWithDeepEntry_effect_main_region_Z__region0_B__region0_C_tr0(ShallowHistoryWithDeepEntry* handle)
{
	shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_B(handle);
	shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_A_default(handle);
}

/* 'default' enter sequence for state Y */
static void shallowHistoryWithDeepEntry_enseq_main_region_Y_default(ShallowHistoryWithDeepEntry* handle)
{
	/* 'default' enter sequence for state Y */
	handle->stateConfVector[0] = ShallowHistoryWithDeepEntry_main_region_Y;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Z */
static void shallowHistoryWithDeepEntry_enseq_main_region_Z_default(ShallowHistoryWithDeepEntry* handle)
{
	/* 'default' enter sequence for state Z */
	shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_default(handle);
}

/* 'default' enter sequence for state A */
static void shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_A_default(ShallowHistoryWithDeepEntry* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = ShallowHistoryWithDeepEntry_main_region_Z__region0_A;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state B */
static void shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_B_default(ShallowHistoryWithDeepEntry* handle)
{
	/* 'default' enter sequence for state B */
	shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_B__region0_default(handle);
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state C */
static void shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_B__region0_C_default(ShallowHistoryWithDeepEntry* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[0] = ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void shallowHistoryWithDeepEntry_enseq_main_region_default(ShallowHistoryWithDeepEntry* handle)
{
	/* 'default' enter sequence for region main region */
	shallowHistoryWithDeepEntry_react_main_region__entry_Default(handle);
}

/* 'default' enter sequence for region null */
static void shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_default(ShallowHistoryWithDeepEntry* handle)
{
	/* 'default' enter sequence for region null */
	shallowHistoryWithDeepEntry_react_main_region_Z__region0__entry_Default(handle);
}

/* shallow enterSequence with history in child null */
static void shallowHistoryWithDeepEntry_shenseq_main_region_Z__region0(ShallowHistoryWithDeepEntry* handle)
{
	/* shallow enterSequence with history in child null */
	/* Handle shallow history entry of null */
	switch(handle->historyVector[ 0 ])
	{
		case ShallowHistoryWithDeepEntry_main_region_Z__region0_A :
		{
			shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_A_default(handle);
			break;
		}
		case ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C :
		{
			shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_B_default(handle);
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region null */
static void shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_B__region0_default(ShallowHistoryWithDeepEntry* handle)
{
	/* 'default' enter sequence for region null */
	shallowHistoryWithDeepEntry_react_main_region_Z__region0_B__region0__entry_Default(handle);
}

/* Default exit sequence for state Y */
static void shallowHistoryWithDeepEntry_exseq_main_region_Y(ShallowHistoryWithDeepEntry* handle)
{
	/* Default exit sequence for state Y */
	handle->stateConfVector[0] = ShallowHistoryWithDeepEntry_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state Z */
static void shallowHistoryWithDeepEntry_exseq_main_region_Z(ShallowHistoryWithDeepEntry* handle)
{
	/* Default exit sequence for state Z */
	shallowHistoryWithDeepEntry_exseq_main_region_Z__region0(handle);
}

/* Default exit sequence for state A */
static void shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_A(ShallowHistoryWithDeepEntry* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = ShallowHistoryWithDeepEntry_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_B(ShallowHistoryWithDeepEntry* handle)
{
	/* Default exit sequence for state B */
	shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_B__region0(handle);
}

/* Default exit sequence for state C */
static void shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_B__region0_C(ShallowHistoryWithDeepEntry* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[0] = ShallowHistoryWithDeepEntry_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void shallowHistoryWithDeepEntry_exseq_main_region(ShallowHistoryWithDeepEntry* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of ShallowHistoryWithDeepEntry.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ShallowHistoryWithDeepEntry_main_region_Y :
		{
			shallowHistoryWithDeepEntry_exseq_main_region_Y(handle);
			break;
		}
		case ShallowHistoryWithDeepEntry_main_region_Z__region0_A :
		{
			shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_A(handle);
			break;
		}
		case ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C :
		{
			shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_B__region0_C(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
static void shallowHistoryWithDeepEntry_exseq_main_region_Z__region0(ShallowHistoryWithDeepEntry* handle)
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of ShallowHistoryWithDeepEntry.main_region.Z._region0) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ShallowHistoryWithDeepEntry_main_region_Z__region0_A :
		{
			shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_A(handle);
			break;
		}
		case ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C :
		{
			shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_B__region0_C(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
static void shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_B__region0(ShallowHistoryWithDeepEntry* handle)
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of ShallowHistoryWithDeepEntry.main_region.Z._region0.B._region0) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C :
		{
			shallowHistoryWithDeepEntry_exseq_main_region_Z__region0_B__region0_C(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state Y. */
static void shallowHistoryWithDeepEntry_react_main_region_Y(ShallowHistoryWithDeepEntry* handle)
{
	/* The reactions of state Y. */
	if (shallowHistoryWithDeepEntry_check_main_region_Y_tr0_tr0(handle) == bool_true)
	{ 
		shallowHistoryWithDeepEntry_effect_main_region_Y_tr0(handle);
	}  else
	{
		if (shallowHistoryWithDeepEntry_check_main_region_Y_tr1_tr1(handle) == bool_true)
		{ 
			shallowHistoryWithDeepEntry_effect_main_region_Y_tr1(handle);
		} 
	}
}

/* The reactions of state A. */
static void shallowHistoryWithDeepEntry_react_main_region_Z__region0_A(ShallowHistoryWithDeepEntry* handle)
{
	/* The reactions of state A. */
	if (shallowHistoryWithDeepEntry_check_main_region_Z_tr0_tr0(handle) == bool_true)
	{ 
		shallowHistoryWithDeepEntry_effect_main_region_Z_tr0(handle);
	}  else
	{
		if (shallowHistoryWithDeepEntry_check_main_region_Z__region0_A_tr0_tr0(handle) == bool_true)
		{ 
			shallowHistoryWithDeepEntry_effect_main_region_Z__region0_A_tr0(handle);
		} 
	}
}

/* The reactions of state C. */
static void shallowHistoryWithDeepEntry_react_main_region_Z__region0_B__region0_C(ShallowHistoryWithDeepEntry* handle)
{
	/* The reactions of state C. */
	if (shallowHistoryWithDeepEntry_check_main_region_Z_tr0_tr0(handle) == bool_true)
	{ 
		shallowHistoryWithDeepEntry_effect_main_region_Z_tr0(handle);
	}  else
	{
		if (shallowHistoryWithDeepEntry_check_main_region_Z__region0_B__region0_C_tr0_tr0(handle) == bool_true)
		{ 
			shallowHistoryWithDeepEntry_effect_main_region_Z__region0_B__region0_C_tr0(handle);
		} 
	}
}

/* Default react sequence for initial entry  */
static void shallowHistoryWithDeepEntry_react_main_region__entry_Default(ShallowHistoryWithDeepEntry* handle)
{
	/* Default react sequence for initial entry  */
	shallowHistoryWithDeepEntry_enseq_main_region_Y_default(handle);
}

/* Default react sequence for shallow history entry  */
static void shallowHistoryWithDeepEntry_react_main_region_Z__region0__entry_Default(ShallowHistoryWithDeepEntry* handle)
{
	/* Default react sequence for shallow history entry  */
	/* Enter the region with shallow history */
	if (handle->historyVector[0] != ShallowHistoryWithDeepEntry_last_state)
	{
		shallowHistoryWithDeepEntry_shenseq_main_region_Z__region0(handle);
	} else
	{
		shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_A_default(handle);
	} 
}

/* Default react sequence for initial entry  */
static void shallowHistoryWithDeepEntry_react_main_region_Z__region0_B__region0__entry_Default(ShallowHistoryWithDeepEntry* handle)
{
	/* Default react sequence for initial entry  */
	shallowHistoryWithDeepEntry_enseq_main_region_Z__region0_B__region0_C_default(handle);
}


