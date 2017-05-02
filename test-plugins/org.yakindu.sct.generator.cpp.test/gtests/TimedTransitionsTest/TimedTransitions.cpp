
#include "TimedTransitions.h"
#include <string.h>

/*! \file Implementation of the state machine 'TimedTransitions'
*/

TimedTransitions::TimedTransitions()
{
	
	
	stateConfVectorPosition = 0;
	
	timer = null;
}

TimedTransitions::~TimedTransitions()
{
}


void TimedTransitions::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = TimedTransitions_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart TimedTransitions */
	ifaceInternalSCI.x = 0;
	ifaceInternalSCI.y = 0;
}

void TimedTransitions::enter()
{
	/* Default enter sequence for statechart TimedTransitions */
	enact();
	enseq_main_region_default();
}

void TimedTransitions::exit()
{
	/* Default exit sequence for statechart TimedTransitions */
	exseq_main_region();
	exact();
}

sc_boolean TimedTransitions::isActive() const
{
	return stateConfVector[0] != TimedTransitions_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean TimedTransitions::isFinal() const
{
   return false;}

void TimedTransitions::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_Start :
		{
			react_main_region_Start();
			break;
		}
		case main_region_End :
		{
			react_main_region_End();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void TimedTransitions::clearInEvents()
{
	timeEvents[0] = false; 
	timeEvents[1] = false; 
}

void TimedTransitions::clearOutEvents()
{
}


void TimedTransitions::setTimer(TimerInterface* timer)
{
	this->timer = timer;
}

TimerInterface* TimedTransitions::getTimer()
{
	return timer;
}

void TimedTransitions::raiseTimeEvent(sc_eventid evid)
{
	if ((evid >= (sc_eventid)timeEvents) && (evid < (sc_eventid)(&timeEvents[timeEventsCount])))
	{
		*(sc_boolean*)evid = true;
	}				
}

sc_boolean TimedTransitions::isStateActive(TimedTransitionsStates state) const
{
	switch (state)
	{
		case main_region_Start : 
			return (sc_boolean) (stateConfVector[0] == main_region_Start
			);
		case main_region_End : 
			return (sc_boolean) (stateConfVector[0] == main_region_End
			);
		default: return false;
	}
}


sc_integer TimedTransitions::InternalSCI::get_x() const
{
	return x;
}

void TimedTransitions::InternalSCI::set_x(sc_integer value)
{
	x = value;
}

sc_integer TimedTransitions::InternalSCI::get_y() const
{
	return y;
}

void TimedTransitions::InternalSCI::set_y(sc_integer value)
{
	y = value;
}


// implementations of all internal functions

sc_boolean TimedTransitions::check__lr0()
{
	return timeEvents[1];
}

sc_boolean TimedTransitions::check__lr1()
{
	return true;
}

sc_boolean TimedTransitions::check_main_region_Start_tr0_tr0()
{
	return timeEvents[0];
}

void TimedTransitions::effect__lr0()
{
	ifaceInternalSCI.x += 1;
}

void TimedTransitions::effect__lr1()
{
	ifaceInternalSCI.y += 1;
}

void TimedTransitions::effect_main_region_Start_tr0()
{
	exseq_main_region_Start();
	enseq_main_region_End_default();
}

/* Entry action for statechart 'TimedTransitions'. */
void TimedTransitions::enact()
{
	/* Entry action for statechart 'TimedTransitions'. */
	timer->setTimer(this, (sc_eventid)(&timeEvents[1]), 1 * 1000, true);
}

/* Entry action for state 'Start'. */
void TimedTransitions::enact_main_region_Start()
{
	/* Entry action for state 'Start'. */
	timer->setTimer(this, (sc_eventid)(&timeEvents[0]), 2 * 1000, false);
}

/* Exit action for state 'TimedTransitions'. */
void TimedTransitions::exact()
{
	/* Exit action for state 'TimedTransitions'. */
	timer->unsetTimer(this, (sc_eventid)(&timeEvents[1]));
}

/* Exit action for state 'Start'. */
void TimedTransitions::exact_main_region_Start()
{
	/* Exit action for state 'Start'. */
	timer->unsetTimer(this, (sc_eventid)(&timeEvents[0]));
}

/* 'default' enter sequence for state Start */
void TimedTransitions::enseq_main_region_Start_default()
{
	/* 'default' enter sequence for state Start */
	enact_main_region_Start();
	stateConfVector[0] = main_region_Start;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state End */
void TimedTransitions::enseq_main_region_End_default()
{
	/* 'default' enter sequence for state End */
	stateConfVector[0] = main_region_End;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void TimedTransitions::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state Start */
void TimedTransitions::exseq_main_region_Start()
{
	/* Default exit sequence for state Start */
	stateConfVector[0] = TimedTransitions_last_state;
	stateConfVectorPosition = 0;
	exact_main_region_Start();
}

/* Default exit sequence for state End */
void TimedTransitions::exseq_main_region_End()
{
	/* Default exit sequence for state End */
	stateConfVector[0] = TimedTransitions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void TimedTransitions::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of TimedTransitions.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_Start :
		{
			exseq_main_region_Start();
			break;
		}
		case main_region_End :
		{
			exseq_main_region_End();
			break;
		}
		default: break;
	}
}

/* The reactions of state Start. */
void TimedTransitions::react_main_region_Start()
{
	/* The reactions of state Start. */
	if (check__lr0())
	{ 
		effect__lr0();
	} 
	effect__lr1();
	if (check_main_region_Start_tr0_tr0())
	{ 
		effect_main_region_Start_tr0();
	} 
}

/* The reactions of state End. */
void TimedTransitions::react_main_region_End()
{
	/* The reactions of state End. */
	if (check__lr0())
	{ 
		effect__lr0();
	} 
	effect__lr1();
}

/* Default react sequence for initial entry  */
void TimedTransitions::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_Start_default();
}


