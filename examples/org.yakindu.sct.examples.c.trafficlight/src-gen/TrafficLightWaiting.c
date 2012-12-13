#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "TrafficLightWaiting.h"
#include "TrafficLightWaitingRequired.h"

/*! \file Implementation of the state machine 'TrafficLightWaiting'
*/

// prototypes of all internal functions

static void trafficLightWaiting_entryaction(TrafficLightWaiting* handle);
static void trafficLightWaiting_exitaction(TrafficLightWaiting* handle);
static void trafficLightWaiting_react_main_region_on_r1_StreetGreen(TrafficLightWaiting* handle);
static void trafficLightWaiting_react_main_region_on_r1_PedWaiting_r1_waitOn(TrafficLightWaiting* handle);
static void trafficLightWaiting_react_main_region_on_r1_PedWaiting_r1_waitOff(TrafficLightWaiting* handle);
static void trafficLightWaiting_react_main_region_on_r1_StreetAttention(TrafficLightWaiting* handle);
static void trafficLightWaiting_react_main_region_on_r1_StreetRed(TrafficLightWaiting* handle);
static void trafficLightWaiting_react_main_region_on_r1_PedestrianGreen(TrafficLightWaiting* handle);
static void trafficLightWaiting_react_main_region_on_r1_PedestrianRed(TrafficLightWaiting* handle);
static void trafficLightWaiting_react_main_region_on_r1_StreetPrepared(TrafficLightWaiting* handle);
static void trafficLightWaiting_react_main_region_off_r1_YellowOn(TrafficLightWaiting* handle);
static void trafficLightWaiting_react_main_region_off_r1_YellowOff(TrafficLightWaiting* handle);
static void clearInEvents(TrafficLightWaiting* handle);
static void clearOutEvents(TrafficLightWaiting* handle);


void trafficLightWaiting_init(TrafficLightWaiting* handle)
{
	int i;

	for (i = 0; i < TRAFFICLIGHTWAITING_MAX_ORTHOGONAL_STATES; ++i)
		handle->stateConfVector[i] = TrafficLightWaiting_last_state;
	
	
	handle->stateConfVectorPosition = 0;

clearInEvents(handle);
clearOutEvents(handle);

	// TODO: initialize all events ...

	{
		/* Default init sequence for statechart TrafficLightWaiting */
		handle->ifaceTrafficLight.red = bool_false;
		handle->ifaceTrafficLight.yellow = bool_false;
		handle->ifaceTrafficLight.green = bool_false;
		handle->ifacePedestrian.request = bool_false;
		handle->ifacePedestrian.red = bool_false;
		handle->ifacePedestrian.green = bool_false;
	}

}

void trafficLightWaiting_enter(TrafficLightWaiting* handle)
{
	{
		/* Default enter sequence for statechart TrafficLightWaiting */
		trafficLightWaiting_entryaction(handle);
		{
			/* Default enter sequence for region main region */
			{
				/* Default react sequence for initial entry  */
				{
					/* Default enter sequence for state on */
					{
						/* Default enter sequence for region r1 */
						{
							/* Default react sequence for initial entry  */
							{
								/* Default enter sequence for state StreetGreen */
								{
									/* Entry action for state 'StreetGreen'. */
									handle->ifaceTrafficLight.red = bool_false;
									handle->ifaceTrafficLight.yellow = bool_false;
									handle->ifaceTrafficLight.green = bool_true;
									handle->ifacePedestrian.red = bool_true;
									handle->ifacePedestrian.green = bool_false;
									handle->ifacePedestrian.request = bool_false;
								}
								handle->stateConfVector[0] = TrafficLightWaiting_main_region_on_r1_StreetGreen;
								handle->stateConfVectorPosition = 0;
							}
						}
					}
				}
			}
		}
	}
}

