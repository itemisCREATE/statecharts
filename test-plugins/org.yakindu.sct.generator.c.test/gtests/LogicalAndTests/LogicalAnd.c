
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "LogicalAnd.h"
/*! \file Implementation of the state machine 'LogicalAnd'
*/

/* prototypes of all internal functions */
static sc_boolean logicalAnd_check_main_region_A_tr0_tr0(const LogicalAnd* handle);
static void logicalAnd_effect_main_region_A_tr0(LogicalAnd* handle);
static void logicalAnd_enseq_main_region_A_default(LogicalAnd* handle);
static void logicalAnd_enseq_main_region_default(LogicalAnd* handle);
static void logicalAnd_exseq_main_region_A(LogicalAnd* handle);
static void logicalAnd_exseq_main_region(LogicalAnd* handle);
static void logicalAnd_react_main_region_A(LogicalAnd* handle);
static void logicalAnd_react_main_region__entry_Default(LogicalAnd* handle);
static void logicalAnd_clearInEvents(LogicalAnd* handle);
static void logicalAnd_clearOutEvents(LogicalAnd* handle);


void logicalAnd_init(LogicalAnd* handle)
{
	sc_integer i;

	for (i = 0; i < LOGICALAND_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = LogicalAnd_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	logicalAnd_clearInEvents(handle);
	logicalAnd_clearOutEvents(handle);

	/* Default init sequence for statechart LogicalAnd */
	handle->iface.x = 1;
	handle->iface.b = bool_false;

}

void logicalAnd_enter(LogicalAnd* handle)
{
	/* Default enter sequence for statechart LogicalAnd */
	logicalAnd_enseq_main_region_default(handle);
}

void logicalAnd_exit(LogicalAnd* handle)
{
	/* Default exit sequence for statechart LogicalAnd */
	logicalAnd_exseq_main_region(handle);
}

sc_boolean logicalAnd_isActive(const LogicalAnd* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != LogicalAnd_last_state)
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
sc_boolean logicalAnd_isFinal(const LogicalAnd* handle)
{
   return bool_false;
}

static void logicalAnd_clearInEvents(LogicalAnd* handle)
{
}

static void logicalAnd_clearOutEvents(LogicalAnd* handle)
{
}

void logicalAnd_runCycle(LogicalAnd* handle)
{
	
	logicalAnd_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < LOGICALAND_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case LogicalAnd_main_region_A :
		{
			logicalAnd_react_main_region_A(handle);
			break;
		}
		default:
			break;
		}
	}
	
	logicalAnd_clearInEvents(handle);
}


sc_boolean logicalAnd_isStateActive(const LogicalAnd* handle, LogicalAndStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case LogicalAnd_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == LogicalAnd_main_region_A
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}



sc_integer logicalAndIface_get_x(const LogicalAnd* handle)
{
	return handle->iface.x;
}
void logicalAndIface_set_x(LogicalAnd* handle, sc_integer value)
{
	handle->iface.x = value;
}
sc_boolean logicalAndIface_get_b(const LogicalAnd* handle)
{
	return handle->iface.b;
}
void logicalAndIface_set_b(LogicalAnd* handle, sc_boolean value)
{
	handle->iface.b = value;
}

/* implementations of all internal functions */

static sc_boolean logicalAnd_check_main_region_A_tr0_tr0(const LogicalAnd* handle)
{
	return (handle->iface.x == 1) ? bool_true : bool_false;
}

static void logicalAnd_effect_main_region_A_tr0(LogicalAnd* handle)
{
	logicalAnd_exseq_main_region_A(handle);
	handle->iface.b = ((handle->iface.x += 1) == 2 && (handle->iface.x *= 2) == 4);
	logicalAnd_enseq_main_region_A_default(handle);
}

/* 'default' enter sequence for state A */
static void logicalAnd_enseq_main_region_A_default(LogicalAnd* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = LogicalAnd_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void logicalAnd_enseq_main_region_default(LogicalAnd* handle)
{
	/* 'default' enter sequence for region main region */
	logicalAnd_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void logicalAnd_exseq_main_region_A(LogicalAnd* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = LogicalAnd_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void logicalAnd_exseq_main_region(LogicalAnd* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of LogicalAnd.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case LogicalAnd_main_region_A :
		{
			logicalAnd_exseq_main_region_A(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void logicalAnd_react_main_region_A(LogicalAnd* handle)
{
	/* The reactions of state A. */
	if (logicalAnd_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		logicalAnd_effect_main_region_A_tr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void logicalAnd_react_main_region__entry_Default(LogicalAnd* handle)
{
	/* Default react sequence for initial entry  */
	logicalAnd_enseq_main_region_A_default(handle);
}


