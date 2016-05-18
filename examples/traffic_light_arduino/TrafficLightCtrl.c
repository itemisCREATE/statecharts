
#include <stdlib.h>
#include <string.h>
#include "sc/sc_types.h"
#include "TrafficLightCtrl.h"
#include "TrafficLightCtrlRequired.h"
/*! \file Implementation of the state machine 'TrafficLightCtrl'
*/

/* prototypes of all internal functions */
static sc_boolean trafficLightCtrl_check__lr0(const TrafficLightCtrl* handle);
static void trafficLightCtrl_effect__lr0(TrafficLightCtrl* handle);
static void trafficLightCtrl_enact(TrafficLightCtrl* handle);
static void trafficLightCtrl_exact(TrafficLightCtrl* handle);
static void trafficLightCtrl_react_main_region_on_r1_StreetGreen(TrafficLightCtrl* handle);
static void trafficLightCtrl_react_main_region_on_r1_PedWaiting_r1_waitOn(TrafficLightCtrl* handle);
static void trafficLightCtrl_react_main_region_on_r1_PedWaiting_r1_waitOff(TrafficLightCtrl* handle);
static void trafficLightCtrl_react_main_region_on_r1_StreetAttention(TrafficLightCtrl* handle);
static void trafficLightCtrl_react_main_region_on_r1_StreetRed(TrafficLightCtrl* handle);
static void trafficLightCtrl_react_main_region_on_r1_PedestrianGreen(TrafficLightCtrl* handle);
static void trafficLightCtrl_react_main_region_on_r1_PedestrianRed(TrafficLightCtrl* handle);
static void trafficLightCtrl_react_main_region_on_r1_StreetPrepare(TrafficLightCtrl* handle);
static void trafficLightCtrl_react_main_region_on_r1_Safe(TrafficLightCtrl* handle);
static void trafficLightCtrl_react_main_region_off_r1_YellowOn(TrafficLightCtrl* handle);
static void trafficLightCtrl_react_main_region_off_r1_YellowOff(TrafficLightCtrl* handle);
static void trafficLightCtrl_clearInEvents(TrafficLightCtrl* handle);
static void trafficLightCtrl_clearOutEvents(TrafficLightCtrl* handle);


void trafficLightCtrl_init(TrafficLightCtrl* handle)
{
	sc_integer i;

	for (i = 0; i < TRAFFICLIGHTCTRL_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = TrafficLightCtrl_last_state;
	}
	
	
	handle->stateConfVectorPosition = 0;

	trafficLightCtrl_clearInEvents(handle);
	trafficLightCtrl_clearOutEvents(handle);

	/* Default init sequence for statechart TrafficLightCtrl */
	handle->ifaceTrafficLight.red = bool_false;
	handle->ifaceTrafficLight.yellow = bool_false;
	handle->ifaceTrafficLight.green = bool_false;
	handle->ifacePedestrian.request = bool_false;
	handle->ifacePedestrian.red = bool_false;
	handle->ifacePedestrian.green = bool_false;

}

void trafficLightCtrl_enter(TrafficLightCtrl* handle)
{
	/* Default enter sequence for statechart TrafficLightCtrl */
	trafficLightCtrl_enact(handle);
	/* 'default' enter sequence for region main region */
	/* Default react sequence for initial entry  */
	/* 'default' enter sequence for state off */
	/* Entry action for state 'off'. */
	handle->ifaceTrafficLight.red = bool_false;
	handle->ifaceTrafficLight.green = bool_false;
	handle->ifaceTrafficLight.yellow = bool_false;
	handle->ifacePedestrian.red = bool_false;
	handle->ifacePedestrian.green = bool_false;
	/* 'default' enter sequence for region r1 */
	/* Default react sequence for initial entry  */
	/* 'default' enter sequence for state YellowOn */
	/* Entry action for state 'YellowOn'. */
	trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) , 500, bool_false);
	handle->ifaceTrafficLight.yellow = bool_true;
	handle->ifacePedestrian.request = bool_true;
	handle->stateConfVector[0] = TrafficLightCtrl_main_region_off_r1_YellowOn;
	handle->stateConfVectorPosition = 0;
}

void trafficLightCtrl_exit(TrafficLightCtrl* handle)
{
	/* Default exit sequence for statechart TrafficLightCtrl */
	/* Default exit sequence for region main region */
	/* Handle exit of all possible states (of TrafficLightCtrl.main_region) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case TrafficLightCtrl_main_region_on_r1_StreetGreen :
		{
			/* Default exit sequence for state StreetGreen */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
		{
			/* Default exit sequence for state waitOn */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'waitOn'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) );		
			/* Exit action for state 'PedWaiting'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
			handle->ifacePedestrian.request = bool_false;
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
		{
			/* Default exit sequence for state waitOff */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'waitOff'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) );		
			/* Exit action for state 'PedWaiting'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
			handle->ifacePedestrian.request = bool_false;
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_StreetAttention :
		{
			/* Default exit sequence for state StreetAttention */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'StreetAttention'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised) );		
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_StreetRed :
		{
			/* Default exit sequence for state StreetRed */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'StreetRed'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised) );		
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_PedestrianGreen :
		{
			/* Default exit sequence for state PedestrianGreen */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'PedestrianGreen'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised) );		
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_PedestrianRed :
		{
			/* Default exit sequence for state PedestrianRed */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'PedestrianRed'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised) );		
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_StreetPrepare :
		{
			/* Default exit sequence for state StreetPrepare */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'StreetPrepare'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised) );		
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_Safe :
		{
			/* Default exit sequence for state Safe */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'Safe'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised) );		
			break;
		}
		case TrafficLightCtrl_main_region_off_r1_YellowOn :
		{
			/* Default exit sequence for state YellowOn */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'YellowOn'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) );		
			break;
		}
		case TrafficLightCtrl_main_region_off_r1_YellowOff :
		{
			/* Default exit sequence for state YellowOff */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'YellowOff'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOff_tev0_raised) );		
			break;
		}
		default: break;
	}
	trafficLightCtrl_exact(handle);
}

sc_boolean trafficLightCtrl_isActive(const TrafficLightCtrl* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != TrafficLightCtrl_last_state)
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
sc_boolean trafficLightCtrl_isFinal(const TrafficLightCtrl* handle)
{
   return bool_false;
}

