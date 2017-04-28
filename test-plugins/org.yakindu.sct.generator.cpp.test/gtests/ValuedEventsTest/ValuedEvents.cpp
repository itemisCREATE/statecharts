
#include "ValuedEvents.h"
#include <string.h>

/*! \file Implementation of the state machine 'ValuedEvents'
*/

ValuedEvents::ValuedEvents()
{
	
	
	stateConfVectorPosition = 0;
	
}

ValuedEvents::~ValuedEvents()
{
}


void ValuedEvents::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = ValuedEvents_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart ValuedEvents */
	iface.myInt = 0;
	iface.myBool = false;
	iface.myReal = 0.0;
	iface.myString = "";
}

void ValuedEvents::enter()
{
	/* Default enter sequence for statechart ValuedEvents */
	enseq_main_region1_default();
	enseq_integer_region_default();
	enseq_boolean_region_default();
	enseq_real_region_default();
	enseq_string_region_default();
}

void ValuedEvents::exit()
{
	/* Default exit sequence for statechart ValuedEvents */
	exseq_main_region1();
	exseq_integer_region();
	exseq_boolean_region();
	exseq_real_region();
	exseq_string_region();
}

sc_boolean ValuedEvents::isActive() const
{
	return stateConfVector[0] != ValuedEvents_last_state||stateConfVector[1] != ValuedEvents_last_state||stateConfVector[2] != ValuedEvents_last_state||stateConfVector[3] != ValuedEvents_last_state||stateConfVector[4] != ValuedEvents_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean ValuedEvents::isFinal() const
{
   return false;}

void ValuedEvents::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region1_A :
		{
			react_main_region1_A();
			break;
		}
		case integer_region_B :
		{
			react_integer_region_B();
			break;
		}
		case integer_region_C :
		{
			react_integer_region_C();
			break;
		}
		case integer_region_D :
		{
			react_integer_region_D();
			break;
		}
		case boolean_region_B :
		{
			react_boolean_region_B();
			break;
		}
		case boolean_region_C :
		{
			react_boolean_region_C();
			break;
		}
		case boolean_region_D :
		{
			react_boolean_region_D();
			break;
		}
		case real_region_B :
		{
			react_real_region_B();
			break;
		}
		case real_region_C :
		{
			react_real_region_C();
			break;
		}
		case real_region_D :
		{
			react_real_region_D();
			break;
		}
		case string_region_B :
		{
			react_string_region_B();
			break;
		}
		case string_region_C :
		{
			react_string_region_C();
			break;
		}
		case string_region_D :
		{
			react_string_region_D();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void ValuedEvents::clearInEvents()
{
	iface.integerEvent_raised = false;
	iface.booleanEvent_raised = false;
	iface.realEvent_raised = false;
	iface.stringEvent_raised = false;
}

void ValuedEvents::clearOutEvents()
{
}


sc_boolean ValuedEvents::isStateActive(ValuedEventsStates state) const
{
	switch (state)
	{
		case main_region1_A : 
			return (sc_boolean) (stateConfVector[0] == main_region1_A
			);
		case integer_region_B : 
			return (sc_boolean) (stateConfVector[1] == integer_region_B
			);
		case integer_region_C : 
			return (sc_boolean) (stateConfVector[1] == integer_region_C
			);
		case integer_region_D : 
			return (sc_boolean) (stateConfVector[1] == integer_region_D
			);
		case boolean_region_B : 
			return (sc_boolean) (stateConfVector[2] == boolean_region_B
			);
		case boolean_region_C : 
			return (sc_boolean) (stateConfVector[2] == boolean_region_C
			);
		case boolean_region_D : 
			return (sc_boolean) (stateConfVector[2] == boolean_region_D
			);
		case real_region_B : 
			return (sc_boolean) (stateConfVector[3] == real_region_B
			);
		case real_region_C : 
			return (sc_boolean) (stateConfVector[3] == real_region_C
			);
		case real_region_D : 
			return (sc_boolean) (stateConfVector[3] == real_region_D
			);
		case string_region_B : 
			return (sc_boolean) (stateConfVector[4] == string_region_B
			);
		case string_region_C : 
			return (sc_boolean) (stateConfVector[4] == string_region_C
			);
		case string_region_D : 
			return (sc_boolean) (stateConfVector[4] == string_region_D
			);
		default: return false;
	}
}

ValuedEvents::DefaultSCI* ValuedEvents::getDefaultSCI()
{
	return &iface;
}

void ValuedEvents::DefaultSCI::raise_integerEvent(sc_integer value)
{
	integerEvent_value = value;
	integerEvent_raised = true;
}

void ValuedEvents::raise_integerEvent(sc_integer value)
{
	iface.raise_integerEvent(value);
}

void ValuedEvents::DefaultSCI::raise_booleanEvent(sc_boolean value)
{
	booleanEvent_value = value;
	booleanEvent_raised = true;
}

void ValuedEvents::raise_booleanEvent(sc_boolean value)
{
	iface.raise_booleanEvent(value);
}

void ValuedEvents::DefaultSCI::raise_realEvent(sc_real value)
{
	realEvent_value = value;
	realEvent_raised = true;
}

void ValuedEvents::raise_realEvent(sc_real value)
{
	iface.raise_realEvent(value);
}

void ValuedEvents::DefaultSCI::raise_stringEvent(sc_string value)
{
	stringEvent_value = value;
	stringEvent_raised = true;
}

void ValuedEvents::raise_stringEvent(sc_string value)
{
	iface.raise_stringEvent(value);
}


sc_integer ValuedEvents::DefaultSCI::get_myInt() const
{
	return myInt;
}

sc_integer ValuedEvents::get_myInt() const
{
	return iface.myInt;
}

void ValuedEvents::DefaultSCI::set_myInt(sc_integer value)
{
	myInt = value;
}

void ValuedEvents::set_myInt(sc_integer value)
{
	iface.myInt = value;
}

sc_boolean ValuedEvents::DefaultSCI::get_myBool() const
{
	return myBool;
}

sc_boolean ValuedEvents::get_myBool() const
{
	return iface.myBool;
}

void ValuedEvents::DefaultSCI::set_myBool(sc_boolean value)
{
	myBool = value;
}

void ValuedEvents::set_myBool(sc_boolean value)
{
	iface.myBool = value;
}

sc_real ValuedEvents::DefaultSCI::get_myReal() const
{
	return myReal;
}

sc_real ValuedEvents::get_myReal() const
{
	return iface.myReal;
}

void ValuedEvents::DefaultSCI::set_myReal(sc_real value)
{
	myReal = value;
}

void ValuedEvents::set_myReal(sc_real value)
{
	iface.myReal = value;
}

sc_string ValuedEvents::DefaultSCI::get_myString() const
{
	return myString;
}

sc_string ValuedEvents::get_myString() const
{
	return iface.myString;
}

void ValuedEvents::DefaultSCI::set_myString(sc_string value)
{
	myString = value;
}

void ValuedEvents::set_myString(sc_string value)
{
	iface.myString = value;
}


// implementations of all internal functions

sc_boolean ValuedEvents::check_integer_region_B_tr0_tr0()
{
	return iface.integerEvent_raised;
}

sc_boolean ValuedEvents::check_integer_region_C_tr0_tr0()
{
	return iface.integerEvent_raised;
}

sc_boolean ValuedEvents::check_boolean_region_B_tr0_tr0()
{
	return iface.booleanEvent_raised;
}

sc_boolean ValuedEvents::check_boolean_region_C_tr0_tr0()
{
	return iface.booleanEvent_raised;
}

sc_boolean ValuedEvents::check_real_region_B_tr0_tr0()
{
	return iface.realEvent_raised;
}

sc_boolean ValuedEvents::check_real_region_C_tr0_tr0()
{
	return iface.realEvent_raised;
}

sc_boolean ValuedEvents::check_string_region_B_tr0_tr0()
{
	return iface.stringEvent_raised;
}

sc_boolean ValuedEvents::check_string_region_C_tr0_tr0()
{
	return iface.stringEvent_raised;
}

void ValuedEvents::effect_integer_region_B_tr0()
{
	exseq_integer_region_B();
	iface.myInt = iface.integerEvent_value;
	enseq_integer_region_C_default();
}

void ValuedEvents::effect_integer_region_C_tr0()
{
	exseq_integer_region_C();
	iface.myInt = iface.integerEvent_value;
	enseq_integer_region_D_default();
}

void ValuedEvents::effect_boolean_region_B_tr0()
{
	exseq_boolean_region_B();
	iface.myBool = iface.booleanEvent_value;
	enseq_boolean_region_C_default();
}

void ValuedEvents::effect_boolean_region_C_tr0()
{
	exseq_boolean_region_C();
	iface.myBool = iface.booleanEvent_value;
	enseq_boolean_region_D_default();
}

void ValuedEvents::effect_real_region_B_tr0()
{
	exseq_real_region_B();
	iface.myReal = iface.realEvent_value;
	enseq_real_region_C_default();
}

void ValuedEvents::effect_real_region_C_tr0()
{
	exseq_real_region_C();
	iface.myReal = iface.realEvent_value;
	enseq_real_region_D_default();
}

void ValuedEvents::effect_string_region_B_tr0()
{
	exseq_string_region_B();
	iface.myString = iface.stringEvent_value;
	enseq_string_region_C_default();
}

void ValuedEvents::effect_string_region_C_tr0()
{
	exseq_string_region_C();
	iface.myString = iface.stringEvent_value;
	enseq_string_region_D_default();
}

/* Entry action for state 'A'. */
void ValuedEvents::enact_main_region1_A()
{
	/* Entry action for state 'A'. */
	iface.integerEvent_value = 2 * 21;
	iface.integerEvent_raised = true;
	iface.realEvent_value = 10;
	iface.realEvent_raised = true;
	iface.booleanEvent_value = true || false;
	iface.booleanEvent_raised = true;
	iface.stringEvent_value = "sct";
	iface.stringEvent_raised = true;
}

/* 'default' enter sequence for state A */
void ValuedEvents::enseq_main_region1_A_default()
{
	/* 'default' enter sequence for state A */
	enact_main_region1_A();
	stateConfVector[0] = main_region1_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void ValuedEvents::enseq_integer_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[1] = integer_region_B;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state C */
void ValuedEvents::enseq_integer_region_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[1] = integer_region_C;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state D */
void ValuedEvents::enseq_integer_region_D_default()
{
	/* 'default' enter sequence for state D */
	stateConfVector[1] = integer_region_D;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state B */
void ValuedEvents::enseq_boolean_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[2] = boolean_region_B;
	stateConfVectorPosition = 2;
}

/* 'default' enter sequence for state C */
void ValuedEvents::enseq_boolean_region_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[2] = boolean_region_C;
	stateConfVectorPosition = 2;
}

/* 'default' enter sequence for state D */
void ValuedEvents::enseq_boolean_region_D_default()
{
	/* 'default' enter sequence for state D */
	stateConfVector[2] = boolean_region_D;
	stateConfVectorPosition = 2;
}

/* 'default' enter sequence for state B */
void ValuedEvents::enseq_real_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[3] = real_region_B;
	stateConfVectorPosition = 3;
}

/* 'default' enter sequence for state C */
void ValuedEvents::enseq_real_region_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[3] = real_region_C;
	stateConfVectorPosition = 3;
}

