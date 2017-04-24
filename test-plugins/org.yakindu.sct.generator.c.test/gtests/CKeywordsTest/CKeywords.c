
#include <stdlib.h>
#include <string.h>
#include "sc_types.h"
#include "CKeywords.h"
/*! \file Implementation of the state machine 'CKeywords'
*/

/* prototypes of all internal functions */
static sc_boolean cKeywords_check_auto_char_tr0_tr0(const CKeywords* handle);
static void cKeywords_effect_auto_char_tr0(CKeywords* handle);
static void cKeywords_enact_auto_char(CKeywords* handle);
static void cKeywords_enact_auto_loop_switch_case_enum_asm(CKeywords* handle);
static void cKeywords_enseq_auto_char_default(CKeywords* handle);
static void cKeywords_enseq_auto_loop_default(CKeywords* handle);
static void cKeywords_enseq_auto_loop_switch_case_default(CKeywords* handle);
static void cKeywords_enseq_auto_loop_switch_case_enum_asm_default(CKeywords* handle);
static void cKeywords_enseq_auto_default(CKeywords* handle);
static void cKeywords_enseq_auto_loop_switch_default(CKeywords* handle);
static void cKeywords_shenseq_auto_loop_switch(CKeywords* handle);
static void cKeywords_enseq_auto_loop_switch_case_enum_default(CKeywords* handle);
static void cKeywords_dhenseq_auto_loop_switch_case_enum(CKeywords* handle);
static void cKeywords_exseq_auto_char(CKeywords* handle);
static void cKeywords_exseq_auto_loop_switch_case_enum_asm(CKeywords* handle);
static void cKeywords_exseq_auto(CKeywords* handle);
static void cKeywords_exseq_auto_loop_switch(CKeywords* handle);
static void cKeywords_exseq_auto_loop_switch_case_enum(CKeywords* handle);
static void cKeywords_react_auto_char(CKeywords* handle);
static void cKeywords_react_auto_loop_switch_case_enum_asm(CKeywords* handle);
static void cKeywords_react_auto__entry_Default(CKeywords* handle);
static void cKeywords_react_auto_loop_switch__entry_Default(CKeywords* handle);
static void cKeywords_react_auto_loop_switch_case_enum__entry_Default(CKeywords* handle);
static void cKeywords_clearInEvents(CKeywords* handle);
static void cKeywords_clearOutEvents(CKeywords* handle);


void cKeywords_init(CKeywords* handle)
{
	sc_integer i;

	for (i = 0; i < CKEYWORDS_MAX_ORTHOGONAL_STATES; ++i)
	{
		handle->stateConfVector[i] = CKeywords_last_state;
	}
	
	for (i = 0; i < CKEYWORDS_MAX_HISTORY_STATES; ++i)
	{
		handle->historyVector[i] = CKeywords_last_state;
	}
	
	handle->stateConfVectorPosition = 0;

	cKeywords_clearInEvents(handle);
	cKeywords_clearOutEvents(handle);

	/* Default init sequence for statechart CKeywords */
	handle->iface.case_ID = bool_false;
	handle->iface.do_ID = 0;
	handle->iface.continue_ID = bool_false;
	handle->iface.double_ID = bool_false;
	handle->iface.enum_ID = bool_false;
	handle->iface.extern_ID = bool_false;
	handle->iface.float_ID = bool_false;
	handle->iface.for_ID = bool_false;
	handle->iface.goto_ID = bool_false;
	handle->iface.if_ID = bool_false;
	handle->iface.int_ID = bool_false;
	handle->iface.long_ID = bool_false;
	handle->iface.register_ID = bool_false;
	handle->iface.return_ID = bool_false;
	handle->iface.short_ID = bool_false;
	handle->iface.signed_ID = bool_false;
	handle->iface.sizeof_ID = bool_false;
	handle->iface.static_ID = bool_false;
	handle->iface.struct_ID = bool_false;
	handle->iface.switch_ID = bool_false;
	handle->iface.typedef_ID = bool_false;
	handle->iface.union_ID = bool_false;
	handle->iface.unsigned_ID = bool_false;
	handle->iface.void_ID = bool_false;
	handle->iface.volatile_ID = bool_false;
	handle->iface.while_ID = bool_false;

}

