
#ifndef SIMPLEEVENT_H_
#define SIMPLEEVENT_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'SimpleEvent'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	SimpleEvent_last_state,
	SimpleEvent_main_region_A,
	SimpleEvent_main_region_B,
	SimpleEvent_main_region__final_
} SimpleEventStates;

/*! Type definition of the data structure for the SimpleEventIface interface scope. */
typedef struct
{
	sc_boolean Event1_raised;
} SimpleEventIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define SIMPLEEVENT_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_SIMPLEEVENT_MAIN_REGION_A 0
#define SCVI_SIMPLEEVENT_MAIN_REGION_B 0
#define SCVI_SIMPLEEVENT_MAIN_REGION__FINAL_ 0

/*! 
 * Type definition of the data structure for the SimpleEvent state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	SimpleEventStates stateConfVector[SIMPLEEVENT_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	SimpleEventIface iface;
} SimpleEvent;

/*! Initializes the SimpleEvent state machine data structures. Must be called before first usage.*/
extern void simpleEvent_init(SimpleEvent* handle);

/*! Activates the state machine */
extern void simpleEvent_enter(SimpleEvent* handle);

/*! Deactivates the state machine */
extern void simpleEvent_exit(SimpleEvent* handle);

/*! Performs a 'run to completion' step. */
extern void simpleEvent_runCycle(SimpleEvent* handle);


/*! Raises the in event 'Event1' that is defined in the default interface scope. */ 
extern void simpleEventIface_raise_event1(SimpleEvent* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean simpleEvent_isActive(const SimpleEvent* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean simpleEvent_isFinal(const SimpleEvent* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean simpleEvent_isStateActive(const SimpleEvent* handle, SimpleEventStates state);

#ifdef __cplusplus
}
#endif 

#endif /* SIMPLEEVENT_H_ */
