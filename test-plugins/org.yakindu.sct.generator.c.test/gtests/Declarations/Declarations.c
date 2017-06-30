
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "Declarations.h"
/*! \file Implementation of the state machine 'Declarations'
*/

/* prototypes of all internal functions */
static sc_boolean declarations_check_main_region_A_tr0_tr0(const Declarations* handle);
static sc_boolean declarations_check_main_region_A_tr1_tr1(const Declarations* handle);
static sc_boolean declarations_check_main_region_B_tr0_tr0(const Declarations* handle);
static sc_boolean declarations_check_main_region_B_tr1_tr1(const Declarations* handle);
static sc_boolean declarations_check_main_region_B_tr2_tr2(const Declarations* handle);
static sc_boolean declarations_check_main_region_B_tr3_tr3(const Declarations* handle);
static void declarations_effect_main_region_A_tr0(Declarations* handle);
static void declarations_effect_main_region_A_tr1(Declarations* handle);
static void declarations_effect_main_region_B_tr0(Declarations* handle);
static void declarations_effect_main_region_B_tr1(Declarations* handle);
static void declarations_effect_main_region_B_tr2(Declarations* handle);
static void declarations_effect_main_region_B_tr3(Declarations* handle);
static void declarations_enact_main_region_A(Declarations* handle);
static void declarations_enseq_main_region_A_default(Declarations* handle);
static void declarations_enseq_main_region_B_default(Declarations* handle);
static void declarations_enseq_main_region_default(Declarations* handle);
static void declarations_exseq_main_region_A(Declarations* handle);
static void declarations_exseq_main_region_B(Declarations* handle);
static void declarations_exseq_main_region(Declarations* handle);
static void declarations_react_main_region_A(Declarations* handle);
static void declarations_react_main_region_B(Declarations* handle);
static void declarations_react_main_region__entry_Default(Declarations* handle);
static void declarations_clearInEvents(Declarations* handle);
static void declarations_clearOutEvents(Declarations* handle);


void declarations_init(Declarations* handle)
{
	sc_integer i;

	for (i = 0; i < DECLARATIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = Declarations_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	declarations_clearInEvents(handle);
	declarations_clearOutEvents(handle);

	/* Default init sequence for statechart Declarations */
	handle->iface.varA = bool_false;
	handle->iface.varB = 1;
	handle->iface.varC = 1.0;
	handle->iface.varD = "myString";
	handle->iface.varE = 0x10;
	handle->ifaceIfA.varA = bool_false;
	handle->ifaceIfA.varB = 1;
	handle->ifaceIfA.varC = 1.0;
	handle->ifaceIfA.varD = "myString";
	handle->ifaceIfA.varE = 0x10;
	handle->internal.varInA = bool_false;
	handle->internal.varInB = 1;
	handle->internal.varInC = 1.0;
	handle->internal.varInD = "myString";
	handle->internal.varInE = 0x10;

}

void declarations_enter(Declarations* handle)
{
	/* Default enter sequence for statechart Declarations */
	declarations_enseq_main_region_default(handle);
}

void declarations_exit(Declarations* handle)
{
	/* Default exit sequence for statechart Declarations */
	declarations_exseq_main_region(handle);
}

sc_boolean declarations_isActive(const Declarations* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < DECLARATIONS_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != Declarations_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean declarations_isFinal(const Declarations* handle)
{
   return bool_false;
}

static void declarations_clearInEvents(Declarations* handle)
{
	handle->iface.evA_raised = bool_false;
	handle->iface.evC_raised = bool_false;
	handle->iface.evE_raised = bool_false;
	handle->ifaceIfA.evA_raised = bool_false;
	handle->ifaceIfA.evC_raised = bool_false;
	handle->ifaceIfA.evE_raised = bool_false;
	handle->internal.evInA_raised = bool_false;
	handle->internal.evInB_raised = bool_false;
	handle->internal.evInC_raised = bool_false;
	handle->internal.evInD_raised = bool_false;
	handle->internal.evInE_raised = bool_false;
	handle->internal.evInF_raised = bool_false;
}

static void declarations_clearOutEvents(Declarations* handle)
{
	handle->iface.evB_raised = bool_false;
	handle->iface.evD_raised = bool_false;
	handle->iface.evF_raised = bool_false;
	handle->ifaceIfA.evB_raised = bool_false;
	handle->ifaceIfA.evD_raised = bool_false;
	handle->ifaceIfA.evF_raised = bool_false;
}

void declarations_runCycle(Declarations* handle)
{
	
	declarations_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < DECLARATIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case Declarations_main_region_A :
		{
			declarations_react_main_region_A(handle);
			break;
		}
		case Declarations_main_region_B :
		{
			declarations_react_main_region_B(handle);
			break;
		}
		default:
			break;
		}
	}
	
	declarations_clearInEvents(handle);
}


