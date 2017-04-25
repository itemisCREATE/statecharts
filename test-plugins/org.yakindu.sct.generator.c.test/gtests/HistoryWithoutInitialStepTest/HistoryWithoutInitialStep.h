
#ifndef HISTORYWITHOUTINITIALSTEP_H_
#define HISTORYWITHOUTINITIALSTEP_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'HistoryWithoutInitialStep'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	HistoryWithoutInitialStep_main_region_A,
	HistoryWithoutInitialStep_main_region_B,
	HistoryWithoutInitialStep_main_region_B_r1_C,
	HistoryWithoutInitialStep_main_region_B_r1_D,
	HistoryWithoutInitialStep_main_region_B_r1_E,
	HistoryWithoutInitialStep_main_region_B_r1_E__region0_F,
	HistoryWithoutInitialStep_last_state
} HistoryWithoutInitialStepStates;

/*! Type definition of the data structure for the HistoryWithoutInitialStepIface interface scope. */
typedef struct
{
	sc_boolean toA_raised;
	sc_boolean toB_raised;
	sc_boolean toHistory_raised;
	sc_boolean next_raised;
} HistoryWithoutInitialStepIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define HISTORYWITHOUTINITIALSTEP_MAX_ORTHOGONAL_STATES 1
	/*! Define dimension of the state configuration vector for history states. */
#define HISTORYWITHOUTINITIALSTEP_MAX_HISTORY_STATES 1

/*! 
 * Type definition of the data structure for the HistoryWithoutInitialStep state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	HistoryWithoutInitialStepStates stateConfVector[HISTORYWITHOUTINITIALSTEP_MAX_ORTHOGONAL_STATES];
	HistoryWithoutInitialStepStates historyVector[HISTORYWITHOUTINITIALSTEP_MAX_HISTORY_STATES];
	sc_ushort stateConfVectorPosition; 
	
	HistoryWithoutInitialStepIface iface;
} HistoryWithoutInitialStep;

/*! Initializes the HistoryWithoutInitialStep state machine data structures. Must be called before first usage.*/
extern void historyWithoutInitialStep_init(HistoryWithoutInitialStep* handle);

/*! Activates the state machine */
extern void historyWithoutInitialStep_enter(HistoryWithoutInitialStep* handle);

/*! Deactivates the state machine */
extern void historyWithoutInitialStep_exit(HistoryWithoutInitialStep* handle);

/*! Performs a 'run to completion' step. */
extern void historyWithoutInitialStep_runCycle(HistoryWithoutInitialStep* handle);


/*! Raises the in event 'toA' that is defined in the default interface scope. */ 
extern void historyWithoutInitialStepIface_raise_toA(HistoryWithoutInitialStep* handle);

/*! Raises the in event 'toB' that is defined in the default interface scope. */ 
extern void historyWithoutInitialStepIface_raise_toB(HistoryWithoutInitialStep* handle);

/*! Raises the in event 'toHistory' that is defined in the default interface scope. */ 
extern void historyWithoutInitialStepIface_raise_toHistory(HistoryWithoutInitialStep* handle);

/*! Raises the in event 'next' that is defined in the default interface scope. */ 
extern void historyWithoutInitialStepIface_raise_next(HistoryWithoutInitialStep* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean historyWithoutInitialStep_isActive(const HistoryWithoutInitialStep* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean historyWithoutInitialStep_isFinal(const HistoryWithoutInitialStep* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean historyWithoutInitialStep_isStateActive(const HistoryWithoutInitialStep* handle, HistoryWithoutInitialStepStates state);

#ifdef __cplusplus
}
#endif 

#endif /* HISTORYWITHOUTINITIALSTEP_H_ */
