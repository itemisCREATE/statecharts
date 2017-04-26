
#include "IntegerExpressions.h"
#include <string.h>

/*! \file Implementation of the state machine 'IntegerExpressions'
*/

IntegerExpressions::IntegerExpressions()
{
	
	
	stateConfVectorPosition = 0;
	
}

IntegerExpressions::~IntegerExpressions()
{
}


void IntegerExpressions::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = IntegerExpressions_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart IntegerExpressions */
	iface.myInt1 = 0;
	iface.myInt2 = 0;
	iface.less = false;
	iface.greater = false;
	iface.equalOrLess = false;
	iface.equalOrGreater = false;
	iface.equal = false;
	iface.notEqual = false;
	iface.plus = 0;
	iface.minus = 0;
	iface.multiply = 0;
	iface.division = 0;
	iface.modulo = 0;
	iface.negat = 0;
	iface.complement = false;
	iface.multiAssign = 2;
	iface.divAssign = 20;
	iface.plusAssign = 2;
	iface.minusAssign = 2;
	iface.moduloAssign = 20;
}

void IntegerExpressions::enter()
{
	/* Default enter sequence for statechart IntegerExpressions */
	enseq_main_region_default();
}

void IntegerExpressions::exit()
{
	/* Default exit sequence for statechart IntegerExpressions */
	exseq_main_region();
}

