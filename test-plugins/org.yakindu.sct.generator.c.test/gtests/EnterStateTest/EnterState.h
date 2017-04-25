
#ifndef ENTERSTATE_H_
#define ENTERSTATE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'EnterState'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	EnterState_r_A,
	EnterState_r_B,
	EnterState_r_B_r_E,
	EnterState_r_B_r_F,
	EnterState_last_state
} EnterStateStates;

/*! Type definition of the data structure for the EnterStateIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_boolean f_raised;
	sc_boolean g_raised;
} EnterStateIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define ENTERSTATE_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the EnterState state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	EnterStateStates stateConfVector[ENTERSTATE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	EnterStateIface iface;
} EnterState;

/*! Initializes the EnterState state machine data structures. Must be called before first usage.*/
extern void enterState_init(EnterState* handle);

/*! Activates the state machine */
extern void enterState_enter(EnterState* handle);

/*! Deactivates the state machine */
extern void enterState_exit(EnterState* handle);

/*! Performs a 'run to completion' step. */
extern void enterState_runCycle(EnterState* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void enterStateIface_raise_e(EnterState* handle);

/*! Raises the in event 'f' that is defined in the default interface scope. */ 
extern void enterStateIface_raise_f(EnterState* handle);

/*! Raises the in event 'g' that is defined in the default interface scope. */ 
extern void enterStateIface_raise_g(EnterState* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean enterState_isActive(const EnterState* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean enterState_isFinal(const EnterState* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean enterState_isStateActive(const EnterState* handle, EnterStateStates state);

#ifdef __cplusplus
}
#endif 

#endif /* ENTERSTATE_H_ */
