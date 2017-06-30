
#ifndef SAMENAMEDIFFERENTREGION_H_
#define SAMENAMEDIFFERENTREGION_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'SameNameDifferentRegion'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	SameNameDifferentRegion_last_state,
	SameNameDifferentRegion_main_region_StateA,
	SameNameDifferentRegion_main_region_StateB,
	SameNameDifferentRegion_main_region_StateB_r1_StateA,
	SameNameDifferentRegion_main_region_StateB_r1_StateB
} SameNameDifferentRegionStates;

/*! Type definition of the data structure for the SameNameDifferentRegionIface interface scope. */
typedef struct
{
	sc_boolean e1_raised;
} SameNameDifferentRegionIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define SAMENAMEDIFFERENTREGION_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_SAMENAMEDIFFERENTREGION_MAIN_REGION_STATEA 0
#define SCVI_SAMENAMEDIFFERENTREGION_MAIN_REGION_STATEB 0
#define SCVI_SAMENAMEDIFFERENTREGION_MAIN_REGION_STATEB_R1_STATEA 0
#define SCVI_SAMENAMEDIFFERENTREGION_MAIN_REGION_STATEB_R1_STATEB 0

/*! 
 * Type definition of the data structure for the SameNameDifferentRegion state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	SameNameDifferentRegionStates stateConfVector[SAMENAMEDIFFERENTREGION_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	SameNameDifferentRegionIface iface;
} SameNameDifferentRegion;

/*! Initializes the SameNameDifferentRegion state machine data structures. Must be called before first usage.*/
extern void sameNameDifferentRegion_init(SameNameDifferentRegion* handle);

/*! Activates the state machine */
extern void sameNameDifferentRegion_enter(SameNameDifferentRegion* handle);

/*! Deactivates the state machine */
extern void sameNameDifferentRegion_exit(SameNameDifferentRegion* handle);

/*! Performs a 'run to completion' step. */
extern void sameNameDifferentRegion_runCycle(SameNameDifferentRegion* handle);


/*! Raises the in event 'e1' that is defined in the default interface scope. */ 
extern void sameNameDifferentRegionIface_raise_e1(SameNameDifferentRegion* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean sameNameDifferentRegion_isActive(const SameNameDifferentRegion* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean sameNameDifferentRegion_isFinal(const SameNameDifferentRegion* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean sameNameDifferentRegion_isStateActive(const SameNameDifferentRegion* handle, SameNameDifferentRegionStates state);

#ifdef __cplusplus
}
#endif 

#endif /* SAMENAMEDIFFERENTREGION_H_ */
