
#include "StatechartKeywords.h"
#include <string.h>

/*! \file Implementation of the state machine 'StatechartKeywords'
*/

StatechartKeywords::StatechartKeywords()
{
	
	ifaceIf_OCB = null;
	ifaceInternalSCI_OCB = null;
	
	stateConfVectorPosition = 0;
	
	timer = null;
}

StatechartKeywords::~StatechartKeywords()
{
}


void StatechartKeywords::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = StatechartKeywords_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart StatechartKeywords */
	ifaceIf.timer = 0;
	ifaceIf.isActive = 0;
	ifaceIf.init = 0;
	ifaceIf.enter_ID = 0;
	ifaceIf.runCycle_ID = 0;
	ifaceInternalSCI.timer = 0;
	ifaceInternalSCI.isActive = 0;
	ifaceInternalSCI.init = 0;
	ifaceInternalSCI.enter_ID = 0;
	ifaceInternalSCI.runCycle_ID = 0;
	ifaceInternalSCI.sCIIf = 0;
}

void StatechartKeywords::enter()
{
	/* Default enter sequence for statechart StatechartKeywords */
	enact();
	enseq_main_region_default();
}

void StatechartKeywords::exit()
{
	/* Default exit sequence for statechart StatechartKeywords */
	exseq_main_region();
	exact();
}

