
#include "ShallowHistory.h"
#include <string.h>

/*! \file Implementation of the state machine 'ShallowHistory'
*/

ShallowHistory::ShallowHistory()
{
	
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = ShallowHistory_last_state;
	
	stateConfVectorPosition = 0;
	
}

ShallowHistory::~ShallowHistory()
{
}


void ShallowHistory::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = ShallowHistory_last_state;
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = ShallowHistory_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void ShallowHistory::enter()
{
	/* Default enter sequence for statechart ShallowHistory */
	enseq_mainRegion_default();
}

void ShallowHistory::exit()
{
	/* Default exit sequence for statechart ShallowHistory */
	exseq_mainRegion();
}

sc_boolean ShallowHistory::isActive() const
{
	return stateConfVector[0] != ShallowHistory_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean ShallowHistory::isFinal() const
{
   return false;}

void ShallowHistory::runCycle()
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
		case mainRegion_State2__region0_State3 :
		{
			react_mainRegion_State2__region0_State3();
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

void ShallowHistory::clearInEvents()
{
	iface.event1_raised = false;
	iface.event2_raised = false;
	iface.event3_raised = false;
	iface.event4_raised = false;
	iface.event5_raised = false;
	iface.event6_raised = false;
	iface.event7_raised = false;
	iface.event8_raised = false;
}

void ShallowHistory::clearOutEvents()
{
}


sc_boolean ShallowHistory::isStateActive(ShallowHistoryStates state) const
{
	switch (state)
	{
		case mainRegion_State1 : 
			return (sc_boolean) (stateConfVector[0] == mainRegion_State1
			);
		case mainRegion_State2 : 
			return (sc_boolean) (stateConfVector[0] >= mainRegion_State2
				&& stateConfVector[0] <= mainRegion_State2__region0_State5);
		case mainRegion_State2__region0_State3 : 
			return (sc_boolean) (stateConfVector[0] == mainRegion_State2__region0_State3
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

ShallowHistory::DefaultSCI* ShallowHistory::getDefaultSCI()
{
	return &iface;
}

void ShallowHistory::DefaultSCI::raise_event1()
{
	event1_raised = true;
}

void ShallowHistory::raise_event1()
{
	iface.raise_event1();
}

void ShallowHistory::DefaultSCI::raise_event2()
{
	event2_raised = true;
}

void ShallowHistory::raise_event2()
{
	iface.raise_event2();
}

void ShallowHistory::DefaultSCI::raise_event3()
{
	event3_raised = true;
}

void ShallowHistory::raise_event3()
{
	iface.raise_event3();
}

void ShallowHistory::DefaultSCI::raise_event4()
{
	event4_raised = true;
}

void ShallowHistory::raise_event4()
{
	iface.raise_event4();
}

void ShallowHistory::DefaultSCI::raise_event5()
{
	event5_raised = true;
}

void ShallowHistory::raise_event5()
{
	iface.raise_event5();
}

void ShallowHistory::DefaultSCI::raise_event6()
{
	event6_raised = true;
}

void ShallowHistory::raise_event6()
{
	iface.raise_event6();
}

void ShallowHistory::DefaultSCI::raise_event7()
{
	event7_raised = true;
}

void ShallowHistory::raise_event7()
{
	iface.raise_event7();
}

void ShallowHistory::DefaultSCI::raise_event8()
{
	event8_raised = true;
}

void ShallowHistory::raise_event8()
{
	iface.raise_event8();
}



// implementations of all internal functions

sc_boolean ShallowHistory::check_mainRegion_State1_tr0_tr0()
{
	return iface.event1_raised;
}

sc_boolean ShallowHistory::check_mainRegion_State2_tr0_tr0()
{
	return iface.event2_raised;
}

sc_boolean ShallowHistory::check_mainRegion_State2__region0_State3_tr0_tr0()
{
	return iface.event3_raised;
}

sc_boolean ShallowHistory::check_mainRegion_State2__region0_State4_tr0_tr0()
{
	return iface.event4_raised;
}

sc_boolean ShallowHistory::check_mainRegion_State2__region0_State4__region0_State6_tr0_tr0()
{
	return iface.event5_raised;
}

sc_boolean ShallowHistory::check_mainRegion_State2__region0_State4__region0_State7_tr0_tr0()
{
	return iface.event6_raised;
}

sc_boolean ShallowHistory::check_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0_tr0()
{
	return iface.event7_raised;
}

sc_boolean ShallowHistory::check_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0_tr0()
{
	return iface.event8_raised;
}

void ShallowHistory::effect_mainRegion_State1_tr0()
{
	exseq_mainRegion_State1();
	enseq_mainRegion_State2_default();
}

void ShallowHistory::effect_mainRegion_State2_tr0()
{
	exseq_mainRegion_State2();
	enseq_mainRegion_State1_default();
}

void ShallowHistory::effect_mainRegion_State2__region0_State3_tr0()
{
	exseq_mainRegion_State2__region0_State3();
	enseq_mainRegion_State2__region0_State4_default();
}

void ShallowHistory::effect_mainRegion_State2__region0_State4_tr0()
{
	exseq_mainRegion_State2__region0_State4();
	enseq_mainRegion_State2__region0_State5_default();
}

void ShallowHistory::effect_mainRegion_State2__region0_State4__region0_State6_tr0()
{
	exseq_mainRegion_State2__region0_State4__region0_State6();
	enseq_mainRegion_State2__region0_State4__region0_State7_default();
}

void ShallowHistory::effect_mainRegion_State2__region0_State4__region0_State7_tr0()
{
	exseq_mainRegion_State2__region0_State4__region0_State7();
	enseq_mainRegion_State2__region0_State4__region0_State6_default();
}

void ShallowHistory::effect_mainRegion_State2__region0_State4__region0_State7__region0_State8_tr0()
{
	exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8();
	enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default();
}

void ShallowHistory::effect_mainRegion_State2__region0_State4__region0_State7__region0_State9_tr0()
{
	exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9();
	enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default();
}

/* 'default' enter sequence for state State1 */
void ShallowHistory::enseq_mainRegion_State1_default()
{
	/* 'default' enter sequence for state State1 */
	stateConfVector[0] = mainRegion_State1;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state State2 */
void ShallowHistory::enseq_mainRegion_State2_default()
{
	/* 'default' enter sequence for state State2 */
	enseq_mainRegion_State2__region0_default();
}

/* 'default' enter sequence for state State3 */
void ShallowHistory::enseq_mainRegion_State2__region0_State3_default()
{
	/* 'default' enter sequence for state State3 */
	stateConfVector[0] = mainRegion_State2__region0_State3;
	stateConfVectorPosition = 0;
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state State4 */
void ShallowHistory::enseq_mainRegion_State2__region0_State4_default()
{
	/* 'default' enter sequence for state State4 */
	enseq_mainRegion_State2__region0_State4__region0_default();
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state State6 */
void ShallowHistory::enseq_mainRegion_State2__region0_State4__region0_State6_default()
{
	/* 'default' enter sequence for state State6 */
	stateConfVector[0] = mainRegion_State2__region0_State4__region0_State6;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state State7 */
void ShallowHistory::enseq_mainRegion_State2__region0_State4__region0_State7_default()
{
	/* 'default' enter sequence for state State7 */
	enseq_mainRegion_State2__region0_State4__region0_State7__region0_default();
}

/* 'default' enter sequence for state State8 */
void ShallowHistory::enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default()
{
	/* 'default' enter sequence for state State8 */
	stateConfVector[0] = mainRegion_State2__region0_State4__region0_State7__region0_State8;
	stateConfVectorPosition = 0;
	historyVector[1] = stateConfVector[0];
}

/* 'default' enter sequence for state State9 */
void ShallowHistory::enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default()
{
	/* 'default' enter sequence for state State9 */
	stateConfVector[0] = mainRegion_State2__region0_State4__region0_State7__region0_State9;
	stateConfVectorPosition = 0;
	historyVector[1] = stateConfVector[0];
}

/* 'default' enter sequence for state State5 */
void ShallowHistory::enseq_mainRegion_State2__region0_State5_default()
{
	/* 'default' enter sequence for state State5 */
	stateConfVector[0] = mainRegion_State2__region0_State5;
	stateConfVectorPosition = 0;
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for region mainRegion */
void ShallowHistory::enseq_mainRegion_default()
{
	/* 'default' enter sequence for region mainRegion */
	react_mainRegion__entry_Default();
}

/* 'default' enter sequence for region null */
void ShallowHistory::enseq_mainRegion_State2__region0_default()
{
	/* 'default' enter sequence for region null */
	react_mainRegion_State2__region0__entry_Default();
}

/* shallow enterSequence with history in child null */
void ShallowHistory::shenseq_mainRegion_State2__region0()
{
	/* shallow enterSequence with history in child null */
	/* Handle shallow history entry of null */
	switch(historyVector[ 0 ])
	{
		case mainRegion_State2__region0_State3 :
		{
			enseq_mainRegion_State2__region0_State3_default();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State6 :
		{
			enseq_mainRegion_State2__region0_State4_default();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			enseq_mainRegion_State2__region0_State4_default();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			enseq_mainRegion_State2__region0_State4_default();
			break;
		}
		case mainRegion_State2__region0_State5 :
		{
			enseq_mainRegion_State2__region0_State5_default();
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region null */
void ShallowHistory::enseq_mainRegion_State2__region0_State4__region0_default()
{
	/* 'default' enter sequence for region null */
	react_mainRegion_State2__region0_State4__region0__entry_Default();
}

/* 'default' enter sequence for region null */
void ShallowHistory::enseq_mainRegion_State2__region0_State4__region0_State7__region0_default()
{
	/* 'default' enter sequence for region null */
	react_mainRegion_State2__region0_State4__region0_State7__region0__entry_Default();
}

/* shallow enterSequence with history in child null */
void ShallowHistory::shenseq_mainRegion_State2__region0_State4__region0_State7__region0()
{
	/* shallow enterSequence with history in child null */
	/* Handle shallow history entry of null */
	switch(historyVector[ 1 ])
	{
		case mainRegion_State2__region0_State4__region0_State7__region0_State8 :
		{
			enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default();
			break;
		}
		case mainRegion_State2__region0_State4__region0_State7__region0_State9 :
		{
			enseq_mainRegion_State2__region0_State4__region0_State7__region0_State9_default();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for state State1 */
void ShallowHistory::exseq_mainRegion_State1()
{
	/* Default exit sequence for state State1 */
	stateConfVector[0] = ShallowHistory_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state State2 */
void ShallowHistory::exseq_mainRegion_State2()
{
	/* Default exit sequence for state State2 */
	exseq_mainRegion_State2__region0();
}

/* Default exit sequence for state State3 */
void ShallowHistory::exseq_mainRegion_State2__region0_State3()
{
	/* Default exit sequence for state State3 */
	stateConfVector[0] = ShallowHistory_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state State4 */
void ShallowHistory::exseq_mainRegion_State2__region0_State4()
{
	/* Default exit sequence for state State4 */
	exseq_mainRegion_State2__region0_State4__region0();
}

/* Default exit sequence for state State6 */
void ShallowHistory::exseq_mainRegion_State2__region0_State4__region0_State6()
{
	/* Default exit sequence for state State6 */
	stateConfVector[0] = ShallowHistory_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state State7 */
void ShallowHistory::exseq_mainRegion_State2__region0_State4__region0_State7()
{
	/* Default exit sequence for state State7 */
	exseq_mainRegion_State2__region0_State4__region0_State7__region0();
}

/* Default exit sequence for state State8 */
void ShallowHistory::exseq_mainRegion_State2__region0_State4__region0_State7__region0_State8()
{
	/* Default exit sequence for state State8 */
	stateConfVector[0] = ShallowHistory_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state State9 */
void ShallowHistory::exseq_mainRegion_State2__region0_State4__region0_State7__region0_State9()
{
	/* Default exit sequence for state State9 */
	stateConfVector[0] = ShallowHistory_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state State5 */
void ShallowHistory::exseq_mainRegion_State2__region0_State5()
{
	/* Default exit sequence for state State5 */
	stateConfVector[0] = ShallowHistory_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region mainRegion */
void ShallowHistory::exseq_mainRegion()
{
	/* Default exit sequence for region mainRegion */
	/* Handle exit of all possible states (of ShallowHistory.mainRegion) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case mainRegion_State1 :
		{
			exseq_mainRegion_State1();
			break;
		}
		case mainRegion_State2__region0_State3 :
		{
			exseq_mainRegion_State2__region0_State3();
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
void ShallowHistory::exseq_mainRegion_State2__region0()
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of ShallowHistory.mainRegion.State2._region0) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case mainRegion_State2__region0_State3 :
		{
			exseq_mainRegion_State2__region0_State3();
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
void ShallowHistory::exseq_mainRegion_State2__region0_State4__region0()
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of ShallowHistory.mainRegion.State2._region0.State4._region0) at position 0... */
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
void ShallowHistory::exseq_mainRegion_State2__region0_State4__region0_State7__region0()
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of ShallowHistory.mainRegion.State2._region0.State4._region0.State7._region0) at position 0... */
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
void ShallowHistory::react_mainRegion_State1()
{
	/* The reactions of state State1. */
	if (check_mainRegion_State1_tr0_tr0())
	{ 
		effect_mainRegion_State1_tr0();
	} 
}

/* The reactions of state State3. */
void ShallowHistory::react_mainRegion_State2__region0_State3()
{
	/* The reactions of state State3. */
	if (check_mainRegion_State2_tr0_tr0())
	{ 
		effect_mainRegion_State2_tr0();
	}  else
	{
		if (check_mainRegion_State2__region0_State3_tr0_tr0())
		{ 
			effect_mainRegion_State2__region0_State3_tr0();
		} 
	}
}

/* The reactions of state State6. */
void ShallowHistory::react_mainRegion_State2__region0_State4__region0_State6()
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
void ShallowHistory::react_mainRegion_State2__region0_State4__region0_State7__region0_State8()
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
void ShallowHistory::react_mainRegion_State2__region0_State4__region0_State7__region0_State9()
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
void ShallowHistory::react_mainRegion_State2__region0_State5()
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
void ShallowHistory::react_mainRegion__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_mainRegion_State1_default();
}

/* Default react sequence for shallow history entry  */
void ShallowHistory::react_mainRegion_State2__region0__entry_Default()
{
	/* Default react sequence for shallow history entry  */
	/* Enter the region with shallow history */
	if (historyVector[0] != ShallowHistory_last_state)
	{
		shenseq_mainRegion_State2__region0();
	} else
	{
		enseq_mainRegion_State2__region0_State3_default();
	} 
}

/* Default react sequence for initial entry  */
void ShallowHistory::react_mainRegion_State2__region0_State4__region0__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_mainRegion_State2__region0_State4__region0_State6_default();
}

/* Default react sequence for shallow history entry  */
void ShallowHistory::react_mainRegion_State2__region0_State4__region0_State7__region0__entry_Default()
{
	/* Default react sequence for shallow history entry  */
	/* Enter the region with shallow history */
	if (historyVector[1] != ShallowHistory_last_state)
	{
		shenseq_mainRegion_State2__region0_State4__region0_State7__region0();
	} else
	{
		enseq_mainRegion_State2__region0_State4__region0_State7__region0_State8_default();
	} 
}


