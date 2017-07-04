
#ifndef DYNAMICCHOICE_H_
#define DYNAMICCHOICE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'DynamicChoice'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	DynamicChoice_last_state,
	DynamicChoice_main_region_Start,
	DynamicChoice_main_region_A,
	DynamicChoice_main_region_B
} DynamicChoiceStates;

/*! Type definition of the data structure for the DynamicChoiceIface interface scope. */
typedef struct
{
	sc_integer number;
	sc_boolean reset_raised;
} DynamicChoiceIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define DYNAMICCHOICE_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_DYNAMICCHOICE_MAIN_REGION_START 0
#define SCVI_DYNAMICCHOICE_MAIN_REGION_A 0
#define SCVI_DYNAMICCHOICE_MAIN_REGION_B 0

/*! 
 * Type definition of the data structure for the DynamicChoice state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	DynamicChoiceStates stateConfVector[DYNAMICCHOICE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	DynamicChoiceIface iface;
} DynamicChoice;

/*! Initializes the DynamicChoice state machine data structures. Must be called before first usage.*/
extern void dynamicChoice_init(DynamicChoice* handle);

/*! Activates the state machine */
extern void dynamicChoice_enter(DynamicChoice* handle);

/*! Deactivates the state machine */
extern void dynamicChoice_exit(DynamicChoice* handle);

/*! Performs a 'run to completion' step. */
extern void dynamicChoice_runCycle(DynamicChoice* handle);


/*! Gets the value of the variable 'number' that is defined in the default interface scope. */ 
extern sc_integer dynamicChoiceIface_get_number(const DynamicChoice* handle);
/*! Sets the value of the variable 'number' that is defined in the default interface scope. */ 
extern void dynamicChoiceIface_set_number(DynamicChoice* handle, sc_integer value);
/*! Raises the in event 'reset' that is defined in the default interface scope. */ 
extern void dynamicChoiceIface_raise_reset(DynamicChoice* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean dynamicChoice_isActive(const DynamicChoice* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean dynamicChoice_isFinal(const DynamicChoice* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean dynamicChoice_isStateActive(const DynamicChoice* handle, DynamicChoiceStates state);

#ifdef __cplusplus
}
#endif 

#endif /* DYNAMICCHOICE_H_ */
