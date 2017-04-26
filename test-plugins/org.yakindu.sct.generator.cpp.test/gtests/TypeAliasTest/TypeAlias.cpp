
#include "TypeAlias.h"
#include <string.h>

/*! \file Implementation of the state machine 'TypeAlias'
*/

TypeAlias::TypeAlias()
{
	
	
	stateConfVectorPosition = 0;
	
}

TypeAlias::~TypeAlias()
{
}


void TypeAlias::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = TypeAlias_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart TypeAlias */
	iface.myVar = 0;
	iface.myString = "";
}

void TypeAlias::enter()
{
	/* Default enter sequence for statechart TypeAlias */
	enseq_main_region_default();
}

void TypeAlias::exit()
{
	/* Default exit sequence for statechart TypeAlias */
	exseq_main_region();
}

sc_boolean TypeAlias::isActive() const
{
	return stateConfVector[0] != TypeAlias_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean TypeAlias::isFinal() const
{
   return false;}

void TypeAlias::runCycle()
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
		case main_region_Mid :
		{
			react_main_region_Mid();
			break;
		}
		case main_region_Mid2 :
		{
			react_main_region_Mid2();
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

void TypeAlias::clearInEvents()
{
	iface.myEvent_raised = false;
}

void TypeAlias::clearOutEvents()
{
}


sc_boolean TypeAlias::isStateActive(TypeAliasStates state) const
{
	switch (state)
	{
		case main_region_Start : 
			return (sc_boolean) (stateConfVector[0] == main_region_Start
			);
		case main_region_Mid : 
			return (sc_boolean) (stateConfVector[0] == main_region_Mid
			);
		case main_region_Mid2 : 
			return (sc_boolean) (stateConfVector[0] == main_region_Mid2
			);
		case main_region_End : 
			return (sc_boolean) (stateConfVector[0] == main_region_End
			);
		default: return false;
	}
}

TypeAlias::DefaultSCI* TypeAlias::getDefaultSCI()
{
	return &iface;
}

void TypeAlias::DefaultSCI::raise_myEvent()
{
	myEvent_raised = true;
}

void TypeAlias::raise_myEvent()
{
	iface.raise_myEvent();
}


sc_integer TypeAlias::DefaultSCI::get_myVar() const
{
	return myVar;
}

sc_integer TypeAlias::get_myVar() const
{
	return iface.myVar;
}

void TypeAlias::DefaultSCI::set_myVar(sc_integer value)
{
	myVar = value;
}

void TypeAlias::set_myVar(sc_integer value)
{
	iface.myVar = value;
}

sc_string TypeAlias::DefaultSCI::get_myString() const
{
	return myString;
}

sc_string TypeAlias::get_myString() const
{
	return iface.myString;
}

void TypeAlias::DefaultSCI::set_myString(sc_string value)
{
	myString = value;
}

void TypeAlias::set_myString(sc_string value)
{
	iface.myString = value;
}


// implementations of all internal functions

sc_boolean TypeAlias::check_main_region_Start_tr0_tr0()
{
	return iface.myVar == 1;
}

sc_boolean TypeAlias::check_main_region_Mid_tr0_tr0()
{
	return (strcmp(iface.myString, "TypeSystem") == 0)
	;
}

sc_boolean TypeAlias::check_main_region_Mid2_tr0_tr0()
{
	return iface.myEvent_raised;
}

void TypeAlias::effect_main_region_Start_tr0()
{
	exseq_main_region_Start();
	enseq_main_region_Mid_default();
}

void TypeAlias::effect_main_region_Mid_tr0()
{
	exseq_main_region_Mid();
	enseq_main_region_Mid2_default();
}

void TypeAlias::effect_main_region_Mid2_tr0()
{
	exseq_main_region_Mid2();
	enseq_main_region_End_default();
}

/* Entry action for state 'Start'. */
void TypeAlias::enact_main_region_Start()
{
	/* Entry action for state 'Start'. */
	iface.myVar = 1;
}

/* Entry action for state 'Mid'. */
void TypeAlias::enact_main_region_Mid()
{
	/* Entry action for state 'Mid'. */
	iface.myString = "TypeSystem";
}

/* 'default' enter sequence for state Start */
void TypeAlias::enseq_main_region_Start_default()
{
	/* 'default' enter sequence for state Start */
	enact_main_region_Start();
	stateConfVector[0] = main_region_Start;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Mid */
void TypeAlias::enseq_main_region_Mid_default()
{
	/* 'default' enter sequence for state Mid */
	enact_main_region_Mid();
	stateConfVector[0] = main_region_Mid;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Mid2 */
void TypeAlias::enseq_main_region_Mid2_default()
{
	/* 'default' enter sequence for state Mid2 */
	stateConfVector[0] = main_region_Mid2;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state End */
void TypeAlias::enseq_main_region_End_default()
{
	/* 'default' enter sequence for state End */
	stateConfVector[0] = main_region_End;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void TypeAlias::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state Start */
void TypeAlias::exseq_main_region_Start()
{
	/* Default exit sequence for state Start */
	stateConfVector[0] = TypeAlias_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Mid */
void TypeAlias::exseq_main_region_Mid()
{
	/* Default exit sequence for state Mid */
	stateConfVector[0] = TypeAlias_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Mid2 */
void TypeAlias::exseq_main_region_Mid2()
{
	/* Default exit sequence for state Mid2 */
	stateConfVector[0] = TypeAlias_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state End */
void TypeAlias::exseq_main_region_End()
{
	/* Default exit sequence for state End */
	stateConfVector[0] = TypeAlias_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void TypeAlias::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of TypeAlias.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_Start :
		{
			exseq_main_region_Start();
			break;
		}
		case main_region_Mid :
		{
			exseq_main_region_Mid();
			break;
		}
		case main_region_Mid2 :
		{
			exseq_main_region_Mid2();
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
void TypeAlias::react_main_region_Start()
{
	/* The reactions of state Start. */
	if (check_main_region_Start_tr0_tr0())
	{ 
		effect_main_region_Start_tr0();
	} 
}

/* The reactions of state Mid. */
void TypeAlias::react_main_region_Mid()
{
	/* The reactions of state Mid. */
	if (check_main_region_Mid_tr0_tr0())
	{ 
		effect_main_region_Mid_tr0();
	} 
}

/* The reactions of state Mid2. */
void TypeAlias::react_main_region_Mid2()
{
	/* The reactions of state Mid2. */
	if (check_main_region_Mid2_tr0_tr0())
	{ 
		effect_main_region_Mid2_tr0();
	} 
}

/* The reactions of state End. */
void TypeAlias::react_main_region_End()
{
	/* The reactions of state End. */
}

/* Default react sequence for initial entry  */
void TypeAlias::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_Start_default();
}


