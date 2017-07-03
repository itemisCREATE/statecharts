
#ifndef CONSTONLYDEFAULTSCOPE_H_
#define CONSTONLYDEFAULTSCOPE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'ConstOnlyDefaultScope'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	ConstOnlyDefaultScope_last_state,
	ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_A,
	ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_B,
	ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_C
} ConstOnlyDefaultScopeStates;

/* Declaration of constants for scope ConstOnlyDefaultScopeIface. */
extern const sc_integer CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPEIFACE_B;
extern const sc_integer CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPEIFACE_C;

/*! Type definition of the data structure for the ConstOnlyDefaultScopeIfaceA interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_integer e_value;
} ConstOnlyDefaultScopeIfaceA;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define CONSTONLYDEFAULTSCOPE_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPE_MAIN_REGION_A 0
#define SCVI_CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPE_MAIN_REGION_B 0
#define SCVI_CONSTONLYDEFAULTSCOPE_CONSTONLYDEFAULTSCOPE_MAIN_REGION_C 0

/*! 
 * Type definition of the data structure for the ConstOnlyDefaultScope state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	ConstOnlyDefaultScopeStates stateConfVector[CONSTONLYDEFAULTSCOPE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	ConstOnlyDefaultScopeIfaceA ifaceA;
} ConstOnlyDefaultScope;

/*! Initializes the ConstOnlyDefaultScope state machine data structures. Must be called before first usage.*/
extern void constOnlyDefaultScope_init(ConstOnlyDefaultScope* handle);

/*! Activates the state machine */
extern void constOnlyDefaultScope_enter(ConstOnlyDefaultScope* handle);

/*! Deactivates the state machine */
extern void constOnlyDefaultScope_exit(ConstOnlyDefaultScope* handle);

/*! Performs a 'run to completion' step. */
extern void constOnlyDefaultScope_runCycle(ConstOnlyDefaultScope* handle);


/*! Gets the value of the variable 'B' that is defined in the default interface scope. */ 
extern const sc_integer constOnlyDefaultScopeIface_get_b(const ConstOnlyDefaultScope* handle);
/*! Gets the value of the variable 'C' that is defined in the default interface scope. */ 
extern const sc_integer constOnlyDefaultScopeIface_get_c(const ConstOnlyDefaultScope* handle);
/*! Raises the in event 'e' that is defined in the interface scope 'A'. */ 
extern void constOnlyDefaultScopeIfaceA_raise_e(ConstOnlyDefaultScope* handle, sc_integer value);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean constOnlyDefaultScope_isActive(const ConstOnlyDefaultScope* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean constOnlyDefaultScope_isFinal(const ConstOnlyDefaultScope* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean constOnlyDefaultScope_isStateActive(const ConstOnlyDefaultScope* handle, ConstOnlyDefaultScopeStates state);

#ifdef __cplusplus
}
#endif 

#endif /* CONSTONLYDEFAULTSCOPE_H_ */