static void trafficLightCtrl_clearInEvents(TrafficLightCtrl* handle)
{
	handle->iface.pedestrianRequest_raised = bool_false;
	handle->iface.onOff_raised = bool_false;
	handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised = bool_false;
	handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised = bool_false;
	handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised = bool_false;
	handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised = bool_false;
	handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised = bool_false;
	handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised = bool_false;
	handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised = bool_false;
	handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised = bool_false;
	handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised = bool_false;
	handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised = bool_false;
	handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOff_tev0_raised = bool_false;
	handle->timeEvents.trafficLightCtrl_tev0_raised = bool_false;
}

static void trafficLightCtrl_clearOutEvents(TrafficLightCtrl* handle)
{
}

void trafficLightCtrl_runCycle(TrafficLightCtrl* handle)
{
	
	trafficLightCtrl_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < TRAFFICLIGHTCTRL_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case TrafficLightCtrl_main_region_on_r1_StreetGreen :
		{
			trafficLightCtrl_react_main_region_on_r1_StreetGreen(handle);
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
		{
			trafficLightCtrl_react_main_region_on_r1_PedWaiting_r1_waitOn(handle);
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
		{
			trafficLightCtrl_react_main_region_on_r1_PedWaiting_r1_waitOff(handle);
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_StreetAttention :
		{
			trafficLightCtrl_react_main_region_on_r1_StreetAttention(handle);
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_StreetRed :
		{
			trafficLightCtrl_react_main_region_on_r1_StreetRed(handle);
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_PedestrianGreen :
		{
			trafficLightCtrl_react_main_region_on_r1_PedestrianGreen(handle);
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_PedestrianRed :
		{
			trafficLightCtrl_react_main_region_on_r1_PedestrianRed(handle);
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_StreetPrepare :
		{
			trafficLightCtrl_react_main_region_on_r1_StreetPrepare(handle);
			break;
		}
		case TrafficLightCtrl_main_region_on_r1_Safe :
		{
			trafficLightCtrl_react_main_region_on_r1_Safe(handle);
			break;
		}
		case TrafficLightCtrl_main_region_off_r1_YellowOn :
		{
			trafficLightCtrl_react_main_region_off_r1_YellowOn(handle);
			break;
		}
		case TrafficLightCtrl_main_region_off_r1_YellowOff :
		{
			trafficLightCtrl_react_main_region_off_r1_YellowOff(handle);
			break;
		}
		default:
			break;
		}
	}
	
	trafficLightCtrl_clearInEvents(handle);
}

void trafficLightCtrl_raiseTimeEvent(const TrafficLightCtrl* handle, sc_eventid evid)
{
	if ( ((sc_intptr_t)evid) >= ((sc_intptr_t)&(handle->timeEvents))
		&&  ((sc_intptr_t)evid) < ((sc_intptr_t)&(handle->timeEvents)) + sizeof(TrafficLightCtrlTimeEvents))
		{
		*(sc_boolean*)evid = bool_true;
	}		
}

sc_boolean trafficLightCtrl_isStateActive(const TrafficLightCtrl* handle, TrafficLightCtrlStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case TrafficLightCtrl_main_region_on :
			result = (sc_boolean) (handle->stateConfVector[0] >= TrafficLightCtrl_main_region_on
				&& handle->stateConfVector[0] <= TrafficLightCtrl_main_region_on_r1_Safe);
			break;
		case TrafficLightCtrl_main_region_on_r1_StreetGreen :
			result = (sc_boolean) (handle->stateConfVector[0] == TrafficLightCtrl_main_region_on_r1_StreetGreen
			);
			break;
		case TrafficLightCtrl_main_region_on_r1_PedWaiting :
			result = (sc_boolean) (handle->stateConfVector[0] >= TrafficLightCtrl_main_region_on_r1_PedWaiting
				&& handle->stateConfVector[0] <= TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff);
			break;
		case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
			result = (sc_boolean) (handle->stateConfVector[0] == TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn
			);
			break;
		case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
			result = (sc_boolean) (handle->stateConfVector[0] == TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff
			);
			break;
		case TrafficLightCtrl_main_region_on_r1_StreetAttention :
			result = (sc_boolean) (handle->stateConfVector[0] == TrafficLightCtrl_main_region_on_r1_StreetAttention
			);
			break;
		case TrafficLightCtrl_main_region_on_r1_StreetRed :
			result = (sc_boolean) (handle->stateConfVector[0] == TrafficLightCtrl_main_region_on_r1_StreetRed
			);
			break;
		case TrafficLightCtrl_main_region_on_r1_PedestrianGreen :
			result = (sc_boolean) (handle->stateConfVector[0] == TrafficLightCtrl_main_region_on_r1_PedestrianGreen
			);
			break;
		case TrafficLightCtrl_main_region_on_r1_PedestrianRed :
			result = (sc_boolean) (handle->stateConfVector[0] == TrafficLightCtrl_main_region_on_r1_PedestrianRed
			);
			break;
		case TrafficLightCtrl_main_region_on_r1_StreetPrepare :
			result = (sc_boolean) (handle->stateConfVector[0] == TrafficLightCtrl_main_region_on_r1_StreetPrepare
			);
			break;
		case TrafficLightCtrl_main_region_on_r1_Safe :
			result = (sc_boolean) (handle->stateConfVector[0] == TrafficLightCtrl_main_region_on_r1_Safe
			);
			break;
		case TrafficLightCtrl_main_region_off :
			result = (sc_boolean) (handle->stateConfVector[0] >= TrafficLightCtrl_main_region_off
				&& handle->stateConfVector[0] <= TrafficLightCtrl_main_region_off_r1_YellowOff);
			break;
		case TrafficLightCtrl_main_region_off_r1_YellowOn :
			result = (sc_boolean) (handle->stateConfVector[0] == TrafficLightCtrl_main_region_off_r1_YellowOn
			);
			break;
		case TrafficLightCtrl_main_region_off_r1_YellowOff :
			result = (sc_boolean) (handle->stateConfVector[0] == TrafficLightCtrl_main_region_off_r1_YellowOff
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}



sc_boolean trafficLightCtrlIfaceTrafficLight_get_red(const TrafficLightCtrl* handle)
{
	return handle->ifaceTrafficLight.red;
}
void trafficLightCtrlIfaceTrafficLight_set_red(TrafficLightCtrl* handle, sc_boolean value)
{
	handle->ifaceTrafficLight.red = value;
}
sc_boolean trafficLightCtrlIfaceTrafficLight_get_yellow(const TrafficLightCtrl* handle)
{
	return handle->ifaceTrafficLight.yellow;
}
void trafficLightCtrlIfaceTrafficLight_set_yellow(TrafficLightCtrl* handle, sc_boolean value)
{
	handle->ifaceTrafficLight.yellow = value;
}
sc_boolean trafficLightCtrlIfaceTrafficLight_get_green(const TrafficLightCtrl* handle)
{
	return handle->ifaceTrafficLight.green;
}
void trafficLightCtrlIfaceTrafficLight_set_green(TrafficLightCtrl* handle, sc_boolean value)
{
	handle->ifaceTrafficLight.green = value;
}


sc_boolean trafficLightCtrlIfacePedestrian_get_request(const TrafficLightCtrl* handle)
{
	return handle->ifacePedestrian.request;
}
void trafficLightCtrlIfacePedestrian_set_request(TrafficLightCtrl* handle, sc_boolean value)
{
	handle->ifacePedestrian.request = value;
}
sc_boolean trafficLightCtrlIfacePedestrian_get_red(const TrafficLightCtrl* handle)
{
	return handle->ifacePedestrian.red;
}
void trafficLightCtrlIfacePedestrian_set_red(TrafficLightCtrl* handle, sc_boolean value)
{
	handle->ifacePedestrian.red = value;
}
sc_boolean trafficLightCtrlIfacePedestrian_get_green(const TrafficLightCtrl* handle)
{
	return handle->ifacePedestrian.green;
}
void trafficLightCtrlIfacePedestrian_set_green(TrafficLightCtrl* handle, sc_boolean value)
{
	handle->ifacePedestrian.green = value;
}
void trafficLightCtrlIface_raise_pedestrianRequest(TrafficLightCtrl* handle)
{
	handle->iface.pedestrianRequest_raised = bool_true;
}
void trafficLightCtrlIface_raise_onOff(TrafficLightCtrl* handle)
{
	handle->iface.onOff_raised = bool_true;
}



/* implementations of all internal functions */

static sc_boolean trafficLightCtrl_check__lr0(const TrafficLightCtrl* handle)
{
	return handle->timeEvents.trafficLightCtrl_tev0_raised;
}

static void trafficLightCtrl_effect__lr0(TrafficLightCtrl* handle)
{
	trafficLightCtrlIface_synchronize(handle);
}

/* Entry action for statechart 'TrafficLightCtrl'. */
static void trafficLightCtrl_enact(TrafficLightCtrl* handle)
{
	/* Entry action for statechart 'TrafficLightCtrl'. */
	trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_tev0_raised) , 200, bool_true);
}

/* Exit action for state 'TrafficLightCtrl'. */
static void trafficLightCtrl_exact(TrafficLightCtrl* handle)
{
	/* Exit action for state 'TrafficLightCtrl'. */
	trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_tev0_raised) );		
}

/* The reactions of state StreetGreen. */
static void trafficLightCtrl_react_main_region_on_r1_StreetGreen(TrafficLightCtrl* handle)
{
	/* The reactions of state StreetGreen. */
	if (trafficLightCtrl_check__lr0(handle) == bool_true)
	{ 
		trafficLightCtrl_effect__lr0(handle);
	} 
	if (handle->iface.onOff_raised == bool_true)
	{ 
		/* Default exit sequence for state on */
		/* Default exit sequence for region r1 */
		/* Handle exit of all possible states (of TrafficLightCtrl.main_region.on.r1) at position 0... */
		switch(handle->stateConfVector[ 0 ])
		{
			case TrafficLightCtrl_main_region_on_r1_StreetGreen :
			{
				/* Default exit sequence for state StreetGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
			{
				/* Default exit sequence for state waitOn */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOn'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
			{
				/* Default exit sequence for state waitOff */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOff'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetAttention :
			{
				/* Default exit sequence for state StreetAttention */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetAttention'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetRed :
			{
				/* Default exit sequence for state StreetRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianGreen :
			{
				/* Default exit sequence for state PedestrianGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianGreen'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianRed :
			{
				/* Default exit sequence for state PedestrianRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetPrepare :
			{
				/* Default exit sequence for state StreetPrepare */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetPrepare'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_Safe :
			{
				/* Default exit sequence for state Safe */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'Safe'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised) );		
				break;
			}
			default: break;
		}
		/* 'default' enter sequence for state off */
		/* Entry action for state 'off'. */
		handle->ifaceTrafficLight.red = bool_false;
		handle->ifaceTrafficLight.green = bool_false;
		handle->ifaceTrafficLight.yellow = bool_false;
		handle->ifacePedestrian.red = bool_false;
		handle->ifacePedestrian.green = bool_false;
		/* 'default' enter sequence for region r1 */
		/* Default react sequence for initial entry  */
		/* 'default' enter sequence for state YellowOn */
		/* Entry action for state 'YellowOn'. */
		trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) , 500, bool_false);
		handle->ifaceTrafficLight.yellow = bool_true;
		handle->ifacePedestrian.request = bool_true;
		handle->stateConfVector[0] = TrafficLightCtrl_main_region_off_r1_YellowOn;
		handle->stateConfVectorPosition = 0;
	}  else
	{
		if (handle->iface.pedestrianRequest_raised == bool_true)
		{ 
			/* Default exit sequence for state StreetGreen */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* 'default' enter sequence for state PedWaiting */
			/* Entry action for state 'PedWaiting'. */
			trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) , 7 * 1000, bool_false);
			/* 'default' enter sequence for region r1 */
			/* Default react sequence for initial entry  */
			/* 'default' enter sequence for state waitOn */
			/* Entry action for state 'waitOn'. */
			trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) , 500, bool_false);
			handle->ifacePedestrian.request = bool_true;
			handle->stateConfVector[0] = TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn;
			handle->stateConfVectorPosition = 0;
		} 
	}
}