/* 'default' enter sequence for state D */
void ValuedEvents::enseq_real_region_D_default()
{
	/* 'default' enter sequence for state D */
	stateConfVector[3] = real_region_D;
	stateConfVectorPosition = 3;
}

/* 'default' enter sequence for state B */
void ValuedEvents::enseq_string_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[4] = string_region_B;
	stateConfVectorPosition = 4;
}

/* 'default' enter sequence for state C */
void ValuedEvents::enseq_string_region_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[4] = string_region_C;
	stateConfVectorPosition = 4;
}

/* 'default' enter sequence for state D */
void ValuedEvents::enseq_string_region_D_default()
{
	/* 'default' enter sequence for state D */
	stateConfVector[4] = string_region_D;
	stateConfVectorPosition = 4;
}

/* 'default' enter sequence for region main region1 */
void ValuedEvents::enseq_main_region1_default()
{
	/* 'default' enter sequence for region main region1 */
	react_main_region1__entry_Default();
}

/* 'default' enter sequence for region integer_region */
void ValuedEvents::enseq_integer_region_default()
{
	/* 'default' enter sequence for region integer_region */
	react_integer_region__entry_Default();
}

/* 'default' enter sequence for region boolean_region */
void ValuedEvents::enseq_boolean_region_default()
{
	/* 'default' enter sequence for region boolean_region */
	react_boolean_region__entry_Default();
}

