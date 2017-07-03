
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "BitExpressions.h"
/*! \file Implementation of the state machine 'BitExpressions'
*/

/* prototypes of all internal functions */
static sc_boolean bitExpressions_check_main_region_StateA_tr0_tr0(const BitExpressions* handle);
static void bitExpressions_effect_main_region_StateA_tr0(BitExpressions* handle);
static void bitExpressions_enact_main_region_StateA(BitExpressions* handle);
static void bitExpressions_enact_main_region_StateB(BitExpressions* handle);
static void bitExpressions_enseq_main_region_StateA_default(BitExpressions* handle);
static void bitExpressions_enseq_main_region_StateB_default(BitExpressions* handle);
static void bitExpressions_enseq_main_region_default(BitExpressions* handle);
static void bitExpressions_exseq_main_region_StateA(BitExpressions* handle);
static void bitExpressions_exseq_main_region_StateB(BitExpressions* handle);
static void bitExpressions_exseq_main_region(BitExpressions* handle);
static void bitExpressions_react_main_region_StateA(BitExpressions* handle);
static void bitExpressions_react_main_region_StateB(BitExpressions* handle);
static void bitExpressions_react_main_region__entry_Default(BitExpressions* handle);
static void bitExpressions_clearInEvents(BitExpressions* handle);
static void bitExpressions_clearOutEvents(BitExpressions* handle);


void bitExpressions_init(BitExpressions* handle)
{
	sc_integer i;

	for (i = 0; i < BITEXPRESSIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = BitExpressions_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	bitExpressions_clearInEvents(handle);
	bitExpressions_clearOutEvents(handle);

	/* Default init sequence for statechart BitExpressions */
	handle->iface.myBit1 = 0;
	handle->iface.myBit2 = 0;
	handle->iface.leftBitshift = 0;
	handle->iface.rightBitshift = 0;
	handle->iface.complementBitshift = 0;
	handle->iface.bitwiseAnd = 0;
	handle->iface.bitwiseOr = 0;
	handle->iface.bitwiseXor = 0;

}

void bitExpressions_enter(BitExpressions* handle)
{
	/* Default enter sequence for statechart BitExpressions */
	bitExpressions_enseq_main_region_default(handle);
}

void bitExpressions_exit(BitExpressions* handle)
{
	/* Default exit sequence for statechart BitExpressions */
	bitExpressions_exseq_main_region(handle);
}

sc_boolean bitExpressions_isActive(const BitExpressions* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < BITEXPRESSIONS_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != BitExpressions_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean bitExpressions_isFinal(const BitExpressions* handle)
{
   return bool_false;
}

static void bitExpressions_clearInEvents(BitExpressions* handle)
{
	handle->iface.e1_raised = bool_false;
}

static void bitExpressions_clearOutEvents(BitExpressions* handle)
{
}

void bitExpressions_runCycle(BitExpressions* handle)
{
	
	bitExpressions_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < BITEXPRESSIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case BitExpressions_main_region_StateA :
		{
			bitExpressions_react_main_region_StateA(handle);
			break;
		}
		case BitExpressions_main_region_StateB :
		{
			bitExpressions_react_main_region_StateB(handle);
			break;
		}
		default:
			break;
		}
	}
	
	bitExpressions_clearInEvents(handle);
}


