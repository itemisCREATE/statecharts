
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "StringExpressions.h"
/*! \file Implementation of the state machine 'StringExpressions'
*/

/* prototypes of all internal functions */
static sc_boolean stringExpressions_check_AssignmentCheckedtr0_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check_VarToVarCompareSucceededtr0_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check_VarToConstCompareSucceededtr0_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check_ConstToVarCompareSucceededtr0_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice0_tr1_tr1(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice0_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice1_tr1_tr1(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice1_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice2_tr1_tr1(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice2_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice3_tr0_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice3_tr1(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice4_tr1_tr1(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice4_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice5_tr1_tr1(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice5_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice6_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice7_tr0_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice7_tr1(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice8_tr1_tr1(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice8_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice9_tr1_tr1(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice9_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice10_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice11_tr0_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice11_tr1(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice12_tr1_tr1(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice12_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice13_tr1_tr1(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice13_tr0(const StringExpressions* handle);
static sc_boolean stringExpressions_check__choice14_tr0(const StringExpressions* handle);
static void stringExpressions_effect_AssignmentCheckedtr0(StringExpressions* handle);
static void stringExpressions_effect_VarToVarCompareSucceededtr0(StringExpressions* handle);
static void stringExpressions_effect_VarToConstCompareSucceededtr0(StringExpressions* handle);
static void stringExpressions_effect_ConstToVarCompareSucceededtr0(StringExpressions* handle);
static void stringExpressions_effect__choice0_tr1(StringExpressions* handle);
static void stringExpressions_effect__choice0_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice1_tr1(StringExpressions* handle);
static void stringExpressions_effect__choice1_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice2_tr1(StringExpressions* handle);
static void stringExpressions_effect__choice2_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice3_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice3_tr1(StringExpressions* handle);
static void stringExpressions_effect__choice4_tr1(StringExpressions* handle);
static void stringExpressions_effect__choice4_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice5_tr1(StringExpressions* handle);
static void stringExpressions_effect__choice5_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice6_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice7_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice7_tr1(StringExpressions* handle);
static void stringExpressions_effect__choice8_tr1(StringExpressions* handle);
static void stringExpressions_effect__choice8_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice9_tr1(StringExpressions* handle);
static void stringExpressions_effect__choice9_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice10_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice11_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice11_tr1(StringExpressions* handle);
static void stringExpressions_effect__choice12_tr1(StringExpressions* handle);
static void stringExpressions_effect__choice12_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice13_tr1(StringExpressions* handle);
static void stringExpressions_effect__choice13_tr0(StringExpressions* handle);
static void stringExpressions_effect__choice14_tr0(StringExpressions* handle);
static void stringExpressions_enact_AssignmentChecked(StringExpressions* handle);
static void stringExpressions_enseq_AssignmentChecked_default(StringExpressions* handle);
static void stringExpressions_enseq_Failed_default(StringExpressions* handle);
static void stringExpressions_enseq_VarToVarCompareSucceeded_default(StringExpressions* handle);
static void stringExpressions_enseq_VarToConstCompareSucceeded_default(StringExpressions* handle);
static void stringExpressions_enseq_ConstToVarCompareSucceeded_default(StringExpressions* handle);
static void stringExpressions_enseq_ConstToConstCompareSucceeded_default(StringExpressions* handle);
static void stringExpressions_enseq_main_region_default(StringExpressions* handle);
static void stringExpressions_exseq_AssignmentChecked(StringExpressions* handle);
static void stringExpressions_exseq_Failed(StringExpressions* handle);
static void stringExpressions_exseq_VarToVarCompareSucceeded(StringExpressions* handle);
static void stringExpressions_exseq_VarToConstCompareSucceeded(StringExpressions* handle);
static void stringExpressions_exseq_ConstToVarCompareSucceeded(StringExpressions* handle);
static void stringExpressions_exseq_ConstToConstCompareSucceeded(StringExpressions* handle);
static void stringExpressions_exseq_main_region(StringExpressions* handle);
static void stringExpressions_react_AssignmentChecked(StringExpressions* handle);
static void stringExpressions_react_Failed(StringExpressions* handle);
static void stringExpressions_react_VarToVarCompareSucceeded(StringExpressions* handle);
static void stringExpressions_react_VarToConstCompareSucceeded(StringExpressions* handle);
static void stringExpressions_react_ConstToVarCompareSucceeded(StringExpressions* handle);
static void stringExpressions_react_ConstToConstCompareSucceeded(StringExpressions* handle);
static void stringExpressions_react__choice0_(StringExpressions* handle);
static void stringExpressions_react__choice1_(StringExpressions* handle);
static void stringExpressions_react__choice2_(StringExpressions* handle);
static void stringExpressions_react__choice3_(StringExpressions* handle);
static void stringExpressions_react__choice4_(StringExpressions* handle);
static void stringExpressions_react__choice5_(StringExpressions* handle);
static void stringExpressions_react__choice6_(StringExpressions* handle);
static void stringExpressions_react__choice7_(StringExpressions* handle);
static void stringExpressions_react__choice8_(StringExpressions* handle);
static void stringExpressions_react__choice9_(StringExpressions* handle);
static void stringExpressions_react__choice10_(StringExpressions* handle);
static void stringExpressions_react__choice11_(StringExpressions* handle);
static void stringExpressions_react__choice12_(StringExpressions* handle);
static void stringExpressions_react__choice13_(StringExpressions* handle);
static void stringExpressions_react__choice14_(StringExpressions* handle);
static void stringExpressions_react_Main_region___entry_Default(StringExpressions* handle);
static void stringExpressions_clearInEvents(StringExpressions* handle);
static void stringExpressions_clearOutEvents(StringExpressions* handle);


void stringExpressions_init(StringExpressions* handle)
{
	sc_integer i;

	for (i = 0; i < STRINGEXPRESSIONS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = StringExpressions_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	stringExpressions_clearInEvents(handle);
	stringExpressions_clearOutEvents(handle);

	/* Default init sequence for statechart StringExpressions */
	handle->iface.stringA = "A";
	handle->iface.stringA2 = "A";
	handle->iface.stringB = "B";
	handle->iface.quotedStringX = "\"X\"";
	handle->iface.quotedStringY = "\"Y\"";
	handle->iface.stringVarEqual = bool_false;
	handle->iface.stringVarNotEqual = bool_false;
	handle->iface.guardStringNotEqual = bool_false;
	handle->iface.guardStringEqual = bool_false;

}

void stringExpressions_enter(StringExpressions* handle)
{
	/* Default enter sequence for statechart StringExpressions */
	stringExpressions_enseq_main_region_default(handle);
}

void stringExpressions_exit(StringExpressions* handle)
{
	/* Default exit sequence for statechart StringExpressions */
	stringExpressions_exseq_main_region(handle);
}

sc_boolean stringExpressions_isActive(const StringExpressions* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != StringExpressions_last_state)
	{
		result =  bool_true;
	}
	else
	{
		result = bool_false;
	}
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean stringExpressions_isFinal(const StringExpressions* handle)
{
   return bool_false;
}

static void stringExpressions_clearInEvents(StringExpressions* handle)
{
	handle->iface.e_raised = bool_false;
}

static void stringExpressions_clearOutEvents(StringExpressions* handle)
{
}

void stringExpressions_runCycle(StringExpressions* handle)
{
	
	stringExpressions_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < STRINGEXPRESSIONS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case StringExpressions_AssignmentChecked :
		{
			stringExpressions_react_AssignmentChecked(handle);
			break;
		}
		case StringExpressions_Failed :
		{
			stringExpressions_react_Failed(handle);
			break;
		}
		case StringExpressions_VarToVarCompareSucceeded :
		{
			stringExpressions_react_VarToVarCompareSucceeded(handle);
			break;
		}
		case StringExpressions_VarToConstCompareSucceeded :
		{
			stringExpressions_react_VarToConstCompareSucceeded(handle);
			break;
		}
		case StringExpressions_ConstToVarCompareSucceeded :
		{
			stringExpressions_react_ConstToVarCompareSucceeded(handle);
			break;
		}
		case StringExpressions_ConstToConstCompareSucceeded :
		{
			stringExpressions_react_ConstToConstCompareSucceeded(handle);
			break;
		}
		default:
			break;
		}
	}
	
	stringExpressions_clearInEvents(handle);
}


sc_boolean stringExpressions_isStateActive(const StringExpressions* handle, StringExpressionsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case StringExpressions_AssignmentChecked :
			result = (sc_boolean) (handle->stateConfVector[0] == StringExpressions_AssignmentChecked
			);
			break;
		case StringExpressions_Failed :
			result = (sc_boolean) (handle->stateConfVector[0] == StringExpressions_Failed
			);
			break;
		case StringExpressions_VarToVarCompareSucceeded :
			result = (sc_boolean) (handle->stateConfVector[0] == StringExpressions_VarToVarCompareSucceeded
			);
			break;
		case StringExpressions_VarToConstCompareSucceeded :
			result = (sc_boolean) (handle->stateConfVector[0] == StringExpressions_VarToConstCompareSucceeded
			);
			break;
		case StringExpressions_ConstToVarCompareSucceeded :
			result = (sc_boolean) (handle->stateConfVector[0] == StringExpressions_ConstToVarCompareSucceeded
			);
			break;
		case StringExpressions_ConstToConstCompareSucceeded :
			result = (sc_boolean) (handle->stateConfVector[0] == StringExpressions_ConstToConstCompareSucceeded
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void stringExpressionsIface_raise_e(StringExpressions* handle)
{
	handle->iface.e_raised = bool_true;
}


sc_string stringExpressionsIface_get_stringA(const StringExpressions* handle)
{
	return handle->iface.stringA;
}
void stringExpressionsIface_set_stringA(StringExpressions* handle, sc_string value)
{
	handle->iface.stringA = value;
}
sc_string stringExpressionsIface_get_stringA2(const StringExpressions* handle)
{
	return handle->iface.stringA2;
}
void stringExpressionsIface_set_stringA2(StringExpressions* handle, sc_string value)
{
	handle->iface.stringA2 = value;
}
sc_string stringExpressionsIface_get_stringB(const StringExpressions* handle)
{
	return handle->iface.stringB;
}
void stringExpressionsIface_set_stringB(StringExpressions* handle, sc_string value)
{
	handle->iface.stringB = value;
}
sc_string stringExpressionsIface_get_quotedStringX(const StringExpressions* handle)
{
	return handle->iface.quotedStringX;
}
void stringExpressionsIface_set_quotedStringX(StringExpressions* handle, sc_string value)
{
	handle->iface.quotedStringX = value;
}
sc_string stringExpressionsIface_get_quotedStringY(const StringExpressions* handle)
{
	return handle->iface.quotedStringY;
}
void stringExpressionsIface_set_quotedStringY(StringExpressions* handle, sc_string value)
{
	handle->iface.quotedStringY = value;
}
sc_boolean stringExpressionsIface_get_stringVarEqual(const StringExpressions* handle)
{
	return handle->iface.stringVarEqual;
}
void stringExpressionsIface_set_stringVarEqual(StringExpressions* handle, sc_boolean value)
{
	handle->iface.stringVarEqual = value;
}
sc_boolean stringExpressionsIface_get_stringVarNotEqual(const StringExpressions* handle)
{
	return handle->iface.stringVarNotEqual;
}
void stringExpressionsIface_set_stringVarNotEqual(StringExpressions* handle, sc_boolean value)
{
	handle->iface.stringVarNotEqual = value;
}
sc_boolean stringExpressionsIface_get_guardStringNotEqual(const StringExpressions* handle)
{
	return handle->iface.guardStringNotEqual;
}
void stringExpressionsIface_set_guardStringNotEqual(StringExpressions* handle, sc_boolean value)
{
	handle->iface.guardStringNotEqual = value;
}
sc_boolean stringExpressionsIface_get_guardStringEqual(const StringExpressions* handle)
{
	return handle->iface.guardStringEqual;
}
void stringExpressionsIface_set_guardStringEqual(StringExpressions* handle, sc_boolean value)
{
	handle->iface.guardStringEqual = value;
}

/* implementations of all internal functions */

static sc_boolean stringExpressions_check_AssignmentCheckedtr0_tr0(const StringExpressions* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean stringExpressions_check_VarToVarCompareSucceededtr0_tr0(const StringExpressions* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean stringExpressions_check_VarToConstCompareSucceededtr0_tr0(const StringExpressions* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean stringExpressions_check_ConstToVarCompareSucceededtr0_tr0(const StringExpressions* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean stringExpressions_check__choice0_tr1_tr1(const StringExpressions* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean stringExpressions_check__choice0_tr0(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice1_tr1_tr1(const StringExpressions* handle)
{
	return ((handle->iface.e_raised) && ((strcmp(handle->iface.stringA, handle->iface.stringA2) == 0)
	)) ? bool_true : bool_false;
}

static sc_boolean stringExpressions_check__choice1_tr0(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice2_tr1_tr1(const StringExpressions* handle)
{
	return ((handle->iface.e_raised) && ((strcmp(handle->iface.stringA, handle->iface.stringB) != 0)
	)) ? bool_true : bool_false;
}

static sc_boolean stringExpressions_check__choice2_tr0(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice3_tr0_tr0(const StringExpressions* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean stringExpressions_check__choice3_tr1(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice4_tr1_tr1(const StringExpressions* handle)
{
	return ((handle->iface.e_raised) && ((strcmp(handle->iface.stringA, "A") == 0)
	)) ? bool_true : bool_false;
}

static sc_boolean stringExpressions_check__choice4_tr0(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice5_tr1_tr1(const StringExpressions* handle)
{
	return ((handle->iface.e_raised) && ((strcmp(handle->iface.stringA, "B") != 0)
	)) ? bool_true : bool_false;
}

static sc_boolean stringExpressions_check__choice5_tr0(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice6_tr0(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice7_tr0_tr0(const StringExpressions* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean stringExpressions_check__choice7_tr1(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice8_tr1_tr1(const StringExpressions* handle)
{
	return ((handle->iface.e_raised) && ((strcmp("A", handle->iface.stringA) == 0)
	)) ? bool_true : bool_false;
}

static sc_boolean stringExpressions_check__choice8_tr0(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice9_tr1_tr1(const StringExpressions* handle)
{
	return ((handle->iface.e_raised) && ((strcmp("A", handle->iface.stringB) != 0)
	)) ? bool_true : bool_false;
}

static sc_boolean stringExpressions_check__choice9_tr0(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice10_tr0(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice11_tr0_tr0(const StringExpressions* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean stringExpressions_check__choice11_tr1(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice12_tr1_tr1(const StringExpressions* handle)
{
	return ((handle->iface.e_raised) && ((strcmp("A", "A") == 0)
	)) ? bool_true : bool_false;
}

static sc_boolean stringExpressions_check__choice12_tr0(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice13_tr1_tr1(const StringExpressions* handle)
{
	return ((handle->iface.e_raised) && ((strcmp("A", "B") != 0)
	)) ? bool_true : bool_false;
}

static sc_boolean stringExpressions_check__choice13_tr0(const StringExpressions* handle)
{
	return bool_true;
}

static sc_boolean stringExpressions_check__choice14_tr0(const StringExpressions* handle)
{
	return bool_true;
}

static void stringExpressions_effect_AssignmentCheckedtr0(StringExpressions* handle)
{
	stringExpressions_exseq_AssignmentChecked(handle);
	handle->iface.stringVarEqual = (strcmp(handle->iface.stringA, handle->iface.stringA2) == 0)
	;
	stringExpressions_react__choice0_(handle);
}

static void stringExpressions_effect_VarToVarCompareSucceededtr0(StringExpressions* handle)
{
	stringExpressions_exseq_VarToVarCompareSucceeded(handle);
	handle->iface.stringVarEqual = (strcmp(handle->iface.stringA, "A") == 0)
	;
	stringExpressions_react__choice3_(handle);
}

static void stringExpressions_effect_VarToConstCompareSucceededtr0(StringExpressions* handle)
{
	stringExpressions_exseq_VarToConstCompareSucceeded(handle);
	handle->iface.stringVarEqual = (strcmp("A", handle->iface.stringA) == 0)
	;
	stringExpressions_react__choice7_(handle);
}

static void stringExpressions_effect_ConstToVarCompareSucceededtr0(StringExpressions* handle)
{
	stringExpressions_exseq_ConstToVarCompareSucceeded(handle);
	handle->iface.stringVarEqual = (strcmp("A", "A") == 0)
	;
	stringExpressions_react__choice11_(handle);
}

static void stringExpressions_effect__choice0_tr1(StringExpressions* handle)
{
	handle->iface.stringVarNotEqual = (strcmp(handle->iface.stringA, handle->iface.stringB) != 0)
	;
	stringExpressions_react__choice1_(handle);
}

static void stringExpressions_effect__choice0_tr0(StringExpressions* handle)
{
	stringExpressions_enseq_Failed_default(handle);
}

static void stringExpressions_effect__choice1_tr1(StringExpressions* handle)
{
	handle->iface.guardStringEqual = (strcmp(handle->iface.stringA, handle->iface.stringA2) == 0)
	;
	stringExpressions_react__choice2_(handle);
}

static void stringExpressions_effect__choice1_tr0(StringExpressions* handle)
{
	stringExpressions_enseq_Failed_default(handle);
}

static void stringExpressions_effect__choice2_tr1(StringExpressions* handle)
{
	handle->iface.guardStringNotEqual = (strcmp(handle->iface.stringA, handle->iface.stringB) != 0)
	;
	stringExpressions_enseq_VarToVarCompareSucceeded_default(handle);
}

static void stringExpressions_effect__choice2_tr0(StringExpressions* handle)
{
	stringExpressions_enseq_Failed_default(handle);
}

static void stringExpressions_effect__choice3_tr0(StringExpressions* handle)
{
	handle->iface.stringVarNotEqual = (strcmp(handle->iface.stringA, "B") != 0)
	;
	stringExpressions_react__choice4_(handle);
}

static void stringExpressions_effect__choice3_tr1(StringExpressions* handle)
{
	stringExpressions_react__choice6_(handle);
}

static void stringExpressions_effect__choice4_tr1(StringExpressions* handle)
{
	handle->iface.guardStringEqual = (strcmp(handle->iface.stringA, "A") == 0)
	;
	stringExpressions_react__choice5_(handle);
}

static void stringExpressions_effect__choice4_tr0(StringExpressions* handle)
{
	stringExpressions_react__choice6_(handle);
}

static void stringExpressions_effect__choice5_tr1(StringExpressions* handle)
{
	handle->iface.guardStringNotEqual = (strcmp(handle->iface.stringA, "B") != 0)
	;
	stringExpressions_enseq_VarToConstCompareSucceeded_default(handle);
}

static void stringExpressions_effect__choice5_tr0(StringExpressions* handle)
{
	stringExpressions_react__choice6_(handle);
}

static void stringExpressions_effect__choice6_tr0(StringExpressions* handle)
{
	stringExpressions_enseq_Failed_default(handle);
}

static void stringExpressions_effect__choice7_tr0(StringExpressions* handle)
{
	handle->iface.stringVarNotEqual = (strcmp("A", handle->iface.stringB) != 0)
	;
	stringExpressions_react__choice8_(handle);
}

static void stringExpressions_effect__choice7_tr1(StringExpressions* handle)
{
	stringExpressions_react__choice10_(handle);
}

static void stringExpressions_effect__choice8_tr1(StringExpressions* handle)
{
	handle->iface.guardStringEqual = (strcmp("A", handle->iface.stringA) == 0)
	;
	stringExpressions_react__choice9_(handle);
}

static void stringExpressions_effect__choice8_tr0(StringExpressions* handle)
{
	stringExpressions_react__choice10_(handle);
}

static void stringExpressions_effect__choice9_tr1(StringExpressions* handle)
{
	handle->iface.guardStringNotEqual = (strcmp("A", handle->iface.stringB) != 0)
	;
	stringExpressions_enseq_ConstToVarCompareSucceeded_default(handle);
}

static void stringExpressions_effect__choice9_tr0(StringExpressions* handle)
{
	stringExpressions_react__choice10_(handle);
}

static void stringExpressions_effect__choice10_tr0(StringExpressions* handle)
{
	stringExpressions_react__choice6_(handle);
}

static void stringExpressions_effect__choice11_tr0(StringExpressions* handle)
{
	handle->iface.stringVarNotEqual = (strcmp("A", "B") != 0)
	;
	stringExpressions_react__choice12_(handle);
}

static void stringExpressions_effect__choice11_tr1(StringExpressions* handle)
{
	stringExpressions_react__choice14_(handle);
}

static void stringExpressions_effect__choice12_tr1(StringExpressions* handle)
{
	handle->iface.guardStringEqual = (strcmp("A", "A") == 0)
	;
	stringExpressions_react__choice13_(handle);
}

static void stringExpressions_effect__choice12_tr0(StringExpressions* handle)
{
	stringExpressions_react__choice14_(handle);
}

static void stringExpressions_effect__choice13_tr1(StringExpressions* handle)
{
	handle->iface.guardStringNotEqual = (strcmp("A", "B") != 0)
	;
	stringExpressions_enseq_ConstToConstCompareSucceeded_default(handle);
}

static void stringExpressions_effect__choice13_tr0(StringExpressions* handle)
{
	stringExpressions_react__choice14_(handle);
}

static void stringExpressions_effect__choice14_tr0(StringExpressions* handle)
{
	stringExpressions_react__choice10_(handle);
}

/* Entry action for state 'AssignmentChecked'. */
static void stringExpressions_enact_AssignmentChecked(StringExpressions* handle)
{
	/* Entry action for state 'AssignmentChecked'. */
	handle->iface.stringVarNotEqual = !(strcmp(handle->iface.stringA, handle->iface.stringB) == 0)
	;
	handle->iface.stringVarEqual = !(strcmp(handle->iface.stringA, handle->iface.stringA2) != 0)
	;
}

/* 'default' enter sequence for state AssignmentChecked */
static void stringExpressions_enseq_AssignmentChecked_default(StringExpressions* handle)
{
	/* 'default' enter sequence for state AssignmentChecked */
	stringExpressions_enact_AssignmentChecked(handle);
	handle->stateConfVector[0] = StringExpressions_AssignmentChecked;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Failed */
static void stringExpressions_enseq_Failed_default(StringExpressions* handle)
{
	/* 'default' enter sequence for state Failed */
	handle->stateConfVector[0] = StringExpressions_Failed;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state VarToVarCompareSucceeded */
static void stringExpressions_enseq_VarToVarCompareSucceeded_default(StringExpressions* handle)
{
	/* 'default' enter sequence for state VarToVarCompareSucceeded */
	handle->stateConfVector[0] = StringExpressions_VarToVarCompareSucceeded;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state VarToConstCompareSucceeded */
static void stringExpressions_enseq_VarToConstCompareSucceeded_default(StringExpressions* handle)
{
	/* 'default' enter sequence for state VarToConstCompareSucceeded */
	handle->stateConfVector[0] = StringExpressions_VarToConstCompareSucceeded;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state ConstToVarCompareSucceeded */
static void stringExpressions_enseq_ConstToVarCompareSucceeded_default(StringExpressions* handle)
{
	/* 'default' enter sequence for state ConstToVarCompareSucceeded */
	handle->stateConfVector[0] = StringExpressions_ConstToVarCompareSucceeded;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state ConstToConstCompareSucceeded */
static void stringExpressions_enseq_ConstToConstCompareSucceeded_default(StringExpressions* handle)
{
	/* 'default' enter sequence for state ConstToConstCompareSucceeded */
	handle->stateConfVector[0] = StringExpressions_ConstToConstCompareSucceeded;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void stringExpressions_enseq_main_region_default(StringExpressions* handle)
{
	/* 'default' enter sequence for region main region */
	stringExpressions_react_Main_region___entry_Default(handle);
}

/* Default exit sequence for state AssignmentChecked */
static void stringExpressions_exseq_AssignmentChecked(StringExpressions* handle)
{
	/* Default exit sequence for state AssignmentChecked */
	handle->stateConfVector[0] = StringExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state Failed */
static void stringExpressions_exseq_Failed(StringExpressions* handle)
{
	/* Default exit sequence for state Failed */
	handle->stateConfVector[0] = StringExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state VarToVarCompareSucceeded */
static void stringExpressions_exseq_VarToVarCompareSucceeded(StringExpressions* handle)
{
	/* Default exit sequence for state VarToVarCompareSucceeded */
	handle->stateConfVector[0] = StringExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state VarToConstCompareSucceeded */
static void stringExpressions_exseq_VarToConstCompareSucceeded(StringExpressions* handle)
{
	/* Default exit sequence for state VarToConstCompareSucceeded */
	handle->stateConfVector[0] = StringExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state ConstToVarCompareSucceeded */
static void stringExpressions_exseq_ConstToVarCompareSucceeded(StringExpressions* handle)
{
	/* Default exit sequence for state ConstToVarCompareSucceeded */
	handle->stateConfVector[0] = StringExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state ConstToConstCompareSucceeded */
static void stringExpressions_exseq_ConstToConstCompareSucceeded(StringExpressions* handle)
{
	/* Default exit sequence for state ConstToConstCompareSucceeded */
	handle->stateConfVector[0] = StringExpressions_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void stringExpressions_exseq_main_region(StringExpressions* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of StringExpressions.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case StringExpressions_AssignmentChecked :
		{
			stringExpressions_exseq_AssignmentChecked(handle);
			break;
		}
		case StringExpressions_Failed :
		{
			stringExpressions_exseq_Failed(handle);
			break;
		}
		case StringExpressions_VarToVarCompareSucceeded :
		{
			stringExpressions_exseq_VarToVarCompareSucceeded(handle);
			break;
		}
		case StringExpressions_VarToConstCompareSucceeded :
		{
			stringExpressions_exseq_VarToConstCompareSucceeded(handle);
			break;
		}
		case StringExpressions_ConstToVarCompareSucceeded :
		{
			stringExpressions_exseq_ConstToVarCompareSucceeded(handle);
			break;
		}
		case StringExpressions_ConstToConstCompareSucceeded :
		{
			stringExpressions_exseq_ConstToConstCompareSucceeded(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state AssignmentChecked. */
static void stringExpressions_react_AssignmentChecked(StringExpressions* handle)
{
	/* The reactions of state AssignmentChecked. */
	if (stringExpressions_check_AssignmentCheckedtr0_tr0(handle) == bool_true)
	{ 
		stringExpressions_effect_AssignmentCheckedtr0(handle);
	} 
}

/* The reactions of state Failed. */
static void stringExpressions_react_Failed(StringExpressions* handle)
{
	/* The reactions of state Failed. */
}

/* The reactions of state VarToVarCompareSucceeded. */
static void stringExpressions_react_VarToVarCompareSucceeded(StringExpressions* handle)
{
	/* The reactions of state VarToVarCompareSucceeded. */
	if (stringExpressions_check_VarToVarCompareSucceededtr0_tr0(handle) == bool_true)
	{ 
		stringExpressions_effect_VarToVarCompareSucceededtr0(handle);
	} 
}

/* The reactions of state VarToConstCompareSucceeded. */
static void stringExpressions_react_VarToConstCompareSucceeded(StringExpressions* handle)
{
	/* The reactions of state VarToConstCompareSucceeded. */
	if (stringExpressions_check_VarToConstCompareSucceededtr0_tr0(handle) == bool_true)
	{ 
		stringExpressions_effect_VarToConstCompareSucceededtr0(handle);
	} 
}

/* The reactions of state ConstToVarCompareSucceeded. */
static void stringExpressions_react_ConstToVarCompareSucceeded(StringExpressions* handle)
{
	/* The reactions of state ConstToVarCompareSucceeded. */
	if (stringExpressions_check_ConstToVarCompareSucceededtr0_tr0(handle) == bool_true)
	{ 
		stringExpressions_effect_ConstToVarCompareSucceededtr0(handle);
	} 
}

/* The reactions of state ConstToConstCompareSucceeded. */
static void stringExpressions_react_ConstToConstCompareSucceeded(StringExpressions* handle)
{
	/* The reactions of state ConstToConstCompareSucceeded. */
}

/* The reactions of state null. */
static void stringExpressions_react__choice0_(StringExpressions* handle)
{
	/* The reactions of state null. */
	if (stringExpressions_check__choice0_tr1_tr1(handle) == bool_true)
	{ 
		stringExpressions_effect__choice0_tr1(handle);
	}  else
	{
		stringExpressions_effect__choice0_tr0(handle);
	}
}

/* The reactions of state null. */
static void stringExpressions_react__choice1_(StringExpressions* handle)
{
	/* The reactions of state null. */
	if (stringExpressions_check__choice1_tr1_tr1(handle) == bool_true)
	{ 
		stringExpressions_effect__choice1_tr1(handle);
	}  else
	{
		stringExpressions_effect__choice1_tr0(handle);
	}
}

/* The reactions of state null. */
static void stringExpressions_react__choice2_(StringExpressions* handle)
{
	/* The reactions of state null. */
	if (stringExpressions_check__choice2_tr1_tr1(handle) == bool_true)
	{ 
		stringExpressions_effect__choice2_tr1(handle);
	}  else
	{
		stringExpressions_effect__choice2_tr0(handle);
	}
}

/* The reactions of state null. */
static void stringExpressions_react__choice3_(StringExpressions* handle)
{
	/* The reactions of state null. */
	if (stringExpressions_check__choice3_tr0_tr0(handle) == bool_true)
	{ 
		stringExpressions_effect__choice3_tr0(handle);
	}  else
	{
		stringExpressions_effect__choice3_tr1(handle);
	}
}

/* The reactions of state null. */
static void stringExpressions_react__choice4_(StringExpressions* handle)
{
	/* The reactions of state null. */
	if (stringExpressions_check__choice4_tr1_tr1(handle) == bool_true)
	{ 
		stringExpressions_effect__choice4_tr1(handle);
	}  else
	{
		stringExpressions_effect__choice4_tr0(handle);
	}
}

/* The reactions of state null. */
static void stringExpressions_react__choice5_(StringExpressions* handle)
{
	/* The reactions of state null. */
	if (stringExpressions_check__choice5_tr1_tr1(handle) == bool_true)
	{ 
		stringExpressions_effect__choice5_tr1(handle);
	}  else
	{
		stringExpressions_effect__choice5_tr0(handle);
	}
}

/* The reactions of state null. */
static void stringExpressions_react__choice6_(StringExpressions* handle)
{
	/* The reactions of state null. */
	stringExpressions_effect__choice6_tr0(handle);
}

/* The reactions of state null. */
static void stringExpressions_react__choice7_(StringExpressions* handle)
{
	/* The reactions of state null. */
	if (stringExpressions_check__choice7_tr0_tr0(handle) == bool_true)
	{ 
		stringExpressions_effect__choice7_tr0(handle);
	}  else
	{
		stringExpressions_effect__choice7_tr1(handle);
	}
}

/* The reactions of state null. */
static void stringExpressions_react__choice8_(StringExpressions* handle)
{
	/* The reactions of state null. */
	if (stringExpressions_check__choice8_tr1_tr1(handle) == bool_true)
	{ 
		stringExpressions_effect__choice8_tr1(handle);
	}  else
	{
		stringExpressions_effect__choice8_tr0(handle);
	}
}

/* The reactions of state null. */
static void stringExpressions_react__choice9_(StringExpressions* handle)
{
	/* The reactions of state null. */
	if (stringExpressions_check__choice9_tr1_tr1(handle) == bool_true)
	{ 
		stringExpressions_effect__choice9_tr1(handle);
	}  else
	{
		stringExpressions_effect__choice9_tr0(handle);
	}
}

/* The reactions of state null. */
static void stringExpressions_react__choice10_(StringExpressions* handle)
{
	/* The reactions of state null. */
	stringExpressions_effect__choice10_tr0(handle);
}

/* The reactions of state null. */
static void stringExpressions_react__choice11_(StringExpressions* handle)
{
	/* The reactions of state null. */
	if (stringExpressions_check__choice11_tr0_tr0(handle) == bool_true)
	{ 
		stringExpressions_effect__choice11_tr0(handle);
	}  else
	{
		stringExpressions_effect__choice11_tr1(handle);
	}
}

/* The reactions of state null. */
static void stringExpressions_react__choice12_(StringExpressions* handle)
{
	/* The reactions of state null. */
	if (stringExpressions_check__choice12_tr1_tr1(handle) == bool_true)
	{ 
		stringExpressions_effect__choice12_tr1(handle);
	}  else
	{
		stringExpressions_effect__choice12_tr0(handle);
	}
}

/* The reactions of state null. */
static void stringExpressions_react__choice13_(StringExpressions* handle)
{
	/* The reactions of state null. */
	if (stringExpressions_check__choice13_tr1_tr1(handle) == bool_true)
	{ 
		stringExpressions_effect__choice13_tr1(handle);
	}  else
	{
		stringExpressions_effect__choice13_tr0(handle);
	}
}

/* The reactions of state null. */
static void stringExpressions_react__choice14_(StringExpressions* handle)
{
	/* The reactions of state null. */
	stringExpressions_effect__choice14_tr0(handle);
}

/* Default react sequence for initial entry  */
static void stringExpressions_react_Main_region___entry_Default(StringExpressions* handle)
{
	/* Default react sequence for initial entry  */
	stringExpressions_enseq_AssignmentChecked_default(handle);
}


