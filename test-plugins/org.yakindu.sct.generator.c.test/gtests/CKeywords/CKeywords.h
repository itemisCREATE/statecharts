
#ifndef CKEYWORDS_H_
#define CKEYWORDS_H_

#include "sc_types.h"
		
#ifdef __cplusplus
extern "C" { 
#endif 

/*! \file Header of the state machine 'CKeywords'.
*/

/*! Enumeration of all states */ 
typedef enum
{
	CKeywords_last_state,
	CKeywords_auto_char,
	CKeywords_auto_loop,
	CKeywords_auto_loop_switch_case,
	CKeywords_auto_loop_switch_case_enum_asm
} CKeywordsStates;

/*! Type definition of the data structure for the CKeywordsIface interface scope. */
typedef struct
{
	sc_boolean auto_raised;
	sc_boolean break_raised;
	sc_boolean case_ID;
	sc_integer do_ID;
	sc_boolean continue_ID;
	sc_boolean double_ID;
	sc_boolean enum_ID;
	sc_boolean extern_ID;
	sc_boolean float_ID;
	sc_boolean for_ID;
	sc_boolean goto_ID;
	sc_boolean if_ID;
	sc_boolean int_ID;
	sc_boolean long_ID;
	sc_boolean register_ID;
	sc_boolean return_ID;
	sc_boolean short_ID;
	sc_boolean signed_ID;
	sc_boolean sizeof_ID;
	sc_boolean static_ID;
	sc_boolean struct_ID;
	sc_boolean switch_ID;
	sc_boolean typedef_ID;
	sc_boolean union_ID;
	sc_boolean unsigned_ID;
	sc_boolean void_ID;
	sc_boolean volatile_ID;
	sc_boolean while_ID;
} CKeywordsIface;


/*! Define dimension of the state configuration vector for orthogonal states. */
#define CKEYWORDS_MAX_ORTHOGONAL_STATES 1
	/*! Define dimension of the state configuration vector for history states. */
#define CKEYWORDS_MAX_HISTORY_STATES 2

/*! Define indices of states in the StateConfVector */
#define SCVI_CKEYWORDS_AUTO_CHAR 0
#define SCVI_CKEYWORDS_AUTO_LOOP 0
#define SCVI_CKEYWORDS_AUTO_LOOP_SWITCH_CASE 0
#define SCVI_CKEYWORDS_AUTO_LOOP_SWITCH_CASE_ENUM_ASM 0

/*! 
 * Type definition of the data structure for the CKeywords state machine.
 * This data structure has to be allocated by the client code. 
 */
typedef struct
{
	CKeywordsStates stateConfVector[CKEYWORDS_MAX_ORTHOGONAL_STATES];
	CKeywordsStates historyVector[CKEYWORDS_MAX_HISTORY_STATES];
	sc_ushort stateConfVectorPosition; 
	
	CKeywordsIface iface;
} CKeywords;

/*! Initializes the CKeywords state machine data structures. Must be called before first usage.*/
extern void cKeywords_init(CKeywords* handle);

/*! Activates the state machine */
extern void cKeywords_enter(CKeywords* handle);

/*! Deactivates the state machine */
extern void cKeywords_exit(CKeywords* handle);

/*! Performs a 'run to completion' step. */
extern void cKeywords_runCycle(CKeywords* handle);


/*! Raises the in event 'auto' that is defined in the default interface scope. */ 
extern void cKeywordsIface_raise_auto(CKeywords* handle);

/*! Raises the in event 'break' that is defined in the default interface scope. */ 
extern void cKeywordsIface_raise_break(CKeywords* handle);

/*! Gets the value of the variable 'case' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_case(const CKeywords* handle);
/*! Sets the value of the variable 'case' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_case(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'do' that is defined in the default interface scope. */ 
extern sc_integer cKeywordsIface_get_do(const CKeywords* handle);
/*! Sets the value of the variable 'do' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_do(CKeywords* handle, sc_integer value);
/*! Gets the value of the variable 'continue' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_continue(const CKeywords* handle);
/*! Sets the value of the variable 'continue' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_continue(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'double' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_double(const CKeywords* handle);
/*! Sets the value of the variable 'double' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_double(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'enum' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_enum(const CKeywords* handle);
/*! Sets the value of the variable 'enum' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_enum(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'extern' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_extern(const CKeywords* handle);
/*! Sets the value of the variable 'extern' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_extern(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'float' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_float(const CKeywords* handle);
/*! Sets the value of the variable 'float' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_float(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'for' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_for(const CKeywords* handle);
/*! Sets the value of the variable 'for' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_for(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'goto' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_goto(const CKeywords* handle);
/*! Sets the value of the variable 'goto' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_goto(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'if' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_if(const CKeywords* handle);
/*! Sets the value of the variable 'if' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_if(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'int' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_int(const CKeywords* handle);
/*! Sets the value of the variable 'int' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_int(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'long' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_long(const CKeywords* handle);
/*! Sets the value of the variable 'long' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_long(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'register' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_register(const CKeywords* handle);
/*! Sets the value of the variable 'register' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_register(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'return' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_return(const CKeywords* handle);
/*! Sets the value of the variable 'return' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_return(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'short' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_short(const CKeywords* handle);
/*! Sets the value of the variable 'short' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_short(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'signed' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_signed(const CKeywords* handle);
/*! Sets the value of the variable 'signed' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_signed(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'sizeof' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_sizeof(const CKeywords* handle);
/*! Sets the value of the variable 'sizeof' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_sizeof(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'static' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_static(const CKeywords* handle);
/*! Sets the value of the variable 'static' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_static(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'struct' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_struct(const CKeywords* handle);
/*! Sets the value of the variable 'struct' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_struct(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'switch' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_switch(const CKeywords* handle);
/*! Sets the value of the variable 'switch' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_switch(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'typedef' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_typedef(const CKeywords* handle);
/*! Sets the value of the variable 'typedef' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_typedef(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'union' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_union(const CKeywords* handle);
/*! Sets the value of the variable 'union' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_union(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'unsigned' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_unsigned(const CKeywords* handle);
/*! Sets the value of the variable 'unsigned' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_unsigned(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'void' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_void(const CKeywords* handle);
/*! Sets the value of the variable 'void' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_void(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'volatile' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_volatile(const CKeywords* handle);
/*! Sets the value of the variable 'volatile' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_volatile(CKeywords* handle, sc_boolean value);
/*! Gets the value of the variable 'while' that is defined in the default interface scope. */ 
extern sc_boolean cKeywordsIface_get_while(const CKeywords* handle);
/*! Sets the value of the variable 'while' that is defined in the default interface scope. */ 
extern void cKeywordsIface_set_while(CKeywords* handle, sc_boolean value);

/*!
 * Checks whether the state machine is active (until 2.4.1 this method was used for states).
 * A state machine is active if it was entered. It is inactive if it has not been entered at all or if it has been exited.
 */
extern sc_boolean cKeywords_isActive(const CKeywords* handle);

/*!
 * Checks if all active states are final. 
 * If there are no active states then the state machine is considered being inactive. In this case this method returns false.
 */
extern sc_boolean cKeywords_isFinal(const CKeywords* handle);

/*! Checks if the specified state is active (until 2.4.1 the used method for states was called isActive()). */
extern sc_boolean cKeywords_isStateActive(const CKeywords* handle, CKeywordsStates state);

#ifdef __cplusplus
}
#endif 

#endif /* CKEYWORDS_H_ */
