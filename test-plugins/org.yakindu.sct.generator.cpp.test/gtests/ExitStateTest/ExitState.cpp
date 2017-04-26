
#include "ExitState.h"
#include <string.h>

/*! \file Implementation of the state machine 'ExitState'
*/

ExitState::ExitState()
{
	
	
	stateConfVectorPosition = 0;
	
}

ExitState::~ExitState()
{
}


void ExitState::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = ExitState_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void ExitState::enter()
{
	/* Default enter sequence for statechart ExitState */
	enseq_r_default();
}

void ExitState::exit()
{
	/* Default exit sequence for statechart ExitState */
	exseq_r();
}

sc_boolean ExitState::isActive() const
{
	return stateConfVector[0] != ExitState_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean ExitState::isFinal() const
{
   return false;}

void ExitState::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case r_A_r_B :
		{
			react_r_A_r_B();
			break;
		}
		case r_E :
		{
			react_r_E();
			break;
		}
		case r_F :
		{
			react_r_F();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void ExitState::clearInEvents()
{
	iface.e_raised = false;
	iface.f_raised = false;
	iface.g_raised = false;
}

void ExitState::clearOutEvents()
{
}


sc_boolean ExitState::isStateActive(ExitStateStates state) const
{
	switch (state)
	{
		case r_A : 
			return (sc_boolean) (stateConfVector[0] >= r_A
				&& stateConfVector[0] <= r_A_r_B);
		case r_A_r_B : 
			return (sc_boolean) (stateConfVector[0] == r_A_r_B
			);
		case r_E : 
			return (sc_boolean) (stateConfVector[0] == r_E
			);
		case r_F : 
			return (sc_boolean) (stateConfVector[0] == r_F
			);
		default: return false;
	}
}

ExitState::DefaultSCI* ExitState::getDefaultSCI()
{
	return &iface;
}

void ExitState::DefaultSCI::raise_e()
{
	e_raised = true;
}

void ExitState::raise_e()
{
	iface.raise_e();
}

void ExitState::DefaultSCI::raise_f()
{
	f_raised = true;
}

void ExitState::raise_f()
{
	iface.raise_f();
}

void ExitState::DefaultSCI::raise_g()
{
	g_raised = true;
}

void ExitState::raise_g()
{
	iface.raise_g();
}



// implementations of all internal functions

sc_boolean ExitState::check_r_A_r_B_tr0_tr0()
{
	return iface.g_raised;
}

sc_boolean ExitState::check_r_A_r_B_tr1_tr1()
{
	return iface.f_raised;
}

sc_boolean ExitState::check_r_A_r_B_tr2_tr2()
{
	return iface.e_raised;
}

void ExitState::effect_r_A_tr0()
{
	exseq_r_A();
	enseq_r_E_default();
}

void ExitState::effect_r_A_tr1()
{
	exseq_r_A();
	enseq_r_F_default();
}

void ExitState::effect_r_A_r_B_tr0()
{
	exseq_r_A_r_B();
	react_r_A_r_g();
}

void ExitState::effect_r_A_r_B_tr1()
{
	exseq_r_A_r_B();
	react_r_A_r_f();
}

void ExitState::effect_r_A_r_B_tr2()
{
	exseq_r_A_r_B();
	react_r_A_r__exit_Default();
}

/* 'default' enter sequence for state A */
void ExitState::enseq_r_A_default()
{
	/* 'default' enter sequence for state A */
	enseq_r_A_r_default();
}

/* 'default' enter sequence for state B */
void ExitState::enseq_r_A_r_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = r_A_r_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state E */
void ExitState::enseq_r_E_default()
{
	/* 'default' enter sequence for state E */
	stateConfVector[0] = r_E;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state F */
void ExitState::enseq_r_F_default()
{
	/* 'default' enter sequence for state F */
	stateConfVector[0] = r_F;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region r */
void ExitState::enseq_r_default()
{
	/* 'default' enter sequence for region r */
	react_r__entry_Default();
}

/* 'default' enter sequence for region r */
void ExitState::enseq_r_A_r_default()
{
	/* 'default' enter sequence for region r */
	react_r_A_r__entry_Default();
}

/* Default exit sequence for state A */
void ExitState::exseq_r_A()
{
	/* Default exit sequence for state A */
	exseq_r_A_r();
}

/* Default exit sequence for state B */
void ExitState::exseq_r_A_r_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = ExitState_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state E */
void ExitState::exseq_r_E()
{
	/* Default exit sequence for state E */
	stateConfVector[0] = ExitState_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state F */
void ExitState::exseq_r_F()
{
	/* Default exit sequence for state F */
	stateConfVector[0] = ExitState_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region r */
void ExitState::exseq_r()
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of ExitState.r) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case r_A_r_B :
		{
			exseq_r_A_r_B();
			break;
		}
		case r_E :
		{
			exseq_r_E();
			break;
		}
		case r_F :
		{
			exseq_r_F();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
void ExitState::exseq_r_A_r()
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of ExitState.r.A.r) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case r_A_r_B :
		{
			exseq_r_A_r_B();
			break;
		}
		default: break;
	}
}

/* The reactions of state B. */
void ExitState::react_r_A_r_B()
{
	/* The reactions of state B. */
	if (check_r_A_r_B_tr0_tr0())
	{ 
		effect_r_A_r_B_tr0();
	}  else
	{
		if (check_r_A_r_B_tr1_tr1())
		{ 
			effect_r_A_r_B_tr1();
		}  else
		{
			if (check_r_A_r_B_tr2_tr2())
			{ 
				effect_r_A_r_B_tr2();
			} 
		}
	}
}

/* The reactions of state E. */
void ExitState::react_r_E()
{
	/* The reactions of state E. */
}

/* The reactions of state F. */
void ExitState::react_r_F()
{
	/* The reactions of state F. */
}

/* Default react sequence for initial entry  */
void ExitState::react_r__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_r_A_default();
}

/* Default react sequence for initial entry  */
void ExitState::react_r_A_r__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_r_A_r_B_default();
}

/* The reactions of exit default. */
void ExitState::react_r_A_r__exit_Default()
{
	/* The reactions of exit default. */
	effect_r_A_tr0();
}

/* The reactions of exit f. */
void ExitState::react_r_A_r_f()
{
	/* The reactions of exit f. */
	effect_r_A_tr1();
}

/* The reactions of exit g. */
void ExitState::react_r_A_r_g()
{
	/* The reactions of exit g. */
	effect_r_A_tr0();
}


