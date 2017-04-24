
#ifndef FINALSTATE_H_
#define FINALSTATE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'FinalState'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	FinalState_main_region_myState,
	FinalState_main_region__final_,
	FinalState_last_state
} FinalStateStates;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define FINALSTATE_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the FinalState state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	FinalStateStates stateConfVector[FINALSTATE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
} FinalState;

/*! Initializes the FinalState state machine data structures. Must be called before first usage.*/
extern void finalState_init(FinalState* handle);

/*! Activates the state machine */
extern void finalState_enter(FinalState* handle);

/*! Deactivates the state machine */
extern void finalState_exit(FinalState* handle);

/*! Performs a 'run to completion' step. */
extern void finalState_runCycle(FinalState* handle);



/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean finalState_isActive(const FinalState* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean finalState_isFinal(const FinalState* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean finalState_isStateActive(const FinalState* handle, FinalStateStates state);

#ifdef __cplusplus
}
#endif 

#endif /* FINALSTATE_H_ */