/* 'default' enter sequence for region real_region */
void ValuedEvents::enseq_real_region_default()
{
	/* 'default' enter sequence for region real_region */
	react_real_region__entry_Default();
}

/* 'default' enter sequence for region string_region */
void ValuedEvents::enseq_string_region_default()
{
	/* 'default' enter sequence for region string_region */
	react_string_region__entry_Default();
}

/* Default exit sequence for state A */
void ValuedEvents::exseq_main_region1_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = ValuedEvents_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void ValuedEvents::exseq_integer_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[1] = ValuedEvents_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state C */
void ValuedEvents::exseq_integer_region_C()
{
	/* Default exit sequence for state C */
	stateConfVector[1] = ValuedEvents_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state D */
void ValuedEvents::exseq_integer_region_D()
{
	/* Default exit sequence for state D */
	stateConfVector[1] = ValuedEvents_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state B */
void ValuedEvents::exseq_boolean_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[2] = ValuedEvents_last_state;
	stateConfVectorPosition = 2;
}

/* Default exit sequence for state C */
void ValuedEvents::exseq_boolean_region_C()
{
	/* Default exit sequence for state C */
	stateConfVector[2] = ValuedEvents_last_state;
	stateConfVectorPosition = 2;
}

/* Default exit sequence for state D */
void ValuedEvents::exseq_boolean_region_D()
{
	/* Default exit sequence for state D */
	stateConfVector[2] = ValuedEvents_last_state;
	stateConfVectorPosition = 2;
}

/* Default exit sequence for state B */
void ValuedEvents::exseq_real_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[3] = ValuedEvents_last_state;
	stateConfVectorPosition = 3;
}

