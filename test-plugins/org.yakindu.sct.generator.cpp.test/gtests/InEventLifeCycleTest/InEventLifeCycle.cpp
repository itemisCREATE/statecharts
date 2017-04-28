
#include "InEventLifeCycle.h"
#include <string.h>

/*! \file Implementation of the state machine 'InEventLifeCycle'
*/

InEventLifeCycle::InEventLifeCycle()
{
	
	
	stateConfVectorPosition = 0;
	
}

InEventLifeCycle::~InEventLifeCycle()
{
}


void InEventLifeCycle::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = InEventLifeCycle_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart InEventLifeCycle */
	iface.i = 0;
}

void InEventLifeCycle::enter()
{
	/* Default enter sequence for statechart InEventLifeCycle */
	enseq_main_region_default();
}

void InEventLifeCycle::exit()
{
	/* Default exit sequence for statechart InEventLifeCycle */
	exseq_main_region();
}

sc_boolean InEventLifeCycle::isActive() const
{
	return stateConfVector[0] != InEventLifeCycle_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean InEventLifeCycle::isFinal() const
{
   return false;}

void InEventLifeCycle::runCycle()
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

void InEventLifeCycle::clearInEvents()
{
	iface.e_raised = false;
}

void InEventLifeCycle::clearOutEvents()
{
}


sc_boolean InEventLifeCycle::isStateActive(InEventLifeCycleStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		default: return false;
	}
}

InEventLifeCycle::DefaultSCI* InEventLifeCycle::getDefaultSCI()
{
	return &iface;
}

void InEventLifeCycle::DefaultSCI::raise_e()
{
	e_raised = true;
}

void InEventLifeCycle::raise_e()
{
	iface.raise_e();
}


sc_integer InEventLifeCycle::DefaultSCI::get_i() const
{
	return i;
}

sc_integer InEventLifeCycle::get_i() const
{
	return iface.i;
}

void InEventLifeCycle::DefaultSCI::set_i(sc_integer value)
{
	i = value;
}

void InEventLifeCycle::set_i(sc_integer value)
{
	iface.i = value;
}


// implementations of all internal functions

sc_boolean InEventLifeCycle::check_main_region_A_lr0_lr0()
{
	return iface.e_raised;
}

void InEventLifeCycle::effect_main_region_A_lr0_lr0()
{
	iface.i += 1;
}

/* 'default' enter sequence for state A */
void InEventLifeCycle::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void InEventLifeCycle::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void InEventLifeCycle::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = InEventLifeCycle_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void InEventLifeCycle::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of InEventLifeCycle.main_region) at position 0... */
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
void InEventLifeCycle::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_lr0_lr0())
	{ 
		effect_main_region_A_lr0_lr0();
	} 
}

/* Default react sequence for initial entry  */
void InEventLifeCycle::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


