
#include "TransitionWithoutCondition.h"
#include <string.h>

/*! \file Implementation of the state machine 'TransitionWithoutCondition'
*/

TransitionWithoutCondition::TransitionWithoutCondition()
{
	
	
	stateConfVectorPosition = 0;
	
}

TransitionWithoutCondition::~TransitionWithoutCondition()
{
}


void TransitionWithoutCondition::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = TransitionWithoutCondition_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void TransitionWithoutCondition::enter()
{
	/* Default enter sequence for statechart TransitionWithoutCondition */
	enseq_main_region_default();
}

void TransitionWithoutCondition::exit()
{
	/* Default exit sequence for statechart TransitionWithoutCondition */
	exseq_main_region();
}

sc_boolean TransitionWithoutCondition::isActive() const
{
	return stateConfVector[0] != TransitionWithoutCondition_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean TransitionWithoutCondition::isFinal() const
{
   return false;}

void TransitionWithoutCondition::runCycle()
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

void TransitionWithoutCondition::clearInEvents()
{
}

void TransitionWithoutCondition::clearOutEvents()
{
}


sc_boolean TransitionWithoutCondition::isStateActive(TransitionWithoutConditionStates state) const
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

sc_boolean TransitionWithoutCondition::check_main_region_A_tr0_tr0()
{
	return true;
}

void TransitionWithoutCondition::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

/* 'default' enter sequence for state A */
void TransitionWithoutCondition::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void TransitionWithoutCondition::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void TransitionWithoutCondition::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void TransitionWithoutCondition::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = TransitionWithoutCondition_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void TransitionWithoutCondition::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = TransitionWithoutCondition_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void TransitionWithoutCondition::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of TransitionWithoutCondition.main_region) at position 0... */
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
void TransitionWithoutCondition::react_main_region_A()
{
	/* The reactions of state A. */
	effect_main_region_A_tr0();
}

/* The reactions of state B. */
void TransitionWithoutCondition::react_main_region_B()
{
	/* The reactions of state B. */
}

/* Default react sequence for initial entry  */
void TransitionWithoutCondition::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


