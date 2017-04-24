
#ifndef INTERNALEVENTLIFECYCLE_H_
#define INTERNALEVENTLIFECYCLE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'InternalEventLifeCycle'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	InternalEventLifeCycle_r1_A,
	InternalEventLifeCycle_r1_B,
	InternalEventLifeCycle_r2_C,
	InternalEventLifeCycle_r2_D,
	InternalEventLifeCycle_last_state
} InternalEventLifeCycleStates;

/*! Type definition of the data structure for the InternalEventLifeCycleIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_boolean f_raised;
} InternalEventLifeCycleIface;

/*! Type definition of the data structure for the InternalEventLifeCycleInternal interface scope. */
typedef struct
{
	sc_boolean i1_raised;
	sc_boolean i2_raised;
} InternalEventLifeCycleInternal;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define INTERNALEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES 2

/*! 
 * Type definition of the data structure for the InternalEventLifeCycle state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	InternalEventLifeCycleStates stateConfVector[INTERNALEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	InternalEventLifeCycleIface iface;
	InternalEventLifeCycleInternal internal;
} InternalEventLifeCycle;

/*! Initializes the InternalEventLifeCycle state machine data structures. Must be called before first usage.*/
extern void internalEventLifeCycle_init(InternalEventLifeCycle* handle);

/*! Activates the state machine */
extern void internalEventLifeCycle_enter(InternalEventLifeCycle* handle);

/*! Deactivates the state machine */
extern void internalEventLifeCycle_exit(InternalEventLifeCycle* handle);

/*! Performs a 'run to completion' step. */
extern void internalEventLifeCycle_runCycle(InternalEventLifeCycle* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void internalEventLifeCycleIface_raise_e(InternalEventLifeCycle* handle);

/*! Raises the in event 'f' that is defined in the default interface scope. */ 
extern void internalEventLifeCycleIface_raise_f(InternalEventLifeCycle* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean internalEventLifeCycle_isActive(const InternalEventLifeCycle* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean internalEventLifeCycle_isFinal(const InternalEventLifeCycle* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean internalEventLifeCycle_isStateActive(const InternalEventLifeCycle* handle, InternalEventLifeCycleStates state);

#ifdef __cplusplus
}
#endif 

#endif /* INTERNALEVENTLIFECYCLE_H_ */