sc_boolean declarations_isStateActive(const Declarations* handle, DeclarationsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case Declarations_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_DECLARATIONS_MAIN_REGION_A] == Declarations_main_region_A
			);
			break;
		case Declarations_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_DECLARATIONS_MAIN_REGION_B] == Declarations_main_region_B
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void declarationsIface_raise_evA(Declarations* handle)
{
	handle->iface.evA_raised = bool_true;
}
void declarationsIface_raise_evC(Declarations* handle, sc_boolean value)
{
	handle->iface.evC_value = value;
	handle->iface.evC_raised = bool_true;
}
void declarationsIface_raise_evE(Declarations* handle, sc_real value)
{
	handle->iface.evE_value = value;
	handle->iface.evE_raised = bool_true;
}

sc_boolean declarationsIface_israised_evB(const Declarations* handle)
{
	return handle->iface.evB_raised;
}
sc_boolean declarationsIface_israised_evD(const Declarations* handle)
{
	return handle->iface.evD_raised;
}
sc_integer declarationsIface_get_evD_value(const Declarations* handle)
{
	return handle->iface.evD_value;
}
sc_boolean declarationsIface_israised_evF(const Declarations* handle)
{
	return handle->iface.evF_raised;
}
sc_string declarationsIface_get_evF_value(const Declarations* handle)
{
	return handle->iface.evF_value;
}

sc_boolean declarationsIface_get_varA(const Declarations* handle)
{
	return handle->iface.varA;
}
void declarationsIface_set_varA(Declarations* handle, sc_boolean value)
{
	handle->iface.varA = value;
}
sc_integer declarationsIface_get_varB(const Declarations* handle)
{
	return handle->iface.varB;
}
void declarationsIface_set_varB(Declarations* handle, sc_integer value)
{
	handle->iface.varB = value;
}
sc_real declarationsIface_get_varC(const Declarations* handle)
{
	return handle->iface.varC;
}
void declarationsIface_set_varC(Declarations* handle, sc_real value)
{
	handle->iface.varC = value;
}
sc_string declarationsIface_get_varD(const Declarations* handle)
{
	return handle->iface.varD;
}
void declarationsIface_set_varD(Declarations* handle, sc_string value)
{
	handle->iface.varD = value;
}
sc_integer declarationsIface_get_varE(const Declarations* handle)
{
	return handle->iface.varE;
}
void declarationsIface_set_varE(Declarations* handle, sc_integer value)
{
	handle->iface.varE = value;
}
void declarationsIfaceIfA_raise_evA(Declarations* handle)
{
	handle->ifaceIfA.evA_raised = bool_true;
}
void declarationsIfaceIfA_raise_evC(Declarations* handle, sc_boolean value)
{
	handle->ifaceIfA.evC_value = value;
	handle->ifaceIfA.evC_raised = bool_true;
}
void declarationsIfaceIfA_raise_evE(Declarations* handle, sc_real value)
{
	handle->ifaceIfA.evE_value = value;
	handle->ifaceIfA.evE_raised = bool_true;
}

sc_boolean declarationsIfaceIfA_israised_evB(const Declarations* handle)
{
	return handle->ifaceIfA.evB_raised;
}
sc_boolean declarationsIfaceIfA_israised_evD(const Declarations* handle)
{
	return handle->ifaceIfA.evD_raised;
}
sc_integer declarationsIfaceIfA_get_evD_value(const Declarations* handle)
{
	return handle->ifaceIfA.evD_value;
}
sc_boolean declarationsIfaceIfA_israised_evF(const Declarations* handle)
{
	return handle->ifaceIfA.evF_raised;
}
sc_string declarationsIfaceIfA_get_evF_value(const Declarations* handle)
{
	return handle->ifaceIfA.evF_value;
}

sc_boolean declarationsIfaceIfA_get_varA(const Declarations* handle)
{
	return handle->ifaceIfA.varA;
}
void declarationsIfaceIfA_set_varA(Declarations* handle, sc_boolean value)
{
	handle->ifaceIfA.varA = value;
}
sc_integer declarationsIfaceIfA_get_varB(const Declarations* handle)
{
	return handle->ifaceIfA.varB;
}
void declarationsIfaceIfA_set_varB(Declarations* handle, sc_integer value)
{
	handle->ifaceIfA.varB = value;
}
sc_real declarationsIfaceIfA_get_varC(const Declarations* handle)
{
	return handle->ifaceIfA.varC;
}
void declarationsIfaceIfA_set_varC(Declarations* handle, sc_real value)
{
	handle->ifaceIfA.varC = value;
}
sc_string declarationsIfaceIfA_get_varD(const Declarations* handle)
{
	return handle->ifaceIfA.varD;
}
void declarationsIfaceIfA_set_varD(Declarations* handle, sc_string value)
{
	handle->ifaceIfA.varD = value;
}
sc_integer declarationsIfaceIfA_get_varE(const Declarations* handle)
{
	return handle->ifaceIfA.varE;
}
void declarationsIfaceIfA_set_varE(Declarations* handle, sc_integer value)
{
	handle->ifaceIfA.varE = value;
}