/* The reactions of state waitOn. */
static void trafficLightCtrl_react_main_region_on_r1_PedWaiting_r1_waitOn(TrafficLightCtrl* handle)
{
	/* The reactions of state waitOn. */
	if (trafficLightCtrl_check__lr0(handle) == bool_true)
	{ 
		trafficLightCtrl_effect__lr0(handle);
	} 
	if (handle->iface.onOff_raised == bool_true)
	{ 
		/* Default exit sequence for state on */
		/* Default exit sequence for region r1 */
		/* Handle exit of all possible states (of TrafficLightCtrl.main_region.on.r1) at position 0... */
		switch(handle->stateConfVector[ 0 ])
		{
			case TrafficLightCtrl_main_region_on_r1_StreetGreen :
			{
				/* Default exit sequence for state StreetGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
			{
				/* Default exit sequence for state waitOn */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOn'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
			{
				/* Default exit sequence for state waitOff */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOff'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetAttention :
			{
				/* Default exit sequence for state StreetAttention */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetAttention'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetRed :
			{
				/* Default exit sequence for state StreetRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianGreen :
			{
				/* Default exit sequence for state PedestrianGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianGreen'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianRed :
			{
				/* Default exit sequence for state PedestrianRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetPrepare :
			{
				/* Default exit sequence for state StreetPrepare */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetPrepare'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_Safe :
			{
				/* Default exit sequence for state Safe */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'Safe'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised) );		
				break;
			}
			default: break;
		}
		/* 'default' enter sequence for state off */
		/* Entry action for state 'off'. */
		handle->ifaceTrafficLight.red = bool_false;
		handle->ifaceTrafficLight.green = bool_false;
		handle->ifaceTrafficLight.yellow = bool_false;
		handle->ifacePedestrian.red = bool_false;
		handle->ifacePedestrian.green = bool_false;
		/* 'default' enter sequence for region r1 */
		/* Default react sequence for initial entry  */
		/* 'default' enter sequence for state YellowOn */
		/* Entry action for state 'YellowOn'. */
		trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) , 500, bool_false);
		handle->ifaceTrafficLight.yellow = bool_true;
		handle->ifacePedestrian.request = bool_true;
		handle->stateConfVector[0] = TrafficLightCtrl_main_region_off_r1_YellowOn;
		handle->stateConfVectorPosition = 0;
	}  else
	{
		if (handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised == bool_true)
		{ 
			/* Default exit sequence for state PedWaiting */
			/* Default exit sequence for region r1 */
			/* Handle exit of all possible states (of TrafficLightCtrl.main_region.on.r1.PedWaiting.r1) at position 0... */
			switch(handle->stateConfVector[ 0 ])
			{
				case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
				{
					/* Default exit sequence for state waitOn */
					handle->stateConfVector[0] = TrafficLightCtrl_last_state;
					handle->stateConfVectorPosition = 0;
					/* Exit action for state 'waitOn'. */
					trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) );		
					break;
				}
				case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
				{
					/* Default exit sequence for state waitOff */
					handle->stateConfVector[0] = TrafficLightCtrl_last_state;
					handle->stateConfVectorPosition = 0;
					/* Exit action for state 'waitOff'. */
					trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) );		
					break;
				}
				default: break;
			}
			/* Exit action for state 'PedWaiting'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
			handle->ifacePedestrian.request = bool_false;
			/* 'default' enter sequence for state StreetAttention */
			/* Entry action for state 'StreetAttention'. */
			trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised) , 2 * 1000, bool_false);
			handle->ifaceTrafficLight.red = bool_false;
			handle->ifaceTrafficLight.yellow = bool_true;
			handle->ifaceTrafficLight.green = bool_false;
			handle->stateConfVector[0] = TrafficLightCtrl_main_region_on_r1_StreetAttention;
			handle->stateConfVectorPosition = 0;
		}  else
		{
			if (handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised == bool_true)
			{ 
				/* Default exit sequence for state waitOn */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOn'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) );		
				/* 'default' enter sequence for state waitOff */
				/* Entry action for state 'waitOff'. */
				trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) , 500, bool_false);
				handle->ifacePedestrian.request = bool_false;
				handle->stateConfVector[0] = TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff;
				handle->stateConfVectorPosition = 0;
			} 
		}
	}
}

