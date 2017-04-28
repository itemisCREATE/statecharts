
#ifndef CHOICE_H_
#define CHOICE_H_

#include "sc_types.h"
#include "StatemachineInterface.h"

/*! \file Header of the state machine 'Choice'.
*/

class Choice : public StatemachineInterface
{
	
	public:
		
		Choice();
		
		~Choice();
		
		/*! Enumeration of all states */ 
		typedef enum
		{
			main_region_A,
			main_region_B,
			main_region_C,
			Choice_last_state
		} ChoiceStates;
		
		//! Inner class for default interface scope.
		class DefaultSCI
		{
			
			public:
				/*! Raises the in event 'e' that is defined in the default interface scope. */
				void raise_e();
				
				/*! Raises the in event 'f' that is defined in the default interface scope. */
				void raise_f();
				
				/*! Raises the in event 'g' that is defined in the default interface scope. */
				void raise_g();
				
				/*! Raises the in event 'h' that is defined in the default interface scope. */
				void raise_h();
				
				/*! Gets the value of the variable 'c' that is defined in the default interface scope. */
				sc_boolean get_c() const;
				
				/*! Sets the value of the variable 'c' that is defined in the default interface scope. */
				void set_c(sc_boolean value);
				
				
			private:
				friend class Choice;
				sc_boolean e_raised;
				sc_boolean f_raised;
				sc_boolean g_raised;
				sc_boolean h_raised;
				sc_boolean c;
		};
				
		
		/*! Returns an instance of the interface class 'DefaultSCI'. */
		DefaultSCI* getDefaultSCI();
		
		/*! Raises the in event 'e' that is defined in the default interface scope. */
		void raise_e();
		
		/*! Raises the in event 'f' that is defined in the default interface scope. */
		void raise_f();
		
		/*! Raises the in event 'g' that is defined in the default interface scope. */
		void raise_g();
		
		/*! Raises the in event 'h' that is defined in the default interface scope. */
		void raise_h();
		
		/*! Gets the value of the variable 'c' that is defined in the default interface scope. */
		sc_boolean get_c() const;
		
		/*! Sets the value of the variable 'c' that is defined in the default interface scope. */
		void set_c(sc_boolean value);
		
		
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
		sc_boolean isStateActive(ChoiceStates state) const;
	
	private:
	
	
		//! the maximum number of orthogonal states defines the dimension of the state configuration vector.
		static const sc_integer maxOrthogonalStates = 1;
		
		
		ChoiceStates stateConfVector[maxOrthogonalStates];
		
		sc_ushort stateConfVectorPosition;
		
		DefaultSCI iface;
		
		// prototypes of all internal functions
		
		sc_boolean check_main_region_A_tr0_tr0();
		sc_boolean check_main_region_A_tr1_tr1();
		sc_boolean check_main_region_A_tr2_tr2();
		sc_boolean check_main_region_A_tr3_tr3();
		sc_boolean check_main_region_B_tr0_tr0();
		sc_boolean check_main_region_C_tr0_tr0();
		sc_boolean check_main_region__choice_0_tr1_tr1();
		sc_boolean check_main_region__choice_0_tr0_tr0();
		sc_boolean check_main_region__choice_1_tr0_tr0();
		sc_boolean check_main_region__choice_1_tr1_tr1();
		sc_boolean check_main_region__choice_2_tr1_tr1();
		sc_boolean check_main_region__choice_2_tr0();
		sc_boolean check_main_region__choice_3_tr1_tr1();
		sc_boolean check_main_region__choice_3_tr0_tr0();
		void effect_main_region_A_tr0();
		void effect_main_region_A_tr1();
		void effect_main_region_A_tr2();
		void effect_main_region_A_tr3();
		void effect_main_region_B_tr0();
		void effect_main_region_C_tr0();
		void effect_main_region__choice_0_tr1();
		void effect_main_region__choice_0_tr0();
		void effect_main_region__choice_1_tr0();
		void effect_main_region__choice_1_tr1();
		void effect_main_region__choice_2_tr1();
		void effect_main_region__choice_2_tr0();
		void effect_main_region__choice_3_tr1();
		void effect_main_region__choice_3_tr0();
		void enseq_main_region_A_default();
		void enseq_main_region_B_default();
		void enseq_main_region_C_default();
		void enseq_main_region_default();
		void exseq_main_region_A();
		void exseq_main_region_B();
		void exseq_main_region_C();
		void exseq_main_region();
		void react_main_region_A();
		void react_main_region_B();
		void react_main_region_C();
		void react_main_region__choice_0();
		void react_main_region__choice_1();
		void react_main_region__choice_2();
		void react_main_region__choice_3();
		void react_main_region__entry_Default();
		void clearInEvents();
		void clearOutEvents();
		
};
#endif /* CHOICE_H_ */
