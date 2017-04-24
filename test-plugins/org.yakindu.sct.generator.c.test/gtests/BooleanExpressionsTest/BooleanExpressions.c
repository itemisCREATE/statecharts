
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "BooleanExpressions.h"
/*! \file Implementation of the state machine 'BooleanExpressions'
*/

/* prototypes of all internal functions */
static sc_boolean booleanExpressions_check_main_region_StateA_tr0_tr0(const BooleanExpressions* handle);
static void booleanExpressions_effect_main_region_StateA_tr0(BooleanExpressions* handle);
static void booleanExpressions_enact_main_region_StateA(BooleanExpressions* handle);
static void booleanExpressions_enact_main_region_StateB(BooleanExpressions* handle);
static void booleanExpressions_enseq_main_region_StateA_default(BooleanExpressions* handle);
static void booleanExpressions_enseq_main_region_StateB_default(BooleanExpressions* handle);
static void booleanExpressions_enseq_main_region_default(BooleanExpressions* handle);
static void booleanExpressions_exseq_main_region_StateA(BooleanExpressions* handle);
static void booleanExpressions_exseq_main_region_StateB(BooleanExpressions* handle);
static void booleanExpressions_exseq_main_region(BooleanExpressions* handle);
static void booleanExpressions_react_main_region_StateA(BooleanExpressions* handle);
static void booleanExpressions_react_main_region_StateB(BooleanExpressions* handle);
static void booleanExpressions_react_main_region__entry_Default(BooleanExpressions* handle);
static void booleanExpressions_clearInEvents(BooleanExpressions* handle);
static void booleanExpressions_clearOutEvents(BooleanExpressions* handle);


void booleanExpressions_init(BooleanExpressions* handle)
{
	sc_integer i;

	for (i = 0; i < BOOLEANEXPRESSIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = BooleanExpressions_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	booleanExpressions_clearInEvents(handle);
	booleanExpressions_clearOutEvents(handle);

	/* Default init sequence for statechart BooleanExpressions */
	handle->iface.myBool1 = bool_false;
	handle->iface.myBool2 = bool_false;
	handle->iface.and_ID = bool_false;
	handle->iface.or_ID = bool_false;
	handle->iface.not_ID = bool_false;
	handle->iface.equal = bool_false;
	handle->iface.notequal = bool_false;

}

void booleanExpressions_enter(BooleanExpressions* handle)
{
	/* Default enter sequence for statechart BooleanExpressions */
	booleanExpressions_enseq_main_region_default(handle);
}

void booleanExpressions_exit(BooleanExpressions* handle)
{
	/* Default exit sequence for statechart BooleanExpressions */
	booleanExpressions_exseq_main_region(handle);
}

sc_boolean booleanExpressions_isActive(const BooleanExpressions* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != BooleanExpressions_last_state)
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
sc_boolean booleanExpressions_isFinal(const BooleanExpressions* handle)
{
   return bool_false;
}

static void booleanExpressions_clearInEvents(BooleanExpressions* handle)
{
	handle->iface.e1_raised = bool_false;
}

static void booleanExpressions_clearOutEvents(BooleanExpressions* handle)
{
}

void booleanExpressions_runCycle(BooleanExpressions* handle)
{
	
	booleanExpressions_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < BOOLEANEXPRESSIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case BooleanExpressions_main_region_StateA :
		{
			booleanExpressions_react_main_region_StateA(handle);
			break;
		}
		case BooleanExpressions_main_region_StateB :
		{
			booleanExpressions_react_main_region_StateB(handle);
			break;
		}
		default:
			break;
		}
	}
	
	booleanExpressions_clearInEvents(handle);
}


