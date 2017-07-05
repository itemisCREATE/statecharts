
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "ValuedEvents.h"
/*! \file Implementation of the state machine 'ValuedEvents'
*/

/* prototypes of all internal functions */
static sc_boolean valuedEvents_check_integer_region_B_tr0_tr0(const ValuedEvents* handle);
static sc_boolean valuedEvents_check_integer_region_C_tr0_tr0(const ValuedEvents* handle);
static sc_boolean valuedEvents_check_boolean_region_B_tr0_tr0(const ValuedEvents* handle);
static sc_boolean valuedEvents_check_boolean_region_C_tr0_tr0(const ValuedEvents* handle);
static sc_boolean valuedEvents_check_real_region_B_tr0_tr0(const ValuedEvents* handle);
static sc_boolean valuedEvents_check_real_region_C_tr0_tr0(const ValuedEvents* handle);
static sc_boolean valuedEvents_check_string_region_B_tr0_tr0(const ValuedEvents* handle);
static sc_boolean valuedEvents_check_string_region_C_tr0_tr0(const ValuedEvents* handle);
static void valuedEvents_effect_integer_region_B_tr0(ValuedEvents* handle);
static void valuedEvents_effect_integer_region_C_tr0(ValuedEvents* handle);
static void valuedEvents_effect_boolean_region_B_tr0(ValuedEvents* handle);
static void valuedEvents_effect_boolean_region_C_tr0(ValuedEvents* handle);
static void valuedEvents_effect_real_region_B_tr0(ValuedEvents* handle);
static void valuedEvents_effect_real_region_C_tr0(ValuedEvents* handle);
static void valuedEvents_effect_string_region_B_tr0(ValuedEvents* handle);
static void valuedEvents_effect_string_region_C_tr0(ValuedEvents* handle);
static void valuedEvents_enact_main_region1_A(ValuedEvents* handle);
static void valuedEvents_enseq_main_region1_A_default(ValuedEvents* handle);
static void valuedEvents_enseq_integer_region_B_default(ValuedEvents* handle);
static void valuedEvents_enseq_integer_region_C_default(ValuedEvents* handle);
static void valuedEvents_enseq_integer_region_D_default(ValuedEvents* handle);
static void valuedEvents_enseq_boolean_region_B_default(ValuedEvents* handle);
static void valuedEvents_enseq_boolean_region_C_default(ValuedEvents* handle);
static void valuedEvents_enseq_boolean_region_D_default(ValuedEvents* handle);
static void valuedEvents_enseq_real_region_B_default(ValuedEvents* handle);
static void valuedEvents_enseq_real_region_C_default(ValuedEvents* handle);
static void valuedEvents_enseq_real_region_D_default(ValuedEvents* handle);
static void valuedEvents_enseq_string_region_B_default(ValuedEvents* handle);
static void valuedEvents_enseq_string_region_C_default(ValuedEvents* handle);
static void valuedEvents_enseq_string_region_D_default(ValuedEvents* handle);
static void valuedEvents_enseq_main_region1_default(ValuedEvents* handle);
static void valuedEvents_enseq_integer_region_default(ValuedEvents* handle);
static void valuedEvents_enseq_boolean_region_default(ValuedEvents* handle);
static void valuedEvents_enseq_real_region_default(ValuedEvents* handle);
static void valuedEvents_enseq_string_region_default(ValuedEvents* handle);
static void valuedEvents_exseq_main_region1_A(ValuedEvents* handle);
static void valuedEvents_exseq_integer_region_B(ValuedEvents* handle);
static void valuedEvents_exseq_integer_region_C(ValuedEvents* handle);
static void valuedEvents_exseq_integer_region_D(ValuedEvents* handle);
static void valuedEvents_exseq_boolean_region_B(ValuedEvents* handle);
static void valuedEvents_exseq_boolean_region_C(ValuedEvents* handle);
static void valuedEvents_exseq_boolean_region_D(ValuedEvents* handle);
static void valuedEvents_exseq_real_region_B(ValuedEvents* handle);
static void valuedEvents_exseq_real_region_C(ValuedEvents* handle);
static void valuedEvents_exseq_real_region_D(ValuedEvents* handle);
static void valuedEvents_exseq_string_region_B(ValuedEvents* handle);
static void valuedEvents_exseq_string_region_C(ValuedEvents* handle);
static void valuedEvents_exseq_string_region_D(ValuedEvents* handle);
static void valuedEvents_exseq_main_region1(ValuedEvents* handle);
static void valuedEvents_exseq_integer_region(ValuedEvents* handle);
static void valuedEvents_exseq_boolean_region(ValuedEvents* handle);
static void valuedEvents_exseq_real_region(ValuedEvents* handle);
static void valuedEvents_exseq_string_region(ValuedEvents* handle);
static void valuedEvents_react_main_region1_A(ValuedEvents* handle);
static void valuedEvents_react_integer_region_B(ValuedEvents* handle);
static void valuedEvents_react_integer_region_C(ValuedEvents* handle);
static void valuedEvents_react_integer_region_D(ValuedEvents* handle);
static void valuedEvents_react_boolean_region_B(ValuedEvents* handle);
static void valuedEvents_react_boolean_region_C(ValuedEvents* handle);
static void valuedEvents_react_boolean_region_D(ValuedEvents* handle);
static void valuedEvents_react_real_region_B(ValuedEvents* handle);
static void valuedEvents_react_real_region_C(ValuedEvents* handle);
static void valuedEvents_react_real_region_D(ValuedEvents* handle);
static void valuedEvents_react_string_region_B(ValuedEvents* handle);
static void valuedEvents_react_string_region_C(ValuedEvents* handle);
static void valuedEvents_react_string_region_D(ValuedEvents* handle);
static void valuedEvents_react_main_region1__entry_Default(ValuedEvents* handle);
static void valuedEvents_react_integer_region__entry_Default(ValuedEvents* handle);
static void valuedEvents_react_boolean_region__entry_Default(ValuedEvents* handle);
static void valuedEvents_react_real_region__entry_Default(ValuedEvents* handle);
static void valuedEvents_react_string_region__entry_Default(ValuedEvents* handle);
static void valuedEvents_clearInEvents(ValuedEvents* handle);
static void valuedEvents_clearOutEvents(ValuedEvents* handle);


