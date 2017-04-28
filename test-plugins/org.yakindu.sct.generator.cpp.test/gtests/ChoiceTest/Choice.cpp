
#include "Choice.h"
#include <string.h>

/*! \file Implementation of the state machine 'Choice'
*/

Choice::Choice()
{
	
	
	stateConfVectorPosition = 0;
	
}

Choice::~Choice()
{
}


void Choice::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = Choice_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart Choice */
	iface.c = false;
}

void Choice::enter()
{
	/* Default enter sequence for statechart Choice */
	enseq_main_region_default();
}

void Choice::exit()
{
	/* Default exit sequence for statechart Choice */
	exseq_main_region();
}

sc_boolean Choice::isActive() const
{
	return stateConfVector[0] != Choice_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean Choice::isFinal() const
{
   return false;}

void Choice::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case main_region_A :
		{
			react_main_region_A();
			break;
		}
		case main_region_B :
		{
			react_main_region_B();
			break;
		}
		case main_region_C :
		{
			react_main_region_C();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void Choice::clearInEvents()
{
	iface.e_raised = false;
	iface.f_raised = false;
	iface.g_raised = false;
	iface.h_raised = false;
}

void Choice::clearOutEvents()
{
}


sc_boolean Choice::isStateActive(ChoiceStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		case main_region_B : 
			return (sc_boolean) (stateConfVector[0] == main_region_B
			);
		case main_region_C : 
			return (sc_boolean) (stateConfVector[0] == main_region_C
			);
		default: return false;
	}
}

Choice::DefaultSCI* Choice::getDefaultSCI()
{
	return &iface;
}

void Choice::DefaultSCI::raise_e()
{
	e_raised = true;
}

void Choice::raise_e()
{
	iface.raise_e();
}

void Choice::DefaultSCI::raise_f()
{
	f_raised = true;
}

void Choice::raise_f()
{
	iface.raise_f();
}

void Choice::DefaultSCI::raise_g()
{
	g_raised = true;
}

void Choice::raise_g()
{
	iface.raise_g();
}

void Choice::DefaultSCI::raise_h()
{
	h_raised = true;
}

void Choice::raise_h()
{
	iface.raise_h();
}


sc_boolean Choice::DefaultSCI::get_c() const
{
	return c;
}

sc_boolean Choice::get_c() const
{
	return iface.c;
}

void Choice::DefaultSCI::set_c(sc_boolean value)
{
	c = value;
}

void Choice::set_c(sc_boolean value)
{
	iface.c = value;
}


// implementations of all internal functions

sc_boolean Choice::check_main_region_A_tr0_tr0()
{
	return iface.e_raised;
}

sc_boolean Choice::check_main_region_A_tr1_tr1()
{
	return iface.f_raised;
}

sc_boolean Choice::check_main_region_A_tr2_tr2()
{
	return iface.g_raised;
}

sc_boolean Choice::check_main_region_A_tr3_tr3()
{
	return iface.h_raised;
}

sc_boolean Choice::check_main_region_B_tr0_tr0()
{
	return true;
}

sc_boolean Choice::check_main_region_C_tr0_tr0()
{
	return true;
}

sc_boolean Choice::check_main_region__choice_0_tr1_tr1()
{
	return iface.c;
}

sc_boolean Choice::check_main_region__choice_0_tr0_tr0()
{
	return true;
}

sc_boolean Choice::check_main_region__choice_1_tr0_tr0()
{
	return iface.c;
}

sc_boolean Choice::check_main_region__choice_1_tr1_tr1()
{
	return true;
}

sc_boolean Choice::check_main_region__choice_2_tr1_tr1()
{
	return iface.c;
}

sc_boolean Choice::check_main_region__choice_2_tr0()
{
	return true;
}

sc_boolean Choice::check_main_region__choice_3_tr1_tr1()
{
	return iface.c;
}

sc_boolean Choice::check_main_region__choice_3_tr0_tr0()
{
	return true;
}

void Choice::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	react_main_region__choice_0();
}

