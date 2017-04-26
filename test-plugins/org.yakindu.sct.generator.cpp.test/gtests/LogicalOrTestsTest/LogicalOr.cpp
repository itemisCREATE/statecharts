
#include "LogicalOr.h"
#include <string.h>

/*! \file Implementation of the state machine 'LogicalOr'
*/

LogicalOr::LogicalOr()
{
	
	
	stateConfVectorPosition = 0;
	
}

LogicalOr::~LogicalOr()
{
}


void LogicalOr::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = LogicalOr_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart LogicalOr */
	iface.x = 1;
	iface.b = false;
}

void LogicalOr::enter()
{
	/* Default enter sequence for statechart LogicalOr */
	enseq_main_region_default();
}

void LogicalOr::exit()
{
	/* Default exit sequence for statechart LogicalOr */
	exseq_main_region();
}

sc_boolean LogicalOr::isActive() const
{
	return stateConfVector[0] != LogicalOr_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean LogicalOr::isFinal() const
{
   return false;}

void LogicalOr::runCycle()
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
		default:
			break;
		}
	}
	
	clearInEvents();
}

void LogicalOr::clearInEvents()
{
}

void LogicalOr::clearOutEvents()
{
}


sc_boolean LogicalOr::isStateActive(LogicalOrStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		default: return false;
	}
}

LogicalOr::DefaultSCI* LogicalOr::getDefaultSCI()
{
	return &iface;
}


sc_integer LogicalOr::DefaultSCI::get_x() const
{
	return x;
}

sc_integer LogicalOr::get_x() const
{
	return iface.x;
}

void LogicalOr::DefaultSCI::set_x(sc_integer value)
{
	x = value;
}

void LogicalOr::set_x(sc_integer value)
{
	iface.x = value;
}

sc_boolean LogicalOr::DefaultSCI::get_b() const
{
	return b;
}

sc_boolean LogicalOr::get_b() const
{
	return iface.b;
}

void LogicalOr::DefaultSCI::set_b(sc_boolean value)
{
	b = value;
}

void LogicalOr::set_b(sc_boolean value)
{
	iface.b = value;
}


// implementations of all internal functions

sc_boolean LogicalOr::check_main_region_A_tr0_tr0()
{
	return iface.x == 1;
}

void LogicalOr::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	iface.b = ((iface.x += 1) != 2 || (iface.x *= 2) == 4);
	enseq_main_region_A_default();
}

/* 'default' enter sequence for state A */
void LogicalOr::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void LogicalOr::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void LogicalOr::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = LogicalOr_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void LogicalOr::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of LogicalOr.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_A :
		{
			exseq_main_region_A();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void LogicalOr::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	} 
}

/* Default react sequence for initial entry  */
void LogicalOr::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


