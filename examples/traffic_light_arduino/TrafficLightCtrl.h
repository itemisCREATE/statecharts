
#ifndef TRAFFICLIGHTCTRL_H_
#define TRAFFICLIGHTCTRL_H_

#include "sc/sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'TrafficLightCtrl'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	TrafficLightCtrl_main_region_on,
	TrafficLightCtrl_main_region_on_r1_StreetGreen,
	TrafficLightCtrl_main_region_on_r1_PedWaiting,
	TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn,
	TrafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff,
	TrafficLightCtrl_main_region_on_r1_StreetAttention,
	TrafficLightCtrl_main_region_on_r1_StreetRed,
	TrafficLightCtrl_main_region_on_r1_PedestrianGreen,
	TrafficLightCtrl_main_region_on_r1_PedestrianRed,
	TrafficLightCtrl_main_region_on_r1_StreetPrepare,
	TrafficLightCtrl_main_region_on_r1_Safe,
	TrafficLightCtrl_main_region_off,
	TrafficLightCtrl_main_region_off_r1_YellowOn,
	TrafficLightCtrl_main_region_off_r1_YellowOff,
	TrafficLightCtrl_last_state
} TrafficLightCtrlStates;

/*! Type definition of the data structure for the TrafficLightCtrlIfaceTrafficLight interface scope. */
typedef struct
{
	sc_boolean red;
	sc_boolean yellow;
	sc_boolean green;
} TrafficLightCtrlIfaceTrafficLight;

/*! Type definition of the data structure for the TrafficLightCtrlIfacePedestrian interface scope. */
typedef struct
{
	sc_boolean request;
	sc_boolean red;
	sc_boolean green;
} TrafficLightCtrlIfacePedestrian;

/*! Type definition of the data structure for the TrafficLightCtrlIface interface scope. */
typedef struct
{
	sc_boolean pedestrianRequest_raised;
	sc_boolean onOff_raised;
} TrafficLightCtrlIface;

/*! Type definition of the data structure for the TrafficLightCtrlTimeEvents interface scope. */
typedef struct
{
	sc_boolean trafficLightCtrl_main_region_on_r1_PedWaiting_tev0_raised;
	sc_boolean trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOn_tev0_raised;
	sc_boolean trafficLightCtrl_main_region_on_r1_PedWaiting_r1_waitOff_tev0_raised;
	sc_boolean trafficLightCtrl_main_region_on_r1_StreetAttention_tev0_raised;
	sc_boolean trafficLightCtrl_main_region_on_r1_StreetRed_tev0_raised;
	sc_boolean trafficLightCtrl_main_region_on_r1_PedestrianGreen_tev0_raised;
	sc_boolean trafficLightCtrl_main_region_on_r1_PedestrianRed_tev0_raised;
	sc_boolean trafficLightCtrl_main_region_on_r1_StreetPrepare_tev0_raised;
	sc_boolean trafficLightCtrl_main_region_on_r1_Safe_tev0_raised;
	sc_boolean trafficLightCtrl_main_region_off_r1_YellowOn_tev0_raised;
	sc_boolean trafficLightCtrl_main_region_off_r1_YellowOff_tev0_raised;
	sc_boolean trafficLightCtrl_tev0_raised;
} TrafficLightCtrlTimeEvents;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define TRAFFICLIGHTCTRL_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the TrafficLightCtrl state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	TrafficLightCtrlStates stateConfVector[TRAFFICLIGHTCTRL_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	TrafficLightCtrlIfaceTrafficLight ifaceTrafficLight;
	TrafficLightCtrlIfacePedestrian ifacePedestrian;
	TrafficLightCtrlIface iface;
	TrafficLightCtrlTimeEvents timeEvents;
} TrafficLightCtrl;

/*! Initializes the TrafficLightCtrl state machine data structures. Must be called before first usage.*/
extern void trafficLightCtrl_init(TrafficLightCtrl* handle);

