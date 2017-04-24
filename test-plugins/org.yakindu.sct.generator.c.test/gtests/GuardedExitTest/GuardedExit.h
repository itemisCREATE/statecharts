
#ifndef GUARDEDEXIT_H_
#define GUARDEDEXIT_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'GuardedExit'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	GuardedExit_main_region_A,
	GuardedExit_main_region_B,
	GuardedExit_last_state
} GuardedExitStates;

/*! Type definition of the data structure for the GuardedExitIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_boolean guard;
	sc_boolean done;
} GuardedExitIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define GUARDEDEXIT_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the GuardedExit state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	GuardedExitStates stateConfVector[GUARDEDEXIT_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	GuardedExitIface iface;
} GuardedExit;

/*! Initializes the GuardedExit state machine data structures. Must be called before first usage.*/
extern void guardedExit_init(GuardedExit* handle);

/*! Activates the state machine */
extern void guardedExit_enter(GuardedExit* handle);

/*! Deactivates the state machine */
extern void guardedExit_exit(GuardedExit* handle);

/*! Performs a 'run to completion' step. */
extern void guardedExit_runCycle(GuardedExit* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void guardedExitIface_raise_e(GuardedExit* handle);

/*! Gets the value of the variable 'guard' that is defined in the default interface scope. */ 
extern sc_boolean guardedExitIface_get_guard(const GuardedExit* handle);
/*! Sets the value of the variable 'guard' that is defined in the default interface scope. */ 
extern void guardedExitIface_set_guard(GuardedExit* handle, sc_boolean value);
/*! Gets the value of the variable 'done' that is defined in the default interface scope. */ 
extern sc_boolean guardedExitIface_get_done(const GuardedExit* handle);
/*! Sets the value of the variable 'done' that is defined in the default interface scope. */ 
extern void guardedExitIface_set_done(GuardedExit* handle, sc_boolean value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean guardedExit_isActive(const GuardedExit* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean guardedExit_isFinal(const GuardedExit* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean guardedExit_isStateActive(const GuardedExit* handle, GuardedExitStates state);

#ifdef __cplusplus
}
#endif 

#endif /* GUARDEDEXIT_H_ */
