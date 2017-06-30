
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "CastExpressions.h"
/*! \file Implementation of the state machine 'CastExpressions'
*/

/* prototypes of all internal functions */
static sc_boolean castExpressions_check_main_region_A_tr0_tr0(const CastExpressions* handle);
static sc_boolean castExpressions_check_main_region_B_tr0_tr0(const CastExpressions* handle);
static void castExpressions_effect_main_region_A_tr0(CastExpressions* handle);
static void castExpressions_effect_main_region_B_tr0(CastExpressions* handle);
static void castExpressions_enact_main_region_B(CastExpressions* handle);
static void castExpressions_enact_main_region_C(CastExpressions* handle);
static void castExpressions_enseq_main_region_A_default(CastExpressions* handle);
static void castExpressions_enseq_main_region_B_default(CastExpressions* handle);
static void castExpressions_enseq_main_region_C_default(CastExpressions* handle);
static void castExpressions_enseq_main_region_default(CastExpressions* handle);
static void castExpressions_exseq_main_region_A(CastExpressions* handle);
static void castExpressions_exseq_main_region_B(CastExpressions* handle);
static void castExpressions_exseq_main_region_C(CastExpressions* handle);
static void castExpressions_exseq_main_region(CastExpressions* handle);
static void castExpressions_react_main_region_A(CastExpressions* handle);
static void castExpressions_react_main_region_B(CastExpressions* handle);
static void castExpressions_react_main_region_C(CastExpressions* handle);
static void castExpressions_react_main_region__entry_Default(CastExpressions* handle);
static void castExpressions_clearInEvents(CastExpressions* handle);
static void castExpressions_clearOutEvents(CastExpressions* handle);


void castExpressions_init(CastExpressions* handle)
{
	sc_integer i;

	for (i = 0; i < CASTEXPRESSIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = CastExpressions_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	castExpressions_clearInEvents(handle);
	castExpressions_clearOutEvents(handle);

	/* Default init sequence for statechart CastExpressions */
	handle->iface.realValue = (((sc_real) 5));
	handle->iface.intValue = (((sc_integer) 5.5));

}

void castExpressions_enter(CastExpressions* handle)
{
	/* Default enter sequence for statechart CastExpressions */
	castExpressions_enseq_main_region_default(handle);
}

void castExpressions_exit(CastExpressions* handle)
{
	/* Default exit sequence for statechart CastExpressions */
	castExpressions_exseq_main_region(handle);
}

sc_boolean castExpressions_isActive(const CastExpressions* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < CASTEXPRESSIONS_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != CastExpressions_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean castExpressions_isFinal(const CastExpressions* handle)
{
   return bool_false;
}

static void castExpressions_clearInEvents(CastExpressions* handle)
{
}

static void castExpressions_clearOutEvents(CastExpressions* handle)
{
}

void castExpressions_runCycle(CastExpressions* handle)
{
	
	castExpressions_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < CASTEXPRESSIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case CastExpressions_main_region_A :
		{
			castExpressions_react_main_region_A(handle);
			break;
		}
		case CastExpressions_main_region_B :
		{
			castExpressions_react_main_region_B(handle);
			break;
		}
		case CastExpressions_main_region_C :
		{
			castExpressions_react_main_region_C(handle);
			break;
		}
		default:
			break;
		}
	}
	
	castExpressions_clearInEvents(handle);
}


sc_boolean castExpressions_isStateActive(const CastExpressions* handle, CastExpressionsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case CastExpressions_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_CASTEXPRESSIONS_MAIN_REGION_A] == CastExpressions_main_region_A
			);
			break;
		case CastExpressions_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_CASTEXPRESSIONS_MAIN_REGION_B] == CastExpressions_main_region_B
			);
			break;
		case CastExpressions_main_region_C :
			result = (sc_boolean) (handle->stateConfVector[SCVI_CASTEXPRESSIONS_MAIN_REGION_C] == CastExpressions_main_region_C
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}



