
#ifndef OPERATIONSWITHOUTBRACES_H_
#define OPERATIONSWITHOUTBRACES_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'OperationsWithoutBraces'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	OperationsWithoutBraces_main_region_A,
	OperationsWithoutBraces_main_region_B,
	OperationsWithoutBraces_main_region_C,
	OperationsWithoutBraces_main_region_D,
	OperationsWithoutBraces_another_region_A,
	OperationsWithoutBraces_another_region_B,
	OperationsWithoutBraces_another_region_C,
	OperationsWithoutBraces_another_region_D,
	OperationsWithoutBraces_last_state
} OperationsWithoutBracesStates;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define OPERATIONSWITHOUTBRACES_MAX_ORTHOGONAL_STATES 2

/*! 
 * Type definition of the data structure for the OperationsWithoutBraces state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	OperationsWithoutBracesStates stateConfVector[OPERATIONSWITHOUTBRACES_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
} OperationsWithoutBraces;

/*! Initializes the OperationsWithoutBraces state machine data structures. Must be called before first usage.*/
extern void operationsWithoutBraces_init(OperationsWithoutBraces* handle);

/*! Activates the state machine */
extern void operationsWithoutBraces_enter(OperationsWithoutBraces* handle);

/*! Deactivates the state machine */
extern void operationsWithoutBraces_exit(OperationsWithoutBraces* handle);

/*! Performs a 'run to completion' step. */
extern void operationsWithoutBraces_runCycle(OperationsWithoutBraces* handle);



/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean operationsWithoutBraces_isActive(const OperationsWithoutBraces* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean operationsWithoutBraces_isFinal(const OperationsWithoutBraces* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean operationsWithoutBraces_isStateActive(const OperationsWithoutBraces* handle, OperationsWithoutBracesStates state);

#ifdef __cplusplus
}
#endif 

#endif /* OPERATIONSWITHOUTBRACES_H_ */
