
#ifndef CONSTANTS_H_
#define CONSTANTS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'Constants'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	Constants_main_region_A,
	Constants_main_region_B,
	Constants_main_region_C,
	Constants_last_state
} ConstantsStates;

/*! Type definition of the data structure for the ConstantsIface interface scope. */
typedef struct
{
	sc_boolean e_raised;
	sc_boolean e2_raised;
	sc_integer e2_value;
	sc_integer result;
} ConstantsIface;

/* Declaration of constants for scope ConstantsIface. */
extern const sc_integer CONSTANTS_CONSTANTSIFACE_X;
extern const sc_integer CONSTANTS_CONSTANTSIFACE_Y;

/* Declaration of constants for scope ConstantsIfaceNamed. */
extern const sc_string CONSTANTS_CONSTANTSIFACENAMED_Y;
extern const sc_integer CONSTANTS_CONSTANTSIFACENAMED_TWO;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define CONSTANTS_MAX_ORTHOGONAL_STATES 1

/*! 
 * Type definition of the data structure for the Constants state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	ConstantsStates stateConfVector[CONSTANTS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	ConstantsIface iface;
} Constants;

/*! Initializes the Constants state machine data structures. Must be called before first usage.*/
extern void constants_init(Constants* handle);

/*! Activates the state machine */
extern void constants_enter(Constants* handle);

/*! Deactivates the state machine */
extern void constants_exit(Constants* handle);

/*! Performs a 'run to completion' step. */
extern void constants_runCycle(Constants* handle);


/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void constantsIface_raise_e(Constants* handle);

/*! Raises the in event 'e2' that is defined in the default interface scope. */ 
extern void constantsIface_raise_e2(Constants* handle, sc_integer value);

/*! Gets the value of the variable 'x' that is defined in the default interface scope. */ 
extern const sc_integer constantsIface_get_x(const Constants* handle);
/*! Gets the value of the variable 'y' that is defined in the default interface scope. */ 
extern const sc_integer constantsIface_get_y(const Constants* handle);
/*! Gets the value of the variable 'result' that is defined in the default interface scope. */ 
extern sc_integer constantsIface_get_result(const Constants* handle);
/*! Sets the value of the variable 'result' that is defined in the default interface scope. */ 
extern void constantsIface_set_result(Constants* handle, sc_integer value);
/*! Gets the value of the variable 'y' that is defined in the interface scope 'Named'. */ 
extern const sc_string constantsIfaceNamed_get_y(const Constants* handle);
/*! Gets the value of the variable 'two' that is defined in the interface scope 'Named'. */ 
extern const sc_integer constantsIfaceNamed_get_two(const Constants* handle);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean constants_isActive(const Constants* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean constants_isFinal(const Constants* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean constants_isStateActive(const Constants* handle, ConstantsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* CONSTANTS_H_ */
