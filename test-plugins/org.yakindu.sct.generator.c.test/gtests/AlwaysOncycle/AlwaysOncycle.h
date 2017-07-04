
#ifndef ALWAYSONCYCLE_H_
#define ALWAYSONCYCLE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'AlwaysOncycle'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	AlwaysOncycle_last_state,
	AlwaysOncycle_main_region_StateA,
	AlwaysOncycle_main_region_StateB
} AlwaysOncycleStates;

/*! Type definition of the data structure for the AlwaysOncycleIface interface scope. */
typedef struct
{
	sc_integer value;
	sc_boolean v2;
} AlwaysOncycleIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define ALWAYSONCYCLE_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_ALWAYSONCYCLE_MAIN_REGION_STATEA 0
#define SCVI_ALWAYSONCYCLE_MAIN_REGION_STATEB 0

/*! 
 * Type definition of the data structure for the AlwaysOncycle state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	AlwaysOncycleStates stateConfVector[ALWAYSONCYCLE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	AlwaysOncycleIface iface;
} AlwaysOncycle;

/*! Initializes the AlwaysOncycle state machine data structures. Must be called before first usage.*/
extern void alwaysOncycle_init(AlwaysOncycle* handle);

/*! Activates the state machine */
extern void alwaysOncycle_enter(AlwaysOncycle* handle);

/*! Deactivates the state machine */
extern void alwaysOncycle_exit(AlwaysOncycle* handle);

/*! Performs a 'run to completion' step. */
extern void alwaysOncycle_runCycle(AlwaysOncycle* handle);


/*! Gets the value of the variable 'value' that is defined in the default interface scope. */ 
extern sc_integer alwaysOncycleIface_get_value(const AlwaysOncycle* handle);
/*! Sets the value of the variable 'value' that is defined in the default interface scope. */ 
extern void alwaysOncycleIface_set_value(AlwaysOncycle* handle, sc_integer value);
/*! Gets the value of the variable 'v2' that is defined in the default interface scope. */ 
extern sc_boolean alwaysOncycleIface_get_v2(const AlwaysOncycle* handle);
/*! Sets the value of the variable 'v2' that is defined in the default interface scope. */ 
extern void alwaysOncycleIface_set_v2(AlwaysOncycle* handle, sc_boolean value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean alwaysOncycle_isActive(const AlwaysOncycle* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean alwaysOncycle_isFinal(const AlwaysOncycle* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean alwaysOncycle_isStateActive(const AlwaysOncycle* handle, AlwaysOncycleStates state);

#ifdef __cplusplus
}
#endif 

#endif /* ALWAYSONCYCLE_H_ */