sc_boolean booleanExpressions_isStateActive(const BooleanExpressions* handle, BooleanExpressionsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case BooleanExpressions_main_region_StateA :
			result = (sc_boolean) (handle->stateConfVector[0] == BooleanExpressions_main_region_StateA
			);
			break;
		case BooleanExpressions_main_region_StateB :
			result = (sc_boolean) (handle->stateConfVector[0] == BooleanExpressions_main_region_StateB
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void booleanExpressionsIface_raise_e1(BooleanExpressions* handle)
{
	handle->iface.e1_raised = bool_true;
}


sc_boolean booleanExpressionsIface_get_myBool1(const BooleanExpressions* handle)
{
	return handle->iface.myBool1;
}
void booleanExpressionsIface_set_myBool1(BooleanExpressions* handle, sc_boolean value)
{
	handle->iface.myBool1 = value;
}
sc_boolean booleanExpressionsIface_get_myBool2(const BooleanExpressions* handle)
{
	return handle->iface.myBool2;
}
void booleanExpressionsIface_set_myBool2(BooleanExpressions* handle, sc_boolean value)
{
	handle->iface.myBool2 = value;
}
sc_boolean booleanExpressionsIface_get_and(const BooleanExpressions* handle)
{
	return handle->iface.and_ID;
}
void booleanExpressionsIface_set_and(BooleanExpressions* handle, sc_boolean value)
{
	handle->iface.and_ID = value;
}
sc_boolean booleanExpressionsIface_get_or(const BooleanExpressions* handle)
{
	return handle->iface.or_ID;
}
void booleanExpressionsIface_set_or(BooleanExpressions* handle, sc_boolean value)
{
	handle->iface.or_ID = value;
}
sc_boolean booleanExpressionsIface_get_not(const BooleanExpressions* handle)
{
	return handle->iface.not_ID;
}
void booleanExpressionsIface_set_not(BooleanExpressions* handle, sc_boolean value)
{
	handle->iface.not_ID = value;
}
sc_boolean booleanExpressionsIface_get_equal(const BooleanExpressions* handle)
{
	return handle->iface.equal;
}
void booleanExpressionsIface_set_equal(BooleanExpressions* handle, sc_boolean value)
{
	handle->iface.equal = value;
}
sc_boolean booleanExpressionsIface_get_notequal(const BooleanExpressions* handle)
{
	return handle->iface.notequal;
}
void booleanExpressionsIface_set_notequal(BooleanExpressions* handle, sc_boolean value)
{
	handle->iface.notequal = value;
}

/* implementations of all internal functions */

static sc_boolean booleanExpressions_check_main_region_StateA_tr0_tr0(const BooleanExpressions* handle)
{
	return handle->iface.e1_raised;
}

static void booleanExpressions_effect_main_region_StateA_tr0(BooleanExpressions* handle)
{
	booleanExpressions_exseq_main_region_StateA(handle);
	booleanExpressions_enseq_main_region_StateB_default(handle);
}

/* Entry action for state 'StateA'. */
static void booleanExpressions_enact_main_region_StateA(BooleanExpressions* handle)
{
	/* Entry action for state 'StateA'. */
	handle->iface.myBool1 = bool_true;
	handle->iface.myBool2 = bool_false;
}

/* Entry action for state 'StateB'. */
static void booleanExpressions_enact_main_region_StateB(BooleanExpressions* handle)
{
	/* Entry action for state 'StateB'. */
	handle->iface.and_ID = handle->iface.myBool1 && handle->iface.myBool2;
	handle->iface.or_ID = handle->iface.myBool1 || handle->iface.myBool2;
	handle->iface.not_ID = !handle->iface.myBool1;
	handle->iface.equal = handle->iface.myBool1 == handle->iface.myBool2;
	handle->iface.notequal = (handle->iface.myBool1 != handle->iface.myBool2);
}

/* 'default' enter sequence for state StateA */
static void booleanExpressions_enseq_main_region_StateA_default(BooleanExpressions* handle)
{
	/* 'default' enter sequence for state StateA */
	booleanExpressions_enact_main_region_StateA(handle);
	handle->stateConfVector[0] = BooleanExpressions_main_region_StateA;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
static void booleanExpressions_enseq_main_region_StateB_default(BooleanExpressions* handle)
{
	/* 'default' enter sequence for state StateB */
	booleanExpressions_enact_main_region_StateB(handle);
	handle->stateConfVector[0] = BooleanExpressions_main_region_StateB;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void booleanExpressions_enseq_main_region_default(BooleanExpressions* handle)
{
	/* 'default' enter sequence for region main region */
	booleanExpressions_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state StateA */
static void booleanExpressions_exseq_main_region_StateA(BooleanExpressions* handle)
{
	/* Default exit sequence for state StateA */
	handle->stateConfVector[0] = BooleanExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateB */
static void booleanExpressions_exseq_main_region_StateB(BooleanExpressions* handle)
{
	/* Default exit sequence for state StateB */
	handle->stateConfVector[0] = BooleanExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void booleanExpressions_exseq_main_region(BooleanExpressions* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of BooleanExpressions.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case BooleanExpressions_main_region_StateA :
		{
			booleanExpressions_exseq_main_region_StateA(handle);
			break;
		}
		case BooleanExpressions_main_region_StateB :
		{
			booleanExpressions_exseq_main_region_StateB(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state StateA. */
static void booleanExpressions_react_main_region_StateA(BooleanExpressions* handle)
{
	/* The reactions of state StateA. */
	if (booleanExpressions_check_main_region_StateA_tr0_tr0(handle) == bool_true)
	{ 
		booleanExpressions_effect_main_region_StateA_tr0(handle);
	} 
}

/* The reactions of state StateB. */
static void booleanExpressions_react_main_region_StateB(BooleanExpressions* handle)
{
	/* The reactions of state StateB. */
}

/* Default react sequence for initial entry  */
static void booleanExpressions_react_main_region__entry_Default(BooleanExpressions* handle)
{
	/* Default react sequence for initial entry  */
	booleanExpressions_enseq_main_region_StateA_default(handle);
}


