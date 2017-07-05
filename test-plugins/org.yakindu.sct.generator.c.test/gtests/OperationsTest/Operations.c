
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "Operations.h"
#include "OperationsRequired.h"
/*! \file Implementation of the state machine 'Operations'
*/

/* prototypes of all internal functions */
static sc_boolean operations_check_main_region_B_tr0_tr0(const Operations* handle);
static sc_boolean operations_check_main_region_C_tr0_tr0(const Operations* handle);
static sc_boolean operations_check_main_region_A_tr0_tr0(const Operations* handle);
static void operations_effect_main_region_B_tr0(Operations* handle);
static void operations_effect_main_region_C_tr0(Operations* handle);
static void operations_effect_main_region_A_tr0(Operations* handle);
static void operations_enact_main_region_B(Operations* handle);
static void operations_enact_main_region_C(Operations* handle);
static void operations_enact_main_region_D(Operations* handle);
static void operations_enseq_main_region_B_default(Operations* handle);
static void operations_enseq_main_region_C_default(Operations* handle);
static void operations_enseq_main_region_D_default(Operations* handle);
static void operations_enseq_main_region_A_default(Operations* handle);
static void operations_enseq_main_region_default(Operations* handle);
static void operations_exseq_main_region_B(Operations* handle);
static void operations_exseq_main_region_C(Operations* handle);
static void operations_exseq_main_region_D(Operations* handle);
static void operations_exseq_main_region_A(Operations* handle);
static void operations_exseq_main_region(Operations* handle);
static void operations_react_main_region_B(Operations* handle);
static void operations_react_main_region_C(Operations* handle);
static void operations_react_main_region_D(Operations* handle);
static void operations_react_main_region_A(Operations* handle);
static void operations_react_main_region__entry_Default(Operations* handle);
static void operations_clearInEvents(Operations* handle);
static void operations_clearOutEvents(Operations* handle);


void operations_init(Operations* handle)
{
	sc_integer i;

	for (i = 0; i < OPERATIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = Operations_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	operations_clearInEvents(handle);
	operations_clearOutEvents(handle);

	/* Default init sequence for statechart Operations */
	handle->internal.myBool = bool_false;

}

void operations_enter(Operations* handle)
{
	/* Default enter sequence for statechart Operations */
	operations_enseq_main_region_default(handle);
}

void operations_exit(Operations* handle)
{
	/* Default exit sequence for statechart Operations */
	operations_exseq_main_region(handle);
}

sc_boolean operations_isActive(const Operations* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < OPERATIONS_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != Operations_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean operations_isFinal(const Operations* handle)
{
   return bool_false;
}

static void operations_clearInEvents(Operations* handle)
{
	handle->iface.ev_raised = bool_false;
}

static void operations_clearOutEvents(Operations* handle)
{
}

void operations_runCycle(Operations* handle)
{
	
	operations_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < OPERATIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case Operations_main_region_B :
		{
			operations_react_main_region_B(handle);
			break;
		}
		case Operations_main_region_C :
		{
			operations_react_main_region_C(handle);
			break;
		}
		case Operations_main_region_D :
		{
			operations_react_main_region_D(handle);
			break;
		}
		case Operations_main_region_A :
		{
			operations_react_main_region_A(handle);
			break;
		}
		default:
			break;
		}
	}
	
	operations_clearInEvents(handle);
}


sc_boolean operations_isStateActive(const Operations* handle, OperationsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case Operations_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_OPERATIONS_MAIN_REGION_B] == Operations_main_region_B
			);
			break;
		case Operations_main_region_C :
			result = (sc_boolean) (handle->stateConfVector[SCVI_OPERATIONS_MAIN_REGION_C] == Operations_main_region_C
			);
			break;
		case Operations_main_region_D :
			result = (sc_boolean) (handle->stateConfVector[SCVI_OPERATIONS_MAIN_REGION_D] == Operations_main_region_D
			);
			break;
		case Operations_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_OPERATIONS_MAIN_REGION_A] == Operations_main_region_A
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}