void valuedEvents_init(ValuedEvents* handle)
{
	sc_integer i;

	for (i = 0; i < VALUEDEVENTS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = ValuedEvents_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	valuedEvents_clearInEvents(handle);
	valuedEvents_clearOutEvents(handle);

	/* Default init sequence for statechart ValuedEvents */
	handle->iface.myInt = 0;
	handle->iface.myBool = bool_false;
	handle->iface.myReal = 0.0;
	handle->iface.myString = "";

}

void valuedEvents_enter(ValuedEvents* handle)
{
	/* Default enter sequence for statechart ValuedEvents */
	valuedEvents_enseq_main_region1_default(handle);
	valuedEvents_enseq_integer_region_default(handle);
	valuedEvents_enseq_boolean_region_default(handle);
	valuedEvents_enseq_real_region_default(handle);
	valuedEvents_enseq_string_region_default(handle);
}

void valuedEvents_exit(ValuedEvents* handle)
{
	/* Default exit sequence for statechart ValuedEvents */
	valuedEvents_exseq_main_region1(handle);
	valuedEvents_exseq_integer_region(handle);
	valuedEvents_exseq_boolean_region(handle);
	valuedEvents_exseq_real_region(handle);
	valuedEvents_exseq_string_region(handle);
}

sc_boolean valuedEvents_isActive(const ValuedEvents* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < VALUEDEVENTS_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != ValuedEvents_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean valuedEvents_isFinal(const ValuedEvents* handle)
{
   return bool_false;
}

static void valuedEvents_clearInEvents(ValuedEvents* handle)
{
	handle->iface.integerEvent_raised = bool_false;
	handle->iface.booleanEvent_raised = bool_false;
	handle->iface.realEvent_raised = bool_false;
	handle->iface.stringEvent_raised = bool_false;
}

static void valuedEvents_clearOutEvents(ValuedEvents* handle)
{
}

void valuedEvents_runCycle(ValuedEvents* handle)
{
	
	valuedEvents_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < VALUEDEVENTS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case ValuedEvents_main_region1_A :
		{
			valuedEvents_react_main_region1_A(handle);
			break;
		}
		case ValuedEvents_integer_region_B :
		{
			valuedEvents_react_integer_region_B(handle);
			break;
		}
		case ValuedEvents_integer_region_C :
		{
			valuedEvents_react_integer_region_C(handle);
			break;
		}
		case ValuedEvents_integer_region_D :
		{
			valuedEvents_react_integer_region_D(handle);
			break;
		}
		case ValuedEvents_boolean_region_B :
		{
			valuedEvents_react_boolean_region_B(handle);
			break;
		}
		case ValuedEvents_boolean_region_C :
		{
			valuedEvents_react_boolean_region_C(handle);
			break;
		}
		case ValuedEvents_boolean_region_D :
		{
			valuedEvents_react_boolean_region_D(handle);
			break;
		}
		case ValuedEvents_real_region_B :
		{
			valuedEvents_react_real_region_B(handle);
			break;
		}
		case ValuedEvents_real_region_C :
		{
			valuedEvents_react_real_region_C(handle);
			break;
		}
		case ValuedEvents_real_region_D :
		{
			valuedEvents_react_real_region_D(handle);
			break;
		}
		case ValuedEvents_string_region_B :
		{
			valuedEvents_react_string_region_B(handle);
			break;
		}
		case ValuedEvents_string_region_C :
		{
			valuedEvents_react_string_region_C(handle);
			break;
		}
		case ValuedEvents_string_region_D :
		{
			valuedEvents_react_string_region_D(handle);
			break;
		}
		default:
			break;
		}
	}
	
	valuedEvents_clearInEvents(handle);
}


