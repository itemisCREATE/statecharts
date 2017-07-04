
#ifndef NULLCHECK_H_
#define NULLCHECK_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'NullCheck'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	NullCheck_last_state,
	NullCheck_main_region_A,
	NullCheck_main_region_B
} NullCheckStates;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define NULLCHECK_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_NULLCHECK_MAIN_REGION_A 0
#define SCVI_NULLCHECK_MAIN_REGION_B 0

/*! 
 * Type definition of the data structure for the NullCheck state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	NullCheckStates stateConfVector[NULLCHECK_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
} NullCheck;

/*! Initializes the NullCheck state machine data structures. Must be called before first usage.*/
extern void nullCheck_init(NullCheck* handle);

/*! Activates the state machine */
extern void nullCheck_enter(NullCheck* handle);

/*! Deactivates the state machine */
extern void nullCheck_exit(NullCheck* handle);

/*! Performs a 'run to completion' step. */
extern void nullCheck_runCycle(NullCheck* handle);



/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean nullCheck_isActive(const NullCheck* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean nullCheck_isFinal(const NullCheck* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean nullCheck_isStateActive(const NullCheck* handle, NullCheckStates state);

#ifdef __cplusplus
}
#endif 

#endif /* NULLCHECK_H_ */
