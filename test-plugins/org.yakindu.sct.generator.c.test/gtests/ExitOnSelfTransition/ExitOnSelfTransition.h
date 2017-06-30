
#ifndef EXITONSELFTRANSITION_H_
#define EXITONSELFTRANSITION_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'ExitOnSelfTransition'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	ExitOnSelfTransition_last_state,
	ExitOnSelfTransition_main_region_A,
	ExitOnSelfTransition_main_region_B
} ExitOnSelfTransitionStates;

/*! Type definition of the data structure for the ExitOnSelfTransitionIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_boolean f_raised;
	sc_integer entryCount;
	sc_integer exitCount;
} ExitOnSelfTransitionIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define EXITONSELFTRANSITION_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_EXITONSELFTRANSITION_MAIN_REGION_A 0
#define SCVI_EXITONSELFTRANSITION_MAIN_REGION_B 0

/*! 
 * Type definition of the data structure for the ExitOnSelfTransition state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	ExitOnSelfTransitionStates stateConfVector[EXITONSELFTRANSITION_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	ExitOnSelfTransitionIface iface;
} ExitOnSelfTransition;

/*! Initializes the ExitOnSelfTransition state machine data structures. Must be called before first usage.*/
extern void exitOnSelfTransition_init(ExitOnSelfTransition* handle);

/*! Activates the state machine */
extern void exitOnSelfTransition_enter(ExitOnSelfTransition* handle);

/*! Deactivates the state machine */
extern void exitOnSelfTransition_exit(ExitOnSelfTransition* handle);

/*! Performs a 'run to completion' step. */
extern void exitOnSelfTransition_runCycle(ExitOnSelfTransition* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void exitOnSelfTransitionIface_raise_e(ExitOnSelfTransition* handle);

/*! Raises the in event 'f' that is defined in the default interface scope. */ 
extern void exitOnSelfTransitionIface_raise_f(ExitOnSelfTransition* handle);

/*! Gets the value of the variable 'entryCount' that is defined in the default interface scope. */ 
extern sc_integer exitOnSelfTransitionIface_get_entryCount(const ExitOnSelfTransition* handle);
/*! Sets the value of the variable 'entryCount' that is defined in the default interface scope. */ 
extern void exitOnSelfTransitionIface_set_entryCount(ExitOnSelfTransition* handle, sc_integer value);
/*! Gets the value of the variable 'exitCount' that is defined in the default interface scope. */ 
extern sc_integer exitOnSelfTransitionIface_get_exitCount(const ExitOnSelfTransition* handle);
/*! Sets the value of the variable 'exitCount' that is defined in the default interface scope. */ 
extern void exitOnSelfTransitionIface_set_exitCount(ExitOnSelfTransition* handle, sc_integer value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean exitOnSelfTransition_isActive(const ExitOnSelfTransition* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean exitOnSelfTransition_isFinal(const ExitOnSelfTransition* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean exitOnSelfTransition_isStateActive(const ExitOnSelfTransition* handle, ExitOnSelfTransitionStates state);

#ifdef __cplusplus
}
#endif 

#endif /* EXITONSELFTRANSITION_H_ */
