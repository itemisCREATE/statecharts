#ifndef ALWAYSONCYCLE_H_
#define ALWAYSONCYCLE_H_

#include "sc_types.h"

#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'AlwaysOncycle'.
*/

//! enumeration of all states 
typedef enum {
	AlwaysOncycle_main_region_StateA ,
	AlwaysOncycle_main_region_StateB ,
	AlwaysOncycle_last_state
} AlwaysOncycleStates;

//! Type definition of the data structure for the AlwaysOncycleIface interface scope.
typedef struct {
	sc_integer  value;
} AlwaysOncycleIface;


//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
#define ALWAYSONCYCLE_MAX_ORTHOGONAL_STATES 1

/*! Type definition of the data structure for the AlwaysOncycle state machine.
This data structure has to be allocated by the client code. */
typedef struct {
	AlwaysOncycleStates stateConfVector[ALWAYSONCYCLE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	AlwaysOncycleIface iface;
} AlwaysOncycle;

/*! Initializes the AlwaysOncycle state machine data structures. Must be called before first usage.*/
extern void alwaysOncycle_init(AlwaysOncycle* handle);

/*! Activates the state machine */
extern void alwaysOncycle_enter(AlwaysOncycle* handle);

/*! Deactivates the state machine */
extern void alwaysOncycle_exit(AlwaysOncycle* handle);

/*! Performs a 'run to completion' step. */
extern void alwaysOncycle_runCycle(AlwaysOncycle* handle);


/*! Gets the value of the variable 'value' that is defined in the default interface scope. */ 
extern sc_integer alwaysOncycleIface_get_value(AlwaysOncycle* handle);
/*! Sets the value of the variable 'value' that is defined in the default interface scope. */ 
extern void alwaysOncycleIface_set_value(AlwaysOncycle* handle, sc_integer value);


/*! Checks if the specified state is active. */
extern sc_boolean alwaysOncycle_isActive(AlwaysOncycle* handle, AlwaysOncycleStates state);

#ifdef __cplusplus
}
#endif 

#endif /* ALWAYSONCYCLE_H_ */
