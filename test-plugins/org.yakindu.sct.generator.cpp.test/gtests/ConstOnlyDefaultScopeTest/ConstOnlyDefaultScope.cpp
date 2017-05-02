
#include "ConstOnlyDefaultScope.h"
#include <string.h>

/*! \file Implementation of the state machine 'ConstOnlyDefaultScope'
*/

ConstOnlyDefaultScope::ConstOnlyDefaultScope()
{
	
	
	stateConfVectorPosition = 0;
	
}

ConstOnlyDefaultScope::~ConstOnlyDefaultScope()
{
}

const sc_integer ConstOnlyDefaultScope::DefaultSCI::B = 1;
const sc_integer ConstOnlyDefaultScope::DefaultSCI::C = 2;


void ConstOnlyDefaultScope::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = ConstOnlyDefaultScope_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void ConstOnlyDefaultScope::enter()
{
	/* Default enter sequence for statechart ConstOnlyDefaultScope */
	enseq_ConstOnlyDefaultScope_main_region_default();
}

void ConstOnlyDefaultScope::exit()
{
	/* Default exit sequence for statechart ConstOnlyDefaultScope */
	exseq_ConstOnlyDefaultScope_main_region();
}

sc_boolean ConstOnlyDefaultScope::isActive() const
{
	return stateConfVector[0] != ConstOnlyDefaultScope_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean ConstOnlyDefaultScope::isFinal() const
{
   return false;}

void ConstOnlyDefaultScope::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case ConstOnlyDefaultScope_main_region_A :
		{
			react_ConstOnlyDefaultScope_main_region_A();
			break;
		}
		case ConstOnlyDefaultScope_main_region_B :
		{
			react_ConstOnlyDefaultScope_main_region_B();
			break;
		}
		case ConstOnlyDefaultScope_main_region_C :
		{
			react_ConstOnlyDefaultScope_main_region_C();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void ConstOnlyDefaultScope::clearInEvents()
{
	ifaceA.e_raised = false;
}

void ConstOnlyDefaultScope::clearOutEvents()
{
}


sc_boolean ConstOnlyDefaultScope::isStateActive(ConstOnlyDefaultScopeStates state) const
{
	switch (state)
	{
		case ConstOnlyDefaultScope_main_region_A : 
			return (sc_boolean) (stateConfVector[0] == ConstOnlyDefaultScope_main_region_A
			);
		case ConstOnlyDefaultScope_main_region_B : 
			return (sc_boolean) (stateConfVector[0] == ConstOnlyDefaultScope_main_region_B
			);
		case ConstOnlyDefaultScope_main_region_C : 
			return (sc_boolean) (stateConfVector[0] == ConstOnlyDefaultScope_main_region_C
			);
		default: return false;
	}
}

ConstOnlyDefaultScope::DefaultSCI* ConstOnlyDefaultScope::getDefaultSCI()
{
	return &iface;
}


const sc_integer ConstOnlyDefaultScope::DefaultSCI::get_b() const
{
	return B;
}

const sc_integer ConstOnlyDefaultScope::get_b() const
{
	return ConstOnlyDefaultScope::DefaultSCI::B;
}

const sc_integer ConstOnlyDefaultScope::DefaultSCI::get_c() const
{
	return C;
}

const sc_integer ConstOnlyDefaultScope::get_c() const
{
	return ConstOnlyDefaultScope::DefaultSCI::C;
}

ConstOnlyDefaultScope::SCI_A* ConstOnlyDefaultScope::getSCI_A()
{
	return &ifaceA;
}

void ConstOnlyDefaultScope::SCI_A::raise_e(sc_integer value)
{
	e_value = value;
	e_raised = true;
}



// implementations of all internal functions

sc_boolean ConstOnlyDefaultScope::check_ConstOnlyDefaultScope_main_region_A_tr0_tr0()
{
	return (ifaceA.e_raised) && (ifaceA.e_value == ConstOnlyDefaultScope::DefaultSCI::B);
}

sc_boolean ConstOnlyDefaultScope::check_ConstOnlyDefaultScope_main_region_A_tr1_tr1()
{
	return (ifaceA.e_raised) && (ifaceA.e_value == ConstOnlyDefaultScope::DefaultSCI::C);
}

void ConstOnlyDefaultScope::effect_ConstOnlyDefaultScope_main_region_A_tr0()
{
	exseq_ConstOnlyDefaultScope_main_region_A();
	enseq_ConstOnlyDefaultScope_main_region_B_default();
}

void ConstOnlyDefaultScope::effect_ConstOnlyDefaultScope_main_region_A_tr1()
{
	exseq_ConstOnlyDefaultScope_main_region_A();
	enseq_ConstOnlyDefaultScope_main_region_C_default();
}

/* 'default' enter sequence for state A */
void ConstOnlyDefaultScope::enseq_ConstOnlyDefaultScope_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = ConstOnlyDefaultScope_main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void ConstOnlyDefaultScope::enseq_ConstOnlyDefaultScope_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = ConstOnlyDefaultScope_main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
void ConstOnlyDefaultScope::enseq_ConstOnlyDefaultScope_main_region_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[0] = ConstOnlyDefaultScope_main_region_C;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void ConstOnlyDefaultScope::enseq_ConstOnlyDefaultScope_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_ConstOnlyDefaultScope_main_region__entry_Default();
}

/* Default exit sequence for state A */
void ConstOnlyDefaultScope::exseq_ConstOnlyDefaultScope_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = ConstOnlyDefaultScope_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void ConstOnlyDefaultScope::exseq_ConstOnlyDefaultScope_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = ConstOnlyDefaultScope_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
void ConstOnlyDefaultScope::exseq_ConstOnlyDefaultScope_main_region_C()
{
	/* Default exit sequence for state C */
	stateConfVector[0] = ConstOnlyDefaultScope_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void ConstOnlyDefaultScope::exseq_ConstOnlyDefaultScope_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of declarations.ConstOnlyDefaultScope.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case ConstOnlyDefaultScope_main_region_A :
		{
			exseq_ConstOnlyDefaultScope_main_region_A();
			break;
		}
		case ConstOnlyDefaultScope_main_region_B :
		{
			exseq_ConstOnlyDefaultScope_main_region_B();
			break;
		}
		case ConstOnlyDefaultScope_main_region_C :
		{
			exseq_ConstOnlyDefaultScope_main_region_C();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void ConstOnlyDefaultScope::react_ConstOnlyDefaultScope_main_region_A()
{
	/* The reactions of state A. */
	if (check_ConstOnlyDefaultScope_main_region_A_tr0_tr0())
	{ 
		effect_ConstOnlyDefaultScope_main_region_A_tr0();
	}  else
	{
		if (check_ConstOnlyDefaultScope_main_region_A_tr1_tr1())
		{ 
			effect_ConstOnlyDefaultScope_main_region_A_tr1();
		} 
	}
}

/* The reactions of state B. */
void ConstOnlyDefaultScope::react_ConstOnlyDefaultScope_main_region_B()
{
	/* The reactions of state B. */
}

/* The reactions of state C. */
void ConstOnlyDefaultScope::react_ConstOnlyDefaultScope_main_region_C()
{
	/* The reactions of state C. */
}

/* Default react sequence for initial entry  */
void ConstOnlyDefaultScope::react_ConstOnlyDefaultScope_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_ConstOnlyDefaultScope_main_region_A_default();
}


