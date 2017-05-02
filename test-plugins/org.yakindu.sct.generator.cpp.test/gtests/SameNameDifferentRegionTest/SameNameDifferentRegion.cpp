
#include "SameNameDifferentRegion.h"
#include <string.h>

/*! \file Implementation of the state machine 'SameNameDifferentRegion'
*/

SameNameDifferentRegion::SameNameDifferentRegion()
{
	
	
	stateConfVectorPosition = 0;
	
}

SameNameDifferentRegion::~SameNameDifferentRegion()
{
}


void SameNameDifferentRegion::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = SameNameDifferentRegion_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void SameNameDifferentRegion::enter()
{
	/* Default enter sequence for statechart SameNameDifferentRegion */
	enseq_main_region_default();
}

void SameNameDifferentRegion::exit()
{
	/* Default exit sequence for statechart SameNameDifferentRegion */
	exseq_main_region();
}

sc_boolean SameNameDifferentRegion::isActive() const
{
	return stateConfVector[0] != SameNameDifferentRegion_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean SameNameDifferentRegion::isFinal() const
{
   return false;}

void SameNameDifferentRegion::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_StateA :
		{
			react_main_region_StateA();
			break;
		}
		case main_region_StateB_r1_StateA :
		{
			react_main_region_StateB_r1_StateA();
			break;
		}
		case main_region_StateB_r1_StateB :
		{
			react_main_region_StateB_r1_StateB();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void SameNameDifferentRegion::clearInEvents()
{
	iface.e1_raised = false;
}

void SameNameDifferentRegion::clearOutEvents()
{
}


sc_boolean SameNameDifferentRegion::isStateActive(SameNameDifferentRegionStates state) const
{
	switch (state)
	{
		case main_region_StateA : 
			return (sc_boolean) (stateConfVector[0] == main_region_StateA
			);
		case main_region_StateB : 
			return (sc_boolean) (stateConfVector[0] >= main_region_StateB
				&& stateConfVector[0] <= main_region_StateB_r1_StateB);
		case main_region_StateB_r1_StateA : 
			return (sc_boolean) (stateConfVector[0] == main_region_StateB_r1_StateA
			);
		case main_region_StateB_r1_StateB : 
			return (sc_boolean) (stateConfVector[0] == main_region_StateB_r1_StateB
			);
		default: return false;
	}
}

SameNameDifferentRegion::DefaultSCI* SameNameDifferentRegion::getDefaultSCI()
{
	return &iface;
}

void SameNameDifferentRegion::DefaultSCI::raise_e1()
{
	e1_raised = true;
}

void SameNameDifferentRegion::raise_e1()
{
	iface.raise_e1();
}



// implementations of all internal functions

sc_boolean SameNameDifferentRegion::check_main_region_StateA_tr0_tr0()
{
	return iface.e1_raised;
}

sc_boolean SameNameDifferentRegion::check_main_region_StateB_r1_StateA_tr0_tr0()
{
	return iface.e1_raised;
}

void SameNameDifferentRegion::effect_main_region_StateA_tr0()
{
	exseq_main_region_StateA();
	enseq_main_region_StateB_default();
}

void SameNameDifferentRegion::effect_main_region_StateB_r1_StateA_tr0()
{
	exseq_main_region_StateB_r1_StateA();
	enseq_main_region_StateB_r1_StateB_default();
}

/* 'default' enter sequence for state StateA */
void SameNameDifferentRegion::enseq_main_region_StateA_default()
{
	/* 'default' enter sequence for state StateA */
	stateConfVector[0] = main_region_StateA;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
void SameNameDifferentRegion::enseq_main_region_StateB_default()
{
	/* 'default' enter sequence for state StateB */
	enseq_main_region_StateB_r1_default();
}

/* 'default' enter sequence for state StateA */
void SameNameDifferentRegion::enseq_main_region_StateB_r1_StateA_default()
{
	/* 'default' enter sequence for state StateA */
	stateConfVector[0] = main_region_StateB_r1_StateA;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
void SameNameDifferentRegion::enseq_main_region_StateB_r1_StateB_default()
{
	/* 'default' enter sequence for state StateB */
	stateConfVector[0] = main_region_StateB_r1_StateB;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void SameNameDifferentRegion::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* 'default' enter sequence for region r1 */
void SameNameDifferentRegion::enseq_main_region_StateB_r1_default()
{
	/* 'default' enter sequence for region r1 */
	react_main_region_StateB_r1__entry_Default();
}

/* Default exit sequence for state StateA */
void SameNameDifferentRegion::exseq_main_region_StateA()
{
	/* Default exit sequence for state StateA */
	stateConfVector[0] = SameNameDifferentRegion_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateA */
void SameNameDifferentRegion::exseq_main_region_StateB_r1_StateA()
{
	/* Default exit sequence for state StateA */
	stateConfVector[0] = SameNameDifferentRegion_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateB */
void SameNameDifferentRegion::exseq_main_region_StateB_r1_StateB()
{
	/* Default exit sequence for state StateB */
	stateConfVector[0] = SameNameDifferentRegion_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void SameNameDifferentRegion::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of SameNameDifferentRegion.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_StateA :
		{
			exseq_main_region_StateA();
			break;
		}
		case main_region_StateB_r1_StateA :
		{
			exseq_main_region_StateB_r1_StateA();
			break;
		}
		case main_region_StateB_r1_StateB :
		{
			exseq_main_region_StateB_r1_StateB();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r1 */
void SameNameDifferentRegion::exseq_main_region_StateB_r1()
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of SameNameDifferentRegion.main_region.StateB.r1) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_StateB_r1_StateA :
		{
			exseq_main_region_StateB_r1_StateA();
			break;
		}
		case main_region_StateB_r1_StateB :
		{
			exseq_main_region_StateB_r1_StateB();
			break;
		}
		default: break;
	}
}

/* The reactions of state StateA. */
void SameNameDifferentRegion::react_main_region_StateA()
{
	/* The reactions of state StateA. */
	if (check_main_region_StateA_tr0_tr0())
	{ 
		effect_main_region_StateA_tr0();
	} 
}

/* The reactions of state StateA. */
void SameNameDifferentRegion::react_main_region_StateB_r1_StateA()
{
	/* The reactions of state StateA. */
	if (check_main_region_StateB_r1_StateA_tr0_tr0())
	{ 
		effect_main_region_StateB_r1_StateA_tr0();
	} 
}

/* The reactions of state StateB. */
void SameNameDifferentRegion::react_main_region_StateB_r1_StateB()
{
	/* The reactions of state StateB. */
}

/* Default react sequence for initial entry  */
void SameNameDifferentRegion::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_StateA_default();
}

/* Default react sequence for initial entry  */
void SameNameDifferentRegion::react_main_region_StateB_r1__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_StateB_r1_StateA_default();
}


