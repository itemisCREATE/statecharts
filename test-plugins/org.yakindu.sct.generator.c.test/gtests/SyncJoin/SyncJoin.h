
#ifndef SYNCJOIN_H_
#define SYNCJOIN_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'SyncJoin'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	SyncJoin_last_state,
	SyncJoin_main_region_A,
	SyncJoin_main_region_B,
	SyncJoin_main_region_B_r1_C1,
	SyncJoin_main_region_B_r1_C2,
	SyncJoin_main_region_B_r2_D1,
	SyncJoin_main_region_B_r2_D2
} SyncJoinStates;

/*! Type definition of the data structure for the SyncJoinIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_boolean f_raised;
	sc_boolean jc_raised;
	sc_boolean jd_raised;
	sc_integer x;
} SyncJoinIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define SYNCJOIN_MAX_ORTHOGONAL_STATES 2

/*! Define indices of states in the StateConfVector */
#define SCVI_SYNCJOIN_MAIN_REGION_A 0
#define SCVI_SYNCJOIN_MAIN_REGION_B 0
#define SCVI_SYNCJOIN_MAIN_REGION_B_R1_C1 0
#define SCVI_SYNCJOIN_MAIN_REGION_B_R1_C2 0
#define SCVI_SYNCJOIN_MAIN_REGION_B_R2_D1 1
#define SCVI_SYNCJOIN_MAIN_REGION_B_R2_D2 1

/*! 
 * Type definition of the data structure for the SyncJoin state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	SyncJoinStates stateConfVector[SYNCJOIN_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	SyncJoinIface iface;
} SyncJoin;

/*! Initializes the SyncJoin state machine data structures. Must be called before first usage.*/
extern void syncJoin_init(SyncJoin* handle);

/*! Activates the state machine */
extern void syncJoin_enter(SyncJoin* handle);

/*! Deactivates the state machine */
extern void syncJoin_exit(SyncJoin* handle);

/*! Performs a 'run to completion' step. */
extern void syncJoin_runCycle(SyncJoin* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void syncJoinIface_raise_e(SyncJoin* handle);

/*! Raises the in event 'f' that is defined in the default interface scope. */ 
extern void syncJoinIface_raise_f(SyncJoin* handle);

/*! Raises the in event 'jc' that is defined in the default interface scope. */ 
extern void syncJoinIface_raise_jc(SyncJoin* handle);

/*! Raises the in event 'jd' that is defined in the default interface scope. */ 
extern void syncJoinIface_raise_jd(SyncJoin* handle);

/*! Gets the value of the variable 'x' that is defined in the default interface scope. */ 
extern sc_integer syncJoinIface_get_x(const SyncJoin* handle);
/*! Sets the value of the variable 'x' that is defined in the default interface scope. */ 
extern void syncJoinIface_set_x(SyncJoin* handle, sc_integer value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean syncJoin_isActive(const SyncJoin* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean syncJoin_isFinal(const SyncJoin* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean syncJoin_isStateActive(const SyncJoin* handle, SyncJoinStates state);

#ifdef __cplusplus
}
#endif 

#endif /* SYNCJOIN_H_ */
