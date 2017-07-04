
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "OutEventLifeCycle.h"
/*! \file Implementation of the state machine 'OutEventLifeCycle'
*/

/* prototypes of all internal functions */
static sc_boolean outEventLifeCycle_check_r1_A_tr0_tr0(const OutEventLifeCycle* handle);
static sc_boolean outEventLifeCycle_check_r1_B_lr0_lr0(const OutEventLifeCycle* handle);
static sc_boolean outEventLifeCycle_check_r2_B_lr0_lr0(const OutEventLifeCycle* handle);
static void outEventLifeCycle_effect_r1_A_tr0(OutEventLifeCycle* handle);
static void outEventLifeCycle_effect_r1_B_lr0_lr0(OutEventLifeCycle* handle);
static void outEventLifeCycle_effect_r2_B_lr0_lr0(OutEventLifeCycle* handle);
static void outEventLifeCycle_enseq_r1_A_default(OutEventLifeCycle* handle);
static void outEventLifeCycle_enseq_r1_B_default(OutEventLifeCycle* handle);
static void outEventLifeCycle_enseq_r2_B_default(OutEventLifeCycle* handle);
static void outEventLifeCycle_enseq_r1_default(OutEventLifeCycle* handle);
static void outEventLifeCycle_enseq_r2_default(OutEventLifeCycle* handle);
static void outEventLifeCycle_exseq_r1_A(OutEventLifeCycle* handle);
static void outEventLifeCycle_exseq_r1_B(OutEventLifeCycle* handle);
static void outEventLifeCycle_exseq_r2_B(OutEventLifeCycle* handle);
static void outEventLifeCycle_exseq_r1(OutEventLifeCycle* handle);
static void outEventLifeCycle_exseq_r2(OutEventLifeCycle* handle);
static void outEventLifeCycle_react_r1_A(OutEventLifeCycle* handle);
static void outEventLifeCycle_react_r1_B(OutEventLifeCycle* handle);
static void outEventLifeCycle_react_r2_B(OutEventLifeCycle* handle);
static void outEventLifeCycle_react_r1__entry_Default(OutEventLifeCycle* handle);
static void outEventLifeCycle_react_r2__entry_Default(OutEventLifeCycle* handle);
static void outEventLifeCycle_clearInEvents(OutEventLifeCycle* handle);
static void outEventLifeCycle_clearOutEvents(OutEventLifeCycle* handle);


void outEventLifeCycle_init(OutEventLifeCycle* handle)
{
	sc_integer i;

	for (i = 0; i < OUTEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = OutEventLifeCycle_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	outEventLifeCycle_clearInEvents(handle);
	outEventLifeCycle_clearOutEvents(handle);

	/* Default init sequence for statechart OutEventLifeCycle */
	handle->iface.f_available_in_cycle = bool_false;
	handle->iface.f_available_in_next_cycle = bool_false;

}

void outEventLifeCycle_enter(OutEventLifeCycle* handle)
{
	/* Default enter sequence for statechart OutEventLifeCycle */
	outEventLifeCycle_enseq_r1_default(handle);
	outEventLifeCycle_enseq_r2_default(handle);
}

void outEventLifeCycle_exit(OutEventLifeCycle* handle)
{
	/* Default exit sequence for statechart OutEventLifeCycle */
	outEventLifeCycle_exseq_r1(handle);
	outEventLifeCycle_exseq_r2(handle);
}

sc_boolean outEventLifeCycle_isActive(const OutEventLifeCycle* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < OUTEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != OutEventLifeCycle_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean outEventLifeCycle_isFinal(const OutEventLifeCycle* handle)
{
   return bool_false;
}

static void outEventLifeCycle_clearInEvents(OutEventLifeCycle* handle)
{
	handle->iface.e_raised = bool_false;
}

static void outEventLifeCycle_clearOutEvents(OutEventLifeCycle* handle)
{
	handle->iface.f_raised = bool_false;
}

void outEventLifeCycle_runCycle(OutEventLifeCycle* handle)
{
	
	outEventLifeCycle_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < OUTEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case OutEventLifeCycle_r1_A :
		{
			outEventLifeCycle_react_r1_A(handle);
			break;
		}
		case OutEventLifeCycle_r1_B :
		{
			outEventLifeCycle_react_r1_B(handle);
			break;
		}
		case OutEventLifeCycle_r2_B :
		{
			outEventLifeCycle_react_r2_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	outEventLifeCycle_clearInEvents(handle);
}


sc_boolean outEventLifeCycle_isStateActive(const OutEventLifeCycle* handle, OutEventLifeCycleStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case OutEventLifeCycle_r1_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_OUTEVENTLIFECYCLE_R1_A] == OutEventLifeCycle_r1_A
			);
			break;
		case OutEventLifeCycle_r1_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_OUTEVENTLIFECYCLE_R1_B] == OutEventLifeCycle_r1_B
			);
			break;
		case OutEventLifeCycle_r2_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_OUTEVENTLIFECYCLE_R2_B] == OutEventLifeCycle_r2_B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void outEventLifeCycleIface_raise_e(OutEventLifeCycle* handle)
{
	handle->iface.e_raised = bool_true;
}

sc_boolean outEventLifeCycleIface_israised_f(const OutEventLifeCycle* handle)
{
	return handle->iface.f_raised;
}

