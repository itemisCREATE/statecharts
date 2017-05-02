
#ifndef SIMPLEHIERACHY_H_
#define SIMPLEHIERACHY_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'SimpleHierachy'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	SimpleHierachy_main_region_A,
	SimpleHierachy_main_region_B,
	SimpleHierachy_main_region_B_subregion1_B1,
	SimpleHierachy_last_state
} SimpleHierachyStates;

/*! Type definition of the data structure for the SimpleHierachyIface interface scope. */
typedef struct
{
	sc_boolean Event1_raised;
} SimpleHierachyIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define SIMPLEHIERACHY_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the SimpleHierachy state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	SimpleHierachyStates stateConfVector[SIMPLEHIERACHY_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	SimpleHierachyIface iface;
} SimpleHierachy;

/*! Initializes the SimpleHierachy state machine data structures. Must be called before first usage.*/
extern void simpleHierachy_init(SimpleHierachy* handle);

/*! Activates the state machine */
extern void simpleHierachy_enter(SimpleHierachy* handle);

/*! Deactivates the state machine */
extern void simpleHierachy_exit(SimpleHierachy* handle);

/*! Performs a 'run to completion' step. */
extern void simpleHierachy_runCycle(SimpleHierachy* handle);


/*! Raises the in event 'Event1' that is defined in the default interface scope. */ 
extern void simpleHierachyIface_raise_event1(SimpleHierachy* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean simpleHierachy_isActive(const SimpleHierachy* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean simpleHierachy_isFinal(const SimpleHierachy* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean simpleHierachy_isStateActive(const SimpleHierachy* handle, SimpleHierachyStates state);

#ifdef __cplusplus
}
#endif 

#endif /* SIMPLEHIERACHY_H_ */
