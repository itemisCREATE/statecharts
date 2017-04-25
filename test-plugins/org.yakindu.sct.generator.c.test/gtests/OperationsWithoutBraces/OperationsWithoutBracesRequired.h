
#ifndef OPERATIONSWITHOUTBRACESREQUIRED_H_
#define OPERATIONSWITHOUTBRACESREQUIRED_H_

#include "sc_types.h"
#include "OperationsWithoutBraces.h"

#ifdef __cplusplus
extern "C"
{
#endif 

/*! \file This header defines prototypes for all functions that are required by the state machine implementation.

This state machine makes use of operations declared in the state machines interface or internal scopes. Thus the function prototypes:
	- operationsWithoutBracesIface_myBoolOp
	- operationsWithoutBracesIface_myIntOp
	- operationsWithoutBracesIface_myRealOp
are defined.

These functions will be called during a 'run to completion step' (runCycle) of the statechart. 
There are some constraints that have to be considered for the implementation of these functions:
	- never call the statechart API functions from within these functions.
	- make sure that the execution time is as short as possible.
 
*/
extern sc_boolean operationsWithoutBracesIface_myBoolOp(const OperationsWithoutBraces* handle);
extern sc_integer operationsWithoutBracesIface_myIntOp(const OperationsWithoutBraces* handle);
extern sc_real operationsWithoutBracesIface_myRealOp(const OperationsWithoutBraces* handle);




#ifdef __cplusplus
}
#endif 

#endif /* OPERATIONSWITHOUTBRACESREQUIRED_H_ */
