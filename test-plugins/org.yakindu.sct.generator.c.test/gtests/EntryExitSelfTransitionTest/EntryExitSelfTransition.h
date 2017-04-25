
#ifndef ENTRYEXITSELFTRANSITION_H_
#define ENTRYEXITSELFTRANSITION_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'EntryExitSelfTransition'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	EntryExitSelfTransition_main_region_A,
	EntryExitSelfTransition_main_region_A__region0_B,
	EntryExitSelfTransition_main_region_A__region0_C,
	EntryExitSelfTransition_last_state
} EntryExitSelfTransitionStates;

/*! Type definition of the data structure for the EntryExitSelfTransitionIface interface scope. */
typedef struct
{
	sc_integer exits;
	sc_integer entries;
	sc_boolean e_raised;
	sc_boolean e1_raised;
} EntryExitSelfTransitionIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define ENTRYEXITSELFTRANSITION_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the EntryExitSelfTransition state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	EntryExitSelfTransitionStates stateConfVector[ENTRYEXITSELFTRANSITION_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	EntryExitSelfTransitionIface iface;
} EntryExitSelfTransition;

/*! Initializes the EntryExitSelfTransition state machine data structures. Must be called before first usage.*/
extern void entryExitSelfTransition_init(EntryExitSelfTransition* handle);

/*! Activates the state machine */
extern void entryExitSelfTransition_enter(EntryExitSelfTransition* handle);

/*! Deactivates the state machine */
extern void entryExitSelfTransition_exit(EntryExitSelfTransition* handle);

/*! Performs a 'run to completion' step. */
extern void entryExitSelfTransition_runCycle(EntryExitSelfTransition* handle);


/*! Gets the value of the variable 'exits' that is defined in the default interface scope. */ 
extern sc_integer entryExitSelfTransitionIface_get_exits(const EntryExitSelfTransition* handle);
/*! Sets the value of the variable 'exits' that is defined in the default interface scope. */ 
extern void entryExitSelfTransitionIface_set_exits(EntryExitSelfTransition* handle, sc_integer value);
/*! Gets the value of the variable 'entries' that is defined in the default interface scope. */ 
extern sc_integer entryExitSelfTransitionIface_get_entries(const EntryExitSelfTransition* handle);
/*! Sets the value of the variable 'entries' that is defined in the default interface scope. */ 
extern void entryExitSelfTransitionIface_set_entries(EntryExitSelfTransition* handle, sc_integer value);
/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void entryExitSelfTransitionIface_raise_e(EntryExitSelfTransition* handle);

/*! Raises the in event 'e1' that is defined in the default interface scope. */ 
extern void entryExitSelfTransitionIface_raise_e1(EntryExitSelfTransition* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean entryExitSelfTransition_isActive(const EntryExitSelfTransition* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean entryExitSelfTransition_isFinal(const EntryExitSelfTransition* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean entryExitSelfTransition_isStateActive(const EntryExitSelfTransition* handle, EntryExitSelfTransitionStates state);

#ifdef __cplusplus
}
#endif 

#endif /* ENTRYEXITSELFTRANSITION_H_ */
