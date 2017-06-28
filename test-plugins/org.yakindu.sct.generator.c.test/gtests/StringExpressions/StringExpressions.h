
#ifndef STRINGEXPRESSIONS_H_
#define STRINGEXPRESSIONS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'StringExpressions'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	StringExpressions_last_state,
	StringExpressions_AssignmentChecked,
	StringExpressions_Failed,
	StringExpressions_VarToVarCompareSucceeded,
	StringExpressions_VarToConstCompareSucceeded,
	StringExpressions_ConstToVarCompareSucceeded,
	StringExpressions_ConstToConstCompareSucceeded
} StringExpressionsStates;

/*! Type definition of the data structure for the StringExpressionsIface interface scope. */
typedef struct
{
	sc_string stringA;
	sc_string stringA2;
	sc_string stringB;
	sc_string quotedStringX;
	sc_string quotedStringY;
	sc_boolean stringVarEqual;
	sc_boolean stringVarNotEqual;
	sc_boolean guardStringNotEqual;
	sc_boolean guardStringEqual;
	sc_boolean e_raised;
} StringExpressionsIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define STRINGEXPRESSIONS_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_STRINGEXPRESSIONS_ASSIGNMENTCHECKED 0
#define SCVI_STRINGEXPRESSIONS_FAILED 0
#define SCVI_STRINGEXPRESSIONS_VARTOVARCOMPARESUCCEEDED 0
#define SCVI_STRINGEXPRESSIONS_VARTOCONSTCOMPARESUCCEEDED 0
#define SCVI_STRINGEXPRESSIONS_CONSTTOVARCOMPARESUCCEEDED 0
#define SCVI_STRINGEXPRESSIONS_CONSTTOCONSTCOMPARESUCCEEDED 0

/*! 
 * Type definition of the data structure for the StringExpressions state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	StringExpressionsStates stateConfVector[STRINGEXPRESSIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	StringExpressionsIface iface;
} StringExpressions;

/*! Initializes the StringExpressions state machine data structures. Must be called before first usage.*/
extern void stringExpressions_init(StringExpressions* handle);

/*! Activates the state machine */
extern void stringExpressions_enter(StringExpressions* handle);

/*! Deactivates the state machine */
extern void stringExpressions_exit(StringExpressions* handle);

/*! Performs a 'run to completion' step. */
extern void stringExpressions_runCycle(StringExpressions* handle);


/*! Gets the value of the variable 'stringA' that is defined in the default interface scope. */ 
extern sc_string stringExpressionsIface_get_stringA(const StringExpressions* handle);
/*! Sets the value of the variable 'stringA' that is defined in the default interface scope. */ 
extern void stringExpressionsIface_set_stringA(StringExpressions* handle, sc_string value);
/*! Gets the value of the variable 'stringA2' that is defined in the default interface scope. */ 
extern sc_string stringExpressionsIface_get_stringA2(const StringExpressions* handle);
/*! Sets the value of the variable 'stringA2' that is defined in the default interface scope. */ 
extern void stringExpressionsIface_set_stringA2(StringExpressions* handle, sc_string value);
/*! Gets the value of the variable 'stringB' that is defined in the default interface scope. */ 
extern sc_string stringExpressionsIface_get_stringB(const StringExpressions* handle);
/*! Sets the value of the variable 'stringB' that is defined in the default interface scope. */ 
extern void stringExpressionsIface_set_stringB(StringExpressions* handle, sc_string value);
/*! Gets the value of the variable 'quotedStringX' that is defined in the default interface scope. */ 
extern sc_string stringExpressionsIface_get_quotedStringX(const StringExpressions* handle);
/*! Sets the value of the variable 'quotedStringX' that is defined in the default interface scope. */ 
extern void stringExpressionsIface_set_quotedStringX(StringExpressions* handle, sc_string value);
/*! Gets the value of the variable 'quotedStringY' that is defined in the default interface scope. */ 
extern sc_string stringExpressionsIface_get_quotedStringY(const StringExpressions* handle);
/*! Sets the value of the variable 'quotedStringY' that is defined in the default interface scope. */ 
extern void stringExpressionsIface_set_quotedStringY(StringExpressions* handle, sc_string value);
/*! Gets the value of the variable 'stringVarEqual' that is defined in the default interface scope. */ 
extern sc_boolean stringExpressionsIface_get_stringVarEqual(const StringExpressions* handle);
/*! Sets the value of the variable 'stringVarEqual' that is defined in the default interface scope. */ 
extern void stringExpressionsIface_set_stringVarEqual(StringExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'stringVarNotEqual' that is defined in the default interface scope. */ 
extern sc_boolean stringExpressionsIface_get_stringVarNotEqual(const StringExpressions* handle);
/*! Sets the value of the variable 'stringVarNotEqual' that is defined in the default interface scope. */ 
extern void stringExpressionsIface_set_stringVarNotEqual(StringExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'guardStringNotEqual' that is defined in the default interface scope. */ 
extern sc_boolean stringExpressionsIface_get_guardStringNotEqual(const StringExpressions* handle);
/*! Sets the value of the variable 'guardStringNotEqual' that is defined in the default interface scope. */ 
extern void stringExpressionsIface_set_guardStringNotEqual(StringExpressions* handle, sc_boolean value);
/*! Gets the value of the variable 'guardStringEqual' that is defined in the default interface scope. */ 
extern sc_boolean stringExpressionsIface_get_guardStringEqual(const StringExpressions* handle);
/*! Sets the value of the variable 'guardStringEqual' that is defined in the default interface scope. */ 
extern void stringExpressionsIface_set_guardStringEqual(StringExpressions* handle, sc_boolean value);
/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void stringExpressionsIface_raise_e(StringExpressions* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean stringExpressions_isActive(const StringExpressions* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean stringExpressions_isFinal(const StringExpressions* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean stringExpressions_isStateActive(const StringExpressions* handle, StringExpressionsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* STRINGEXPRESSIONS_H_ */
