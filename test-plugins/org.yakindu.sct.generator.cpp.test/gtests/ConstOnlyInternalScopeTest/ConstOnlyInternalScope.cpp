
#include "ConstOnlyInternalScope.h"
#include <string.h>

/*! \file Implementation of the state machine 'ConstOnlyInternalScope'
*/

ConstOnlyInternalScope::ConstOnlyInternalScope()
{
	
	
	stateConfVectorPosition = 0;
	
}

ConstOnlyInternalScope::~ConstOnlyInternalScope()
{
}

const sc_integer ConstOnlyInternalScope::InternalSCI::B = 1;
const sc_integer ConstOnlyInternalScope::InternalSCI::C = 2;


void ConstOnlyInternalScope::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = ConstOnlyInternalScope_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void ConstOnlyInternalScope::enter()
{
	/* Default enter sequence for statechart ConstOnlyInternalScope */
	enseq_ConstOnlyInternalScope_main_region_default();
}

void ConstOnlyInternalScope::exit()
{
	/* Default exit sequence for statechart ConstOnlyInternalScope */
	exseq_ConstOnlyInternalScope_main_region();
}

sc_boolean ConstOnlyInternalScope::isActive() const
{
	return stateConfVector[0] != ConstOnlyInternalScope_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean ConstOnlyInternalScope::isFinal() const
{
   return false;}

void ConstOnlyInternalScope::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case ConstOnlyInternalScope_main_region_A :
		{
			react_ConstOnlyInternalScope_main_region_A();
			break;
		}
		case ConstOnlyInternalScope_main_region_B :
		{
			react_ConstOnlyInternalScope_main_region_B();
			break;
		}
		case ConstOnlyInternalScope_main_region_C :
		{
			react_ConstOnlyInternalScope_main_region_C();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void ConstOnlyInternalScope::clearInEvents()
{
	iface.e_raised = false;
}

void ConstOnlyInternalScope::clearOutEvents()
{
}


sc_boolean ConstOnlyInternalScope::isStateActive(ConstOnlyInternalScopeStates state) const
{
	switch (state)
	{
		case ConstOnlyInternalScope_main_region_A : 
			return (sc_boolean) (stateConfVector[0] == ConstOnlyInternalScope_main_region_A
			);
		case ConstOnlyInternalScope_main_region_B : 
			return (sc_boolean) (stateConfVector[0] == ConstOnlyInternalScope_main_region_B
			);
		case ConstOnlyInternalScope_main_region_C : 
			return (sc_boolean) (stateConfVector[0] == ConstOnlyInternalScope_main_region_C
			);
		default: return false;
	}
}

ConstOnlyInternalScope::DefaultSCI* ConstOnlyInternalScope::getDefaultSCI()
{
	return &iface;
}

void ConstOnlyInternalScope::DefaultSCI::raise_e(sc_integer value)
{
	e_value = value;
	e_raised = true;
}

void ConstOnlyInternalScope::raise_e(sc_integer value)
{
	iface.raise_e(value);
}



const sc_integer ConstOnlyInternalScope::InternalSCI::get_b() const
{
	return B;
}

const sc_integer ConstOnlyInternalScope::InternalSCI::get_c() const
{
	return C;
}


// implementations of all internal functions

sc_boolean ConstOnlyInternalScope::check_ConstOnlyInternalScope_main_region_A_tr0_tr0()
{
	return (iface.e_raised) && (iface.e_value == ConstOnlyInternalScope::InternalSCI::B);
}

sc_boolean ConstOnlyInternalScope::check_ConstOnlyInternalScope_main_region_A_tr1_tr1()
{
	return (iface.e_raised) && (iface.e_value == ConstOnlyInternalScope::InternalSCI::C);
}

void ConstOnlyInternalScope::effect_ConstOnlyInternalScope_main_region_A_tr0()
{
	exseq_ConstOnlyInternalScope_main_region_A();
	enseq_ConstOnlyInternalScope_main_region_B_default();
}

void ConstOnlyInternalScope::effect_ConstOnlyInternalScope_main_region_A_tr1()
{
	exseq_ConstOnlyInternalScope_main_region_A();
	enseq_ConstOnlyInternalScope_main_region_C_default();
}

/* 'default' enter sequence for state A */
void ConstOnlyInternalScope::enseq_ConstOnlyInternalScope_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = ConstOnlyInternalScope_main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void ConstOnlyInternalScope::enseq_ConstOnlyInternalScope_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = ConstOnlyInternalScope_main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
void ConstOnlyInternalScope::enseq_ConstOnlyInternalScope_main_region_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[0] = ConstOnlyInternalScope_main_region_C;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void ConstOnlyInternalScope::enseq_ConstOnlyInternalScope_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_ConstOnlyInternalScope_main_region__entry_Default();
}

/* Default exit sequence for state A */
void ConstOnlyInternalScope::exseq_ConstOnlyInternalScope_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = ConstOnlyInternalScope_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void ConstOnlyInternalScope::exseq_ConstOnlyInternalScope_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = ConstOnlyInternalScope_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
void ConstOnlyInternalScope::exseq_ConstOnlyInternalScope_main_region_C()
{
	/* Default exit sequence for state C */
	stateConfVector[0] = ConstOnlyInternalScope_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void ConstOnlyInternalScope::exseq_ConstOnlyInternalScope_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of declarations.ConstOnlyInternalScope.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case ConstOnlyInternalScope_main_region_A :
		{
			exseq_ConstOnlyInternalScope_main_region_A();
			break;
		}
		case ConstOnlyInternalScope_main_region_B :
		{
			exseq_ConstOnlyInternalScope_main_region_B();
			break;
		}
		case ConstOnlyInternalScope_main_region_C :
		{
			exseq_ConstOnlyInternalScope_main_region_C();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void ConstOnlyInternalScope::react_ConstOnlyInternalScope_main_region_A()
{
	/* The reactions of state A. */
	if (check_ConstOnlyInternalScope_main_region_A_tr0_tr0())
	{ 
		effect_ConstOnlyInternalScope_main_region_A_tr0();
	}  else
	{
		if (check_ConstOnlyInternalScope_main_region_A_tr1_tr1())
		{ 
			effect_ConstOnlyInternalScope_main_region_A_tr1();
		} 
	}
}

/* The reactions of state B. */
void ConstOnlyInternalScope::react_ConstOnlyInternalScope_main_region_B()
{
	/* The reactions of state B. */
}

/* The reactions of state C. */
void ConstOnlyInternalScope::react_ConstOnlyInternalScope_main_region_C()
{
	/* The reactions of state C. */
}

/* Default react sequence for initial entry  */
void ConstOnlyInternalScope::react_ConstOnlyInternalScope_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_ConstOnlyInternalScope_main_region_A_default();
}


