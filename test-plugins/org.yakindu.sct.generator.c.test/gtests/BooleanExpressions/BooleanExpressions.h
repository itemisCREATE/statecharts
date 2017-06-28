
#ifndef BOOLEANEXPRESSIONS_H_
#define BOOLEANEXPRESSIONS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'BooleanExpressions'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	BooleanExpressions_last_state,
	BooleanExpressions_main_region_StateA,
	BooleanExpressions_main_region_StateB
} BooleanExpressionsStates;

/*! Type definition of the data structure for the BooleanExpressionsIface interface scope. */
typedef struct
{
	sc_boolean myBool1;
	sc_boolean myBool2;
	sc_boolean and_ID;
	sc_boolean or_ID;
	sc_boolean not_ID;
	sc_boolean equal;
	sc_boolean notequal;
	sc_boolean e1_raised;
} BooleanExpressionsIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define BOOLEANEXPRESSIONS_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_BOOLEANEXPRESSIONS_MAIN_REGION_STATEA 0
#define SCVI_BOOLEANEXPRESSIONS_MAIN_REGION_STATEB 0

/*! 
 * Type definition of the data structure for the BooleanExpressions state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	BooleanExpressionsStates stateConfVector[BOOLEANEXPRESSIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	BooleanExpressionsIface iface;
} BooleanExpressions;

/*! Initializes the BooleanExpressions state machine data structures. Must be called before first usage.*/
extern void booleanExpressions_init(BooleanExpressions* handle);

/*! Activates the state machine */
extern void booleanExpressions_enter(BooleanExpressions* handle);

/*! Deactivates the state machine */
extern void booleanExpressions_exit(BooleanExpressions* handle);

/*! Performs a 'run to completion' step. */
extern void booleanExpressions_runCycle(BooleanExpressions* handle);


/*! Gets the value of the variable 'myBool1' that is defined in the default interface scope. */ 
extern sc_boolean booleanExpressionsIface_get_myBool1(const BooleanExpressions* handle);
/*! Sets the value of the variable 'myBool1' that is defined in the default interface scope. */ 
extern void booleanExpressionsIface_set_myBool1(BooleanExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'myBool2' that is defined in the default interface scope. */ 
extern sc_boolean booleanExpressionsIface_get_myBool2(const BooleanExpressions* handle);
/*! Sets the value of the variable 'myBool2' that is defined in the default interface scope. */ 
extern void booleanExpressionsIface_set_myBool2(BooleanExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'and' that is defined in the default interface scope. */ 
extern sc_boolean booleanExpressionsIface_get_and(const BooleanExpressions* handle);
/*! Sets the value of the variable 'and' that is defined in the default interface scope. */ 
extern void booleanExpressionsIface_set_and(BooleanExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'or' that is defined in the default interface scope. */ 
extern sc_boolean booleanExpressionsIface_get_or(const BooleanExpressions* handle);
/*! Sets the value of the variable 'or' that is defined in the default interface scope. */ 
extern void booleanExpressionsIface_set_or(BooleanExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'not' that is defined in the default interface scope. */ 
extern sc_boolean booleanExpressionsIface_get_not(const BooleanExpressions* handle);
/*! Sets the value of the variable 'not' that is defined in the default interface scope. */ 
extern void booleanExpressionsIface_set_not(BooleanExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'equal' that is defined in the default interface scope. */ 
extern sc_boolean booleanExpressionsIface_get_equal(const BooleanExpressions* handle);
/*! Sets the value of the variable 'equal' that is defined in the default interface scope. */ 
extern void booleanExpressionsIface_set_equal(BooleanExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'notequal' that is defined in the default interface scope. */ 
extern sc_boolean booleanExpressionsIface_get_notequal(const BooleanExpressions* handle);
/*! Sets the value of the variable 'notequal' that is defined in the default interface scope. */ 
extern void booleanExpressionsIface_set_notequal(BooleanExpressions* handle, sc_boolean value);
/*! Raises the in event 'e1' that is defined in the default interface scope. */ 
extern void booleanExpressionsIface_raise_e1(BooleanExpressions* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean booleanExpressions_isActive(const BooleanExpressions* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean booleanExpressions_isFinal(const BooleanExpressions* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean booleanExpressions_isStateActive(const BooleanExpressions* handle, BooleanExpressionsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* BOOLEANEXPRESSIONS_H_ */
