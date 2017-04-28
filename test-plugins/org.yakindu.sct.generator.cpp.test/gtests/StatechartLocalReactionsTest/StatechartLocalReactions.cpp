
#include "StatechartLocalReactions.h"
#include <string.h>

/*! \file Implementation of the state machine 'StatechartLocalReactions'
*/

StatechartLocalReactions::StatechartLocalReactions()
{
	
	
	stateConfVectorPosition = 0;
	
}

StatechartLocalReactions::~StatechartLocalReactions()
{
}


void StatechartLocalReactions::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = StatechartLocalReactions_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart StatechartLocalReactions */
	iface.myInt = 0;
}

void StatechartLocalReactions::enter()
{
	/* Default enter sequence for statechart StatechartLocalReactions */
	enseq_main_region_default();
	enseq_region2_default();
}

void StatechartLocalReactions::exit()
{
	/* Default exit sequence for statechart StatechartLocalReactions */
	exseq_main_region();
	exseq_region2();
}

sc_boolean StatechartLocalReactions::isActive() const
{
	return stateConfVector[0] != StatechartLocalReactions_last_state||stateConfVector[1] != StatechartLocalReactions_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean StatechartLocalReactions::isFinal() const
{
   return false;}

void StatechartLocalReactions::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_S1 :
		{
			react_main_region_S1();
			break;
		}
		case main_region_S2 :
		{
			react_main_region_S2();
			break;
		}
		case region2_a :
		{
			react_region2_a();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void StatechartLocalReactions::clearInEvents()
{
}

void StatechartLocalReactions::clearOutEvents()
{
}


sc_boolean StatechartLocalReactions::isStateActive(StatechartLocalReactionsStates state) const
{
	switch (state)
	{
		case main_region_S1 : 
			return (sc_boolean) (stateConfVector[0] == main_region_S1
			);
		case main_region_S2 : 
			return (sc_boolean) (stateConfVector[0] == main_region_S2
			);
		case region2_a : 
			return (sc_boolean) (stateConfVector[1] == region2_a
			);
		default: return false;
	}
}

StatechartLocalReactions::DefaultSCI* StatechartLocalReactions::getDefaultSCI()
{
	return &iface;
}


sc_integer StatechartLocalReactions::DefaultSCI::get_myInt() const
{
	return myInt;
}

sc_integer StatechartLocalReactions::get_myInt() const
{
	return iface.myInt;
}

void StatechartLocalReactions::DefaultSCI::set_myInt(sc_integer value)
{
	myInt = value;
}

void StatechartLocalReactions::set_myInt(sc_integer value)
{
	iface.myInt = value;
}



// implementations of all internal functions

sc_boolean StatechartLocalReactions::check__lr0()
{
	return true;
}

sc_boolean StatechartLocalReactions::check__lr1()
{
	return iface.myInt == 100;
}

sc_boolean StatechartLocalReactions::check_main_region_S1_tr0_tr0()
{
	return true;
}

sc_boolean StatechartLocalReactions::check_main_region_S2_tr0_tr0()
{
	return true;
}

void StatechartLocalReactions::effect__lr0()
{
	iface.myInt += 1;
}

void StatechartLocalReactions::effect__lr1()
{
	iface.myInt = 0;
}

void StatechartLocalReactions::effect_main_region_S1_tr0()
{
	exseq_main_region_S1();
	enseq_main_region_S2_default();
}

void StatechartLocalReactions::effect_main_region_S2_tr0()
{
	exseq_main_region_S2();
	enseq_main_region_S1_default();
}

/* 'default' enter sequence for state S1 */
void StatechartLocalReactions::enseq_main_region_S1_default()
{
	/* 'default' enter sequence for state S1 */
	stateConfVector[0] = main_region_S1;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state S2 */
void StatechartLocalReactions::enseq_main_region_S2_default()
{
	/* 'default' enter sequence for state S2 */
	stateConfVector[0] = main_region_S2;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state a */
void StatechartLocalReactions::enseq_region2_a_default()
{
	/* 'default' enter sequence for state a */
	stateConfVector[1] = region2_a;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region main region */
void StatechartLocalReactions::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* 'default' enter sequence for region region2 */
void StatechartLocalReactions::enseq_region2_default()
{
	/* 'default' enter sequence for region region2 */
	react_region2__entry_Default();
}

/* Default exit sequence for state S1 */
void StatechartLocalReactions::exseq_main_region_S1()
{
	/* Default exit sequence for state S1 */
	stateConfVector[0] = StatechartLocalReactions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state S2 */
void StatechartLocalReactions::exseq_main_region_S2()
{
	/* Default exit sequence for state S2 */
	stateConfVector[0] = StatechartLocalReactions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state a */
void StatechartLocalReactions::exseq_region2_a()
{
	/* Default exit sequence for state a */
	stateConfVector[1] = StatechartLocalReactions_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for region main region */
void StatechartLocalReactions::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of StatechartLocalReactions.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_S1 :
		{
			exseq_main_region_S1();
			break;
		}
		case main_region_S2 :
		{
			exseq_main_region_S2();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region region2 */
void StatechartLocalReactions::exseq_region2()
{
	/* Default exit sequence for region region2 */
	/* Handle exit of all possible states (of StatechartLocalReactions.region2) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case region2_a :
		{
			exseq_region2_a();
			break;
		}
		default: break;
	}
}

/* The reactions of state S1. */
void StatechartLocalReactions::react_main_region_S1()
{
	/* The reactions of state S1. */
	effect__lr0();
	if (check__lr1())
	{ 
		effect__lr1();
	} 
	effect_main_region_S1_tr0();
}

/* The reactions of state S2. */
void StatechartLocalReactions::react_main_region_S2()
{
	/* The reactions of state S2. */
	effect__lr0();
	if (check__lr1())
	{ 
		effect__lr1();
	} 
	effect_main_region_S2_tr0();
}

/* The reactions of state a. */
void StatechartLocalReactions::react_region2_a()
{
}

/* Default react sequence for initial entry  */
void StatechartLocalReactions::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_S1_default();
}

/* Default react sequence for initial entry  */
void StatechartLocalReactions::react_region2__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_region2_a_default();
}