void trafficLightWaiting_exit(TrafficLightWaiting* handle)
{
	{
		/* Default exit sequence for statechart TrafficLightWaiting */
		{
			/* Default exit sequence for region main region */
			/* Handle exit of all possible states (of main region) at position 0... */
			switch(handle->stateConfVector[ 0 ]) {
				case TrafficLightWaiting_main_region_on_r1_StreetGreen : {
					{
						/* Default exit sequence for state StreetGreen */
						handle->stateConfVector[0] = TrafficLightWaiting_last_state;
						handle->stateConfVectorPosition = 0;
					}
					break;
				}
				case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn : {
					{
						/* Default exit sequence for state waitOn */
						handle->stateConfVector[0] = TrafficLightWaiting_last_state;
						handle->stateConfVectorPosition = 0;
						{
							/* Exit action for state 'waitOn'. */
							trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) );		
						}
					}
					{
						/* Exit action for state 'PedWaiting'. */
						trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
						handle->ifacePedestrian.request = bool_false;
					}
					break;
				}
				case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff : {
					{
						/* Default exit sequence for state waitOff */
						handle->stateConfVector[0] = TrafficLightWaiting_last_state;
						handle->stateConfVectorPosition = 0;
						{
							/* Exit action for state 'waitOff'. */
							trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) );		
						}
					}
					{
						/* Exit action for state 'PedWaiting'. */
						trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
						handle->ifacePedestrian.request = bool_false;
					}
					break;
				}
				case TrafficLightWaiting_main_region_on_r1_StreetAttention : {
					{
						/* Default exit sequence for state StreetAttention */
						handle->stateConfVector[0] = TrafficLightWaiting_last_state;
						handle->stateConfVectorPosition = 0;
						{
							/* Exit action for state 'StreetAttention'. */
							trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised) );		
						}
					}
					break;
				}
				case TrafficLightWaiting_main_region_on_r1_StreetRed : {
					{
						/* Default exit sequence for state StreetRed */
						handle->stateConfVector[0] = TrafficLightWaiting_last_state;
						handle->stateConfVectorPosition = 0;
						{
							/* Exit action for state 'StreetRed'. */
							trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised) );		
						}
					}
					break;
				}
				case TrafficLightWaiting_main_region_on_r1_PedestrianGreen : {
					{
						/* Default exit sequence for state PedestrianGreen */
						handle->stateConfVector[0] = TrafficLightWaiting_last_state;
						handle->stateConfVectorPosition = 0;
						{
							/* Exit action for state 'PedestrianGreen'. */
							trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised) );		
						}
					}
					break;
				}
				case TrafficLightWaiting_main_region_on_r1_PedestrianRed : {
					{
						/* Default exit sequence for state PedestrianRed */
						handle->stateConfVector[0] = TrafficLightWaiting_last_state;
						handle->stateConfVectorPosition = 0;
						{
							/* Exit action for state 'PedestrianRed'. */
							trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised) );		
						}
					}
					break;
				}
				case TrafficLightWaiting_main_region_on_r1_StreetPrepared : {
					{
						/* Default exit sequence for state StreetPrepared */
						handle->stateConfVector[0] = TrafficLightWaiting_last_state;
						handle->stateConfVectorPosition = 0;
						{
							/* Exit action for state 'StreetPrepared'. */
							trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetPrepared_time_event_0_raised) );		
						}
					}
					break;
				}
				case TrafficLightWaiting_main_region_off_r1_YellowOn : {
					{
						/* Default exit sequence for state YellowOn */
						handle->stateConfVector[0] = TrafficLightWaiting_last_state;
						handle->stateConfVectorPosition = 0;
						{
							/* Exit action for state 'YellowOn'. */
							trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) );		
						}
					}
					break;
				}
				case TrafficLightWaiting_main_region_off_r1_YellowOff : {
					{
						/* Default exit sequence for state YellowOff */
						handle->stateConfVector[0] = TrafficLightWaiting_last_state;
						handle->stateConfVectorPosition = 0;
						{
							/* Exit action for state 'YellowOff'. */
							trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOff_time_event_0_raised) );		
						}
					}
					break;
				}
				default: break;
			}
		}
		trafficLightWaiting_exitaction(handle);
	}
}

static void clearInEvents(TrafficLightWaiting* handle) {
	handle->iface.pedestrianRequest_raised = bool_false;
	handle->iface.onOff_raised = bool_false;
	handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised = bool_false; 
	handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised = bool_false; 
	handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised = bool_false; 
	handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised = bool_false; 
	handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised = bool_false; 
	handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised = bool_false; 
	handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised = bool_false; 
	handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetPrepared_time_event_0_raised = bool_false; 
	handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised = bool_false; 
	handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOff_time_event_0_raised = bool_false; 
}

static void clearOutEvents(TrafficLightWaiting* handle) {
}

