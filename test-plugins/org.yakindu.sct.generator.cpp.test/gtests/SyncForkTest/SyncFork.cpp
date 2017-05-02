
#include "SyncFork.h"
#include <string.h>

/*! \file Implementation of the state machine 'SyncFork'
*/

SyncFork::SyncFork()
{
	
	
	stateConfVectorPosition = 0;
	
}

SyncFork::~SyncFork()
{
}


void SyncFork::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = SyncFork_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void SyncFork::enter()
{
	/* Default enter sequence for statechart SyncFork */
	enseq_main_region_default();
}

void SyncFork::exit()
{
	/* Default exit sequence for statechart SyncFork */
	exseq_main_region();
}

sc_boolean SyncFork::isActive() const
{
	return stateConfVector[0] != SyncFork_last_state||stateConfVector[1] != SyncFork_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean SyncFork::isFinal() const
{
   return false;}

void SyncFork::runCycle()
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
		case main_region_B_r1_C1 :
		{
			react_main_region_B_r1_C1();
			break;
		}
		case main_region_B_r1_C2 :
		{
			react_main_region_B_r1_C2();
			break;
		}
		case main_region_B_r2_D1 :
		{
			react_main_region_B_r2_D1();
			break;
		}
		case main_region_B_r2_D2 :
		{
			react_main_region_B_r2_D2();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void SyncFork::clearInEvents()
{
	iface.e_raised = false;
	iface.f_raised = false;
}

void SyncFork::clearOutEvents()
{
}


sc_boolean SyncFork::isStateActive(SyncForkStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		case main_region_B : 
			return (sc_boolean) (stateConfVector[0] >= main_region_B
				&& stateConfVector[0] <= main_region_B_r2_D2);
		case main_region_B_r1_C1 : 
			return (sc_boolean) (stateConfVector[0] == main_region_B_r1_C1
			);
		case main_region_B_r1_C2 : 
			return (sc_boolean) (stateConfVector[0] == main_region_B_r1_C2
			);
		case main_region_B_r2_D1 : 
			return (sc_boolean) (stateConfVector[1] == main_region_B_r2_D1
			);
		case main_region_B_r2_D2 : 
			return (sc_boolean) (stateConfVector[1] == main_region_B_r2_D2
			);
		default: return false;
	}
}

SyncFork::DefaultSCI* SyncFork::getDefaultSCI()
{
	return &iface;
}

void SyncFork::DefaultSCI::raise_e()
{
	e_raised = true;
}

void SyncFork::raise_e()
{
	iface.raise_e();
}

void SyncFork::DefaultSCI::raise_f()
{
	f_raised = true;
}

void SyncFork::raise_f()
{
	iface.raise_f();
}



// implementations of all internal functions

sc_boolean SyncFork::check_main_region_A_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean SyncFork::check_main_region_A_tr1_tr1()
{
	return iface.f_raised;
}

sc_boolean SyncFork::check_main_region_B_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean SyncFork::check_main_region_B_r1_C1_tr0_tr0()
{
	return iface.f_raised;
}

sc_boolean SyncFork::check_main_region_B_r2_D1_tr0_tr0()
{
	return iface.f_raised;
}

void SyncFork::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	react_main_region__sync0();
}

void SyncFork::effect_main_region_A_tr1()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void SyncFork::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region_A_default();
}

void SyncFork::effect_main_region_B_r1_C1_tr0()
{
	exseq_main_region_B_r1_C1();
	enseq_main_region_B_r1_C2_default();
}

void SyncFork::effect_main_region_B_r2_D1_tr0()
{
	exseq_main_region_B_r2_D1();
	enseq_main_region_B_r2_D2_default();
}

/* 'default' enter sequence for state A */
void SyncFork::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void SyncFork::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	enseq_main_region_B_r1_default();
	enseq_main_region_B_r2_default();
}

