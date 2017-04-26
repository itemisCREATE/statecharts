
#include "EntryExitSelfTransition.h"
#include <string.h>

/*! \file Implementation of the state machine 'EntryExitSelfTransition'
*/

EntryExitSelfTransition::EntryExitSelfTransition()
{
	
	
	stateConfVectorPosition = 0;
	
}

EntryExitSelfTransition::~EntryExitSelfTransition()
{
}


void EntryExitSelfTransition::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = EntryExitSelfTransition_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart EntryExitSelfTransition */
	iface.exits = 0;
	iface.entries = 0;
}

void EntryExitSelfTransition::enter()
{
	/* Default enter sequence for statechart EntryExitSelfTransition */
	enseq_main_region_default();
}

void EntryExitSelfTransition::exit()
{
	/* Default exit sequence for statechart EntryExitSelfTransition */
	exseq_main_region();
}

sc_boolean EntryExitSelfTransition::isActive() const
{
	return stateConfVector[0] != EntryExitSelfTransition_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean EntryExitSelfTransition::isFinal() const
{
   return false;}

void EntryExitSelfTransition::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_A__region0_B :
		{
			react_main_region_A__region0_B();
			break;
		}
		case main_region_A__region0_C :
		{
			react_main_region_A__region0_C();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void EntryExitSelfTransition::clearInEvents()
{
	iface.e_raised = false;
	iface.e1_raised = false;
}

void EntryExitSelfTransition::clearOutEvents()
{
}


sc_boolean EntryExitSelfTransition::isStateActive(EntryExitSelfTransitionStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] >= main_region_A
				&& stateConfVector[0] <= main_region_A__region0_C);
		case main_region_A__region0_B : 
			return (sc_boolean) (stateConfVector[0] == main_region_A__region0_B
			);
		case main_region_A__region0_C : 
			return (sc_boolean) (stateConfVector[0] == main_region_A__region0_C
			);
		default: return false;
	}
}

EntryExitSelfTransition::DefaultSCI* EntryExitSelfTransition::getDefaultSCI()
{
	return &iface;
}

void EntryExitSelfTransition::DefaultSCI::raise_e()
{
	e_raised = true;
}

void EntryExitSelfTransition::raise_e()
{
	iface.raise_e();
}

void EntryExitSelfTransition::DefaultSCI::raise_e1()
{
	e1_raised = true;
}

void EntryExitSelfTransition::raise_e1()
{
	iface.raise_e1();
}


sc_integer EntryExitSelfTransition::DefaultSCI::get_exits() const
{
	return exits;
}

sc_integer EntryExitSelfTransition::get_exits() const
{
	return iface.exits;
}

void EntryExitSelfTransition::DefaultSCI::set_exits(sc_integer value)
{
	exits = value;
}

void EntryExitSelfTransition::set_exits(sc_integer value)
{
	iface.exits = value;
}

sc_integer EntryExitSelfTransition::DefaultSCI::get_entries() const
{
	return entries;
}

sc_integer EntryExitSelfTransition::get_entries() const
{
	return iface.entries;
}

void EntryExitSelfTransition::DefaultSCI::set_entries(sc_integer value)
{
	entries = value;
}

void EntryExitSelfTransition::set_entries(sc_integer value)
{
	iface.entries = value;
}


// implementations of all internal functions

sc_boolean EntryExitSelfTransition::check_main_region_A_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean EntryExitSelfTransition::check_main_region_A__region0_B_tr0_tr0()
{
	return iface.e1_raised;
}

sc_boolean EntryExitSelfTransition::check_main_region_A__region0_C_tr0_tr0()
{
	return iface.e1_raised;
}

void EntryExitSelfTransition::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enact_main_region_A();
	enseq_main_region_A__region0_C_default();
}

void EntryExitSelfTransition::effect_main_region_A__region0_B_tr0()
{
	exseq_main_region_A__region0_B();
	enseq_main_region_A__region0_C_default();
}

void EntryExitSelfTransition::effect_main_region_A__region0_C_tr0()
{
	exseq_main_region_A();
	enseq_main_region_A_default();
}

/* Entry action for state 'A'. */
void EntryExitSelfTransition::enact_main_region_A()
{
	/* Entry action for state 'A'. */
	iface.entries += 1;
}

/* Exit action for state 'A'. */
void EntryExitSelfTransition::exact_main_region_A()
{
	/* Exit action for state 'A'. */
	iface.exits += 1;
}

/* 'default' enter sequence for state A */
void EntryExitSelfTransition::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	enact_main_region_A();
	enseq_main_region_A__region0_default();
}

/* 'default' enter sequence for state B */
void EntryExitSelfTransition::enseq_main_region_A__region0_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = main_region_A__region0_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
void EntryExitSelfTransition::enseq_main_region_A__region0_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[0] = main_region_A__region0_C;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void EntryExitSelfTransition::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* 'default' enter sequence for region  */
void EntryExitSelfTransition::enseq_main_region_A__region0_default()
{
	/* 'default' enter sequence for region  */
	react_main_region_A__region0__entry_Default();
}

/* Default exit sequence for state A */
void EntryExitSelfTransition::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	exseq_main_region_A__region0();
	exact_main_region_A();
}

/* Default exit sequence for state B */
void EntryExitSelfTransition::exseq_main_region_A__region0_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = EntryExitSelfTransition_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
void EntryExitSelfTransition::exseq_main_region_A__region0_C()
{
	/* Default exit sequence for state C */
	stateConfVector[0] = EntryExitSelfTransition_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void EntryExitSelfTransition::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of EntryExitSelfTransition.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_A__region0_B :
		{
			exseq_main_region_A__region0_B();
			exact_main_region_A();
			break;
		}
		case main_region_A__region0_C :
		{
			exseq_main_region_A__region0_C();
			exact_main_region_A();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region  */
void EntryExitSelfTransition::exseq_main_region_A__region0()
{
	/* Default exit sequence for region  */
	/* Handle exit of all possible states (of EntryExitSelfTransition.main_region.A._region0) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_A__region0_B :
		{
			exseq_main_region_A__region0_B();
			break;
		}
		case main_region_A__region0_C :
		{
			exseq_main_region_A__region0_C();
			break;
		}
		default: break;
	}
}

/* The reactions of state B. */
void EntryExitSelfTransition::react_main_region_A__region0_B()
{
	/* The reactions of state B. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	}  else
	{
		if (check_main_region_A__region0_B_tr0_tr0())
		{ 
			effect_main_region_A__region0_B_tr0();
		} 
	}
}

/* The reactions of state C. */
void EntryExitSelfTransition::react_main_region_A__region0_C()
{
	/* The reactions of state C. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	}  else
	{
		if (check_main_region_A__region0_C_tr0_tr0())
		{ 
			effect_main_region_A__region0_C_tr0();
		} 
	}
}

/* Default react sequence for initial entry  */
void EntryExitSelfTransition::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}

/* Default react sequence for initial entry  */
void EntryExitSelfTransition::react_main_region_A__region0__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A__region0_B_default();
}


