
#include "ShallowHistoryWithDeepEntry.h"
#include <string.h>

/*! \file Implementation of the state machine 'ShallowHistoryWithDeepEntry'
*/

ShallowHistoryWithDeepEntry::ShallowHistoryWithDeepEntry()
{
	
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = ShallowHistoryWithDeepEntry_last_state;
	
	stateConfVectorPosition = 0;
	
}

ShallowHistoryWithDeepEntry::~ShallowHistoryWithDeepEntry()
{
}


void ShallowHistoryWithDeepEntry::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = ShallowHistoryWithDeepEntry_last_state;
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = ShallowHistoryWithDeepEntry_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void ShallowHistoryWithDeepEntry::enter()
{
	/* Default enter sequence for statechart ShallowHistoryWithDeepEntry */
	enseq_main_region_default();
}

void ShallowHistoryWithDeepEntry::exit()
{
	/* Default exit sequence for statechart ShallowHistoryWithDeepEntry */
	exseq_main_region();
}

sc_boolean ShallowHistoryWithDeepEntry::isActive() const
{
	return stateConfVector[0] != ShallowHistoryWithDeepEntry_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean ShallowHistoryWithDeepEntry::isFinal() const
{
   return false;}

void ShallowHistoryWithDeepEntry::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_Y :
		{
			react_main_region_Y();
			break;
		}
		case main_region_Z__region0_A :
		{
			react_main_region_Z__region0_A();
			break;
		}
		case main_region_Z__region0_B__region0_C :
		{
			react_main_region_Z__region0_B__region0_C();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void ShallowHistoryWithDeepEntry::clearInEvents()
{
	iface.toZ_raised = false;
	iface.toY_raised = false;
	iface.toC_raised = false;
	iface.toA_raised = false;
}

void ShallowHistoryWithDeepEntry::clearOutEvents()
{
}


sc_boolean ShallowHistoryWithDeepEntry::isStateActive(ShallowHistoryWithDeepEntryStates state) const
{
	switch (state)
	{
		case main_region_Y : 
			return (sc_boolean) (stateConfVector[0] == main_region_Y
			);
		case main_region_Z : 
			return (sc_boolean) (stateConfVector[0] >= main_region_Z
				&& stateConfVector[0] <= main_region_Z__region0_B__region0_C);
		case main_region_Z__region0_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_Z__region0_A
			);
		case main_region_Z__region0_B : 
			return (sc_boolean) (stateConfVector[0] >= main_region_Z__region0_B
				&& stateConfVector[0] <= main_region_Z__region0_B__region0_C);
		case main_region_Z__region0_B__region0_C : 
			return (sc_boolean) (stateConfVector[0] == main_region_Z__region0_B__region0_C
			);
		default: return false;
	}
}

ShallowHistoryWithDeepEntry::DefaultSCI* ShallowHistoryWithDeepEntry::getDefaultSCI()
{
	return &iface;
}

void ShallowHistoryWithDeepEntry::DefaultSCI::raise_toZ()
{
	toZ_raised = true;
}

void ShallowHistoryWithDeepEntry::raise_toZ()
{
	iface.raise_toZ();
}

void ShallowHistoryWithDeepEntry::DefaultSCI::raise_toY()
{
	toY_raised = true;
}

void ShallowHistoryWithDeepEntry::raise_toY()
{
	iface.raise_toY();
}

void ShallowHistoryWithDeepEntry::DefaultSCI::raise_toC()
{
	toC_raised = true;
}

void ShallowHistoryWithDeepEntry::raise_toC()
{
	iface.raise_toC();
}

void ShallowHistoryWithDeepEntry::DefaultSCI::raise_toA()
{
	toA_raised = true;
}

void ShallowHistoryWithDeepEntry::raise_toA()
{
	iface.raise_toA();
}



// implementations of all internal functions

sc_boolean ShallowHistoryWithDeepEntry::check_main_region_Y_tr0_tr0()
{
	return iface.toZ_raised;
}

sc_boolean ShallowHistoryWithDeepEntry::check_main_region_Y_tr1_tr1()
{
	return iface.toC_raised;
}

sc_boolean ShallowHistoryWithDeepEntry::check_main_region_Z_tr0_tr0()
{
	return iface.toY_raised;
}

sc_boolean ShallowHistoryWithDeepEntry::check_main_region_Z__region0_A_tr0_tr0()
{
	return iface.toC_raised;
}

sc_boolean ShallowHistoryWithDeepEntry::check_main_region_Z__region0_B__region0_C_tr0_tr0()
{
	return iface.toA_raised;
}

void ShallowHistoryWithDeepEntry::effect_main_region_Y_tr0()
{
	exseq_main_region_Y();
	enseq_main_region_Z_default();
}

void ShallowHistoryWithDeepEntry::effect_main_region_Y_tr1()
{
	exseq_main_region_Y();
	enseq_main_region_Z__region0_B__region0_C_default();
	historyVector[0] = stateConfVector[0];
}

void ShallowHistoryWithDeepEntry::effect_main_region_Z_tr0()
{
	exseq_main_region_Z();
	enseq_main_region_Y_default();
}

void ShallowHistoryWithDeepEntry::effect_main_region_Z__region0_A_tr0()
{
	exseq_main_region_Z__region0_A();
	enseq_main_region_Z__region0_B__region0_C_default();
	historyVector[0] = stateConfVector[0];
}

void ShallowHistoryWithDeepEntry::effect_main_region_Z__region0_B__region0_C_tr0()
{
	exseq_main_region_Z__region0_B();
	enseq_main_region_Z__region0_A_default();
}

/* 'default' enter sequence for state Y */
void ShallowHistoryWithDeepEntry::enseq_main_region_Y_default()
{
	/* 'default' enter sequence for state Y */
	stateConfVector[0] = main_region_Y;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Z */
void ShallowHistoryWithDeepEntry::enseq_main_region_Z_default()
{
	/* 'default' enter sequence for state Z */
	enseq_main_region_Z__region0_default();
}

/* 'default' enter sequence for state A */
void ShallowHistoryWithDeepEntry::enseq_main_region_Z__region0_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_Z__region0_A;
	stateConfVectorPosition = 0;
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state B */
void ShallowHistoryWithDeepEntry::enseq_main_region_Z__region0_B_default()
{
	/* 'default' enter sequence for state B */
	enseq_main_region_Z__region0_B__region0_default();
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state C */
void ShallowHistoryWithDeepEntry::enseq_main_region_Z__region0_B__region0_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[0] = main_region_Z__region0_B__region0_C;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void ShallowHistoryWithDeepEntry::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* 'default' enter sequence for region null */
void ShallowHistoryWithDeepEntry::enseq_main_region_Z__region0_default()
{
	/* 'default' enter sequence for region null */
	react_main_region_Z__region0__entry_Default();
}

/* shallow enterSequence with history in child null */
void ShallowHistoryWithDeepEntry::shenseq_main_region_Z__region0()
{
	/* shallow enterSequence with history in child null */
	/* Handle shallow history entry of null */
	switch(historyVector[ 0 ])
	{
		case main_region_Z__region0_A :
		{
			enseq_main_region_Z__region0_A_default();
			break;
		}
		case main_region_Z__region0_B__region0_C :
		{
			enseq_main_region_Z__region0_B_default();
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region null */
void ShallowHistoryWithDeepEntry::enseq_main_region_Z__region0_B__region0_default()
{
	/* 'default' enter sequence for region null */
	react_main_region_Z__region0_B__region0__entry_Default();
}

/* Default exit sequence for state Y */
void ShallowHistoryWithDeepEntry::exseq_main_region_Y()
{
	/* Default exit sequence for state Y */
	stateConfVector[0] = ShallowHistoryWithDeepEntry_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Z */
void ShallowHistoryWithDeepEntry::exseq_main_region_Z()
{
	/* Default exit sequence for state Z */
	exseq_main_region_Z__region0();
}

/* Default exit sequence for state A */
void ShallowHistoryWithDeepEntry::exseq_main_region_Z__region0_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = ShallowHistoryWithDeepEntry_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void ShallowHistoryWithDeepEntry::exseq_main_region_Z__region0_B()
{
	/* Default exit sequence for state B */
	exseq_main_region_Z__region0_B__region0();
}

/* Default exit sequence for state C */
void ShallowHistoryWithDeepEntry::exseq_main_region_Z__region0_B__region0_C()
{
	/* Default exit sequence for state C */
	stateConfVector[0] = ShallowHistoryWithDeepEntry_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void ShallowHistoryWithDeepEntry::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of ShallowHistoryWithDeepEntry.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_Y :
		{
			exseq_main_region_Y();
			break;
		}
		case main_region_Z__region0_A :
		{
			exseq_main_region_Z__region0_A();
			break;
		}
		case main_region_Z__region0_B__region0_C :
		{
			exseq_main_region_Z__region0_B__region0_C();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
void ShallowHistoryWithDeepEntry::exseq_main_region_Z__region0()
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of ShallowHistoryWithDeepEntry.main_region.Z._region0) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_Z__region0_A :
		{
			exseq_main_region_Z__region0_A();
			break;
		}
		case main_region_Z__region0_B__region0_C :
		{
			exseq_main_region_Z__region0_B__region0_C();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
void ShallowHistoryWithDeepEntry::exseq_main_region_Z__region0_B__region0()
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of ShallowHistoryWithDeepEntry.main_region.Z._region0.B._region0) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_Z__region0_B__region0_C :
		{
			exseq_main_region_Z__region0_B__region0_C();
			break;
		}
		default: break;
	}
}

/* The reactions of state Y. */
void ShallowHistoryWithDeepEntry::react_main_region_Y()
{
	/* The reactions of state Y. */
	if (check_main_region_Y_tr0_tr0())
	{ 
		effect_main_region_Y_tr0();
	}  else
	{
		if (check_main_region_Y_tr1_tr1())
		{ 
			effect_main_region_Y_tr1();
		} 
	}
}

/* The reactions of state A. */
void ShallowHistoryWithDeepEntry::react_main_region_Z__region0_A()
{
	/* The reactions of state A. */
	if (check_main_region_Z_tr0_tr0())
	{ 
		effect_main_region_Z_tr0();
	}  else
	{
		if (check_main_region_Z__region0_A_tr0_tr0())
		{ 
			effect_main_region_Z__region0_A_tr0();
		} 
	}
}

/* The reactions of state C. */
void ShallowHistoryWithDeepEntry::react_main_region_Z__region0_B__region0_C()
{
	/* The reactions of state C. */
	if (check_main_region_Z_tr0_tr0())
	{ 
		effect_main_region_Z_tr0();
	}  else
	{
		if (check_main_region_Z__region0_B__region0_C_tr0_tr0())
		{ 
			effect_main_region_Z__region0_B__region0_C_tr0();
		} 
	}
}

/* Default react sequence for initial entry  */
void ShallowHistoryWithDeepEntry::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_Y_default();
}

/* Default react sequence for shallow history entry  */
void ShallowHistoryWithDeepEntry::react_main_region_Z__region0__entry_Default()
{
	/* Default react sequence for shallow history entry  */
	/* Enter the region with shallow history */
	if (historyVector[0] != ShallowHistoryWithDeepEntry_last_state)
	{
		shenseq_main_region_Z__region0();
	} else
	{
		enseq_main_region_Z__region0_A_default();
	} 
}

/* Default react sequence for initial entry  */
void ShallowHistoryWithDeepEntry::react_main_region_Z__region0_B__region0__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_Z__region0_B__region0_C_default();
}


