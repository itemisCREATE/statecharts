
#include "LocalReactions.h"
#include <string.h>

/*! \file Implementation of the state machine 'LocalReactions'
*/

LocalReactions::LocalReactions()
{
	
	
	stateConfVectorPosition = 0;
	
}

LocalReactions::~LocalReactions()
{
}


void LocalReactions::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = LocalReactions_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart LocalReactions */
	iface.x = 0;
}

void LocalReactions::enter()
{
	/* Default enter sequence for statechart LocalReactions */
	enseq_main_region_default();
}

void LocalReactions::exit()
{
	/* Default exit sequence for statechart LocalReactions */
	exseq_main_region();
}

sc_boolean LocalReactions::isActive() const
{
	return stateConfVector[0] != LocalReactions_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean LocalReactions::isFinal() const
{
   return false;}

void LocalReactions::runCycle()
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

void LocalReactions::clearInEvents()
{
}

void LocalReactions::clearOutEvents()
{
}


sc_boolean LocalReactions::isStateActive(LocalReactionsStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		default: return false;
	}
}

LocalReactions::DefaultSCI* LocalReactions::getDefaultSCI()
{
	return &iface;
}


sc_integer LocalReactions::DefaultSCI::get_x() const
{
	return x;
}

sc_integer LocalReactions::get_x() const
{
	return iface.x;
}

void LocalReactions::DefaultSCI::set_x(sc_integer value)
{
	x = value;
}

void LocalReactions::set_x(sc_integer value)
{
	iface.x = value;
}


// implementations of all internal functions

sc_boolean LocalReactions::check_main_region_A_lr0_lr0()
{
	return iface.x == 0;
}

void LocalReactions::effect_main_region_A_lr0_lr0()
{
	iface.x += 1;
}

/* 'default' enter sequence for state A */
void LocalReactions::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void LocalReactions::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void LocalReactions::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = LocalReactions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void LocalReactions::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of LocalReactions.main_region) at position 0... */
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
void LocalReactions::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_lr0_lr0())
	{ 
		effect_main_region_A_lr0_lr0();
	} 
}

/* Default react sequence for initial entry  */
void LocalReactions::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


