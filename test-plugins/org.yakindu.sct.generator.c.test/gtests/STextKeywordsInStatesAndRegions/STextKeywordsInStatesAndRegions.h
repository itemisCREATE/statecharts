
#ifndef STEXTKEYWORDSINSTATESANDREGIONS_H_
#define STEXTKEYWORDSINSTATESANDREGIONS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'STextKeywordsInStatesAndRegions'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	STextKeywordsInStatesAndRegions_last_state,
	STextKeywordsInStatesAndRegions_default_namespace,
	STextKeywordsInStatesAndRegions_operation_interface,
	STextKeywordsInStatesAndRegions_operation_internal,
	STextKeywordsInStatesAndRegions_namespace_event,
	STextKeywordsInStatesAndRegions_namespace_local,
	STextKeywordsInStatesAndRegions_local_in,
	STextKeywordsInStatesAndRegions_local_out,
	STextKeywordsInStatesAndRegions_interface_var,
	STextKeywordsInStatesAndRegions_interface_readonly,
	STextKeywordsInStatesAndRegions_internal_external,
	STextKeywordsInStatesAndRegions_internal_operation,
	STextKeywordsInStatesAndRegions_event_default,
	STextKeywordsInStatesAndRegions_event_else,
	STextKeywordsInStatesAndRegions_in_entry,
	STextKeywordsInStatesAndRegions_in_exit,
	STextKeywordsInStatesAndRegions_out_always,
	STextKeywordsInStatesAndRegions_out_oncycle,
	STextKeywordsInStatesAndRegions_var_raise,
	STextKeywordsInStatesAndRegions_var_valueof,
	STextKeywordsInStatesAndRegions_readonly_active,
	STextKeywordsInStatesAndRegions_readonly_namespace,
	STextKeywordsInStatesAndRegions_external_interface,
	STextKeywordsInStatesAndRegions_external_internal,
	STextKeywordsInStatesAndRegions_else_event,
	STextKeywordsInStatesAndRegions_else_local,
	STextKeywordsInStatesAndRegions_entry_in,
	STextKeywordsInStatesAndRegions_entry_out,
	STextKeywordsInStatesAndRegions_exit_var,
	STextKeywordsInStatesAndRegions_exit_readonly,
	STextKeywordsInStatesAndRegions_always_external,
	STextKeywordsInStatesAndRegions_always_operation,
	STextKeywordsInStatesAndRegions_oncycle_default,
	STextKeywordsInStatesAndRegions_oncycle_else,
	STextKeywordsInStatesAndRegions_raise_entry,
	STextKeywordsInStatesAndRegions_raise_exit,
	STextKeywordsInStatesAndRegions_valueof_always,
	STextKeywordsInStatesAndRegions_valueof_oncycle,
	STextKeywordsInStatesAndRegions_active_raise,
	STextKeywordsInStatesAndRegions_active_valueof
} STextKeywordsInStatesAndRegionsStates;

/*! Type definition of the data structure for the STextKeywordsInStatesAndRegionsIface interface scope. */
typedef struct
{
	sc_boolean e1_raised;
	sc_boolean e2_raised;
} STextKeywordsInStatesAndRegionsIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define STEXTKEYWORDSINSTATESANDREGIONS_MAX_ORTHOGONAL_STATES 20

/*! Define indices of states in the StateConfVector */
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_DEFAULT_NAMESPACE 0
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_OPERATION_INTERFACE 1
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_OPERATION_INTERNAL 1
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_NAMESPACE_EVENT 2
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_NAMESPACE_LOCAL 2
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_LOCAL_IN 3
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_LOCAL_OUT 3
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_INTERFACE_VAR 4
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_INTERFACE_READONLY 4
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_INTERNAL_EXTERNAL 5
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_INTERNAL_OPERATION 5
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_EVENT_DEFAULT 6
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_EVENT_ELSE 6
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_IN_ENTRY 7
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_IN_EXIT 7
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_OUT_ALWAYS 8
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_OUT_ONCYCLE 8
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_VAR_RAISE 9
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_VAR_VALUEOF 9
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_READONLY_ACTIVE 10
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_READONLY_NAMESPACE 10
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_EXTERNAL_INTERFACE 11
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_EXTERNAL_INTERNAL 11
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_ELSE_EVENT 12
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_ELSE_LOCAL 12
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_ENTRY_IN 13
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_ENTRY_OUT 13
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_EXIT_VAR 14
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_EXIT_READONLY 14
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_ALWAYS_EXTERNAL 15
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_ALWAYS_OPERATION 15
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_ONCYCLE_DEFAULT 16
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_ONCYCLE_ELSE 16
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_RAISE_ENTRY 17
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_RAISE_EXIT 17
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_VALUEOF_ALWAYS 18
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_VALUEOF_ONCYCLE 18
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_ACTIVE_RAISE 19
#define SCVI_STEXTKEYWORDSINSTATESANDREGIONS_ACTIVE_VALUEOF 19

/*! 
 * Type definition of the data structure for the STextKeywordsInStatesAndRegions state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	STextKeywordsInStatesAndRegionsStates stateConfVector[STEXTKEYWORDSINSTATESANDREGIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	STextKeywordsInStatesAndRegionsIface iface;
} STextKeywordsInStatesAndRegions;

/*! Initializes the STextKeywordsInStatesAndRegions state machine data structures. Must be called before first usage.*/
extern void sTextKeywordsInStatesAndRegions_init(STextKeywordsInStatesAndRegions* handle);

/*! Activates the state machine */
extern void sTextKeywordsInStatesAndRegions_enter(STextKeywordsInStatesAndRegions* handle);

/*! Deactivates the state machine */
extern void sTextKeywordsInStatesAndRegions_exit(STextKeywordsInStatesAndRegions* handle);

/*! Performs a 'run to completion' step. */
extern void sTextKeywordsInStatesAndRegions_runCycle(STextKeywordsInStatesAndRegions* handle);


/*! Raises the in event 'e1' that is defined in the default interface scope. */ 
extern void sTextKeywordsInStatesAndRegionsIface_raise_e1(STextKeywordsInStatesAndRegions* handle);

/*! Raises the in event 'e2' that is defined in the default interface scope. */ 
extern void sTextKeywordsInStatesAndRegionsIface_raise_e2(STextKeywordsInStatesAndRegions* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean sTextKeywordsInStatesAndRegions_isActive(const STextKeywordsInStatesAndRegions* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean sTextKeywordsInStatesAndRegions_isFinal(const STextKeywordsInStatesAndRegions* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean sTextKeywordsInStatesAndRegions_isStateActive(const STextKeywordsInStatesAndRegions* handle, STextKeywordsInStatesAndRegionsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* STEXTKEYWORDSINSTATESANDREGIONS_H_ */
