
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "InternalEventLifeCycle.h"
/*! \file Implementation of the state machine 'InternalEventLifeCycle'
*/

/* prototypes of all internal functions */
static sc_boolean internalEventLifeCycle_check_r1_A_tr0_tr0(const InternalEventLifeCycle* handle);
static sc_boolean internalEventLifeCycle_check_r1_A_lr0_lr0(const InternalEventLifeCycle* handle);
static sc_boolean internalEventLifeCycle_check_r1_B_tr0_tr0(const InternalEventLifeCycle* handle);
static sc_boolean internalEventLifeCycle_check_r2_C_tr0_tr0(const InternalEventLifeCycle* handle);
static sc_boolean internalEventLifeCycle_check_r2_D_tr0_tr0(const InternalEventLifeCycle* handle);
static void internalEventLifeCycle_effect_r1_A_tr0(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_effect_r1_A_lr0_lr0(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_effect_r1_B_tr0(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_effect_r2_C_tr0(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_effect_r2_D_tr0(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_enseq_r1_A_default(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_enseq_r1_B_default(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_enseq_r2_C_default(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_enseq_r2_D_default(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_enseq_r1_default(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_enseq_r2_default(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_exseq_r1_A(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_exseq_r1_B(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_exseq_r2_C(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_exseq_r2_D(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_exseq_r1(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_exseq_r2(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_react_r1_A(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_react_r1_B(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_react_r2_C(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_react_r2_D(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_react_r1__entry_Default(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_react_r2__entry_Default(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_clearInEvents(InternalEventLifeCycle* handle);
static void internalEventLifeCycle_clearOutEvents(InternalEventLifeCycle* handle);


void internalEventLifeCycle_init(InternalEventLifeCycle* handle)
{
	sc_integer i;

	for (i = 0; i < INTERNALEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = InternalEventLifeCycle_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	internalEventLifeCycle_clearInEvents(handle);
	internalEventLifeCycle_clearOutEvents(handle);


}

void internalEventLifeCycle_enter(InternalEventLifeCycle* handle)
{
	/* Default enter sequence for statechart InternalEventLifeCycle */
	internalEventLifeCycle_enseq_r1_default(handle);
	internalEventLifeCycle_enseq_r2_default(handle);
}

void internalEventLifeCycle_exit(InternalEventLifeCycle* handle)
{
	/* Default exit sequence for statechart InternalEventLifeCycle */
	internalEventLifeCycle_exseq_r1(handle);
	internalEventLifeCycle_exseq_r2(handle);
}

sc_boolean internalEventLifeCycle_isActive(const InternalEventLifeCycle* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < INTERNALEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != InternalEventLifeCycle_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean internalEventLifeCycle_isFinal(const InternalEventLifeCycle* handle)
{
   return bool_false;
}

static void internalEventLifeCycle_clearInEvents(InternalEventLifeCycle* handle)
{
	handle->iface.e_raised = bool_false;
	handle->iface.f_raised = bool_false;
	handle->internal.i1_raised = bool_false;
	handle->internal.i2_raised = bool_false;
}

static void internalEventLifeCycle_clearOutEvents(InternalEventLifeCycle* handle)
{
}

void internalEventLifeCycle_runCycle(InternalEventLifeCycle* handle)
{
	
	internalEventLifeCycle_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < INTERNALEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case InternalEventLifeCycle_r1_A :
		{
			internalEventLifeCycle_react_r1_A(handle);
			break;
		}
		case InternalEventLifeCycle_r1_B :
		{
			internalEventLifeCycle_react_r1_B(handle);
			break;
		}
		case InternalEventLifeCycle_r2_C :
		{
			internalEventLifeCycle_react_r2_C(handle);
			break;
		}
		case InternalEventLifeCycle_r2_D :
		{
			internalEventLifeCycle_react_r2_D(handle);
			break;
		}
		default:
			break;
		}
	}
	
	internalEventLifeCycle_clearInEvents(handle);
}


sc_boolean internalEventLifeCycle_isStateActive(const InternalEventLifeCycle* handle, InternalEventLifeCycleStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case InternalEventLifeCycle_r1_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_INTERNALEVENTLIFECYCLE_R1_A] == InternalEventLifeCycle_r1_A
			);
			break;
		case InternalEventLifeCycle_r1_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_INTERNALEVENTLIFECYCLE_R1_B] == InternalEventLifeCycle_r1_B
			);
			break;
		case InternalEventLifeCycle_r2_C :
			result = (sc_boolean) (handle->stateConfVector[SCVI_INTERNALEVENTLIFECYCLE_R2_C] == InternalEventLifeCycle_r2_C
			);
			break;
		case InternalEventLifeCycle_r2_D :
			result = (sc_boolean) (handle->stateConfVector[SCVI_INTERNALEVENTLIFECYCLE_R2_D] == InternalEventLifeCycle_r2_D
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void internalEventLifeCycleIface_raise_e(InternalEventLifeCycle* handle)
{
	handle->iface.e_raised = bool_true;
}
void internalEventLifeCycleIface_raise_f(InternalEventLifeCycle* handle)
{
	handle->iface.f_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean internalEventLifeCycle_check_r1_A_tr0_tr0(const InternalEventLifeCycle* handle)
{
	return handle->internal.i2_raised;
}

static sc_boolean internalEventLifeCycle_check_r1_A_lr0_lr0(const InternalEventLifeCycle* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean internalEventLifeCycle_check_r1_B_tr0_tr0(const InternalEventLifeCycle* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean internalEventLifeCycle_check_r2_C_tr0_tr0(const InternalEventLifeCycle* handle)
{
	return handle->internal.i1_raised;
}

static sc_boolean internalEventLifeCycle_check_r2_D_tr0_tr0(const InternalEventLifeCycle* handle)
{
	return handle->iface.f_raised;
}

static void internalEventLifeCycle_effect_r1_A_tr0(InternalEventLifeCycle* handle)
{
	internalEventLifeCycle_exseq_r1_A(handle);
	internalEventLifeCycle_enseq_r1_B_default(handle);
}

static void internalEventLifeCycle_effect_r1_A_lr0_lr0(InternalEventLifeCycle* handle)
{
	handle->internal.i1_raised = bool_true;
}

static void internalEventLifeCycle_effect_r1_B_tr0(InternalEventLifeCycle* handle)
{
	internalEventLifeCycle_exseq_r1_B(handle);
	internalEventLifeCycle_enseq_r1_A_default(handle);
}

static void internalEventLifeCycle_effect_r2_C_tr0(InternalEventLifeCycle* handle)
{
	internalEventLifeCycle_exseq_r2_C(handle);
	internalEventLifeCycle_enseq_r2_D_default(handle);
}

static void internalEventLifeCycle_effect_r2_D_tr0(InternalEventLifeCycle* handle)
{
	internalEventLifeCycle_exseq_r2_D(handle);
	handle->internal.i2_raised = bool_true;
	internalEventLifeCycle_enseq_r2_C_default(handle);
}

/* 'default' enter sequence for state A */
static void internalEventLifeCycle_enseq_r1_A_default(InternalEventLifeCycle* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = InternalEventLifeCycle_r1_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void internalEventLifeCycle_enseq_r1_B_default(InternalEventLifeCycle* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = InternalEventLifeCycle_r1_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
static void internalEventLifeCycle_enseq_r2_C_default(InternalEventLifeCycle* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[1] = InternalEventLifeCycle_r2_C;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state D */
static void internalEventLifeCycle_enseq_r2_D_default(InternalEventLifeCycle* handle)
{
	/* 'default' enter sequence for state D */
	handle->stateConfVector[1] = InternalEventLifeCycle_r2_D;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region r1 */
static void internalEventLifeCycle_enseq_r1_default(InternalEventLifeCycle* handle)
{
	/* 'default' enter sequence for region r1 */
	internalEventLifeCycle_react_r1__entry_Default(handle);
}

/* 'default' enter sequence for region r2 */
static void internalEventLifeCycle_enseq_r2_default(InternalEventLifeCycle* handle)
{
	/* 'default' enter sequence for region r2 */
	internalEventLifeCycle_react_r2__entry_Default(handle);
}

/* Default exit sequence for state A */
static void internalEventLifeCycle_exseq_r1_A(InternalEventLifeCycle* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = InternalEventLifeCycle_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void internalEventLifeCycle_exseq_r1_B(InternalEventLifeCycle* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = InternalEventLifeCycle_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
static void internalEventLifeCycle_exseq_r2_C(InternalEventLifeCycle* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[1] = InternalEventLifeCycle_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state D */
static void internalEventLifeCycle_exseq_r2_D(InternalEventLifeCycle* handle)
{
	/* Default exit sequence for state D */
	handle->stateConfVector[1] = InternalEventLifeCycle_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for region r1 */
static void internalEventLifeCycle_exseq_r1(InternalEventLifeCycle* handle)
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of InternalEventLifeCycle.r1) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case InternalEventLifeCycle_r1_A :
		{
			internalEventLifeCycle_exseq_r1_A(handle);
			break;
		}
		case InternalEventLifeCycle_r1_B :
		{
			internalEventLifeCycle_exseq_r1_B(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r2 */
static void internalEventLifeCycle_exseq_r2(InternalEventLifeCycle* handle)
{
	/* Default exit sequence for region r2 */
	/* Handle exit of all possible states (of InternalEventLifeCycle.r2) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case InternalEventLifeCycle_r2_C :
		{
			internalEventLifeCycle_exseq_r2_C(handle);
			break;
		}
		case InternalEventLifeCycle_r2_D :
		{
			internalEventLifeCycle_exseq_r2_D(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void internalEventLifeCycle_react_r1_A(InternalEventLifeCycle* handle)
{
	/* The reactions of state A. */
	if (internalEventLifeCycle_check_r1_A_tr0_tr0(handle) == bool_true)
	{ 
		internalEventLifeCycle_effect_r1_A_tr0(handle);
	}  else
	{
		if (internalEventLifeCycle_check_r1_A_lr0_lr0(handle) == bool_true)
		{ 
			internalEventLifeCycle_effect_r1_A_lr0_lr0(handle);
		} 
	}
}

/* The reactions of state B. */
static void internalEventLifeCycle_react_r1_B(InternalEventLifeCycle* handle)
{
	/* The reactions of state B. */
	if (internalEventLifeCycle_check_r1_B_tr0_tr0(handle) == bool_true)
	{ 
		internalEventLifeCycle_effect_r1_B_tr0(handle);
	} 
}

/* The reactions of state C. */
static void internalEventLifeCycle_react_r2_C(InternalEventLifeCycle* handle)
{
	/* The reactions of state C. */
	if (internalEventLifeCycle_check_r2_C_tr0_tr0(handle) == bool_true)
	{ 
		internalEventLifeCycle_effect_r2_C_tr0(handle);
	} 
}

/* The reactions of state D. */
static void internalEventLifeCycle_react_r2_D(InternalEventLifeCycle* handle)
{
	/* The reactions of state D. */
	if (internalEventLifeCycle_check_r2_D_tr0_tr0(handle) == bool_true)
	{ 
		internalEventLifeCycle_effect_r2_D_tr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void internalEventLifeCycle_react_r1__entry_Default(InternalEventLifeCycle* handle)
{
	/* Default react sequence for initial entry  */
	internalEventLifeCycle_enseq_r1_A_default(handle);
}

/* Default react sequence for initial entry  */
static void internalEventLifeCycle_react_r2__entry_Default(InternalEventLifeCycle* handle)
{
	/* Default react sequence for initial entry  */
	internalEventLifeCycle_enseq_r2_C_default(handle);
}


