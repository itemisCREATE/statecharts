
#include "CKeywords.h"
#include <string.h>

/*! \file Implementation of the state machine 'CKeywords'
*/

CKeywords::CKeywords()
{
	
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = CKeywords_last_state;
	
	stateConfVectorPosition = 0;
	
}

CKeywords::~CKeywords()
{
}


void CKeywords::init()
{
	for (int i = 0; i < maxOrthogonalStates; ++i)
		stateConfVector[i] = CKeywords_last_state;
	
	for (int i = 0; i < maxHistoryStates; ++i)
		historyVector[i] = CKeywords_last_state;
	
	stateConfVectorPosition = 0;

	clearInEvents();
	clearOutEvents();
	
	/* Default init sequence for statechart CKeywords */
	iface.case_ID = false;
	iface.do_ID = 0;
	iface.continue_ID = false;
	iface.double_ID = false;
	iface.enum_ID = false;
	iface.extern_ID = false;
	iface.float_ID = false;
	iface.for_ID = false;
	iface.goto_ID = false;
	iface.if_ID = false;
	iface.int_ID = false;
	iface.long_ID = false;
	iface.register_ID = false;
	iface.return_ID = false;
	iface.short_ID = false;
	iface.signed_ID = false;
	iface.sizeof_ID = false;
	iface.static_ID = false;
	iface.struct_ID = false;
	iface.switch_ID = false;
	iface.typedef_ID = false;
	iface.union_ID = false;
	iface.unsigned_ID = false;
	iface.void_ID = false;
	iface.volatile_ID = false;
	iface.while_ID = false;
}

void CKeywords::enter()
{
	/* Default enter sequence for statechart CKeywords */
	enseq_auto_default();
}

void CKeywords::exit()
{
	/* Default exit sequence for statechart CKeywords */
	exseq_auto();
}

sc_boolean CKeywords::isActive() const
{
	return stateConfVector[0] != CKeywords_last_state;
}

/* 
 * Always returns 'false' since this state machine can never become final.
 */
sc_boolean CKeywords::isFinal() const
{
   return false;}

void CKeywords::runCycle()
{
	
	clearOutEvents();
	
	for (stateConfVectorPosition = 0;
		stateConfVectorPosition < maxOrthogonalStates;
		stateConfVectorPosition++)
		{
			
		switch (stateConfVector[stateConfVectorPosition])
		{
		case auto_char :
		{
			react_auto_char();
			break;
		}
		case auto_loop_switch_case_enum_asm :
		{
			react_auto_loop_switch_case_enum_asm();
			break;
		}
		default:
			break;
		}
	}
	
	clearInEvents();
}

void CKeywords::clearInEvents()
{
	iface.auto_raised = false;
	iface.break_raised = false;
}

void CKeywords::clearOutEvents()
{
}


sc_boolean CKeywords::isStateActive(CKeywordsStates state) const
{
	switch (state)
	{
		case auto_char : 
			return (sc_boolean) (stateConfVector[0] == auto_char
			);
		case auto_loop : 
			return (sc_boolean) (stateConfVector[0] >= auto_loop
				&& stateConfVector[0] <= auto_loop_switch_case_enum_asm);
		case auto_loop_switch_case : 
			return (sc_boolean) (stateConfVector[0] >= auto_loop_switch_case
				&& stateConfVector[0] <= auto_loop_switch_case_enum_asm);
		case auto_loop_switch_case_enum_asm : 
			return (sc_boolean) (stateConfVector[0] == auto_loop_switch_case_enum_asm
			);
		default: return false;
	}
}

CKeywords::DefaultSCI* CKeywords::getDefaultSCI()
{
	return &iface;
}

void CKeywords::DefaultSCI::raise_auto()
{
	auto_raised = true;
}

void CKeywords::raise_auto()
{
	iface.raise_auto();
}

void CKeywords::DefaultSCI::raise_break()
{
	break_raised = true;
}

void CKeywords::raise_break()
{
	iface.raise_break();
}


