
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "DeepEntry.h"
/*! \file Implementation of the state machine 'DeepEntry'
*/

/* prototypes of all internal functions */
static sc_boolean deepEntry_check_r2_B_tr0_tr0(const DeepEntry* handle);
static sc_boolean deepEntry_check_r2_B_r_BA_tr0_tr0(const DeepEntry* handle);
static sc_boolean deepEntry_check_r2_C_tr0_tr0(const DeepEntry* handle);
static void deepEntry_effect_r2_B_tr0(DeepEntry* handle);
static void deepEntry_effect_r2_B_r_BA_tr0(DeepEntry* handle);
static void deepEntry_effect_r2_C_tr0(DeepEntry* handle);
static void deepEntry_enact_r_A(DeepEntry* handle);
static void deepEntry_enact_r2_B_r_BA(DeepEntry* handle);
static void deepEntry_enact_r3_D(DeepEntry* handle);
static void deepEntry_enact_r3_D_r_DA(DeepEntry* handle);
static void deepEntry_enseq_r_A_r_B_default(DeepEntry* handle);
static void deepEntry_enseq_r2_B_default(DeepEntry* handle);
static void deepEntry_enseq_r2_B_r_BA_default(DeepEntry* handle);
static void deepEntry_enseq_r2_B_r_BA_r_BAA_default(DeepEntry* handle);
static void deepEntry_enseq_r2_B_r_BB_default(DeepEntry* handle);
static void deepEntry_enseq_r2_C_default(DeepEntry* handle);
static void deepEntry_enseq_r3_D_r_DA_r_DAA_default(DeepEntry* handle);
static void deepEntry_enseq_r_default(DeepEntry* handle);
static void deepEntry_enseq_r2_default(DeepEntry* handle);
static void deepEntry_enseq_r2_B_r_default(DeepEntry* handle);
static void deepEntry_shenseq_r2_B_r(DeepEntry* handle);
static void deepEntry_enseq_r2_B_r_BA_r_default(DeepEntry* handle);
static void deepEntry_enseq_r3_default(DeepEntry* handle);
static void deepEntry_dhenseq_r3(DeepEntry* handle);
static void deepEntry_dhenseq_r3_D_r(DeepEntry* handle);
static void deepEntry_dhenseq_r3_D_r_DA_r(DeepEntry* handle);
static void deepEntry_exseq_r_A_r_B(DeepEntry* handle);
static void deepEntry_exseq_r2_B(DeepEntry* handle);
static void deepEntry_exseq_r2_B_r_BA(DeepEntry* handle);
static void deepEntry_exseq_r2_B_r_BA_r_BAA(DeepEntry* handle);
static void deepEntry_exseq_r2_B_r_BB(DeepEntry* handle);
static void deepEntry_exseq_r2_C(DeepEntry* handle);
static void deepEntry_exseq_r3_D_r_DA_r_DAA(DeepEntry* handle);
static void deepEntry_exseq_r(DeepEntry* handle);
static void deepEntry_exseq_r_A_r(DeepEntry* handle);
static void deepEntry_exseq_r2(DeepEntry* handle);
static void deepEntry_exseq_r2_B_r(DeepEntry* handle);
static void deepEntry_exseq_r2_B_r_BA_r(DeepEntry* handle);
static void deepEntry_exseq_r3(DeepEntry* handle);
static void deepEntry_exseq_r3_D_r(DeepEntry* handle);
static void deepEntry_exseq_r3_D_r_DA_r(DeepEntry* handle);
static void deepEntry_react_r_A_r_B(DeepEntry* handle);
static void deepEntry_react_r2_B_r_BA_r_BAA(DeepEntry* handle);
static void deepEntry_react_r2_B_r_BB(DeepEntry* handle);
static void deepEntry_react_r2_C(DeepEntry* handle);
static void deepEntry_react_r3_D_r_DA_r_DAA(DeepEntry* handle);
static void deepEntry_react_r__entry_Default(DeepEntry* handle);
static void deepEntry_react_r2_B_r__entry_Default(DeepEntry* handle);
static void deepEntry_react_r2_B_r_BA_r__entry_Default(DeepEntry* handle);
static void deepEntry_react_r2__entry_Default(DeepEntry* handle);
static void deepEntry_react_r3__entry_Default(DeepEntry* handle);
static void deepEntry_clearInEvents(DeepEntry* handle);
static void deepEntry_clearOutEvents(DeepEntry* handle);


