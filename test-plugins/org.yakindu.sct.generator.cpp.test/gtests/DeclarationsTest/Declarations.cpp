
#include "Declarations.h"
#include <string.h>

/*! \file Implementation of the state machine 'Declarations'
*/

Declarations::Declarations()
{
	
	
	stateConfVectorPosition = 0;
	
}

Declarations::~Declarations()
{
}


void Declarations::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = Declarations_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart Declarations */
	iface.varA = false;
	iface.varB = 1;
	iface.varC = 1.0;
	iface.varD = "myString";
	iface.varE = 0x10;
	ifaceIfA.varA = false;
	ifaceIfA.varB = 1;
	ifaceIfA.varC = 1.0;
	ifaceIfA.varD = "myString";
	ifaceIfA.varE = 0x10;
	ifaceInternalSCI.varInA = false;
	ifaceInternalSCI.varInB = 1;
	ifaceInternalSCI.varInC = 1.0;
	ifaceInternalSCI.varInD = "myString";
	ifaceInternalSCI.varInE = 0x10;
}

void Declarations::enter()
{
	/* Default enter sequence for statechart Declarations */
	enseq_main_region_default();
}

void Declarations::exit()
{
	/* Default exit sequence for statechart Declarations */
	exseq_main_region();
}

sc_boolean Declarations::isActive() const
{
	return stateConfVector[0] != Declarations_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean Declarations::isFinal() const
{
   return false;}

void Declarations::runCycle()
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
		default:
			break;
		}
	}
	
	clearInEvents();
}

void Declarations::clearInEvents()
{
	iface.evA_raised = false;
	iface.evC_raised = false;
	iface.evE_raised = false;
	ifaceIfA.evA_raised = false;
	ifaceIfA.evC_raised = false;
	ifaceIfA.evE_raised = false;
	ifaceInternalSCI.evInA_raised = false; 
	ifaceInternalSCI.evInB_raised = false; 
	ifaceInternalSCI.evInC_raised = false; 
	ifaceInternalSCI.evInD_raised = false; 
	ifaceInternalSCI.evInE_raised = false; 
	ifaceInternalSCI.evInF_raised = false; 
}

void Declarations::clearOutEvents()
{
	iface.evB_raised = false;
	iface.evD_raised = false;
	iface.evF_raised = false;
	ifaceIfA.evB_raised = false;
	ifaceIfA.evD_raised = false;
	ifaceIfA.evF_raised = false;
}


sc_boolean Declarations::isStateActive(DeclarationsStates state) const
{
	switch (state)
	{
		case main_region_A : 
			return (sc_boolean) (stateConfVector[0] == main_region_A
			);
		case main_region_B : 
			return (sc_boolean) (stateConfVector[0] == main_region_B
			);
		default: return false;
	}
}

Declarations::DefaultSCI* Declarations::getDefaultSCI()
{
	return &iface;
}

void Declarations::DefaultSCI::raise_evA()
{
	evA_raised = true;
}

void Declarations::raise_evA()
{
	iface.raise_evA();
}

void Declarations::DefaultSCI::raise_evC(sc_boolean value)
{
	evC_value = value;
	evC_raised = true;
}

void Declarations::raise_evC(sc_boolean value)
{
	iface.raise_evC(value);
}

void Declarations::DefaultSCI::raise_evE(sc_real value)
{
	evE_value = value;
	evE_raised = true;
}

void Declarations::raise_evE(sc_real value)
{
	iface.raise_evE(value);
}

sc_boolean Declarations::DefaultSCI::isRaised_evB() const
{
	return evB_raised;
}

sc_boolean Declarations::isRaised_evB() const
{
	return iface.isRaised_evB();
}

sc_boolean Declarations::DefaultSCI::isRaised_evD() const
{
	return evD_raised;
}

sc_boolean Declarations::isRaised_evD() const
{
	return iface.isRaised_evD();
}

sc_integer Declarations::DefaultSCI::get_evD_value() const
{
	return evD_value;
}

sc_integer Declarations::get_evD_value() const
{
	return iface.get_evD_value();
}

sc_boolean Declarations::DefaultSCI::isRaised_evF() const
{
	return evF_raised;
}

sc_boolean Declarations::isRaised_evF() const
{
	return iface.isRaised_evF();
}

sc_string Declarations::DefaultSCI::get_evF_value() const
{
	return evF_value;
}

sc_string Declarations::get_evF_value() const
{
	return iface.get_evF_value();
}


sc_boolean Declarations::DefaultSCI::get_varA() const
{
	return varA;
}

sc_boolean Declarations::get_varA() const
{
	return iface.varA;
}

void Declarations::DefaultSCI::set_varA(sc_boolean value)
{
	varA = value;
}

void Declarations::set_varA(sc_boolean value)
{
	iface.varA = value;
}

