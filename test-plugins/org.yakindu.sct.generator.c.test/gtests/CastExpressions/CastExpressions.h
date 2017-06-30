
#ifndef CASTEXPRESSIONS_H_
#define CASTEXPRESSIONS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'CastExpressions'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	CastExpressions_last_state,
	CastExpressions_main_region_A,
	CastExpressions_main_region_B,
	CastExpressions_main_region_C
} CastExpressionsStates;

/*! Type definition of the data structure for the CastExpressionsIface interface scope. */
typedef struct
{
	sc_real realValue;
	sc_integer intValue;
} CastExpressionsIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define CASTEXPRESSIONS_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_CASTEXPRESSIONS_MAIN_REGION_A 0
#define SCVI_CASTEXPRESSIONS_MAIN_REGION_B 0
#define SCVI_CASTEXPRESSIONS_MAIN_REGION_C 0

/*! 
 * Type definition of the data structure for the CastExpressions state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	CastExpressionsStates stateConfVector[CASTEXPRESSIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	CastExpressionsIface iface;
} CastExpressions;

/*! Initializes the CastExpressions state machine data structures. Must be called before first usage.*/
extern void castExpressions_init(CastExpressions* handle);

/*! Activates the state machine */
extern void castExpressions_enter(CastExpressions* handle);

/*! Deactivates the state machine */
extern void castExpressions_exit(CastExpressions* handle);

/*! Performs a 'run to completion' step. */
extern void castExpressions_runCycle(CastExpressions* handle);


/*! Gets the value of the variable 'realValue' that is defined in the default interface scope. */ 
extern sc_real castExpressionsIface_get_realValue(const CastExpressions* handle);
/*! Sets the value of the variable 'realValue' that is defined in the default interface scope. */ 
extern void castExpressionsIface_set_realValue(CastExpressions* handle, sc_real value);
/*! Gets the value of the variable 'intValue' that is defined in the default interface scope. */ 
extern sc_integer castExpressionsIface_get_intValue(const CastExpressions* handle);
/*! Sets the value of the variable 'intValue' that is defined in the default interface scope. */ 
extern void castExpressionsIface_set_intValue(CastExpressions* handle, sc_integer value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean castExpressions_isActive(const CastExpressions* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean castExpressions_isFinal(const CastExpressions* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean castExpressions_isStateActive(const CastExpressions* handle, CastExpressionsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* CASTEXPRESSIONS_H_ */
