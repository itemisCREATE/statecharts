
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "TypeAlias.h"
/*! \file Implementation of the state machine 'TypeAlias'
*/

/* prototypes of all internal functions */
static sc_boolean typeAlias_check_main_region_Start_tr0_tr0(const TypeAlias* handle);
static sc_boolean typeAlias_check_main_region_Mid_tr0_tr0(const TypeAlias* handle);
static sc_boolean typeAlias_check_main_region_Mid2_tr0_tr0(const TypeAlias* handle);
static void typeAlias_effect_main_region_Start_tr0(TypeAlias* handle);
static void typeAlias_effect_main_region_Mid_tr0(TypeAlias* handle);
static void typeAlias_effect_main_region_Mid2_tr0(TypeAlias* handle);
static void typeAlias_enact_main_region_Start(TypeAlias* handle);
static void typeAlias_enact_main_region_Mid(TypeAlias* handle);
static void typeAlias_enseq_main_region_Start_default(TypeAlias* handle);
static void typeAlias_enseq_main_region_Mid_default(TypeAlias* handle);
static void typeAlias_enseq_main_region_Mid2_default(TypeAlias* handle);
static void typeAlias_enseq_main_region_End_default(TypeAlias* handle);
static void typeAlias_enseq_main_region_default(TypeAlias* handle);
static void typeAlias_exseq_main_region_Start(TypeAlias* handle);
static void typeAlias_exseq_main_region_Mid(TypeAlias* handle);
static void typeAlias_exseq_main_region_Mid2(TypeAlias* handle);
static void typeAlias_exseq_main_region_End(TypeAlias* handle);
static void typeAlias_exseq_main_region(TypeAlias* handle);
static void typeAlias_react_main_region_Start(TypeAlias* handle);
static void typeAlias_react_main_region_Mid(TypeAlias* handle);
static void typeAlias_react_main_region_Mid2(TypeAlias* handle);
static void typeAlias_react_main_region_End(TypeAlias* handle);
static void typeAlias_react_main_region__entry_Default(TypeAlias* handle);
static void typeAlias_clearInEvents(TypeAlias* handle);
static void typeAlias_clearOutEvents(TypeAlias* handle);


void typeAlias_init(TypeAlias* handle)
{
	sc_integer i;

	for (i = 0; i < TYPEALIAS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = TypeAlias_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	typeAlias_clearInEvents(handle);
	typeAlias_clearOutEvents(handle);

	/* Default init sequence for statechart TypeAlias */
	handle->iface.myVar = 0;
	handle->iface.myString = "";

}

void typeAlias_enter(TypeAlias* handle)
{
	/* Default enter sequence for statechart TypeAlias */
	typeAlias_enseq_main_region_default(handle);
}

void typeAlias_exit(TypeAlias* handle)
{
	/* Default exit sequence for statechart TypeAlias */
	typeAlias_exseq_main_region(handle);
}

sc_boolean typeAlias_isActive(const TypeAlias* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != TypeAlias_last_state)
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
sc_boolean typeAlias_isFinal(const TypeAlias* handle)
{
   return bool_false;
}

static void typeAlias_clearInEvents(TypeAlias* handle)
{
	handle->iface.myEvent_raised = bool_false;
}

static void typeAlias_clearOutEvents(TypeAlias* handle)
{
}

void typeAlias_runCycle(TypeAlias* handle)
{
	
	typeAlias_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < TYPEALIAS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case TypeAlias_main_region_Start :
		{
			typeAlias_react_main_region_Start(handle);
			break;
		}
		case TypeAlias_main_region_Mid :
		{
			typeAlias_react_main_region_Mid(handle);
			break;
		}
		case TypeAlias_main_region_Mid2 :
		{
			typeAlias_react_main_region_Mid2(handle);
			break;
		}
		case TypeAlias_main_region_End :
		{
			typeAlias_react_main_region_End(handle);
			break;
		}
		default:
			break;
		}
	}
	
	typeAlias_clearInEvents(handle);
}