void trafficLightWaiting_runCycle(TrafficLightWaiting* handle) {
	
	clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < TRAFFICLIGHTWAITING_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++) {
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition]) {
		case TrafficLightWaiting_main_region_on_r1_StreetGreen : {
			trafficLightWaiting_react_main_region_on_r1_StreetGreen(handle);
			break;
		}
		case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn : {
			trafficLightWaiting_react_main_region_on_r1_PedWaiting_r1_waitOn(handle);
			break;
		}
		case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff : {
			trafficLightWaiting_react_main_region_on_r1_PedWaiting_r1_waitOff(handle);
			break;
		}
		case TrafficLightWaiting_main_region_on_r1_StreetAttention : {
			trafficLightWaiting_react_main_region_on_r1_StreetAttention(handle);
			break;
		}
		case TrafficLightWaiting_main_region_on_r1_StreetRed : {
			trafficLightWaiting_react_main_region_on_r1_StreetRed(handle);
			break;
		}
		case TrafficLightWaiting_main_region_on_r1_PedestrianGreen : {
			trafficLightWaiting_react_main_region_on_r1_PedestrianGreen(handle);
			break;
		}
		case TrafficLightWaiting_main_region_on_r1_PedestrianRed : {
			trafficLightWaiting_react_main_region_on_r1_PedestrianRed(handle);
			break;
		}
		case TrafficLightWaiting_main_region_on_r1_StreetPrepared : {
			trafficLightWaiting_react_main_region_on_r1_StreetPrepared(handle);
			break;
		}
		case TrafficLightWaiting_main_region_off_r1_YellowOn : {
			trafficLightWaiting_react_main_region_off_r1_YellowOn(handle);
			break;
		}
		case TrafficLightWaiting_main_region_off_r1_YellowOff : {
			trafficLightWaiting_react_main_region_off_r1_YellowOff(handle);
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents(handle);
}

void trafficLightWaiting_raiseTimeEvent(TrafficLightWaiting* handle, sc_eventid evid) {
	if ( ((intptr_t)evid) >= ((intptr_t)&(handle->timeEvents))
		&&  ((intptr_t)evid) < ((intptr_t)&(handle->timeEvents)) + sizeof(TrafficLightWaitingTimeEvents)) {
		*(sc_boolean*)evid = bool_true;
	}		
}

sc_boolean trafficLightWaiting_isActive(TrafficLightWaiting* handle, TrafficLightWaitingStates state) {
	switch (state) {
		case TrafficLightWaiting_main_region_on : 
			return (sc_boolean) (handle->stateConfVector[0] >= TrafficLightWaiting_main_region_on
				&& handle->stateConfVector[0] <= TrafficLightWaiting_main_region_on_r1_StreetPrepared);
		case TrafficLightWaiting_main_region_on_r1_StreetGreen : 
			return (sc_boolean) (handle->stateConfVector[0] == TrafficLightWaiting_main_region_on_r1_StreetGreen
			);
		case TrafficLightWaiting_main_region_on_r1_PedWaiting : 
			return (sc_boolean) (handle->stateConfVector[0] >= TrafficLightWaiting_main_region_on_r1_PedWaiting
				&& handle->stateConfVector[0] <= TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff);
		case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn : 
			return (sc_boolean) (handle->stateConfVector[0] == TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn
			);
		case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff : 
			return (sc_boolean) (handle->stateConfVector[0] == TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff
			);
		case TrafficLightWaiting_main_region_on_r1_StreetAttention : 
			return (sc_boolean) (handle->stateConfVector[0] == TrafficLightWaiting_main_region_on_r1_StreetAttention
			);
		case TrafficLightWaiting_main_region_on_r1_StreetRed : 
			return (sc_boolean) (handle->stateConfVector[0] == TrafficLightWaiting_main_region_on_r1_StreetRed
			);
		case TrafficLightWaiting_main_region_on_r1_PedestrianGreen : 
			return (sc_boolean) (handle->stateConfVector[0] == TrafficLightWaiting_main_region_on_r1_PedestrianGreen
			);
		case TrafficLightWaiting_main_region_on_r1_PedestrianRed : 
			return (sc_boolean) (handle->stateConfVector[0] == TrafficLightWaiting_main_region_on_r1_PedestrianRed
			);
		case TrafficLightWaiting_main_region_on_r1_StreetPrepared : 
			return (sc_boolean) (handle->stateConfVector[0] == TrafficLightWaiting_main_region_on_r1_StreetPrepared
			);
		case TrafficLightWaiting_main_region_off : 
			return (sc_boolean) (handle->stateConfVector[0] >= TrafficLightWaiting_main_region_off
				&& handle->stateConfVector[0] <= TrafficLightWaiting_main_region_off_r1_YellowOff);
		case TrafficLightWaiting_main_region_off_r1_YellowOn : 
			return (sc_boolean) (handle->stateConfVector[0] == TrafficLightWaiting_main_region_off_r1_YellowOn
			);
		case TrafficLightWaiting_main_region_off_r1_YellowOff : 
			return (sc_boolean) (handle->stateConfVector[0] == TrafficLightWaiting_main_region_off_r1_YellowOff
			);
		default: return bool_false;
	}
}



sc_boolean trafficLightWaitingIfaceTrafficLight_get_red(TrafficLightWaiting* handle) {
	return handle->ifaceTrafficLight.red;
}
void trafficLightWaitingIfaceTrafficLight_set_red(TrafficLightWaiting* handle, sc_boolean value) {
	handle->ifaceTrafficLight.red = value;
}
sc_boolean trafficLightWaitingIfaceTrafficLight_get_yellow(TrafficLightWaiting* handle) {
	return handle->ifaceTrafficLight.yellow;
}
void trafficLightWaitingIfaceTrafficLight_set_yellow(TrafficLightWaiting* handle, sc_boolean value) {
	handle->ifaceTrafficLight.yellow = value;
}
sc_boolean trafficLightWaitingIfaceTrafficLight_get_green(TrafficLightWaiting* handle) {
	return handle->ifaceTrafficLight.green;
}
void trafficLightWaitingIfaceTrafficLight_set_green(TrafficLightWaiting* handle, sc_boolean value) {
	handle->ifaceTrafficLight.green = value;
}


sc_boolean trafficLightWaitingIfacePedestrian_get_request(TrafficLightWaiting* handle) {
	return handle->ifacePedestrian.request;
}
void trafficLightWaitingIfacePedestrian_set_request(TrafficLightWaiting* handle, sc_boolean value) {
	handle->ifacePedestrian.request = value;
}
sc_boolean trafficLightWaitingIfacePedestrian_get_red(TrafficLightWaiting* handle) {
	return handle->ifacePedestrian.red;
}
void trafficLightWaitingIfacePedestrian_set_red(TrafficLightWaiting* handle, sc_boolean value) {
	handle->ifacePedestrian.red = value;
}
sc_boolean trafficLightWaitingIfacePedestrian_get_green(TrafficLightWaiting* handle) {
	return handle->ifacePedestrian.green;
}
void trafficLightWaitingIfacePedestrian_set_green(TrafficLightWaiting* handle, sc_boolean value) {
	handle->ifacePedestrian.green = value;
}
void trafficLightWaitingIface_raise_pedestrianRequest(TrafficLightWaiting* handle) {
	handle->iface.pedestrianRequest_raised = bool_true;
}
void trafficLightWaitingIface_raise_onOff(TrafficLightWaiting* handle) {
	handle->iface.onOff_raised = bool_true;
}


		
// implementations of all internal functions

/* Entry action for statechart 'TrafficLightWaiting'. */
static void trafficLightWaiting_entryaction(TrafficLightWaiting* handle) {
	{
		/* Entry action for statechart 'TrafficLightWaiting'. */
	}
}

/* Exit action for state 'TrafficLightWaiting'. */
static void trafficLightWaiting_exitaction(TrafficLightWaiting* handle) {
	{
		/* Exit action for state 'TrafficLightWaiting'. */
	}
}

/* The reactions of state StreetGreen. */
static void trafficLightWaiting_react_main_region_on_r1_StreetGreen(TrafficLightWaiting* handle) {
	{
		/* The reactions of state StreetGreen. */
		if (handle->iface.onOff_raised) { 
			{
				/* Default exit sequence for state on */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case TrafficLightWaiting_main_region_on_r1_StreetGreen : {
							{
								/* Default exit sequence for state StreetGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn : {
							{
								/* Default exit sequence for state waitOn */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOn'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff : {
							{
								/* Default exit sequence for state waitOff */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOff'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetAttention : {
							{
								/* Default exit sequence for state StreetAttention */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetAttention'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetRed : {
							{
								/* Default exit sequence for state StreetRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianGreen : {
							{
								/* Default exit sequence for state PedestrianGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianGreen'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianRed : {
							{
								/* Default exit sequence for state PedestrianRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetPrepared : {
							{
								/* Default exit sequence for state StreetPrepared */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetPrepared'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetPrepared_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state off */
				{
					/* Entry action for state 'off'. */
					handle->ifaceTrafficLight.red = bool_false;
					handle->ifaceTrafficLight.green = bool_false;
					handle->ifaceTrafficLight.yellow = bool_false;
					handle->ifacePedestrian.red = bool_false;
					handle->ifacePedestrian.green = bool_false;
				}
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for initial entry  */
						{
							/* Default enter sequence for state YellowOn */
							{
								/* Entry action for state 'YellowOn'. */
								trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) , 500, bool_false);
								handle->ifaceTrafficLight.yellow = bool_true;
								handle->ifacePedestrian.request = bool_true;
							}
							handle->stateConfVector[0] = TrafficLightWaiting_main_region_off_r1_YellowOn;
							handle->stateConfVectorPosition = 0;
						}
					}
				}
			}
		}  else {
			if (handle->iface.pedestrianRequest_raised) { 
				{
					/* Default exit sequence for state StreetGreen */
					handle->stateConfVector[0] = TrafficLightWaiting_last_state;
					handle->stateConfVectorPosition = 0;
				}
				{
					/* Default enter sequence for state PedWaiting */
					{
						/* Entry action for state 'PedWaiting'. */
						trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) , 7 * 1000, bool_false);
					}
					{
						/* Default enter sequence for region r1 */
						{
							/* Default react sequence for initial entry  */
							{
								/* Default enter sequence for state waitOn */
								{
									/* Entry action for state 'waitOn'. */
									trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) , 500, bool_false);
									handle->ifacePedestrian.request = bool_true;
								}
								handle->stateConfVector[0] = TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn;
								handle->stateConfVectorPosition = 0;
							}
						}
					}
				}
			} 
		}
	}
}

