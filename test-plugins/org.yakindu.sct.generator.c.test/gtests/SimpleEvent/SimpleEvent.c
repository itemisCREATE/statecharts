
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "SimpleEvent.h"
/*! \file Implementation of the state machine 'SimpleEvent'
*/

/* prototypes of all internal functions */
static sc_boolean simpleEvent_check_main_region_A_tr0_tr0(const SimpleEvent* handle);
static sc_boolean simpleEvent_check_main_region_B_tr0_tr0(const SimpleEvent* handle);
static void simpleEvent_effect_main_region_A_tr0(SimpleEvent* handle);
static void simpleEvent_effect_main_region_B_tr0(SimpleEvent* handle);
static void simpleEvent_enseq_main_region_A_default(SimpleEvent* handle);
static void simpleEvent_enseq_main_region_B_default(SimpleEvent* handle);
static void simpleEvent_enseq_main_region__final__default(SimpleEvent* handle);
static void simpleEvent_enseq_main_region_default(SimpleEvent* handle);
static void simpleEvent_exseq_main_region_A(SimpleEvent* handle);
static void simpleEvent_exseq_main_region_B(SimpleEvent* handle);
static void simpleEvent_exseq_main_region__final_(SimpleEvent* handle);
static void simpleEvent_exseq_main_region(SimpleEvent* handle);
static void simpleEvent_react_main_region_A(SimpleEvent* handle);
static void simpleEvent_react_main_region_B(SimpleEvent* handle);
static void simpleEvent_react_main_region__final_(SimpleEvent* handle);
static void simpleEvent_react_main_region__entry_Default(SimpleEvent* handle);
static void simpleEvent_clearInEvents(SimpleEvent* handle);
static void simpleEvent_clearOutEvents(SimpleEvent* handle);


void simpleEvent_init(SimpleEvent* handle)
{
	sc_integer i;

	for (i = 0; i < SIMPLEEVENT_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = SimpleEvent_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	simpleEvent_clearInEvents(handle);
	simpleEvent_clearOutEvents(handle);


}

void simpleEvent_enter(SimpleEvent* handle)
{
	/* Default enter sequence for statechart SimpleEvent */
	simpleEvent_enseq_main_region_default(handle);
}

void simpleEvent_exit(SimpleEvent* handle)
{
	/* Default exit sequence for statechart SimpleEvent */
	simpleEvent_exseq_main_region(handle);
}

sc_boolean simpleEvent_isActive(const SimpleEvent* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < SIMPLEEVENT_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != SimpleEvent_last_state;
	}
	
	return result;
}

sc_boolean simpleEvent_isFinal(const SimpleEvent* handle)
{
	return (handle->stateConfVector[0] == SimpleEvent_main_region__final_);

}

static void simpleEvent_clearInEvents(SimpleEvent* handle)
{
	handle->iface.Event1_raised = bool_false;
}

static void simpleEvent_clearOutEvents(SimpleEvent* handle)
{
}

void simpleEvent_runCycle(SimpleEvent* handle)
{
	
	simpleEvent_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < SIMPLEEVENT_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case SimpleEvent_main_region_A :
		{
			simpleEvent_react_main_region_A(handle);
			break;
		}
		case SimpleEvent_main_region_B :
		{
			simpleEvent_react_main_region_B(handle);
			break;
		}
		case SimpleEvent_main_region__final_ :
		{
			simpleEvent_react_main_region__final_(handle);
			break;
		}
		default:
			break;
		}
	}
	
	simpleEvent_clearInEvents(handle);
}


sc_boolean simpleEvent_isStateActive(const SimpleEvent* handle, SimpleEventStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case SimpleEvent_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_SIMPLEEVENT_MAIN_REGION_A] == SimpleEvent_main_region_A
			);
			break;
		case SimpleEvent_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_SIMPLEEVENT_MAIN_REGION_B] == SimpleEvent_main_region_B
			);
			break;
		case SimpleEvent_main_region__final_ :
			result = (sc_boolean) (handle->stateConfVector[SCVI_SIMPLEEVENT_MAIN_REGION__FINAL_] == SimpleEvent_main_region__final_
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void simpleEventIface_raise_event1(SimpleEvent* handle)
{
	handle->iface.Event1_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean simpleEvent_check_main_region_A_tr0_tr0(const SimpleEvent* handle)
{
	return handle->iface.Event1_raised;
}

static sc_boolean simpleEvent_check_main_region_B_tr0_tr0(const SimpleEvent* handle)
{
	return bool_true;
}

static void simpleEvent_effect_main_region_A_tr0(SimpleEvent* handle)
{
	simpleEvent_exseq_main_region_A(handle);
	simpleEvent_enseq_main_region_B_default(handle);
}

static void simpleEvent_effect_main_region_B_tr0(SimpleEvent* handle)
{
	simpleEvent_exseq_main_region_B(handle);
	simpleEvent_enseq_main_region__final__default(handle);
}

/* 'default' enter sequence for state A */
static void simpleEvent_enseq_main_region_A_default(SimpleEvent* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = SimpleEvent_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void simpleEvent_enseq_main_region_B_default(SimpleEvent* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = SimpleEvent_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* Default enter sequence for state null */
static void simpleEvent_enseq_main_region__final__default(SimpleEvent* handle)
{
	/* Default enter sequence for state null */
	handle->stateConfVector[0] = SimpleEvent_main_region__final_;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void simpleEvent_enseq_main_region_default(SimpleEvent* handle)
{
	/* 'default' enter sequence for region main region */
	simpleEvent_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void simpleEvent_exseq_main_region_A(SimpleEvent* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = SimpleEvent_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void simpleEvent_exseq_main_region_B(SimpleEvent* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = SimpleEvent_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for final state. */
static void simpleEvent_exseq_main_region__final_(SimpleEvent* handle)
{
	/* Default exit sequence for final state. */
	handle->stateConfVector[0] = SimpleEvent_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void simpleEvent_exseq_main_region(SimpleEvent* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of SimpleEvent.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case SimpleEvent_main_region_A :
		{
			simpleEvent_exseq_main_region_A(handle);
			break;
		}
		case SimpleEvent_main_region_B :
		{
			simpleEvent_exseq_main_region_B(handle);
			break;
		}
		case SimpleEvent_main_region__final_ :
		{
			simpleEvent_exseq_main_region__final_(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void simpleEvent_react_main_region_A(SimpleEvent* handle)
{
	/* The reactions of state A. */
	if (simpleEvent_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		simpleEvent_effect_main_region_A_tr0(handle);
	} 
}

/* The reactions of state B. */
static void simpleEvent_react_main_region_B(SimpleEvent* handle)
{
	/* The reactions of state B. */
	simpleEvent_effect_main_region_B_tr0(handle);
}

/* The reactions of state null. */
static void simpleEvent_react_main_region__final_(SimpleEvent* handle)
{
	/* The reactions of state null. */
}

/* Default react sequence for initial entry  */
static void simpleEvent_react_main_region__entry_Default(SimpleEvent* handle)
{
	/* Default react sequence for initial entry  */
	simpleEvent_enseq_main_region_A_default(handle);
}