/* 'default' enter sequence for state C1 */
void SyncFork::enseq_main_region_B_r1_C1_default()
{
	/* 'default' enter sequence for state C1 */
	stateConfVector[0] = main_region_B_r1_C1;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C2 */
void SyncFork::enseq_main_region_B_r1_C2_default()
{
	/* 'default' enter sequence for state C2 */
	stateConfVector[0] = main_region_B_r1_C2;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state D1 */
void SyncFork::enseq_main_region_B_r2_D1_default()
{
	/* 'default' enter sequence for state D1 */
	stateConfVector[1] = main_region_B_r2_D1;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state D2 */
void SyncFork::enseq_main_region_B_r2_D2_default()
{
	/* 'default' enter sequence for state D2 */
	stateConfVector[1] = main_region_B_r2_D2;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region main region */
void SyncFork::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* 'default' enter sequence for region r1 */
void SyncFork::enseq_main_region_B_r1_default()
{
	/* 'default' enter sequence for region r1 */
	react_main_region_B_r1__entry_Default();
}

/* 'default' enter sequence for region r2 */
void SyncFork::enseq_main_region_B_r2_default()
{
	/* 'default' enter sequence for region r2 */
	react_main_region_B_r2__entry_Default();
}

/* Default exit sequence for state A */
void SyncFork::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = SyncFork_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void SyncFork::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	exseq_main_region_B_r1();
	exseq_main_region_B_r2();
}

/* Default exit sequence for state C1 */
void SyncFork::exseq_main_region_B_r1_C1()
{
	/* Default exit sequence for state C1 */
	stateConfVector[0] = SyncFork_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state C2 */
void SyncFork::exseq_main_region_B_r1_C2()
{
	/* Default exit sequence for state C2 */
	stateConfVector[0] = SyncFork_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state D1 */
void SyncFork::exseq_main_region_B_r2_D1()
{
	/* Default exit sequence for state D1 */
	stateConfVector[1] = SyncFork_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state D2 */
void SyncFork::exseq_main_region_B_r2_D2()
{
	/* Default exit sequence for state D2 */
	stateConfVector[1] = SyncFork_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for region main region */
void SyncFork::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of SyncFork.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_A :
		{
			exseq_main_region_A();
			break;
		}
		case main_region_B_r1_C1 :
		{
			exseq_main_region_B_r1_C1();
			break;
		}
		case main_region_B_r1_C2 :
		{
			exseq_main_region_B_r1_C2();
			break;
		}
		default: break;
	}
	/* Handle exit of all possible states (of SyncFork.main_region) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case main_region_B_r2_D1 :
		{
			exseq_main_region_B_r2_D1();
			break;
		}
		case main_region_B_r2_D2 :
		{
			exseq_main_region_B_r2_D2();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r1 */
void SyncFork::exseq_main_region_B_r1()
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of SyncFork.main_region.B.r1) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_B_r1_C1 :
		{
			exseq_main_region_B_r1_C1();
			break;
		}
		case main_region_B_r1_C2 :
		{
			exseq_main_region_B_r1_C2();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r2 */
void SyncFork::exseq_main_region_B_r2()
{
	/* Default exit sequence for region r2 */
	/* Handle exit of all possible states (of SyncFork.main_region.B.r2) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case main_region_B_r2_D1 :
		{
			exseq_main_region_B_r2_D1();
			break;
		}
		case main_region_B_r2_D2 :
		{
			exseq_main_region_B_r2_D2();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void SyncFork::react_main_region_A()
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

/* The reactions of state C1. */
void SyncFork::react_main_region_B_r1_C1()
{
	/* The reactions of state C1. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	}  else
	{
		if (check_main_region_B_r1_C1_tr0_tr0())
		{ 
			effect_main_region_B_r1_C1_tr0();
		} 
	}
}

/* The reactions of state C2. */
void SyncFork::react_main_region_B_r1_C2()
{
	/* The reactions of state C2. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	}  else
	{
	}
}

/* The reactions of state D1. */
void SyncFork::react_main_region_B_r2_D1()
{
	/* The reactions of state D1. */
	if (check_main_region_B_r2_D1_tr0_tr0())
	{ 
		effect_main_region_B_r2_D1_tr0();
	} 
}

/* The reactions of state D2. */
void SyncFork::react_main_region_B_r2_D2()
{
}

/* Default react sequence for initial entry  */
void SyncFork::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}

/* Default react sequence for initial entry  */
void SyncFork::react_main_region_B_r1__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_B_r1_C1_default();
}

/* Default react sequence for initial entry  */
void SyncFork::react_main_region_B_r2__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_B_r2_D1_default();
}

/* The reactions of state null. */
void SyncFork::react_main_region__sync0()
{
	/* The reactions of state null. */
	enseq_main_region_B_r1_C2_default();
	enseq_main_region_B_r2_D2_default();
}