/* The reactions of state waitOn. */
static void trafficLightWaiting_react_main_region_on_r1_PedWaiting_r1_waitOn(TrafficLightWaiting* handle) {
	{
		/* The reactions of state waitOn. */
		if (handle->iface.onOff_raised) { 
			{
				/* Default exit sequence for state on */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case TrafficLightWaiting_main_region_on_r1_StreetGreen : {
							{
								/* Default exit sequence for state StreetGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn : {
							{
								/* Default exit sequence for state waitOn */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOn'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff : {
							{
								/* Default exit sequence for state waitOff */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOff'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetAttention : {
							{
								/* Default exit sequence for state StreetAttention */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetAttention'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetRed : {
							{
								/* Default exit sequence for state StreetRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianGreen : {
							{
								/* Default exit sequence for state PedestrianGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianGreen'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianRed : {
							{
								/* Default exit sequence for state PedestrianRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetPrepared : {
							{
								/* Default exit sequence for state StreetPrepared */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetPrepared'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetPrepared_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state off */
				{
					/* Entry action for state 'off'. */
					handle->ifaceTrafficLight.red = bool_false;
					handle->ifaceTrafficLight.green = bool_false;
					handle->ifaceTrafficLight.yellow = bool_false;
					handle->ifacePedestrian.red = bool_false;
					handle->ifacePedestrian.green = bool_false;
				}
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for initial entry  */
						{
							/* Default enter sequence for state YellowOn */
							{
								/* Entry action for state 'YellowOn'. */
								trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) , 500, bool_false);
								handle->ifaceTrafficLight.yellow = bool_true;
								handle->ifacePedestrian.request = bool_true;
							}
							handle->stateConfVector[0] = TrafficLightWaiting_main_region_off_r1_YellowOn;
							handle->stateConfVectorPosition = 0;
						}
					}
				}
			}
		}  else {
			if (handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) { 
				{
					/* Default exit sequence for state PedWaiting */
					{
						/* Default exit sequence for region r1 */
						/* Handle exit of all possible states (of r1) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn : {
								{
									/* Default exit sequence for state waitOn */
									handle->stateConfVector[0] = TrafficLightWaiting_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'waitOn'. */
										trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) );		
									}
								}
								break;
							}
							case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff : {
								{
									/* Default exit sequence for state waitOff */
									handle->stateConfVector[0] = TrafficLightWaiting_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'waitOff'. */
										trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) );		
									}
								}
								break;
							}
							default: break;
						}
					}
					{
						/* Exit action for state 'PedWaiting'. */
						trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
						handle->ifacePedestrian.request = bool_false;
					}
				}
				{
					/* Default enter sequence for state StreetAttention */
					{
						/* Entry action for state 'StreetAttention'. */
						trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised) , 2 * 1000, bool_false);
						handle->ifaceTrafficLight.red = bool_false;
						handle->ifaceTrafficLight.yellow = bool_true;
						handle->ifaceTrafficLight.green = bool_false;
					}
					handle->stateConfVector[0] = TrafficLightWaiting_main_region_on_r1_StreetAttention;
					handle->stateConfVectorPosition = 0;
				}
			}  else {
				if (handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) { 
					{
						/* Default exit sequence for state waitOn */
						handle->stateConfVector[0] = TrafficLightWaiting_last_state;
						handle->stateConfVectorPosition = 0;
						{
							/* Exit action for state 'waitOn'. */
							trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) );		
						}
					}
					{
						/* Default enter sequence for state waitOff */
						{
							/* Entry action for state 'waitOff'. */
							trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) , 500, bool_false);
							handle->ifacePedestrian.request = bool_false;
						}
						handle->stateConfVector[0] = TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff;
						handle->stateConfVectorPosition = 0;
					}
				} 
			}
		}
	}
}

