
#include "ConstOnlyNamedScope.h"
#include <string.h>

/*! \file Implementation of the state machine 'ConstOnlyNamedScope'
*/

ConstOnlyNamedScope::ConstOnlyNamedScope()
{
	
	
	stateConfVectorPosition = 0;
	
}

ConstOnlyNamedScope::~ConstOnlyNamedScope()
{
}

const sc_integer ConstOnlyNamedScope::SCI_A::B = 1;
const sc_integer ConstOnlyNamedScope::SCI_A::C = 2;


void ConstOnlyNamedScope::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = ConstOnlyNamedScope_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void ConstOnlyNamedScope::enter()
{
	/* Default enter sequence for statechart ConstOnlyNamedScope */
	enseq_ConstOnlyNamedScope_main_region_default();
}

void ConstOnlyNamedScope::exit()
{
	/* Default exit sequence for statechart ConstOnlyNamedScope */
	exseq_ConstOnlyNamedScope_main_region();
}

sc_boolean ConstOnlyNamedScope::isActive() const
{
	return stateConfVector[0] != ConstOnlyNamedScope_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean ConstOnlyNamedScope::isFinal() const
{
   return false;}

void ConstOnlyNamedScope::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case ConstOnlyNamedScope_main_region_A :
		{
			react_ConstOnlyNamedScope_main_region_A();
			break;
		}
		case ConstOnlyNamedScope_main_region_B :
		{
			react_ConstOnlyNamedScope_main_region_B();
			break;
		}
		case ConstOnlyNamedScope_main_region_C :
		{
			react_ConstOnlyNamedScope_main_region_C();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void ConstOnlyNamedScope::clearInEvents()
{
	iface.e_raised = false;
}

void ConstOnlyNamedScope::clearOutEvents()
{
}


sc_boolean ConstOnlyNamedScope::isStateActive(ConstOnlyNamedScopeStates state) const
{
	switch (state)
	{
		case ConstOnlyNamedScope_main_region_A : 
			return (sc_boolean) (stateConfVector[0] == ConstOnlyNamedScope_main_region_A
			);
		case ConstOnlyNamedScope_main_region_B : 
			return (sc_boolean) (stateConfVector[0] == ConstOnlyNamedScope_main_region_B
			);
		case ConstOnlyNamedScope_main_region_C : 
			return (sc_boolean) (stateConfVector[0] == ConstOnlyNamedScope_main_region_C
			);
		default: return false;
	}
}

ConstOnlyNamedScope::DefaultSCI* ConstOnlyNamedScope::getDefaultSCI()
{
	return &iface;
}

void ConstOnlyNamedScope::DefaultSCI::raise_e(sc_integer value)
{
	e_value = value;
	e_raised = true;
}

void ConstOnlyNamedScope::raise_e(sc_integer value)
{
	iface.raise_e(value);
}


ConstOnlyNamedScope::SCI_A* ConstOnlyNamedScope::getSCI_A()
{
	return &ifaceA;
}


const sc_integer ConstOnlyNamedScope::SCI_A::get_b() const
{
	return B;
}

const sc_integer ConstOnlyNamedScope::SCI_A::get_c() const
{
	return C;
}


// implementations of all internal functions

sc_boolean ConstOnlyNamedScope::check_ConstOnlyNamedScope_main_region_A_tr0_tr0()
{
	return (iface.e_raised) && (iface.e_value == ConstOnlyNamedScope::SCI_A::B);
}

sc_boolean ConstOnlyNamedScope::check_ConstOnlyNamedScope_main_region_A_tr1_tr1()
{
	return (iface.e_raised) && (iface.e_value == ConstOnlyNamedScope::SCI_A::C);
}

void ConstOnlyNamedScope::effect_ConstOnlyNamedScope_main_region_A_tr0()
{
	exseq_ConstOnlyNamedScope_main_region_A();
	enseq_ConstOnlyNamedScope_main_region_B_default();
}

void ConstOnlyNamedScope::effect_ConstOnlyNamedScope_main_region_A_tr1()
{
	exseq_ConstOnlyNamedScope_main_region_A();
	enseq_ConstOnlyNamedScope_main_region_C_default();
}

/* 'default' enter sequence for state A */
void ConstOnlyNamedScope::enseq_ConstOnlyNamedScope_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = ConstOnlyNamedScope_main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void ConstOnlyNamedScope::enseq_ConstOnlyNamedScope_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = ConstOnlyNamedScope_main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
void ConstOnlyNamedScope::enseq_ConstOnlyNamedScope_main_region_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[0] = ConstOnlyNamedScope_main_region_C;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void ConstOnlyNamedScope::enseq_ConstOnlyNamedScope_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_ConstOnlyNamedScope_main_region__entry_Default();
}

/* Default exit sequence for state A */
void ConstOnlyNamedScope::exseq_ConstOnlyNamedScope_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = ConstOnlyNamedScope_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void ConstOnlyNamedScope::exseq_ConstOnlyNamedScope_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = ConstOnlyNamedScope_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
void ConstOnlyNamedScope::exseq_ConstOnlyNamedScope_main_region_C()
{
	/* Default exit sequence for state C */
	stateConfVector[0] = ConstOnlyNamedScope_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void ConstOnlyNamedScope::exseq_ConstOnlyNamedScope_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of declarations.ConstOnlyNamedScope.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case ConstOnlyNamedScope_main_region_A :
		{
			exseq_ConstOnlyNamedScope_main_region_A();
			break;
		}
		case ConstOnlyNamedScope_main_region_B :
		{
			exseq_ConstOnlyNamedScope_main_region_B();
			break;
		}
		case ConstOnlyNamedScope_main_region_C :
		{
			exseq_ConstOnlyNamedScope_main_region_C();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void ConstOnlyNamedScope::react_ConstOnlyNamedScope_main_region_A()
{
	/* The reactions of state A. */
	if (check_ConstOnlyNamedScope_main_region_A_tr0_tr0())
	{ 
		effect_ConstOnlyNamedScope_main_region_A_tr0();
	}  else
	{
		if (check_ConstOnlyNamedScope_main_region_A_tr1_tr1())
		{ 
			effect_ConstOnlyNamedScope_main_region_A_tr1();
		} 
	}
}

/* The reactions of state B. */
void ConstOnlyNamedScope::react_ConstOnlyNamedScope_main_region_B()
{
	/* The reactions of state B. */
}

/* The reactions of state C. */
void ConstOnlyNamedScope::react_ConstOnlyNamedScope_main_region_C()
{
	/* The reactions of state C. */
}

/* Default react sequence for initial entry  */
void ConstOnlyNamedScope::react_ConstOnlyNamedScope_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_ConstOnlyNamedScope_main_region_A_default();
}


