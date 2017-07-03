
#ifndef HISTORYWITHEXITPOINT_H_
#define HISTORYWITHEXITPOINT_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'HistoryWithExitPoint'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	HistoryWithExitPoint_last_state,
	HistoryWithExitPoint_mr_A,
	HistoryWithExitPoint_mr_A_r_X1,
	HistoryWithExitPoint_mr_A_r_X2,
	HistoryWithExitPoint_mr_B
} HistoryWithExitPointStates;

/*! Type definition of the data structure for the HistoryWithExitPointIface interface scope. */
typedef struct
{
	sc_boolean push_raised;
	sc_boolean back_raised;
	sc_boolean next_raised;
} HistoryWithExitPointIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define HISTORYWITHEXITPOINT_MAX_ORTHOGONAL_STATES 1
	/*! Define dimension of the state configuration vector for history states. */
#define HISTORYWITHEXITPOINT_MAX_HISTORY_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_HISTORYWITHEXITPOINT_MR_A 0
#define SCVI_HISTORYWITHEXITPOINT_MR_A_R_X1 0
#define SCVI_HISTORYWITHEXITPOINT_MR_A_R_X2 0
#define SCVI_HISTORYWITHEXITPOINT_MR_B 0

/*! 
 * Type definition of the data structure for the HistoryWithExitPoint state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	HistoryWithExitPointStates stateConfVector[HISTORYWITHEXITPOINT_MAX_ORTHOGONAL_STATES];
	HistoryWithExitPointStates historyVector[HISTORYWITHEXITPOINT_MAX_HISTORY_STATES];
	sc_ushort stateConfVectorPosition; 
	
	HistoryWithExitPointIface iface;
} HistoryWithExitPoint;

/*! Initializes the HistoryWithExitPoint state machine data structures. Must be called before first usage.*/
extern void historyWithExitPoint_init(HistoryWithExitPoint* handle);

/*! Activates the state machine */
extern void historyWithExitPoint_enter(HistoryWithExitPoint* handle);

/*! Deactivates the state machine */
extern void historyWithExitPoint_exit(HistoryWithExitPoint* handle);

/*! Performs a 'run to completion' step. */
extern void historyWithExitPoint_runCycle(HistoryWithExitPoint* handle);


/*! Raises the in event 'push' that is defined in the default interface scope. */ 
extern void historyWithExitPointIface_raise_push(HistoryWithExitPoint* handle);

/*! Raises the in event 'back' that is defined in the default interface scope. */ 
extern void historyWithExitPointIface_raise_back(HistoryWithExitPoint* handle);

/*! Raises the in event 'next' that is defined in the default interface scope. */ 
extern void historyWithExitPointIface_raise_next(HistoryWithExitPoint* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean historyWithExitPoint_isActive(const HistoryWithExitPoint* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean historyWithExitPoint_isFinal(const HistoryWithExitPoint* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean historyWithExitPoint_isStateActive(const HistoryWithExitPoint* handle, HistoryWithExitPointStates state);

#ifdef __cplusplus
}
#endif 

#endif /* HISTORYWITHEXITPOINT_H_ */
