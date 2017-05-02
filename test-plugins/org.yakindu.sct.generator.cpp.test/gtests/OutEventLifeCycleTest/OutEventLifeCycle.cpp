
#include "OutEventLifeCycle.h"
#include <string.h>

/*! \file Implementation of the state machine 'OutEventLifeCycle'
*/

OutEventLifeCycle::OutEventLifeCycle()
{
	
	
	stateConfVectorPosition = 0;
	
}

OutEventLifeCycle::~OutEventLifeCycle()
{
}


void OutEventLifeCycle::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = OutEventLifeCycle_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart OutEventLifeCycle */
	iface.f_available_in_cycle = false;
	iface.f_available_in_next_cycle = false;
}

void OutEventLifeCycle::enter()
{
	/* Default enter sequence for statechart OutEventLifeCycle */
	enseq_r1_default();
	enseq_r2_default();
}

void OutEventLifeCycle::exit()
{
	/* Default exit sequence for statechart OutEventLifeCycle */
	exseq_r1();
	exseq_r2();
}

sc_boolean OutEventLifeCycle::isActive() const
{
	return stateConfVector[0] != OutEventLifeCycle_last_state||stateConfVector[1] != OutEventLifeCycle_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean OutEventLifeCycle::isFinal() const
{
   return false;}

void OutEventLifeCycle::runCycle()
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
		case r2_B :
		{
			react_r2_B();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void OutEventLifeCycle::clearInEvents()
{
	iface.e_raised = false;
}

void OutEventLifeCycle::clearOutEvents()
{
	iface.f_raised = false;
}


sc_boolean OutEventLifeCycle::isStateActive(OutEventLifeCycleStates state) const
{
	switch (state)
	{
		case r1_A : 
			return (sc_boolean) (stateConfVector[0] == r1_A
			);
		case r1_B : 
			return (sc_boolean) (stateConfVector[0] == r1_B
			);
		case r2_B : 
			return (sc_boolean) (stateConfVector[1] == r2_B
			);
		default: return false;
	}
}

OutEventLifeCycle::DefaultSCI* OutEventLifeCycle::getDefaultSCI()
{
	return &iface;
}

void OutEventLifeCycle::DefaultSCI::raise_e()
{
	e_raised = true;
}

void OutEventLifeCycle::raise_e()
{
	iface.raise_e();
}

sc_boolean OutEventLifeCycle::DefaultSCI::isRaised_f() const
{
	return f_raised;
}

sc_boolean OutEventLifeCycle::isRaised_f() const
{
	return iface.isRaised_f();
}


sc_boolean OutEventLifeCycle::DefaultSCI::get_f_available_in_cycle() const
{
	return f_available_in_cycle;
}

sc_boolean OutEventLifeCycle::get_f_available_in_cycle() const
{
	return iface.f_available_in_cycle;
}

void OutEventLifeCycle::DefaultSCI::set_f_available_in_cycle(sc_boolean value)
{
	f_available_in_cycle = value;
}

void OutEventLifeCycle::set_f_available_in_cycle(sc_boolean value)
{
	iface.f_available_in_cycle = value;
}

sc_boolean OutEventLifeCycle::DefaultSCI::get_f_available_in_next_cycle() const
{
	return f_available_in_next_cycle;
}

sc_boolean OutEventLifeCycle::get_f_available_in_next_cycle() const
{
	return iface.f_available_in_next_cycle;
}

void OutEventLifeCycle::DefaultSCI::set_f_available_in_next_cycle(sc_boolean value)
{
	f_available_in_next_cycle = value;
}

void OutEventLifeCycle::set_f_available_in_next_cycle(sc_boolean value)
{
	iface.f_available_in_next_cycle = value;
}


// implementations of all internal functions

sc_boolean OutEventLifeCycle::check_r1_A_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean OutEventLifeCycle::check_r1_B_lr0_lr0()
{
	return iface.f_raised;
}

sc_boolean OutEventLifeCycle::check_r2_B_lr0_lr0()
{
	return iface.f_raised;
}

void OutEventLifeCycle::effect_r1_A_tr0()
{
	exseq_r1_A();
	iface.f_raised = true;
	enseq_r1_B_default();
}

void OutEventLifeCycle::effect_r1_B_lr0_lr0()
{
	iface.f_available_in_next_cycle = true;
}

void OutEventLifeCycle::effect_r2_B_lr0_lr0()
{
	iface.f_available_in_cycle = true;
}

/* 'default' enter sequence for state A */
void OutEventLifeCycle::enseq_r1_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = r1_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void OutEventLifeCycle::enseq_r1_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = r1_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void OutEventLifeCycle::enseq_r2_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[1] = r2_B;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region r1 */
void OutEventLifeCycle::enseq_r1_default()
{
	/* 'default' enter sequence for region r1 */
	react_r1__entry_Default();
}

/* 'default' enter sequence for region r2 */
void OutEventLifeCycle::enseq_r2_default()
{
	/* 'default' enter sequence for region r2 */
	react_r2__entry_Default();
}

/* Default exit sequence for state A */
void OutEventLifeCycle::exseq_r1_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = OutEventLifeCycle_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void OutEventLifeCycle::exseq_r1_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = OutEventLifeCycle_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void OutEventLifeCycle::exseq_r2_B()
{
	/* Default exit sequence for state B */
	stateConfVector[1] = OutEventLifeCycle_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for region r1 */
void OutEventLifeCycle::exseq_r1()
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of OutEventLifeCycle.r1) at position 0... */
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
void OutEventLifeCycle::exseq_r2()
{
	/* Default exit sequence for region r2 */
	/* Handle exit of all possible states (of OutEventLifeCycle.r2) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case r2_B :
		{
			exseq_r2_B();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void OutEventLifeCycle::react_r1_A()
{
	/* The reactions of state A. */
	if (check_r1_A_tr0_tr0())
	{ 
		effect_r1_A_tr0();
	} 
}

/* The reactions of state B. */
void OutEventLifeCycle::react_r1_B()
{
	/* The reactions of state B. */
	if (check_r1_B_lr0_lr0())
	{ 
		effect_r1_B_lr0_lr0();
	} 
}

/* The reactions of state B. */
void OutEventLifeCycle::react_r2_B()
{
	/* The reactions of state B. */
	if (check_r2_B_lr0_lr0())
	{ 
		effect_r2_B_lr0_lr0();
	} 
}

/* Default react sequence for initial entry  */
void OutEventLifeCycle::react_r1__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_r1_A_default();
}

/* Default react sequence for initial entry  */
void OutEventLifeCycle::react_r2__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_r2_B_default();
}