sc_boolean IntegerExpressions::isActive() const
{
	return stateConfVector[0] != IntegerExpressions_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean IntegerExpressions::isFinal() const
{
   return false;}

void IntegerExpressions::runCycle()
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

void IntegerExpressions::clearInEvents()
{
	iface.e1_raised = false;
}

void IntegerExpressions::clearOutEvents()
{
}


sc_boolean IntegerExpressions::isStateActive(IntegerExpressionsStates state) const
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

IntegerExpressions::DefaultSCI* IntegerExpressions::getDefaultSCI()
{
	return &iface;
}

void IntegerExpressions::DefaultSCI::raise_e1()
{
	e1_raised = true;
}

void IntegerExpressions::raise_e1()
{
	iface.raise_e1();
}


sc_integer IntegerExpressions::DefaultSCI::get_myInt1() const
{
	return myInt1;
}

sc_integer IntegerExpressions::get_myInt1() const
{
	return iface.myInt1;
}

void IntegerExpressions::DefaultSCI::set_myInt1(sc_integer value)
{
	myInt1 = value;
}

void IntegerExpressions::set_myInt1(sc_integer value)
{
	iface.myInt1 = value;
}

sc_integer IntegerExpressions::DefaultSCI::get_myInt2() const
{
	return myInt2;
}

sc_integer IntegerExpressions::get_myInt2() const
{
	return iface.myInt2;
}

void IntegerExpressions::DefaultSCI::set_myInt2(sc_integer value)
{
	myInt2 = value;
}

void IntegerExpressions::set_myInt2(sc_integer value)
{
	iface.myInt2 = value;
}

sc_boolean IntegerExpressions::DefaultSCI::get_less() const
{
	return less;
}

sc_boolean IntegerExpressions::get_less() const
{
	return iface.less;
}

void IntegerExpressions::DefaultSCI::set_less(sc_boolean value)
{
	less = value;
}

void IntegerExpressions::set_less(sc_boolean value)
{
	iface.less = value;
}

sc_boolean IntegerExpressions::DefaultSCI::get_greater() const
{
	return greater;
}

sc_boolean IntegerExpressions::get_greater() const
{
	return iface.greater;
}

void IntegerExpressions::DefaultSCI::set_greater(sc_boolean value)
{
	greater = value;
}

void IntegerExpressions::set_greater(sc_boolean value)
{
	iface.greater = value;
}

sc_boolean IntegerExpressions::DefaultSCI::get_equalOrLess() const
{
	return equalOrLess;
}

sc_boolean IntegerExpressions::get_equalOrLess() const
{
	return iface.equalOrLess;
}

void IntegerExpressions::DefaultSCI::set_equalOrLess(sc_boolean value)
{
	equalOrLess = value;
}

void IntegerExpressions::set_equalOrLess(sc_boolean value)
{
	iface.equalOrLess = value;
}

sc_boolean IntegerExpressions::DefaultSCI::get_equalOrGreater() const
{
	return equalOrGreater;
}

sc_boolean IntegerExpressions::get_equalOrGreater() const
{
	return iface.equalOrGreater;
}

void IntegerExpressions::DefaultSCI::set_equalOrGreater(sc_boolean value)
{
	equalOrGreater = value;
}

void IntegerExpressions::set_equalOrGreater(sc_boolean value)
{
	iface.equalOrGreater = value;
}

sc_boolean IntegerExpressions::DefaultSCI::get_equal() const
{
	return equal;
}

sc_boolean IntegerExpressions::get_equal() const
{
	return iface.equal;
}

void IntegerExpressions::DefaultSCI::set_equal(sc_boolean value)
{
	equal = value;
}

void IntegerExpressions::set_equal(sc_boolean value)
{
	iface.equal = value;
}

sc_boolean IntegerExpressions::DefaultSCI::get_notEqual() const
{
	return notEqual;
}

sc_boolean IntegerExpressions::get_notEqual() const
{
	return iface.notEqual;
}

void IntegerExpressions::DefaultSCI::set_notEqual(sc_boolean value)
{
	notEqual = value;
}

void IntegerExpressions::set_notEqual(sc_boolean value)
{
	iface.notEqual = value;
}

sc_integer IntegerExpressions::DefaultSCI::get_plus() const
{
	return plus;
}

sc_integer IntegerExpressions::get_plus() const
{
	return iface.plus;
}

void IntegerExpressions::DefaultSCI::set_plus(sc_integer value)
{
	plus = value;
}

void IntegerExpressions::set_plus(sc_integer value)
{
	iface.plus = value;
}

sc_integer IntegerExpressions::DefaultSCI::get_minus() const
{
	return minus;
}

sc_integer IntegerExpressions::get_minus() const
{
	return iface.minus;
}

void IntegerExpressions::DefaultSCI::set_minus(sc_integer value)
{
	minus = value;
}

void IntegerExpressions::set_minus(sc_integer value)
{
	iface.minus = value;
}

sc_integer IntegerExpressions::DefaultSCI::get_multiply() const
{
	return multiply;
}

sc_integer IntegerExpressions::get_multiply() const
{
	return iface.multiply;
}

void IntegerExpressions::DefaultSCI::set_multiply(sc_integer value)
{
	multiply = value;
}

void IntegerExpressions::set_multiply(sc_integer value)
{
	iface.multiply = value;
}

sc_integer IntegerExpressions::DefaultSCI::get_division() const
{
	return division;
}

sc_integer IntegerExpressions::get_division() const
{
	return iface.division;
}

void IntegerExpressions::DefaultSCI::set_division(sc_integer value)
{
	division = value;
}

void IntegerExpressions::set_division(sc_integer value)
{
	iface.division = value;
}

sc_integer IntegerExpressions::DefaultSCI::get_modulo() const
{
	return modulo;
}

sc_integer IntegerExpressions::get_modulo() const
{
	return iface.modulo;
}

void IntegerExpressions::DefaultSCI::set_modulo(sc_integer value)
{
	modulo = value;
}

void IntegerExpressions::set_modulo(sc_integer value)
{
	iface.modulo = value;
}

sc_integer IntegerExpressions::DefaultSCI::get_negat() const
{
	return negat;
}

sc_integer IntegerExpressions::get_negat() const
{
	return iface.negat;
}

void IntegerExpressions::DefaultSCI::set_negat(sc_integer value)
{
	negat = value;
}

void IntegerExpressions::set_negat(sc_integer value)
{
	iface.negat = value;
}

sc_boolean IntegerExpressions::DefaultSCI::get_complement() const
{
	return complement;
}

sc_boolean IntegerExpressions::get_complement() const
{
	return iface.complement;
}

void IntegerExpressions::DefaultSCI::set_complement(sc_boolean value)
{
	complement = value;
}

void IntegerExpressions::set_complement(sc_boolean value)
{
	iface.complement = value;
}

sc_integer IntegerExpressions::DefaultSCI::get_multiAssign() const
{
	return multiAssign;
}

sc_integer IntegerExpressions::get_multiAssign() const
{
	return iface.multiAssign;
}

void IntegerExpressions::DefaultSCI::set_multiAssign(sc_integer value)
{
	multiAssign = value;
}

void IntegerExpressions::set_multiAssign(sc_integer value)
{
	iface.multiAssign = value;
}

sc_integer IntegerExpressions::DefaultSCI::get_divAssign() const
{
	return divAssign;
}

sc_integer IntegerExpressions::get_divAssign() const
{
	return iface.divAssign;
}

void IntegerExpressions::DefaultSCI::set_divAssign(sc_integer value)
{
	divAssign = value;
}

void IntegerExpressions::set_divAssign(sc_integer value)
{
	iface.divAssign = value;
}

sc_integer IntegerExpressions::DefaultSCI::get_plusAssign() const
{
	return plusAssign;
}

sc_integer IntegerExpressions::get_plusAssign() const
{
	return iface.plusAssign;
}

void IntegerExpressions::DefaultSCI::set_plusAssign(sc_integer value)
{
	plusAssign = value;
}

void IntegerExpressions::set_plusAssign(sc_integer value)
{
	iface.plusAssign = value;
}

sc_integer IntegerExpressions::DefaultSCI::get_minusAssign() const
{
	return minusAssign;
}

sc_integer IntegerExpressions::get_minusAssign() const
{
	return iface.minusAssign;
}

void IntegerExpressions::DefaultSCI::set_minusAssign(sc_integer value)
{
	minusAssign = value;
}

void IntegerExpressions::set_minusAssign(sc_integer value)
{
	iface.minusAssign = value;
}

sc_integer IntegerExpressions::DefaultSCI::get_moduloAssign() const
{
	return moduloAssign;
}

sc_integer IntegerExpressions::get_moduloAssign() const
{
	return iface.moduloAssign;
}

void IntegerExpressions::DefaultSCI::set_moduloAssign(sc_integer value)
{
	moduloAssign = value;
}

void IntegerExpressions::set_moduloAssign(sc_integer value)
{
	iface.moduloAssign = value;
}


// implementations of all internal functions

sc_boolean IntegerExpressions::check_main_region_StateA_tr0_tr0()
{
	return iface.e1_raised;
}

void IntegerExpressions::effect_main_region_StateA_tr0()
{
	exseq_main_region_StateA();
	enseq_main_region_StateB_default();
}

/* Entry action for state 'StateA'. */
void IntegerExpressions::enact_main_region_StateA()
{
	/* Entry action for state 'StateA'. */
	iface.myInt1 = 10;
	iface.myInt2 = 5;
}

/* Entry action for state 'StateB'. */
void IntegerExpressions::enact_main_region_StateB()
{
	/* Entry action for state 'StateB'. */
	iface.less = (iface.myInt1 < iface.myInt2);
	iface.greater = (iface.myInt1 > iface.myInt2);
	iface.equalOrLess = (iface.myInt1 <= iface.myInt2);
	iface.equalOrGreater = (iface.myInt1 >= iface.myInt2);
	iface.equal = (iface.myInt1 == iface.myInt2);
	iface.notEqual = (iface.myInt1 != iface.myInt2);
	iface.plus = iface.myInt1 + iface.myInt2;
	iface.minus = iface.myInt1 - iface.myInt2;
	iface.multiply = iface.myInt1 * iface.myInt2;
	iface.division = iface.myInt1 / iface.myInt2;
	iface.modulo = iface.myInt1 % iface.myInt2;
	iface.negat = -iface.myInt1;
	iface.multiAssign *= iface.myInt1;
	iface.divAssign /= iface.myInt1;
	iface.plusAssign += iface.myInt1;
	iface.minusAssign -= iface.myInt1;
	iface.moduloAssign %= iface.myInt1;
}

/* 'default' enter sequence for state StateA */
void IntegerExpressions::enseq_main_region_StateA_default()
{
	/* 'default' enter sequence for state StateA */
	enact_main_region_StateA();
	stateConfVector[0] = main_region_StateA;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateB */
void IntegerExpressions::enseq_main_region_StateB_default()
{
	/* 'default' enter sequence for state StateB */
	enact_main_region_StateB();
	stateConfVector[0] = main_region_StateB;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void IntegerExpressions::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state StateA */
void IntegerExpressions::exseq_main_region_StateA()
{
	/* Default exit sequence for state StateA */
	stateConfVector[0] = IntegerExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateB */
void IntegerExpressions::exseq_main_region_StateB()
{
	/* Default exit sequence for state StateB */
	stateConfVector[0] = IntegerExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void IntegerExpressions::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of IntegerExpressions.main_region) at position 0... */
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
void IntegerExpressions::react_main_region_StateA()
{
	/* The reactions of state StateA. */
	if (check_main_region_StateA_tr0_tr0())
	{ 
		effect_main_region_StateA_tr0();
	} 
}

/* The reactions of state StateB. */
void IntegerExpressions::react_main_region_StateB()
{
	/* The reactions of state StateB. */
}

/* Default react sequence for initial entry  */
void IntegerExpressions::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_StateA_default();
}


