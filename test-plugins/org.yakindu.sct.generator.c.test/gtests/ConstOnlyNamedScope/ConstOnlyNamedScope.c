
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "ConstOnlyNamedScope.h"
/*! \file Implementation of the state machine 'ConstOnlyNamedScope'
*/

/* prototypes of all internal functions */
static sc_boolean constOnlyNamedScope_check_ConstOnlyNamedScope_main_region_A_tr0_tr0(const ConstOnlyNamedScope* handle);
static sc_boolean constOnlyNamedScope_check_ConstOnlyNamedScope_main_region_A_tr1_tr1(const ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_effect_ConstOnlyNamedScope_main_region_A_tr0(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_effect_ConstOnlyNamedScope_main_region_A_tr1(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_enseq_ConstOnlyNamedScope_main_region_A_default(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_enseq_ConstOnlyNamedScope_main_region_B_default(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_enseq_ConstOnlyNamedScope_main_region_C_default(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_enseq_ConstOnlyNamedScope_main_region_default(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region_A(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region_B(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region_C(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_react_ConstOnlyNamedScope_main_region_A(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_react_ConstOnlyNamedScope_main_region_B(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_react_ConstOnlyNamedScope_main_region_C(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_react_ConstOnlyNamedScope_main_region__entry_Default(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_clearInEvents(ConstOnlyNamedScope* handle);
static void constOnlyNamedScope_clearOutEvents(ConstOnlyNamedScope* handle);

const sc_integer CONSTONLYNAMEDSCOPE_CONSTONLYNAMEDSCOPEIFACEA_B = 1;
const sc_integer CONSTONLYNAMEDSCOPE_CONSTONLYNAMEDSCOPEIFACEA_C = 2;

void constOnlyNamedScope_init(ConstOnlyNamedScope* handle)
{
	sc_integer i;

	for (i = 0; i < CONSTONLYNAMEDSCOPE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = ConstOnlyNamedScope_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	constOnlyNamedScope_clearInEvents(handle);
	constOnlyNamedScope_clearOutEvents(handle);


}

void constOnlyNamedScope_enter(ConstOnlyNamedScope* handle)
{
	/* Default enter sequence for statechart ConstOnlyNamedScope */
	constOnlyNamedScope_enseq_ConstOnlyNamedScope_main_region_default(handle);
}

void constOnlyNamedScope_exit(ConstOnlyNamedScope* handle)
{
	/* Default exit sequence for statechart ConstOnlyNamedScope */
	constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region(handle);
}

sc_boolean constOnlyNamedScope_isActive(const ConstOnlyNamedScope* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < CONSTONLYNAMEDSCOPE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != ConstOnlyNamedScope_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean constOnlyNamedScope_isFinal(const ConstOnlyNamedScope* handle)
{
   return bool_false;
}

static void constOnlyNamedScope_clearInEvents(ConstOnlyNamedScope* handle)
{
	handle->iface.e_raised = bool_false;
}

static void constOnlyNamedScope_clearOutEvents(ConstOnlyNamedScope* handle)
{
}

void constOnlyNamedScope_runCycle(ConstOnlyNamedScope* handle)
{
	
	constOnlyNamedScope_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < CONSTONLYNAMEDSCOPE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_A :
		{
			constOnlyNamedScope_react_ConstOnlyNamedScope_main_region_A(handle);
			break;
		}
		case ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_B :
		{
			constOnlyNamedScope_react_ConstOnlyNamedScope_main_region_B(handle);
			break;
		}
		case ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_C :
		{
			constOnlyNamedScope_react_ConstOnlyNamedScope_main_region_C(handle);
			break;
		}
		default:
			break;
		}
	}
	
	constOnlyNamedScope_clearInEvents(handle);
}


sc_boolean constOnlyNamedScope_isStateActive(const ConstOnlyNamedScope* handle, ConstOnlyNamedScopeStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_CONSTONLYNAMEDSCOPE_CONSTONLYNAMEDSCOPE_MAIN_REGION_A] == ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_A
			);
			break;
		case ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_CONSTONLYNAMEDSCOPE_CONSTONLYNAMEDSCOPE_MAIN_REGION_B] == ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_B
			);
			break;
		case ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_C :
			result = (sc_boolean) (handle->stateConfVector[SCVI_CONSTONLYNAMEDSCOPE_CONSTONLYNAMEDSCOPE_MAIN_REGION_C] == ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_C
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void constOnlyNamedScopeIface_raise_e(ConstOnlyNamedScope* handle, sc_integer value)
{
	handle->iface.e_value = value;
	handle->iface.e_raised = bool_true;
}




const sc_integer constOnlyNamedScopeIfaceA_get_b(const ConstOnlyNamedScope* handle)
{
	return CONSTONLYNAMEDSCOPE_CONSTONLYNAMEDSCOPEIFACEA_B;
}
const sc_integer constOnlyNamedScopeIfaceA_get_c(const ConstOnlyNamedScope* handle)
{
	return CONSTONLYNAMEDSCOPE_CONSTONLYNAMEDSCOPEIFACEA_C;
}

/* implementations of all internal functions */

static sc_boolean constOnlyNamedScope_check_ConstOnlyNamedScope_main_region_A_tr0_tr0(const ConstOnlyNamedScope* handle)
{
	return ((handle->iface.e_raised) && (handle->iface.e_value == CONSTONLYNAMEDSCOPE_CONSTONLYNAMEDSCOPEIFACEA_B)) ? bool_true : bool_false;
}

static sc_boolean constOnlyNamedScope_check_ConstOnlyNamedScope_main_region_A_tr1_tr1(const ConstOnlyNamedScope* handle)
{
	return ((handle->iface.e_raised) && (handle->iface.e_value == CONSTONLYNAMEDSCOPE_CONSTONLYNAMEDSCOPEIFACEA_C)) ? bool_true : bool_false;
}

static void constOnlyNamedScope_effect_ConstOnlyNamedScope_main_region_A_tr0(ConstOnlyNamedScope* handle)
{
	constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region_A(handle);
	constOnlyNamedScope_enseq_ConstOnlyNamedScope_main_region_B_default(handle);
}

static void constOnlyNamedScope_effect_ConstOnlyNamedScope_main_region_A_tr1(ConstOnlyNamedScope* handle)
{
	constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region_A(handle);
	constOnlyNamedScope_enseq_ConstOnlyNamedScope_main_region_C_default(handle);
}

/* 'default' enter sequence for state A */
static void constOnlyNamedScope_enseq_ConstOnlyNamedScope_main_region_A_default(ConstOnlyNamedScope* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void constOnlyNamedScope_enseq_ConstOnlyNamedScope_main_region_B_default(ConstOnlyNamedScope* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
static void constOnlyNamedScope_enseq_ConstOnlyNamedScope_main_region_C_default(ConstOnlyNamedScope* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[0] = ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_C;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void constOnlyNamedScope_enseq_ConstOnlyNamedScope_main_region_default(ConstOnlyNamedScope* handle)
{
	/* 'default' enter sequence for region main region */
	constOnlyNamedScope_react_ConstOnlyNamedScope_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region_A(ConstOnlyNamedScope* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = ConstOnlyNamedScope_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region_B(ConstOnlyNamedScope* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = ConstOnlyNamedScope_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
static void constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region_C(ConstOnlyNamedScope* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[0] = ConstOnlyNamedScope_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region(ConstOnlyNamedScope* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of declarations.ConstOnlyNamedScope.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_A :
		{
			constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region_A(handle);
			break;
		}
		case ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_B :
		{
			constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region_B(handle);
			break;
		}
		case ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_C :
		{
			constOnlyNamedScope_exseq_ConstOnlyNamedScope_main_region_C(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void constOnlyNamedScope_react_ConstOnlyNamedScope_main_region_A(ConstOnlyNamedScope* handle)
{
	/* The reactions of state A. */
	if (constOnlyNamedScope_check_ConstOnlyNamedScope_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		constOnlyNamedScope_effect_ConstOnlyNamedScope_main_region_A_tr0(handle);
	}  else
	{
		if (constOnlyNamedScope_check_ConstOnlyNamedScope_main_region_A_tr1_tr1(handle) == bool_true)
		{ 
			constOnlyNamedScope_effect_ConstOnlyNamedScope_main_region_A_tr1(handle);
		} 
	}
}

/* The reactions of state B. */
static void constOnlyNamedScope_react_ConstOnlyNamedScope_main_region_B(ConstOnlyNamedScope* handle)
{
	/* The reactions of state B. */
}

/* The reactions of state C. */
static void constOnlyNamedScope_react_ConstOnlyNamedScope_main_region_C(ConstOnlyNamedScope* handle)
{
	/* The reactions of state C. */
}

/* Default react sequence for initial entry  */
static void constOnlyNamedScope_react_ConstOnlyNamedScope_main_region__entry_Default(ConstOnlyNamedScope* handle)
{
	/* Default react sequence for initial entry  */
	constOnlyNamedScope_enseq_ConstOnlyNamedScope_main_region_A_default(handle);
}


