
#include "SimpleHierachy.h"
#include <string.h>

/*! \file Implementation of the state machine 'SimpleHierachy'
*/

SimpleHierachy::SimpleHierachy()
{
	
	
	stateConfVectorPosition = 0;
	
}

SimpleHierachy::~SimpleHierachy()
{
}


void SimpleHierachy::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = SimpleHierachy_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void SimpleHierachy::enter()
{
	/* Default enter sequence for statechart SimpleHierachy */
	enseq_main_region_default();
}

void SimpleHierachy::exit()
{
	/* Default exit sequence for statechart SimpleHierachy */
	exseq_main_region();
}

sc_boolean SimpleHierachy::isActive() const
{
	return stateConfVector[0] != SimpleHierachy_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean SimpleHierachy::isFinal() const
{
   return false;}

void SimpleHierachy::runCycle()
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
		case main_region_B_subregion1_B1 :
		{
			react_main_region_B_subregion1_B1();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void SimpleHierachy::clearInEvents()
{
	iface.Event1_raised = false;
}

void SimpleHierachy::clearOutEvents()
{
}


sc_boolean SimpleHierachy::isStateActive(SimpleHierachyStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		case main_region_B : 
			return (sc_boolean) (stateConfVector[0] >= main_region_B
				&& stateConfVector[0] <= main_region_B_subregion1_B1);
		case main_region_B_subregion1_B1 : 
			return (sc_boolean) (stateConfVector[0] == main_region_B_subregion1_B1
			);
		default: return false;
	}
}

SimpleHierachy::DefaultSCI* SimpleHierachy::getDefaultSCI()
{
	return &iface;
}

void SimpleHierachy::DefaultSCI::raise_event1()
{
	Event1_raised = true;
}

void SimpleHierachy::raise_event1()
{
	iface.raise_event1();
}



// implementations of all internal functions

sc_boolean SimpleHierachy::check_main_region_A_tr0_tr0()
{
	return iface.Event1_raised;
}

void SimpleHierachy::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

/* 'default' enter sequence for state A */
void SimpleHierachy::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void SimpleHierachy::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	enseq_main_region_B_subregion1_default();
}

/* 'default' enter sequence for state B1 */
void SimpleHierachy::enseq_main_region_B_subregion1_B1_default()
{
	/* 'default' enter sequence for state B1 */
	stateConfVector[0] = main_region_B_subregion1_B1;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void SimpleHierachy::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* 'default' enter sequence for region subregion1 */
void SimpleHierachy::enseq_main_region_B_subregion1_default()
{
	/* 'default' enter sequence for region subregion1 */
	react_main_region_B_subregion1__entry_Default();
}

/* Default exit sequence for state A */
void SimpleHierachy::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = SimpleHierachy_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B1 */
void SimpleHierachy::exseq_main_region_B_subregion1_B1()
{
	/* Default exit sequence for state B1 */
	stateConfVector[0] = SimpleHierachy_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void SimpleHierachy::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of SimpleHierachy.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_A :
		{
			exseq_main_region_A();
			break;
		}
		case main_region_B_subregion1_B1 :
		{
			exseq_main_region_B_subregion1_B1();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region subregion1 */
void SimpleHierachy::exseq_main_region_B_subregion1()
{
	/* Default exit sequence for region subregion1 */
	/* Handle exit of all possible states (of SimpleHierachy.main_region.B.subregion1) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_B_subregion1_B1 :
		{
			exseq_main_region_B_subregion1_B1();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void SimpleHierachy::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	} 
}

/* The reactions of state B1. */
void SimpleHierachy::react_main_region_B_subregion1_B1()
{
	/* The reactions of state B1. */
}

/* Default react sequence for initial entry  */
void SimpleHierachy::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}

/* Default react sequence for initial entry  */
void SimpleHierachy::react_main_region_B_subregion1__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_B_subregion1_B1_default();
}


