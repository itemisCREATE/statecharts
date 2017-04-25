
#ifndef OUTEVENTLIFECYCLE_H_
#define OUTEVENTLIFECYCLE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'OutEventLifeCycle'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	OutEventLifeCycle_r1_A,
	OutEventLifeCycle_r1_B,
	OutEventLifeCycle_r2_B,
	OutEventLifeCycle_last_state
} OutEventLifeCycleStates;

/*! Type definition of the data structure for the OutEventLifeCycleIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_boolean f_raised;
	sc_boolean f_available_in_cycle;
	sc_boolean f_available_in_next_cycle;
} OutEventLifeCycleIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define OUTEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES 2

/*! 
 * Type definition of the data structure for the OutEventLifeCycle state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	OutEventLifeCycleStates stateConfVector[OUTEVENTLIFECYCLE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	OutEventLifeCycleIface iface;
} OutEventLifeCycle;

/*! Initializes the OutEventLifeCycle state machine data structures. Must be called before first usage.*/
extern void outEventLifeCycle_init(OutEventLifeCycle* handle);

/*! Activates the state machine */
extern void outEventLifeCycle_enter(OutEventLifeCycle* handle);

/*! Deactivates the state machine */
extern void outEventLifeCycle_exit(OutEventLifeCycle* handle);

/*! Performs a 'run to completion' step. */
extern void outEventLifeCycle_runCycle(OutEventLifeCycle* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void outEventLifeCycleIface_raise_e(OutEventLifeCycle* handle);

/*! Checks if the out event 'f' that is defined in the default interface scope has been raised. */ 
extern sc_boolean outEventLifeCycleIface_israised_f(const OutEventLifeCycle* handle);

/*! Gets the value of the variable 'f_available_in_cycle' that is defined in the default interface scope. */ 
extern sc_boolean outEventLifeCycleIface_get_f_available_in_cycle(const OutEventLifeCycle* handle);
/*! Sets the value of the variable 'f_available_in_cycle' that is defined in the default interface scope. */ 
extern void outEventLifeCycleIface_set_f_available_in_cycle(OutEventLifeCycle* handle, sc_boolean value);
/*! Gets the value of the variable 'f_available_in_next_cycle' that is defined in the default interface scope. */ 
extern sc_boolean outEventLifeCycleIface_get_f_available_in_next_cycle(const OutEventLifeCycle* handle);
/*! Sets the value of the variable 'f_available_in_next_cycle' that is defined in the default interface scope. */ 
extern void outEventLifeCycleIface_set_f_available_in_next_cycle(OutEventLifeCycle* handle, sc_boolean value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean outEventLifeCycle_isActive(const OutEventLifeCycle* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean outEventLifeCycle_isFinal(const OutEventLifeCycle* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean outEventLifeCycle_isStateActive(const OutEventLifeCycle* handle, OutEventLifeCycleStates state);

#ifdef __cplusplus
}
#endif 

#endif /* OUTEVENTLIFECYCLE_H_ */
