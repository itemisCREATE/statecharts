
#ifndef STATECHARTACTIVE_H_
#define STATECHARTACTIVE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'StatechartActive'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	StatechartActive_last_state,
	StatechartActive_r_A
} StatechartActiveStates;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define STATECHARTACTIVE_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_STATECHARTACTIVE_R_A 0

/*! 
 * Type definition of the data structure for the StatechartActive state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	StatechartActiveStates stateConfVector[STATECHARTACTIVE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
} StatechartActive;

/*! Initializes the StatechartActive state machine data structures. Must be called before first usage.*/
extern void statechartActive_init(StatechartActive* handle);

/*! Activates the state machine */
extern void statechartActive_enter(StatechartActive* handle);

/*! Deactivates the state machine */
extern void statechartActive_exit(StatechartActive* handle);

/*! Performs a 'run to completion' step. */
extern void statechartActive_runCycle(StatechartActive* handle);



/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean statechartActive_isActive(const StatechartActive* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean statechartActive_isFinal(const StatechartActive* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean statechartActive_isStateActive(const StatechartActive* handle, StatechartActiveStates state);

#ifdef __cplusplus
}
#endif 

#endif /* STATECHARTACTIVE_H_ */
