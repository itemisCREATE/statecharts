
#include "Parenthesis.h"
#include <string.h>

/*! \file Implementation of the state machine 'Parenthesis'
*/

Parenthesis::Parenthesis()
{
	
	
	stateConfVectorPosition = 0;
	
}

Parenthesis::~Parenthesis()
{
}


void Parenthesis::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = Parenthesis_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart Parenthesis */
	iface.erg = 0;
}

void Parenthesis::enter()
{
	/* Default enter sequence for statechart Parenthesis */
	enseq_mainRegion_default();
}

void Parenthesis::exit()
{
	/* Default exit sequence for statechart Parenthesis */
	exseq_mainRegion();
}

sc_boolean Parenthesis::isActive() const
{
	return stateConfVector[0] != Parenthesis_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean Parenthesis::isFinal() const
{
   return false;}

void Parenthesis::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case mainRegion_A :
		{
			react_mainRegion_A();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void Parenthesis::clearInEvents()
{
}

void Parenthesis::clearOutEvents()
{
}


sc_boolean Parenthesis::isStateActive(ParenthesisStates state) const
{
	switch (state)
	{
		case mainRegion_A : 
			return (sc_boolean) (stateConfVector[0] == mainRegion_A
			);
		default: return false;
	}
}

Parenthesis::DefaultSCI* Parenthesis::getDefaultSCI()
{
	return &iface;
}


sc_integer Parenthesis::DefaultSCI::get_erg() const
{
	return erg;
}

sc_integer Parenthesis::get_erg() const
{
	return iface.erg;
}

void Parenthesis::DefaultSCI::set_erg(sc_integer value)
{
	erg = value;
}

void Parenthesis::set_erg(sc_integer value)
{
	iface.erg = value;
}


// implementations of all internal functions

/* Entry action for state 'A'. */
void Parenthesis::enact_mainRegion_A()
{
	/* Entry action for state 'A'. */
	iface.erg = 4 * (3 - 1);
}

/* 'default' enter sequence for state A */
void Parenthesis::enseq_mainRegion_A_default()
{
	/* 'default' enter sequence for state A */
	enact_mainRegion_A();
	stateConfVector[0] = mainRegion_A;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for region mainRegion */
void Parenthesis::enseq_mainRegion_default()
{
	/* 'default' enter sequence for region mainRegion */
	react_mainRegion__entry_Default();
}

/* Default exit sequence for state A */
void Parenthesis::exseq_mainRegion_A()
{
	/* Default exit sequence for state A */
	stateConfVector[0] = Parenthesis_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region mainRegion */
void Parenthesis::exseq_mainRegion()
{
	/* Default exit sequence for region mainRegion */
	/* Handle exit of all possible states (of Parenthesis.mainRegion) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case mainRegion_A :
		{
			exseq_mainRegion_A();
			break;
		}
		default: break;
	}
}

/* The reactions of state A. */
void Parenthesis::react_mainRegion_A()
{
	/* The reactions of state A. */
}

/* Default react sequence for initial entry  */
void Parenthesis::react_mainRegion__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_mainRegion_A_default();
}


