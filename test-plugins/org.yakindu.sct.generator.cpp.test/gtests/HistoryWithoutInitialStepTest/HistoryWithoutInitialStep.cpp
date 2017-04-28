
#include "HistoryWithoutInitialStep.h"
#include <string.h>

/*! \file Implementation of the state machine 'HistoryWithoutInitialStep'
*/

HistoryWithoutInitialStep::HistoryWithoutInitialStep()
{
	
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = HistoryWithoutInitialStep_last_state;
	
	stateConfVectorPosition = 0;
	
}

HistoryWithoutInitialStep::~HistoryWithoutInitialStep()
{
}


void HistoryWithoutInitialStep::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = HistoryWithoutInitialStep_last_state;
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = HistoryWithoutInitialStep_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void HistoryWithoutInitialStep::enter()
{
	/* Default enter sequence for statechart HistoryWithoutInitialStep */
	enseq_main_region_default();
}

void HistoryWithoutInitialStep::exit()
{
	/* Default exit sequence for statechart HistoryWithoutInitialStep */
	exseq_main_region();
}

sc_boolean HistoryWithoutInitialStep::isActive() const
{
	return stateConfVector[0] != HistoryWithoutInitialStep_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean HistoryWithoutInitialStep::isFinal() const
{
   return false;}

void HistoryWithoutInitialStep::runCycle()
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
		case main_region_B_r1_C :
		{
			react_main_region_B_r1_C();
			break;
		}
		case main_region_B_r1_D :
		{
			react_main_region_B_r1_D();
			break;
		}
		case main_region_B_r1_E__region0_F :
		{
			react_main_region_B_r1_E__region0_F();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void HistoryWithoutInitialStep::clearInEvents()
{
	iface.toA_raised = false;
	iface.toB_raised = false;
	iface.toHistory_raised = false;
	iface.next_raised = false;
}

void HistoryWithoutInitialStep::clearOutEvents()
{
}


sc_boolean HistoryWithoutInitialStep::isStateActive(HistoryWithoutInitialStepStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		case main_region_B : 
			return (sc_boolean) (stateConfVector[0] >= main_region_B
				&& stateConfVector[0] <= main_region_B_r1_E__region0_F);
		case main_region_B_r1_C : 
			return (sc_boolean) (stateConfVector[0] == main_region_B_r1_C
			);
		case main_region_B_r1_D : 
			return (sc_boolean) (stateConfVector[0] == main_region_B_r1_D
			);
		case main_region_B_r1_E : 
			return (sc_boolean) (stateConfVector[0] >= main_region_B_r1_E
				&& stateConfVector[0] <= main_region_B_r1_E__region0_F);
		case main_region_B_r1_E__region0_F : 
			return (sc_boolean) (stateConfVector[0] == main_region_B_r1_E__region0_F
			);
		default: return false;
	}
}

HistoryWithoutInitialStep::DefaultSCI* HistoryWithoutInitialStep::getDefaultSCI()
{
	return &iface;
}

void HistoryWithoutInitialStep::DefaultSCI::raise_toA()
{
	toA_raised = true;
}

void HistoryWithoutInitialStep::raise_toA()
{
	iface.raise_toA();
}

void HistoryWithoutInitialStep::DefaultSCI::raise_toB()
{
	toB_raised = true;
}

void HistoryWithoutInitialStep::raise_toB()
{
	iface.raise_toB();
}

void HistoryWithoutInitialStep::DefaultSCI::raise_toHistory()
{
	toHistory_raised = true;
}

void HistoryWithoutInitialStep::raise_toHistory()
{
	iface.raise_toHistory();
}

void HistoryWithoutInitialStep::DefaultSCI::raise_next()
{
	next_raised = true;
}

void HistoryWithoutInitialStep::raise_next()
{
	iface.raise_next();
}



// implementations of all internal functions

sc_boolean HistoryWithoutInitialStep::check_main_region_A_tr0_tr0()
{
	return iface.toB_raised;
}

sc_boolean HistoryWithoutInitialStep::check_main_region_A_tr1_tr1()
{
	return iface.toHistory_raised;
}

sc_boolean HistoryWithoutInitialStep::check_main_region_B_tr0_tr0()
{
	return iface.toA_raised;
}

sc_boolean HistoryWithoutInitialStep::check_main_region_B_r1_C_tr0_tr0()
{
	return iface.next_raised;
}

sc_boolean HistoryWithoutInitialStep::check_main_region_B_r1_D_tr0_tr0()
{
	return iface.next_raised;
}

sc_boolean HistoryWithoutInitialStep::check_main_region_B_r1_E_tr0_tr0()
{
	return iface.next_raised;
}

void HistoryWithoutInitialStep::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void HistoryWithoutInitialStep::effect_main_region_A_tr1()
{
	exseq_main_region_A();
	react_main_region_B_r1_he();
}

void HistoryWithoutInitialStep::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region_A_default();
}