void cKeywords_enter(CKeywords* handle)
{
	/* Default enter sequence for statechart CKeywords */
	cKeywords_enseq_auto_default(handle);
}

void cKeywords_exit(CKeywords* handle)
{
	/* Default exit sequence for statechart CKeywords */
	cKeywords_exseq_auto(handle);
}

sc_boolean cKeywords_isActive(const CKeywords* handle)
{
	sc_boolean result;
	if (handle->stateConfVector[0] != CKeywords_last_state)
	{
		result =  bool_true;
	}
	else
	{
		result = bool_false;
	}
	return result;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean cKeywords_isFinal(const CKeywords* handle)
{
   return bool_false;
}

static void cKeywords_clearInEvents(CKeywords* handle)
{
	handle->iface.auto_raised = bool_false;
	handle->iface.break_raised = bool_false;
}

static void cKeywords_clearOutEvents(CKeywords* handle)
{
}

void cKeywords_runCycle(CKeywords* handle)
{
	
	cKeywords_clearOutEvents(handle);
	
	for (handle->stateConfVectorPosition = 0;
		handle->stateConfVectorPosition < CKEYWORDS_MAX_ORTHOGONAL_STATES;
		handle->stateConfVectorPosition++)
		{
			
		switch (handle->stateConfVector[handle->stateConfVectorPosition])
		{
		case CKeywords_auto_char :
		{
			cKeywords_react_auto_char(handle);
			break;
		}
		case CKeywords_auto_loop_switch_case_enum_asm :
		{
			cKeywords_react_auto_loop_switch_case_enum_asm(handle);
			break;
		}
		default:
			break;
		}
	}
	
	cKeywords_clearInEvents(handle);
}


sc_boolean cKeywords_isStateActive(const CKeywords* handle, CKeywordsStates state)
{
	sc_boolean result = bool_false;
	switch (state)
	{
		case CKeywords_auto_char :
			result = (sc_boolean) (handle->stateConfVector[0] == CKeywords_auto_char
			);
			break;
		case CKeywords_auto_loop :
			result = (sc_boolean) (handle->stateConfVector[0] >= CKeywords_auto_loop
				&& handle->stateConfVector[0] <= CKeywords_auto_loop_switch_case_enum_asm);
			break;
		case CKeywords_auto_loop_switch_case :
			result = (sc_boolean) (handle->stateConfVector[0] >= CKeywords_auto_loop_switch_case
				&& handle->stateConfVector[0] <= CKeywords_auto_loop_switch_case_enum_asm);
			break;
		case CKeywords_auto_loop_switch_case_enum_asm :
			result = (sc_boolean) (handle->stateConfVector[0] == CKeywords_auto_loop_switch_case_enum_asm
			);
			break;
		default:
			result = bool_false;
			break;
	}
	return result;
}

void cKeywordsIface_raise_auto(CKeywords* handle)
{
	handle->iface.auto_raised = bool_true;
}
void cKeywordsIface_raise_break(CKeywords* handle)
{
	handle->iface.break_raised = bool_true;
}


sc_boolean cKeywordsIface_get_case(const CKeywords* handle)
{
	return handle->iface.case_ID;
}
void cKeywordsIface_set_case(CKeywords* handle, sc_boolean value)
{
	handle->iface.case_ID = value;
}
sc_integer cKeywordsIface_get_do(const CKeywords* handle)
{
	return handle->iface.do_ID;
}
void cKeywordsIface_set_do(CKeywords* handle, sc_integer value)
{
	handle->iface.do_ID = value;
}
sc_boolean cKeywordsIface_get_continue(const CKeywords* handle)
{
	return handle->iface.continue_ID;
}
void cKeywordsIface_set_continue(CKeywords* handle, sc_boolean value)
{
	handle->iface.continue_ID = value;
}
sc_boolean cKeywordsIface_get_double(const CKeywords* handle)
{
	return handle->iface.double_ID;
}
void cKeywordsIface_set_double(CKeywords* handle, sc_boolean value)
{
	handle->iface.double_ID = value;
}
sc_boolean cKeywordsIface_get_enum(const CKeywords* handle)
{
	return handle->iface.enum_ID;
}
void cKeywordsIface_set_enum(CKeywords* handle, sc_boolean value)
{
	handle->iface.enum_ID = value;
}
sc_boolean cKeywordsIface_get_extern(const CKeywords* handle)
{
	return handle->iface.extern_ID;
}
void cKeywordsIface_set_extern(CKeywords* handle, sc_boolean value)
{
	handle->iface.extern_ID = value;
}
sc_boolean cKeywordsIface_get_float(const CKeywords* handle)
{
	return handle->iface.float_ID;
}
void cKeywordsIface_set_float(CKeywords* handle, sc_boolean value)
{
	handle->iface.float_ID = value;
}
sc_boolean cKeywordsIface_get_for(const CKeywords* handle)
{
	return handle->iface.for_ID;
}
void cKeywordsIface_set_for(CKeywords* handle, sc_boolean value)
{
	handle->iface.for_ID = value;
}
sc_boolean cKeywordsIface_get_goto(const CKeywords* handle)
{
	return handle->iface.goto_ID;
}
void cKeywordsIface_set_goto(CKeywords* handle, sc_boolean value)
{
	handle->iface.goto_ID = value;
}
sc_boolean cKeywordsIface_get_if(const CKeywords* handle)
{
	return handle->iface.if_ID;
}
void cKeywordsIface_set_if(CKeywords* handle, sc_boolean value)
{
	handle->iface.if_ID = value;
}
sc_boolean cKeywordsIface_get_int(const CKeywords* handle)
{
	return handle->iface.int_ID;
}
void cKeywordsIface_set_int(CKeywords* handle, sc_boolean value)
{
	handle->iface.int_ID = value;
}
sc_boolean cKeywordsIface_get_long(const CKeywords* handle)
{
	return handle->iface.long_ID;
}
void cKeywordsIface_set_long(CKeywords* handle, sc_boolean value)
{
	handle->iface.long_ID = value;
}
sc_boolean cKeywordsIface_get_register(const CKeywords* handle)
{
	return handle->iface.register_ID;
}
void cKeywordsIface_set_register(CKeywords* handle, sc_boolean value)
{
	handle->iface.register_ID = value;
}
sc_boolean cKeywordsIface_get_return(const CKeywords* handle)
{
	return handle->iface.return_ID;
}
void cKeywordsIface_set_return(CKeywords* handle, sc_boolean value)
{
	handle->iface.return_ID = value;
}
sc_boolean cKeywordsIface_get_short(const CKeywords* handle)
{
	return handle->iface.short_ID;
}
void cKeywordsIface_set_short(CKeywords* handle, sc_boolean value)
{
	handle->iface.short_ID = value;
}
sc_boolean cKeywordsIface_get_signed(const CKeywords* handle)
{
	return handle->iface.signed_ID;
}
void cKeywordsIface_set_signed(CKeywords* handle, sc_boolean value)
{
	handle->iface.signed_ID = value;
}
sc_boolean cKeywordsIface_get_sizeof(const CKeywords* handle)
{
	return handle->iface.sizeof_ID;
}
void cKeywordsIface_set_sizeof(CKeywords* handle, sc_boolean value)
{
	handle->iface.sizeof_ID = value;
}
sc_boolean cKeywordsIface_get_static(const CKeywords* handle)
{
	return handle->iface.static_ID;
}
void cKeywordsIface_set_static(CKeywords* handle, sc_boolean value)
{
	handle->iface.static_ID = value;
}
sc_boolean cKeywordsIface_get_struct(const CKeywords* handle)
{
	return handle->iface.struct_ID;
}
void cKeywordsIface_set_struct(CKeywords* handle, sc_boolean value)
{
	handle->iface.struct_ID = value;
}
sc_boolean cKeywordsIface_get_switch(const CKeywords* handle)
{
	return handle->iface.switch_ID;
}
void cKeywordsIface_set_switch(CKeywords* handle, sc_boolean value)
{
	handle->iface.switch_ID = value;
}
sc_boolean cKeywordsIface_get_typedef(const CKeywords* handle)
{
	return handle->iface.typedef_ID;
}
void cKeywordsIface_set_typedef(CKeywords* handle, sc_boolean value)
{
	handle->iface.typedef_ID = value;
}
sc_boolean cKeywordsIface_get_union(const CKeywords* handle)
{
	return handle->iface.union_ID;
}
void cKeywordsIface_set_union(CKeywords* handle, sc_boolean value)
{
	handle->iface.union_ID = value;
}
sc_boolean cKeywordsIface_get_unsigned(const CKeywords* handle)
{
	return handle->iface.unsigned_ID;
}
void cKeywordsIface_set_unsigned(CKeywords* handle, sc_boolean value)
{
	handle->iface.unsigned_ID = value;
}
sc_boolean cKeywordsIface_get_void(const CKeywords* handle)
{
	return handle->iface.void_ID;
}
void cKeywordsIface_set_void(CKeywords* handle, sc_boolean value)
{
	handle->iface.void_ID = value;
}
sc_boolean cKeywordsIface_get_volatile(const CKeywords* handle)
{
	return handle->iface.volatile_ID;
}
void cKeywordsIface_set_volatile(CKeywords* handle, sc_boolean value)
{
	handle->iface.volatile_ID = value;
}
sc_boolean cKeywordsIface_get_while(const CKeywords* handle)
{
	return handle->iface.while_ID;
}
void cKeywordsIface_set_while(CKeywords* handle, sc_boolean value)
{
	handle->iface.while_ID = value;
}

/* implementations of all internal functions */

static sc_boolean cKeywords_check_auto_char_tr0_tr0(const CKeywords* handle)
{
	return ((handle->iface.auto_raised) && (handle->iface.case_ID)) ? bool_true : bool_false;
}

static void cKeywords_effect_auto_char_tr0(CKeywords* handle)
{
	cKeywords_exseq_auto_char(handle);
	handle->iface.do_ID += 1;
	cKeywords_enseq_auto_loop_default(handle);
}

/* Entry action for state 'char'. */
static void cKeywords_enact_auto_char(CKeywords* handle)
{
	/* Entry action for state 'char'. */
	handle->iface.case_ID = bool_true;
	handle->iface.do_ID = 0;
	handle->iface.continue_ID = bool_true;
	handle->iface.double_ID = bool_true;
	handle->iface.enum_ID = bool_true;
	handle->iface.extern_ID = bool_true;
	handle->iface.float_ID = bool_true;
	handle->iface.for_ID = bool_true;
	handle->iface.goto_ID = bool_true;
	handle->iface.if_ID = bool_true;
	handle->iface.int_ID = bool_true;
	handle->iface.long_ID = bool_true;
	handle->iface.register_ID = bool_true;
	handle->iface.return_ID = bool_true;
	handle->iface.short_ID = bool_true;
	handle->iface.signed_ID = bool_true;
	handle->iface.sizeof_ID = bool_true;
	handle->iface.static_ID = bool_true;
	handle->iface.struct_ID = bool_true;
	handle->iface.switch_ID = bool_true;
	handle->iface.typedef_ID = bool_true;
	handle->iface.union_ID = bool_true;
	handle->iface.unsigned_ID = bool_true;
	handle->iface.void_ID = bool_true;
	handle->iface.volatile_ID = bool_true;
	handle->iface.while_ID = bool_true;
}

/* Entry action for state 'asm'. */
static void cKeywords_enact_auto_loop_switch_case_enum_asm(CKeywords* handle)
{
	/* Entry action for state 'asm'. */
	handle->iface.case_ID = bool_false;
	handle->iface.do_ID = 0;
	handle->iface.continue_ID = bool_false;
	handle->iface.double_ID = bool_false;
	handle->iface.enum_ID = bool_false;
	handle->iface.extern_ID = bool_false;
	handle->iface.float_ID = bool_false;
	handle->iface.for_ID = bool_false;
	handle->iface.goto_ID = bool_false;
	handle->iface.if_ID = bool_false;
	handle->iface.int_ID = bool_false;
	handle->iface.long_ID = bool_false;
	handle->iface.register_ID = bool_false;
	handle->iface.return_ID = bool_false;
	handle->iface.short_ID = bool_false;
	handle->iface.signed_ID = bool_false;
	handle->iface.sizeof_ID = bool_false;
	handle->iface.static_ID = bool_false;
	handle->iface.struct_ID = bool_false;
	handle->iface.switch_ID = bool_false;
	handle->iface.typedef_ID = bool_false;
	handle->iface.union_ID = bool_false;
	handle->iface.unsigned_ID = bool_false;
	handle->iface.void_ID = bool_false;
	handle->iface.volatile_ID = bool_false;
	handle->iface.while_ID = bool_false;
}

/* 'default' enter sequence for state char */
static void cKeywords_enseq_auto_char_default(CKeywords* handle)
{
	/* 'default' enter sequence for state char */
	cKeywords_enact_auto_char(handle);
	handle->stateConfVector[0] = CKeywords_auto_char;
	handle->stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state loop */
static void cKeywords_enseq_auto_loop_default(CKeywords* handle)
{
	/* 'default' enter sequence for state loop */
	cKeywords_enseq_auto_loop_switch_default(handle);
}

/* 'default' enter sequence for state case */
static void cKeywords_enseq_auto_loop_switch_case_default(CKeywords* handle)
{
	/* 'default' enter sequence for state case */
	cKeywords_enseq_auto_loop_switch_case_enum_default(handle);
	handle->historyVector[0] = handle->stateConfVector[0];
}

/* 'default' enter sequence for state asm */
static void cKeywords_enseq_auto_loop_switch_case_enum_asm_default(CKeywords* handle)
{
	/* 'default' enter sequence for state asm */
	cKeywords_enact_auto_loop_switch_case_enum_asm(handle);
	handle->stateConfVector[0] = CKeywords_auto_loop_switch_case_enum_asm;
	handle->stateConfVectorPosition = 0;
	handle->historyVector[1] = handle->stateConfVector[0];
}

/* 'default' enter sequence for region auto */
static void cKeywords_enseq_auto_default(CKeywords* handle)
{
	/* 'default' enter sequence for region auto */
	cKeywords_react_auto__entry_Default(handle);
}

/* 'default' enter sequence for region switch */
static void cKeywords_enseq_auto_loop_switch_default(CKeywords* handle)
{
	/* 'default' enter sequence for region switch */
	cKeywords_react_auto_loop_switch__entry_Default(handle);
}

/* shallow enterSequence with history in child switch */
static void cKeywords_shenseq_auto_loop_switch(CKeywords* handle)
{
	/* shallow enterSequence with history in child switch */
	/* Handle shallow history entry of switch */
	switch(handle->historyVector[ 0 ])
	{
		case CKeywords_auto_loop_switch_case_enum_asm :
		{
			cKeywords_enseq_auto_loop_switch_case_default(handle);
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region enum */
static void cKeywords_enseq_auto_loop_switch_case_enum_default(CKeywords* handle)
{
	/* 'default' enter sequence for region enum */
	cKeywords_react_auto_loop_switch_case_enum__entry_Default(handle);
}

/* deep enterSequence with history in child enum */
static void cKeywords_dhenseq_auto_loop_switch_case_enum(CKeywords* handle)
{
	/* deep enterSequence with history in child enum */
	/* Handle deep history entry of enum */
	switch(handle->historyVector[ 1 ])
	{
		case CKeywords_auto_loop_switch_case_enum_asm :
		{
			/* enterSequence with history in child asm for leaf asm */
			cKeywords_enseq_auto_loop_switch_case_enum_asm_default(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for state char */
static void cKeywords_exseq_auto_char(CKeywords* handle)
{
	/* Default exit sequence for state char */
	handle->stateConfVector[0] = CKeywords_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for state asm */
static void cKeywords_exseq_auto_loop_switch_case_enum_asm(CKeywords* handle)
{
	/* Default exit sequence for state asm */
	handle->stateConfVector[0] = CKeywords_last_state;
	handle->stateConfVectorPosition = 0;
}

/* Default exit sequence for region auto */
static void cKeywords_exseq_auto(CKeywords* handle)
{
	/* Default exit sequence for region auto */
	/* Handle exit of all possible states (of CKeywords.auto) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case CKeywords_auto_char :
		{
			cKeywords_exseq_auto_char(handle);
			break;
		}
		case CKeywords_auto_loop_switch_case_enum_asm :
		{
			cKeywords_exseq_auto_loop_switch_case_enum_asm(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region switch */
static void cKeywords_exseq_auto_loop_switch(CKeywords* handle)
{
	/* Default exit sequence for region switch */
	/* Handle exit of all possible states (of CKeywords.auto.loop.switch) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case CKeywords_auto_loop_switch_case_enum_asm :
		{
			cKeywords_exseq_auto_loop_switch_case_enum_asm(handle);
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region enum */
static void cKeywords_exseq_auto_loop_switch_case_enum(CKeywords* handle)
{
	/* Default exit sequence for region enum */
	/* Handle exit of all possible states (of CKeywords.auto.loop.switch.case.enum) at position 0... */
	switch(handle->stateConfVector[ 0 ])
	{
		case CKeywords_auto_loop_switch_case_enum_asm :
		{
			cKeywords_exseq_auto_loop_switch_case_enum_asm(handle);
			break;
		}
		default: break;
	}
}

/* The reactions of state char. */
static void cKeywords_react_auto_char(CKeywords* handle)
{
	/* The reactions of state char. */
	if (cKeywords_check_auto_char_tr0_tr0(handle) == bool_true)
	{ 
		cKeywords_effect_auto_char_tr0(handle);
	} 
}

/* The reactions of state asm. */
static void cKeywords_react_auto_loop_switch_case_enum_asm(CKeywords* handle)
{
	/* The reactions of state asm. */
}

/* Default react sequence for initial entry  */
static void cKeywords_react_auto__entry_Default(CKeywords* handle)
{
	/* Default react sequence for initial entry  */
	cKeywords_enseq_auto_char_default(handle);
}

/* Default react sequence for shallow history entry  */
static void cKeywords_react_auto_loop_switch__entry_Default(CKeywords* handle)
{
	/* Default react sequence for shallow history entry  */
	/* Enter the region with shallow history */
	if (handle->historyVector[0] != CKeywords_last_state)
	{
		cKeywords_shenseq_auto_loop_switch(handle);
	} else
	{
		cKeywords_enseq_auto_loop_switch_case_default(handle);
	} 
}

/* Default react sequence for deep history entry  */
static void cKeywords_react_auto_loop_switch_case_enum__entry_Default(CKeywords* handle)
{
	/* Default react sequence for deep history entry  */
	/* Enter the region with deep history */
	if (handle->historyVector[1] != CKeywords_last_state)
	{
		cKeywords_dhenseq_auto_loop_switch_case_enum(handle);
	} else
	{
		cKeywords_enseq_auto_loop_switch_case_enum_asm_default(handle);
	} 
}


