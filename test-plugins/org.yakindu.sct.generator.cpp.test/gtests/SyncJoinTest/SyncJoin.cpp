
#include "SyncJoin.h"
#include <string.h>

/*! \file Implementation of the state machine 'SyncJoin'
*/

SyncJoin::SyncJoin()
{
	
	
	stateConfVectorPosition = 0;
	
}

SyncJoin::~SyncJoin()
{
}


void SyncJoin::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = SyncJoin_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart SyncJoin */
	iface.x = 0;
}

void SyncJoin::enter()
{
	/* Default enter sequence for statechart SyncJoin */
	enseq_main_region_default();
}

void SyncJoin::exit()
{
	/* Default exit sequence for statechart SyncJoin */
	exseq_main_region();
}

sc_boolean SyncJoin::isActive() const
{
	return stateConfVector[0] != SyncJoin_last_state||stateConfVector[1] != SyncJoin_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean SyncJoin::isFinal() const
{
   return false;}

void SyncJoin::runCycle()
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

void SyncJoin::clearInEvents()
{
	iface.e_raised = false;
	iface.f_raised = false;
	iface.jc_raised = false;
	iface.jd_raised = false;
}

void SyncJoin::clearOutEvents()
{
}


sc_boolean SyncJoin::isStateActive(SyncJoinStates state) const
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

SyncJoin::DefaultSCI* SyncJoin::getDefaultSCI()
{
	return &iface;
}

void SyncJoin::DefaultSCI::raise_e()
{
	e_raised = true;
}

void SyncJoin::raise_e()
{
	iface.raise_e();
}

void SyncJoin::DefaultSCI::raise_f()
{
	f_raised = true;
}

void SyncJoin::raise_f()
{
	iface.raise_f();
}

void SyncJoin::DefaultSCI::raise_jc()
{
	jc_raised = true;
}

void SyncJoin::raise_jc()
{
	iface.raise_jc();
}

void SyncJoin::DefaultSCI::raise_jd()
{
	jd_raised = true;
}

void SyncJoin::raise_jd()
{
	iface.raise_jd();
}


sc_integer SyncJoin::DefaultSCI::get_x() const
{
	return x;
}

sc_integer SyncJoin::get_x() const
{
	return iface.x;
}

void SyncJoin::DefaultSCI::set_x(sc_integer value)
{
	x = value;
}

void SyncJoin::set_x(sc_integer value)
{
	iface.x = value;
}


// implementations of all internal functions

sc_boolean SyncJoin::check_main_region_A_tr0_tr0()
{
	return iface.e_raised || iface.f_raised;
}

sc_boolean SyncJoin::check_main_region_B_r1_C1_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean SyncJoin::check_main_region_B_r1_C2_tr0_tr0()
{
	return iface.jc_raised && isStateActive(main_region_B_r2_D2) && iface.jd_raised;
}

sc_boolean SyncJoin::check_main_region_B_r2_D1_tr0_tr0()
{
	return iface.f_raised;
}

sc_boolean SyncJoin::check_main_region_B_r2_D2_tr0_tr0()
{
	return iface.jd_raised && isStateActive(main_region_B_r1_C2) && iface.jc_raised;
}

void SyncJoin::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void SyncJoin::effect_main_region_B_r1_C1_tr0()
{
	exseq_main_region_B_r1_C1();
	enseq_main_region_B_r1_C2_default();
}

void SyncJoin::effect_main_region_B_r1_C2_tr0()
{
	exseq_main_region_B();
	react_main_region__sync0();
}

void SyncJoin::effect_main_region_B_r2_D1_tr0()
{
	exseq_main_region_B_r2_D1();
	enseq_main_region_B_r2_D2_default();
}

void SyncJoin::effect_main_region_B_r2_D2_tr0()
{
	exseq_main_region_B();
	react_main_region__sync0();
}

/* Entry action for state 'A'. */
void SyncJoin::enact_main_region_A()
{
	/* Entry action for state 'A'. */
	iface.x += 1;
}

/* 'default' enter sequence for state A */
void SyncJoin::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	enact_main_region_A();
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void SyncJoin::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	enseq_main_region_B_r1_default();
	enseq_main_region_B_r2_default();
}

