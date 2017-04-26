
#include "ConditionalExpressions.h"
#include <string.h>

/*! \file Implementation of the state machine 'ConditionalExpressions'
*/

ConditionalExpressions::ConditionalExpressions()
{
	
	
	stateConfVectorPosition = 0;
	
}

ConditionalExpressions::~ConditionalExpressions()
{
}


void ConditionalExpressions::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = ConditionalExpressions_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart ConditionalExpressions */
	iface.condition = iface.boolVar ? 3 : 2;
	iface.boolVar = true;
}

void ConditionalExpressions::enter()
{
	/* Default enter sequence for statechart ConditionalExpressions */
	enseq_main_region_default();
}

void ConditionalExpressions::exit()
{
	/* Default exit sequence for statechart ConditionalExpressions */
	exseq_main_region();
}

sc_boolean ConditionalExpressions::isActive() const
{
	return stateConfVector[0] != ConditionalExpressions_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean ConditionalExpressions::isFinal() const
{
   return false;}

void ConditionalExpressions::runCycle()
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

void ConditionalExpressions::clearInEvents()
{
	iface.e_raised = false;
}

void ConditionalExpressions::clearOutEvents()
{
}


sc_boolean ConditionalExpressions::isStateActive(ConditionalExpressionsStates state) const
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

ConditionalExpressions::DefaultSCI* ConditionalExpressions::getDefaultSCI()
{
	return &iface;
}

void ConditionalExpressions::DefaultSCI::raise_e()
{
	e_raised = true;
}

void ConditionalExpressions::raise_e()
{
	iface.raise_e();
}


sc_integer ConditionalExpressions::DefaultSCI::get_condition() const
{
	return condition;
}

sc_integer ConditionalExpressions::get_condition() const
{
	return iface.condition;
}

void ConditionalExpressions::DefaultSCI::set_condition(sc_integer value)
{
	condition = value;
}

void ConditionalExpressions::set_condition(sc_integer value)
{
	iface.condition = value;
}

sc_boolean ConditionalExpressions::DefaultSCI::get_boolVar() const
{
	return boolVar;
}

sc_boolean ConditionalExpressions::get_boolVar() const
{
	return iface.boolVar;
}

void ConditionalExpressions::DefaultSCI::set_boolVar(sc_boolean value)
{
	boolVar = value;
}

void ConditionalExpressions::set_boolVar(sc_boolean value)
{
	iface.boolVar = value;
}


// implementations of all internal functions

sc_boolean ConditionalExpressions::check_main_region_A_tr0_tr0()
{
	return (iface.e_raised) && (1 == (iface.boolVar ? 1 : 0));
}

void ConditionalExpressions::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

/* Entry action for state 'A'. */
void ConditionalExpressions::enact_main_region_A()
{
	/* Entry action for state 'A'. */
	iface.condition = iface.boolVar ? 1 : 0;
}

/* Entry action for state 'B'. */
void ConditionalExpressions::enact_main_region_B()
{
	/* Entry action for state 'B'. */
	iface.condition = ((iface.condition == 2) ? 1 : 2);
}

/* 'default' enter sequence for state A */
void ConditionalExpressions::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	enact_main_region_A();
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void ConditionalExpressions::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	enact_main_region_B();
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void ConditionalExpressions::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void ConditionalExpressions::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = ConditionalExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void ConditionalExpressions::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = ConditionalExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void ConditionalExpressions::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of ConditionalExpressions.main_region) at position 0... */
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
void ConditionalExpressions::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	} 
}

/* The reactions of state B. */
void ConditionalExpressions::react_main_region_B()
{
	/* The reactions of state B. */
}

/* Default react sequence for initial entry  */
void ConditionalExpressions::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


