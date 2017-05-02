
#include "BooleanExpressions.h"
#include <string.h>

/*! \file Implementation of the state machine 'BooleanExpressions'
*/

BooleanExpressions::BooleanExpressions()
{
	
	
	stateConfVectorPosition = 0;
	
}

BooleanExpressions::~BooleanExpressions()
{
}


void BooleanExpressions::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = BooleanExpressions_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart BooleanExpressions */
	iface.myBool1 = false;
	iface.myBool2 = false;
	iface.and_ID = false;
	iface.or_ID = false;
	iface.not_ID = false;
	iface.equal = false;
	iface.notequal = false;
}

void BooleanExpressions::enter()
{
	/* Default enter sequence for statechart BooleanExpressions */
	enseq_main_region_default();
}

void BooleanExpressions::exit()
{
	/* Default exit sequence for statechart BooleanExpressions */
	exseq_main_region();
}

sc_boolean BooleanExpressions::isActive() const
{
	return stateConfVector[0] != BooleanExpressions_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean BooleanExpressions::isFinal() const
{
   return false;}

void BooleanExpressions::runCycle()
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

void BooleanExpressions::clearInEvents()
{
	iface.e1_raised = false;
}

void BooleanExpressions::clearOutEvents()
{
}


sc_boolean BooleanExpressions::isStateActive(BooleanExpressionsStates state) const
{
	switch (state)
	{
		case main_region_StateA : 
			return (sc_boolean) (stateConfVector[0] == main_region_StateA
			);
		case main_region_StateB : 
			return (sc_boolean) (stateConfVector[0] == main_region_StateB
			);
		default: return false;
	}
}

BooleanExpressions::DefaultSCI* BooleanExpressions::getDefaultSCI()
{
	return &iface;
}

void BooleanExpressions::DefaultSCI::raise_e1()
{
	e1_raised = true;
}

void BooleanExpressions::raise_e1()
{
	iface.raise_e1();
}


sc_boolean BooleanExpressions::DefaultSCI::get_myBool1() const
{
	return myBool1;
}

sc_boolean BooleanExpressions::get_myBool1() const
{
	return iface.myBool1;
}

void BooleanExpressions::DefaultSCI::set_myBool1(sc_boolean value)
{
	myBool1 = value;
}

void BooleanExpressions::set_myBool1(sc_boolean value)
{
	iface.myBool1 = value;
}

sc_boolean BooleanExpressions::DefaultSCI::get_myBool2() const
{
	return myBool2;
}

sc_boolean BooleanExpressions::get_myBool2() const
{
	return iface.myBool2;
}

void BooleanExpressions::DefaultSCI::set_myBool2(sc_boolean value)
{
	myBool2 = value;
}

void BooleanExpressions::set_myBool2(sc_boolean value)
{
	iface.myBool2 = value;
}

sc_boolean BooleanExpressions::DefaultSCI::get_and() const
{
	return and_ID;
}

sc_boolean BooleanExpressions::get_and() const
{
	return iface.and_ID;
}

void BooleanExpressions::DefaultSCI::set_and(sc_boolean value)
{
	and_ID = value;
}

void BooleanExpressions::set_and(sc_boolean value)
{
	iface.and_ID = value;
}

sc_boolean BooleanExpressions::DefaultSCI::get_or() const
{
	return or_ID;
}

sc_boolean BooleanExpressions::get_or() const
{
	return iface.or_ID;
}

void BooleanExpressions::DefaultSCI::set_or(sc_boolean value)
{
	or_ID = value;
}

void BooleanExpressions::set_or(sc_boolean value)
{
	iface.or_ID = value;
}

sc_boolean BooleanExpressions::DefaultSCI::get_not() const
{
	return not_ID;
}

sc_boolean BooleanExpressions::get_not() const
{
	return iface.not_ID;
}

void BooleanExpressions::DefaultSCI::set_not(sc_boolean value)
{
	not_ID = value;
}

void BooleanExpressions::set_not(sc_boolean value)
{
	iface.not_ID = value;
}

sc_boolean BooleanExpressions::DefaultSCI::get_equal() const
{
	return equal;
}

sc_boolean BooleanExpressions::get_equal() const
{
	return iface.equal;
}

void BooleanExpressions::DefaultSCI::set_equal(sc_boolean value)
{
	equal = value;
}

void BooleanExpressions::set_equal(sc_boolean value)
{
	iface.equal = value;
}

sc_boolean BooleanExpressions::DefaultSCI::get_notequal() const
{
	return notequal;
}

sc_boolean BooleanExpressions::get_notequal() const
{
	return iface.notequal;
}

void BooleanExpressions::DefaultSCI::set_notequal(sc_boolean value)
{
	notequal = value;
}

void BooleanExpressions::set_notequal(sc_boolean value)
{
	iface.notequal = value;
}


// implementations of all internal functions

sc_boolean BooleanExpressions::check_main_region_StateA_tr0_tr0()
{
	return iface.e1_raised;
}

void BooleanExpressions::effect_main_region_StateA_tr0()
{
	exseq_main_region_StateA();
	enseq_main_region_StateB_default();
}

/* Entry action for state 'StateA'. */
void BooleanExpressions::enact_main_region_StateA()
{
	/* Entry action for state 'StateA'. */
	iface.myBool1 = true;
	iface.myBool2 = false;
}

/* Entry action for state 'StateB'. */
void BooleanExpressions::enact_main_region_StateB()
{
	/* Entry action for state 'StateB'. */
	iface.and_ID = iface.myBool1 && iface.myBool2;
	iface.or_ID = iface.myBool1 || iface.myBool2;
	iface.not_ID = !iface.myBool1;
	iface.equal = iface.myBool1 == iface.myBool2;
	iface.notequal = (iface.myBool1 != iface.myBool2);
}

/* 'default' enter sequence for state StateA */
void BooleanExpressions::enseq_main_region_StateA_default()
{
	/* 'default' enter sequence for state StateA */
	enact_main_region_StateA();
	stateConfVector[0] = main_region_StateA;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
void BooleanExpressions::enseq_main_region_StateB_default()
{
	/* 'default' enter sequence for state StateB */
	enact_main_region_StateB();
	stateConfVector[0] = main_region_StateB;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void BooleanExpressions::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state StateA */
void BooleanExpressions::exseq_main_region_StateA()
{
	/* Default exit sequence for state StateA */
	stateConfVector[0] = BooleanExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateB */
void BooleanExpressions::exseq_main_region_StateB()
{
	/* Default exit sequence for state StateB */
	stateConfVector[0] = BooleanExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void BooleanExpressions::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of BooleanExpressions.main_region) at position 0... */
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
void BooleanExpressions::react_main_region_StateA()
{
	/* The reactions of state StateA. */
	if (check_main_region_StateA_tr0_tr0())
	{ 
		effect_main_region_StateA_tr0();
	} 
}

/* The reactions of state StateB. */
void BooleanExpressions::react_main_region_StateB()
{
	/* The reactions of state StateB. */
}

/* Default react sequence for initial entry  */
void BooleanExpressions::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_StateA_default();
}


