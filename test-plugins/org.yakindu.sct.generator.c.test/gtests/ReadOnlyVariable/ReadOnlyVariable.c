
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "ReadOnlyVariable.h"
/*! \file Implementation of the state machine 'ReadOnlyVariable'
*/

/* prototypes of all internal functions */
static sc_boolean readOnlyVariable_check_main_region_StateA_tr0_tr0(const ReadOnlyVariable* handle);
static void readOnlyVariable_effect_main_region_StateA_tr0(ReadOnlyVariable* handle);
static void readOnlyVariable_enact_main_region_StateB(ReadOnlyVariable* handle);
static void readOnlyVariable_enseq_main_region_StateB_default(ReadOnlyVariable* handle);
static void readOnlyVariable_enseq_main_region_StateA_default(ReadOnlyVariable* handle);
static void readOnlyVariable_enseq_main_region_default(ReadOnlyVariable* handle);
static void readOnlyVariable_exseq_main_region_StateB(ReadOnlyVariable* handle);
static void readOnlyVariable_exseq_main_region_StateA(ReadOnlyVariable* handle);
static void readOnlyVariable_exseq_main_region(ReadOnlyVariable* handle);
static void readOnlyVariable_react_main_region_StateB(ReadOnlyVariable* handle);
static void readOnlyVariable_react_main_region_StateA(ReadOnlyVariable* handle);
static void readOnlyVariable_react_main_region__entry_Default(ReadOnlyVariable* handle);
static void readOnlyVariable_clearInEvents(ReadOnlyVariable* handle);
static void readOnlyVariable_clearOutEvents(ReadOnlyVariable* handle);


void readOnlyVariable_init(ReadOnlyVariable* handle)
{
	sc_integer i;

	for (i = 0; i < READONLYVARIABLE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = ReadOnlyVariable_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	readOnlyVariable_clearInEvents(handle);
	readOnlyVariable_clearOutEvents(handle);

	/* Default init sequence for statechart ReadOnlyVariable */
	handle->iface.myInt = 0;
	handle->iface.myString = "testString";
	handle->iface.myBool = bool_true;
	handle->iface.myReal = 1.1;
	handle->ifaceA.myInt = 0;
	handle->ifaceA.myString = "testString";
	handle->ifaceA.myBool = bool_true;
	handle->ifaceA.myReal = 1.1;

}

void readOnlyVariable_enter(ReadOnlyVariable* handle)
{
	/* Default enter sequence for statechart ReadOnlyVariable */
	readOnlyVariable_enseq_main_region_default(handle);
}

void readOnlyVariable_exit(ReadOnlyVariable* handle)
{
	/* Default exit sequence for statechart ReadOnlyVariable */
	readOnlyVariable_exseq_main_region(handle);
}

sc_boolean readOnlyVariable_isActive(const ReadOnlyVariable* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < READONLYVARIABLE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != ReadOnlyVariable_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean readOnlyVariable_isFinal(const ReadOnlyVariable* handle)
{
   return bool_false;
}

static void readOnlyVariable_clearInEvents(ReadOnlyVariable* handle)
{
}

static void readOnlyVariable_clearOutEvents(ReadOnlyVariable* handle)
{
}

void readOnlyVariable_runCycle(ReadOnlyVariable* handle)
{
	
	readOnlyVariable_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < READONLYVARIABLE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case ReadOnlyVariable_main_region_StateB :
		{
			readOnlyVariable_react_main_region_StateB(handle);
			break;
		}
		case ReadOnlyVariable_main_region_StateA :
		{
			readOnlyVariable_react_main_region_StateA(handle);
			break;
		}
		default:
			break;
		}
	}
	
	readOnlyVariable_clearInEvents(handle);
}