/*! Activates the state machine */
extern void trafficLightCtrl_enter(TrafficLightCtrl* handle);

/*! Deactivates the state machine */
extern void trafficLightCtrl_exit(TrafficLightCtrl* handle);

/*! Performs a 'run to completion' step. */
extern void trafficLightCtrl_runCycle(TrafficLightCtrl* handle);

/*! Raises a time event. */
extern void trafficLightCtrl_raiseTimeEvent(const TrafficLightCtrl* handle, sc_eventid evid);

/*! Gets the value of the variable 'red' that is defined in the interface scope 'TrafficLight'. */ 
extern sc_boolean trafficLightCtrlIfaceTrafficLight_get_red(const TrafficLightCtrl* handle);
/*! Sets the value of the variable 'red' that is defined in the interface scope 'TrafficLight'. */ 
extern void trafficLightCtrlIfaceTrafficLight_set_red(TrafficLightCtrl* handle, sc_boolean value);
/*! Gets the value of the variable 'yellow' that is defined in the interface scope 'TrafficLight'. */ 
extern sc_boolean trafficLightCtrlIfaceTrafficLight_get_yellow(const TrafficLightCtrl* handle);
/*! Sets the value of the variable 'yellow' that is defined in the interface scope 'TrafficLight'. */ 
extern void trafficLightCtrlIfaceTrafficLight_set_yellow(TrafficLightCtrl* handle, sc_boolean value);
/*! Gets the value of the variable 'green' that is defined in the interface scope 'TrafficLight'. */ 
extern sc_boolean trafficLightCtrlIfaceTrafficLight_get_green(const TrafficLightCtrl* handle);
/*! Sets the value of the variable 'green' that is defined in the interface scope 'TrafficLight'. */ 
extern void trafficLightCtrlIfaceTrafficLight_set_green(TrafficLightCtrl* handle, sc_boolean value);
/*! Gets the value of the variable 'request' that is defined in the interface scope 'Pedestrian'. */ 
extern sc_boolean trafficLightCtrlIfacePedestrian_get_request(const TrafficLightCtrl* handle);
/*! Sets the value of the variable 'request' that is defined in the interface scope 'Pedestrian'. */ 
extern void trafficLightCtrlIfacePedestrian_set_request(TrafficLightCtrl* handle, sc_boolean value);
/*! Gets the value of the variable 'red' that is defined in the interface scope 'Pedestrian'. */ 
extern sc_boolean trafficLightCtrlIfacePedestrian_get_red(const TrafficLightCtrl* handle);
/*! Sets the value of the variable 'red' that is defined in the interface scope 'Pedestrian'. */ 
extern void trafficLightCtrlIfacePedestrian_set_red(TrafficLightCtrl* handle, sc_boolean value);
/*! Gets the value of the variable 'green' that is defined in the interface scope 'Pedestrian'. */ 
extern sc_boolean trafficLightCtrlIfacePedestrian_get_green(const TrafficLightCtrl* handle);
/*! Sets the value of the variable 'green' that is defined in the interface scope 'Pedestrian'. */ 
extern void trafficLightCtrlIfacePedestrian_set_green(TrafficLightCtrl* handle, sc_boolean value);
/*! Raises the in event 'pedestrianRequest' that is defined in the default interface scope. */ 
extern void trafficLightCtrlIface_raise_pedestrianRequest(TrafficLightCtrl* handle);

/*! Raises the in event 'onOff' that is defined in the default interface scope. */ 
extern void trafficLightCtrlIface_raise_onOff(TrafficLightCtrl* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean trafficLightCtrl_isActive(const TrafficLightCtrl* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean trafficLightCtrl_isFinal(const TrafficLightCtrl* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean trafficLightCtrl_isStateActive(const TrafficLightCtrl* handle, TrafficLightCtrlStates state);

#ifdef __cplusplus
}
#endif 

#endif /* TRAFFICLIGHTCTRL_H_ */
