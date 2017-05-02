
#include "StateIsActive.h"
#include <string.h>

/*! \file Implementation of the state machine 'StateIsActive'
*/

StateIsActive::StateIsActive()
{
	
	
	stateConfVectorPosition = 0;
	
}

StateIsActive::~StateIsActive()
{
}


void StateIsActive::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = StateIsActive_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void StateIsActive::enter()
{
	/* Default enter sequence for statechart StateIsActive */
	enseq_R1_default();
	enseq_R2_default();
}

void StateIsActive::exit()
{
	/* Default exit sequence for statechart StateIsActive */
	exseq_R1();
	exseq_R2();
}

sc_boolean StateIsActive::isActive() const
{
	return stateConfVector[0] != StateIsActive_last_state||stateConfVector[1] != StateIsActive_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean StateIsActive::isFinal() const
{
   return false;}

void StateIsActive::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case R1_R1A :
		{
			react_R1_R1A();
			break;
		}
		case R1_R1B :
		{
			react_R1_R1B();
			break;
		}
		case R2_R2A :
		{
			react_R2_R2A();
			break;
		}
		case R2_R2B :
		{
			react_R2_R2B();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void StateIsActive::clearInEvents()
{
	iface.Event1_raised = false;
}

void StateIsActive::clearOutEvents()
{
}


sc_boolean StateIsActive::isStateActive(StateIsActiveStates state) const
{
	switch (state)
	{
		case R1_R1A : 
			return (sc_boolean) (stateConfVector[0] == R1_R1A
			);
		case R1_R1B : 
			return (sc_boolean) (stateConfVector[0] == R1_R1B
			);
		case R2_R2A : 
			return (sc_boolean) (stateConfVector[1] == R2_R2A
			);
		case R2_R2B : 
			return (sc_boolean) (stateConfVector[1] == R2_R2B
			);
		default: return false;
	}
}

StateIsActive::DefaultSCI* StateIsActive::getDefaultSCI()
{
	return &iface;
}

void StateIsActive::DefaultSCI::raise_event1()
{
	Event1_raised = true;
}

void StateIsActive::raise_event1()
{
	iface.raise_event1();
}



// implementations of all internal functions

sc_boolean StateIsActive::check_R1_R1A_tr0_tr0()
{
	return isStateActive(R2_R2B);
}

sc_boolean StateIsActive::check_R2_R2A_tr0_tr0()
{
	return iface.Event1_raised;
}

void StateIsActive::effect_R1_R1A_tr0()
{
	exseq_R1_R1A();
	enseq_R1_R1B_default();
}

void StateIsActive::effect_R2_R2A_tr0()
{
	exseq_R2_R2A();
	enseq_R2_R2B_default();
}

/* 'default' enter sequence for state R1A */
void StateIsActive::enseq_R1_R1A_default()
{
	/* 'default' enter sequence for state R1A */
	stateConfVector[0] = R1_R1A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state R1B */
void StateIsActive::enseq_R1_R1B_default()
{
	/* 'default' enter sequence for state R1B */
	stateConfVector[0] = R1_R1B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state R2A */
void StateIsActive::enseq_R2_R2A_default()
{
	/* 'default' enter sequence for state R2A */
	stateConfVector[1] = R2_R2A;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state R2B */
void StateIsActive::enseq_R2_R2B_default()
{
	/* 'default' enter sequence for state R2B */
	stateConfVector[1] = R2_R2B;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region R1 */
void StateIsActive::enseq_R1_default()
{
	/* 'default' enter sequence for region R1 */
	react_R1__entry_Default();
}

/* 'default' enter sequence for region R2 */
void StateIsActive::enseq_R2_default()
{
	/* 'default' enter sequence for region R2 */
	react_R2__entry_Default();
}

/* Default exit sequence for state R1A */
void StateIsActive::exseq_R1_R1A()
{
	/* Default exit sequence for state R1A */
	stateConfVector[0] = StateIsActive_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state R1B */
void StateIsActive::exseq_R1_R1B()
{
	/* Default exit sequence for state R1B */
	stateConfVector[0] = StateIsActive_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state R2A */
void StateIsActive::exseq_R2_R2A()
{
	/* Default exit sequence for state R2A */
	stateConfVector[1] = StateIsActive_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state R2B */
void StateIsActive::exseq_R2_R2B()
{
	/* Default exit sequence for state R2B */
	stateConfVector[1] = StateIsActive_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for region R1 */
void StateIsActive::exseq_R1()
{
	/* Default exit sequence for region R1 */
	/* Handle exit of all possible states (of StateIsActive.R1) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case R1_R1A :
		{
			exseq_R1_R1A();
			break;
		}
		case R1_R1B :
		{
			exseq_R1_R1B();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region R2 */
void StateIsActive::exseq_R2()
{
	/* Default exit sequence for region R2 */
	/* Handle exit of all possible states (of StateIsActive.R2) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case R2_R2A :
		{
			exseq_R2_R2A();
			break;
		}
		case R2_R2B :
		{
			exseq_R2_R2B();
			break;
		}
		default: break;
	}
}

/* The reactions of state R1A. */
void StateIsActive::react_R1_R1A()
{
	/* The reactions of state R1A. */
	if (check_R1_R1A_tr0_tr0())
	{ 
		effect_R1_R1A_tr0();
	} 
}

/* The reactions of state R1B. */
void StateIsActive::react_R1_R1B()
{
	/* The reactions of state R1B. */
}

/* The reactions of state R2A. */
void StateIsActive::react_R2_R2A()
{
	/* The reactions of state R2A. */
	if (check_R2_R2A_tr0_tr0())
	{ 
		effect_R2_R2A_tr0();
	} 
}

/* The reactions of state R2B. */
void StateIsActive::react_R2_R2B()
{
}

/* Default react sequence for initial entry  */
void StateIsActive::react_R1__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_R1_R1A_default();
}

/* Default react sequence for initial entry  */
void StateIsActive::react_R2__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_R2_R2A_default();
}


