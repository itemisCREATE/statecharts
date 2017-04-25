
#ifndef EXITSTATE_H_
#define EXITSTATE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'ExitState'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	ExitState_r_A,
	ExitState_r_A_r_B,
	ExitState_r_E,
	ExitState_r_F,
	ExitState_last_state
} ExitStateStates;

/*! Type definition of the data structure for the ExitStateIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_boolean f_raised;
	sc_boolean g_raised;
} ExitStateIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define EXITSTATE_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the ExitState state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	ExitStateStates stateConfVector[EXITSTATE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	ExitStateIface iface;
} ExitState;

/*! Initializes the ExitState state machine data structures. Must be called before first usage.*/
extern void exitState_init(ExitState* handle);

/*! Activates the state machine */
extern void exitState_enter(ExitState* handle);

/*! Deactivates the state machine */
extern void exitState_exit(ExitState* handle);

/*! Performs a 'run to completion' step. */
extern void exitState_runCycle(ExitState* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void exitStateIface_raise_e(ExitState* handle);

/*! Raises the in event 'f' that is defined in the default interface scope. */ 
extern void exitStateIface_raise_f(ExitState* handle);

/*! Raises the in event 'g' that is defined in the default interface scope. */ 
extern void exitStateIface_raise_g(ExitState* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean exitState_isActive(const ExitState* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean exitState_isFinal(const ExitState* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean exitState_isStateActive(const ExitState* handle, ExitStateStates state);

#ifdef __cplusplus
}
#endif 

#endif /* EXITSTATE_H_ */
