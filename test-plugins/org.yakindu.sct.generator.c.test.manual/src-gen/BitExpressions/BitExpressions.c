#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "BitExpressions.h"
#include "BitExpressionsRequired.h"

/*! \file Implementation of the state machine 'BitExpressions'
*/

// prototypes of all internal functions

static void bitExpressions_entryaction(BitExpressions* handle);
static void bitExpressions_exitaction(BitExpressions* handle);
static void bitExpressions_react_main_region_StateA(BitExpressions* handle);
static void bitExpressions_react_main_region_StateB(BitExpressions* handle);
static void clearInEvents(BitExpressions* handle);
static void clearOutEvents(BitExpressions* handle);


void bitExpressions_init(BitExpressions* handle)
{
	int i;

	for (i = 0; i < BITEXPRESSIONS_MAX_ORTHOGONAL_STATES; ++i)
		handle->stateConfVector[i] = BitExpressions_last_state;
	
	
	handle->stateConfVectorPosition = 0;

	// TODO: initialize all events ...
	// TODO: initialize all variables ... (set default values - here or inenter sequence ?!?)

}

void bitExpressions_enter(BitExpressions* handle)
{
	/* Default enter sequence for statechart BitExpressions */
	bitExpressions_entryaction(handle);
	/* Default enter sequence for region main region */
	/* Default react sequence for initial entry  */
	/* Default enter sequence for state StateA */
	/* Entry action for state 'StateA'. */
	handle->iface.myBit1 = 5;
	handle->iface.myBit2 = 7;
	handle->stateConfVector[0] = BitExpressions_main_region_StateA;
	handle->stateConfVectorPosition = 0;
}

void bitExpressions_exit(BitExpressions* handle)
{
	/* Default exit sequence for statechart BitExpressions */
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of main region) at position 0... */
	switch(handle->stateConfVector[ 0 ]) {
		case BitExpressions_main_region_StateA : {
			/* Default exit sequence for state StateA */
			handle->stateConfVector[0] = BitExpressions_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case BitExpressions_main_region_StateB : {
			/* Default exit sequence for state StateB */
			handle->stateConfVector[0] = BitExpressions_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		default: break;
	}
	bitExpressions_exitaction(handle);
}

static void clearInEvents(BitExpressions* handle) {
	handle->iface.e1_raised = bool_false;
}

static void clearOutEvents(BitExpressions* handle) {
}

void bitExpressions_runCycle(BitExpressions* handle) {
	
	clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < BITEXPRESSIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++) {
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition]) {
		case BitExpressions_main_region_StateA : {
			bitExpressions_react_main_region_StateA(handle);
			break;
		}
		case BitExpressions_main_region_StateB : {
			bitExpressions_react_main_region_StateB(handle);
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents(handle);
}


sc_boolean bitExpressions_isActive(BitExpressions* handle, BitExpressionsStates state) {
	switch (state) {
		case BitExpressions_main_region_StateA : 
			return (sc_boolean) (handle->stateConfVector[0] == BitExpressions_main_region_StateA
			);
		case BitExpressions_main_region_StateB : 
			return (sc_boolean) (handle->stateConfVector[0] == BitExpressions_main_region_StateB
			);
		default: return bool_false;
	}
}

void bitExpressionsIface_raise_e1(BitExpressions* handle) {
	handle->iface.e1_raised = bool_true;
}


sc_integer bitExpressionsIface_get_myBit1(BitExpressions* handle) {
	return handle->iface.myBit1;
}
void bitExpressionsIface_set_myBit1(BitExpressions* handle, sc_integer value) {
	handle->iface.myBit1 = value;
}
sc_integer bitExpressionsIface_get_myBit2(BitExpressions* handle) {
	return handle->iface.myBit2;
}
void bitExpressionsIface_set_myBit2(BitExpressions* handle, sc_integer value) {
	handle->iface.myBit2 = value;
}
sc_integer bitExpressionsIface_get_leftBitshift(BitExpressions* handle) {
	return handle->iface.leftBitshift;
}
void bitExpressionsIface_set_leftBitshift(BitExpressions* handle, sc_integer value) {
	handle->iface.leftBitshift = value;
}
sc_integer bitExpressionsIface_get_rightBitshift(BitExpressions* handle) {
	return handle->iface.rightBitshift;
}
void bitExpressionsIface_set_rightBitshift(BitExpressions* handle, sc_integer value) {
	handle->iface.rightBitshift = value;
}
sc_integer bitExpressionsIface_get_complementBitshift(BitExpressions* handle) {
	return handle->iface.complementBitshift;
}
void bitExpressionsIface_set_complementBitshift(BitExpressions* handle, sc_integer value) {
	handle->iface.complementBitshift = value;
}
sc_integer bitExpressionsIface_get_bitwiseAnd(BitExpressions* handle) {
	return handle->iface.bitwiseAnd;
}
void bitExpressionsIface_set_bitwiseAnd(BitExpressions* handle, sc_integer value) {
	handle->iface.bitwiseAnd = value;
}
sc_integer bitExpressionsIface_get_bitwiseOr(BitExpressions* handle) {
	return handle->iface.bitwiseOr;
}
void bitExpressionsIface_set_bitwiseOr(BitExpressions* handle, sc_integer value) {
	handle->iface.bitwiseOr = value;
}
sc_integer bitExpressionsIface_get_bitwiseXor(BitExpressions* handle) {
	return handle->iface.bitwiseXor;
}
void bitExpressionsIface_set_bitwiseXor(BitExpressions* handle, sc_integer value) {
	handle->iface.bitwiseXor = value;
}
		
// implementations of all internal functions

/* Entry action for statechart 'BitExpressions'. */
static void bitExpressions_entryaction(BitExpressions* handle) {
	/* Entry action for statechart 'BitExpressions'. */
}

/* Exit action for state 'BitExpressions'. */
static void bitExpressions_exitaction(BitExpressions* handle) {
	/* Exit action for state 'BitExpressions'. */
}

/* The reactions of state StateA. */
static void bitExpressions_react_main_region_StateA(BitExpressions* handle) {
	/* The reactions of state StateA. */
	if (handle->iface.e1_raised) { 
		/* Default exit sequence for state StateA */
		handle->stateConfVector[0] = BitExpressions_last_state;
		handle->stateConfVectorPosition = 0;
		/* Default enter sequence for state StateB */
		/* Entry action for state 'StateB'. */
		handle->iface.leftBitshift = handle->iface.myBit1 << 1;
		handle->iface.rightBitshift = handle->iface.myBit1 >> 1;
		handle->iface.complementBitshift = ~ handle->iface.myBit1;
		handle->iface.bitwiseAnd = handle->iface.myBit1 & handle->iface.myBit2;
		handle->iface.bitwiseOr = handle->iface.myBit1 | handle->iface.myBit2;
		handle->iface.bitwiseXor = handle->iface.myBit1 ^ handle->iface.myBit2;
		handle->stateConfVector[0] = BitExpressions_main_region_StateB;
		handle->stateConfVectorPosition = 0;
	} 
}

/* The reactions of state StateB. */
static void bitExpressions_react_main_region_StateB(BitExpressions* handle) {
	/* The reactions of state StateB. */
}


