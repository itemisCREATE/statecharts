#ifndef TRAFFICLIGHTWAITING_H_
#define TRAFFICLIGHTWAITING_H_

#include "sc_types.h"

#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'TrafficLightWaiting'.
*/

//! enumeration of all states 
typedef enum {
	TrafficLightWaiting_main_region_on ,
	TrafficLightWaiting_main_region_on_r1_StreetGreen ,
	TrafficLightWaiting_main_region_on_r1_PedWaiting ,
	TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn ,
	TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff ,
	TrafficLightWaiting_main_region_on_r1_StreetAttention ,
	TrafficLightWaiting_main_region_on_r1_StreetRed ,
	TrafficLightWaiting_main_region_on_r1_PedestrianGreen ,
	TrafficLightWaiting_main_region_on_r1_PedestrianRed ,
	TrafficLightWaiting_main_region_on_r1_StreetPrepare ,
	TrafficLightWaiting_main_region_off ,
	TrafficLightWaiting_main_region_off_r1_YellowOn ,
	TrafficLightWaiting_main_region_off_r1_YellowOff ,
	TrafficLightWaiting_last_state
} TrafficLightWaitingStates;

//! Type definition of the data structure for the TrafficLightWaitingIfaceTrafficLight interface scope.
typedef struct {
	sc_boolean  red;
	sc_boolean  yellow;
	sc_boolean  green;
} TrafficLightWaitingIfaceTrafficLight;

//! Type definition of the data structure for the TrafficLightWaitingIfacePedestrian interface scope.
typedef struct {
	sc_boolean  request;
	sc_boolean  red;
	sc_boolean  green;
} TrafficLightWaitingIfacePedestrian;

//! Type definition of the data structure for the TrafficLightWaitingIface interface scope.
typedef struct {
	sc_boolean pedestrianRequest_raised;
	sc_boolean onOff_raised;
} TrafficLightWaitingIface;

//! Type definition of the data structure for the TrafficLightWaitingTimeEvents interface scope.
typedef struct {
	sc_boolean TrafficLightWaiting_main_region_on_r1_PedWaiting_time_event_0_raised;
	sc_boolean TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOn_time_event_0_raised;
	sc_boolean TrafficLightWaiting_main_region_on_r1_PedWaiting_r1_waitOff_time_event_0_raised;
	sc_boolean TrafficLightWaiting_main_region_on_r1_StreetAttention_time_event_0_raised;
	sc_boolean TrafficLightWaiting_main_region_on_r1_StreetRed_time_event_0_raised;
	sc_boolean TrafficLightWaiting_main_region_on_r1_PedestrianGreen_time_event_0_raised;
	sc_boolean TrafficLightWaiting_main_region_on_r1_PedestrianRed_time_event_0_raised;
	sc_boolean TrafficLightWaiting_main_region_on_r1_StreetPrepare_time_event_0_raised;
	sc_boolean TrafficLightWaiting_main_region_off_r1_YellowOn_time_event_0_raised;
	sc_boolean TrafficLightWaiting_main_region_off_r1_YellowOff_time_event_0_raised;
} TrafficLightWaitingTimeEvents;


//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
#define TRAFFICLIGHTWAITING_MAX_ORTHOGONAL_STATES 1

/*! Type definition of the data structure for the TrafficLightWaiting state machine.
This data structure has to be allocated by the client code. */
typedef struct {
	TrafficLightWaitingStates stateConfVector[TRAFFICLIGHTWAITING_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	TrafficLightWaitingIfaceTrafficLight ifaceTrafficLight;
	TrafficLightWaitingIfacePedestrian ifacePedestrian;
	TrafficLightWaitingIface iface;
	TrafficLightWaitingTimeEvents timeEvents;
} TrafficLightWaiting;

/*! Initializes the TrafficLightWaiting state machine data structures. Must be called before first usage.*/
extern void trafficLightWaiting_init(TrafficLightWaiting* handle);

/*! Activates the state machine */
extern void trafficLightWaiting_enter(TrafficLightWaiting* handle);

/*! Deactivates the state machine */
extern void trafficLightWaiting_exit(TrafficLightWaiting* handle);

/*! Performs a 'run to completion' step. */
extern void trafficLightWaiting_runCycle(TrafficLightWaiting* handle);

/*! Raises a time event. */
extern void trafficLightWaiting_raiseTimeEvent(TrafficLightWaiting* handle, sc_eventid evid);

/*! Gets the value of the variable 'red' that is defined in the interface scope 'TrafficLight'. */ 
extern sc_boolean trafficLightWaitingIfaceTrafficLight_get_red(TrafficLightWaiting* handle);
/*! Sets the value of the variable 'red' that is defined in the interface scope 'TrafficLight'. */ 
extern void trafficLightWaitingIfaceTrafficLight_set_red(TrafficLightWaiting* handle, sc_boolean value);
/*! Gets the value of the variable 'yellow' that is defined in the interface scope 'TrafficLight'. */ 
extern sc_boolean trafficLightWaitingIfaceTrafficLight_get_yellow(TrafficLightWaiting* handle);
/*! Sets the value of the variable 'yellow' that is defined in the interface scope 'TrafficLight'. */ 
extern void trafficLightWaitingIfaceTrafficLight_set_yellow(TrafficLightWaiting* handle, sc_boolean value);
/*! Gets the value of the variable 'green' that is defined in the interface scope 'TrafficLight'. */ 
extern sc_boolean trafficLightWaitingIfaceTrafficLight_get_green(TrafficLightWaiting* handle);
/*! Sets the value of the variable 'green' that is defined in the interface scope 'TrafficLight'. */ 
extern void trafficLightWaitingIfaceTrafficLight_set_green(TrafficLightWaiting* handle, sc_boolean value);

/*! Gets the value of the variable 'request' that is defined in the interface scope 'Pedestrian'. */ 
extern sc_boolean trafficLightWaitingIfacePedestrian_get_request(TrafficLightWaiting* handle);
/*! Sets the value of the variable 'request' that is defined in the interface scope 'Pedestrian'. */ 
extern void trafficLightWaitingIfacePedestrian_set_request(TrafficLightWaiting* handle, sc_boolean value);
/*! Gets the value of the variable 'red' that is defined in the interface scope 'Pedestrian'. */ 
extern sc_boolean trafficLightWaitingIfacePedestrian_get_red(TrafficLightWaiting* handle);
/*! Sets the value of the variable 'red' that is defined in the interface scope 'Pedestrian'. */ 
extern void trafficLightWaitingIfacePedestrian_set_red(TrafficLightWaiting* handle, sc_boolean value);
/*! Gets the value of the variable 'green' that is defined in the interface scope 'Pedestrian'. */ 
extern sc_boolean trafficLightWaitingIfacePedestrian_get_green(TrafficLightWaiting* handle);
/*! Sets the value of the variable 'green' that is defined in the interface scope 'Pedestrian'. */ 
extern void trafficLightWaitingIfacePedestrian_set_green(TrafficLightWaiting* handle, sc_boolean value);

/*! Raises the in event 'pedestrianRequest' that is defined in the default interface scope. */ 
extern void trafficLightWaitingIface_raise_pedestrianRequest(TrafficLightWaiting* handle);

/*! Raises the in event 'onOff' that is defined in the default interface scope. */ 
extern void trafficLightWaitingIface_raise_onOff(TrafficLightWaiting* handle);



/*! Checks if the specified state is active. */
extern sc_boolean trafficLightWaiting_isActive(TrafficLightWaiting* handle, TrafficLightWaitingStates state);

#ifdef __cplusplus
}
#endif 

#endif /* TRAFFICLIGHTWAITING_H_ */
