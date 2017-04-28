
#include "Guard.h"
#include <string.h>

/*! \file Implementation of the state machine 'Guard'
*/

Guard::Guard()
{
	
	
	stateConfVectorPosition = 0;
	
}

Guard::~Guard()
{
}


void Guard::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = Guard_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart Guard */
	iface.MyVar = 0;
}

void Guard::enter()
{
	/* Default enter sequence for statechart Guard */
	enseq_main_region_default();
}

void Guard::exit()
{
	/* Default exit sequence for statechart Guard */
	exseq_main_region();
}

sc_boolean Guard::isActive() const
{
	return stateConfVector[0] != Guard_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean Guard::isFinal() const
{
   return false;}

void Guard::runCycle()
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

void Guard::clearInEvents()
{
	iface.Event1_raised = false;
	iface.Event2_raised = false;
	iface.Return_raised = false;
}

void Guard::clearOutEvents()
{
}


sc_boolean Guard::isStateActive(GuardStates state) const
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

Guard::DefaultSCI* Guard::getDefaultSCI()
{
	return &iface;
}

void Guard::DefaultSCI::raise_event1()
{
	Event1_raised = true;
}

void Guard::raise_event1()
{
	iface.raise_event1();
}

void Guard::DefaultSCI::raise_event2()
{
	Event2_raised = true;
}

void Guard::raise_event2()
{
	iface.raise_event2();
}

void Guard::DefaultSCI::raise_return()
{
	Return_raised = true;
}

void Guard::raise_return()
{
	iface.raise_return();
}


sc_integer Guard::DefaultSCI::get_myVar() const
{
	return MyVar;
}

sc_integer Guard::get_myVar() const
{
	return iface.MyVar;
}

void Guard::DefaultSCI::set_myVar(sc_integer value)
{
	MyVar = value;
}

void Guard::set_myVar(sc_integer value)
{
	iface.MyVar = value;
}


// implementations of all internal functions

sc_boolean Guard::check_main_region_A_tr0_tr0()
{
	return (iface.Event1_raised) && (iface.MyVar == 10);
}

sc_boolean Guard::check_main_region_A_tr1_tr1()
{
	return iface.Event2_raised;
}

sc_boolean Guard::check_main_region_B_tr0_tr0()
{
	return iface.Return_raised;
}

void Guard::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void Guard::effect_main_region_A_tr1()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void Guard::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region_A_default();
}

/* Entry action for state 'B'. */
void Guard::enact_main_region_B()
{
	/* Entry action for state 'B'. */
	iface.MyVar = 10;
}

/* 'default' enter sequence for state A */
void Guard::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void Guard::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	enact_main_region_B();
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void Guard::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void Guard::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = Guard_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void Guard::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = Guard_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void Guard::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of Guard.main_region) at position 0... */
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
void Guard::react_main_region_A()
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
void Guard::react_main_region_B()
{
	/* The reactions of state B. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	} 
}

/* Default react sequence for initial entry  */
void Guard::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


