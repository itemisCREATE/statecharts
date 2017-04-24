
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "Constants.h"
/*! \file Implementation of the state machine 'Constants'
*/

/* prototypes of all internal functions */
static sc_boolean constants_check_main_region_A_tr0_tr0(const Constants* handle);
static sc_boolean constants_check_main_region_B_tr0_tr0(const Constants* handle);
static sc_boolean constants_check_main_region_C_tr0_tr0(const Constants* handle);
static void constants_effect_main_region_A_tr0(Constants* handle);
static void constants_effect_main_region_B_tr0(Constants* handle);
static void constants_effect_main_region_C_tr0(Constants* handle);
static void constants_enact_main_region_B(Constants* handle);
static void constants_enact_main_region_C(Constants* handle);
static void constants_enseq_main_region_A_default(Constants* handle);
static void constants_enseq_main_region_B_default(Constants* handle);
static void constants_enseq_main_region_C_default(Constants* handle);
static void constants_enseq_main_region_default(Constants* handle);
static void constants_exseq_main_region_A(Constants* handle);
static void constants_exseq_main_region_B(Constants* handle);
static void constants_exseq_main_region_C(Constants* handle);
static void constants_exseq_main_region(Constants* handle);
static void constants_react_main_region_A(Constants* handle);
static void constants_react_main_region_B(Constants* handle);
static void constants_react_main_region_C(Constants* handle);
static void constants_react_main_region__entry_Default(Constants* handle);
static void constants_clearInEvents(Constants* handle);
static void constants_clearOutEvents(Constants* handle);

const sc_integer CONSTANTS_CONSTANTSIFACE_X = 10;
const sc_integer CONSTANTS_CONSTANTSIFACE_Y = 10 * 2;
const sc_string CONSTANTS_CONSTANTSIFACENAMED_Y = "Hello World";
const sc_integer CONSTANTS_CONSTANTSIFACENAMED_TWO = 2;
const sc_integer CONSTANTS_CONSTANTSINTERNAL_INTERNALCONSTANT = 5;

void constants_init(Constants* handle)
{
	sc_integer i;

	for (i = 0; i < CONSTANTS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = Constants_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	constants_clearInEvents(handle);
	constants_clearOutEvents(handle);

	/* Default init sequence for statechart Constants */
	handle->iface.result = 0;

}

void constants_enter(Constants* handle)
{
	/* Default enter sequence for statechart Constants */
	constants_enseq_main_region_default(handle);
}

void constants_exit(Constants* handle)
{
	/* Default exit sequence for statechart Constants */
	constants_exseq_main_region(handle);
}

sc_boolean constants_isActive(const Constants* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != Constants_last_state)
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
sc_boolean constants_isFinal(const Constants* handle)
{
   return bool_false;
}

static void constants_clearInEvents(Constants* handle)
{
	handle->iface.e_raised = bool_false;
	handle->iface.e2_raised = bool_false;
}

static void constants_clearOutEvents(Constants* handle)
{
}

void constants_runCycle(Constants* handle)
{
	
	constants_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < CONSTANTS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case Constants_main_region_A :
		{
			constants_react_main_region_A(handle);
			break;
		}
		case Constants_main_region_B :
		{
			constants_react_main_region_B(handle);
			break;
		}
		case Constants_main_region_C :
		{
			constants_react_main_region_C(handle);
			break;
		}
		default:
			break;
		}
	}
	
	constants_clearInEvents(handle);
}