/* The reactions of state waitOff. */
static void trafficLightCtrl_react_main_region_on_r1_PedWaiting_r1_waitOff(TrafficLightCtrl* handle)
{
	/* The reactions of state waitOff. */
	if (trafficLightCtrl_check__lr0(handle) == bool_true)
	{ 
		trafficLightCtrl_effect__lr0(handle);
	} 
	if (handle->iface.onOff_raised == bool_true)
	{ 
		/* Default exit sequence for state on */
		/* Default exit sequence for region r1 */
		/* Handle exit of all possible states (of TrafficLightCtrl.main_region.on.r1) at position 0... */
		switch(handle->stateConfVector[ 0 ])
		{
			case TrafficLightCtrl_main_region_on_r1_StreetGreen :
			{
				/* Default exit sequence for state StreetGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
			{
				/* Default exit sequence for state waitOn */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOn'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
			{
				/* Default exit sequence for state waitOff */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOff'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetAttention :
			{
				/* Default exit sequence for state StreetAttention */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetAttention'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetRed :
			{
				/* Default exit sequence for state StreetRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianGreen :
			{
				/* Default exit sequence for state PedestrianGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianGreen'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianRed :
			{
				/* Default exit sequence for state PedestrianRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetPrepare :
			{
				/* Default exit sequence for state StreetPrepare */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetPrepare'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_Safe :
			{
				/* Default exit sequence for state Safe */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'Safe'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised) );		
				break;
			}
			default: break;
		}
		/* 'default' enter sequence for state off */
		/* Entry action for state 'off'. */
		handle->ifaceTrafficLight.red = bool_false;
		handle->ifaceTrafficLight.green = bool_false;
		handle->ifaceTrafficLight.yellow = bool_false;
		handle->ifacePedestrian.red = bool_false;
		handle->ifacePedestrian.green = bool_false;
		/* 'default' enter sequence for region r1 */
		/* Default react sequence for initial entry  */
		/* 'default' enter sequence for state YellowOn */
		/* Entry action for state 'YellowOn'. */
		trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) , 500, bool_false);
		handle->ifaceTrafficLight.yellow = bool_true;
		handle->ifacePedestrian.request = bool_true;
		handle->stateConfVector[0] = TrafficLightCtrl_main_region_off_r1_YellowOn;
		handle->stateConfVectorPosition = 0;
	}  else
	{
		if (handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised == bool_true)
		{ 
			/* Default exit sequence for state PedWaiting */
			/* Default exit sequence for region r1 */
			/* Handle exit of all possible states (of TrafficLightCtrl.main_region.on.r1.PedWaiting.r1) at position 0... */
			switch(handle->stateConfVector[ 0 ])
			{
				case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
				{
					/* Default exit sequence for state waitOn */
					handle->stateConfVector[0] = TrafficLightCtrl_last_state;
					handle->stateConfVectorPosition = 0;
					/* Exit action for state 'waitOn'. */
					trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) );		
					break;
				}
				case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
				{
					/* Default exit sequence for state waitOff */
					handle->stateConfVector[0] = TrafficLightCtrl_last_state;
					handle->stateConfVectorPosition = 0;
					/* Exit action for state 'waitOff'. */
					trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) );		
					break;
				}
				default: break;
			}
			/* Exit action for state 'PedWaiting'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
			handle->ifacePedestrian.request = bool_false;
			/* 'default' enter sequence for state StreetAttention */
			/* Entry action for state 'StreetAttention'. */
			trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised) , 2 * 1000, bool_false);
			handle->ifaceTrafficLight.red = bool_false;
			handle->ifaceTrafficLight.yellow = bool_true;
			handle->ifaceTrafficLight.green = bool_false;
			handle->stateConfVector[0] = TrafficLightCtrl_main_region_on_r1_StreetAttention;
			handle->stateConfVectorPosition = 0;
		}  else
		{
			if (handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised == bool_true)
			{ 
				/* Default exit sequence for state waitOff */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOff'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) );		
				/* 'default' enter sequence for state waitOn */
				/* Entry action for state 'waitOn'. */
				trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) , 500, bool_false);
				handle->ifacePedestrian.request = bool_true;
				handle->stateConfVector[0] = TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn;
				handle->stateConfVectorPosition = 0;
			} 
		}
	}
}