void operationsIface_raise_ev(Operations* handle)
{
	handle->iface.ev_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean operations_check_main_region_B_tr0_tr0(const Operations* handle)
{
	return ((handle->iface.ev_raised) && (operationsIface_alwaysTrue(handle))) ? bool_true : bool_false;
}

static sc_boolean operations_check_main_region_C_tr0_tr0(const Operations* handle)
{
	return handle->iface.ev_raised;
}

static sc_boolean operations_check_main_region_A_tr0_tr0(const Operations* handle)
{
	return bool_true;
}

static void operations_effect_main_region_B_tr0(Operations* handle)
{
	operations_exseq_main_region_B(handle);
	operations_enseq_main_region_C_default(handle);
}

static void operations_effect_main_region_C_tr0(Operations* handle)
{
	operations_exseq_main_region_C(handle);
	operations_enseq_main_region_D_default(handle);
}

static void operations_effect_main_region_A_tr0(Operations* handle)
{
	operations_exseq_main_region_A(handle);
	operations_enseq_main_region_B_default(handle);
}

/* Entry action for state 'B'. */
static void operations_enact_main_region_B(Operations* handle)
{
	/* Entry action for state 'B'. */
	operationsInternal_internalOperation1(handle);
	handle->internal.myBool = operationsInternal_internalOperation2(handle, 4);
	operationsInternal_internalOperation3(handle);
	operationsInternal_internalOperation3a(handle, 1.0);
	operationsInternal_internalOperation4(handle);
	operationsInternal_internalOperation4a(handle, 5);
	operationsInternal_internalOperation5(handle);
	operationsInternal_internalOperation5a(handle, "");
}

/* Entry action for state 'C'. */
static void operations_enact_main_region_C(Operations* handle)
{
	/* Entry action for state 'C'. */
	operationsIfaceInterface1_interfaceOperation1(handle);
	operationsIfaceInterface1_interfaceOperation2(handle, 4);
	operationsIfaceInterface1_interfaceOperation3(handle);
	operationsIfaceInterface1_interfaceOperation3a(handle, 1.0);
	operationsIfaceInterface1_interfaceOperation4(handle);
	operationsIfaceInterface1_interfaceOperation4a(handle, 5);
	operationsIfaceInterface1_interfaceOperation5(handle);
	operationsIfaceInterface1_interfaceOperation5a(handle, "");
}

/* Entry action for state 'D'. */
static void operations_enact_main_region_D(Operations* handle)
{
	/* Entry action for state 'D'. */
	operationsIface_unnamedInterfaceOperation1(handle);
	operationsIface_unnamedInterfaceOperation2(handle, 4);
	operationsIface_unnamedOperation3(handle);
	operationsIface_unnamedOperation3a(handle, 1.0);
	operationsIface_unnamedOperation4(handle);
	operationsIface_unnamedOperation4a(handle, 5);
	operationsIface_unnamedOperation5(handle);
	operationsIface_unnamedOperation5a(handle, "");
}

/* 'default' enter sequence for state B */
static void operations_enseq_main_region_B_default(Operations* handle)
{
	/* 'default' enter sequence for state B */
	operations_enact_main_region_B(handle);
	handle->stateConfVector[0] = Operations_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
static void operations_enseq_main_region_C_default(Operations* handle)
{
	/* 'default' enter sequence for state C */
	operations_enact_main_region_C(handle);
	handle->stateConfVector[0] = Operations_main_region_C;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state D */
static void operations_enseq_main_region_D_default(Operations* handle)
{
	/* 'default' enter sequence for state D */
	operations_enact_main_region_D(handle);
	handle->stateConfVector[0] = Operations_main_region_D;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state A */
static void operations_enseq_main_region_A_default(Operations* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = Operations_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void operations_enseq_main_region_default(Operations* handle)
{
	/* 'default' enter sequence for region main region */
	operations_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state B */
static void operations_exseq_main_region_B(Operations* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = Operations_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
static void operations_exseq_main_region_C(Operations* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[0] = Operations_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state D */
static void operations_exseq_main_region_D(Operations* handle)
{
	/* Default exit sequence for state D */
	handle->stateConfVector[0] = Operations_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state A */
static void operations_exseq_main_region_A(Operations* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = Operations_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void operations_exseq_main_region(Operations* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of Operations.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case Operations_main_region_B :
		{
			operations_exseq_main_region_B(handle);
			break;
		}
		case Operations_main_region_C :
		{
			operations_exseq_main_region_C(handle);
			break;
		}
		case Operations_main_region_D :
		{
			operations_exseq_main_region_D(handle);
			break;
		}
		case Operations_main_region_A :
		{
			operations_exseq_main_region_A(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state B. */
static void operations_react_main_region_B(Operations* handle)
{
	/* The reactions of state B. */
	if (operations_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		operations_effect_main_region_B_tr0(handle);
	} 
}

/* The reactions of state C. */
static void operations_react_main_region_C(Operations* handle)
{
	/* The reactions of state C. */
	if (operations_check_main_region_C_tr0_tr0(handle) == bool_true)
	{ 
		operations_effect_main_region_C_tr0(handle);
	} 
}

/* The reactions of state D. */
static void operations_react_main_region_D(Operations* handle)
{
	/* The reactions of state D. */
}

/* The reactions of state A. */
static void operations_react_main_region_A(Operations* handle)
{
	/* The reactions of state A. */
	operations_effect_main_region_A_tr0(handle);
}

/* Default react sequence for initial entry  */
static void operations_react_main_region__entry_Default(Operations* handle)
{
	/* Default react sequence for initial entry  */
	operations_enseq_main_region_A_default(handle);
}


