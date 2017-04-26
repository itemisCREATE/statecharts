
#include "GuardedExit.h"
#include <string.h>

/*! \file Implementation of the state machine 'GuardedExit'
*/

GuardedExit::GuardedExit()
{
	
	
	stateConfVectorPosition = 0;
	
}

GuardedExit::~GuardedExit()
{
}


void GuardedExit::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = GuardedExit_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart GuardedExit */
	iface.guard = false;
	iface.done = false;
}

void GuardedExit::enter()
{
	/* Default enter sequence for statechart GuardedExit */
	enseq_main_region_default();
}

void GuardedExit::exit()
{
	/* Default exit sequence for statechart GuardedExit */
	exseq_main_region();
}

sc_boolean GuardedExit::isActive() const
{
	return stateConfVector[0] != GuardedExit_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean GuardedExit::isFinal() const
{
   return false;}

void GuardedExit::runCycle()
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

void GuardedExit::clearInEvents()
{
	iface.e_raised = false;
}

void GuardedExit::clearOutEvents()
{
}


sc_boolean GuardedExit::isStateActive(GuardedExitStates state) const
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

GuardedExit::DefaultSCI* GuardedExit::getDefaultSCI()
{
	return &iface;
}

void GuardedExit::DefaultSCI::raise_e()
{
	e_raised = true;
}

void GuardedExit::raise_e()
{
	iface.raise_e();
}


sc_boolean GuardedExit::DefaultSCI::get_guard() const
{
	return guard;
}

sc_boolean GuardedExit::get_guard() const
{
	return iface.guard;
}

void GuardedExit::DefaultSCI::set_guard(sc_boolean value)
{
	guard = value;
}

void GuardedExit::set_guard(sc_boolean value)
{
	iface.guard = value;
}

sc_boolean GuardedExit::DefaultSCI::get_done() const
{
	return done;
}

sc_boolean GuardedExit::get_done() const
{
	return iface.done;
}

void GuardedExit::DefaultSCI::set_done(sc_boolean value)
{
	done = value;
}

void GuardedExit::set_done(sc_boolean value)
{
	iface.done = value;
}


// implementations of all internal functions

sc_boolean GuardedExit::check_main_region_A_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean GuardedExit::check_main_region_B_tr0_tr0()
{
	return iface.e_raised;
}

void GuardedExit::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void GuardedExit::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region_A_default();
}

/* Exit action for state 'A'. */
void GuardedExit::exact_main_region_A()
{
	/* Exit action for state 'A'. */
	if (iface.guard)
	{ 
		iface.done = true;
	} 
}

/* 'default' enter sequence for state A */
void GuardedExit::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void GuardedExit::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void GuardedExit::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void GuardedExit::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = GuardedExit_last_state;
	stateConfVectorPosition = 0;
	exact_main_region_A();
}

/* Default exit sequence for state B */
void GuardedExit::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = GuardedExit_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void GuardedExit::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of GuardedExit.main_region) at position 0... */
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
void GuardedExit::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	} 
}

/* The reactions of state B. */
void GuardedExit::react_main_region_B()
{
	/* The reactions of state B. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	} 
}

/* Default react sequence for initial entry  */
void GuardedExit::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