sc_boolean typeAlias_isStateActive(const TypeAlias* handle, TypeAliasStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case TypeAlias_main_region_Start :
			result = (sc_boolean) (handle->stateConfVector[0] == TypeAlias_main_region_Start
			);
			break;
		case TypeAlias_main_region_Mid :
			result = (sc_boolean) (handle->stateConfVector[0] == TypeAlias_main_region_Mid
			);
			break;
		case TypeAlias_main_region_Mid2 :
			result = (sc_boolean) (handle->stateConfVector[0] == TypeAlias_main_region_Mid2
			);
			break;
		case TypeAlias_main_region_End :
			result = (sc_boolean) (handle->stateConfVector[0] == TypeAlias_main_region_End
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void typeAliasIface_raise_myEvent(TypeAlias* handle)
{
	handle->iface.myEvent_raised = bool_true;
}


sc_integer typeAliasIface_get_myVar(const TypeAlias* handle)
{
	return handle->iface.myVar;
}
void typeAliasIface_set_myVar(TypeAlias* handle, sc_integer value)
{
	handle->iface.myVar = value;
}
sc_string typeAliasIface_get_myString(const TypeAlias* handle)
{
	return handle->iface.myString;
}
void typeAliasIface_set_myString(TypeAlias* handle, sc_string value)
{
	handle->iface.myString = value;
}

/* implementations of all internal functions */

static sc_boolean typeAlias_check_main_region_Start_tr0_tr0(const TypeAlias* handle)
{
	return (handle->iface.myVar == 1) ? bool_true : bool_false;
}

static sc_boolean typeAlias_check_main_region_Mid_tr0_tr0(const TypeAlias* handle)
{
	return ((strcmp(handle->iface.myString, "TypeSystem") == 0)
	) ? bool_true : bool_false;
}

static sc_boolean typeAlias_check_main_region_Mid2_tr0_tr0(const TypeAlias* handle)
{
	return handle->iface.myEvent_raised;
}

static void typeAlias_effect_main_region_Start_tr0(TypeAlias* handle)
{
	typeAlias_exseq_main_region_Start(handle);
	typeAlias_enseq_main_region_Mid_default(handle);
}

static void typeAlias_effect_main_region_Mid_tr0(TypeAlias* handle)
{
	typeAlias_exseq_main_region_Mid(handle);
	typeAlias_enseq_main_region_Mid2_default(handle);
}

static void typeAlias_effect_main_region_Mid2_tr0(TypeAlias* handle)
{
	typeAlias_exseq_main_region_Mid2(handle);
	typeAlias_enseq_main_region_End_default(handle);
}

/* Entry action for state 'Start'. */
static void typeAlias_enact_main_region_Start(TypeAlias* handle)
{
	/* Entry action for state 'Start'. */
	handle->iface.myVar = 1;
}

/* Entry action for state 'Mid'. */
static void typeAlias_enact_main_region_Mid(TypeAlias* handle)
{
	/* Entry action for state 'Mid'. */
	handle->iface.myString = "TypeSystem";
}

/* 'default' enter sequence for state Start */
static void typeAlias_enseq_main_region_Start_default(TypeAlias* handle)
{
	/* 'default' enter sequence for state Start */
	typeAlias_enact_main_region_Start(handle);
	handle->stateConfVector[0] = TypeAlias_main_region_Start;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Mid */
static void typeAlias_enseq_main_region_Mid_default(TypeAlias* handle)
{
	/* 'default' enter sequence for state Mid */
	typeAlias_enact_main_region_Mid(handle);
	handle->stateConfVector[0] = TypeAlias_main_region_Mid;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Mid2 */
static void typeAlias_enseq_main_region_Mid2_default(TypeAlias* handle)
{
	/* 'default' enter sequence for state Mid2 */
	handle->stateConfVector[0] = TypeAlias_main_region_Mid2;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state End */
static void typeAlias_enseq_main_region_End_default(TypeAlias* handle)
{
	/* 'default' enter sequence for state End */
	handle->stateConfVector[0] = TypeAlias_main_region_End;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void typeAlias_enseq_main_region_default(TypeAlias* handle)
{
	/* 'default' enter sequence for region main region */
	typeAlias_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state Start */
static void typeAlias_exseq_main_region_Start(TypeAlias* handle)
{
	/* Default exit sequence for state Start */
	handle->stateConfVector[0] = TypeAlias_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state Mid */
static void typeAlias_exseq_main_region_Mid(TypeAlias* handle)
{
	/* Default exit sequence for state Mid */
	handle->stateConfVector[0] = TypeAlias_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state Mid2 */
static void typeAlias_exseq_main_region_Mid2(TypeAlias* handle)
{
	/* Default exit sequence for state Mid2 */
	handle->stateConfVector[0] = TypeAlias_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state End */
static void typeAlias_exseq_main_region_End(TypeAlias* handle)
{
	/* Default exit sequence for state End */
	handle->stateConfVector[0] = TypeAlias_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void typeAlias_exseq_main_region(TypeAlias* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of TypeAlias.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case TypeAlias_main_region_Start :
		{
			typeAlias_exseq_main_region_Start(handle);
			break;
		}
		case TypeAlias_main_region_Mid :
		{
			typeAlias_exseq_main_region_Mid(handle);
			break;
		}
		case TypeAlias_main_region_Mid2 :
		{
			typeAlias_exseq_main_region_Mid2(handle);
			break;
		}
		case TypeAlias_main_region_End :
		{
			typeAlias_exseq_main_region_End(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state Start. */
static void typeAlias_react_main_region_Start(TypeAlias* handle)
{
	/* The reactions of state Start. */
	if (typeAlias_check_main_region_Start_tr0_tr0(handle) == bool_true)
	{ 
		typeAlias_effect_main_region_Start_tr0(handle);
	} 
}

/* The reactions of state Mid. */
static void typeAlias_react_main_region_Mid(TypeAlias* handle)
{
	/* The reactions of state Mid. */
	if (typeAlias_check_main_region_Mid_tr0_tr0(handle) == bool_true)
	{ 
		typeAlias_effect_main_region_Mid_tr0(handle);
	} 
}

/* The reactions of state Mid2. */
static void typeAlias_react_main_region_Mid2(TypeAlias* handle)
{
	/* The reactions of state Mid2. */
	if (typeAlias_check_main_region_Mid2_tr0_tr0(handle) == bool_true)
	{ 
		typeAlias_effect_main_region_Mid2_tr0(handle);
	} 
}

/* The reactions of state End. */
static void typeAlias_react_main_region_End(TypeAlias* handle)
{
	/* The reactions of state End. */
}

/* Default react sequence for initial entry  */
static void typeAlias_react_main_region__entry_Default(TypeAlias* handle)
{
	/* Default react sequence for initial entry  */
	typeAlias_enseq_main_region_Start_default(handle);
}


