
#include "SimpleEvent.h"
#include <string.h>

/*! \file Implementation of the state machine 'SimpleEvent'
*/

SimpleEvent::SimpleEvent()
{
	
	
	stateConfVectorPosition = 0;
	
}

SimpleEvent::~SimpleEvent()
{
}


void SimpleEvent::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = SimpleEvent_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void SimpleEvent::enter()
{
	/* Default enter sequence for statechart SimpleEvent */
	enseq_main_region_default();
}

void SimpleEvent::exit()
{
	/* Default exit sequence for statechart SimpleEvent */
	exseq_main_region();
}

sc_boolean SimpleEvent::isActive() const
{
	return stateConfVector[0] != SimpleEvent_last_state;
}

sc_boolean SimpleEvent::isFinal() const
{
	return (stateConfVector[0] == main_region__final_);
}

void SimpleEvent::runCycle()
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

void SimpleEvent::clearInEvents()
{
	iface.Event1_raised = false;
}

void SimpleEvent::clearOutEvents()
{
}


sc_boolean SimpleEvent::isStateActive(SimpleEventStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		case main_region_B : 
			return (sc_boolean) (stateConfVector[0] == main_region_B
			);
		case main_region__final_ : 
			return (sc_boolean) (stateConfVector[0] == main_region__final_
			);
		default: return false;
	}
}

SimpleEvent::DefaultSCI* SimpleEvent::getDefaultSCI()
{
	return &iface;
}

void SimpleEvent::DefaultSCI::raise_event1()
{
	Event1_raised = true;
}

void SimpleEvent::raise_event1()
{
	iface.raise_event1();
}



// implementations of all internal functions

sc_boolean SimpleEvent::check_main_region_A_tr0_tr0()
{
	return iface.Event1_raised;
}

sc_boolean SimpleEvent::check_main_region_B_tr0_tr0()
{
	return true;
}

void SimpleEvent::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void SimpleEvent::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region__final__default();
}

/* 'default' enter sequence for state A */
void SimpleEvent::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void SimpleEvent::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* Default enter sequence for state null */
void SimpleEvent::enseq_main_region__final__default()
{
	/* Default enter sequence for state null */
	stateConfVector[0] = main_region__final_;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void SimpleEvent::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void SimpleEvent::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = SimpleEvent_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void SimpleEvent::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = SimpleEvent_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for final state. */
void SimpleEvent::exseq_main_region__final_()
{
	/* Default exit sequence for final state. */
	stateConfVector[0] = SimpleEvent_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void SimpleEvent::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of SimpleEvent.main_region) at position 0... */
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
		case main_region__final_ :
		{
			exseq_main_region__final_();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void SimpleEvent::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	} 
}

/* The reactions of state B. */
void SimpleEvent::react_main_region_B()
{
	/* The reactions of state B. */
	effect_main_region_B_tr0();
}

/* The reactions of state null. */
void SimpleEvent::react_main_region__final_()
{
	/* The reactions of state null. */
}

/* Default react sequence for initial entry  */
void SimpleEvent::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


