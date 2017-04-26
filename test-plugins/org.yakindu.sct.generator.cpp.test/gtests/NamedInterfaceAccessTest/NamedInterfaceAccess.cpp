
#include "NamedInterfaceAccess.h"
#include <string.h>

/*! \file Implementation of the state machine 'NamedInterfaceAccess'
*/

NamedInterfaceAccess::NamedInterfaceAccess()
{
	
	
	stateConfVectorPosition = 0;
	
}

NamedInterfaceAccess::~NamedInterfaceAccess()
{
}


void NamedInterfaceAccess::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = NamedInterfaceAccess_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart NamedInterfaceAccess */
	ifaceInternalSCI.number1 = 3;
	ifaceInternalSCI.number2 = 7;
	ifaceInternalSCI.number3 = 5;
}

void NamedInterfaceAccess::enter()
{
	/* Default enter sequence for statechart NamedInterfaceAccess */
	enseq_region_1_default();
	enseq__region1_default();
}

void NamedInterfaceAccess::exit()
{
	/* Default exit sequence for statechart NamedInterfaceAccess */
	exseq_region_1();
	exseq__region1();
}

sc_boolean NamedInterfaceAccess::isActive() const
{
	return stateConfVector[0] != NamedInterfaceAccess_last_state||stateConfVector[1] != NamedInterfaceAccess_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean NamedInterfaceAccess::isFinal() const
{
   return false;}

void NamedInterfaceAccess::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case region_1_Idle :
		{
			react_region_1_Idle();
			break;
		}
		case region_1_Number1Pressed :
		{
			react_region_1_Number1Pressed();
			break;
		}
		case region_1_Number2Pressed :
		{
			react_region_1_Number2Pressed();
			break;
		}
		case region_1_Number3Pressed :
		{
			react_region_1_Number3Pressed();
			break;
		}
		case _region1_Closed :
		{
			react__region1_Closed();
			break;
		}
		case _region1_Open :
		{
			react__region1_Open();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void NamedInterfaceAccess::clearInEvents()
{
	ifaceUser.numberPressed_raised = false;
	ifaceUser.reset_raised = false;
}

void NamedInterfaceAccess::clearOutEvents()
{
	ifaceSafe.open_raised = false;
	ifaceSafe.close_raised = false;
}


sc_boolean NamedInterfaceAccess::isStateActive(NamedInterfaceAccessStates state) const
{
	switch (state)
	{
		case region_1_Idle : 
			return (sc_boolean) (stateConfVector[0] == region_1_Idle
			);
		case region_1_Number1Pressed : 
			return (sc_boolean) (stateConfVector[0] == region_1_Number1Pressed
			);
		case region_1_Number2Pressed : 
			return (sc_boolean) (stateConfVector[0] == region_1_Number2Pressed
			);
		case region_1_Number3Pressed : 
			return (sc_boolean) (stateConfVector[0] == region_1_Number3Pressed
			);
		case _region1_Closed : 
			return (sc_boolean) (stateConfVector[1] == _region1_Closed
			);
		case _region1_Open : 
			return (sc_boolean) (stateConfVector[1] == _region1_Open
			);
		default: return false;
	}
}

NamedInterfaceAccess::SCI_Safe* NamedInterfaceAccess::getSCI_Safe()
{
	return &ifaceSafe;
}

sc_boolean NamedInterfaceAccess::SCI_Safe::isRaised_open() const
{
	return open_raised;
}

sc_boolean NamedInterfaceAccess::SCI_Safe::isRaised_close() const
{
	return close_raised;
}


NamedInterfaceAccess::SCI_User* NamedInterfaceAccess::getSCI_User()
{
	return &ifaceUser;
}

void NamedInterfaceAccess::SCI_User::raise_numberPressed(sc_integer value)
{
	numberPressed_value = value;
	numberPressed_raised = true;
}

void NamedInterfaceAccess::SCI_User::raise_reset()
{
	reset_raised = true;
}



sc_integer NamedInterfaceAccess::InternalSCI::get_number1() const
{
	return number1;
}

void NamedInterfaceAccess::InternalSCI::set_number1(sc_integer value)
{
	number1 = value;
}

sc_integer NamedInterfaceAccess::InternalSCI::get_number2() const
{
	return number2;
}

void NamedInterfaceAccess::InternalSCI::set_number2(sc_integer value)
{
	number2 = value;
}

sc_integer NamedInterfaceAccess::InternalSCI::get_number3() const
{
	return number3;
}

void NamedInterfaceAccess::InternalSCI::set_number3(sc_integer value)
{
	number3 = value;
}


// implementations of all internal functions

sc_boolean NamedInterfaceAccess::check_region_1_Idle_tr0_tr0()
{
	return (ifaceUser.numberPressed_raised) && (ifaceUser.numberPressed_value == ifaceInternalSCI.number1);
}

sc_boolean NamedInterfaceAccess::check_region_1_Number1Pressed_tr0_tr0()
{
	return (ifaceUser.numberPressed_raised) && (ifaceUser.numberPressed_value == ifaceInternalSCI.number2);
}

sc_boolean NamedInterfaceAccess::check_region_1_Number1Pressed_tr1_tr1()
{
	return ifaceUser.numberPressed_raised;
}

sc_boolean NamedInterfaceAccess::check_region_1_Number2Pressed_tr0_tr0()
{
	return (ifaceUser.numberPressed_raised) && (ifaceUser.numberPressed_value == ifaceInternalSCI.number3);
}

sc_boolean NamedInterfaceAccess::check_region_1_Number2Pressed_tr1_tr1()
{
	return ifaceUser.numberPressed_raised;
}

sc_boolean NamedInterfaceAccess::check_region_1_Number3Pressed_tr0_tr0()
{
	return ifaceUser.numberPressed_raised;
}

sc_boolean NamedInterfaceAccess::check__region1_Closed_tr0_tr0()
{
	return ifaceSafe.open_raised;
}

sc_boolean NamedInterfaceAccess::check__region1_Open_tr0_tr0()
{
	return ifaceSafe.close_raised;
}

void NamedInterfaceAccess::effect_region_1_Idle_tr0()
{
	exseq_region_1_Idle();
	enseq_region_1_Number1Pressed_default();
}

void NamedInterfaceAccess::effect_region_1_Number1Pressed_tr0()
{
	exseq_region_1_Number1Pressed();
	enseq_region_1_Number2Pressed_default();
}

void NamedInterfaceAccess::effect_region_1_Number1Pressed_tr1()
{
	exseq_region_1_Number1Pressed();
	enseq_region_1_Idle_default();
}

void NamedInterfaceAccess::effect_region_1_Number2Pressed_tr0()
{
	exseq_region_1_Number2Pressed();
	enseq_region_1_Number3Pressed_default();
}

void NamedInterfaceAccess::effect_region_1_Number2Pressed_tr1()
{
	exseq_region_1_Number2Pressed();
	enseq_region_1_Idle_default();
}

void NamedInterfaceAccess::effect_region_1_Number3Pressed_tr0()
{
	exseq_region_1_Number3Pressed();
	enseq_region_1_Idle_default();
}

void NamedInterfaceAccess::effect__region1_Closed_tr0()
{
	exseq__region1_Closed();
	enseq__region1_Open_default();
}

void NamedInterfaceAccess::effect__region1_Open_tr0()
{
	exseq__region1_Open();
	enseq__region1_Closed_default();
}

/* Entry action for state 'Idle'. */
void NamedInterfaceAccess::enact_region_1_Idle()
{
	/* Entry action for state 'Idle'. */
	ifaceSafe.close_raised = true;
}

/* Entry action for state 'Number3Pressed'. */
void NamedInterfaceAccess::enact_region_1_Number3Pressed()
{
	/* Entry action for state 'Number3Pressed'. */
	ifaceSafe.open_raised = true;
}

/* 'default' enter sequence for state Idle */
void NamedInterfaceAccess::enseq_region_1_Idle_default()
{
	/* 'default' enter sequence for state Idle */
	enact_region_1_Idle();
	stateConfVector[0] = region_1_Idle;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Number1Pressed */
void NamedInterfaceAccess::enseq_region_1_Number1Pressed_default()
{
	/* 'default' enter sequence for state Number1Pressed */
	stateConfVector[0] = region_1_Number1Pressed;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Number2Pressed */
void NamedInterfaceAccess::enseq_region_1_Number2Pressed_default()
{
	/* 'default' enter sequence for state Number2Pressed */
	stateConfVector[0] = region_1_Number2Pressed;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Number3Pressed */
void NamedInterfaceAccess::enseq_region_1_Number3Pressed_default()
{
	/* 'default' enter sequence for state Number3Pressed */
	enact_region_1_Number3Pressed();
	stateConfVector[0] = region_1_Number3Pressed;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state Closed */
void NamedInterfaceAccess::enseq__region1_Closed_default()
{
	/* 'default' enter sequence for state Closed */
	stateConfVector[1] = _region1_Closed;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for state Open */
void NamedInterfaceAccess::enseq__region1_Open_default()
{
	/* 'default' enter sequence for state Open */
	stateConfVector[1] = _region1_Open;
	stateConfVectorPosition = 1;
}

/* 'default' enter sequence for region region 1 */
void NamedInterfaceAccess::enseq_region_1_default()
{
	/* 'default' enter sequence for region region 1 */
	react_region_1__entry_Default();
}

/* 'default' enter sequence for region null */
void NamedInterfaceAccess::enseq__region1_default()
{
	/* 'default' enter sequence for region null */
	react__region1__entry_Default();
}

/* Default exit sequence for state Idle */
void NamedInterfaceAccess::exseq_region_1_Idle()
{
	/* Default exit sequence for state Idle */
	stateConfVector[0] = NamedInterfaceAccess_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Number1Pressed */
void NamedInterfaceAccess::exseq_region_1_Number1Pressed()
{
	/* Default exit sequence for state Number1Pressed */
	stateConfVector[0] = NamedInterfaceAccess_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Number2Pressed */
void NamedInterfaceAccess::exseq_region_1_Number2Pressed()
{
	/* Default exit sequence for state Number2Pressed */
	stateConfVector[0] = NamedInterfaceAccess_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Number3Pressed */
void NamedInterfaceAccess::exseq_region_1_Number3Pressed()
{
	/* Default exit sequence for state Number3Pressed */
	stateConfVector[0] = NamedInterfaceAccess_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state Closed */
void NamedInterfaceAccess::exseq__region1_Closed()
{
	/* Default exit sequence for state Closed */
	stateConfVector[1] = NamedInterfaceAccess_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for state Open */
void NamedInterfaceAccess::exseq__region1_Open()
{
	/* Default exit sequence for state Open */
	stateConfVector[1] = NamedInterfaceAccess_last_state;
	stateConfVectorPosition = 1;
}

/* Default exit sequence for region region 1 */
void NamedInterfaceAccess::exseq_region_1()
{
	/* Default exit sequence for region region 1 */
	/* Handle exit of all possible states (of NamedInterfaceAccess.region_1) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case region_1_Idle :
		{
			exseq_region_1_Idle();
			break;
		}
		case region_1_Number1Pressed :
		{
			exseq_region_1_Number1Pressed();
			break;
		}
		case region_1_Number2Pressed :
		{
			exseq_region_1_Number2Pressed();
			break;
		}
		case region_1_Number3Pressed :
		{
			exseq_region_1_Number3Pressed();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region null */
void NamedInterfaceAccess::exseq__region1()
{
	/* Default exit sequence for region null */
	/* Handle exit of all possible states (of NamedInterfaceAccess._region1) at position 1... */
	switch(stateConfVector[ 1 ])
	{
		case _region1_Closed :
		{
			exseq__region1_Closed();
			break;
		}
		case _region1_Open :
		{
			exseq__region1_Open();
			break;
		}
		default: break;
	}
}

/* The reactions of state Idle. */
void NamedInterfaceAccess::react_region_1_Idle()
{
	/* The reactions of state Idle. */
	if (check_region_1_Idle_tr0_tr0())
	{ 
		effect_region_1_Idle_tr0();
	} 
}

/* The reactions of state Number1Pressed. */
void NamedInterfaceAccess::react_region_1_Number1Pressed()
{
	/* The reactions of state Number1Pressed. */
	if (check_region_1_Number1Pressed_tr0_tr0())
	{ 
		effect_region_1_Number1Pressed_tr0();
	}  else
	{
		if (check_region_1_Number1Pressed_tr1_tr1())
		{ 
			effect_region_1_Number1Pressed_tr1();
		} 
	}
}

/* The reactions of state Number2Pressed. */
void NamedInterfaceAccess::react_region_1_Number2Pressed()
{
	/* The reactions of state Number2Pressed. */
	if (check_region_1_Number2Pressed_tr0_tr0())
	{ 
		effect_region_1_Number2Pressed_tr0();
	}  else
	{
		if (check_region_1_Number2Pressed_tr1_tr1())
		{ 
			effect_region_1_Number2Pressed_tr1();
		} 
	}
}

/* The reactions of state Number3Pressed. */
void NamedInterfaceAccess::react_region_1_Number3Pressed()
{
	/* The reactions of state Number3Pressed. */
	if (check_region_1_Number3Pressed_tr0_tr0())
	{ 
		effect_region_1_Number3Pressed_tr0();
	} 
}

/* The reactions of state Closed. */
void NamedInterfaceAccess::react__region1_Closed()
{
	/* The reactions of state Closed. */
	if (check__region1_Closed_tr0_tr0())
	{ 
		effect__region1_Closed_tr0();
	} 
}

/* The reactions of state Open. */
void NamedInterfaceAccess::react__region1_Open()
{
	/* The reactions of state Open. */
	if (check__region1_Open_tr0_tr0())
	{ 
		effect__region1_Open_tr0();
	} 
}

/* Default react sequence for initial entry  */
void NamedInterfaceAccess::react_region_1__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_region_1_Idle_default();
}

/* Default react sequence for initial entry  */
void NamedInterfaceAccess::react__region1__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq__region1_Closed_default();
}