/* Default exit sequence for state C */
void ValuedEvents::exseq_real_region_C()
{
	/* Default exit sequence for state C */
	stateConfVector[3] = ValuedEvents_last_state;
	stateConfVectorPosition = 3;
}

/* Default exit sequence for state D */
void ValuedEvents::exseq_real_region_D()
{
	/* Default exit sequence for state D */
	stateConfVector[3] = ValuedEvents_last_state;
	stateConfVectorPosition = 3;
}

/* Default exit sequence for state B */
void ValuedEvents::exseq_string_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[4] = ValuedEvents_last_state;
	stateConfVectorPosition = 4;
}

/* Default exit sequence for state C */
void ValuedEvents::exseq_string_region_C()
{
	/* Default exit sequence for state C */
	stateConfVector[4] = ValuedEvents_last_state;
	stateConfVectorPosition = 4;
}

/* Default exit sequence for state D */
void ValuedEvents::exseq_string_region_D()
{
	/* Default exit sequence for state D */
	stateConfVector[4] = ValuedEvents_last_state;
	stateConfVectorPosition = 4;
}

/* Default exit sequence for region main region1 */
void ValuedEvents::exseq_main_region1()
{
	/* Default exit sequence for region main region1 */
	/* Handle exit of all possible states (of ValuedEvents.main_region1) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region1_A :
		{
			exseq_main_region1_A();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region integer_region */
void ValuedEvents::exseq_integer_region()
{
	/* Default exit sequence for region integer_region */
	/* Handle exit of all possible states (of ValuedEvents.integer_region) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case integer_region_B :
		{
			exseq_integer_region_B();
			break;
		}
		case integer_region_C :
		{
			exseq_integer_region_C();
			break;
		}
		case integer_region_D :
		{
			exseq_integer_region_D();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region boolean_region */
void ValuedEvents::exseq_boolean_region()
{
	/* Default exit sequence for region boolean_region */
	/* Handle exit of all possible states (of ValuedEvents.boolean_region) at position 2... */
	switch(stateConfVector[ 2 ])
	{
		case boolean_region_B :
		{
			exseq_boolean_region_B();
			break;
		}
		case boolean_region_C :
		{
			exseq_boolean_region_C();
			break;
		}
		case boolean_region_D :
		{
			exseq_boolean_region_D();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region real_region */
void ValuedEvents::exseq_real_region()
{
	/* Default exit sequence for region real_region */
	/* Handle exit of all possible states (of ValuedEvents.real_region) at position 3... */
	switch(stateConfVector[ 3 ])
	{
		case real_region_B :
		{
			exseq_real_region_B();
			break;
		}
		case real_region_C :
		{
			exseq_real_region_C();
			break;
		}
		case real_region_D :
		{
			exseq_real_region_D();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region string_region */
void ValuedEvents::exseq_string_region()
{
	/* Default exit sequence for region string_region */
	/* Handle exit of all possible states (of ValuedEvents.string_region) at position 4... */
	switch(stateConfVector[ 4 ])
	{
		case string_region_B :
		{
			exseq_string_region_B();
			break;
		}
		case string_region_C :
		{
			exseq_string_region_C();
			break;
		}
		case string_region_D :
		{
			exseq_string_region_D();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void ValuedEvents::react_main_region1_A()
{
	/* The reactions of state A. */
}

/* The reactions of state B. */
void ValuedEvents::react_integer_region_B()
{
	/* The reactions of state B. */
	if (check_integer_region_B_tr0_tr0())
	{ 
		effect_integer_region_B_tr0();
	} 
}

/* The reactions of state C. */
void ValuedEvents::react_integer_region_C()
{
	/* The reactions of state C. */
	if (check_integer_region_C_tr0_tr0())
	{ 
		effect_integer_region_C_tr0();
	} 
}

/* The reactions of state D. */
void ValuedEvents::react_integer_region_D()
{
}

/* The reactions of state B. */
void ValuedEvents::react_boolean_region_B()
{
	/* The reactions of state B. */
	if (check_boolean_region_B_tr0_tr0())
	{ 
		effect_boolean_region_B_tr0();
	} 
}

/* The reactions of state C. */
void ValuedEvents::react_boolean_region_C()
{
	/* The reactions of state C. */
	if (check_boolean_region_C_tr0_tr0())
	{ 
		effect_boolean_region_C_tr0();
	} 
}

/* The reactions of state D. */
void ValuedEvents::react_boolean_region_D()
{
}

/* The reactions of state B. */
void ValuedEvents::react_real_region_B()
{
	/* The reactions of state B. */
	if (check_real_region_B_tr0_tr0())
	{ 
		effect_real_region_B_tr0();
	} 
}

/* The reactions of state C. */
void ValuedEvents::react_real_region_C()
{
	/* The reactions of state C. */
	if (check_real_region_C_tr0_tr0())
	{ 
		effect_real_region_C_tr0();
	} 
}

/* The reactions of state D. */
void ValuedEvents::react_real_region_D()
{
}

/* The reactions of state B. */
void ValuedEvents::react_string_region_B()
{
	/* The reactions of state B. */
	if (check_string_region_B_tr0_tr0())
	{ 
		effect_string_region_B_tr0();
	} 
}

/* The reactions of state C. */
void ValuedEvents::react_string_region_C()
{
	/* The reactions of state C. */
	if (check_string_region_C_tr0_tr0())
	{ 
		effect_string_region_C_tr0();
	} 
}

/* The reactions of state D. */
void ValuedEvents::react_string_region_D()
{
}

/* Default react sequence for initial entry  */
void ValuedEvents::react_main_region1__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region1_A_default();
}

/* Default react sequence for initial entry  */
void ValuedEvents::react_integer_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_integer_region_B_default();
}

/* Default react sequence for initial entry  */
void ValuedEvents::react_boolean_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_boolean_region_B_default();
}

/* Default react sequence for initial entry  */
void ValuedEvents::react_real_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_real_region_B_default();
}

/* Default react sequence for initial entry  */
void ValuedEvents::react_string_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_string_region_B_default();
}


