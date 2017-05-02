
#ifndef LOGICALOR_H_
#define LOGICALOR_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'LogicalOr'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	LogicalOr_main_region_A,
	LogicalOr_last_state
} LogicalOrStates;

/*! Type definition of the data structure for the LogicalOrIface interface scope. */
typedef struct
{
	sc_integer x;
	sc_boolean b;
} LogicalOrIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define LOGICALOR_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the LogicalOr state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	LogicalOrStates stateConfVector[LOGICALOR_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	LogicalOrIface iface;
} LogicalOr;

/*! Initializes the LogicalOr state machine data structures. Must be called before first usage.*/
extern void logicalOr_init(LogicalOr* handle);

/*! Activates the state machine */
extern void logicalOr_enter(LogicalOr* handle);

/*! Deactivates the state machine */
extern void logicalOr_exit(LogicalOr* handle);

/*! Performs a 'run to completion' step. */
extern void logicalOr_runCycle(LogicalOr* handle);


/*! Gets the value of the variable 'x' that is defined in the default interface scope. */ 
extern sc_integer logicalOrIface_get_x(const LogicalOr* handle);
/*! Sets the value of the variable 'x' that is defined in the default interface scope. */ 
extern void logicalOrIface_set_x(LogicalOr* handle, sc_integer value);
/*! Gets the value of the variable 'b' that is defined in the default interface scope. */ 
extern sc_boolean logicalOrIface_get_b(const LogicalOr* handle);
/*! Sets the value of the variable 'b' that is defined in the default interface scope. */ 
extern void logicalOrIface_set_b(LogicalOr* handle, sc_boolean value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean logicalOr_isActive(const LogicalOr* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean logicalOr_isFinal(const LogicalOr* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean logicalOr_isStateActive(const LogicalOr* handle, LogicalOrStates state);

#ifdef __cplusplus
}
#endif 

#endif /* LOGICALOR_H_ */
