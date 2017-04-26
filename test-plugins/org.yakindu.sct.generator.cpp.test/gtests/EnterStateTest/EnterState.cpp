
#include "EnterState.h"
#include <string.h>

/*! \file Implementation of the state machine 'EnterState'
*/

EnterState::EnterState()
{
	
	
	stateConfVectorPosition = 0;
	
}

EnterState::~EnterState()
{
}


void EnterState::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = EnterState_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void EnterState::enter()
{
	/* Default enter sequence for statechart EnterState */
	enseq_r_default();
}

void EnterState::exit()
{
	/* Default exit sequence for statechart EnterState */
	exseq_r();
}

sc_boolean EnterState::isActive() const
{
	return stateConfVector[0] != EnterState_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean EnterState::isFinal() const
{
   return false;}

void EnterState::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case r_A :
		{
			react_r_A();
			break;
		}
		case r_B_r_E :
		{
			react_r_B_r_E();
			break;
		}
		case r_B_r_F :
		{
			react_r_B_r_F();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void EnterState::clearInEvents()
{
	iface.e_raised = false;
	iface.f_raised = false;
	iface.g_raised = false;
}

void EnterState::clearOutEvents()
{
}


sc_boolean EnterState::isStateActive(EnterStateStates state) const
{
	switch (state)
	{
		case r_A : 
			return (sc_boolean) (stateConfVector[0] == r_A
			);
		case r_B : 
			return (sc_boolean) (stateConfVector[0] >= r_B
				&& stateConfVector[0] <= r_B_r_F);
		case r_B_r_E : 
			return (sc_boolean) (stateConfVector[0] == r_B_r_E
			);
		case r_B_r_F : 
			return (sc_boolean) (stateConfVector[0] == r_B_r_F
			);
		default: return false;
	}
}

EnterState::DefaultSCI* EnterState::getDefaultSCI()
{
	return &iface;
}

void EnterState::DefaultSCI::raise_e()
{
	e_raised = true;
}

void EnterState::raise_e()
{
	iface.raise_e();
}

void EnterState::DefaultSCI::raise_f()
{
	f_raised = true;
}

void EnterState::raise_f()
{
	iface.raise_f();
}

void EnterState::DefaultSCI::raise_g()
{
	g_raised = true;
}

void EnterState::raise_g()
{
	iface.raise_g();
}



// implementations of all internal functions

sc_boolean EnterState::check_r_A_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean EnterState::check_r_A_tr1_tr1()
{
	return iface.f_raised;
}

sc_boolean EnterState::check_r_A_tr2_tr2()
{
	return iface.g_raised;
}

void EnterState::effect_r_A_tr0()
{
	exseq_r_A();
	enseq_r_B_default();
}

void EnterState::effect_r_A_tr1()
{
	exseq_r_A();
	enseq_r_B_f();
}

void EnterState::effect_r_A_tr2()
{
	exseq_r_A();
	enseq_r_B_g();
}

/* 'default' enter sequence for state A */
void EnterState::enseq_r_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = r_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void EnterState::enseq_r_B_default()
{
	/* 'default' enter sequence for state B */
	enseq_r_B_r_default();
}

/* 'f' enter sequence for state B */
void EnterState::enseq_r_B_f()
{
	/* 'f' enter sequence for state B */
	enseq_r_B_r_f();
}

/* 'g' enter sequence for state B */
void EnterState::enseq_r_B_g()
{
	/* 'g' enter sequence for state B */
	enseq_r_B_r_default();
}

/* 'default' enter sequence for state E */
void EnterState::enseq_r_B_r_E_default()
{
	/* 'default' enter sequence for state E */
	stateConfVector[0] = r_B_r_E;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state F */
void EnterState::enseq_r_B_r_F_default()
{
	/* 'default' enter sequence for state F */
	stateConfVector[0] = r_B_r_F;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region r */
void EnterState::enseq_r_default()
{
	/* 'default' enter sequence for region r */
	react_r__entry_Default();
}

/* 'default' enter sequence for region r */
void EnterState::enseq_r_B_r_default()
{
	/* 'default' enter sequence for region r */
	react_r_B_r__entry_Default();
}

/* 'f' enter sequence for region r */
void EnterState::enseq_r_B_r_f()
{
	/* 'f' enter sequence for region r */
	react_r_B_r_f();
}

/* Default exit sequence for state A */
void EnterState::exseq_r_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = EnterState_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state E */
void EnterState::exseq_r_B_r_E()
{
	/* Default exit sequence for state E */
	stateConfVector[0] = EnterState_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state F */
void EnterState::exseq_r_B_r_F()
{
	/* Default exit sequence for state F */
	stateConfVector[0] = EnterState_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region r */
void EnterState::exseq_r()
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of EnterState.r) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case r_A :
		{
			exseq_r_A();
			break;
		}
		case r_B_r_E :
		{
			exseq_r_B_r_E();
			break;
		}
		case r_B_r_F :
		{
			exseq_r_B_r_F();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
void EnterState::exseq_r_B_r()
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of EnterState.r.B.r) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case r_B_r_E :
		{
			exseq_r_B_r_E();
			break;
		}
		case r_B_r_F :
		{
			exseq_r_B_r_F();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void EnterState::react_r_A()
{
	/* The reactions of state A. */
	if (check_r_A_tr0_tr0())
	{ 
		effect_r_A_tr0();
	}  else
	{
		if (check_r_A_tr1_tr1())
		{ 
			effect_r_A_tr1();
		}  else
		{
			if (check_r_A_tr2_tr2())
			{ 
				effect_r_A_tr2();
			} 
		}
	}
}

/* The reactions of state E. */
void EnterState::react_r_B_r_E()
{
	/* The reactions of state E. */
}

/* The reactions of state F. */
void EnterState::react_r_B_r_F()
{
	/* The reactions of state F. */
}

/* Default react sequence for initial entry  */
void EnterState::react_r__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_r_A_default();
}

/* Default react sequence for initial entry  */
void EnterState::react_r_B_r__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_r_B_r_E_default();
}

/* Default react sequence for initial entry f */
void EnterState::react_r_B_r_f()
{
	/* Default react sequence for initial entry f */
	enseq_r_B_r_F_default();
}