sc_boolean valuedEvents_isStateActive(const ValuedEvents* handle, ValuedEventsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case ValuedEvents_main_region1_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_VALUEDEVENTS_MAIN_REGION1_A] == ValuedEvents_main_region1_A
			);
			break;
		case ValuedEvents_integer_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_VALUEDEVENTS_INTEGER_REGION_B] == ValuedEvents_integer_region_B
			);
			break;
		case ValuedEvents_integer_region_C :
			result = (sc_boolean) (handle->stateConfVector[SCVI_VALUEDEVENTS_INTEGER_REGION_C] == ValuedEvents_integer_region_C
			);
			break;
		case ValuedEvents_integer_region_D :
			result = (sc_boolean) (handle->stateConfVector[SCVI_VALUEDEVENTS_INTEGER_REGION_D] == ValuedEvents_integer_region_D
			);
			break;
		case ValuedEvents_boolean_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_VALUEDEVENTS_BOOLEAN_REGION_B] == ValuedEvents_boolean_region_B
			);
			break;
		case ValuedEvents_boolean_region_C :
			result = (sc_boolean) (handle->stateConfVector[SCVI_VALUEDEVENTS_BOOLEAN_REGION_C] == ValuedEvents_boolean_region_C
			);
			break;
		case ValuedEvents_boolean_region_D :
			result = (sc_boolean) (handle->stateConfVector[SCVI_VALUEDEVENTS_BOOLEAN_REGION_D] == ValuedEvents_boolean_region_D
			);
			break;
		case ValuedEvents_real_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_VALUEDEVENTS_REAL_REGION_B] == ValuedEvents_real_region_B
			);
			break;
		case ValuedEvents_real_region_C :
			result = (sc_boolean) (handle->stateConfVector[SCVI_VALUEDEVENTS_REAL_REGION_C] == ValuedEvents_real_region_C
			);
			break;
		case ValuedEvents_real_region_D :
			result = (sc_boolean) (handle->stateConfVector[SCVI_VALUEDEVENTS_REAL_REGION_D] == ValuedEvents_real_region_D
			);
			break;
		case ValuedEvents_string_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_VALUEDEVENTS_STRING_REGION_B] == ValuedEvents_string_region_B
			);
			break;
		case ValuedEvents_string_region_C :
			result = (sc_boolean) (handle->stateConfVector[SCVI_VALUEDEVENTS_STRING_REGION_C] == ValuedEvents_string_region_C
			);
			break;
		case ValuedEvents_string_region_D :
			result = (sc_boolean) (handle->stateConfVector[SCVI_VALUEDEVENTS_STRING_REGION_D] == ValuedEvents_string_region_D
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void valuedEventsIface_raise_integerEvent(ValuedEvents* handle, sc_integer value)
{
	handle->iface.integerEvent_value = value;
	handle->iface.integerEvent_raised = bool_true;
}
void valuedEventsIface_raise_booleanEvent(ValuedEvents* handle, sc_boolean value)
{
	handle->iface.booleanEvent_value = value;
	handle->iface.booleanEvent_raised = bool_true;
}
void valuedEventsIface_raise_realEvent(ValuedEvents* handle, sc_real value)
{
	handle->iface.realEvent_value = value;
	handle->iface.realEvent_raised = bool_true;
}
void valuedEventsIface_raise_stringEvent(ValuedEvents* handle, sc_string value)
{
	handle->iface.stringEvent_value = value;
	handle->iface.stringEvent_raised = bool_true;
}


sc_integer valuedEventsIface_get_myInt(const ValuedEvents* handle)
{
	return handle->iface.myInt;
}
void valuedEventsIface_set_myInt(ValuedEvents* handle, sc_integer value)
{
	handle->iface.myInt = value;
}
sc_boolean valuedEventsIface_get_myBool(const ValuedEvents* handle)
{
	return handle->iface.myBool;
}
void valuedEventsIface_set_myBool(ValuedEvents* handle, sc_boolean value)
{
	handle->iface.myBool = value;
}
sc_real valuedEventsIface_get_myReal(const ValuedEvents* handle)
{
	return handle->iface.myReal;
}
void valuedEventsIface_set_myReal(ValuedEvents* handle, sc_real value)
{
	handle->iface.myReal = value;
}
sc_string valuedEventsIface_get_myString(const ValuedEvents* handle)
{
	return handle->iface.myString;
}
void valuedEventsIface_set_myString(ValuedEvents* handle, sc_string value)
{
	handle->iface.myString = value;
}

/* implementations of all internal functions */

static sc_boolean valuedEvents_check_integer_region_B_tr0_tr0(const ValuedEvents* handle)
{
	return handle->iface.integerEvent_raised;
}

static sc_boolean valuedEvents_check_integer_region_C_tr0_tr0(const ValuedEvents* handle)
{
	return handle->iface.integerEvent_raised;
}

static sc_boolean valuedEvents_check_boolean_region_B_tr0_tr0(const ValuedEvents* handle)
{
	return handle->iface.booleanEvent_raised;
}

static sc_boolean valuedEvents_check_boolean_region_C_tr0_tr0(const ValuedEvents* handle)
{
	return handle->iface.booleanEvent_raised;
}

static sc_boolean valuedEvents_check_real_region_B_tr0_tr0(const ValuedEvents* handle)
{
	return handle->iface.realEvent_raised;
}

static sc_boolean valuedEvents_check_real_region_C_tr0_tr0(const ValuedEvents* handle)
{
	return handle->iface.realEvent_raised;
}

static sc_boolean valuedEvents_check_string_region_B_tr0_tr0(const ValuedEvents* handle)
{
	return handle->iface.stringEvent_raised;
}

static sc_boolean valuedEvents_check_string_region_C_tr0_tr0(const ValuedEvents* handle)
{
	return handle->iface.stringEvent_raised;
}

static void valuedEvents_effect_integer_region_B_tr0(ValuedEvents* handle)
{
	valuedEvents_exseq_integer_region_B(handle);
	handle->iface.myInt = handle->iface.integerEvent_value;
	valuedEvents_enseq_integer_region_C_default(handle);
}

static void valuedEvents_effect_integer_region_C_tr0(ValuedEvents* handle)
{
	valuedEvents_exseq_integer_region_C(handle);
	handle->iface.myInt = handle->iface.integerEvent_value;
	valuedEvents_enseq_integer_region_D_default(handle);
}

static void valuedEvents_effect_boolean_region_B_tr0(ValuedEvents* handle)
{
	valuedEvents_exseq_boolean_region_B(handle);
	handle->iface.myBool = handle->iface.booleanEvent_value;
	valuedEvents_enseq_boolean_region_C_default(handle);
}

static void valuedEvents_effect_boolean_region_C_tr0(ValuedEvents* handle)
{
	valuedEvents_exseq_boolean_region_C(handle);
	handle->iface.myBool = handle->iface.booleanEvent_value;
	valuedEvents_enseq_boolean_region_D_default(handle);
}

static void valuedEvents_effect_real_region_B_tr0(ValuedEvents* handle)
{
	valuedEvents_exseq_real_region_B(handle);
	handle->iface.myReal = handle->iface.realEvent_value;
	valuedEvents_enseq_real_region_C_default(handle);
}

static void valuedEvents_effect_real_region_C_tr0(ValuedEvents* handle)
{
	valuedEvents_exseq_real_region_C(handle);
	handle->iface.myReal = handle->iface.realEvent_value;
	valuedEvents_enseq_real_region_D_default(handle);
}

static void valuedEvents_effect_string_region_B_tr0(ValuedEvents* handle)
{
	valuedEvents_exseq_string_region_B(handle);
	handle->iface.myString = handle->iface.stringEvent_value;
	valuedEvents_enseq_string_region_C_default(handle);
}

static void valuedEvents_effect_string_region_C_tr0(ValuedEvents* handle)
{
	valuedEvents_exseq_string_region_C(handle);
	handle->iface.myString = handle->iface.stringEvent_value;
	valuedEvents_enseq_string_region_D_default(handle);
}

/* Entry action for state 'A'. */
static void valuedEvents_enact_main_region1_A(ValuedEvents* handle)
{
	/* Entry action for state 'A'. */
	handle->iface.integerEvent_value = 2 * 21;
	handle->iface.integerEvent_raised = bool_true;
	handle->iface.realEvent_value = 10;
	handle->iface.realEvent_raised = bool_true;
	handle->iface.booleanEvent_value = bool_true || bool_false;
	handle->iface.booleanEvent_raised = bool_true;
	handle->iface.stringEvent_value = "sct";
	handle->iface.stringEvent_raised = bool_true;
}

/* 'default' enter sequence for state A */
static void valuedEvents_enseq_main_region1_A_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for state A */
	valuedEvents_enact_main_region1_A(handle);
	handle->stateConfVector[0] = ValuedEvents_main_region1_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void valuedEvents_enseq_integer_region_B_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[1] = ValuedEvents_integer_region_B;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state C */
static void valuedEvents_enseq_integer_region_C_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[1] = ValuedEvents_integer_region_C;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state D */
static void valuedEvents_enseq_integer_region_D_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for state D */
	handle->stateConfVector[1] = ValuedEvents_integer_region_D;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state B */
static void valuedEvents_enseq_boolean_region_B_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[2] = ValuedEvents_boolean_region_B;
	handle->stateConfVectorPosition = 2;
}

