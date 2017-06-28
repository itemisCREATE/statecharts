
#ifndef PRIORITYVALUES_H_
#define PRIORITYVALUES_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'PriorityValues'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	PriorityValues_last_state,
	PriorityValues_someRegion_A,
	PriorityValues_someRegion_B,
	PriorityValues_main_region_A,
	PriorityValues_main_region_B,
	PriorityValues_main_region_C,
	PriorityValues_main_region_D,
	PriorityValues_main_region_E
} PriorityValuesStates;

/*! Type definition of the data structure for the PriorityValuesIface interface scope. */
typedef struct
{
	sc_boolean event1_raised;
	sc_boolean event2_raised;
} PriorityValuesIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define PRIORITYVALUES_MAX_ORTHOGONAL_STATES 2

/*! Define indices of states in the StateConfVector */
#define SCVI_PRIORITYVALUES_SOMEREGION_A 0
#define SCVI_PRIORITYVALUES_SOMEREGION_B 0
#define SCVI_PRIORITYVALUES_MAIN_REGION_A 1
#define SCVI_PRIORITYVALUES_MAIN_REGION_B 1
#define SCVI_PRIORITYVALUES_MAIN_REGION_C 1
#define SCVI_PRIORITYVALUES_MAIN_REGION_D 1
#define SCVI_PRIORITYVALUES_MAIN_REGION_E 1

/*! 
 * Type definition of the data structure for the PriorityValues state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	PriorityValuesStates stateConfVector[PRIORITYVALUES_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	PriorityValuesIface iface;
} PriorityValues;

/*! Initializes the PriorityValues state machine data structures. Must be called before first usage.*/
extern void priorityValues_init(PriorityValues* handle);

/*! Activates the state machine */
extern void priorityValues_enter(PriorityValues* handle);

/*! Deactivates the state machine */
extern void priorityValues_exit(PriorityValues* handle);

/*! Performs a 'run to completion' step. */
extern void priorityValues_runCycle(PriorityValues* handle);


/*! Raises the in event 'event1' that is defined in the default interface scope. */ 
extern void priorityValuesIface_raise_event1(PriorityValues* handle);

/*! Raises the in event 'event2' that is defined in the default interface scope. */ 
extern void priorityValuesIface_raise_event2(PriorityValues* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean priorityValues_isActive(const PriorityValues* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean priorityValues_isFinal(const PriorityValues* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean priorityValues_isStateActive(const PriorityValues* handle, PriorityValuesStates state);

#ifdef __cplusplus
}
#endif 

#endif /* PRIORITYVALUES_H_ */
