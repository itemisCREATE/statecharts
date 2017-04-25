
#ifndef FEATURECALLS_H_
#define FEATURECALLS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'FeatureCalls'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	FeatureCalls_main_region_A,
	FeatureCalls_main_region_B,
	FeatureCalls_last_state
} FeatureCallsStates;

/*! Type definition of the data structure for the FeatureCallsIfaceMyInterface interface scope. */
typedef struct
{
	sc_boolean Event1_raised;
	sc_integer myInt;
} FeatureCallsIfaceMyInterface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define FEATURECALLS_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the FeatureCalls state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	FeatureCallsStates stateConfVector[FEATURECALLS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	FeatureCallsIfaceMyInterface ifaceMyInterface;
} FeatureCalls;

/*! Initializes the FeatureCalls state machine data structures. Must be called before first usage.*/
extern void featureCalls_init(FeatureCalls* handle);

/*! Activates the state machine */
extern void featureCalls_enter(FeatureCalls* handle);

/*! Deactivates the state machine */
extern void featureCalls_exit(FeatureCalls* handle);

/*! Performs a 'run to completion' step. */
extern void featureCalls_runCycle(FeatureCalls* handle);


/*! Raises the in event 'Event1' that is defined in the interface scope 'MyInterface'. */ 
extern void featureCallsIfaceMyInterface_raise_event1(FeatureCalls* handle);

/*! Gets the value of the variable 'myInt' that is defined in the interface scope 'MyInterface'. */ 
extern sc_integer featureCallsIfaceMyInterface_get_myInt(const FeatureCalls* handle);
/*! Sets the value of the variable 'myInt' that is defined in the interface scope 'MyInterface'. */ 
extern void featureCallsIfaceMyInterface_set_myInt(FeatureCalls* handle, sc_integer value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean featureCalls_isActive(const FeatureCalls* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean featureCalls_isFinal(const FeatureCalls* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean featureCalls_isStateActive(const FeatureCalls* handle, FeatureCallsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* FEATURECALLS_H_ */
