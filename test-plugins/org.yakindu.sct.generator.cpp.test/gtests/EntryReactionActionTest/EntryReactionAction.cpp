
#include "EntryReactionAction.h"
#include <string.h>

/*! \file Implementation of the state machine 'EntryReactionAction'
*/

EntryReactionAction::EntryReactionAction()
{
	
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = EntryReactionAction_last_state;
	
	stateConfVectorPosition = 0;
	
}

EntryReactionAction::~EntryReactionAction()
{
}


void EntryReactionAction::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = EntryReactionAction_last_state;
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = EntryReactionAction_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart EntryReactionAction */
	iface.enteredR1 = false;
	iface.enteredR2 = false;
	iface.enteredBdefault = false;
	iface.enteredBother = false;
}

void EntryReactionAction::enter()
{
	/* Default enter sequence for statechart EntryReactionAction */
	enseq_EntryReactionAction_r2_default();
	enseq_EntryReactionAction_r1_default();
}

void EntryReactionAction::exit()
{
	/* Default exit sequence for statechart EntryReactionAction */
	exseq_EntryReactionAction_r2();
	exseq_EntryReactionAction_r1();
}

sc_boolean EntryReactionAction::isActive() const
{
	return stateConfVector[0] != EntryReactionAction_last_state||stateConfVector[1] != EntryReactionAction_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean EntryReactionAction::isFinal() const
{
   return false;}

void EntryReactionAction::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case EntryReactionAction_r2_B_r_BA :
		{
			react_EntryReactionAction_r2_B_r_BA();
			break;
		}
		case EntryReactionAction_r2_B_r_BB :
		{
			react_EntryReactionAction_r2_B_r_BB();
			break;
		}
		case EntryReactionAction_r2_D :
		{
			react_EntryReactionAction_r2_D();
			break;
		}
		case EntryReactionAction_r1_A :
		{
			react_EntryReactionAction_r1_A();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void EntryReactionAction::clearInEvents()
{
	iface.b_raised = false;
	iface.d_raised = false;
}

void EntryReactionAction::clearOutEvents()
{
}


sc_boolean EntryReactionAction::isStateActive(EntryReactionActionStates state) const
{
	switch (state)
	{
		case EntryReactionAction_r2_B : 
			return (sc_boolean) (stateConfVector[0] >= EntryReactionAction_r2_B
				&& stateConfVector[0] <= EntryReactionAction_r2_B_r_BB);
		case EntryReactionAction_r2_B_r_BA : 
			return (sc_boolean) (stateConfVector[0] == EntryReactionAction_r2_B_r_BA
			);
		case EntryReactionAction_r2_B_r_BB : 
			return (sc_boolean) (stateConfVector[0] == EntryReactionAction_r2_B_r_BB
			);
		case EntryReactionAction_r2_D : 
			return (sc_boolean) (stateConfVector[0] == EntryReactionAction_r2_D
			);
		case EntryReactionAction_r1_A : 
			return (sc_boolean) (stateConfVector[1] == EntryReactionAction_r1_A
			);
		default: return false;
	}
}

EntryReactionAction::DefaultSCI* EntryReactionAction::getDefaultSCI()
{
	return &iface;
}

void EntryReactionAction::DefaultSCI::raise_b()
{
	b_raised = true;
}

void EntryReactionAction::raise_b()
{
	iface.raise_b();
}

void EntryReactionAction::DefaultSCI::raise_d()
{
	d_raised = true;
}

void EntryReactionAction::raise_d()
{
	iface.raise_d();
}


sc_boolean EntryReactionAction::DefaultSCI::get_enteredR1() const
{
	return enteredR1;
}

sc_boolean EntryReactionAction::get_enteredR1() const
{
	return iface.enteredR1;
}

void EntryReactionAction::DefaultSCI::set_enteredR1(sc_boolean value)
{
	enteredR1 = value;
}

void EntryReactionAction::set_enteredR1(sc_boolean value)
{
	iface.enteredR1 = value;
}

sc_boolean EntryReactionAction::DefaultSCI::get_enteredR2() const
{
	return enteredR2;
}

sc_boolean EntryReactionAction::get_enteredR2() const
{
	return iface.enteredR2;
}

void EntryReactionAction::DefaultSCI::set_enteredR2(sc_boolean value)
{
	enteredR2 = value;
}

void EntryReactionAction::set_enteredR2(sc_boolean value)
{
	iface.enteredR2 = value;
}

sc_boolean EntryReactionAction::DefaultSCI::get_enteredBdefault() const
{
	return enteredBdefault;
}

sc_boolean EntryReactionAction::get_enteredBdefault() const
{
	return iface.enteredBdefault;
}

void EntryReactionAction::DefaultSCI::set_enteredBdefault(sc_boolean value)
{
	enteredBdefault = value;
}

void EntryReactionAction::set_enteredBdefault(sc_boolean value)
{
	iface.enteredBdefault = value;
}

sc_boolean EntryReactionAction::DefaultSCI::get_enteredBother() const
{
	return enteredBother;
}

sc_boolean EntryReactionAction::get_enteredBother() const
{
	return iface.enteredBother;
}

void EntryReactionAction::DefaultSCI::set_enteredBother(sc_boolean value)
{
	enteredBother = value;
}

void EntryReactionAction::set_enteredBother(sc_boolean value)
{
	iface.enteredBother = value;
}


// implementations of all internal functions

sc_boolean EntryReactionAction::check_EntryReactionAction_r2_B_tr0_tr0()
{
	return iface.d_raised;
}

sc_boolean EntryReactionAction::check_EntryReactionAction_r2_B_r_BA_tr0_tr0()
{
	return iface.b_raised;
}

sc_boolean EntryReactionAction::check_EntryReactionAction_r2_B_r_BB_tr0_tr0()
{
	return iface.b_raised;
}

sc_boolean EntryReactionAction::check_EntryReactionAction_r2_D_tr0_tr0()
{
	return iface.b_raised;
}

sc_boolean EntryReactionAction::check_EntryReactionAction_r2_D_tr1_tr1()
{
	return iface.d_raised;
}

void EntryReactionAction::effect_EntryReactionAction_r2_B_tr0()
{
	exseq_EntryReactionAction_r2_B();
	enseq_EntryReactionAction_r2_D_default();
}

void EntryReactionAction::effect_EntryReactionAction_r2_B_r_BA_tr0()
{
	exseq_EntryReactionAction_r2_B_r_BA();
	enseq_EntryReactionAction_r2_B_r_BB_default();
}

void EntryReactionAction::effect_EntryReactionAction_r2_B_r_BB_tr0()
{
	exseq_EntryReactionAction_r2_B_r_BB();
	enseq_EntryReactionAction_r2_B_r_BA_default();
}

void EntryReactionAction::effect_EntryReactionAction_r2_D_tr0()
{
	exseq_EntryReactionAction_r2_D();
	enseq_EntryReactionAction_r2_B_other();
}

void EntryReactionAction::effect_EntryReactionAction_r2_D_tr1()
{
	exseq_EntryReactionAction_r2_D();
	enseq_EntryReactionAction_r2_B_default();
}

/* 'default' enter sequence for state B */
void EntryReactionAction::enseq_EntryReactionAction_r2_B_default()
{
	/* 'default' enter sequence for state B */
	enseq_EntryReactionAction_r2_B_r_default();
}

/* 'other' enter sequence for state B */
void EntryReactionAction::enseq_EntryReactionAction_r2_B_other()
{
	/* 'other' enter sequence for state B */
	enseq_EntryReactionAction_r2_B_r_other();
}

/* 'default' enter sequence for state BA */
void EntryReactionAction::enseq_EntryReactionAction_r2_B_r_BA_default()
{
	/* 'default' enter sequence for state BA */
	stateConfVector[0] = EntryReactionAction_r2_B_r_BA;
	stateConfVectorPosition = 0;
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state BB */
void EntryReactionAction::enseq_EntryReactionAction_r2_B_r_BB_default()
{
	/* 'default' enter sequence for state BB */
	stateConfVector[0] = EntryReactionAction_r2_B_r_BB;
	stateConfVectorPosition = 0;
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state D */
void EntryReactionAction::enseq_EntryReactionAction_r2_D_default()
{
	/* 'default' enter sequence for state D */
	stateConfVector[0] = EntryReactionAction_r2_D;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state A */
void EntryReactionAction::enseq_EntryReactionAction_r1_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[1] = EntryReactionAction_r1_A;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region r2 */
void EntryReactionAction::enseq_EntryReactionAction_r2_default()
{
	/* 'default' enter sequence for region r2 */
	react_EntryReactionAction_r2_default();
}

/* 'default' enter sequence for region r */
void EntryReactionAction::enseq_EntryReactionAction_r2_B_r_default()
{
	/* 'default' enter sequence for region r */
	react_EntryReactionAction_r2_B_r_default();
}

/* 'other' enter sequence for region r */
void EntryReactionAction::enseq_EntryReactionAction_r2_B_r_other()
{
	/* 'other' enter sequence for region r */
	react_EntryReactionAction_r2_B_r_other();
}

/* shallow enterSequence with history in child r */
void EntryReactionAction::shenseq_EntryReactionAction_r2_B_r()
{
	/* shallow enterSequence with history in child r */
	/* Handle shallow history entry of r */
	switch(historyVector[ 0 ])
	{
		case EntryReactionAction_r2_B_r_BA :
		{
			enseq_EntryReactionAction_r2_B_r_BA_default();
			break;
		}
		case EntryReactionAction_r2_B_r_BB :
		{
			enseq_EntryReactionAction_r2_B_r_BB_default();
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region r1 */
void EntryReactionAction::enseq_EntryReactionAction_r1_default()
{
	/* 'default' enter sequence for region r1 */
	react_EntryReactionAction_r1__entry_Default();
}

/* Default exit sequence for state B */
void EntryReactionAction::exseq_EntryReactionAction_r2_B()
{
	/* Default exit sequence for state B */
	exseq_EntryReactionAction_r2_B_r();
}

/* Default exit sequence for state BA */
void EntryReactionAction::exseq_EntryReactionAction_r2_B_r_BA()
{
	/* Default exit sequence for state BA */
	stateConfVector[0] = EntryReactionAction_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state BB */
void EntryReactionAction::exseq_EntryReactionAction_r2_B_r_BB()
{
	/* Default exit sequence for state BB */
	stateConfVector[0] = EntryReactionAction_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state D */
void EntryReactionAction::exseq_EntryReactionAction_r2_D()
{
	/* Default exit sequence for state D */
	stateConfVector[0] = EntryReactionAction_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state A */
void EntryReactionAction::exseq_EntryReactionAction_r1_A()
{
	/* Default exit sequence for state A */
	stateConfVector[1] = EntryReactionAction_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for region r2 */
void EntryReactionAction::exseq_EntryReactionAction_r2()
{
	/* Default exit sequence for region r2 */
	/* Handle exit of all possible states (of entries.EntryReactionAction.r2) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case EntryReactionAction_r2_B_r_BA :
		{
			exseq_EntryReactionAction_r2_B_r_BA();
			break;
		}
		case EntryReactionAction_r2_B_r_BB :
		{
			exseq_EntryReactionAction_r2_B_r_BB();
			break;
		}
		case EntryReactionAction_r2_D :
		{
			exseq_EntryReactionAction_r2_D();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r */
void EntryReactionAction::exseq_EntryReactionAction_r2_B_r()
{
	/* Default exit sequence for region r */
	/* Handle exit of all possible states (of entries.EntryReactionAction.r2.B.r) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case EntryReactionAction_r2_B_r_BA :
		{
			exseq_EntryReactionAction_r2_B_r_BA();
			break;
		}
		case EntryReactionAction_r2_B_r_BB :
		{
			exseq_EntryReactionAction_r2_B_r_BB();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region r1 */
void EntryReactionAction::exseq_EntryReactionAction_r1()
{
	/* Default exit sequence for region r1 */
	/* Handle exit of all possible states (of entries.EntryReactionAction.r1) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case EntryReactionAction_r1_A :
		{
			exseq_EntryReactionAction_r1_A();
			break;
		}
		default: break;
	}
}

/* The reactions of state BA. */
void EntryReactionAction::react_EntryReactionAction_r2_B_r_BA()
{
	/* The reactions of state BA. */
	if (check_EntryReactionAction_r2_B_tr0_tr0())
	{ 
		effect_EntryReactionAction_r2_B_tr0();
	}  else
	{
		if (check_EntryReactionAction_r2_B_r_BA_tr0_tr0())
		{ 
			effect_EntryReactionAction_r2_B_r_BA_tr0();
		} 
	}
}

/* The reactions of state BB. */
void EntryReactionAction::react_EntryReactionAction_r2_B_r_BB()
{
	/* The reactions of state BB. */
	if (check_EntryReactionAction_r2_B_tr0_tr0())
	{ 
		effect_EntryReactionAction_r2_B_tr0();
	}  else
	{
		if (check_EntryReactionAction_r2_B_r_BB_tr0_tr0())
		{ 
			effect_EntryReactionAction_r2_B_r_BB_tr0();
		} 
	}
}

/* The reactions of state D. */
void EntryReactionAction::react_EntryReactionAction_r2_D()
{
	/* The reactions of state D. */
	if (check_EntryReactionAction_r2_D_tr0_tr0())
	{ 
		effect_EntryReactionAction_r2_D_tr0();
	}  else
	{
		if (check_EntryReactionAction_r2_D_tr1_tr1())
		{ 
			effect_EntryReactionAction_r2_D_tr1();
		} 
	}
}

/* The reactions of state A. */
void EntryReactionAction::react_EntryReactionAction_r1_A()
{
}

/* Default react sequence for initial entry default */
void EntryReactionAction::react_EntryReactionAction_r2_default()
{
	/* Default react sequence for initial entry default */
	iface.enteredR2 = true;
	enseq_EntryReactionAction_r2_B_default();
}

/* Default react sequence for shallow history entry default */
void EntryReactionAction::react_EntryReactionAction_r2_B_r_default()
{
	/* Default react sequence for shallow history entry default */
	/* Enter the region with shallow history */
	if (historyVector[0] != EntryReactionAction_last_state)
	{
		shenseq_EntryReactionAction_r2_B_r();
	} else
	{
		iface.enteredBdefault = true;
		enseq_EntryReactionAction_r2_B_r_BA_default();
	} 
}

/* Default react sequence for initial entry other */
void EntryReactionAction::react_EntryReactionAction_r2_B_r_other()
{
	/* Default react sequence for initial entry other */
	iface.enteredBother = true;
	enseq_EntryReactionAction_r2_B_r_BB_default();
}

/* Default react sequence for initial entry  */
void EntryReactionAction::react_EntryReactionAction_r1__entry_Default()
{
	/* Default react sequence for initial entry  */
	iface.enteredR1 = true;
	enseq_EntryReactionAction_r1_A_default();
}