/* The reactions of state waitOff. */
static void trafficLightWaiting_react_main_region_on_r1_PedWaiting_r1_waitOff(TrafficLightWaiting* handle) {
	{
		/* The reactions of state waitOff. */
		if (handle->iface.onOff_raised) { 
			{
				/* Default exit sequence for state on */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case TrafficLightWaiting_main_region_on_r1_StreetGreen : {
							{
								/* Default exit sequence for state StreetGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn : {
							{
								/* Default exit sequence for state waitOn */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOn'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff : {
							{
								/* Default exit sequence for state waitOff */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOff'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetAttention : {
							{
								/* Default exit sequence for state StreetAttention */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetAttention'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetRed : {
							{
								/* Default exit sequence for state StreetRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianGreen : {
							{
								/* Default exit sequence for state PedestrianGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianGreen'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianRed : {
							{
								/* Default exit sequence for state PedestrianRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetPrepared : {
							{
								/* Default exit sequence for state StreetPrepared */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetPrepared'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetPrepared_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state off */
				{
					/* Entry action for state 'off'. */
					handle->ifaceTrafficLight.red = bool_false;
					handle->ifaceTrafficLight.green = bool_false;
					handle->ifaceTrafficLight.yellow = bool_false;
					handle->ifacePedestrian.red = bool_false;
					handle->ifacePedestrian.green = bool_false;
				}
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for initial entry  */
						{
							/* Default enter sequence for state YellowOn */
							{
								/* Entry action for state 'YellowOn'. */
								trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) , 500, bool_false);
								handle->ifaceTrafficLight.yellow = bool_true;
								handle->ifacePedestrian.request = bool_true;
							}
							handle->stateConfVector[0] = TrafficLightWaiting_main_region_off_r1_YellowOn;
							handle->stateConfVectorPosition = 0;
						}
					}
				}
			}
		}  else {
			if (handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) { 
				{
					/* Default exit sequence for state PedWaiting */
					{
						/* Default exit sequence for region r1 */
						/* Handle exit of all possible states (of r1) at position 0... */
						switch(handle->stateConfVector[ 0 ]) {
							case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn : {
								{
									/* Default exit sequence for state waitOn */
									handle->stateConfVector[0] = TrafficLightWaiting_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'waitOn'. */
										trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) );		
									}
								}
								break;
							}
							case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff : {
								{
									/* Default exit sequence for state waitOff */
									handle->stateConfVector[0] = TrafficLightWaiting_last_state;
									handle->stateConfVectorPosition = 0;
									{
										/* Exit action for state 'waitOff'. */
										trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) );		
									}
								}
								break;
							}
							default: break;
						}
					}
					{
						/* Exit action for state 'PedWaiting'. */
						trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
						handle->ifacePedestrian.request = bool_false;
					}
				}
				{
					/* Default enter sequence for state StreetAttention */
					{
						/* Entry action for state 'StreetAttention'. */
						trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised) , 2 * 1000, bool_false);
						handle->ifaceTrafficLight.red = bool_false;
						handle->ifaceTrafficLight.yellow = bool_true;
						handle->ifaceTrafficLight.green = bool_false;
					}
					handle->stateConfVector[0] = TrafficLightWaiting_main_region_on_r1_StreetAttention;
					handle->stateConfVectorPosition = 0;
				}
			}  else {
				if (handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) { 
					{
						/* Default exit sequence for state waitOff */
						handle->stateConfVector[0] = TrafficLightWaiting_last_state;
						handle->stateConfVectorPosition = 0;
						{
							/* Exit action for state 'waitOff'. */
							trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) );		
						}
					}
					{
						/* Default enter sequence for state waitOn */
						{
							/* Entry action for state 'waitOn'. */
							trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) , 500, bool_false);
							handle->ifacePedestrian.request = bool_true;
						}
						handle->stateConfVector[0] = TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn;
						handle->stateConfVectorPosition = 0;
					}
				} 
			}
		}
	}
}

/* The reactions of state StreetAttention. */
static void trafficLightWaiting_react_main_region_on_r1_StreetAttention(TrafficLightWaiting* handle) {
	{
		/* The reactions of state StreetAttention. */
		if (handle->iface.onOff_raised) { 
			{
				/* Default exit sequence for state on */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case TrafficLightWaiting_main_region_on_r1_StreetGreen : {
							{
								/* Default exit sequence for state StreetGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn : {
							{
								/* Default exit sequence for state waitOn */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOn'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff : {
							{
								/* Default exit sequence for state waitOff */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOff'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetAttention : {
							{
								/* Default exit sequence for state StreetAttention */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetAttention'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetRed : {
							{
								/* Default exit sequence for state StreetRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianGreen : {
							{
								/* Default exit sequence for state PedestrianGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianGreen'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianRed : {
							{
								/* Default exit sequence for state PedestrianRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetPrepared : {
							{
								/* Default exit sequence for state StreetPrepared */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetPrepared'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetPrepared_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state off */
				{
					/* Entry action for state 'off'. */
					handle->ifaceTrafficLight.red = bool_false;
					handle->ifaceTrafficLight.green = bool_false;
					handle->ifaceTrafficLight.yellow = bool_false;
					handle->ifacePedestrian.red = bool_false;
					handle->ifacePedestrian.green = bool_false;
				}
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for initial entry  */
						{
							/* Default enter sequence for state YellowOn */
							{
								/* Entry action for state 'YellowOn'. */
								trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) , 500, bool_false);
								handle->ifaceTrafficLight.yellow = bool_true;
								handle->ifacePedestrian.request = bool_true;
							}
							handle->stateConfVector[0] = TrafficLightWaiting_main_region_off_r1_YellowOn;
							handle->stateConfVectorPosition = 0;
						}
					}
				}
			}
		}  else {
			if (handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised) { 
				{
					/* Default exit sequence for state StreetAttention */
					handle->stateConfVector[0] = TrafficLightWaiting_last_state;
					handle->stateConfVectorPosition = 0;
					{
						/* Exit action for state 'StreetAttention'. */
						trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised) );		
					}
				}
				{
					/* Default enter sequence for state StreetRed */
					{
						/* Entry action for state 'StreetRed'. */
						trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised) , 2 * 1000, bool_false);
						handle->ifaceTrafficLight.red = bool_true;
						handle->ifaceTrafficLight.yellow = bool_false;
						handle->ifaceTrafficLight.green = bool_false;
					}
					handle->stateConfVector[0] = TrafficLightWaiting_main_region_on_r1_StreetRed;
					handle->stateConfVectorPosition = 0;
				}
			} 
		}
	}
}

