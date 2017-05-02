
#include "Constants.h"
#include <string.h>

/*! \file Implementation of the state machine 'Constants'
*/

Constants::Constants()
{
	
	
	stateConfVectorPosition = 0;
	
}

Constants::~Constants()
{
}

const sc_integer Constants::DefaultSCI::x = 10;
const sc_integer Constants::DefaultSCI::y = Constants::DefaultSCI::x * 2;

const sc_string Constants::SCI_Named::y = "Hello World";
const sc_integer Constants::SCI_Named::two = 2;

const sc_integer Constants::InternalSCI::internalConstant = 5;


void Constants::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = Constants_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart Constants */
	iface.result = 0;
}

void Constants::enter()
{
	/* Default enter sequence for statechart Constants */
	enseq_main_region_default();
}

void Constants::exit()
{
	/* Default exit sequence for statechart Constants */
	exseq_main_region();
}

sc_boolean Constants::isActive() const
{
	return stateConfVector[0] != Constants_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean Constants::isFinal() const
{
   return false;}

void Constants::runCycle()
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

void Constants::clearInEvents()
{
	iface.e_raised = false;
	iface.e2_raised = false;
}

void Constants::clearOutEvents()
{
}


sc_boolean Constants::isStateActive(ConstantsStates state) const
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

Constants::DefaultSCI* Constants::getDefaultSCI()
{
	return &iface;
}

void Constants::DefaultSCI::raise_e()
{
	e_raised = true;
}

void Constants::raise_e()
{
	iface.raise_e();
}

void Constants::DefaultSCI::raise_e2(sc_integer value)
{
	e2_value = value;
	e2_raised = true;
}

void Constants::raise_e2(sc_integer value)
{
	iface.raise_e2(value);
}


const sc_integer Constants::DefaultSCI::get_x() const
{
	return x;
}

const sc_integer Constants::get_x() const
{
	return Constants::DefaultSCI::x;
}

const sc_integer Constants::DefaultSCI::get_y() const
{
	return y;
}

const sc_integer Constants::get_y() const
{
	return Constants::DefaultSCI::y;
}

sc_integer Constants::DefaultSCI::get_result() const
{
	return result;
}

sc_integer Constants::get_result() const
{
	return iface.result;
}

void Constants::DefaultSCI::set_result(sc_integer value)
{
	result = value;
}

void Constants::set_result(sc_integer value)
{
	iface.result = value;
}

Constants::SCI_Named* Constants::getSCI_Named()
{
	return &ifaceNamed;
}


const sc_string Constants::SCI_Named::get_y() const
{
	return y;
}

const sc_integer Constants::SCI_Named::get_two() const
{
	return two;
}


const sc_integer Constants::InternalSCI::get_internalConstant() const
{
	return internalConstant;
}


// implementations of all internal functions

sc_boolean Constants::check_main_region_A_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean Constants::check_main_region_B_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean Constants::check_main_region_C_tr0_tr0()
{
	return iface.e2_raised;
}

void Constants::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void Constants::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region_C_default();
}

void Constants::effect_main_region_C_tr0()
{
	exseq_main_region_C();
	iface.result = iface.e2_value * Constants::DefaultSCI::x * Constants::SCI_Named::two * Constants::InternalSCI::internalConstant;
	enseq_main_region_A_default();
}

/* Entry action for state 'B'. */
void Constants::enact_main_region_B()
{
	/* Entry action for state 'B'. */
	iface.result = Constants::SCI_Named::two * Constants::DefaultSCI::x;
}

/* Entry action for state 'C'. */
void Constants::enact_main_region_C()
{
	/* Entry action for state 'C'. */
	iface.result = iface.result * Constants::InternalSCI::internalConstant;
}

/* 'default' enter sequence for state A */
void Constants::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void Constants::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	enact_main_region_B();
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
void Constants::enseq_main_region_C_default()
{
	/* 'default' enter sequence for state C */
	enact_main_region_C();
	stateConfVector[0] = main_region_C;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void Constants::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void Constants::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = Constants_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void Constants::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = Constants_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
void Constants::exseq_main_region_C()
{
	/* Default exit sequence for state C */
	stateConfVector[0] = Constants_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void Constants::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of Constants.main_region) at position 0... */
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
void Constants::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	} 
}

/* The reactions of state B. */
void Constants::react_main_region_B()
{
	/* The reactions of state B. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	} 
}

/* The reactions of state C. */
void Constants::react_main_region_C()
{
	/* The reactions of state C. */
	if (check_main_region_C_tr0_tr0())
	{ 
		effect_main_region_C_tr0();
	} 
}

/* Default react sequence for initial entry  */
void Constants::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


