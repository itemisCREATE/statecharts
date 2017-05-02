
#ifndef OPERATIONS_H_
#define OPERATIONS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'Operations'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	Operations_main_region_B,
	Operations_main_region_C,
	Operations_main_region_D,
	Operations_main_region_A,
	Operations_last_state
} OperationsStates;

/*! Type definition of the data structure for the OperationsInternal interface scope. */
typedef struct
{
	sc_boolean myBool;
} OperationsInternal;

/*! Type definition of the data structure for the OperationsIface interface scope. */
typedef struct
{
	sc_boolean ev_raised;
} OperationsIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define OPERATIONS_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the Operations state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	OperationsStates stateConfVector[OPERATIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	OperationsInternal internal;
	OperationsIface iface;
} Operations;

/*! Initializes the Operations state machine data structures. Must be called before first usage.*/
extern void operations_init(Operations* handle);

/*! Activates the state machine */
extern void operations_enter(Operations* handle);

/*! Deactivates the state machine */
extern void operations_exit(Operations* handle);

/*! Performs a 'run to completion' step. */
extern void operations_runCycle(Operations* handle);


/*! Raises the in event 'ev' that is defined in the default interface scope. */ 
extern void operationsIface_raise_ev(Operations* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean operations_isActive(const Operations* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean operations_isFinal(const Operations* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean operations_isStateActive(const Operations* handle, OperationsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* OPERATIONS_H_ */