/* The reactions of state StreetRed. */
static void trafficLightWaiting_react_main_region_on_r1_StreetRed(TrafficLightWaiting* handle) {
	{
		/* The reactions of state StreetRed. */
		if (handle->iface.onOff_raised) { 
			{
				/* Default exit sequence for state on */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case TrafficLightWaiting_main_region_on_r1_StreetGreen : {
							{
								/* Default exit sequence for state StreetGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn : {
							{
								/* Default exit sequence for state waitOn */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOn'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff : {
							{
								/* Default exit sequence for state waitOff */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOff'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetAttention : {
							{
								/* Default exit sequence for state StreetAttention */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetAttention'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetRed : {
							{
								/* Default exit sequence for state StreetRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianGreen : {
							{
								/* Default exit sequence for state PedestrianGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianGreen'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianRed : {
							{
								/* Default exit sequence for state PedestrianRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetPrepared : {
							{
								/* Default exit sequence for state StreetPrepared */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetPrepared'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetPrepared_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state off */
				{
					/* Entry action for state 'off'. */
					handle->ifaceTrafficLight.red = bool_false;
					handle->ifaceTrafficLight.green = bool_false;
					handle->ifaceTrafficLight.yellow = bool_false;
					handle->ifacePedestrian.red = bool_false;
					handle->ifacePedestrian.green = bool_false;
				}
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for initial entry  */
						{
							/* Default enter sequence for state YellowOn */
							{
								/* Entry action for state 'YellowOn'. */
								trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) , 500, bool_false);
								handle->ifaceTrafficLight.yellow = bool_true;
								handle->ifacePedestrian.request = bool_true;
							}
							handle->stateConfVector[0] = TrafficLightWaiting_main_region_off_r1_YellowOn;
							handle->stateConfVectorPosition = 0;
						}
					}
				}
			}
		}  else {
			if (handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised) { 
				{
					/* Default exit sequence for state StreetRed */
					handle->stateConfVector[0] = TrafficLightWaiting_last_state;
					handle->stateConfVectorPosition = 0;
					{
						/* Exit action for state 'StreetRed'. */
						trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised) );		
					}
				}
				{
					/* Default enter sequence for state PedestrianGreen */
					{
						/* Entry action for state 'PedestrianGreen'. */
						trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised) , 7 * 1000, bool_false);
						handle->ifacePedestrian.red = bool_false;
						handle->ifacePedestrian.green = bool_true;
					}
					handle->stateConfVector[0] = TrafficLightWaiting_main_region_on_r1_PedestrianGreen;
					handle->stateConfVectorPosition = 0;
				}
			} 
		}
	}
}

/* The reactions of state PedestrianGreen. */
static void trafficLightWaiting_react_main_region_on_r1_PedestrianGreen(TrafficLightWaiting* handle) {
	{
		/* The reactions of state PedestrianGreen. */
		if (handle->iface.onOff_raised) { 
			{
				/* Default exit sequence for state on */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case TrafficLightWaiting_main_region_on_r1_StreetGreen : {
							{
								/* Default exit sequence for state StreetGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn : {
							{
								/* Default exit sequence for state waitOn */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOn'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff : {
							{
								/* Default exit sequence for state waitOff */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOff'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetAttention : {
							{
								/* Default exit sequence for state StreetAttention */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetAttention'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetRed : {
							{
								/* Default exit sequence for state StreetRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianGreen : {
							{
								/* Default exit sequence for state PedestrianGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianGreen'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianRed : {
							{
								/* Default exit sequence for state PedestrianRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetPrepared : {
							{
								/* Default exit sequence for state StreetPrepared */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetPrepared'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetPrepared_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state off */
				{
					/* Entry action for state 'off'. */
					handle->ifaceTrafficLight.red = bool_false;
					handle->ifaceTrafficLight.green = bool_false;
					handle->ifaceTrafficLight.yellow = bool_false;
					handle->ifacePedestrian.red = bool_false;
					handle->ifacePedestrian.green = bool_false;
				}
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for initial entry  */
						{
							/* Default enter sequence for state YellowOn */
							{
								/* Entry action for state 'YellowOn'. */
								trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) , 500, bool_false);
								handle->ifaceTrafficLight.yellow = bool_true;
								handle->ifacePedestrian.request = bool_true;
							}
							handle->stateConfVector[0] = TrafficLightWaiting_main_region_off_r1_YellowOn;
							handle->stateConfVectorPosition = 0;
						}
					}
				}
			}
		}  else {
			if (handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised) { 
				{
					/* Default exit sequence for state PedestrianGreen */
					handle->stateConfVector[0] = TrafficLightWaiting_last_state;
					handle->stateConfVectorPosition = 0;
					{
						/* Exit action for state 'PedestrianGreen'. */
						trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised) );		
					}
				}
				{
					/* Default enter sequence for state PedestrianRed */
					{
						/* Entry action for state 'PedestrianRed'. */
						trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised) , 5 * 1000, bool_false);
						handle->ifacePedestrian.red = bool_true;
						handle->ifacePedestrian.green = bool_false;
					}
					handle->stateConfVector[0] = TrafficLightWaiting_main_region_on_r1_PedestrianRed;
					handle->stateConfVectorPosition = 0;
				}
			} 
		}
	}
}

