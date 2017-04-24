
#ifndef INEVENTLIFECYCLE_H_
#define INEVENTLIFECYCLE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'InEventLifeCycle'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	InEventLifeCycle_main_region_A,
	InEventLifeCycle_last_state
} InEventLifeCycleStates;

/*! Type definition of the data structure for the InEventLifeCycleIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_integer i;
} InEventLifeCycleIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define INEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the InEventLifeCycle state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	InEventLifeCycleStates stateConfVector[INEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	InEventLifeCycleIface iface;
} InEventLifeCycle;

/*! Initializes the InEventLifeCycle state machine data structures. Must be called before first usage.*/
extern void inEventLifeCycle_init(InEventLifeCycle* handle);

/*! Activates the state machine */
extern void inEventLifeCycle_enter(InEventLifeCycle* handle);

/*! Deactivates the state machine */
extern void inEventLifeCycle_exit(InEventLifeCycle* handle);

/*! Performs a 'run to completion' step. */
extern void inEventLifeCycle_runCycle(InEventLifeCycle* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void inEventLifeCycleIface_raise_e(InEventLifeCycle* handle);

/*! Gets the value of the variable 'i' that is defined in the default interface scope. */ 
extern sc_integer inEventLifeCycleIface_get_i(const InEventLifeCycle* handle);
/*! Sets the value of the variable 'i' that is defined in the default interface scope. */ 
extern void inEventLifeCycleIface_set_i(InEventLifeCycle* handle, sc_integer value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean inEventLifeCycle_isActive(const InEventLifeCycle* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean inEventLifeCycle_isFinal(const InEventLifeCycle* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean inEventLifeCycle_isStateActive(const InEventLifeCycle* handle, InEventLifeCycleStates state);

#ifdef __cplusplus
}
#endif 

#endif /* INEVENTLIFECYCLE_H_ */
