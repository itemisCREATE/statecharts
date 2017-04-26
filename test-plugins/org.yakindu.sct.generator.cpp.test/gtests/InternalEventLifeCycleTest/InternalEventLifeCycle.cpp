
#include "InternalEventLifeCycle.h"
#include <string.h>

/*! \file Implementation of the state machine 'InternalEventLifeCycle'
*/

InternalEventLifeCycle::InternalEventLifeCycle()
{
	
	
	stateConfVectorPosition = 0;
	
}

InternalEventLifeCycle::~InternalEventLifeCycle()
{
}


void InternalEventLifeCycle::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = InternalEventLifeCycle_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void InternalEventLifeCycle::enter()
{
	/* Default enter sequence for statechart InternalEventLifeCycle */
	enseq_r1_default();
	enseq_r2_default();
}

void InternalEventLifeCycle::exit()
{
	/* Default exit sequence for statechart InternalEventLifeCycle */
	exseq_r1();
	exseq_r2();
}

sc_boolean InternalEventLifeCycle::isActive() const
{
	return stateConfVector[0] != InternalEventLifeCycle_last_state||stateConfVector[1] != InternalEventLifeCycle_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean InternalEventLifeCycle::isFinal() const
{
   return false;}

void InternalEventLifeCycle::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case r1_A :
		{
			react_r1_A();
			break;
		}
		case r1_B :
		{
			react_r1_B();
			break;
		}
		case r2_C :
		{
			react_r2_C();
			break;
		}
		case r2_D :
		{
			react_r2_D();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void InternalEventLifeCycle::clearInEvents()
{
	iface.e_raised = false;
	iface.f_raised = false;
	ifaceInternalSCI.i1_raised = false; 
	ifaceInternalSCI.i2_raised = false; 
}

void InternalEventLifeCycle::clearOutEvents()
{
}


sc_boolean InternalEventLifeCycle::isStateActive(InternalEventLifeCycleStates state) const
{
	switch (state)
	{
		case r1_A : 
			return (sc_boolean) (stateConfVector[0] == r1_A
			);
		case r1_B : 
			return (sc_boolean) (stateConfVector[0] == r1_B
			);
		case r2_C : 
			return (sc_boolean) (stateConfVector[1] == r2_C
			);
		case r2_D : 
			return (sc_boolean) (stateConfVector[1] == r2_D
			);
		default: return false;
	}
}

InternalEventLifeCycle::DefaultSCI* InternalEventLifeCycle::getDefaultSCI()
{
	return &iface;
}

void InternalEventLifeCycle::DefaultSCI::raise_e()
{
	e_raised = true;
}

void InternalEventLifeCycle::raise_e()
{
	iface.raise_e();
}

void InternalEventLifeCycle::DefaultSCI::raise_f()
{
	f_raised = true;
}

void InternalEventLifeCycle::raise_f()
{
	iface.raise_f();
}



void InternalEventLifeCycle::InternalSCI::raise_i1()
{
	i1_raised = true;
}

sc_boolean InternalEventLifeCycle::InternalSCI::isRaised_i1() const
{
	return i1_raised;
}

void InternalEventLifeCycle::InternalSCI::raise_i2()
{
	i2_raised = true;
}

sc_boolean InternalEventLifeCycle::InternalSCI::isRaised_i2() const
{
	return i2_raised;
}


// implementations of all internal functions

sc_boolean InternalEventLifeCycle::check_r1_A_tr0_tr0()
{
	return ifaceInternalSCI.i2_raised;
}

sc_boolean InternalEventLifeCycle::check_r1_A_lr0_lr0()
{
	return iface.e_raised;
}

sc_boolean InternalEventLifeCycle::check_r1_B_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean InternalEventLifeCycle::check_r2_C_tr0_tr0()
{
	return ifaceInternalSCI.i1_raised;
}

sc_boolean InternalEventLifeCycle::check_r2_D_tr0_tr0()
{
	return iface.f_raised;
}

void InternalEventLifeCycle::effect_r1_A_tr0()
{
	exseq_r1_A();
	enseq_r1_B_default();
}

void InternalEventLifeCycle::effect_r1_A_lr0_lr0()
{
	ifaceInternalSCI.i1_raised = true;
}

void InternalEventLifeCycle::effect_r1_B_tr0()
{
	exseq_r1_B();
	enseq_r1_A_default();
}

void InternalEventLifeCycle::effect_r2_C_tr0()
{
	exseq_r2_C();
	enseq_r2_D_default();
}

void InternalEventLifeCycle::effect_r2_D_tr0()
{
	exseq_r2_D();
	ifaceInternalSCI.i2_raised = true;
	enseq_r2_C_default();
}

/* 'default' enter sequence for state A */
void InternalEventLifeCycle::enseq_r1_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = r1_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void InternalEventLifeCycle::enseq_r1_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = r1_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
void InternalEventLifeCycle::enseq_r2_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[1] = r2_C;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state D */
void InternalEventLifeCycle::enseq_r2_D_default()
{
	/* 'default' enter sequence for state D */
	stateConfVector[1] = r2_D;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region r1 */
void InternalEventLifeCycle::enseq_r1_default()
{
	/* 'default' enter sequence for region r1 */
	react_r1__entry_Default();
}

/* 'default' enter sequence for region r2 */
void InternalEventLifeCycle::enseq_r2_default()
{
	/* 'default' enter sequence for region r2 */
	react_r2__entry_Default();
}

/* Default exit sequence for state A */
void InternalEventLifeCycle::exseq_r1_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = InternalEventLifeCycle_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void InternalEventLifeCycle::exseq_r1_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = InternalEventLifeCycle_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
void InternalEventLifeCycle::exseq_r2_C()
{
	/* Default exit sequence for state C */
	stateConfVector[1] = InternalEventLifeCycle_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state D */
void InternalEventLifeCycle::exseq_r2_D()
{
	/* Default exit sequence for state D */
	stateConfVector[1] = InternalEventLifeCycle_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for region r1 */
void InternalEventLifeCycle::exseq_r1()
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of InternalEventLifeCycle.r1) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case r1_A :
		{
			exseq_r1_A();
			break;
		}
		case r1_B :
		{
			exseq_r1_B();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r2 */
void InternalEventLifeCycle::exseq_r2()
{
	/* Default exit sequence for region r2 */
	/* Handle exit of all possible states (of InternalEventLifeCycle.r2) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case r2_C :
		{
			exseq_r2_C();
			break;
		}
		case r2_D :
		{
			exseq_r2_D();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void InternalEventLifeCycle::react_r1_A()
{
	/* The reactions of state A. */
	if (check_r1_A_tr0_tr0())
	{ 
		effect_r1_A_tr0();
	}  else
	{
		if (check_r1_A_lr0_lr0())
		{ 
			effect_r1_A_lr0_lr0();
		} 
	}
}

/* The reactions of state B. */
void InternalEventLifeCycle::react_r1_B()
{
	/* The reactions of state B. */
	if (check_r1_B_tr0_tr0())
	{ 
		effect_r1_B_tr0();
	} 
}

/* The reactions of state C. */
void InternalEventLifeCycle::react_r2_C()
{
	/* The reactions of state C. */
	if (check_r2_C_tr0_tr0())
	{ 
		effect_r2_C_tr0();
	} 
}

/* The reactions of state D. */
void InternalEventLifeCycle::react_r2_D()
{
	/* The reactions of state D. */
	if (check_r2_D_tr0_tr0())
	{ 
		effect_r2_D_tr0();
	} 
}

/* Default react sequence for initial entry  */
void InternalEventLifeCycle::react_r1__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_r1_A_default();
}

/* Default react sequence for initial entry  */
void InternalEventLifeCycle::react_r2__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_r2_C_default();
}