void deepEntry_init(DeepEntry* handle)
{
	sc_integer i;

	for (i = 0; i < DEEPENTRY_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = DeepEntry_last_state;
	}
	
	for (i = 0; i < DEEPENTRY_MAX_HISTORY_STATES; ++i)
	{
		handle->historyVector[i] = DeepEntry_last_state;
	}
	
	handle->stateConfVectorPosition = 0;

	deepEntry_clearInEvents(handle);
	deepEntry_clearOutEvents(handle);

	/* Default init sequence for statechart DeepEntry */
	handle->iface.x = 0;
	handle->iface.y = 0;
	handle->iface.z = 0;

}

void deepEntry_enter(DeepEntry* handle)
{
	/* Default enter sequence for statechart DeepEntry */
	deepEntry_enseq_r_default(handle);
	deepEntry_enseq_r2_default(handle);
	deepEntry_enseq_r3_default(handle);
}

void deepEntry_exit(DeepEntry* handle)
{
	/* Default exit sequence for statechart DeepEntry */
	deepEntry_exseq_r(handle);
	deepEntry_exseq_r2(handle);
	deepEntry_exseq_r3(handle);
}

sc_boolean deepEntry_isActive(const DeepEntry* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != DeepEntry_last_state || handle->stateConfVector[1] != DeepEntry_last_state || handle->stateConfVector[2] != DeepEntry_last_state)
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
sc_boolean deepEntry_isFinal(const DeepEntry* handle)
{
   return bool_false;
}

static void deepEntry_clearInEvents(DeepEntry* handle)
{
	handle->iface.e_raised = bool_false;
	handle->iface.f_raised = bool_false;
}

static void deepEntry_clearOutEvents(DeepEntry* handle)
{
}

void deepEntry_runCycle(DeepEntry* handle)
{
	
	deepEntry_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < DEEPENTRY_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case DeepEntry_r_A_r_B :
		{
			deepEntry_react_r_A_r_B(handle);
			break;
		}
		case DeepEntry_r2_B_r_BA_r_BAA :
		{
			deepEntry_react_r2_B_r_BA_r_BAA(handle);
			break;
		}
		case DeepEntry_r2_B_r_BB :
		{
			deepEntry_react_r2_B_r_BB(handle);
			break;
		}
		case DeepEntry_r2_C :
		{
			deepEntry_react_r2_C(handle);
			break;
		}
		case DeepEntry_r3_D_r_DA_r_DAA :
		{
			deepEntry_react_r3_D_r_DA_r_DAA(handle);
			break;
		}
		default:
			break;
		}
	}
	
	deepEntry_clearInEvents(handle);
}


