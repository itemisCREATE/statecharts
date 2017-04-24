
#ifndef CONSTONLYNAMEDSCOPE_H_
#define CONSTONLYNAMEDSCOPE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'ConstOnlyNamedScope'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_A,
	ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_B,
	ConstOnlyNamedScope_ConstOnlyNamedScope_main_region_C,
	ConstOnlyNamedScope_last_state
} ConstOnlyNamedScopeStates;

/*! Type definition of the data structure for the ConstOnlyNamedScopeIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_integer e_value;
} ConstOnlyNamedScopeIface;

/* Declaration of constants for scope ConstOnlyNamedScopeIfaceA. */
extern const sc_integer CONSTONLYNAMEDSCOPE_CONSTONLYNAMEDSCOPEIFACEA_B;
extern const sc_integer CONSTONLYNAMEDSCOPE_CONSTONLYNAMEDSCOPEIFACEA_C;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define CONSTONLYNAMEDSCOPE_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the ConstOnlyNamedScope state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	ConstOnlyNamedScopeStates stateConfVector[CONSTONLYNAMEDSCOPE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	ConstOnlyNamedScopeIface iface;
} ConstOnlyNamedScope;

/*! Initializes the ConstOnlyNamedScope state machine data structures. Must be called before first usage.*/
extern void constOnlyNamedScope_init(ConstOnlyNamedScope* handle);

/*! Activates the state machine */
extern void constOnlyNamedScope_enter(ConstOnlyNamedScope* handle);

/*! Deactivates the state machine */
extern void constOnlyNamedScope_exit(ConstOnlyNamedScope* handle);

/*! Performs a 'run to completion' step. */
extern void constOnlyNamedScope_runCycle(ConstOnlyNamedScope* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void constOnlyNamedScopeIface_raise_e(ConstOnlyNamedScope* handle, sc_integer value);

/*! Gets the value of the variable 'B' that is defined in the interface scope 'A'. */ 
extern const sc_integer constOnlyNamedScopeIfaceA_get_b(const ConstOnlyNamedScope* handle);
/*! Gets the value of the variable 'C' that is defined in the interface scope 'A'. */ 
extern const sc_integer constOnlyNamedScopeIfaceA_get_c(const ConstOnlyNamedScope* handle);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean constOnlyNamedScope_isActive(const ConstOnlyNamedScope* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean constOnlyNamedScope_isFinal(const ConstOnlyNamedScope* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean constOnlyNamedScope_isStateActive(const ConstOnlyNamedScope* handle, ConstOnlyNamedScopeStates state);

#ifdef __cplusplus
}
#endif 

#endif /* CONSTONLYNAMEDSCOPE_H_ */
