
#ifndef STATICCHOICE_H_
#define STATICCHOICE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'StaticChoice'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	StaticChoice_last_state,
	StaticChoice_main_region_Start,
	StaticChoice_main_region_B,
	StaticChoice_main_region_A
} StaticChoiceStates;

/*! Type definition of the data structure for the StaticChoiceIface interface scope. */
typedef struct
{
	sc_integer number;
	sc_boolean reset_raised;
} StaticChoiceIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define STATICCHOICE_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_STATICCHOICE_MAIN_REGION_START 0
#define SCVI_STATICCHOICE_MAIN_REGION_B 0
#define SCVI_STATICCHOICE_MAIN_REGION_A 0

/*! 
 * Type definition of the data structure for the StaticChoice state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	StaticChoiceStates stateConfVector[STATICCHOICE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	StaticChoiceIface iface;
} StaticChoice;

/*! Initializes the StaticChoice state machine data structures. Must be called before first usage.*/
extern void staticChoice_init(StaticChoice* handle);

/*! Activates the state machine */
extern void staticChoice_enter(StaticChoice* handle);

/*! Deactivates the state machine */
extern void staticChoice_exit(StaticChoice* handle);

/*! Performs a 'run to completion' step. */
extern void staticChoice_runCycle(StaticChoice* handle);


/*! Gets the value of the variable 'number' that is defined in the default interface scope. */ 
extern sc_integer staticChoiceIface_get_number(const StaticChoice* handle);
/*! Sets the value of the variable 'number' that is defined in the default interface scope. */ 
extern void staticChoiceIface_set_number(StaticChoice* handle, sc_integer value);
/*! Raises the in event 'reset' that is defined in the default interface scope. */ 
extern void staticChoiceIface_raise_reset(StaticChoice* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean staticChoice_isActive(const StaticChoice* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean staticChoice_isFinal(const StaticChoice* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean staticChoice_isStateActive(const StaticChoice* handle, StaticChoiceStates state);

#ifdef __cplusplus
}
#endif 

#endif /* STATICCHOICE_H_ */
