
#include "FinalState.h"
#include <string.h>

/*! \file Implementation of the state machine 'FinalState'
*/

FinalState::FinalState()
{
	
	
	stateConfVectorPosition = 0;
	
}

FinalState::~FinalState()
{
}


void FinalState::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = FinalState_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void FinalState::enter()
{
	/* Default enter sequence for statechart FinalState */
	enseq_main_region_default();
}

void FinalState::exit()
{
	/* Default exit sequence for statechart FinalState */
	exseq_main_region();
}

sc_boolean FinalState::isActive() const
{
	return stateConfVector[0] != FinalState_last_state;
}

sc_boolean FinalState::isFinal() const
{
	return (stateConfVector[0] == main_region__final_);
}

void FinalState::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_myState :
		{
			react_main_region_myState();
			break;
		}
		case main_region__final_ :
		{
			react_main_region__final_();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void FinalState::clearInEvents()
{
}

void FinalState::clearOutEvents()
{
}


sc_boolean FinalState::isStateActive(FinalStateStates state) const
{
	switch (state)
	{
		case main_region_myState : 
			return (sc_boolean) (stateConfVector[0] == main_region_myState
			);
		case main_region__final_ : 
			return (sc_boolean) (stateConfVector[0] == main_region__final_
			);
		default: return false;
	}
}


// implementations of all internal functions

sc_boolean FinalState::check_main_region_myState_tr0_tr0()
{
	return true;
}

void FinalState::effect_main_region_myState_tr0()
{
	exseq_main_region_myState();
	enseq_main_region__final__default();
}

/* 'default' enter sequence for state myState */
void FinalState::enseq_main_region_myState_default()
{
	/* 'default' enter sequence for state myState */
	stateConfVector[0] = main_region_myState;
	stateConfVectorPosition = 0;
}

/* Default enter sequence for state null */
void FinalState::enseq_main_region__final__default()
{
	/* Default enter sequence for state null */
	stateConfVector[0] = main_region__final_;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void FinalState::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state myState */
void FinalState::exseq_main_region_myState()
{
	/* Default exit sequence for state myState */
	stateConfVector[0] = FinalState_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for final state. */
void FinalState::exseq_main_region__final_()
{
	/* Default exit sequence for final state. */
	stateConfVector[0] = FinalState_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void FinalState::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of FinalState.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_myState :
		{
			exseq_main_region_myState();
			break;
		}
		case main_region__final_ :
		{
			exseq_main_region__final_();
			break;
		}
		default: break;
	}
}

/* The reactions of state myState. */
void FinalState::react_main_region_myState()
{
	/* The reactions of state myState. */
	effect_main_region_myState_tr0();
}

/* The reactions of state null. */
void FinalState::react_main_region__final_()
{
	/* The reactions of state null. */
}

/* Default react sequence for initial entry  */
void FinalState::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_myState_default();
}


