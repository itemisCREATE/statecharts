
#include "EmptyTransition.h"
#include <string.h>

/*! \file Implementation of the state machine 'EmptyTransition'
*/

EmptyTransition::EmptyTransition()
{
	
	
	stateConfVectorPosition = 0;
	
}

EmptyTransition::~EmptyTransition()
{
}


void EmptyTransition::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = EmptyTransition_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void EmptyTransition::enter()
{
	/* Default enter sequence for statechart EmptyTransition */
	enseq_main_region_default();
}

void EmptyTransition::exit()
{
	/* Default exit sequence for statechart EmptyTransition */
	exseq_main_region();
}

sc_boolean EmptyTransition::isActive() const
{
	return stateConfVector[0] != EmptyTransition_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean EmptyTransition::isFinal() const
{
   return false;}

void EmptyTransition::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_A :
		{
			react_main_region_A();
			break;
		}
		case main_region_B :
		{
			react_main_region_B();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void EmptyTransition::clearInEvents()
{
}

void EmptyTransition::clearOutEvents()
{
}


sc_boolean EmptyTransition::isStateActive(EmptyTransitionStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		case main_region_B : 
			return (sc_boolean) (stateConfVector[0] == main_region_B
			);
		default: return false;
	}
}


// implementations of all internal functions

/* 'default' enter sequence for state A */
void EmptyTransition::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void EmptyTransition::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void EmptyTransition::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void EmptyTransition::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = EmptyTransition_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void EmptyTransition::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = EmptyTransition_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void EmptyTransition::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of EmptyTransition.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_A :
		{
			exseq_main_region_A();
			break;
		}
		case main_region_B :
		{
			exseq_main_region_B();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void EmptyTransition::react_main_region_A()
{
	/* The reactions of state A. */
}

/* The reactions of state B. */
void EmptyTransition::react_main_region_B()
{
	/* The reactions of state B. */
}

/* Default react sequence for initial entry  */
void EmptyTransition::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


