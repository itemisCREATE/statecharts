
#include "CastExpressions.h"
#include <string.h>

/*! \file Implementation of the state machine 'CastExpressions'
*/

CastExpressions::CastExpressions()
{
	
	
	stateConfVectorPosition = 0;
	
}

CastExpressions::~CastExpressions()
{
}


void CastExpressions::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = CastExpressions_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart CastExpressions */
	iface.realValue = (((sc_real) 5));
	iface.intValue = (((sc_integer) 5.5));
}

void CastExpressions::enter()
{
	/* Default enter sequence for statechart CastExpressions */
	enseq_main_region_default();
}

void CastExpressions::exit()
{
	/* Default exit sequence for statechart CastExpressions */
	exseq_main_region();
}

sc_boolean CastExpressions::isActive() const
{
	return stateConfVector[0] != CastExpressions_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean CastExpressions::isFinal() const
{
   return false;}

void CastExpressions::runCycle()
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
		case main_region_B :
		{
			react_main_region_B();
			break;
		}
		case main_region_C :
		{
			react_main_region_C();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void CastExpressions::clearInEvents()
{
}

void CastExpressions::clearOutEvents()
{
}


sc_boolean CastExpressions::isStateActive(CastExpressionsStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		case main_region_B : 
			return (sc_boolean) (stateConfVector[0] == main_region_B
			);
		case main_region_C : 
			return (sc_boolean) (stateConfVector[0] == main_region_C
			);
		default: return false;
	}
}

CastExpressions::DefaultSCI* CastExpressions::getDefaultSCI()
{
	return &iface;
}


sc_real CastExpressions::DefaultSCI::get_realValue() const
{
	return realValue;
}

sc_real CastExpressions::get_realValue() const
{
	return iface.realValue;
}

void CastExpressions::DefaultSCI::set_realValue(sc_real value)
{
	realValue = value;
}

void CastExpressions::set_realValue(sc_real value)
{
	iface.realValue = value;
}

sc_integer CastExpressions::DefaultSCI::get_intValue() const
{
	return intValue;
}

sc_integer CastExpressions::get_intValue() const
{
	return iface.intValue;
}

void CastExpressions::DefaultSCI::set_intValue(sc_integer value)
{
	intValue = value;
}

void CastExpressions::set_intValue(sc_integer value)
{
	iface.intValue = value;
}


// implementations of all internal functions

sc_boolean CastExpressions::check_main_region_A_tr0_tr0()
{
	return true;
}

sc_boolean CastExpressions::check_main_region_B_tr0_tr0()
{
	return (true) && (((sc_real) (iface.realValue * 0.1)) > ((sc_integer) 1.4) && ((sc_integer) (iface.realValue * iface.intValue)) < ((sc_real) 100));
}

void CastExpressions::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void CastExpressions::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region_C_default();
}

/* Entry action for state 'B'. */
void CastExpressions::enact_main_region_B()
{
	/* Entry action for state 'B'. */
	iface.realValue = 3 * ((sc_integer) 5.5);
}

/* Entry action for state 'C'. */
void CastExpressions::enact_main_region_C()
{
	/* Entry action for state 'C'. */
	iface.realValue = ((sc_integer) (iface.realValue * iface.intValue * 10.1));
}

/* 'default' enter sequence for state A */
void CastExpressions::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void CastExpressions::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	enact_main_region_B();
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
void CastExpressions::enseq_main_region_C_default()
{
	/* 'default' enter sequence for state C */
	enact_main_region_C();
	stateConfVector[0] = main_region_C;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void CastExpressions::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void CastExpressions::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = CastExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void CastExpressions::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = CastExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
void CastExpressions::exseq_main_region_C()
{
	/* Default exit sequence for state C */
	stateConfVector[0] = CastExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void CastExpressions::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of CastExpressions.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_A :
		{
			exseq_main_region_A();
			break;
		}
		case main_region_B :
		{
			exseq_main_region_B();
			break;
		}
		case main_region_C :
		{
			exseq_main_region_C();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void CastExpressions::react_main_region_A()
{
	/* The reactions of state A. */
	effect_main_region_A_tr0();
}

/* The reactions of state B. */
void CastExpressions::react_main_region_B()
{
	/* The reactions of state B. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	} 
}

/* The reactions of state C. */
void CastExpressions::react_main_region_C()
{
	/* The reactions of state C. */
}

/* Default react sequence for initial entry  */
void CastExpressions::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


