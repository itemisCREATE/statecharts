
#ifndef CONSTONLYINTERNALSCOPE_H_
#define CONSTONLYINTERNALSCOPE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'ConstOnlyInternalScope'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_A,
	ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_B,
	ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_C,
	ConstOnlyInternalScope_last_state
} ConstOnlyInternalScopeStates;

/*! Type definition of the data structure for the ConstOnlyInternalScopeIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_integer e_value;
} ConstOnlyInternalScopeIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define CONSTONLYINTERNALSCOPE_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the ConstOnlyInternalScope state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	ConstOnlyInternalScopeStates stateConfVector[CONSTONLYINTERNALSCOPE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	ConstOnlyInternalScopeIface iface;
} ConstOnlyInternalScope;

/*! Initializes the ConstOnlyInternalScope state machine data structures. Must be called before first usage.*/
extern void constOnlyInternalScope_init(ConstOnlyInternalScope* handle);

/*! Activates the state machine */
extern void constOnlyInternalScope_enter(ConstOnlyInternalScope* handle);

/*! Deactivates the state machine */
extern void constOnlyInternalScope_exit(ConstOnlyInternalScope* handle);

/*! Performs a 'run to completion' step. */
extern void constOnlyInternalScope_runCycle(ConstOnlyInternalScope* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void constOnlyInternalScopeIface_raise_e(ConstOnlyInternalScope* handle, sc_integer value);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean constOnlyInternalScope_isActive(const ConstOnlyInternalScope* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean constOnlyInternalScope_isFinal(const ConstOnlyInternalScope* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean constOnlyInternalScope_isStateActive(const ConstOnlyInternalScope* handle, ConstOnlyInternalScopeStates state);

#ifdef __cplusplus
}
#endif 

#endif /* CONSTONLYINTERNALSCOPE_H_ */
