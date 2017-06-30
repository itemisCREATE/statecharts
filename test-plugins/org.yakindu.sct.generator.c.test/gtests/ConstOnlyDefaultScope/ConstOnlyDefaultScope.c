
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "ConstOnlyDefaultScope.h"
/*! \file Implementation of the state machine 'ConstOnlyDefaultScope'
*/

/* prototypes of all internal functions */
static sc_boolean constOnlyDefaultScope_check_ConstOnlyDefaultScope_main_region_A_tr0_tr0(const ConstOnlyDefaultScope* handle);
static sc_boolean constOnlyDefaultScope_check_ConstOnlyDefaultScope_main_region_A_tr1_tr1(const ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_effect_ConstOnlyDefaultScope_main_region_A_tr0(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_effect_ConstOnlyDefaultScope_main_region_A_tr1(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_enseq_ConstOnlyDefaultScope_main_region_A_default(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_enseq_ConstOnlyDefaultScope_main_region_B_default(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_enseq_ConstOnlyDefaultScope_main_region_C_default(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_enseq_ConstOnlyDefaultScope_main_region_default(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region_A(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region_B(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region_C(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_react_ConstOnlyDefaultScope_main_region_A(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_react_ConstOnlyDefaultScope_main_region_B(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_react_ConstOnlyDefaultScope_main_region_C(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_react_ConstOnlyDefaultScope_main_region__entry_Default(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_clearInEvents(ConstOnlyDefaultScope* handle);
static void constOnlyDefaultScope_clearOutEvents(ConstOnlyDefaultScope* handle);

const sc_integer CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPEIFACE_B = 1;
const sc_integer CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPEIFACE_C = 2;

void constOnlyDefaultScope_init(ConstOnlyDefaultScope* handle)
{
	sc_integer i;

	for (i = 0; i < CONSTONLYDEFAULTSCOPE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = ConstOnlyDefaultScope_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	constOnlyDefaultScope_clearInEvents(handle);
	constOnlyDefaultScope_clearOutEvents(handle);


}

void constOnlyDefaultScope_enter(ConstOnlyDefaultScope* handle)
{
	/* Default enter sequence for statechart ConstOnlyDefaultScope */
	constOnlyDefaultScope_enseq_ConstOnlyDefaultScope_main_region_default(handle);
}

void constOnlyDefaultScope_exit(ConstOnlyDefaultScope* handle)
{
	/* Default exit sequence for statechart ConstOnlyDefaultScope */
	constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region(handle);
}

sc_boolean constOnlyDefaultScope_isActive(const ConstOnlyDefaultScope* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < CONSTONLYDEFAULTSCOPE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != ConstOnlyDefaultScope_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean constOnlyDefaultScope_isFinal(const ConstOnlyDefaultScope* handle)
{
   return bool_false;
}

static void constOnlyDefaultScope_clearInEvents(ConstOnlyDefaultScope* handle)
{
	handle->ifaceA.e_raised = bool_false;
}

static void constOnlyDefaultScope_clearOutEvents(ConstOnlyDefaultScope* handle)
{
}

void constOnlyDefaultScope_runCycle(ConstOnlyDefaultScope* handle)
{
	
	constOnlyDefaultScope_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < CONSTONLYDEFAULTSCOPE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_A :
		{
			constOnlyDefaultScope_react_ConstOnlyDefaultScope_main_region_A(handle);
			break;
		}
		case ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_B :
		{
			constOnlyDefaultScope_react_ConstOnlyDefaultScope_main_region_B(handle);
			break;
		}
		case ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_C :
		{
			constOnlyDefaultScope_react_ConstOnlyDefaultScope_main_region_C(handle);
			break;
		}
		default:
			break;
		}
	}
	
	constOnlyDefaultScope_clearInEvents(handle);
}


sc_boolean constOnlyDefaultScope_isStateActive(const ConstOnlyDefaultScope* handle, ConstOnlyDefaultScopeStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPE_MAIN_REGION_A] == ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_A
			);
			break;
		case ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPE_MAIN_REGION_B] == ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_B
			);
			break;
		case ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_C :
			result = (sc_boolean) (handle->stateConfVector[SCVI_CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPE_MAIN_REGION_C] == ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_C
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}



const sc_integer constOnlyDefaultScopeIface_get_b(const ConstOnlyDefaultScope* handle)
{
	return CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPEIFACE_B;
}
const sc_integer constOnlyDefaultScopeIface_get_c(const ConstOnlyDefaultScope* handle)
{
	return CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPEIFACE_C;
}
void constOnlyDefaultScopeIfaceA_raise_e(ConstOnlyDefaultScope* handle, sc_integer value)
{
	handle->ifaceA.e_value = value;
	handle->ifaceA.e_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean constOnlyDefaultScope_check_ConstOnlyDefaultScope_main_region_A_tr0_tr0(const ConstOnlyDefaultScope* handle)
{
	return ((handle->ifaceA.e_raised) && (handle->ifaceA.e_value == CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPEIFACE_B)) ? bool_true : bool_false;
}

static sc_boolean constOnlyDefaultScope_check_ConstOnlyDefaultScope_main_region_A_tr1_tr1(const ConstOnlyDefaultScope* handle)
{
	return ((handle->ifaceA.e_raised) && (handle->ifaceA.e_value == CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPEIFACE_C)) ? bool_true : bool_false;
}

static void constOnlyDefaultScope_effect_ConstOnlyDefaultScope_main_region_A_tr0(ConstOnlyDefaultScope* handle)
{
	constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region_A(handle);
	constOnlyDefaultScope_enseq_ConstOnlyDefaultScope_main_region_B_default(handle);
}

static void constOnlyDefaultScope_effect_ConstOnlyDefaultScope_main_region_A_tr1(ConstOnlyDefaultScope* handle)
{
	constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region_A(handle);
	constOnlyDefaultScope_enseq_ConstOnlyDefaultScope_main_region_C_default(handle);
}

/* 'default' enter sequence for state A */
static void constOnlyDefaultScope_enseq_ConstOnlyDefaultScope_main_region_A_default(ConstOnlyDefaultScope* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void constOnlyDefaultScope_enseq_ConstOnlyDefaultScope_main_region_B_default(ConstOnlyDefaultScope* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
static void constOnlyDefaultScope_enseq_ConstOnlyDefaultScope_main_region_C_default(ConstOnlyDefaultScope* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[0] = ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_C;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void constOnlyDefaultScope_enseq_ConstOnlyDefaultScope_main_region_default(ConstOnlyDefaultScope* handle)
{
	/* 'default' enter sequence for region main region */
	constOnlyDefaultScope_react_ConstOnlyDefaultScope_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region_A(ConstOnlyDefaultScope* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = ConstOnlyDefaultScope_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region_B(ConstOnlyDefaultScope* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = ConstOnlyDefaultScope_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
static void constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region_C(ConstOnlyDefaultScope* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[0] = ConstOnlyDefaultScope_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region(ConstOnlyDefaultScope* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of declarations.ConstOnlyDefaultScope.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_A :
		{
			constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region_A(handle);
			break;
		}
		case ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_B :
		{
			constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region_B(handle);
			break;
		}
		case ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_C :
		{
			constOnlyDefaultScope_exseq_ConstOnlyDefaultScope_main_region_C(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void constOnlyDefaultScope_react_ConstOnlyDefaultScope_main_region_A(ConstOnlyDefaultScope* handle)
{
	/* The reactions of state A. */
	if (constOnlyDefaultScope_check_ConstOnlyDefaultScope_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		constOnlyDefaultScope_effect_ConstOnlyDefaultScope_main_region_A_tr0(handle);
	}  else
	{
		if (constOnlyDefaultScope_check_ConstOnlyDefaultScope_main_region_A_tr1_tr1(handle) == bool_true)
		{ 
			constOnlyDefaultScope_effect_ConstOnlyDefaultScope_main_region_A_tr1(handle);
		} 
	}
}

/* The reactions of state B. */
static void constOnlyDefaultScope_react_ConstOnlyDefaultScope_main_region_B(ConstOnlyDefaultScope* handle)
{
	/* The reactions of state B. */
}

/* The reactions of state C. */
static void constOnlyDefaultScope_react_ConstOnlyDefaultScope_main_region_C(ConstOnlyDefaultScope* handle)
{
	/* The reactions of state C. */
}

/* Default react sequence for initial entry  */
static void constOnlyDefaultScope_react_ConstOnlyDefaultScope_main_region__entry_Default(ConstOnlyDefaultScope* handle)
{
	/* Default react sequence for initial entry  */
	constOnlyDefaultScope_enseq_ConstOnlyDefaultScope_main_region_A_default(handle);
}


