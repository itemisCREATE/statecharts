
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "IntegerExpressions.h"
/*! \file Implementation of the state machine 'IntegerExpressions'
*/

/* prototypes of all internal functions */
static sc_boolean integerExpressions_check_main_region_StateA_tr0_tr0(const IntegerExpressions* handle);
static void integerExpressions_effect_main_region_StateA_tr0(IntegerExpressions* handle);
static void integerExpressions_enact_main_region_StateA(IntegerExpressions* handle);
static void integerExpressions_enact_main_region_StateB(IntegerExpressions* handle);
static void integerExpressions_enseq_main_region_StateA_default(IntegerExpressions* handle);
static void integerExpressions_enseq_main_region_StateB_default(IntegerExpressions* handle);
static void integerExpressions_enseq_main_region_default(IntegerExpressions* handle);
static void integerExpressions_exseq_main_region_StateA(IntegerExpressions* handle);
static void integerExpressions_exseq_main_region_StateB(IntegerExpressions* handle);
static void integerExpressions_exseq_main_region(IntegerExpressions* handle);
static void integerExpressions_react_main_region_StateA(IntegerExpressions* handle);
static void integerExpressions_react_main_region_StateB(IntegerExpressions* handle);
static void integerExpressions_react_main_region__entry_Default(IntegerExpressions* handle);
static void integerExpressions_clearInEvents(IntegerExpressions* handle);
static void integerExpressions_clearOutEvents(IntegerExpressions* handle);


void integerExpressions_init(IntegerExpressions* handle)
{
	sc_integer i;

	for (i = 0; i < INTEGEREXPRESSIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = IntegerExpressions_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	integerExpressions_clearInEvents(handle);
	integerExpressions_clearOutEvents(handle);

	/* Default init sequence for statechart IntegerExpressions */
	handle->iface.myInt1 = 0;
	handle->iface.myInt2 = 0;
	handle->iface.less = bool_false;
	handle->iface.greater = bool_false;
	handle->iface.equalOrLess = bool_false;
	handle->iface.equalOrGreater = bool_false;
	handle->iface.equal = bool_false;
	handle->iface.notEqual = bool_false;
	handle->iface.plus = 0;
	handle->iface.minus = 0;
	handle->iface.multiply = 0;
	handle->iface.division = 0;
	handle->iface.modulo = 0;
	handle->iface.negat = 0;
	handle->iface.complement = bool_false;
	handle->iface.multiAssign = 2;
	handle->iface.divAssign = 20;
	handle->iface.plusAssign = 2;
	handle->iface.minusAssign = 2;
	handle->iface.moduloAssign = 20;

}

void integerExpressions_enter(IntegerExpressions* handle)
{
	/* Default enter sequence for statechart IntegerExpressions */
	integerExpressions_enseq_main_region_default(handle);
}

void integerExpressions_exit(IntegerExpressions* handle)
{
	/* Default exit sequence for statechart IntegerExpressions */
	integerExpressions_exseq_main_region(handle);
}

sc_boolean integerExpressions_isActive(const IntegerExpressions* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != IntegerExpressions_last_state)
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
sc_boolean integerExpressions_isFinal(const IntegerExpressions* handle)
{
   return bool_false;
}

static void integerExpressions_clearInEvents(IntegerExpressions* handle)
{
	handle->iface.e1_raised = bool_false;
}

static void integerExpressions_clearOutEvents(IntegerExpressions* handle)
{
}

void integerExpressions_runCycle(IntegerExpressions* handle)
{
	
	integerExpressions_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < INTEGEREXPRESSIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case IntegerExpressions_main_region_StateA :
		{
			integerExpressions_react_main_region_StateA(handle);
			break;
		}
		case IntegerExpressions_main_region_StateB :
		{
			integerExpressions_react_main_region_StateB(handle);
			break;
		}
		default:
			break;
		}
	}
	
	integerExpressions_clearInEvents(handle);
}


