
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "ExitState.h"
/*! \file Implementation of the state machine 'ExitState'
*/

/* prototypes of all internal functions */
static sc_boolean exitState_check_r_A_r_B_tr0_tr0(const ExitState* handle);
static sc_boolean exitState_check_r_A_r_B_tr1_tr1(const ExitState* handle);
static sc_boolean exitState_check_r_A_r_B_tr2_tr2(const ExitState* handle);
static void exitState_effect_r_A_tr0(ExitState* handle);
static void exitState_effect_r_A_tr1(ExitState* handle);
static void exitState_effect_r_A_r_B_tr0(ExitState* handle);
static void exitState_effect_r_A_r_B_tr1(ExitState* handle);
static void exitState_effect_r_A_r_B_tr2(ExitState* handle);
static void exitState_enseq_r_A_default(ExitState* handle);
static void exitState_enseq_r_A_r_B_default(ExitState* handle);
static void exitState_enseq_r_E_default(ExitState* handle);
static void exitState_enseq_r_F_default(ExitState* handle);
static void exitState_enseq_r_default(ExitState* handle);
static void exitState_enseq_r_A_r_default(ExitState* handle);
static void exitState_exseq_r_A(ExitState* handle);
static void exitState_exseq_r_A_r_B(ExitState* handle);
static void exitState_exseq_r_E(ExitState* handle);
static void exitState_exseq_r_F(ExitState* handle);
static void exitState_exseq_r(ExitState* handle);
static void exitState_exseq_r_A_r(ExitState* handle);
static void exitState_react_r_A_r_B(ExitState* handle);
static void exitState_react_r_E(ExitState* handle);
static void exitState_react_r_F(ExitState* handle);
static void exitState_react_r__entry_Default(ExitState* handle);
static void exitState_react_r_A_r__entry_Default(ExitState* handle);
static void exitState_react_r_A_r__exit_Default(ExitState* handle);
static void exitState_react_r_A_r_f(ExitState* handle);
static void exitState_react_r_A_r_g(ExitState* handle);
static void exitState_clearInEvents(ExitState* handle);
static void exitState_clearOutEvents(ExitState* handle);


void exitState_init(ExitState* handle)
{
	sc_integer i;

	for (i = 0; i < EXITSTATE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = ExitState_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	exitState_clearInEvents(handle);
	exitState_clearOutEvents(handle);


}

void exitState_enter(ExitState* handle)
{
	/* Default enter sequence for statechart ExitState */
	exitState_enseq_r_default(handle);
}

void exitState_exit(ExitState* handle)
{
	/* Default exit sequence for statechart ExitState */
	exitState_exseq_r(handle);
}

sc_boolean exitState_isActive(const ExitState* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < EXITSTATE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != ExitState_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean exitState_isFinal(const ExitState* handle)
{
   return bool_false;
}

static void exitState_clearInEvents(ExitState* handle)
{
	handle->iface.e_raised = bool_false;
	handle->iface.f_raised = bool_false;
	handle->iface.g_raised = bool_false;
}

static void exitState_clearOutEvents(ExitState* handle)
{
}

void exitState_runCycle(ExitState* handle)
{
	
	exitState_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < EXITSTATE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case ExitState_r_A_r_B :
		{
			exitState_react_r_A_r_B(handle);
			break;
		}
		case ExitState_r_E :
		{
			exitState_react_r_E(handle);
			break;
		}
		case ExitState_r_F :
		{
			exitState_react_r_F(handle);
			break;
		}
		default:
			break;
		}
	}
	
	exitState_clearInEvents(handle);
}


