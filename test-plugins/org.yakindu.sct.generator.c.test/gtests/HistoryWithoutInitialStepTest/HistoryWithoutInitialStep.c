
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "HistoryWithoutInitialStep.h"
/*! \file Implementation of the state machine 'HistoryWithoutInitialStep'
*/

/* prototypes of all internal functions */
static sc_boolean historyWithoutInitialStep_check_main_region_A_tr0_tr0(const HistoryWithoutInitialStep* handle);
static sc_boolean historyWithoutInitialStep_check_main_region_A_tr1_tr1(const HistoryWithoutInitialStep* handle);
static sc_boolean historyWithoutInitialStep_check_main_region_B_tr0_tr0(const HistoryWithoutInitialStep* handle);
static sc_boolean historyWithoutInitialStep_check_main_region_B_r1_C_tr0_tr0(const HistoryWithoutInitialStep* handle);
static sc_boolean historyWithoutInitialStep_check_main_region_B_r1_D_tr0_tr0(const HistoryWithoutInitialStep* handle);
static sc_boolean historyWithoutInitialStep_check_main_region_B_r1_E_tr0_tr0(const HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_effect_main_region_A_tr0(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_effect_main_region_A_tr1(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_effect_main_region_B_tr0(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_effect_main_region_B_r1_C_tr0(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_effect_main_region_B_r1_D_tr0(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_effect_main_region_B_r1_E_tr0(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_enseq_main_region_A_default(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_enseq_main_region_B_default(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_enseq_main_region_B_r1_C_default(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_enseq_main_region_B_r1_D_default(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_enseq_main_region_B_r1_E_default(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_enseq_main_region_B_r1_E__region0_F_default(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_enseq_main_region_default(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_enseq_main_region_B_r1_default(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_shenseq_main_region_B_r1(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_enseq_main_region_B_r1_E__region0_default(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_exseq_main_region_A(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_exseq_main_region_B(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_exseq_main_region_B_r1_C(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_exseq_main_region_B_r1_D(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_exseq_main_region_B_r1_E(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_exseq_main_region_B_r1_E__region0_F(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_exseq_main_region(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_exseq_main_region_B_r1(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_exseq_main_region_B_r1_E__region0(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_react_main_region_A(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_react_main_region_B_r1_C(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_react_main_region_B_r1_D(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_react_main_region_B_r1_E__region0_F(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_react_main_region__entry_Default(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_react_main_region_B_r1__entry_Default(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_react_main_region_B_r1_he(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_react_main_region_B_r1_E__region0__entry_Default(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_clearInEvents(HistoryWithoutInitialStep* handle);
static void historyWithoutInitialStep_clearOutEvents(HistoryWithoutInitialStep* handle);


void historyWithoutInitialStep_init(HistoryWithoutInitialStep* handle)
{
	sc_integer i;

	for (i = 0; i < HISTORYWITHOUTINITIALSTEP_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = HistoryWithoutInitialStep_last_state;
	}
	
	for (i = 0; i < HISTORYWITHOUTINITIALSTEP_MAX_HISTORY_STATES; ++i)
	{
		handle->historyVector[i] = HistoryWithoutInitialStep_last_state;
	}
	
	handle->stateConfVectorPosition = 0;

	historyWithoutInitialStep_clearInEvents(handle);
	historyWithoutInitialStep_clearOutEvents(handle);


}

void historyWithoutInitialStep_enter(HistoryWithoutInitialStep* handle)
{
	/* Default enter sequence for statechart HistoryWithoutInitialStep */
	historyWithoutInitialStep_enseq_main_region_default(handle);
}

void historyWithoutInitialStep_exit(HistoryWithoutInitialStep* handle)
{
	/* Default exit sequence for statechart HistoryWithoutInitialStep */
	historyWithoutInitialStep_exseq_main_region(handle);
}

sc_boolean historyWithoutInitialStep_isActive(const HistoryWithoutInitialStep* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != HistoryWithoutInitialStep_last_state)
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
sc_boolean historyWithoutInitialStep_isFinal(const HistoryWithoutInitialStep* handle)
{
   return bool_false;
}

static void historyWithoutInitialStep_clearInEvents(HistoryWithoutInitialStep* handle)
{
	handle->iface.toA_raised = bool_false;
	handle->iface.toB_raised = bool_false;
	handle->iface.toHistory_raised = bool_false;
	handle->iface.next_raised = bool_false;
}

static void historyWithoutInitialStep_clearOutEvents(HistoryWithoutInitialStep* handle)
{
}

void historyWithoutInitialStep_runCycle(HistoryWithoutInitialStep* handle)
{
	
	historyWithoutInitialStep_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < HISTORYWITHOUTINITIALSTEP_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case HistoryWithoutInitialStep_main_region_A :
		{
			historyWithoutInitialStep_react_main_region_A(handle);
			break;
		}
		case HistoryWithoutInitialStep_main_region_B_r1_C :
		{
			historyWithoutInitialStep_react_main_region_B_r1_C(handle);
			break;
		}
		case HistoryWithoutInitialStep_main_region_B_r1_D :
		{
			historyWithoutInitialStep_react_main_region_B_r1_D(handle);
			break;
		}
		case HistoryWithoutInitialStep_main_region_B_r1_E__region0_F :
		{
			historyWithoutInitialStep_react_main_region_B_r1_E__region0_F(handle);
			break;
		}
		default:
			break;
		}
	}
	
	historyWithoutInitialStep_clearInEvents(handle);
}


sc_boolean historyWithoutInitialStep_isStateActive(const HistoryWithoutInitialStep* handle, HistoryWithoutInitialStepStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case HistoryWithoutInitialStep_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == HistoryWithoutInitialStep_main_region_A
			);
			break;
		case HistoryWithoutInitialStep_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[0] >= HistoryWithoutInitialStep_main_region_B
				&& handle->stateConfVector[0] <= HistoryWithoutInitialStep_main_region_B_r1_E__region0_F);
			break;
		case HistoryWithoutInitialStep_main_region_B_r1_C :
			result = (sc_boolean) (handle->stateConfVector[0] == HistoryWithoutInitialStep_main_region_B_r1_C
			);
			break;
		case HistoryWithoutInitialStep_main_region_B_r1_D :
			result = (sc_boolean) (handle->stateConfVector[0] == HistoryWithoutInitialStep_main_region_B_r1_D
			);
			break;
		case HistoryWithoutInitialStep_main_region_B_r1_E :
			result = (sc_boolean) (handle->stateConfVector[0] >= HistoryWithoutInitialStep_main_region_B_r1_E
				&& handle->stateConfVector[0] <= HistoryWithoutInitialStep_main_region_B_r1_E__region0_F);
			break;
		case HistoryWithoutInitialStep_main_region_B_r1_E__region0_F :
			result = (sc_boolean) (handle->stateConfVector[0] == HistoryWithoutInitialStep_main_region_B_r1_E__region0_F
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void historyWithoutInitialStepIface_raise_toA(HistoryWithoutInitialStep* handle)
{
	handle->iface.toA_raised = bool_true;
}
void historyWithoutInitialStepIface_raise_toB(HistoryWithoutInitialStep* handle)
{
	handle->iface.toB_raised = bool_true;
}
void historyWithoutInitialStepIface_raise_toHistory(HistoryWithoutInitialStep* handle)
{
	handle->iface.toHistory_raised = bool_true;
}
void historyWithoutInitialStepIface_raise_next(HistoryWithoutInitialStep* handle)
{
	handle->iface.next_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean historyWithoutInitialStep_check_main_region_A_tr0_tr0(const HistoryWithoutInitialStep* handle)
{
	return handle->iface.toB_raised;
}

static sc_boolean historyWithoutInitialStep_check_main_region_A_tr1_tr1(const HistoryWithoutInitialStep* handle)
{
	return handle->iface.toHistory_raised;
}

static sc_boolean historyWithoutInitialStep_check_main_region_B_tr0_tr0(const HistoryWithoutInitialStep* handle)
{
	return handle->iface.toA_raised;
}

static sc_boolean historyWithoutInitialStep_check_main_region_B_r1_C_tr0_tr0(const HistoryWithoutInitialStep* handle)
{
	return handle->iface.next_raised;
}

static sc_boolean historyWithoutInitialStep_check_main_region_B_r1_D_tr0_tr0(const HistoryWithoutInitialStep* handle)
{
	return handle->iface.next_raised;
}

static sc_boolean historyWithoutInitialStep_check_main_region_B_r1_E_tr0_tr0(const HistoryWithoutInitialStep* handle)
{
	return handle->iface.next_raised;
}

static void historyWithoutInitialStep_effect_main_region_A_tr0(HistoryWithoutInitialStep* handle)
{
	historyWithoutInitialStep_exseq_main_region_A(handle);
	historyWithoutInitialStep_enseq_main_region_B_default(handle);
}

static void historyWithoutInitialStep_effect_main_region_A_tr1(HistoryWithoutInitialStep* handle)
{
	historyWithoutInitialStep_exseq_main_region_A(handle);
	historyWithoutInitialStep_react_main_region_B_r1_he(handle);
}

static void historyWithoutInitialStep_effect_main_region_B_tr0(HistoryWithoutInitialStep* handle)
{
	historyWithoutInitialStep_exseq_main_region_B(handle);
	historyWithoutInitialStep_enseq_main_region_A_default(handle);
}

static void historyWithoutInitialStep_effect_main_region_B_r1_C_tr0(HistoryWithoutInitialStep* handle)
{
	historyWithoutInitialStep_exseq_main_region_B_r1_C(handle);
	historyWithoutInitialStep_enseq_main_region_B_r1_D_default(handle);
}

static void historyWithoutInitialStep_effect_main_region_B_r1_D_tr0(HistoryWithoutInitialStep* handle)
{
	historyWithoutInitialStep_exseq_main_region_B_r1_D(handle);
	historyWithoutInitialStep_enseq_main_region_B_r1_E_default(handle);
}

static void historyWithoutInitialStep_effect_main_region_B_r1_E_tr0(HistoryWithoutInitialStep* handle)
{
	historyWithoutInitialStep_exseq_main_region_B_r1_E(handle);
	historyWithoutInitialStep_enseq_main_region_B_r1_C_default(handle);
}

/* 'default' enter sequence for state A */
static void historyWithoutInitialStep_enseq_main_region_A_default(HistoryWithoutInitialStep* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = HistoryWithoutInitialStep_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void historyWithoutInitialStep_enseq_main_region_B_default(HistoryWithoutInitialStep* handle)
{
	/* 'default' enter sequence for state B */
	historyWithoutInitialStep_enseq_main_region_B_r1_default(handle);
}

/* 'default' enter sequence for state C */
static void historyWithoutInitialStep_enseq_main_region_B_r1_C_default(HistoryWithoutInitialStep* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[0] = HistoryWithoutInitialStep_main_region_B_r1_C;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state D */
static void historyWithoutInitialStep_enseq_main_region_B_r1_D_default(HistoryWithoutInitialStep* handle)
{
	/* 'default' enter sequence for state D */
	handle->stateConfVector[0] = HistoryWithoutInitialStep_main_region_B_r1_D;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state E */
static void historyWithoutInitialStep_enseq_main_region_B_r1_E_default(HistoryWithoutInitialStep* handle)
{
	/* 'default' enter sequence for state E */
	historyWithoutInitialStep_enseq_main_region_B_r1_E__region0_default(handle);
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state F */
static void historyWithoutInitialStep_enseq_main_region_B_r1_E__region0_F_default(HistoryWithoutInitialStep* handle)
{
	/* 'default' enter sequence for state F */
	handle->stateConfVector[0] = HistoryWithoutInitialStep_main_region_B_r1_E__region0_F;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void historyWithoutInitialStep_enseq_main_region_default(HistoryWithoutInitialStep* handle)
{
	/* 'default' enter sequence for region main region */
	historyWithoutInitialStep_react_main_region__entry_Default(handle);
}

/* 'default' enter sequence for region r1 */
static void historyWithoutInitialStep_enseq_main_region_B_r1_default(HistoryWithoutInitialStep* handle)
{
	/* 'default' enter sequence for region r1 */
	historyWithoutInitialStep_react_main_region_B_r1__entry_Default(handle);
}

/* shallow enterSequence with history in child r1 */
static void historyWithoutInitialStep_shenseq_main_region_B_r1(HistoryWithoutInitialStep* handle)
{
	/* shallow enterSequence with history in child r1 */
	/* Handle shallow history entry of r1 */
	switch(handle->historyVector[ 0 ])
	{
		case HistoryWithoutInitialStep_main_region_B_r1_C :
		{
			historyWithoutInitialStep_enseq_main_region_B_r1_C_default(handle);
			break;
		}
		case HistoryWithoutInitialStep_main_region_B_r1_D :
		{
			historyWithoutInitialStep_enseq_main_region_B_r1_D_default(handle);
			break;
		}
		case HistoryWithoutInitialStep_main_region_B_r1_E__region0_F :
		{
			historyWithoutInitialStep_enseq_main_region_B_r1_E_default(handle);
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region null */
static void historyWithoutInitialStep_enseq_main_region_B_r1_E__region0_default(HistoryWithoutInitialStep* handle)
{
	/* 'default' enter sequence for region null */
	historyWithoutInitialStep_react_main_region_B_r1_E__region0__entry_Default(handle);
}

/* Default exit sequence for state A */
static void historyWithoutInitialStep_exseq_main_region_A(HistoryWithoutInitialStep* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = HistoryWithoutInitialStep_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void historyWithoutInitialStep_exseq_main_region_B(HistoryWithoutInitialStep* handle)
{
	/* Default exit sequence for state B */
	historyWithoutInitialStep_exseq_main_region_B_r1(handle);
}

/* Default exit sequence for state C */
static void historyWithoutInitialStep_exseq_main_region_B_r1_C(HistoryWithoutInitialStep* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[0] = HistoryWithoutInitialStep_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state D */
static void historyWithoutInitialStep_exseq_main_region_B_r1_D(HistoryWithoutInitialStep* handle)
{
	/* Default exit sequence for state D */
	handle->stateConfVector[0] = HistoryWithoutInitialStep_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state E */
static void historyWithoutInitialStep_exseq_main_region_B_r1_E(HistoryWithoutInitialStep* handle)
{
	/* Default exit sequence for state E */
	historyWithoutInitialStep_exseq_main_region_B_r1_E__region0(handle);
}

/* Default exit sequence for state F */
static void historyWithoutInitialStep_exseq_main_region_B_r1_E__region0_F(HistoryWithoutInitialStep* handle)
{
	/* Default exit sequence for state F */
	handle->stateConfVector[0] = HistoryWithoutInitialStep_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void historyWithoutInitialStep_exseq_main_region(HistoryWithoutInitialStep* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of HistoryWithoutInitialStep.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case HistoryWithoutInitialStep_main_region_A :
		{
			historyWithoutInitialStep_exseq_main_region_A(handle);
			break;
		}
		case HistoryWithoutInitialStep_main_region_B_r1_C :
		{
			historyWithoutInitialStep_exseq_main_region_B_r1_C(handle);
			break;
		}
		case HistoryWithoutInitialStep_main_region_B_r1_D :
		{
			historyWithoutInitialStep_exseq_main_region_B_r1_D(handle);
			break;
		}
		case HistoryWithoutInitialStep_main_region_B_r1_E__region0_F :
		{
			historyWithoutInitialStep_exseq_main_region_B_r1_E__region0_F(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r1 */
static void historyWithoutInitialStep_exseq_main_region_B_r1(HistoryWithoutInitialStep* handle)
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of HistoryWithoutInitialStep.main_region.B.r1) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case HistoryWithoutInitialStep_main_region_B_r1_C :
		{
			historyWithoutInitialStep_exseq_main_region_B_r1_C(handle);
			break;
		}
		case HistoryWithoutInitialStep_main_region_B_r1_D :
		{
			historyWithoutInitialStep_exseq_main_region_B_r1_D(handle);
			break;
		}
		case HistoryWithoutInitialStep_main_region_B_r1_E__region0_F :
		{
			historyWithoutInitialStep_exseq_main_region_B_r1_E__region0_F(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
static void historyWithoutInitialStep_exseq_main_region_B_r1_E__region0(HistoryWithoutInitialStep* handle)
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of HistoryWithoutInitialStep.main_region.B.r1.E._region0) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case HistoryWithoutInitialStep_main_region_B_r1_E__region0_F :
		{
			historyWithoutInitialStep_exseq_main_region_B_r1_E__region0_F(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void historyWithoutInitialStep_react_main_region_A(HistoryWithoutInitialStep* handle)
{
	/* The reactions of state A. */
	if (historyWithoutInitialStep_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		historyWithoutInitialStep_effect_main_region_A_tr0(handle);
	}  else
	{
		if (historyWithoutInitialStep_check_main_region_A_tr1_tr1(handle) == bool_true)
		{ 
			historyWithoutInitialStep_effect_main_region_A_tr1(handle);
		} 
	}
}

/* The reactions of state C. */
static void historyWithoutInitialStep_react_main_region_B_r1_C(HistoryWithoutInitialStep* handle)
{
	/* The reactions of state C. */
	if (historyWithoutInitialStep_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		historyWithoutInitialStep_effect_main_region_B_tr0(handle);
	}  else
	{
		if (historyWithoutInitialStep_check_main_region_B_r1_C_tr0_tr0(handle) == bool_true)
		{ 
			historyWithoutInitialStep_effect_main_region_B_r1_C_tr0(handle);
		} 
	}
}

/* The reactions of state D. */
static void historyWithoutInitialStep_react_main_region_B_r1_D(HistoryWithoutInitialStep* handle)
{
	/* The reactions of state D. */
	if (historyWithoutInitialStep_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		historyWithoutInitialStep_effect_main_region_B_tr0(handle);
	}  else
	{
		if (historyWithoutInitialStep_check_main_region_B_r1_D_tr0_tr0(handle) == bool_true)
		{ 
			historyWithoutInitialStep_effect_main_region_B_r1_D_tr0(handle);
		} 
	}
}

/* The reactions of state F. */
static void historyWithoutInitialStep_react_main_region_B_r1_E__region0_F(HistoryWithoutInitialStep* handle)
{
	/* The reactions of state F. */
	if (historyWithoutInitialStep_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		historyWithoutInitialStep_effect_main_region_B_tr0(handle);
	}  else
	{
		if (historyWithoutInitialStep_check_main_region_B_r1_E_tr0_tr0(handle) == bool_true)
		{ 
			historyWithoutInitialStep_effect_main_region_B_r1_E_tr0(handle);
		}  else
		{
		}
	}
}

/* Default react sequence for initial entry  */
static void historyWithoutInitialStep_react_main_region__entry_Default(HistoryWithoutInitialStep* handle)
{
	/* Default react sequence for initial entry  */
	historyWithoutInitialStep_enseq_main_region_A_default(handle);
}

/* Default react sequence for initial entry  */
static void historyWithoutInitialStep_react_main_region_B_r1__entry_Default(HistoryWithoutInitialStep* handle)
{
	/* Default react sequence for initial entry  */
	historyWithoutInitialStep_enseq_main_region_B_r1_C_default(handle);
}

/* Default react sequence for shallow history entry he */
static void historyWithoutInitialStep_react_main_region_B_r1_he(HistoryWithoutInitialStep* handle)
{
	/* Default react sequence for shallow history entry he */
	/* Enter the region with shallow history */
	if (handle->historyVector[0] != HistoryWithoutInitialStep_last_state)
	{
		historyWithoutInitialStep_shenseq_main_region_B_r1(handle);
	} 
}

/* Default react sequence for initial entry  */
static void historyWithoutInitialStep_react_main_region_B_r1_E__region0__entry_Default(HistoryWithoutInitialStep* handle)
{
	/* Default react sequence for initial entry  */
	historyWithoutInitialStep_enseq_main_region_B_r1_E__region0_F_default(handle);
}


