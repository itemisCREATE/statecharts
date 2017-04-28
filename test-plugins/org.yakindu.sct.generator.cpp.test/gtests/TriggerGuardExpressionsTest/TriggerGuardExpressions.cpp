
#include "TriggerGuardExpressions.h"
#include <string.h>

/*! \file Implementation of the state machine 'TriggerGuardExpressions'
*/

TriggerGuardExpressions::TriggerGuardExpressions()
{
	
	
	stateConfVectorPosition = 0;
	
}

TriggerGuardExpressions::~TriggerGuardExpressions()
{
}


void TriggerGuardExpressions::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = TriggerGuardExpressions_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart TriggerGuardExpressions */
	iface.b = false;
}

void TriggerGuardExpressions::enter()
{
	/* Default enter sequence for statechart TriggerGuardExpressions */
	enseq_main_region_default();
}

void TriggerGuardExpressions::exit()
{
	/* Default exit sequence for statechart TriggerGuardExpressions */
	exseq_main_region();
}

sc_boolean TriggerGuardExpressions::isActive() const
{
	return stateConfVector[0] != TriggerGuardExpressions_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean TriggerGuardExpressions::isFinal() const
{
   return false;}

void TriggerGuardExpressions::runCycle()
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

void TriggerGuardExpressions::clearInEvents()
{
	iface.e1_raised = false;
	iface.e2_raised = false;
}

void TriggerGuardExpressions::clearOutEvents()
{
}


sc_boolean TriggerGuardExpressions::isStateActive(TriggerGuardExpressionsStates state) const
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

TriggerGuardExpressions::DefaultSCI* TriggerGuardExpressions::getDefaultSCI()
{
	return &iface;
}

void TriggerGuardExpressions::DefaultSCI::raise_e1()
{
	e1_raised = true;
}

void TriggerGuardExpressions::raise_e1()
{
	iface.raise_e1();
}

void TriggerGuardExpressions::DefaultSCI::raise_e2()
{
	e2_raised = true;
}

void TriggerGuardExpressions::raise_e2()
{
	iface.raise_e2();
}


sc_boolean TriggerGuardExpressions::DefaultSCI::get_b() const
{
	return b;
}

sc_boolean TriggerGuardExpressions::get_b() const
{
	return iface.b;
}

void TriggerGuardExpressions::DefaultSCI::set_b(sc_boolean value)
{
	b = value;
}

void TriggerGuardExpressions::set_b(sc_boolean value)
{
	iface.b = value;
}


// implementations of all internal functions

sc_boolean TriggerGuardExpressions::check_main_region_A_tr0_tr0()
{
	return (iface.e1_raised || iface.e2_raised) && (iface.b);
}

sc_boolean TriggerGuardExpressions::check_main_region_B_tr0_tr0()
{
	return true;
}

void TriggerGuardExpressions::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void TriggerGuardExpressions::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region_A_default();
}

/* 'default' enter sequence for state A */
void TriggerGuardExpressions::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void TriggerGuardExpressions::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void TriggerGuardExpressions::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void TriggerGuardExpressions::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = TriggerGuardExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void TriggerGuardExpressions::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = TriggerGuardExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void TriggerGuardExpressions::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of TriggerGuardExpressions.main_region) at position 0... */
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
void TriggerGuardExpressions::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	} 
}

/* The reactions of state B. */
void TriggerGuardExpressions::react_main_region_B()
{
	/* The reactions of state B. */
	effect_main_region_B_tr0();
}

/* Default react sequence for initial entry  */
void TriggerGuardExpressions::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


