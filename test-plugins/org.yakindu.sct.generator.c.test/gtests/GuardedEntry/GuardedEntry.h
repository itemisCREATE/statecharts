
#ifndef GUARDEDENTRY_H_
#define GUARDEDENTRY_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'GuardedEntry'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	GuardedEntry_last_state,
	GuardedEntry_main_region_A,
	GuardedEntry_main_region_B
} GuardedEntryStates;

/*! Type definition of the data structure for the GuardedEntryIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_boolean guard;
	sc_boolean done;
} GuardedEntryIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define GUARDEDENTRY_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_GUARDEDENTRY_MAIN_REGION_A 0
#define SCVI_GUARDEDENTRY_MAIN_REGION_B 0

/*! 
 * Type definition of the data structure for the GuardedEntry state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	GuardedEntryStates stateConfVector[GUARDEDENTRY_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	GuardedEntryIface iface;
} GuardedEntry;

/*! Initializes the GuardedEntry state machine data structures. Must be called before first usage.*/
extern void guardedEntry_init(GuardedEntry* handle);

/*! Activates the state machine */
extern void guardedEntry_enter(GuardedEntry* handle);

/*! Deactivates the state machine */
extern void guardedEntry_exit(GuardedEntry* handle);

/*! Performs a 'run to completion' step. */
extern void guardedEntry_runCycle(GuardedEntry* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void guardedEntryIface_raise_e(GuardedEntry* handle);

/*! Gets the value of the variable 'guard' that is defined in the default interface scope. */ 
extern sc_boolean guardedEntryIface_get_guard(const GuardedEntry* handle);
/*! Sets the value of the variable 'guard' that is defined in the default interface scope. */ 
extern void guardedEntryIface_set_guard(GuardedEntry* handle, sc_boolean value);
/*! Gets the value of the variable 'done' that is defined in the default interface scope. */ 
extern sc_boolean guardedEntryIface_get_done(const GuardedEntry* handle);
/*! Sets the value of the variable 'done' that is defined in the default interface scope. */ 
extern void guardedEntryIface_set_done(GuardedEntry* handle, sc_boolean value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean guardedEntry_isActive(const GuardedEntry* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean guardedEntry_isFinal(const GuardedEntry* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean guardedEntry_isStateActive(const GuardedEntry* handle, GuardedEntryStates state);

#ifdef __cplusplus
}
#endif 

#endif /* GUARDEDENTRY_H_ */
