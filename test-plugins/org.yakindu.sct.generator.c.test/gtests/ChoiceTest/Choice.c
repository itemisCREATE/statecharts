
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "Choice.h"
/*! \file Implementation of the state machine 'Choice'
*/

/* prototypes of all internal functions */
static sc_boolean choice_check_main_region_A_tr0_tr0(const Choice* handle);
static sc_boolean choice_check_main_region_A_tr1_tr1(const Choice* handle);
static sc_boolean choice_check_main_region_A_tr2_tr2(const Choice* handle);
static sc_boolean choice_check_main_region_A_tr3_tr3(const Choice* handle);
static sc_boolean choice_check_main_region_B_tr0_tr0(const Choice* handle);
static sc_boolean choice_check_main_region_C_tr0_tr0(const Choice* handle);
static sc_boolean choice_check_main_region__choice_0_tr1_tr1(const Choice* handle);
static sc_boolean choice_check_main_region__choice_0_tr0_tr0(const Choice* handle);
static sc_boolean choice_check_main_region__choice_1_tr0_tr0(const Choice* handle);
static sc_boolean choice_check_main_region__choice_1_tr1_tr1(const Choice* handle);
static sc_boolean choice_check_main_region__choice_2_tr1_tr1(const Choice* handle);
static sc_boolean choice_check_main_region__choice_2_tr0(const Choice* handle);
static sc_boolean choice_check_main_region__choice_3_tr1_tr1(const Choice* handle);
static sc_boolean choice_check_main_region__choice_3_tr0_tr0(const Choice* handle);
static void choice_effect_main_region_A_tr0(Choice* handle);
static void choice_effect_main_region_A_tr1(Choice* handle);
static void choice_effect_main_region_A_tr2(Choice* handle);
static void choice_effect_main_region_A_tr3(Choice* handle);
static void choice_effect_main_region_B_tr0(Choice* handle);
static void choice_effect_main_region_C_tr0(Choice* handle);
static void choice_effect_main_region__choice_0_tr1(Choice* handle);
static void choice_effect_main_region__choice_0_tr0(Choice* handle);
static void choice_effect_main_region__choice_1_tr0(Choice* handle);
static void choice_effect_main_region__choice_1_tr1(Choice* handle);
static void choice_effect_main_region__choice_2_tr1(Choice* handle);
static void choice_effect_main_region__choice_2_tr0(Choice* handle);
static void choice_effect_main_region__choice_3_tr1(Choice* handle);
static void choice_effect_main_region__choice_3_tr0(Choice* handle);
static void choice_enseq_main_region_A_default(Choice* handle);
static void choice_enseq_main_region_B_default(Choice* handle);
static void choice_enseq_main_region_C_default(Choice* handle);
static void choice_enseq_main_region_default(Choice* handle);
static void choice_exseq_main_region_A(Choice* handle);
static void choice_exseq_main_region_B(Choice* handle);
static void choice_exseq_main_region_C(Choice* handle);
static void choice_exseq_main_region(Choice* handle);
static void choice_react_main_region_A(Choice* handle);
static void choice_react_main_region_B(Choice* handle);
static void choice_react_main_region_C(Choice* handle);
static void choice_react_main_region__choice_0(Choice* handle);
static void choice_react_main_region__choice_1(Choice* handle);
static void choice_react_main_region__choice_2(Choice* handle);
static void choice_react_main_region__choice_3(Choice* handle);
static void choice_react_main_region__entry_Default(Choice* handle);
static void choice_clearInEvents(Choice* handle);
static void choice_clearOutEvents(Choice* handle);


void choice_init(Choice* handle)
{
	sc_integer i;

	for (i = 0; i < CHOICE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = Choice_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	choice_clearInEvents(handle);
	choice_clearOutEvents(handle);

	/* Default init sequence for statechart Choice */
	handle->iface.c = bool_false;

}

void choice_enter(Choice* handle)
{
	/* Default enter sequence for statechart Choice */
	choice_enseq_main_region_default(handle);
}

void choice_exit(Choice* handle)
{
	/* Default exit sequence for statechart Choice */
	choice_exseq_main_region(handle);
}

sc_boolean choice_isActive(const Choice* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != Choice_last_state)
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
sc_boolean choice_isFinal(const Choice* handle)
{
   return bool_false;
}

static void choice_clearInEvents(Choice* handle)
{
	handle->iface.e_raised = bool_false;
	handle->iface.f_raised = bool_false;
	handle->iface.g_raised = bool_false;
	handle->iface.h_raised = bool_false;
}

static void choice_clearOutEvents(Choice* handle)
{
}

void choice_runCycle(Choice* handle)
{
	
	choice_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < CHOICE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case Choice_main_region_A :
		{
			choice_react_main_region_A(handle);
			break;
		}
		case Choice_main_region_B :
		{
			choice_react_main_region_B(handle);
			break;
		}
		case Choice_main_region_C :
		{
			choice_react_main_region_C(handle);
			break;
		}
		default:
			break;
		}
	}
	
	choice_clearInEvents(handle);
}


