
#ifndef TRIGGERGUARDEXPRESSIONS_H_
#define TRIGGERGUARDEXPRESSIONS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'TriggerGuardExpressions'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	TriggerGuardExpressions_last_state,
	TriggerGuardExpressions_main_region_A,
	TriggerGuardExpressions_main_region_B
} TriggerGuardExpressionsStates;

/*! Type definition of the data structure for the TriggerGuardExpressionsIface interface scope. */
typedef struct
{
	sc_boolean e1_raised;
	sc_boolean e2_raised;
	sc_boolean b;
} TriggerGuardExpressionsIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define TRIGGERGUARDEXPRESSIONS_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_TRIGGERGUARDEXPRESSIONS_MAIN_REGION_A 0
#define SCVI_TRIGGERGUARDEXPRESSIONS_MAIN_REGION_B 0

/*! 
 * Type definition of the data structure for the TriggerGuardExpressions state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	TriggerGuardExpressionsStates stateConfVector[TRIGGERGUARDEXPRESSIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	TriggerGuardExpressionsIface iface;
} TriggerGuardExpressions;

/*! Initializes the TriggerGuardExpressions state machine data structures. Must be called before first usage.*/
extern void triggerGuardExpressions_init(TriggerGuardExpressions* handle);

/*! Activates the state machine */
extern void triggerGuardExpressions_enter(TriggerGuardExpressions* handle);

/*! Deactivates the state machine */
extern void triggerGuardExpressions_exit(TriggerGuardExpressions* handle);

/*! Performs a 'run to completion' step. */
extern void triggerGuardExpressions_runCycle(TriggerGuardExpressions* handle);


/*! Raises the in event 'e1' that is defined in the default interface scope. */ 
extern void triggerGuardExpressionsIface_raise_e1(TriggerGuardExpressions* handle);

/*! Raises the in event 'e2' that is defined in the default interface scope. */ 
extern void triggerGuardExpressionsIface_raise_e2(TriggerGuardExpressions* handle);

/*! Gets the value of the variable 'b' that is defined in the default interface scope. */ 
extern sc_boolean triggerGuardExpressionsIface_get_b(const TriggerGuardExpressions* handle);
/*! Sets the value of the variable 'b' that is defined in the default interface scope. */ 
extern void triggerGuardExpressionsIface_set_b(TriggerGuardExpressions* handle, sc_boolean value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean triggerGuardExpressions_isActive(const TriggerGuardExpressions* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean triggerGuardExpressions_isFinal(const TriggerGuardExpressions* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean triggerGuardExpressions_isStateActive(const TriggerGuardExpressions* handle, TriggerGuardExpressionsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* TRIGGERGUARDEXPRESSIONS_H_ */
