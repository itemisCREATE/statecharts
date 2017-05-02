
#ifndef TRIGGEREXPRESSIONPRECEDENCE_H_
#define TRIGGEREXPRESSIONPRECEDENCE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'TriggerExpressionPrecedence'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	TriggerExpressionPrecedence_TriggerExpressionPrecedence_main_region_A,
	TriggerExpressionPrecedence_last_state
} TriggerExpressionPrecedenceStates;

/*! Type definition of the data structure for the TriggerExpressionPrecedenceIface interface scope. */
typedef struct
{
	sc_boolean e1_raised;
	sc_boolean e2_raised;
	sc_boolean c1;
	sc_boolean c2;
	sc_boolean e1_transition;
	sc_boolean e2_transition;
} TriggerExpressionPrecedenceIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define TRIGGEREXPRESSIONPRECEDENCE_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the TriggerExpressionPrecedence state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	TriggerExpressionPrecedenceStates stateConfVector[TRIGGEREXPRESSIONPRECEDENCE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	TriggerExpressionPrecedenceIface iface;
} TriggerExpressionPrecedence;

/*! Initializes the TriggerExpressionPrecedence state machine data structures. Must be called before first usage.*/
extern void triggerExpressionPrecedence_init(TriggerExpressionPrecedence* handle);

/*! Activates the state machine */
extern void triggerExpressionPrecedence_enter(TriggerExpressionPrecedence* handle);

/*! Deactivates the state machine */
extern void triggerExpressionPrecedence_exit(TriggerExpressionPrecedence* handle);

/*! Performs a 'run to completion' step. */
extern void triggerExpressionPrecedence_runCycle(TriggerExpressionPrecedence* handle);


/*! Raises the in event 'e1' that is defined in the default interface scope. */ 
extern void triggerExpressionPrecedenceIface_raise_e1(TriggerExpressionPrecedence* handle);

/*! Raises the in event 'e2' that is defined in the default interface scope. */ 
extern void triggerExpressionPrecedenceIface_raise_e2(TriggerExpressionPrecedence* handle);

/*! Gets the value of the variable 'c1' that is defined in the default interface scope. */ 
extern sc_boolean triggerExpressionPrecedenceIface_get_c1(const TriggerExpressionPrecedence* handle);
/*! Sets the value of the variable 'c1' that is defined in the default interface scope. */ 
extern void triggerExpressionPrecedenceIface_set_c1(TriggerExpressionPrecedence* handle, sc_boolean value);
/*! Gets the value of the variable 'c2' that is defined in the default interface scope. */ 
extern sc_boolean triggerExpressionPrecedenceIface_get_c2(const TriggerExpressionPrecedence* handle);
/*! Sets the value of the variable 'c2' that is defined in the default interface scope. */ 
extern void triggerExpressionPrecedenceIface_set_c2(TriggerExpressionPrecedence* handle, sc_boolean value);
/*! Gets the value of the variable 'e1_transition' that is defined in the default interface scope. */ 
extern sc_boolean triggerExpressionPrecedenceIface_get_e1_transition(const TriggerExpressionPrecedence* handle);
/*! Sets the value of the variable 'e1_transition' that is defined in the default interface scope. */ 
extern void triggerExpressionPrecedenceIface_set_e1_transition(TriggerExpressionPrecedence* handle, sc_boolean value);
/*! Gets the value of the variable 'e2_transition' that is defined in the default interface scope. */ 
extern sc_boolean triggerExpressionPrecedenceIface_get_e2_transition(const TriggerExpressionPrecedence* handle);
/*! Sets the value of the variable 'e2_transition' that is defined in the default interface scope. */ 
extern void triggerExpressionPrecedenceIface_set_e2_transition(TriggerExpressionPrecedence* handle, sc_boolean value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean triggerExpressionPrecedence_isActive(const TriggerExpressionPrecedence* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean triggerExpressionPrecedence_isFinal(const TriggerExpressionPrecedence* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean triggerExpressionPrecedence_isStateActive(const TriggerExpressionPrecedence* handle, TriggerExpressionPrecedenceStates state);

#ifdef __cplusplus
}
#endif 

#endif /* TRIGGEREXPRESSIONPRECEDENCE_H_ */