sc_boolean outEventLifeCycleIface_get_f_available_in_cycle(const OutEventLifeCycle* handle)
{
	return handle->iface.f_available_in_cycle;
}
void outEventLifeCycleIface_set_f_available_in_cycle(OutEventLifeCycle* handle, sc_boolean value)
{
	handle->iface.f_available_in_cycle = value;
}
sc_boolean outEventLifeCycleIface_get_f_available_in_next_cycle(const OutEventLifeCycle* handle)
{
	return handle->iface.f_available_in_next_cycle;
}
void outEventLifeCycleIface_set_f_available_in_next_cycle(OutEventLifeCycle* handle, sc_boolean value)
{
	handle->iface.f_available_in_next_cycle = value;
}

/* implementations of all internal functions */

static sc_boolean outEventLifeCycle_check_r1_A_tr0_tr0(const OutEventLifeCycle* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean outEventLifeCycle_check_r1_B_lr0_lr0(const OutEventLifeCycle* handle)
{
	return handle->iface.f_raised;
}

static sc_boolean outEventLifeCycle_check_r2_B_lr0_lr0(const OutEventLifeCycle* handle)
{
	return handle->iface.f_raised;
}

static void outEventLifeCycle_effect_r1_A_tr0(OutEventLifeCycle* handle)
{
	outEventLifeCycle_exseq_r1_A(handle);
	handle->iface.f_raised = bool_true;
	outEventLifeCycle_enseq_r1_B_default(handle);
}

static void outEventLifeCycle_effect_r1_B_lr0_lr0(OutEventLifeCycle* handle)
{
	handle->iface.f_available_in_next_cycle = bool_true;
}

static void outEventLifeCycle_effect_r2_B_lr0_lr0(OutEventLifeCycle* handle)
{
	handle->iface.f_available_in_cycle = bool_true;
}

/* 'default' enter sequence for state A */
static void outEventLifeCycle_enseq_r1_A_default(OutEventLifeCycle* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = OutEventLifeCycle_r1_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void outEventLifeCycle_enseq_r1_B_default(OutEventLifeCycle* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = OutEventLifeCycle_r1_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void outEventLifeCycle_enseq_r2_B_default(OutEventLifeCycle* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[1] = OutEventLifeCycle_r2_B;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region r1 */
static void outEventLifeCycle_enseq_r1_default(OutEventLifeCycle* handle)
{
	/* 'default' enter sequence for region r1 */
	outEventLifeCycle_react_r1__entry_Default(handle);
}

/* 'default' enter sequence for region r2 */
static void outEventLifeCycle_enseq_r2_default(OutEventLifeCycle* handle)
{
	/* 'default' enter sequence for region r2 */
	outEventLifeCycle_react_r2__entry_Default(handle);
}

/* Default exit sequence for state A */
static void outEventLifeCycle_exseq_r1_A(OutEventLifeCycle* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = OutEventLifeCycle_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void outEventLifeCycle_exseq_r1_B(OutEventLifeCycle* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = OutEventLifeCycle_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void outEventLifeCycle_exseq_r2_B(OutEventLifeCycle* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[1] = OutEventLifeCycle_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for region r1 */
static void outEventLifeCycle_exseq_r1(OutEventLifeCycle* handle)
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of OutEventLifeCycle.r1) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case OutEventLifeCycle_r1_A :
		{
			outEventLifeCycle_exseq_r1_A(handle);
			break;
		}
		case OutEventLifeCycle_r1_B :
		{
			outEventLifeCycle_exseq_r1_B(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r2 */
static void outEventLifeCycle_exseq_r2(OutEventLifeCycle* handle)
{
	/* Default exit sequence for region r2 */
	/* Handle exit of all possible states (of OutEventLifeCycle.r2) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case OutEventLifeCycle_r2_B :
		{
			outEventLifeCycle_exseq_r2_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void outEventLifeCycle_react_r1_A(OutEventLifeCycle* handle)
{
	/* The reactions of state A. */
	if (outEventLifeCycle_check_r1_A_tr0_tr0(handle) == bool_true)
	{ 
		outEventLifeCycle_effect_r1_A_tr0(handle);
	} 
}

/* The reactions of state B. */
static void outEventLifeCycle_react_r1_B(OutEventLifeCycle* handle)
{
	/* The reactions of state B. */
	if (outEventLifeCycle_check_r1_B_lr0_lr0(handle) == bool_true)
	{ 
		outEventLifeCycle_effect_r1_B_lr0_lr0(handle);
	} 
}

/* The reactions of state B. */
static void outEventLifeCycle_react_r2_B(OutEventLifeCycle* handle)
{
	/* The reactions of state B. */
	if (outEventLifeCycle_check_r2_B_lr0_lr0(handle) == bool_true)
	{ 
		outEventLifeCycle_effect_r2_B_lr0_lr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void outEventLifeCycle_react_r1__entry_Default(OutEventLifeCycle* handle)
{
	/* Default react sequence for initial entry  */
	outEventLifeCycle_enseq_r1_A_default(handle);
}

/* Default react sequence for initial entry  */
static void outEventLifeCycle_react_r2__entry_Default(OutEventLifeCycle* handle)
{
	/* Default react sequence for initial entry  */
	outEventLifeCycle_enseq_r2_B_default(handle);
}


