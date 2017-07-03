
#ifndef STATECHARTKEYWORDS_H_
#define STATECHARTKEYWORDS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'StatechartKeywords'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	StatechartKeywords_last_state,
	StatechartKeywords_main_region_Timer
} StatechartKeywordsStates;

/*! Type definition of the data structure for the StatechartKeywordsIfaceIf interface scope. */
typedef struct
{
	sc_integer timer;
	sc_integer isActive;
	sc_integer init;
	sc_integer enter;
	sc_integer runCycle;
	sc_boolean operationCallback_raised;
	sc_boolean listeners_raised;
} StatechartKeywordsIfaceIf;

/*! Type definition of the data structure for the StatechartKeywordsInternal interface scope. */
typedef struct
{
	sc_integer timer;
	sc_integer isActive;
	sc_integer init;
	sc_integer enter;
	sc_integer runCycle;
	sc_integer sCIIf;
	sc_boolean operationCallback_raised;
	sc_boolean listeners_raised;
} StatechartKeywordsInternal;

/*! Type definition of the data structure for the StatechartKeywordsTimeEvents interface scope. */
typedef struct
{
	sc_boolean statechartKeywords_tev0_raised;
} StatechartKeywordsTimeEvents;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define STATECHARTKEYWORDS_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_STATECHARTKEYWORDS_MAIN_REGION_TIMER 0

/*! 
 * Type definition of the data structure for the StatechartKeywords state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	StatechartKeywordsStates stateConfVector[STATECHARTKEYWORDS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	StatechartKeywordsIfaceIf ifaceIf;
	StatechartKeywordsInternal internal;
	StatechartKeywordsTimeEvents timeEvents;
} StatechartKeywords;

/*! Initializes the StatechartKeywords state machine data structures. Must be called before first usage.*/
extern void statechartKeywords_init(StatechartKeywords* handle);

/*! Activates the state machine */
extern void statechartKeywords_enter(StatechartKeywords* handle);

/*! Deactivates the state machine */
extern void statechartKeywords_exit(StatechartKeywords* handle);

/*! Performs a 'run to completion' step. */
extern void statechartKeywords_runCycle(StatechartKeywords* handle);

/*! Raises a time event. */
extern void statechartKeywords_raiseTimeEvent(const StatechartKeywords* handle, sc_eventid evid);

/*! Gets the value of the variable 'timer' that is defined in the interface scope 'if'. */ 
extern sc_integer statechartKeywordsIfaceIf_get_timer(const StatechartKeywords* handle);
/*! Sets the value of the variable 'timer' that is defined in the interface scope 'if'. */ 
extern void statechartKeywordsIfaceIf_set_timer(StatechartKeywords* handle, sc_integer value);
/*! Gets the value of the variable 'isActive' that is defined in the interface scope 'if'. */ 
extern sc_integer statechartKeywordsIfaceIf_get_isActive(const StatechartKeywords* handle);
/*! Sets the value of the variable 'isActive' that is defined in the interface scope 'if'. */ 
extern void statechartKeywordsIfaceIf_set_isActive(StatechartKeywords* handle, sc_integer value);
/*! Gets the value of the variable 'init' that is defined in the interface scope 'if'. */ 
extern sc_integer statechartKeywordsIfaceIf_get_init(const StatechartKeywords* handle);
/*! Sets the value of the variable 'init' that is defined in the interface scope 'if'. */ 
extern void statechartKeywordsIfaceIf_set_init(StatechartKeywords* handle, sc_integer value);
/*! Gets the value of the variable 'enter' that is defined in the interface scope 'if'. */ 
extern sc_integer statechartKeywordsIfaceIf_get_enter(const StatechartKeywords* handle);
/*! Sets the value of the variable 'enter' that is defined in the interface scope 'if'. */ 
extern void statechartKeywordsIfaceIf_set_enter(StatechartKeywords* handle, sc_integer value);
/*! Gets the value of the variable 'runCycle' that is defined in the interface scope 'if'. */ 
extern sc_integer statechartKeywordsIfaceIf_get_runCycle(const StatechartKeywords* handle);
/*! Sets the value of the variable 'runCycle' that is defined in the interface scope 'if'. */ 
extern void statechartKeywordsIfaceIf_set_runCycle(StatechartKeywords* handle, sc_integer value);
/*! Checks if the out event 'operationCallback' that is defined in the interface scope 'if' has been raised. */ 
extern sc_boolean statechartKeywordsIfaceIf_israised_operationCallback(const StatechartKeywords* handle);

/*! Checks if the out event 'listeners' that is defined in the interface scope 'if' has been raised. */ 
extern sc_boolean statechartKeywordsIfaceIf_israised_listeners(const StatechartKeywords* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean statechartKeywords_isActive(const StatechartKeywords* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean statechartKeywords_isFinal(const StatechartKeywords* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean statechartKeywords_isStateActive(const StatechartKeywords* handle, StatechartKeywordsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* STATECHARTKEYWORDS_H_ */