sc_boolean readOnlyVariable_isStateActive(const ReadOnlyVariable* handle, ReadOnlyVariableStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case ReadOnlyVariable_main_region_StateB :
			result = (sc_boolean) (handle->stateConfVector[SCVI_READONLYVARIABLE_MAIN_REGION_STATEB] == ReadOnlyVariable_main_region_StateB
			);
			break;
		case ReadOnlyVariable_main_region_StateA :
			result = (sc_boolean) (handle->stateConfVector[SCVI_READONLYVARIABLE_MAIN_REGION_STATEA] == ReadOnlyVariable_main_region_StateA
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}



sc_integer readOnlyVariableIface_get_myInt(const ReadOnlyVariable* handle)
{
	return handle->iface.myInt;
}
sc_string readOnlyVariableIface_get_myString(const ReadOnlyVariable* handle)
{
	return handle->iface.myString;
}
sc_boolean readOnlyVariableIface_get_myBool(const ReadOnlyVariable* handle)
{
	return handle->iface.myBool;
}
sc_real readOnlyVariableIface_get_myReal(const ReadOnlyVariable* handle)
{
	return handle->iface.myReal;
}


sc_integer readOnlyVariableIfaceA_get_myInt(const ReadOnlyVariable* handle)
{
	return handle->ifaceA.myInt;
}
sc_string readOnlyVariableIfaceA_get_myString(const ReadOnlyVariable* handle)
{
	return handle->ifaceA.myString;
}
sc_boolean readOnlyVariableIfaceA_get_myBool(const ReadOnlyVariable* handle)
{
	return handle->ifaceA.myBool;
}
sc_real readOnlyVariableIfaceA_get_myReal(const ReadOnlyVariable* handle)
{
	return handle->ifaceA.myReal;
}

/* implementations of all internal functions */

static sc_boolean readOnlyVariable_check_main_region_StateA_tr0_tr0(const ReadOnlyVariable* handle)
{
	return bool_true;
}

static void readOnlyVariable_effect_main_region_StateA_tr0(ReadOnlyVariable* handle)
{
	readOnlyVariable_exseq_main_region_StateA(handle);
	readOnlyVariable_enseq_main_region_StateB_default(handle);
}

/* Entry action for state 'StateB'. */
static void readOnlyVariable_enact_main_region_StateB(ReadOnlyVariable* handle)
{
	/* Entry action for state 'StateB'. */
	handle->iface.myInt = 100;
	handle->iface.myString = "fail";
	handle->iface.myBool = bool_false;
	handle->iface.myReal = 6.6;
	handle->ifaceA.myInt = 200;
	handle->ifaceA.myString = "A_fail";
	handle->ifaceA.myBool = bool_false;
	handle->ifaceA.myReal = 7.7;
}

/* 'default' enter sequence for state StateB */
static void readOnlyVariable_enseq_main_region_StateB_default(ReadOnlyVariable* handle)
{
	/* 'default' enter sequence for state StateB */
	readOnlyVariable_enact_main_region_StateB(handle);
	handle->stateConfVector[0] = ReadOnlyVariable_main_region_StateB;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state StateA */
static void readOnlyVariable_enseq_main_region_StateA_default(ReadOnlyVariable* handle)
{
	/* 'default' enter sequence for state StateA */
	handle->stateConfVector[0] = ReadOnlyVariable_main_region_StateA;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void readOnlyVariable_enseq_main_region_default(ReadOnlyVariable* handle)
{
	/* 'default' enter sequence for region main region */
	readOnlyVariable_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state StateB */
static void readOnlyVariable_exseq_main_region_StateB(ReadOnlyVariable* handle)
{
	/* Default exit sequence for state StateB */
	handle->stateConfVector[0] = ReadOnlyVariable_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state StateA */
static void readOnlyVariable_exseq_main_region_StateA(ReadOnlyVariable* handle)
{
	/* Default exit sequence for state StateA */
	handle->stateConfVector[0] = ReadOnlyVariable_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void readOnlyVariable_exseq_main_region(ReadOnlyVariable* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of ReadOnlyVariable.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ReadOnlyVariable_main_region_StateB :
		{
			readOnlyVariable_exseq_main_region_StateB(handle);
			break;
		}
		case ReadOnlyVariable_main_region_StateA :
		{
			readOnlyVariable_exseq_main_region_StateA(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state StateB. */
static void readOnlyVariable_react_main_region_StateB(ReadOnlyVariable* handle)
{
	/* The reactions of state StateB. */
}

/* The reactions of state StateA. */
static void readOnlyVariable_react_main_region_StateA(ReadOnlyVariable* handle)
{
	/* The reactions of state StateA. */
	readOnlyVariable_effect_main_region_StateA_tr0(handle);
}

/* Default react sequence for initial entry  */
static void readOnlyVariable_react_main_region__entry_Default(ReadOnlyVariable* handle)
{
	/* Default react sequence for initial entry  */
	readOnlyVariable_enseq_main_region_StateA_default(handle);
}


