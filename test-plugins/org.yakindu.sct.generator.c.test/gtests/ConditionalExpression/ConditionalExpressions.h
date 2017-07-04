
#ifndef CONDITIONALEXPRESSIONS_H_
#define CONDITIONALEXPRESSIONS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'ConditionalExpressions'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	ConditionalExpressions_last_state,
	ConditionalExpressions_main_region_A,
	ConditionalExpressions_main_region_B
} ConditionalExpressionsStates;

/*! Type definition of the data structure for the ConditionalExpressionsIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_integer condition;
	sc_boolean boolVar;
} ConditionalExpressionsIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define CONDITIONALEXPRESSIONS_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_CONDITIONALEXPRESSIONS_MAIN_REGION_A 0
#define SCVI_CONDITIONALEXPRESSIONS_MAIN_REGION_B 0

/*! 
 * Type definition of the data structure for the ConditionalExpressions state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	ConditionalExpressionsStates stateConfVector[CONDITIONALEXPRESSIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	ConditionalExpressionsIface iface;
} ConditionalExpressions;

/*! Initializes the ConditionalExpressions state machine data structures. Must be called before first usage.*/
extern void conditionalExpressions_init(ConditionalExpressions* handle);

/*! Activates the state machine */
extern void conditionalExpressions_enter(ConditionalExpressions* handle);

/*! Deactivates the state machine */
extern void conditionalExpressions_exit(ConditionalExpressions* handle);

/*! Performs a 'run to completion' step. */
extern void conditionalExpressions_runCycle(ConditionalExpressions* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void conditionalExpressionsIface_raise_e(ConditionalExpressions* handle);

/*! Gets the value of the variable 'condition' that is defined in the default interface scope. */ 
extern sc_integer conditionalExpressionsIface_get_condition(const ConditionalExpressions* handle);
/*! Sets the value of the variable 'condition' that is defined in the default interface scope. */ 
extern void conditionalExpressionsIface_set_condition(ConditionalExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'boolVar' that is defined in the default interface scope. */ 
extern sc_boolean conditionalExpressionsIface_get_boolVar(const ConditionalExpressions* handle);
/*! Sets the value of the variable 'boolVar' that is defined in the default interface scope. */ 
extern void conditionalExpressionsIface_set_boolVar(ConditionalExpressions* handle, sc_boolean value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean conditionalExpressions_isActive(const ConditionalExpressions* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean conditionalExpressions_isFinal(const ConditionalExpressions* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean conditionalExpressions_isStateActive(const ConditionalExpressions* handle, ConditionalExpressionsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* CONDITIONALEXPRESSIONS_H_ */