sc_boolean deepEntry_isStateActive(const DeepEntry* handle, DeepEntryStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case DeepEntry_r_A :
			result = (sc_boolean) (handle->stateConfVector[0] >= DeepEntry_r_A
				&& handle->stateConfVector[0] <= DeepEntry_r_A_r_B);
			break;
		case DeepEntry_r_A_r_B :
			result = (sc_boolean) (handle->stateConfVector[0] == DeepEntry_r_A_r_B
			);
			break;
		case DeepEntry_r2_B :
			result = (sc_boolean) (handle->stateConfVector[1] >= DeepEntry_r2_B
				&& handle->stateConfVector[1] <= DeepEntry_r2_B_r_BB);
			break;
		case DeepEntry_r2_B_r_BA :
			result = (sc_boolean) (handle->stateConfVector[1] >= DeepEntry_r2_B_r_BA
				&& handle->stateConfVector[1] <= DeepEntry_r2_B_r_BA_r_BAA);
			break;
		case DeepEntry_r2_B_r_BA_r_BAA :
			result = (sc_boolean) (handle->stateConfVector[1] == DeepEntry_r2_B_r_BA_r_BAA
			);
			break;
		case DeepEntry_r2_B_r_BB :
			result = (sc_boolean) (handle->stateConfVector[1] == DeepEntry_r2_B_r_BB
			);
			break;
		case DeepEntry_r2_C :
			result = (sc_boolean) (handle->stateConfVector[1] == DeepEntry_r2_C
			);
			break;
		case DeepEntry_r3_D :
			result = (sc_boolean) (handle->stateConfVector[2] >= DeepEntry_r3_D
				&& handle->stateConfVector[2] <= DeepEntry_r3_D_r_DA_r_DAA);
			break;
		case DeepEntry_r3_D_r_DA :
			result = (sc_boolean) (handle->stateConfVector[2] >= DeepEntry_r3_D_r_DA
				&& handle->stateConfVector[2] <= DeepEntry_r3_D_r_DA_r_DAA);
			break;
		case DeepEntry_r3_D_r_DA_r_DAA :
			result = (sc_boolean) (handle->stateConfVector[2] == DeepEntry_r3_D_r_DA_r_DAA
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void deepEntryIface_raise_e(DeepEntry* handle)
{
	handle->iface.e_raised = bool_true;
}
void deepEntryIface_raise_f(DeepEntry* handle)
{
	handle->iface.f_raised = bool_true;
}


sc_integer deepEntryIface_get_x(const DeepEntry* handle)
{
	return handle->iface.x;
}
void deepEntryIface_set_x(DeepEntry* handle, sc_integer value)
{
	handle->iface.x = value;
}
sc_integer deepEntryIface_get_y(const DeepEntry* handle)
{
	return handle->iface.y;
}
void deepEntryIface_set_y(DeepEntry* handle, sc_integer value)
{
	handle->iface.y = value;
}
sc_integer deepEntryIface_get_z(const DeepEntry* handle)
{
	return handle->iface.z;
}
void deepEntryIface_set_z(DeepEntry* handle, sc_integer value)
{
	handle->iface.z = value;
}

/* implementations of all internal functions */

static sc_boolean deepEntry_check_r2_B_tr0_tr0(const DeepEntry* handle)
{
	return handle->iface.f_raised;
}

static sc_boolean deepEntry_check_r2_B_r_BA_tr0_tr0(const DeepEntry* handle)
{
	return handle->iface.e_raised;
}

static sc_boolean deepEntry_check_r2_C_tr0_tr0(const DeepEntry* handle)
{
	return handle->iface.f_raised;
}

static void deepEntry_effect_r2_B_tr0(DeepEntry* handle)
{
	deepEntry_exseq_r2_B(handle);
	deepEntry_enseq_r2_C_default(handle);
}

static void deepEntry_effect_r2_B_r_BA_tr0(DeepEntry* handle)
{
	deepEntry_exseq_r2_B_r_BA(handle);
	deepEntry_enseq_r2_B_r_BB_default(handle);
}

static void deepEntry_effect_r2_C_tr0(DeepEntry* handle)
{
	deepEntry_exseq_r2_C(handle);
	deepEntry_enseq_r2_B_default(handle);
}

/* Entry action for state 'A'. */
static void deepEntry_enact_r_A(DeepEntry* handle)
{
	/* Entry action for state 'A'. */
	handle->iface.x += 1;
}

/* Entry action for state 'BA'. */
static void deepEntry_enact_r2_B_r_BA(DeepEntry* handle)
{
	/* Entry action for state 'BA'. */
	handle->iface.y += 1;
}

/* Entry action for state 'D'. */
static void deepEntry_enact_r3_D(DeepEntry* handle)
{
	/* Entry action for state 'D'. */
	handle->iface.z += 1;
}

/* Entry action for state 'DA'. */
static void deepEntry_enact_r3_D_r_DA(DeepEntry* handle)
{
	/* Entry action for state 'DA'. */
	handle->iface.z += 1;
}

/* 'default' enter sequence for state B */
static void deepEntry_enseq_r_A_r_B_default(DeepEntry* handle)
{
	/* 'default' enter sequence for state B */
	handle->stateConfVector[0] = DeepEntry_r_A_r_B;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
static void deepEntry_enseq_r2_B_default(DeepEntry* handle)
{
	/* 'default' enter sequence for state B */
	deepEntry_enseq_r2_B_r_default(handle);
}

/* 'default' enter sequence for state BA */
static void deepEntry_enseq_r2_B_r_BA_default(DeepEntry* handle)
{
	/* 'default' enter sequence for state BA */
	deepEntry_enact_r2_B_r_BA(handle);
	deepEntry_enseq_r2_B_r_BA_r_default(handle);
	handle->historyVector[0] = handle->stateConfVector[1];
}

/* 'default' enter sequence for state BAA */
static void deepEntry_enseq_r2_B_r_BA_r_BAA_default(DeepEntry* handle)
{
	/* 'default' enter sequence for state BAA */
	handle->stateConfVector[1] = DeepEntry_r2_B_r_BA_r_BAA;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state BB */
static void deepEntry_enseq_r2_B_r_BB_default(DeepEntry* handle)
{
	/* 'default' enter sequence for state BB */
	handle->stateConfVector[1] = DeepEntry_r2_B_r_BB;
	handle->stateConfVectorPosition = 1;
	handle->historyVector[0] = handle->stateConfVector[1];
}

/* 'default' enter sequence for state C */
static void deepEntry_enseq_r2_C_default(DeepEntry* handle)
{
	/* 'default' enter sequence for state C */
	handle->stateConfVector[1] = DeepEntry_r2_C;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state DAA */
static void deepEntry_enseq_r3_D_r_DA_r_DAA_default(DeepEntry* handle)
{
	/* 'default' enter sequence for state DAA */
	handle->stateConfVector[2] = DeepEntry_r3_D_r_DA_r_DAA;
	handle->stateConfVectorPosition = 2;
	handle->historyVector[3] = handle->stateConfVector[2];
}

/* 'default' enter sequence for region r */
static void deepEntry_enseq_r_default(DeepEntry* handle)
{
	/* 'default' enter sequence for region r */
	deepEntry_react_r__entry_Default(handle);
}

/* 'default' enter sequence for region r2 */
static void deepEntry_enseq_r2_default(DeepEntry* handle)
{
	/* 'default' enter sequence for region r2 */
	deepEntry_react_r2__entry_Default(handle);
}

/* 'default' enter sequence for region r */
static void deepEntry_enseq_r2_B_r_default(DeepEntry* handle)
{
	/* 'default' enter sequence for region r */
	deepEntry_react_r2_B_r__entry_Default(handle);
}

/* shallow enterSequence with history in child r */
static void deepEntry_shenseq_r2_B_r(DeepEntry* handle)
{
	/* shallow enterSequence with history in child r */
	/* Handle shallow history entry of r */
	switch(handle->historyVector[ 0 ])
	{
		case DeepEntry_r2_B_r_BA_r_BAA :
		{
			deepEntry_enseq_r2_B_r_BA_default(handle);
			break;
		}
		case DeepEntry_r2_B_r_BB :
		{
			deepEntry_enseq_r2_B_r_BB_default(handle);
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region r */
static void deepEntry_enseq_r2_B_r_BA_r_default(DeepEntry* handle)
{
	/* 'default' enter sequence for region r */
	deepEntry_react_r2_B_r_BA_r__entry_Default(handle);
}

/* 'default' enter sequence for region r3 */
static void deepEntry_enseq_r3_default(DeepEntry* handle)
{
	/* 'default' enter sequence for region r3 */
	deepEntry_react_r3__entry_Default(handle);
}

/* deep enterSequence with history in child r3 */
static void deepEntry_dhenseq_r3(DeepEntry* handle)
{
	/* deep enterSequence with history in child r3 */
	/* Handle deep history entry of r3 */
	switch(handle->historyVector[ 1 ])
	{
		case DeepEntry_r3_D_r_DA_r_DAA :
		{
			/* enterSequence with history in child D for leaf DAA */
			deepEntry_enact_r3_D(handle);
			deepEntry_dhenseq_r3_D_r(handle);
			break;
		}
		default: break;
	}
}

/* deep enterSequence with history in child r */
static void deepEntry_dhenseq_r3_D_r(DeepEntry* handle)
{
	/* deep enterSequence with history in child r */
	/* Handle deep history entry of r */
	switch(handle->historyVector[ 2 ])
	{
		case DeepEntry_r3_D_r_DA_r_DAA :
		{
			/* enterSequence with history in child DA for leaf DAA */
			deepEntry_enact_r3_D_r_DA(handle);
			deepEntry_dhenseq_r3_D_r_DA_r(handle);
			break;
		}
		default: break;
	}
}

/* deep enterSequence with history in child r */
static void deepEntry_dhenseq_r3_D_r_DA_r(DeepEntry* handle)
{
	/* deep enterSequence with history in child r */
	/* Handle deep history entry of r */
	switch(handle->historyVector[ 3 ])
	{
		case DeepEntry_r3_D_r_DA_r_DAA :
		{
			/* enterSequence with history in child DAA for leaf DAA */
			deepEntry_enseq_r3_D_r_DA_r_DAA_default(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for state B */
static void deepEntry_exseq_r_A_r_B(DeepEntry* handle)
{
	/* Default exit sequence for state B */
	handle->stateConfVector[0] = DeepEntry_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
static void deepEntry_exseq_r2_B(DeepEntry* handle)
{
	/* Default exit sequence for state B */
	deepEntry_exseq_r2_B_r(handle);
}

/* Default exit sequence for state BA */
static void deepEntry_exseq_r2_B_r_BA(DeepEntry* handle)
{
	/* Default exit sequence for state BA */
	deepEntry_exseq_r2_B_r_BA_r(handle);
}

/* Default exit sequence for state BAA */
static void deepEntry_exseq_r2_B_r_BA_r_BAA(DeepEntry* handle)
{
	/* Default exit sequence for state BAA */
	handle->stateConfVector[1] = DeepEntry_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state BB */
static void deepEntry_exseq_r2_B_r_BB(DeepEntry* handle)
{
	/* Default exit sequence for state BB */
	handle->stateConfVector[1] = DeepEntry_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state C */
static void deepEntry_exseq_r2_C(DeepEntry* handle)
{
	/* Default exit sequence for state C */
	handle->stateConfVector[1] = DeepEntry_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for state DAA */
static void deepEntry_exseq_r3_D_r_DA_r_DAA(DeepEntry* handle)
{
	/* Default exit sequence for state DAA */
	handle->stateConfVector[2] = DeepEntry_last_state;
	handle->stateConfVectorPosition = 2;
}

/* Default exit sequence for region r */
static void deepEntry_exseq_r(DeepEntry* handle)
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of DeepEntry.r) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case DeepEntry_r_A_r_B :
		{
			deepEntry_exseq_r_A_r_B(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
static void deepEntry_exseq_r_A_r(DeepEntry* handle)
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of DeepEntry.r.A.r) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case DeepEntry_r_A_r_B :
		{
			deepEntry_exseq_r_A_r_B(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r2 */
static void deepEntry_exseq_r2(DeepEntry* handle)
{
	/* Default exit sequence for region r2 */
	/* Handle exit of all possible states (of DeepEntry.r2) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case DeepEntry_r2_B_r_BA_r_BAA :
		{
			deepEntry_exseq_r2_B_r_BA_r_BAA(handle);
			break;
		}
		case DeepEntry_r2_B_r_BB :
		{
			deepEntry_exseq_r2_B_r_BB(handle);
			break;
		}
		case DeepEntry_r2_C :
		{
			deepEntry_exseq_r2_C(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
static void deepEntry_exseq_r2_B_r(DeepEntry* handle)
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of DeepEntry.r2.B.r) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case DeepEntry_r2_B_r_BA_r_BAA :
		{
			deepEntry_exseq_r2_B_r_BA_r_BAA(handle);
			break;
		}
		case DeepEntry_r2_B_r_BB :
		{
			deepEntry_exseq_r2_B_r_BB(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
static void deepEntry_exseq_r2_B_r_BA_r(DeepEntry* handle)
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of DeepEntry.r2.B.r.BA.r) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case DeepEntry_r2_B_r_BA_r_BAA :
		{
			deepEntry_exseq_r2_B_r_BA_r_BAA(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r3 */
static void deepEntry_exseq_r3(DeepEntry* handle)
{
	/* Default exit sequence for region r3 */
	/* Handle exit of all possible states (of DeepEntry.r3) at position 2... */
	switch(handle->stateConfVector[ 2 ])
	{
		case DeepEntry_r3_D_r_DA_r_DAA :
		{
			deepEntry_exseq_r3_D_r_DA_r_DAA(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
static void deepEntry_exseq_r3_D_r(DeepEntry* handle)
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of DeepEntry.r3.D.r) at position 2... */
	switch(handle->stateConfVector[ 2 ])
	{
		case DeepEntry_r3_D_r_DA_r_DAA :
		{
			deepEntry_exseq_r3_D_r_DA_r_DAA(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
static void deepEntry_exseq_r3_D_r_DA_r(DeepEntry* handle)
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of DeepEntry.r3.D.r.DA.r) at position 2... */
	switch(handle->stateConfVector[ 2 ])
	{
		case DeepEntry_r3_D_r_DA_r_DAA :
		{
			deepEntry_exseq_r3_D_r_DA_r_DAA(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state B. */
static void deepEntry_react_r_A_r_B(DeepEntry* handle)
{
	/* The reactions of state B. */
}

/* The reactions of state BAA. */
static void deepEntry_react_r2_B_r_BA_r_BAA(DeepEntry* handle)
{
	/* The reactions of state BAA. */
	if (deepEntry_check_r2_B_tr0_tr0(handle) == bool_true)
	{ 
		deepEntry_effect_r2_B_tr0(handle);
	}  else
	{
		if (deepEntry_check_r2_B_r_BA_tr0_tr0(handle) == bool_true)
		{ 
			deepEntry_effect_r2_B_r_BA_tr0(handle);
		}  else
		{
		}
	}
}

/* The reactions of state BB. */
static void deepEntry_react_r2_B_r_BB(DeepEntry* handle)
{
	/* The reactions of state BB. */
	if (deepEntry_check_r2_B_tr0_tr0(handle) == bool_true)
	{ 
		deepEntry_effect_r2_B_tr0(handle);
	}  else
	{
	}
}

/* The reactions of state C. */
static void deepEntry_react_r2_C(DeepEntry* handle)
{
	/* The reactions of state C. */
	if (deepEntry_check_r2_C_tr0_tr0(handle) == bool_true)
	{ 
		deepEntry_effect_r2_C_tr0(handle);
	} 
}

/* The reactions of state DAA. */
static void deepEntry_react_r3_D_r_DA_r_DAA(DeepEntry* handle)
{
	/* The reactions of state DAA. */
}

/* Default react sequence for initial entry  */
static void deepEntry_react_r__entry_Default(DeepEntry* handle)
{
	/* Default react sequence for initial entry  */
	deepEntry_enact_r_A(handle);
	deepEntry_enseq_r_A_r_B_default(handle);
}

/* Default react sequence for shallow history entry  */
static void deepEntry_react_r2_B_r__entry_Default(DeepEntry* handle)
{
	/* Default react sequence for shallow history entry  */
	/* Enter the region with shallow history */
	if (handle->historyVector[0] != DeepEntry_last_state)
	{
		deepEntry_shenseq_r2_B_r(handle);
	} else
	{
		deepEntry_enact_r2_B_r_BA(handle);
		deepEntry_enseq_r2_B_r_BA_r_BAA_default(handle);
		handle->historyVector[0] = handle->stateConfVector[1];
	} 
}

/* Default react sequence for initial entry  */
static void deepEntry_react_r2_B_r_BA_r__entry_Default(DeepEntry* handle)
{
	/* Default react sequence for initial entry  */
	deepEntry_enseq_r2_B_r_BA_r_BAA_default(handle);
}

/* Default react sequence for initial entry  */
static void deepEntry_react_r2__entry_Default(DeepEntry* handle)
{
	/* Default react sequence for initial entry  */
	deepEntry_enseq_r2_B_default(handle);
}

/* Default react sequence for deep history entry  */
static void deepEntry_react_r3__entry_Default(DeepEntry* handle)
{
	/* Default react sequence for deep history entry  */
	/* Enter the region with deep history */
	if (handle->historyVector[1] != DeepEntry_last_state)
	{
		deepEntry_dhenseq_r3(handle);
	} else
	{
		deepEntry_enact_r3_D(handle);
		deepEntry_enact_r3_D_r_DA(handle);
		deepEntry_enseq_r3_D_r_DA_r_DAA_default(handle);
		handle->historyVector[2] = handle->stateConfVector[2];
		handle->historyVector[1] = handle->stateConfVector[2];
	} 
}


