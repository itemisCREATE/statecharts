
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "EntryReactionAction.h"
/*! \file Implementation of the state machine 'EntryReactionAction'
*/

/* prototypes of all internal functions */
static sc_boolean entryReactionAction_check_EntryReactionAction_r2_B_tr0_tr0(const EntryReactionAction* handle);
static sc_boolean entryReactionAction_check_EntryReactionAction_r2_B_r_BA_tr0_tr0(const EntryReactionAction* handle);
static sc_boolean entryReactionAction_check_EntryReactionAction_r2_B_r_BB_tr0_tr0(const EntryReactionAction* handle);
static sc_boolean entryReactionAction_check_EntryReactionAction_r2_D_tr0_tr0(const EntryReactionAction* handle);
static sc_boolean entryReactionAction_check_EntryReactionAction_r2_D_tr1_tr1(const EntryReactionAction* handle);
static void entryReactionAction_effect_EntryReactionAction_r2_B_tr0(EntryReactionAction* handle);
static void entryReactionAction_effect_EntryReactionAction_r2_B_r_BA_tr0(EntryReactionAction* handle);
static void entryReactionAction_effect_EntryReactionAction_r2_B_r_BB_tr0(EntryReactionAction* handle);
static void entryReactionAction_effect_EntryReactionAction_r2_D_tr0(EntryReactionAction* handle);
static void entryReactionAction_effect_EntryReactionAction_r2_D_tr1(EntryReactionAction* handle);
static void entryReactionAction_enseq_EntryReactionAction_r2_B_default(EntryReactionAction* handle);
static void entryReactionAction_enseq_EntryReactionAction_r2_B_other(EntryReactionAction* handle);
static void entryReactionAction_enseq_EntryReactionAction_r2_B_r_BA_default(EntryReactionAction* handle);
static void entryReactionAction_enseq_EntryReactionAction_r2_B_r_BB_default(EntryReactionAction* handle);
static void entryReactionAction_enseq_EntryReactionAction_r2_D_default(EntryReactionAction* handle);
static void entryReactionAction_enseq_EntryReactionAction_r1_A_default(EntryReactionAction* handle);
static void entryReactionAction_enseq_EntryReactionAction_r2_default(EntryReactionAction* handle);
static void entryReactionAction_enseq_EntryReactionAction_r2_B_r_default(EntryReactionAction* handle);
static void entryReactionAction_enseq_EntryReactionAction_r2_B_r_other(EntryReactionAction* handle);
static void entryReactionAction_shenseq_EntryReactionAction_r2_B_r(EntryReactionAction* handle);
static void entryReactionAction_enseq_EntryReactionAction_r1_default(EntryReactionAction* handle);
static void entryReactionAction_exseq_EntryReactionAction_r2_B(EntryReactionAction* handle);
static void entryReactionAction_exseq_EntryReactionAction_r2_B_r_BA(EntryReactionAction* handle);
static void entryReactionAction_exseq_EntryReactionAction_r2_B_r_BB(EntryReactionAction* handle);
static void entryReactionAction_exseq_EntryReactionAction_r2_D(EntryReactionAction* handle);
static void entryReactionAction_exseq_EntryReactionAction_r1_A(EntryReactionAction* handle);
static void entryReactionAction_exseq_EntryReactionAction_r2(EntryReactionAction* handle);
static void entryReactionAction_exseq_EntryReactionAction_r2_B_r(EntryReactionAction* handle);
static void entryReactionAction_exseq_EntryReactionAction_r1(EntryReactionAction* handle);
static void entryReactionAction_react_EntryReactionAction_r2_B_r_BA(EntryReactionAction* handle);
static void entryReactionAction_react_EntryReactionAction_r2_B_r_BB(EntryReactionAction* handle);
static void entryReactionAction_react_EntryReactionAction_r2_D(EntryReactionAction* handle);
static void entryReactionAction_react_EntryReactionAction_r1_A(EntryReactionAction* handle);
static void entryReactionAction_react_EntryReactionAction_r2_default(EntryReactionAction* handle);
static void entryReactionAction_react_EntryReactionAction_r2_B_r_default(EntryReactionAction* handle);
static void entryReactionAction_react_EntryReactionAction_r2_B_r_other(EntryReactionAction* handle);
static void entryReactionAction_react_EntryReactionAction_r1__entry_Default(EntryReactionAction* handle);
static void entryReactionAction_clearInEvents(EntryReactionAction* handle);
static void entryReactionAction_clearOutEvents(EntryReactionAction* handle);


