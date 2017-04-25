
#ifndef TRANSITIONWITHOUTCONDITION_H_
#define TRANSITIONWITHOUTCONDITION_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'TransitionWithoutCondition'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	TransitionWithoutCondition_main_region_A,
	TransitionWithoutCondition_main_region_B,
	TransitionWithoutCondition_last_state
} TransitionWithoutConditionStates;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define TRANSITIONWITHOUTCONDITION_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the TransitionWithoutCondition state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	TransitionWithoutConditionStates stateConfVector[TRANSITIONWITHOUTCONDITION_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
} TransitionWithoutCondition;

/*! Initializes the TransitionWithoutCondition state machine data structures. Must be called before first usage.*/
extern void transitionWithoutCondition_init(TransitionWithoutCondition* handle);

/*! Activates the state machine */
extern void transitionWithoutCondition_enter(TransitionWithoutCondition* handle);

/*! Deactivates the state machine */
extern void transitionWithoutCondition_exit(TransitionWithoutCondition* handle);

/*! Performs a 'run to completion' step. */
extern void transitionWithoutCondition_runCycle(TransitionWithoutCondition* handle);



/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean transitionWithoutCondition_isActive(const TransitionWithoutCondition* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean transitionWithoutCondition_isFinal(const TransitionWithoutCondition* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean transitionWithoutCondition_isStateActive(const TransitionWithoutCondition* handle, TransitionWithoutConditionStates state);

#ifdef __cplusplus
}
#endif 

#endif /* TRANSITIONWITHOUTCONDITION_H_ */
