
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "OperationsWithoutBraces.h"
#include "OperationsWithoutBracesRequired.h"
/*! \file Implementation of the state machine 'OperationsWithoutBraces'
*/

/* prototypes of all internal functions */
static sc_boolean operationsWithoutBraces_check_main_region_A_tr0_tr0(const OperationsWithoutBraces* handle);
static sc_boolean operationsWithoutBraces_check_main_region_B_tr0_tr0(const OperationsWithoutBraces* handle);
static sc_boolean operationsWithoutBraces_check_main_region_C_tr0_tr0(const OperationsWithoutBraces* handle);
static sc_boolean operationsWithoutBraces_check_another_region_A_tr0_tr0(const OperationsWithoutBraces* handle);
static sc_boolean operationsWithoutBraces_check_another_region_B_tr0_tr0(const OperationsWithoutBraces* handle);
static sc_boolean operationsWithoutBraces_check_another_region_C_tr0_tr0(const OperationsWithoutBraces* handle);
static void operationsWithoutBraces_effect_main_region_A_tr0(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_effect_main_region_B_tr0(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_effect_main_region_C_tr0(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_effect_another_region_A_tr0(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_effect_another_region_B_tr0(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_effect_another_region_C_tr0(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_enseq_main_region_A_default(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_enseq_main_region_B_default(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_enseq_main_region_C_default(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_enseq_main_region_D_default(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_enseq_another_region_A_default(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_enseq_another_region_B_default(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_enseq_another_region_C_default(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_enseq_another_region_D_default(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_enseq_main_region_default(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_enseq_another_region_default(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_exseq_main_region_A(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_exseq_main_region_B(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_exseq_main_region_C(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_exseq_main_region_D(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_exseq_another_region_A(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_exseq_another_region_B(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_exseq_another_region_C(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_exseq_another_region_D(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_exseq_main_region(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_exseq_another_region(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_react_main_region_A(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_react_main_region_B(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_react_main_region_C(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_react_main_region_D(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_react_another_region_A(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_react_another_region_B(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_react_another_region_C(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_react_another_region_D(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_react_main_region__entry_Default(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_react_another_region__entry_Default(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_clearInEvents(OperationsWithoutBraces* handle);
static void operationsWithoutBraces_clearOutEvents(OperationsWithoutBraces* handle);


void operationsWithoutBraces_init(OperationsWithoutBraces* handle)
{
	sc_integer i;

	for (i = 0; i < OPERATIONSWITHOUTBRACES_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = OperationsWithoutBraces_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	operationsWithoutBraces_clearInEvents(handle);
	operationsWithoutBraces_clearOutEvents(handle);


}

void operationsWithoutBraces_enter(OperationsWithoutBraces* handle)
{
	/* Default enter sequence for statechart OperationsWithoutBraces */
	operationsWithoutBraces_enseq_main_region_default(handle);
	operationsWithoutBraces_enseq_another_region_default(handle);
}

void operationsWithoutBraces_exit(OperationsWithoutBraces* handle)
{
	/* Default exit sequence for statechart OperationsWithoutBraces */
	operationsWithoutBraces_exseq_main_region(handle);
	operationsWithoutBraces_exseq_another_region(handle);
}

sc_boolean operationsWithoutBraces_isActive(const OperationsWithoutBraces* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != OperationsWithoutBraces_last_state || handle->stateConfVector[1] != OperationsWithoutBraces_last_state)
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
sc_boolean operationsWithoutBraces_isFinal(const OperationsWithoutBraces* handle)
{
   return bool_false;
}

static void operationsWithoutBraces_clearInEvents(OperationsWithoutBraces* handle)
{
}

static void operationsWithoutBraces_clearOutEvents(OperationsWithoutBraces* handle)
{
}

void operationsWithoutBraces_runCycle(OperationsWithoutBraces* handle)
{
	
	operationsWithoutBraces_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < OPERATIONSWITHOUTBRACES_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case OperationsWithoutBraces_main_region_A :
		{
			operationsWithoutBraces_react_main_region_A(handle);
			break;
		}
		case OperationsWithoutBraces_main_region_B :
		{
			operationsWithoutBraces_react_main_region_B(handle);
			break;
		}
		case OperationsWithoutBraces_main_region_C :
		{
			operationsWithoutBraces_react_main_region_C(handle);
			break;
		}
		case OperationsWithoutBraces_main_region_D :
		{
			operationsWithoutBraces_react_main_region_D(handle);
			break;
		}
		case OperationsWithoutBraces_another_region_A :
		{
			operationsWithoutBraces_react_another_region_A(handle);
			break;
		}
		case OperationsWithoutBraces_another_region_B :
		{
			operationsWithoutBraces_react_another_region_B(handle);
			break;
		}
		case OperationsWithoutBraces_another_region_C :
		{
			operationsWithoutBraces_react_another_region_C(handle);
			break;
		}
		case OperationsWithoutBraces_another_region_D :
		{
			operationsWithoutBraces_react_another_region_D(handle);
			break;
		}
		default:
			break;
		}
	}
	
	operationsWithoutBraces_clearInEvents(handle);
}


sc_boolean operationsWithoutBraces_isStateActive(const OperationsWithoutBraces* handle, OperationsWithoutBracesStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case OperationsWithoutBraces_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == OperationsWithoutBraces_main_region_A
			);
			break;
		case OperationsWithoutBraces_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[0] == OperationsWithoutBraces_main_region_B
			);
			break;
		case OperationsWithoutBraces_main_region_C :
			result = (sc_boolean) (handle->stateConfVector[0] == OperationsWithoutBraces_main_region_C
			);
			break;
		case OperationsWithoutBraces_main_region_D :
			result = (sc_boolean) (handle->stateConfVector[0] == OperationsWithoutBraces_main_region_D
			);
			break;
		case OperationsWithoutBraces_another_region_A :
			result = (sc_boolean) (handle->stateConfVector[1] == OperationsWithoutBraces_another_region_A
			);
			break;
		case OperationsWithoutBraces_another_region_B :
			result = (sc_boolean) (handle->stateConfVector[1] == OperationsWithoutBraces_another_region_B
			);
			break;
		case OperationsWithoutBraces_another_region_C :
			result = (sc_boolean) (handle->stateConfVector[1] == OperationsWithoutBraces_another_region_C
			);
			break;
		case OperationsWithoutBraces_another_region_D :
			result = (sc_boolean) (handle->stateConfVector[1] == OperationsWithoutBraces_another_region_D
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}




/* implementations of all internal functions */

static sc_boolean operationsWithoutBraces_check_main_region_A_tr0_tr0(const OperationsWithoutBraces* handle)
{
	return ((bool_true) && (!operationsWithoutBracesIface_myBoolOp(handle))) ? bool_true : bool_false;
}

static sc_boolean operationsWithoutBraces_check_main_region_B_tr0_tr0(const OperationsWithoutBraces* handle)
{
	return ((bool_true) && (operationsWithoutBracesIface_myIntOp(handle) == 0)) ? bool_true : bool_false;
}

static sc_boolean operationsWithoutBraces_check_main_region_C_tr0_tr0(const OperationsWithoutBraces* handle)
{
	return ((bool_true) && (operationsWithoutBracesIface_myRealOp(handle) == 0.0)) ? bool_true : bool_false;
}

static sc_boolean operationsWithoutBraces_check_another_region_A_tr0_tr0(const OperationsWithoutBraces* handle)
{
	return ((bool_true) && (!operationsWithoutBracesIface_myBoolOp(handle))) ? bool_true : bool_false;
}

static sc_boolean operationsWithoutBraces_check_another_region_B_tr0_tr0(const OperationsWithoutBraces* handle)
{
	return ((bool_true) && (operationsWithoutBracesIface_myIntOp(handle) == 0)) ? bool_true : bool_false;
}

static sc_boolean operationsWithoutBraces_check_another_region_C_tr0_tr0(const OperationsWithoutBraces* handle)
{
	return ((bool_true) && (operationsWithoutBracesIface_myRealOp(handle) == 0.0)) ? bool_true : bool_false;
}

static void operationsWithoutBraces_effect_main_region_A_tr0(OperationsWithoutBraces* handle)
{
	operationsWithoutBraces_exseq_main_region_A(handle);
	operationsWithoutBraces_enseq_main_region_B_default(handle);
}

static void operationsWithoutBraces_effect_main_region_B_tr0(OperationsWithoutBraces* handle)
{
	operationsWithoutBraces_exseq_main_region_B(handle);
	operationsWithoutBraces_enseq_main_region_C_default(handle);
}

static void operationsWithoutBraces_effect_main_region_C_tr0(OperationsWithoutBraces* handle)
{
	operationsWithoutBraces_exseq_main_region_C(handle);
	operationsWithoutBraces_enseq_main_region_D_default(handle);
}

static void operationsWithoutBraces_effect_another_region_A_tr0(OperationsWithoutBraces* handle)
{
	operationsWithoutBraces_exseq_another_region_A(handle);
	operationsWithoutBraces_enseq_another_region_B_default(handle);
}

static void operationsWithoutBraces_effect_another_region_B_tr0(OperationsWithoutBraces* handle)
{
	operationsWithoutBraces_exseq_another_region_B(handle);
	operationsWithoutBraces_enseq_another_region_C_default(handle);
}

static void operationsWithoutBraces_effect_another_region_C_tr0(OperationsWithoutBraces* handle)
{
	operationsWithoutBraces_exseq_another_region_C(handle);
	operationsWithoutBraces_enseq_another_region_D_default(handle);
}

/* 'default' enter sequence for state A */
static void operationsWithoutBraces_enseq_main_region_A_default(OperationsWithoutBraces* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = OperationsWithoutBraces_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void operationsWithoutBraces_enseq_main_region_B_default(OperationsWithoutBraces* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = OperationsWithoutBraces_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
static void operationsWithoutBraces_enseq_main_region_C_default(OperationsWithoutBraces* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[0] = OperationsWithoutBraces_main_region_C;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state D */
static void operationsWithoutBraces_enseq_main_region_D_default(OperationsWithoutBraces* handle)
{
	/* 'default' enter sequence for state D */
	handle->stateConfVector[0] = OperationsWithoutBraces_main_region_D;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state A */
static void operationsWithoutBraces_enseq_another_region_A_default(OperationsWithoutBraces* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[1] = OperationsWithoutBraces_another_region_A;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state B */
static void operationsWithoutBraces_enseq_another_region_B_default(OperationsWithoutBraces* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[1] = OperationsWithoutBraces_another_region_B;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state C */
static void operationsWithoutBraces_enseq_another_region_C_default(OperationsWithoutBraces* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[1] = OperationsWithoutBraces_another_region_C;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state D */
static void operationsWithoutBraces_enseq_another_region_D_default(OperationsWithoutBraces* handle)
{
	/* 'default' enter sequence for state D */
	handle->stateConfVector[1] = OperationsWithoutBraces_another_region_D;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region main region */
static void operationsWithoutBraces_enseq_main_region_default(OperationsWithoutBraces* handle)
{
	/* 'default' enter sequence for region main region */
	operationsWithoutBraces_react_main_region__entry_Default(handle);
}

/* 'default' enter sequence for region another region */
static void operationsWithoutBraces_enseq_another_region_default(OperationsWithoutBraces* handle)
{
	/* 'default' enter sequence for region another region */
	operationsWithoutBraces_react_another_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void operationsWithoutBraces_exseq_main_region_A(OperationsWithoutBraces* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = OperationsWithoutBraces_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void operationsWithoutBraces_exseq_main_region_B(OperationsWithoutBraces* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = OperationsWithoutBraces_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
static void operationsWithoutBraces_exseq_main_region_C(OperationsWithoutBraces* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[0] = OperationsWithoutBraces_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state D */
static void operationsWithoutBraces_exseq_main_region_D(OperationsWithoutBraces* handle)
{
	/* Default exit sequence for state D */
	handle->stateConfVector[0] = OperationsWithoutBraces_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state A */
static void operationsWithoutBraces_exseq_another_region_A(OperationsWithoutBraces* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[1] = OperationsWithoutBraces_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state B */
static void operationsWithoutBraces_exseq_another_region_B(OperationsWithoutBraces* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[1] = OperationsWithoutBraces_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state C */
static void operationsWithoutBraces_exseq_another_region_C(OperationsWithoutBraces* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[1] = OperationsWithoutBraces_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state D */
static void operationsWithoutBraces_exseq_another_region_D(OperationsWithoutBraces* handle)
{
	/* Default exit sequence for state D */
	handle->stateConfVector[1] = OperationsWithoutBraces_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for region main region */
static void operationsWithoutBraces_exseq_main_region(OperationsWithoutBraces* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of OperationsWithoutBraces.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case OperationsWithoutBraces_main_region_A :
		{
			operationsWithoutBraces_exseq_main_region_A(handle);
			break;
		}
		case OperationsWithoutBraces_main_region_B :
		{
			operationsWithoutBraces_exseq_main_region_B(handle);
			break;
		}
		case OperationsWithoutBraces_main_region_C :
		{
			operationsWithoutBraces_exseq_main_region_C(handle);
			break;
		}
		case OperationsWithoutBraces_main_region_D :
		{
			operationsWithoutBraces_exseq_main_region_D(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region another region */
static void operationsWithoutBraces_exseq_another_region(OperationsWithoutBraces* handle)
{
	/* Default exit sequence for region another region */
	/* Handle exit of all possible states (of OperationsWithoutBraces.another_region) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case OperationsWithoutBraces_another_region_A :
		{
			operationsWithoutBraces_exseq_another_region_A(handle);
			break;
		}
		case OperationsWithoutBraces_another_region_B :
		{
			operationsWithoutBraces_exseq_another_region_B(handle);
			break;
		}
		case OperationsWithoutBraces_another_region_C :
		{
			operationsWithoutBraces_exseq_another_region_C(handle);
			break;
		}
		case OperationsWithoutBraces_another_region_D :
		{
			operationsWithoutBraces_exseq_another_region_D(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void operationsWithoutBraces_react_main_region_A(OperationsWithoutBraces* handle)
{
	/* The reactions of state A. */
	if (operationsWithoutBraces_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		operationsWithoutBraces_effect_main_region_A_tr0(handle);
	} 
}

/* The reactions of state B. */
static void operationsWithoutBraces_react_main_region_B(OperationsWithoutBraces* handle)
{
	/* The reactions of state B. */
	if (operationsWithoutBraces_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		operationsWithoutBraces_effect_main_region_B_tr0(handle);
	} 
}

/* The reactions of state C. */
static void operationsWithoutBraces_react_main_region_C(OperationsWithoutBraces* handle)
{
	/* The reactions of state C. */
	if (operationsWithoutBraces_check_main_region_C_tr0_tr0(handle) == bool_true)
	{ 
		operationsWithoutBraces_effect_main_region_C_tr0(handle);
	} 
}

/* The reactions of state D. */
static void operationsWithoutBraces_react_main_region_D(OperationsWithoutBraces* handle)
{
	/* The reactions of state D. */
}

/* The reactions of state A. */
static void operationsWithoutBraces_react_another_region_A(OperationsWithoutBraces* handle)
{
	/* The reactions of state A. */
	if (operationsWithoutBraces_check_another_region_A_tr0_tr0(handle) == bool_true)
	{ 
		operationsWithoutBraces_effect_another_region_A_tr0(handle);
	} 
}

/* The reactions of state B. */
static void operationsWithoutBraces_react_another_region_B(OperationsWithoutBraces* handle)
{
	/* The reactions of state B. */
	if (operationsWithoutBraces_check_another_region_B_tr0_tr0(handle) == bool_true)
	{ 
		operationsWithoutBraces_effect_another_region_B_tr0(handle);
	} 
}

/* The reactions of state C. */
static void operationsWithoutBraces_react_another_region_C(OperationsWithoutBraces* handle)
{
	/* The reactions of state C. */
	if (operationsWithoutBraces_check_another_region_C_tr0_tr0(handle) == bool_true)
	{ 
		operationsWithoutBraces_effect_another_region_C_tr0(handle);
	} 
}

/* The reactions of state D. */
static void operationsWithoutBraces_react_another_region_D(OperationsWithoutBraces* handle)
{
}

/* Default react sequence for initial entry  */
static void operationsWithoutBraces_react_main_region__entry_Default(OperationsWithoutBraces* handle)
{
	/* Default react sequence for initial entry  */
	operationsWithoutBraces_enseq_main_region_A_default(handle);
}

/* Default react sequence for initial entry  */
static void operationsWithoutBraces_react_another_region__entry_Default(OperationsWithoutBraces* handle)
{
	/* Default react sequence for initial entry  */
	operationsWithoutBraces_enseq_another_region_A_default(handle);
}


