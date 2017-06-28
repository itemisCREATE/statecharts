
#ifndef DEEPHISTORY_H_
#define DEEPHISTORY_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'DeepHistory'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	DeepHistory_last_state,
	DeepHistory_mainRegion_State1,
	DeepHistory_mainRegion_State2,
	DeepHistory_mainRegion_State2__region0_a,
	DeepHistory_mainRegion_State2__region0_State4,
	DeepHistory_mainRegion_State2__region0_State4__region0_State6,
	DeepHistory_mainRegion_State2__region0_State4__region0_State7,
	DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8,
	DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9,
	DeepHistory_mainRegion_State2__region0_State5
} DeepHistoryStates;

/*! Type definition of the data structure for the DeepHistoryIface interface scope. */
typedef struct
{
	sc_boolean event1_raised;
	sc_boolean event2_raised;
	sc_boolean event3_raised;
	sc_boolean event4_raised;
	sc_boolean event5_raised;
	sc_boolean event6_raised;
	sc_boolean event7_raised;
	sc_boolean event8_raised;
	sc_boolean event9_raised;
} DeepHistoryIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define DEEPHISTORY_MAX_ORTHOGONAL_STATES 1
	/*! Define dimension of the state configuration vector for history states. */
#define DEEPHISTORY_MAX_HISTORY_STATES 3

/*! Define indices of states in the StateConfVector */
#define SCVI_DEEPHISTORY_MAINREGION_STATE1 0
#define SCVI_DEEPHISTORY_MAINREGION_STATE2 0
#define SCVI_DEEPHISTORY_MAINREGION_STATE2__REGION0_A 0
#define SCVI_DEEPHISTORY_MAINREGION_STATE2__REGION0_STATE4 0
#define SCVI_DEEPHISTORY_MAINREGION_STATE2__REGION0_STATE4__REGION0_STATE6 0
#define SCVI_DEEPHISTORY_MAINREGION_STATE2__REGION0_STATE4__REGION0_STATE7 0
#define SCVI_DEEPHISTORY_MAINREGION_STATE2__REGION0_STATE4__REGION0_STATE7__REGION0_STATE8 0
#define SCVI_DEEPHISTORY_MAINREGION_STATE2__REGION0_STATE4__REGION0_STATE7__REGION0_STATE9 0
#define SCVI_DEEPHISTORY_MAINREGION_STATE2__REGION0_STATE5 0

/*! 
 * Type definition of the data structure for the DeepHistory state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	DeepHistoryStates stateConfVector[DEEPHISTORY_MAX_ORTHOGONAL_STATES];
	DeepHistoryStates historyVector[DEEPHISTORY_MAX_HISTORY_STATES];
	sc_ushort stateConfVectorPosition; 
	
	DeepHistoryIface iface;
} DeepHistory;

/*! Initializes the DeepHistory state machine data structures. Must be called before first usage.*/
extern void deepHistory_init(DeepHistory* handle);

/*! Activates the state machine */
extern void deepHistory_enter(DeepHistory* handle);

/*! Deactivates the state machine */
extern void deepHistory_exit(DeepHistory* handle);

/*! Performs a 'run to completion' step. */
extern void deepHistory_runCycle(DeepHistory* handle);


/*! Raises the in event 'event1' that is defined in the default interface scope. */ 
extern void deepHistoryIface_raise_event1(DeepHistory* handle);

/*! Raises the in event 'event2' that is defined in the default interface scope. */ 
extern void deepHistoryIface_raise_event2(DeepHistory* handle);

/*! Raises the in event 'event3' that is defined in the default interface scope. */ 
extern void deepHistoryIface_raise_event3(DeepHistory* handle);

/*! Raises the in event 'event4' that is defined in the default interface scope. */ 
extern void deepHistoryIface_raise_event4(DeepHistory* handle);

/*! Raises the in event 'event5' that is defined in the default interface scope. */ 
extern void deepHistoryIface_raise_event5(DeepHistory* handle);

/*! Raises the in event 'event6' that is defined in the default interface scope. */ 
extern void deepHistoryIface_raise_event6(DeepHistory* handle);

/*! Raises the in event 'event7' that is defined in the default interface scope. */ 
extern void deepHistoryIface_raise_event7(DeepHistory* handle);

/*! Raises the in event 'event8' that is defined in the default interface scope. */ 
extern void deepHistoryIface_raise_event8(DeepHistory* handle);

/*! Raises the in event 'event9' that is defined in the default interface scope. */ 
extern void deepHistoryIface_raise_event9(DeepHistory* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean deepHistory_isActive(const DeepHistory* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean deepHistory_isFinal(const DeepHistory* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean deepHistory_isStateActive(const DeepHistory* handle, DeepHistoryStates state);

#ifdef __cplusplus
}
#endif 

#endif /* DEEPHISTORY_H_ */
