
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "NamedInterfaceAccess.h"
/*! \file Implementation of the state machine 'NamedInterfaceAccess'
*/

/* prototypes of all internal functions */
static sc_boolean namedInterfaceAccess_check_region_1_Idle_tr0_tr0(const NamedInterfaceAccess* handle);
static sc_boolean namedInterfaceAccess_check_region_1_Number1Pressed_tr0_tr0(const NamedInterfaceAccess* handle);
static sc_boolean namedInterfaceAccess_check_region_1_Number1Pressed_tr1_tr1(const NamedInterfaceAccess* handle);
static sc_boolean namedInterfaceAccess_check_region_1_Number2Pressed_tr0_tr0(const NamedInterfaceAccess* handle);
static sc_boolean namedInterfaceAccess_check_region_1_Number2Pressed_tr1_tr1(const NamedInterfaceAccess* handle);
static sc_boolean namedInterfaceAccess_check_region_1_Number3Pressed_tr0_tr0(const NamedInterfaceAccess* handle);
static sc_boolean namedInterfaceAccess_check__region1_Closed_tr0_tr0(const NamedInterfaceAccess* handle);
static sc_boolean namedInterfaceAccess_check__region1_Open_tr0_tr0(const NamedInterfaceAccess* handle);
static void namedInterfaceAccess_effect_region_1_Idle_tr0(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_effect_region_1_Number1Pressed_tr0(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_effect_region_1_Number1Pressed_tr1(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_effect_region_1_Number2Pressed_tr0(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_effect_region_1_Number2Pressed_tr1(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_effect_region_1_Number3Pressed_tr0(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_effect__region1_Closed_tr0(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_effect__region1_Open_tr0(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_enact_region_1_Idle(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_enact_region_1_Number3Pressed(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_enseq_region_1_Idle_default(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_enseq_region_1_Number1Pressed_default(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_enseq_region_1_Number2Pressed_default(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_enseq_region_1_Number3Pressed_default(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_enseq__region1_Closed_default(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_enseq__region1_Open_default(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_enseq_region_1_default(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_enseq__region1_default(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_exseq_region_1_Idle(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_exseq_region_1_Number1Pressed(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_exseq_region_1_Number2Pressed(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_exseq_region_1_Number3Pressed(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_exseq__region1_Closed(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_exseq__region1_Open(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_exseq_region_1(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_exseq__region1(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_react_region_1_Idle(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_react_region_1_Number1Pressed(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_react_region_1_Number2Pressed(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_react_region_1_Number3Pressed(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_react__region1_Closed(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_react__region1_Open(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_react_region_1__entry_Default(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_react__region1__entry_Default(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_clearInEvents(NamedInterfaceAccess* handle);
static void namedInterfaceAccess_clearOutEvents(NamedInterfaceAccess* handle);


void namedInterfaceAccess_init(NamedInterfaceAccess* handle)
{
	sc_integer i;

	for (i = 0; i < NAMEDINTERFACEACCESS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = NamedInterfaceAccess_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	namedInterfaceAccess_clearInEvents(handle);
	namedInterfaceAccess_clearOutEvents(handle);

	/* Default init sequence for statechart NamedInterfaceAccess */
	handle->internal.number1 = 3;
	handle->internal.number2 = 7;
	handle->internal.number3 = 5;

}

void namedInterfaceAccess_enter(NamedInterfaceAccess* handle)
{
	/* Default enter sequence for statechart NamedInterfaceAccess */
	namedInterfaceAccess_enseq_region_1_default(handle);
	namedInterfaceAccess_enseq__region1_default(handle);
}

void namedInterfaceAccess_exit(NamedInterfaceAccess* handle)
{
	/* Default exit sequence for statechart NamedInterfaceAccess */
	namedInterfaceAccess_exseq_region_1(handle);
	namedInterfaceAccess_exseq__region1(handle);
}

sc_boolean namedInterfaceAccess_isActive(const NamedInterfaceAccess* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < NAMEDINTERFACEACCESS_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != NamedInterfaceAccess_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean namedInterfaceAccess_isFinal(const NamedInterfaceAccess* handle)
{
   return bool_false;
}

static void namedInterfaceAccess_clearInEvents(NamedInterfaceAccess* handle)
{
	handle->ifaceUser.numberPressed_raised = bool_false;
	handle->ifaceUser.reset_raised = bool_false;
}

static void namedInterfaceAccess_clearOutEvents(NamedInterfaceAccess* handle)
{
	handle->ifaceSafe.open_raised = bool_false;
	handle->ifaceSafe.close_raised = bool_false;
}

void namedInterfaceAccess_runCycle(NamedInterfaceAccess* handle)
{
	
	namedInterfaceAccess_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < NAMEDINTERFACEACCESS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case NamedInterfaceAccess_region_1_Idle :
		{
			namedInterfaceAccess_react_region_1_Idle(handle);
			break;
		}
		case NamedInterfaceAccess_region_1_Number1Pressed :
		{
			namedInterfaceAccess_react_region_1_Number1Pressed(handle);
			break;
		}
		case NamedInterfaceAccess_region_1_Number2Pressed :
		{
			namedInterfaceAccess_react_region_1_Number2Pressed(handle);
			break;
		}
		case NamedInterfaceAccess_region_1_Number3Pressed :
		{
			namedInterfaceAccess_react_region_1_Number3Pressed(handle);
			break;
		}
		case NamedInterfaceAccess__region1_Closed :
		{
			namedInterfaceAccess_react__region1_Closed(handle);
			break;
		}
		case NamedInterfaceAccess__region1_Open :
		{
			namedInterfaceAccess_react__region1_Open(handle);
			break;
		}
		default:
			break;
		}
	}
	
	namedInterfaceAccess_clearInEvents(handle);
}


sc_boolean namedInterfaceAccess_isStateActive(const NamedInterfaceAccess* handle, NamedInterfaceAccessStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case NamedInterfaceAccess_region_1_Idle :
			result = (sc_boolean) (handle->stateConfVector[SCVI_NAMEDINTERFACEACCESS_REGION_1_IDLE] == NamedInterfaceAccess_region_1_Idle
			);
			break;
		case NamedInterfaceAccess_region_1_Number1Pressed :
			result = (sc_boolean) (handle->stateConfVector[SCVI_NAMEDINTERFACEACCESS_REGION_1_NUMBER1PRESSED] == NamedInterfaceAccess_region_1_Number1Pressed
			);
			break;
		case NamedInterfaceAccess_region_1_Number2Pressed :
			result = (sc_boolean) (handle->stateConfVector[SCVI_NAMEDINTERFACEACCESS_REGION_1_NUMBER2PRESSED] == NamedInterfaceAccess_region_1_Number2Pressed
			);
			break;
		case NamedInterfaceAccess_region_1_Number3Pressed :
			result = (sc_boolean) (handle->stateConfVector[SCVI_NAMEDINTERFACEACCESS_REGION_1_NUMBER3PRESSED] == NamedInterfaceAccess_region_1_Number3Pressed
			);
			break;
		case NamedInterfaceAccess__region1_Closed :
			result = (sc_boolean) (handle->stateConfVector[SCVI_NAMEDINTERFACEACCESS__REGION1_CLOSED] == NamedInterfaceAccess__region1_Closed
			);
			break;
		case NamedInterfaceAccess__region1_Open :
			result = (sc_boolean) (handle->stateConfVector[SCVI_NAMEDINTERFACEACCESS__REGION1_OPEN] == NamedInterfaceAccess__region1_Open
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}


sc_boolean namedInterfaceAccessIfaceSafe_israised_open(const NamedInterfaceAccess* handle)
{
	return handle->ifaceSafe.open_raised;
}
sc_boolean namedInterfaceAccessIfaceSafe_israised_close(const NamedInterfaceAccess* handle)
{
	return handle->ifaceSafe.close_raised;
}

void namedInterfaceAccessIfaceUser_raise_numberPressed(NamedInterfaceAccess* handle, sc_integer value)
{
	handle->ifaceUser.numberPressed_value = value;
	handle->ifaceUser.numberPressed_raised = bool_true;
}
void namedInterfaceAccessIfaceUser_raise_reset(NamedInterfaceAccess* handle)
{
	handle->ifaceUser.reset_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean namedInterfaceAccess_check_region_1_Idle_tr0_tr0(const NamedInterfaceAccess* handle)
{
	return ((handle->ifaceUser.numberPressed_raised) && (handle->ifaceUser.numberPressed_value == handle->internal.number1)) ? bool_true : bool_false;
}

static sc_boolean namedInterfaceAccess_check_region_1_Number1Pressed_tr0_tr0(const NamedInterfaceAccess* handle)
{
	return ((handle->ifaceUser.numberPressed_raised) && (handle->ifaceUser.numberPressed_value == handle->internal.number2)) ? bool_true : bool_false;
}

static sc_boolean namedInterfaceAccess_check_region_1_Number1Pressed_tr1_tr1(const NamedInterfaceAccess* handle)
{
	return handle->ifaceUser.numberPressed_raised;
}

static sc_boolean namedInterfaceAccess_check_region_1_Number2Pressed_tr0_tr0(const NamedInterfaceAccess* handle)
{
	return ((handle->ifaceUser.numberPressed_raised) && (handle->ifaceUser.numberPressed_value == handle->internal.number3)) ? bool_true : bool_false;
}

static sc_boolean namedInterfaceAccess_check_region_1_Number2Pressed_tr1_tr1(const NamedInterfaceAccess* handle)
{
	return handle->ifaceUser.numberPressed_raised;
}

static sc_boolean namedInterfaceAccess_check_region_1_Number3Pressed_tr0_tr0(const NamedInterfaceAccess* handle)
{
	return handle->ifaceUser.numberPressed_raised;
}

static sc_boolean namedInterfaceAccess_check__region1_Closed_tr0_tr0(const NamedInterfaceAccess* handle)
{
	return handle->ifaceSafe.open_raised;
}

static sc_boolean namedInterfaceAccess_check__region1_Open_tr0_tr0(const NamedInterfaceAccess* handle)
{
	return handle->ifaceSafe.close_raised;
}

static void namedInterfaceAccess_effect_region_1_Idle_tr0(NamedInterfaceAccess* handle)
{
	namedInterfaceAccess_exseq_region_1_Idle(handle);
	namedInterfaceAccess_enseq_region_1_Number1Pressed_default(handle);
}

static void namedInterfaceAccess_effect_region_1_Number1Pressed_tr0(NamedInterfaceAccess* handle)
{
	namedInterfaceAccess_exseq_region_1_Number1Pressed(handle);
	namedInterfaceAccess_enseq_region_1_Number2Pressed_default(handle);
}

static void namedInterfaceAccess_effect_region_1_Number1Pressed_tr1(NamedInterfaceAccess* handle)
{
	namedInterfaceAccess_exseq_region_1_Number1Pressed(handle);
	namedInterfaceAccess_enseq_region_1_Idle_default(handle);
}

static void namedInterfaceAccess_effect_region_1_Number2Pressed_tr0(NamedInterfaceAccess* handle)
{
	namedInterfaceAccess_exseq_region_1_Number2Pressed(handle);
	namedInterfaceAccess_enseq_region_1_Number3Pressed_default(handle);
}

static void namedInterfaceAccess_effect_region_1_Number2Pressed_tr1(NamedInterfaceAccess* handle)
{
	namedInterfaceAccess_exseq_region_1_Number2Pressed(handle);
	namedInterfaceAccess_enseq_region_1_Idle_default(handle);
}

static void namedInterfaceAccess_effect_region_1_Number3Pressed_tr0(NamedInterfaceAccess* handle)
{
	namedInterfaceAccess_exseq_region_1_Number3Pressed(handle);
	namedInterfaceAccess_enseq_region_1_Idle_default(handle);
}

static void namedInterfaceAccess_effect__region1_Closed_tr0(NamedInterfaceAccess* handle)
{
	namedInterfaceAccess_exseq__region1_Closed(handle);
	namedInterfaceAccess_enseq__region1_Open_default(handle);
}

static void namedInterfaceAccess_effect__region1_Open_tr0(NamedInterfaceAccess* handle)
{
	namedInterfaceAccess_exseq__region1_Open(handle);
	namedInterfaceAccess_enseq__region1_Closed_default(handle);
}

/* Entry action for state 'Idle'. */
static void namedInterfaceAccess_enact_region_1_Idle(NamedInterfaceAccess* handle)
{
	/* Entry action for state 'Idle'. */
	handle->ifaceSafe.close_raised = bool_true;
}

/* Entry action for state 'Number3Pressed'. */
static void namedInterfaceAccess_enact_region_1_Number3Pressed(NamedInterfaceAccess* handle)
{
	/* Entry action for state 'Number3Pressed'. */
	handle->ifaceSafe.open_raised = bool_true;
}

/* 'default' enter sequence for state Idle */
static void namedInterfaceAccess_enseq_region_1_Idle_default(NamedInterfaceAccess* handle)
{
	/* 'default' enter sequence for state Idle */
	namedInterfaceAccess_enact_region_1_Idle(handle);
	handle->stateConfVector[0] = NamedInterfaceAccess_region_1_Idle;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Number1Pressed */
static void namedInterfaceAccess_enseq_region_1_Number1Pressed_default(NamedInterfaceAccess* handle)
{
	/* 'default' enter sequence for state Number1Pressed */
	handle->stateConfVector[0] = NamedInterfaceAccess_region_1_Number1Pressed;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Number2Pressed */
static void namedInterfaceAccess_enseq_region_1_Number2Pressed_default(NamedInterfaceAccess* handle)
{
	/* 'default' enter sequence for state Number2Pressed */
	handle->stateConfVector[0] = NamedInterfaceAccess_region_1_Number2Pressed;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Number3Pressed */
static void namedInterfaceAccess_enseq_region_1_Number3Pressed_default(NamedInterfaceAccess* handle)
{
	/* 'default' enter sequence for state Number3Pressed */
	namedInterfaceAccess_enact_region_1_Number3Pressed(handle);
	handle->stateConfVector[0] = NamedInterfaceAccess_region_1_Number3Pressed;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Closed */
static void namedInterfaceAccess_enseq__region1_Closed_default(NamedInterfaceAccess* handle)
{
	/* 'default' enter sequence for state Closed */
	handle->stateConfVector[1] = NamedInterfaceAccess__region1_Closed;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state Open */
static void namedInterfaceAccess_enseq__region1_Open_default(NamedInterfaceAccess* handle)
{
	/* 'default' enter sequence for state Open */
	handle->stateConfVector[1] = NamedInterfaceAccess__region1_Open;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region region 1 */
static void namedInterfaceAccess_enseq_region_1_default(NamedInterfaceAccess* handle)
{
	/* 'default' enter sequence for region region 1 */
	namedInterfaceAccess_react_region_1__entry_Default(handle);
}

/* 'default' enter sequence for region null */
static void namedInterfaceAccess_enseq__region1_default(NamedInterfaceAccess* handle)
{
	/* 'default' enter sequence for region null */
	namedInterfaceAccess_react__region1__entry_Default(handle);
}

/* Default exit sequence for state Idle */
static void namedInterfaceAccess_exseq_region_1_Idle(NamedInterfaceAccess* handle)
{
	/* Default exit sequence for state Idle */
	handle->stateConfVector[0] = NamedInterfaceAccess_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state Number1Pressed */
static void namedInterfaceAccess_exseq_region_1_Number1Pressed(NamedInterfaceAccess* handle)
{
	/* Default exit sequence for state Number1Pressed */
	handle->stateConfVector[0] = NamedInterfaceAccess_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state Number2Pressed */
static void namedInterfaceAccess_exseq_region_1_Number2Pressed(NamedInterfaceAccess* handle)
{
	/* Default exit sequence for state Number2Pressed */
	handle->stateConfVector[0] = NamedInterfaceAccess_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state Number3Pressed */
static void namedInterfaceAccess_exseq_region_1_Number3Pressed(NamedInterfaceAccess* handle)
{
	/* Default exit sequence for state Number3Pressed */
	handle->stateConfVector[0] = NamedInterfaceAccess_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state Closed */
static void namedInterfaceAccess_exseq__region1_Closed(NamedInterfaceAccess* handle)
{
	/* Default exit sequence for state Closed */
	handle->stateConfVector[1] = NamedInterfaceAccess_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state Open */
static void namedInterfaceAccess_exseq__region1_Open(NamedInterfaceAccess* handle)
{
	/* Default exit sequence for state Open */
	handle->stateConfVector[1] = NamedInterfaceAccess_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for region region 1 */
static void namedInterfaceAccess_exseq_region_1(NamedInterfaceAccess* handle)
{
	/* Default exit sequence for region region 1 */
	/* Handle exit of all possible states (of NamedInterfaceAccess.region_1) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case NamedInterfaceAccess_region_1_Idle :
		{
			namedInterfaceAccess_exseq_region_1_Idle(handle);
			break;
		}
		case NamedInterfaceAccess_region_1_Number1Pressed :
		{
			namedInterfaceAccess_exseq_region_1_Number1Pressed(handle);
			break;
		}
		case NamedInterfaceAccess_region_1_Number2Pressed :
		{
			namedInterfaceAccess_exseq_region_1_Number2Pressed(handle);
			break;
		}
		case NamedInterfaceAccess_region_1_Number3Pressed :
		{
			namedInterfaceAccess_exseq_region_1_Number3Pressed(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
static void namedInterfaceAccess_exseq__region1(NamedInterfaceAccess* handle)
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of NamedInterfaceAccess._region1) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case NamedInterfaceAccess__region1_Closed :
		{
			namedInterfaceAccess_exseq__region1_Closed(handle);
			break;
		}
		case NamedInterfaceAccess__region1_Open :
		{
			namedInterfaceAccess_exseq__region1_Open(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state Idle. */
static void namedInterfaceAccess_react_region_1_Idle(NamedInterfaceAccess* handle)
{
	/* The reactions of state Idle. */
	if (namedInterfaceAccess_check_region_1_Idle_tr0_tr0(handle) == bool_true)
	{ 
		namedInterfaceAccess_effect_region_1_Idle_tr0(handle);
	} 
}

/* The reactions of state Number1Pressed. */
static void namedInterfaceAccess_react_region_1_Number1Pressed(NamedInterfaceAccess* handle)
{
	/* The reactions of state Number1Pressed. */
	if (namedInterfaceAccess_check_region_1_Number1Pressed_tr0_tr0(handle) == bool_true)
	{ 
		namedInterfaceAccess_effect_region_1_Number1Pressed_tr0(handle);
	}  else
	{
		if (namedInterfaceAccess_check_region_1_Number1Pressed_tr1_tr1(handle) == bool_true)
		{ 
			namedInterfaceAccess_effect_region_1_Number1Pressed_tr1(handle);
		} 
	}
}

/* The reactions of state Number2Pressed. */
static void namedInterfaceAccess_react_region_1_Number2Pressed(NamedInterfaceAccess* handle)
{
	/* The reactions of state Number2Pressed. */
	if (namedInterfaceAccess_check_region_1_Number2Pressed_tr0_tr0(handle) == bool_true)
	{ 
		namedInterfaceAccess_effect_region_1_Number2Pressed_tr0(handle);
	}  else
	{
		if (namedInterfaceAccess_check_region_1_Number2Pressed_tr1_tr1(handle) == bool_true)
		{ 
			namedInterfaceAccess_effect_region_1_Number2Pressed_tr1(handle);
		} 
	}
}

/* The reactions of state Number3Pressed. */
static void namedInterfaceAccess_react_region_1_Number3Pressed(NamedInterfaceAccess* handle)
{
	/* The reactions of state Number3Pressed. */
	if (namedInterfaceAccess_check_region_1_Number3Pressed_tr0_tr0(handle) == bool_true)
	{ 
		namedInterfaceAccess_effect_region_1_Number3Pressed_tr0(handle);
	} 
}

/* The reactions of state Closed. */
static void namedInterfaceAccess_react__region1_Closed(NamedInterfaceAccess* handle)
{
	/* The reactions of state Closed. */
	if (namedInterfaceAccess_check__region1_Closed_tr0_tr0(handle) == bool_true)
	{ 
		namedInterfaceAccess_effect__region1_Closed_tr0(handle);
	} 
}

/* The reactions of state Open. */
static void namedInterfaceAccess_react__region1_Open(NamedInterfaceAccess* handle)
{
	/* The reactions of state Open. */
	if (namedInterfaceAccess_check__region1_Open_tr0_tr0(handle) == bool_true)
	{ 
		namedInterfaceAccess_effect__region1_Open_tr0(handle);
	} 
}

/* Default react sequence for initial entry  */
static void namedInterfaceAccess_react_region_1__entry_Default(NamedInterfaceAccess* handle)
{
	/* Default react sequence for initial entry  */
	namedInterfaceAccess_enseq_region_1_Idle_default(handle);
}

/* Default react sequence for initial entry  */
static void namedInterfaceAccess_react__region1__entry_Default(NamedInterfaceAccess* handle)
{
	/* Default react sequence for initial entry  */
	namedInterfaceAccess_enseq__region1_Closed_default(handle);
}


