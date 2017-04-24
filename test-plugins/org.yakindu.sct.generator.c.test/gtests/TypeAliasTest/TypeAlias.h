
#ifndef TYPEALIAS_H_
#define TYPEALIAS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'TypeAlias'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	TypeAlias_main_region_Start,
	TypeAlias_main_region_Mid,
	TypeAlias_main_region_Mid2,
	TypeAlias_main_region_End,
	TypeAlias_last_state
} TypeAliasStates;

/*! Type definition of the data structure for the TypeAliasIface interface scope. */
typedef struct
{
	sc_integer myVar;
	sc_string myString;
	sc_boolean myEvent_raised;
} TypeAliasIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define TYPEALIAS_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the TypeAlias state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	TypeAliasStates stateConfVector[TYPEALIAS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	TypeAliasIface iface;
} TypeAlias;

/*! Initializes the TypeAlias state machine data structures. Must be called before first usage.*/
extern void typeAlias_init(TypeAlias* handle);

/*! Activates the state machine */
extern void typeAlias_enter(TypeAlias* handle);

/*! Deactivates the state machine */
extern void typeAlias_exit(TypeAlias* handle);

/*! Performs a 'run to completion' step. */
extern void typeAlias_runCycle(TypeAlias* handle);


/*! Gets the value of the variable 'myVar' that is defined in the default interface scope. */ 
extern sc_integer typeAliasIface_get_myVar(const TypeAlias* handle);
/*! Sets the value of the variable 'myVar' that is defined in the default interface scope. */ 
extern void typeAliasIface_set_myVar(TypeAlias* handle, sc_integer value);
/*! Gets the value of the variable 'myString' that is defined in the default interface scope. */ 
extern sc_string typeAliasIface_get_myString(const TypeAlias* handle);
/*! Sets the value of the variable 'myString' that is defined in the default interface scope. */ 
extern void typeAliasIface_set_myString(TypeAlias* handle, sc_string value);
/*! Raises the in event 'myEvent' that is defined in the default interface scope. */ 
extern void typeAliasIface_raise_myEvent(TypeAlias* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean typeAlias_isActive(const TypeAlias* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean typeAlias_isFinal(const TypeAlias* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean typeAlias_isStateActive(const TypeAlias* handle, TypeAliasStates state);

#ifdef __cplusplus
}
#endif 

#endif /* TYPEALIAS_H_ */