/* The reactions of state StreetAttention. */
static void trafficLightCtrl_react_main_region_on_r1_StreetAttention(TrafficLightCtrl* handle)
{
	/* The reactions of state StreetAttention. */
	if (trafficLightCtrl_check__lr0(handle) == bool_true)
	{ 
		trafficLightCtrl_effect__lr0(handle);
	} 
	if (handle->iface.onOff_raised == bool_true)
	{ 
		/* Default exit sequence for state on */
		/* Default exit sequence for region r1 */
		/* Handle exit of all possible states (of TrafficLightCtrl.main_region.on.r1) at position 0... */
		switch(handle->stateConfVector[ 0 ])
		{
			case TrafficLightCtrl_main_region_on_r1_StreetGreen :
			{
				/* Default exit sequence for state StreetGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
			{
				/* Default exit sequence for state waitOn */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOn'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
			{
				/* Default exit sequence for state waitOff */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOff'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetAttention :
			{
				/* Default exit sequence for state StreetAttention */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetAttention'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetRed :
			{
				/* Default exit sequence for state StreetRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianGreen :
			{
				/* Default exit sequence for state PedestrianGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianGreen'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianRed :
			{
				/* Default exit sequence for state PedestrianRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetPrepare :
			{
				/* Default exit sequence for state StreetPrepare */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetPrepare'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_Safe :
			{
				/* Default exit sequence for state Safe */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'Safe'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised) );		
				break;
			}
			default: break;
		}
		/* 'default' enter sequence for state off */
		/* Entry action for state 'off'. */
		handle->ifaceTrafficLight.red = bool_false;
		handle->ifaceTrafficLight.green = bool_false;
		handle->ifaceTrafficLight.yellow = bool_false;
		handle->ifacePedestrian.red = bool_false;
		handle->ifacePedestrian.green = bool_false;
		/* 'default' enter sequence for region r1 */
		/* Default react sequence for initial entry  */
		/* 'default' enter sequence for state YellowOn */
		/* Entry action for state 'YellowOn'. */
		trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) , 500, bool_false);
		handle->ifaceTrafficLight.yellow = bool_true;
		handle->ifacePedestrian.request = bool_true;
		handle->stateConfVector[0] = TrafficLightCtrl_main_region_off_r1_YellowOn;
		handle->stateConfVectorPosition = 0;
	}  else
	{
		if (handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised == bool_true)
		{ 
			/* Default exit sequence for state StreetAttention */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'StreetAttention'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised) );		
			/* 'default' enter sequence for state StreetRed */
			/* Entry action for state 'StreetRed'. */
			trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised) , 2 * 1000, bool_false);
			handle->ifaceTrafficLight.red = bool_true;
			handle->ifaceTrafficLight.yellow = bool_false;
			handle->ifaceTrafficLight.green = bool_false;
			handle->stateConfVector[0] = TrafficLightCtrl_main_region_on_r1_StreetRed;
			handle->stateConfVectorPosition = 0;
		} 
	}
}

