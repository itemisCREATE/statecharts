
#ifndef STATEISACTIVE_H_
#define STATEISACTIVE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'StateIsActive'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	StateIsActive_last_state,
	StateIsActive_R1_R1A,
	StateIsActive_R1_R1B,
	StateIsActive_R2_R2A,
	StateIsActive_R2_R2B
} StateIsActiveStates;

/*! Type definition of the data structure for the StateIsActiveIface interface scope. */
typedef struct
{
	sc_boolean Event1_raised;
} StateIsActiveIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define STATEISACTIVE_MAX_ORTHOGONAL_STATES 2

/*! Define indices of states in the StateConfVector */
#define SCVI_STATEISACTIVE_R1_R1A 0
#define SCVI_STATEISACTIVE_R1_R1B 0
#define SCVI_STATEISACTIVE_R2_R2A 1
#define SCVI_STATEISACTIVE_R2_R2B 1

/*! 
 * Type definition of the data structure for the StateIsActive state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	StateIsActiveStates stateConfVector[STATEISACTIVE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	StateIsActiveIface iface;
} StateIsActive;

/*! Initializes the StateIsActive state machine data structures. Must be called before first usage.*/
extern void stateIsActive_init(StateIsActive* handle);

/*! Activates the state machine */
extern void stateIsActive_enter(StateIsActive* handle);

/*! Deactivates the state machine */
extern void stateIsActive_exit(StateIsActive* handle);

/*! Performs a 'run to completion' step. */
extern void stateIsActive_runCycle(StateIsActive* handle);


/*! Raises the in event 'Event1' that is defined in the default interface scope. */ 
extern void stateIsActiveIface_raise_event1(StateIsActive* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean stateIsActive_isActive(const StateIsActive* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean stateIsActive_isFinal(const StateIsActive* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean stateIsActive_isStateActive(const StateIsActive* handle, StateIsActiveStates state);

#ifdef __cplusplus
}
#endif 

#endif /* STATEISACTIVE_H_ */
