
#ifndef DEEPENTRY_H_
#define DEEPENTRY_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'DeepEntry'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	DeepEntry_r_A,
	DeepEntry_r_A_r_B,
	DeepEntry_r2_B,
	DeepEntry_r2_B_r_BA,
	DeepEntry_r2_B_r_BA_r_BAA,
	DeepEntry_r2_B_r_BB,
	DeepEntry_r2_C,
	DeepEntry_r3_D,
	DeepEntry_r3_D_r_DA,
	DeepEntry_r3_D_r_DA_r_DAA,
	DeepEntry_last_state
} DeepEntryStates;

/*! Type definition of the data structure for the DeepEntryIface interface scope. */
typedef struct
{
	sc_integer x;
	sc_integer y;
	sc_integer z;
	sc_boolean e_raised;
	sc_boolean f_raised;
} DeepEntryIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define DEEPENTRY_MAX_ORTHOGONAL_STATES 3
	/*! Define dimension of the state configuration vector for history states. */
#define DEEPENTRY_MAX_HISTORY_STATES 4

/*! 
 * Type definition of the data structure for the DeepEntry state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	DeepEntryStates stateConfVector[DEEPENTRY_MAX_ORTHOGONAL_STATES];
	DeepEntryStates historyVector[DEEPENTRY_MAX_HISTORY_STATES];
	sc_ushort stateConfVectorPosition; 
	
	DeepEntryIface iface;
} DeepEntry;

/*! Initializes the DeepEntry state machine data structures. Must be called before first usage.*/
extern void deepEntry_init(DeepEntry* handle);

/*! Activates the state machine */
extern void deepEntry_enter(DeepEntry* handle);

/*! Deactivates the state machine */
extern void deepEntry_exit(DeepEntry* handle);

/*! Performs a 'run to completion' step. */
extern void deepEntry_runCycle(DeepEntry* handle);


/*! Gets the value of the variable 'x' that is defined in the default interface scope. */ 
extern sc_integer deepEntryIface_get_x(const DeepEntry* handle);
/*! Sets the value of the variable 'x' that is defined in the default interface scope. */ 
extern void deepEntryIface_set_x(DeepEntry* handle, sc_integer value);
/*! Gets the value of the variable 'y' that is defined in the default interface scope. */ 
extern sc_integer deepEntryIface_get_y(const DeepEntry* handle);
/*! Sets the value of the variable 'y' that is defined in the default interface scope. */ 
extern void deepEntryIface_set_y(DeepEntry* handle, sc_integer value);
/*! Gets the value of the variable 'z' that is defined in the default interface scope. */ 
extern sc_integer deepEntryIface_get_z(const DeepEntry* handle);
/*! Sets the value of the variable 'z' that is defined in the default interface scope. */ 
extern void deepEntryIface_set_z(DeepEntry* handle, sc_integer value);
/*! Raises the in event 'e' that is defined in the default interface scope. */ 
extern void deepEntryIface_raise_e(DeepEntry* handle);

/*! Raises the in event 'f' that is defined in the default interface scope. */ 
extern void deepEntryIface_raise_f(DeepEntry* handle);


/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean deepEntry_isActive(const DeepEntry* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean deepEntry_isFinal(const DeepEntry* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean deepEntry_isStateActive(const DeepEntry* handle, DeepEntryStates state);

#ifdef __cplusplus
}
#endif 

#endif /* DEEPENTRY_H_ */
