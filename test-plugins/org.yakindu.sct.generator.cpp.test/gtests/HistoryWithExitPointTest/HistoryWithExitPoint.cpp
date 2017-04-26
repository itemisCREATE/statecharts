
#include "HistoryWithExitPoint.h"
#include <string.h>

/*! \file Implementation of the state machine 'HistoryWithExitPoint'
*/

HistoryWithExitPoint::HistoryWithExitPoint()
{
	
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = HistoryWithExitPoint_last_state;
	
	stateConfVectorPosition = 0;
	
}

HistoryWithExitPoint::~HistoryWithExitPoint()
{
}


void HistoryWithExitPoint::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = HistoryWithExitPoint_last_state;
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = HistoryWithExitPoint_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void HistoryWithExitPoint::enter()
{
	/* Default enter sequence for statechart HistoryWithExitPoint */
	enseq_mr_default();
}

void HistoryWithExitPoint::exit()
{
	/* Default exit sequence for statechart HistoryWithExitPoint */
	exseq_mr();
}

sc_boolean HistoryWithExitPoint::isActive() const
{
	return stateConfVector[0] != HistoryWithExitPoint_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean HistoryWithExitPoint::isFinal() const
{
   return false;}

void HistoryWithExitPoint::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case mr_A_r_X1 :
		{
			react_mr_A_r_X1();
			break;
		}
		case mr_A_r_X2 :
		{
			react_mr_A_r_X2();
			break;
		}
		case mr_B :
		{
			react_mr_B();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void HistoryWithExitPoint::clearInEvents()
{
	iface.push_raised = false;
	iface.back_raised = false;
	iface.next_raised = false;
}

void HistoryWithExitPoint::clearOutEvents()
{
}


sc_boolean HistoryWithExitPoint::isStateActive(HistoryWithExitPointStates state) const
{
	switch (state)
	{
		case mr_A : 
			return (sc_boolean) (stateConfVector[0] >= mr_A
				&& stateConfVector[0] <= mr_A_r_X2);
		case mr_A_r_X1 : 
			return (sc_boolean) (stateConfVector[0] == mr_A_r_X1
			);
		case mr_A_r_X2 : 
			return (sc_boolean) (stateConfVector[0] == mr_A_r_X2
			);
		case mr_B : 
			return (sc_boolean) (stateConfVector[0] == mr_B
			);
		default: return false;
	}
}

HistoryWithExitPoint::DefaultSCI* HistoryWithExitPoint::getDefaultSCI()
{
	return &iface;
}

void HistoryWithExitPoint::DefaultSCI::raise_push()
{
	push_raised = true;
}

void HistoryWithExitPoint::raise_push()
{
	iface.raise_push();
}

void HistoryWithExitPoint::DefaultSCI::raise_back()
{
	back_raised = true;
}

void HistoryWithExitPoint::raise_back()
{
	iface.raise_back();
}

void HistoryWithExitPoint::DefaultSCI::raise_next()
{
	next_raised = true;
}

void HistoryWithExitPoint::raise_next()
{
	iface.raise_next();
}



// implementations of all internal functions

sc_boolean HistoryWithExitPoint::check_mr_A_r_X1_tr0_tr0()
{
	return iface.next_raised;
}

sc_boolean HistoryWithExitPoint::check_mr_A_r_X1_tr1_tr1()
{
	return iface.push_raised;
}

sc_boolean HistoryWithExitPoint::check_mr_A_r_X2_tr0_tr0()
{
	return iface.next_raised;
}

sc_boolean HistoryWithExitPoint::check_mr_A_r_X2_tr1_tr1()
{
	return iface.push_raised;
}

sc_boolean HistoryWithExitPoint::check_mr_B_tr0_tr0()
{
	return iface.back_raised;
}

void HistoryWithExitPoint::effect_mr_A_tr0()
{
	exseq_mr_A();
	enseq_mr_B_default();
}

void HistoryWithExitPoint::effect_mr_A_r_X1_tr0()
{
	exseq_mr_A_r_X1();
	enseq_mr_A_r_X2_default();
}

void HistoryWithExitPoint::effect_mr_A_r_X1_tr1()
{
	exseq_mr_A_r_X1();
	react_mr_A_r_exit_to_B();
}

void HistoryWithExitPoint::effect_mr_A_r_X2_tr0()
{
	exseq_mr_A_r_X2();
	enseq_mr_A_r_X1_default();
}

void HistoryWithExitPoint::effect_mr_A_r_X2_tr1()
{
	exseq_mr_A_r_X2();
	react_mr_A_r_exit_to_B();
}

void HistoryWithExitPoint::effect_mr_B_tr0()
{
	exseq_mr_B();
	enseq_mr_A_default();
}

/* 'default' enter sequence for state A */
void HistoryWithExitPoint::enseq_mr_A_default()
{
	/* 'default' enter sequence for state A */
	enseq_mr_A_r_default();
}

/* 'default' enter sequence for state X1 */
void HistoryWithExitPoint::enseq_mr_A_r_X1_default()
{
	/* 'default' enter sequence for state X1 */
	stateConfVector[0] = mr_A_r_X1;
	stateConfVectorPosition = 0;
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state X2 */
void HistoryWithExitPoint::enseq_mr_A_r_X2_default()
{
	/* 'default' enter sequence for state X2 */
	stateConfVector[0] = mr_A_r_X2;
	stateConfVectorPosition = 0;
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state B */
void HistoryWithExitPoint::enseq_mr_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = mr_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region mr */
void HistoryWithExitPoint::enseq_mr_default()
{
	/* 'default' enter sequence for region mr */
	react_mr__entry_Default();
}

/* 'default' enter sequence for region r */
void HistoryWithExitPoint::enseq_mr_A_r_default()
{
	/* 'default' enter sequence for region r */
	react_mr_A_r__entry_Default();
}

/* shallow enterSequence with history in child r */
void HistoryWithExitPoint::shenseq_mr_A_r()
{
	/* shallow enterSequence with history in child r */
	/* Handle shallow history entry of r */
	switch(historyVector[ 0 ])
	{
		case mr_A_r_X1 :
		{
			enseq_mr_A_r_X1_default();
			break;
		}
		case mr_A_r_X2 :
		{
			enseq_mr_A_r_X2_default();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for state A */
void HistoryWithExitPoint::exseq_mr_A()
{
	/* Default exit sequence for state A */
	exseq_mr_A_r();
}

/* Default exit sequence for state X1 */
void HistoryWithExitPoint::exseq_mr_A_r_X1()
{
	/* Default exit sequence for state X1 */
	stateConfVector[0] = HistoryWithExitPoint_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state X2 */
void HistoryWithExitPoint::exseq_mr_A_r_X2()
{
	/* Default exit sequence for state X2 */
	stateConfVector[0] = HistoryWithExitPoint_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void HistoryWithExitPoint::exseq_mr_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = HistoryWithExitPoint_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region mr */
void HistoryWithExitPoint::exseq_mr()
{
	/* Default exit sequence for region mr */
	/* Handle exit of all possible states (of HistoryWithExitPoint.mr) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case mr_A_r_X1 :
		{
			exseq_mr_A_r_X1();
			break;
		}
		case mr_A_r_X2 :
		{
			exseq_mr_A_r_X2();
			break;
		}
		case mr_B :
		{
			exseq_mr_B();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
void HistoryWithExitPoint::exseq_mr_A_r()
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of HistoryWithExitPoint.mr.A.r) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case mr_A_r_X1 :
		{
			exseq_mr_A_r_X1();
			break;
		}
		case mr_A_r_X2 :
		{
			exseq_mr_A_r_X2();
			break;
		}
		default: break;
	}
}

/* The reactions of state X1. */
void HistoryWithExitPoint::react_mr_A_r_X1()
{
	/* The reactions of state X1. */
	if (check_mr_A_r_X1_tr0_tr0())
	{ 
		effect_mr_A_r_X1_tr0();
	}  else
	{
		if (check_mr_A_r_X1_tr1_tr1())
		{ 
			effect_mr_A_r_X1_tr1();
		} 
	}
}

/* The reactions of state X2. */
void HistoryWithExitPoint::react_mr_A_r_X2()
{
	/* The reactions of state X2. */
	if (check_mr_A_r_X2_tr0_tr0())
	{ 
		effect_mr_A_r_X2_tr0();
	}  else
	{
		if (check_mr_A_r_X2_tr1_tr1())
		{ 
			effect_mr_A_r_X2_tr1();
		} 
	}
}

/* The reactions of state B. */
void HistoryWithExitPoint::react_mr_B()
{
	/* The reactions of state B. */
	if (check_mr_B_tr0_tr0())
	{ 
		effect_mr_B_tr0();
	} 
}

/* Default react sequence for initial entry  */
void HistoryWithExitPoint::react_mr__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_mr_A_default();
}

/* Default react sequence for shallow history entry  */
void HistoryWithExitPoint::react_mr_A_r__entry_Default()
{
	/* Default react sequence for shallow history entry  */
	/* Enter the region with shallow history */
	if (historyVector[0] != HistoryWithExitPoint_last_state)
	{
		shenseq_mr_A_r();
	} else
	{
		enseq_mr_A_r_X1_default();
	} 
}

/* The reactions of exit exit_to_B. */
void HistoryWithExitPoint::react_mr_A_r_exit_to_B()
{
	/* The reactions of exit exit_to_B. */
	effect_mr_A_tr0();
}


