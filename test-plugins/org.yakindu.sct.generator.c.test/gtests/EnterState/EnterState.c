
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "EnterState.h"
/*! \file Implementation of the state machine 'EnterState'
*/

/* prototypes of all internal functions */
static sc_boolean enterState_check_r_A_tr0_tr0(const EnterState* handle);
static sc_boolean enterState_check_r_A_tr1_tr1(const EnterState* handle);
static sc_boolean enterState_check_r_A_tr2_tr2(const EnterState* handle);
static void enterState_effect_r_A_tr0(EnterState* handle);
static void enterState_effect_r_A_tr1(EnterState* handle);
static void enterState_effect_r_A_tr2(EnterState* handle);
static void enterState_enseq_r_A_default(EnterState* handle);
static void enterState_enseq_r_B_default(EnterState* handle);
static void enterState_enseq_r_B_f(EnterState* handle);
static void enterState_enseq_r_B_g(EnterState* handle);
static void enterState_enseq_r_B_r_E_default(EnterState* handle);
static void enterState_enseq_r_B_r_F_default(EnterState* handle);
static void enterState_enseq_r_default(EnterState* handle);
static void enterState_enseq_r_B_r_default(EnterState* handle);
static void enterState_enseq_r_B_r_f(EnterState* handle);
static void enterState_exseq_r_A(EnterState* handle);
static void enterState_exseq_r_B_r_E(EnterState* handle);
static void enterState_exseq_r_B_r_F(EnterState* handle);
static void enterState_exseq_r(EnterState* handle);
static void enterState_exseq_r_B_r(EnterState* handle);
static void enterState_react_r_A(EnterState* handle);
static void enterState_react_r_B_r_E(EnterState* handle);
static void enterState_react_r_B_r_F(EnterState* handle);
static void enterState_react_r__entry_Default(EnterState* handle);
static void enterState_react_r_B_r__entry_Default(EnterState* handle);
static void enterState_react_r_B_r_f(EnterState* handle);
static void enterState_clearInEvents(EnterState* handle);
static void enterState_clearOutEvents(EnterState* handle);


void enterState_init(EnterState* handle)
{
	sc_integer i;

	for (i = 0; i < ENTERSTATE_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = EnterState_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	enterState_clearInEvents(handle);
	enterState_clearOutEvents(handle);


}

void enterState_enter(EnterState* handle)
{
	/* Default enter sequence for statechart EnterState */
	enterState_enseq_r_default(handle);
}

void enterState_exit(EnterState* handle)
{
	/* Default exit sequence for statechart EnterState */
	enterState_exseq_r(handle);
}

sc_boolean enterState_isActive(const EnterState* handle)
{
	sc_boolean result = bool_false;
	int i;
	
	for(i = 0; i < ENTERSTATE_MAX_ORTHOGONAL_STATES; i++)
	{
		result = result || handle->stateConfVector[i] != EnterState_last_state;
	}
	
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean enterState_isFinal(const EnterState* handle)
{
   return bool_false;
}

static void enterState_clearInEvents(EnterState* handle)
{
	handle->iface.e_raised = bool_false;
	handle->iface.f_raised = bool_false;
	handle->iface.g_raised = bool_false;
}

static void enterState_clearOutEvents(EnterState* handle)
{
}

void enterState_runCycle(EnterState* handle)
{
	
	enterState_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < ENTERSTATE_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case EnterState_r_A :
		{
			enterState_react_r_A(handle);
			break;
		}
		case EnterState_r_B_r_E :
		{
			enterState_react_r_B_r_E(handle);
			break;
		}
		case EnterState_r_B_r_F :
		{
			enterState_react_r_B_r_F(handle);
			break;
		}
		default:
			break;
		}
	}
	
	enterState_clearInEvents(handle);
}


