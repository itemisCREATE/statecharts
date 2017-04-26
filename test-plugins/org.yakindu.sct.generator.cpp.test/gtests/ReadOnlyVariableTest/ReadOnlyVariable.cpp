
#include "ReadOnlyVariable.h"
#include <string.h>

/*! \file Implementation of the state machine 'ReadOnlyVariable'
*/

ReadOnlyVariable::ReadOnlyVariable()
{
	
	
	stateConfVectorPosition = 0;
	
}

ReadOnlyVariable::~ReadOnlyVariable()
{
}


void ReadOnlyVariable::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = ReadOnlyVariable_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart ReadOnlyVariable */
	iface.myInt = 0;
	iface.myString = "testString";
	iface.myBool = true;
	iface.myReal = 1.1;
	ifaceA.myInt = 0;
	ifaceA.myString = "testString";
	ifaceA.myBool = true;
	ifaceA.myReal = 1.1;
}

void ReadOnlyVariable::enter()
{
	/* Default enter sequence for statechart ReadOnlyVariable */
	enseq_main_region_default();
}

void ReadOnlyVariable::exit()
{
	/* Default exit sequence for statechart ReadOnlyVariable */
	exseq_main_region();
}

sc_boolean ReadOnlyVariable::isActive() const
{
	return stateConfVector[0] != ReadOnlyVariable_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean ReadOnlyVariable::isFinal() const
{
   return false;}

void ReadOnlyVariable::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_StateB :
		{
			react_main_region_StateB();
			break;
		}
		case main_region_StateA :
		{
			react_main_region_StateA();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void ReadOnlyVariable::clearInEvents()
{
}

void ReadOnlyVariable::clearOutEvents()
{
}


sc_boolean ReadOnlyVariable::isStateActive(ReadOnlyVariableStates state) const
{
	switch (state)
	{
		case main_region_StateB : 
			return (sc_boolean) (stateConfVector[0] == main_region_StateB
			);
		case main_region_StateA : 
			return (sc_boolean) (stateConfVector[0] == main_region_StateA
			);
		default: return false;
	}
}

ReadOnlyVariable::DefaultSCI* ReadOnlyVariable::getDefaultSCI()
{
	return &iface;
}


sc_integer ReadOnlyVariable::DefaultSCI::get_myInt() const
{
	return myInt;
}

sc_integer ReadOnlyVariable::get_myInt() const
{
	return iface.myInt;
}

sc_string ReadOnlyVariable::DefaultSCI::get_myString() const
{
	return myString;
}

sc_string ReadOnlyVariable::get_myString() const
{
	return iface.myString;
}

sc_boolean ReadOnlyVariable::DefaultSCI::get_myBool() const
{
	return myBool;
}

sc_boolean ReadOnlyVariable::get_myBool() const
{
	return iface.myBool;
}

sc_real ReadOnlyVariable::DefaultSCI::get_myReal() const
{
	return myReal;
}

sc_real ReadOnlyVariable::get_myReal() const
{
	return iface.myReal;
}

ReadOnlyVariable::SCI_A* ReadOnlyVariable::getSCI_A()
{
	return &ifaceA;
}


sc_integer ReadOnlyVariable::SCI_A::get_myInt() const
{
	return myInt;
}

sc_string ReadOnlyVariable::SCI_A::get_myString() const
{
	return myString;
}

sc_boolean ReadOnlyVariable::SCI_A::get_myBool() const
{
	return myBool;
}

sc_real ReadOnlyVariable::SCI_A::get_myReal() const
{
	return myReal;
}


// implementations of all internal functions

sc_boolean ReadOnlyVariable::check_main_region_StateA_tr0_tr0()
{
	return true;
}

void ReadOnlyVariable::effect_main_region_StateA_tr0()
{
	exseq_main_region_StateA();
	enseq_main_region_StateB_default();
}

/* Entry action for state 'StateB'. */
void ReadOnlyVariable::enact_main_region_StateB()
{
	/* Entry action for state 'StateB'. */
	iface.myInt = 100;
	iface.myString = "fail";
	iface.myBool = false;
	iface.myReal = 6.6;
	ifaceA.myInt = 200;
	ifaceA.myString = "A_fail";
	ifaceA.myBool = false;
	ifaceA.myReal = 7.7;
}

/* 'default' enter sequence for state StateB */
void ReadOnlyVariable::enseq_main_region_StateB_default()
{
	/* 'default' enter sequence for state StateB */
	enact_main_region_StateB();
	stateConfVector[0] = main_region_StateB;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateA */
void ReadOnlyVariable::enseq_main_region_StateA_default()
{
	/* 'default' enter sequence for state StateA */
	stateConfVector[0] = main_region_StateA;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void ReadOnlyVariable::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state StateB */
void ReadOnlyVariable::exseq_main_region_StateB()
{
	/* Default exit sequence for state StateB */
	stateConfVector[0] = ReadOnlyVariable_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateA */
void ReadOnlyVariable::exseq_main_region_StateA()
{
	/* Default exit sequence for state StateA */
	stateConfVector[0] = ReadOnlyVariable_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void ReadOnlyVariable::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of ReadOnlyVariable.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_StateB :
		{
			exseq_main_region_StateB();
			break;
		}
		case main_region_StateA :
		{
			exseq_main_region_StateA();
			break;
		}
		default: break;
	}
}

/* The reactions of state StateB. */
void ReadOnlyVariable::react_main_region_StateB()
{
	/* The reactions of state StateB. */
}

/* The reactions of state StateA. */
void ReadOnlyVariable::react_main_region_StateA()
{
	/* The reactions of state StateA. */
	effect_main_region_StateA_tr0();
}

/* Default react sequence for initial entry  */
void ReadOnlyVariable::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_StateA_default();
}


