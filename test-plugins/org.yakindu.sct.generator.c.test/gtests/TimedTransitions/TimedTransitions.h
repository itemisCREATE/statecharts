
#ifndef TIMEDTRANSITIONS_H_
#define TIMEDTRANSITIONS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'TimedTransitions'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	TimedTransitions_last_state,
	TimedTransitions_main_region_Start,
	TimedTransitions_main_region_End
} TimedTransitionsStates;

/*! Type definition of the data structure for the TimedTransitionsInternal interface scope. */
typedef struct
{
	sc_integer x;
	sc_integer y;
} TimedTransitionsInternal;

/*! Type definition of the data structure for the TimedTransitionsTimeEvents interface scope. */
typedef struct
{
	sc_boolean timedTransitions_main_region_Start_tev0_raised;
	sc_boolean timedTransitions_tev0_raised;
} TimedTransitionsTimeEvents;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define TIMEDTRANSITIONS_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_TIMEDTRANSITIONS_MAIN_REGION_START 0
#define SCVI_TIMEDTRANSITIONS_MAIN_REGION_END 0

/*! 
 * Type definition of the data structure for the TimedTransitions state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	TimedTransitionsStates stateConfVector[TIMEDTRANSITIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	TimedTransitionsInternal internal;
	TimedTransitionsTimeEvents timeEvents;
} TimedTransitions;

/*! Initializes the TimedTransitions state machine data structures. Must be called before first usage.*/
extern void timedTransitions_init(TimedTransitions* handle);

/*! Activates the state machine */
extern void timedTransitions_enter(TimedTransitions* handle);

/*! Deactivates the state machine */
extern void timedTransitions_exit(TimedTransitions* handle);

/*! Performs a 'run to completion' step. */
extern void timedTransitions_runCycle(TimedTransitions* handle);

/*! Raises a time event. */
extern void timedTransitions_raiseTimeEvent(const TimedTransitions* handle, sc_eventid evid);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean timedTransitions_isActive(const TimedTransitions* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean timedTransitions_isFinal(const TimedTransitions* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean timedTransitions_isStateActive(const TimedTransitions* handle, TimedTransitionsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* TIMEDTRANSITIONS_H_ */