void entryReactionAction_init(EntryReactionAction* handle)
{
	sc_integer i;

	for (i = 0; i < ENTRYREACTIONACTION_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = EntryReactionAction_last_state;
	}
	
	for (i = 0; i < ENTRYREACTIONACTION_MAX_HISTORY_STATES; ++i)
	{
		handle->historyVector[i] = EntryReactionAction_last_state;
	}
	
	handle->stateConfVectorPosition = 0;

	entryReactionAction_clearInEvents(handle);
	entryReactionAction_clearOutEvents(handle);

	/* Default init sequence for statechart EntryReactionAction */
	handle->iface.enteredR1 = bool_false;
	handle->iface.enteredR2 = bool_false;
	handle->iface.enteredBdefault = bool_false;
	handle->iface.enteredBother = bool_false;

}

void entryReactionAction_enter(EntryReactionAction* handle)
{
	/* Default enter sequence for statechart EntryReactionAction */
	entryReactionAction_enseq_EntryReactionAction_r2_default(handle);
	entryReactionAction_enseq_EntryReactionAction_r1_default(handle);
}

void entryReactionAction_exit(EntryReactionAction* handle)
{
	/* Default exit sequence for statechart EntryReactionAction */
	entryReactionAction_exseq_EntryReactionAction_r2(handle);
	entryReactionAction_exseq_EntryReactionAction_r1(handle);
}

sc_boolean entryReactionAction_isActive(const EntryReactionAction* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != EntryReactionAction_last_state || handle->stateConfVector[1] != EntryReactionAction_last_state)
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
sc_boolean entryReactionAction_isFinal(const EntryReactionAction* handle)
{
   return bool_false;
}

static void entryReactionAction_clearInEvents(EntryReactionAction* handle)
{
	handle->iface.b_raised = bool_false;
	handle->iface.d_raised = bool_false;
}

static void entryReactionAction_clearOutEvents(EntryReactionAction* handle)
{
}

void entryReactionAction_runCycle(EntryReactionAction* handle)
{
	
	entryReactionAction_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < ENTRYREACTIONACTION_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case EntryReactionAction_EntryReactionAction_r2_B_r_BA :
		{
			entryReactionAction_react_EntryReactionAction_r2_B_r_BA(handle);
			break;
		}
		case EntryReactionAction_EntryReactionAction_r2_B_r_BB :
		{
			entryReactionAction_react_EntryReactionAction_r2_B_r_BB(handle);
			break;
		}
		case EntryReactionAction_EntryReactionAction_r2_D :
		{
			entryReactionAction_react_EntryReactionAction_r2_D(handle);
			break;
		}
		case EntryReactionAction_EntryReactionAction_r1_A :
		{
			entryReactionAction_react_EntryReactionAction_r1_A(handle);
			break;
		}
		default:
			break;
		}
	}
	
	entryReactionAction_clearInEvents(handle);
}


