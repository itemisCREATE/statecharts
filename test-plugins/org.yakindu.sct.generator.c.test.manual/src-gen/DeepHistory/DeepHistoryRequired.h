#ifndef DEEPHISTORYREQUIRED_H_
#define DEEPHISTORYREQUIRED_H_

#include "sc_types.h"

#ifdef __cplusplus
extern "C" {
#endif 



/*! \file This header defines prototypes for all functions that are required by the state machine implementation.


		
These functions will be called during a 'run to completion step' (runCycle) of the statechart. 
There are some constraints that have to be considered for the implementation of these functions:
	- never call the statechart API functions from within these functions.
	- make sure that the execution time is as short as possible.
 
*/




#ifdef __cplusplus
}
#endif 

#endif /* DEEPHISTORYREQUIRED_H_ */
