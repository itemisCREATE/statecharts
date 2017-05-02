
#ifndef STEXTKEYWORDSINSTATESANDREGIONS_H_
#define STEXTKEYWORDSINSTATESANDREGIONS_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'STextKeywordsInStatesAndRegions'.
*/

class STextKeywordsInStatesAndRegions : public StatemachineInterface
{
	
	public:
		
		STextKeywordsInStatesAndRegions();
		
		~STextKeywordsInStatesAndRegions();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			default_namespace,
			operation_interface,
			operation_internal,
			namespace_event,
			namespace_local,
			local_in,
			local_out,
			interface_var,
			interface_readonly,
			internal_external,
			internal_operation,
			event_default,
			event_else,
			in_entry,
			in_exit,
			out_always,
			out_oncycle,
			var_raise,
			var_valueof,
			readonly_active,
			readonly_namespace,
			external_interface,
			external_internal,
			else_event,
			else_local,
			entry_in,
			entry_out,
			exit_var,
			exit_readonly,
			always_external,
			always_operation,
			oncycle_default,
			oncycle_else,
			raise_entry,
			raise_exit,
			valueof_always,
			valueof_oncycle,
			active_raise,
			active_valueof,
			STextKeywordsInStatesAndRegions_last_state
		} STextKeywordsInStatesAndRegionsStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'e1' that is defined in the default interface scope. */
				void raise_e1();
				
				/*! Raises the in event 'e2' that is defined in the default interface scope. */
				void raise_e2();
				
				
			private:
				friend class STextKeywordsInStatesAndRegions;
				sc_boolean e1_raised;
				sc_boolean e2_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'e1' that is defined in the default interface scope. */
		void raise_e1();
		
		/*! Raises the in event 'e2' that is defined in the default interface scope. */
		void raise_e2();
		
		
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
		sc_boolean isStateActive(STextKeywordsInStatesAndRegionsStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 20;
		
		
		STextKeywordsInStatesAndRegionsStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_operation_interface_tr0_tr0();
		sc_boolean check_namespace_event_tr0_tr0();
		sc_boolean check_local_in_tr0_tr0();
		sc_boolean check_interface_var_tr0_tr0();
		sc_boolean check_internal_external_tr0_tr0();
		sc_boolean check_event_default_tr0_tr0();
		sc_boolean check_in_entry_tr0_tr0();
		sc_boolean check_out_always_tr0_tr0();
		sc_boolean check_var_raise_tr0_tr0();
		sc_boolean check_readonly_active_tr0_tr0();
		sc_boolean check_external_interface_tr0_tr0();
		sc_boolean check_else_event_tr0_tr0();
		sc_boolean check_entry_in_tr0_tr0();
		sc_boolean check_exit_var_tr0_tr0();
		sc_boolean check_always_external_tr0_tr0();
		sc_boolean check_oncycle_default_tr0_tr0();
		sc_boolean check_raise_entry_tr0_tr0();
		sc_boolean check_valueof_always_tr0_tr0();
		sc_boolean check_active_raise_tr0_tr0();
		void effect_operation_interface_tr0();
		void effect_namespace_event_tr0();
		void effect_local_in_tr0();
		void effect_interface_var_tr0();
		void effect_internal_external_tr0();
		void effect_event_default_tr0();
		void effect_in_entry_tr0();
		void effect_out_always_tr0();
		void effect_var_raise_tr0();
		void effect_readonly_active_tr0();
		void effect_external_interface_tr0();
		void effect_else_event_tr0();
		void effect_entry_in_tr0();
		void effect_exit_var_tr0();
		void effect_always_external_tr0();
		void effect_oncycle_default_tr0();
		void effect_raise_entry_tr0();
		void effect_valueof_always_tr0();
		void effect_active_raise_tr0();
		void enseq_default_namespace_default();
		void enseq_operation_interface_default();
		void enseq_operation_internal_default();
		void enseq_namespace_event_default();
		void enseq_namespace_local_default();
		void enseq_local_in_default();
		void enseq_local_out_default();
		void enseq_interface_var_default();
		void enseq_interface_readonly_default();
		void enseq_internal_external_default();
		void enseq_internal_operation_default();
		void enseq_event_default_default();
		void enseq_event_else_default();
		void enseq_in_entry_default();
		void enseq_in_exit_default();
		void enseq_out_always_default();
		void enseq_out_oncycle_default();
		void enseq_var_raise_default();
		void enseq_var_valueof_default();
		void enseq_readonly_active_default();
		void enseq_readonly_namespace_default();
		void enseq_external_interface_default();
		void enseq_external_internal_default();
		void enseq_else_event_default();
		void enseq_else_local_default();
		void enseq_entry_in_default();
		void enseq_entry_out_default();
		void enseq_exit_var_default();
		void enseq_exit_readonly_default();
		void enseq_always_external_default();
		void enseq_always_operation_default();
		void enseq_oncycle_default_default();
		void enseq_oncycle_else_default();
		void enseq_raise_entry_default();
		void enseq_raise_exit_default();
		void enseq_valueof_always_default();
		void enseq_valueof_oncycle_default();
		void enseq_active_raise_default();
		void enseq_active_valueof_default();
		void enseq_default_default();
		void enseq_operation_default();
		void enseq_namespace_default();
		void enseq_local_default();
		void enseq_interface_default();
		void enseq_internal_default();
		void enseq_event_default();
		void enseq_in_default();
		void enseq_out_default();
		void enseq_var_default();
		void enseq_readonly_default();
		void enseq_external_default();
		void enseq_else_default();
		void enseq_entry_default();
		void enseq_exit_default();
		void enseq_always_default();
		void enseq_oncycle_default();
		void enseq_raise_default();
		void enseq_valueof_default();
		void enseq_active_default();
		void exseq_default_namespace();
		void exseq_operation_interface();
		void exseq_operation_internal();
		void exseq_namespace_event();
		void exseq_namespace_local();
		void exseq_local_in();
		void exseq_local_out();
		void exseq_interface_var();
		void exseq_interface_readonly();
		void exseq_internal_external();
		void exseq_internal_operation();
		void exseq_event_default();
		void exseq_event_else();
		void exseq_in_entry();
		void exseq_in_exit();
		void exseq_out_always();
		void exseq_out_oncycle();
		void exseq_var_raise();
		void exseq_var_valueof();
		void exseq_readonly_active();
		void exseq_readonly_namespace();
		void exseq_external_interface();
		void exseq_external_internal();
		void exseq_else_event();
		void exseq_else_local();
		void exseq_entry_in();
		void exseq_entry_out();
		void exseq_exit_var();
		void exseq_exit_readonly();
		void exseq_always_external();
		void exseq_always_operation();
		void exseq_oncycle_default();
		void exseq_oncycle_else();
		void exseq_raise_entry();
		void exseq_raise_exit();
		void exseq_valueof_always();
		void exseq_valueof_oncycle();
		void exseq_active_raise();
		void exseq_active_valueof();
		void exseq_default();
		void exseq_operation();
		void exseq_namespace();
		void exseq_local();
		void exseq_interface();
		void exseq_internal();
		void exseq_event();
		void exseq_in();
		void exseq_out();
		void exseq_var();
		void exseq_readonly();
		void exseq_external();
		void exseq_else();
		void exseq_entry();
		void exseq_exit();
		void exseq_always();
		void exseq_oncycle();
		void exseq_raise();
		void exseq_valueof();
		void exseq_active();
		void react_default_namespace();
		void react_operation_interface();
		void react_operation_internal();
		void react_namespace_event();
		void react_namespace_local();
		void react_local_in();
		void react_local_out();
		void react_interface_var();
		void react_interface_readonly();
		void react_internal_external();
		void react_internal_operation();
		void react_event_default();
		void react_event_else();
		void react_in_entry();
		void react_in_exit();
		void react_out_always();
		void react_out_oncycle();
		void react_var_raise();
		void react_var_valueof();
		void react_readonly_active();
		void react_readonly_namespace();
		void react_external_interface();
		void react_external_internal();
		void react_else_event();
		void react_else_local();
		void react_entry_in();
		void react_entry_out();
		void react_exit_var();
		void react_exit_readonly();
		void react_always_external();
		void react_always_operation();
		void react_oncycle_default();
		void react_oncycle_else();
		void react_raise_entry();
		void react_raise_exit();
		void react_valueof_always();
		void react_valueof_oncycle();
		void react_active_raise();
		void react_active_valueof();
		void react_default__entry_Default();
		void react_operation__entry_Default();
		void react_namespace__entry_Default();
		void react_local__entry_Default();
		void react_interface__entry_Default();
		void react_internal__entry_Default();
		void react_event__entry_Default();
		void react_in__entry_Default();
		void react_out__entry_Default();
		void react_var__entry_Default();
		void react_readonly__entry_Default();
		void react_external__entry_Default();
		void react_else__entry_Default();
		void react_entry__entry_Default();
		void react_exit__entry_Default();
		void react_always__entry_Default();
		void react_oncycle__entry_Default();
		void react_raise__entry_Default();
		void react_valueof__entry_Default();
		void react_active__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* STEXTKEYWORDSINSTATESANDREGIONS_H_ */
