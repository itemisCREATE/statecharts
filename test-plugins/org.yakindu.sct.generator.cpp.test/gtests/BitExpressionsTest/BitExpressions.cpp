
#include "BitExpressions.h"
#include <string.h>

/*! \file Implementation of the state machine 'BitExpressions'
*/

BitExpressions::BitExpressions()
{
	
	
	stateConfVectorPosition = 0;
	
}

BitExpressions::~BitExpressions()
{
}


void BitExpressions::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = BitExpressions_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart BitExpressions */
	iface.myBit1 = 0;
	iface.myBit2 = 0;
	iface.leftBitshift = 0;
	iface.rightBitshift = 0;
	iface.complementBitshift = 0;
	iface.bitwiseAnd = 0;
	iface.bitwiseOr = 0;
	iface.bitwiseXor = 0;
}

void BitExpressions::enter()
{
	/* Default enter sequence for statechart BitExpressions */
	enseq_main_region_default();
}

void BitExpressions::exit()
{
	/* Default exit sequence for statechart BitExpressions */
	exseq_main_region();
}

sc_boolean BitExpressions::isActive() const
{
	return stateConfVector[0] != BitExpressions_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean BitExpressions::isFinal() const
{
   return false;}

void BitExpressions::runCycle()
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

void BitExpressions::clearInEvents()
{
	iface.e1_raised = false;
}

void BitExpressions::clearOutEvents()
{
}


sc_boolean BitExpressions::isStateActive(BitExpressionsStates state) const
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

BitExpressions::DefaultSCI* BitExpressions::getDefaultSCI()
{
	return &iface;
}

void BitExpressions::DefaultSCI::raise_e1()
{
	e1_raised = true;
}

void BitExpressions::raise_e1()
{
	iface.raise_e1();
}


sc_integer BitExpressions::DefaultSCI::get_myBit1() const
{
	return myBit1;
}

sc_integer BitExpressions::get_myBit1() const
{
	return iface.myBit1;
}

void BitExpressions::DefaultSCI::set_myBit1(sc_integer value)
{
	myBit1 = value;
}

void BitExpressions::set_myBit1(sc_integer value)
{
	iface.myBit1 = value;
}

sc_integer BitExpressions::DefaultSCI::get_myBit2() const
{
	return myBit2;
}

sc_integer BitExpressions::get_myBit2() const
{
	return iface.myBit2;
}

void BitExpressions::DefaultSCI::set_myBit2(sc_integer value)
{
	myBit2 = value;
}

void BitExpressions::set_myBit2(sc_integer value)
{
	iface.myBit2 = value;
}

sc_integer BitExpressions::DefaultSCI::get_leftBitshift() const
{
	return leftBitshift;
}

sc_integer BitExpressions::get_leftBitshift() const
{
	return iface.leftBitshift;
}

void BitExpressions::DefaultSCI::set_leftBitshift(sc_integer value)
{
	leftBitshift = value;
}

void BitExpressions::set_leftBitshift(sc_integer value)
{
	iface.leftBitshift = value;
}

sc_integer BitExpressions::DefaultSCI::get_rightBitshift() const
{
	return rightBitshift;
}

sc_integer BitExpressions::get_rightBitshift() const
{
	return iface.rightBitshift;
}

void BitExpressions::DefaultSCI::set_rightBitshift(sc_integer value)
{
	rightBitshift = value;
}

void BitExpressions::set_rightBitshift(sc_integer value)
{
	iface.rightBitshift = value;
}

sc_integer BitExpressions::DefaultSCI::get_complementBitshift() const
{
	return complementBitshift;
}

sc_integer BitExpressions::get_complementBitshift() const
{
	return iface.complementBitshift;
}

void BitExpressions::DefaultSCI::set_complementBitshift(sc_integer value)
{
	complementBitshift = value;
}

void BitExpressions::set_complementBitshift(sc_integer value)
{
	iface.complementBitshift = value;
}

sc_integer BitExpressions::DefaultSCI::get_bitwiseAnd() const
{
	return bitwiseAnd;
}

sc_integer BitExpressions::get_bitwiseAnd() const
{
	return iface.bitwiseAnd;
}

void BitExpressions::DefaultSCI::set_bitwiseAnd(sc_integer value)
{
	bitwiseAnd = value;
}

void BitExpressions::set_bitwiseAnd(sc_integer value)
{
	iface.bitwiseAnd = value;
}

sc_integer BitExpressions::DefaultSCI::get_bitwiseOr() const
{
	return bitwiseOr;
}

sc_integer BitExpressions::get_bitwiseOr() const
{
	return iface.bitwiseOr;
}

void BitExpressions::DefaultSCI::set_bitwiseOr(sc_integer value)
{
	bitwiseOr = value;
}

void BitExpressions::set_bitwiseOr(sc_integer value)
{
	iface.bitwiseOr = value;
}

sc_integer BitExpressions::DefaultSCI::get_bitwiseXor() const
{
	return bitwiseXor;
}

sc_integer BitExpressions::get_bitwiseXor() const
{
	return iface.bitwiseXor;
}

void BitExpressions::DefaultSCI::set_bitwiseXor(sc_integer value)
{
	bitwiseXor = value;
}

void BitExpressions::set_bitwiseXor(sc_integer value)
{
	iface.bitwiseXor = value;
}


// implementations of all internal functions

sc_boolean BitExpressions::check_main_region_StateA_tr0_tr0()
{
	return iface.e1_raised;
}

void BitExpressions::effect_main_region_StateA_tr0()
{
	exseq_main_region_StateA();
	enseq_main_region_StateB_default();
}

/* Entry action for state 'StateA'. */
void BitExpressions::enact_main_region_StateA()
{
	/* Entry action for state 'StateA'. */
	iface.myBit1 = 5;
	iface.myBit2 = 7;
}

/* Entry action for state 'StateB'. */
void BitExpressions::enact_main_region_StateB()
{
	/* Entry action for state 'StateB'. */
	iface.leftBitshift = iface.myBit1 << 1;
	iface.rightBitshift = iface.myBit1 >> 1;
	iface.complementBitshift = ~iface.myBit1;
	iface.bitwiseAnd = iface.myBit1 & iface.myBit2;
	iface.bitwiseOr = iface.myBit1 | iface.myBit2;
	iface.bitwiseXor = iface.myBit1 ^ iface.myBit2;
}

/* 'default' enter sequence for state StateA */
void BitExpressions::enseq_main_region_StateA_default()
{
	/* 'default' enter sequence for state StateA */
	enact_main_region_StateA();
	stateConfVector[0] = main_region_StateA;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
void BitExpressions::enseq_main_region_StateB_default()
{
	/* 'default' enter sequence for state StateB */
	enact_main_region_StateB();
	stateConfVector[0] = main_region_StateB;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void BitExpressions::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state StateA */
void BitExpressions::exseq_main_region_StateA()
{
	/* Default exit sequence for state StateA */
	stateConfVector[0] = BitExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateB */
void BitExpressions::exseq_main_region_StateB()
{
	/* Default exit sequence for state StateB */
	stateConfVector[0] = BitExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void BitExpressions::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of BitExpressions.main_region) at position 0... */
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
void BitExpressions::react_main_region_StateA()
{
	/* The reactions of state StateA. */
	if (check_main_region_StateA_tr0_tr0())
	{ 
		effect_main_region_StateA_tr0();
	} 
}

/* The reactions of state StateB. */
void BitExpressions::react_main_region_StateB()
{
	/* The reactions of state StateB. */
}

/* Default react sequence for initial entry  */
void BitExpressions::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_StateA_default();
}