sc_real castExpressionsIface_get_realValue(const CastExpressions* handle)
{
	return handle->iface.realValue;
}
void castExpressionsIface_set_realValue(CastExpressions* handle, sc_real value)
{
	handle->iface.realValue = value;
}
sc_integer castExpressionsIface_get_intValue(const CastExpressions* handle)
{
	return handle->iface.intValue;
}
void castExpressionsIface_set_intValue(CastExpressions* handle, sc_integer value)
{
	handle->iface.intValue = value;
}

/* implementations of all internal functions */

static sc_boolean castExpressions_check_main_region_A_tr0_tr0(const CastExpressions* handle)
{
	return bool_true;
}

static sc_boolean castExpressions_check_main_region_B_tr0_tr0(const CastExpressions* handle)
{
	return ((bool_true) && (((sc_real) (handle->iface.realValue * 0.1)) > ((sc_integer) 1.4) && ((sc_integer) (handle->iface.realValue * handle->iface.intValue)) < ((sc_real) 100))) ? bool_true : bool_false;
}

static void castExpressions_effect_main_region_A_tr0(CastExpressions* handle)
{
	castExpressions_exseq_main_region_A(handle);
	castExpressions_enseq_main_region_B_default(handle);
}

static void castExpressions_effect_main_region_B_tr0(CastExpressions* handle)
{
	castExpressions_exseq_main_region_B(handle);
	castExpressions_enseq_main_region_C_default(handle);
}

/* Entry action for state 'B'. */
static void castExpressions_enact_main_region_B(CastExpressions* handle)
{
	/* Entry action for state 'B'. */
	handle->iface.realValue = 3 * ((sc_integer) 5.5);
}

/* Entry action for state 'C'. */
static void castExpressions_enact_main_region_C(CastExpressions* handle)
{
	/* Entry action for state 'C'. */
	handle->iface.realValue = ((sc_integer) (handle->iface.realValue * handle->iface.intValue * 10.1));
}

/* 'default' enter sequence for state A */
static void castExpressions_enseq_main_region_A_default(CastExpressions* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = CastExpressions_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void castExpressions_enseq_main_region_B_default(CastExpressions* handle)
{
	/* 'default' enter sequence for state B */
	castExpressions_enact_main_region_B(handle);
	handle->stateConfVector[0] = CastExpressions_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
static void castExpressions_enseq_main_region_C_default(CastExpressions* handle)
{
	/* 'default' enter sequence for state C */
	castExpressions_enact_main_region_C(handle);
	handle->stateConfVector[0] = CastExpressions_main_region_C;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void castExpressions_enseq_main_region_default(CastExpressions* handle)
{
	/* 'default' enter sequence for region main region */
	castExpressions_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void castExpressions_exseq_main_region_A(CastExpressions* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = CastExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void castExpressions_exseq_main_region_B(CastExpressions* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = CastExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
static void castExpressions_exseq_main_region_C(CastExpressions* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[0] = CastExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void castExpressions_exseq_main_region(CastExpressions* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of CastExpressions.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case CastExpressions_main_region_A :
		{
			castExpressions_exseq_main_region_A(handle);
			break;
		}
		case CastExpressions_main_region_B :
		{
			castExpressions_exseq_main_region_B(handle);
			break;
		}
		case CastExpressions_main_region_C :
		{
			castExpressions_exseq_main_region_C(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void castExpressions_react_main_region_A(CastExpressions* handle)
{
	/* The reactions of state A. */
	castExpressions_effect_main_region_A_tr0(handle);
}

/* The reactions of state B. */
static void castExpressions_react_main_region_B(CastExpressions* handle)
{
	/* The reactions of state B. */
	if (castExpressions_check_main_region_B_tr0_tr0(handle) == bool_true)
	{ 
		castExpressions_effect_main_region_B_tr0(handle);
	} 
}

/* The reactions of state C. */
static void castExpressions_react_main_region_C(CastExpressions* handle)
{
	/* The reactions of state C. */
}

/* Default react sequence for initial entry  */
static void castExpressions_react_main_region__entry_Default(CastExpressions* handle)
{
	/* Default react sequence for initial entry  */
	castExpressions_enseq_main_region_A_default(handle);
}


