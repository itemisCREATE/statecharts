
#include "Operations.h"
#include <string.h>

/*! \file Implementation of the state machine 'Operations'
*/

Operations::Operations()
{
	
	ifaceInternalSCI_OCB = null;
	ifaceInterface1_OCB = null;
	iface_OCB = null;
	
	stateConfVectorPosition = 0;
	
}

Operations::~Operations()
{
}


void Operations::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = Operations_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart Operations */
	ifaceInternalSCI.myBool = false;
}

void Operations::enter()
{
	/* Default enter sequence for statechart Operations */
	enseq_main_region_default();
}

void Operations::exit()
{
	/* Default exit sequence for statechart Operations */
	exseq_main_region();
}

sc_boolean Operations::isActive() const
{
	return stateConfVector[0] != Operations_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean Operations::isFinal() const
{
   return false;}

void Operations::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
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
		case main_region_A :
		{
			react_main_region_A();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void Operations::clearInEvents()
{
	iface.ev_raised = false;
}

void Operations::clearOutEvents()
{
}


sc_boolean Operations::isStateActive(OperationsStates state) const
{
	switch (state)
	{
		case main_region_B : 
			return (sc_boolean) (stateConfVector[0] == main_region_B
			);
		case main_region_C : 
			return (sc_boolean) (stateConfVector[0] == main_region_C
			);
		case main_region_D : 
			return (sc_boolean) (stateConfVector[0] == main_region_D
			);
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		default: return false;
	}
}


sc_boolean Operations::InternalSCI::get_myBool() const
{
	return myBool;
}

void Operations::InternalSCI::set_myBool(sc_boolean value)
{
	myBool = value;
}

void Operations::setInternalSCI_OCB(InternalSCI_OCB* operationCallback)
{
	ifaceInternalSCI_OCB = operationCallback;
}
Operations::SCI_Interface1* Operations::getSCI_Interface1()
{
	return &ifaceInterface1;
}


void Operations::setSCI_Interface1_OCB(SCI_Interface1_OCB* operationCallback)
{
	ifaceInterface1_OCB = operationCallback;
}
Operations::DefaultSCI* Operations::getDefaultSCI()
{
	return &iface;
}

void Operations::DefaultSCI::raise_ev()
{
	ev_raised = true;
}

void Operations::raise_ev()
{
	iface.raise_ev();
}


void Operations::setDefaultSCI_OCB(DefaultSCI_OCB* operationCallback)
{
	iface_OCB = operationCallback;
}

// implementations of all internal functions

sc_boolean Operations::check_main_region_B_tr0_tr0()
{
	return (iface.ev_raised) && (iface_OCB->alwaysTrue());
}

sc_boolean Operations::check_main_region_C_tr0_tr0()
{
	return iface.ev_raised;
}

sc_boolean Operations::check_main_region_A_tr0_tr0()
{
	return true;
}

void Operations::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region_C_default();
}

void Operations::effect_main_region_C_tr0()
{
	exseq_main_region_C();
	enseq_main_region_D_default();
}

void Operations::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

/* Entry action for state 'B'. */
void Operations::enact_main_region_B()
{
	/* Entry action for state 'B'. */
	ifaceInternalSCI_OCB->internalOperation1();
	ifaceInternalSCI.myBool = ifaceInternalSCI_OCB->InternalOperation2(4);
	ifaceInternalSCI_OCB->internalOperation3();
	ifaceInternalSCI_OCB->internalOperation3a(1.0);
	ifaceInternalSCI_OCB->internalOperation4();
	ifaceInternalSCI_OCB->internalOperation4a(5);
	ifaceInternalSCI_OCB->internalOperation5();
	ifaceInternalSCI_OCB->internalOperation5a("");
}

/* Entry action for state 'C'. */
void Operations::enact_main_region_C()
{
	/* Entry action for state 'C'. */
	ifaceInterface1_OCB->interfaceOperation1();
	ifaceInterface1_OCB->InterfaceOperation2(4);
	ifaceInterface1_OCB->interfaceOperation3();
	ifaceInterface1_OCB->interfaceOperation3a(1.0);
	ifaceInterface1_OCB->interfaceOperation4();
	ifaceInterface1_OCB->interfaceOperation4a(5);
	ifaceInterface1_OCB->interfaceOperation5();
	ifaceInterface1_OCB->interfaceOperation5a("");
}

/* Entry action for state 'D'. */
void Operations::enact_main_region_D()
{
	/* Entry action for state 'D'. */
	iface_OCB->unnamedInterfaceOperation1();
	iface_OCB->UnnamedInterfaceOperation2(4);
	iface_OCB->unnamedOperation3();
	iface_OCB->unnamedOperation3a(1.0);
	iface_OCB->unnamedOperation4();
	iface_OCB->unnamedOperation4a(5);
	iface_OCB->unnamedOperation5();
	iface_OCB->unnamedOperation5a("");
}

/* 'default' enter sequence for state B */
void Operations::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	enact_main_region_B();
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state C */
void Operations::enseq_main_region_C_default()
{
	/* 'default' enter sequence for state C */
	enact_main_region_C();
	stateConfVector[0] = main_region_C;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state D */
void Operations::enseq_main_region_D_default()
{
	/* 'default' enter sequence for state D */
	enact_main_region_D();
	stateConfVector[0] = main_region_D;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state A */
void Operations::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void Operations::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state B */
void Operations::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = Operations_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state C */
void Operations::exseq_main_region_C()
{
	/* Default exit sequence for state C */
	stateConfVector[0] = Operations_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state D */
void Operations::exseq_main_region_D()
{
	/* Default exit sequence for state D */
	stateConfVector[0] = Operations_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state A */
void Operations::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = Operations_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void Operations::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of Operations.main_region) at position 0... */
	switch(stateConfVector[ 0 ])
	{
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
		case main_region_A :
		{
			exseq_main_region_A();
			break;
		}
		default: break;
	}
}

/* The reactions of state B. */
void Operations::react_main_region_B()
{
	/* The reactions of state B. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	} 
}

/* The reactions of state C. */
void Operations::react_main_region_C()
{
	/* The reactions of state C. */
	if (check_main_region_C_tr0_tr0())
	{ 
		effect_main_region_C_tr0();
	} 
}

/* The reactions of state D. */
void Operations::react_main_region_D()
{
	/* The reactions of state D. */
}

/* The reactions of state A. */
void Operations::react_main_region_A()
{
	/* The reactions of state A. */
	effect_main_region_A_tr0();
}

/* Default react sequence for initial entry  */
void Operations::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