/* 'default' enter sequence for state C1 */
void SyncJoin::enseq_main_region_B_r1_C1_default()
{
	/* 'default' enter sequence for state C1 */
	stateConfVector[0] = main_region_B_r1_C1;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C2 */
void SyncJoin::enseq_main_region_B_r1_C2_default()
{
	/* 'default' enter sequence for state C2 */
	stateConfVector[0] = main_region_B_r1_C2;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state D1 */
void SyncJoin::enseq_main_region_B_r2_D1_default()
{
	/* 'default' enter sequence for state D1 */
	stateConfVector[1] = main_region_B_r2_D1;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state D2 */
void SyncJoin::enseq_main_region_B_r2_D2_default()
{
	/* 'default' enter sequence for state D2 */
	stateConfVector[1] = main_region_B_r2_D2;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region main region */
void SyncJoin::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* 'default' enter sequence for region r1 */
void SyncJoin::enseq_main_region_B_r1_default()
{
	/* 'default' enter sequence for region r1 */
	react_main_region_B_r1__entry_Default();
}

/* 'default' enter sequence for region r2 */
void SyncJoin::enseq_main_region_B_r2_default()
{
	/* 'default' enter sequence for region r2 */
	react_main_region_B_r2__entry_Default();
}

/* Default exit sequence for state A */
void SyncJoin::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = SyncJoin_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void SyncJoin::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	exseq_main_region_B_r1();
	exseq_main_region_B_r2();
}

/* Default exit sequence for state C1 */
void SyncJoin::exseq_main_region_B_r1_C1()
{
	/* Default exit sequence for state C1 */
	stateConfVector[0] = SyncJoin_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state C2 */
void SyncJoin::exseq_main_region_B_r1_C2()
{
	/* Default exit sequence for state C2 */
	stateConfVector[0] = SyncJoin_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state D1 */
void SyncJoin::exseq_main_region_B_r2_D1()
{
	/* Default exit sequence for state D1 */
	stateConfVector[1] = SyncJoin_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state D2 */
void SyncJoin::exseq_main_region_B_r2_D2()
{
	/* Default exit sequence for state D2 */
	stateConfVector[1] = SyncJoin_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for region main region */
void SyncJoin::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of SyncJoin.main_region) at position 0... */
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
	/* Handle exit of all possible states (of SyncJoin.main_region) at position 1... */
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
void SyncJoin::exseq_main_region_B_r1()
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of SyncJoin.main_region.B.r1) at position 0... */
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
void SyncJoin::exseq_main_region_B_r2()
{
	/* Default exit sequence for region r2 */
	/* Handle exit of all possible states (of SyncJoin.main_region.B.r2) at position 1... */
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
void SyncJoin::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	} 
}

/* The reactions of state C1. */
void SyncJoin::react_main_region_B_r1_C1()
{
	/* The reactions of state C1. */
	if (check_main_region_B_r1_C1_tr0_tr0())
	{ 
		effect_main_region_B_r1_C1_tr0();
	} 
}

/* The reactions of state C2. */
void SyncJoin::react_main_region_B_r1_C2()
{
	/* The reactions of state C2. */
	if (check_main_region_B_r1_C2_tr0_tr0())
	{ 
		effect_main_region_B_r1_C2_tr0();
	} 
}

/* The reactions of state D1. */
void SyncJoin::react_main_region_B_r2_D1()
{
	/* The reactions of state D1. */
	if (check_main_region_B_r2_D1_tr0_tr0())
	{ 
		effect_main_region_B_r2_D1_tr0();
	} 
}

/* The reactions of state D2. */
void SyncJoin::react_main_region_B_r2_D2()
{
	/* The reactions of state D2. */
	if (check_main_region_B_r2_D2_tr0_tr0())
	{ 
		effect_main_region_B_r2_D2_tr0();
	} 
}

/* Default react sequence for initial entry  */
void SyncJoin::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_B_default();
}

/* Default react sequence for initial entry  */
void SyncJoin::react_main_region_B_r1__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_B_r1_C1_default();
}

/* Default react sequence for initial entry  */
void SyncJoin::react_main_region_B_r2__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_B_r2_D1_default();
}

/* The reactions of state null. */
void SyncJoin::react_main_region__sync0()
{
	/* The reactions of state null. */
	enseq_main_region_A_default();
}


