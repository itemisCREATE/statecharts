
#ifndef EMPTYTRANSITION_H_
#define EMPTYTRANSITION_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'EmptyTransition'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	EmptyTransition_main_region_A,
	EmptyTransition_main_region_B,
	EmptyTransition_last_state
} EmptyTransitionStates;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define EMPTYTRANSITION_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the EmptyTransition state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	EmptyTransitionStates stateConfVector[EMPTYTRANSITION_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
} EmptyTransition;

/*! Initializes the EmptyTransition state machine data structures. Must be called before first usage.*/
extern void emptyTransition_init(EmptyTransition* handle);

/*! Activates the state machine */
extern void emptyTransition_enter(EmptyTransition* handle);

/*! Deactivates the state machine */
extern void emptyTransition_exit(EmptyTransition* handle);

/*! Performs a 'run to completion' step. */
extern void emptyTransition_runCycle(EmptyTransition* handle);



/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean emptyTransition_isActive(const EmptyTransition* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean emptyTransition_isFinal(const EmptyTransition* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean emptyTransition_isStateActive(const EmptyTransition* handle, EmptyTransitionStates state);

#ifdef __cplusplus
}
#endif 

#endif /* EMPTYTRANSITION_H_ */