/* The reactions of state PedestrianRed. */
static void trafficLightWaiting_react_main_region_on_r1_PedestrianRed(TrafficLightWaiting* handle) {
	{
		/* The reactions of state PedestrianRed. */
		if (handle->iface.onOff_raised) { 
			{
				/* Default exit sequence for state on */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case TrafficLightWaiting_main_region_on_r1_StreetGreen : {
							{
								/* Default exit sequence for state StreetGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn : {
							{
								/* Default exit sequence for state waitOn */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOn'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff : {
							{
								/* Default exit sequence for state waitOff */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOff'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetAttention : {
							{
								/* Default exit sequence for state StreetAttention */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetAttention'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetRed : {
							{
								/* Default exit sequence for state StreetRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianGreen : {
							{
								/* Default exit sequence for state PedestrianGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianGreen'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianRed : {
							{
								/* Default exit sequence for state PedestrianRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetPrepared : {
							{
								/* Default exit sequence for state StreetPrepared */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetPrepared'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetPrepared_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state off */
				{
					/* Entry action for state 'off'. */
					handle->ifaceTrafficLight.red = bool_false;
					handle->ifaceTrafficLight.green = bool_false;
					handle->ifaceTrafficLight.yellow = bool_false;
					handle->ifacePedestrian.red = bool_false;
					handle->ifacePedestrian.green = bool_false;
				}
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for initial entry  */
						{
							/* Default enter sequence for state YellowOn */
							{
								/* Entry action for state 'YellowOn'. */
								trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) , 500, bool_false);
								handle->ifaceTrafficLight.yellow = bool_true;
								handle->ifacePedestrian.request = bool_true;
							}
							handle->stateConfVector[0] = TrafficLightWaiting_main_region_off_r1_YellowOn;
							handle->stateConfVectorPosition = 0;
						}
					}
				}
			}
		}  else {
			if (handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised) { 
				{
					/* Default exit sequence for state PedestrianRed */
					handle->stateConfVector[0] = TrafficLightWaiting_last_state;
					handle->stateConfVectorPosition = 0;
					{
						/* Exit action for state 'PedestrianRed'. */
						trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised) );		
					}
				}
				{
					/* Default enter sequence for state StreetPrepared */
					{
						/* Entry action for state 'StreetPrepared'. */
						trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetPrepared_time_event_0_raised) , 2 * 1000, bool_false);
						handle->ifaceTrafficLight.red = bool_true;
						handle->ifaceTrafficLight.yellow = bool_true;
						handle->ifaceTrafficLight.green = bool_false;
					}
					handle->stateConfVector[0] = TrafficLightWaiting_main_region_on_r1_StreetPrepared;
					handle->stateConfVectorPosition = 0;
				}
			} 
		}
	}
}

/* The reactions of state StreetPrepared. */
static void trafficLightWaiting_react_main_region_on_r1_StreetPrepared(TrafficLightWaiting* handle) {
	{
		/* The reactions of state StreetPrepared. */
		if (handle->iface.onOff_raised) { 
			{
				/* Default exit sequence for state on */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case TrafficLightWaiting_main_region_on_r1_StreetGreen : {
							{
								/* Default exit sequence for state StreetGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn : {
							{
								/* Default exit sequence for state waitOn */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOn'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff : {
							{
								/* Default exit sequence for state waitOff */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'waitOff'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised) );		
								}
							}
							{
								/* Exit action for state 'PedWaiting'. */
								trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised) );		
								handle->ifacePedestrian.request = bool_false;
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetAttention : {
							{
								/* Default exit sequence for state StreetAttention */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetAttention'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetRed : {
							{
								/* Default exit sequence for state StreetRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianGreen : {
							{
								/* Default exit sequence for state PedestrianGreen */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianGreen'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_PedestrianRed : {
							{
								/* Default exit sequence for state PedestrianRed */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'PedestrianRed'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_on_r1_StreetPrepared : {
							{
								/* Default exit sequence for state StreetPrepared */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'StreetPrepared'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetPrepared_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state off */
				{
					/* Entry action for state 'off'. */
					handle->ifaceTrafficLight.red = bool_false;
					handle->ifaceTrafficLight.green = bool_false;
					handle->ifaceTrafficLight.yellow = bool_false;
					handle->ifacePedestrian.red = bool_false;
					handle->ifacePedestrian.green = bool_false;
				}
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for initial entry  */
						{
							/* Default enter sequence for state YellowOn */
							{
								/* Entry action for state 'YellowOn'. */
								trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) , 500, bool_false);
								handle->ifaceTrafficLight.yellow = bool_true;
								handle->ifacePedestrian.request = bool_true;
							}
							handle->stateConfVector[0] = TrafficLightWaiting_main_region_off_r1_YellowOn;
							handle->stateConfVectorPosition = 0;
						}
					}
				}
			}
		}  else {
			if (handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetPrepared_time_event_0_raised) { 
				{
					/* Default exit sequence for state StreetPrepared */
					handle->stateConfVector[0] = TrafficLightWaiting_last_state;
					handle->stateConfVectorPosition = 0;
					{
						/* Exit action for state 'StreetPrepared'. */
						trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_on_r1_StreetPrepared_time_event_0_raised) );		
					}
				}
				{
					/* Default enter sequence for state StreetGreen */
					{
						/* Entry action for state 'StreetGreen'. */
						handle->ifaceTrafficLight.red = bool_false;
						handle->ifaceTrafficLight.yellow = bool_false;
						handle->ifaceTrafficLight.green = bool_true;
						handle->ifacePedestrian.red = bool_true;
						handle->ifacePedestrian.green = bool_false;
						handle->ifacePedestrian.request = bool_false;
					}
					handle->stateConfVector[0] = TrafficLightWaiting_main_region_on_r1_StreetGreen;
					handle->stateConfVectorPosition = 0;
				}
			} 
		}
	}
}