sc_boolean enterState_isStateActive(const EnterState* handle, EnterStateStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case EnterState_r_A :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ENTERSTATE_R_A] == EnterState_r_A
			);
			break;
		case EnterState_r_B :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ENTERSTATE_R_B] >= EnterState_r_B
				&& handle->stateConfVector[SCVI_ENTERSTATE_R_B] <= EnterState_r_B_r_F);
			break;
		case EnterState_r_B_r_E :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ENTERSTATE_R_B_R_E] == EnterState_r_B_r_E
			);
			break;
		case EnterState_r_B_r_F :
			result = (sc_boolean) (handle->stateConfVector[SCVI_ENTERSTATE_R_B_R_F] == EnterState_r_B_r_F
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void enterStateIface_raise_e(EnterState* handle)
{
	handle->iface.e_raised = bool_true;
}
void enterStateIface_raise_f(EnterState* handle)
{
	handle->iface.f_raised = bool_true;
}
void enterStateIface_raise_g(EnterState* handle)
{
	handle->iface.g_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean enterState_check_r_A_tr0_tr0(const EnterState* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean enterState_check_r_A_tr1_tr1(const EnterState* handle)
{
	return handle->iface.f_raised;
}

static sc_boolean enterState_check_r_A_tr2_tr2(const EnterState* handle)
{
	return handle->iface.g_raised;
}

static void enterState_effect_r_A_tr0(EnterState* handle)
{
	enterState_exseq_r_A(handle);
	enterState_enseq_r_B_default(handle);
}

static void enterState_effect_r_A_tr1(EnterState* handle)
{
	enterState_exseq_r_A(handle);
	enterState_enseq_r_B_f(handle);
}

static void enterState_effect_r_A_tr2(EnterState* handle)
{
	enterState_exseq_r_A(handle);
	enterState_enseq_r_B_g(handle);
}

/* 'default' enter sequence for state A */
static void enterState_enseq_r_A_default(EnterState* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[0] = EnterState_r_A;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void enterState_enseq_r_B_default(EnterState* handle)
{
	/* 'default' enter sequence for state B */
	enterState_enseq_r_B_r_default(handle);
}

/* 'f' enter sequence for state B */
static void enterState_enseq_r_B_f(EnterState* handle)
{
	/* 'f' enter sequence for state B */
	enterState_enseq_r_B_r_f(handle);
}

/* 'g' enter sequence for state B */
static void enterState_enseq_r_B_g(EnterState* handle)
{
	/* 'g' enter sequence for state B */
	enterState_enseq_r_B_r_default(handle);
}

/* 'default' enter sequence for state E */
static void enterState_enseq_r_B_r_E_default(EnterState* handle)
{
	/* 'default' enter sequence for state E */
	handle->stateConfVector[0] = EnterState_r_B_r_E;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state F */
static void enterState_enseq_r_B_r_F_default(EnterState* handle)
{
	/* 'default' enter sequence for state F */
	handle->stateConfVector[0] = EnterState_r_B_r_F;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region r */
static void enterState_enseq_r_default(EnterState* handle)
{
	/* 'default' enter sequence for region r */
	enterState_react_r__entry_Default(handle);
}

/* 'default' enter sequence for region r */
static void enterState_enseq_r_B_r_default(EnterState* handle)
{
	/* 'default' enter sequence for region r */
	enterState_react_r_B_r__entry_Default(handle);
}

/* 'f' enter sequence for region r */
static void enterState_enseq_r_B_r_f(EnterState* handle)
{
	/* 'f' enter sequence for region r */
	enterState_react_r_B_r_f(handle);
}

/* Default exit sequence for state A */
static void enterState_exseq_r_A(EnterState* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[0] = EnterState_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state E */
static void enterState_exseq_r_B_r_E(EnterState* handle)
{
	/* Default exit sequence for state E */
	handle->stateConfVector[0] = EnterState_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state F */
static void enterState_exseq_r_B_r_F(EnterState* handle)
{
	/* Default exit sequence for state F */
	handle->stateConfVector[0] = EnterState_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region r */
static void enterState_exseq_r(EnterState* handle)
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of EnterState.r) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case EnterState_r_A :
		{
			enterState_exseq_r_A(handle);
			break;
		}
		case EnterState_r_B_r_E :
		{
			enterState_exseq_r_B_r_E(handle);
			break;
		}
		case EnterState_r_B_r_F :
		{
			enterState_exseq_r_B_r_F(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
static void enterState_exseq_r_B_r(EnterState* handle)
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of EnterState.r.B.r) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case EnterState_r_B_r_E :
		{
			enterState_exseq_r_B_r_E(handle);
			break;
		}
		case EnterState_r_B_r_F :
		{
			enterState_exseq_r_B_r_F(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
static void enterState_react_r_A(EnterState* handle)
{
	/* The reactions of state A. */
	if (enterState_check_r_A_tr0_tr0(handle) == bool_true)
	{ 
		enterState_effect_r_A_tr0(handle);
	}  else
	{
		if (enterState_check_r_A_tr1_tr1(handle) == bool_true)
		{ 
			enterState_effect_r_A_tr1(handle);
		}  else
		{
			if (enterState_check_r_A_tr2_tr2(handle) == bool_true)
			{ 
				enterState_effect_r_A_tr2(handle);
			} 
		}
	}
}

/* The reactions of state E. */
static void enterState_react_r_B_r_E(EnterState* handle)
{
	/* The reactions of state E. */
}

/* The reactions of state F. */
static void enterState_react_r_B_r_F(EnterState* handle)
{
	/* The reactions of state F. */
}

/* Default react sequence for initial entry  */
static void enterState_react_r__entry_Default(EnterState* handle)
{
	/* Default react sequence for initial entry  */
	enterState_enseq_r_A_default(handle);
}

/* Default react sequence for initial entry  */
static void enterState_react_r_B_r__entry_Default(EnterState* handle)
{
	/* Default react sequence for initial entry  */
	enterState_enseq_r_B_r_E_default(handle);
}

/* Default react sequence for initial entry f */
static void enterState_react_r_B_r_f(EnterState* handle)
{
	/* Default react sequence for initial entry f */
	enterState_enseq_r_B_r_F_default(handle);
}


