
#include "AlwaysOncycle.h"
#include <string.h>

/*! \file Implementation of the state machine 'AlwaysOncycle'
*/

AlwaysOncycle::AlwaysOncycle()
{
	
	
	stateConfVectorPosition = 0;
	
}

AlwaysOncycle::~AlwaysOncycle()
{
}


void AlwaysOncycle::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = AlwaysOncycle_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart AlwaysOncycle */
	iface.value = 0;
	iface.v2 = false;
}

void AlwaysOncycle::enter()
{
	/* Default enter sequence for statechart AlwaysOncycle */
	enseq_main_region_default();
}

void AlwaysOncycle::exit()
{
	/* Default exit sequence for statechart AlwaysOncycle */
	exseq_main_region();
}

sc_boolean AlwaysOncycle::isActive() const
{
	return stateConfVector[0] != AlwaysOncycle_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean AlwaysOncycle::isFinal() const
{
   return false;}

void AlwaysOncycle::runCycle()
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
		default:
			break;
		}
	}
	
	clearInEvents();
}

void AlwaysOncycle::clearInEvents()
{
}

void AlwaysOncycle::clearOutEvents()
{
}


sc_boolean AlwaysOncycle::isStateActive(AlwaysOncycleStates state) const
{
	switch (state)
	{
		case main_region_StateA : 
			return (sc_boolean) (stateConfVector[SCVI_MAIN_REGION_STATEA] == main_region_StateA
			);
		case main_region_StateB : 
			return (sc_boolean) (stateConfVector[SCVI_MAIN_REGION_STATEB] == main_region_StateB
			);
		default: return false;
	}
}

AlwaysOncycle::DefaultSCI* AlwaysOncycle::getDefaultSCI()
{
	return &iface;
}


sc_integer AlwaysOncycle::DefaultSCI::get_value() const
{
	return value;
}

sc_integer AlwaysOncycle::get_value() const
{
	return iface.value;
}

void AlwaysOncycle::DefaultSCI::set_value(sc_integer value)
{
	value = value;
}

void AlwaysOncycle::set_value(sc_integer value)
{
	iface.value = value;
}

sc_boolean AlwaysOncycle::DefaultSCI::get_v2() const
{
	return v2;
}

sc_boolean AlwaysOncycle::get_v2() const
{
	return iface.v2;
}

void AlwaysOncycle::DefaultSCI::set_v2(sc_boolean value)
{
	v2 = value;
}

void AlwaysOncycle::set_v2(sc_boolean value)
{
	iface.v2 = value;
}


// implementations of all internal functions

sc_boolean AlwaysOncycle::check_main_region_StateA_lr1_lr1()
{
	return true;
}

sc_boolean AlwaysOncycle::check_main_region_StateA_tr0_tr0()
{
	return iface.value == 5;
}

sc_boolean AlwaysOncycle::check_main_region_StateB_lr0_lr0()
{
	return true;
}

sc_boolean AlwaysOncycle::check_main_region_StateB_tr0_tr0()
{
	return iface.value == 5;
}

void AlwaysOncycle::effect_main_region_StateA_lr1_lr1()
{
	iface.value += 1;
}

void AlwaysOncycle::effect_main_region_StateA_tr0()
{
	exseq_main_region_StateA();
	enseq_main_region_StateB_default();
}

void AlwaysOncycle::effect_main_region_StateB_lr0_lr0()
{
	iface.value += 1;
}

void AlwaysOncycle::effect_main_region_StateB_tr0()
{
	exseq_main_region_StateB();
	enseq_main_region_StateA_default();
}

/* Entry action for state 'StateA'. */
void AlwaysOncycle::enact_main_region_StateA()
{
	/* Entry action for state 'StateA'. */
	iface.value = 0;
}

/* Exit action for state 'StateA'. */
void AlwaysOncycle::exact_main_region_StateA()
{
	/* Exit action for state 'StateA'. */
	iface.value = 0;
}

/* 'default' enter sequence for state StateA */
void AlwaysOncycle::enseq_main_region_StateA_default()
{
	/* 'default' enter sequence for state StateA */
	enact_main_region_StateA();
	stateConfVector[0] = main_region_StateA;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
void AlwaysOncycle::enseq_main_region_StateB_default()
{
	/* 'default' enter sequence for state StateB */
	stateConfVector[0] = main_region_StateB;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void AlwaysOncycle::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state StateA */
void AlwaysOncycle::exseq_main_region_StateA()
{
	/* Default exit sequence for state StateA */
	stateConfVector[0] = AlwaysOncycle_last_state;
	stateConfVectorPosition = 0;
	exact_main_region_StateA();
}

/* Default exit sequence for state StateB */
void AlwaysOncycle::exseq_main_region_StateB()
{
	/* Default exit sequence for state StateB */
	stateConfVector[0] = AlwaysOncycle_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void AlwaysOncycle::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of AlwaysOncycle.main_region) at position 0... */
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

/* The reactions of state StateA. */
void AlwaysOncycle::react_main_region_StateA()
{
	/* The reactions of state StateA. */
	if (check_main_region_StateA_tr0_tr0())
	{ 
		effect_main_region_StateA_tr0();
	}  else
	{
		effect_main_region_StateA_lr1_lr1();
	}
}

/* The reactions of state StateB. */
void AlwaysOncycle::react_main_region_StateB()
{
	/* The reactions of state StateB. */
	if (check_main_region_StateB_tr0_tr0())
	{ 
		effect_main_region_StateB_tr0();
	}  else
	{
		effect_main_region_StateB_lr0_lr0();
	}
}

/* Default react sequence for initial entry  */
void AlwaysOncycle::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_StateA_default();
}


