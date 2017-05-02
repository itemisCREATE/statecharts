
#ifndef ENTRYEXITSELFTRANSITION_H_
#define ENTRYEXITSELFTRANSITION_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'EntryExitSelfTransition'.
*/

class EntryExitSelfTransition : public StatemachineInterface
{
	
	public:
		
		EntryExitSelfTransition();
		
		~EntryExitSelfTransition();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_A,
			main_region_A__region0_B,
			main_region_A__region0_C,
			EntryExitSelfTransition_last_state
		} EntryExitSelfTransitionStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'exits' that is defined in the default interface scope. */
				sc_integer get_exits() const;
				
				/*! Sets the value of the variable 'exits' that is defined in the default interface scope. */
				void set_exits(sc_integer value);
				
				/*! Gets the value of the variable 'entries' that is defined in the default interface scope. */
				sc_integer get_entries() const;
				
				/*! Sets the value of the variable 'entries' that is defined in the default interface scope. */
				void set_entries(sc_integer value);
				
				/*! Raises the in event 'e' that is defined in the default interface scope. */
				void raise_e();
				
				/*! Raises the in event 'e1' that is defined in the default interface scope. */
				void raise_e1();
				
				
			private:
				friend class EntryExitSelfTransition;
				sc_integer exits;
				sc_integer entries;
				sc_boolean e_raised;
				sc_boolean e1_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'exits' that is defined in the default interface scope. */
		sc_integer get_exits() const;
		
		/*! Sets the value of the variable 'exits' that is defined in the default interface scope. */
		void set_exits(sc_integer value);
		
		/*! Gets the value of the variable 'entries' that is defined in the default interface scope. */
		sc_integer get_entries() const;
		
		/*! Sets the value of the variable 'entries' that is defined in the default interface scope. */
		void set_entries(sc_integer value);
		
		/*! Raises the in event 'e' that is defined in the default interface scope. */
		void raise_e();
		
		/*! Raises the in event 'e1' that is defined in the default interface scope. */
		void raise_e1();
		
		
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
		sc_boolean isStateActive(EntryExitSelfTransitionStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		EntryExitSelfTransitionStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_A_tr0_tr0();
		sc_boolean check_main_region_A__region0_B_tr0_tr0();
		sc_boolean check_main_region_A__region0_C_tr0_tr0();
		void effect_main_region_A_tr0();
		void effect_main_region_A__region0_B_tr0();
		void effect_main_region_A__region0_C_tr0();
		void enact_main_region_A();
		void exact_main_region_A();
		void enseq_main_region_A_default();
		void enseq_main_region_A__region0_B_default();
		void enseq_main_region_A__region0_C_default();
		void enseq_main_region_default();
		void enseq_main_region_A__region0_default();
		void exseq_main_region_A();
		void exseq_main_region_A__region0_B();
		void exseq_main_region_A__region0_C();
		void exseq_main_region();
		void exseq_main_region_A__region0();
		void react_main_region_A__region0_B();
		void react_main_region_A__region0_C();
		void react_main_region__entry_Default();
		void react_main_region_A__region0__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* ENTRYEXITSELFTRANSITION_H_ */
