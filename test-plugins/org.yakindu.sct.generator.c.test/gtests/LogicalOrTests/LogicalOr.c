
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "LogicalOr.h"
/*! \file Implementation of the state machine 'LogicalOr'
*/

/* prototypes of all internal functions */
static sc_boolean logicalOr_check_main_region_A_tr0_tr0(const LogicalOr* handle);
static void logicalOr_effect_main_region_A_tr0(LogicalOr* handle);
static void logicalOr_enseq_main_region_A_default(LogicalOr* handle);
static void logicalOr_enseq_main_region_default(LogicalOr* handle);
static void logicalOr_exseq_main_region_A(LogicalOr* handle);
static void logicalOr_exseq_main_region(LogicalOr* handle);
static void logicalOr_react_main_region_A(LogicalOr* handle);
static void logicalOr_react_main_region__entry_Default(LogicalOr* handle);
static void logicalOr_clearInEvents(LogicalOr* handle);
static void logicalOr_clearOutEvents(LogicalOr* handle);


void logicalOr_init(LogicalOr* handle)
{
	sc_integer i;

	for (i = 0; i < LOGICALOR_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = LogicalOr_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	logicalOr_clearInEvents(handle);
	logicalOr_clearOutEvents(handle);

	/* Default init sequence for statechart LogicalOr */
	handle->iface.x = 1;
	handle->iface.b = bool_false;

}

void logicalOr_enter(LogicalOr* handle)
{
	/* Default enter sequence for statechart LogicalOr */
	logicalOr_enseq_main_region_default(handle);
}

void logicalOr_exit(LogicalOr* handle)
{
	/* Default exit sequence for statechart LogicalOr */
	logicalOr_exseq_main_region(handle);
}

sc_boolean logicalOr_isActive(const LogicalOr* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != LogicalOr_last_state)
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
sc_boolean logicalOr_isFinal(const LogicalOr* handle)
{
   return bool_false;
}

static void logicalOr_clearInEvents(LogicalOr* handle)
{
}

static void logicalOr_clearOutEvents(LogicalOr* handle)
{
}

void logicalOr_runCycle(LogicalOr* handle)
{
	
	logicalOr_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < LOGICALOR_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case LogicalOr_main_region_A :
		{
			logicalOr_react_main_region_A(handle);
			break;
		}
		default:
			break;
		}
	}
	
	logicalOr_clearInEvents(handle);
}


sc_boolean logicalOr_isStateActive(const LogicalOr* handle, LogicalOrStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case LogicalOr_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == LogicalOr_main_region_A
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}



sc_integer logicalOrIface_get_x(const LogicalOr* handle)
{
	return handle->iface.x;
}
void logicalOrIface_set_x(LogicalOr* handle, sc_integer value)
{
	handle->iface.x = value;
}
sc_boolean logicalOrIface_get_b(const LogicalOr* handle)
{
	return handle->iface.b;
}
void logicalOrIface_set_b(LogicalOr* handle, sc_boolean value)
{
	handle->iface.b = value;
}

/* implementations of all internal functions */

static sc_boolean logicalOr_check_main_region_A_tr0_tr0(const LogicalOr* handle)
{
	return (handle->iface.x == 1) ? bool_true : bool_false;
}

static void logicalOr_effect_main_region_A_tr0(LogicalOr* handle)
{
	logicalOr_exseq_main_region_A(handle);
	handle->iface.b = ((handle->iface.x += 1) != 2 || (handle->iface.x *= 2) == 4);
	logicalOr_enseq_main_region_A_default(handle);
}

/* 'default' enter sequence for state A */
static void logicalOr_enseq_main_region_A_default(LogicalOr* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = LogicalOr_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void logicalOr_enseq_main_region_default(LogicalOr* handle)
{
	/* 'default' enter sequence for region main region */
	logicalOr_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void logicalOr_exseq_main_region_A(LogicalOr* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = LogicalOr_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void logicalOr_exseq_main_region(LogicalOr* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of LogicalOr.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case LogicalOr_main_region_A :
		{
			logicalOr_exseq_main_region_A(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void logicalOr_react_main_region_A(LogicalOr* handle)
{
	/* The reactions of state A. */
	if (logicalOr_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		logicalOr_effect_main_region_A_tr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void logicalOr_react_main_region__entry_Default(LogicalOr* handle)
{
	/* Default react sequence for initial entry  */
	logicalOr_enseq_main_region_A_default(handle);
}