/* The reactions of state StreetRed. */
static void trafficLightCtrl_react_main_region_on_r1_StreetRed(TrafficLightCtrl* handle)
{
	/* The reactions of state StreetRed. */
	if (trafficLightCtrl_check__lr0(handle) == bool_true)
	{ 
		trafficLightCtrl_effect__lr0(handle);
	} 
	if (handle->iface.onOff_raised == bool_true)
	{ 
		/* Default exit sequence for state on */
		/* Default exit sequence for region r1 */
		/* Handle exit of all possible states (of TrafficLightCtrl.main_region.on.r1) at position 0... */
		switch(handle->stateConfVector[ 0 ])
		{
			case TrafficLightCtrl_main_region_on_r1_StreetGreen :
			{
				/* Default exit sequence for state StreetGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
			{
				/* Default exit sequence for state waitOn */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOn'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
			{
				/* Default exit sequence for state waitOff */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOff'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetAttention :
			{
				/* Default exit sequence for state StreetAttention */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetAttention'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetRed :
			{
				/* Default exit sequence for state StreetRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianGreen :
			{
				/* Default exit sequence for state PedestrianGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianGreen'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianRed :
			{
				/* Default exit sequence for state PedestrianRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetPrepare :
			{
				/* Default exit sequence for state StreetPrepare */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetPrepare'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_Safe :
			{
				/* Default exit sequence for state Safe */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'Safe'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised) );		
				break;
			}
			default: break;
		}
		/* 'default' enter sequence for state off */
		/* Entry action for state 'off'. */
		handle->ifaceTrafficLight.red = bool_false;
		handle->ifaceTrafficLight.green = bool_false;
		handle->ifaceTrafficLight.yellow = bool_false;
		handle->ifacePedestrian.red = bool_false;
		handle->ifacePedestrian.green = bool_false;
		/* 'default' enter sequence for region r1 */
		/* Default react sequence for initial entry  */
		/* 'default' enter sequence for state YellowOn */
		/* Entry action for state 'YellowOn'. */
		trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) , 500, bool_false);
		handle->ifaceTrafficLight.yellow = bool_true;
		handle->ifacePedestrian.request = bool_true;
		handle->stateConfVector[0] = TrafficLightCtrl_main_region_off_r1_YellowOn;
		handle->stateConfVectorPosition = 0;
	}  else
	{
		if (handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised == bool_true)
		{ 
			/* Default exit sequence for state StreetRed */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'StreetRed'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised) );		
			/* 'default' enter sequence for state PedestrianGreen */
			/* Entry action for state 'PedestrianGreen'. */
			trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised) , 7 * 1000, bool_false);
			handle->ifacePedestrian.red = bool_false;
			handle->ifacePedestrian.green = bool_true;
			handle->stateConfVector[0] = TrafficLightCtrl_main_region_on_r1_PedestrianGreen;
			handle->stateConfVectorPosition = 0;
		} 
	}
}

/* The reactions of state PedestrianGreen. */
static void trafficLightCtrl_react_main_region_on_r1_PedestrianGreen(TrafficLightCtrl* handle)
{
	/* The reactions of state PedestrianGreen. */
	if (trafficLightCtrl_check__lr0(handle) == bool_true)
	{ 
		trafficLightCtrl_effect__lr0(handle);
	} 
	if (handle->iface.onOff_raised == bool_true)
	{ 
		/* Default exit sequence for state on */
		/* Default exit sequence for region r1 */
		/* Handle exit of all possible states (of TrafficLightCtrl.main_region.on.r1) at position 0... */
		switch(handle->stateConfVector[ 0 ])
		{
			case TrafficLightCtrl_main_region_on_r1_StreetGreen :
			{
				/* Default exit sequence for state StreetGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
			{
				/* Default exit sequence for state waitOn */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOn'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
			{
				/* Default exit sequence for state waitOff */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOff'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetAttention :
			{
				/* Default exit sequence for state StreetAttention */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetAttention'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetRed :
			{
				/* Default exit sequence for state StreetRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianGreen :
			{
				/* Default exit sequence for state PedestrianGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianGreen'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianRed :
			{
				/* Default exit sequence for state PedestrianRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetPrepare :
			{
				/* Default exit sequence for state StreetPrepare */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetPrepare'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_Safe :
			{
				/* Default exit sequence for state Safe */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'Safe'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised) );		
				break;
			}
			default: break;
		}
		/* 'default' enter sequence for state off */
		/* Entry action for state 'off'. */
		handle->ifaceTrafficLight.red = bool_false;
		handle->ifaceTrafficLight.green = bool_false;
		handle->ifaceTrafficLight.yellow = bool_false;
		handle->ifacePedestrian.red = bool_false;
		handle->ifacePedestrian.green = bool_false;
		/* 'default' enter sequence for region r1 */
		/* Default react sequence for initial entry  */
		/* 'default' enter sequence for state YellowOn */
		/* Entry action for state 'YellowOn'. */
		trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) , 500, bool_false);
		handle->ifaceTrafficLight.yellow = bool_true;
		handle->ifacePedestrian.request = bool_true;
		handle->stateConfVector[0] = TrafficLightCtrl_main_region_off_r1_YellowOn;
		handle->stateConfVectorPosition = 0;
	}  else
	{
		if (handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised == bool_true)
		{ 
			/* Default exit sequence for state PedestrianGreen */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'PedestrianGreen'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised) );		
			/* 'default' enter sequence for state PedestrianRed */
			/* Entry action for state 'PedestrianRed'. */
			trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised) , 5 * 1000, bool_false);
			handle->ifacePedestrian.red = bool_true;
			handle->ifacePedestrian.green = bool_false;
			handle->stateConfVector[0] = TrafficLightCtrl_main_region_on_r1_PedestrianRed;
			handle->stateConfVectorPosition = 0;
		} 
	}
}

/* The reactions of state PedestrianRed. */
static void trafficLightCtrl_react_main_region_on_r1_PedestrianRed(TrafficLightCtrl* handle)
{
	/* The reactions of state PedestrianRed. */
	if (trafficLightCtrl_check__lr0(handle) == bool_true)
	{ 
		trafficLightCtrl_effect__lr0(handle);
	} 
	if (handle->iface.onOff_raised == bool_true)
	{ 
		/* Default exit sequence for state on */
		/* Default exit sequence for region r1 */
		/* Handle exit of all possible states (of TrafficLightCtrl.main_region.on.r1) at position 0... */
		switch(handle->stateConfVector[ 0 ])
		{
			case TrafficLightCtrl_main_region_on_r1_StreetGreen :
			{
				/* Default exit sequence for state StreetGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
			{
				/* Default exit sequence for state waitOn */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOn'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
			{
				/* Default exit sequence for state waitOff */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOff'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetAttention :
			{
				/* Default exit sequence for state StreetAttention */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetAttention'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetRed :
			{
				/* Default exit sequence for state StreetRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianGreen :
			{
				/* Default exit sequence for state PedestrianGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianGreen'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianRed :
			{
				/* Default exit sequence for state PedestrianRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetPrepare :
			{
				/* Default exit sequence for state StreetPrepare */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetPrepare'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_Safe :
			{
				/* Default exit sequence for state Safe */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'Safe'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised) );		
				break;
			}
			default: break;
		}
		/* 'default' enter sequence for state off */
		/* Entry action for state 'off'. */
		handle->ifaceTrafficLight.red = bool_false;
		handle->ifaceTrafficLight.green = bool_false;
		handle->ifaceTrafficLight.yellow = bool_false;
		handle->ifacePedestrian.red = bool_false;
		handle->ifacePedestrian.green = bool_false;
		/* 'default' enter sequence for region r1 */
		/* Default react sequence for initial entry  */
		/* 'default' enter sequence for state YellowOn */
		/* Entry action for state 'YellowOn'. */
		trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) , 500, bool_false);
		handle->ifaceTrafficLight.yellow = bool_true;
		handle->ifacePedestrian.request = bool_true;
		handle->stateConfVector[0] = TrafficLightCtrl_main_region_off_r1_YellowOn;
		handle->stateConfVectorPosition = 0;
	}  else
	{
		if (handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised == bool_true)
		{ 
			/* Default exit sequence for state PedestrianRed */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'PedestrianRed'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised) );		
			/* 'default' enter sequence for state StreetPrepare */
			/* Entry action for state 'StreetPrepare'. */
			trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised) , 2 * 1000, bool_false);
			handle->ifaceTrafficLight.red = bool_true;
			handle->ifaceTrafficLight.yellow = bool_true;
			handle->ifaceTrafficLight.green = bool_false;
			handle->stateConfVector[0] = TrafficLightCtrl_main_region_on_r1_StreetPrepare;
			handle->stateConfVectorPosition = 0;
		} 
	}
}

