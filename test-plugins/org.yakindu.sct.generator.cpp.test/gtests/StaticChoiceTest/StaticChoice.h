
#ifndef STATICCHOICE_H_
#define STATICCHOICE_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'StaticChoice'.
*/

class StaticChoice : public StatemachineInterface
{
	
	public:
		
		StaticChoice();
		
		~StaticChoice();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_Start,
			main_region_B,
			main_region_A,
			StaticChoice_last_state
		} StaticChoiceStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Gets the value of the variable 'number' that is defined in the default interface scope. */
				sc_integer get_number() const;
				
				/*! Sets the value of the variable 'number' that is defined in the default interface scope. */
				void set_number(sc_integer value);
				
				/*! Raises the in event 'reset' that is defined in the default interface scope. */
				void raise_reset();
				
				
			private:
				friend class StaticChoice;
				sc_integer number;
				sc_boolean reset_raised;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Gets the value of the variable 'number' that is defined in the default interface scope. */
		sc_integer get_number() const;
		
		/*! Sets the value of the variable 'number' that is defined in the default interface scope. */
		void set_number(sc_integer value);
		
		/*! Raises the in event 'reset' that is defined in the default interface scope. */
		void raise_reset();
		
		
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
		sc_boolean isStateActive(StaticChoiceStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		StaticChoiceStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_Start_tr0_tr0();
		sc_boolean check_main_region__choice_0_tr1_tr1();
		sc_boolean check_main_region__choice_0_tr0();
		void effect_main_region_Start_tr0();
		void effect_main_region__choice_0_tr1();
		void effect_main_region__choice_0_tr0();
		void enact_main_region_Start();
		void enseq_main_region_Start_default();
		void enseq_main_region_B_default();
		void enseq_main_region_A_default();
		void enseq_main_region_default();
		void exseq_main_region_Start();
		void exseq_main_region_B();
		void exseq_main_region_A();
		void exseq_main_region();
		void react_main_region_Start();
		void react_main_region_B();
		void react_main_region_A();
		void react_main_region__choice_0();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* STATICCHOICE_H_ */