sc_boolean CKeywords::DefaultSCI::get_case() const
{
	return case_ID;
}

sc_boolean CKeywords::get_case() const
{
	return iface.case_ID;
}

void CKeywords::DefaultSCI::set_case(sc_boolean value)
{
	case_ID = value;
}

void CKeywords::set_case(sc_boolean value)
{
	iface.case_ID = value;
}

sc_integer CKeywords::DefaultSCI::get_do() const
{
	return do_ID;
}

sc_integer CKeywords::get_do() const
{
	return iface.do_ID;
}

void CKeywords::DefaultSCI::set_do(sc_integer value)
{
	do_ID = value;
}

void CKeywords::set_do(sc_integer value)
{
	iface.do_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_continue() const
{
	return continue_ID;
}

sc_boolean CKeywords::get_continue() const
{
	return iface.continue_ID;
}

void CKeywords::DefaultSCI::set_continue(sc_boolean value)
{
	continue_ID = value;
}

void CKeywords::set_continue(sc_boolean value)
{
	iface.continue_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_double() const
{
	return double_ID;
}

sc_boolean CKeywords::get_double() const
{
	return iface.double_ID;
}

void CKeywords::DefaultSCI::set_double(sc_boolean value)
{
	double_ID = value;
}

void CKeywords::set_double(sc_boolean value)
{
	iface.double_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_enum() const
{
	return enum_ID;
}

sc_boolean CKeywords::get_enum() const
{
	return iface.enum_ID;
}

void CKeywords::DefaultSCI::set_enum(sc_boolean value)
{
	enum_ID = value;
}

void CKeywords::set_enum(sc_boolean value)
{
	iface.enum_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_extern() const
{
	return extern_ID;
}

sc_boolean CKeywords::get_extern() const
{
	return iface.extern_ID;
}

void CKeywords::DefaultSCI::set_extern(sc_boolean value)
{
	extern_ID = value;
}

void CKeywords::set_extern(sc_boolean value)
{
	iface.extern_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_float() const
{
	return float_ID;
}

sc_boolean CKeywords::get_float() const
{
	return iface.float_ID;
}

void CKeywords::DefaultSCI::set_float(sc_boolean value)
{
	float_ID = value;
}

void CKeywords::set_float(sc_boolean value)
{
	iface.float_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_for() const
{
	return for_ID;
}

sc_boolean CKeywords::get_for() const
{
	return iface.for_ID;
}

void CKeywords::DefaultSCI::set_for(sc_boolean value)
{
	for_ID = value;
}

void CKeywords::set_for(sc_boolean value)
{
	iface.for_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_goto() const
{
	return goto_ID;
}

sc_boolean CKeywords::get_goto() const
{
	return iface.goto_ID;
}

void CKeywords::DefaultSCI::set_goto(sc_boolean value)
{
	goto_ID = value;
}

void CKeywords::set_goto(sc_boolean value)
{
	iface.goto_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_if() const
{
	return if_ID;
}

sc_boolean CKeywords::get_if() const
{
	return iface.if_ID;
}

void CKeywords::DefaultSCI::set_if(sc_boolean value)
{
	if_ID = value;
}

void CKeywords::set_if(sc_boolean value)
{
	iface.if_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_int() const
{
	return int_ID;
}

sc_boolean CKeywords::get_int() const
{
	return iface.int_ID;
}

void CKeywords::DefaultSCI::set_int(sc_boolean value)
{
	int_ID = value;
}

void CKeywords::set_int(sc_boolean value)
{
	iface.int_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_long() const
{
	return long_ID;
}

sc_boolean CKeywords::get_long() const
{
	return iface.long_ID;
}

void CKeywords::DefaultSCI::set_long(sc_boolean value)
{
	long_ID = value;
}

void CKeywords::set_long(sc_boolean value)
{
	iface.long_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_register() const
{
	return register_ID;
}

sc_boolean CKeywords::get_register() const
{
	return iface.register_ID;
}

void CKeywords::DefaultSCI::set_register(sc_boolean value)
{
	register_ID = value;
}

void CKeywords::set_register(sc_boolean value)
{
	iface.register_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_return() const
{
	return return_ID;
}

sc_boolean CKeywords::get_return() const
{
	return iface.return_ID;
}

void CKeywords::DefaultSCI::set_return(sc_boolean value)
{
	return_ID = value;
}

void CKeywords::set_return(sc_boolean value)
{
	iface.return_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_short() const
{
	return short_ID;
}

sc_boolean CKeywords::get_short() const
{
	return iface.short_ID;
}

void CKeywords::DefaultSCI::set_short(sc_boolean value)
{
	short_ID = value;
}

void CKeywords::set_short(sc_boolean value)
{
	iface.short_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_signed() const
{
	return signed_ID;
}

sc_boolean CKeywords::get_signed() const
{
	return iface.signed_ID;
}

void CKeywords::DefaultSCI::set_signed(sc_boolean value)
{
	signed_ID = value;
}

void CKeywords::set_signed(sc_boolean value)
{
	iface.signed_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_sizeof() const
{
	return sizeof_ID;
}

sc_boolean CKeywords::get_sizeof() const
{
	return iface.sizeof_ID;
}

void CKeywords::DefaultSCI::set_sizeof(sc_boolean value)
{
	sizeof_ID = value;
}

void CKeywords::set_sizeof(sc_boolean value)
{
	iface.sizeof_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_static() const
{
	return static_ID;
}

sc_boolean CKeywords::get_static() const
{
	return iface.static_ID;
}

void CKeywords::DefaultSCI::set_static(sc_boolean value)
{
	static_ID = value;
}

void CKeywords::set_static(sc_boolean value)
{
	iface.static_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_struct() const
{
	return struct_ID;
}

sc_boolean CKeywords::get_struct() const
{
	return iface.struct_ID;
}

void CKeywords::DefaultSCI::set_struct(sc_boolean value)
{
	struct_ID = value;
}

void CKeywords::set_struct(sc_boolean value)
{
	iface.struct_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_switch() const
{
	return switch_ID;
}

sc_boolean CKeywords::get_switch() const
{
	return iface.switch_ID;
}

void CKeywords::DefaultSCI::set_switch(sc_boolean value)
{
	switch_ID = value;
}

void CKeywords::set_switch(sc_boolean value)
{
	iface.switch_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_typedef() const
{
	return typedef_ID;
}

sc_boolean CKeywords::get_typedef() const
{
	return iface.typedef_ID;
}

void CKeywords::DefaultSCI::set_typedef(sc_boolean value)
{
	typedef_ID = value;
}

void CKeywords::set_typedef(sc_boolean value)
{
	iface.typedef_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_union() const
{
	return union_ID;
}

sc_boolean CKeywords::get_union() const
{
	return iface.union_ID;
}

void CKeywords::DefaultSCI::set_union(sc_boolean value)
{
	union_ID = value;
}

void CKeywords::set_union(sc_boolean value)
{
	iface.union_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_unsigned() const
{
	return unsigned_ID;
}

sc_boolean CKeywords::get_unsigned() const
{
	return iface.unsigned_ID;
}

void CKeywords::DefaultSCI::set_unsigned(sc_boolean value)
{
	unsigned_ID = value;
}

void CKeywords::set_unsigned(sc_boolean value)
{
	iface.unsigned_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_void() const
{
	return void_ID;
}

sc_boolean CKeywords::get_void() const
{
	return iface.void_ID;
}

void CKeywords::DefaultSCI::set_void(sc_boolean value)
{
	void_ID = value;
}

void CKeywords::set_void(sc_boolean value)
{
	iface.void_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_volatile() const
{
	return volatile_ID;
}

sc_boolean CKeywords::get_volatile() const
{
	return iface.volatile_ID;
}

void CKeywords::DefaultSCI::set_volatile(sc_boolean value)
{
	volatile_ID = value;
}

void CKeywords::set_volatile(sc_boolean value)
{
	iface.volatile_ID = value;
}

sc_boolean CKeywords::DefaultSCI::get_while() const
{
	return while_ID;
}

sc_boolean CKeywords::get_while() const
{
	return iface.while_ID;
}

void CKeywords::DefaultSCI::set_while(sc_boolean value)
{
	while_ID = value;
}

void CKeywords::set_while(sc_boolean value)
{
	iface.while_ID = value;
}


// implementations of all internal functions

sc_boolean CKeywords::check_auto_char_tr0_tr0()
{
	return (iface.auto_raised) && (iface.case_ID);
}

void CKeywords::effect_auto_char_tr0()
{
	exseq_auto_char();
	iface.do_ID += 1;
	enseq_auto_loop_default();
}

/* Entry action for state 'char'. */
void CKeywords::enact_auto_char()
{
	/* Entry action for state 'char'. */
	iface.case_ID = true;
	iface.do_ID = 0;
	iface.continue_ID = true;
	iface.double_ID = true;
	iface.enum_ID = true;
	iface.extern_ID = true;
	iface.float_ID = true;
	iface.for_ID = true;
	iface.goto_ID = true;
	iface.if_ID = true;
	iface.int_ID = true;
	iface.long_ID = true;
	iface.register_ID = true;
	iface.return_ID = true;
	iface.short_ID = true;
	iface.signed_ID = true;
	iface.sizeof_ID = true;
	iface.static_ID = true;
	iface.struct_ID = true;
	iface.switch_ID = true;
	iface.typedef_ID = true;
	iface.union_ID = true;
	iface.unsigned_ID = true;
	iface.void_ID = true;
	iface.volatile_ID = true;
	iface.while_ID = true;
}

/* Entry action for state 'asm'. */
void CKeywords::enact_auto_loop_switch_case_enum_asm()
{
	/* Entry action for state 'asm'. */
	iface.case_ID = false;
	iface.do_ID = 0;
	iface.continue_ID = false;
	iface.double_ID = false;
	iface.enum_ID = false;
	iface.extern_ID = false;
	iface.float_ID = false;
	iface.for_ID = false;
	iface.goto_ID = false;
	iface.if_ID = false;
	iface.int_ID = false;
	iface.long_ID = false;
	iface.register_ID = false;
	iface.return_ID = false;
	iface.short_ID = false;
	iface.signed_ID = false;
	iface.sizeof_ID = false;
	iface.static_ID = false;
	iface.struct_ID = false;
	iface.switch_ID = false;
	iface.typedef_ID = false;
	iface.union_ID = false;
	iface.unsigned_ID = false;
	iface.void_ID = false;
	iface.volatile_ID = false;
	iface.while_ID = false;
}

/* 'default' enter sequence for state char */
void CKeywords::enseq_auto_char_default()
{
	/* 'default' enter sequence for state char */
	enact_auto_char();
	stateConfVector[0] = auto_char;
	stateConfVectorPosition = 0;
}

/* 'default' enter sequence for state loop */
void CKeywords::enseq_auto_loop_default()
{
	/* 'default' enter sequence for state loop */
	enseq_auto_loop_switch_default();
}

/* 'default' enter sequence for state case */
void CKeywords::enseq_auto_loop_switch_case_default()
{
	/* 'default' enter sequence for state case */
	enseq_auto_loop_switch_case_enum_default();
	historyVector[0] = stateConfVector[0];
}

/* 'default' enter sequence for state asm */
void CKeywords::enseq_auto_loop_switch_case_enum_asm_default()
{
	/* 'default' enter sequence for state asm */
	enact_auto_loop_switch_case_enum_asm();
	stateConfVector[0] = auto_loop_switch_case_enum_asm;
	stateConfVectorPosition = 0;
	historyVector[1] = stateConfVector[0];
}

/* 'default' enter sequence for region auto */
void CKeywords::enseq_auto_default()
{
	/* 'default' enter sequence for region auto */
	react_auto__entry_Default();
}

/* 'default' enter sequence for region switch */
void CKeywords::enseq_auto_loop_switch_default()
{
	/* 'default' enter sequence for region switch */
	react_auto_loop_switch__entry_Default();
}

/* shallow enterSequence with history in child switch */
void CKeywords::shenseq_auto_loop_switch()
{
	/* shallow enterSequence with history in child switch */
	/* Handle shallow history entry of switch */
	switch(historyVector[ 0 ])
	{
		case auto_loop_switch_case_enum_asm :
		{
			enseq_auto_loop_switch_case_default();
			break;
		}
		default: break;
	}
}

/* 'default' enter sequence for region enum */
void CKeywords::enseq_auto_loop_switch_case_enum_default()
{
	/* 'default' enter sequence for region enum */
	react_auto_loop_switch_case_enum__entry_Default();
}

/* deep enterSequence with history in child enum */
void CKeywords::dhenseq_auto_loop_switch_case_enum()
{
	/* deep enterSequence with history in child enum */
	/* Handle deep history entry of enum */
	switch(historyVector[ 1 ])
	{
		case auto_loop_switch_case_enum_asm :
		{
			/* enterSequence with history in child asm for leaf asm */
			enseq_auto_loop_switch_case_enum_asm_default();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for state char */
void CKeywords::exseq_auto_char()
{
	/* Default exit sequence for state char */
	stateConfVector[0] = CKeywords_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for state asm */
void CKeywords::exseq_auto_loop_switch_case_enum_asm()
{
	/* Default exit sequence for state asm */
	stateConfVector[0] = CKeywords_last_state;
	stateConfVectorPosition = 0;
}

/* Default exit sequence for region auto */
void CKeywords::exseq_auto()
{
	/* Default exit sequence for region auto */
	/* Handle exit of all possible states (of CKeywords.auto) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case auto_char :
		{
			exseq_auto_char();
			break;
		}
		case auto_loop_switch_case_enum_asm :
		{
			exseq_auto_loop_switch_case_enum_asm();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region switch */
void CKeywords::exseq_auto_loop_switch()
{
	/* Default exit sequence for region switch */
	/* Handle exit of all possible states (of CKeywords.auto.loop.switch) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case auto_loop_switch_case_enum_asm :
		{
			exseq_auto_loop_switch_case_enum_asm();
			break;
		}
		default: break;
	}
}

/* Default exit sequence for region enum */
void CKeywords::exseq_auto_loop_switch_case_enum()
{
	/* Default exit sequence for region enum */
	/* Handle exit of all possible states (of CKeywords.auto.loop.switch.case.enum) at position 0... */
	switch(stateConfVector[ 0 ])
	{
		case auto_loop_switch_case_enum_asm :
		{
			exseq_auto_loop_switch_case_enum_asm();
			break;
		}
		default: break;
	}
}

/* The reactions of state char. */
void CKeywords::react_auto_char()
{
	/* The reactions of state char. */
	if (check_auto_char_tr0_tr0())
	{ 
		effect_auto_char_tr0();
	} 
}

/* The reactions of state asm. */
void CKeywords::react_auto_loop_switch_case_enum_asm()
{
	/* The reactions of state asm. */
}

/* Default react sequence for initial entry  */
void CKeywords::react_auto__entry_Default()
{
	/* Default react sequence for initial entry  */
	enseq_auto_char_default();
}

/* Default react sequence for shallow history entry  */
void CKeywords::react_auto_loop_switch__entry_Default()
{
	/* Default react sequence for shallow history entry  */
	/* Enter the region with shallow history */
	if (historyVector[0] != CKeywords_last_state)
	{
		shenseq_auto_loop_switch();
	} else
	{
		enseq_auto_loop_switch_case_default();
	} 
}

/* Default react sequence for deep history entry  */
void CKeywords::react_auto_loop_switch_case_enum__entry_Default()
{
	/* Default react sequence for deep history entry  */
	/* Enter the region with deep history */
	if (historyVector[1] != CKeywords_last_state)
	{
		dhenseq_auto_loop_switch_case_enum();
	} else
	{
		enseq_auto_loop_switch_case_enum_asm_default();
	} 
}


