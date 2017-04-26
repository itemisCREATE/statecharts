
#include "DeepHistory.h"
#include <string.h>

/*! \file Implementation of the state machine 'DeepHistory'
*/

DeepHistory::DeepHistory()
{
	
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = DeepHistory_last_state;
	
	stateConfVectorPosition = 0;
	
}

DeepHistory::~DeepHistory()
{
}


void DeepHistory::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = DeepHistory_last_state;
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = DeepHistory_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void DeepHistory::enter()
{
	/* Default enter sequence for statechart DeepHistory */
	enseq_mainRegion_default();
}

void DeepHistory::exit()
{
	/* Default exit sequence for statechart DeepHistory */
	exseq_mainRegion();
}

sc_boolean DeepHistory::isActive() const
{
	return stateConfVector[0] != DeepHistory_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean DeepHistory::isFinal() const
{
   return false;}

void DeepHistory::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case mainRegion_State1 :
		{
			react_mainRegion_State1();
			break;
		}
		case mainRegion_State2__region0_a :
		{
			react_mainRegion_State2__region0_a();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State6 :
		{
			react_mainRegion_State2__region0_State4__region0_State6();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			react_mainRegion_State2__region0_State4__region0_State7__region0_State8();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			react_mainRegion_State2__region0_State4__region0_State7__region0_State9();
			break;
		}
		case mainRegion_State2__region0_State5 :
		{
			react_mainRegion_State2__region0_State5();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void DeepHistory::clearInEvents()
{
	iface.event1_raised = false;
	iface.event2_raised = false;
	iface.event3_raised = false;
	iface.event4_raised = false;
	iface.event5_raised = false;
	iface.event6_raised = false;
	iface.event7_raised = false;
	iface.event8_raised = false;
	iface.event9_raised = false;
}

void DeepHistory::clearOutEvents()
{
}


sc_boolean DeepHistory::isStateActive(DeepHistoryStates state) const
{
	switch (state)
	{
		case mainRegion_State1 : 
			return (sc_boolean) (stateConfVector[0] == mainRegion_State1
			);
		case mainRegion_State2 : 
			return (sc_boolean) (stateConfVector[0] >= mainRegion_State2
				&& stateConfVector[0] <= mainRegion_State2__region0_State5);
		case mainRegion_State2__region0_a : 
			return (sc_boolean) (stateConfVector[0] == mainRegion_State2__region0_a
			);
		case mainRegion_State2__region0_State4 : 
			return (sc_boolean) (stateConfVector[0] >= mainRegion_State2__region0_State4
				&& stateConfVector[0] <= mainRegion_State2__region0_State4__region0_State7__region0_State9);
		case mainRegion_State2__region0_State4__region0_State6 : 
			return (sc_boolean) (stateConfVector[0] == mainRegion_State2__region0_State4__region0_State6
			);
		case mainRegion_State2__region0_State4__region0_State7 : 
			return (sc_boolean) (stateConfVector[0] >= mainRegion_State2__region0_State4__region0_State7
				&& stateConfVector[0] <= mainRegion_State2__region0_State4__region0_State7__region0_State9);
		case mainRegion_State2__region0_State4__region0_State7__region0_State8 : 
			return (sc_boolean) (stateConfVector[0] == mainRegion_State2__region0_State4__region0_State7__region0_State8
			);
		case mainRegion_State2__region0_State4__region0_State7__region0_State9 : 
			return (sc_boolean) (stateConfVector[0] == mainRegion_State2__region0_State4__region0_State7__region0_State9
			);
		case mainRegion_State2__region0_State5 : 
			return (sc_boolean) (stateConfVector[0] == mainRegion_State2__region0_State5
			);
		default: return false;
	}
}

DeepHistory::DefaultSCI* DeepHistory::getDefaultSCI()
{
	return &iface;
}

void DeepHistory::DefaultSCI::raise_event1()
{
	event1_raised = true;
}

void DeepHistory::raise_event1()
{
	iface.raise_event1();
}

void DeepHistory::DefaultSCI::raise_event2()
{
	event2_raised = true;
}

void DeepHistory::raise_event2()
{
	iface.raise_event2();
}

void DeepHistory::DefaultSCI::raise_event3()
{
	event3_raised = true;
}

void DeepHistory::raise_event3()
{
	iface.raise_event3();
}

void DeepHistory::DefaultSCI::raise_event4()
{
	event4_raised = true;
}

void DeepHistory::raise_event4()
{
	iface.raise_event4();
}

void DeepHistory::DefaultSCI::raise_event5()
{
	event5_raised = true;
}

void DeepHistory::raise_event5()
{
	iface.raise_event5();
}

void DeepHistory::DefaultSCI::raise_event6()
{
	event6_raised = true;
}

void DeepHistory::raise_event6()
{
	iface.raise_event6();
}

void DeepHistory::DefaultSCI::raise_event7()
{
	event7_raised = true;
}

void DeepHistory::raise_event7()
{
	iface.raise_event7();
}

void DeepHistory::DefaultSCI::raise_event8()
{
	event8_raised = true;
}

void DeepHistory::raise_event8()
{
	iface.raise_event8();
}

void DeepHistory::DefaultSCI::raise_event9()
{
	event9_raised = true;
}

void DeepHistory::raise_event9()
{
	iface.raise_event9();
}



// implementations of all internal functions

sc_boolean DeepHistory::check_mainRegion_State1_tr0_tr0()
{
	return iface.event1_raised;
}

sc_boolean DeepHistory::check_mainRegion_State2_tr0_tr0()
{
	return iface.event2_raised;
}

sc_boolean DeepHistory::check_mainRegion_State2__region0_a_tr0_tr0()
{
	return iface.event3_raised;
}

sc_boolean DeepHistory::check_mainRegion_State2__region0_State4_tr0_tr0()
{
	return iface.event4_raised;
}

sc_boolean DeepHistory::check_mainRegion_State2__region0_State4__region0_State6_tr0_tr0()
{
	return iface.event5_raised;
}

sc_boolean DeepHistory::check_mainRegion_State2__region0_State4__region0_State7_tr0_tr0()
{
	return iface.event6_raised;
}

sc_boolean DeepHistory::check_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0_tr0()
{
	return iface.event7_raised;
}

sc_boolean DeepHistory::check_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0_tr0()
{
	return iface.event8_raised;
}

void DeepHistory::effect_mainRegion_State1_tr0()
{
	exseq_mainRegion_State1();
	enseq_mainRegion_State2_default();
}

void DeepHistory::effect_mainRegion_State2_tr0()
{
	exseq_mainRegion_State2();
	enseq_mainRegion_State1_default();
}

void DeepHistory::effect_mainRegion_State2__region0_a_tr0()
{
	exseq_mainRegion_State2__region0_a();
	enseq_mainRegion_State2__region0_State4_default();
}

void DeepHistory::effect_mainRegion_State2__region0_State4_tr0()
{
	exseq_mainRegion_State2__region0_State4();
	enseq_mainRegion_State2__region0_State5_default();
}

void DeepHistory::effect_mainRegion_State2__region0_State4__region0_State6_tr0()
{
	exseq_mainRegion_State2__region0_State4__region0_State6();
	enseq_mainRegion_State2__region0_State4__region0_State7_default();
}

void DeepHistory::effect_mainRegion_State2__region0_State4__region0_State7_tr0()
{
	exseq_mainRegion_State2__region0_State4__region0_State7();
	enseq_mainRegion_State2__region0_State4__region0_State6_default();
}

void DeepHistory::effect_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0()
{
	exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8();
	enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default();
}

void DeepHistory::effect_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0()
{
	exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9();
	enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default();
}

/* 'default' enter sequence for state State1 */
void DeepHistory::enseq_mainRegion_State1_default()
{
	/* 'default' enter sequence for state State1 */
	stateConfVector[0] = mainRegion_State1;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state State2 */
void DeepHistory::enseq_mainRegion_State2_default()
{
	/* 'default' enter sequence for state State2 */
	enseq_mainRegion_State2__region0_default();
}

/* 'default' enter sequence for state a */
void DeepHistory::enseq_mainRegion_State2__region0_a_default()
{
	/* 'default' enter sequence for state a */
	stateConfVector[0] = mainRegion_State2__region0_a;
	stateConfVectorPosition = 0;
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state State4 */
void DeepHistory::enseq_mainRegion_State2__region0_State4_default()
{
	/* 'default' enter sequence for state State4 */
	enseq_mainRegion_State2__region0_State4__region0_default();
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state State6 */
void DeepHistory::enseq_mainRegion_State2__region0_State4__region0_State6_default()
{
	/* 'default' enter sequence for state State6 */
	stateConfVector[0] = mainRegion_State2__region0_State4__region0_State6;
	stateConfVectorPosition = 0;
	historyVector[1] = stateConfVector[0];
}

/* 'default' enter sequence for state State7 */
void DeepHistory::enseq_mainRegion_State2__region0_State4__region0_State7_default()
{
	/* 'default' enter sequence for state State7 */
	enseq_mainRegion_State2__region0_State4__region0_State7__region0_default();
	historyVector[1] = stateConfVector[0];
}

/* 'default' enter sequence for state State8 */
void DeepHistory::enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default()
{
	/* 'default' enter sequence for state State8 */
	stateConfVector[0] = mainRegion_State2__region0_State4__region0_State7__region0_State8;
	stateConfVectorPosition = 0;
	historyVector[2] = stateConfVector[0];
}

/* 'default' enter sequence for state State9 */
void DeepHistory::enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default()
{
	/* 'default' enter sequence for state State9 */
	stateConfVector[0] = mainRegion_State2__region0_State4__region0_State7__region0_State9;
	stateConfVectorPosition = 0;
	historyVector[2] = stateConfVector[0];
}

/* 'default' enter sequence for state State5 */
void DeepHistory::enseq_mainRegion_State2__region0_State5_default()
{
	/* 'default' enter sequence for state State5 */
	stateConfVector[0] = mainRegion_State2__region0_State5;
	stateConfVectorPosition = 0;
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for region mainRegion */
void DeepHistory::enseq_mainRegion_default()
{
	/* 'default' enter sequence for region mainRegion */
	react_mainRegion__entry_Default();
}

/* 'default' enter sequence for region null */
void DeepHistory::enseq_mainRegion_State2__region0_default()
{
	/* 'default' enter sequence for region null */
	react_mainRegion_State2__region0__entry_Default();
}

/* deep enterSequence with history in child null */
void DeepHistory::dhenseq_mainRegion_State2__region0()
{
	/* deep enterSequence with history in child null */
	/* Handle deep history entry of null */
	switch(historyVector[ 0 ])
	{
		case mainRegion_State2__region0_a :
		{
			/* enterSequence with history in child a for leaf a */
			enseq_mainRegion_State2__region0_a_default();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State6 :
		{
			/* enterSequence with history in child State4 for leaf State6 */
			dhenseq_mainRegion_State2__region0_State4__region0();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			/* enterSequence with history in child State4 for leaf State8 */
			dhenseq_mainRegion_State2__region0_State4__region0();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			/* enterSequence with history in child State4 for leaf State9 */
			dhenseq_mainRegion_State2__region0_State4__region0();
			break;
		}
		case mainRegion_State2__region0_State5 :
		{
			/* enterSequence with history in child State5 for leaf State5 */
			enseq_mainRegion_State2__region0_State5_default();
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region null */
void DeepHistory::enseq_mainRegion_State2__region0_State4__region0_default()
{
	/* 'default' enter sequence for region null */
	react_mainRegion_State2__region0_State4__region0__entry_Default();
}

/* deep enterSequence with history in child null */
void DeepHistory::dhenseq_mainRegion_State2__region0_State4__region0()
{
	/* deep enterSequence with history in child null */
	/* Handle deep history entry of null */
	switch(historyVector[ 1 ])
	{
		case mainRegion_State2__region0_State4__region0_State6 :
		{
			/* enterSequence with history in child State6 for leaf State6 */
			enseq_mainRegion_State2__region0_State4__region0_State6_default();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			/* enterSequence with history in child State7 for leaf State8 */
			dhenseq_mainRegion_State2__region0_State4__region0_State7__region0();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			/* enterSequence with history in child State7 for leaf State9 */
			dhenseq_mainRegion_State2__region0_State4__region0_State7__region0();
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region null */
void DeepHistory::enseq_mainRegion_State2__region0_State4__region0_State7__region0_default()
{
	/* 'default' enter sequence for region null */
	react_mainRegion_State2__region0_State4__region0_State7__region0__entry_Default();
}

/* deep enterSequence with history in child null */
void DeepHistory::dhenseq_mainRegion_State2__region0_State4__region0_State7__region0()
{
	/* deep enterSequence with history in child null */
	/* Handle deep history entry of null */
	switch(historyVector[ 2 ])
	{
		case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			/* enterSequence with history in child State8 for leaf State8 */
			enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			/* enterSequence with history in child State9 for leaf State9 */
			enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for state State1 */
void DeepHistory::exseq_mainRegion_State1()
{
	/* Default exit sequence for state State1 */
	stateConfVector[0] = DeepHistory_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state State2 */
void DeepHistory::exseq_mainRegion_State2()
{
	/* Default exit sequence for state State2 */
	exseq_mainRegion_State2__region0();
}

/* Default exit sequence for state a */
void DeepHistory::exseq_mainRegion_State2__region0_a()
{
	/* Default exit sequence for state a */
	stateConfVector[0] = DeepHistory_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state State4 */
void DeepHistory::exseq_mainRegion_State2__region0_State4()
{
	/* Default exit sequence for state State4 */
	exseq_mainRegion_State2__region0_State4__region0();
}

/* Default exit sequence for state State6 */
void DeepHistory::exseq_mainRegion_State2__region0_State4__region0_State6()
{
	/* Default exit sequence for state State6 */
	stateConfVector[0] = DeepHistory_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state State7 */
void DeepHistory::exseq_mainRegion_State2__region0_State4__region0_State7()
{
	/* Default exit sequence for state State7 */
	exseq_mainRegion_State2__region0_State4__region0_State7__region0();
}

/* Default exit sequence for state State8 */
void DeepHistory::exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8()
{
	/* Default exit sequence for state State8 */
	stateConfVector[0] = DeepHistory_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state State9 */
void DeepHistory::exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9()
{
	/* Default exit sequence for state State9 */
	stateConfVector[0] = DeepHistory_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state State5 */
void DeepHistory::exseq_mainRegion_State2__region0_State5()
{
	/* Default exit sequence for state State5 */
	stateConfVector[0] = DeepHistory_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region mainRegion */
void DeepHistory::exseq_mainRegion()
{
	/* Default exit sequence for region mainRegion */
	/* Handle exit of all possible states (of DeepHistory.mainRegion) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case mainRegion_State1 :
		{
			exseq_mainRegion_State1();
			break;
		}
		case mainRegion_State2__region0_a :
		{
			exseq_mainRegion_State2__region0_a();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State6 :
		{
			exseq_mainRegion_State2__region0_State4__region0_State6();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9();
			break;
		}
		case mainRegion_State2__region0_State5 :
		{
			exseq_mainRegion_State2__region0_State5();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
void DeepHistory::exseq_mainRegion_State2__region0()
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of DeepHistory.mainRegion.State2._region0) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case mainRegion_State2__region0_a :
		{
			exseq_mainRegion_State2__region0_a();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State6 :
		{
			exseq_mainRegion_State2__region0_State4__region0_State6();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9();
			break;
		}
		case mainRegion_State2__region0_State5 :
		{
			exseq_mainRegion_State2__region0_State5();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
void DeepHistory::exseq_mainRegion_State2__region0_State4__region0()
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of DeepHistory.mainRegion.State2._region0.State4._region0) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case mainRegion_State2__region0_State4__region0_State6 :
		{
			exseq_mainRegion_State2__region0_State4__region0_State6();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
void DeepHistory::exseq_mainRegion_State2__region0_State4__region0_State7__region0()
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of DeepHistory.mainRegion.State2._region0.State4._region0.State7._region0) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9();
			break;
		}
		default: break;
	}
}

/* The reactions of state State1. */
void DeepHistory::react_mainRegion_State1()
{
	/* The reactions of state State1. */
	if (check_mainRegion_State1_tr0_tr0())
	{ 
		effect_mainRegion_State1_tr0();
	} 
}

/* The reactions of state a. */
void DeepHistory::react_mainRegion_State2__region0_a()
{
	/* The reactions of state a. */
	if (check_mainRegion_State2_tr0_tr0())
	{ 
		effect_mainRegion_State2_tr0();
	}  else
	{
		if (check_mainRegion_State2__region0_a_tr0_tr0())
		{ 
			effect_mainRegion_State2__region0_a_tr0();
		} 
	}
}

/* The reactions of state State6. */
void DeepHistory::react_mainRegion_State2__region0_State4__region0_State6()
{
	/* The reactions of state State6. */
	if (check_mainRegion_State2_tr0_tr0())
	{ 
		effect_mainRegion_State2_tr0();
	}  else
	{
		if (check_mainRegion_State2__region0_State4_tr0_tr0())
		{ 
			effect_mainRegion_State2__region0_State4_tr0();
		}  else
		{
			if (check_mainRegion_State2__region0_State4__region0_State6_tr0_tr0())
			{ 
				effect_mainRegion_State2__region0_State4__region0_State6_tr0();
			} 
		}
	}
}

/* The reactions of state State8. */
void DeepHistory::react_mainRegion_State2__region0_State4__region0_State7__region0_State8()
{
	/* The reactions of state State8. */
	if (check_mainRegion_State2_tr0_tr0())
	{ 
		effect_mainRegion_State2_tr0();
	}  else
	{
		if (check_mainRegion_State2__region0_State4_tr0_tr0())
		{ 
			effect_mainRegion_State2__region0_State4_tr0();
		}  else
		{
			if (check_mainRegion_State2__region0_State4__region0_State7_tr0_tr0())
			{ 
				effect_mainRegion_State2__region0_State4__region0_State7_tr0();
			}  else
			{
				if (check_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0_tr0())
				{ 
					effect_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0();
				} 
			}
		}
	}
}

/* The reactions of state State9. */
void DeepHistory::react_mainRegion_State2__region0_State4__region0_State7__region0_State9()
{
	/* The reactions of state State9. */
	if (check_mainRegion_State2_tr0_tr0())
	{ 
		effect_mainRegion_State2_tr0();
	}  else
	{
		if (check_mainRegion_State2__region0_State4_tr0_tr0())
		{ 
			effect_mainRegion_State2__region0_State4_tr0();
		}  else
		{
			if (check_mainRegion_State2__region0_State4__region0_State7_tr0_tr0())
			{ 
				effect_mainRegion_State2__region0_State4__region0_State7_tr0();
			}  else
			{
				if (check_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0_tr0())
				{ 
					effect_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0();
				} 
			}
		}
	}
}

/* The reactions of state State5. */
void DeepHistory::react_mainRegion_State2__region0_State5()
{
	/* The reactions of state State5. */
	if (check_mainRegion_State2_tr0_tr0())
	{ 
		effect_mainRegion_State2_tr0();
	}  else
	{
	}
}

/* Default react sequence for initial entry  */
void DeepHistory::react_mainRegion__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_mainRegion_State1_default();
}

/* Default react sequence for initial entry  */
void DeepHistory::react_mainRegion_State2__region0_State4__region0__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_mainRegion_State2__region0_State4__region0_State6_default();
}

/* Default react sequence for initial entry  */
void DeepHistory::react_mainRegion_State2__region0_State4__region0_State7__region0__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default();
}

/* Default react sequence for deep history entry  */
void DeepHistory::react_mainRegion_State2__region0__entry_Default()
{
	/* Default react sequence for deep history entry  */
	/* Enter the region with deep history */
	if (historyVector[0] != DeepHistory_last_state)
	{
		dhenseq_mainRegion_State2__region0();
	} else
	{
		enseq_mainRegion_State2__region0_a_default();
	} 
}


