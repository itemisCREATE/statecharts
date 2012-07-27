#ifndef BITEXPRESSIONS_H_
#define BITEXPRESSIONS_H_

#include "sc_types.h"

#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'BitExpressions'.
*/

//! enumeration of all states 
typedef enum {
	BitExpressions_main_region_StateA ,
	BitExpressions_main_region_StateB ,
	BitExpressions_last_state
} BitExpressionsStates;

//! Type definition of the data structure for the BitExpressionsIface interface scope.
typedef struct {
	sc_integer  myBit1;
	sc_integer  myBit2;
	sc_integer  leftBitshift;
	sc_integer  rightBitshift;
	sc_integer  complementBitshift;
	sc_integer  bitwiseAnd;
	sc_integer  bitwiseOr;
	sc_integer  bitwiseXor;
	sc_boolean e1_raised;
} BitExpressionsIface;


//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
#define BITEXPRESSIONS_MAX_ORTHOGONAL_STATES 1

/*! Type definition of the data structure for the BitExpressions state machine.
This data structure has to be allocated by the client code. */
typedef struct {
	BitExpressionsStates stateConfVector[BITEXPRESSIONS_MAX_ORTHOGONAL_STATES];
	sc_ushort stateConfVectorPosition; 
	
	BitExpressionsIface iface;
} BitExpressions;

/*! Initializes the BitExpressions state machine data structures. Must be called before first usage.*/
extern void bitExpressions_init(BitExpressions* handle);

/*! Activates the state machine */
extern void bitExpressions_enter(BitExpressions* handle);

/*! Deactivates the state machine */
extern void bitExpressions_exit(BitExpressions* handle);

/*! Performs a 'run to completion' step. */
extern void bitExpressions_runCycle(BitExpressions* handle);


/*! Gets the value of the variable 'myBit1' that is defined in the default interface scope. */ 
extern sc_integer bitExpressionsIface_get_myBit1(BitExpressions* handle);
/*! Sets the value of the variable 'myBit1' that is defined in the default interface scope. */ 
extern void bitExpressionsIface_set_myBit1(BitExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'myBit2' that is defined in the default interface scope. */ 
extern sc_integer bitExpressionsIface_get_myBit2(BitExpressions* handle);
/*! Sets the value of the variable 'myBit2' that is defined in the default interface scope. */ 
extern void bitExpressionsIface_set_myBit2(BitExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'leftBitshift' that is defined in the default interface scope. */ 
extern sc_integer bitExpressionsIface_get_leftBitshift(BitExpressions* handle);
/*! Sets the value of the variable 'leftBitshift' that is defined in the default interface scope. */ 
extern void bitExpressionsIface_set_leftBitshift(BitExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'rightBitshift' that is defined in the default interface scope. */ 
extern sc_integer bitExpressionsIface_get_rightBitshift(BitExpressions* handle);
/*! Sets the value of the variable 'rightBitshift' that is defined in the default interface scope. */ 
extern void bitExpressionsIface_set_rightBitshift(BitExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'complementBitshift' that is defined in the default interface scope. */ 
extern sc_integer bitExpressionsIface_get_complementBitshift(BitExpressions* handle);
/*! Sets the value of the variable 'complementBitshift' that is defined in the default interface scope. */ 
extern void bitExpressionsIface_set_complementBitshift(BitExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'bitwiseAnd' that is defined in the default interface scope. */ 
extern sc_integer bitExpressionsIface_get_bitwiseAnd(BitExpressions* handle);
/*! Sets the value of the variable 'bitwiseAnd' that is defined in the default interface scope. */ 
extern void bitExpressionsIface_set_bitwiseAnd(BitExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'bitwiseOr' that is defined in the default interface scope. */ 
extern sc_integer bitExpressionsIface_get_bitwiseOr(BitExpressions* handle);
/*! Sets the value of the variable 'bitwiseOr' that is defined in the default interface scope. */ 
extern void bitExpressionsIface_set_bitwiseOr(BitExpressions* handle, sc_integer value);
/*! Gets the value of the variable 'bitwiseXor' that is defined in the default interface scope. */ 
extern sc_integer bitExpressionsIface_get_bitwiseXor(BitExpressions* handle);
/*! Sets the value of the variable 'bitwiseXor' that is defined in the default interface scope. */ 
extern void bitExpressionsIface_set_bitwiseXor(BitExpressions* handle, sc_integer value);
/*! Raises the in event 'e1' that is defined in the default interface scope. */ 
extern void bitExpressionsIface_raise_e1(BitExpressions* handle);



/*! Checks if the specified state is active. */
extern sc_boolean bitExpressions_isActive(BitExpressions* handle, BitExpressionsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* BITEXPRESSIONS_H_ */
