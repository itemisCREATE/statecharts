
#ifndef STATECHARTLOCALREACTIONS_H_
#define STATECHARTLOCALREACTIONS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'StatechartLocalReactions'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	StatechartLocalReactions_last_state,
	StatechartLocalReactions_main_region_S1,
	StatechartLocalReactions_main_region_S2,
	StatechartLocalReactions_region2_a
} StatechartLocalReactionsStates;

/*! Type definition of the data structure for the StatechartLocalReactionsIface interface scope. */
typedef struct
{
	sc_integer myInt;
} StatechartLocalReactionsIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define STATECHARTLOCALREACTIONS_MAX_ORTHOGONAL_STATES 2

/*! Define indices of states in the StateConfVector */
#define SCVI_STATECHARTLOCALREACTIONS_MAIN_REGION_S1 0
#define SCVI_STATECHARTLOCALREACTIONS_MAIN_REGION_S2 0
#define SCVI_STATECHARTLOCALREACTIONS_REGION2_A 1

/*! 
 * Type definition of the data structure for the StatechartLocalReactions state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	StatechartLocalReactionsStates stateConfVector[STATECHARTLOCALREACTIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	StatechartLocalReactionsIface iface;
} StatechartLocalReactions;

/*! Initializes the StatechartLocalReactions state machine data structures. Must be called before first usage.*/
extern void statechartLocalReactions_init(StatechartLocalReactions* handle);

/*! Activates the state machine */
extern void statechartLocalReactions_enter(StatechartLocalReactions* handle);

/*! Deactivates the state machine */
extern void statechartLocalReactions_exit(StatechartLocalReactions* handle);

/*! Performs a 'run to completion' step. */
extern void statechartLocalReactions_runCycle(StatechartLocalReactions* handle);


/*! Gets the value of the variable 'myInt' that is defined in the default interface scope. */ 
extern sc_integer statechartLocalReactionsIface_get_myInt(const StatechartLocalReactions* handle);
/*! Sets the value of the variable 'myInt' that is defined in the default interface scope. */ 
extern void statechartLocalReactionsIface_set_myInt(StatechartLocalReactions* handle, sc_integer value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean statechartLocalReactions_isActive(const StatechartLocalReactions* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean statechartLocalReactions_isFinal(const StatechartLocalReactions* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean statechartLocalReactions_isStateActive(const StatechartLocalReactions* handle, StatechartLocalReactionsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* STATECHARTLOCALREACTIONS_H_ */
