
#ifndef DECLARATIONS_H_
#define DECLARATIONS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'Declarations'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	Declarations_last_state,
	Declarations_main_region_A,
	Declarations_main_region_B
} DeclarationsStates;

/*! Type definition of the data structure for the DeclarationsIface interface scope. */
typedef struct
{
	sc_boolean evA_raised;
	sc_boolean evB_raised;
	sc_boolean evC_raised;
	sc_boolean evC_value;
	sc_boolean evD_raised;
	sc_integer evD_value;
	sc_boolean evE_raised;
	sc_real evE_value;
	sc_boolean evF_raised;
	sc_string evF_value;
	sc_boolean varA;
	sc_integer varB;
	sc_real varC;
	sc_string varD;
	sc_integer varE;
} DeclarationsIface;

/*! Type definition of the data structure for the DeclarationsIfaceIfA interface scope. */
typedef struct
{
	sc_boolean evA_raised;
	sc_boolean evB_raised;
	sc_boolean evC_raised;
	sc_boolean evC_value;
	sc_boolean evD_raised;
	sc_integer evD_value;
	sc_boolean evE_raised;
	sc_real evE_value;
	sc_boolean evF_raised;
	sc_string evF_value;
	sc_boolean varA;
	sc_integer varB;
	sc_real varC;
	sc_string varD;
	sc_integer varE;
} DeclarationsIfaceIfA;

/*! Type definition of the data structure for the DeclarationsInternal interface scope. */
typedef struct
{
	sc_boolean evInA_raised;
	sc_boolean evInB_raised;
	sc_boolean evInC_raised;
	sc_boolean evInC_value;
	sc_boolean evInD_raised;
	sc_integer evInD_value;
	sc_boolean evInE_raised;
	sc_real evInE_value;
	sc_boolean evInF_raised;
	sc_string evInF_value;
	sc_boolean varInA;
	sc_integer varInB;
	sc_real varInC;
	sc_string varInD;
	sc_integer varInE;
} DeclarationsInternal;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define DECLARATIONS_MAX_ORTHOGONAL_STATES 1

/*! Define indices of states in the StateConfVector */
#define SCVI_DECLARATIONS_MAIN_REGION_A 0
#define SCVI_DECLARATIONS_MAIN_REGION_B 0

/*! 
 * Type definition of the data structure for the Declarations state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	DeclarationsStates stateConfVector[DECLARATIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	DeclarationsIface iface;
	DeclarationsIfaceIfA ifaceIfA;
	DeclarationsInternal internal;
} Declarations;

/*! Initializes the Declarations state machine data structures. Must be called before first usage.*/
extern void declarations_init(Declarations* handle);

/*! Activates the state machine */
extern void declarations_enter(Declarations* handle);

/*! Deactivates the state machine */
extern void declarations_exit(Declarations* handle);

/*! Performs a 'run to completion' step. */
extern void declarations_runCycle(Declarations* handle);


/*! Raises the in event 'evA' that is defined in the default interface scope. */ 
extern void declarationsIface_raise_evA(Declarations* handle);

/*! Checks if the out event 'evB' that is defined in the default interface scope has been raised. */ 
extern sc_boolean declarationsIface_israised_evB(const Declarations* handle);

/*! Raises the in event 'evC' that is defined in the default interface scope. */ 
extern void declarationsIface_raise_evC(Declarations* handle, sc_boolean value);

/*! Checks if the out event 'evD' that is defined in the default interface scope has been raised. */ 
extern sc_boolean declarationsIface_israised_evD(const Declarations* handle);

/*! Gets the value of the out event 'evD' that is defined in the default interface scope. */ 
extern sc_integer declarationsIface_get_evD_value(const Declarations* handle);

/*! Raises the in event 'evE' that is defined in the default interface scope. */ 
extern void declarationsIface_raise_evE(Declarations* handle, sc_real value);

/*! Checks if the out event 'evF' that is defined in the default interface scope has been raised. */ 
extern sc_boolean declarationsIface_israised_evF(const Declarations* handle);

/*! Gets the value of the out event 'evF' that is defined in the default interface scope. */ 
extern sc_string declarationsIface_get_evF_value(const Declarations* handle);

