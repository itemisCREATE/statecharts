
#ifndef CKEYWORDS_H_
#define CKEYWORDS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'CKeywords'.
*/

class CKeywords : public StatemachineInterface
{
	
	public:
		
		CKeywords();
		
		~CKeywords();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			auto_char,
			auto_loop,
			auto_loop_switch_case,
			auto_loop_switch_case_enum_asm,
			CKeywords_last_state
		} CKeywordsStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'auto' that is defined in the default interface scope. */
				void raise_auto();
				
				/*! Raises the in event 'break' that is defined in the default interface scope. */
				void raise_break();
				
				/*! Gets the value of the variable 'case' that is defined in the default interface scope. */
				sc_boolean get_case() const;
				
				/*! Sets the value of the variable 'case' that is defined in the default interface scope. */
				void set_case(sc_boolean value);
				
				/*! Gets the value of the variable 'do' that is defined in the default interface scope. */
				sc_integer get_do() const;
				
				/*! Sets the value of the variable 'do' that is defined in the default interface scope. */
				void set_do(sc_integer value);
				
				/*! Gets the value of the variable 'continue' that is defined in the default interface scope. */
				sc_boolean get_continue() const;
				
				/*! Sets the value of the variable 'continue' that is defined in the default interface scope. */
				void set_continue(sc_boolean value);
				
				/*! Gets the value of the variable 'double' that is defined in the default interface scope. */
				sc_boolean get_double() const;
				
				/*! Sets the value of the variable 'double' that is defined in the default interface scope. */
				void set_double(sc_boolean value);
				
				/*! Gets the value of the variable 'enum' that is defined in the default interface scope. */
				sc_boolean get_enum() const;
				
				/*! Sets the value of the variable 'enum' that is defined in the default interface scope. */
				void set_enum(sc_boolean value);
				
				/*! Gets the value of the variable 'extern' that is defined in the default interface scope. */
				sc_boolean get_extern() const;
				
				/*! Sets the value of the variable 'extern' that is defined in the default interface scope. */
				void set_extern(sc_boolean value);
				
				/*! Gets the value of the variable 'float' that is defined in the default interface scope. */
				sc_boolean get_float() const;
				
				/*! Sets the value of the variable 'float' that is defined in the default interface scope. */
				void set_float(sc_boolean value);
				
				/*! Gets the value of the variable 'for' that is defined in the default interface scope. */
				sc_boolean get_for() const;
				
				/*! Sets the value of the variable 'for' that is defined in the default interface scope. */
				void set_for(sc_boolean value);
				
				/*! Gets the value of the variable 'goto' that is defined in the default interface scope. */
				sc_boolean get_goto() const;
				
				/*! Sets the value of the variable 'goto' that is defined in the default interface scope. */
				void set_goto(sc_boolean value);
				
				/*! Gets the value of the variable 'if' that is defined in the default interface scope. */
				sc_boolean get_if() const;
				
				/*! Sets the value of the variable 'if' that is defined in the default interface scope. */
				void set_if(sc_boolean value);
				
				/*! Gets the value of the variable 'int' that is defined in the default interface scope. */
				sc_boolean get_int() const;
				
				/*! Sets the value of the variable 'int' that is defined in the default interface scope. */
				void set_int(sc_boolean value);
				
				/*! Gets the value of the variable 'long' that is defined in the default interface scope. */
				sc_boolean get_long() const;
				
				/*! Sets the value of the variable 'long' that is defined in the default interface scope. */
				void set_long(sc_boolean value);
				
				/*! Gets the value of the variable 'register' that is defined in the default interface scope. */
				sc_boolean get_register() const;
				
				/*! Sets the value of the variable 'register' that is defined in the default interface scope. */
				void set_register(sc_boolean value);
				
				/*! Gets the value of the variable 'return' that is defined in the default interface scope. */
				sc_boolean get_return() const;
				
				/*! Sets the value of the variable 'return' that is defined in the default interface scope. */
				void set_return(sc_boolean value);
				
				/*! Gets the value of the variable 'short' that is defined in the default interface scope. */
				sc_boolean get_short() const;
				
				/*! Sets the value of the variable 'short' that is defined in the default interface scope. */
				void set_short(sc_boolean value);
				
				/*! Gets the value of the variable 'signed' that is defined in the default interface scope. */
				sc_boolean get_signed() const;
				
				/*! Sets the value of the variable 'signed' that is defined in the default interface scope. */
				void set_signed(sc_boolean value);
				
				/*! Gets the value of the variable 'sizeof' that is defined in the default interface scope. */
				sc_boolean get_sizeof() const;
				
				/*! Sets the value of the variable 'sizeof' that is defined in the default interface scope. */
				void set_sizeof(sc_boolean value);
				
				/*! Gets the value of the variable 'static' that is defined in the default interface scope. */
				sc_boolean get_static() const;
				
				/*! Sets the value of the variable 'static' that is defined in the default interface scope. */
				void set_static(sc_boolean value);
				
				/*! Gets the value of the variable 'struct' that is defined in the default interface scope. */
				sc_boolean get_struct() const;
				
				/*! Sets the value of the variable 'struct' that is defined in the default interface scope. */
				void set_struct(sc_boolean value);
				
				/*! Gets the value of the variable 'switch' that is defined in the default interface scope. */
				sc_boolean get_switch() const;
				
				/*! Sets the value of the variable 'switch' that is defined in the default interface scope. */
				void set_switch(sc_boolean value);
				
				/*! Gets the value of the variable 'typedef' that is defined in the default interface scope. */
				sc_boolean get_typedef() const;
				
				/*! Sets the value of the variable 'typedef' that is defined in the default interface scope. */
				void set_typedef(sc_boolean value);
				
				/*! Gets the value of the variable 'union' that is defined in the default interface scope. */
				sc_boolean get_union() const;
				
				/*! Sets the value of the variable 'union' that is defined in the default interface scope. */
				void set_union(sc_boolean value);
				
				/*! Gets the value of the variable 'unsigned' that is defined in the default interface scope. */
				sc_boolean get_unsigned() const;
				
				/*! Sets the value of the variable 'unsigned' that is defined in the default interface scope. */
				void set_unsigned(sc_boolean value);
				
				/*! Gets the value of the variable 'void' that is defined in the default interface scope. */
				sc_boolean get_void() const;
				
				/*! Sets the value of the variable 'void' that is defined in the default interface scope. */
				void set_void(sc_boolean value);
				
				/*! Gets the value of the variable 'volatile' that is defined in the default interface scope. */
				sc_boolean get_volatile() const;
				
				/*! Sets the value of the variable 'volatile' that is defined in the default interface scope. */
				void set_volatile(sc_boolean value);
				
				/*! Gets the value of the variable 'while' that is defined in the default interface scope. */
				sc_boolean get_while() const;
				
				/*! Sets the value of the variable 'while' that is defined in the default interface scope. */
				void set_while(sc_boolean value);
				
				
			private:
				friend class CKeywords;
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
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'auto' that is defined in the default interface scope. */
		void raise_auto();
		
		/*! Raises the in event 'break' that is defined in the default interface scope. */
		void raise_break();
		
		/*! Gets the value of the variable 'case' that is defined in the default interface scope. */
		sc_boolean get_case() const;
		
		/*! Sets the value of the variable 'case' that is defined in the default interface scope. */
		void set_case(sc_boolean value);
		
		/*! Gets the value of the variable 'do' that is defined in the default interface scope. */
		sc_integer get_do() const;
		
		/*! Sets the value of the variable 'do' that is defined in the default interface scope. */
		void set_do(sc_integer value);
		
		/*! Gets the value of the variable 'continue' that is defined in the default interface scope. */
		sc_boolean get_continue() const;
		
		/*! Sets the value of the variable 'continue' that is defined in the default interface scope. */
		void set_continue(sc_boolean value);
		
		/*! Gets the value of the variable 'double' that is defined in the default interface scope. */
		sc_boolean get_double() const;
		
		/*! Sets the value of the variable 'double' that is defined in the default interface scope. */
		void set_double(sc_boolean value);
		
		/*! Gets the value of the variable 'enum' that is defined in the default interface scope. */
		sc_boolean get_enum() const;
		
		/*! Sets the value of the variable 'enum' that is defined in the default interface scope. */
		void set_enum(sc_boolean value);
		
		/*! Gets the value of the variable 'extern' that is defined in the default interface scope. */
		sc_boolean get_extern() const;
		
		/*! Sets the value of the variable 'extern' that is defined in the default interface scope. */
		void set_extern(sc_boolean value);
		
		/*! Gets the value of the variable 'float' that is defined in the default interface scope. */
		sc_boolean get_float() const;
		
		/*! Sets the value of the variable 'float' that is defined in the default interface scope. */
		void set_float(sc_boolean value);
		
		/*! Gets the value of the variable 'for' that is defined in the default interface scope. */
		sc_boolean get_for() const;
		
		/*! Sets the value of the variable 'for' that is defined in the default interface scope. */
		void set_for(sc_boolean value);
		
		/*! Gets the value of the variable 'goto' that is defined in the default interface scope. */
		sc_boolean get_goto() const;
		
		/*! Sets the value of the variable 'goto' that is defined in the default interface scope. */
		void set_goto(sc_boolean value);
		
		/*! Gets the value of the variable 'if' that is defined in the default interface scope. */
		sc_boolean get_if() const;
		
		/*! Sets the value of the variable 'if' that is defined in the default interface scope. */
		void set_if(sc_boolean value);
		
		/*! Gets the value of the variable 'int' that is defined in the default interface scope. */
		sc_boolean get_int() const;
		
		/*! Sets the value of the variable 'int' that is defined in the default interface scope. */
		void set_int(sc_boolean value);
		
		/*! Gets the value of the variable 'long' that is defined in the default interface scope. */
		sc_boolean get_long() const;
		
		/*! Sets the value of the variable 'long' that is defined in the default interface scope. */
		void set_long(sc_boolean value);
		
		/*! Gets the value of the variable 'register' that is defined in the default interface scope. */
		sc_boolean get_register() const;
		
		/*! Sets the value of the variable 'register' that is defined in the default interface scope. */
		void set_register(sc_boolean value);
		
		/*! Gets the value of the variable 'return' that is defined in the default interface scope. */
		sc_boolean get_return() const;
		
		/*! Sets the value of the variable 'return' that is defined in the default interface scope. */
		void set_return(sc_boolean value);
		
		/*! Gets the value of the variable 'short' that is defined in the default interface scope. */
		sc_boolean get_short() const;
		
		/*! Sets the value of the variable 'short' that is defined in the default interface scope. */
		void set_short(sc_boolean value);
		
		/*! Gets the value of the variable 'signed' that is defined in the default interface scope. */
		sc_boolean get_signed() const;
		
		/*! Sets the value of the variable 'signed' that is defined in the default interface scope. */
		void set_signed(sc_boolean value);
		
		/*! Gets the value of the variable 'sizeof' that is defined in the default interface scope. */
		sc_boolean get_sizeof() const;
		
		/*! Sets the value of the variable 'sizeof' that is defined in the default interface scope. */
		void set_sizeof(sc_boolean value);
		
		/*! Gets the value of the variable 'static' that is defined in the default interface scope. */
		sc_boolean get_static() const;
		
		/*! Sets the value of the variable 'static' that is defined in the default interface scope. */
		void set_static(sc_boolean value);
		
		/*! Gets the value of the variable 'struct' that is defined in the default interface scope. */
		sc_boolean get_struct() const;
		
		/*! Sets the value of the variable 'struct' that is defined in the default interface scope. */
		void set_struct(sc_boolean value);
		
		/*! Gets the value of the variable 'switch' that is defined in the default interface scope. */
		sc_boolean get_switch() const;
		
		/*! Sets the value of the variable 'switch' that is defined in the default interface scope. */
		void set_switch(sc_boolean value);
		
		/*! Gets the value of the variable 'typedef' that is defined in the default interface scope. */
		sc_boolean get_typedef() const;
		
		/*! Sets the value of the variable 'typedef' that is defined in the default interface scope. */
		void set_typedef(sc_boolean value);
		
		/*! Gets the value of the variable 'union' that is defined in the default interface scope. */
		sc_boolean get_union() const;
		
		/*! Sets the value of the variable 'union' that is defined in the default interface scope. */
		void set_union(sc_boolean value);
		
		/*! Gets the value of the variable 'unsigned' that is defined in the default interface scope. */
		sc_boolean get_unsigned() const;
		
		/*! Sets the value of the variable 'unsigned' that is defined in the default interface scope. */
		void set_unsigned(sc_boolean value);
		
		/*! Gets the value of the variable 'void' that is defined in the default interface scope. */
		sc_boolean get_void() const;
		
		/*! Sets the value of the variable 'void' that is defined in the default interface scope. */
		void set_void(sc_boolean value);
		
		/*! Gets the value of the variable 'volatile' that is defined in the default interface scope. */
		sc_boolean get_volatile() const;
		
		/*! Sets the value of the variable 'volatile' that is defined in the default interface scope. */
		void set_volatile(sc_boolean value);
		
		/*! Gets the value of the variable 'while' that is defined in the default interface scope. */
		sc_boolean get_while() const;
		
		/*! Sets the value of the variable 'while' that is defined in the default interface scope. */
		void set_while(sc_boolean value);
		
		
		/*
		 * Functions inherited from StatemachineInterface
		 */
		virtual void init();
		
		virtual void enter();
		
		virtual void exit();
		
		virtual void runCycle();
		
		/*!
		* Checks if the state machine is active (until 2.4.1 this method was used for states).
		* A state machine is active if it has been entered. It is inactive if it has not been entered at all or if it has been exited.
		*/
		virtual sc_boolean isActive() const;
		
		
		/*!
		* Checks if all active states are final. 
		* If there are no active states then the state machine is considered being inactive. In this case this method returns false.
		*/
		virtual sc_boolean isFinal() const;
		
		
		/*! Checks if the specified state is active (until 2.4.1 the used method for states was calles isActive()). */
		sc_boolean isStateActive(CKeywordsStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		//! dimension of the state configuration vector for history states
		static const sc_integer maxHistoryStates = 2;
		
		
		CKeywordsStates stateConfVector[maxOrthogonalStates];
		
		CKeywordsStates historyVector[maxHistoryStates];
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_auto_char_tr0_tr0();
		void effect_auto_char_tr0();
		void enact_auto_char();
		void enact_auto_loop_switch_case_enum_asm();
		void enseq_auto_char_default();
		void enseq_auto_loop_default();
		void enseq_auto_loop_switch_case_default();
		void enseq_auto_loop_switch_case_enum_asm_default();
		void enseq_auto_default();
		void enseq_auto_loop_switch_default();
		void shenseq_auto_loop_switch();
		void enseq_auto_loop_switch_case_enum_default();
		void dhenseq_auto_loop_switch_case_enum();
		void exseq_auto_char();
		void exseq_auto_loop_switch_case_enum_asm();
		void exseq_auto();
		void exseq_auto_loop_switch();
		void exseq_auto_loop_switch_case_enum();
		void react_auto_char();
		void react_auto_loop_switch_case_enum_asm();
		void react_auto__entry_Default();
		void react_auto_loop_switch__entry_Default();
		void react_auto_loop_switch_case_enum__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* CKEYWORDS_H_ */
