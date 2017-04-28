
#include "FeatureCalls.h"
#include <string.h>

/*! \file Implementation of the state machine 'FeatureCalls'
*/

FeatureCalls::FeatureCalls()
{
	
	
	stateConfVectorPosition = 0;
	
}

FeatureCalls::~FeatureCalls()
{
}


void FeatureCalls::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = FeatureCalls_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart FeatureCalls */
	ifaceMyInterface.myInt = 0;
}

void FeatureCalls::enter()
{
	/* Default enter sequence for statechart FeatureCalls */
	enseq_main_region_default();
}

void FeatureCalls::exit()
{
	/* Default exit sequence for statechart FeatureCalls */
	exseq_main_region();
}

sc_boolean FeatureCalls::isActive() const
{
	return stateConfVector[0] != FeatureCalls_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean FeatureCalls::isFinal() const
{
   return false;}

void FeatureCalls::runCycle()
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

void FeatureCalls::clearInEvents()
{
	ifaceMyInterface.Event1_raised = false;
}

void FeatureCalls::clearOutEvents()
{
}


sc_boolean FeatureCalls::isStateActive(FeatureCallsStates state) const
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

FeatureCalls::SCI_MyInterface* FeatureCalls::getSCI_MyInterface()
{
	return &ifaceMyInterface;
}

void FeatureCalls::SCI_MyInterface::raise_event1()
{
	Event1_raised = true;
}


sc_integer FeatureCalls::SCI_MyInterface::get_myInt() const
{
	return myInt;
}

void FeatureCalls::SCI_MyInterface::set_myInt(sc_integer value)
{
	myInt = value;
}


// implementations of all internal functions

sc_boolean FeatureCalls::check_main_region_A_tr0_tr0()
{
	return ifaceMyInterface.Event1_raised;
}

sc_boolean FeatureCalls::check_main_region_B_tr0_tr0()
{
	return ifaceMyInterface.Event1_raised;
}

void FeatureCalls::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void FeatureCalls::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region_A_default();
}

/* Entry action for state 'B'. */
void FeatureCalls::enact_main_region_B()
{
	/* Entry action for state 'B'. */
	ifaceMyInterface.myInt = 42;
	ifaceMyInterface.Event1_raised = true;
}

/* 'default' enter sequence for state A */
void FeatureCalls::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void FeatureCalls::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	enact_main_region_B();
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void FeatureCalls::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void FeatureCalls::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = FeatureCalls_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void FeatureCalls::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = FeatureCalls_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void FeatureCalls::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of FeatureCalls.main_region) at position 0... */
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
void FeatureCalls::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	} 
}

/* The reactions of state B. */
void FeatureCalls::react_main_region_B()
{
	/* The reactions of state B. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	} 
}

/* Default react sequence for initial entry  */
void FeatureCalls::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


