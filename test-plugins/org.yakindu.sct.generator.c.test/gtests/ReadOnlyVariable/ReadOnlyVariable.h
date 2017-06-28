
#ifndef READONLYVARIABLE_H_
#define READONLYVARIABLE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'ReadOnlyVariable'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	ReadOnlyVariable_last_state,
	ReadOnlyVariable_main_region_StateB,
	ReadOnlyVariable_main_region_StateA
} ReadOnlyVariableStates;

/*! Type definition of the data structure for the ReadOnlyVariableIface interface scope. */
typedef struct
{
	sc_integer myInt;
	sc_string myString;
	sc_boolean myBool;
	sc_real myReal;
} ReadOnlyVariableIface;

/*! Type definition of the data structure for the ReadOnlyVariableIfaceA interface scope. */
typedef struct
{
	sc_integer myInt;
	sc_string myString;
	sc_boolean myBool;
	sc_real myReal;
} ReadOnlyVariableIfaceA;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define READONLYVARIABLE_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_READONLYVARIABLE_MAIN_REGION_STATEB 0
#define SCVI_READONLYVARIABLE_MAIN_REGION_STATEA 0

/*! 
 * Type definition of the data structure for the ReadOnlyVariable state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	ReadOnlyVariableStates stateConfVector[READONLYVARIABLE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	ReadOnlyVariableIface iface;
	ReadOnlyVariableIfaceA ifaceA;
} ReadOnlyVariable;

/*! Initializes the ReadOnlyVariable state machine data structures. Must be called before first usage.*/
extern void readOnlyVariable_init(ReadOnlyVariable* handle);

/*! Activates the state machine */
extern void readOnlyVariable_enter(ReadOnlyVariable* handle);

/*! Deactivates the state machine */
extern void readOnlyVariable_exit(ReadOnlyVariable* handle);

/*! Performs a 'run to completion' step. */
extern void readOnlyVariable_runCycle(ReadOnlyVariable* handle);


/*! Gets the value of the variable 'myInt' that is defined in the default interface scope. */ 
extern sc_integer readOnlyVariableIface_get_myInt(const ReadOnlyVariable* handle);
/*! Gets the value of the variable 'myString' that is defined in the default interface scope. */ 
extern sc_string readOnlyVariableIface_get_myString(const ReadOnlyVariable* handle);
/*! Gets the value of the variable 'myBool' that is defined in the default interface scope. */ 
extern sc_boolean readOnlyVariableIface_get_myBool(const ReadOnlyVariable* handle);
/*! Gets the value of the variable 'myReal' that is defined in the default interface scope. */ 
extern sc_real readOnlyVariableIface_get_myReal(const ReadOnlyVariable* handle);
/*! Gets the value of the variable 'myInt' that is defined in the interface scope 'A'. */ 
extern sc_integer readOnlyVariableIfaceA_get_myInt(const ReadOnlyVariable* handle);
/*! Gets the value of the variable 'myString' that is defined in the interface scope 'A'. */ 
extern sc_string readOnlyVariableIfaceA_get_myString(const ReadOnlyVariable* handle);
/*! Gets the value of the variable 'myBool' that is defined in the interface scope 'A'. */ 
extern sc_boolean readOnlyVariableIfaceA_get_myBool(const ReadOnlyVariable* handle);
/*! Gets the value of the variable 'myReal' that is defined in the interface scope 'A'. */ 
extern sc_real readOnlyVariableIfaceA_get_myReal(const ReadOnlyVariable* handle);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean readOnlyVariable_isActive(const ReadOnlyVariable* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean readOnlyVariable_isFinal(const ReadOnlyVariable* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean readOnlyVariable_isStateActive(const ReadOnlyVariable* handle, ReadOnlyVariableStates state);

#ifdef __cplusplus
}
#endif 

#endif /* READONLYVARIABLE_H_ */
