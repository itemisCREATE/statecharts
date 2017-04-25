
#ifndef OPERATIONSREQUIRED_H_
#define OPERATIONSREQUIRED_H_

#include "sc_types.h"
#include "Operations.h"

#ifdef __cplusplus
extern "C"
{
#endif 

/*! \file This header defines prototypes for all functions that are required by the state machine implementation.

This state machine makes use of operations declared in the state machines interface or internal scopes. Thus the function prototypes:
	- operationsInternal_internalOperation1
	- operationsInternal_internalOperation2
	- operationsInternal_internalOperation3
	- operationsInternal_internalOperation3a
	- operationsInternal_internalOperation4
	- operationsInternal_internalOperation4a
	- operationsInternal_internalOperation5
	- operationsInternal_internalOperation5a
	- operationsIfaceInterface1_interfaceOperation1
	- operationsIfaceInterface1_interfaceOperation2
	- operationsIfaceInterface1_interfaceOperation3
	- operationsIfaceInterface1_interfaceOperation3a
	- operationsIfaceInterface1_interfaceOperation4
	- operationsIfaceInterface1_interfaceOperation4a
	- operationsIfaceInterface1_interfaceOperation5
	- operationsIfaceInterface1_interfaceOperation5a
	- operationsIface_unnamedInterfaceOperation1
	- operationsIface_unnamedInterfaceOperation2
	- operationsIface_unnamedOperation3
	- operationsIface_unnamedOperation3a
	- operationsIface_unnamedOperation4
	- operationsIface_unnamedOperation4a
	- operationsIface_unnamedOperation5
	- operationsIface_unnamedOperation5a
	- operationsIface_alwaysTrue
are defined.

These functions will be called during a 'run to completion step' (runCycle) of the statechart. 
There are some constraints that have to be considered for the implementation of these functions:
	- never call the statechart API functions from within these functions.
	- make sure that the execution time is as short as possible.
 
*/
extern void operationsInternal_internalOperation1(const Operations* handle);
extern sc_boolean operationsInternal_internalOperation2(const Operations* handle, const sc_integer param1);
extern sc_real operationsInternal_internalOperation3(const Operations* handle);
extern sc_real operationsInternal_internalOperation3a(const Operations* handle, const sc_real param1);
extern sc_integer operationsInternal_internalOperation4(const Operations* handle);
extern sc_integer operationsInternal_internalOperation4a(const Operations* handle, const sc_integer param1);
extern sc_string operationsInternal_internalOperation5(const Operations* handle);
extern sc_string operationsInternal_internalOperation5a(const Operations* handle, const sc_string param1);

extern void operationsIfaceInterface1_interfaceOperation1(const Operations* handle);
extern sc_boolean operationsIfaceInterface1_interfaceOperation2(const Operations* handle, const sc_integer param1);
extern sc_real operationsIfaceInterface1_interfaceOperation3(const Operations* handle);
extern sc_real operationsIfaceInterface1_interfaceOperation3a(const Operations* handle, const sc_real param1);
extern sc_integer operationsIfaceInterface1_interfaceOperation4(const Operations* handle);
extern sc_integer operationsIfaceInterface1_interfaceOperation4a(const Operations* handle, const sc_integer param1);
extern sc_string operationsIfaceInterface1_interfaceOperation5(const Operations* handle);
extern sc_string operationsIfaceInterface1_interfaceOperation5a(const Operations* handle, const sc_string param1);

extern void operationsIface_unnamedInterfaceOperation1(const Operations* handle);
extern sc_boolean operationsIface_unnamedInterfaceOperation2(const Operations* handle, const sc_integer param1);
extern sc_real operationsIface_unnamedOperation3(const Operations* handle);
extern sc_real operationsIface_unnamedOperation3a(const Operations* handle, const sc_real param1);
extern sc_integer operationsIface_unnamedOperation4(const Operations* handle);
extern sc_integer operationsIface_unnamedOperation4a(const Operations* handle, const sc_integer param1);
extern sc_string operationsIface_unnamedOperation5(const Operations* handle);
extern sc_string operationsIface_unnamedOperation5a(const Operations* handle, const sc_string param1);
extern sc_boolean operationsIface_alwaysTrue(const Operations* handle);




#ifdef __cplusplus
}
#endif 

#endif /* OPERATIONSREQUIRED_H_ */