/* implementations of all internal functions */

static sc_boolean declarations_check_main_region_A_tr0_tr0(const Declarations* handle)
{
	return handle->internal.evInA_raised;
}

static sc_boolean declarations_check_main_region_A_tr1_tr1(const Declarations* handle)
{
	return handle->internal.evInC_raised;
}

static sc_boolean declarations_check_main_region_B_tr0_tr0(const Declarations* handle)
{
	return handle->internal.evInB_raised;
}

static sc_boolean declarations_check_main_region_B_tr1_tr1(const Declarations* handle)
{
	return handle->internal.evInD_raised;
}

static sc_boolean declarations_check_main_region_B_tr2_tr2(const Declarations* handle)
{
	return handle->internal.evInE_raised;
}

static sc_boolean declarations_check_main_region_B_tr3_tr3(const Declarations* handle)
{
	return handle->internal.evInF_raised;
}

static void declarations_effect_main_region_A_tr0(Declarations* handle)
{
	declarations_exseq_main_region_A(handle);
	declarations_enseq_main_region_B_default(handle);
}

static void declarations_effect_main_region_A_tr1(Declarations* handle)
{
	declarations_exseq_main_region_A(handle);
	declarations_enseq_main_region_A_default(handle);
}

static void declarations_effect_main_region_B_tr0(Declarations* handle)
{
	declarations_exseq_main_region_B(handle);
	declarations_enseq_main_region_A_default(handle);
}

static void declarations_effect_main_region_B_tr1(Declarations* handle)
{
	declarations_exseq_main_region_B(handle);
	declarations_enseq_main_region_B_default(handle);
}

static void declarations_effect_main_region_B_tr2(Declarations* handle)
{
	declarations_exseq_main_region_B(handle);
	declarations_enseq_main_region_B_default(handle);
}

static void declarations_effect_main_region_B_tr3(Declarations* handle)
{
	declarations_exseq_main_region_B(handle);
	declarations_enseq_main_region_A_default(handle);
}

/* Entry action for state 'A'. */
static void declarations_enact_main_region_A(Declarations* handle)
{
	/* Entry action for state 'A'. */
	handle->internal.varInA = bool_false;
	handle->internal.varInB = 1;
	handle->internal.varInC = 1.1;
	handle->internal.varInD = "blub";
	handle->internal.varInE = 1;
}

/* 'default' enter sequence for state A */
static void declarations_enseq_main_region_A_default(Declarations* handle)
{
	/* 'default' enter sequence for state A */
	declarations_enact_main_region_A(handle);
	handle->stateConfVector[0] = Declarations_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void declarations_enseq_main_region_B_default(Declarations* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = Declarations_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void declarations_enseq_main_region_default(Declarations* handle)
{
	/* 'default' enter sequence for region main region */
	declarations_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void declarations_exseq_main_region_A(Declarations* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = Declarations_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void declarations_exseq_main_region_B(Declarations* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = Declarations_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void declarations_exseq_main_region(Declarations* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of Declarations.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case Declarations_main_region_A :
		{
			declarations_exseq_main_region_A(handle);
			break;
		}
		case Declarations_main_region_B :
		{
			declarations_exseq_main_region_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void declarations_react_main_region_A(Declarations* handle)
{
	/* The reactions of state A. */
	if (declarations_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		declarations_effect_main_region_A_tr0(handle);
	}  else
	{
		if (declarations_check_main_region_A_tr1_tr1(handle) == bool_true)
		{ 
			declarations_effect_main_region_A_tr1(handle);
		} 
	}
}

/* The reactions of state B. */
static void declarations_react_main_region_B(Declarations* handle)
{
	/* The reactions of state B. */
	if (declarations_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		declarations_effect_main_region_B_tr0(handle);
	}  else
	{
		if (declarations_check_main_region_B_tr1_tr1(handle) == bool_true)
		{ 
			declarations_effect_main_region_B_tr1(handle);
		}  else
		{
			if (declarations_check_main_region_B_tr2_tr2(handle) == bool_true)
			{ 
				declarations_effect_main_region_B_tr2(handle);
			}  else
			{
				if (declarations_check_main_region_B_tr3_tr3(handle) == bool_true)
				{ 
					declarations_effect_main_region_B_tr3(handle);
				} 
			}
		}
	}
}

/* Default react sequence for initial entry  */
static void declarations_react_main_region__entry_Default(Declarations* handle)
{
	/* Default react sequence for initial entry  */
	declarations_enseq_main_region_A_default(handle);
}