/* 'default' enter sequence for state C */
static void valuedEvents_enseq_boolean_region_C_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[2] = ValuedEvents_boolean_region_C;
	handle->stateConfVectorPosition = 2;
}

/* 'default' enter sequence for state D */
static void valuedEvents_enseq_boolean_region_D_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for state D */
	handle->stateConfVector[2] = ValuedEvents_boolean_region_D;
	handle->stateConfVectorPosition = 2;
}

/* 'default' enter sequence for state B */
static void valuedEvents_enseq_real_region_B_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[3] = ValuedEvents_real_region_B;
	handle->stateConfVectorPosition = 3;
}

/* 'default' enter sequence for state C */
static void valuedEvents_enseq_real_region_C_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[3] = ValuedEvents_real_region_C;
	handle->stateConfVectorPosition = 3;
}

/* 'default' enter sequence for state D */
static void valuedEvents_enseq_real_region_D_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for state D */
	handle->stateConfVector[3] = ValuedEvents_real_region_D;
	handle->stateConfVectorPosition = 3;
}

/* 'default' enter sequence for state B */
static void valuedEvents_enseq_string_region_B_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[4] = ValuedEvents_string_region_B;
	handle->stateConfVectorPosition = 4;
}

/* 'default' enter sequence for state C */
static void valuedEvents_enseq_string_region_C_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[4] = ValuedEvents_string_region_C;
	handle->stateConfVectorPosition = 4;
}

