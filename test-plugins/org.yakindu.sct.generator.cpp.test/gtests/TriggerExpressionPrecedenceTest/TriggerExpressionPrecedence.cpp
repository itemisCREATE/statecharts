
#include "TriggerExpressionPrecedence.h"
#include <string.h>

/*! \file Implementation of the state machine 'TriggerExpressionPrecedence'
*/

TriggerExpressionPrecedence::TriggerExpressionPrecedence()
{
	
	
	stateConfVectorPosition = 0;
	
}

TriggerExpressionPrecedence::~TriggerExpressionPrecedence()
{
}


void TriggerExpressionPrecedence::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = TriggerExpressionPrecedence_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart TriggerExpressionPrecedence */
	iface.c1 = false;
	iface.c2 = false;
	iface.e1_transition = false;
	iface.e2_transition = false;
}

void TriggerExpressionPrecedence::enter()
{
	/* Default enter sequence for statechart TriggerExpressionPrecedence */
	enseq_TriggerExpressionPrecedence_main_region_default();
}

void TriggerExpressionPrecedence::exit()
{
	/* Default exit sequence for statechart TriggerExpressionPrecedence */
	exseq_TriggerExpressionPrecedence_main_region();
}

sc_boolean TriggerExpressionPrecedence::isActive() const
{
	return stateConfVector[0] != TriggerExpressionPrecedence_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean TriggerExpressionPrecedence::isFinal() const
{
   return false;}

void TriggerExpressionPrecedence::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case TriggerExpressionPrecedence_main_region_A :
		{
			react_TriggerExpressionPrecedence_main_region_A();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void TriggerExpressionPrecedence::clearInEvents()
{
	iface.e1_raised = false;
	iface.e2_raised = false;
}

void TriggerExpressionPrecedence::clearOutEvents()
{
}


sc_boolean TriggerExpressionPrecedence::isStateActive(TriggerExpressionPrecedenceStates state) const
{
	switch (state)
	{
		case TriggerExpressionPrecedence_main_region_A : 
			return (sc_boolean) (stateConfVector[0] == TriggerExpressionPrecedence_main_region_A
			);
		default: return false;
	}
}

TriggerExpressionPrecedence::DefaultSCI* TriggerExpressionPrecedence::getDefaultSCI()
{
	return &iface;
}

void TriggerExpressionPrecedence::DefaultSCI::raise_e1()
{
	e1_raised = true;
}

void TriggerExpressionPrecedence::raise_e1()
{
	iface.raise_e1();
}

void TriggerExpressionPrecedence::DefaultSCI::raise_e2()
{
	e2_raised = true;
}

void TriggerExpressionPrecedence::raise_e2()
{
	iface.raise_e2();
}


sc_boolean TriggerExpressionPrecedence::DefaultSCI::get_c1() const
{
	return c1;
}

sc_boolean TriggerExpressionPrecedence::get_c1() const
{
	return iface.c1;
}

void TriggerExpressionPrecedence::DefaultSCI::set_c1(sc_boolean value)
{
	c1 = value;
}

void TriggerExpressionPrecedence::set_c1(sc_boolean value)
{
	iface.c1 = value;
}

sc_boolean TriggerExpressionPrecedence::DefaultSCI::get_c2() const
{
	return c2;
}

sc_boolean TriggerExpressionPrecedence::get_c2() const
{
	return iface.c2;
}

void TriggerExpressionPrecedence::DefaultSCI::set_c2(sc_boolean value)
{
	c2 = value;
}

void TriggerExpressionPrecedence::set_c2(sc_boolean value)
{
	iface.c2 = value;
}

sc_boolean TriggerExpressionPrecedence::DefaultSCI::get_e1_transition() const
{
	return e1_transition;
}

sc_boolean TriggerExpressionPrecedence::get_e1_transition() const
{
	return iface.e1_transition;
}

void TriggerExpressionPrecedence::DefaultSCI::set_e1_transition(sc_boolean value)
{
	e1_transition = value;
}

void TriggerExpressionPrecedence::set_e1_transition(sc_boolean value)
{
	iface.e1_transition = value;
}

sc_boolean TriggerExpressionPrecedence::DefaultSCI::get_e2_transition() const
{
	return e2_transition;
}

sc_boolean TriggerExpressionPrecedence::get_e2_transition() const
{
	return iface.e2_transition;
}

void TriggerExpressionPrecedence::DefaultSCI::set_e2_transition(sc_boolean value)
{
	e2_transition = value;
}

void TriggerExpressionPrecedence::set_e2_transition(sc_boolean value)
{
	iface.e2_transition = value;
}


// implementations of all internal functions

sc_boolean TriggerExpressionPrecedence::check_TriggerExpressionPrecedence_main_region_A_tr0_tr0()
{
	return (iface.e1_raised) && (iface.c1 || iface.c2);
}

sc_boolean TriggerExpressionPrecedence::check_TriggerExpressionPrecedence_main_region_A_tr1_tr1()
{
	return iface.e2_raised;
}

void TriggerExpressionPrecedence::effect_TriggerExpressionPrecedence_main_region_A_tr0()
{
	exseq_TriggerExpressionPrecedence_main_region_A();
	iface.e1_transition = true;
	enseq_TriggerExpressionPrecedence_main_region_A_default();
}

void TriggerExpressionPrecedence::effect_TriggerExpressionPrecedence_main_region_A_tr1()
{
	exseq_TriggerExpressionPrecedence_main_region_A();
	iface.e2_transition = true;
	enseq_TriggerExpressionPrecedence_main_region_A_default();
}

/* 'default' enter sequence for state A */
void TriggerExpressionPrecedence::enseq_TriggerExpressionPrecedence_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = TriggerExpressionPrecedence_main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void TriggerExpressionPrecedence::enseq_TriggerExpressionPrecedence_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_TriggerExpressionPrecedence_main_region__entry_Default();
}

/* Default exit sequence for state A */
void TriggerExpressionPrecedence::exseq_TriggerExpressionPrecedence_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = TriggerExpressionPrecedence_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void TriggerExpressionPrecedence::exseq_TriggerExpressionPrecedence_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of expressions.TriggerExpressionPrecedence.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case TriggerExpressionPrecedence_main_region_A :
		{
			exseq_TriggerExpressionPrecedence_main_region_A();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void TriggerExpressionPrecedence::react_TriggerExpressionPrecedence_main_region_A()
{
	/* The reactions of state A. */
	if (check_TriggerExpressionPrecedence_main_region_A_tr0_tr0())
	{ 
		effect_TriggerExpressionPrecedence_main_region_A_tr0();
	}  else
	{
		if (check_TriggerExpressionPrecedence_main_region_A_tr1_tr1())
		{ 
			effect_TriggerExpressionPrecedence_main_region_A_tr1();
		} 
	}
}

/* Default react sequence for initial entry  */
void TriggerExpressionPrecedence::react_TriggerExpressionPrecedence_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_TriggerExpressionPrecedence_main_region_A_default();
}


