
#ifndef LOGICALAND_H_
#define LOGICALAND_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'LogicalAnd'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	LogicalAnd_last_state,
	LogicalAnd_main_region_A
} LogicalAndStates;

/*! Type definition of the data structure for the LogicalAndIface interface scope. */
typedef struct
{
	sc_integer x;
	sc_boolean b;
} LogicalAndIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define LOGICALAND_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_LOGICALAND_MAIN_REGION_A 0

/*! 
 * Type definition of the data structure for the LogicalAnd state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	LogicalAndStates stateConfVector[LOGICALAND_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	LogicalAndIface iface;
} LogicalAnd;

/*! Initializes the LogicalAnd state machine data structures. Must be called before first usage.*/
extern void logicalAnd_init(LogicalAnd* handle);

/*! Activates the state machine */
extern void logicalAnd_enter(LogicalAnd* handle);

/*! Deactivates the state machine */
extern void logicalAnd_exit(LogicalAnd* handle);

/*! Performs a 'run to completion' step. */
extern void logicalAnd_runCycle(LogicalAnd* handle);


/*! Gets the value of the variable 'x' that is defined in the default interface scope. */ 
extern sc_integer logicalAndIface_get_x(const LogicalAnd* handle);
/*! Sets the value of the variable 'x' that is defined in the default interface scope. */ 
extern void logicalAndIface_set_x(LogicalAnd* handle, sc_integer value);
/*! Gets the value of the variable 'b' that is defined in the default interface scope. */ 
extern sc_boolean logicalAndIface_get_b(const LogicalAnd* handle);
/*! Sets the value of the variable 'b' that is defined in the default interface scope. */ 
extern void logicalAndIface_set_b(LogicalAnd* handle, sc_boolean value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean logicalAnd_isActive(const LogicalAnd* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean logicalAnd_isFinal(const LogicalAnd* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean logicalAnd_isStateActive(const LogicalAnd* handle, LogicalAndStates state);

#ifdef __cplusplus
}
#endif 

#endif /* LOGICALAND_H_ */
