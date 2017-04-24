
#ifndef LOCALREACTIONS_H_
#define LOCALREACTIONS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'LocalReactions'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	LocalReactions_main_region_A,
	LocalReactions_last_state
} LocalReactionsStates;

/*! Type definition of the data structure for the LocalReactionsIface interface scope. */
typedef struct
{
	sc_integer x;
} LocalReactionsIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define LOCALREACTIONS_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the LocalReactions state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	LocalReactionsStates stateConfVector[LOCALREACTIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	LocalReactionsIface iface;
} LocalReactions;

/*! Initializes the LocalReactions state machine data structures. Must be called before first usage.*/
extern void localReactions_init(LocalReactions* handle);

/*! Activates the state machine */
extern void localReactions_enter(LocalReactions* handle);

/*! Deactivates the state machine */
extern void localReactions_exit(LocalReactions* handle);

/*! Performs a 'run to completion' step. */
extern void localReactions_runCycle(LocalReactions* handle);


/*! Gets the value of the variable 'x' that is defined in the default interface scope. */ 
extern sc_integer localReactionsIface_get_x(const LocalReactions* handle);
/*! Sets the value of the variable 'x' that is defined in the default interface scope. */ 
extern void localReactionsIface_set_x(LocalReactions* handle, sc_integer value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean localReactions_isActive(const LocalReactions* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean localReactions_isFinal(const LocalReactions* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean localReactions_isStateActive(const LocalReactions* handle, LocalReactionsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* LOCALREACTIONS_H_ */
