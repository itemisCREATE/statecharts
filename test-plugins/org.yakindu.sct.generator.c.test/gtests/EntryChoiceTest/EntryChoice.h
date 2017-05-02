
#ifndef ENTRYCHOICE_H_
#define ENTRYCHOICE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'EntryChoice'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	EntryChoice_main_region_A,
	EntryChoice_last_state
} EntryChoiceStates;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define ENTRYCHOICE_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the EntryChoice state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	EntryChoiceStates stateConfVector[ENTRYCHOICE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
} EntryChoice;

/*! Initializes the EntryChoice state machine data structures. Must be called before first usage.*/
extern void entryChoice_init(EntryChoice* handle);

/*! Activates the state machine */
extern void entryChoice_enter(EntryChoice* handle);

/*! Deactivates the state machine */
extern void entryChoice_exit(EntryChoice* handle);

/*! Performs a 'run to completion' step. */
extern void entryChoice_runCycle(EntryChoice* handle);



/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean entryChoice_isActive(const EntryChoice* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean entryChoice_isFinal(const EntryChoice* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean entryChoice_isStateActive(const EntryChoice* handle, EntryChoiceStates state);

#ifdef __cplusplus
}
#endif 

#endif /* ENTRYCHOICE_H_ */
