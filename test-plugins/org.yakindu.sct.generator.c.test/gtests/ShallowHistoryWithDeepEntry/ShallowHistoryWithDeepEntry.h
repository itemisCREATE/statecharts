
#ifndef SHALLOWHISTORYWITHDEEPENTRY_H_
#define SHALLOWHISTORYWITHDEEPENTRY_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'ShallowHistoryWithDeepEntry'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	ShallowHistoryWithDeepEntry_last_state,
	ShallowHistoryWithDeepEntry_main_region_Y,
	ShallowHistoryWithDeepEntry_main_region_Z,
	ShallowHistoryWithDeepEntry_main_region_Z__region0_A,
	ShallowHistoryWithDeepEntry_main_region_Z__region0_B,
	ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C
} ShallowHistoryWithDeepEntryStates;

/*! Type definition of the data structure for the ShallowHistoryWithDeepEntryIface interface scope. */
typedef struct
{
	sc_boolean toZ_raised;
	sc_boolean toY_raised;
	sc_boolean toC_raised;
	sc_boolean toA_raised;
} ShallowHistoryWithDeepEntryIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define SHALLOWHISTORYWITHDEEPENTRY_MAX_ORTHOGONAL_STATES 1
	/*! Define dimension of the state configuration vector for history states. */
#define SHALLOWHISTORYWITHDEEPENTRY_MAX_HISTORY_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_SHALLOWHISTORYWITHDEEPENTRY_MAIN_REGION_Y 0
#define SCVI_SHALLOWHISTORYWITHDEEPENTRY_MAIN_REGION_Z 0
#define SCVI_SHALLOWHISTORYWITHDEEPENTRY_MAIN_REGION_Z__REGION0_A 0
#define SCVI_SHALLOWHISTORYWITHDEEPENTRY_MAIN_REGION_Z__REGION0_B 0
#define SCVI_SHALLOWHISTORYWITHDEEPENTRY_MAIN_REGION_Z__REGION0_B__REGION0_C 0

/*! 
 * Type definition of the data structure for the ShallowHistoryWithDeepEntry state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	ShallowHistoryWithDeepEntryStates stateConfVector[SHALLOWHISTORYWITHDEEPENTRY_MAX_ORTHOGONAL_STATES];
	ShallowHistoryWithDeepEntryStates historyVector[SHALLOWHISTORYWITHDEEPENTRY_MAX_HISTORY_STATES];
	sc_ushort stateConfVectorPosition; 
	
	ShallowHistoryWithDeepEntryIface iface;
} ShallowHistoryWithDeepEntry;

/*! Initializes the ShallowHistoryWithDeepEntry state machine data structures. Must be called before first usage.*/
extern void shallowHistoryWithDeepEntry_init(ShallowHistoryWithDeepEntry* handle);

/*! Activates the state machine */
extern void shallowHistoryWithDeepEntry_enter(ShallowHistoryWithDeepEntry* handle);

/*! Deactivates the state machine */
extern void shallowHistoryWithDeepEntry_exit(ShallowHistoryWithDeepEntry* handle);

/*! Performs a 'run to completion' step. */
extern void shallowHistoryWithDeepEntry_runCycle(ShallowHistoryWithDeepEntry* handle);


/*! Raises the in event 'toZ' that is defined in the default interface scope. */ 
extern void shallowHistoryWithDeepEntryIface_raise_toZ(ShallowHistoryWithDeepEntry* handle);

/*! Raises the in event 'toY' that is defined in the default interface scope. */ 
extern void shallowHistoryWithDeepEntryIface_raise_toY(ShallowHistoryWithDeepEntry* handle);

/*! Raises the in event 'toC' that is defined in the default interface scope. */ 
extern void shallowHistoryWithDeepEntryIface_raise_toC(ShallowHistoryWithDeepEntry* handle);

/*! Raises the in event 'toA' that is defined in the default interface scope. */ 
extern void shallowHistoryWithDeepEntryIface_raise_toA(ShallowHistoryWithDeepEntry* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean shallowHistoryWithDeepEntry_isActive(const ShallowHistoryWithDeepEntry* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean shallowHistoryWithDeepEntry_isFinal(const ShallowHistoryWithDeepEntry* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean shallowHistoryWithDeepEntry_isStateActive(const ShallowHistoryWithDeepEntry* handle, ShallowHistoryWithDeepEntryStates state);

#ifdef __cplusplus
}
#endif 

#endif /* SHALLOWHISTORYWITHDEEPENTRY_H_ */