sc_boolean StatechartKeywords::isActive() const
{
	return stateConfVector[0] != StatechartKeywords_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean StatechartKeywords::isFinal() const
{
   return false;}

void StatechartKeywords::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_Timer :
		{
			react_main_region_Timer();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void StatechartKeywords::clearInEvents()
{
	ifaceInternalSCI.operationCallback_raised = false; 
	ifaceInternalSCI.listeners_raised = false; 
	timeEvents[0] = false; 
}

void StatechartKeywords::clearOutEvents()
{
	ifaceIf.operationCallback_raised = false;
	ifaceIf.listeners_raised = false;
}


void StatechartKeywords::setTimer(TimerInterface* timer)
{
	this->timer = timer;
}

TimerInterface* StatechartKeywords::getTimer()
{
	return timer;
}

void StatechartKeywords::raiseTimeEvent(sc_eventid evid)
{
	if ((evid >= (sc_eventid)timeEvents) && (evid < (sc_eventid)(&timeEvents[timeEventsCount])))
	{
		*(sc_boolean*)evid = true;
	}				
}

sc_boolean StatechartKeywords::isStateActive(StatechartKeywordsStates state) const
{
	switch (state)
	{
		case main_region_Timer : 
			return (sc_boolean) (stateConfVector[SCVI_MAIN_REGION_TIMER] == main_region_Timer
			);
		default: return false;
	}
}

StatechartKeywords::SCI_If* StatechartKeywords::getSCI_If()
{
	return &ifaceIf;
}

sc_boolean StatechartKeywords::SCI_If::isRaised_operationCallback() const
{
	return operationCallback_raised;
}

sc_boolean StatechartKeywords::SCI_If::isRaised_listeners() const
{
	return listeners_raised;
}


sc_integer StatechartKeywords::SCI_If::get_timer() const
{
	return timer;
}

void StatechartKeywords::SCI_If::set_timer(sc_integer value)
{
	timer = value;
}

sc_integer StatechartKeywords::SCI_If::get_isActive() const
{
	return isActive;
}

void StatechartKeywords::SCI_If::set_isActive(sc_integer value)
{
	isActive = value;
}

sc_integer StatechartKeywords::SCI_If::get_init() const
{
	return init;
}

void StatechartKeywords::SCI_If::set_init(sc_integer value)
{
	init = value;
}

sc_integer StatechartKeywords::SCI_If::get_enter() const
{
	return enter_ID;
}

void StatechartKeywords::SCI_If::set_enter(sc_integer value)
{
	enter_ID = value;
}

sc_integer StatechartKeywords::SCI_If::get_runCycle() const
{
	return runCycle_ID;
}

void StatechartKeywords::SCI_If::set_runCycle(sc_integer value)
{
	runCycle_ID = value;
}

void StatechartKeywords::setSCI_If_OCB(SCI_If_OCB* operationCallback)
{
	ifaceIf_OCB = operationCallback;
}

void StatechartKeywords::InternalSCI::raise_operationCallback()
{
	operationCallback_raised = true;
}

sc_boolean StatechartKeywords::InternalSCI::isRaised_operationCallback() const
{
	return operationCallback_raised;
}

void StatechartKeywords::InternalSCI::raise_listeners()
{
	listeners_raised = true;
}

sc_boolean StatechartKeywords::InternalSCI::isRaised_listeners() const
{
	return listeners_raised;
}

sc_integer StatechartKeywords::InternalSCI::get_timer() const
{
	return timer;
}

void StatechartKeywords::InternalSCI::set_timer(sc_integer value)
{
	timer = value;
}

sc_integer StatechartKeywords::InternalSCI::get_isActive() const
{
	return isActive;
}

void StatechartKeywords::InternalSCI::set_isActive(sc_integer value)
{
	isActive = value;
}

sc_integer StatechartKeywords::InternalSCI::get_init() const
{
	return init;
}

void StatechartKeywords::InternalSCI::set_init(sc_integer value)
{
	init = value;
}

sc_integer StatechartKeywords::InternalSCI::get_enter() const
{
	return enter_ID;
}

void StatechartKeywords::InternalSCI::set_enter(sc_integer value)
{
	enter_ID = value;
}

sc_integer StatechartKeywords::InternalSCI::get_runCycle() const
{
	return runCycle_ID;
}

void StatechartKeywords::InternalSCI::set_runCycle(sc_integer value)
{
	runCycle_ID = value;
}

sc_integer StatechartKeywords::InternalSCI::get_sCIIf() const
{
	return sCIIf;
}

void StatechartKeywords::InternalSCI::set_sCIIf(sc_integer value)
{
	sCIIf = value;
}

void StatechartKeywords::setInternalSCI_OCB(InternalSCI_OCB* operationCallback)
{
	ifaceInternalSCI_OCB = operationCallback;
}

// implementations of all internal functions

sc_boolean StatechartKeywords::check__lr0()
{
	return timeEvents[0];
}

void StatechartKeywords::effect__lr0()
{
	ifaceInternalSCI.timer += 1;
}

/* Entry action for statechart 'StatechartKeywords'. */
void StatechartKeywords::enact()
{
	/* Entry action for statechart 'StatechartKeywords'. */
	timer->setTimer(this, (sc_eventid)(&timeEvents[0]), 1 * 1000, true);
}

/* Exit action for state 'StatechartKeywords'. */
void StatechartKeywords::exact()
{
	/* Exit action for state 'StatechartKeywords'. */
	timer->unsetTimer(this, (sc_eventid)(&timeEvents[0]));
}

/* 'default' enter sequence for state Timer */
void StatechartKeywords::enseq_main_region_Timer_default()
{
	/* 'default' enter sequence for state Timer */
	stateConfVector[0] = main_region_Timer;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void StatechartKeywords::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state Timer */
void StatechartKeywords::exseq_main_region_Timer()
{
	/* Default exit sequence for state Timer */
	stateConfVector[0] = StatechartKeywords_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void StatechartKeywords::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of StatechartKeywords.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_Timer :
		{
			exseq_main_region_Timer();
			break;
		}
		default: break;
	}
}

/* The reactions of state Timer. */
void StatechartKeywords::react_main_region_Timer()
{
	/* The reactions of state Timer. */
	if (check__lr0())
	{ 
		effect__lr0();
	} 
}

/* Default react sequence for initial entry  */
void StatechartKeywords::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_Timer_default();
}