/* The reactions of state StreetPrepare. */
static void trafficLightCtrl_react_main_region_on_r1_StreetPrepare(TrafficLightCtrl* handle)
{
	/* The reactions of state StreetPrepare. */
	if (trafficLightCtrl_check__lr0(handle) == bool_true)
	{ 
		trafficLightCtrl_effect__lr0(handle);
	} 
	if (handle->iface.onOff_raised == bool_true)
	{ 
		/* Default exit sequence for state on */
		/* Default exit sequence for region r1 */
		/* Handle exit of all possible states (of TrafficLightCtrl.main_region.on.r1) at position 0... */
		switch(handle->stateConfVector[ 0 ])
		{
			case TrafficLightCtrl_main_region_on_r1_StreetGreen :
			{
				/* Default exit sequence for state StreetGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
			{
				/* Default exit sequence for state waitOn */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOn'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
			{
				/* Default exit sequence for state waitOff */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOff'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetAttention :
			{
				/* Default exit sequence for state StreetAttention */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetAttention'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetRed :
			{
				/* Default exit sequence for state StreetRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianGreen :
			{
				/* Default exit sequence for state PedestrianGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianGreen'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianRed :
			{
				/* Default exit sequence for state PedestrianRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetPrepare :
			{
				/* Default exit sequence for state StreetPrepare */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetPrepare'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_Safe :
			{
				/* Default exit sequence for state Safe */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'Safe'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised) );		
				break;
			}
			default: break;
		}
		/* 'default' enter sequence for state off */
		/* Entry action for state 'off'. */
		handle->ifaceTrafficLight.red = bool_false;
		handle->ifaceTrafficLight.green = bool_false;
		handle->ifaceTrafficLight.yellow = bool_false;
		handle->ifacePedestrian.red = bool_false;
		handle->ifacePedestrian.green = bool_false;
		/* 'default' enter sequence for region r1 */
		/* Default react sequence for initial entry  */
		/* 'default' enter sequence for state YellowOn */
		/* Entry action for state 'YellowOn'. */
		trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) , 500, bool_false);
		handle->ifaceTrafficLight.yellow = bool_true;
		handle->ifacePedestrian.request = bool_true;
		handle->stateConfVector[0] = TrafficLightCtrl_main_region_off_r1_YellowOn;
		handle->stateConfVectorPosition = 0;
	}  else
	{
		if (handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised == bool_true)
		{ 
			/* Default exit sequence for state StreetPrepare */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'StreetPrepare'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised) );		
			/* 'default' enter sequence for state StreetGreen */
			/* Entry action for state 'StreetGreen'. */
			handle->ifaceTrafficLight.red = bool_false;
			handle->ifaceTrafficLight.yellow = bool_false;
			handle->ifaceTrafficLight.green = bool_true;
			handle->ifacePedestrian.red = bool_true;
			handle->ifacePedestrian.green = bool_false;
			handle->ifacePedestrian.request = bool_false;
			handle->stateConfVector[0] = TrafficLightCtrl_main_region_on_r1_StreetGreen;
			handle->stateConfVectorPosition = 0;
		} 
	}
}

/* The reactions of state Safe. */
static void trafficLightCtrl_react_main_region_on_r1_Safe(TrafficLightCtrl* handle)
{
	/* The reactions of state Safe. */
	if (trafficLightCtrl_check__lr0(handle) == bool_true)
	{ 
		trafficLightCtrl_effect__lr0(handle);
	} 
	if (handle->iface.onOff_raised == bool_true)
	{ 
		/* Default exit sequence for state on */
		/* Default exit sequence for region r1 */
		/* Handle exit of all possible states (of TrafficLightCtrl.main_region.on.r1) at position 0... */
		switch(handle->stateConfVector[ 0 ])
		{
			case TrafficLightCtrl_main_region_on_r1_StreetGreen :
			{
				/* Default exit sequence for state StreetGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn :
			{
				/* Default exit sequence for state waitOn */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOn'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff :
			{
				/* Default exit sequence for state waitOff */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'waitOff'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised) );		
				/* Exit action for state 'PedWaiting'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised) );		
				handle->ifacePedestrian.request = bool_false;
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetAttention :
			{
				/* Default exit sequence for state StreetAttention */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetAttention'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetRed :
			{
				/* Default exit sequence for state StreetRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianGreen :
			{
				/* Default exit sequence for state PedestrianGreen */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianGreen'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_PedestrianRed :
			{
				/* Default exit sequence for state PedestrianRed */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'PedestrianRed'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_StreetPrepare :
			{
				/* Default exit sequence for state StreetPrepare */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'StreetPrepare'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_on_r1_Safe :
			{
				/* Default exit sequence for state Safe */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'Safe'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised) );		
				break;
			}
			default: break;
		}
		/* 'default' enter sequence for state off */
		/* Entry action for state 'off'. */
		handle->ifaceTrafficLight.red = bool_false;
		handle->ifaceTrafficLight.green = bool_false;
		handle->ifaceTrafficLight.yellow = bool_false;
		handle->ifacePedestrian.red = bool_false;
		handle->ifacePedestrian.green = bool_false;
		/* 'default' enter sequence for region r1 */
		/* Default react sequence for initial entry  */
		/* 'default' enter sequence for state YellowOn */
		/* Entry action for state 'YellowOn'. */
		trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) , 500, bool_false);
		handle->ifaceTrafficLight.yellow = bool_true;
		handle->ifacePedestrian.request = bool_true;
		handle->stateConfVector[0] = TrafficLightCtrl_main_region_off_r1_YellowOn;
		handle->stateConfVectorPosition = 0;
	}  else
	{
		if (handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised == bool_true)
		{ 
			/* Default exit sequence for state Safe */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'Safe'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised) );		
			/* 'default' enter sequence for state StreetPrepare */
			/* Entry action for state 'StreetPrepare'. */
			trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised) , 2 * 1000, bool_false);
			handle->ifaceTrafficLight.red = bool_true;
			handle->ifaceTrafficLight.yellow = bool_true;
			handle->ifaceTrafficLight.green = bool_false;
			handle->stateConfVector[0] = TrafficLightCtrl_main_region_on_r1_StreetPrepare;
			handle->stateConfVectorPosition = 0;
		} 
	}
}

