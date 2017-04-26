
#include "StaticChoice.h"
#include <string.h>

/*! \file Implementation of the state machine 'StaticChoice'
*/

StaticChoice::StaticChoice()
{
	
	
	stateConfVectorPosition = 0;
	
}

StaticChoice::~StaticChoice()
{
}


void StaticChoice::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = StaticChoice_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart StaticChoice */
	iface.number = 0;
}

void StaticChoice::enter()
{
	/* Default enter sequence for statechart StaticChoice */
	enseq_main_region_default();
}

void StaticChoice::exit()
{
	/* Default exit sequence for statechart StaticChoice */
	exseq_main_region();
}

sc_boolean StaticChoice::isActive() const
{
	return stateConfVector[0] != StaticChoice_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean StaticChoice::isFinal() const
{
   return false;}

void StaticChoice::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_Start :
		{
			react_main_region_Start();
			break;
		}
		case main_region_B :
		{
			react_main_region_B();
			break;
		}
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

void StaticChoice::clearInEvents()
{
	iface.reset_raised = false;
}

void StaticChoice::clearOutEvents()
{
}


sc_boolean StaticChoice::isStateActive(StaticChoiceStates state) const
{
	switch (state)
	{
		case main_region_Start : 
			return (sc_boolean) (stateConfVector[0] == main_region_Start
			);
		case main_region_B : 
			return (sc_boolean) (stateConfVector[0] == main_region_B
			);
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		default: return false;
	}
}

StaticChoice::DefaultSCI* StaticChoice::getDefaultSCI()
{
	return &iface;
}

void StaticChoice::DefaultSCI::raise_reset()
{
	reset_raised = true;
}

void StaticChoice::raise_reset()
{
	iface.raise_reset();
}


sc_integer StaticChoice::DefaultSCI::get_number() const
{
	return number;
}

sc_integer StaticChoice::get_number() const
{
	return iface.number;
}

void StaticChoice::DefaultSCI::set_number(sc_integer value)
{
	number = value;
}

void StaticChoice::set_number(sc_integer value)
{
	iface.number = value;
}


// implementations of all internal functions

sc_boolean StaticChoice::check_main_region_Start_tr0_tr0()
{
	return true;
}

sc_boolean StaticChoice::check_main_region__choice_0_tr1_tr1()
{
	return iface.number == 2;
}

sc_boolean StaticChoice::check_main_region__choice_0_tr0()
{
	return true;
}

void StaticChoice::effect_main_region_Start_tr0()
{
	exseq_main_region_Start();
	iface.number += 1;
	react_main_region__choice_0();
}

void StaticChoice::effect_main_region__choice_0_tr1()
{
	enseq_main_region_A_default();
}

void StaticChoice::effect_main_region__choice_0_tr0()
{
	enseq_main_region_B_default();
}

/* Entry action for state 'Start'. */
void StaticChoice::enact_main_region_Start()
{
	/* Entry action for state 'Start'. */
	iface.number = 1;
}

/* 'default' enter sequence for state Start */
void StaticChoice::enseq_main_region_Start_default()
{
	/* 'default' enter sequence for state Start */
	enact_main_region_Start();
	stateConfVector[0] = main_region_Start;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void StaticChoice::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state A */
void StaticChoice::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void StaticChoice::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state Start */
void StaticChoice::exseq_main_region_Start()
{
	/* Default exit sequence for state Start */
	stateConfVector[0] = StaticChoice_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void StaticChoice::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = StaticChoice_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state A */
void StaticChoice::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = StaticChoice_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void StaticChoice::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of StaticChoice.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_Start :
		{
			exseq_main_region_Start();
			break;
		}
		case main_region_B :
		{
			exseq_main_region_B();
			break;
		}
		case main_region_A :
		{
			exseq_main_region_A();
			break;
		}
		default: break;
	}
}

/* The reactions of state Start. */
void StaticChoice::react_main_region_Start()
{
	/* The reactions of state Start. */
	effect_main_region_Start_tr0();
}

/* The reactions of state B. */
void StaticChoice::react_main_region_B()
{
	/* The reactions of state B. */
}

/* The reactions of state A. */
void StaticChoice::react_main_region_A()
{
	/* The reactions of state A. */
}

/* The reactions of state null. */
void StaticChoice::react_main_region__choice_0()
{
	/* The reactions of state null. */
	if (check_main_region__choice_0_tr1_tr1())
	{ 
		effect_main_region__choice_0_tr1();
	}  else
	{
		effect_main_region__choice_0_tr0();
	}
}

/* Default react sequence for initial entry  */
void StaticChoice::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_Start_default();
}


