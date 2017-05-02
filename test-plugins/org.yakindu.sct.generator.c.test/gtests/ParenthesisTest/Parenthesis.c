
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "Parenthesis.h"
/*! \file Implementation of the state machine 'Parenthesis'
*/

/* prototypes of all internal functions */
static void parenthesis_enact_mainRegion_A(Parenthesis* handle);
static void parenthesis_enseq_mainRegion_A_default(Parenthesis* handle);
static void parenthesis_enseq_mainRegion_default(Parenthesis* handle);
static void parenthesis_exseq_mainRegion_A(Parenthesis* handle);
static void parenthesis_exseq_mainRegion(Parenthesis* handle);
static void parenthesis_react_mainRegion_A(Parenthesis* handle);
static void parenthesis_react_mainRegion__entry_Default(Parenthesis* handle);
static void parenthesis_clearInEvents(Parenthesis* handle);
static void parenthesis_clearOutEvents(Parenthesis* handle);


void parenthesis_init(Parenthesis* handle)
{
	sc_integer i;

	for (i = 0; i < PARENTHESIS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = Parenthesis_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	parenthesis_clearInEvents(handle);
	parenthesis_clearOutEvents(handle);

	/* Default init sequence for statechart Parenthesis */
	handle->iface.erg = 0;

}

void parenthesis_enter(Parenthesis* handle)
{
	/* Default enter sequence for statechart Parenthesis */
	parenthesis_enseq_mainRegion_default(handle);
}

void parenthesis_exit(Parenthesis* handle)
{
	/* Default exit sequence for statechart Parenthesis */
	parenthesis_exseq_mainRegion(handle);
}

sc_boolean parenthesis_isActive(const Parenthesis* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != Parenthesis_last_state)
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
sc_boolean parenthesis_isFinal(const Parenthesis* handle)
{
   return bool_false;
}

static void parenthesis_clearInEvents(Parenthesis* handle)
{
}

static void parenthesis_clearOutEvents(Parenthesis* handle)
{
}

void parenthesis_runCycle(Parenthesis* handle)
{
	
	parenthesis_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < PARENTHESIS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case Parenthesis_mainRegion_A :
		{
			parenthesis_react_mainRegion_A(handle);
			break;
		}
		default:
			break;
		}
	}
	
	parenthesis_clearInEvents(handle);
}


sc_boolean parenthesis_isStateActive(const Parenthesis* handle, ParenthesisStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case Parenthesis_mainRegion_A :
			result = (sc_boolean) (handle->stateConfVector[0] == Parenthesis_mainRegion_A
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}



sc_integer parenthesisIface_get_erg(const Parenthesis* handle)
{
	return handle->iface.erg;
}
void parenthesisIface_set_erg(Parenthesis* handle, sc_integer value)
{
	handle->iface.erg = value;
}

/* implementations of all internal functions */

/* Entry action for state 'A'. */
static void parenthesis_enact_mainRegion_A(Parenthesis* handle)
{
	/* Entry action for state 'A'. */
	handle->iface.erg = 4 * (3 - 1);
}

/* 'default' enter sequence for state A */
static void parenthesis_enseq_mainRegion_A_default(Parenthesis* handle)
{
	/* 'default' enter sequence for state A */
	parenthesis_enact_mainRegion_A(handle);
	handle->stateConfVector[0] = Parenthesis_mainRegion_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region mainRegion */
static void parenthesis_enseq_mainRegion_default(Parenthesis* handle)
{
	/* 'default' enter sequence for region mainRegion */
	parenthesis_react_mainRegion__entry_Default(handle);
}

/* Default exit sequence for state A */
static void parenthesis_exseq_mainRegion_A(Parenthesis* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = Parenthesis_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region mainRegion */
static void parenthesis_exseq_mainRegion(Parenthesis* handle)
{
	/* Default exit sequence for region mainRegion */
	/* Handle exit of all possible states (of Parenthesis.mainRegion) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case Parenthesis_mainRegion_A :
		{
			parenthesis_exseq_mainRegion_A(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void parenthesis_react_mainRegion_A(Parenthesis* handle)
{
	/* The reactions of state A. */
}

/* Default react sequence for initial entry  */
static void parenthesis_react_mainRegion__entry_Default(Parenthesis* handle)
{
	/* Default react sequence for initial entry  */
	parenthesis_enseq_mainRegion_A_default(handle);
}


