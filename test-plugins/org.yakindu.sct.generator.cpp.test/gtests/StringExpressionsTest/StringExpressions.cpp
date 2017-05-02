
#include "StringExpressions.h"
#include <string.h>

/*! \file Implementation of the state machine 'StringExpressions'
*/

StringExpressions::StringExpressions()
{
	
	
	stateConfVectorPosition = 0;
	
}

StringExpressions::~StringExpressions()
{
}


void StringExpressions::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = StringExpressions_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart StringExpressions */
	iface.stringA = "A";
	iface.stringA2 = "A";
	iface.stringB = "B";
	iface.quotedStringX = "\"X\"";
	iface.quotedStringY = "\"Y\"";
	iface.stringVarEqual = false;
	iface.stringVarNotEqual = false;
	iface.guardStringNotEqual = false;
	iface.guardStringEqual = false;
}

void StringExpressions::enter()
{
	/* Default enter sequence for statechart StringExpressions */
	enseq_main_region_default();
}

void StringExpressions::exit()
{
	/* Default exit sequence for statechart StringExpressions */
	exseq_main_region();
}

sc_boolean StringExpressions::isActive() const
{
	return stateConfVector[0] != StringExpressions_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean StringExpressions::isFinal() const
{
   return false;}

void StringExpressions::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_AssignmentChecked :
		{
			react_main_region_AssignmentChecked();
			break;
		}
		case main_region_Failed :
		{
			react_main_region_Failed();
			break;
		}
		case main_region_VarToVarCompareSucceeded :
		{
			react_main_region_VarToVarCompareSucceeded();
			break;
		}
		case main_region_VarToConstCompareSucceeded :
		{
			react_main_region_VarToConstCompareSucceeded();
			break;
		}
		case main_region_ConstToVarCompareSucceeded :
		{
			react_main_region_ConstToVarCompareSucceeded();
			break;
		}
		case main_region_ConstToConstCompareSucceeded :
		{
			react_main_region_ConstToConstCompareSucceeded();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void StringExpressions::clearInEvents()
{
	iface.e_raised = false;
}

void StringExpressions::clearOutEvents()
{
}


sc_boolean StringExpressions::isStateActive(StringExpressionsStates state) const
{
	switch (state)
	{
		case main_region_AssignmentChecked : 
			return (sc_boolean) (stateConfVector[0] == main_region_AssignmentChecked
			);
		case main_region_Failed : 
			return (sc_boolean) (stateConfVector[0] == main_region_Failed
			);
		case main_region_VarToVarCompareSucceeded : 
			return (sc_boolean) (stateConfVector[0] == main_region_VarToVarCompareSucceeded
			);
		case main_region_VarToConstCompareSucceeded : 
			return (sc_boolean) (stateConfVector[0] == main_region_VarToConstCompareSucceeded
			);
		case main_region_ConstToVarCompareSucceeded : 
			return (sc_boolean) (stateConfVector[0] == main_region_ConstToVarCompareSucceeded
			);
		case main_region_ConstToConstCompareSucceeded : 
			return (sc_boolean) (stateConfVector[0] == main_region_ConstToConstCompareSucceeded
			);
		default: return false;
	}
}

StringExpressions::DefaultSCI* StringExpressions::getDefaultSCI()
{
	return &iface;
}

void StringExpressions::DefaultSCI::raise_e()
{
	e_raised = true;
}

void StringExpressions::raise_e()
{
	iface.raise_e();
}


sc_string StringExpressions::DefaultSCI::get_stringA() const
{
	return stringA;
}

sc_string StringExpressions::get_stringA() const
{
	return iface.stringA;
}

void StringExpressions::DefaultSCI::set_stringA(sc_string value)
{
	stringA = value;
}

void StringExpressions::set_stringA(sc_string value)
{
	iface.stringA = value;
}

sc_string StringExpressions::DefaultSCI::get_stringA2() const
{
	return stringA2;
}

sc_string StringExpressions::get_stringA2() const
{
	return iface.stringA2;
}

void StringExpressions::DefaultSCI::set_stringA2(sc_string value)
{
	stringA2 = value;
}

void StringExpressions::set_stringA2(sc_string value)
{
	iface.stringA2 = value;
}

sc_string StringExpressions::DefaultSCI::get_stringB() const
{
	return stringB;
}

sc_string StringExpressions::get_stringB() const
{
	return iface.stringB;
}

void StringExpressions::DefaultSCI::set_stringB(sc_string value)
{
	stringB = value;
}

void StringExpressions::set_stringB(sc_string value)
{
	iface.stringB = value;
}

sc_string StringExpressions::DefaultSCI::get_quotedStringX() const
{
	return quotedStringX;
}

sc_string StringExpressions::get_quotedStringX() const
{
	return iface.quotedStringX;
}

void StringExpressions::DefaultSCI::set_quotedStringX(sc_string value)
{
	quotedStringX = value;
}

void StringExpressions::set_quotedStringX(sc_string value)
{
	iface.quotedStringX = value;
}

sc_string StringExpressions::DefaultSCI::get_quotedStringY() const
{
	return quotedStringY;
}

sc_string StringExpressions::get_quotedStringY() const
{
	return iface.quotedStringY;
}

void StringExpressions::DefaultSCI::set_quotedStringY(sc_string value)
{
	quotedStringY = value;
}

void StringExpressions::set_quotedStringY(sc_string value)
{
	iface.quotedStringY = value;
}

sc_boolean StringExpressions::DefaultSCI::get_stringVarEqual() const
{
	return stringVarEqual;
}

sc_boolean StringExpressions::get_stringVarEqual() const
{
	return iface.stringVarEqual;
}

void StringExpressions::DefaultSCI::set_stringVarEqual(sc_boolean value)
{
	stringVarEqual = value;
}

void StringExpressions::set_stringVarEqual(sc_boolean value)
{
	iface.stringVarEqual = value;
}

sc_boolean StringExpressions::DefaultSCI::get_stringVarNotEqual() const
{
	return stringVarNotEqual;
}

sc_boolean StringExpressions::get_stringVarNotEqual() const
{
	return iface.stringVarNotEqual;
}

void StringExpressions::DefaultSCI::set_stringVarNotEqual(sc_boolean value)
{
	stringVarNotEqual = value;
}

void StringExpressions::set_stringVarNotEqual(sc_boolean value)
{
	iface.stringVarNotEqual = value;
}

sc_boolean StringExpressions::DefaultSCI::get_guardStringNotEqual() const
{
	return guardStringNotEqual;
}

sc_boolean StringExpressions::get_guardStringNotEqual() const
{
	return iface.guardStringNotEqual;
}

void StringExpressions::DefaultSCI::set_guardStringNotEqual(sc_boolean value)
{
	guardStringNotEqual = value;
}

void StringExpressions::set_guardStringNotEqual(sc_boolean value)
{
	iface.guardStringNotEqual = value;
}

sc_boolean StringExpressions::DefaultSCI::get_guardStringEqual() const
{
	return guardStringEqual;
}

sc_boolean StringExpressions::get_guardStringEqual() const
{
	return iface.guardStringEqual;
}

void StringExpressions::DefaultSCI::set_guardStringEqual(sc_boolean value)
{
	guardStringEqual = value;
}

void StringExpressions::set_guardStringEqual(sc_boolean value)
{
	iface.guardStringEqual = value;
}


// implementations of all internal functions

sc_boolean StringExpressions::check_main_region_AssignmentChecked_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean StringExpressions::check_main_region_VarToVarCompareSucceeded_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean StringExpressions::check_main_region_VarToConstCompareSucceeded_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean StringExpressions::check_main_region_ConstToVarCompareSucceeded_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean StringExpressions::check_main_region__choice_0_tr1_tr1()
{
	return iface.e_raised;
}

sc_boolean StringExpressions::check_main_region__choice_0_tr0()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_1_tr1_tr1()
{
	return (iface.e_raised) && ((strcmp(iface.stringA, iface.stringA2) == 0)
	);
}

sc_boolean StringExpressions::check_main_region__choice_1_tr0()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_2_tr1_tr1()
{
	return (iface.e_raised) && ((strcmp(iface.stringA, iface.stringB) != 0)
	);
}

sc_boolean StringExpressions::check_main_region__choice_2_tr0()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_3_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean StringExpressions::check_main_region__choice_3_tr1()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_4_tr1_tr1()
{
	return (iface.e_raised) && ((strcmp(iface.stringA, "A") == 0)
	);
}

sc_boolean StringExpressions::check_main_region__choice_4_tr0()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_5_tr1_tr1()
{
	return (iface.e_raised) && ((strcmp(iface.stringA, "B") != 0)
	);
}

sc_boolean StringExpressions::check_main_region__choice_5_tr0()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_6_tr0()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_7_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean StringExpressions::check_main_region__choice_7_tr1()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_8_tr1_tr1()
{
	return (iface.e_raised) && ((strcmp("A", iface.stringA) == 0)
	);
}

sc_boolean StringExpressions::check_main_region__choice_8_tr0()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_9_tr1_tr1()
{
	return (iface.e_raised) && ((strcmp("A", iface.stringB) != 0)
	);
}

sc_boolean StringExpressions::check_main_region__choice_9_tr0()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_10_tr0()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_11_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean StringExpressions::check_main_region__choice_11_tr1()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_12_tr1_tr1()
{
	return (iface.e_raised) && ((strcmp("A", "A") == 0)
	);
}

sc_boolean StringExpressions::check_main_region__choice_12_tr0()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_13_tr1_tr1()
{
	return (iface.e_raised) && ((strcmp("A", "B") != 0)
	);
}

sc_boolean StringExpressions::check_main_region__choice_13_tr0()
{
	return true;
}

sc_boolean StringExpressions::check_main_region__choice_14_tr0()
{
	return true;
}

void StringExpressions::effect_main_region_AssignmentChecked_tr0()
{
	exseq_main_region_AssignmentChecked();
	iface.stringVarEqual = (strcmp(iface.stringA, iface.stringA2) == 0)
	;
	react_main_region__choice_0();
}

void StringExpressions::effect_main_region_VarToVarCompareSucceeded_tr0()
{
	exseq_main_region_VarToVarCompareSucceeded();
	iface.stringVarEqual = (strcmp(iface.stringA, "A") == 0)
	;
	react_main_region__choice_3();
}

void StringExpressions::effect_main_region_VarToConstCompareSucceeded_tr0()
{
	exseq_main_region_VarToConstCompareSucceeded();
	iface.stringVarEqual = (strcmp("A", iface.stringA) == 0)
	;
	react_main_region__choice_7();
}

void StringExpressions::effect_main_region_ConstToVarCompareSucceeded_tr0()
{
	exseq_main_region_ConstToVarCompareSucceeded();
	iface.stringVarEqual = (strcmp("A", "A") == 0)
	;
	react_main_region__choice_11();
}

void StringExpressions::effect_main_region__choice_0_tr1()
{
	iface.stringVarNotEqual = (strcmp(iface.stringA, iface.stringB) != 0)
	;
	react_main_region__choice_1();
}

void StringExpressions::effect_main_region__choice_0_tr0()
{
	enseq_main_region_Failed_default();
}

void StringExpressions::effect_main_region__choice_1_tr1()
{
	iface.guardStringEqual = (strcmp(iface.stringA, iface.stringA2) == 0)
	;
	react_main_region__choice_2();
}

void StringExpressions::effect_main_region__choice_1_tr0()
{
	enseq_main_region_Failed_default();
}

void StringExpressions::effect_main_region__choice_2_tr1()
{
	iface.guardStringNotEqual = (strcmp(iface.stringA, iface.stringB) != 0)
	;
	enseq_main_region_VarToVarCompareSucceeded_default();
}

void StringExpressions::effect_main_region__choice_2_tr0()
{
	enseq_main_region_Failed_default();
}

void StringExpressions::effect_main_region__choice_3_tr0()
{
	iface.stringVarNotEqual = (strcmp(iface.stringA, "B") != 0)
	;
	react_main_region__choice_4();
}

void StringExpressions::effect_main_region__choice_3_tr1()
{
	react_main_region__choice_6();
}

void StringExpressions::effect_main_region__choice_4_tr1()
{
	iface.guardStringEqual = (strcmp(iface.stringA, "A") == 0)
	;
	react_main_region__choice_5();
}

void StringExpressions::effect_main_region__choice_4_tr0()
{
	react_main_region__choice_6();
}

void StringExpressions::effect_main_region__choice_5_tr1()
{
	iface.guardStringNotEqual = (strcmp(iface.stringA, "B") != 0)
	;
	enseq_main_region_VarToConstCompareSucceeded_default();
}

void StringExpressions::effect_main_region__choice_5_tr0()
{
	react_main_region__choice_6();
}

void StringExpressions::effect_main_region__choice_6_tr0()
{
	enseq_main_region_Failed_default();
}

void StringExpressions::effect_main_region__choice_7_tr0()
{
	iface.stringVarNotEqual = (strcmp("A", iface.stringB) != 0)
	;
	react_main_region__choice_8();
}

void StringExpressions::effect_main_region__choice_7_tr1()
{
	react_main_region__choice_10();
}

void StringExpressions::effect_main_region__choice_8_tr1()
{
	iface.guardStringEqual = (strcmp("A", iface.stringA) == 0)
	;
	react_main_region__choice_9();
}

void StringExpressions::effect_main_region__choice_8_tr0()
{
	react_main_region__choice_10();
}

void StringExpressions::effect_main_region__choice_9_tr1()
{
	iface.guardStringNotEqual = (strcmp("A", iface.stringB) != 0)
	;
	enseq_main_region_ConstToVarCompareSucceeded_default();
}

void StringExpressions::effect_main_region__choice_9_tr0()
{
	react_main_region__choice_10();
}

void StringExpressions::effect_main_region__choice_10_tr0()
{
	react_main_region__choice_6();
}

void StringExpressions::effect_main_region__choice_11_tr0()
{
	iface.stringVarNotEqual = (strcmp("A", "B") != 0)
	;
	react_main_region__choice_12();
}

void StringExpressions::effect_main_region__choice_11_tr1()
{
	react_main_region__choice_14();
}

void StringExpressions::effect_main_region__choice_12_tr1()
{
	iface.guardStringEqual = (strcmp("A", "A") == 0)
	;
	react_main_region__choice_13();
}

void StringExpressions::effect_main_region__choice_12_tr0()
{
	react_main_region__choice_14();
}

void StringExpressions::effect_main_region__choice_13_tr1()
{
	iface.guardStringNotEqual = (strcmp("A", "B") != 0)
	;
	enseq_main_region_ConstToConstCompareSucceeded_default();
}

void StringExpressions::effect_main_region__choice_13_tr0()
{
	react_main_region__choice_14();
}

void StringExpressions::effect_main_region__choice_14_tr0()
{
	react_main_region__choice_10();
}

/* Entry action for state 'AssignmentChecked'. */
void StringExpressions::enact_main_region_AssignmentChecked()
{
	/* Entry action for state 'AssignmentChecked'. */
	iface.stringVarNotEqual = !(strcmp(iface.stringA, iface.stringB) == 0)
	;
	iface.stringVarEqual = !(strcmp(iface.stringA, iface.stringA2) != 0)
	;
}

/* 'default' enter sequence for state AssignmentChecked */
void StringExpressions::enseq_main_region_AssignmentChecked_default()
{
	/* 'default' enter sequence for state AssignmentChecked */
	enact_main_region_AssignmentChecked();
	stateConfVector[0] = main_region_AssignmentChecked;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Failed */
void StringExpressions::enseq_main_region_Failed_default()
{
	/* 'default' enter sequence for state Failed */
	stateConfVector[0] = main_region_Failed;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state VarToVarCompareSucceeded */
void StringExpressions::enseq_main_region_VarToVarCompareSucceeded_default()
{
	/* 'default' enter sequence for state VarToVarCompareSucceeded */
	stateConfVector[0] = main_region_VarToVarCompareSucceeded;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state VarToConstCompareSucceeded */
void StringExpressions::enseq_main_region_VarToConstCompareSucceeded_default()
{
	/* 'default' enter sequence for state VarToConstCompareSucceeded */
	stateConfVector[0] = main_region_VarToConstCompareSucceeded;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state ConstToVarCompareSucceeded */
void StringExpressions::enseq_main_region_ConstToVarCompareSucceeded_default()
{
	/* 'default' enter sequence for state ConstToVarCompareSucceeded */
	stateConfVector[0] = main_region_ConstToVarCompareSucceeded;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state ConstToConstCompareSucceeded */
void StringExpressions::enseq_main_region_ConstToConstCompareSucceeded_default()
{
	/* 'default' enter sequence for state ConstToConstCompareSucceeded */
	stateConfVector[0] = main_region_ConstToConstCompareSucceeded;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void StringExpressions::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state AssignmentChecked */
void StringExpressions::exseq_main_region_AssignmentChecked()
{
	/* Default exit sequence for state AssignmentChecked */
	stateConfVector[0] = StringExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Failed */
void StringExpressions::exseq_main_region_Failed()
{
	/* Default exit sequence for state Failed */
	stateConfVector[0] = StringExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state VarToVarCompareSucceeded */
void StringExpressions::exseq_main_region_VarToVarCompareSucceeded()
{
	/* Default exit sequence for state VarToVarCompareSucceeded */
	stateConfVector[0] = StringExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state VarToConstCompareSucceeded */
void StringExpressions::exseq_main_region_VarToConstCompareSucceeded()
{
	/* Default exit sequence for state VarToConstCompareSucceeded */
	stateConfVector[0] = StringExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state ConstToVarCompareSucceeded */
void StringExpressions::exseq_main_region_ConstToVarCompareSucceeded()
{
	/* Default exit sequence for state ConstToVarCompareSucceeded */
	stateConfVector[0] = StringExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state ConstToConstCompareSucceeded */
void StringExpressions::exseq_main_region_ConstToConstCompareSucceeded()
{
	/* Default exit sequence for state ConstToConstCompareSucceeded */
	stateConfVector[0] = StringExpressions_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void StringExpressions::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of StringExpressions.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_AssignmentChecked :
		{
			exseq_main_region_AssignmentChecked();
			break;
		}
		case main_region_Failed :
		{
			exseq_main_region_Failed();
			break;
		}
		case main_region_VarToVarCompareSucceeded :
		{
			exseq_main_region_VarToVarCompareSucceeded();
			break;
		}
		case main_region_VarToConstCompareSucceeded :
		{
			exseq_main_region_VarToConstCompareSucceeded();
			break;
		}
		case main_region_ConstToVarCompareSucceeded :
		{
			exseq_main_region_ConstToVarCompareSucceeded();
			break;
		}
		case main_region_ConstToConstCompareSucceeded :
		{
			exseq_main_region_ConstToConstCompareSucceeded();
			break;
		}
		default: break;
	}
}

/* The reactions of state AssignmentChecked. */
void StringExpressions::react_main_region_AssignmentChecked()
{
	/* The reactions of state AssignmentChecked. */
	if (check_main_region_AssignmentChecked_tr0_tr0())
	{ 
		effect_main_region_AssignmentChecked_tr0();
	} 
}

/* The reactions of state Failed. */
void StringExpressions::react_main_region_Failed()
{
	/* The reactions of state Failed. */
}

/* The reactions of state VarToVarCompareSucceeded. */
void StringExpressions::react_main_region_VarToVarCompareSucceeded()
{
	/* The reactions of state VarToVarCompareSucceeded. */
	if (check_main_region_VarToVarCompareSucceeded_tr0_tr0())
	{ 
		effect_main_region_VarToVarCompareSucceeded_tr0();
	} 
}

/* The reactions of state VarToConstCompareSucceeded. */
void StringExpressions::react_main_region_VarToConstCompareSucceeded()
{
	/* The reactions of state VarToConstCompareSucceeded. */
	if (check_main_region_VarToConstCompareSucceeded_tr0_tr0())
	{ 
		effect_main_region_VarToConstCompareSucceeded_tr0();
	} 
}

/* The reactions of state ConstToVarCompareSucceeded. */
void StringExpressions::react_main_region_ConstToVarCompareSucceeded()
{
	/* The reactions of state ConstToVarCompareSucceeded. */
	if (check_main_region_ConstToVarCompareSucceeded_tr0_tr0())
	{ 
		effect_main_region_ConstToVarCompareSucceeded_tr0();
	} 
}

/* The reactions of state ConstToConstCompareSucceeded. */
void StringExpressions::react_main_region_ConstToConstCompareSucceeded()
{
	/* The reactions of state ConstToConstCompareSucceeded. */
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_0()
{
	/* The reactions of state null. */
	if (check_main_region__choice_0_tr1_tr1())
	{ 
		effect_main_region__choice_0_tr1();
	}  else
	{
		effect_main_region__choice_0_tr0();
	}
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_1()
{
	/* The reactions of state null. */
	if (check_main_region__choice_1_tr1_tr1())
	{ 
		effect_main_region__choice_1_tr1();
	}  else
	{
		effect_main_region__choice_1_tr0();
	}
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_2()
{
	/* The reactions of state null. */
	if (check_main_region__choice_2_tr1_tr1())
	{ 
		effect_main_region__choice_2_tr1();
	}  else
	{
		effect_main_region__choice_2_tr0();
	}
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_3()
{
	/* The reactions of state null. */
	if (check_main_region__choice_3_tr0_tr0())
	{ 
		effect_main_region__choice_3_tr0();
	}  else
	{
		effect_main_region__choice_3_tr1();
	}
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_4()
{
	/* The reactions of state null. */
	if (check_main_region__choice_4_tr1_tr1())
	{ 
		effect_main_region__choice_4_tr1();
	}  else
	{
		effect_main_region__choice_4_tr0();
	}
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_5()
{
	/* The reactions of state null. */
	if (check_main_region__choice_5_tr1_tr1())
	{ 
		effect_main_region__choice_5_tr1();
	}  else
	{
		effect_main_region__choice_5_tr0();
	}
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_6()
{
	/* The reactions of state null. */
	effect_main_region__choice_6_tr0();
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_7()
{
	/* The reactions of state null. */
	if (check_main_region__choice_7_tr0_tr0())
	{ 
		effect_main_region__choice_7_tr0();
	}  else
	{
		effect_main_region__choice_7_tr1();
	}
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_8()
{
	/* The reactions of state null. */
	if (check_main_region__choice_8_tr1_tr1())
	{ 
		effect_main_region__choice_8_tr1();
	}  else
	{
		effect_main_region__choice_8_tr0();
	}
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_9()
{
	/* The reactions of state null. */
	if (check_main_region__choice_9_tr1_tr1())
	{ 
		effect_main_region__choice_9_tr1();
	}  else
	{
		effect_main_region__choice_9_tr0();
	}
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_10()
{
	/* The reactions of state null. */
	effect_main_region__choice_10_tr0();
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_11()
{
	/* The reactions of state null. */
	if (check_main_region__choice_11_tr0_tr0())
	{ 
		effect_main_region__choice_11_tr0();
	}  else
	{
		effect_main_region__choice_11_tr1();
	}
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_12()
{
	/* The reactions of state null. */
	if (check_main_region__choice_12_tr1_tr1())
	{ 
		effect_main_region__choice_12_tr1();
	}  else
	{
		effect_main_region__choice_12_tr0();
	}
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_13()
{
	/* The reactions of state null. */
	if (check_main_region__choice_13_tr1_tr1())
	{ 
		effect_main_region__choice_13_tr1();
	}  else
	{
		effect_main_region__choice_13_tr0();
	}
}

/* The reactions of state null. */
void StringExpressions::react_main_region__choice_14()
{
	/* The reactions of state null. */
	effect_main_region__choice_14_tr0();
}

/* Default react sequence for initial entry  */
void StringExpressions::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_AssignmentChecked_default();
}