sc_boolean integerExpressions_isStateActive(const IntegerExpressions* handle, IntegerExpressionsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case IntegerExpressions_main_region_StateA :
			result = (sc_boolean) (handle->stateConfVector[0] == IntegerExpressions_main_region_StateA
			);
			break;
		case IntegerExpressions_main_region_StateB :
			result = (sc_boolean) (handle->stateConfVector[0] == IntegerExpressions_main_region_StateB
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void integerExpressionsIface_raise_e1(IntegerExpressions* handle)
{
	handle->iface.e1_raised = bool_true;
}


sc_integer integerExpressionsIface_get_myInt1(const IntegerExpressions* handle)
{
	return handle->iface.myInt1;
}
void integerExpressionsIface_set_myInt1(IntegerExpressions* handle, sc_integer value)
{
	handle->iface.myInt1 = value;
}
sc_integer integerExpressionsIface_get_myInt2(const IntegerExpressions* handle)
{
	return handle->iface.myInt2;
}
void integerExpressionsIface_set_myInt2(IntegerExpressions* handle, sc_integer value)
{
	handle->iface.myInt2 = value;
}
sc_boolean integerExpressionsIface_get_less(const IntegerExpressions* handle)
{
	return handle->iface.less;
}
void integerExpressionsIface_set_less(IntegerExpressions* handle, sc_boolean value)
{
	handle->iface.less = value;
}
sc_boolean integerExpressionsIface_get_greater(const IntegerExpressions* handle)
{
	return handle->iface.greater;
}
void integerExpressionsIface_set_greater(IntegerExpressions* handle, sc_boolean value)
{
	handle->iface.greater = value;
}
sc_boolean integerExpressionsIface_get_equalOrLess(const IntegerExpressions* handle)
{
	return handle->iface.equalOrLess;
}
void integerExpressionsIface_set_equalOrLess(IntegerExpressions* handle, sc_boolean value)
{
	handle->iface.equalOrLess = value;
}
sc_boolean integerExpressionsIface_get_equalOrGreater(const IntegerExpressions* handle)
{
	return handle->iface.equalOrGreater;
}
void integerExpressionsIface_set_equalOrGreater(IntegerExpressions* handle, sc_boolean value)
{
	handle->iface.equalOrGreater = value;
}
sc_boolean integerExpressionsIface_get_equal(const IntegerExpressions* handle)
{
	return handle->iface.equal;
}
void integerExpressionsIface_set_equal(IntegerExpressions* handle, sc_boolean value)
{
	handle->iface.equal = value;
}
sc_boolean integerExpressionsIface_get_notEqual(const IntegerExpressions* handle)
{
	return handle->iface.notEqual;
}
void integerExpressionsIface_set_notEqual(IntegerExpressions* handle, sc_boolean value)
{
	handle->iface.notEqual = value;
}
sc_integer integerExpressionsIface_get_plus(const IntegerExpressions* handle)
{
	return handle->iface.plus;
}
void integerExpressionsIface_set_plus(IntegerExpressions* handle, sc_integer value)
{
	handle->iface.plus = value;
}
sc_integer integerExpressionsIface_get_minus(const IntegerExpressions* handle)
{
	return handle->iface.minus;
}
void integerExpressionsIface_set_minus(IntegerExpressions* handle, sc_integer value)
{
	handle->iface.minus = value;
}
sc_integer integerExpressionsIface_get_multiply(const IntegerExpressions* handle)
{
	return handle->iface.multiply;
}
void integerExpressionsIface_set_multiply(IntegerExpressions* handle, sc_integer value)
{
	handle->iface.multiply = value;
}
sc_integer integerExpressionsIface_get_division(const IntegerExpressions* handle)
{
	return handle->iface.division;
}
void integerExpressionsIface_set_division(IntegerExpressions* handle, sc_integer value)
{
	handle->iface.division = value;
}
sc_integer integerExpressionsIface_get_modulo(const IntegerExpressions* handle)
{
	return handle->iface.modulo;
}
void integerExpressionsIface_set_modulo(IntegerExpressions* handle, sc_integer value)
{
	handle->iface.modulo = value;
}
sc_integer integerExpressionsIface_get_negat(const IntegerExpressions* handle)
{
	return handle->iface.negat;
}
void integerExpressionsIface_set_negat(IntegerExpressions* handle, sc_integer value)
{
	handle->iface.negat = value;
}
sc_boolean integerExpressionsIface_get_complement(const IntegerExpressions* handle)
{
	return handle->iface.complement;
}
void integerExpressionsIface_set_complement(IntegerExpressions* handle, sc_boolean value)
{
	handle->iface.complement = value;
}
sc_integer integerExpressionsIface_get_multiAssign(const IntegerExpressions* handle)
{
	return handle->iface.multiAssign;
}
void integerExpressionsIface_set_multiAssign(IntegerExpressions* handle, sc_integer value)
{
	handle->iface.multiAssign = value;
}
sc_integer integerExpressionsIface_get_divAssign(const IntegerExpressions* handle)
{
	return handle->iface.divAssign;
}
void integerExpressionsIface_set_divAssign(IntegerExpressions* handle, sc_integer value)
{
	handle->iface.divAssign = value;
}
sc_integer integerExpressionsIface_get_plusAssign(const IntegerExpressions* handle)
{
	return handle->iface.plusAssign;
}
void integerExpressionsIface_set_plusAssign(IntegerExpressions* handle, sc_integer value)
{
	handle->iface.plusAssign = value;
}
sc_integer integerExpressionsIface_get_minusAssign(const IntegerExpressions* handle)
{
	return handle->iface.minusAssign;
}
void integerExpressionsIface_set_minusAssign(IntegerExpressions* handle, sc_integer value)
{
	handle->iface.minusAssign = value;
}
sc_integer integerExpressionsIface_get_moduloAssign(const IntegerExpressions* handle)
{
	return handle->iface.moduloAssign;
}
void integerExpressionsIface_set_moduloAssign(IntegerExpressions* handle, sc_integer value)
{
	handle->iface.moduloAssign = value;
}

/* implementations of all internal functions */

static sc_boolean integerExpressions_check_main_region_StateA_tr0_tr0(const IntegerExpressions* handle)
{
	return handle->iface.e1_raised;
}

static void integerExpressions_effect_main_region_StateA_tr0(IntegerExpressions* handle)
{
	integerExpressions_exseq_main_region_StateA(handle);
	integerExpressions_enseq_main_region_StateB_default(handle);
}

/* Entry action for state 'StateA'. */
static void integerExpressions_enact_main_region_StateA(IntegerExpressions* handle)
{
	/* Entry action for state 'StateA'. */
	handle->iface.myInt1 = 10;
	handle->iface.myInt2 = 5;
}

/* Entry action for state 'StateB'. */
static void integerExpressions_enact_main_region_StateB(IntegerExpressions* handle)
{
	/* Entry action for state 'StateB'. */
	handle->iface.less = (handle->iface.myInt1 < handle->iface.myInt2);
	handle->iface.greater = (handle->iface.myInt1 > handle->iface.myInt2);
	handle->iface.equalOrLess = (handle->iface.myInt1 <= handle->iface.myInt2);
	handle->iface.equalOrGreater = (handle->iface.myInt1 >= handle->iface.myInt2);
	handle->iface.equal = (handle->iface.myInt1 == handle->iface.myInt2);
	handle->iface.notEqual = (handle->iface.myInt1 != handle->iface.myInt2);
	handle->iface.plus = handle->iface.myInt1 + handle->iface.myInt2;
	handle->iface.minus = handle->iface.myInt1 - handle->iface.myInt2;
	handle->iface.multiply = handle->iface.myInt1 * handle->iface.myInt2;
	handle->iface.division = handle->iface.myInt1 / handle->iface.myInt2;
	handle->iface.modulo = handle->iface.myInt1 % handle->iface.myInt2;
	handle->iface.negat = -handle->iface.myInt1;
	handle->iface.multiAssign *= handle->iface.myInt1;
	handle->iface.divAssign /= handle->iface.myInt1;
	handle->iface.plusAssign += handle->iface.myInt1;
	handle->iface.minusAssign -= handle->iface.myInt1;
	handle->iface.moduloAssign %= handle->iface.myInt1;
}

/* 'default' enter sequence for state StateA */
static void integerExpressions_enseq_main_region_StateA_default(IntegerExpressions* handle)
{
	/* 'default' enter sequence for state StateA */
	integerExpressions_enact_main_region_StateA(handle);
	handle->stateConfVector[0] = IntegerExpressions_main_region_StateA;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
static void integerExpressions_enseq_main_region_StateB_default(IntegerExpressions* handle)
{
	/* 'default' enter sequence for state StateB */
	integerExpressions_enact_main_region_StateB(handle);
	handle->stateConfVector[0] = IntegerExpressions_main_region_StateB;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void integerExpressions_enseq_main_region_default(IntegerExpressions* handle)
{
	/* 'default' enter sequence for region main region */
	integerExpressions_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state StateA */
static void integerExpressions_exseq_main_region_StateA(IntegerExpressions* handle)
{
	/* Default exit sequence for state StateA */
	handle->stateConfVector[0] = IntegerExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateB */
static void integerExpressions_exseq_main_region_StateB(IntegerExpressions* handle)
{
	/* Default exit sequence for state StateB */
	handle->stateConfVector[0] = IntegerExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void integerExpressions_exseq_main_region(IntegerExpressions* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of IntegerExpressions.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case IntegerExpressions_main_region_StateA :
		{
			integerExpressions_exseq_main_region_StateA(handle);
			break;
		}
		case IntegerExpressions_main_region_StateB :
		{
			integerExpressions_exseq_main_region_StateB(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state StateA. */
static void integerExpressions_react_main_region_StateA(IntegerExpressions* handle)
{
	/* The reactions of state StateA. */
	if (integerExpressions_check_main_region_StateA_tr0_tr0(handle) == bool_true)
	{ 
		integerExpressions_effect_main_region_StateA_tr0(handle);
	} 
}

/* The reactions of state StateB. */
static void integerExpressions_react_main_region_StateB(IntegerExpressions* handle)
{
	/* The reactions of state StateB. */
}

/* Default react sequence for initial entry  */
static void integerExpressions_react_main_region__entry_Default(IntegerExpressions* handle)
{
	/* Default react sequence for initial entry  */
	integerExpressions_enseq_main_region_StateA_default(handle);
}


