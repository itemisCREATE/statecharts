
#include "DynamicChoice.h"
#include <string.h>

/*! \file Implementation of the state machine 'DynamicChoice'
*/

DynamicChoice::DynamicChoice()
{
	
	
	stateConfVectorPosition = 0;
	
}

DynamicChoice::~DynamicChoice()
{
}


void DynamicChoice::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = DynamicChoice_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart DynamicChoice */
	iface.number = 0;
}

void DynamicChoice::enter()
{
	/* Default enter sequence for statechart DynamicChoice */
	enseq_main_region_default();
}

void DynamicChoice::exit()
{
	/* Default exit sequence for statechart DynamicChoice */
	exseq_main_region();
}

sc_boolean DynamicChoice::isActive() const
{
	return stateConfVector[0] != DynamicChoice_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean DynamicChoice::isFinal() const
{
   return false;}

void DynamicChoice::runCycle()
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

void DynamicChoice::clearInEvents()
{
	iface.reset_raised = false;
}

void DynamicChoice::clearOutEvents()
{
}


sc_boolean DynamicChoice::isStateActive(DynamicChoiceStates state) const
{
	switch (state)
	{
		case main_region_Start : 
			return (sc_boolean) (stateConfVector[0] == main_region_Start
			);
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		case main_region_B : 
			return (sc_boolean) (stateConfVector[0] == main_region_B
			);
		default: return false;
	}
}

DynamicChoice::DefaultSCI* DynamicChoice::getDefaultSCI()
{
	return &iface;
}

void DynamicChoice::DefaultSCI::raise_reset()
{
	reset_raised = true;
}

void DynamicChoice::raise_reset()
{
	iface.raise_reset();
}


sc_integer DynamicChoice::DefaultSCI::get_number() const
{
	return number;
}

sc_integer DynamicChoice::get_number() const
{
	return iface.number;
}

void DynamicChoice::DefaultSCI::set_number(sc_integer value)
{
	number = value;
}

void DynamicChoice::set_number(sc_integer value)
{
	iface.number = value;
}


// implementations of all internal functions

sc_boolean DynamicChoice::check_main_region_Start_tr0_tr0()
{
	return true;
}

sc_boolean DynamicChoice::check_main_region__choice_0_tr0_tr0()
{
	return iface.number == 2;
}

sc_boolean DynamicChoice::check_main_region__choice_0_tr1()
{
	return true;
}

void DynamicChoice::effect_main_region_Start_tr0()
{
	exseq_main_region_Start();
	iface.number += 1;
	react_main_region__choice_0();
}

void DynamicChoice::effect_main_region__choice_0_tr0()
{
	enseq_main_region_A_default();
}

void DynamicChoice::effect_main_region__choice_0_tr1()
{
	enseq_main_region_B_default();
}

/* Entry action for state 'Start'. */
void DynamicChoice::enact_main_region_Start()
{
	/* Entry action for state 'Start'. */
	iface.number = 1;
}

/* 'default' enter sequence for state Start */
void DynamicChoice::enseq_main_region_Start_default()
{
	/* 'default' enter sequence for state Start */
	enact_main_region_Start();
	stateConfVector[0] = main_region_Start;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state A */
void DynamicChoice::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void DynamicChoice::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void DynamicChoice::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state Start */
void DynamicChoice::exseq_main_region_Start()
{
	/* Default exit sequence for state Start */
	stateConfVector[0] = DynamicChoice_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state A */
void DynamicChoice::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = DynamicChoice_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void DynamicChoice::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = DynamicChoice_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void DynamicChoice::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of DynamicChoice.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_Start :
		{
			exseq_main_region_Start();
			break;
		}
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

/* The reactions of state Start. */
void DynamicChoice::react_main_region_Start()
{
	/* The reactions of state Start. */
	effect_main_region_Start_tr0();
}

/* The reactions of state A. */
void DynamicChoice::react_main_region_A()
{
	/* The reactions of state A. */
}

/* The reactions of state B. */
void DynamicChoice::react_main_region_B()
{
	/* The reactions of state B. */
}

/* The reactions of state null. */
void DynamicChoice::react_main_region__choice_0()
{
	/* The reactions of state null. */
	if (check_main_region__choice_0_tr0_tr0())
	{ 
		effect_main_region__choice_0_tr0();
	}  else
	{
		effect_main_region__choice_0_tr1();
	}
}

/* Default react sequence for initial entry  */
void DynamicChoice::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_Start_default();
}