/* The reactions of state YellowOn. */
static void trafficLightWaiting_react_main_region_off_r1_YellowOn(TrafficLightWaiting* handle) {
	{
		/* The reactions of state YellowOn. */
		if (handle->iface.onOff_raised) { 
			{
				/* Default exit sequence for state off */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case TrafficLightWaiting_main_region_off_r1_YellowOn : {
							{
								/* Default exit sequence for state YellowOn */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'YellowOn'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_off_r1_YellowOff : {
							{
								/* Default exit sequence for state YellowOff */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'YellowOff'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOff_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state on */
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for initial entry  */
						{
							/* Default enter sequence for state StreetGreen */
							{
								/* Entry action for state 'StreetGreen'. */
								handle->ifaceTrafficLight.red = bool_false;
								handle->ifaceTrafficLight.yellow = bool_false;
								handle->ifaceTrafficLight.green = bool_true;
								handle->ifacePedestrian.red = bool_true;
								handle->ifacePedestrian.green = bool_false;
								handle->ifacePedestrian.request = bool_false;
							}
							handle->stateConfVector[0] = TrafficLightWaiting_main_region_on_r1_StreetGreen;
							handle->stateConfVectorPosition = 0;
						}
					}
				}
			}
		}  else {
			if (handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) { 
				{
					/* Default exit sequence for state YellowOn */
					handle->stateConfVector[0] = TrafficLightWaiting_last_state;
					handle->stateConfVectorPosition = 0;
					{
						/* Exit action for state 'YellowOn'. */
						trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) );		
					}
				}
				{
					/* Default enter sequence for state YellowOff */
					{
						/* Entry action for state 'YellowOff'. */
						trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOff_time_event_0_raised) , 500, bool_false);
						handle->ifaceTrafficLight.yellow = bool_false;
						handle->ifacePedestrian.request = bool_false;
					}
					handle->stateConfVector[0] = TrafficLightWaiting_main_region_off_r1_YellowOff;
					handle->stateConfVectorPosition = 0;
				}
			} 
		}
	}
}

/* The reactions of state YellowOff. */
static void trafficLightWaiting_react_main_region_off_r1_YellowOff(TrafficLightWaiting* handle) {
	{
		/* The reactions of state YellowOff. */
		if (handle->iface.onOff_raised) { 
			{
				/* Default exit sequence for state off */
				{
					/* Default exit sequence for region r1 */
					/* Handle exit of all possible states (of r1) at position 0... */
					switch(handle->stateConfVector[ 0 ]) {
						case TrafficLightWaiting_main_region_off_r1_YellowOn : {
							{
								/* Default exit sequence for state YellowOn */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'YellowOn'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) );		
								}
							}
							break;
						}
						case TrafficLightWaiting_main_region_off_r1_YellowOff : {
							{
								/* Default exit sequence for state YellowOff */
								handle->stateConfVector[0] = TrafficLightWaiting_last_state;
								handle->stateConfVectorPosition = 0;
								{
									/* Exit action for state 'YellowOff'. */
									trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOff_time_event_0_raised) );		
								}
							}
							break;
						}
						default: break;
					}
				}
			}
			{
				/* Default enter sequence for state on */
				{
					/* Default enter sequence for region r1 */
					{
						/* Default react sequence for initial entry  */
						{
							/* Default enter sequence for state StreetGreen */
							{
								/* Entry action for state 'StreetGreen'. */
								handle->ifaceTrafficLight.red = bool_false;
								handle->ifaceTrafficLight.yellow = bool_false;
								handle->ifaceTrafficLight.green = bool_true;
								handle->ifacePedestrian.red = bool_true;
								handle->ifacePedestrian.green = bool_false;
								handle->ifacePedestrian.request = bool_false;
							}
							handle->stateConfVector[0] = TrafficLightWaiting_main_region_on_r1_StreetGreen;
							handle->stateConfVectorPosition = 0;
						}
					}
				}
			}
		}  else {
			if (handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOff_time_event_0_raised) { 
				{
					/* Default exit sequence for state YellowOff */
					handle->stateConfVector[0] = TrafficLightWaiting_last_state;
					handle->stateConfVectorPosition = 0;
					{
						/* Exit action for state 'YellowOff'. */
						trafficLightWaiting_unsetTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOff_time_event_0_raised) );		
					}
				}
				{
					/* Default enter sequence for state YellowOn */
					{
						/* Entry action for state 'YellowOn'. */
						trafficLightWaiting_setTimer( (sc_eventid) &(handle->timeEvents.TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised) , 500, bool_false);
						handle->ifaceTrafficLight.yellow = bool_true;
						handle->ifacePedestrian.request = bool_true;
					}
					handle->stateConfVector[0] = TrafficLightWaiting_main_region_off_r1_YellowOn;
					handle->stateConfVectorPosition = 0;
				}
			} 
		}
	}
}