sc_boolean bitExpressions_isStateActive(const BitExpressions* handle, BitExpressionsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case BitExpressions_main_region_StateA :
			result = (sc_boolean) (handle->stateConfVector[SCVI_BITEXPRESSIONS_MAIN_REGION_STATEA] == BitExpressions_main_region_StateA
			);
			break;
		case BitExpressions_main_region_StateB :
			result = (sc_boolean) (handle->stateConfVector[SCVI_BITEXPRESSIONS_MAIN_REGION_STATEB] == BitExpressions_main_region_StateB
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void bitExpressionsIface_raise_e1(BitExpressions* handle)
{
	handle->iface.e1_raised = bool_true;
}


sc_integer bitExpressionsIface_get_myBit1(const BitExpressions* handle)
{
	return handle->iface.myBit1;
}
void bitExpressionsIface_set_myBit1(BitExpressions* handle, sc_integer value)
{
	handle->iface.myBit1 = value;
}
sc_integer bitExpressionsIface_get_myBit2(const BitExpressions* handle)
{
	return handle->iface.myBit2;
}
void bitExpressionsIface_set_myBit2(BitExpressions* handle, sc_integer value)
{
	handle->iface.myBit2 = value;
}
sc_integer bitExpressionsIface_get_leftBitshift(const BitExpressions* handle)
{
	return handle->iface.leftBitshift;
}
void bitExpressionsIface_set_leftBitshift(BitExpressions* handle, sc_integer value)
{
	handle->iface.leftBitshift = value;
}
sc_integer bitExpressionsIface_get_rightBitshift(const BitExpressions* handle)
{
	return handle->iface.rightBitshift;
}
void bitExpressionsIface_set_rightBitshift(BitExpressions* handle, sc_integer value)
{
	handle->iface.rightBitshift = value;
}
sc_integer bitExpressionsIface_get_complementBitshift(const BitExpressions* handle)
{
	return handle->iface.complementBitshift;
}
void bitExpressionsIface_set_complementBitshift(BitExpressions* handle, sc_integer value)
{
	handle->iface.complementBitshift = value;
}
sc_integer bitExpressionsIface_get_bitwiseAnd(const BitExpressions* handle)
{
	return handle->iface.bitwiseAnd;
}
void bitExpressionsIface_set_bitwiseAnd(BitExpressions* handle, sc_integer value)
{
	handle->iface.bitwiseAnd = value;
}
sc_integer bitExpressionsIface_get_bitwiseOr(const BitExpressions* handle)
{
	return handle->iface.bitwiseOr;
}
void bitExpressionsIface_set_bitwiseOr(BitExpressions* handle, sc_integer value)
{
	handle->iface.bitwiseOr = value;
}
sc_integer bitExpressionsIface_get_bitwiseXor(const BitExpressions* handle)
{
	return handle->iface.bitwiseXor;
}
void bitExpressionsIface_set_bitwiseXor(BitExpressions* handle, sc_integer value)
{
	handle->iface.bitwiseXor = value;
}

/* implementations of all internal functions */

static sc_boolean bitExpressions_check_main_region_StateA_tr0_tr0(const BitExpressions* handle)
{
	return handle->iface.e1_raised;
}

static void bitExpressions_effect_main_region_StateA_tr0(BitExpressions* handle)
{
	bitExpressions_exseq_main_region_StateA(handle);
	bitExpressions_enseq_main_region_StateB_default(handle);
}

/* Entry action for state 'StateA'. */
static void bitExpressions_enact_main_region_StateA(BitExpressions* handle)
{
	/* Entry action for state 'StateA'. */
	handle->iface.myBit1 = 5;
	handle->iface.myBit2 = 7;
}

/* Entry action for state 'StateB'. */
static void bitExpressions_enact_main_region_StateB(BitExpressions* handle)
{
	/* Entry action for state 'StateB'. */
	handle->iface.leftBitshift = handle->iface.myBit1 << 1;
	handle->iface.rightBitshift = handle->iface.myBit1 >> 1;
	handle->iface.complementBitshift = ~handle->iface.myBit1;
	handle->iface.bitwiseAnd = handle->iface.myBit1 & handle->iface.myBit2;
	handle->iface.bitwiseOr = handle->iface.myBit1 | handle->iface.myBit2;
	handle->iface.bitwiseXor = handle->iface.myBit1 ^ handle->iface.myBit2;
}

/* 'default' enter sequence for state StateA */
static void bitExpressions_enseq_main_region_StateA_default(BitExpressions* handle)
{
	/* 'default' enter sequence for state StateA */
	bitExpressions_enact_main_region_StateA(handle);
	handle->stateConfVector[0] = BitExpressions_main_region_StateA;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
static void bitExpressions_enseq_main_region_StateB_default(BitExpressions* handle)
{
	/* 'default' enter sequence for state StateB */
	bitExpressions_enact_main_region_StateB(handle);
	handle->stateConfVector[0] = BitExpressions_main_region_StateB;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void bitExpressions_enseq_main_region_default(BitExpressions* handle)
{
	/* 'default' enter sequence for region main region */
	bitExpressions_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state StateA */
static void bitExpressions_exseq_main_region_StateA(BitExpressions* handle)
{
	/* Default exit sequence for state StateA */
	handle->stateConfVector[0] = BitExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateB */
static void bitExpressions_exseq_main_region_StateB(BitExpressions* handle)
{
	/* Default exit sequence for state StateB */
	handle->stateConfVector[0] = BitExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void bitExpressions_exseq_main_region(BitExpressions* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of BitExpressions.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case BitExpressions_main_region_StateA :
		{
			bitExpressions_exseq_main_region_StateA(handle);
			break;
		}
		case BitExpressions_main_region_StateB :
		{
			bitExpressions_exseq_main_region_StateB(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state StateA. */
static void bitExpressions_react_main_region_StateA(BitExpressions* handle)
{
	/* The reactions of state StateA. */
	if (bitExpressions_check_main_region_StateA_tr0_tr0(handle) == bool_true)
	{ 
		bitExpressions_effect_main_region_StateA_tr0(handle);
	} 
}

/* The reactions of state StateB. */
static void bitExpressions_react_main_region_StateB(BitExpressions* handle)
{
	/* The reactions of state StateB. */
}

/* Default react sequence for initial entry  */
static void bitExpressions_react_main_region__entry_Default(BitExpressions* handle)
{
	/* Default react sequence for initial entry  */
	bitExpressions_enseq_main_region_StateA_default(handle);
}