/*! Gets the value of the variable 'varA' that is defined in the default interface scope. */ 
extern sc_boolean declarationsIface_get_varA(const Declarations* handle);
/*! Sets the value of the variable 'varA' that is defined in the default interface scope. */ 
extern void declarationsIface_set_varA(Declarations* handle, sc_boolean value);
/*! Gets the value of the variable 'varB' that is defined in the default interface scope. */ 
extern sc_integer declarationsIface_get_varB(const Declarations* handle);
/*! Sets the value of the variable 'varB' that is defined in the default interface scope. */ 
extern void declarationsIface_set_varB(Declarations* handle, sc_integer value);
/*! Gets the value of the variable 'varC' that is defined in the default interface scope. */ 
extern sc_real declarationsIface_get_varC(const Declarations* handle);
/*! Sets the value of the variable 'varC' that is defined in the default interface scope. */ 
extern void declarationsIface_set_varC(Declarations* handle, sc_real value);
/*! Gets the value of the variable 'varD' that is defined in the default interface scope. */ 
extern sc_string declarationsIface_get_varD(const Declarations* handle);
/*! Sets the value of the variable 'varD' that is defined in the default interface scope. */ 
extern void declarationsIface_set_varD(Declarations* handle, sc_string value);
/*! Gets the value of the variable 'varE' that is defined in the default interface scope. */ 
extern sc_integer declarationsIface_get_varE(const Declarations* handle);
/*! Sets the value of the variable 'varE' that is defined in the default interface scope. */ 
extern void declarationsIface_set_varE(Declarations* handle, sc_integer value);
/*! Raises the in event 'evA' that is defined in the interface scope 'ifA'. */ 
extern void declarationsIfaceIfA_raise_evA(Declarations* handle);

/*! Checks if the out event 'evB' that is defined in the interface scope 'ifA' has been raised. */ 
extern sc_boolean declarationsIfaceIfA_israised_evB(const Declarations* handle);

/*! Raises the in event 'evC' that is defined in the interface scope 'ifA'. */ 
extern void declarationsIfaceIfA_raise_evC(Declarations* handle, sc_boolean value);

/*! Checks if the out event 'evD' that is defined in the interface scope 'ifA' has been raised. */ 
extern sc_boolean declarationsIfaceIfA_israised_evD(const Declarations* handle);

/*! Gets the value of the out event 'evD' that is defined in the interface scope 'ifA'. */ 
extern sc_integer declarationsIfaceIfA_get_evD_value(const Declarations* handle);

/*! Raises the in event 'evE' that is defined in the interface scope 'ifA'. */ 
extern void declarationsIfaceIfA_raise_evE(Declarations* handle, sc_real value);

/*! Checks if the out event 'evF' that is defined in the interface scope 'ifA' has been raised. */ 
extern sc_boolean declarationsIfaceIfA_israised_evF(const Declarations* handle);

/*! Gets the value of the out event 'evF' that is defined in the interface scope 'ifA'. */ 
extern sc_string declarationsIfaceIfA_get_evF_value(const Declarations* handle);

/*! Gets the value of the variable 'varA' that is defined in the interface scope 'ifA'. */ 
extern sc_boolean declarationsIfaceIfA_get_varA(const Declarations* handle);
/*! Sets the value of the variable 'varA' that is defined in the interface scope 'ifA'. */ 
extern void declarationsIfaceIfA_set_varA(Declarations* handle, sc_boolean value);
/*! Gets the value of the variable 'varB' that is defined in the interface scope 'ifA'. */ 
extern sc_integer declarationsIfaceIfA_get_varB(const Declarations* handle);
/*! Sets the value of the variable 'varB' that is defined in the interface scope 'ifA'. */ 
extern void declarationsIfaceIfA_set_varB(Declarations* handle, sc_integer value);
/*! Gets the value of the variable 'varC' that is defined in the interface scope 'ifA'. */ 
extern sc_real declarationsIfaceIfA_get_varC(const Declarations* handle);
/*! Sets the value of the variable 'varC' that is defined in the interface scope 'ifA'. */ 
extern void declarationsIfaceIfA_set_varC(Declarations* handle, sc_real value);
/*! Gets the value of the variable 'varD' that is defined in the interface scope 'ifA'. */ 
extern sc_string declarationsIfaceIfA_get_varD(const Declarations* handle);
/*! Sets the value of the variable 'varD' that is defined in the interface scope 'ifA'. */ 
extern void declarationsIfaceIfA_set_varD(Declarations* handle, sc_string value);
/*! Gets the value of the variable 'varE' that is defined in the interface scope 'ifA'. */ 
extern sc_integer declarationsIfaceIfA_get_varE(const Declarations* handle);
/*! Sets the value of the variable 'varE' that is defined in the interface scope 'ifA'. */ 
extern void declarationsIfaceIfA_set_varE(Declarations* handle, sc_integer value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean declarations_isActive(const Declarations* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean declarations_isFinal(const Declarations* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean declarations_isStateActive(const Declarations* handle, DeclarationsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* DECLARATIONS_H_ */