sc_boolean exitState_isStateActive(const ExitState* handle, ExitStateStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case ExitState_r_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_EXITSTATE_R_A] >= ExitState_r_A
				&& handle->stateConfVector[SCVI_EXITSTATE_R_A] <= ExitState_r_A_r_B);
			break;
		case ExitState_r_A_r_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_EXITSTATE_R_A_R_B] == ExitState_r_A_r_B
			);
			break;
		case ExitState_r_E :
			result = (sc_boolean) (handle->stateConfVector[SCVI_EXITSTATE_R_E] == ExitState_r_E
			);
			break;
		case ExitState_r_F :
			result = (sc_boolean) (handle->stateConfVector[SCVI_EXITSTATE_R_F] == ExitState_r_F
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void exitStateIface_raise_e(ExitState* handle)
{
	handle->iface.e_raised = bool_true;
}
void exitStateIface_raise_f(ExitState* handle)
{
	handle->iface.f_raised = bool_true;
}
void exitStateIface_raise_g(ExitState* handle)
{
	handle->iface.g_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean exitState_check_r_A_r_B_tr0_tr0(const ExitState* handle)
{
	return handle->iface.g_raised;
}

static sc_boolean exitState_check_r_A_r_B_tr1_tr1(const ExitState* handle)
{
	return handle->iface.f_raised;
}

static sc_boolean exitState_check_r_A_r_B_tr2_tr2(const ExitState* handle)
{
	return handle->iface.e_raised;
}

static void exitState_effect_r_A_tr0(ExitState* handle)
{
	exitState_exseq_r_A(handle);
	exitState_enseq_r_E_default(handle);
}

static void exitState_effect_r_A_tr1(ExitState* handle)
{
	exitState_exseq_r_A(handle);
	exitState_enseq_r_F_default(handle);
}

static void exitState_effect_r_A_r_B_tr0(ExitState* handle)
{
	exitState_exseq_r_A_r_B(handle);
	exitState_react_r_A_r_g(handle);
}

static void exitState_effect_r_A_r_B_tr1(ExitState* handle)
{
	exitState_exseq_r_A_r_B(handle);
	exitState_react_r_A_r_f(handle);
}

static void exitState_effect_r_A_r_B_tr2(ExitState* handle)
{
	exitState_exseq_r_A_r_B(handle);
	exitState_react_r_A_r__exit_Default(handle);
}

/* 'default' enter sequence for state A */
static void exitState_enseq_r_A_default(ExitState* handle)
{
	/* 'default' enter sequence for state A */
	exitState_enseq_r_A_r_default(handle);
}

/* 'default' enter sequence for state B */
static void exitState_enseq_r_A_r_B_default(ExitState* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = ExitState_r_A_r_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state E */
static void exitState_enseq_r_E_default(ExitState* handle)
{
	/* 'default' enter sequence for state E */
	handle->stateConfVector[0] = ExitState_r_E;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state F */
static void exitState_enseq_r_F_default(ExitState* handle)
{
	/* 'default' enter sequence for state F */
	handle->stateConfVector[0] = ExitState_r_F;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region r */
static void exitState_enseq_r_default(ExitState* handle)
{
	/* 'default' enter sequence for region r */
	exitState_react_r__entry_Default(handle);
}

/* 'default' enter sequence for region r */
static void exitState_enseq_r_A_r_default(ExitState* handle)
{
	/* 'default' enter sequence for region r */
	exitState_react_r_A_r__entry_Default(handle);
}

/* Default exit sequence for state A */
static void exitState_exseq_r_A(ExitState* handle)
{
	/* Default exit sequence for state A */
	exitState_exseq_r_A_r(handle);
}

/* Default exit sequence for state B */
static void exitState_exseq_r_A_r_B(ExitState* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = ExitState_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state E */
static void exitState_exseq_r_E(ExitState* handle)
{
	/* Default exit sequence for state E */
	handle->stateConfVector[0] = ExitState_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state F */
static void exitState_exseq_r_F(ExitState* handle)
{
	/* Default exit sequence for state F */
	handle->stateConfVector[0] = ExitState_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region r */
static void exitState_exseq_r(ExitState* handle)
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of ExitState.r) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ExitState_r_A_r_B :
		{
			exitState_exseq_r_A_r_B(handle);
			break;
		}
		case ExitState_r_E :
		{
			exitState_exseq_r_E(handle);
			break;
		}
		case ExitState_r_F :
		{
			exitState_exseq_r_F(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
static void exitState_exseq_r_A_r(ExitState* handle)
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of ExitState.r.A.r) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case ExitState_r_A_r_B :
		{
			exitState_exseq_r_A_r_B(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state B. */
static void exitState_react_r_A_r_B(ExitState* handle)
{
	/* The reactions of state B. */
	if (exitState_check_r_A_r_B_tr0_tr0(handle) == bool_true)
	{ 
		exitState_effect_r_A_r_B_tr0(handle);
	}  else
	{
		if (exitState_check_r_A_r_B_tr1_tr1(handle) == bool_true)
		{ 
			exitState_effect_r_A_r_B_tr1(handle);
		}  else
		{
			if (exitState_check_r_A_r_B_tr2_tr2(handle) == bool_true)
			{ 
				exitState_effect_r_A_r_B_tr2(handle);
			} 
		}
	}
}

/* The reactions of state E. */
static void exitState_react_r_E(ExitState* handle)
{
	/* The reactions of state E. */
}

/* The reactions of state F. */
static void exitState_react_r_F(ExitState* handle)
{
	/* The reactions of state F. */
}

/* Default react sequence for initial entry  */
static void exitState_react_r__entry_Default(ExitState* handle)
{
	/* Default react sequence for initial entry  */
	exitState_enseq_r_A_default(handle);
}

/* Default react sequence for initial entry  */
static void exitState_react_r_A_r__entry_Default(ExitState* handle)
{
	/* Default react sequence for initial entry  */
	exitState_enseq_r_A_r_B_default(handle);
}

/* The reactions of exit default. */
static void exitState_react_r_A_r__exit_Default(ExitState* handle)
{
	/* The reactions of exit default. */
	exitState_effect_r_A_tr0(handle);
}

/* The reactions of exit f. */
static void exitState_react_r_A_r_f(ExitState* handle)
{
	/* The reactions of exit f. */
	exitState_effect_r_A_tr1(handle);
}

/* The reactions of exit g. */
static void exitState_react_r_A_r_g(ExitState* handle)
{
	/* The reactions of exit g. */
	exitState_effect_r_A_tr0(handle);
}


