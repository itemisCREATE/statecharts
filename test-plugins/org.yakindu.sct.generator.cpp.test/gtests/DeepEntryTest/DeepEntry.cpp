
#include "DeepEntry.h"
#include <string.h>

/*! \file Implementation of the state machine 'DeepEntry'
*/

DeepEntry::DeepEntry()
{
	
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = DeepEntry_last_state;
	
	stateConfVectorPosition = 0;
	
}

DeepEntry::~DeepEntry()
{
}


void DeepEntry::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = DeepEntry_last_state;
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = DeepEntry_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart DeepEntry */
	iface.x = 0;
	iface.y = 0;
	iface.z = 0;
}

void DeepEntry::enter()
{
	/* Default enter sequence for statechart DeepEntry */
	enseq_r_default();
	enseq_r2_default();
	enseq_r3_default();
}

void DeepEntry::exit()
{
	/* Default exit sequence for statechart DeepEntry */
	exseq_r();
	exseq_r2();
	exseq_r3();
}

sc_boolean DeepEntry::isActive() const
{
	return stateConfVector[0] != DeepEntry_last_state||stateConfVector[1] != DeepEntry_last_state||stateConfVector[2] != DeepEntry_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean DeepEntry::isFinal() const
{
   return false;}

void DeepEntry::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case r_A_r_B :
		{
			react_r_A_r_B();
			break;
		}
		case r2_B_r_BA_r_BAA :
		{
			react_r2_B_r_BA_r_BAA();
			break;
		}
		case r2_B_r_BB :
		{
			react_r2_B_r_BB();
			break;
		}
		case r2_C :
		{
			react_r2_C();
			break;
		}
		case r3_D_r_DA_r_DAA :
		{
			react_r3_D_r_DA_r_DAA();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void DeepEntry::clearInEvents()
{
	iface.e_raised = false;
	iface.f_raised = false;
}

void DeepEntry::clearOutEvents()
{
}


sc_boolean DeepEntry::isStateActive(DeepEntryStates state) const
{
	switch (state)
	{
		case r_A : 
			return (sc_boolean) (stateConfVector[0] >= r_A
				&& stateConfVector[0] <= r_A_r_B);
		case r_A_r_B : 
			return (sc_boolean) (stateConfVector[0] == r_A_r_B
			);
		case r2_B : 
			return (sc_boolean) (stateConfVector[1] >= r2_B
				&& stateConfVector[1] <= r2_B_r_BB);
		case r2_B_r_BA : 
			return (sc_boolean) (stateConfVector[1] >= r2_B_r_BA
				&& stateConfVector[1] <= r2_B_r_BA_r_BAA);
		case r2_B_r_BA_r_BAA : 
			return (sc_boolean) (stateConfVector[1] == r2_B_r_BA_r_BAA
			);
		case r2_B_r_BB : 
			return (sc_boolean) (stateConfVector[1] == r2_B_r_BB
			);
		case r2_C : 
			return (sc_boolean) (stateConfVector[1] == r2_C
			);
		case r3_D : 
			return (sc_boolean) (stateConfVector[2] >= r3_D
				&& stateConfVector[2] <= r3_D_r_DA_r_DAA);
		case r3_D_r_DA : 
			return (sc_boolean) (stateConfVector[2] >= r3_D_r_DA
				&& stateConfVector[2] <= r3_D_r_DA_r_DAA);
		case r3_D_r_DA_r_DAA : 
			return (sc_boolean) (stateConfVector[2] == r3_D_r_DA_r_DAA
			);
		default: return false;
	}
}

DeepEntry::DefaultSCI* DeepEntry::getDefaultSCI()
{
	return &iface;
}

void DeepEntry::DefaultSCI::raise_e()
{
	e_raised = true;
}

void DeepEntry::raise_e()
{
	iface.raise_e();
}

void DeepEntry::DefaultSCI::raise_f()
{
	f_raised = true;
}

void DeepEntry::raise_f()
{
	iface.raise_f();
}


sc_integer DeepEntry::DefaultSCI::get_x() const
{
	return x;
}

sc_integer DeepEntry::get_x() const
{
	return iface.x;
}

void DeepEntry::DefaultSCI::set_x(sc_integer value)
{
	x = value;
}

void DeepEntry::set_x(sc_integer value)
{
	iface.x = value;
}

sc_integer DeepEntry::DefaultSCI::get_y() const
{
	return y;
}

sc_integer DeepEntry::get_y() const
{
	return iface.y;
}

void DeepEntry::DefaultSCI::set_y(sc_integer value)
{
	y = value;
}

void DeepEntry::set_y(sc_integer value)
{
	iface.y = value;
}

sc_integer DeepEntry::DefaultSCI::get_z() const
{
	return z;
}

sc_integer DeepEntry::get_z() const
{
	return iface.z;
}

void DeepEntry::DefaultSCI::set_z(sc_integer value)
{
	z = value;
}

void DeepEntry::set_z(sc_integer value)
{
	iface.z = value;
}


// implementations of all internal functions

sc_boolean DeepEntry::check_r2_B_tr0_tr0()
{
	return iface.f_raised;
}

sc_boolean DeepEntry::check_r2_B_r_BA_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean DeepEntry::check_r2_C_tr0_tr0()
{
	return iface.f_raised;
}

void DeepEntry::effect_r2_B_tr0()
{
	exseq_r2_B();
	enseq_r2_C_default();
}

void DeepEntry::effect_r2_B_r_BA_tr0()
{
	exseq_r2_B_r_BA();
	enseq_r2_B_r_BB_default();
}

void DeepEntry::effect_r2_C_tr0()
{
	exseq_r2_C();
	enseq_r2_B_default();
}

/* Entry action for state 'A'. */
void DeepEntry::enact_r_A()
{
	/* Entry action for state 'A'. */
	iface.x += 1;
}

/* Entry action for state 'BA'. */
void DeepEntry::enact_r2_B_r_BA()
{
	/* Entry action for state 'BA'. */
	iface.y += 1;
}

/* Entry action for state 'D'. */
void DeepEntry::enact_r3_D()
{
	/* Entry action for state 'D'. */
	iface.z += 1;
}

/* Entry action for state 'DA'. */
void DeepEntry::enact_r3_D_r_DA()
{
	/* Entry action for state 'DA'. */
	iface.z += 1;
}

/* 'default' enter sequence for state B */
void DeepEntry::enseq_r_A_r_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = r_A_r_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void DeepEntry::enseq_r2_B_default()
{
	/* 'default' enter sequence for state B */
	enseq_r2_B_r_default();
}

/* 'default' enter sequence for state BA */
void DeepEntry::enseq_r2_B_r_BA_default()
{
	/* 'default' enter sequence for state BA */
	enact_r2_B_r_BA();
	enseq_r2_B_r_BA_r_default();
	historyVector[0] = stateConfVector[1];
}

/* 'default' enter sequence for state BAA */
void DeepEntry::enseq_r2_B_r_BA_r_BAA_default()
{
	/* 'default' enter sequence for state BAA */
	stateConfVector[1] = r2_B_r_BA_r_BAA;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state BB */
void DeepEntry::enseq_r2_B_r_BB_default()
{
	/* 'default' enter sequence for state BB */
	stateConfVector[1] = r2_B_r_BB;
	stateConfVectorPosition = 1;
	historyVector[0] = stateConfVector[1];
}

/* 'default' enter sequence for state C */
void DeepEntry::enseq_r2_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[1] = r2_C;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state DAA */
void DeepEntry::enseq_r3_D_r_DA_r_DAA_default()
{
	/* 'default' enter sequence for state DAA */
	stateConfVector[2] = r3_D_r_DA_r_DAA;
	stateConfVectorPosition = 2;
	historyVector[3] = stateConfVector[2];
}

/* 'default' enter sequence for region r */
void DeepEntry::enseq_r_default()
{
	/* 'default' enter sequence for region r */
	react_r__entry_Default();
}

/* 'default' enter sequence for region r2 */
void DeepEntry::enseq_r2_default()
{
	/* 'default' enter sequence for region r2 */
	react_r2__entry_Default();
}

/* 'default' enter sequence for region r */
void DeepEntry::enseq_r2_B_r_default()
{
	/* 'default' enter sequence for region r */
	react_r2_B_r__entry_Default();
}

/* shallow enterSequence with history in child r */
void DeepEntry::shenseq_r2_B_r()
{
	/* shallow enterSequence with history in child r */
	/* Handle shallow history entry of r */
	switch(historyVector[ 0 ])
	{
		case r2_B_r_BA_r_BAA :
		{
			enseq_r2_B_r_BA_default();
			break;
		}
		case r2_B_r_BB :
		{
			enseq_r2_B_r_BB_default();
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region r */
void DeepEntry::enseq_r2_B_r_BA_r_default()
{
	/* 'default' enter sequence for region r */
	react_r2_B_r_BA_r__entry_Default();
}

/* 'default' enter sequence for region r3 */
void DeepEntry::enseq_r3_default()
{
	/* 'default' enter sequence for region r3 */
	react_r3__entry_Default();
}

/* deep enterSequence with history in child r3 */
void DeepEntry::dhenseq_r3()
{
	/* deep enterSequence with history in child r3 */
	/* Handle deep history entry of r3 */
	switch(historyVector[ 1 ])
	{
		case r3_D_r_DA_r_DAA :
		{
			/* enterSequence with history in child D for leaf DAA */
			enact_r3_D();
			dhenseq_r3_D_r();
			break;
		}
		default: break;
	}
}

/* deep enterSequence with history in child r */
void DeepEntry::dhenseq_r3_D_r()
{
	/* deep enterSequence with history in child r */
	/* Handle deep history entry of r */
	switch(historyVector[ 2 ])
	{
		case r3_D_r_DA_r_DAA :
		{
			/* enterSequence with history in child DA for leaf DAA */
			enact_r3_D_r_DA();
			dhenseq_r3_D_r_DA_r();
			break;
		}
		default: break;
	}
}

/* deep enterSequence with history in child r */
void DeepEntry::dhenseq_r3_D_r_DA_r()
{
	/* deep enterSequence with history in child r */
	/* Handle deep history entry of r */
	switch(historyVector[ 3 ])
	{
		case r3_D_r_DA_r_DAA :
		{
			/* enterSequence with history in child DAA for leaf DAA */
			enseq_r3_D_r_DA_r_DAA_default();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for state B */
void DeepEntry::exseq_r_A_r_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = DeepEntry_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void DeepEntry::exseq_r2_B()
{
	/* Default exit sequence for state B */
	exseq_r2_B_r();
}

/* Default exit sequence for state BA */
void DeepEntry::exseq_r2_B_r_BA()
{
	/* Default exit sequence for state BA */
	exseq_r2_B_r_BA_r();
}

/* Default exit sequence for state BAA */
void DeepEntry::exseq_r2_B_r_BA_r_BAA()
{
	/* Default exit sequence for state BAA */
	stateConfVector[1] = DeepEntry_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state BB */
void DeepEntry::exseq_r2_B_r_BB()
{
	/* Default exit sequence for state BB */
	stateConfVector[1] = DeepEntry_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state C */
void DeepEntry::exseq_r2_C()
{
	/* Default exit sequence for state C */
	stateConfVector[1] = DeepEntry_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state DAA */
void DeepEntry::exseq_r3_D_r_DA_r_DAA()
{
	/* Default exit sequence for state DAA */
	stateConfVector[2] = DeepEntry_last_state;
	stateConfVectorPosition = 2;
}

/* Default exit sequence for region r */
void DeepEntry::exseq_r()
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of DeepEntry.r) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case r_A_r_B :
		{
			exseq_r_A_r_B();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
void DeepEntry::exseq_r_A_r()
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of DeepEntry.r.A.r) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case r_A_r_B :
		{
			exseq_r_A_r_B();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r2 */
void DeepEntry::exseq_r2()
{
	/* Default exit sequence for region r2 */
	/* Handle exit of all possible states (of DeepEntry.r2) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case r2_B_r_BA_r_BAA :
		{
			exseq_r2_B_r_BA_r_BAA();
			break;
		}
		case r2_B_r_BB :
		{
			exseq_r2_B_r_BB();
			break;
		}
		case r2_C :
		{
			exseq_r2_C();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
void DeepEntry::exseq_r2_B_r()
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of DeepEntry.r2.B.r) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case r2_B_r_BA_r_BAA :
		{
			exseq_r2_B_r_BA_r_BAA();
			break;
		}
		case r2_B_r_BB :
		{
			exseq_r2_B_r_BB();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
void DeepEntry::exseq_r2_B_r_BA_r()
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of DeepEntry.r2.B.r.BA.r) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case r2_B_r_BA_r_BAA :
		{
			exseq_r2_B_r_BA_r_BAA();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r3 */
void DeepEntry::exseq_r3()
{
	/* Default exit sequence for region r3 */
	/* Handle exit of all possible states (of DeepEntry.r3) at position 2... */
	switch(stateConfVector[ 2 ])
	{
		case r3_D_r_DA_r_DAA :
		{
			exseq_r3_D_r_DA_r_DAA();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
void DeepEntry::exseq_r3_D_r()
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of DeepEntry.r3.D.r) at position 2... */
	switch(stateConfVector[ 2 ])
	{
		case r3_D_r_DA_r_DAA :
		{
			exseq_r3_D_r_DA_r_DAA();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
void DeepEntry::exseq_r3_D_r_DA_r()
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of DeepEntry.r3.D.r.DA.r) at position 2... */
	switch(stateConfVector[ 2 ])
	{
		case r3_D_r_DA_r_DAA :
		{
			exseq_r3_D_r_DA_r_DAA();
			break;
		}
		default: break;
	}
}

/* The reactions of state B. */
void DeepEntry::react_r_A_r_B()
{
	/* The reactions of state B. */
}

/* The reactions of state BAA. */
void DeepEntry::react_r2_B_r_BA_r_BAA()
{
	/* The reactions of state BAA. */
	if (check_r2_B_tr0_tr0())
	{ 
		effect_r2_B_tr0();
	}  else
	{
		if (check_r2_B_r_BA_tr0_tr0())
		{ 
			effect_r2_B_r_BA_tr0();
		}  else
		{
		}
	}
}

/* The reactions of state BB. */
void DeepEntry::react_r2_B_r_BB()
{
	/* The reactions of state BB. */
	if (check_r2_B_tr0_tr0())
	{ 
		effect_r2_B_tr0();
	}  else
	{
	}
}

/* The reactions of state C. */
void DeepEntry::react_r2_C()
{
	/* The reactions of state C. */
	if (check_r2_C_tr0_tr0())
	{ 
		effect_r2_C_tr0();
	} 
}

/* The reactions of state DAA. */
void DeepEntry::react_r3_D_r_DA_r_DAA()
{
	/* The reactions of state DAA. */
}

/* Default react sequence for initial entry  */
void DeepEntry::react_r__entry_Default()
{
	/* Default react sequence for initial entry  */
	enact_r_A();
	enseq_r_A_r_B_default();
}

/* Default react sequence for shallow history entry  */
void DeepEntry::react_r2_B_r__entry_Default()
{
	/* Default react sequence for shallow history entry  */
	/* Enter the region with shallow history */
	if (historyVector[0] != DeepEntry_last_state)
	{
		shenseq_r2_B_r();
	} else
	{
		enact_r2_B_r_BA();
		enseq_r2_B_r_BA_r_BAA_default();
		historyVector[0] = stateConfVector[1];
	} 
}

/* Default react sequence for initial entry  */
void DeepEntry::react_r2_B_r_BA_r__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_r2_B_r_BA_r_BAA_default();
}

/* Default react sequence for initial entry  */
void DeepEntry::react_r2__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_r2_B_default();
}

/* Default react sequence for deep history entry  */
void DeepEntry::react_r3__entry_Default()
{
	/* Default react sequence for deep history entry  */
	/* Enter the region with deep history */
	if (historyVector[1] != DeepEntry_last_state)
	{
		dhenseq_r3();
	} else
	{
		enact_r3_D();
		enact_r3_D_r_DA();
		enseq_r3_D_r_DA_r_DAA_default();
		historyVector[2] = stateConfVector[2];
		historyVector[1] = stateConfVector[2];
	} 
}