sc_boolean choice_isStateActive(const Choice* handle, ChoiceStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case Choice_main_region_A :
			result = (sc_boolean) (handle->stateConfVector[0] == Choice_main_region_A
			);
			break;
		case Choice_main_region_B :
			result = (sc_boolean) (handle->stateConfVector[0] == Choice_main_region_B
			);
			break;
		case Choice_main_region_C :
			result = (sc_boolean) (handle->stateConfVector[0] == Choice_main_region_C
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void choiceIface_raise_e(Choice* handle)
{
	handle->iface.e_raised = bool_true;
}
void choiceIface_raise_f(Choice* handle)
{
	handle->iface.f_raised = bool_true;
}
void choiceIface_raise_g(Choice* handle)
{
	handle->iface.g_raised = bool_true;
}
void choiceIface_raise_h(Choice* handle)
{
	handle->iface.h_raised = bool_true;
}


sc_boolean choiceIface_get_c(const Choice* handle)
{
	return handle->iface.c;
}
void choiceIface_set_c(Choice* handle, sc_boolean value)
{
	handle->iface.c = value;
}

/* implementations of all internal functions */

static sc_boolean choice_check_main_region_A_tr0_tr0(const Choice* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean choice_check_main_region_A_tr1_tr1(const Choice* handle)
{
	return handle->iface.f_raised;
}

static sc_boolean choice_check_main_region_A_tr2_tr2(const Choice* handle)
{
	return handle->iface.g_raised;
}

static sc_boolean choice_check_main_region_A_tr3_tr3(const Choice* handle)
{
	return handle->iface.h_raised;
}

static sc_boolean choice_check_main_region_B_tr0_tr0(const Choice* handle)
{
	return bool_true;
}

static sc_boolean choice_check_main_region_C_tr0_tr0(const Choice* handle)
{
	return bool_true;
}

static sc_boolean choice_check_main_region__choice_0_tr1_tr1(const Choice* handle)
{
	return handle->iface.c;
}

static sc_boolean choice_check_main_region__choice_0_tr0_tr0(const Choice* handle)
{
	return bool_true;
}

static sc_boolean choice_check_main_region__choice_1_tr0_tr0(const Choice* handle)
{
	return handle->iface.c;
}

static sc_boolean choice_check_main_region__choice_1_tr1_tr1(const Choice* handle)
{
	return bool_true;
}

static sc_boolean choice_check_main_region__choice_2_tr1_tr1(const Choice* handle)
{
	return handle->iface.c;
}

static sc_boolean choice_check_main_region__choice_2_tr0(const Choice* handle)
{
	return bool_true;
}

static sc_boolean choice_check_main_region__choice_3_tr1_tr1(const Choice* handle)
{
	return handle->iface.c;
}

static sc_boolean choice_check_main_region__choice_3_tr0_tr0(const Choice* handle)
{
	return bool_true;
}

static void choice_effect_main_region_A_tr0(Choice* handle)
{
	choice_exseq_main_region_A(handle);
	choice_react_main_region__choice_0(handle);
}

static void choice_effect_main_region_A_tr1(Choice* handle)
{
	choice_exseq_main_region_A(handle);
	choice_react_main_region__choice_2(handle);
}

static void choice_effect_main_region_A_tr2(Choice* handle)
{
	choice_exseq_main_region_A(handle);
	choice_react_main_region__choice_1(handle);
}

static void choice_effect_main_region_A_tr3(Choice* handle)
{
	choice_exseq_main_region_A(handle);
	choice_react_main_region__choice_3(handle);
}

static void choice_effect_main_region_B_tr0(Choice* handle)
{
	choice_exseq_main_region_B(handle);
	choice_enseq_main_region_A_default(handle);
}

static void choice_effect_main_region_C_tr0(Choice* handle)
{
	choice_exseq_main_region_C(handle);
	choice_enseq_main_region_A_default(handle);
}

static void choice_effect_main_region__choice_0_tr1(Choice* handle)
{
	choice_enseq_main_region_C_default(handle);
}

static void choice_effect_main_region__choice_0_tr0(Choice* handle)
{
	choice_enseq_main_region_B_default(handle);
}

static void choice_effect_main_region__choice_1_tr0(Choice* handle)
{
	choice_enseq_main_region_C_default(handle);
}

static void choice_effect_main_region__choice_1_tr1(Choice* handle)
{
	choice_enseq_main_region_B_default(handle);
}

static void choice_effect_main_region__choice_2_tr1(Choice* handle)
{
	choice_enseq_main_region_C_default(handle);
}

static void choice_effect_main_region__choice_2_tr0(Choice* handle)
{
	choice_enseq_main_region_B_default(handle);
}

static void choice_effect_main_region__choice_3_tr1(Choice* handle)
{
	choice_enseq_main_region_C_default(handle);
}

static void choice_effect_main_region__choice_3_tr0(Choice* handle)
{
	choice_enseq_main_region_B_default(handle);
}

/* 'default' enter sequence for state A */
static void choice_enseq_main_region_A_default(Choice* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = Choice_main_region_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void choice_enseq_main_region_B_default(Choice* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = Choice_main_region_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
static void choice_enseq_main_region_C_default(Choice* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[0] = Choice_main_region_C;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
static void choice_enseq_main_region_default(Choice* handle)
{
	/* 'default' enter sequence for region main region */
	choice_react_main_region__entry_Default(handle);
}

/* Default exit sequence for state A */
static void choice_exseq_main_region_A(Choice* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = Choice_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void choice_exseq_main_region_B(Choice* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = Choice_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
static void choice_exseq_main_region_C(Choice* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[0] = Choice_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
static void choice_exseq_main_region(Choice* handle)
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of Choice.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case Choice_main_region_A :
		{
			choice_exseq_main_region_A(handle);
			break;
		}
		case Choice_main_region_B :
		{
			choice_exseq_main_region_B(handle);
			break;
		}
		case Choice_main_region_C :
		{
			choice_exseq_main_region_C(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void choice_react_main_region_A(Choice* handle)
{
	/* The reactions of state A. */
	if (choice_check_main_region_A_tr0_tr0(handle) == bool_true)
	{ 
		choice_effect_main_region_A_tr0(handle);
	}  else
	{
		if (choice_check_main_region_A_tr1_tr1(handle) == bool_true)
		{ 
			choice_effect_main_region_A_tr1(handle);
		}  else
		{
			if (choice_check_main_region_A_tr2_tr2(handle) == bool_true)
			{ 
				choice_effect_main_region_A_tr2(handle);
			}  else
			{
				if (choice_check_main_region_A_tr3_tr3(handle) == bool_true)
				{ 
					choice_effect_main_region_A_tr3(handle);
				} 
			}
		}
	}
}

/* The reactions of state B. */
static void choice_react_main_region_B(Choice* handle)
{
	/* The reactions of state B. */
	choice_effect_main_region_B_tr0(handle);
}

/* The reactions of state C. */
static void choice_react_main_region_C(Choice* handle)
{
	/* The reactions of state C. */
	choice_effect_main_region_C_tr0(handle);
}

/* The reactions of state null. */
static void choice_react_main_region__choice_0(Choice* handle)
{
	/* The reactions of state null. */
	if (choice_check_main_region__choice_0_tr1_tr1(handle) == bool_true)
	{ 
		choice_effect_main_region__choice_0_tr1(handle);
	}  else
	{
		choice_effect_main_region__choice_0_tr0(handle);
	}
}

/* The reactions of state null. */
static void choice_react_main_region__choice_1(Choice* handle)
{
	/* The reactions of state null. */
	if (choice_check_main_region__choice_1_tr0_tr0(handle) == bool_true)
	{ 
		choice_effect_main_region__choice_1_tr0(handle);
	}  else
	{
		choice_effect_main_region__choice_1_tr1(handle);
	}
}

/* The reactions of state null. */
static void choice_react_main_region__choice_2(Choice* handle)
{
	/* The reactions of state null. */
	if (choice_check_main_region__choice_2_tr1_tr1(handle) == bool_true)
	{ 
		choice_effect_main_region__choice_2_tr1(handle);
	}  else
	{
		choice_effect_main_region__choice_2_tr0(handle);
	}
}

/* The reactions of state null. */
static void choice_react_main_region__choice_3(Choice* handle)
{
	/* The reactions of state null. */
	if (choice_check_main_region__choice_3_tr1_tr1(handle) == bool_true)
	{ 
		choice_effect_main_region__choice_3_tr1(handle);
	}  else
	{
		choice_effect_main_region__choice_3_tr0(handle);
	}
}

/* Default react sequence for initial entry  */
static void choice_react_main_region__entry_Default(Choice* handle)
{
	/* Default react sequence for initial entry  */
	choice_enseq_main_region_A_default(handle);
}


