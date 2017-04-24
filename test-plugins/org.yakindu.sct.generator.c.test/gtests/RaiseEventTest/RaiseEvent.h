
#ifndef RAISEEVENT_H_
#define RAISEEVENT_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'RaiseEvent'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	RaiseEvent_main_region_StateA,
	RaiseEvent_main_region_StateB,
	RaiseEvent_second_region_SateA,
	RaiseEvent_second_region_StateB,
	RaiseEvent_last_state
} RaiseEventStates;

/*! Type definition of the data structure for the RaiseEventIface interface scope. */
typedef struct
{
	sc_boolean e1_raised;
	sc_boolean e2_raised;
} RaiseEventIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define RAISEEVENT_MAX_ORTHOGONAL_STATES 2

/*! 
 * Type definition of the data structure for the RaiseEvent state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	RaiseEventStates stateConfVector[RAISEEVENT_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	RaiseEventIface iface;
} RaiseEvent;

/*! Initializes the RaiseEvent state machine data structures. Must be called before first usage.*/
extern void raiseEvent_init(RaiseEvent* handle);

/*! Activates the state machine */
extern void raiseEvent_enter(RaiseEvent* handle);

/*! Deactivates the state machine */
extern void raiseEvent_exit(RaiseEvent* handle);

/*! Performs a 'run to completion' step. */
extern void raiseEvent_runCycle(RaiseEvent* handle);


/*! Checks if the out event 'e1' that is defined in the default interface scope has been raised. */ 
extern sc_boolean raiseEventIface_israised_e1(const RaiseEvent* handle);

/*! Raises the in event 'e2' that is defined in the default interface scope. */ 
extern void raiseEventIface_raise_e2(RaiseEvent* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean raiseEvent_isActive(const RaiseEvent* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean raiseEvent_isFinal(const RaiseEvent* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean raiseEvent_isStateActive(const RaiseEvent* handle, RaiseEventStates state);

#ifdef __cplusplus
}
#endif 

#endif /* RAISEEVENT_H_ */
