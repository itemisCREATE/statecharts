
#include "ExitOnSelfTransition.h"
#include <string.h>

/*! \file Implementation of the state machine 'ExitOnSelfTransition'
*/

ExitOnSelfTransition::ExitOnSelfTransition()
{
	
	
	stateConfVectorPosition = 0;
	
}

ExitOnSelfTransition::~ExitOnSelfTransition()
{
}


void ExitOnSelfTransition::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = ExitOnSelfTransition_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart ExitOnSelfTransition */
	iface.entryCount = 0;
	iface.exitCount = 0;
}

void ExitOnSelfTransition::enter()
{
	/* Default enter sequence for statechart ExitOnSelfTransition */
	enseq_main_region_default();
}

void ExitOnSelfTransition::exit()
{
	/* Default exit sequence for statechart ExitOnSelfTransition */
	exseq_main_region();
}

sc_boolean ExitOnSelfTransition::isActive() const
{
	return stateConfVector[0] != ExitOnSelfTransition_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean ExitOnSelfTransition::isFinal() const
{
   return false;}

void ExitOnSelfTransition::runCycle()
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

void ExitOnSelfTransition::clearInEvents()
{
	iface.e_raised = false;
	iface.f_raised = false;
}

void ExitOnSelfTransition::clearOutEvents()
{
}


sc_boolean ExitOnSelfTransition::isStateActive(ExitOnSelfTransitionStates state) const
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

ExitOnSelfTransition::DefaultSCI* ExitOnSelfTransition::getDefaultSCI()
{
	return &iface;
}

void ExitOnSelfTransition::DefaultSCI::raise_e()
{
	e_raised = true;
}

void ExitOnSelfTransition::raise_e()
{
	iface.raise_e();
}

void ExitOnSelfTransition::DefaultSCI::raise_f()
{
	f_raised = true;
}

void ExitOnSelfTransition::raise_f()
{
	iface.raise_f();
}


sc_integer ExitOnSelfTransition::DefaultSCI::get_entryCount() const
{
	return entryCount;
}

sc_integer ExitOnSelfTransition::get_entryCount() const
{
	return iface.entryCount;
}

void ExitOnSelfTransition::DefaultSCI::set_entryCount(sc_integer value)
{
	entryCount = value;
}

void ExitOnSelfTransition::set_entryCount(sc_integer value)
{
	iface.entryCount = value;
}

sc_integer ExitOnSelfTransition::DefaultSCI::get_exitCount() const
{
	return exitCount;
}

sc_integer ExitOnSelfTransition::get_exitCount() const
{
	return iface.exitCount;
}

void ExitOnSelfTransition::DefaultSCI::set_exitCount(sc_integer value)
{
	exitCount = value;
}

void ExitOnSelfTransition::set_exitCount(sc_integer value)
{
	iface.exitCount = value;
}


// implementations of all internal functions

sc_boolean ExitOnSelfTransition::check_main_region_A_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean ExitOnSelfTransition::check_main_region_A_tr1_tr1()
{
	return iface.f_raised;
}

sc_boolean ExitOnSelfTransition::check_main_region_B_tr0_tr0()
{
	return iface.f_raised;
}

void ExitOnSelfTransition::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_A_default();
}

void ExitOnSelfTransition::effect_main_region_A_tr1()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void ExitOnSelfTransition::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region_A_default();
}

/* Entry action for state 'A'. */
void ExitOnSelfTransition::enact_main_region_A()
{
	/* Entry action for state 'A'. */
	iface.entryCount += 1;
}

/* Exit action for state 'A'. */
void ExitOnSelfTransition::exact_main_region_A()
{
	/* Exit action for state 'A'. */
	iface.exitCount += 1;
}

/* 'default' enter sequence for state A */
void ExitOnSelfTransition::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	enact_main_region_A();
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void ExitOnSelfTransition::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void ExitOnSelfTransition::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void ExitOnSelfTransition::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = ExitOnSelfTransition_last_state;
	stateConfVectorPosition = 0;
	exact_main_region_A();
}

/* Default exit sequence for state B */
void ExitOnSelfTransition::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = ExitOnSelfTransition_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void ExitOnSelfTransition::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of ExitOnSelfTransition.main_region) at position 0... */
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
void ExitOnSelfTransition::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	}  else
	{
		if (check_main_region_A_tr1_tr1())
		{ 
			effect_main_region_A_tr1();
		} 
	}
}

/* The reactions of state B. */
void ExitOnSelfTransition::react_main_region_B()
{
	/* The reactions of state B. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	} 
}

/* Default react sequence for initial entry  */
void ExitOnSelfTransition::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


