
#ifndef INTEGEREXPRESSIONS_H_
#define INTEGEREXPRESSIONS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'IntegerExpressions'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	IntegerExpressions_main_region_StateA,
	IntegerExpressions_main_region_StateB,
	IntegerExpressions_last_state
} IntegerExpressionsStates;

/*! Type definition of the data structure for the IntegerExpressionsIface interface scope. */
typedef struct
{
	sc_integer myInt1;
	sc_integer myInt2;
	sc_boolean less;
	sc_boolean greater;
	sc_boolean equalOrLess;
	sc_boolean equalOrGreater;
	sc_boolean equal;
	sc_boolean notEqual;
	sc_integer plus;
	sc_integer minus;
	sc_integer multiply;
	sc_integer division;
	sc_integer modulo;
	sc_integer negat;
	sc_boolean complement;
	sc_integer multiAssign;
	sc_integer divAssign;
	sc_integer plusAssign;
	sc_integer minusAssign;
	sc_integer moduloAssign;
	sc_boolean e1_raised;
} IntegerExpressionsIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define INTEGEREXPRESSIONS_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the IntegerExpressions state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	IntegerExpressionsStates stateConfVector[INTEGEREXPRESSIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	IntegerExpressionsIface iface;
} IntegerExpressions;

/*! Initializes the IntegerExpressions state machine data structures. Must be called before first usage.*/
extern void integerExpressions_init(IntegerExpressions* handle);

/*! Activates the state machine */
extern void integerExpressions_enter(IntegerExpressions* handle);

/*! Deactivates the state machine */
extern void integerExpressions_exit(IntegerExpressions* handle);

/*! Performs a 'run to completion' step. */
extern void integerExpressions_runCycle(IntegerExpressions* handle);


/*! Gets the value of the variable 'myInt1' that is defined in the default interface scope. */ 
extern sc_integer integerExpressionsIface_get_myInt1(const IntegerExpressions* handle);
/*! Sets the value of the variable 'myInt1' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_myInt1(IntegerExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'myInt2' that is defined in the default interface scope. */ 
extern sc_integer integerExpressionsIface_get_myInt2(const IntegerExpressions* handle);
/*! Sets the value of the variable 'myInt2' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_myInt2(IntegerExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'less' that is defined in the default interface scope. */ 
extern sc_boolean integerExpressionsIface_get_less(const IntegerExpressions* handle);
/*! Sets the value of the variable 'less' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_less(IntegerExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'greater' that is defined in the default interface scope. */ 
extern sc_boolean integerExpressionsIface_get_greater(const IntegerExpressions* handle);
/*! Sets the value of the variable 'greater' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_greater(IntegerExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'equalOrLess' that is defined in the default interface scope. */ 
extern sc_boolean integerExpressionsIface_get_equalOrLess(const IntegerExpressions* handle);
/*! Sets the value of the variable 'equalOrLess' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_equalOrLess(IntegerExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'equalOrGreater' that is defined in the default interface scope. */ 
extern sc_boolean integerExpressionsIface_get_equalOrGreater(const IntegerExpressions* handle);
/*! Sets the value of the variable 'equalOrGreater' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_equalOrGreater(IntegerExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'equal' that is defined in the default interface scope. */ 
extern sc_boolean integerExpressionsIface_get_equal(const IntegerExpressions* handle);
/*! Sets the value of the variable 'equal' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_equal(IntegerExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'notEqual' that is defined in the default interface scope. */ 
extern sc_boolean integerExpressionsIface_get_notEqual(const IntegerExpressions* handle);
/*! Sets the value of the variable 'notEqual' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_notEqual(IntegerExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'plus' that is defined in the default interface scope. */ 
extern sc_integer integerExpressionsIface_get_plus(const IntegerExpressions* handle);
/*! Sets the value of the variable 'plus' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_plus(IntegerExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'minus' that is defined in the default interface scope. */ 
extern sc_integer integerExpressionsIface_get_minus(const IntegerExpressions* handle);
/*! Sets the value of the variable 'minus' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_minus(IntegerExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'multiply' that is defined in the default interface scope. */ 
extern sc_integer integerExpressionsIface_get_multiply(const IntegerExpressions* handle);
/*! Sets the value of the variable 'multiply' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_multiply(IntegerExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'division' that is defined in the default interface scope. */ 
extern sc_integer integerExpressionsIface_get_division(const IntegerExpressions* handle);
/*! Sets the value of the variable 'division' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_division(IntegerExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'modulo' that is defined in the default interface scope. */ 
extern sc_integer integerExpressionsIface_get_modulo(const IntegerExpressions* handle);
/*! Sets the value of the variable 'modulo' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_modulo(IntegerExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'negat' that is defined in the default interface scope. */ 
extern sc_integer integerExpressionsIface_get_negat(const IntegerExpressions* handle);
/*! Sets the value of the variable 'negat' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_negat(IntegerExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'complement' that is defined in the default interface scope. */ 
extern sc_boolean integerExpressionsIface_get_complement(const IntegerExpressions* handle);
/*! Sets the value of the variable 'complement' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_complement(IntegerExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'multiAssign' that is defined in the default interface scope. */ 
extern sc_integer integerExpressionsIface_get_multiAssign(const IntegerExpressions* handle);
/*! Sets the value of the variable 'multiAssign' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_multiAssign(IntegerExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'divAssign' that is defined in the default interface scope. */ 
extern sc_integer integerExpressionsIface_get_divAssign(const IntegerExpressions* handle);
/*! Sets the value of the variable 'divAssign' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_divAssign(IntegerExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'plusAssign' that is defined in the default interface scope. */ 
extern sc_integer integerExpressionsIface_get_plusAssign(const IntegerExpressions* handle);
/*! Sets the value of the variable 'plusAssign' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_plusAssign(IntegerExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'minusAssign' that is defined in the default interface scope. */ 
extern sc_integer integerExpressionsIface_get_minusAssign(const IntegerExpressions* handle);
/*! Sets the value of the variable 'minusAssign' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_minusAssign(IntegerExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'moduloAssign' that is defined in the default interface scope. */ 
extern sc_integer integerExpressionsIface_get_moduloAssign(const IntegerExpressions* handle);
/*! Sets the value of the variable 'moduloAssign' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_set_moduloAssign(IntegerExpressions* handle, sc_integer value);
/*! Raises the in event 'e1' that is defined in the default interface scope. */ 
extern void integerExpressionsIface_raise_e1(IntegerExpressions* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean integerExpressions_isActive(const IntegerExpressions* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean integerExpressions_isFinal(const IntegerExpressions* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean integerExpressions_isStateActive(const IntegerExpressions* handle, IntegerExpressionsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* INTEGEREXPRESSIONS_H_ */
