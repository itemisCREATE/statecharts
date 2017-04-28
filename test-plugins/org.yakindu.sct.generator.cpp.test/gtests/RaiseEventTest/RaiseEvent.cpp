
#include "RaiseEvent.h"
#include <string.h>

/*! \file Implementation of the state machine 'RaiseEvent'
*/

RaiseEvent::RaiseEvent()
{
	
	
	stateConfVectorPosition = 0;
	
}

RaiseEvent::~RaiseEvent()
{
}


void RaiseEvent::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = RaiseEvent_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void RaiseEvent::enter()
{
	/* Default enter sequence for statechart RaiseEvent */
	enseq_main_region_default();
	enseq_second_region_default();
}

void RaiseEvent::exit()
{
	/* Default exit sequence for statechart RaiseEvent */
	exseq_main_region();
	exseq_second_region();
}

sc_boolean RaiseEvent::isActive() const
{
	return stateConfVector[0] != RaiseEvent_last_state||stateConfVector[1] != RaiseEvent_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean RaiseEvent::isFinal() const
{
   return false;}

void RaiseEvent::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_StateA :
		{
			react_main_region_StateA();
			break;
		}
		case main_region_StateB :
		{
			react_main_region_StateB();
			break;
		}
		case second_region_SateA :
		{
			react_second_region_SateA();
			break;
		}
		case second_region_StateB :
		{
			react_second_region_StateB();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void RaiseEvent::clearInEvents()
{
	iface.e2_raised = false;
}

void RaiseEvent::clearOutEvents()
{
	iface.e1_raised = false;
}


sc_boolean RaiseEvent::isStateActive(RaiseEventStates state) const
{
	switch (state)
	{
		case main_region_StateA : 
			return (sc_boolean) (stateConfVector[0] == main_region_StateA
			);
		case main_region_StateB : 
			return (sc_boolean) (stateConfVector[0] == main_region_StateB
			);
		case second_region_SateA : 
			return (sc_boolean) (stateConfVector[1] == second_region_SateA
			);
		case second_region_StateB : 
			return (sc_boolean) (stateConfVector[1] == second_region_StateB
			);
		default: return false;
	}
}

RaiseEvent::DefaultSCI* RaiseEvent::getDefaultSCI()
{
	return &iface;
}

void RaiseEvent::DefaultSCI::raise_e2()
{
	e2_raised = true;
}

void RaiseEvent::raise_e2()
{
	iface.raise_e2();
}

sc_boolean RaiseEvent::DefaultSCI::isRaised_e1() const
{
	return e1_raised;
}

sc_boolean RaiseEvent::isRaised_e1() const
{
	return iface.isRaised_e1();
}



// implementations of all internal functions

sc_boolean RaiseEvent::check_main_region_StateA_tr0_tr0()
{
	return iface.e2_raised;
}

sc_boolean RaiseEvent::check_second_region_SateA_tr0_tr0()
{
	return iface.e1_raised;
}

void RaiseEvent::effect_main_region_StateA_tr0()
{
	exseq_main_region_StateA();
	enseq_main_region_StateB_default();
}

void RaiseEvent::effect_second_region_SateA_tr0()
{
	exseq_second_region_SateA();
	enseq_second_region_StateB_default();
}

/* Entry action for state 'StateB'. */
void RaiseEvent::enact_main_region_StateB()
{
	/* Entry action for state 'StateB'. */
	iface.e1_raised = true;
}

/* 'default' enter sequence for state StateA */
void RaiseEvent::enseq_main_region_StateA_default()
{
	/* 'default' enter sequence for state StateA */
	stateConfVector[0] = main_region_StateA;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
void RaiseEvent::enseq_main_region_StateB_default()
{
	/* 'default' enter sequence for state StateB */
	enact_main_region_StateB();
	stateConfVector[0] = main_region_StateB;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state SateA */
void RaiseEvent::enseq_second_region_SateA_default()
{
	/* 'default' enter sequence for state SateA */
	stateConfVector[1] = second_region_SateA;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state StateB */
void RaiseEvent::enseq_second_region_StateB_default()
{
	/* 'default' enter sequence for state StateB */
	stateConfVector[1] = second_region_StateB;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region main region */
void RaiseEvent::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* 'default' enter sequence for region second region */
void RaiseEvent::enseq_second_region_default()
{
	/* 'default' enter sequence for region second region */
	react_second_region__entry_Default();
}

/* Default exit sequence for state StateA */
void RaiseEvent::exseq_main_region_StateA()
{
	/* Default exit sequence for state StateA */
	stateConfVector[0] = RaiseEvent_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateB */
void RaiseEvent::exseq_main_region_StateB()
{
	/* Default exit sequence for state StateB */
	stateConfVector[0] = RaiseEvent_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state SateA */
void RaiseEvent::exseq_second_region_SateA()
{
	/* Default exit sequence for state SateA */
	stateConfVector[1] = RaiseEvent_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state StateB */
void RaiseEvent::exseq_second_region_StateB()
{
	/* Default exit sequence for state StateB */
	stateConfVector[1] = RaiseEvent_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for region main region */
void RaiseEvent::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of RaiseEvent.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_StateA :
		{
			exseq_main_region_StateA();
			break;
		}
		case main_region_StateB :
		{
			exseq_main_region_StateB();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region second region */
void RaiseEvent::exseq_second_region()
{
	/* Default exit sequence for region second region */
	/* Handle exit of all possible states (of RaiseEvent.second_region) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case second_region_SateA :
		{
			exseq_second_region_SateA();
			break;
		}
		case second_region_StateB :
		{
			exseq_second_region_StateB();
			break;
		}
		default: break;
	}
}

/* The reactions of state StateA. */
void RaiseEvent::react_main_region_StateA()
{
	/* The reactions of state StateA. */
	if (check_main_region_StateA_tr0_tr0())
	{ 
		effect_main_region_StateA_tr0();
	} 
}

/* The reactions of state StateB. */
void RaiseEvent::react_main_region_StateB()
{
	/* The reactions of state StateB. */
}

/* The reactions of state SateA. */
void RaiseEvent::react_second_region_SateA()
{
	/* The reactions of state SateA. */
	if (check_second_region_SateA_tr0_tr0())
	{ 
		effect_second_region_SateA_tr0();
	} 
}

/* The reactions of state StateB. */
void RaiseEvent::react_second_region_StateB()
{
}

/* Default react sequence for initial entry  */
void RaiseEvent::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_StateA_default();
}

/* Default react sequence for initial entry  */
void RaiseEvent::react_second_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_second_region_SateA_default();
}


