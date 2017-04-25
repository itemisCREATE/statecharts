
#ifndef PARENTHESIS_H_
#define PARENTHESIS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'Parenthesis'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	Parenthesis_mainRegion_A,
	Parenthesis_last_state
} ParenthesisStates;

/*! Type definition of the data structure for the ParenthesisIface interface scope. */
typedef struct
{
	sc_integer erg;
} ParenthesisIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define PARENTHESIS_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the Parenthesis state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	ParenthesisStates stateConfVector[PARENTHESIS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	ParenthesisIface iface;
} Parenthesis;

/*! Initializes the Parenthesis state machine data structures. Must be called before first usage.*/
extern void parenthesis_init(Parenthesis* handle);

/*! Activates the state machine */
extern void parenthesis_enter(Parenthesis* handle);

/*! Deactivates the state machine */
extern void parenthesis_exit(Parenthesis* handle);

/*! Performs a 'run to completion' step. */
extern void parenthesis_runCycle(Parenthesis* handle);


/*! Gets the value of the variable 'erg' that is defined in the default interface scope. */ 
extern sc_integer parenthesisIface_get_erg(const Parenthesis* handle);
/*! Sets the value of the variable 'erg' that is defined in the default interface scope. */ 
extern void parenthesisIface_set_erg(Parenthesis* handle, sc_integer value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean parenthesis_isActive(const Parenthesis* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean parenthesis_isFinal(const Parenthesis* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean parenthesis_isStateActive(const Parenthesis* handle, ParenthesisStates state);

#ifdef __cplusplus
}
#endif 

#endif /* PARENTHESIS_H_ */