sc_boolean constants_isStateActive(const Constants* handle, ConstantsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case Constants_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == Constants_main_region_A
			);
			break;
		case Constants_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[0] == Constants_main_region_B
			);
			break;
		case Constants_main_region_C :
			result = (sc_boolean) (handle->stateConfVector[0] == Constants_main_region_C
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void constantsIface_raise_e(Constants* handle)
{
	handle->iface.e_raised = bool_true;
}
void constantsIface_raise_e2(Constants* handle, sc_integer value)
{
	handle->iface.e2_value = value;
	handle->iface.e2_raised = bool_true;
}


const sc_integer constantsIface_get_x(const Constants* handle)
{
	return CONSTANTS_CONSTANTSIFACE_X;
}
const sc_integer constantsIface_get_y(const Constants* handle)
{
	return CONSTANTS_CONSTANTSIFACE_Y;
}
sc_integer constantsIface_get_result(const Constants* handle)
{
	return handle->iface.result;
}
void constantsIface_set_result(Constants* handle, sc_integer value)
{
	handle->iface.result = value;
}


const sc_string constantsIfaceNamed_get_y(const Constants* handle)
{
	return CONSTANTS_CONSTANTSIFACENAMED_Y;
}
const sc_integer constantsIfaceNamed_get_two(const Constants* handle)
{
	return CONSTANTS_CONSTANTSIFACENAMED_TWO;
}

/* implementations of all internal functions */

static sc_boolean constants_check_main_region_A_tr0_tr0(const Constants* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean constants_check_main_region_B_tr0_tr0(const Constants* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean constants_check_main_region_C_tr0_tr0(const Constants* handle)
{
	return handle->iface.e2_raised;
}

static void constants_effect_main_region_A_tr0(Constants* handle)
{
	constants_exseq_main_region_A(handle);
	constants_enseq_main_region_B_default(handle);
}

static void constants_effect_main_region_B_tr0(Constants* handle)
{
	constants_exseq_main_region_B(handle);
	constants_enseq_main_region_C_default(handle);
}

static void constants_effect_main_region_C_tr0(Constants* handle)
{
	constants_exseq_main_region_C(handle);
	handle->iface.result = handle->iface.e2_value * CONSTANTS_CONSTANTSIFACE_X * CONSTANTS_CONSTANTSIFACENAMED_TWO * CONSTANTS_CONSTANTSINTERNAL_INTERNALCONSTANT;
	constants_enseq_main_region_A_default(handle);
}

/* Entry action for state 'B'. */
static void constants_enact_main_region_B(Constants* handle)
{
	/* Entry action for state 'B'. */
	handle->iface.result = CONSTANTS_CONSTANTSIFACENAMED_TWO * CONSTANTS_CONSTANTSIFACE_X;
}

/* Entry action for state 'C'. */
static void constants_enact_main_region_C(Constants* handle)
{
	/* Entry action for state 'C'. */
	handle->iface.result = handle->iface.result * CONSTANTS_CONSTANTSINTERNAL_INTERNALCONSTANT;
}

/* 'default' enter sequence for state A */
static void constants_enseq_main_region_A_default(Constants* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = Constants_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void constants_enseq_main_region_B_default(Constants* handle)
{
	/* 'default' enter sequence for state B */
	constants_enact_main_region_B(handle);
	handle->stateConfVector[0] = Constants_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
static void constants_enseq_main_region_C_default(Constants* handle)
{
	/* 'default' enter sequence for state C */
	constants_enact_main_region_C(handle);
	handle->stateConfVector[0] = Constants_main_region_C;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void constants_enseq_main_region_default(Constants* handle)
{
	/* 'default' enter sequence for region main region */
	constants_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void constants_exseq_main_region_A(Constants* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = Constants_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void constants_exseq_main_region_B(Constants* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = Constants_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
static void constants_exseq_main_region_C(Constants* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[0] = Constants_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void constants_exseq_main_region(Constants* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of Constants.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case Constants_main_region_A :
		{
			constants_exseq_main_region_A(handle);
			break;
		}
		case Constants_main_region_B :
		{
			constants_exseq_main_region_B(handle);
			break;
		}
		case Constants_main_region_C :
		{
			constants_exseq_main_region_C(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void constants_react_main_region_A(Constants* handle)
{
	/* The reactions of state A. */
	if (constants_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		constants_effect_main_region_A_tr0(handle);
	} 
}

/* The reactions of state B. */
static void constants_react_main_region_B(Constants* handle)
{
	/* The reactions of state B. */
	if (constants_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		constants_effect_main_region_B_tr0(handle);
	} 
}

/* The reactions of state C. */
static void constants_react_main_region_C(Constants* handle)
{
	/* The reactions of state C. */
	if (constants_check_main_region_C_tr0_tr0(handle) == bool_true)
	{ 
		constants_effect_main_region_C_tr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void constants_react_main_region__entry_Default(Constants* handle)
{
	/* Default react sequence for initial entry  */
	constants_enseq_main_region_A_default(handle);
}