/* 'default' enter sequence for state D */
static void valuedEvents_enseq_string_region_D_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for state D */
	handle->stateConfVector[4] = ValuedEvents_string_region_D;
	handle->stateConfVectorPosition = 4;
}

/* 'default' enter sequence for region main region1 */
static void valuedEvents_enseq_main_region1_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for region main region1 */
	valuedEvents_react_main_region1__entry_Default(handle);
}

/* 'default' enter sequence for region integer_region */
static void valuedEvents_enseq_integer_region_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for region integer_region */
	valuedEvents_react_integer_region__entry_Default(handle);
}

/* 'default' enter sequence for region boolean_region */
static void valuedEvents_enseq_boolean_region_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for region boolean_region */
	valuedEvents_react_boolean_region__entry_Default(handle);
}

/* 'default' enter sequence for region real_region */
static void valuedEvents_enseq_real_region_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for region real_region */
	valuedEvents_react_real_region__entry_Default(handle);
}

/* 'default' enter sequence for region string_region */
static void valuedEvents_enseq_string_region_default(ValuedEvents* handle)
{
	/* 'default' enter sequence for region string_region */
	valuedEvents_react_string_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void valuedEvents_exseq_main_region1_A(ValuedEvents* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = ValuedEvents_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void valuedEvents_exseq_integer_region_B(ValuedEvents* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[1] = ValuedEvents_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state C */
static void valuedEvents_exseq_integer_region_C(ValuedEvents* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[1] = ValuedEvents_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state D */
static void valuedEvents_exseq_integer_region_D(ValuedEvents* handle)
{
	/* Default exit sequence for state D */
	handle->stateConfVector[1] = ValuedEvents_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state B */
static void valuedEvents_exseq_boolean_region_B(ValuedEvents* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[2] = ValuedEvents_last_state;
	handle->stateConfVectorPosition = 2;
}

/* Default exit sequence for state C */
static void valuedEvents_exseq_boolean_region_C(ValuedEvents* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[2] = ValuedEvents_last_state;
	handle->stateConfVectorPosition = 2;
}

/* Default exit sequence for state D */
static void valuedEvents_exseq_boolean_region_D(ValuedEvents* handle)
{
	/* Default exit sequence for state D */
	handle->stateConfVector[2] = ValuedEvents_last_state;
	handle->stateConfVectorPosition = 2;
}

/* Default exit sequence for state B */
static void valuedEvents_exseq_real_region_B(ValuedEvents* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[3] = ValuedEvents_last_state;
	handle->stateConfVectorPosition = 3;
}

/* Default exit sequence for state C */
static void valuedEvents_exseq_real_region_C(ValuedEvents* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[3] = ValuedEvents_last_state;
	handle->stateConfVectorPosition = 3;
}

/* Default exit sequence for state D */
static void valuedEvents_exseq_real_region_D(ValuedEvents* handle)
{
	/* Default exit sequence for state D */
	handle->stateConfVector[3] = ValuedEvents_last_state;
	handle->stateConfVectorPosition = 3;
}

/* Default exit sequence for state B */
static void valuedEvents_exseq_string_region_B(ValuedEvents* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[4] = ValuedEvents_last_state;
	handle->stateConfVectorPosition = 4;
}

/* Default exit sequence for state C */
static void valuedEvents_exseq_string_region_C(ValuedEvents* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[4] = ValuedEvents_last_state;
	handle->stateConfVectorPosition = 4;
}

/* Default exit sequence for state D */
static void valuedEvents_exseq_string_region_D(ValuedEvents* handle)
{
	/* Default exit sequence for state D */
	handle->stateConfVector[4] = ValuedEvents_last_state;
	handle->stateConfVectorPosition = 4;
}

/* Default exit sequence for region main region1 */
static void valuedEvents_exseq_main_region1(ValuedEvents* handle)
{
	/* Default exit sequence for region main region1 */
	/* Handle exit of all possible states (of ValuedEvents.main_region1) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ValuedEvents_main_region1_A :
		{
			valuedEvents_exseq_main_region1_A(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region integer_region */
static void valuedEvents_exseq_integer_region(ValuedEvents* handle)
{
	/* Default exit sequence for region integer_region */
	/* Handle exit of all possible states (of ValuedEvents.integer_region) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case ValuedEvents_integer_region_B :
		{
			valuedEvents_exseq_integer_region_B(handle);
			break;
		}
		case ValuedEvents_integer_region_C :
		{
			valuedEvents_exseq_integer_region_C(handle);
			break;
		}
		case ValuedEvents_integer_region_D :
		{
			valuedEvents_exseq_integer_region_D(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region boolean_region */
static void valuedEvents_exseq_boolean_region(ValuedEvents* handle)
{
	/* Default exit sequence for region boolean_region */
	/* Handle exit of all possible states (of ValuedEvents.boolean_region) at position 2... */
	switch(handle->stateConfVector[ 2 ])
	{
		case ValuedEvents_boolean_region_B :
		{
			valuedEvents_exseq_boolean_region_B(handle);
			break;
		}
		case ValuedEvents_boolean_region_C :
		{
			valuedEvents_exseq_boolean_region_C(handle);
			break;
		}
		case ValuedEvents_boolean_region_D :
		{
			valuedEvents_exseq_boolean_region_D(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region real_region */
static void valuedEvents_exseq_real_region(ValuedEvents* handle)
{
	/* Default exit sequence for region real_region */
	/* Handle exit of all possible states (of ValuedEvents.real_region) at position 3... */
	switch(handle->stateConfVector[ 3 ])
	{
		case ValuedEvents_real_region_B :
		{
			valuedEvents_exseq_real_region_B(handle);
			break;
		}
		case ValuedEvents_real_region_C :
		{
			valuedEvents_exseq_real_region_C(handle);
			break;
		}
		case ValuedEvents_real_region_D :
		{
			valuedEvents_exseq_real_region_D(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region string_region */
static void valuedEvents_exseq_string_region(ValuedEvents* handle)
{
	/* Default exit sequence for region string_region */
	/* Handle exit of all possible states (of ValuedEvents.string_region) at position 4... */
	switch(handle->stateConfVector[ 4 ])
	{
		case ValuedEvents_string_region_B :
		{
			valuedEvents_exseq_string_region_B(handle);
			break;
		}
		case ValuedEvents_string_region_C :
		{
			valuedEvents_exseq_string_region_C(handle);
			break;
		}
		case ValuedEvents_string_region_D :
		{
			valuedEvents_exseq_string_region_D(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void valuedEvents_react_main_region1_A(ValuedEvents* handle)
{
	/* The reactions of state A. */
}

/* The reactions of state B. */
static void valuedEvents_react_integer_region_B(ValuedEvents* handle)
{
	/* The reactions of state B. */
	if (valuedEvents_check_integer_region_B_tr0_tr0(handle) == bool_true)
	{ 
		valuedEvents_effect_integer_region_B_tr0(handle);
	} 
}

/* The reactions of state C. */
static void valuedEvents_react_integer_region_C(ValuedEvents* handle)
{
	/* The reactions of state C. */
	if (valuedEvents_check_integer_region_C_tr0_tr0(handle) == bool_true)
	{ 
		valuedEvents_effect_integer_region_C_tr0(handle);
	} 
}

/* The reactions of state D. */
static void valuedEvents_react_integer_region_D(ValuedEvents* handle)
{
}

/* The reactions of state B. */
static void valuedEvents_react_boolean_region_B(ValuedEvents* handle)
{
	/* The reactions of state B. */
	if (valuedEvents_check_boolean_region_B_tr0_tr0(handle) == bool_true)
	{ 
		valuedEvents_effect_boolean_region_B_tr0(handle);
	} 
}

/* The reactions of state C. */
static void valuedEvents_react_boolean_region_C(ValuedEvents* handle)
{
	/* The reactions of state C. */
	if (valuedEvents_check_boolean_region_C_tr0_tr0(handle) == bool_true)
	{ 
		valuedEvents_effect_boolean_region_C_tr0(handle);
	} 
}

/* The reactions of state D. */
static void valuedEvents_react_boolean_region_D(ValuedEvents* handle)
{
}

/* The reactions of state B. */
static void valuedEvents_react_real_region_B(ValuedEvents* handle)
{
	/* The reactions of state B. */
	if (valuedEvents_check_real_region_B_tr0_tr0(handle) == bool_true)
	{ 
		valuedEvents_effect_real_region_B_tr0(handle);
	} 
}

/* The reactions of state C. */
static void valuedEvents_react_real_region_C(ValuedEvents* handle)
{
	/* The reactions of state C. */
	if (valuedEvents_check_real_region_C_tr0_tr0(handle) == bool_true)
	{ 
		valuedEvents_effect_real_region_C_tr0(handle);
	} 
}

/* The reactions of state D. */
static void valuedEvents_react_real_region_D(ValuedEvents* handle)
{
}

/* The reactions of state B. */
static void valuedEvents_react_string_region_B(ValuedEvents* handle)
{
	/* The reactions of state B. */
	if (valuedEvents_check_string_region_B_tr0_tr0(handle) == bool_true)
	{ 
		valuedEvents_effect_string_region_B_tr0(handle);
	} 
}

/* The reactions of state C. */
static void valuedEvents_react_string_region_C(ValuedEvents* handle)
{
	/* The reactions of state C. */
	if (valuedEvents_check_string_region_C_tr0_tr0(handle) == bool_true)
	{ 
		valuedEvents_effect_string_region_C_tr0(handle);
	} 
}

/* The reactions of state D. */
static void valuedEvents_react_string_region_D(ValuedEvents* handle)
{
}

/* Default react sequence for initial entry  */
static void valuedEvents_react_main_region1__entry_Default(ValuedEvents* handle)
{
	/* Default react sequence for initial entry  */
	valuedEvents_enseq_main_region1_A_default(handle);
}

/* Default react sequence for initial entry  */
static void valuedEvents_react_integer_region__entry_Default(ValuedEvents* handle)
{
	/* Default react sequence for initial entry  */
	valuedEvents_enseq_integer_region_B_default(handle);
}

/* Default react sequence for initial entry  */
static void valuedEvents_react_boolean_region__entry_Default(ValuedEvents* handle)
{
	/* Default react sequence for initial entry  */
	valuedEvents_enseq_boolean_region_B_default(handle);
}

/* Default react sequence for initial entry  */
static void valuedEvents_react_real_region__entry_Default(ValuedEvents* handle)
{
	/* Default react sequence for initial entry  */
	valuedEvents_enseq_real_region_B_default(handle);
}

/* Default react sequence for initial entry  */
static void valuedEvents_react_string_region__entry_Default(ValuedEvents* handle)
{
	/* Default react sequence for initial entry  */
	valuedEvents_enseq_string_region_B_default(handle);
}