sc_boolean entryReactionAction_isStateActive(const EntryReactionAction* handle, EntryReactionActionStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case EntryReactionAction_EntryReactionAction_r2_B :
			result = (sc_boolean) (handle->stateConfVector[0] >= EntryReactionAction_EntryReactionAction_r2_B
				&& handle->stateConfVector[0] <= EntryReactionAction_EntryReactionAction_r2_B_r_BB);
			break;
		case EntryReactionAction_EntryReactionAction_r2_B_r_BA :
			result = (sc_boolean) (handle->stateConfVector[0] == EntryReactionAction_EntryReactionAction_r2_B_r_BA
			);
			break;
		case EntryReactionAction_EntryReactionAction_r2_B_r_BB :
			result = (sc_boolean) (handle->stateConfVector[0] == EntryReactionAction_EntryReactionAction_r2_B_r_BB
			);
			break;
		case EntryReactionAction_EntryReactionAction_r2_D :
			result = (sc_boolean) (handle->stateConfVector[0] == EntryReactionAction_EntryReactionAction_r2_D
			);
			break;
		case EntryReactionAction_EntryReactionAction_r1_A :
			result = (sc_boolean) (handle->stateConfVector[1] == EntryReactionAction_EntryReactionAction_r1_A
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void entryReactionActionIface_raise_b(EntryReactionAction* handle)
{
	handle->iface.b_raised = bool_true;
}
void entryReactionActionIface_raise_d(EntryReactionAction* handle)
{
	handle->iface.d_raised = bool_true;
}


sc_boolean entryReactionActionIface_get_enteredR1(const EntryReactionAction* handle)
{
	return handle->iface.enteredR1;
}
void entryReactionActionIface_set_enteredR1(EntryReactionAction* handle, sc_boolean value)
{
	handle->iface.enteredR1 = value;
}
sc_boolean entryReactionActionIface_get_enteredR2(const EntryReactionAction* handle)
{
	return handle->iface.enteredR2;
}
void entryReactionActionIface_set_enteredR2(EntryReactionAction* handle, sc_boolean value)
{
	handle->iface.enteredR2 = value;
}
sc_boolean entryReactionActionIface_get_enteredBdefault(const EntryReactionAction* handle)
{
	return handle->iface.enteredBdefault;
}
void entryReactionActionIface_set_enteredBdefault(EntryReactionAction* handle, sc_boolean value)
{
	handle->iface.enteredBdefault = value;
}
sc_boolean entryReactionActionIface_get_enteredBother(const EntryReactionAction* handle)
{
	return handle->iface.enteredBother;
}
void entryReactionActionIface_set_enteredBother(EntryReactionAction* handle, sc_boolean value)
{
	handle->iface.enteredBother = value;
}

/* implementations of all internal functions */

static sc_boolean entryReactionAction_check_EntryReactionAction_r2_B_tr0_tr0(const EntryReactionAction* handle)
{
	return handle->iface.d_raised;
}

static sc_boolean entryReactionAction_check_EntryReactionAction_r2_B_r_BA_tr0_tr0(const EntryReactionAction* handle)
{
	return handle->iface.b_raised;
}

static sc_boolean entryReactionAction_check_EntryReactionAction_r2_B_r_BB_tr0_tr0(const EntryReactionAction* handle)
{
	return handle->iface.b_raised;
}

static sc_boolean entryReactionAction_check_EntryReactionAction_r2_D_tr0_tr0(const EntryReactionAction* handle)
{
	return handle->iface.b_raised;
}

static sc_boolean entryReactionAction_check_EntryReactionAction_r2_D_tr1_tr1(const EntryReactionAction* handle)
{
	return handle->iface.d_raised;
}

static void entryReactionAction_effect_EntryReactionAction_r2_B_tr0(EntryReactionAction* handle)
{
	entryReactionAction_exseq_EntryReactionAction_r2_B(handle);
	entryReactionAction_enseq_EntryReactionAction_r2_D_default(handle);
}

static void entryReactionAction_effect_EntryReactionAction_r2_B_r_BA_tr0(EntryReactionAction* handle)
{
	entryReactionAction_exseq_EntryReactionAction_r2_B_r_BA(handle);
	entryReactionAction_enseq_EntryReactionAction_r2_B_r_BB_default(handle);
}

static void entryReactionAction_effect_EntryReactionAction_r2_B_r_BB_tr0(EntryReactionAction* handle)
{
	entryReactionAction_exseq_EntryReactionAction_r2_B_r_BB(handle);
	entryReactionAction_enseq_EntryReactionAction_r2_B_r_BA_default(handle);
}

static void entryReactionAction_effect_EntryReactionAction_r2_D_tr0(EntryReactionAction* handle)
{
	entryReactionAction_exseq_EntryReactionAction_r2_D(handle);
	entryReactionAction_enseq_EntryReactionAction_r2_B_other(handle);
}

static void entryReactionAction_effect_EntryReactionAction_r2_D_tr1(EntryReactionAction* handle)
{
	entryReactionAction_exseq_EntryReactionAction_r2_D(handle);
	entryReactionAction_enseq_EntryReactionAction_r2_B_default(handle);
}

/* 'default' enter sequence for state B */
static void entryReactionAction_enseq_EntryReactionAction_r2_B_default(EntryReactionAction* handle)
{
	/* 'default' enter sequence for state B */
	entryReactionAction_enseq_EntryReactionAction_r2_B_r_default(handle);
}

/* 'other' enter sequence for state B */
static void entryReactionAction_enseq_EntryReactionAction_r2_B_other(EntryReactionAction* handle)
{
	/* 'other' enter sequence for state B */
	entryReactionAction_enseq_EntryReactionAction_r2_B_r_other(handle);
}

/* 'default' enter sequence for state BA */
static void entryReactionAction_enseq_EntryReactionAction_r2_B_r_BA_default(EntryReactionAction* handle)
{
	/* 'default' enter sequence for state BA */
	handle->stateConfVector[0] = EntryReactionAction_EntryReactionAction_r2_B_r_BA;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state BB */
static void entryReactionAction_enseq_EntryReactionAction_r2_B_r_BB_default(EntryReactionAction* handle)
{
	/* 'default' enter sequence for state BB */
	handle->stateConfVector[0] = EntryReactionAction_EntryReactionAction_r2_B_r_BB;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state D */
static void entryReactionAction_enseq_EntryReactionAction_r2_D_default(EntryReactionAction* handle)
{
	/* 'default' enter sequence for state D */
	handle->stateConfVector[0] = EntryReactionAction_EntryReactionAction_r2_D;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state A */
static void entryReactionAction_enseq_EntryReactionAction_r1_A_default(EntryReactionAction* handle)
{
	/* 'default' enter sequence for state A */
	handle->stateConfVector[1] = EntryReactionAction_EntryReactionAction_r1_A;
	handle->stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region r2 */
static void entryReactionAction_enseq_EntryReactionAction_r2_default(EntryReactionAction* handle)
{
	/* 'default' enter sequence for region r2 */
	entryReactionAction_react_EntryReactionAction_r2_default(handle);
}

/* 'default' enter sequence for region r */
static void entryReactionAction_enseq_EntryReactionAction_r2_B_r_default(EntryReactionAction* handle)
{
	/* 'default' enter sequence for region r */
	entryReactionAction_react_EntryReactionAction_r2_B_r_default(handle);
}

/* 'other' enter sequence for region r */
static void entryReactionAction_enseq_EntryReactionAction_r2_B_r_other(EntryReactionAction* handle)
{
	/* 'other' enter sequence for region r */
	entryReactionAction_react_EntryReactionAction_r2_B_r_other(handle);
}

/* shallow enterSequence with history in child r */
static void entryReactionAction_shenseq_EntryReactionAction_r2_B_r(EntryReactionAction* handle)
{
	/* shallow enterSequence with history in child r */
	/* Handle shallow history entry of r */
	switch(handle->historyVector[ 0 ])
	{
		case EntryReactionAction_EntryReactionAction_r2_B_r_BA :
		{
			entryReactionAction_enseq_EntryReactionAction_r2_B_r_BA_default(handle);
			break;
		}
		case EntryReactionAction_EntryReactionAction_r2_B_r_BB :
		{
			entryReactionAction_enseq_EntryReactionAction_r2_B_r_BB_default(handle);
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region r1 */
static void entryReactionAction_enseq_EntryReactionAction_r1_default(EntryReactionAction* handle)
{
	/* 'default' enter sequence for region r1 */
	entryReactionAction_react_EntryReactionAction_r1__entry_Default(handle);
}

/* Default exit sequence for state B */
static void entryReactionAction_exseq_EntryReactionAction_r2_B(EntryReactionAction* handle)
{
	/* Default exit sequence for state B */
	entryReactionAction_exseq_EntryReactionAction_r2_B_r(handle);
}

/* Default exit sequence for state BA */
static void entryReactionAction_exseq_EntryReactionAction_r2_B_r_BA(EntryReactionAction* handle)
{
	/* Default exit sequence for state BA */
	handle->stateConfVector[0] = EntryReactionAction_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state BB */
static void entryReactionAction_exseq_EntryReactionAction_r2_B_r_BB(EntryReactionAction* handle)
{
	/* Default exit sequence for state BB */
	handle->stateConfVector[0] = EntryReactionAction_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state D */
static void entryReactionAction_exseq_EntryReactionAction_r2_D(EntryReactionAction* handle)
{
	/* Default exit sequence for state D */
	handle->stateConfVector[0] = EntryReactionAction_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state A */
static void entryReactionAction_exseq_EntryReactionAction_r1_A(EntryReactionAction* handle)
{
	/* Default exit sequence for state A */
	handle->stateConfVector[1] = EntryReactionAction_last_state;
	handle->stateConfVectorPosition = 1;
}

/* Default exit sequence for region r2 */
static void entryReactionAction_exseq_EntryReactionAction_r2(EntryReactionAction* handle)
{
	/* Default exit sequence for region r2 */
	/* Handle exit of all possible states (of entries.EntryReactionAction.r2) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case EntryReactionAction_EntryReactionAction_r2_B_r_BA :
		{
			entryReactionAction_exseq_EntryReactionAction_r2_B_r_BA(handle);
			break;
		}
		case EntryReactionAction_EntryReactionAction_r2_B_r_BB :
		{
			entryReactionAction_exseq_EntryReactionAction_r2_B_r_BB(handle);
			break;
		}
		case EntryReactionAction_EntryReactionAction_r2_D :
		{
			entryReactionAction_exseq_EntryReactionAction_r2_D(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
static void entryReactionAction_exseq_EntryReactionAction_r2_B_r(EntryReactionAction* handle)
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of entries.EntryReactionAction.r2.B.r) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case EntryReactionAction_EntryReactionAction_r2_B_r_BA :
		{
			entryReactionAction_exseq_EntryReactionAction_r2_B_r_BA(handle);
			break;
		}
		case EntryReactionAction_EntryReactionAction_r2_B_r_BB :
		{
			entryReactionAction_exseq_EntryReactionAction_r2_B_r_BB(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r1 */
static void entryReactionAction_exseq_EntryReactionAction_r1(EntryReactionAction* handle)
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of entries.EntryReactionAction.r1) at position 1... */
	switch(handle->stateConfVector[ 1 ])
	{
		case EntryReactionAction_EntryReactionAction_r1_A :
		{
			entryReactionAction_exseq_EntryReactionAction_r1_A(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state BA. */
static void entryReactionAction_react_EntryReactionAction_r2_B_r_BA(EntryReactionAction* handle)
{
	/* The reactions of state BA. */
	if (entryReactionAction_check_EntryReactionAction_r2_B_tr0_tr0(handle) == bool_true)
	{ 
		entryReactionAction_effect_EntryReactionAction_r2_B_tr0(handle);
	}  else
	{
		if (entryReactionAction_check_EntryReactionAction_r2_B_r_BA_tr0_tr0(handle) == bool_true)
		{ 
			entryReactionAction_effect_EntryReactionAction_r2_B_r_BA_tr0(handle);
		} 
	}
}

/* The reactions of state BB. */
static void entryReactionAction_react_EntryReactionAction_r2_B_r_BB(EntryReactionAction* handle)
{
	/* The reactions of state BB. */
	if (entryReactionAction_check_EntryReactionAction_r2_B_tr0_tr0(handle) == bool_true)
	{ 
		entryReactionAction_effect_EntryReactionAction_r2_B_tr0(handle);
	}  else
	{
		if (entryReactionAction_check_EntryReactionAction_r2_B_r_BB_tr0_tr0(handle) == bool_true)
		{ 
			entryReactionAction_effect_EntryReactionAction_r2_B_r_BB_tr0(handle);
		} 
	}
}

/* The reactions of state D. */
static void entryReactionAction_react_EntryReactionAction_r2_D(EntryReactionAction* handle)
{
	/* The reactions of state D. */
	if (entryReactionAction_check_EntryReactionAction_r2_D_tr0_tr0(handle) == bool_true)
	{ 
		entryReactionAction_effect_EntryReactionAction_r2_D_tr0(handle);
	}  else
	{
		if (entryReactionAction_check_EntryReactionAction_r2_D_tr1_tr1(handle) == bool_true)
		{ 
			entryReactionAction_effect_EntryReactionAction_r2_D_tr1(handle);
		} 
	}
}

/* The reactions of state A. */
static void entryReactionAction_react_EntryReactionAction_r1_A(EntryReactionAction* handle)
{
}

/* Default react sequence for initial entry default */
static void entryReactionAction_react_EntryReactionAction_r2_default(EntryReactionAction* handle)
{
	/* Default react sequence for initial entry default */
	handle->iface.enteredR2 = bool_true;
	entryReactionAction_enseq_EntryReactionAction_r2_B_default(handle);
}

/* Default react sequence for shallow history entry default */
static void entryReactionAction_react_EntryReactionAction_r2_B_r_default(EntryReactionAction* handle)
{
	/* Default react sequence for shallow history entry default */
	/* Enter the region with shallow history */
	if (handle->historyVector[0] != EntryReactionAction_last_state)
	{
		entryReactionAction_shenseq_EntryReactionAction_r2_B_r(handle);
	} else
	{
		handle->iface.enteredBdefault = bool_true;
		entryReactionAction_enseq_EntryReactionAction_r2_B_r_BA_default(handle);
	} 
}

/* Default react sequence for initial entry other */
static void entryReactionAction_react_EntryReactionAction_r2_B_r_other(EntryReactionAction* handle)
{
	/* Default react sequence for initial entry other */
	handle->iface.enteredBother = bool_true;
	entryReactionAction_enseq_EntryReactionAction_r2_B_r_BB_default(handle);
}

/* Default react sequence for initial entry  */
static void entryReactionAction_react_EntryReactionAction_r1__entry_Default(EntryReactionAction* handle)
{
	/* Default react sequence for initial entry  */
	handle->iface.enteredR1 = bool_true;
	entryReactionAction_enseq_EntryReactionAction_r1_A_default(handle);
}


