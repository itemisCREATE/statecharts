
#include "StatechartActive.h"
#include <string.h>

/*! \file Implementation of the state machine 'StatechartActive'
*/

StatechartActive::StatechartActive()
{
	
	
	stateConfVectorPosition = 0;
	
}

StatechartActive::~StatechartActive()
{
}


void StatechartActive::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = StatechartActive_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void StatechartActive::enter()
{
	/* Default enter sequence for statechart StatechartActive */
	enseq_r_default();
}

void StatechartActive::exit()
{
	/* Default exit sequence for statechart StatechartActive */
	exseq_r();
}

sc_boolean StatechartActive::isActive() const
{
	return stateConfVector[0] != StatechartActive_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean StatechartActive::isFinal() const
{
   return false;}

void StatechartActive::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case r_A :
		{
			react_r_A();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void StatechartActive::clearInEvents()
{
}

void StatechartActive::clearOutEvents()
{
}


sc_boolean StatechartActive::isStateActive(StatechartActiveStates state) const
{
	switch (state)
	{
		case r_A : 
			return (sc_boolean) (stateConfVector[0] == r_A
			);
		default: return false;
	}
}


// implementations of all internal functions

/* 'default' enter sequence for state A */
void StatechartActive::enseq_r_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = r_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region r */
void StatechartActive::enseq_r_default()
{
	/* 'default' enter sequence for region r */
	react_r__entry_Default();
}

/* Default exit sequence for state A */
void StatechartActive::exseq_r_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = StatechartActive_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region r */
void StatechartActive::exseq_r()
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of StatechartActive.r) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case r_A :
		{
			exseq_r_A();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void StatechartActive::react_r_A()
{
	/* The reactions of state A. */
}

/* Default react sequence for initial entry  */
void StatechartActive::react_r__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_r_A_default();
}


