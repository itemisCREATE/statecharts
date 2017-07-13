
#include "LogicalAnd.h"
#include <string.h>

/*! \file Implementation of the state machine 'LogicalAnd'
*/

LogicalAnd::LogicalAnd()
{
	
	
	stateConfVectorPosition = 0;
	
}

LogicalAnd::~LogicalAnd()
{
}


void LogicalAnd::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = LogicalAnd_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart LogicalAnd */
	iface.x = 1;
	iface.b = false;
}

void LogicalAnd::enter()
{
	/* Default enter sequence for statechart LogicalAnd */
	enseq_main_region_default();
}

void LogicalAnd::exit()
{
	/* Default exit sequence for statechart LogicalAnd */
	exseq_main_region();
}

sc_boolean LogicalAnd::isActive() const
{
	return stateConfVector[0] != LogicalAnd_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean LogicalAnd::isFinal() const
{
   return false;}

void LogicalAnd::runCycle()
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

void LogicalAnd::clearInEvents()
{
}

void LogicalAnd::clearOutEvents()
{
}


sc_boolean LogicalAnd::isStateActive(LogicalAndStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[SCVI_MAIN_REGION_A] == main_region_A
			);
		default: return false;
	}
}

LogicalAnd::DefaultSCI* LogicalAnd::getDefaultSCI()
{
	return &iface;
}


sc_integer LogicalAnd::DefaultSCI::get_x() const
{
	return x;
}

sc_integer LogicalAnd::get_x() const
{
	return iface.x;
}

void LogicalAnd::DefaultSCI::set_x(sc_integer value)
{
	x = value;
}

void LogicalAnd::set_x(sc_integer value)
{
	iface.x = value;
}

sc_boolean LogicalAnd::DefaultSCI::get_b() const
{
	return b;
}

sc_boolean LogicalAnd::get_b() const
{
	return iface.b;
}

void LogicalAnd::DefaultSCI::set_b(sc_boolean value)
{
	b = value;
}

void LogicalAnd::set_b(sc_boolean value)
{
	iface.b = value;
}


// implementations of all internal functions

sc_boolean LogicalAnd::check_main_region_A_tr0_tr0()
{
	return iface.x == 1;
}

void LogicalAnd::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	iface.b = ((iface.x += 1) == 2 && (iface.x *= 2) == 4);
	enseq_main_region_A_default();
}

/* 'default' enter sequence for state A */
void LogicalAnd::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void LogicalAnd::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void LogicalAnd::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = LogicalAnd_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void LogicalAnd::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of LogicalAnd.main_region) at position 0... */
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
void LogicalAnd::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	} 
}

/* Default react sequence for initial entry  */
void LogicalAnd::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


