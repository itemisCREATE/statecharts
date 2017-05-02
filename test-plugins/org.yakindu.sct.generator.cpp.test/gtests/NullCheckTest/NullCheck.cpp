
#include "NullCheck.h"
#include <string.h>

/*! \file Implementation of the state machine 'NullCheck'
*/

NullCheck::NullCheck()
{
	
	
	stateConfVectorPosition = 0;
	
}

NullCheck::~NullCheck()
{
}


void NullCheck::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = NullCheck_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void NullCheck::enter()
{
	/* Default enter sequence for statechart NullCheck */
	enseq_main_region_default();
}

void NullCheck::exit()
{
	/* Default exit sequence for statechart NullCheck */
	exseq_main_region();
}

sc_boolean NullCheck::isActive() const
{
	return stateConfVector[0] != NullCheck_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean NullCheck::isFinal() const
{
   return false;}

void NullCheck::runCycle()
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

void NullCheck::clearInEvents()
{
}

void NullCheck::clearOutEvents()
{
}


sc_boolean NullCheck::isStateActive(NullCheckStates state) const
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

sc_boolean NullCheck::check_main_region_A_tr0_tr0()
{
	return null == null;
}

void NullCheck::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

/* 'default' enter sequence for state A */
void NullCheck::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void NullCheck::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void NullCheck::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void NullCheck::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = NullCheck_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void NullCheck::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = NullCheck_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void NullCheck::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of NullCheck.main_region) at position 0... */
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
void NullCheck::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	} 
}

/* The reactions of state B. */
void NullCheck::react_main_region_B()
{
	/* The reactions of state B. */
}

/* Default react sequence for initial entry  */
void NullCheck::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