sc_integer Declarations::DefaultSCI::get_varB() const
{
	return varB;
}

sc_integer Declarations::get_varB() const
{
	return iface.varB;
}

void Declarations::DefaultSCI::set_varB(sc_integer value)
{
	varB = value;
}

void Declarations::set_varB(sc_integer value)
{
	iface.varB = value;
}

sc_real Declarations::DefaultSCI::get_varC() const
{
	return varC;
}

sc_real Declarations::get_varC() const
{
	return iface.varC;
}

void Declarations::DefaultSCI::set_varC(sc_real value)
{
	varC = value;
}

void Declarations::set_varC(sc_real value)
{
	iface.varC = value;
}

sc_string Declarations::DefaultSCI::get_varD() const
{
	return varD;
}

sc_string Declarations::get_varD() const
{
	return iface.varD;
}

void Declarations::DefaultSCI::set_varD(sc_string value)
{
	varD = value;
}

void Declarations::set_varD(sc_string value)
{
	iface.varD = value;
}

sc_integer Declarations::DefaultSCI::get_varE() const
{
	return varE;
}

sc_integer Declarations::get_varE() const
{
	return iface.varE;
}

void Declarations::DefaultSCI::set_varE(sc_integer value)
{
	varE = value;
}

void Declarations::set_varE(sc_integer value)
{
	iface.varE = value;
}

Declarations::SCI_IfA* Declarations::getSCI_IfA()
{
	return &ifaceIfA;
}

void Declarations::SCI_IfA::raise_evA()
{
	evA_raised = true;
}

void Declarations::SCI_IfA::raise_evC(sc_boolean value)
{
	evC_value = value;
	evC_raised = true;
}

void Declarations::SCI_IfA::raise_evE(sc_real value)
{
	evE_value = value;
	evE_raised = true;
}

sc_boolean Declarations::SCI_IfA::isRaised_evB() const
{
	return evB_raised;
}

sc_boolean Declarations::SCI_IfA::isRaised_evD() const
{
	return evD_raised;
}

sc_integer Declarations::SCI_IfA::get_evD_value() const
{
	return evD_value;
}

sc_boolean Declarations::SCI_IfA::isRaised_evF() const
{
	return evF_raised;
}

sc_string Declarations::SCI_IfA::get_evF_value() const
{
	return evF_value;
}


sc_boolean Declarations::SCI_IfA::get_varA() const
{
	return varA;
}

void Declarations::SCI_IfA::set_varA(sc_boolean value)
{
	varA = value;
}

sc_integer Declarations::SCI_IfA::get_varB() const
{
	return varB;
}

void Declarations::SCI_IfA::set_varB(sc_integer value)
{
	varB = value;
}

sc_real Declarations::SCI_IfA::get_varC() const
{
	return varC;
}

void Declarations::SCI_IfA::set_varC(sc_real value)
{
	varC = value;
}

sc_string Declarations::SCI_IfA::get_varD() const
{
	return varD;
}

void Declarations::SCI_IfA::set_varD(sc_string value)
{
	varD = value;
}

sc_integer Declarations::SCI_IfA::get_varE() const
{
	return varE;
}

void Declarations::SCI_IfA::set_varE(sc_integer value)
{
	varE = value;
}


void Declarations::InternalSCI::raise_evInA()
{
	evInA_raised = true;
}

sc_boolean Declarations::InternalSCI::isRaised_evInA() const
{
	return evInA_raised;
}

void Declarations::InternalSCI::raise_evInB()
{
	evInB_raised = true;
}

sc_boolean Declarations::InternalSCI::isRaised_evInB() const
{
	return evInB_raised;
}

void Declarations::InternalSCI::raise_evInC(sc_boolean value)
{
	evInC_value = value;
	evInC_raised = true;
}

sc_boolean Declarations::InternalSCI::isRaised_evInC() const
{
	return evInC_raised;
}

sc_boolean Declarations::InternalSCI::get_evInC_value() const
{
	return evInC_value;
}

void Declarations::InternalSCI::raise_evInD(sc_integer value)
{
	evInD_value = value;
	evInD_raised = true;
}

sc_boolean Declarations::InternalSCI::isRaised_evInD() const
{
	return evInD_raised;
}

sc_integer Declarations::InternalSCI::get_evInD_value() const
{
	return evInD_value;
}

void Declarations::InternalSCI::raise_evInE(sc_real value)
{
	evInE_value = value;
	evInE_raised = true;
}

sc_boolean Declarations::InternalSCI::isRaised_evInE() const
{
	return evInE_raised;
}

sc_real Declarations::InternalSCI::get_evInE_value() const
{
	return evInE_value;
}

void Declarations::InternalSCI::raise_evInF(sc_string value)
{
	evInF_value = value;
	evInF_raised = true;
}

