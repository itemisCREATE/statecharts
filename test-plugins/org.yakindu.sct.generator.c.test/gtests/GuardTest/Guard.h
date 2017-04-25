
#ifndef GUARD_H_
#define GUARD_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'Guard'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	Guard_main_region_A,
	Guard_main_region_B,
	Guard_last_state
} GuardStates;

/*! Type definition of the data structure for the GuardIface interface scope. */
typedef struct
{
	sc_boolean Event1_raised;
	sc_boolean Event2_raised;
	sc_boolean Return_raised;
	sc_integer MyVar;
} GuardIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define GUARD_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the Guard state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	GuardStates stateConfVector[GUARD_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	GuardIface iface;
} Guard;

/*! Initializes the Guard state machine data structures. Must be called before first usage.*/
extern void guard_init(Guard* handle);

/*! Activates the state machine */
extern void guard_enter(Guard* handle);

/*! Deactivates the state machine */
extern void guard_exit(Guard* handle);

/*! Performs a 'run to completion' step. */
extern void guard_runCycle(Guard* handle);


/*! Raises the in event 'Event1' that is defined in the default interface scope. */ 
extern void guardIface_raise_event1(Guard* handle);

/*! Raises the in event 'Event2' that is defined in the default interface scope. */ 
extern void guardIface_raise_event2(Guard* handle);

/*! Raises the in event 'Return' that is defined in the default interface scope. */ 
extern void guardIface_raise_return(Guard* handle);

/*! Gets the value of the variable 'MyVar' that is defined in the default interface scope. */ 
extern sc_integer guardIface_get_myVar(const Guard* handle);
/*! Sets the value of the variable 'MyVar' that is defined in the default interface scope. */ 
extern void guardIface_set_myVar(Guard* handle, sc_integer value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean guard_isActive(const Guard* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean guard_isFinal(const Guard* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean guard_isStateActive(const Guard* handle, GuardStates state);

#ifdef __cplusplus
}
#endif 

#endif /* GUARD_H_ */