void HistoryWithoutInitialStep::effect_main_region_B_r1_C_tr0()
{
	exseq_main_region_B_r1_C();
	enseq_main_region_B_r1_D_default();
}

void HistoryWithoutInitialStep::effect_main_region_B_r1_D_tr0()
{
	exseq_main_region_B_r1_D();
	enseq_main_region_B_r1_E_default();
}

void HistoryWithoutInitialStep::effect_main_region_B_r1_E_tr0()
{
	exseq_main_region_B_r1_E();
	enseq_main_region_B_r1_C_default();
}

/* 'default' enter sequence for state A */
void HistoryWithoutInitialStep::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void HistoryWithoutInitialStep::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	enseq_main_region_B_r1_default();
}

/* 'default' enter sequence for state C */
void HistoryWithoutInitialStep::enseq_main_region_B_r1_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[0] = main_region_B_r1_C;
	stateConfVectorPosition = 0;
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state D */
void HistoryWithoutInitialStep::enseq_main_region_B_r1_D_default()
{
	/* 'default' enter sequence for state D */
	stateConfVector[0] = main_region_B_r1_D;
	stateConfVectorPosition = 0;
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state E */
void HistoryWithoutInitialStep::enseq_main_region_B_r1_E_default()
{
	/* 'default' enter sequence for state E */
	enseq_main_region_B_r1_E__region0_default();
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state F */
void HistoryWithoutInitialStep::enseq_main_region_B_r1_E__region0_F_default()
{
	/* 'default' enter sequence for state F */
	stateConfVector[0] = main_region_B_r1_E__region0_F;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void HistoryWithoutInitialStep::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* 'default' enter sequence for region r1 */
void HistoryWithoutInitialStep::enseq_main_region_B_r1_default()
{
	/* 'default' enter sequence for region r1 */
	react_main_region_B_r1__entry_Default();
}

/* shallow enterSequence with history in child r1 */
void HistoryWithoutInitialStep::shenseq_main_region_B_r1()
{
	/* shallow enterSequence with history in child r1 */
	/* Handle shallow history entry of r1 */
	switch(historyVector[ 0 ])
	{
		case main_region_B_r1_C :
		{
			enseq_main_region_B_r1_C_default();
			break;
		}
		case main_region_B_r1_D :
		{
			enseq_main_region_B_r1_D_default();
			break;
		}
		case main_region_B_r1_E__region0_F :
		{
			enseq_main_region_B_r1_E_default();
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region null */
void HistoryWithoutInitialStep::enseq_main_region_B_r1_E__region0_default()
{
	/* 'default' enter sequence for region null */
	react_main_region_B_r1_E__region0__entry_Default();
}

/* Default exit sequence for state A */
void HistoryWithoutInitialStep::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = HistoryWithoutInitialStep_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void HistoryWithoutInitialStep::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	exseq_main_region_B_r1();
}

/* Default exit sequence for state C */
void HistoryWithoutInitialStep::exseq_main_region_B_r1_C()
{
	/* Default exit sequence for state C */
	stateConfVector[0] = HistoryWithoutInitialStep_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state D */
void HistoryWithoutInitialStep::exseq_main_region_B_r1_D()
{
	/* Default exit sequence for state D */
	stateConfVector[0] = HistoryWithoutInitialStep_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state E */
void HistoryWithoutInitialStep::exseq_main_region_B_r1_E()
{
	/* Default exit sequence for state E */
	exseq_main_region_B_r1_E__region0();
}

/* Default exit sequence for state F */
void HistoryWithoutInitialStep::exseq_main_region_B_r1_E__region0_F()
{
	/* Default exit sequence for state F */
	stateConfVector[0] = HistoryWithoutInitialStep_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void HistoryWithoutInitialStep::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of HistoryWithoutInitialStep.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_A :
		{
			exseq_main_region_A();
			break;
		}
		case main_region_B_r1_C :
		{
			exseq_main_region_B_r1_C();
			break;
		}
		case main_region_B_r1_D :
		{
			exseq_main_region_B_r1_D();
			break;
		}
		case main_region_B_r1_E__region0_F :
		{
			exseq_main_region_B_r1_E__region0_F();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r1 */
void HistoryWithoutInitialStep::exseq_main_region_B_r1()
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of HistoryWithoutInitialStep.main_region.B.r1) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_B_r1_C :
		{
			exseq_main_region_B_r1_C();
			break;
		}
		case main_region_B_r1_D :
		{
			exseq_main_region_B_r1_D();
			break;
		}
		case main_region_B_r1_E__region0_F :
		{
			exseq_main_region_B_r1_E__region0_F();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
void HistoryWithoutInitialStep::exseq_main_region_B_r1_E__region0()
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of HistoryWithoutInitialStep.main_region.B.r1.E._region0) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_B_r1_E__region0_F :
		{
			exseq_main_region_B_r1_E__region0_F();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void HistoryWithoutInitialStep::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	}  else
	{
		if (check_main_region_A_tr1_tr1())
		{ 
			effect_main_region_A_tr1();
		} 
	}
}

/* The reactions of state C. */
void HistoryWithoutInitialStep::react_main_region_B_r1_C()
{
	/* The reactions of state C. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	}  else
	{
		if (check_main_region_B_r1_C_tr0_tr0())
		{ 
			effect_main_region_B_r1_C_tr0();
		} 
	}
}

/* The reactions of state D. */
void HistoryWithoutInitialStep::react_main_region_B_r1_D()
{
	/* The reactions of state D. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	}  else
	{
		if (check_main_region_B_r1_D_tr0_tr0())
		{ 
			effect_main_region_B_r1_D_tr0();
		} 
	}
}

/* The reactions of state F. */
void HistoryWithoutInitialStep::react_main_region_B_r1_E__region0_F()
{
	/* The reactions of state F. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	}  else
	{
		if (check_main_region_B_r1_E_tr0_tr0())
		{ 
			effect_main_region_B_r1_E_tr0();
		}  else
		{
		}
	}
}

/* Default react sequence for initial entry  */
void HistoryWithoutInitialStep::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}

/* Default react sequence for initial entry  */
void HistoryWithoutInitialStep::react_main_region_B_r1__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_B_r1_C_default();
}

/* Default react sequence for shallow history entry he */
void HistoryWithoutInitialStep::react_main_region_B_r1_he()
{
	/* Default react sequence for shallow history entry he */
	/* Enter the region with shallow history */
	if (historyVector[0] != HistoryWithoutInitialStep_last_state)
	{
		shenseq_main_region_B_r1();
	} 
}

/* Default react sequence for initial entry  */
void HistoryWithoutInitialStep::react_main_region_B_r1_E__region0__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_B_r1_E__region0_F_default();
}