sc_boolean Declarations::InternalSCI::isRaised_evInF() const
{
	return evInF_raised;
}

sc_string Declarations::InternalSCI::get_evInF_value() const
{
	return evInF_value;
}

sc_boolean Declarations::InternalSCI::get_varInA() const
{
	return varInA;
}

void Declarations::InternalSCI::set_varInA(sc_boolean value)
{
	varInA = value;
}

sc_integer Declarations::InternalSCI::get_varInB() const
{
	return varInB;
}

void Declarations::InternalSCI::set_varInB(sc_integer value)
{
	varInB = value;
}

sc_real Declarations::InternalSCI::get_varInC() const
{
	return varInC;
}

void Declarations::InternalSCI::set_varInC(sc_real value)
{
	varInC = value;
}

sc_string Declarations::InternalSCI::get_varInD() const
{
	return varInD;
}

void Declarations::InternalSCI::set_varInD(sc_string value)
{
	varInD = value;
}

sc_integer Declarations::InternalSCI::get_varInE() const
{
	return varInE;
}

void Declarations::InternalSCI::set_varInE(sc_integer value)
{
	varInE = value;
}


// implementations of all internal functions

sc_boolean Declarations::check_main_region_A_tr0_tr0()
{
	return ifaceInternalSCI.evInA_raised;
}

sc_boolean Declarations::check_main_region_A_tr1_tr1()
{
	return ifaceInternalSCI.evInC_raised;
}

sc_boolean Declarations::check_main_region_B_tr0_tr0()
{
	return ifaceInternalSCI.evInB_raised;
}

sc_boolean Declarations::check_main_region_B_tr1_tr1()
{
	return ifaceInternalSCI.evInD_raised;
}

sc_boolean Declarations::check_main_region_B_tr2_tr2()
{
	return ifaceInternalSCI.evInE_raised;
}

sc_boolean Declarations::check_main_region_B_tr3_tr3()
{
	return ifaceInternalSCI.evInF_raised;
}

void Declarations::effect_main_region_A_tr0()
{
	exseq_main_region_A();
	enseq_main_region_B_default();
}

void Declarations::effect_main_region_A_tr1()
{
	exseq_main_region_A();
	enseq_main_region_A_default();
}

void Declarations::effect_main_region_B_tr0()
{
	exseq_main_region_B();
	enseq_main_region_A_default();
}

void Declarations::effect_main_region_B_tr1()
{
	exseq_main_region_B();
	enseq_main_region_B_default();
}

void Declarations::effect_main_region_B_tr2()
{
	exseq_main_region_B();
	enseq_main_region_B_default();
}

void Declarations::effect_main_region_B_tr3()
{
	exseq_main_region_B();
	enseq_main_region_A_default();
}

/* Entry action for state 'A'. */
void Declarations::enact_main_region_A()
{
	/* Entry action for state 'A'. */
	ifaceInternalSCI.varInA = false;
	ifaceInternalSCI.varInB = 1;
	ifaceInternalSCI.varInC = 1.1;
	ifaceInternalSCI.varInD = "blub";
	ifaceInternalSCI.varInE = 1;
}

/* 'default' enter sequence for state A */
void Declarations::enseq_main_region_A_default()
{
	/* 'default' enter sequence for state A */
	enact_main_region_A();
	stateConfVector[0] = main_region_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state B */
void Declarations::enseq_main_region_B_default()
{
	/* 'default' enter sequence for state B */
	stateConfVector[0] = main_region_B;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region main region */
void Declarations::enseq_main_region_default()
{
	/* 'default' enter sequence for region main region */
	react_main_region__entry_Default();
}

/* Default exit sequence for state A */
void Declarations::exseq_main_region_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = Declarations_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state B */
void Declarations::exseq_main_region_B()
{
	/* Default exit sequence for state B */
	stateConfVector[0] = Declarations_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region main region */
void Declarations::exseq_main_region()
{
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of Declarations.main_region) at position 0... */
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
		default: break;
	}
}

/* The reactions of state A. */
void Declarations::react_main_region_A()
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
		} 
	}
}

/* The reactions of state B. */
void Declarations::react_main_region_B()
{
	/* The reactions of state B. */
	if (check_main_region_B_tr0_tr0())
	{ 
		effect_main_region_B_tr0();
	}  else
	{
		if (check_main_region_B_tr1_tr1())
		{ 
			effect_main_region_B_tr1();
		}  else
		{
			if (check_main_region_B_tr2_tr2())
			{ 
				effect_main_region_B_tr2();
			}  else
			{
				if (check_main_region_B_tr3_tr3())
				{ 
					effect_main_region_B_tr3();
				} 
			}
		}
	}
}

/* Default react sequence for initial entry  */
void Declarations::react_main_region__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_main_region_A_default();
}


