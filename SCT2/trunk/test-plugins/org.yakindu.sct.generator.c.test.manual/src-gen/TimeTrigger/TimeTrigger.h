#ifndef TIMETRIGGER_H_
#define TIMETRIGGER_H_

#include "sc_types.h"

#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'TimeTrigger'.
*/

//! enumeration of all states 
typedef enum {
	TimeTrigger_mainRegion_StateA ,
	TimeTrigger_mainRegion_StateB ,
	TimeTrigger_last_state
} TimeTriggerStates;

//! Type definition of the data structure for the TimeTriggerIface interface scope.
typedef struct {
	sc_integer  value;
} TimeTriggerIface;

//! Type definition of the data structure for the TimeTriggerTimeEvents interface scope.
typedef struct {
	sc_boolean StateA_time_event_0_raised;
	sc_boolean StateB_time_event_0_raised;
} TimeTriggerTimeEvents;


//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
#define TIMETRIGGER_MAX_ORTHOGONAL_STATES 1

/*! Type definition of the data structure for the TimeTrigger state machine.
This data structure has to be allocated by the client code. */
typedef struct {
	TimeTriggerStates stateConfVector[TIMETRIGGER_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	TimeTriggerIface iface;
	TimeTriggerTimeEvents timeEvents;
} TimeTrigger;

/*! Initializes the TimeTrigger state machine data structures. Must be called before first usage.*/
extern void timeTrigger_init(TimeTrigger* handle);

/*! Activates the state machine */
extern void timeTrigger_enter(TimeTrigger* handle);

/*! Deactivates the state machine */
extern void timeTrigger_exit(TimeTrigger* handle);

/*! Performs a 'run to completion' step. */
extern void timeTrigger_runCycle(TimeTrigger* handle);

/*! Raises a time event. */
extern void timeTrigger_raiseTimeEvent(TimeTrigger* handle, sc_eventid evid);

/*! Gets the value of the variable 'value' that is defined in the default interface scope. */ 
extern sc_integer timeTriggerIface_get_value(TimeTrigger* handle);
/*! Sets the value of the variable 'value' that is defined in the default interface scope. */ 
extern void timeTriggerIface_set_value(TimeTrigger* handle, sc_integer value);


/*! Checks if the specified state is active. */
extern sc_boolean timeTrigger_isActive(TimeTrigger* handle, TimeTriggerStates state);

#ifdef __cplusplus
}
#endif 

#endif /* TIMETRIGGER_H_ */
