
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "ConstOnlyInternalScope.h"
/*! \file Implementation of the state machine 'ConstOnlyInternalScope'
*/

/* prototypes of all internal functions */
static sc_boolean constOnlyInternalScope_check_ConstOnlyInternalScope_main_region_A_tr0_tr0(const ConstOnlyInternalScope* handle);
static sc_boolean constOnlyInternalScope_check_ConstOnlyInternalScope_main_region_A_tr1_tr1(const ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_effect_ConstOnlyInternalScope_main_region_A_tr0(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_effect_ConstOnlyInternalScope_main_region_A_tr1(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_enseq_ConstOnlyInternalScope_main_region_A_default(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_enseq_ConstOnlyInternalScope_main_region_B_default(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_enseq_ConstOnlyInternalScope_main_region_C_default(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_enseq_ConstOnlyInternalScope_main_region_default(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region_A(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region_B(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region_C(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_react_ConstOnlyInternalScope_main_region_A(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_react_ConstOnlyInternalScope_main_region_B(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_react_ConstOnlyInternalScope_main_region_C(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_react_ConstOnlyInternalScope_main_region__entry_Default(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_clearInEvents(ConstOnlyInternalScope* handle);
static void constOnlyInternalScope_clearOutEvents(ConstOnlyInternalScope* handle);

const sc_integer CONSTONLYINTERNALSCOPE_CONSTONLYINTERNALSCOPEINTERNAL_B = 1;
const sc_integer CONSTONLYINTERNALSCOPE_CONSTONLYINTERNALSCOPEINTERNAL_C = 2;

void constOnlyInternalScope_init(ConstOnlyInternalScope* handle)
{
	sc_integer i;

	for (i = 0; i < CONSTONLYINTERNALSCOPE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = ConstOnlyInternalScope_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	constOnlyInternalScope_clearInEvents(handle);
	constOnlyInternalScope_clearOutEvents(handle);


}

void constOnlyInternalScope_enter(ConstOnlyInternalScope* handle)
{
	/* Default enter sequence for statechart ConstOnlyInternalScope */
	constOnlyInternalScope_enseq_ConstOnlyInternalScope_main_region_default(handle);
}

void constOnlyInternalScope_exit(ConstOnlyInternalScope* handle)
{
	/* Default exit sequence for statechart ConstOnlyInternalScope */
	constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region(handle);
}

sc_boolean constOnlyInternalScope_isActive(const ConstOnlyInternalScope* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != ConstOnlyInternalScope_last_state)
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
sc_boolean constOnlyInternalScope_isFinal(const ConstOnlyInternalScope* handle)
{
   return bool_false;
}

static void constOnlyInternalScope_clearInEvents(ConstOnlyInternalScope* handle)
{
	handle->iface.e_raised = bool_false;
}

static void constOnlyInternalScope_clearOutEvents(ConstOnlyInternalScope* handle)
{
}

void constOnlyInternalScope_runCycle(ConstOnlyInternalScope* handle)
{
	
	constOnlyInternalScope_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < CONSTONLYINTERNALSCOPE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_A :
		{
			constOnlyInternalScope_react_ConstOnlyInternalScope_main_region_A(handle);
			break;
		}
		case ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_B :
		{
			constOnlyInternalScope_react_ConstOnlyInternalScope_main_region_B(handle);
			break;
		}
		case ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_C :
		{
			constOnlyInternalScope_react_ConstOnlyInternalScope_main_region_C(handle);
			break;
		}
		default:
			break;
		}
	}
	
	constOnlyInternalScope_clearInEvents(handle);
}


sc_boolean constOnlyInternalScope_isStateActive(const ConstOnlyInternalScope* handle, ConstOnlyInternalScopeStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_A
			);
			break;
		case ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[0] == ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_B
			);
			break;
		case ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_C :
			result = (sc_boolean) (handle->stateConfVector[0] == ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_C
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void constOnlyInternalScopeIface_raise_e(ConstOnlyInternalScope* handle, sc_integer value)
{
	handle->iface.e_value = value;
	handle->iface.e_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean constOnlyInternalScope_check_ConstOnlyInternalScope_main_region_A_tr0_tr0(const ConstOnlyInternalScope* handle)
{
	return ((handle->iface.e_raised) && (handle->iface.e_value == CONSTONLYINTERNALSCOPE_CONSTONLYINTERNALSCOPEINTERNAL_B)) ? bool_true : bool_false;
}

static sc_boolean constOnlyInternalScope_check_ConstOnlyInternalScope_main_region_A_tr1_tr1(const ConstOnlyInternalScope* handle)
{
	return ((handle->iface.e_raised) && (handle->iface.e_value == CONSTONLYINTERNALSCOPE_CONSTONLYINTERNALSCOPEINTERNAL_C)) ? bool_true : bool_false;
}

static void constOnlyInternalScope_effect_ConstOnlyInternalScope_main_region_A_tr0(ConstOnlyInternalScope* handle)
{
	constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region_A(handle);
	constOnlyInternalScope_enseq_ConstOnlyInternalScope_main_region_B_default(handle);
}

static void constOnlyInternalScope_effect_ConstOnlyInternalScope_main_region_A_tr1(ConstOnlyInternalScope* handle)
{
	constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region_A(handle);
	constOnlyInternalScope_enseq_ConstOnlyInternalScope_main_region_C_default(handle);
}

/* 'default' enter sequence for state A */
static void constOnlyInternalScope_enseq_ConstOnlyInternalScope_main_region_A_default(ConstOnlyInternalScope* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void constOnlyInternalScope_enseq_ConstOnlyInternalScope_main_region_B_default(ConstOnlyInternalScope* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
static void constOnlyInternalScope_enseq_ConstOnlyInternalScope_main_region_C_default(ConstOnlyInternalScope* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[0] = ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_C;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void constOnlyInternalScope_enseq_ConstOnlyInternalScope_main_region_default(ConstOnlyInternalScope* handle)
{
	/* 'default' enter sequence for region main region */
	constOnlyInternalScope_react_ConstOnlyInternalScope_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region_A(ConstOnlyInternalScope* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = ConstOnlyInternalScope_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region_B(ConstOnlyInternalScope* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = ConstOnlyInternalScope_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
static void constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region_C(ConstOnlyInternalScope* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[0] = ConstOnlyInternalScope_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region(ConstOnlyInternalScope* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of declarations.ConstOnlyInternalScope.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_A :
		{
			constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region_A(handle);
			break;
		}
		case ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_B :
		{
			constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region_B(handle);
			break;
		}
		case ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_C :
		{
			constOnlyInternalScope_exseq_ConstOnlyInternalScope_main_region_C(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void constOnlyInternalScope_react_ConstOnlyInternalScope_main_region_A(ConstOnlyInternalScope* handle)
{
	/* The reactions of state A. */
	if (constOnlyInternalScope_check_ConstOnlyInternalScope_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		constOnlyInternalScope_effect_ConstOnlyInternalScope_main_region_A_tr0(handle);
	}  else
	{
		if (constOnlyInternalScope_check_ConstOnlyInternalScope_main_region_A_tr1_tr1(handle) == bool_true)
		{ 
			constOnlyInternalScope_effect_ConstOnlyInternalScope_main_region_A_tr1(handle);
		} 
	}
}

/* The reactions of state B. */
static void constOnlyInternalScope_react_ConstOnlyInternalScope_main_region_B(ConstOnlyInternalScope* handle)
{
	/* The reactions of state B. */
}

/* The reactions of state C. */
static void constOnlyInternalScope_react_ConstOnlyInternalScope_main_region_C(ConstOnlyInternalScope* handle)
{
	/* The reactions of state C. */
}

/* Default react sequence for initial entry  */
static void constOnlyInternalScope_react_ConstOnlyInternalScope_main_region__entry_Default(ConstOnlyInternalScope* handle)
{
	/* Default react sequence for initial entry  */
	constOnlyInternalScope_enseq_ConstOnlyInternalScope_main_region_A_default(handle);
}


