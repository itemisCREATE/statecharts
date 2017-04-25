
#ifndef VARIADICFUNCTIONSREQUIRED_H_
#define VARIADICFUNCTIONSREQUIRED_H_

#include "sc_types.h"
#include "VariadicFunctions.h"

#ifdef __cplusplus
extern "C"
{
#endif 

/*! \file This header defines prototypes for all functions that are required by the state machine implementation.

This state machine makes use of operations declared in the state machines interface or internal scopes. Thus the function prototypes:
	- variadicFunctionsIface_myVarOperation
	- variadicFunctionsIfaceIF2_myVarOperation2
	- variadicFunctionsInternal_myInternalVarOperation
are defined.

These functions will be called during a 'run to completion step' (runCycle) of the statechart. 
There are some constraints that have to be considered for the implementation of these functions:
	- never call the statechart API functions from within these functions.
	- make sure that the execution time is as short as possible.
 
*/
extern void variadicFunctionsIface_myVarOperation(const VariadicFunctions* handle, ...);

extern void variadicFunctionsIfaceIF2_myVarOperation2(const VariadicFunctions* handle, const sc_integer argCount, ...);

extern sc_integer variadicFunctionsInternal_myInternalVarOperation(const VariadicFunctions* handle, ...);




#ifdef __cplusplus
}
#endif 

#endif /* VARIADICFUNCTIONSREQUIRED_H_ */
