
#include "EntryChoice.h"
#include <string.h>

/*! \file Implementation of the state machine 'EntryChoice'
*/

EntryChoice::EntryChoice()
{
	
	
	stateConfVectorPosition = 0;
	
}

EntryChoice::~EntryChoice()
{
}


void EntryChoice::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = EntryChoice_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void EntryChoice::enter()
{
	/* Default enter sequence for statechart EntryChoice */
	enseq_main_region_default();
}

void EntryChoice::exit()
{
	/* Default exit sequence for statechart EntryChoice */
	exseq_main_region();
}

sc_boolean EntryChoice::isActive() const
{
	return stateConfVector[0] != EntryChoice_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean EntryChoice::isFinal() const
{
   return false;}

void EntryChoice::runCycle()
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
		default:
			break;
		}
	}
	
	clearInEvents();
}

void EntryChoice::clearInEvents()
{
}

void EntryChoice::clearOutEvents()
{
}


sc_boolean EntryChoice::isStateActive(EntryChoiceStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		default: return false;
	}
}


// implementations of all internal functions

sc_boolean EntryChoice::check_main_region__choice_0_tr0_tr0()
{
	return true;
}

void EntryChoice::effect_main_region__choice_0_tr0()
{
	enseq_main_region_A_default();
}

/* 'default' enter sequence for state A */
void EntryChoice::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void EntryChoice::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void EntryChoice::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = EntryChoice_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void EntryChoice::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of EntryChoice.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_A :
		{
			exseq_main_region_A();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void EntryChoice::react_main_region_A()
{
	/* The reactions of state A. */
}

/* The reactions of state null. */
void EntryChoice::react_main_region__choice_0()
{
	/* The reactions of state null. */
	effect_main_region__choice_0_tr0();
}

/* Default react sequence for initial entry  */
void EntryChoice::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	react_main_region__choice_0();
}


