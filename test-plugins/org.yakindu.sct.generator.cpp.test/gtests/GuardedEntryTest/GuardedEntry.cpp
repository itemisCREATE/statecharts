
#include "GuardedEntry.h"
#include <string.h>

/*! \file Implementation of the state machine 'GuardedEntry'
*/

GuardedEntry::GuardedEntry()
{
	
	
	stateConfVectorPosition = 0;
	
}

GuardedEntry::~GuardedEntry()
{
}


void GuardedEntry::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = GuardedEntry_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart GuardedEntry */
	iface.guard = false;
	iface.done = false;
}

void GuardedEntry::enter()
{
	/* Default enter sequence for statechart GuardedEntry */
	enseq_main_region_default();
}

void GuardedEntry::exit()
{
	/* Default exit sequence for statechart GuardedEntry */
	exseq_main_region();
}

sc_boolean GuardedEntry::isActive() const
{
	return stateConfVector[0] != GuardedEntry_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean GuardedEntry::isFinal() const
{
   return false;}

void GuardedEntry::runCycle()
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

void GuardedEntry::clearInEvents()
{
	iface.e_raised = false;
}

void GuardedEntry::clearOutEvents()
{
}


sc_boolean GuardedEntry::isStateActive(GuardedEntryStates state) const
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

GuardedEntry::DefaultSCI* GuardedEntry::getDefaultSCI()
{
	return &iface;
}

void GuardedEntry::DefaultSCI::raise_e()
{
	e_raised = true;
}

void GuardedEntry::raise_e()
{
	iface.raise_e();
}


sc_boolean GuardedEntry::DefaultSCI::get_guard() const
{
	return guard;
}

sc_boolean GuardedEntry::get_guard() const
{
	return iface.guard;
}

void GuardedEntry::DefaultSCI::set_guard(sc_boolean value)
{
	guard = value;
}

void GuardedEntry::set_guard(sc_boolean value)
{
	iface.guard = value;
}

sc_boolean GuardedEntry::DefaultSCI::get_done() const
{
	return done;
}

sc_boolean GuardedEntry::get_done() const
{
	return iface.done;
}

void GuardedEntry::DefaultSCI::set_done(sc_boolean value)
{
	done = value;
}

void GuardedEntry::set_done(sc_boolean value)
{
	iface.done = value;
}


// implementations of all internal functions

sc_boolean GuardedEntry::check_main_region_A_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean GuardedEntry::check_main_region_B_tr0_tr0()
{
	return iface.e_raised;
}

void GuardedEntry::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void GuardedEntry::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region_A_default();
}

/* Entry action for state 'A'. */
void GuardedEntry::enact_main_region_A()
{
	/* Entry action for state 'A'. */
	if (iface.guard)
	{ 
		iface.done = true;
	} 
}

/* 'default' enter sequence for state A */
void GuardedEntry::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	enact_main_region_A();
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void GuardedEntry::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void GuardedEntry::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void GuardedEntry::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = GuardedEntry_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void GuardedEntry::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = GuardedEntry_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void GuardedEntry::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of GuardedEntry.main_region) at position 0... */
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
void GuardedEntry::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	} 
}

/* The reactions of state B. */
void GuardedEntry::react_main_region_B()
{
	/* The reactions of state B. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	} 
}

/* Default react sequence for initial entry  */
void GuardedEntry::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


