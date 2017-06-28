
#ifndef CHOICE_H_
#define CHOICE_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'Choice'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	Choice_last_state,
	Choice_main_region_A,
	Choice_main_region_B,
	Choice_main_region_C
} ChoiceStates;

/*! Type definition of the data structure for the ChoiceIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_boolean f_raised;
	sc_boolean g_raised;
	sc_boolean h_raised;
	sc_boolean c;
} ChoiceIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define CHOICE_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_CHOICE_MAIN_REGION_A 0
#define SCVI_CHOICE_MAIN_REGION_B 0
#define SCVI_CHOICE_MAIN_REGION_C 0

/*! 
 * Type definition of the data structure for the Choice state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	ChoiceStates stateConfVector[CHOICE_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	ChoiceIface iface;
} Choice;

/*! Initializes the Choice state machine data structures. Must be called before first usage.*/
extern void choice_init(Choice* handle);

/*! Activates the state machine */
extern void choice_enter(Choice* handle);

/*! Deactivates the state machine */
extern void choice_exit(Choice* handle);

/*! Performs a 'run to completion' step. */
extern void choice_runCycle(Choice* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void choiceIface_raise_e(Choice* handle);

/*! Raises the in event 'f' that is defined in the default interface scope. */ 
extern void choiceIface_raise_f(Choice* handle);

/*! Raises the in event 'g' that is defined in the default interface scope. */ 
extern void choiceIface_raise_g(Choice* handle);

/*! Raises the in event 'h' that is defined in the default interface scope. */ 
extern void choiceIface_raise_h(Choice* handle);

/*! Gets the value of the variable 'c' that is defined in the default interface scope. */ 
extern sc_boolean choiceIface_get_c(const Choice* handle);
/*! Sets the value of the variable 'c' that is defined in the default interface scope. */ 
extern void choiceIface_set_c(Choice* handle, sc_boolean value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean choice_isActive(const Choice* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean choice_isFinal(const Choice* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean choice_isStateActive(const Choice* handle, ChoiceStates state);

#ifdef __cplusplus
}
#endif 

#endif /* CHOICE_H_ */