/* The reactions of state YellowOn. */
static void trafficLightCtrl_react_main_region_off_r1_YellowOn(TrafficLightCtrl* handle)
{
	/* The reactions of state YellowOn. */
	if (trafficLightCtrl_check__lr0(handle) == bool_true)
	{ 
		trafficLightCtrl_effect__lr0(handle);
	} 
	if (handle->iface.onOff_raised == bool_true)
	{ 
		/* Default exit sequence for state off */
		/* Default exit sequence for region r1 */
		/* Handle exit of all possible states (of TrafficLightCtrl.main_region.off.r1) at position 0... */
		switch(handle->stateConfVector[ 0 ])
		{
			case TrafficLightCtrl_main_region_off_r1_YellowOn :
			{
				/* Default exit sequence for state YellowOn */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'YellowOn'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_off_r1_YellowOff :
			{
				/* Default exit sequence for state YellowOff */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'YellowOff'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOff_tev0_raised) );		
				break;
			}
			default: break;
		}
		/* 'default' enter sequence for state on */
		/* 'default' enter sequence for region r1 */
		/* Default react sequence for initial entry  */
		/* 'default' enter sequence for state Safe */
		/* Entry action for state 'Safe'. */
		trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised) , 10 * 1000, bool_false);
		handle->ifaceTrafficLight.red = bool_true;
		handle->ifaceTrafficLight.yellow = bool_false;
		handle->ifaceTrafficLight.green = bool_false;
		handle->ifacePedestrian.red = bool_true;
		handle->ifacePedestrian.green = bool_false;
		handle->ifacePedestrian.request = bool_false;
		handle->stateConfVector[0] = TrafficLightCtrl_main_region_on_r1_Safe;
		handle->stateConfVectorPosition = 0;
	}  else
	{
		if (handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised == bool_true)
		{ 
			/* Default exit sequence for state YellowOn */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'YellowOn'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) );		
			/* 'default' enter sequence for state YellowOff */
			/* Entry action for state 'YellowOff'. */
			trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOff_tev0_raised) , 500, bool_false);
			handle->ifaceTrafficLight.yellow = bool_false;
			handle->ifacePedestrian.request = bool_false;
			handle->stateConfVector[0] = TrafficLightCtrl_main_region_off_r1_YellowOff;
			handle->stateConfVectorPosition = 0;
		} 
	}
}

/* The reactions of state YellowOff. */
static void trafficLightCtrl_react_main_region_off_r1_YellowOff(TrafficLightCtrl* handle)
{
	/* The reactions of state YellowOff. */
	if (trafficLightCtrl_check__lr0(handle) == bool_true)
	{ 
		trafficLightCtrl_effect__lr0(handle);
	} 
	if (handle->iface.onOff_raised == bool_true)
	{ 
		/* Default exit sequence for state off */
		/* Default exit sequence for region r1 */
		/* Handle exit of all possible states (of TrafficLightCtrl.main_region.off.r1) at position 0... */
		switch(handle->stateConfVector[ 0 ])
		{
			case TrafficLightCtrl_main_region_off_r1_YellowOn :
			{
				/* Default exit sequence for state YellowOn */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'YellowOn'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) );		
				break;
			}
			case TrafficLightCtrl_main_region_off_r1_YellowOff :
			{
				/* Default exit sequence for state YellowOff */
				handle->stateConfVector[0] = TrafficLightCtrl_last_state;
				handle->stateConfVectorPosition = 0;
				/* Exit action for state 'YellowOff'. */
				trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOff_tev0_raised) );		
				break;
			}
			default: break;
		}
		/* 'default' enter sequence for state on */
		/* 'default' enter sequence for region r1 */
		/* Default react sequence for initial entry  */
		/* 'default' enter sequence for state Safe */
		/* Entry action for state 'Safe'. */
		trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_on_r1_Safe_tev0_raised) , 10 * 1000, bool_false);
		handle->ifaceTrafficLight.red = bool_true;
		handle->ifaceTrafficLight.yellow = bool_false;
		handle->ifaceTrafficLight.green = bool_false;
		handle->ifacePedestrian.red = bool_true;
		handle->ifacePedestrian.green = bool_false;
		handle->ifacePedestrian.request = bool_false;
		handle->stateConfVector[0] = TrafficLightCtrl_main_region_on_r1_Safe;
		handle->stateConfVectorPosition = 0;
	}  else
	{
		if (handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOff_tev0_raised == bool_true)
		{ 
			/* Default exit sequence for state YellowOff */
			handle->stateConfVector[0] = TrafficLightCtrl_last_state;
			handle->stateConfVectorPosition = 0;
			/* Exit action for state 'YellowOff'. */
			trafficLightCtrl_unsetTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOff_tev0_raised) );		
			/* 'default' enter sequence for state YellowOn */
			/* Entry action for state 'YellowOn'. */
			trafficLightCtrl_setTimer(handle, (sc_eventid) &(handle->timeEvents.trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised) , 500, bool_false);
			handle->ifaceTrafficLight.yellow = bool_true;
			handle->ifacePedestrian.request = bool_true;
			handle->stateConfVector[0] = TrafficLightCtrl_main_region_off_r1_YellowOn;
			handle->stateConfVectorPosition = 0;
		} 
	}
}