void Choice::effect_main_region_A_tr1()
{
	exseq_main_region_A();
	react_main_region__choice_2();
}

void Choice::effect_main_region_A_tr2()
{
	exseq_main_region_A();
	react_main_region__choice_1();
}

void Choice::effect_main_region_A_tr3()
{
	exseq_main_region_A();
	react_main_region__choice_3();
}

void Choice::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region_A_default();
}

void Choice::effect_main_region_C_tr0()
{
	exseq_main_region_C();
	enseq_main_region_A_default();
}

void Choice::effect_main_region__choice_0_tr1()
{
	enseq_main_region_C_default();
}

void Choice::effect_main_region__choice_0_tr0()
{
	enseq_main_region_B_default();
}

void Choice::effect_main_region__choice_1_tr0()
{
	enseq_main_region_C_default();
}

void Choice::effect_main_region__choice_1_tr1()
{
	enseq_main_region_B_default();
}

void Choice::effect_main_region__choice_2_tr1()
{
	enseq_main_region_C_default();
}

void Choice::effect_main_region__choice_2_tr0()
{
	enseq_main_region_B_default();
}

void Choice::effect_main_region__choice_3_tr1()
{
	enseq_main_region_C_default();
}

void Choice::effect_main_region__choice_3_tr0()
{
	enseq_main_region_B_default();
}

/* 'default' enter sequence for state A */
void Choice::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void Choice::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
void Choice::enseq_main_region_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[0] = main_region_C;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void Choice::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void Choice::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = Choice_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void Choice::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = Choice_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
void Choice::exseq_main_region_C()
{
	/* Default exit sequence for state C */
	stateConfVector[0] = Choice_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void Choice::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of Choice.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case main_region_A :
		{
			exseq_main_region_A();
			break;
		}
		case main_region_B :
		{
			exseq_main_region_B();
			break;
		}
		case main_region_C :
		{
			exseq_main_region_C();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void Choice::react_main_region_A()
{
	/* The reactions of state A. */
	if (check_main_region_A_tr0_tr0())
	{ 
		effect_main_region_A_tr0();
	}  else
	{
		if (check_main_region_A_tr1_tr1())
		{ 
			effect_main_region_A_tr1();
		}  else
		{
			if (check_main_region_A_tr2_tr2())
			{ 
				effect_main_region_A_tr2();
			}  else
			{
				if (check_main_region_A_tr3_tr3())
				{ 
					effect_main_region_A_tr3();
				} 
			}
		}
	}
}

/* The reactions of state B. */
void Choice::react_main_region_B()
{
	/* The reactions of state B. */
	effect_main_region_B_tr0();
}

/* The reactions of state C. */
void Choice::react_main_region_C()
{
	/* The reactions of state C. */
	effect_main_region_C_tr0();
}

/* The reactions of state null. */
void Choice::react_main_region__choice_0()
{
	/* The reactions of state null. */
	if (check_main_region__choice_0_tr1_tr1())
	{ 
		effect_main_region__choice_0_tr1();
	}  else
	{
		effect_main_region__choice_0_tr0();
	}
}

/* The reactions of state null. */
void Choice::react_main_region__choice_1()
{
	/* The reactions of state null. */
	if (check_main_region__choice_1_tr0_tr0())
	{ 
		effect_main_region__choice_1_tr0();
	}  else
	{
		effect_main_region__choice_1_tr1();
	}
}

/* The reactions of state null. */
void Choice::react_main_region__choice_2()
{
	/* The reactions of state null. */
	if (check_main_region__choice_2_tr1_tr1())
	{ 
		effect_main_region__choice_2_tr1();
	}  else
	{
		effect_main_region__choice_2_tr0();
	}
}

/* The reactions of state null. */
void Choice::react_main_region__choice_3()
{
	/* The reactions of state null. */
	if (check_main_region__choice_3_tr1_tr1())
	{ 
		effect_main_region__choice_3_tr1();
	}  else
	{
		effect_main_region__choice_3_tr0();
	}
}

/* Default react sequence for initial entry  */
void Choice::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


