
#ifndef SYNCFORK_H_
#define SYNCFORK_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'SyncFork'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	SyncFork_last_state,
	SyncFork_main_region_A,
	SyncFork_main_region_B,
	SyncFork_main_region_B_r1_C1,
	SyncFork_main_region_B_r1_C2,
	SyncFork_main_region_B_r2_D1,
	SyncFork_main_region_B_r2_D2
} SyncForkStates;

/*! Type definition of the data structure for the SyncForkIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_boolean f_raised;
} SyncForkIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define SYNCFORK_MAX_ORTHOGONAL_STATES 2

/*! Define indices of states in the StateConfVector */
#define SCVI_SYNCFORK_MAIN_REGION_A 0
#define SCVI_SYNCFORK_MAIN_REGION_B 0
#define SCVI_SYNCFORK_MAIN_REGION_B_R1_C1 0
#define SCVI_SYNCFORK_MAIN_REGION_B_R1_C2 0
#define SCVI_SYNCFORK_MAIN_REGION_B_R2_D1 1
#define SCVI_SYNCFORK_MAIN_REGION_B_R2_D2 1

/*! 
 * Type definition of the data structure for the SyncFork state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	SyncForkStates stateConfVector[SYNCFORK_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	SyncForkIface iface;
} SyncFork;

/*! Initializes the SyncFork state machine data structures. Must be called before first usage.*/
extern void syncFork_init(SyncFork* handle);

/*! Activates the state machine */
extern void syncFork_enter(SyncFork* handle);

/*! Deactivates the state machine */
extern void syncFork_exit(SyncFork* handle);

/*! Performs a 'run to completion' step. */
extern void syncFork_runCycle(SyncFork* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void syncForkIface_raise_e(SyncFork* handle);

/*! Raises the in event 'f' that is defined in the default interface scope. */ 
extern void syncForkIface_raise_f(SyncFork* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean syncFork_isActive(const SyncFork* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean syncFork_isFinal(const SyncFork* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean syncFork_isStateActive(const SyncFork* handle, SyncForkStates state);

#ifdef __cplusplus
}
#endif 

#endif /* SYNCFORK_H_ */
