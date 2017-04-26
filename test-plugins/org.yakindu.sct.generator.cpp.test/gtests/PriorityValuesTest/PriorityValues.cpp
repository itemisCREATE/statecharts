
#include "PriorityValues.h"
#include <string.h>

/*! \file Implementation of the state machine 'PriorityValues'
*/

PriorityValues::PriorityValues()
{
	
	
	stateConfVectorPosition = 0;
	
}

PriorityValues::~PriorityValues()
{
}


void PriorityValues::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = PriorityValues_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
}

void PriorityValues::enter()
{
	/* Default enter sequence for statechart PriorityValues */
	enseq_someRegion_default();
	enseq_main_region_default();
}

void PriorityValues::exit()
{
	/* Default exit sequence for statechart PriorityValues */
	exseq_someRegion();
	exseq_main_region();
}

sc_boolean PriorityValues::isActive() const
{
	return stateConfVector[0] != PriorityValues_last_state||stateConfVector[1] != PriorityValues_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean PriorityValues::isFinal() const
{
   return false;}

void PriorityValues::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case someRegion_A :
		{
			react_someRegion_A();
			break;
		}
		case someRegion_B :
		{
			react_someRegion_B();
			break;
		}
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
		case main_region_D :
		{
			react_main_region_D();
			break;
		}
		case main_region_E :
		{
			react_main_region_E();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void PriorityValues::clearInEvents()
{
	iface.event1_raised = false;
	iface.event2_raised = false;
}

void PriorityValues::clearOutEvents()
{
}


sc_boolean PriorityValues::isStateActive(PriorityValuesStates state) const
{
	switch (state)
	{
		case someRegion_A : 
			return (sc_boolean) (stateConfVector[0] == someRegion_A
			);
		case someRegion_B : 
			return (sc_boolean) (stateConfVector[0] == someRegion_B
			);
		case main_region_A : 
			return (sc_boolean) (stateConfVector[1] == main_region_A
			);
		case main_region_B : 
			return (sc_boolean) (stateConfVector[1] == main_region_B
			);
		case main_region_C : 
			return (sc_boolean) (stateConfVector[1] == main_region_C
			);
		case main_region_D : 
			return (sc_boolean) (stateConfVector[1] == main_region_D
			);
		case main_region_E : 
			return (sc_boolean) (stateConfVector[1] == main_region_E
			);
		default: return false;
	}
}

PriorityValues::DefaultSCI* PriorityValues::getDefaultSCI()
{
	return &iface;
}

void PriorityValues::DefaultSCI::raise_event1()
{
	event1_raised = true;
}

void PriorityValues::raise_event1()
{
	iface.raise_event1();
}

void PriorityValues::DefaultSCI::raise_event2()
{
	event2_raised = true;
}

void PriorityValues::raise_event2()
{
	iface.raise_event2();
}



// implementations of all internal functions

sc_boolean PriorityValues::check_someRegion_A_tr0_tr0()
{
	return iface.event2_raised;
}

sc_boolean PriorityValues::check_main_region_A_tr0_tr0()
{
	return iface.event1_raised;
}

sc_boolean PriorityValues::check_main_region_A_tr1_tr1()
{
	return iface.event1_raised;
}

sc_boolean PriorityValues::check_main_region_A_tr2_tr2()
{
	return iface.event1_raised;
}

sc_boolean PriorityValues::check_main_region_A_tr3_tr3()
{
	return (iface.event2_raised) && (!isStateActive(someRegion_B));
}

void PriorityValues::effect_someRegion_A_tr0()
{
	exseq_someRegion_A();
	enseq_someRegion_B_default();
}

void PriorityValues::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_C_default();
}

void PriorityValues::effect_main_region_A_tr1()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void PriorityValues::effect_main_region_A_tr2()
{
	exseq_main_region_A();
	enseq_main_region_D_default();
}

void PriorityValues::effect_main_region_A_tr3()
{
	exseq_main_region_A();
	enseq_main_region_E_default();
}

/* 'default' enter sequence for state A */
void PriorityValues::enseq_someRegion_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = someRegion_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void PriorityValues::enseq_someRegion_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = someRegion_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state A */
void PriorityValues::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[1] = main_region_A;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state B */
void PriorityValues::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[1] = main_region_B;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state C */
void PriorityValues::enseq_main_region_C_default()
{
	/* 'default' enter sequence for state C */
	stateConfVector[1] = main_region_C;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state D */
void PriorityValues::enseq_main_region_D_default()
{
	/* 'default' enter sequence for state D */
	stateConfVector[1] = main_region_D;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state E */
void PriorityValues::enseq_main_region_E_default()
{
	/* 'default' enter sequence for state E */
	stateConfVector[1] = main_region_E;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region someRegion */
void PriorityValues::enseq_someRegion_default()
{
	/* 'default' enter sequence for region someRegion */
	react_someRegion__entry_Default();
}

/* 'default' enter sequence for region main region */
void PriorityValues::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void PriorityValues::exseq_someRegion_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = PriorityValues_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void PriorityValues::exseq_someRegion_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = PriorityValues_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state A */
void PriorityValues::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[1] = PriorityValues_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state B */
void PriorityValues::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[1] = PriorityValues_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state C */
void PriorityValues::exseq_main_region_C()
{
	/* Default exit sequence for state C */
	stateConfVector[1] = PriorityValues_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state D */
void PriorityValues::exseq_main_region_D()
{
	/* Default exit sequence for state D */
	stateConfVector[1] = PriorityValues_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state E */
void PriorityValues::exseq_main_region_E()
{
	/* Default exit sequence for state E */
	stateConfVector[1] = PriorityValues_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for region someRegion */
void PriorityValues::exseq_someRegion()
{
	/* Default exit sequence for region someRegion */
	/* Handle exit of all possible states (of PriorityValues.someRegion) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case someRegion_A :
		{
			exseq_someRegion_A();
			break;
		}
		case someRegion_B :
		{
			exseq_someRegion_B();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region main region */
void PriorityValues::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of PriorityValues.main_region) at position 1... */
	switch(stateConfVector[ 1 ])
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
		case main_region_D :
		{
			exseq_main_region_D();
			break;
		}
		case main_region_E :
		{
			exseq_main_region_E();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void PriorityValues::react_someRegion_A()
{
	/* The reactions of state A. */
	if (check_someRegion_A_tr0_tr0())
	{ 
		effect_someRegion_A_tr0();
	} 
}

/* The reactions of state B. */
void PriorityValues::react_someRegion_B()
{
	/* The reactions of state B. */
}

/* The reactions of state A. */
void PriorityValues::react_main_region_A()
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
void PriorityValues::react_main_region_B()
{
}

/* The reactions of state C. */
void PriorityValues::react_main_region_C()
{
}

/* The reactions of state D. */
void PriorityValues::react_main_region_D()
{
}

/* The reactions of state E. */
void PriorityValues::react_main_region_E()
{
}

/* Default react sequence for initial entry  */
void PriorityValues::react_someRegion__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_someRegion_A_default();
}

/* Default react sequence for initial entry  */
void PriorityValues::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


