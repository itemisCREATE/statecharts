
#ifndef VARIADICFUNCTIONS_H_
#define VARIADICFUNCTIONS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'VariadicFunctions'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	VariadicFunctions_main_region_StateA,
	VariadicFunctions_main_region_StateB,
	VariadicFunctions_last_state
} VariadicFunctionsStates;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define VARIADICFUNCTIONS_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the VariadicFunctions state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	VariadicFunctionsStates stateConfVector[VARIADICFUNCTIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
} VariadicFunctions;

/*! Initializes the VariadicFunctions state machine data structures. Must be called before first usage.*/
extern void variadicFunctions_init(VariadicFunctions* handle);

/*! Activates the state machine */
extern void variadicFunctions_enter(VariadicFunctions* handle);

/*! Deactivates the state machine */
extern void variadicFunctions_exit(VariadicFunctions* handle);

/*! Performs a 'run to completion' step. */
extern void variadicFunctions_runCycle(VariadicFunctions* handle);



/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean variadicFunctions_isActive(const VariadicFunctions* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean variadicFunctions_isFinal(const VariadicFunctions* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean variadicFunctions_isStateActive(const VariadicFunctions* handle, VariadicFunctionsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* VARIADICFUNCTIONS_H_ */
